package com.android.contacts.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.contacts.R;
import com.ttnet.org.chromium.base.TimeUtils;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class DateUtils {
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT = null;
    private static final SimpleDateFormat[] DATE_FORMATS = null;
    private static final String FEB_29_DATE = "02-29";
    private static final DateFormat FORMAT_WITHOUT_YEAR_DATE_FIRST = null;
    private static final DateFormat FORMAT_WITHOUT_YEAR_MONTH_FIRST = null;
    public static final SimpleDateFormat FULL_DATE_FORMAT = null;
    public static final long MILLIS_OF_DAY = 86400000;
    public static final SimpleDateFormat NO_YEAR_DATE_AND_TIME_FORMAT = null;
    public static final SimpleDateFormat NO_YEAR_DATE_FORMAT = null;
    public static final TimeZone UTC_TIMEZONE = null;

    public DateUtils() {
    }

    static {
        UTC_TIMEZONE = TimeZone.getTimeZone("UTC");
        NO_YEAR_DATE_FORMAT = new SimpleDateFormat("MM-dd", Locale.US);
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        FULL_DATE_FORMAT = r0;
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        DATE_AND_TIME_FORMAT = r1;
        NO_YEAR_DATE_AND_TIME_FORMAT = new SimpleDateFormat("--MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        int r4 = 0;
        SimpleDateFormat[] r3 = {r0, r1, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmmssSSS'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US), new SimpleDateFormat("yyyyMMdd'T'HHmm'Z'", Locale.US)};
        DATE_FORMATS = r3;
        FORMAT_WITHOUT_YEAR_MONTH_FIRST = new SimpleDateFormat("MM-dd");
        FORMAT_WITHOUT_YEAR_DATE_FIRST = new SimpleDateFormat("dd-MM");
        int r2 = r3.length;
    L3:
        if (r4 >= r2) goto L5;
        SimpleDateFormat r5 = r3[r4];
        r5.setLenient(true);
        r5.setTimeZone(UTC_TIMEZONE);
        r4 = r4 + 1;
        goto L3
    L5:
        SimpleDateFormat r6 = NO_YEAR_DATE_FORMAT;
        TimeZone r7 = UTC_TIMEZONE;
        r6.setTimeZone(r7);
        FORMAT_WITHOUT_YEAR_MONTH_FIRST.setTimeZone(r7);
        FORMAT_WITHOUT_YEAR_DATE_FIRST.setTimeZone(r7);
    }

    public static Date parseDate(String r7) {
        ParsePosition r0 = new ParsePosition(0);
        int r2 = 0;
    L3:
        SimpleDateFormat[] r3 = DATE_FORMATS;
        if (r2 >= r3.length) goto L16;
        SimpleDateFormat r4 = r3[r2];
        monitor-enter(r4);
        r0.setIndex(0);     // Catch: Throwable -> L13
        Date r5 = r4.parse(r7, r0);     // Catch: Throwable -> L13
        if (r0.getIndex() == r7.length()) goto L9;
        monitor-exit(r4);     // Catch: Throwable -> L13
        r2 = r2 + 1;     // Catch: Throwable -> L13
        goto L3
    L9:
        monitor-exit(r4);     // Catch: Throwable -> L13
        return r5;
    L13:
        th = move-exception;
        throw th;
    L16:
        return null;
    }

    public static String formatDate(Context r7, String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r9 = r8.trim();
        if (r9.length() != 0) goto L9;
        return r9;
    L9:
        if (TextUtils.equals(FEB_29_DATE, r9) == false) goto L12;
        return FEB_29_DATE;
    L12:
        ParsePosition r0 = new ParsePosition(0);
        SimpleDateFormat r2 = NO_YEAR_DATE_FORMAT;
        monitor-enter(r2);
        Date r3 = r2.parse(r9, r0);     // Catch: Throwable -> L46
        monitor-exit(r2);     // Catch: Throwable -> L46
        if (r0.getIndex() == r9.length()) goto L19;
        int r4 = 0;
    L31:
        SimpleDateFormat[] r5 = DATE_FORMATS;
        if (r4 >= r5.length) goto L45;
        SimpleDateFormat r6 = r5[r4];
        monitor-enter(r6);
        r0.setIndex(0);     // Catch: Throwable -> L42
        Date r10 = r6.parse(r9, r0);     // Catch: Throwable -> L42
        if (r0.getIndex() == r9.length()) goto L37;
        monitor-exit(r6);     // Catch: Throwable -> L42
        r4 = r4 + 1;     // Catch: Throwable -> L42
        goto L31
    L37:
        DateFormat r11 = getDateFormat(r7);     // Catch: Throwable -> L42
        r11.setTimeZone(UTC_TIMEZONE);     // Catch: Throwable -> L42
        String r12 = r11.format(r10);     // Catch: Throwable -> L42
        monitor-exit(r6);     // Catch: Throwable -> L42
        return r12;
    L42:
        th = move-exception;
        throw th;
    L45:
        return r9;
    L19:
        if (isMonthBeforeDate(r7) == false) goto L21;
        DateFormat r13 = FORMAT_WITHOUT_YEAR_MONTH_FIRST;
    L22:
        DateFormat r14 = r13;
        monitor-enter(r14);
        String r15 = r14.format(r3);     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
        return r15;
    L27:
        th = move-exception;
        throw th;
    L21:
        r13 = FORMAT_WITHOUT_YEAR_DATE_FIRST;
    L46:
        th = move-exception;
        throw th;
    }

    public static DateFormat getDateFormat(Context r6) {
        if (Constants.ANDROID60 == false) goto L8;
        Class<?> r0 = Class.forName("android.text.format.DateFormat");     // Catch: Exception -> L6
        return (DateFormat) r0.getDeclaredMethod("getDateFormatEx", new Class[]{Context.class}).invoke(r0, new Object[]{r6});
    L11:
        return android.text.format.DateFormat.getDateFormat(r6);
    L8:
        return android.text.format.DateFormat.getDateFormat(r6);
    }

    private static boolean isMonthBeforeDate(Context r4) {
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

    public static String formatDuration(long r12, Context r14) {
        if (r12 < TimeUtils.SECONDS_PER_DAY) goto L5;
        long r5 = (r12 / TimeUtils.SECONDS_PER_HOUR) / 24;
        r12 = r12 - (r5 * TimeUtils.SECONDS_PER_HOUR);
    L7:
        if (r12 < TimeUtils.SECONDS_PER_HOUR) goto L9;
        long r7 = r12 / TimeUtils.SECONDS_PER_HOUR;
        r12 = r12 - (TimeUtils.SECONDS_PER_HOUR * r7);
    L11:
        if (r12 < 60) goto L13;
        long r9 = r12 / 60;
        r12 = r12 - (60 * r9);
    L14:
        String r1 = "";
        if (r5 <= 0) goto L17;
        String r0 = r14.getString(R.string.common_value_days, new Object[]{Long.valueOf(r5)});
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
    L23:
        String r8 = r14.getString(R.string.common_value_hours, new Object[]{Long.valueOf(r7)});
        r6 = true;
    L24:
        if (r6 == false) goto L26;
    L27:
        r1 = r14.getString(R.string.common_value_minutes, new Object[]{Long.valueOf(r9)});
    L29:
        return r0 + r8 + r1 + r14.getString(R.string.common_value_seconds, new Object[]{Long.valueOf(r12)});
    L26:
        if (r9 <= 0) goto L29;
    L20:
        if (r7 > 0) goto L23;
        r8 = "";
        goto L24
    L17:
        r0 = "";
        r6 = false;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L11
    L5:
        r5 = 0;
        goto L7
    }

    public static boolean isSameDay(Calendar r2, Calendar r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        if (r2.get(5) != r3.get(5)) goto L11;
        if (r2.get(2) != r3.get(2)) goto L11;
        if (r2.get(1) != r3.get(1)) goto L11;
        return true;
    L11:
        return false;
    }

    public static final long getYesterdayInMillis() {
        long r0 = Calendar.getInstance().getTimeInMillis();
        return (r0 - (r0 % 86400000)) - ((long) TimeZone.getDefault().getRawOffset());
    }
}
