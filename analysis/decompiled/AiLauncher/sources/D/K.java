package D;

import D.H;
import K.InterfaceC0872a0;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.camera.core.ImageProcessingUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import g3.InterfaceFutureC4095a;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class K implements InterfaceC0872a0.a {

    /* renamed from: a, reason: collision with root package name */
    public H.a f2047a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f2048b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2049c;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f2051e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f2052f;

    /* renamed from: g, reason: collision with root package name */
    public Executor f2053g;

    /* renamed from: h, reason: collision with root package name */
    public androidx.camera.core.m f2054h;

    /* renamed from: i, reason: collision with root package name */
    public ImageWriter f2055i;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f2060n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f2061o;

    /* renamed from: p, reason: collision with root package name */
    public ByteBuffer f2062p;

    /* renamed from: q, reason: collision with root package name */
    public ByteBuffer f2063q;

    /* renamed from: r, reason: collision with root package name */
    public ByteBuffer f2064r;

    /* renamed from: s, reason: collision with root package name */
    public ByteBuffer f2065s;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f2050d = 1;

    /* renamed from: j, reason: collision with root package name */
    public Rect f2056j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    public Rect f2057k = new Rect();

    /* renamed from: l, reason: collision with root package name */
    public Matrix f2058l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public Matrix f2059m = new Matrix();

    /* renamed from: t, reason: collision with root package name */
    public final Object f2066t = new Object();

    /* renamed from: u, reason: collision with root package name */
    public boolean f2067u = true;

    public static /* synthetic */ void b(K k10, androidx.camera.core.i iVar, Matrix matrix, androidx.camera.core.i iVar2, Rect rect, H.a aVar, CallbackToFutureAdapter.a aVar2) {
        if (!k10.f2067u) {
            aVar2.f(new OperationCanceledException("ImageAnalysis is detached"));
            return;
        }
        p0 p0Var = new p0(iVar2, Z.b(iVar.Z0().e(), iVar.Z0().getTimestamp(), k10.f2051e ? 0 : k10.f2048b, matrix, iVar.Z0().a()));
        if (!rect.isEmpty()) {
            p0Var.S(rect);
        }
        aVar.b(p0Var);
        aVar2.c(null);
    }

    public static /* synthetic */ Object c(final K k10, Executor executor, final androidx.camera.core.i iVar, final Matrix matrix, final androidx.camera.core.i iVar2, final Rect rect, final H.a aVar, final CallbackToFutureAdapter.a aVar2) {
        k10.getClass();
        executor.execute(new Runnable() { // from class: D.J
            @Override // java.lang.Runnable
            public final void run() {
                K.b(this.f2040a, iVar, matrix, iVar2, rect, aVar, aVar2);
            }
        });
        return "analyzeImage";
    }

    public static androidx.camera.core.m h(int i10, int i11, int i12, int i13, int i14) {
        boolean z10 = i12 == 90 || i12 == 270;
        int i15 = z10 ? i11 : i10;
        if (!z10) {
            i10 = i11;
        }
        return new androidx.camera.core.m(Y.a(i15, i10, i13, i14));
    }

    public static Matrix j(int i10, int i11, int i12, int i13, int i14) {
        Matrix matrix = new Matrix();
        if (i14 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i10, i11), M.o.f4493a, Matrix.ScaleToFit.FILL);
            matrix.postRotate(i14);
            matrix.postConcat(M.o.b(new RectF(0.0f, 0.0f, i12, i13)));
        }
        return matrix;
    }

    public static Rect k(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @Override // K.InterfaceC0872a0.a
    public void a(InterfaceC0872a0 interfaceC0872a0) {
        try {
            androidx.camera.core.i iVarD = d(interfaceC0872a0);
            if (iVarD != null) {
                l(iVarD);
            }
        } catch (IllegalStateException e10) {
            C0761b0.d("ImageAnalysisAnalyzer", "Failed to acquire image.", e10);
        }
    }

    public abstract androidx.camera.core.i d(InterfaceC0872a0 interfaceC0872a0);

    public InterfaceFutureC4095a<Void> e(final androidx.camera.core.i iVar) throws Throwable {
        Object obj;
        final Executor executor;
        final H.a aVar;
        boolean z10;
        androidx.camera.core.m mVar;
        ImageWriter imageWriter;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        ByteBuffer byteBuffer5;
        ByteBuffer byteBuffer6;
        androidx.camera.core.i iVarO;
        androidx.camera.core.i iVar2;
        int i10 = this.f2051e ? this.f2048b : 0;
        Object obj2 = this.f2066t;
        synchronized (obj2) {
            try {
                try {
                    executor = this.f2053g;
                    aVar = this.f2047a;
                    z10 = this.f2051e && i10 != this.f2049c;
                    if (z10) {
                        n(iVar, i10);
                    }
                    if (this.f2051e || this.f2050d == 3) {
                        g(iVar);
                    }
                    try {
                        mVar = this.f2054h;
                        try {
                            imageWriter = this.f2055i;
                            byteBuffer = this.f2060n;
                            byteBuffer2 = this.f2061o;
                            byteBuffer3 = this.f2062p;
                            byteBuffer4 = this.f2063q;
                            byteBuffer5 = this.f2064r;
                            byteBuffer6 = this.f2065s;
                        } catch (Throwable th) {
                            th = th;
                            obj = obj2;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
        if (aVar == null || executor == null || !this.f2067u) {
            return O.f.f(new OperationCanceledException("No analyzer or executor currently set."));
        }
        if (mVar != null) {
            if (this.f2050d == 2) {
                iVarO = ImageProcessingUtil.g(iVar, mVar, byteBuffer, i10, this.f2052f);
            } else {
                if (this.f2050d == 1) {
                    if (this.f2052f) {
                        ImageProcessingUtil.c(iVar);
                    }
                    if (imageWriter != null && byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null) {
                        iVarO = ImageProcessingUtil.n(iVar, mVar, imageWriter, byteBuffer2, byteBuffer3, byteBuffer4, i10);
                    }
                }
                iVar2 = null;
            }
            iVar2 = iVarO;
        } else {
            if (this.f2050d == 3) {
                if (this.f2052f) {
                    ImageProcessingUtil.c(iVar);
                }
                if (byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null && byteBuffer5 != null && byteBuffer6 != null) {
                    iVarO = ImageProcessingUtil.o(iVar, byteBuffer2, byteBuffer3, byteBuffer4, byteBuffer5, byteBuffer6, i10);
                    iVar2 = iVarO;
                }
            }
            iVar2 = null;
        }
        boolean z11 = iVar2 == null;
        final androidx.camera.core.i iVar3 = z11 ? iVar : iVar2;
        final Rect rect = new Rect();
        final Matrix matrix = new Matrix();
        synchronized (this.f2066t) {
            if (z10 && !z11) {
                try {
                    m(iVar.getWidth(), iVar.getHeight(), iVar3.getWidth(), iVar3.getHeight());
                } finally {
                }
            }
            this.f2049c = i10;
            rect.set(this.f2057k);
            matrix.set(this.f2059m);
        }
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.I
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar2) {
                return K.c(this.f2033a, executor, iVar, matrix, iVar3, rect, aVar, aVar2);
            }
        });
    }

    public abstract void f();

    public final void g(androidx.camera.core.i iVar) {
        if (this.f2050d != 1 && this.f2050d != 3) {
            if (this.f2050d == 2 && this.f2060n == null) {
                this.f2060n = ByteBuffer.allocateDirect(iVar.getWidth() * iVar.getHeight() * 4);
                return;
            }
            return;
        }
        if (this.f2061o == null) {
            this.f2061o = ByteBuffer.allocateDirect(iVar.getWidth() * iVar.getHeight());
        }
        this.f2061o.position(0);
        if (this.f2062p == null) {
            this.f2062p = ByteBuffer.allocateDirect((iVar.getWidth() * iVar.getHeight()) / 4);
        }
        this.f2062p.position(0);
        if (this.f2063q == null) {
            this.f2063q = ByteBuffer.allocateDirect((iVar.getWidth() * iVar.getHeight()) / 4);
        }
        this.f2063q.position(0);
        if (this.f2050d == 3) {
            if (this.f2064r == null) {
                this.f2064r = ByteBuffer.allocateDirect(iVar.getWidth() * iVar.getHeight());
            }
            this.f2064r.position(0);
            if (this.f2065s == null) {
                this.f2065s = ByteBuffer.allocateDirect((iVar.getWidth() * iVar.getHeight()) / 2);
            }
            this.f2065s.position(0);
        }
    }

    public void i() {
        this.f2067u = false;
        f();
    }

    public abstract void l(androidx.camera.core.i iVar);

    public final void m(int i10, int i11, int i12, int i13) {
        Matrix matrixJ = j(i10, i11, i12, i13, this.f2048b);
        this.f2057k = k(this.f2056j, matrixJ);
        this.f2059m.setConcat(this.f2058l, matrixJ);
    }

    public final void n(androidx.camera.core.i iVar, int i10) {
        androidx.camera.core.m mVar = this.f2054h;
        if (mVar == null) {
            return;
        }
        mVar.j();
        this.f2054h = h(iVar.getWidth(), iVar.getHeight(), i10, this.f2054h.e(), this.f2054h.a());
        if (this.f2050d == 1) {
            ImageWriter imageWriter = this.f2055i;
            if (imageWriter != null) {
                Q.a.a(imageWriter);
            }
            this.f2055i = Q.a.c(this.f2054h.getSurface(), this.f2054h.a());
        }
    }

    public void o(Executor executor, H.a aVar) {
        if (aVar == null) {
            f();
        }
        synchronized (this.f2066t) {
            this.f2047a = aVar;
            this.f2053g = executor;
        }
    }

    public void p(boolean z10) {
        this.f2052f = z10;
    }

    public void q(int i10) {
        this.f2050d = i10;
    }

    public void r(boolean z10) {
        this.f2051e = z10;
    }

    public void s(androidx.camera.core.m mVar) {
        synchronized (this.f2066t) {
            this.f2054h = mVar;
        }
    }

    public void t(int i10) {
        this.f2048b = i10;
    }

    public void u(Matrix matrix) {
        synchronized (this.f2066t) {
            this.f2058l = matrix;
            this.f2059m = new Matrix(this.f2058l);
        }
    }

    public void v(Rect rect) {
        synchronized (this.f2066t) {
            this.f2056j = rect;
            this.f2057k = new Rect(this.f2056j);
        }
    }
}
