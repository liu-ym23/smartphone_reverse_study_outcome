package com.stepos.common.drawble;

import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class StrokeGradientDrawable {
    private GradientDrawable mGradientDrawable;
    private int mStrokeColor;
    private int mStrokeWidth;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.mGradientDrawable = gradientDrawable;
    }

    public GradientDrawable getGradientDrawable() {
        return this.mGradientDrawable;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeColor(int i10) {
        this.mStrokeColor = i10;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i10);
    }

    public void setStrokeWidth(int i10) {
        this.mStrokeWidth = i10;
        this.mGradientDrawable.setStroke(i10, getStrokeColor());
    }
}
