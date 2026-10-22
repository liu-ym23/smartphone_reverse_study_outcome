package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: classes39.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float r100, GLTransformation r101) {
        float r102 = this.mFromDegrees;
        r101.rotate = r102 + ((this.mToDegrees - r102) * r100);
    }

    public GLRotateAnimation(float r100, float r101, float r102, float r103, float r104) {
        this.mFromDegrees = r100;
        this.mToDegrees = r101;
    }
}
