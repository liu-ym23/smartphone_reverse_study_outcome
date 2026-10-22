package com.stepos.common.drawble;

import android.graphics.drawable.GradientDrawable;

/* loaded from: classes.dex */
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

    public void setStrokeColor(int i5) {
        this.mStrokeColor = i5;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i5);
    }

    public void setStrokeWidth(int i5) {
        this.mStrokeWidth = i5;
        this.mGradientDrawable.setStroke(i5, getStrokeColor());
    }
}
