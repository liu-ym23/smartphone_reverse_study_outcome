package com.stepos.policy.sdk.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    private static boolean changeStepOsFlag(WindowManager.LayoutParams layoutParams, String str, boolean z10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("steposFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i10 = z10 ? i | i3 : (~i) & i3;
            if (i3 == i10) {
                return false;
            }
            declaredField2.setInt(layoutParams, i10);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBlackColor(int i, int i3) {
        return toGrey(i) < i3;
    }

    public static void setStatusBarColor(Window window, int i) throws IllegalAccessException, IllegalArgumentException {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean zIsBlackColor = isBlackColor(i, 50);
        if (mStatusBarColorFiled == null) {
            setStatusBarDarkIcon(activity, zIsBlackColor);
        } else {
            setStatusBarDarkIcon(activity, zIsBlackColor, zIsBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i);
        }
    }

    public static int toGrey(int i) {
        return (((i & 255) * 15) + ((((65280 & i) >> 8) * 75) + (((i & 16711680) >> 16) * 38))) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i) {
        try {
            setStatusBarColor(window, i);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception unused) {
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setStatusBarDarkIcon(activity, z10, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z10) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z10) {
            i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z10);
            setStatusBarColor(window, 0);
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z10, boolean z11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        } else if (z11) {
            setStatusBarDarkIcon(activity.getWindow(), z10);
        }
    }
}
