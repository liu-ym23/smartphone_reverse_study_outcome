package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes2.dex */
public class ScrollGridView extends GridView {
    public ScrollGridView(Context r10) {
        super(r10);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ScrollGridView(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public ScrollGridView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
