package s;

import K.V;
import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.adapter.CameraControlAdapter;
import androidx.camera.camera2.adapter.CameraInternalAdapter;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.State3AControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.UseCaseCameraImpl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.camera2.impl.UseCaseCameraState;
import androidx.camera.camera2.impl.UseCaseSurfaceManager;
import androidx.camera.core.impl.CameraInternal;
import i8.C4177a;
import java.util.Set;
import o.C4969a;
import o.C4978j;
import o.C4981m;
import o.C4984p;
import p.C5025g;
import r.C5185c;
import r.InterfaceC5183a;
import r.InterfaceC5194l;
import r.K;
import r.M;
import s.InterfaceC5426a;
import s.l;
import s.v;
import t.C0;
import t.C5493u;
import t.InterfaceC5495w;
import t.N;
import t.Q;
import t.S;
import t.i0;
import t.j0;
import t.y0;
import t.z0;
import u.C5563k;
import v.C5644a;
import w.InterfaceC5705k;

/* loaded from: classes.dex */
public final class u {

    public static final class b implements InterfaceC5426a.InterfaceC0518a {

        /* renamed from: a, reason: collision with root package name */
        public C5427b f39919a;

        public b() {
        }

        @Override // s.InterfaceC5426a.InterfaceC0518a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(C5427b c5427b) {
            this.f39919a = (C5427b) i8.c.b(c5427b);
            return this;
        }

