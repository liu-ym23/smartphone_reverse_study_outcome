package com.stepos.pps.reflect;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SystemProperties {
    private static final String TAG = "SystemProperties";
    private static Method getBoolean_Method;
    private static Method getInt_Method;
    private static Method get_Method;
    private static Method set_Method;

    static {
        init();
    }

    public static String get(String str, String str2) {
        try {
            return (String) get_Method.invoke(null, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "get " + e.toString());
            return str2;
        }
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static boolean getBoolean(String str, boolean z) {
        try {
            return ((Boolean) getBoolean_Method.invoke(null, str, Boolean.valueOf(z))).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "getBoolean " + e.toString());
            return z;
        }
    }

    public static int getInt(String str, int i) {
        try {
            return ((Integer) getInt_Method.invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getInt" + e.toString());
            return i;
        }
    }

    public static void set(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            set_Method.invoke(null, str, str2);
        } catch (Exception e) {
            Log.i(TAG, "set: " + e.toString());
        }
    }

    private static void init() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            get_Method = cls.getMethod("get", String.class, String.class);
            getBoolean_Method = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            getInt_Method = cls.getMethod("getInt", String.class, Integer.TYPE);
            set_Method = cls.getMethod("set", String.class, String.class);
        } catch (Exception e) {
            Log.e(TAG, "SystemProperty init " + e.toString());
        }
    }
}
