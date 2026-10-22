package com.android.contacts.common.util;

import android.content.Context;
import android.text.format.Time;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateUtils {
    private static final SimpleDateFormat[] DATE_FORMATS = null;
    public static final String NO_YEAR_DATE_FEB29TH = "--02-29";
    public static final TimeZone UTC_TIMEZONE = null;

    public DateUtils() {
    }

    static {
        UTC_TIMEZONE = TimeZone.getTimeZone("UTC");
        int r2 = 0;
        SimpleDateFormat[] r0 = {CommonDateUtils.FULL_DATE_FORMAT, CommonDateUtils.DATE_AND_TIME_FORMAT, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmmssSSS'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmm'Z'", Locale.US)};
        DATE_FORMATS = r0;
        int r1 = r0.length;
    L3:
        if (r2 >= r1) goto L5;
        SimpleDateFormat r4 = r0[r2];
        r4.setLenient(true);
        r4.setTimeZone(UTC_TIMEZONE);
        r2 = r2 + 1;
        goto L3
    L5:
        new SimpleDateFormat("--MM-dd", Locale.US).setTimeZone(UTC_TIMEZONE);
    }

    public static Calendar parseDate(String r6, boolean r7) {
        ParsePosition r0 = new ParsePosition(0);
        if (r7 == false) goto L5;
    L22:
        int r8 = 0;
    L23:
        SimpleDateFormat[] r2 = DATE_FORMATS;
        if (r8 >= r2.length) goto L37;
        SimpleDateFormat r3 = r2[r8];
        monitor-enter(r3);
        r0.setIndex(0);     // Catch: Throwable -> L34
        Date r4 = r3.parse(r6, r0);     // Catch: Throwable -> L34
        if (r0.getIndex() == r6.length()) goto L29;
        monitor-exit(r3);     // Catch: Throwable -> L34
        r8 = r8 + 1;     // Catch: Throwable -> L34
        goto L23
    L29:
        Calendar r9 = getUtcDate(r4, false);     // Catch: Throwable -> L34
        monitor-exit(r3);     // Catch: Throwable -> L34
        return r9;
    L34:
        th = move-exception;
        throw th;
    L37:
        return null;
    L5:
        if (NO_YEAR_DATE_FEB29TH.equals(r6) == true) goto L7;
        SimpleDateFormat r10 = CommonDateUtils.NO_YEAR_DATE_FORMAT;
        monitor-enter(r10);
        Date r5 = CommonDateUtils.NO_YEAR_DATE_FORMAT.parse(r6, r0);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        if (r0.getIndex() != r6.length()) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L22;
        return getUtcDate(r5, true);
    L15:
        r11 = false;
    L19:
        th = move-exception;
        throw th;
    L7:
        return getUtcDate(0, 1, 29);
    }

    private static final Calendar getUtcDate(Date r2, boolean r3) {
        Calendar r0 = Calendar.getInstance(UTC_TIMEZONE, Locale.US);
        r0.setTime(r2);
        if (r3 == false) goto L5;
        r0.set(1, 0);
    L5:
        return r0;
    }

    private static final Calendar getUtcDate(int r2, int r3, int r4) {
        Calendar r0 = Calendar.getInstance(UTC_TIMEZONE, Locale.US);
        r0.clear();
        r0.set(1, r2);
        r0.set(2, r3);
        r0.set(5, r4);
        return r0;
    }

    public static boolean isYearSet(Calendar r1) {
        if (r1.get(1) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String formatDate(Context r1, String r2) {
        return formatDate(r1, r2, true);
    }

    public static String formatDate(Context r1, String r2, boolean r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r4 = r2.trim();
        if (r4.length() != 0) goto L8;
        return r4;
    L8:
        Calendar r0 = parseDate(r4, false);
        if (r0 != null) goto L12;
        return r4;
    L12:
        if (isYearSet(r0) == true) goto L14;
        DateFormat r5 = getLocalizedDateFormatWithoutYear(r1);
    L17:
        monitor-enter(r5);
        r5.setTimeZone(UTC_TIMEZONE);     // Catch: Throwable -> L21
        String r6 = r5.format(r0.getTime());     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L21
        return r6;
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r3 == false) goto L16;
        r5 = android.text.format.DateFormat.getLongDateFormat(r1);
        goto L17
    L16:
        r5 = android.text.format.DateFormat.getDateFormat(r1);
        goto L17
    }

    public static boolean isMonthBeforeDay(Context r4) {
        char[] r5 = android.text.format.DateFormat.getDateFormatOrder(r4);
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L13;
        char r2 = r5[r1];
        if (r2 == 'd') goto L7;
        if (r2 == 'M') goto L10;
        r1 = r1 + 1;
        goto L4
    L10:
        return true;
    L7:
        return false;
    L13:
        return false;
    }

    public static DateFormat getLocalizedDateFormatWithoutYear(Context r4) {
        String r0 = ((SimpleDateFormat) SimpleDateFormat.getDateInstance(1)).toPattern();
        if (r0.contains("de") == false) goto L5;
        String r1 = "[^Mm]*[Yy]+[^Mm]*";
    L14:
        return new SimpleDateFormat(r0.replaceAll(r1, ""));
    L9:
        if (isMonthBeforeDay(r4) == false) goto L11;
        String r5 = "MMMM dd";
    L13:
        return new SimpleDateFormat(r5);
    L11:
        r5 = "dd MMMM";
        goto L13
    L5:
        r1 = "[^DdMm]*[Yy]+[^DdMm]*";
        goto L14
    }

    public static Date getNextAnnualDate(Calendar r7) {
        Calendar r0 = Calendar.getInstance();
        r0.setTime(new Date());
        boolean r2 = false;
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        boolean r1 = isYearSet(r7);
        int r4 = r7.get(1);
        int r5 = r7.get(2);
        int r8 = r7.get(5);
        if (r5 == 1) goto L5;
    L7:
        GregorianCalendar r6 = new GregorianCalendar();
        if (r1 == true) goto L10;
        r4 = r0.get(1);
    L10:
        r6.set(r4, r5, r8);
        if (r1 == true) goto L23;
        int r3 = r0.get(1);
        if (r6.before(r0) == true) goto L17;
        if (r2 == false) goto L23;
        if (r6.isLeapYear(r3) == true) goto L23;
    L17:
        r3 = r3 + 1;
        if (r2 == false) goto L21;
        if (r6.isLeapYear(r3) == false) goto L17;
    L21:
        r6.set(r3, r5, r8);
    L23:
        return r6.getTime();
    L5:
        if (r8 != 29) goto L7;
        r2 = true;
        goto L7
    }

    public static int getDayDifference(Time r2, long r3, long r5) {
        r2.set(r3);
        int r4 = Time.getJulianDay(r3, r2.gmtoff);
        r2.set(r5);
        return Math.abs(Time.getJulianDay(r5, r2.gmtoff) - r4);
    }
}
