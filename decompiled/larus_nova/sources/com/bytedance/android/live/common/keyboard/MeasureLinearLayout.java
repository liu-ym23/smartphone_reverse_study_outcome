package com.bytedance.android.live.common.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import i40.b;
import i40.d;
import i40.h;

/* JADX INFO: loaded from: classes45.dex */
public class MeasureLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f64490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f64492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64493d;

    public b getKeyBoardObservable() {
        return this.f64490a;
    }

    public MeasureLinearLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        b r101 = this.f64490a;
        Context r102 = getContext();
        d r103 = r101.f488133a.a(r102, this);
        if (r103 == null) goto L7;
        r101.c(r103.f488135a, r103.f488136b);
        return;
    }

    public void setKeyBoardObservable(b r100) {
        this.f64490a = r100;
    }

    public MeasureLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f64492c;
        int r103 = this.f64491b;
        if (r102 != r103) goto L5;
        this.f64493d = this.f64490a.a(getContext(), r101);
    L6:
        super.onMeasure(r100, r101);
        return;
    L5:
        this.f64492c = r103;
        goto L6
    }

    public MeasureLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f64493d = true;
        this.f64490a = new b(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        if (this.f64493d == true) goto L6;
        h.c("【skip layout】", true);
        return;
    L6:
        super.onLayout(r100, r101, r110, r111, r112);
        b r102 = this.f64490a;
        Context r103 = getContext();
        r102.f488133a.c(r103, this, r101, r110, r111, r112);
    }
}
