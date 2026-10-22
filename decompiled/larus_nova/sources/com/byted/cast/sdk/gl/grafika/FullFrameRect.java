package com.byted.cast.sdk.gl.grafika;

/* JADX INFO: loaded from: classes43.dex */
public class FullFrameRect {
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable;

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public FullFrameRect(Texture2dProgram r100) {
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mProgram = r100;
    }

    public void changeProgram(Texture2dProgram r100) {
        this.mProgram.release();
        this.mProgram = r100;
    }

    public void release(boolean r100) {
        Texture2dProgram r101 = this.mProgram;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.release();
    L6:
        this.mProgram = null;
        return;
    }

    public void drawFrame(int r110, float[] r111) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), r111, this.mRectDrawable.getTexCoordArray(), r110, this.mRectDrawable.getTexCoordStride());
    }
}
