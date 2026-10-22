package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes45.dex */
public class LiveResUtil {
    private static final float DIP_UPPER = 0.5f;
    private static final int MAX_TRACE = 5;
    private static Resources mResources;

    public static Resources getResources() {
        Resources r100 = mResources;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Context r101 = getContext();
        if (r101 == null) goto L8;
        mResources = r101.getResources();
    L8:
        Resources r102 = mResources;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return Resources.getSystem();
    }

    public static Context getContext() {
        return jc1.a.b();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return INVOKEVIRTUAL_com_bytedance_android_live_core_utils_LiveResUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
    }

    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    private LiveResUtil() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_core_utils_LiveResUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static float dip2Px(float r100) {
        return TypedValue.applyDimension(1, r100, getDisplayMetrics());
    }

    public static int dp2Px(float r100) {
        return (int) ((r100 * getDisplayMetrics().density) + 0.5f);
    }

    public static int getColor(int r100) {
        return getResources().getColor(r100);
    }

    public static int getDimension(int r100) {
        return (int) getResources().getDimension(r100);
    }

    public static Drawable getDrawable(int r100) {
        return getResources().getDrawable(r100);
    }

    public static String getString(int r100) {
        return getResources().getString(r100);
    }

    public static String[] getStringArray(int r100) {
        return getResources().getStringArray(r100);
    }

    public static String getString(int r100, Object... r101) {
        return getResources().getString(r100, r101);
    }

    public static String getQuantityString(int r100, int r101, Object... r102) {
        return getResources().getQuantityString(r100, r101, r102);
    }
}
