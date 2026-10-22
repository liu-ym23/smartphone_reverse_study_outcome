package com.android.server.wallpaper;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.SystemProperties;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
class GLHelper {
    private static final String TAG = null;
    private static final int sMaxTextureSize = 0;

    GLHelper() {
    }

    static {
        TAG = GLHelper.class.getSimpleName();
        int maxTextureSize = SystemProperties.getInt("sys.max_texture_size", 0);
        if (maxTextureSize <= 0) goto L5;
        int r1 = maxTextureSize;
    L6:
        sMaxTextureSize = r1;
        return;
    L5:
        r1 = retrieveTextureSizeFromGL();
        goto L6
    }

    private static int retrieveTextureSizeFromGL() {
        EGLDisplay eglDisplay = EGL14.eglGetDisplay(0);     // Catch: RuntimeException -> L31
        if (eglDisplay != null) goto L6;
    L29:
        String err = "eglGetDisplay failed: " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: RuntimeException -> L31
        throw new RuntimeException(err);     // Catch: RuntimeException -> L31
    L6:
        if (eglDisplay == EGL14.EGL_NO_DISPLAY) goto L29;
        if (EGL14.eglInitialize(eglDisplay, null, 0, null, 1) == false) goto L27;
        EGLConfig eglConfig = null;
        int[] configsCount = new int[1];     // Catch: RuntimeException -> L31
        EGLConfig[] configs = new EGLConfig[1];     // Catch: RuntimeException -> L31
        int[] configSpec = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12327, 12344, 12344};     // Catch: RuntimeException -> L31
        if (EGL14.eglChooseConfig(eglDisplay, configSpec, 0, configs, 0, 1, configsCount, 0) == true) goto L12;
        String err2 = "eglChooseConfig failed: " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: RuntimeException -> L31
        throw new RuntimeException(err2);     // Catch: RuntimeException -> L31
    L12:
        if (configsCount[0] <= 0) goto L14;
        eglConfig = configs[0];     // Catch: RuntimeException -> L31
    L14:
        if (eglConfig == null) goto L24;
        int[] attr_list = {12440, 2, 12344};     // Catch: RuntimeException -> L31
        EGLContext eglContext = EGL14.eglCreateContext(eglDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, attr_list, 0);     // Catch: RuntimeException -> L31
        if (eglContext != null) goto L18;
    L21:
        String err3 = "eglCreateContext failed: " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: RuntimeException -> L31
        throw new RuntimeException(err3);     // Catch: RuntimeException -> L31
    L18:
        if (eglContext == EGL14.EGL_NO_CONTEXT) goto L21;
        int[] attrs = {12375, 1, 12374, 1, 12344};     // Catch: RuntimeException -> L31
        EGLSurface eglSurface = EGL14.eglCreatePbufferSurface(eglDisplay, eglConfig, attrs, 0);     // Catch: RuntimeException -> L31
        EGL14.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext);     // Catch: RuntimeException -> L31
        int[] maxSize = new int[1];     // Catch: RuntimeException -> L31
        GLES20.glGetIntegerv(3379, maxSize, 0);     // Catch: RuntimeException -> L31
        EGL14.eglMakeCurrent(eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);     // Catch: RuntimeException -> L31
        EGL14.eglDestroySurface(eglDisplay, eglSurface);     // Catch: RuntimeException -> L31
        EGL14.eglDestroyContext(eglDisplay, eglContext);     // Catch: RuntimeException -> L31
        EGL14.eglTerminate(eglDisplay);     // Catch: RuntimeException -> L31
        return maxSize[0];
    L24:
        throw new RuntimeException("eglConfig not initialized!");     // Catch: RuntimeException -> L31
    L27:
        String err4 = "eglInitialize failed: " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: RuntimeException -> L31
        throw new RuntimeException(err4);     // Catch: RuntimeException -> L31
    L31:
        e = move-exception;
        Log.w(TAG, "Retrieve from GL failed", e);
        return Integer.MAX_VALUE;
    }

    static int getMaxTextureSize() {
        return sMaxTextureSize;
    }
}
