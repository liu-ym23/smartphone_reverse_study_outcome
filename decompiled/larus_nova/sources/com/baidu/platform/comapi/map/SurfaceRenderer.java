package com.baidu.platform.comapi.map;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes39.dex */
public interface SurfaceRenderer {
    void onDrawFrame(Object r100);

    void onSurfaceChanged(int r100, int r101);

    void onSurfaceCreated(SurfaceHolder r100, int r101, int r102, int r103);

    void onSurfaceDestroyed(SurfaceHolder r100);
}
