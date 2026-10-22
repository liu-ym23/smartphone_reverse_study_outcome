package C0;

import C0.h;
import C0.p;
import E0.a;
import E0.h;
import Y0.a;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.Executor;
import z0.C1342h;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public class k implements m, h.a, p.a {

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f399i = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    private final s f400a;

    /* renamed from: b, reason: collision with root package name */
    private final o f401b;

    /* renamed from: c, reason: collision with root package name */
    private final E0.h f402c;

    /* renamed from: d, reason: collision with root package name */
    private final b f403d;

    /* renamed from: e, reason: collision with root package name */
    private final y f404e;

    /* renamed from: f, reason: collision with root package name */
    private final c f405f;

    /* renamed from: g, reason: collision with root package name */
    private final a f406g;

    /* renamed from: h, reason: collision with root package name */
    private final C0.a f407h;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final h.e f408a;

        /* renamed from: b, reason: collision with root package name */
        final D.e<h<?>> f409b = Y0.a.d(150, new C0012a());

        /* renamed from: c, reason: collision with root package name */
        private int f410c;

        /* renamed from: C0.k$a$a, reason: collision with other inner class name */
        class C0012a implements a.d<h<?>> {
            C0012a() {
            }

            @Override // Y0.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f408a, aVar.f409b);
            }
        }

        a(h.e eVar) {
            this.f408a = eVar;
        }

        <R> h<R> a(v0.e eVar, Object obj, n nVar, InterfaceC1340f interfaceC1340f, int i5, int i6, Class<?> cls, Class<R> cls2, v0.g gVar, j jVar, Map<Class<?>, z0.k<?>> map, boolean z5, boolean z6, boolean z7, C1342h c1342h, h.b<R> bVar) {
            h hVar = (h) X0.j.d(this.f409b.b());
            int i7 = this.f410c;
            this.f410c = i7 + 1;
            return hVar.q(eVar, obj, nVar, interfaceC1340f, i5, i6, cls, cls2, gVar, jVar, map, z5, z6, z7, c1342h, bVar, i7);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final F0.a f412a;

        /* renamed from: b, reason: collision with root package name */
        final F0.a f413b;

        /* renamed from: c, reason: collision with root package name */
        final F0.a f414c;

        /* renamed from: d, reason: collision with root package name */
        final F0.a f415d;

        /* renamed from: e, reason: collision with root package name */
        final m f416e;

        /* renamed from: f, reason: collision with root package name */
        final D.e<l<?>> f417f = Y0.a.d(150, new a());

        class a implements a.d<l<?>> {
            a() {
            }

            @Override // Y0.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f412a, bVar.f413b, bVar.f414c, bVar.f415d, bVar.f416e, bVar.f417f);
            }
        }

        b(F0.a aVar, F0.a aVar2, F0.a aVar3, F0.a aVar4, m mVar) {
            this.f412a = aVar;
            this.f413b = aVar2;
            this.f414c = aVar3;
            this.f415d = aVar4;
            this.f416e = mVar;
        }

        <R> l<R> a(InterfaceC1340f interfaceC1340f, boolean z5, boolean z6, boolean z7, boolean z8) {
            return ((l) X0.j.d(this.f417f.b())).l(interfaceC1340f, z5, z6, z7, z8);
        }
    }

    private static class c implements h.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0020a f419a;

        /* renamed from: b, reason: collision with root package name */
        private volatile E0.a f420b;

        c(a.InterfaceC0020a interfaceC0020a) {
            this.f419a = interfaceC0020a;
        }

        @Override // C0.h.e
        public E0.a a() {
            if (this.f420b == null) {
                synchronized (this) {
                    try {
                        if (this.f420b == null) {
                            this.f420b = this.f419a.build();
                        }
                        if (this.f420b == null) {
                            this.f420b = new E0.b();
                        }
                    } finally {
                    }
                }
            }
            return this.f420b;
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final l<?> f421a;

        /* renamed from: b, reason: collision with root package name */
        private final T0.i f422b;

        d(T0.i iVar, l<?> lVar) {
            this.f422b = iVar;
            this.f421a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f421a.r(this.f422b);
            }
        }
    }

    public k(E0.h hVar, a.InterfaceC0020a interfaceC0020a, F0.a aVar, F0.a aVar2, F0.a aVar3, F0.a aVar4, boolean z5) {
        this(hVar, interfaceC0020a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z5);
    }

    private p<?> e(InterfaceC1340f interfaceC1340f) {
        v<?> vVarD = this.f402c.d(interfaceC1340f);
        if (vVarD == null) {
            return null;
        }
        return vVarD instanceof p ? (p) vVarD : new p<>(vVarD, true, true);
    }

    private p<?> g(InterfaceC1340f interfaceC1340f, boolean z5) {
        if (!z5) {
            return null;
        }
        p<?> pVarE = this.f407h.e(interfaceC1340f);
        if (pVarE != null) {
            pVarE.a();
        }
        return pVarE;
    }

    private p<?> h(InterfaceC1340f interfaceC1340f, boolean z5) {
        if (!z5) {
            return null;
        }
        p<?> pVarE = e(interfaceC1340f);
        if (pVarE != null) {
            pVarE.a();
            this.f407h.a(interfaceC1340f, pVarE);
        }
        return pVarE;
    }

    private static void i(String str, long j5, InterfaceC1340f interfaceC1340f) {
        Log.v("Engine", str + " in " + X0.f.a(j5) + "ms, key: " + interfaceC1340f);
    }

    @Override // C0.m
    public synchronized void a(l<?> lVar, InterfaceC1340f interfaceC1340f, p<?> pVar) {
        if (pVar != null) {
            try {
                pVar.h(interfaceC1340f, this);
                if (pVar.f()) {
                    this.f407h.a(interfaceC1340f, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f400a.d(interfaceC1340f, lVar);
    }

    @Override // E0.h.a
    public void b(v<?> vVar) {
        this.f404e.a(vVar);
    }

    @Override // C0.p.a
    public synchronized void c(InterfaceC1340f interfaceC1340f, p<?> pVar) {
        try {
            this.f407h.d(interfaceC1340f);
            if (pVar.f()) {
                this.f402c.c(interfaceC1340f, pVar);
            } else {
                this.f404e.a(pVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // C0.m
    public synchronized void d(l<?> lVar, InterfaceC1340f interfaceC1340f) {
        this.f400a.d(interfaceC1340f, lVar);
    }

    public synchronized <R> d f(v0.e eVar, Object obj, InterfaceC1340f interfaceC1340f, int i5, int i6, Class<?> cls, Class<R> cls2, v0.g gVar, j jVar, Map<Class<?>, z0.k<?>> map, boolean z5, boolean z6, C1342h c1342h, boolean z7, boolean z8, boolean z9, boolean z10, T0.i iVar, Executor executor) {
        try {
            boolean z11 = f399i;
            long jB = z11 ? X0.f.b() : 0L;
            n nVarA = this.f401b.a(obj, interfaceC1340f, i5, i6, map, cls, cls2, c1342h);
            p<?> pVarG = g(nVarA, z7);
            if (pVarG != null) {
                iVar.a(pVarG, EnumC1335a.MEMORY_CACHE);
                if (z11) {
                    i("Loaded resource from active resources", jB, nVarA);
                }
                return null;
            }
            p<?> pVarH = h(nVarA, z7);
            if (pVarH != null) {
                iVar.a(pVarH, EnumC1335a.MEMORY_CACHE);
                if (z11) {
                    i("Loaded resource from cache", jB, nVarA);
                }
                return null;
            }
            l<?> lVarA = this.f400a.a(nVarA, z10);
            if (lVarA != null) {
                lVarA.b(iVar, executor);
                if (z11) {
                    i("Added to existing load", jB, nVarA);
                }
                return new d(iVar, lVarA);
            }
            l<R> lVarA2 = this.f403d.a(nVarA, z7, z8, z9, z10);
            h<R> hVarA = this.f406g.a(eVar, obj, nVarA, interfaceC1340f, i5, i6, cls, cls2, gVar, jVar, map, z5, z6, z10, c1342h, lVarA2);
            this.f400a.c(nVarA, lVarA2);
            lVarA2.b(iVar, executor);
            lVarA2.s(hVarA);
            if (z11) {
                i("Started new load", jB, nVarA);
            }
            return new d(iVar, lVarA2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void j(v<?> vVar) {
        if (!(vVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((p) vVar).g();
    }

    k(E0.h hVar, a.InterfaceC0020a interfaceC0020a, F0.a aVar, F0.a aVar2, F0.a aVar3, F0.a aVar4, s sVar, o oVar, C0.a aVar5, b bVar, a aVar6, y yVar, boolean z5) {
        this.f402c = hVar;
        c cVar = new c(interfaceC0020a);
        this.f405f = cVar;
        C0.a aVar7 = aVar5 == null ? new C0.a(z5) : aVar5;
        this.f407h = aVar7;
        aVar7.f(this);
        this.f401b = oVar == null ? new o() : oVar;
        this.f400a = sVar == null ? new s() : sVar;
        this.f403d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.f406g = aVar6 == null ? new a(cVar) : aVar6;
        this.f404e = yVar == null ? new y() : yVar;
        hVar.e(this);
    }
}
