package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import com.baidu.platform.comapi.map.s;

/* loaded from: classes.dex */
interface r extends SurfaceHolder.Callback2 {
    Bitmap captureImageFromSurface(int i4, int i5, int i6, int i7, Object obj, Bitmap.Config config);

    int getDebugFlags();

    int getFPS();

    int getRenderMode();

    s.a getViewType();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void queueEvent(Runnable runnable);

    void requestRender();

    void setDebugFlags(int i4);

    void setFPS(int i4);

    void setRenderMode(int i4);

    void setRenderer(SurfaceRenderer surfaceRenderer);
}
