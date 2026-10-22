package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes28.dex */
public class i3 implements GLSurfaceView.EGLContextFactory, y.g {
    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.y.g
    public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
        return null;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.y.g
    public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
    }

    public i3() {
    }
}
