package com.bef.effectsdk.algorithm;

/* JADX INFO: loaded from: classes39.dex */
public class RectDocDetTargetArea {
    private float bottomLeftX;
    private float bottomLeftY;
    private float bottomRightX;
    private float bottomRightY;
    private float topLeftX;
    private float topLeftY;
    private float topRightX;
    private float topRightY;

    public float getBottomLeftX() {
        return this.bottomLeftX;
    }

    public float getBottomLeftY() {
        return this.bottomLeftY;
    }

    public float getBottomRightX() {
        return this.bottomRightX;
    }

    public float getBottomRightY() {
        return this.bottomRightY;
    }

    public float getTopLeftX() {
        return this.topLeftX;
    }

    public float getTopLeftY() {
        return this.topLeftY;
    }

    public float getTopRightX() {
        return this.topRightX;
    }

    public float getTopRightY() {
        return this.topRightY;
    }

    public RectDocDetTargetArea(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107) {
        this.topLeftX = r100;
        this.topLeftY = r101;
        this.topRightX = r102;
        this.topRightY = r103;
        this.bottomLeftX = r104;
        this.bottomLeftY = r105;
        this.bottomRightX = r106;
        this.bottomRightY = r107;
    }
}
