package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;

/* JADX INFO: loaded from: classes28.dex */
public class RotateAnimation extends Animation {
    private float mFromDegrees;
    private float mToDegrees;

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "RotateAnimation";
    }

    public RotateAnimation(float r100, float r101) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(r100, r101, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = r100;
        this.mToDegrees = r101;
    }

    public RotateAnimation(float r100, float r101, float r110, float r111, float r112) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(r100, r101, r110, r111, r112);
        this.mFromDegrees = r100;
        this.mToDegrees = r101;
    }
}
