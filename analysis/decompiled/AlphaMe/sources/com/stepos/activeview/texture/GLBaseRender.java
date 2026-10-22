package com.stepos.activeview.texture;

import android.content.Context;
import android.opengl.GLES20;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class GLBaseRender implements GLRendererInterface {
    protected Context mContext;
    protected String mFragGlsl;
    protected int mHeight;
    protected String mImageFile;
    protected String mVertexGlsl;
    protected int mWidth;
    private GLRenderDefault tle;

    public GLBaseRender(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mVertexGlsl = str;
        this.mFragGlsl = str2;
        this.mImageFile = str3;
    }

    private void drawFun(float f4) {
        GLES20.glClear(16640);
        this.tle.drawSelf(f4);
    }

    @Override // com.stepos.activeview.texture.GLRendererInterface
    public void drawFrame(float f4) {
        GLES20.glClear(16384);
        drawFun(f4);
    }

    @Override // com.stepos.activeview.texture.GLRendererInterface
    public void renderChanged(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
        GLES20.glViewport(0, 0, i4, i5);
        float f4 = this.mWidth / this.mHeight;
        this.tle.setFrustumM(-f4, f4, -1.0f, 1.0f, 1.0f, 10.0f);
        this.tle.setViewMat(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 3.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE);
        this.tle.setResolution(this.mWidth, this.mHeight);
    }

    @Override // com.stepos.activeview.texture.GLRendererInterface
    public void renderInit(int i4, int i5) {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.tle = new GLRenderDefault(this.mContext, this.mVertexGlsl, this.mFragGlsl, this.mImageFile);
        GLES20.glEnable(2929);
        renderChanged(i4, i5);
    }

    public void setViewport(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
    }

    @Override // com.stepos.activeview.texture.GLRendererInterface
    public void setWidthAndHeight(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
    }
}
