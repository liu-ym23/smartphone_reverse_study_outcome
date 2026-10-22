package com.byted.cast.sdk.gl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: classes43.dex */
public class EGlSurface {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = "EglSurface";
    private EGLConfig[] configs;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int height;
    private Surface surface;
    private int width;

    private void createEGLSurface() {
        this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.configs[0], this.surface, new int[]{12344}, 0);
        GlUtils.checkEglError("eglCreateWindowSurface");
    }

    private void eglSetup() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        this.eglDisplay = r100;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L15;
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == false) goto L13;
        EGLDisplay r102 = this.eglDisplay;
        EGLConfig[] r103 = this.configs;
        int r104 = r103.length;
        if (EGL14.eglChooseConfig(r102, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, r103, 0, r104, new int[1], 0) == false) goto L11;
        EGLDisplay r105 = this.eglDisplay;
        EGLConfig r106 = this.configs[0];
        EGLContext r107 = EGL14.EGL_NO_CONTEXT;
        this.eglContext = EGL14.eglCreateContext(r105, r106, r107, new int[]{12440, 2, 12344}, 0);
        GlUtils.checkEglError("eglCreateContext");
        createEGLSurface();
        this.width = getWidth();
        this.height = getHeight();
        return;
    L11:
        throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    L13:
        throw new RuntimeException("unable to initialize EGL14");
    L15:
        throw new RuntimeException("unable to get EGL14 display");
    }

    public int getHeight() {
        int[] r100 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r100, 0);
        return r100[0];
    }

    public int getWidth() {
        int[] r100 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r100, 0);
        return r100[0];
    }

    public void makeCurrent() {
        EGLDisplay r100 = this.eglDisplay;
        EGLSurface r101 = this.eglSurface;
        if (EGL14.eglMakeCurrent(r100, r101, r101, this.eglContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void makeUnCurrent() {
        EGLDisplay r100 = this.eglDisplay;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void release() {
        EGLDisplay r100 = this.eglDisplay;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGL14.eglDestroySurface(r100, this.eglSurface);
        EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.eglDisplay);
    L5:
        this.surface.release();
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }

    public EGlSurface(Surface r100) {
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.configs = new EGLConfig[1];
        this.width = 0;
        this.height = 0;
        this.surface = r100;
        eglSetup();
    }

    public void setPresentationTime(long r100) {
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, r100);
    }
}
