package com.stepos.ailauncher.common.utils;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"PrivateApi", "DiscouragedApi"})
/* loaded from: classes3.dex */
public class H {
    private static String DecorViewClsName = "com.android.internal.policy.DecorView";
    public static int MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON = 256;
    private static int NAVIGATION_BAR_TRANSIENT = -1;
    private static int NAVIGATION_BAR_TRANSLUCENT = -1;
    private static int NAVIGATION_BAR_TRANSPARENT = -1;
    private static final String TAG = "NavigationBarUtils";
    private static Field mFiledMeizuFlags = null;
    private static Field mLastBottomInset = null;
    private static Field mLastLeftInset = null;
    private static Field mLastRightInset = null;
    private static final List<Object> mNaviListeners = new ArrayList();
    private static int mNavigationBarHeight = -1;
    private static Method setNavigationBarColorExt;
    private static Method setNavigationBarIconColor;

    static {
        try {
            setNavigationBarIconColor = Window.class.getDeclaredMethod("setNavigationBarIconColor", Boolean.TYPE);
            setNavigationBarColorExt = Window.class.getDeclaredMethod("setNavigationBarColorExt", Integer.TYPE);
            Class<?> cls = Class.forName(DecorViewClsName);
            Field declaredField = cls.getDeclaredField("mLastBottomInset");
            mLastBottomInset = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls.getDeclaredField("mLastRightInset");
            mLastRightInset = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Field declaredField3 = cls.getDeclaredField("mLastLeftInset");
            mLastLeftInset = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
            mFiledMeizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON").getInt(null);
        } catch (Exception e10) {
            Log.w(TAG, "exception:" + e10.getMessage());
        }
    }

    public static int a(String str) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = View.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(null);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static void b() {
        if (NAVIGATION_BAR_TRANSPARENT == -1) {
            NAVIGATION_BAR_TRANSIENT = a("NAVIGATION_BAR_TRANSIENT");
            NAVIGATION_BAR_TRANSLUCENT = a("NAVIGATION_BAR_TRANSLUCENT");
            NAVIGATION_BAR_TRANSPARENT = a("NAVIGATION_BAR_TRANSPARENT");
        }
    }

    public static void c(Window window, boolean z10) {
        if (window == null || window.getDecorView() == null) {
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        int i10 = z10 ? systemUiVisibility | 16 : systemUiVisibility & (-17);
        Log.d(TAG, "setLightNavigationBar isLight:" + z10);
        if (z10) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(134217728);
        }
        window.getDecorView().setSystemUiVisibility(i10);
    }

    public static void d(Window window) {
        b();
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | NAVIGATION_BAR_TRANSPARENT) & (~NAVIGATION_BAR_TRANSIENT) & (~NAVIGATION_BAR_TRANSLUCENT));
        window.clearFlags(134217728);
    }
}
