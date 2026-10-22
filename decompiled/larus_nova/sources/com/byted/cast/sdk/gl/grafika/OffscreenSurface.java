package com.byted.cast.sdk.gl.grafika;

/* JADX INFO: loaded from: classes43.dex */
public class OffscreenSurface extends EglSurfaceBase {
    public void release() {
        releaseEglSurface();
    }

    public OffscreenSurface(EglCore r100, int r101, int r102) {
        super(r100);
        createOffscreenSurface(r101, r102);
    }
}
