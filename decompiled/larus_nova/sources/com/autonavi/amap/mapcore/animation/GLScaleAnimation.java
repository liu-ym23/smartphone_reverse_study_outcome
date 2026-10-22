package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: classes39.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX;
    private float mPivotY;
    private float mToX;
    private float mToY;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float r100, GLTransformation r101) {
        float r102 = this.mFromX;
        float r103 = 1.0f;
        if (r102 == 1.0f) goto L5;
    L8:
        float r104 = r102 + ((this.mToX - r102) * r100);
    L9:
        float r105 = this.mFromY;
        if (r105 == 1.0f) goto L12;
    L13:
        r103 = ((this.mToY - r105) * r100) + r105;
    L15:
        if (this.mPivotX == 0.0f) goto L17;
    L19:
        r101.scaleX = r104;
        r101.scaleY = r103;
        return;
    L17:
        if (this.mPivotY != 0.0f) goto L19;
        r101.scaleX = r104;
        r101.scaleY = r103;
        return;
    L12:
        if (this.mToY == 1.0f) goto L15;
    L5:
        if (this.mToX != 1.0f) goto L8;
        r104 = 1.0f;
        goto L9
    }

    public GLScaleAnimation(float r100, float r101, float r102, float r103) {
        this.mFromX = r100;
        this.mToX = r101;
        this.mFromY = r102;
        this.mToY = r103;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
    }
}
