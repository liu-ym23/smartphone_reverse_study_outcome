package com.stepos.policy.sdk.util;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicySdkSystemProperties {
    private PolicySdkSystemProperties() {
    }

    public static String get(Context context, String str) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, str);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static Boolean getBoolean(Context context, String str, boolean z5) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, str, Boolean.valueOf(z5));
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return Boolean.valueOf(z5);
        }
    }

    public static Integer getInt(Context context, String str, int i5) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, str, Integer.valueOf(i5));
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return Integer.valueOf(i5);
        }
    }

    public static Long getLong(Context context, String str, long j5) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) clsLoadClass.getMethod("getLong", String.class, Long.TYPE).invoke(clsLoadClass, str, Long.valueOf(j5));
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return Long.valueOf(j5);
        }
    }

    public static void set(Context context, String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            context.getClassLoader().loadClass("android.os.SystemProperties").getMethod("set", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static String get(Context context, String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class, String.class).invoke(clsLoadClass, str, str2);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return str2;
        }
    }
}
