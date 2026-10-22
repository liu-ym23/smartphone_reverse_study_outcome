package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;

/* JADX INFO: loaded from: classes28.dex */
public class ScaleAnimation extends Animation {
    private float mFromX;
    private float mFromY;
    private float mPivotX;
    private float mPivotY;
    private float mToX;
    private float mToY;

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "ScaleAnimation";
    }

    public ScaleAnimation(float r100, float r101, float r102, float r103) {
        this.glAnimation = new GLScaleAnimation(r100, r101, r102, r103);
        this.mFromX = r100;
        this.mToX = r101;
        this.mFromY = r102;
        this.mToY = r103;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }
}
