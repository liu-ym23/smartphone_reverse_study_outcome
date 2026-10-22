package com.obric.autogui.common.api.space.cc;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: CCSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCBackgroundSurface {
    private final Surface surface;
    private final SurfaceTexture texture;

    public CCBackgroundSurface() {
        SurfaceTexture r0 = new SurfaceTexture(false);
        this.texture = r0;
        this.surface = new Surface(r0);
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final void release() {
        this.texture.release();
        this.surface.release();
    }
}
