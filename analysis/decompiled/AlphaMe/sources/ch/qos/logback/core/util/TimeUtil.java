package ch.qos.logback.core.util;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class TimeUtil {
    public static long computeStartOfNextDay(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.add(5, 1);
        calendar.set(14, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        return calendar.getTime().getTime();
    }

    public static long computeStartOfNextHour(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(14, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.add(10, 1);
        return calendar.getTime().getTime();
    }

    public static long computeStartOfNextMinute(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(14, 0);
        calendar.set(13, 0);
        calendar.add(12, 1);
        return calendar.getTime().getTime();
    }

    public static long computeStartOfNextMonth(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(2, 1);
        return calendar.getTime().getTime();
    }

    public static long computeStartOfNextSecond(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(14, 0);
        calendar.add(13, 1);
        return calendar.getTime().getTime();
    }

    public static long computeStartOfNextWeek(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(7, calendar.getFirstDayOfWeek());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(3, 1);
        return calendar.getTime().getTime();
    }
}
