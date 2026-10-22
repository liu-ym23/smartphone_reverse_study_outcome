package org.libpag;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.view.Surface;

/* loaded from: classes.dex */
public class PAGSurface {

    /* renamed from: a, reason: collision with root package name */
    private Surface f19187a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f19188b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f19189c = 0;
    long nativeSurface;

    static {
        P4.a.a("pag");
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

    public static PAGSurface FromTexture(int i5, int i6, int i7) {
        return FromTexture(i5, i6, i7, false);
    }

    public static PAGSurface FromTextureForAsyncThread(int i5, int i6, int i7) {
        return FromTextureForAsyncThread(i5, i6, i7, false);
    }

    public static PAGSurface MakeOffscreen(int i5, int i6) {
        long jSetupOffscreen = SetupOffscreen(i5, i6);
        if (jSetupOffscreen == 0) {
            return null;
        }
        return new PAGSurface(jSetupOffscreen);
    }

    private static native long SetupFromSurfaceWithGLContext(Surface surface, long j5);

    public static native long SetupFromTexture(int i5, int i6, int i7, boolean z5, boolean z6);

    private static native long SetupOffscreen(int i5, int i6);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native boolean copyPixelsTo(Bitmap bitmap);

    protected void finalize() {
        nativeFinalize();
    }

    public native void freeCache();

    public native int height();

    public native Bitmap makeSnapshot();

    public void release() {
        Surface surface;
        if (this.f19188b && (surface = this.f19187a) != null) {
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
        pAGSurface.f19187a = surface;
        return pAGSurface;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        PAGSurface pAGSurfaceFromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        if (pAGSurfaceFromSurface != null) {
            pAGSurfaceFromSurface.f19188b = true;
        }
        return pAGSurfaceFromSurface;
    }

    public static PAGSurface FromTexture(int i5, int i6, int i7, boolean z5) {
        long jSetupFromTexture = SetupFromTexture(i5, i6, i7, z5, false);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.f19189c = i5;
        return pAGSurface;
    }

    public static PAGSurface FromTextureForAsyncThread(int i5, int i6, int i7, boolean z5) {
        long jSetupFromTexture = SetupFromTexture(i5, i6, i7, z5, true);
        if (jSetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(jSetupFromTexture);
        pAGSurface.f19189c = i5;
        return pAGSurface;
    }
}
