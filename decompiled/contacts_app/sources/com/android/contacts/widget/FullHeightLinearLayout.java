package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class FullHeightLinearLayout extends LinearLayout {
    public FullHeightLinearLayout(Context r1) {
        super(r1);
    }

    public FullHeightLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public FullHeightLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (View.MeasureSpec.getMode(r4) != Integer.MIN_VALUE) goto L5;
        r4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r4), 1073741824);
    L5:
        super.onMeasure(r3, r4);
    }
}
