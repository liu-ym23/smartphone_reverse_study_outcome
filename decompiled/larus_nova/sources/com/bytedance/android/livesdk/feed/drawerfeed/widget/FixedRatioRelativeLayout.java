package com.bytedance.android.livesdk.feed.drawerfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes8.dex */
public class FixedRatioRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f123993a;

    public FixedRatioRelativeLayout(Context r100) {
        super(r100);
        this.f123993a = 1.0f;
    }

    public void setRatio(float r100) {
        this.f123993a = r100;
    }

    public FixedRatioRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f123993a = 1.0f;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        float r103 = this.f123993a;
        if (r103 <= 0.0f) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec((int) (r102 / r103), 1073741824);
    L5:
        super.onMeasure(r100, r101);
    }

    public FixedRatioRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f123993a = 1.0f;
    }
}
