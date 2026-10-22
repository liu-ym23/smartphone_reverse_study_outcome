package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedanceos.common.BaseApplication;
import com.tmall.wireless.tangram.structure.card.FixCard;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    public static class a extends DisplayMetrics {
        public a() {
            ((DisplayMetrics) this).widthPixels = 0;
            ((DisplayMetrics) this).heightPixels = 0;
            ((DisplayMetrics) this).density = 0.0f;
            ((DisplayMetrics) this).densityDpi = 120;
            ((DisplayMetrics) this).scaledDensity = 0.0f;
            ((DisplayMetrics) this).xdpi = 0.0f;
            ((DisplayMetrics) this).ydpi = 0.0f;
        }
    }

    public static int a(int r10) {
        return b(BaseApplication.c(), r10);
    }

    public static int b(Context r10, int r11) {
        return (int) ((r11 * f(r10)) + 0.5f);
    }

    public static DisplayMetrics c(Context r10) {
        DisplayMetrics r11 = new DisplayMetrics();     // Catch: NullPointerException -> L4
        ((WindowManager) r10.getSystemService("window")).getDefaultDisplay().getMetrics(r11);     // Catch: NullPointerException -> L4
        return r11;
    L5:
        return new a();
    }

    public static String d(int r10) {
        if (r10 < 0) goto L7;
        if (r10 >= 120) goto L7;
        return "ldpi";
    L7:
        if (r10 < 120) goto L11;
        if (r10 >= 160) goto L11;
        return "mdpi";
    L11:
        if (r10 < 160) goto L15;
        if (r10 >= 240) goto L15;
        return "hdpi";
    L15:
        if (r10 < 240) goto L19;
        if (r10 >= 320) goto L19;
        return "xhdpi";
    L19:
        if (r10 < 320) goto L22;
        if (r10 >= 480) goto L22;
        return "xxhdpi";
    L22:
        if (r10 >= 480) goto L24;
    L26:
        return "";
    L24:
        if (r10 >= 640) goto L26;
        return "xxxhdpi";
    }

    public static String e(Context r10) {
        DisplayMetrics r11 = c(r10);
        return r11.widthPixels + FixCard.FixStyle.KEY_X + r11.heightPixels;
    }

    public static float f(Context r10) {
        return c(r10).density;
    }

    public static int g(Context r10) {
        return c(r10).heightPixels;
    }

    public static int h(Context r10) {
        return c(r10).widthPixels;
    }
}
