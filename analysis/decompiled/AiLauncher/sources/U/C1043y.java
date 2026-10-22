package U;

import D.C0761b0;
import W.d;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.processing.util.GLUtils;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: U.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1043y {

    /* renamed from: c, reason: collision with root package name */
    public Thread f6153c;

    /* renamed from: g, reason: collision with root package name */
    public EGLConfig f6157g;

    /* renamed from: i, reason: collision with root package name */
    public Surface f6159i;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f6151a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final Map<Surface, W.f> f6152b = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public EGLDisplay f6154d = EGL14.EGL_NO_DISPLAY;

    /* renamed from: e, reason: collision with root package name */
    public EGLContext f6155e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f, reason: collision with root package name */
    public int[] f6156f = GLUtils.f11667a;

    /* renamed from: h, reason: collision with root package name */
    public EGLSurface f6158h = EGL14.EGL_NO_SURFACE;

    /* renamed from: j, reason: collision with root package name */
    public Map<GLUtils.InputFormat, GLUtils.e> f6160j = Collections.EMPTY_MAP;

    /* renamed from: k, reason: collision with root package name */
    public GLUtils.e f6161k = null;

    /* renamed from: l, reason: collision with root package name */
    public GLUtils.InputFormat f6162l = GLUtils.InputFormat.UNKNOWN;

    /* renamed from: m, reason: collision with root package name */
    public int f6163m = -1;

    public final void a(int i10) {
        GLES20.glActiveTexture(33984);
        GLUtils.g("glActiveTexture");
        GLES20.glBindTexture(36197, i10);
        GLUtils.g("glBindTexture");
    }

    public final void b(D.B b10, d.a aVar) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f6154d = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f6154d, iArr, 0, iArr, 1)) {
            this.f6154d = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        if (aVar != null) {
            aVar.c(iArr[0] + "." + iArr[1]);
        }
        int i10 = b10.d() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f6154d, new int[]{12324, i10, 12323, i10, 12322, i10, 12321, b10.d() ? 2 : 8, 12325, 0, 12326, 0, 12352, b10.d() ? 64 : 4, 12610, b10.d() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f6154d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, b10.d() ? 3 : 2, 12344}, 0);
        GLUtils.f("eglCreateContext");
        this.f6157g = eGLConfig;
        this.f6155e = eGLContextEglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f6154d, eGLContextEglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    public W.f c(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.f6154d;
            EGLConfig eGLConfig = this.f6157g;
            Objects.requireNonNull(eGLConfig);
            EGLSurface eGLSurfaceQ = GLUtils.q(eGLDisplay, eGLConfig, surface, this.f6156f);
            Size sizeX = GLUtils.x(this.f6154d, eGLSurfaceQ);
            return W.f.d(eGLSurfaceQ, sizeX.getWidth(), sizeX.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e10) {
            C0761b0.p("OpenGlRenderer", "Failed to create EGL surface: " + e10.getMessage(), e10);
            return null;
        }
    }

    public final void d() {
        EGLDisplay eGLDisplay = this.f6154d;
        EGLConfig eGLConfig = this.f6157g;
        Objects.requireNonNull(eGLConfig);
        this.f6158h = GLUtils.n(eGLDisplay, eGLConfig, 1, 1);
    }

    public final B0.d<String, String> e(D.B b10) {
        GLUtils.i(this.f6151a, false);
        try {
            b(b10, null);
            d();
            i(this.f6158h);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString(this.f6154d, 12373);
            if (strGlGetString == null) {
                strGlGetString = "";
            }
            if (strEglQueryString == null) {
                strEglQueryString = "";
            }
            return new B0.d<>(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e10) {
            C0761b0.p("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e10.getMessage(), e10);
            return new B0.d<>("", "");
        } finally {
            l();
        }
    }

    public W.f f(Surface surface) {
        B0.h.i(this.f6152b.containsKey(surface), "The surface is not registered.");
        W.f fVar = this.f6152b.get(surface);
        Objects.requireNonNull(fVar);
        return fVar;
    }

    public int g() {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        return this.f6163m;
    }

    public W.d h(D.B b10, Map<GLUtils.InputFormat, B> map) {
        GLUtils.i(this.f6151a, false);
        d.a aVarA = W.d.a();
        try {
            if (b10.d()) {
                B0.d<String, String> dVarE = e(b10);
                String str = (String) B0.h.f(dVarE.f1411a);
                String str2 = (String) B0.h.f(dVarE.f1412b);
                if (!str.contains("GL_EXT_YUV_target")) {
                    C0761b0.o("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    b10 = D.B.f1998d;
                }
                this.f6156f = GLUtils.k(str2, b10);
                aVarA.d(str);
                aVarA.b(str2);
            }
            b(b10, aVarA);
            d();
            i(this.f6158h);
            aVarA.e(GLUtils.w());
            this.f6160j = GLUtils.o(b10, map);
            int iP = GLUtils.p();
            this.f6163m = iP;
            s(iP);
            this.f6153c = Thread.currentThread();
            this.f6151a.set(true);
            return aVarA.a();
        } catch (IllegalArgumentException | IllegalStateException e10) {
            l();
            throw e10;
        }
    }

    public void i(EGLSurface eGLSurface) {
        B0.h.f(this.f6154d);
        B0.h.f(this.f6155e);
        if (!EGL14.eglMakeCurrent(this.f6154d, eGLSurface, eGLSurface, this.f6155e)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    public void j(Surface surface) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        if (this.f6152b.containsKey(surface)) {
            return;
        }
        this.f6152b.put(surface, GLUtils.f11678l);
    }

    public void k() {
        if (this.f6151a.getAndSet(false)) {
            GLUtils.h(this.f6153c);
            l();
        }
    }

    public final void l() {
        Iterator<GLUtils.e> it = this.f6160j.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f6160j = Collections.EMPTY_MAP;
        this.f6161k = null;
        if (!Objects.equals(this.f6154d, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.f6154d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (W.f fVar : this.f6152b.values()) {
                if (!Objects.equals(fVar.a(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.f6154d, fVar.a())) {
                    GLUtils.e("eglDestroySurface");
                }
            }
            this.f6152b.clear();
            if (!Objects.equals(this.f6158h, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f6154d, this.f6158h);
                this.f6158h = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.f6155e, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.f6154d, this.f6155e);
                this.f6155e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f6154d);
            this.f6154d = EGL14.EGL_NO_DISPLAY;
        }
        this.f6157g = null;
        this.f6163m = -1;
        this.f6162l = GLUtils.InputFormat.UNKNOWN;
        this.f6159i = null;
        this.f6153c = null;
    }

    public void m(Surface surface, boolean z10) {
        if (this.f6159i == surface) {
            this.f6159i = null;
            i(this.f6158h);
        }
        W.f fVarRemove = z10 ? this.f6152b.remove(surface) : this.f6152b.put(surface, GLUtils.f11678l);
        if (fVarRemove == null || fVarRemove == GLUtils.f11678l) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.f6154d, fVarRemove.a());
        } catch (RuntimeException e10) {
            C0761b0.p("OpenGlRenderer", "Failed to destroy EGL surface: " + e10.getMessage(), e10);
        }
    }

    public void n(long j10, float[] fArr, Surface surface) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        W.f fVarF = f(surface);
        if (fVarF == GLUtils.f11678l) {
            fVarF = c(surface);
            if (fVarF == null) {
                return;
            } else {
                this.f6152b.put(surface, fVarF);
            }
        }
        if (surface != this.f6159i) {
            i(fVarF.a());
            this.f6159i = surface;
            GLES20.glViewport(0, 0, fVarF.c(), fVarF.b());
            GLES20.glScissor(0, 0, fVarF.c(), fVarF.b());
        }
        GLUtils.e eVar = (GLUtils.e) B0.h.f(this.f6161k);
        if (eVar instanceof GLUtils.f) {
            ((GLUtils.f) eVar).h(fArr);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.g("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.f6154d, fVarF.a(), j10);
        if (EGL14.eglSwapBuffers(this.f6154d, fVarF.a())) {
            return;
        }
        C0761b0.o("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        m(surface, false);
    }

    public void o(GLUtils.InputFormat inputFormat) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        if (this.f6162l != inputFormat) {
            this.f6162l = inputFormat;
            s(this.f6163m);
        }
    }

    public Bitmap p(Size size, float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        q(byteBufferAllocateDirect, size, fArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.j(bitmapCreateBitmap, byteBufferAllocateDirect, size.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    public final void q(ByteBuffer byteBuffer, Size size, float[] fArr) {
        B0.h.b(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        B0.h.b(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int iU = GLUtils.u();
        GLES20.glActiveTexture(33985);
        GLUtils.g("glActiveTexture");
        GLES20.glBindTexture(3553, iU);
        GLUtils.g("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, null);
        GLUtils.g("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int iT = GLUtils.t();
        GLES20.glBindFramebuffer(36160, iT);
        GLUtils.g("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iU, 0);
        GLUtils.g("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        GLUtils.g("glActiveTexture");
        GLES20.glBindTexture(36197, this.f6163m);
        GLUtils.g("glBindTexture");
        this.f6159i = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        GLUtils.e eVar = (GLUtils.e) B0.h.f(this.f6161k);
        if (eVar instanceof GLUtils.f) {
            ((GLUtils.f) eVar).h(fArr);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.g("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        GLUtils.g("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLUtils.s(iU);
        GLUtils.r(iT);
        a(this.f6163m);
    }

    public void r(Surface surface) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        m(surface, true);
    }

    public void s(int i10) {
        GLUtils.e eVar = this.f6160j.get(this.f6162l);
        if (eVar == null) {
            throw new IllegalStateException("Unable to configure program for input format: " + this.f6162l);
        }
        if (this.f6161k != eVar) {
            this.f6161k = eVar;
            eVar.f();
            Log.d("OpenGlRenderer", "Using program for input format " + this.f6162l + ": " + this.f6161k);
        }
        a(i10);
    }
}
