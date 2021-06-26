package com.wen;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * <p>
 * Java 8 日期处理
 * </p>
 *
 * @author wenjun
 * @since 2021-06-26
 */
public class DateDemo {

    public static void main(String[] args) {
        DateDemo dateDemo = new DateDemo();
        dateDemo.demo1();
        dateDemo.demo2();
        dateDemo.demo3();
        dateDemo.demo4();
        dateDemo.demo5();
        dateDemo.demo6();
        dateDemo.demo7();
        dateDemo.demo8();
        dateDemo.demo9();
        dateDemo.demo10();
        dateDemo.demo11();
        dateDemo.demo12();
        dateDemo.demo13();
        dateDemo.demo14();
        dateDemo.demo15();
        dateDemo.demo16();
        dateDemo.demo17();
        dateDemo.demo18();
    }

    /**
     * 获取当前日期
     */
    public void demo1() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

    /**
     * 获取年、月、日
     */
    public void demo2() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        // %n 换行
        System.out.printf("%d %d %d %n", year, month, day);
    }

    /**
     * 指定日期
     */
    public void demo3() {
        LocalDate localDate = LocalDate.of(2021, 6, 26);
        System.out.println(localDate);
    }

    /**
     * 日期是否相等
     */
    public void demo4() {
        LocalDate today = LocalDate.now();
        LocalDate localDate = LocalDate.of(2021, 6, 26);
        System.out.println(Objects.equals(today, localDate));
    }

    /**
     * 是否生日
     */
    public void demo5() {
        LocalDate today = LocalDate.now();
        LocalDate localDate = LocalDate.of(2021, 6, 26);
        MonthDay birthday = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay monthDay = MonthDay.from(today);
        System.out.println(Objects.equals(birthday, monthDay));
    }

    /**
     * 获取当前时间
     */
    public void demo6() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    /**
     * 新增小时
     */
    public void demo7() {
        LocalTime localTime = LocalTime.now();
        LocalTime newLocalTime = localTime.plusHours(2);
        System.out.println(newLocalTime);
    }

    /**
     * 一周前或一周后日期
     */
    public void demo8() {
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minus(1, ChronoUnit.WEEKS);
        System.out.println(lastWeek);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek);
    }

    /**
     * 使用 Clock 时钟类
     */
    public void demo9() {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println(defaultClock.millis());
    }

    /**
     * 日期早晚
     */
    public void demo10() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2021, 6, 27);
        System.out.println(today.isBefore(tomorrow));
        System.out.println(today.isAfter(tomorrow));
    }

    /**
     * 特定时区时间
     */
    public void demo11() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 时区
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    }

    /**
     * 年月处理
     */
    public void demo12() {
        YearMonth currentYearMonth = YearMonth.now();
        // %d 表示数字，%s 表示字符串
        System.out.printf("当前年月：%s，本月天数：%d %n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth yearMonth = YearMonth.of(2021, Month.JUNE);
        System.out.printf("自定义年月：%s %n", yearMonth);
    }

    /**
     * 是否闰年
     */
    public void demo13() {
        LocalDate today = LocalDate.now();
        System.out.println(today.isLeapYear());
    }

    /**
     * 日期之差
     */
    public void demo14() {
        LocalDate today = LocalDate.now();
        LocalDate localDate = LocalDate.of(2021, Month.MAY, 14);
        Period period = Period.between(today, localDate);
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    /**
     * 包含时差信息的日期时间
     */
    public void demo15() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, Month.JUNE, 26, 17, 18);
        ZoneOffset zoneOffset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);
    }

    /**
     * 当前时间戳
     */
    public void demo16() {
        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
    }

    /**
     * 格式化
     */
    public void demo17() {
        String s = "20210626";
        LocalDate localDate = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);
    }

    /**
     * 格式化
     */
    public void demo18() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String s = localDateTime.format(dateTimeFormatter);
        System.out.println(s);
        LocalDate localDate = LocalDate.parse(s, dateTimeFormatter);
        System.out.println(localDate);
    }
}
