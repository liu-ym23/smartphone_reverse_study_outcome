package org.threeten.bp;

import com.obric.oui.calendar.ODatePickerView;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class DateTimeUtils {
    private DateTimeUtils() {
    }

    public static Instant toInstant(Date r2) {
        return Instant.ofEpochMilli(r2.getTime());
    }

    public static Date toDate(Instant r3) {
        return new Date(r3.toEpochMilli());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static Instant toInstant(Calendar r2) {
        return Instant.ofEpochMilli(r2.getTimeInMillis());
    }

    public static ZonedDateTime toZonedDateTime(Calendar r2) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(r2.getTimeInMillis()), toZoneId(r2.getTimeZone()));
    }

    public static GregorianCalendar toGregorianCalendar(ZonedDateTime r4) {
        GregorianCalendar r1 = new GregorianCalendar(toTimeZone(r4.getZone()));
        r1.setGregorianChange(new Date(Long.MIN_VALUE));
        r1.setFirstDayOfWeek(2);
        r1.setMinimalDaysInFirstWeek(4);
        r1.setTimeInMillis(r4.toInstant().toEpochMilli());     // Catch: ArithmeticException -> L5
        return r1;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static ZoneId toZoneId(TimeZone r1) {
        return ZoneId.of(r1.getID(), ZoneId.SHORT_IDS);
    }

    public static TimeZone toTimeZone(ZoneId r2) {
        String r3 = r2.getId();
        if (r3.startsWith("+") == false) goto L5;
    L10:
        r3 = "GMT" + r3;
    L12:
        return TimeZone.getTimeZone(r3);
    L5:
        if (r3.startsWith("-") == true) goto L10;
        if (r3.equals("Z") == false) goto L12;
        r3 = "UTC";
        goto L12
    }

    public static LocalDate toLocalDate(java.sql.Date r2) {
        return LocalDate.of(r2.getYear() + ODatePickerView.YEAR_FROM, r2.getMonth() + 1, r2.getDate());
    }

    public static java.sql.Date toSqlDate(LocalDate r3) {
        return new java.sql.Date(r3.getYear() - 1900, r3.getMonthValue() - 1, r3.getDayOfMonth());
    }

    public static LocalTime toLocalTime(Time r2) {
        return LocalTime.of(r2.getHours(), r2.getMinutes(), r2.getSeconds());
    }

    public static Time toSqlTime(LocalTime r3) {
        return new Time(r3.getHour(), r3.getMinute(), r3.getSecond());
    }

    public static Timestamp toSqlTimestamp(LocalDateTime r9) {
        return new Timestamp(r9.getYear() - 1900, r9.getMonthValue() - 1, r9.getDayOfMonth(), r9.getHour(), r9.getMinute(), r9.getSecond(), r9.getNano());
    }

    public static LocalDateTime toLocalDateTime(Timestamp r8) {
        return LocalDateTime.of(r8.getYear() + ODatePickerView.YEAR_FROM, r8.getMonth() + 1, r8.getDate(), r8.getHours(), r8.getMinutes(), r8.getSeconds(), r8.getNanos());
    }

    public static Timestamp toSqlTimestamp(Instant r5) {
        Timestamp r0 = new Timestamp(r5.getEpochSecond() * 1000);     // Catch: ArithmeticException -> L4
        r0.setNanos(r5.getNano());     // Catch: ArithmeticException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static Instant toInstant(Timestamp r4) {
        return Instant.ofEpochSecond(r4.getTime() / 1000, r4.getNanos());
    }
}
