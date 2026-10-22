package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class PolicySdkStatusbarColorUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 0;
    private static final String TAG = "StatusbarColorUtils";
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    static {
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (Exception unused4) {
        }
    }

    private static boolean changeStepOsFlag(WindowManager.LayoutParams layoutParams, String str, boolean z4) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i4 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("steposFlags");
            declaredField2.setAccessible(true);
            int i5 = declaredField2.getInt(layoutParams);
            int i6 = z4 ? i4 | i5 : (~i4) & i5;
            if (i5 == i6) {
                return false;
            }
            declaredField2.setInt(layoutParams, i6);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBlackColor(int i4, int i5) {
        return toGrey(i4) < i5;
    }

    public static void setStatusBarColor(Window window, int i4) throws IllegalAccessException, IllegalArgumentException {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i4) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i4));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i4));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean zIsBlackColor = isBlackColor(i4, 50);
        if (mStatusBarColorFiled == null) {
            setStatusBarDarkIcon(activity, zIsBlackColor);
        } else {
            setStatusBarDarkIcon(activity, zIsBlackColor, zIsBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i4);
        }
    }

    public static int toGrey(int i4) {
        return (((i4 & 255) * 15) + ((((65280 & i4) >> 8) * 75) + (((i4 & 16711680) >> 16) * 38))) >> 7;
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarDarkIcon(activity, z4, true);
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z4, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z4));
            } catch (Exception unused) {
            }
        } else if (z5) {
            setStatusBarDarkIcon(activity.getWindow(), z4);
        }
    }

    private static void setStatusBarDarkIcon(View view, boolean z4) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i4 = z4 ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        if (i4 != systemUiVisibility) {
            view.setSystemUiVisibility(i4);
        }
    }

    public static void setStatusBarDarkIcon(Window window, int i4) {
        try {
            setStatusBarColor(window, i4);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception unused) {
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z4) throws IllegalAccessException, IllegalArgumentException {
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z4);
            setStatusBarColor(window, 0);
        }
    }
}
