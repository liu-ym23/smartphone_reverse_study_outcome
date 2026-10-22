package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_OutputSurface extends OutputSurface {
    private final EGLSurface eglSurface;
    private final int height;
    private final int width;

    public int hashCode() {
        return ((((this.eglSurface.hashCode() ^ 1000003) * 1000003) ^ this.width) * 1000003) ^ this.height;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.eglSurface + ", width=" + this.width + ", height=" + this.height + i.f25855d;
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public EGLSurface getEglSurface() {
        return this.eglSurface;
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OutputSurface) == false) goto L16;
        OutputSurface r101 = (OutputSurface) r100;
        if (this.eglSurface.equals(r101.getEglSurface()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.width != r101.getWidth()) goto L14;
        if (this.height != r101.getHeight()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_OutputSurface(EGLSurface r100, int r101, int r102) {
        if (r100 == null) goto L7;
        this.eglSurface = r100;
        this.width = r101;
        this.height = r102;
        return;
    L7:
        throw new NullPointerException("Null eglSurface");
    }
}
