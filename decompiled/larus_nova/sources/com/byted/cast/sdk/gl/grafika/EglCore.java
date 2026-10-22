package com.byted.cast.sdk.gl.grafika;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: loaded from: classes43.dex */
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "Grafika";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    public EglCore() {
        this(null, 0);
    }

    public void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) goto L5;
        release();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public void makeNothingCurrent() {
        EGLDisplay r100 = this.mEGLDisplay;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void release() {
        EGLDisplay r100 = this.mEGLDisplay;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEGLDisplay);
    L5:
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    private void checkEglError(String r100) {
        int r101 = EGL14.eglGetError();
        if (r101 != 12288) goto L6;
        return;
    L6:
        throw new RuntimeException(r100 + ": EGL error: 0x" + Integer.toHexString(r101));
    }

    public static void logCurrent(String r100) {
        EGLDisplay r101 = EGL14.eglGetCurrentDisplay();
        EGLContext r102 = EGL14.eglGetCurrentContext();
        EGLSurface r103 = EGL14.eglGetCurrentSurface(12377);
        Objects.toString(r101);
        Objects.toString(r102);
        Objects.toString(r103);
    }

    public EGLSurface createWindowSurface(Object r100) {
        if ((r100 instanceof Surface) == false) goto L5;
    L9:
        EGLSurface r101 = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, r100, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (r101 == null) goto L13;
        return r101;
    L13:
        throw new RuntimeException("surface was null");
    L5:
        if ((r100 instanceof SurfaceTexture) == true) goto L9;
        throw new RuntimeException("invalid surface: " + r100);
    }

    public boolean isCurrent(EGLSurface r100) {
        if (this.mEGLContext.equals(EGL14.eglGetCurrentContext()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(EGL14.eglGetCurrentSurface(12377)) == false) goto L7;
        return true;
    }

    public void makeCurrent(EGLSurface r100) {
        EGLDisplay r101 = this.mEGLDisplay;
        EGLDisplay r102 = EGL14.EGL_NO_DISPLAY;
        if (EGL14.eglMakeCurrent(r101, r100, r100, this.mEGLContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public String queryString(int r100) {
        return EGL14.eglQueryString(this.mEGLDisplay, r100);
    }

    public void releaseSurface(EGLSurface r100) {
        EGL14.eglDestroySurface(this.mEGLDisplay, r100);
    }

    public boolean swapBuffers(EGLSurface r100) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, r100);
    }

    public EglCore(EGLContext r100, int r110) {
        EGLDisplay r101 = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = r101;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        if (r101 != EGL14.EGL_NO_DISPLAY) goto L31;
        if (r100 != null) goto L6;
        r100 = EGL14.EGL_NO_CONTEXT;
    L6:
        EGLDisplay r102 = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = r102;
        if (r102 == EGL14.EGL_NO_DISPLAY) goto L29;
        int[] r103 = new int[2];
        if (EGL14.eglInitialize(r102, r103, 0, r103, 1) == true) goto L11;
        this.mEGLDisplay = null;
        throw new RuntimeException("unable to initialize EGL14");
    L11:
        if ((r110 & 2) == 0) goto L18;
        EGLConfig r104 = getConfig(r110, 3);
        if (r104 == null) goto L18;
        EGLDisplay r105 = this.mEGLDisplay;
        EGLContext r106 = EGL14.eglCreateContext(r105, r104, r100, new int[]{12440, 3, 12344}, 0);
        if (EGL14.eglGetError() != 12288) goto L18;
        this.mEGLConfig = r104;
        this.mEGLContext = r106;
        this.mGlVersion = 3;
    L18:
        if (this.mEGLContext != EGL14.EGL_NO_CONTEXT) goto L24;
        EGLConfig r111 = getConfig(r110, 2);
        if (r111 == null) goto L23;
        EGLDisplay r107 = this.mEGLDisplay;
        EGLContext r108 = EGL14.eglCreateContext(r107, r111, r100, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        this.mEGLConfig = r111;
        this.mEGLContext = r108;
        this.mGlVersion = 2;
        goto L24
    L23:
        throw new RuntimeException("Unable to find a suitable EGLConfig");
    L24:
        EGLDisplay r112 = this.mEGLDisplay;
        EGLContext r109 = this.mEGLContext;
        EGL14.eglQueryContext(r112, r109, 12440, new int[1], 0);
        return;
    L29:
        throw new RuntimeException("unable to get EGL14 display");
    L31:
        throw new RuntimeException("EGL already set up");
    }

    private EGLConfig getConfig(int r110, int r111) {
        if (r111 < 3) goto L5;
        int r112 = 68;
    L6:
        int[] r100 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r112, 12344, 0, 12344};
        if ((r110 & 1) == 0) goto L9;
        r100[10] = 12610;
        r100[11] = 1;
    L9:
        EGLConfig[] r113 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, r100, 0, r113, 0, 1, new int[1], 0) == true) goto L14;
        return null;
    L14:
        return r113[0];
    L5:
        r112 = 4;
        goto L6
    }

    public EGLSurface createOffscreenSurface(int r100, int r101) {
        EGLSurface r102 = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, r100, 12374, r101, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new RuntimeException("surface was null");
    }

    public void makeCurrent(EGLSurface r100, EGLSurface r101) {
        EGLDisplay r102 = this.mEGLDisplay;
        EGLDisplay r103 = EGL14.EGL_NO_DISPLAY;
        if (EGL14.eglMakeCurrent(r102, r100, r101, this.mEGLContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent(draw,read) failed");
    }

    public int querySurface(EGLSurface r100, int r101) {
        int[] r102 = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, r100, r101, r102, 0);
        return r102[0];
    }

    public void setPresentationTime(EGLSurface r100, long r101) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, r100, r101);
    }
}
