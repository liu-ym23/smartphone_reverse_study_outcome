package com.stepos.alphame.utils;

import K.RunnableC0090w;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"PrivateApi", "DiscouragedApi"})
/* loaded from: classes.dex */
public class NavigationBarUtils {
    private static String DecorViewClsName = "com.android.internal.policy.DecorView";
    private static int NAVIGATION_BAR_TRANSIENT = -1;
    private static int NAVIGATION_BAR_TRANSLUCENT = -1;
    private static int NAVIGATION_BAR_TRANSPARENT = -1;
    public static int STEPOS_FLAG_DARK_NAVIGATION_BAR_ICON = 256;
    private static final String TAG = "NavigationBarUtils";
    private static Field mFiledSteposFlags = null;
    private static Field mLastBottomInset = null;
    private static Field mLastLeftInset = null;
    private static Field mLastRightInset = null;
    private static final List<OnNavigationChangeListener> mNaviListeners = new ArrayList();
    private static int mNavigationBarHeight = -1;
    private static Method setNavigationBarColorExt;
    private static Method setNavigationBarIconColor;

    public interface OnNavigationChangeListener {
        void onNaviChanged();
    }

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
            mFiledSteposFlags = WindowManager.LayoutParams.class.getDeclaredField("steposFlags");
            STEPOS_FLAG_DARK_NAVIGATION_BAR_ICON = WindowManager.LayoutParams.class.getDeclaredField("STEPOS_FLAG_DARK_NAVIGATION_BAR_ICON").getInt(null);
        } catch (Exception e4) {
            Log.w(TAG, "exception:" + e4.getMessage());
        }
    }

    public static void addNavigationChangeListener(@NonNull OnNavigationChangeListener onNavigationChangeListener) {
        List<OnNavigationChangeListener> list = mNaviListeners;
        if (list.contains(onNavigationChangeListener)) {
            return;
        }
        list.add(onNavigationChangeListener);
    }

    public static void changeNavigationBar(Window window, boolean z4, boolean z5) {
        boolean z6 = z4 || z5;
        boolean zIsLightNavigationBar = isLightNavigationBar(window);
        Log.d(TAG, "setLightBar:" + z6 + ",currentIsLightNavigationBar:" + zIsLightNavigationBar);
        if (zIsLightNavigationBar != z6) {
            setLightNavigationBar(window, z6);
        }
    }

    public static void changeNavigationBarColor(Window window, boolean z4, boolean z5, boolean z6) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (setNavigationBarIconColor == null) {
            changeNavigationBar(window, z4, z6);
            return;
        }
        boolean z7 = z4 || z5;
        try {
            if (isDarkIconColor(window) != z7) {
                Log.d(TAG, "change navigationBar isDarkColor:" + z7);
                setNavigationBarIconColor.invoke(window, Boolean.valueOf(z7));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void checkNavigationBarHeight(View view) {
        if (view != null) {
            view.post(new RunnableC0090w(2, view));
        }
    }

    private static int getFieldInt(String str) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = View.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(null);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int getNavigationBarHeight() {
        return mNavigationBarHeight;
    }

    public static int getNavigationBarHeightV1(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private static void init() {
        if (NAVIGATION_BAR_TRANSPARENT == -1) {
            NAVIGATION_BAR_TRANSIENT = getFieldInt("NAVIGATION_BAR_TRANSIENT");
            NAVIGATION_BAR_TRANSLUCENT = getFieldInt("NAVIGATION_BAR_TRANSLUCENT");
            NAVIGATION_BAR_TRANSPARENT = getFieldInt("NAVIGATION_BAR_TRANSPARENT");
        }
    }

    public static boolean isDarkIconColor(Window window) {
        Field field = mFiledSteposFlags;
        if (field != null && window != null) {
            try {
                return (field.getInt(window.getAttributes()) & STEPOS_FLAG_DARK_NAVIGATION_BAR_ICON) != 0;
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isHaveNavigationBar(Activity activity) {
        return getNavigationBarHeight(activity) > 0;
    }

    public static boolean isLightNavigationBar(Window window) {
        return (window == null || window.getDecorView() == null || (window.getDecorView().getSystemUiVisibility() & 16) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkNavigationBarHeight$0(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        setNavigationBarHeight(rootWindowInsets != null ? rootWindowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom : 0);
    }

    public static void removeNavigationChangeListener(OnNavigationChangeListener onNavigationChangeListener) {
        mNaviListeners.remove(onNavigationChangeListener);
    }

    public static void setLightNavigationBar(Window window, boolean z4) {
        if (window == null || window.getDecorView() == null) {
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        int i4 = z4 ? systemUiVisibility | 16 : systemUiVisibility & (-17);
        Log.d(TAG, "setLightNavigationBar isLight:" + z4);
        if (z4) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(134217728);
        }
        window.getDecorView().setSystemUiVisibility(i4);
    }

    public static void setNavigationBarColor(Window window, int i4) {
        window.clearFlags(134217728);
        window.setNavigationBarColor(i4);
    }

    public static void setNavigationBarColorExt(Window window, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = setNavigationBarColorExt;
        if (method != null) {
            try {
                method.invoke(window, Integer.valueOf(i4));
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void setNavigationBarHeight(int i4) {
        Log.i(TAG, "setNavigationBarHeight: " + i4);
        boolean z4 = i4 != mNavigationBarHeight;
        mNavigationBarHeight = i4;
        if (z4) {
            mNaviListeners.forEach(new b());
        }
    }

    public static void setTransparent(Window window) {
        init();
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility((decorView.getSystemUiVisibility() | NAVIGATION_BAR_TRANSPARENT) & (~NAVIGATION_BAR_TRANSIENT) & (~NAVIGATION_BAR_TRANSLUCENT));
        window.clearFlags(134217728);
    }

    public static int getNavigationBarHeight(Context context) {
        if (context instanceof Activity) {
            return getNavigationBarHeight((Activity) context);
        }
        return 0;
    }

    public static boolean isHaveNavigationBar(Context context) {
        return (context instanceof Activity) && isHaveNavigationBar((Activity) context);
    }

    public static boolean isHaveNavigationBar() {
        try {
            return "0".equals(SystemProperty.get("qemu.hw.mainkeys", "1"));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
