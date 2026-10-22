package org.libpag;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.Pair;
import android.view.Surface;
import gc.AbstractC4115a;

/* loaded from: classes5.dex */
public class PAGSurface {

    /* renamed from: a, reason: collision with root package name */
    private Surface f37894a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37895b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f37896c = 0;
    long nativeSurface;

    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    private PAGSurface(long j10) {
        this.nativeSurface = j10;
    }

    public static PAGSurface FromSurface(Surface surface) {
        return FromSurface(surface, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture) {
        return FromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromTexture(int i10, int i11, int i12) {
        return FromTexture(i10, i11, i12, false);
    }

    public static PAGSurface FromTextureForAsyncThread(int i10, int i11, int i12) {
        return FromTextureForAsyncThread(i10, i11, i12, false);
    }

    public static PAGSurface MakeOffscreen(int i10, int i11) {
        long jSetupOffscreen = SetupOffscreen(i10, i11);
        if (jSetupOffscreen == 0) {
            return null;
        }
        return new PAGSurface(jSetupOffscreen);
    }

    private static native long SetupFromSurfaceWithGLContext(Surface surface, long j10);

    public static native long SetupFromTexture(int i10, int i11, int i12, boolean z10, boolean z11);

    private static native long SetupOffscreen(int i10, int i11);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native boolean copyPixelsTo(Bitmap bitmap);

    public void finalize() {
        nativeFinalize();
    }

    public native void freeCache();

    public native int height();

    public Bitmap makeSnapshot() {
        Pair pairA = a.a(width(), height(), true);
        if (pairA.first == null) {
            return null;
        }
        Object obj = pairA.second;
        if (obj != null) {
            ((HardwareBuffer) obj).close();
        }
        if (copyPixelsTo((Bitmap) pairA.first)) {
            return (Bitmap) pairA.first;
        }
        return null;
    }

    public void release() {
        Surface surface;
        freeCache();
        if (this.f37895b && (surface = this.f37894a) != null) {
            surface.release();
        }
        nativeRelease();
    }

    public native void updateSize();

    public native int width();

    public static PAGSurface FromSurface(Surface surface, EGLContext eGLContext) {
        if (surface == null) {
            return null;
        }
        long jSetupFromSurfaceWithGLContext = SetupFromSurfaceWithGLContext(surface, (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) ? 0L : eGLContext.getNativeHandle());
        if (jSetupFromSurfaceWithGLContext == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromSurfaceWithGLContext);
        pAGSurface.f37894a = surface;
        return pAGSurface;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        PAGSurface pAGSurfaceFromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        if (pAGSurfaceFromSurface != null) {
            pAGSurfaceFromSurface.f37895b = true;
        }
        return pAGSurfaceFromSurface;
    }

    public static PAGSurface FromTexture(int i10, int i11, int i12, boolean z10) {
        long jSetupFromTexture = SetupFromTexture(i10, i11, i12, z10, false);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.f37896c = i10;
        return pAGSurface;
    }

    public static PAGSurface FromTextureForAsyncThread(int i10, int i11, int i12, boolean z10) {
        long jSetupFromTexture = SetupFromTexture(i10, i11, i12, z10, true);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.f37896c = i10;
        return pAGSurface;
    }
}