        @Override // s.InterfaceC5426a.InterfaceC0518a
        public InterfaceC5426a build() {
            i8.c.a(this.f39919a, C5427b.class);
            return new c(this.f39919a);
        }
    }

    public static final class c implements InterfaceC5426a {

        /* renamed from: a, reason: collision with root package name */
        public final C5427b f39920a;

        /* renamed from: b, reason: collision with root package name */
        public final c f39921b = this;

        public c(C5427b c5427b) {
            this.f39920a = c5427b;
        }

        @Override // s.InterfaceC5426a
        public androidx.camera.camera2.pipe.h a() {
            return C5430e.a(this.f39920a);
        }

        @Override // s.InterfaceC5426a
        public InterfaceC5705k b() {
            return k.a(C5430e.a(this.f39920a));
        }

        @Override // s.InterfaceC5426a
        public l.a c() {
            return new d(this.f39921b);
        }

        public Q e() {
            C5427b c5427b = this.f39920a;
            return C5434i.a(c5427b, C5433h.a(c5427b));
        }
    }

    public static final class d implements l.a {

        /* renamed from: a, reason: collision with root package name */
        public final c f39922a;

        /* renamed from: b, reason: collision with root package name */
        public m f39923b;

        /* renamed from: c, reason: collision with root package name */
        public P.i f39924c;

        @Override // s.l.a
        public l build() {
            i8.c.a(this.f39923b, m.class);
            i8.c.a(this.f39924c, P.i.class);
            return new e(this.f39922a, this.f39923b, this.f39924c);
        }

        @Override // s.l.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d b(m mVar) {
            this.f39923b = (m) i8.c.b(mVar);
            return this;
        }

        @Override // s.l.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a(P.i iVar) {
            this.f39924c = (P.i) i8.c.b(iVar);
            return this;
        }

        public d(c cVar) {
            this.f39922a = cVar;
        }
    }

    public static final class e implements l {

        /* renamed from: A, reason: collision with root package name */
        public i8.d<CameraInternalAdapter> f39925A;

        /* renamed from: B, reason: collision with root package name */
        public i8.d<C4969a> f39926B;

        /* renamed from: C, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.impl.b> f39927C;

        /* renamed from: D, reason: collision with root package name */
        public i8.d<String> f39928D;

        /* renamed from: E, reason: collision with root package name */
        public i8.d<V> f39929E;

        /* renamed from: F, reason: collision with root package name */
        public i8.d<C5563k> f39930F;

        /* renamed from: G, reason: collision with root package name */
        public i8.d<C4978j> f39931G;

        /* renamed from: H, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.impl.c> f39932H;

        /* renamed from: I, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.impl.g> f39933I;

        /* renamed from: J, reason: collision with root package name */
        public i8.d<CameraControlAdapter> f39934J;

        /* renamed from: a, reason: collision with root package name */
        public final m f39935a;

        /* renamed from: b, reason: collision with root package name */
        public final P.i f39936b;

        /* renamed from: c, reason: collision with root package name */
        public final c f39937c;

        /* renamed from: d, reason: collision with root package name */
        public final e f39938d = this;

        /* renamed from: e, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.g> f39939e;

        /* renamed from: f, reason: collision with root package name */
        public i8.d<C5493u> f39940f;

        /* renamed from: g, reason: collision with root package name */
        public i8.d<o.Q> f39941g;

        /* renamed from: h, reason: collision with root package name */
        public i8.d<StreamConfigurationMap> f39942h;

        /* renamed from: i, reason: collision with root package name */
        public i8.d<r.y> f39943i;

        /* renamed from: j, reason: collision with root package name */
        public i8.d<p.q> f39944j;

        /* renamed from: k, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.compat.quirk.a> f39945k;

        /* renamed from: l, reason: collision with root package name */
        public i8.d<y0> f39946l;

        /* renamed from: m, reason: collision with root package name */
        public i8.d<State3AControl> f39947m;

        /* renamed from: n, reason: collision with root package name */
        public i8.d<N> f39948n;

        /* renamed from: o, reason: collision with root package name */
        public i8.d<LowLightBoostControl> f39949o;

        /* renamed from: p, reason: collision with root package name */
        public i8.d<p.o> f39950p;

        /* renamed from: q, reason: collision with root package name */
        public i8.d<S> f39951q;

        /* renamed from: r, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.impl.f> f39952r;

        /* renamed from: s, reason: collision with root package name */
        public i8.d<FlashControl> f39953s;

        /* renamed from: t, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.impl.d> f39954t;

        /* renamed from: u, reason: collision with root package name */
        public i8.d<StillCaptureRequestControl> f39955u;

        /* renamed from: v, reason: collision with root package name */
        public i8.d<z0> f39956v;

        /* renamed from: w, reason: collision with root package name */
        public i8.d<C0> f39957w;

        /* renamed from: x, reason: collision with root package name */
        public i8.d<C5025g> f39958x;

        /* renamed from: y, reason: collision with root package name */
        public i8.d<C5644a> f39959y;

        /* renamed from: z, reason: collision with root package name */
        public i8.d<C4981m> f39960z;

        public static final class a<T> implements i8.d<T> {

            /* renamed from: a, reason: collision with root package name */
            public final c f39961a;

            /* renamed from: b, reason: collision with root package name */
            public final e f39962b;

            /* renamed from: c, reason: collision with root package name */
            public final int f39963c;

            public a(c cVar, e eVar, int i10) {
                this.f39961a = cVar;
                this.f39962b = eVar;
                this.f39963c = i10;
            }

            @Override // X8.a
            public T get() {
                switch (this.f39963c) {
                    case 0:
                        return (T) new CameraInternalAdapter(n.a(this.f39962b.f39935a), this.f39962b.f39933I.get(), this.f39962b.f39931G.get(), this.f39962b.f39934J.get(), this.f39962b.f39946l.get(), this.f39962b.f39960z.get());
                    case 1:
                        androidx.camera.camera2.pipe.h hVarA = C5430e.a(this.f39961a.f39920a);
                        E.a aVarA = C5429d.a(this.f39961a.f39920a);
                        f fVar = new f(this.f39961a, this.f39962b);
                        o.Q q10 = this.f39962b.f39941g.get();
                        LowLightBoostControl lowLightBoostControl = this.f39962b.f39949o.get();
                        Set<j0> setI = this.f39962b.i();
                        C5644a c5644a = this.f39962b.f39959y.get();
                        C4981m c4981m = this.f39962b.f39960z.get();
                        e eVar = this.f39962b;
                        return (T) new androidx.camera.camera2.impl.g(hVarA, aVarA, fVar, q10, lowLightBoostControl, setI, c5644a, c4981m, eVar.f39925A, eVar.f39946l, eVar.f39931G, eVar.f39929E.get(), this.f39962b.f39940f.get(), C5432g.a(this.f39961a.f39920a), this.f39962b.f39932H.get(), C5433h.a(this.f39961a.f39920a), this.f39961a.e());
                    case 2:
                        return (T) t.a(this.f39962b.f39940f.get());
                    case 3:
                        return (T) new C5493u(n.a(this.f39962b.f39935a), this.f39962b.f39939e.get());
                    case 4:
                        return (T) o.INSTANCE.c(C5430e.a(this.f39961a.f39920a), n.a(this.f39962b.f39935a));
                    case 5:
                        return (T) new LowLightBoostControl(this.f39962b.f39939e.get(), this.f39962b.f39947m.get(), this.f39962b.f39946l.get(), this.f39962b.f39948n.get());
                    case 6:
                        return (T) new State3AControl(this.f39962b.f39940f.get(), this.f39962b.d(), this.f39962b.f39946l.get());
                    case 7:
                        return (T) new androidx.camera.camera2.compat.quirk.a(this.f39962b.f39939e.get(), this.f39962b.f39944j.get());
                    case 8:
                        return (T) new p.q(this.f39962b.f39942h.get(), this.f39962b.f39943i.get());
                    case 9:
                        return (T) o.INSTANCE.e(this.f39962b.f39939e.get());
                    case 10:
                        return (T) new r.y(this.f39962b.f39939e.get(), this.f39962b.f39942h.get());
                    case 11:
                        return (T) s.a(n.a(this.f39962b.f39935a), C5431f.a(this.f39961a.f39920a));
                    case 12:
                        return (T) new N();
                    case 13:
                        return (T) new S(this.f39962b.f39950p.get());
                    case 14:
                        return (T) new p.o(this.f39962b.f39940f.get(), this.f39962b.f39946l.get(), this.f39962b.f39948n.get());
                    case 15:
                        return (T) new FlashControl(this.f39962b.f39940f.get(), this.f39962b.f39947m.get(), this.f39962b.f39946l.get(), this.f39962b.f39952r.get(), this.f39962b.l());
                    case 16:
                        return (T) new androidx.camera.camera2.impl.f(this.f39962b.f39940f.get(), this.f39962b.f39947m.get(), this.f39962b.f39946l.get());
                    case 17:
                        return (T) new androidx.camera.camera2.impl.d(this.f39962b.f39940f.get(), this.f39962b.h(), this.f39962b.f39947m.get(), this.f39962b.f39946l.get(), this.f39962b.n());
                    case 18:
                        return (T) new StillCaptureRequestControl(this.f39962b.f39953s.get(), this.f39962b.f39946l.get());
                    case 19:
                        return (T) new z0();
                    case 20:
                        return (T) new C0(this.f39962b.n());
                    case 21:
                        return (T) p.a(this.f39962b.f39958x.get(), this.f39962b.f39946l.get(), this.f39962b.f39948n.get());
                    case 22:
                        return (T) new C5025g();
                    case 23:
                        return (T) new C4981m();
                    case 24:
                        return (T) new C4978j(this.f39962b.f39940f.get(), n.a(this.f39962b.f39935a), this.f39962b.f39960z.get(), this.f39962b.f39926B.get(), this.f39962b.f39927C.get(), this.f39962b.f39954t.get(), this.f39962b.f39945k.get(), this.f39962b.f39929E.get(), this.f39962b.f39944j.get(), this.f39962b.f39930F.get(), this.f39962b.f39936b);
                    case 25:
                        return (T) new C4969a(this.f39962b.f39957w.get(), this.f39962b.f39951q.get(), this.f39962b.f39952r.get(), this.f39962b.f39949o.get());
                    case 26:
                        return (T) new androidx.camera.camera2.impl.b();
                    case 27:
                        return (T) r.a(this.f39962b.f39928D.get(), this.f39962b.f39945k.get());
                    case 28:
                        return (T) q.a(n.a(this.f39962b.f39935a));
                    case 29:
                        return (T) new C5563k(this.f39961a.b());
                    case 30:
                        return (T) new androidx.camera.camera2.impl.c(this.f39962b.f39927C.get(), this.f39962b.f39948n.get(), n.a(this.f39962b.f39935a), this.f39962b.f39945k.get(), this.f39962b.f39941g.get(), this.f39962b.k(), this.f39962b.f39939e.get(), C5432g.a(this.f39961a.f39920a), C5428c.a(this.f39961a.f39920a));
                    case 31:
                        return (T) new CameraControlAdapter(this.f39962b.f39940f.get(), this.f39962b.f39951q.get(), this.f39962b.f39953s.get(), this.f39962b.f39954t.get(), this.f39962b.f39955u.get(), this.f39962b.f39952r.get(), this.f39962b.f39949o.get(), this.f39962b.f39957w.get(), this.f39962b.f39941g.get(), this.f39962b.f39959y.get(), this.f39962b.f39933I.get(), this.f39962b.f39946l.get(), this.f39962b.f39956v.get());
                    default:
                        throw new AssertionError(this.f39963c);
                }
            }
        }

        public e(c cVar, m mVar, P.i iVar) {
            this.f39937c = cVar;
            this.f39935a = mVar;
            this.f39936b = iVar;
            f(mVar, iVar);
            g(mVar, iVar);
        }

        @Override // s.l
        public CameraInternal a() {
            return this.f39925A.get();
        }

        public InterfaceC5183a d() {
            return C5185c.a(this.f39945k.get());
        }

        public InterfaceC5194l e() {
            return r.n.a(this.f39945k.get());
        }

        public final void f(m mVar, P.i iVar) {
            this.f39939e = i8.b.b(new a(this.f39937c, this.f39938d, 4));
            this.f39940f = i8.b.b(new a(this.f39937c, this.f39938d, 3));
            this.f39941g = i8.b.b(new a(this.f39937c, this.f39938d, 2));
            this.f39942h = i8.b.b(new a(this.f39937c, this.f39938d, 9));
            this.f39943i = i8.b.b(new a(this.f39937c, this.f39938d, 10));
            this.f39944j = i8.b.b(new a(this.f39937c, this.f39938d, 8));
            this.f39945k = i8.b.b(new a(this.f39937c, this.f39938d, 7));
            this.f39946l = i8.b.b(new a(this.f39937c, this.f39938d, 11));
            this.f39947m = i8.b.b(new a(this.f39937c, this.f39938d, 6));
            this.f39948n = i8.b.b(new a(this.f39937c, this.f39938d, 12));
            this.f39949o = i8.b.b(new a(this.f39937c, this.f39938d, 5));
            this.f39950p = i8.b.b(new a(this.f39937c, this.f39938d, 14));
            this.f39951q = i8.b.b(new a(this.f39937c, this.f39938d, 13));
            this.f39952r = i8.b.b(new a(this.f39937c, this.f39938d, 16));
            this.f39953s = i8.b.b(new a(this.f39937c, this.f39938d, 15));
            this.f39954t = i8.b.b(new a(this.f39937c, this.f39938d, 17));
            this.f39955u = i8.b.b(new a(this.f39937c, this.f39938d, 18));
            this.f39956v = i8.b.b(new a(this.f39937c, this.f39938d, 19));
            this.f39957w = i8.b.b(new a(this.f39937c, this.f39938d, 20));
            this.f39958x = i8.b.b(new a(this.f39937c, this.f39938d, 22));
            this.f39959y = i8.b.b(new a(this.f39937c, this.f39938d, 21));
            this.f39960z = i8.b.b(new a(this.f39937c, this.f39938d, 23));
            this.f39925A = new C4177a();
            this.f39926B = i8.b.b(new a(this.f39937c, this.f39938d, 25));
            this.f39927C = i8.b.b(new a(this.f39937c, this.f39938d, 26));
        }

        public final void g(m mVar, P.i iVar) {
            this.f39928D = i8.b.b(new a(this.f39937c, this.f39938d, 28));
            this.f39929E = i8.b.b(new a(this.f39937c, this.f39938d, 27));
            this.f39930F = i8.b.b(new a(this.f39937c, this.f39938d, 29));
            this.f39931G = i8.b.b(new a(this.f39937c, this.f39938d, 24));
            this.f39932H = i8.b.b(new a(this.f39937c, this.f39938d, 30));
            this.f39933I = i8.b.b(new a(this.f39937c, this.f39938d, 1));
            this.f39934J = i8.b.b(new a(this.f39937c, this.f39938d, 31));
            C4177a.a(this.f39925A, i8.b.b(new a(this.f39937c, this.f39938d, 0)));
        }

        public r.p h() {
            return r.q.a(this.f39945k.get());
        }

        public Set<j0> i() {
            return j();
        }

        public Set j() {
            i8.e eVarC = i8.e.c(9);
            eVarC.a(this.f39951q.get());
            eVarC.a(this.f39953s.get());
            eVarC.a(this.f39954t.get());
            eVarC.a(this.f39947m.get());
            eVarC.a(this.f39955u.get());
            eVarC.a(this.f39952r.get());
            eVarC.a(this.f39949o.get());
            eVarC.a(this.f39956v.get());
            eVarC.a(this.f39957w.get());
            return eVarC.b();
        }

        public r.E k() {
            return r.F.a(this.f39945k.get());
        }

        public r.H l() {
            return r.J.a(this.f39945k.get());
        }

        public K m() {
            return M.a(this.f39945k.get(), this.f39937c.b(), this.f39930F.get());
        }

        public p.t n() {
            return p.u.a(this.f39940f.get());
        }
    }

    public static final class f implements v.a {

        /* renamed from: a, reason: collision with root package name */
        public final c f39964a;

        /* renamed from: b, reason: collision with root package name */
        public final e f39965b;

        /* renamed from: c, reason: collision with root package name */
        public UseCaseCameraConfig f39966c;

        @Override // s.v.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(UseCaseCameraConfig useCaseCameraConfig) {
            this.f39966c = (UseCaseCameraConfig) i8.c.b(useCaseCameraConfig);
            return this;
        }

        @Override // s.v.a
        public v build() {
            i8.c.a(this.f39966c, UseCaseCameraConfig.class);
            return new g(this.f39964a, this.f39965b, this.f39966c);
        }

        public f(c cVar, e eVar) {
            this.f39964a = cVar;
            this.f39965b = eVar;
        }
    }

    public static final class g implements v {

        /* renamed from: a, reason: collision with root package name */
        public final UseCaseCameraConfig f39967a;

        /* renamed from: b, reason: collision with root package name */
        public final c f39968b;

        /* renamed from: c, reason: collision with root package name */
        public final e f39969c;

        /* renamed from: d, reason: collision with root package name */
        public final g f39970d = this;

        /* renamed from: e, reason: collision with root package name */
        public i8.d<J> f39971e;

        /* renamed from: f, reason: collision with root package name */
        public i8.d<K.z0> f39972f;

        /* renamed from: g, reason: collision with root package name */
        public i8.d<C4984p> f39973g;

        /* renamed from: h, reason: collision with root package name */
        public i8.d<UseCaseCameraState> f39974h;

        /* renamed from: i, reason: collision with root package name */
        public i8.d<CapturePipelineImpl> f39975i;

        /* renamed from: j, reason: collision with root package name */
        public i8.d<CapturePipelineTorchCorrection> f39976j;

        /* renamed from: k, reason: collision with root package name */
        public i8.d<InterfaceC5495w> f39977k;

        /* renamed from: l, reason: collision with root package name */
        public i8.d<SessionConfigAdapter> f39978l;

        /* renamed from: m, reason: collision with root package name */
        public i8.d<UseCaseSurfaceManager> f39979m;

        /* renamed from: n, reason: collision with root package name */
        public i8.d<UseCaseCameraRequestControlImpl> f39980n;

        /* renamed from: o, reason: collision with root package name */
        public i8.d<DeferredUseCaseCameraRequestControl> f39981o;

        /* renamed from: p, reason: collision with root package name */
        public i8.d<UseCaseCameraImpl> f39982p;

        public static final class a<T> implements i8.d<T> {

            /* renamed from: a, reason: collision with root package name */
            public final c f39983a;

            /* renamed from: b, reason: collision with root package name */
            public final e f39984b;

            /* renamed from: c, reason: collision with root package name */
            public final g f39985c;

            /* renamed from: d, reason: collision with root package name */
            public final int f39986d;

            public a(c cVar, e eVar, g gVar, int i10) {
                this.f39983a = cVar;
                this.f39984b = eVar;
                this.f39985c = gVar;
                this.f39986d = i10;
            }

            @Override // X8.a
            public T get() {
                switch (this.f39986d) {
                    case 0:
                        J j10 = this.f39985c.f39971e.get();
                        y0 y0Var = this.f39984b.f39946l.get();
                        K.z0 z0Var = this.f39985c.f39972f.get();
                        DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl = this.f39985c.f39981o.get();
                        g gVar = this.f39985c;
                        return (T) new UseCaseCameraImpl(j10, y0Var, z0Var, deferredUseCaseCameraRequestControl, gVar.f39979m, gVar.f39978l, gVar.f39977k);
                    case 1:
                        return (T) C5420B.a(this.f39985c.f39967a, this.f39984b.f39960z.get());
                    case 2:
                        return (T) this.f39985c.f39967a.getSessionProcessor();
                    case 3:
                        return (T) new DeferredUseCaseCameraRequestControl(this.f39985c.f39980n, this.f39984b.f39946l.get());
                    case 4:
                        g gVar2 = this.f39985c;
                        return (T) new UseCaseCameraRequestControlImpl(gVar2.f39977k, gVar2.f39974h, gVar2.f39971e.get(), this.f39985c.f39979m, this.f39984b.f39946l.get(), C5432g.a(this.f39983a.f39920a));
                    case 5:
                        g gVar3 = this.f39985c;
                        return (T) C5422D.a(gVar3.f39975i, gVar3.f39976j);
                    case 6:
                        C4984p c4984p = this.f39985c.f39973g.get();
                        FlashControl flashControl = this.f39984b.f39953s.get();
                        androidx.camera.camera2.impl.f fVar = this.f39984b.f39952r.get();
                        z0 z0Var2 = this.f39984b.f39956v.get();
                        y0 y0Var2 = this.f39984b.f39946l.get();
                        N n10 = this.f39984b.f39948n.get();
                        K kM = this.f39984b.m();
                        C5493u c5493u = this.f39984b.f39940f.get();
                        g gVar4 = this.f39985c;
                        return (T) new CapturePipelineImpl(c4984p, flashControl, fVar, z0Var2, y0Var2, n10, kM, c5493u, gVar4.f39974h, gVar4.f39971e.get());
                    case 7:
                        return (T) new C4984p(this.f39984b.f39940f.get(), this.f39985c.f39971e.get(), this.f39984b.f39941g.get(), this.f39984b.f39946l.get(), this.f39984b.k());
                    case 8:
                        return (T) new UseCaseCameraState(this.f39985c.f39971e.get(), this.f39984b.k());
                    case 9:
                        return (T) new CapturePipelineTorchCorrection(this.f39984b.f39940f.get(), this.f39985c.f39975i, this.f39984b.f39946l.get(), this.f39984b.f39952r.get());
                    case 10:
                        return (T) new UseCaseSurfaceManager(this.f39984b.f39946l.get(), C5430e.a(this.f39983a.f39920a), this.f39984b.e(), this.f39985c.f39978l.get());
                    case 11:
                        return (T) C5419A.a(this.f39985c.f39967a);
                    default:
                        throw new AssertionError(this.f39986d);
                }
            }
        }

        public g(c cVar, e eVar, UseCaseCameraConfig useCaseCameraConfig) {
            this.f39968b = cVar;
            this.f39969c = eVar;
            this.f39967a = useCaseCameraConfig;
            c(useCaseCameraConfig);
        }

        @Override // s.v
        public i0 a() {
            return this.f39982p.get();
        }

        public final void c(UseCaseCameraConfig useCaseCameraConfig) {
            this.f39971e = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 1));
            this.f39972f = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 2));
            this.f39973g = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 7));
            this.f39974h = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 8));
            this.f39975i = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 6));
            this.f39976j = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 9));
            this.f39977k = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 5));
            this.f39978l = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 11));
            this.f39979m = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 10));
            this.f39980n = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 4));
            this.f39981o = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 3));
            this.f39982p = i8.b.b(new a(this.f39968b, this.f39969c, this.f39970d, 0));
        }
    }

    public static InterfaceC5426a.InterfaceC0518a a() {
        return new b();
    }
}
