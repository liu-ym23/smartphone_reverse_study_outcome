package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: classes39.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float r100, float r101) {
        this.mCurAlpha = 0.0f;
        this.mFromAlpha = r100;
        this.mToAlpha = r101;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float r100, GLTransformation r101) {
        float r102 = this.mFromAlpha;
        float r103 = r102 + ((this.mToAlpha - r102) * r100);
        this.mCurAlpha = r103;
        r101.alpha = r103;
    }
}
