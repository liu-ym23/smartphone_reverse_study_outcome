package com.byted.cast.sdk.gl.grafika;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes43.dex */
public class EglSurfaceBase {
    protected static final String TAG = "Grafika";
    private EGLSurface mEGLSurface;
    protected EglCore mEglCore;
    private int mHeight;
    private int mWidth;

    public int getHeight() {
        int r100 = this.mHeight;
        if (r100 < 0) goto L5;
        return r100;
    L5:
        return this.mEglCore.querySurface(this.mEGLSurface, 12374);
    }

    public int getWidth() {
        int r100 = this.mWidth;
        if (r100 < 0) goto L5;
        return r100;
    L5:
        return this.mEglCore.querySurface(this.mEGLSurface, 12375);
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }

    public EglSurfaceBase(EglCore r100) {
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mEglCore = r100;
    }

    public void createWindowSurface(Object r100) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) goto L7;
        this.mEGLSurface = this.mEglCore.createWindowSurface(r100);
        return;
    L7:
        throw new IllegalStateException("surface already created");
    }

    public void makeCurrentReadFrom(EglSurfaceBase r100) {
        this.mEglCore.makeCurrent(this.mEGLSurface, r100.mEGLSurface);
    }

    public void saveFrame(File r110) throws IOException {
        if (this.mEglCore.isCurrent(this.mEGLSurface) == false) goto L16;
        String r111 = r110.toString();
        int r100 = getWidth();
        int r101 = getHeight();
        ByteBuffer r102 = ByteBuffer.allocateDirect((r100 * r101) * 4);
        r102.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, r100, r101, 6408, 5121, r102);
        GlUtil.checkGlError("glReadPixels");
        r102.rewind();
        BufferedOutputStream r103 = null;
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r111));     // Catch: Throwable -> L11
        Bitmap r112 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        r112.copyPixelsFromBuffer(r102);     // Catch: Throwable -> L9
        r112.compress(Bitmap.CompressFormat.PNG, 90, r104);     // Catch: Throwable -> L9
        r112.recycle();     // Catch: Throwable -> L9
        r104.close();
        return;
    L9:
        th = th;
        r103 = r104;
    L12:
        if (r103 == null) goto L14;
        r103.close();
    L14:
        throw th;
    L11:
        th = th;
        goto L12
    L16:
        throw new RuntimeException("Expected EGL context/surface is not current");
    }

    public void setPresentationTime(long r100) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, r100);
    }

    public void createOffscreenSurface(int r100, int r101) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) goto L7;
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(r100, r101);
        this.mWidth = r100;
        this.mHeight = r101;
        return;
    L7:
        throw new IllegalStateException("surface already created");
    }
}
