package com.tmall.wireless.tangram.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TangramViewMetrics {
    private static float mDensity = -1.0f;
    private static int mScreenHeight;
    private static int mScreenWidth;

    static {
    }

    public TangramViewMetrics() {
    }

    public static int dp2px(float r10) {
        return (int) (mDensity * r10);
    }

    public static void initWith(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        DisplayMetrics r12 = r11.getDisplayMetrics();
        mDensity = r12.density;
        int r13 = r11.getConfiguration().orientation;
        if (r13 != 1) goto L5;
        int r14 = r12.widthPixels;
    L6:
        mScreenWidth = r14;
        if (r13 != 1) goto L9;
        int r15 = r12.heightPixels;
    L10:
        mScreenHeight = r15;
        return;
    L9:
        r15 = r12.widthPixels;
        goto L10
    L5:
        r14 = r12.heightPixels;
        goto L6
    }

    public static float screenDensity() {
        return mDensity;
    }

    public static int screenHeight() {
        return mScreenHeight;
    }

    public static int screenWidth() {
        return mScreenWidth;
    }
}
