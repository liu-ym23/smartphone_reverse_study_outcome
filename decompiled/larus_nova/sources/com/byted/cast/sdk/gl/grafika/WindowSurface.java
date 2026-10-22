package com.byted.cast.sdk.gl.grafika;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: classes43.dex */
public class WindowSurface extends EglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public void release() {
        releaseEglSurface();
        Surface r100 = this.mSurface;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mReleaseSurface == false) goto L7;
        r100.release();
    L7:
        this.mSurface = null;
    }

    public void recreate(EglCore r100) {
        Surface r101 = this.mSurface;
        if (r101 == null) goto L7;
        this.mEglCore = r100;
        createWindowSurface(r101);
        return;
    L7:
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public WindowSurface(EglCore r100, SurfaceTexture r101) {
        super(r100);
        createWindowSurface(r101);
    }

    public WindowSurface(EglCore r100, Surface r101, boolean r102) {
        super(r100);
        createWindowSurface(r101);
        this.mSurface = r101;
        this.mReleaseSurface = r102;
    }
}
