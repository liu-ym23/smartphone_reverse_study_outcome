package com.stepos.activeview.texture;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* loaded from: classes.dex */
public class GLDrawThread extends Thread {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static int THREAD_SLEEP_TIME = 20;
    public static float TIME;
    private EGL10 mEgl;
    private GL mGL;
    private GLBaseRender mRenderer;
    private AtomicBoolean mStopRender;
    private SurfaceTexture mSurfaceTexture;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;

    public GLDrawThread(SurfaceTexture surfaceTexture, GLBaseRender gLBaseRender, AtomicBoolean atomicBoolean) {
        this.mSurfaceTexture = surfaceTexture;
        this.mRenderer = gLBaseRender;
        this.mStopRender = atomicBoolean;
    }

    private void destoryGL() {
        this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglContext = EGL10.EGL_NO_CONTEXT;
        this.mEglSurface = EGL10.EGL_NO_SURFACE;
    }

    public static int getSleepTime() {
        return THREAD_SLEEP_TIME;
    }

    private void initGL() {
        EGLContext eGLContext;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
        }
        if (!this.mEgl.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.mEgl.eglChooseConfig(this.mEglDisplay, new int[]{12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("eglChooseConfig failed : " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
        }
        int[] iArr = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        EGL10 egl102 = this.mEgl;
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContext2 = EGL10.EGL_NO_CONTEXT;
        this.mEglContext = egl102.eglCreateContext(eGLDisplay, eGLConfig, eGLContext2, iArr);
        EGLSurface eGLSurfaceEglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, eGLConfigArr[0], this.mSurfaceTexture, null);
        this.mEglSurface = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE || (eGLContext = this.mEglContext) == eGLContext2) {
            if (this.mEgl.eglGetError() == 12299) {
                throw new RuntimeException("eglCreateWindowSurface returned  EGL_BAD_NATIVE_WINDOW. ");
            }
            throw new RuntimeException("eglCreateWindowSurface failed : " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
        }
        if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, eGLContext)) {
            this.mGL = this.mEglContext.getGL();
        } else {
            throw new RuntimeException("eglMakeCurrent failed : " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
        }
    }

    public static void setSleepTime(int i4) {
        THREAD_SLEEP_TIME = i4;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        initGL();
        GLBaseRender gLBaseRender = this.mRenderer;
        if (gLBaseRender != null) {
            gLBaseRender.renderInit(gLBaseRender.mWidth, gLBaseRender.mHeight);
        }
        while (true) {
            AtomicBoolean atomicBoolean = this.mStopRender;
            if (atomicBoolean == null || atomicBoolean.get()) {
                break;
            }
            if (this.mRenderer != null) {
                synchronized (Float.valueOf(TIME)) {
                    this.mRenderer.drawFrame(TIME);
                    this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
                }
            }
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException unused) {
            }
        }
        destoryGL();
    }
}
