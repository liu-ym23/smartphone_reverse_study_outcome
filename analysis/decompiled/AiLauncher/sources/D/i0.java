package D;

import K.InterfaceC0898v;
import X.c;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.z;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i0 extends UseCase {

    /* renamed from: D, reason: collision with root package name */
    public static final b f2117D = new b();

    /* renamed from: E, reason: collision with root package name */
    public static final Executor f2118E = N.a.d();

    /* renamed from: A, reason: collision with root package name */
    public SurfaceRequest f2119A;

    /* renamed from: B, reason: collision with root package name */
    public SurfaceProcessorNode f2120B;

    /* renamed from: C, reason: collision with root package name */
    public SessionConfig.c f2121C;

    /* renamed from: v, reason: collision with root package name */
    public c f2122v;

    /* renamed from: w, reason: collision with root package name */
    public Executor f2123w;

    /* renamed from: x, reason: collision with root package name */
    public SessionConfig.b f2124x;

    /* renamed from: y, reason: collision with root package name */
    public DeferrableSurface f2125y;

    /* renamed from: z, reason: collision with root package name */
    public U.M f2126z;

    public static final class a implements z.b<i0, androidx.camera.core.impl.w, a>, s.a<a> {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.camera.core.impl.u f2127a;

        public a() {
            this(androidx.camera.core.impl.u.k0());
        }

        public static a f(Config config) {
            return new a(androidx.camera.core.impl.u.l0(config));
        }

        @Override // D.C
        public androidx.camera.core.impl.t a() {
            return this.f2127a;
        }

        public i0 e() {
            androidx.camera.core.impl.w wVarD = d();
            androidx.camera.core.impl.s.y(wVarD);
            return new i0(wVarD);
        }

        @Override // androidx.camera.core.impl.z.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.w d() {
            return new androidx.camera.core.impl.w(androidx.camera.core.impl.v.j0(this.f2127a));
        }

        public a h(UseCaseConfigFactory.CaptureType captureType) {
            a().t(androidx.camera.core.impl.z.f11551L, captureType);
            return this;
        }

        public a i(B b10) {
            a().t(androidx.camera.core.impl.r.f11485p, b10);
            return this;
        }

        public a j(boolean z10) {
            a().t(androidx.camera.core.impl.z.f11550K, Boolean.valueOf(z10));
            return this;
        }

        public a k(X.c cVar) {
            a().t(androidx.camera.core.impl.s.f11494y, cVar);
            return this;
        }

        public a l(int i10) {
            a().t(androidx.camera.core.impl.z.f11544E, Integer.valueOf(i10));
            return this;
        }

        @Deprecated
        public a m(int i10) {
            if (i10 == -1) {
                i10 = 0;
            }
            a().t(androidx.camera.core.impl.s.f11486q, Integer.valueOf(i10));
            return this;
        }

        public a n(Class<i0> cls) {
            a().t(P.m.f5354c, cls);
            if (a().g(P.m.f5353b, null) == null) {
                o(cls.getCanonicalName() + O6.l.DATE_SEPARATOR + UUID.randomUUID());
            }
            return this;
        }

        public a o(String str) {
            a().t(P.m.f5353b, str);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        @Deprecated
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public a c(Size size) {
            a().t(androidx.camera.core.impl.s.f11490u, size);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a b(int i10) {
            a().t(androidx.camera.core.impl.s.f11487r, Integer.valueOf(i10));
            a().t(androidx.camera.core.impl.s.f11488s, Integer.valueOf(i10));
            return this;
        }

        public a(androidx.camera.core.impl.u uVar) {
            this.f2127a = uVar;
            Class cls = (Class) uVar.g(P.m.f5354c, null);
            if (cls != null && !cls.equals(i0.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            h(UseCaseConfigFactory.CaptureType.PREVIEW);
            n(i0.class);
            Config.a<Integer> aVar = androidx.camera.core.impl.s.f11489t;
            if (((Integer) uVar.g(aVar, -1)).intValue() == -1) {
                uVar.t(aVar, 2);
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final X.c f2128a;

        /* renamed from: b, reason: collision with root package name */
        public static final androidx.camera.core.impl.w f2129b;

        /* renamed from: c, reason: collision with root package name */
        public static final B f2130c;

        static {
            X.c cVarA = new c.a().d(X.a.f6804c).f(X.d.f6816c).a();
            f2128a = cVarA;
            B b10 = B.f1997c;
            f2130c = b10;
            f2129b = new a().l(2).m(0).k(cVarA).j(true).i(b10).d();
        }

        public androidx.camera.core.impl.w a() {
            return f2129b;
        }
    }

    public interface c {
        void a(SurfaceRequest surfaceRequest);
    }

    public i0(androidx.camera.core.impl.w wVar) {
        super(wVar);
        this.f2123w = f2118E;
    }

    public static /* synthetic */ void h0(i0 i0Var, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (i0Var.i() == null) {
            return;
        }
        i0Var.u0((androidx.camera.core.impl.w) i0Var.l(), i0Var.g());
        i0Var.L();
    }

    private void l0() {
        SessionConfig.c cVar = this.f2121C;
        if (cVar != null) {
            cVar.b();
            this.f2121C = null;
        }
        DeferrableSurface deferrableSurface = this.f2125y;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.f2125y = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.f2120B;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.f();
            this.f2120B = null;
        }
        U.M m10 = this.f2126z;
        if (m10 != null) {
            m10.i();
            this.f2126z = null;
        }
        SurfaceRequest surfaceRequest = this.f2119A;
        if (surfaceRequest != null) {
            surfaceRequest.k();
        }
        this.f2119A = null;
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> B() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public z.b<?, ?, ?> D(Config config) {
        return a.f(config);
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.z<?> P(InterfaceC0898v interfaceC0898v, z.b<?, ?, ?> bVar) {
        bVar.a().t(androidx.camera.core.impl.r.f11483n, 34);
        return bVar.d();
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.y T(Config config) {
        this.f2124x.g(config);
        e0(List.of(this.f2124x.o()));
        return g().i().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.y U(androidx.camera.core.impl.y yVar, androidx.camera.core.impl.y yVar2) {
        C0761b0.a("Preview", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + yVar + ", secondaryStreamSpec " + yVar2);
        u0((androidx.camera.core.impl.w) l(), yVar);
        return yVar;
    }

    @Override // androidx.camera.core.UseCase
    public void V() {
        l0();
    }

    @Override // androidx.camera.core.UseCase
    public void c0(Rect rect) {
        super.c0(rect);
        q0();
    }

    public final void k0(SessionConfig.b bVar, androidx.camera.core.impl.y yVar) {
        if (this.f2122v != null) {
            bVar.n(this.f2125y, yVar.b(), s(), q());
        }
        SessionConfig.c cVar = this.f2121C;
        if (cVar != null) {
            cVar.b();
        }
        SessionConfig.c cVar2 = new SessionConfig.c(new SessionConfig.d() { // from class: D.h0
            @Override // androidx.camera.core.impl.SessionConfig.d
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                i0.h0(this.f2108a, sessionConfig, sessionError);
            }
        });
        this.f2121C = cVar2;
        bVar.q(cVar2);
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.z<?> m(boolean z10, UseCaseConfigFactory useCaseConfigFactory) {
        b bVar = f2117D;
        Config configA = useCaseConfigFactory.a(bVar.a().V(), 1);
        if (z10) {
            configA = Config.X(configA, bVar.a());
        }
        if (configA == null) {
            return null;
        }
        return D(configA).d();
    }

    public final SessionConfig.b m0(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.y yVar) {
        M.n.b();
        CameraInternal cameraInternalI = i();
        Objects.requireNonNull(cameraInternalI);
        final CameraInternal cameraInternal = cameraInternalI;
        l0();
        B0.h.h(this.f2126z == null);
        Matrix matrixY = y();
        boolean zP = cameraInternal.p();
        Rect rectN0 = n0(yVar.f());
        Objects.requireNonNull(rectN0);
        this.f2126z = new U.M(1, 34, yVar, matrixY, zP, rectN0, u(cameraInternal, H(cameraInternal)), f(), t0(cameraInternal));
        AbstractC0772i abstractC0772iN = n();
        if (abstractC0772iN != null) {
            this.f2120B = new SurfaceProcessorNode(cameraInternal, abstractC0772iN.a(), "Preview");
            this.f2126z.e(new Runnable() { // from class: D.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2096a.L();
                }
            });
            W.e eVarJ = W.e.j(this.f2126z);
            U.M m10 = this.f2120B.j(SurfaceProcessorNode.b.c(this.f2126z, Collections.singletonList(eVarJ))).get(eVarJ);
            Objects.requireNonNull(m10);
            m10.e(new Runnable() { // from class: D.f0
                @Override // java.lang.Runnable
                public final void run() {
                    i0 i0Var = this.f2102a;
                    i0Var.o0(i0Var.f2126z, cameraInternal);
                }
            });
            this.f2119A = m10.k(cameraInternal);
            this.f2125y = this.f2126z.o();
        } else {
            this.f2126z.e(new Runnable() { // from class: D.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2096a.L();
                }
            });
            SurfaceRequest surfaceRequestK = this.f2126z.k(cameraInternal);
            this.f2119A = surfaceRequestK;
            this.f2125y = surfaceRequestK.l();
        }
        if (this.f2122v != null) {
            p0();
        }
        SessionConfig.b bVarP = SessionConfig.b.p(wVar, yVar.f());
        bVarP.w(yVar.g());
        b(bVarP, yVar);
        bVarP.v(wVar.F());
        if (yVar.d() != null) {
            bVarP.g(yVar.d());
        }
        k0(bVarP, yVar);
        return bVarP;
    }

    public final Rect n0(Size size) {
        if (E() != null) {
            return E();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    public final void o0(U.M m10, CameraInternal cameraInternal) {
        M.n.b();
        if (cameraInternal == i()) {
            m10.v();
        }
    }

    public final void p0() {
        q0();
        final c cVar = (c) B0.h.f(this.f2122v);
        final SurfaceRequest surfaceRequest = (SurfaceRequest) B0.h.f(this.f2119A);
        this.f2123w.execute(new Runnable() { // from class: D.g0
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(surfaceRequest);
            }
        });
    }

    public final void q0() {
        CameraInternal cameraInternalI = i();
        U.M m10 = this.f2126z;
        if (cameraInternalI == null || m10 == null) {
            return;
        }
        m10.z(u(cameraInternalI, H(cameraInternalI)), f());
    }

    public void r0(c cVar) {
        s0(f2118E, cVar);
    }

    public void s0(Executor executor, c cVar) {
        M.n.b();
        if (cVar == null) {
            this.f2122v = null;
            K();
            return;
        }
        this.f2122v = cVar;
        this.f2123w = executor;
        if (h() != null) {
            u0((androidx.camera.core.impl.w) l(), g());
            L();
        }
        J();
    }

    public final boolean t0(CameraInternal cameraInternal) {
        return cameraInternal.p() && H(cameraInternal);
    }

    public String toString() {
        return "Preview:" + r();
    }

    public final void u0(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.y yVar) {
        SessionConfig.b bVarM0 = m0(wVar, yVar);
        this.f2124x = bVarM0;
        e0(List.of(bVarM0.o()));
    }
}
