package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes44.dex */
public final class y0 {
    public static DisplayMetrics d() {
        if (getContext() != null) goto L6;
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    L6:
        Resources r101 = getContext().getApplicationContext().getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
    }

    public static int f() {
        return d().heightPixels;
    }

    public static int g() {
        return d().widthPixels;
    }

    public static Context getContext() {
        return com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
    }

    public static Resources getResources() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getResources();
    }

    public static final int h() {
        int r100 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r100 > 0) goto L7;
        return 0;
    L7:
        return getContext().getResources().getDimensionPixelSize(r100);
    }

    public static float a(float r100) {
        return TypedValue.applyDimension(1, r100, d());
    }

    public static int b(float r100) {
        return (int) ((r100 * d().density) + 0.5f);
    }

    public static int c(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r101.getResources() == null) goto L8;
        return r101.getResources().getColor(r100);
    }

    public static Drawable e(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
    L8:
        return null;
    L5:
        if (r101.getResources() == null) goto L8;
        return r101.getResources().getDrawable(r100);
    }

    public static String i(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getString(r100);
    }

    public static float k(int r100) {
        return r100 / d().density;
    }

    public static String j(int r100, Object... r101) {
        Context r102 = getContext();
        if (r102 != null) goto L6;
        return null;
    L6:
        return r102.getString(r100, r101);
    }
}
