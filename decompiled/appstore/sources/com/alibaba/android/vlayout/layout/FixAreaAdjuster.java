package com.alibaba.android.vlayout.layout;

/* JADX INFO: loaded from: classes.dex */
public class FixAreaAdjuster {
    public static final FixAreaAdjuster mDefaultAdjuster = null;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static {
        mDefaultAdjuster = new FixAreaAdjuster(0, 0, 0, 0);
    }

    public FixAreaAdjuster(int r10, int r11, int r12, int r13) {
        this.left = r10;
        this.top = r11;
        this.right = r12;
        this.bottom = r13;
    }
}
