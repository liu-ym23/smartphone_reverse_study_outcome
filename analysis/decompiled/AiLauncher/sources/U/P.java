package U;

import D.C0761b0;
import D.r0;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class P implements r0 {

    /* renamed from: b, reason: collision with root package name */
    public final Surface f6057b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6058c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6059d;

    /* renamed from: e, reason: collision with root package name */
    public final Size f6060e;

    /* renamed from: f, reason: collision with root package name */
    public final r0.a f6061f;

    /* renamed from: g, reason: collision with root package name */
    public final r0.a f6062g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f6063h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f6064i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f6065j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f6066k;

    /* renamed from: l, reason: collision with root package name */
    public B0.a<r0.b> f6067l;

    /* renamed from: m, reason: collision with root package name */
    public Executor f6068m;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f6071p;

    /* renamed from: q, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f6072q;

    /* renamed from: r, reason: collision with root package name */
    public Matrix f6073r;

    /* renamed from: a, reason: collision with root package name */
    public final Object f6056a = new Object();

    /* renamed from: n, reason: collision with root package name */
    public boolean f6069n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6070o = false;

    public P(Surface surface, int i10, int i11, Size size, r0.a aVar, r0.a aVar2, Matrix matrix) {
        float[] fArr = new float[16];
        this.f6063h = fArr;
        float[] fArr2 = new float[16];
        this.f6064i = fArr2;
        float[] fArr3 = new float[16];
        this.f6065j = fArr3;
        float[] fArr4 = new float[16];
        this.f6066k = fArr4;
        this.f6057b = surface;
        this.f6058c = i10;
        this.f6059d = i11;
        this.f6060e = size;
        this.f6061f = aVar;
        this.f6062g = aVar2;
        this.f6073r = matrix;
        g(fArr, fArr3, aVar);
        g(fArr2, fArr4, aVar2);
        this.f6071p = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: U.N
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar3) {
                return P.b(this.f6053a, aVar3);
            }
        });
    }

    public static /* synthetic */ Object b(P p10, CallbackToFutureAdapter.a aVar) {
        p10.f6072q = aVar;
        return "SurfaceOutputImpl close future complete";
    }

    public static /* synthetic */ void e(P p10, AtomicReference atomicReference) {
        p10.getClass();
        ((B0.a) atomicReference.get()).accept(r0.b.c(0, p10));
    }

    public static void g(float[] fArr, float[] fArr2, r0.a aVar) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        if (aVar == null) {
            return;
        }
        M.k.d(fArr, 0.5f);
        M.k.c(fArr, aVar.e(), 0.5f, 0.5f);
        if (aVar.d()) {
            android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix matrixD = M.o.d(M.o.r(aVar.c()), M.o.r(M.o.o(aVar.c(), aVar.e())), aVar.e(), aVar.d());
        RectF rectF = new RectF(aVar.b());
        matrixD.mapRect(rectF);
        float width = rectF.left / r1.getWidth();
        float height = ((r1.getHeight() - rectF.height()) - rectF.top) / r1.getHeight();
        float fWidth = rectF.width() / r1.getWidth();
        float fHeight = rectF.height() / r1.getHeight();
        android.opengl.Matrix.translateM(fArr, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(fArr, 0, fWidth, fHeight, 1.0f);
        i(fArr2, aVar.a());
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    public static void i(float[] fArr, CameraInternal cameraInternal) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        M.k.d(fArr, 0.5f);
        if (cameraInternal != null) {
            B0.h.i(cameraInternal.p(), "Camera has no transform.");
            M.k.c(fArr, cameraInternal.a().e(), 0.5f, 0.5f);
            if (cameraInternal.j()) {
                android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    @Override // D.r0
    public void B0(float[] fArr, float[] fArr2) {
        x(fArr, fArr2, true);
    }

    @Override // D.r0
    public Surface Q(Executor executor, B0.a<r0.b> aVar) {
        boolean z10;
        synchronized (this.f6056a) {
            this.f6068m = executor;
            this.f6067l = aVar;
            z10 = this.f6069n;
        }
        if (z10) {
            m();
        }
        return this.f6057b;
    }

    @Override // D.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f6056a) {
            try {
                if (!this.f6070o) {
                    this.f6070o = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6072q.c(null);
    }

    @Override // D.r0
    public int getFormat() {
        return this.f6059d;
    }

    @Override // D.r0
    public Size getSize() {
        return this.f6060e;
    }

    public InterfaceFutureC4095a<Void> l() {
        return this.f6071p;
    }

    public void m() {
        Executor executor;
        B0.a<r0.b> aVar;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.f6056a) {
            try {
                if (this.f6068m == null || (aVar = this.f6067l) == null) {
                    this.f6069n = true;
                } else if (!this.f6070o) {
                    atomicReference.set(aVar);
                    executor = this.f6068m;
                    this.f6069n = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: U.O
                    @Override // java.lang.Runnable
                    public final void run() {
                        P.e(this.f6054a, atomicReference);
                    }
                });
            } catch (RejectedExecutionException e10) {
                C0761b0.b("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e10);
            }
        }
    }

    @Override // D.r0
    public void x(float[] fArr, float[] fArr2, boolean z10) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, z10 ? this.f6063h : this.f6064i, 0);
    }
}
