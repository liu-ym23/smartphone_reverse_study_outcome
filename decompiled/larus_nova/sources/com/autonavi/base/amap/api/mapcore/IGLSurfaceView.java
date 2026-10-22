package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.mapcore.util.h3;
import com.amap.api.mapcore.util.i3;

/* JADX INFO: loaded from: classes39.dex */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable r100);

    boolean postDelayed(Runnable r100, long r101);

    void queueEvent(Runnable r100);

    void requestRender();

    void setBackgroundColor(int r100);

    void setEGLConfigChooser(h3 r100);

    void setEGLContextFactory(i3 r100);

    void setRenderMode(int r100);

    void setRenderer(GLSurfaceView.Renderer r100);

    void setVisibility(int r100);

    void setZOrderOnTop(boolean r100);
}
