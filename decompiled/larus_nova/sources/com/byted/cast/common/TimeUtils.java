package com.byted.cast.common;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes39.dex */
public class TimeUtils {
    private static final ThreadLocal<SimpleDateFormat> millisFormatter = null;
    private static final ThreadLocal<SimpleDateFormat> millsFormatterWithUnderline = null;

    public TimeUtils() {
    }

    static {
        millisFormatter = new AnonymousClass1();
        millsFormatterWithUnderline = new AnonymousClass2();
    }

    public static String getCurrentMillisTime() {
        SimpleDateFormat r100 = millisFormatter.get();
        if (r100 != null) goto L7;
        return String.valueOf(System.currentTimeMillis());
    L7:
        return r100.format(new java.util.Date(System.currentTimeMillis()));
    }

    public static String getCurrentMillisTimeWithUnderline() {
        SimpleDateFormat r100 = millsFormatterWithUnderline.get();
        if (r100 != null) goto L7;
        return String.valueOf(System.currentTimeMillis());
    L7:
        return r100.format(new java.util.Date(System.currentTimeMillis()));
    }
}
