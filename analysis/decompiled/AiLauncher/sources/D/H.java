package D;

import K.C0874b0;
import K.InterfaceC0898v;
import X.c;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class H extends UseCase {

    /* renamed from: E, reason: collision with root package name */
    public static final d f2017E = new d();

    /* renamed from: F, reason: collision with root package name */
    public static final Boolean f2018F = null;

    /* renamed from: A, reason: collision with root package name */
    public Matrix f2019A;

    /* renamed from: B, reason: collision with root package name */
    public SessionConfig.b f2020B;

    /* renamed from: C, reason: collision with root package name */
    public DeferrableSurface f2021C;

    /* renamed from: D, reason: collision with root package name */
    public SessionConfig.c f2022D;

    /* renamed from: v, reason: collision with root package name */
    public final Object f2023v;

    /* renamed from: w, reason: collision with root package name */
    public K f2024w;

    /* renamed from: x, reason: collision with root package name */
    public Executor f2025x;

    /* renamed from: y, reason: collision with root package name */
    public a f2026y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f2027z;

    public interface a {
        default Size a() {
            return null;
        }

        void b(androidx.camera.core.i iVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static final class c implements s.a<c>, z.b<H, androidx.camera.core.impl.p, c> {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.camera.core.impl.u f2028a;

        public c() {
            this(androidx.camera.core.impl.u.k0());
        }

        public static c f(Config config) {
            return new c(androidx.camera.core.impl.u.l0(config));
        }

        @Override // D.C
        public androidx.camera.core.impl.t a() {
            return this.f2028a;
        }

        public H e() {
            androidx.camera.core.impl.p pVarD = d();
            androidx.camera.core.impl.s.y(pVarD);
            return new H(pVarD);
        }

        @Override // androidx.camera.core.impl.z.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.p d() {
            return new androidx.camera.core.impl.p(androidx.camera.core.impl.v.j0(this.f2028a));
        }

        public c h(int i10) {
            a().t(androidx.camera.core.impl.p.f11462S, Integer.valueOf(i10));
            return this;
        }

        public c i(UseCaseConfigFactory.CaptureType captureType) {
            a().t(androidx.camera.core.impl.z.f11551L, captureType);
            return this;
        }

        public c j(Size size) {
            a().t(androidx.camera.core.impl.s.f11491v, size);
            return this;
        }

        public c k(B b10) {
            if (!Objects.equals(B.f1998d, b10)) {
                throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
            }
            a().t(androidx.camera.core.impl.r.f11485p, b10);
            return this;
        }

        public c l(X.c cVar) {
            a().t(androidx.camera.core.impl.s.f11494y, cVar);
            return this;
        }

        public c m(int i10) {
            a().t(androidx.camera.core.impl.z.f11544E, Integer.valueOf(i10));
            return this;
        }

        @Deprecated
        public c n(int i10) {
            if (i10 == -1) {
                i10 = 0;
            }
            a().t(androidx.camera.core.impl.s.f11486q, Integer.valueOf(i10));
            return this;
        }

        public c o(Class<H> cls) {
            a().t(P.m.f5354c, cls);
            if (a().g(P.m.f5353b, null) == null) {
                p(cls.getCanonicalName() + O6.l.DATE_SEPARATOR + UUID.randomUUID());
            }
            return this;
        }

        public c p(String str) {
            a().t(P.m.f5353b, str);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        @Deprecated
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public c c(Size size) {
            a().t(androidx.camera.core.impl.s.f11490u, size);
            return this;
        }

        @Override // androidx.camera.core.impl.s.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public c b(int i10) {
            a().t(androidx.camera.core.impl.s.f11487r, Integer.valueOf(i10));
            return this;
        }

        public c(androidx.camera.core.impl.u uVar) {
            this.f2028a = uVar;
            Class cls = (Class) uVar.g(P.m.f5354c, null);
            if (cls == null || cls.equals(H.class)) {
                i(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
                o(H.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final Size f2029a;

        /* renamed from: b, reason: collision with root package name */
        public static final B f2030b;

        /* renamed from: c, reason: collision with root package name */
        public static final X.c f2031c;

        /* renamed from: d, reason: collision with root package name */
        public static final androidx.camera.core.impl.p f2032d;

        static {
            Size size = new Size(640, 480);
            f2029a = size;
            B b10 = B.f1998d;
            f2030b = b10;
            X.c cVarA = new c.a().d(X.a.f6804c).f(new X.d(T.c.f5825c, 1)).a();
            f2031c = cVarA;
            f2032d = new c().j(size).m(1).n(0).l(cVarA).k(b10).d();
        }

        public androidx.camera.core.impl.p a() {
            return f2032d;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public H(androidx.camera.core.impl.p pVar) {
        super(pVar);
        this.f2023v = new Object();
    }

    public static /* synthetic */ void h0(androidx.camera.core.m mVar, androidx.camera.core.m mVar2) {
        mVar.j();
        if (mVar2 != null) {
            mVar2.j();
        }
    }

    public static /* synthetic */ void i0(H h10, K k10, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (h10.i() == null) {
            return;
        }
        h10.m0();
        k10.f();
        SessionConfig.b bVarN0 = h10.n0(h10.k(), (androidx.camera.core.impl.p) h10.l(), (androidx.camera.core.impl.y) B0.h.f(h10.g()));
        h10.f2020B = bVarN0;
        h10.e0(List.of(bVarN0.o()));
        h10.L();
    }

    public static /* synthetic */ List k0(Size size, List list, int i10) {
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.contains(size)) {
            arrayList.remove(size);
            arrayList.add(0, size);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.UseCase
    public z.b<?, ?, ?> D(Config config) {
        return c.f(config);
    }

    @Override // androidx.camera.core.UseCase
    public boolean F() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.z<?> P(InterfaceC0898v interfaceC0898v, z.b<?, ?, ?> bVar) {
        final Size sizeA;
        synchronized (this.f2023v) {
            try {
                a aVar = this.f2026y;
                sizeA = aVar != null ? aVar.a() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sizeA == null) {
            return bVar.d();
        }
        if (interfaceC0898v.z(((Integer) bVar.a().g(androidx.camera.core.impl.s.f11487r, 0)).intValue()) % 180 == 90) {
            sizeA = new Size(sizeA.getHeight(), sizeA.getWidth());
        }
        androidx.camera.core.impl.z zVarD = bVar.d();
        Config.a<Size> aVar2 = androidx.camera.core.impl.s.f11490u;
        if (!zVarD.b(aVar2)) {
            bVar.a().t(aVar2, sizeA);
        }
        androidx.camera.core.impl.z zVarD2 = bVar.d();
        Config.a aVar3 = androidx.camera.core.impl.s.f11494y;
        if (zVarD2.b(aVar3)) {
            X.c cVar = (X.c) e().g(aVar3, null);
            c.a aVar4 = cVar == null ? new c.a() : c.a.b(cVar);
            if (cVar == null || cVar.d() == null) {
                aVar4.f(new X.d(sizeA, 1));
            }
            if (cVar == null) {
                aVar4.e(new X.b() { // from class: D.E
                    @Override // X.b
                    public final List a(List list, int i10) {
                        return H.k0(sizeA, list, i10);
                    }
                });
            }
            bVar.a().t(aVar3, aVar4.a());
        }
        return bVar.d();
    }

    @Override // androidx.camera.core.UseCase
    public void Q(int i10) {
        w0(i10);
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.y T(Config config) {
        this.f2020B.g(config);
        e0(List.of(this.f2020B.o()));
        return g().i().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.y U(androidx.camera.core.impl.y yVar, androidx.camera.core.impl.y yVar2) {
        C0761b0.a("ImageAnalysis", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + yVar + ", secondaryStreamSpec " + yVar2);
        SessionConfig.b bVarN0 = n0(k(), (androidx.camera.core.impl.p) l(), yVar);
        this.f2020B = bVarN0;
        e0(List.of(bVarN0.o()));
        return yVar;
    }

    @Override // androidx.camera.core.UseCase
    public void V() {
        m0();
        synchronized (this.f2023v) {
            this.f2024w.i();
            this.f2024w = null;
        }
    }

    @Override // androidx.camera.core.UseCase
    public void a0(Matrix matrix) {
        super.a0(matrix);
        synchronized (this.f2023v) {
            try {
                K k10 = this.f2024w;
                if (k10 != null) {
                    k10.u(matrix);
                }
                this.f2019A = matrix;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public void c0(Rect rect) {
        super.c0(rect);
        synchronized (this.f2023v) {
            try {
                K k10 = this.f2024w;
                if (k10 != null) {
                    k10.v(rect);
                }
                this.f2027z = rect;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l0() {
        synchronized (this.f2023v) {
            try {
                K k10 = this.f2024w;
                if (k10 != null) {
                    k10.o(null, null);
                }
                if (this.f2026y != null) {
                    K();
                }
                this.f2025x = null;
                this.f2026y = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.z<?> m(boolean z10, UseCaseConfigFactory useCaseConfigFactory) {
        d dVar = f2017E;
        Config configA = useCaseConfigFactory.a(dVar.a().V(), 1);
        if (z10) {
            configA = Config.X(configA, dVar.a());
        }
        if (configA == null) {
            return null;
        }
        return D(configA).d();
    }

    public void m0() {
        M.n.b();
        SessionConfig.c cVar = this.f2022D;
        if (cVar != null) {
            cVar.b();
            this.f2022D = null;
        }
        DeferrableSurface deferrableSurface = this.f2021C;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.f2021C = null;
        }
    }

    public SessionConfig.b n0(String str, androidx.camera.core.impl.p pVar, androidx.camera.core.impl.y yVar) {
        final K k10;
        M.n.b();
        Size sizeF = yVar.f();
        Executor executor = (Executor) B0.h.f(pVar.d0(N.a.b()));
        boolean z10 = true;
        int iP0 = o0() == 1 ? p0() : 4;
        final androidx.camera.core.m mVar = pVar.j0() != null ? new androidx.camera.core.m(pVar.j0().a(sizeF.getWidth(), sizeF.getHeight(), p(), iP0, 0L)) : new androidx.camera.core.m(Y.a(sizeF.getWidth(), sizeF.getHeight(), p(), iP0));
        synchronized (this.f2023v) {
            u0();
            k10 = this.f2024w;
        }
        boolean zS0 = i() != null ? s0(i()) : false;
        int height = zS0 ? sizeF.getHeight() : sizeF.getWidth();
        int width = zS0 ? sizeF.getWidth() : sizeF.getHeight();
        int i10 = r0() == 2 ? 1 : 35;
        boolean z11 = p() == 35 && r0() == 2;
        boolean z12 = p() == 35 && r0() == 3;
        if (p() != 35 || ((i() == null || t(i()) == 0) && !Boolean.TRUE.equals(q0()))) {
            z10 = false;
        }
        final androidx.camera.core.m mVar2 = (z11 || (z10 && !z12)) ? new androidx.camera.core.m(Y.a(height, width, i10, mVar.a())) : null;
        if (mVar2 != null) {
            k10.s(mVar2);
        }
        x0();
        mVar.b(k10, executor);
        SessionConfig.b bVarP = SessionConfig.b.p(pVar, yVar.f());
        if (yVar.d() != null) {
            bVarP.g(yVar.d());
        }
        DeferrableSurface deferrableSurface = this.f2021C;
        if (deferrableSurface != null) {
            deferrableSurface.d();
        }
        C0874b0 c0874b0 = new C0874b0(mVar.getSurface(), sizeF, p());
        this.f2021C = c0874b0;
        c0874b0.k().a(new Runnable() { // from class: D.F
            @Override // java.lang.Runnable
            public final void run() {
                H.h0(mVar, mVar2);
            }
        }, N.a.d());
        bVarP.w(yVar.g());
        b(bVarP, yVar);
        bVarP.n(this.f2021C, yVar.b(), null, -1);
        SessionConfig.c cVar = this.f2022D;
        if (cVar != null) {
            cVar.b();
        }
        SessionConfig.c cVar2 = new SessionConfig.c(new SessionConfig.d() { // from class: D.G
            @Override // androidx.camera.core.impl.SessionConfig.d
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                H.i0(this.f2015a, k10, sessionConfig, sessionError);
            }
        });
        this.f2022D = cVar2;
        bVarP.q(cVar2);
        return bVarP;
    }

    public int o0() {
        return ((androidx.camera.core.impl.p) l()).h0(0);
    }

    public int p0() {
        return ((androidx.camera.core.impl.p) l()).i0(6);
    }

    public Boolean q0() {
        return ((androidx.camera.core.impl.p) l()).k0(f2018F);
    }

    public int r0() {
        return ((androidx.camera.core.impl.p) l()).l0(1);
    }

    public final boolean s0(CameraInternal cameraInternal) {
        return t0() && t(cameraInternal) % 180 != 0;
    }

    public boolean t0() {
        return ((androidx.camera.core.impl.p) l()).m0(Boolean.FALSE).booleanValue();
    }

    public String toString() {
        return "ImageAnalysis:" + r();
    }

    public final void u0() {
        a aVar;
        synchronized (this.f2023v) {
            try {
                androidx.camera.core.impl.p pVar = (androidx.camera.core.impl.p) l();
                if (pVar.h0(0) == 1) {
                    this.f2024w = new L();
                } else {
                    this.f2024w = new androidx.camera.core.h(pVar.d0(N.a.b()));
                }
                this.f2024w.q(r0());
                this.f2024w.r(t0());
                CameraInternal cameraInternalI = i();
                Boolean boolQ0 = q0();
                boolean zA = cameraInternalI != null ? cameraInternalI.i().s().a(OnePixelShiftQuirk.class) : false;
                K k10 = this.f2024w;
                if (boolQ0 != null) {
                    zA = boolQ0.booleanValue();
                }
                k10.p(zA);
                if (cameraInternalI != null) {
                    this.f2024w.t(t(cameraInternalI));
                }
                Rect rect = this.f2027z;
                if (rect != null) {
                    this.f2024w.v(rect);
                }
                Matrix matrix = this.f2019A;
                if (matrix != null) {
                    this.f2024w.u(matrix);
                }
                Executor executor = this.f2025x;
                if (executor != null && (aVar = this.f2026y) != null) {
                    this.f2024w.o(executor, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v0(Executor executor, final a aVar) {
        synchronized (this.f2023v) {
            try {
                K k10 = this.f2024w;
                if (k10 != null) {
                    k10.o(executor, new a() { // from class: D.D
                        @Override // D.H.a
                        public final void b(androidx.camera.core.i iVar) {
                            aVar.b(iVar);
                        }
                    });
                }
                if (this.f2026y == null) {
                    J();
                }
                this.f2025x = executor;
                this.f2026y = aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w0(int i10) {
        if (b0(i10)) {
            x0();
        }
    }

    public final void x0() {
        synchronized (this.f2023v) {
            try {
                CameraInternal cameraInternalI = i();
                if (cameraInternalI != null) {
                    this.f2024w.t(t(cameraInternalI));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
