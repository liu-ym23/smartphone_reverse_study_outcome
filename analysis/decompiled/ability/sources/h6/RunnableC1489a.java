package h6;

import J9.e;
import M9.C0248b;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import f6.AbstractC1436a;

/* renamed from: h6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC1489a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4564a;
    public final /* synthetic */ C1490b b;

    public /* synthetic */ RunnableC1489a(C1490b c1490b, int i) {
        this.f4564a = i;
        this.b = c1490b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i6;
        int i10 = this.f4564a;
        C1490b c1490b = this.b;
        switch (i10) {
            case 0:
                boolean z10 = c1490b.l != EGL14.EGL_NO_SURFACE;
                AbstractC1436a.d("DebugOverlayFlow", "teardown begin: hadWindow=" + z10 + " currentExternal=" + c1490b.m, true);
                try {
                    SurfaceTexture surfaceTexture = c1490b.o;
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(null);
                    }
                    Surface surface = c1490b.p;
                    if (surface != null) {
                        surface.release();
                    }
                    SurfaceTexture surfaceTexture2 = c1490b.o;
                    if (surfaceTexture2 != null) {
                        surfaceTexture2.release();
                    }
                    e eVar = c1490b.f4569s;
                    if (eVar != null) {
                        Bitmap bitmap = (Bitmap) eVar.e;
                        int i11 = eVar.c;
                        if (i11 != 0) {
                            GLES20.glDeleteTextures(1, new int[]{i11}, 0);
                            eVar.c = 0;
                        }
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    c cVar = c1490b.f4567q;
                    if (cVar != null && (i6 = cVar.f4571a) != 0) {
                        GLES20.glDeleteProgram(i6);
                    }
                    C0248b c0248b = c1490b.f4568r;
                    if (c0248b != null && (i = c0248b.f977a) != 0) {
                        GLES20.glDeleteProgram(i);
                    }
                    int i12 = c1490b.n;
                    if (i12 != 0) {
                        GLES20.glDeleteTextures(1, new int[]{i12}, 0);
                    }
                    EGLSurface eGLSurface = c1490b.l;
                    if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                        EGL14.eglDestroySurface(c1490b.h, eGLSurface);
                    }
                    EGLSurface eGLSurface2 = c1490b.k;
                    if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                        EGL14.eglDestroySurface(c1490b.h, eGLSurface2);
                    }
                    EGLDisplay eGLDisplay = c1490b.h;
                    if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                        EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
                        EGLContext eGLContext = c1490b.i;
                        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(c1490b.h, eGLContext);
                        }
                        EGL14.eglTerminate(c1490b.h);
                    }
                    AbstractC1436a.d("DebugOverlayFlow", "teardown done", true);
                    return;
                } catch (Throwable th) {
                    AbstractC1436a.c("DebugOverlayFlow", "teardown failed: " + th.getMessage(), th);
                    return;
                }
            case 1:
                c1490b.getClass();
                try {
                    c1490b.b();
                    c1490b.a();
                    c1490b.c();
                    c1490b.f = true;
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            default:
                c1490b.u = true;
                c1490b.d();
                return;
        }
    }
}
