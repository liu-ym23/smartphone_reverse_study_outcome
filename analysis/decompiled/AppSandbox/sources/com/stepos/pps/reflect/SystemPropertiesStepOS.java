package com.stepos.pps.reflect;

import android.util.Log;

/* loaded from: classes.dex */
public class SystemPropertiesStepOS {
    private static final String TAG = "SystemPropertiesStepOS";

    public static void set(String str, String str2) {
        try {
            ReflectCache.on("android.os.SystemProperties", "set", (Class<?>[]) new Class[]{String.class, String.class}).invoke(str, str2);
        } catch (Exception e) {
            Log.e(TAG, "set exception: " + e);
        }
    }

    public static String get(String str, String str2) {
        try {
            return (String) ReflectCache.on("android.os.SystemProperties", "get", (Class<?>[]) new Class[]{String.class, String.class}).invoke(str, str2);
        } catch (Exception e) {
            Log.e(TAG, "get exception: " + e);
            return str2;
        }
    }

    public static int getInt(String str, int i) {
        try {
            return ((Integer) ReflectCache.on("android.os.SystemProperties", "getInt", (Class<?>[]) new Class[]{String.class, Integer.TYPE}).invoke(str, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getInt exception: " + e);
            return i;
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        try {
            return ((Boolean) ReflectCache.on("android.os.SystemProperties", "getBoolean", (Class<?>[]) new Class[]{String.class, Boolean.TYPE}).invoke(str, Boolean.valueOf(z))).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "getInt exception: " + e);
            return z;
        }
    }
}
