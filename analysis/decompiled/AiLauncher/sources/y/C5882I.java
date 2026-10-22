package y;

import A.GraphProcessor;
import A.StreamGraph;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl;
import androidx.camera.camera2.pipe.compat.Camera2Backend;
import androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCache;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl;
import androidx.camera.camera2.pipe.compat.Camera2MetadataCache;
import androidx.camera.camera2.pipe.compat.CameraStateOpener;
import androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager;
import androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.CameraGraphImpl;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.h;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.camera.camera2.pipe.t;
import i8.C4177a;
import java.util.List;
import w.C5711q;
import w.InterfaceC5700f;
import w.InterfaceC5702h;
import w.InterfaceC5703i;
import w.InterfaceC5705k;
import x.C5806b0;
import x.C5810d0;
import x.J0;
import x.r0;
import x.s0;
import y.InterfaceC5890a;
import y.InterfaceC5901l;

/* renamed from: y.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5882I {

    /* renamed from: y.I$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public C5906q f43640a;

        /* renamed from: b, reason: collision with root package name */
        public a0 f43641b;

        public InterfaceC5905p a() {
            i8.c.a(this.f43640a, C5906q.class);
            i8.c.a(this.f43641b, a0.class);
            return new g(this.f43640a, this.f43641b);
        }

        public b b(C5906q c5906q) {
            this.f43640a = (C5906q) i8.c.b(c5906q);
            return this;
        }

        public b c(a0 a0Var) {
            this.f43641b = (a0) i8.c.b(a0Var);
            return this;
        }

        public b() {
        }
    }

    /* renamed from: y.I$c */
    public static final class c implements InterfaceC5890a.InterfaceC0552a {

        /* renamed from: a, reason: collision with root package name */
        public final g f43642a;

        /* renamed from: b, reason: collision with root package name */
        public C5891b f43643b;

        @Override // y.InterfaceC5890a.InterfaceC0552a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(C5891b c5891b) {
            this.f43643b = (C5891b) i8.c.b(c5891b);
            return this;
        }

        @Override // y.InterfaceC5890a.InterfaceC0552a
        public InterfaceC5890a build() {
            i8.c.a(this.f43643b, C5891b.class);
            return new d(this.f43642a, this.f43643b);
        }

        public c(g gVar) {
            this.f43642a = gVar;
        }
    }

    /* renamed from: y.I$d */
    public static final class d implements InterfaceC5890a {

        /* renamed from: a, reason: collision with root package name */
        public final C5891b f43644a;

        /* renamed from: b, reason: collision with root package name */
        public final g f43645b;

        /* renamed from: c, reason: collision with root package name */
        public final d f43646c = this;

        /* renamed from: d, reason: collision with root package name */
        public i8.d<Ua.M> f43647d;

        /* renamed from: e, reason: collision with root package name */
        public i8.d<B.f> f43648e;

        /* renamed from: f, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.f> f43649f;

        /* renamed from: g, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.e> f43650g;

        /* renamed from: h, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.g> f43651h;

        /* renamed from: i, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.i> f43652i;

        /* renamed from: j, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.c> f43653j;

        /* renamed from: k, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.compat.r> f43654k;

        /* renamed from: l, reason: collision with root package name */
        public i8.d<Camera2CameraController> f43655l;

        /* renamed from: y.I$d$a */
        public static final class a<T> implements i8.d<T> {

            /* renamed from: a, reason: collision with root package name */
            public final g f43656a;

            /* renamed from: b, reason: collision with root package name */
            public final d f43657b;

            /* renamed from: c, reason: collision with root package name */
            public final int f43658c;

            public a(g gVar, d dVar, int i10) {
                this.f43656a = gVar;
                this.f43657b = dVar;
                this.f43658c = i10;
            }

            @Override // X8.a
            public T get() {
                switch (this.f43658c) {
                    case 0:
                        return (T) new Camera2CameraController(this.f43657b.f43647d.get(), this.f43656a.f43691f.get(), this.f43656a.f43700o.get(), C5892c.a(this.f43657b.f43644a), C5894e.a(this.f43657b.f43644a), C5897h.a(this.f43657b.f43644a), this.f43657b.f43648e.get(), this.f43657b.f43654k.get(), this.f43657b.d(), this.f43656a.f43706u.get(), this.f43656a.f43711z.get(), this.f43656a.f43701p.get(), this.f43656a.f43698m.get(), C5893d.a(this.f43657b.f43644a), C5895f.a(this.f43657b.f43644a), C5896g.a(this.f43657b.f43644a), this.f43656a.f43685A.get());
                    case 1:
                        return (T) C5900k.a(this.f43656a.f43691f.get(), this.f43656a.f43689d.get());
                    case 2:
                        g gVar = this.f43656a;
                        return (T) C5899j.a(gVar.f43692g, gVar.f43691f.get(), C5892c.a(this.f43657b.f43644a), this.f43656a.f43689d.get());
                    case 3:
                        d dVar = this.f43657b;
                        return (T) x.Q.a(dVar.f43649f, dVar.f43650g, dVar.f43651h, dVar.f43652i, dVar.f43653j, C5892c.a(dVar.f43644a));
                    case 4:
                        return (T) new androidx.camera.camera2.pipe.compat.f(this.f43656a.f43691f.get(), C5896g.a(this.f43657b.f43644a), C5892c.a(this.f43657b.f43644a));
                    case 5:
                        return (T) new androidx.camera.camera2.pipe.compat.e(C5896g.a(this.f43657b.f43644a), this.f43656a.f43691f.get());
                    case 6:
                        return (T) new androidx.camera.camera2.pipe.compat.g(this.f43656a.f43691f.get(), C5896g.a(this.f43657b.f43644a), C5892c.a(this.f43657b.f43644a));
                    case 7:
                        return (T) new androidx.camera.camera2.pipe.compat.i(this.f43656a.f43691f.get(), C5892c.a(this.f43657b.f43644a), C5896g.a(this.f43657b.f43644a));
                    case 8:
                        return (T) new androidx.camera.camera2.pipe.compat.c(this.f43656a.f43691f.get(), C5892c.a(this.f43657b.f43644a), C5896g.a(this.f43657b.f43644a), this.f43656a.f43699n.get(), this.f43656a.f43700o.get());
                    default:
                        throw new AssertionError(this.f43658c);
                }
            }
        }

        public d(g gVar, C5891b c5891b) {
            this.f43645b = gVar;
            this.f43644a = c5891b;
            c(c5891b);
        }

        @Override // y.InterfaceC5890a
        public InterfaceC5703i a() {
            return this.f43655l.get();
        }

        public final void c(C5891b c5891b) {
            this.f43647d = i8.b.b(new a(this.f43645b, this.f43646c, 1));
            this.f43648e = i8.b.b(new a(this.f43645b, this.f43646c, 2));
            this.f43649f = new a(this.f43645b, this.f43646c, 4);
            this.f43650g = new a(this.f43645b, this.f43646c, 5);
            this.f43651h = new a(this.f43645b, this.f43646c, 6);
            this.f43652i = new a(this.f43645b, this.f43646c, 7);
            this.f43653j = new a(this.f43645b, this.f43646c, 8);
            this.f43654k = i8.b.b(new a(this.f43645b, this.f43646c, 3));
            this.f43655l = i8.b.b(new a(this.f43645b, this.f43646c, 0));
        }

        public J0 d() {
            return new J0(this.f43645b.f43691f.get(), C5892c.a(this.f43644a), C5896g.a(this.f43644a), this.f43645b.f43701p.get(), this.f43645b.f43700o.get());
        }
    }

    /* renamed from: y.I$e */
    public static final class e implements InterfaceC5901l.a {

        /* renamed from: a, reason: collision with root package name */
        public final g f43659a;

        /* renamed from: b, reason: collision with root package name */
        public C5902m f43660b;

        @Override // y.InterfaceC5901l.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(C5902m c5902m) {
            this.f43660b = (C5902m) i8.c.b(c5902m);
            return this;
        }

        @Override // y.InterfaceC5901l.a
        public InterfaceC5901l build() {
            i8.c.a(this.f43660b, C5902m.class);
            return new f(this.f43659a, this.f43660b);
        }

        public e(g gVar) {
            this.f43659a = gVar;
        }
    }

    /* renamed from: y.I$f */
    public static final class f implements InterfaceC5901l {

        /* renamed from: a, reason: collision with root package name */
        public final C5902m f43661a;

        /* renamed from: b, reason: collision with root package name */
        public final g f43662b;

        /* renamed from: c, reason: collision with root package name */
        public final f f43663c = this;

        /* renamed from: d, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.b> f43664d;

        /* renamed from: e, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.g> f43665e;

        /* renamed from: f, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.graph.c> f43666f;

        /* renamed from: g, reason: collision with root package name */
        public i8.d<GraphProcessor> f43667g;

        /* renamed from: h, reason: collision with root package name */
        public i8.d<StreamGraph> f43668h;

        /* renamed from: i, reason: collision with root package name */
        public i8.d<InterfaceC5703i> f43669i;

        /* renamed from: j, reason: collision with root package name */
        public i8.d<A.r> f43670j;

        /* renamed from: k, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.internal.a> f43671k;

        /* renamed from: l, reason: collision with root package name */
        public i8.d<z.s> f43672l;

        /* renamed from: m, reason: collision with root package name */
        public i8.d<androidx.camera.camera2.pipe.internal.b> f43673m;

        /* renamed from: n, reason: collision with root package name */
        public i8.d<List<t.a>> f43674n;

        /* renamed from: o, reason: collision with root package name */
        public i8.d<GraphSessionLock> f43675o;

        /* renamed from: p, reason: collision with root package name */
        public i8.d<Ua.M> f43676p;

        /* renamed from: q, reason: collision with root package name */
        public i8.d<B.d> f43677q;

        /* renamed from: r, reason: collision with root package name */
        public i8.d<B.e> f43678r;

        /* renamed from: s, reason: collision with root package name */
        public i8.d<A.j> f43679s;

        /* renamed from: t, reason: collision with root package name */
        public i8.d<Controller3A> f43680t;

        /* renamed from: u, reason: collision with root package name */
        public i8.d<CameraGraphImpl> f43681u;

        /* renamed from: y.I$f$a */
        public static final class a<T> implements i8.d<T> {

            /* renamed from: a, reason: collision with root package name */
            public final g f43682a;

            /* renamed from: b, reason: collision with root package name */
            public final f f43683b;

            /* renamed from: c, reason: collision with root package name */
            public final int f43684c;

            public a(g gVar, f fVar, int i10) {
                this.f43682a = gVar;
                this.f43683b = fVar;
                this.f43684c = i10;
            }

            @Override // X8.a
            public T get() {
                switch (this.f43684c) {
                    case 0:
                        return (T) new CameraGraphImpl(C5903n.a(this.f43683b.f43661a), this.f43683b.f43665e.get(), this.f43683b.f43667g.get(), this.f43683b.f43667g.get(), this.f43683b.f43668h.get(), this.f43683b.f43670j.get(), this.f43683b.f43669i.get(), this.f43683b.f43673m.get(), this.f43683b.f43671k.get(), this.f43682a.f43703r.get(), C5904o.a(this.f43683b.f43661a), this.f43683b.f43677q.get(), this.f43683b.f43678r.get(), this.f43683b.f43675o.get(), this.f43683b.f43676p.get(), this.f43683b.f43680t.get());
                    case 1:
                        return (T) C5886M.a(C5903n.a(this.f43683b.f43661a), this.f43683b.f43664d.get());
                    case 2:
                        return (T) C5884K.a(this.f43682a.f43708w.get(), C5903n.a(this.f43683b.f43661a), this.f43682a.f43710y.get());
                    case 3:
                        return (T) new GraphProcessor(this.f43682a.f43691f.get(), C5904o.a(this.f43683b.f43661a), C5903n.a(this.f43683b.f43661a), this.f43683b.f43666f.get(), this.f43683b.f43674n.get(), this.f43682a.f43701p.get());
                    case 4:
                        return (T) new androidx.camera.camera2.pipe.graph.c();
                    case 5:
                        return (T) Q.a(C5903n.a(this.f43683b.f43661a), this.f43683b.f43666f.get(), this.f43683b.f43673m.get());
                    case 6:
                        return (T) C5889P.a(this.f43683b.f43668h.get(), this.f43683b.f43671k.get(), this.f43683b.f43665e.get(), this.f43683b.f43672l.get());
                    case 7:
                        return (T) new StreamGraph(this.f43683b.f43665e.get(), C5903n.a(this.f43683b.f43661a), this.f43682a.p(), this.f43683b.f43669i);
                    case 8:
                        return (T) C5885L.a(C5904o.a(this.f43683b.f43661a), C5903n.a(this.f43683b.f43661a), this.f43683b.f43664d.get(), this.f43682a.f43710y.get(), this.f43683b.f43667g.get(), this.f43683b.f43668h.get(), this.f43683b.f43670j.get());
                    case 9:
                        return (T) S.a(this.f43683b.f43668h.get(), this.f43683b.f43669i, this.f43682a.f43711z.get());
                    case 10:
                        return (T) new androidx.camera.camera2.pipe.internal.a();
                    case 11:
                        return (T) T.a();
                    case 12:
                        return (T) new B.d(this.f43683b.f43675o.get(), this.f43683b.f43667g.get(), this.f43683b.f43676p.get());
                    case 13:
                        return (T) new GraphSessionLock();
                    case 14:
                        return (T) C5888O.a(this.f43682a.f43691f.get(), this.f43682a.f43689d.get());
                    case 15:
                        return (T) new B.e(this.f43683b.f43675o.get(), this.f43683b.f43667g.get(), this.f43683b.f43676p.get());
                    case 16:
                        return (T) new Controller3A(this.f43683b.f43667g.get(), this.f43683b.f43665e.get(), this.f43683b.f43679s.get(), this.f43683b.f43666f.get());
                    case 17:
                        return (T) new A.j();
                    default:
                        throw new AssertionError(this.f43684c);
                }
            }
        }

        public f(g gVar, C5902m c5902m) {
            this.f43662b = gVar;
            this.f43661a = c5902m;
            c(c5902m);
        }

        @Override // y.InterfaceC5901l
        public CameraGraph a() {
            return this.f43681u.get();
        }

        public final void c(C5902m c5902m) {
            this.f43664d = i8.b.b(new a(this.f43662b, this.f43663c, 2));
            this.f43665e = i8.b.b(new a(this.f43662b, this.f43663c, 1));
            this.f43666f = i8.b.b(new a(this.f43662b, this.f43663c, 4));
            this.f43667g = new C4177a();
            this.f43668h = new C4177a();
            this.f43669i = new C4177a();
            this.f43670j = i8.b.b(new a(this.f43662b, this.f43663c, 9));
            C4177a.a(this.f43669i, i8.b.b(new a(this.f43662b, this.f43663c, 8)));
            C4177a.a(this.f43668h, i8.b.b(new a(this.f43662b, this.f43663c, 7)));
            this.f43671k = i8.b.b(new a(this.f43662b, this.f43663c, 10));
            this.f43672l = i8.b.b(new a(this.f43662b, this.f43663c, 11));
            this.f43673m = i8.b.b(new a(this.f43662b, this.f43663c, 6));
            this.f43674n = i8.b.b(new a(this.f43662b, this.f43663c, 5));
            C4177a.a(this.f43667g, i8.b.b(new a(this.f43662b, this.f43663c, 3)));
            this.f43675o = i8.b.b(new a(this.f43662b, this.f43663c, 13));
            this.f43676p = i8.b.b(new a(this.f43662b, this.f43663c, 14));
            this.f43677q = i8.b.b(new a(this.f43662b, this.f43663c, 12));
            this.f43678r = i8.b.b(new a(this.f43662b, this.f43663c, 15));
            this.f43679s = i8.b.b(new a(this.f43662b, this.f43663c, 17));
            this.f43680t = i8.b.b(new a(this.f43662b, this.f43663c, 16));
            this.f43681u = i8.b.b(new a(this.f43662b, this.f43663c, 0));
        }
    }

    /* renamed from: y.I$g */
    public static final class g implements InterfaceC5905p {

        /* renamed from: A, reason: collision with root package name */
        public i8.d<r0> f43685A;

        /* renamed from: a, reason: collision with root package name */
        public final C5906q f43686a;

        /* renamed from: b, reason: collision with root package name */
        public final a0 f43687b;

        /* renamed from: c, reason: collision with root package name */
        public final g f43688c = this;

        /* renamed from: d, reason: collision with root package name */
        public i8.d<kotlinx.coroutines.g> f43689d;

        /* renamed from: e, reason: collision with root package name */
        public i8.d<CameraPipeLifetime> f43690e;

        /* renamed from: f, reason: collision with root package name */
        public i8.d<Threads> f43691f;

        /* renamed from: g, reason: collision with root package name */
        public i8.d<CameraManager> f43692g;

        /* renamed from: h, reason: collision with root package name */
        public i8.d<PackageManager> f43693h;

        /* renamed from: i, reason: collision with root package name */
        public i8.d<C5806b0> f43694i;

        /* renamed from: j, reason: collision with root package name */
        public i8.d<Z.f> f43695j;

        /* renamed from: k, reason: collision with root package name */
        public i8.d<Camera2DeviceCache> f43696k;

        /* renamed from: l, reason: collision with root package name */
        public i8.d<z.m> f43697l;

        /* renamed from: m, reason: collision with root package name */
        public i8.d<z.t> f43698m;

        /* renamed from: n, reason: collision with root package name */
        public i8.d<Camera2MetadataCache> f43699n;

        /* renamed from: o, reason: collision with root package name */
        public i8.d<w.S> f43700o;

        /* renamed from: p, reason: collision with root package name */
        public i8.d<C5810d0> f43701p;

        /* renamed from: q, reason: collision with root package name */
        public i8.d<s0> f43702q;

        /* renamed from: r, reason: collision with root package name */
        public i8.d<AudioRestrictionControllerImpl> f43703r;

        /* renamed from: s, reason: collision with root package name */
        public i8.d<RetryingCameraStateOpenerImpl> f43704s;

        /* renamed from: t, reason: collision with root package name */
        public i8.d<Camera2DeviceCloserImpl> f43705t;

        /* renamed from: u, reason: collision with root package name */
        public i8.d<PruningCamera2DeviceManager> f43706u;

        /* renamed from: v, reason: collision with root package name */
        public i8.d<Camera2Backend> f43707v;

        /* renamed from: w, reason: collision with root package name */
        public i8.d<InterfaceC5700f> f43708w;

        /* renamed from: x, reason: collision with root package name */
        public i8.d<B.b> f43709x;

        /* renamed from: y, reason: collision with root package name */
        public i8.d<InterfaceC5702h> f43710y;

        /* renamed from: z, reason: collision with root package name */
        public i8.d<C5711q> f43711z;

        /* renamed from: y.I$g$a */
        public static final class a<T> implements i8.d<T> {

            /* renamed from: a, reason: collision with root package name */
            public final g f43712a;

            /* renamed from: b, reason: collision with root package name */
            public final int f43713b;

            public a(g gVar, int i10) {
                this.f43712a = gVar;
                this.f43713b = i10;
            }

            @Override // X8.a
            public T get() {
                switch (this.f43713b) {
                    case 0:
                        return (T) new CameraPipeLifetime(this.f43712a.f43689d.get());
                    case 1:
                        return (T) C5876C.a();
                    case 2:
                        return (T) new B.b(this.f43712a.f43708w.get());
                    case 3:
                        h.Config configA = C5907s.a(this.f43712a.f43686a);
                        g gVar = this.f43712a;
                        return (T) C5912x.a(configA, gVar.f43707v, gVar.m(), this.f43712a.f43691f.get(), this.f43712a.f43690e.get());
                    case 4:
                        return (T) new Camera2Backend(this.f43712a.f43691f.get(), this.f43712a.f43696k.get(), this.f43712a.f43699n.get(), this.f43712a.f43706u.get(), new c(this.f43712a), this.f43712a.m());
                    case 5:
                        return (T) b0.a(this.f43712a.f43687b, this.f43712a.f43690e.get(), this.f43712a.f43689d.get());
                    case 6:
                        g gVar2 = this.f43712a;
                        i8.d<CameraManager> dVar = gVar2.f43692g;
                        Threads threads = gVar2.f43691f.get();
                        Context contextM = this.f43712a.m();
                        PackageManager packageManager = this.f43712a.f43693h.get();
                        C5806b0 c5806b0 = this.f43712a.f43694i.get();
                        g gVar3 = this.f43712a;
                        return (T) new Camera2DeviceCache(dVar, threads, contextM, packageManager, c5806b0, gVar3.f43695j, gVar3.f43690e.get(), this.f43712a.f43689d.get());
                    case 7:
                        return (T) C5874A.a(this.f43712a.m());
                    case 8:
                        return (T) C5880G.a(this.f43712a.m());
                    case 9:
                        return (T) new C5806b0();
                    case 10:
                        return (T) C5914z.a(this.f43712a.m());
                    case 11:
                        return (T) new Camera2MetadataCache(this.f43712a.m(), this.f43712a.f43691f.get(), this.f43712a.f43697l.get(), this.f43712a.l(), this.f43712a.f43698m.get());
                    case 12:
                        return (T) new z.m(this.f43712a.m());
                    case 13:
                        return (T) new z.t();
                    case 14:
                        return (T) new PruningCamera2DeviceManager(this.f43712a.f43697l.get(), this.f43712a.f43704s.get(), this.f43712a.f43705t.get(), this.f43712a.f43694i.get(), this.f43712a.f43691f.get());
                    case 15:
                        return (T) new RetryingCameraStateOpenerImpl(this.f43712a.n(), this.f43712a.f43694i.get(), this.f43712a.i(), this.f43712a.f43698m.get(), this.f43712a.f43702q.get(), this.f43712a.f43703r.get(), this.f43712a.k(), this.f43712a.f43691f.get());
                    case 16:
                        return (T) new C5810d0(this.f43712a.f43699n.get(), this.f43712a.f43700o.get());
                    case 17:
                        return (T) C5881H.a(C5908t.a(this.f43712a.f43686a));
                    case 18:
                        return (T) C5879F.a(this.f43712a.m());
                    case 19:
                        return (T) new AudioRestrictionControllerImpl(this.f43712a.f43691f.get(), this.f43712a.f43690e.get(), this.f43712a.f43689d.get());
                    case 20:
                        return (T) new Camera2DeviceCloserImpl(this.f43712a.f43691f.get(), this.f43712a.f43701p.get(), this.f43712a.f43704s.get());
                    case 21:
                        return (T) C5913y.a(this.f43712a.m(), this.f43712a.f43691f.get(), this.f43712a.f43708w.get());
                    case 22:
                        return (T) C5877D.a();
                    case 23:
                        return (T) new r0();
                    default:
                        throw new AssertionError(this.f43713b);
                }
            }
        }

        public g(C5906q c5906q, a0 a0Var) {
            this.f43686a = c5906q;
            this.f43687b = a0Var;
            q(c5906q, a0Var);
        }

        @Override // y.InterfaceC5905p
        public InterfaceC5705k a() {
            return this.f43709x.get();
        }

        @Override // y.InterfaceC5905p
        public InterfaceC5901l.a b() {
            return new e(this.f43688c);
        }

        @Override // y.InterfaceC5905p
        public C5711q c() {
            return this.f43711z.get();
        }

        @Override // y.InterfaceC5905p
        public InterfaceC5702h d() {
            return this.f43710y.get();
        }

        @Override // y.InterfaceC5905p
        public InterfaceC5700f e() {
            return this.f43708w.get();
        }

        @Override // y.InterfaceC5905p
        public CameraPipeLifetime f() {
            return this.f43690e.get();
        }

        public Camera2CameraAvailabilityMonitor i() {
            return new Camera2CameraAvailabilityMonitor(this.f43692g, this.f43691f.get(), this.f43689d.get());
        }

        public x.K j() {
            return new x.K(this.f43692g, this.f43691f.get());
        }

        public h.CameraInteropConfig k() {
            C5906q c5906q = this.f43686a;
            return r.a(c5906q, C5907s.a(c5906q));
        }

        public h.c l() {
            return C5875B.a(C5907s.a(this.f43686a));
        }

        public Context m() {
            return C5878E.a(C5907s.a(this.f43686a));
        }

        public CameraStateOpener n() {
            return new CameraStateOpener(j(), this.f43699n.get(), this.f43694i.get(), this.f43701p.get(), this.f43698m.get(), k(), this.f43691f.get());
        }

        public C.i o() {
            return new C.i(this.f43691f.get(), C5907s.a(this.f43686a));
        }

        public C.m p() {
            return C5911w.a(o(), C5907s.a(this.f43686a));
        }

        public final void q(C5906q c5906q, a0 a0Var) {
            this.f43689d = i8.b.b(new a(this.f43688c, 1));
            this.f43690e = i8.b.b(new a(this.f43688c, 0));
            this.f43691f = i8.b.b(new a(this.f43688c, 5));
            this.f43692g = i8.f.a(new a(this.f43688c, 7));
            this.f43693h = i8.b.b(new a(this.f43688c, 8));
            this.f43694i = i8.b.b(new a(this.f43688c, 9));
            this.f43695j = i8.b.b(new a(this.f43688c, 10));
            this.f43696k = i8.b.b(new a(this.f43688c, 6));
            this.f43697l = i8.b.b(new a(this.f43688c, 12));
            this.f43698m = i8.b.b(new a(this.f43688c, 13));
            this.f43699n = i8.b.b(new a(this.f43688c, 11));
            this.f43700o = i8.b.b(new a(this.f43688c, 17));
            this.f43701p = i8.b.b(new a(this.f43688c, 16));
            this.f43702q = i8.f.a(new a(this.f43688c, 18));
            this.f43703r = i8.b.b(new a(this.f43688c, 19));
            this.f43704s = i8.b.b(new a(this.f43688c, 15));
            this.f43705t = i8.b.b(new a(this.f43688c, 20));
            this.f43706u = i8.b.b(new a(this.f43688c, 14));
            this.f43707v = new a(this.f43688c, 4);
            this.f43708w = i8.b.b(new a(this.f43688c, 3));
            this.f43709x = i8.b.b(new a(this.f43688c, 2));
            this.f43710y = i8.b.b(new a(this.f43688c, 21));
            this.f43711z = i8.b.b(new a(this.f43688c, 22));
            this.f43685A = i8.b.b(new a(this.f43688c, 23));
        }
    }

    public static b a() {
        return new b();
    }
}
