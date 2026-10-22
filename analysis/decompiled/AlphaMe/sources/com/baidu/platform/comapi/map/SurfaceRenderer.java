package com.baidu.platform.comapi.map;

import android.view.SurfaceHolder;

/* loaded from: classes.dex */
public interface SurfaceRenderer {
    void onDrawFrame(Object obj);

    void onSurfaceChanged(int i4, int i5);

    void onSurfaceCreated(SurfaceHolder surfaceHolder, int i4, int i5, int i6);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
