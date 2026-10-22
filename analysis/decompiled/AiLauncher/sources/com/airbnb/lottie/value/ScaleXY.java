package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f10, float f11) {
        this.scaleX = f10;
        this.scaleY = f11;
    }

    public boolean equals(float f10, float f11) {
        return this.scaleX == f10 && this.scaleY == f11;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f10, float f11) {
        this.scaleX = f10;
        this.scaleY = f11;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
