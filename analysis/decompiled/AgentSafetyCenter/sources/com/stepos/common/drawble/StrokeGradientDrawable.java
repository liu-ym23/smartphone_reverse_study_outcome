package com.stepos.common.drawble;

import android.graphics.drawable.GradientDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i);
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        this.mGradientDrawable.setStroke(i, getStrokeColor());
    }
}
