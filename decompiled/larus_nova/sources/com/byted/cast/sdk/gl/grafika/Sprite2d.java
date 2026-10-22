package com.byted.cast.sdk.gl.grafika;

import android.opengl.Matrix;

/* JADX INFO: loaded from: classes43.dex */
public class Sprite2d {
    private static final String TAG = "Grafika";
    private float mAngle;
    private float[] mColor;
    private Drawable2d mDrawable;
    private boolean mMatrixReady;
    private float[] mModelViewMatrix;
    private float mPosX;
    private float mPosY;
    private float mScaleX;
    private float mScaleY;
    private float[] mScratchMatrix;
    private int mTextureId;

    private void recomputeMatrix() {
        float[] r100 = this.mModelViewMatrix;
        Matrix.setIdentityM(r100, 0);
        Matrix.translateM(r100, 0, this.mPosX, this.mPosY, 0.0f);
        float r101 = this.mAngle;
        if (r101 == 0.0f) goto L5;
        Matrix.rotateM(r100, 0, r101, 0.0f, 0.0f, 1.0f);
    L5:
        Matrix.scaleM(r100, 0, this.mScaleX, this.mScaleY, 1.0f);
        this.mMatrixReady = true;
    }

    public float[] getModelViewMatrix() {
        if (this.mMatrixReady == true) goto L6;
        recomputeMatrix();
    L6:
        return this.mModelViewMatrix;
    }

    public String toString() {
        return "[Sprite2d pos=" + this.mPosX + "," + this.mPosY + " scale=" + this.mScaleX + "," + this.mScaleY + " angle=" + this.mAngle + " color={" + this.mColor[0] + "," + this.mColor[1] + "," + this.mColor[2] + "} drawable=" + this.mDrawable + "]";
    }

    public float[] getColor() {
        return this.mColor;
    }

    public float getPositionX() {
        return this.mPosX;
    }

    public float getPositionY() {
        return this.mPosY;
    }

    public float getRotation() {
        return this.mAngle;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public Sprite2d(Drawable2d r100) {
        this.mScratchMatrix = new float[16];
        this.mDrawable = r100;
        float[] r101 = new float[4];
        this.mColor = r101;
        r101[3] = 1.0f;
        this.mTextureId = -1;
        this.mModelViewMatrix = new float[16];
        this.mMatrixReady = false;
    }

    public void setRotation(float r100) {
    L3:
        if (r100 < 360.0f) goto L6;
        r100 = r100 - 360.0f;
    L6:
        if (r100 > (-360.0f)) goto L8;
        r100 = r100 + 360.0f;
        goto L6
    L8:
        this.mAngle = r100;
        this.mMatrixReady = false;
    }

    public void setTexture(int r100) {
        this.mTextureId = r100;
    }

    public void draw(Texture2dProgram r110, float[] r210) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, r210, 0, getModelViewMatrix(), 0);
        r110.draw(this.mScratchMatrix, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.mDrawable.getTexCoordArray(), this.mTextureId, this.mDrawable.getTexCoordStride());
    }

    public void setPosition(float r100, float r101) {
        this.mPosX = r100;
        this.mPosY = r101;
        this.mMatrixReady = false;
    }

    public void setScale(float r100, float r101) {
        this.mScaleX = r100;
        this.mScaleY = r101;
        this.mMatrixReady = false;
    }

    public void draw(FlatShadedProgram r110, float[] r111) {
        Matrix.multiplyMM(this.mScratchMatrix, 0, r111, 0, getModelViewMatrix(), 0);
        r110.draw(this.mScratchMatrix, this.mColor, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride());
    }

    public void setColor(float r100, float r101, float r102) {
        float[] r103 = this.mColor;
        r103[0] = r100;
        r103[1] = r101;
        r103[2] = r102;
    }
}
