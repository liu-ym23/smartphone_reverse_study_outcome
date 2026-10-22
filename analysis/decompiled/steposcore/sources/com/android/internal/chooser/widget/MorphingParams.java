package com.android.internal.chooser.widget;

import android.content.res.ColorStateList;

/* compiled from: Switch.java */
/* loaded from: classes.dex */
class MorphingParams {
    public float cornerRadius;
    public int duration;
    public float fromAlpha;
    public ColorStateList fromColor;
    public ColorStateList fromDarkColor;
    public int fromStrokeColor;
    public int fromStrokeWidth;
    public int height;
    public StrokeGradientDrawable mDrawable;
    public float toAlpha;
    public ColorStateList toColor;
    public ColorStateList toDarkColor;
    public int toStrokeColor;
    public int toStrokeWidth;
    public int width;

    private MorphingParams(StrokeGradientDrawable drawable) {
        this.mDrawable = drawable;
    }

    public static MorphingParams create(StrokeGradientDrawable drawable) {
        return new MorphingParams(drawable);
    }

    public MorphingParams duration(int duration) {
        this.duration = duration;
        return this;
    }

    public MorphingParams color(ColorStateList fromColor, ColorStateList toColor) {
        this.fromColor = fromColor;
        this.toColor = toColor;
        return this;
    }

    public MorphingParams cornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public MorphingParams height(int height) {
        this.height = height;
        return this;
    }

    public MorphingParams width(int width) {
        this.width = width;
        return this;
    }

    public MorphingParams strokeWidth(int fromStrokeWidth, int toStrokeWidth) {
        this.fromStrokeWidth = fromStrokeWidth;
        this.toStrokeWidth = toStrokeWidth;
        return this;
    }

    public MorphingParams strokeColor(int fromStrokeColor, int toStrokeColor) {
        this.fromStrokeColor = fromStrokeColor;
        this.toStrokeColor = toStrokeColor;
        return this;
    }

    public MorphingParams alpha(float fromAlpha, float toAlpha) {
        this.fromAlpha = fromAlpha;
        this.toAlpha = toAlpha;
        return this;
    }
}
