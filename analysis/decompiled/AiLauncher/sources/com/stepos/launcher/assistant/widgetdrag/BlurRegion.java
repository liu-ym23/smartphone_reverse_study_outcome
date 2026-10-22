package com.stepos.launcher.assistant.widgetdrag;

import android.graphics.Rect;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class BlurRegion {
    private float alpha;
    private int blurColor;
    private int blurRadius;
    private float cornerRadiusBL;
    private float cornerRadiusBR;
    private float cornerRadiusTL;
    private float cornerRadiusTR;
    private Rect rect;

    public BlurRegion(int i10, float f10, float f11, float f12, float f13, float f14, Rect rect, int i11) {
        this.blurRadius = i10;
        this.cornerRadiusTL = f10;
        this.cornerRadiusTR = f11;
        this.cornerRadiusBL = f12;
        this.cornerRadiusBR = f13;
        this.alpha = f14;
        this.rect = rect;
        this.blurColor = i11;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getBlurColor() {
        return this.blurColor;
    }

    public int getBlurRadius() {
        return this.blurRadius;
    }

    public float getCornerRadiusBL() {
        return this.cornerRadiusBL;
    }

    public float getCornerRadiusBR() {
        return this.cornerRadiusBR;
    }

    public float getCornerRadiusTL() {
        return this.cornerRadiusTL;
    }

    public float getCornerRadiusTR() {
        return this.cornerRadiusTR;
    }

    public Rect getRect() {
        return this.rect;
    }

    public void setAlpha(float f10) {
        this.alpha = f10;
    }

    public void setBlurColor(int i10) {
        this.blurColor = i10;
    }

    public void setBlurRadius(int i10) {
        this.blurRadius = i10;
    }

    public void setCornerRadiusBL(float f10) {
        this.cornerRadiusBL = f10;
    }

    public void setCornerRadiusBR(float f10) {
        this.cornerRadiusBR = f10;
    }

    public void setCornerRadiusTL(float f10) {
        this.cornerRadiusTL = f10;
    }

    public void setCornerRadiusTR(float f10) {
        this.cornerRadiusTR = f10;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public float[] toFloatArray() {
        float f10 = this.blurRadius;
        float f11 = this.alpha;
        Rect rect = this.rect;
        return new float[]{f10, f11, rect.left, rect.top, rect.right, rect.bottom, this.cornerRadiusTL, this.cornerRadiusTR, this.cornerRadiusBL, this.cornerRadiusBR};
    }

    public String toString() {
        return "BlurRegion{blurRadius=" + this.blurRadius + ", corners={" + this.cornerRadiusTL + Const.STR_MART_COMMA + this.cornerRadiusTR + Const.STR_MART_COMMA + this.cornerRadiusBL + Const.STR_MART_COMMA + this.cornerRadiusBR + "}, alpha=" + this.alpha + ", rect=" + this.rect + "}";
    }
}
