package C0;

import C0.h;
import H0.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z0.C1342h;
import z0.InterfaceC1338d;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
final class g<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f318a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<InterfaceC1340f> f319b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private v0.e f320c;

    /* renamed from: d, reason: collision with root package name */
    private Object f321d;

    /* renamed from: e, reason: collision with root package name */
    private int f322e;

    /* renamed from: f, reason: collision with root package name */
    private int f323f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f324g;

    /* renamed from: h, reason: collision with root package name */
    private h.e f325h;

    /* renamed from: i, reason: collision with root package name */
    private C1342h f326i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, z0.k<?>> f327j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f328k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f329l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f330m;

    /* renamed from: n, reason: collision with root package name */
    private InterfaceC1340f f331n;

    /* renamed from: o, reason: collision with root package name */
    private v0.g f332o;

    /* renamed from: p, reason: collision with root package name */
    private j f333p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f334q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f335r;

    g() {
    }

    void a() {
        this.f320c = null;
        this.f321d = null;
        this.f331n = null;
        this.f324g = null;
        this.f328k = null;
        this.f326i = null;
        this.f332o = null;
        this.f327j = null;
        this.f333p = null;
        this.f318a.clear();
        this.f329l = false;
        this.f319b.clear();
        this.f330m = false;
    }

    D0.b b() {
        return this.f320c.a();
    }

    List<InterfaceC1340f> c() {
        if (!this.f330m) {
            this.f330m = true;
            this.f319b.clear();
            List<n.a<?>> listG = g();
            int size = listG.size();
            for (int i5 = 0; i5 < size; i5++) {
                n.a<?> aVar = listG.get(i5);
                if (!this.f319b.contains(aVar.f2003a)) {
                    this.f319b.add(aVar.f2003a);
                }
                for (int i6 = 0; i6 < aVar.f2004b.size(); i6++) {
                    if (!this.f319b.contains(aVar.f2004b.get(i6))) {
                        this.f319b.add(aVar.f2004b.get(i6));
                    }
                }
            }
        }
        return this.f319b;
    }

    E0.a d() {
        return this.f325h.a();
    }

    j e() {
        return this.f333p;
    }

    int f() {
        return this.f323f;
    }

    List<n.a<?>> g() {
        if (!this.f329l) {
            this.f329l = true;
            this.f318a.clear();
            List listI = this.f320c.g().i(this.f321d);
            int size = listI.size();
            for (int i5 = 0; i5 < size; i5++) {
                n.a<?> aVarB = ((H0.n) listI.get(i5)).b(this.f321d, this.f322e, this.f323f, this.f326i);
                if (aVarB != null) {
                    this.f318a.add(aVarB);
                }
            }
        }
        return this.f318a;
    }

    <Data> t<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f320c.g().h(cls, this.f324g, this.f328k);
    }

    Class<?> i() {
        return this.f321d.getClass();
    }

    List<H0.n<File, ?>> j(File file) {
        return this.f320c.g().i(file);
    }

    C1342h k() {
        return this.f326i;
    }

    v0.g l() {
        return this.f332o;
    }

    List<Class<?>> m() {
        return this.f320c.g().j(this.f321d.getClass(), this.f324g, this.f328k);
    }

    <Z> z0.j<Z> n(v<Z> vVar) {
        return this.f320c.g().k(vVar);
    }

    InterfaceC1340f o() {
        return this.f331n;
    }

    <X> InterfaceC1338d<X> p(X x5) {
        return this.f320c.g().m(x5);
    }

    Class<?> q() {
        return this.f328k;
    }

    <Z> z0.k<Z> r(Class<Z> cls) {
        z0.k<Z> kVar = (z0.k) this.f327j.get(cls);
        if (kVar == null) {
            Iterator<Map.Entry<Class<?>, z0.k<?>>> it = this.f327j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, z0.k<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    kVar = (z0.k) next.getValue();
                    break;
                }
            }
        }
        if (kVar != null) {
            return kVar;
        }
        if (!this.f327j.isEmpty() || !this.f334q) {
            return J0.b.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.f322e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void u(v0.e eVar, Object obj, InterfaceC1340f interfaceC1340f, int i5, int i6, j jVar, Class<?> cls, Class<R> cls2, v0.g gVar, C1342h c1342h, Map<Class<?>, z0.k<?>> map, boolean z5, boolean z6, h.e eVar2) {
        this.f320c = eVar;
        this.f321d = obj;
        this.f331n = interfaceC1340f;
        this.f322e = i5;
        this.f323f = i6;
        this.f333p = jVar;
        this.f324g = cls;
        this.f325h = eVar2;
        this.f328k = cls2;
        this.f332o = gVar;
        this.f326i = c1342h;
        this.f327j = map;
        this.f334q = z5;
        this.f335r = z6;
    }

    boolean v(v<?> vVar) {
        return this.f320c.g().n(vVar);
    }

    boolean w() {
        return this.f335r;
    }

    boolean x(InterfaceC1340f interfaceC1340f) {
        List<n.a<?>> listG = g();
        int size = listG.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (listG.get(i5).f2003a.equals(interfaceC1340f)) {
                return true;
            }
        }
        return false;
    }
}
