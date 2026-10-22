package com.stepos.statsapp.v3.utils.reflect;

/* loaded from: classes2.dex */
public class SystemProperties {
    public static String get(String str) throws IllegalArgumentException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (String) ReflectionCache.build().getMethod(clsForName, "get", String.class).invoke(clsForName, str);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Boolean getBoolean(String str, boolean z10) throws IllegalArgumentException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Boolean) ReflectionCache.build().getMethod(clsForName, "getBoolean", String.class, Boolean.TYPE).invoke(clsForName, str, Boolean.valueOf(z10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Boolean.valueOf(z10);
        }
    }

    public static Integer getInt(String str, int i10) throws IllegalArgumentException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Integer) ReflectionCache.build().getMethod(clsForName, "getInt", String.class, Integer.TYPE).invoke(clsForName, str, Integer.valueOf(i10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Integer.valueOf(i10);
        }
    }

    public static Long getLong(String str, long j10) throws IllegalArgumentException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (Long) ReflectionCache.build().getMethod(clsForName, "getLong", String.class, Long.TYPE).invoke(clsForName, str, Long.valueOf(j10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Long.valueOf(j10);
        }
    }

    public static String get(String str, String str2) throws IllegalArgumentException {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.SystemProperties");
            return (String) ReflectionCache.build().getMethod(clsForName, "get", String.class, String.class).invoke(clsForName, str, str2);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return str2;
        }
    }
}
