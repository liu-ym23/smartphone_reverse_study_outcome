package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public class RoundedRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46047a;

    public float getBorderRadius() {
        return this.f46047a;
    }

    public RoundedRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        int r101 = this.f46047a;
        super.dispatchDraw(r100);
    }

    public void setBorderRadius(int r100) {
        this.f46047a = r100;
        invalidate();
    }

    public RoundedRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundedRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f46047a = 0;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        this.f46047a = r103.getDimensionPixelOffset(1, 0);
    L5:
        r103.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f46047a <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new e0(this.f46047a, r100, r101));
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
