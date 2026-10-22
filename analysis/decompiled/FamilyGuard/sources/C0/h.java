package C0;

import C0.f;
import C0.i;
import Y0.a;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;
import v0.h;
import z0.C1341g;
import z0.C1342h;
import z0.EnumC1335a;
import z0.EnumC1337c;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {

    /* renamed from: A, reason: collision with root package name */
    private EnumC1335a f336A;

    /* renamed from: B, reason: collision with root package name */
    private A0.d<?> f337B;

    /* renamed from: C, reason: collision with root package name */
    private volatile C0.f f338C;

    /* renamed from: D, reason: collision with root package name */
    private volatile boolean f339D;

    /* renamed from: E, reason: collision with root package name */
    private volatile boolean f340E;

    /* renamed from: d, reason: collision with root package name */
    private final e f344d;

    /* renamed from: e, reason: collision with root package name */
    private final D.e<h<?>> f345e;

    /* renamed from: h, reason: collision with root package name */
    private v0.e f348h;

    /* renamed from: i, reason: collision with root package name */
    private InterfaceC1340f f349i;

    /* renamed from: j, reason: collision with root package name */
    private v0.g f350j;

    /* renamed from: k, reason: collision with root package name */
    private n f351k;

    /* renamed from: l, reason: collision with root package name */
    private int f352l;

    /* renamed from: m, reason: collision with root package name */
    private int f353m;

    /* renamed from: n, reason: collision with root package name */
    private j f354n;

    /* renamed from: o, reason: collision with root package name */
    private C1342h f355o;

    /* renamed from: p, reason: collision with root package name */
    private b<R> f356p;

    /* renamed from: q, reason: collision with root package name */
    private int f357q;

    /* renamed from: r, reason: collision with root package name */
    private EnumC0011h f358r;

    /* renamed from: s, reason: collision with root package name */
    private g f359s;

    /* renamed from: t, reason: collision with root package name */
    private long f360t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f361u;

    /* renamed from: v, reason: collision with root package name */
    private Object f362v;

    /* renamed from: w, reason: collision with root package name */
    private Thread f363w;

    /* renamed from: x, reason: collision with root package name */
    private InterfaceC1340f f364x;

    /* renamed from: y, reason: collision with root package name */
    private InterfaceC1340f f365y;

    /* renamed from: z, reason: collision with root package name */
    private Object f366z;

    /* renamed from: a, reason: collision with root package name */
    private final C0.g<R> f341a = new C0.g<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<Throwable> f342b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Y0.c f343c = Y0.c.a();

    /* renamed from: f, reason: collision with root package name */
    private final d<?> f346f = new d<>();

    /* renamed from: g, reason: collision with root package name */
    private final f f347g = new f();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f367a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f368b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f369c;

        static {
            int[] iArr = new int[EnumC1337c.values().length];
            f369c = iArr;
            try {
                iArr[EnumC1337c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f369c[EnumC1337c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0011h.values().length];
            f368b = iArr2;
            try {
                iArr2[EnumC0011h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f368b[EnumC0011h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f368b[EnumC0011h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f368b[EnumC0011h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f368b[EnumC0011h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f367a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f367a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f367a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b<R> {
        void a(v<R> vVar, EnumC1335a enumC1335a);

        void c(q qVar);

        void d(h<?> hVar);
    }

    private final class c<Z> implements i.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final EnumC1335a f370a;

        c(EnumC1335a enumC1335a) {
            this.f370a = enumC1335a;
        }

        @Override // C0.i.a
        public v<Z> a(v<Z> vVar) {
            return h.this.y(this.f370a, vVar);
        }
    }

    private static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        private InterfaceC1340f f372a;

        /* renamed from: b, reason: collision with root package name */
        private z0.j<Z> f373b;

        /* renamed from: c, reason: collision with root package name */
        private u<Z> f374c;

        d() {
        }

        void a() {
            this.f372a = null;
            this.f373b = null;
            this.f374c = null;
        }

        void b(e eVar, C1342h c1342h) {
            Y0.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f372a, new C0.e(this.f373b, this.f374c, c1342h));
            } finally {
                this.f374c.h();
                Y0.b.d();
            }
        }

        boolean c() {
            return this.f374c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(InterfaceC1340f interfaceC1340f, z0.j<X> jVar, u<X> uVar) {
            this.f372a = interfaceC1340f;
            this.f373b = jVar;
            this.f374c = uVar;
        }
    }

    interface e {
        E0.a a();
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f375a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f376b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f377c;

        f() {
        }

        private boolean a(boolean z5) {
            return (this.f377c || z5 || this.f376b) && this.f375a;
        }

        synchronized boolean b() {
            this.f376b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f377c = true;
            return a(false);
        }

        synchronized boolean d(boolean z5) {
            this.f375a = true;
            return a(z5);
        }

        synchronized void e() {
            this.f376b = false;
            this.f375a = false;
            this.f377c = false;
        }
    }

    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: C0.h$h, reason: collision with other inner class name */
    private enum EnumC0011h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, D.e<h<?>> eVar2) {
        this.f344d = eVar;
        this.f345e = eVar2;
    }

    private void C() {
        this.f347g.e();
        this.f346f.a();
        this.f341a.a();
        this.f339D = false;
        this.f348h = null;
        this.f349i = null;
        this.f355o = null;
        this.f350j = null;
        this.f351k = null;
        this.f356p = null;
        this.f358r = null;
        this.f338C = null;
        this.f363w = null;
        this.f364x = null;
        this.f366z = null;
        this.f336A = null;
        this.f337B = null;
        this.f360t = 0L;
        this.f340E = false;
        this.f362v = null;
        this.f342b.clear();
        this.f345e.a(this);
    }

    private void E() {
        this.f363w = Thread.currentThread();
        this.f360t = X0.f.b();
        boolean zA = false;
        while (!this.f340E && this.f338C != null && !(zA = this.f338C.a())) {
            this.f358r = n(this.f358r);
            this.f338C = m();
            if (this.f358r == EnumC0011h.SOURCE) {
                d();
                return;
            }
        }
        if ((this.f358r == EnumC0011h.FINISHED || this.f340E) && !zA) {
            v();
        }
    }

    private <Data, ResourceType> v<R> F(Data data, EnumC1335a enumC1335a, t<Data, ResourceType, R> tVar) {
        C1342h c1342hO = o(enumC1335a);
        A0.e<Data> eVarL = this.f348h.g().l(data);
        try {
            return tVar.a(eVarL, c1342hO, this.f352l, this.f353m, new c(enumC1335a));
        } finally {
            eVarL.b();
        }
    }

    private void G() {
        int i5 = a.f367a[this.f359s.ordinal()];
        if (i5 == 1) {
            this.f358r = n(EnumC0011h.INITIALIZE);
            this.f338C = m();
            E();
        } else if (i5 == 2) {
            E();
        } else {
            if (i5 == 3) {
                l();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f359s);
        }
    }

    private void H() {
        Throwable th;
        this.f343c.c();
        if (!this.f339D) {
            this.f339D = true;
            return;
        }
        if (this.f342b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f342b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private <Data> v<R> j(A0.d<?> dVar, Data data, EnumC1335a enumC1335a) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long jB = X0.f.b();
            v<R> vVarK = k(data, enumC1335a);
            if (Log.isLoggable("DecodeJob", 2)) {
                r("Decoded result " + vVarK, jB);
            }
            return vVarK;
        } finally {
            dVar.b();
        }
    }

    private <Data> v<R> k(Data data, EnumC1335a enumC1335a) {
        return F(data, enumC1335a, this.f341a.h(data.getClass()));
    }

    private void l() {
        v<R> vVarJ;
        if (Log.isLoggable("DecodeJob", 2)) {
            s("Retrieved data", this.f360t, "data: " + this.f366z + ", cache key: " + this.f364x + ", fetcher: " + this.f337B);
        }
        try {
            vVarJ = j(this.f337B, this.f366z, this.f336A);
        } catch (q e6) {
            e6.i(this.f365y, this.f336A);
            this.f342b.add(e6);
            vVarJ = null;
        }
        if (vVarJ != null) {
            u(vVarJ, this.f336A);
        } else {
            E();
        }
    }

    private C0.f m() {
        int i5 = a.f368b[this.f358r.ordinal()];
        if (i5 == 1) {
            return new w(this.f341a, this);
        }
        if (i5 == 2) {
            return new C0.c(this.f341a, this);
        }
        if (i5 == 3) {
            return new z(this.f341a, this);
        }
        if (i5 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f358r);
    }

    private EnumC0011h n(EnumC0011h enumC0011h) {
        int i5 = a.f368b[enumC0011h.ordinal()];
        if (i5 == 1) {
            return this.f354n.a() ? EnumC0011h.DATA_CACHE : n(EnumC0011h.DATA_CACHE);
        }
        if (i5 == 2) {
            return this.f361u ? EnumC0011h.FINISHED : EnumC0011h.SOURCE;
        }
        if (i5 == 3 || i5 == 4) {
            return EnumC0011h.FINISHED;
        }
        if (i5 == 5) {
            return this.f354n.b() ? EnumC0011h.RESOURCE_CACHE : n(EnumC0011h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0011h);
    }

    private C1342h o(EnumC1335a enumC1335a) {
        C1342h c1342h = this.f355o;
        boolean z5 = enumC1335a == EnumC1335a.RESOURCE_DISK_CACHE || this.f341a.w();
        C1341g<Boolean> c1341g = K0.h.f3535i;
        Boolean bool = (Boolean) c1342h.c(c1341g);
        if (bool != null && (!bool.booleanValue() || z5)) {
            return c1342h;
        }
        C1342h c1342h2 = new C1342h();
        c1342h2.d(this.f355o);
        c1342h2.e(c1341g, Boolean.valueOf(z5));
        return c1342h2;
    }

    private int p() {
        return this.f350j.ordinal();
    }

    private void r(String str, long j5) {
        s(str, j5, null);
    }

    private void s(String str, long j5, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(X0.f.a(j5));
        sb.append(", load key: ");
        sb.append(this.f351k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void t(v<R> vVar, EnumC1335a enumC1335a) {
        H();
        this.f356p.a(vVar, enumC1335a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(v<R> vVar, EnumC1335a enumC1335a) {
        u uVar;
        if (vVar instanceof r) {
            ((r) vVar).a();
        }
        if (this.f346f.c()) {
            vVar = u.e(vVar);
            uVar = vVar;
        } else {
            uVar = 0;
        }
        t(vVar, enumC1335a);
        this.f358r = EnumC0011h.ENCODE;
        try {
            if (this.f346f.c()) {
                this.f346f.b(this.f344d, this.f355o);
            }
            w();
        } finally {
            if (uVar != 0) {
                uVar.h();
            }
        }
    }

    private void v() {
        H();
        this.f356p.c(new q("Failed to load resource", new ArrayList(this.f342b)));
        x();
    }

    private void w() {
        if (this.f347g.b()) {
            C();
        }
    }

    private void x() {
        if (this.f347g.c()) {
            C();
        }
    }

    boolean I() {
        EnumC0011h enumC0011hN = n(EnumC0011h.INITIALIZE);
        return enumC0011hN == EnumC0011h.RESOURCE_CACHE || enumC0011hN == EnumC0011h.DATA_CACHE;
    }

    @Override // C0.f.a
    public void b(InterfaceC1340f interfaceC1340f, Exception exc, A0.d<?> dVar, EnumC1335a enumC1335a) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.j(interfaceC1340f, enumC1335a, dVar.a());
        this.f342b.add(qVar);
        if (Thread.currentThread() == this.f363w) {
            E();
        } else {
            this.f359s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f356p.d(this);
        }
    }

    @Override // C0.f.a
    public void d() {
        this.f359s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f356p.d(this);
    }

    @Override // C0.f.a
    public void e(InterfaceC1340f interfaceC1340f, Object obj, A0.d<?> dVar, EnumC1335a enumC1335a, InterfaceC1340f interfaceC1340f2) {
        this.f364x = interfaceC1340f;
        this.f366z = obj;
        this.f337B = dVar;
        this.f336A = enumC1335a;
        this.f365y = interfaceC1340f2;
        if (Thread.currentThread() != this.f363w) {
            this.f359s = g.DECODE_DATA;
            this.f356p.d(this);
        } else {
            Y0.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                l();
            } finally {
                Y0.b.d();
            }
        }
    }

    @Override // Y0.a.f
    public Y0.c g() {
        return this.f343c;
    }

    public void h() {
        this.f340E = true;
        C0.f fVar = this.f338C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(h<?> hVar) {
        int iP = p() - hVar.p();
        return iP == 0 ? this.f357q - hVar.f357q : iP;
    }

    h<R> q(v0.e eVar, Object obj, n nVar, InterfaceC1340f interfaceC1340f, int i5, int i6, Class<?> cls, Class<R> cls2, v0.g gVar, j jVar, Map<Class<?>, z0.k<?>> map, boolean z5, boolean z6, boolean z7, C1342h c1342h, b<R> bVar, int i7) {
        this.f341a.u(eVar, obj, interfaceC1340f, i5, i6, jVar, cls, cls2, gVar, c1342h, map, z5, z6, this.f344d);
        this.f348h = eVar;
        this.f349i = interfaceC1340f;
        this.f350j = gVar;
        this.f351k = nVar;
        this.f352l = i5;
        this.f353m = i6;
        this.f354n = jVar;
        this.f361u = z7;
        this.f355o = c1342h;
        this.f356p = bVar;
        this.f357q = i7;
        this.f359s = g.INITIALIZE;
        this.f362v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        Y0.b.b("DecodeJob#run(model=%s)", this.f362v);
        A0.d<?> dVar = this.f337B;
        try {
            try {
                try {
                    if (this.f340E) {
                        v();
                        if (dVar != null) {
                            dVar.b();
                        }
                        Y0.b.d();
                        return;
                    }
                    G();
                    if (dVar != null) {
                        dVar.b();
                    }
                    Y0.b.d();
                } catch (C0.b e6) {
                    throw e6;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f340E + ", stage: " + this.f358r, th);
                }
                if (this.f358r != EnumC0011h.ENCODE) {
                    this.f342b.add(th);
                    v();
                }
                if (!this.f340E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            Y0.b.d();
            throw th2;
        }
    }

    <Z> v<Z> y(EnumC1335a enumC1335a, v<Z> vVar) {
        v<Z> vVarA;
        z0.k<Z> kVar;
        EnumC1337c enumC1337cA;
        InterfaceC1340f dVar;
        Class<?> cls = vVar.get().getClass();
        z0.j<Z> jVarN = null;
        if (enumC1335a != EnumC1335a.RESOURCE_DISK_CACHE) {
            z0.k<Z> kVarR = this.f341a.r(cls);
            kVar = kVarR;
            vVarA = kVarR.a(this.f348h, vVar, this.f352l, this.f353m);
        } else {
            vVarA = vVar;
            kVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.b();
        }
        if (this.f341a.v(vVarA)) {
            jVarN = this.f341a.n(vVarA);
            enumC1337cA = jVarN.a(this.f355o);
        } else {
            enumC1337cA = EnumC1337c.NONE;
        }
        z0.j jVar = jVarN;
        if (!this.f354n.d(!this.f341a.x(this.f364x), enumC1335a, enumC1337cA)) {
            return vVarA;
        }
        if (jVar == null) {
            throw new h.d(vVarA.get().getClass());
        }
        int i5 = a.f369c[enumC1337cA.ordinal()];
        if (i5 == 1) {
            dVar = new C0.d(this.f364x, this.f349i);
        } else {
            if (i5 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + enumC1337cA);
            }
            dVar = new x(this.f341a.b(), this.f364x, this.f349i, this.f352l, this.f353m, kVar, cls, this.f355o);
        }
        u uVarE = u.e(vVarA);
        this.f346f.d(dVar, jVar, uVarE);
        return uVarE;
    }

    void z(boolean z5) {
        if (this.f347g.d(z5)) {
            C();
        }
    }
}
