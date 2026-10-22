package com.byted.cast.sdk.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public interface IRenderView {
    public static final int AR_16_9_FIT_PARENT = 4;
    public static final int AR_4_3_FIT_PARENT = 5;
    public static final int AR_ASPECT_FILL_PARENT = 1;
    public static final int AR_ASPECT_FIT_PARENT = 0;
    public static final int AR_ASPECT_WRAP_CONTENT = 2;
    public static final int AR_MATCH_PARENT = 3;

    public interface IRenderCallback {
        void onSurfaceChanged(ISurfaceHolder r100, int r101, int r102, int r103);

        void onSurfaceCreated(ISurfaceHolder r100, int r101, int r102);

        void onSurfaceDestroyed(ISurfaceHolder r100);

        void onSurfaceTextureCreated(IRenderView r100, Surface r101);
    }

    public interface ISurfaceHolder {
        IRenderView getRenderView();

        SurfaceHolder getSurfaceHolder();

        SurfaceTexture getSurfaceTexture();

        Surface openSurface();
    }

    void addRenderCallback(IRenderCallback r100);

    View getView();

    void removeRenderCallback(IRenderCallback r100);

    void setAspectRatio(int r100);

    void setVideoRotation(int r100);

    void setVideoSampleAspectRatio(int r100, int r101);

    void setVideoSize(int r100, int r101);
}
