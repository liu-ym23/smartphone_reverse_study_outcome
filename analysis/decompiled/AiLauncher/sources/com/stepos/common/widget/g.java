package com.stepos.common.widget;

import android.content.res.ColorStateList;

/* loaded from: classes3.dex */
public class g {
    public float cornerRadius;
    public int duration;
    public float fromAlpha;
    public ColorStateList fromColor;
    public ColorStateList fromDarkColor;
    public int fromStrokeColor;
    public int fromStrokeWidth;
    public int height;
    public k mDrawable;
    public float toAlpha;
    public ColorStateList toColor;
    public ColorStateList toDarkColor;
    public int toStrokeColor;
    public int toStrokeWidth;
    public int width;

    public g(k kVar) {
        this.mDrawable = kVar;
    }

    public static g d(k kVar) {
        return new g(kVar);
    }

    public g a(float f10, float f11) {
        this.fromAlpha = f10;
        this.toAlpha = f11;
        return this;
    }

    public g b(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.fromColor = colorStateList;
        this.toColor = colorStateList2;
        return this;
    }

    public g c(int i10) {
        this.cornerRadius = i10;
        return this;
    }

    public g e(int i10) {
        this.height = i10;
        return this;
    }

    public g f(int i10) {
        this.width = i10;
        return this;
    }
}
