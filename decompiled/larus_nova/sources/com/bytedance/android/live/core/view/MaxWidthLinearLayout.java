package com.bytedance.android.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes45.dex */
public class MaxWidthLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66541a;

    public MaxWidthLinearLayout(Context r100) {
        super(r100);
    }

    public void setMaxWidth(int r100) {
        this.f66541a = r100;
    }

    public MaxWidthLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f66541a <= 0) goto L7;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = this.f66541a;
        if (r103 <= r104) goto L7;
        r100 = View.MeasureSpec.makeMeasureSpec(r104, r102);
    L7:
        super.onMeasure(r100, r101);
    }

    public MaxWidthLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
