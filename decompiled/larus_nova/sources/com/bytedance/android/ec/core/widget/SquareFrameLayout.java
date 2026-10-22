package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes43.dex */
public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(Context r100) {
        super(r100);
    }

    public SquareFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r100);
    }

    public SquareFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
