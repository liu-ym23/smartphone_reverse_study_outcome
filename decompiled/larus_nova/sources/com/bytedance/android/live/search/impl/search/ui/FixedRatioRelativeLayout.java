package com.bytedance.android.live.search.impl.search.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class FixedRatioRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f100793a;

    public FixedRatioRelativeLayout(Context r100) {
        this(r100, null);
    }

    public void setRatio(float r100) {
        this.f100793a = r100;
    }

    public FixedRatioRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        float r103 = this.f100793a;
        if (r103 <= 0.0f) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec((int) (r102 / r103), 1073741824);
    L5:
        super.onMeasure(r100, r101);
    }

    public FixedRatioRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f100793a = 1.0f;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ratio}, r102, 0);
        if (r103 == null) goto L6;
        this.f100793a = r103.getFloat(0, 1.0f);
        r103.recycle();
        return;
    }
}
