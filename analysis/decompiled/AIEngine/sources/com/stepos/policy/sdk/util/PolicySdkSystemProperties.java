package com.stepos.policy.sdk.util;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkSystemProperties {
    private PolicySdkSystemProperties() {
    }

    public static String get(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, str);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Boolean getBoolean(Context context, String str, boolean z) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, str, Boolean.valueOf(z));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Boolean.valueOf(z);
        }
    }

    public static Integer getInt(Context context, String str, int i10) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, str, Integer.valueOf(i10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Integer.valueOf(i10);
        }
    }

    public static Long getLong(Context context, String str, long j10) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) clsLoadClass.getMethod("getLong", String.class, Long.TYPE).invoke(clsLoadClass, str, Long.valueOf(j10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Long.valueOf(j10);
        }
    }

    public static void set(Context context, String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            context.getClassLoader().loadClass("android.os.SystemProperties").getMethod("set", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String get(Context context, String str, String str2) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class, String.class).invoke(clsLoadClass, str, str2);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return str2;
        }
    }
}
