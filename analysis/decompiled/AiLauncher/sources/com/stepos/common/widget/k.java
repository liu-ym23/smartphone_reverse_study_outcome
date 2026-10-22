package com.stepos.common.widget;

import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class k {
    private int mAlpha;
    private int mColor;
    private GradientDrawable mGradientDrawable;
    private int mHeight;
    private int mPaddingLeft;
    private int mPaddingRight;
    private float mRadius;
    private int mStrokeColor;
    private int mStrokeWidth;
    private int mWidth;

    public k(GradientDrawable gradientDrawable) {
        this.mGradientDrawable = gradientDrawable;
    }

    public GradientDrawable a() {
        return this.mGradientDrawable;
    }

    public int b() {
        return this.mHeight;
    }

    public int c() {
        return this.mPaddingLeft;
    }

    public int d() {
        return this.mPaddingRight;
    }

    public int e() {
        return this.mWidth;
    }

    public void f(int i10) {
        if (this.mAlpha == i10) {
            return;
        }
        this.mAlpha = i10;
        this.mGradientDrawable.setAlpha(i10);
    }

    public void g(int i10) {
        this.mColor = i10;
        this.mGradientDrawable.setColor(i10);
        this.mGradientDrawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
    }

    public void h(float f10) {
        this.mRadius = f10;
        this.mGradientDrawable.setCornerRadius(f10);
    }

    public void i(int i10) {
        this.mHeight = i10;
        this.mGradientDrawable.setSize(this.mWidth, i10);
    }

    public void j(int i10) {
        this.mPaddingLeft = i10;
    }

    public void k(int i10) {
        this.mPaddingRight = i10;
    }

    public void l(int i10) {
        this.mWidth = i10;
        this.mGradientDrawable.setSize(i10, this.mHeight);
    }
}
