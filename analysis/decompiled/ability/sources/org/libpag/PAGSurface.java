package org.libpag;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.Pair;
import android.view.Surface;
import z2.l;

/* loaded from: classes4.dex */
public class PAGSurface {

    /* renamed from: a, reason: collision with root package name */
    private Surface f5504a = null;
    private boolean b = false;
    private int c = 0;
    long nativeSurface;

    static {
        l.j("pag");
        nativeInit();
    }

    private PAGSurface(long j5) {
        this.nativeSurface = j5;
    }

    public static PAGSurface FromSurface(Surface surface) {
        return FromSurface(surface, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture) {
        return FromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromTexture(int i, int i6, int i10) {
        return FromTexture(i, i6, i10, false);
    }

    public static PAGSurface FromTextureForAsyncThread(int i, int i6, int i10) {
        return FromTextureForAsyncThread(i, i6, i10, false);
    }

    public static PAGSurface MakeOffscreen(int i, int i6) {
        long jSetupOffscreen = SetupOffscreen(i, i6);
        if (jSetupOffscreen == 0) {
            return null;
        }
        return new PAGSurface(jSetupOffscreen);
    }

    private static native long SetupFromSurfaceWithGLContext(Surface surface, long j5);

    public static native long SetupFromTexture(int i, int i6, int i10, boolean z10, boolean z11);

    private static native long SetupOffscreen(int i, int i6);

    private void a() {
        Surface surface;
        if (!this.b || (surface = this.f5504a) == null) {
            return;
        }
        surface.release();
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native boolean copyPixelsTo(Bitmap bitmap);

    public void finalize() {
        a();
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
        freeCache();
        a();
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
        pAGSurface.f5504a = surface;
        return pAGSurface;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        PAGSurface pAGSurfaceFromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        if (pAGSurfaceFromSurface != null) {
            pAGSurfaceFromSurface.b = true;
        }
        return pAGSurfaceFromSurface;
    }

    public static PAGSurface FromTexture(int i, int i6, int i10, boolean z10) {
        long jSetupFromTexture = SetupFromTexture(i, i6, i10, z10, false);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.c = i;
        return pAGSurface;
    }

    public static PAGSurface FromTextureForAsyncThread(int i, int i6, int i10, boolean z10) {
        long jSetupFromTexture = SetupFromTexture(i, i6, i10, z10, true);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.c = i;
        return pAGSurface;
    }
}
