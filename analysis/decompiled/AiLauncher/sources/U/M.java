package U;

import D.r0;
import U.M;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class M {

    /* renamed from: a, reason: collision with root package name */
    public final int f6034a;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f6035b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6036c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6037d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6038e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6039f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.camera.core.impl.y f6040g;

    /* renamed from: h, reason: collision with root package name */
    public int f6041h;

    /* renamed from: i, reason: collision with root package name */
    public int f6042i;

    /* renamed from: k, reason: collision with root package name */
    public SurfaceRequest f6044k;

    /* renamed from: l, reason: collision with root package name */
    public a f6045l;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6043j = false;

    /* renamed from: m, reason: collision with root package name */
    public final Set<Runnable> f6046m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    public boolean f6047n = false;

    /* renamed from: o, reason: collision with root package name */
    public final List<B0.a<SurfaceRequest.g>> f6048o = new ArrayList();

    public static class a extends DeferrableSurface {

        /* renamed from: o, reason: collision with root package name */
        public final InterfaceFutureC4095a<Surface> f6049o;

        /* renamed from: p, reason: collision with root package name */
        public CallbackToFutureAdapter.a<Surface> f6050p;

        /* renamed from: q, reason: collision with root package name */
        public DeferrableSurface f6051q;

        /* renamed from: r, reason: collision with root package name */
        public P f6052r;

        public a(Size size, int i10) {
            super(size, i10);
            this.f6049o = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: U.K
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return M.a.r(this.f6032a, aVar);
                }
            });
        }

        public static /* synthetic */ void q(a aVar) {
            P p10 = aVar.f6052r;
            if (p10 != null) {
                p10.m();
            }
            if (aVar.f6051q == null) {
                aVar.f6050p.d();
            }
            aVar.f6051q = null;
        }

        public static /* synthetic */ Object r(a aVar, CallbackToFutureAdapter.a aVar2) {
            aVar.f6050p = aVar2;
            return "SettableFuture hashCode: " + aVar.hashCode();
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public void d() {
            super.d();
            M.n.e(new Runnable() { // from class: U.J
                @Override // java.lang.Runnable
                public final void run() {
                    M.a.q(this.f6031a);
                }
            });
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public InterfaceFutureC4095a<Surface> o() {
            return this.f6049o;
        }

        public boolean s() {
            M.n.b();
            return this.f6051q == null && !m();
        }

        public void t(P p10) {
            B0.h.i(this.f6052r == null, "Consumer can only be linked once.");
            this.f6052r = p10;
        }

        public boolean u(final DeferrableSurface deferrableSurface, Runnable runnable) throws DeferrableSurface.SurfaceClosedException {
            M.n.b();
            B0.h.f(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.f6051q;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            B0.h.i(deferrableSurface2 == null, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            B0.h.b(h().equals(deferrableSurface.h()), String.format("The provider's size(%s) must match the parent(%s)", h(), deferrableSurface.h()));
            B0.h.b(i() == deferrableSurface.i(), String.format("The provider's format(%s) must match the parent(%s)", Integer.valueOf(i()), Integer.valueOf(deferrableSurface.i())));
            B0.h.i(!m(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.f6051q = deferrableSurface;
            O.f.j(deferrableSurface.j(), this.f6050p);
            deferrableSurface.l();
            k().a(new Runnable() { // from class: U.L
                @Override // java.lang.Runnable
                public final void run() {
                    deferrableSurface.e();
                }
            }, N.a.a());
            deferrableSurface.f().a(runnable, N.a.d());
            return true;
        }
    }

    public M(int i10, int i11, androidx.camera.core.impl.y yVar, Matrix matrix, boolean z10, Rect rect, int i12, int i13, boolean z11) {
        this.f6039f = i10;
        this.f6034a = i11;
        this.f6040g = yVar;
        this.f6035b = matrix;
        this.f6036c = z10;
        this.f6037d = rect;
        this.f6042i = i12;
        this.f6041h = i13;
        this.f6038e = z11;
        this.f6045l = new a(yVar.f(), i11);
    }

    public static /* synthetic */ void a(final M m10) {
        m10.getClass();
        N.a.d().execute(new Runnable() { // from class: U.H
            @Override // java.lang.Runnable
            public final void run() {
                M.b(this.f6029a);
            }
        });
    }

    public static /* synthetic */ void b(M m10) {
        if (m10.f6047n) {
            return;
        }
        m10.v();
    }

    public static /* synthetic */ void c(M m10, int i10, int i11) {
        boolean z10;
        boolean z11 = true;
        if (m10.f6042i != i10) {
            m10.f6042i = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (m10.f6041h != i11) {
            m10.f6041h = i11;
        } else {
            z11 = z10;
        }
        if (z11) {
            m10.x();
        }
    }

    public static /* synthetic */ InterfaceFutureC4095a d(M m10, final a aVar, int i10, r0.a aVar2, r0.a aVar3, Surface surface) {
        m10.getClass();
        B0.h.f(surface);
        try {
            aVar.l();
            P p10 = new P(surface, m10.t(), i10, m10.f6040g.f(), aVar2, aVar3, m10.f6035b);
            p10.l().a(new Runnable() { // from class: U.I
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.e();
                }
            }, N.a.a());
            aVar.t(p10);
            return O.f.h(p10);
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            return O.f.f(e10);
        }
    }

    public void e(Runnable runnable) {
        M.n.b();
        h();
        this.f6046m.add(runnable);
    }

    public void f(B0.a<SurfaceRequest.g> aVar) {
        B0.h.f(aVar);
        this.f6048o.add(aVar);
    }

    public final void g() {
        B0.h.i(!this.f6043j, "Consumer can only be linked once.");
        this.f6043j = true;
    }

    public final void h() {
        B0.h.i(!this.f6047n, "Edge is already closed.");
    }

    public final void i() {
        M.n.b();
        this.f6045l.d();
        this.f6047n = true;
        this.f6048o.clear();
        this.f6046m.clear();
    }

    public InterfaceFutureC4095a<r0> j(final int i10, final r0.a aVar, final r0.a aVar2) {
        M.n.b();
        h();
        g();
        final a aVar3 = this.f6045l;
        return O.f.o(aVar3.j(), new O.a() { // from class: U.F
            @Override // O.a
            public final InterfaceFutureC4095a apply(Object obj) {
                return M.d(this.f6021a, aVar3, i10, aVar, aVar2, (Surface) obj);
            }
        }, N.a.d());
    }

    public SurfaceRequest k(CameraInternal cameraInternal) {
        return l(cameraInternal, true);
    }

    public SurfaceRequest l(CameraInternal cameraInternal, boolean z10) {
        M.n.b();
        h();
        SurfaceRequest surfaceRequest = new SurfaceRequest(this.f6040g.f(), cameraInternal, z10, this.f6040g.b(), this.f6040g.g(), this.f6040g.c(), new Runnable() { // from class: U.C
            @Override // java.lang.Runnable
            public final void run() {
                M.a(this.f6018a);
            }
        });
        try {
            final DeferrableSurface deferrableSurfaceL = surfaceRequest.l();
            a aVar = this.f6045l;
            Objects.requireNonNull(aVar);
            if (aVar.u(deferrableSurfaceL, new D(aVar))) {
                InterfaceFutureC4095a<Void> interfaceFutureC4095aK = aVar.k();
                Objects.requireNonNull(deferrableSurfaceL);
                interfaceFutureC4095aK.a(new Runnable() { // from class: U.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        deferrableSurfaceL.d();
                    }
                }, N.a.a());
            }
            this.f6044k = surfaceRequest;
            x();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            throw new AssertionError("Surface is somehow already closed", e10);
        } catch (RuntimeException e11) {
            surfaceRequest.u();
            throw e11;
        }
    }

    public final void m() {
        M.n.b();
        h();
        this.f6045l.d();
    }

    public Rect n() {
        return this.f6037d;
    }

    public DeferrableSurface o() {
        M.n.b();
        h();
        g();
        return this.f6045l;
    }

    public int p() {
        return this.f6034a;
    }

    public int q() {
        return this.f6042i;
    }

    public Matrix r() {
        return this.f6035b;
    }

    public androidx.camera.core.impl.y s() {
        return this.f6040g;
    }

    public int t() {
        return this.f6039f;
    }

    public String toString() {
        return "SurfaceEdge{targets=" + this.f6039f + ", format=" + this.f6034a + ", resolution=" + this.f6040g.f() + ", cropRect=" + this.f6037d + ", rotationDegrees=" + this.f6042i + ", mirroring=" + this.f6038e + ", sensorToBufferTransform= " + this.f6035b + ", rotationInTransform= " + M.o.f(this.f6035b) + ", isMirrorInTransform= " + M.o.k(this.f6035b) + ", isClosed=" + this.f6047n + '}';
    }

    public boolean u() {
        return this.f6036c;
    }

    public void v() {
        M.n.b();
        h();
        if (this.f6045l.s()) {
            return;
        }
        this.f6043j = false;
        this.f6045l.d();
        this.f6045l = new a(this.f6040g.f(), this.f6034a);
        Iterator<Runnable> it = this.f6046m.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public boolean w() {
        return this.f6038e;
    }

    public final void x() {
        M.n.b();
        SurfaceRequest.g gVarG = SurfaceRequest.g.g(this.f6037d, this.f6042i, this.f6041h, u(), this.f6035b, this.f6038e);
        SurfaceRequest surfaceRequest = this.f6044k;
        if (surfaceRequest != null) {
            surfaceRequest.t(gVarG);
        }
        Iterator<B0.a<SurfaceRequest.g>> it = this.f6048o.iterator();
        while (it.hasNext()) {
            it.next().accept(gVarG);
        }
    }

    public void y(DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        M.n.b();
        h();
        a aVar = this.f6045l;
        Objects.requireNonNull(aVar);
        aVar.u(deferrableSurface, new D(aVar));
    }

    public void z(final int i10, final int i11) {
        M.n.e(new Runnable() { // from class: U.G
            @Override // java.lang.Runnable
            public final void run() {
                M.c(this.f6026a, i10, i11);
            }
        });
    }
}
