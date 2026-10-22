package com.zyql.ai.selector.tools;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class DateUtils {
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String cdTime(long j10, long j11) {
        long j12 = j11 - j10;
        if (j12 > 1000) {
            return (j12 / 1000) + "秒";
        }
        return j12 + "毫秒";
    }

    public static int dateDiffer(long j10) {
        try {
            return (int) Math.abs(getCurrentTimeMillis() - j10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j10) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d", Long.valueOf(timeUnit.toMinutes(j10)), Long.valueOf(timeUnit.toSeconds(j10) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j10))));
    }

    public static String getCreateFileName(String str) {
        return str + sf.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static long getCurrentTimeMillis() {
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        if (string.length() > 10) {
            string = string.substring(0, 10);
        }
        return ValueOf.toLong(string);
    }

    public static String getCreateFileName() {
        return sf.format(Long.valueOf(System.currentTimeMillis()));
    }
}
