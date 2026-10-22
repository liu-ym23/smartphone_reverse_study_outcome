package com.autonavi.base.ae.gmap.gloverlay;

/* JADX INFO: loaded from: classes39.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int r100, int r101, int r102, int r103) {
        this.mResId = r100;
        this.mWidth = r102;
        this.mHeight = r103;
        this.mResWidth = r102;
        this.mResHeight = r103;
        this.mAnchor = r101;
    }

    public GLOverlayTexture(int r100, int r101, float r102, float r103, int r104, int r105) {
        this.mResId = r100;
        this.mWidth = r104;
        this.mHeight = r105;
        this.mResWidth = r104;
        this.mResHeight = r105;
        this.mAnchor = r101;
        this.mAnchorXRatio = r102;
        this.mAnchorYRatio = r103;
    }
}
