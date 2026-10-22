package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutputSurface {
    public OutputSurface() {
    }

    public abstract EGLSurface getEglSurface();

    public abstract int getHeight();

    public abstract int getWidth();

    public static OutputSurface of(EGLSurface r100, int r101, int r102) {
        return new AutoValue_OutputSurface(r100, r101, r102);
    }
}
