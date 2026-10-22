package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes39.dex */
interface r extends SurfaceHolder.Callback2 {
    Bitmap captureImageFromSurface(int r100, int r101, int r102, int r103, Object r104, Bitmap.Config r105);

    int getDebugFlags();

    int getFPS();

    int getRenderMode();

    s.a getViewType();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void queueEvent(Runnable r100);

    void requestRender();

    void setDebugFlags(int r100);

    void setFPS(int r100);

    void setRenderMode(int r100);

    void setRenderer(SurfaceRenderer r100);
}
