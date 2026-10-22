package com.amap.api.mapcore.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes28.dex */
public class l3 extends i3 {
    public l3() {
    }

    @Override // com.amap.api.mapcore.util.i3, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.y.g
    public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
        return r100.eglCreateContext(r101, r102, EGL10.EGL_NO_CONTEXT, new int[]{12440, 3, 12344});
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.amap.api.mapcore.util.i3, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.y.g
    public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
        if (r100 == null) goto L17;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == EGL10.EGL_NO_DISPLAY) goto L19;
        if (r102 == null) goto L20;
        EGLContext r103 = EGL10.EGL_NO_CONTEXT;
        if (r102 == r103) goto L22;
        EGLSurface r104 = EGL10.EGL_NO_SURFACE;     // Catch: Throwable -> L14
        r100.eglMakeCurrent(r101, r104, r104, r103);     // Catch: Throwable -> L14
        if (r100.eglDestroyContext(r101, r102) == true) goto L21;
        r100.eglGetError();     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    }
}
