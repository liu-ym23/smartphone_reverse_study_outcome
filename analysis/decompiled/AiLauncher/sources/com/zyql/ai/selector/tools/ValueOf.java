package com.zyql.ai.selector.tools;

/* loaded from: classes4.dex */
public class ValueOf {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T to(Object obj, T t10) {
        return obj == 0 ? t10 : obj;
    }

    public static boolean toBoolean(Object obj) {
        return toBoolean(obj, false);
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static float toFloat(Object obj, long j10) {
        if (obj == null) {
            return j10;
        }
        try {
            return Float.valueOf(obj.toString().trim()).floatValue();
        } catch (Exception unused) {
            return j10;
        }
    }

    public static int toInt(Object obj, int i10) {
        if (obj != null) {
            try {
                String strTrim = obj.toString().trim();
                return strTrim.contains(".") ? Integer.valueOf(strTrim.substring(0, strTrim.lastIndexOf("."))).intValue() : Integer.valueOf(strTrim).intValue();
            } catch (Exception unused) {
            }
        }
        return i10;
    }

    public static long toLong(Object obj, long j10) {
        if (obj != null) {
            try {
                String strTrim = obj.toString().trim();
                return strTrim.contains(".") ? Long.valueOf(strTrim.substring(0, strTrim.lastIndexOf("."))).longValue() : Long.valueOf(strTrim).longValue();
            } catch (Exception unused) {
            }
        }
        return j10;
    }

    public static String toString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean toBoolean(Object obj, boolean z10) {
        if (obj == null) {
            return false;
        }
        try {
            return !"false".equals(obj.toString().trim().trim());
        } catch (Exception unused) {
            return z10;
        }
    }

    public static double toDouble(Object obj, int i10) {
        if (obj == null) {
            return i10;
        }
        try {
            return Double.valueOf(obj.toString().trim()).doubleValue();
        } catch (Exception unused) {
            return i10;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0L);
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static long toLong(Object obj) {
        return toLong(obj, 0L);
    }
}
