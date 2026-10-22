package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    private static boolean changeStepOsFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i10 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("steposFlags");
            declaredField2.setAccessible(true);
            int i11 = declaredField2.getInt(layoutParams);
            int i12 = z ? i10 | i11 : (~i10) & i11;
            if (i11 == i12) {
                return false;
            }
            declaredField2.setInt(layoutParams, i12);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBlackColor(int i10, int i11) {
        return toGrey(i10) < i11;
    }

    public static void setStatusBarColor(Window window, int i10) throws IllegalAccessException, IllegalArgumentException {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i10) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i10));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i10));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean zIsBlackColor = isBlackColor(i10, 50);
        if (mStatusBarColorFiled == null) {
            setStatusBarDarkIcon(activity, zIsBlackColor);
        } else {
            setStatusBarDarkIcon(activity, zIsBlackColor, zIsBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i10);
        }
    }

    public static int toGrey(int i10) {
        return (((i10 & 255) * 15) + ((((65280 & i10) >> 8) * 75) + (((i10 & 16711680) >> 16) * 38))) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i10) {
        try {
            setStatusBarColor(window, i10);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception unused) {
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarDarkIcon(activity, z, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z) {
        int i10;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i10 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i10 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i10 != systemUiVisibility) {
            view.setSystemUiVisibility(i10);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) throws IllegalAccessException, IllegalArgumentException {
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z);
            setStatusBarColor(window, 0);
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        } else if (z3) {
            setStatusBarDarkIcon(activity.getWindow(), z);
        }
    }
}
