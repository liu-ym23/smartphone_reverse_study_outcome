package h6;

import I4.l;
import J9.e;
import M9.C0248b;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import ca.AbstractC0897f;
import f6.AbstractC1436a;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.k;

/* renamed from: h6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1490b {

    /* renamed from: a, reason: collision with root package name */
    public final int f4565a;
    public final int b;
    public Handler d;
    public volatile boolean f;
    public volatile boolean g;
    public EGLDisplay h;
    public EGLContext i;

    /* renamed from: j, reason: collision with root package name */
    public EGLConfig f4566j;
    public EGLSurface k;
    public EGLSurface l;
    public Surface m;
    public int n;
    public SurfaceTexture o;
    public Surface p;

    /* renamed from: q, reason: collision with root package name */
    public c f4567q;

    /* renamed from: r, reason: collision with root package name */
    public C0248b f4568r;

    /* renamed from: s, reason: collision with root package name */
    public e f4569s;

    /* renamed from: t, reason: collision with root package name */
    public final float[] f4570t;
    public volatile boolean u;
    public final HandlerThread c = new HandlerThread("DebugOverlayEgl");
    public final CountDownLatch e = new CountDownLatch(1);

    public C1490b(int i, int i6) {
        this.f4565a = i;
        this.b = i6;
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        k.e(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.h = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        k.e(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.i = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.k = EGL_NO_SURFACE;
        EGLSurface EGL_NO_SURFACE2 = EGL14.EGL_NO_SURFACE;
        k.e(EGL_NO_SURFACE2, "EGL_NO_SURFACE");
        this.l = EGL_NO_SURFACE2;
        this.f4570t = new float[16];
    }

    public final void a() {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.h, this.f4566j, new int[]{12375, 1, 12374, 1, 12344}, 0);
        k.e(eGLSurfaceEglCreatePbufferSurface, "eglCreatePbufferSurface(...)");
        this.k = eGLSurfaceEglCreatePbufferSurface;
        if (eGLSurfaceEglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("eglCreatePbufferSurface failed");
        }
        if (!EGL14.eglMakeCurrent(this.h, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, this.i)) {
            throw new IllegalStateException("eglMakeCurrent(pbuffer) failed");
        }
    }

    public final void b() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        k.e(eGLDisplayEglGetDisplay, "eglGetDisplay(...)");
        this.h = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new IllegalStateException("eglInitialize failed");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!EGL14.eglChooseConfig(this.h, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) || iArr2[0] <= 0) {
            throw new IllegalStateException("eglChooseConfig failed");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        k.c(eGLConfig);
        this.f4566j = eGLConfig;
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.h, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        k.e(eGLContextEglCreateContext, "eglCreateContext(...)");
        this.i = eGLContextEglCreateContext;
        if (eGLContextEglCreateContext == EGL14.EGL_NO_CONTEXT) {
            throw new IllegalStateException("eglCreateContext failed");
        }
    }

    public final void c() {
        this.f4567q = new c();
        this.f4568r = new C0248b();
        int i = this.f4565a;
        int i6 = this.b;
        this.f4569s = new e(i, i6);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i10 = iArr[0];
        this.n = i10;
        GLES20.glBindTexture(36197, i10);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.n);
        this.o = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(i, i6);
        SurfaceTexture surfaceTexture2 = this.o;
        if (surfaceTexture2 == null) {
            k.n("inputSurfaceTexture");
            throw null;
        }
        com.mdisdk.gles.a aVar = new com.mdisdk.gles.a(this, 1);
        Handler handler = this.d;
        if (handler == null) {
            k.n("handler");
            throw null;
        }
        surfaceTexture2.setOnFrameAvailableListener(aVar, handler);
        SurfaceTexture surfaceTexture3 = this.o;
        if (surfaceTexture3 != null) {
            this.p = new Surface(surfaceTexture3);
        } else {
            k.n("inputSurfaceTexture");
            throw null;
        }
    }

    public final void d() {
        SurfaceTexture surfaceTexture;
        if (this.u) {
            try {
                EGLDisplay eGLDisplay = this.h;
                EGLSurface eGLSurface = this.k;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.i);
                surfaceTexture = this.o;
            } catch (Throwable th) {
                AbstractC1436a.b("DebugOverlayEgl", "updateTexImage failed: " + th.getMessage(), true);
            }
            if (surfaceTexture == null) {
                k.n("inputSurfaceTexture");
                throw null;
            }
            surfaceTexture.updateTexImage();
            SurfaceTexture surfaceTexture2 = this.o;
            if (surfaceTexture2 == null) {
                k.n("inputSurfaceTexture");
                throw null;
            }
            surfaceTexture2.getTransformMatrix(this.f4570t);
            this.u = false;
            EGLSurface eGLSurface2 = this.l;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE && EGL14.eglMakeCurrent(this.h, eGLSurface2, eGLSurface2, this.i)) {
                GLES20.glViewport(0, 0, this.f4565a, this.b);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                c cVar = this.f4567q;
                if (cVar == null) {
                    k.n("oesProgram");
                    throw null;
                }
                int i = this.n;
                float[] texMat = this.f4570t;
                k.f(texMat, "texMat");
                GLES20.glUseProgram(cVar.f4571a);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i);
                GLES20.glUniform1i(cVar.e, 0);
                GLES20.glUniformMatrix4fv(cVar.d, 1, false, texMat, 0);
                cVar.f.position(0);
                GLES20.glVertexAttribPointer(cVar.b, 2, 5126, false, 0, (Buffer) cVar.f);
                int i6 = cVar.b;
                GLES20.glEnableVertexAttribArray(i6);
                cVar.g.position(0);
                GLES20.glVertexAttribPointer(cVar.c, 2, 5126, false, 0, (Buffer) cVar.g);
                int i10 = cVar.c;
                GLES20.glEnableVertexAttribArray(i10);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(i6);
                GLES20.glDisableVertexAttribArray(i10);
                e eVar = this.f4569s;
                if (eVar == null) {
                    k.n("cardRenderer");
                    throw null;
                }
                int i11 = eVar.c;
                if (i11 != 0) {
                    GLES20.glEnable(3042);
                    GLES20.glBlendFunc(770, 771);
                    C0248b c0248b = this.f4568r;
                    if (c0248b == null) {
                        k.n("overlayProgram");
                        throw null;
                    }
                    e eVar2 = this.f4569s;
                    if (eVar2 == null) {
                        k.n("cardRenderer");
                        throw null;
                    }
                    RectF ndcRect = (RectF) eVar2.d;
                    k.f(ndcRect, "ndcRect");
                    float[] fArr = (float[]) c0248b.g;
                    float f = ndcRect.left;
                    fArr[0] = f;
                    float f7 = ndcRect.bottom;
                    fArr[1] = f7;
                    float f9 = ndcRect.right;
                    fArr[2] = f9;
                    fArr[3] = f7;
                    fArr[4] = f;
                    float f10 = ndcRect.top;
                    fArr[5] = f10;
                    fArr[6] = f9;
                    fArr[7] = f10;
                    FloatBuffer floatBuffer = (FloatBuffer) c0248b.f;
                    floatBuffer.position(0);
                    floatBuffer.put(fArr);
                    floatBuffer.position(0);
                    GLES20.glUseProgram(c0248b.f977a);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, i11);
                    GLES20.glUniform1i(c0248b.d, 0);
                    GLES20.glVertexAttribPointer(c0248b.b, 2, 5126, false, 0, (Buffer) c0248b.f);
                    int i12 = c0248b.b;
                    GLES20.glEnableVertexAttribArray(i12);
                    ((FloatBuffer) c0248b.e).position(0);
                    GLES20.glVertexAttribPointer(c0248b.c, 2, 5126, false, 0, (Buffer) c0248b.e);
                    int i13 = c0248b.c;
                    GLES20.glEnableVertexAttribArray(i13);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(i12);
                    GLES20.glDisableVertexAttribArray(i13);
                    GLES20.glDisable(3042);
                }
                EGL14.eglSwapBuffers(this.h, this.l);
            }
        }
    }

    public final void e(Surface surface) {
        if (!this.g) {
            AbstractC1436a.e("DebugOverlayFlow", "setExternalSurface: thread not started, drop surface=" + surface, true);
            return;
        }
        AbstractC1436a.d("DebugOverlayFlow", "setExternalSurface(post async): surface=" + surface + " valid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null), true);
        Handler handler = this.d;
        if (handler != null) {
            handler.post(new l(17, this, surface));
        } else {
            k.n("handler");
            throw null;
        }
    }

    public final void f(Surface surface) {
        Surface surface2 = this.m;
        if (surface == surface2) {
            AbstractC1436a.a("DebugOverlayFlow", "switchExternalSurface: same as current, skip", true);
            return;
        }
        AbstractC1436a.d("DebugOverlayFlow", "switchExternalSurface: from=" + surface2 + " to=" + surface + " valid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null) + " hadWindow=" + (this.l != EGL14.EGL_NO_SURFACE), true);
        if (this.l != EGL14.EGL_NO_SURFACE) {
            EGLDisplay eGLDisplay = this.h;
            EGLSurface eGLSurface = this.k;
            boolean zEglMakeCurrent = EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.i);
            boolean zEglDestroySurface = EGL14.eglDestroySurface(this.h, this.l);
            int iEglGetError = EGL14.eglGetError();
            AbstractC0897f.r(16);
            String string = Integer.toString(iEglGetError, 16);
            k.e(string, "toString(...)");
            StringBuilder sb = new StringBuilder("switchExternalSurface: destroyed old window, makeCurrent(pbuffer)=");
            sb.append(zEglMakeCurrent);
            sb.append(" destroy=");
            sb.append(zEglDestroySurface);
            sb.append(" err=0x");
            com.stepos.statsrpk.service.c.r(sb, string, "DebugOverlayFlow", true);
            EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
            k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
            this.l = EGL_NO_SURFACE;
        }
        this.m = surface;
        if (surface == null || !surface.isValid()) {
            AbstractC1436a.d("DebugOverlayFlow", "switchExternalSurface: surface null/invalid, EGL window stays released", true);
            return;
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.h, this.f4566j, surface, new int[]{12344}, 0);
        k.e(eGLSurfaceEglCreateWindowSurface, "eglCreateWindowSurface(...)");
        this.l = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
            int iEglGetError2 = EGL14.eglGetError();
            AbstractC0897f.r(16);
            String string2 = Integer.toString(iEglGetError2, 16);
            k.e(string2, "toString(...)");
            AbstractC1436a.b("DebugOverlayFlow", "switchExternalSurface: eglCreateWindowSurface FAILED err=0x".concat(string2), true);
            this.m = null;
            return;
        }
        AbstractC1436a.d("DebugOverlayFlow", "switchExternalSurface: eglCreateWindowSurface OK, pendingFrame=" + this.u, true);
        if (this.u) {
            d();
        }
    }
}
