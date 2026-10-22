package com.google.android.material.datepicker;

import android.content.Context;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
class DateStrings {
    private DateStrings() {
    }

    public static c getDateRangeString(@Nullable Long r10, @Nullable Long r11) {
        return getDateRangeString(r10, r11, null);
    }

    public static String getDateString(long r10) {
        return getDateString(r10, null);
    }

    public static String getMonthDay(long r10) {
        return getMonthDay(r10, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long r10) {
        return getMonthDayOfWeekDay(r10, Locale.getDefault());
    }

    public static String getYearMonth(Context r10, long r11) {
        return DateUtils.formatDateTime(r10, r11 - ((long) TimeZone.getDefault().getOffset(r11)), 36);
    }

    public static String getYearMonthDay(long r10) {
        return getYearMonthDay(r10, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long r10) {
        return getYearMonthDayOfWeekDay(r10, Locale.getDefault());
    }

    public static c getDateRangeString(@Nullable Long r10, @Nullable Long r11, @Nullable SimpleDateFormat r12) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L7;
        return c.a(null, null);
    L7:
        if (r10 == null) goto L9;
        if (r11 == null) goto L12;
        Calendar r13 = UtcDates.getTodayCalendar();
        Calendar r14 = UtcDates.getUtcCalendar();
        r14.setTimeInMillis(r10.longValue());
        Calendar r15 = UtcDates.getUtcCalendar();
        r15.setTimeInMillis(r11.longValue());
        if (r12 == null) goto L18;
        Date r16 = new Date(r10.longValue());
        Date r17 = new Date(r11.longValue());
        return c.a(r12.format(r16), r12.format(r17));
    L18:
        if (r14.get(1) != r15.get(1)) goto L26;
        if (r14.get(1) != r13.get(1)) goto L24;
        return c.a(getMonthDay(r10.longValue(), Locale.getDefault()), getMonthDay(r11.longValue(), Locale.getDefault()));
    L24:
        return c.a(getMonthDay(r10.longValue(), Locale.getDefault()), getYearMonthDay(r11.longValue(), Locale.getDefault()));
    L26:
        return c.a(getYearMonthDay(r10.longValue(), Locale.getDefault()), getYearMonthDay(r11.longValue(), Locale.getDefault()));
    L12:
        return c.a(getDateString(r10.longValue(), r12), null);
    L9:
        return c.a(null, getDateString(r11.longValue(), r12));
    }

    public static String getDateString(long r10, @Nullable SimpleDateFormat r11) {
        Calendar r12 = UtcDates.getTodayCalendar();
        Calendar r13 = UtcDates.getUtcCalendar();
        r13.setTimeInMillis(r10);
        if (r11 == null) goto L7;
        return r11.format(new Date(r10));
    L7:
        if (r12.get(1) != r13.get(1)) goto L11;
        return getMonthDay(r10);
    L11:
        return getYearMonthDay(r10);
    }

    public static String getMonthDay(long r10, Locale r11) {
        return UtcDates.getAbbrMonthDayFormat(r11).format(new Date(r10));
    }

    public static String getMonthDayOfWeekDay(long r10, Locale r11) {
        return UtcDates.getAbbrMonthWeekdayDayFormat(r11).format(new Date(r10));
    }

    public static String getYearMonthDay(long r10, Locale r11) {
        return UtcDates.getYearAbbrMonthDayFormat(r11).format(new Date(r10));
    }

    public static String getYearMonthDayOfWeekDay(long r10, Locale r11) {
        return UtcDates.getYearAbbrMonthWeekdayDayFormat(r11).format(new Date(r10));
    }
}
