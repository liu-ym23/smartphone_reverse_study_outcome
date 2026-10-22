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

    private static boolean changeStepOsFlag(WindowManager.LayoutParams layoutParams, String str, boolean z5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i5 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("steposFlags");
            declaredField2.setAccessible(true);
            int i6 = declaredField2.getInt(layoutParams);
            int i7 = z5 ? i5 | i6 : (~i5) & i6;
            if (i6 == i7) {
                return false;
            }
            declaredField2.setInt(layoutParams, i7);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBlackColor(int i5, int i6) {
        return toGrey(i5) < i6;
    }

    public static void setStatusBarColor(Window window, int i5) throws IllegalAccessException, IllegalArgumentException {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i5) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i5));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i5));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean zIsBlackColor = isBlackColor(i5, 50);
        if (mStatusBarColorFiled == null) {
            setStatusBarDarkIcon(activity, zIsBlackColor);
        } else {
            setStatusBarDarkIcon(activity, zIsBlackColor, zIsBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i5);
        }
    }

    public static int toGrey(int i5) {
        return (((((i5 & 16711680) >> 16) * 38) + (((65280 & i5) >> 8) * 75)) + ((i5 & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i5) {
        try {
            setStatusBarColor(window, i5);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception unused) {
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarDarkIcon(activity, z5, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z5) {
        int i5;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z5) {
            i5 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i5 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i5 != systemUiVisibility) {
            view.setSystemUiVisibility(i5);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z5) throws IllegalAccessException, IllegalArgumentException {
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z5);
            setStatusBarColor(window, 0);
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z5, boolean z6) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z5));
            } catch (Exception unused) {
            }
        } else if (z6) {
            setStatusBarDarkIcon(activity.getWindow(), z5);
        }
    }
}
