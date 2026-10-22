package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Util {
    public Util() {
    }

    public static final FrameLayout.LayoutParams createLayoutParams(int r10, int r11) {
        return new FrameLayout.LayoutParams(r10, r11);
    }

    public static final FrameLayout.LayoutParams createMatchParams() {
        return createLayoutParams(-1, -1);
    }

    public static final FrameLayout.LayoutParams createMatchWrapParams() {
        return createLayoutParams(-1, -2);
    }

    public static final FrameLayout.LayoutParams createWrapMatchParams() {
        return createLayoutParams(-2, -1);
    }

    public static final FrameLayout.LayoutParams createWrapParams() {
        return createLayoutParams(-2, -2);
    }

    public static final int dpToPx(float r10, Resources r11) {
        return (int) TypedValue.applyDimension(1, r10, r11.getDisplayMetrics());
    }
}
