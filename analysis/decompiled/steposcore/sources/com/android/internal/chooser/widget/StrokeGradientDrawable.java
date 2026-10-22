package com.android.internal.chooser.widget;

import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;

/* compiled from: Switch.java */
/* loaded from: classes.dex */
class StrokeGradientDrawable {
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

    public StrokeGradientDrawable(GradientDrawable drawable) {
        this.mGradientDrawable = drawable;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.mStrokeWidth = strokeWidth;
        this.mGradientDrawable.setStroke(strokeWidth, getStrokeColor());
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeColor = strokeColor;
        this.mGradientDrawable.setStroke(getStrokeWidth(), strokeColor);
    }

    public void setCornerRadius(float radius) {
        this.mRadius = radius;
        this.mGradientDrawable.setCornerRadius(radius);
    }

    public void setColor(int color) {
        this.mColor = color;
        this.mGradientDrawable.setColor(color);
        this.mGradientDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public int getColor() {
        return this.mColor;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
        this.mGradientDrawable.setSize(this.mWidth, mHeight);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
        this.mGradientDrawable.setSize(mWidth, this.mHeight);
    }

    public GradientDrawable getGradientDrawable() {
        return this.mGradientDrawable;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void setPaddingLeft(int mPaddingLeft) {
        this.mPaddingLeft = mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public void setPaddingRight(int mPaddingRight) {
        this.mPaddingRight = mPaddingRight;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(int alpha) {
        if (this.mAlpha == alpha) {
            return;
        }
        this.mAlpha = alpha;
        this.mGradientDrawable.setAlpha(alpha);
    }
}
