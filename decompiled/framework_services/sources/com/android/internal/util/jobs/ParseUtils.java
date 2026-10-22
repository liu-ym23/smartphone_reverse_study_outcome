package com.android.internal.util.jobs;

/* JADX INFO: loaded from: classes.dex */
public final class ParseUtils {
    private ParseUtils() {
    }

    public static int parseInt(String value, int defValue) {
        return parseIntWithBase(value, 10, defValue);
    }

    public static int parseIntWithBase(String value, int base, int defValue) {
        if (value != null) goto L8;
        return defValue;
    L8:
        return Integer.parseInt(value, base);
    L7:
        return defValue;
    }

    public static long parseLong(String value, long defValue) {
        return parseLongWithBase(value, 10, defValue);
    }

    public static long parseLongWithBase(String value, int base, long defValue) {
        if (value != null) goto L8;
        return defValue;
    L8:
        return Long.parseLong(value, base);
    L7:
        return defValue;
    }

    public static float parseFloat(String value, float defValue) {
        if (value != null) goto L8;
        return defValue;
    L8:
        return Float.parseFloat(value);
    L7:
        return defValue;
    }

    public static double parseDouble(String value, double defValue) {
        if (value != null) goto L8;
        return defValue;
    L8:
        return Double.parseDouble(value);
    L7:
        return defValue;
    }

    public static boolean parseBoolean(String r3, boolean r4) {
        if ("true".equals(r3) == false) goto L6;
        return true;
    L6:
        if ("false".equals(r3) == false) goto L9;
        return false;
    L9:
        if (parseInt(r3, r4 ? 1 : 0) == 0) goto L12;
        return true;
    L12:
        return false;
    }
}
