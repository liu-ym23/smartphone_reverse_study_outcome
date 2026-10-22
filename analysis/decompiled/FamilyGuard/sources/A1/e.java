package A1;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: v, reason: collision with root package name */
    private static final com.google.gson.reflect.a<?> f36v = com.google.gson.reflect.a.get(Object.class);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.reflect.a<?>, f<?>>> f37a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<com.google.gson.reflect.a<?>, t<?>> f38b;

    /* renamed from: c, reason: collision with root package name */
    private final C1.c f39c;

    /* renamed from: d, reason: collision with root package name */
    private final D1.d f40d;

    /* renamed from: e, reason: collision with root package name */
    final List<u> f41e;

    /* renamed from: f, reason: collision with root package name */
    final C1.d f42f;

    /* renamed from: g, reason: collision with root package name */
    final A1.d f43g;

    /* renamed from: h, reason: collision with root package name */
    final Map<Type, A1.f<?>> f44h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f45i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f46j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f47k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f48l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f49m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f50n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f51o;

    /* renamed from: p, reason: collision with root package name */
    final String f52p;

    /* renamed from: q, reason: collision with root package name */
    final int f53q;

    /* renamed from: r, reason: collision with root package name */
    final int f54r;

    /* renamed from: s, reason: collision with root package name */
    final s f55s;

    /* renamed from: t, reason: collision with root package name */
    final List<u> f56t;

    /* renamed from: u, reason: collision with root package name */
    final List<u> f57u;

    class a extends t<Number> {
        a() {
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(G1.a aVar) throws IOException {
            if (aVar.V() != G1.b.NULL) {
                return Double.valueOf(aVar.E());
            }
            aVar.O();
            return null;
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.D();
            } else {
                e.d(number.doubleValue());
                cVar.X(number);
            }
        }
    }

    class b extends t<Number> {
        b() {
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(G1.a aVar) throws IOException {
            if (aVar.V() != G1.b.NULL) {
                return Float.valueOf((float) aVar.E());
            }
            aVar.O();
            return null;
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.D();
            } else {
                e.d(number.floatValue());
                cVar.X(number);
            }
        }
    }

    static class c extends t<Number> {
        c() {
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(G1.a aVar) throws IOException {
            if (aVar.V() != G1.b.NULL) {
                return Long.valueOf(aVar.I());
            }
            aVar.O();
            return null;
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.D();
            } else {
                cVar.Y(number.toString());
            }
        }
    }

    static class d extends t<AtomicLong> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f60a;

        d(t tVar) {
            this.f60a = tVar;
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(G1.a aVar) {
            return new AtomicLong(((Number) this.f60a.b(aVar)).longValue());
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, AtomicLong atomicLong) {
            this.f60a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: A1.e$e, reason: collision with other inner class name */
    static class C0001e extends t<AtomicLongArray> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f61a;

        C0001e(t tVar) {
            this.f61a = tVar;
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(G1.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.w()) {
                arrayList.add(Long.valueOf(((Number) this.f61a.b(aVar)).longValue()));
            }
            aVar.r();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i5 = 0; i5 < size; i5++) {
                atomicLongArray.set(i5, ((Long) arrayList.get(i5)).longValue());
            }
            return atomicLongArray;
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.f();
            int length = atomicLongArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                this.f61a.d(cVar, Long.valueOf(atomicLongArray.get(i5)));
            }
            cVar.r();
        }
    }

    static class f<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private t<T> f62a;

        f() {
        }

        @Override // A1.t
        public T b(G1.a aVar) {
            t<T> tVar = this.f62a;
            if (tVar != null) {
                return tVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // A1.t
        public void d(G1.c cVar, T t5) {
            t<T> tVar = this.f62a;
            if (tVar == null) {
                throw new IllegalStateException();
            }
            tVar.d(cVar, t5);
        }

        public void e(t<T> tVar) {
            if (this.f62a != null) {
                throw new AssertionError();
            }
            this.f62a = tVar;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        C1.d dVar = C1.d.f551g;
        A1.c cVar = A1.c.f29a;
        Map map = Collections.EMPTY_MAP;
        s sVar = s.f68a;
        List list = Collections.EMPTY_LIST;
        this(dVar, cVar, map, false, false, false, true, false, false, false, sVar, null, 2, 2, list, list, list);
    }

    private static void a(Object obj, G1.a aVar) {
        if (obj != null) {
            try {
                if (aVar.V() == G1.b.END_DOCUMENT) {
                } else {
                    throw new k("JSON document was not fully consumed.");
                }
            } catch (G1.d e6) {
                throw new r(e6);
            } catch (IOException e7) {
                throw new k(e7);
            }
        }
    }

    private static t<AtomicLong> b(t<Number> tVar) {
        return new d(tVar).a();
    }

    private static t<AtomicLongArray> c(t<Number> tVar) {
        return new C0001e(tVar).a();
    }

    static void d(double d6) {
        if (Double.isNaN(d6) || Double.isInfinite(d6)) {
            throw new IllegalArgumentException(d6 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private t<Number> e(boolean z5) {
        return z5 ? D1.n.f1151v : new a();
    }

    private t<Number> f(boolean z5) {
        return z5 ? D1.n.f1150u : new b();
    }

    private static t<Number> n(s sVar) {
        return sVar == s.f68a ? D1.n.f1149t : new c();
    }

    public <T> T g(G1.a aVar, Type type) {
        boolean zX = aVar.x();
        boolean z5 = true;
        aVar.d0(true);
        try {
            try {
                try {
                    aVar.V();
                    z5 = false;
                    return k(com.google.gson.reflect.a.get(type)).b(aVar);
                } catch (EOFException e6) {
                    if (!z5) {
                        throw new r(e6);
                    }
                    aVar.d0(zX);
                    return null;
                } catch (IllegalStateException e7) {
                    throw new r(e7);
                }
            } catch (IOException e8) {
                throw new r(e8);
            } catch (AssertionError e9) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e9.getMessage(), e9);
            }
        } finally {
            aVar.d0(zX);
        }
    }

    public <T> T h(Reader reader, Type type) {
        G1.a aVarO = o(reader);
        T t5 = (T) g(aVarO, type);
        a(t5, aVarO);
        return t5;
    }

    public <T> T i(String str, Class<T> cls) {
        return (T) C1.k.c(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public <T> t<T> k(com.google.gson.reflect.a<T> aVar) {
        boolean z5;
        t<T> tVar = (t) this.f38b.get(aVar == null ? f36v : aVar);
        if (tVar != null) {
            return tVar;
        }
        Map<com.google.gson.reflect.a<?>, f<?>> map = this.f37a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f37a.set(map);
            z5 = true;
        } else {
            z5 = false;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<u> it = this.f41e.iterator();
            while (it.hasNext()) {
                t<T> tVarB = it.next().b(this, aVar);
                if (tVarB != null) {
                    fVar2.e(tVarB);
                    this.f38b.put(aVar, tVarB);
                    return tVarB;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z5) {
                this.f37a.remove();
            }
        }
    }

    public <T> t<T> l(Class<T> cls) {
        return k(com.google.gson.reflect.a.get((Class) cls));
    }

    public <T> t<T> m(u uVar, com.google.gson.reflect.a<T> aVar) {
        if (!this.f41e.contains(uVar)) {
            uVar = this.f40d;
        }
        boolean z5 = false;
        for (u uVar2 : this.f41e) {
            if (z5) {
                t<T> tVarB = uVar2.b(this, aVar);
                if (tVarB != null) {
                    return tVarB;
                }
            } else if (uVar2 == uVar) {
                z5 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public G1.a o(Reader reader) {
        G1.a aVar = new G1.a(reader);
        aVar.d0(this.f50n);
        return aVar;
    }

    public G1.c p(Writer writer) throws IOException {
        if (this.f47k) {
            writer.write(")]}'\n");
        }
        G1.c cVar = new G1.c(writer);
        if (this.f49m) {
            cVar.O("  ");
        }
        cVar.T(this.f45i);
        return cVar;
    }

    public String q(j jVar) {
        StringWriter stringWriter = new StringWriter();
        u(jVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(l.f64a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(j jVar, G1.c cVar) {
        boolean zX = cVar.x();
        cVar.S(true);
        boolean zW = cVar.w();
        cVar.N(this.f48l);
        boolean zV = cVar.v();
        cVar.T(this.f45i);
        try {
            try {
                C1.l.b(jVar, cVar);
            } catch (IOException e6) {
                throw new k(e6);
            } catch (AssertionError e7) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e7.getMessage(), e7);
            }
        } finally {
            cVar.S(zX);
            cVar.N(zW);
            cVar.T(zV);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f45i + ",factories:" + this.f41e + ",instanceCreators:" + this.f39c + "}";
    }

    public void u(j jVar, Appendable appendable) {
        try {
            t(jVar, p(C1.l.c(appendable)));
        } catch (IOException e6) {
            throw new k(e6);
        }
    }

    public void v(Object obj, Type type, G1.c cVar) {
        t tVarK = k(com.google.gson.reflect.a.get(type));
        boolean zX = cVar.x();
        cVar.S(true);
        boolean zW = cVar.w();
        cVar.N(this.f48l);
        boolean zV = cVar.v();
        cVar.T(this.f45i);
        try {
            try {
                tVarK.d(cVar, obj);
            } catch (IOException e6) {
                throw new k(e6);
            } catch (AssertionError e7) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e7.getMessage(), e7);
            }
        } finally {
            cVar.S(zX);
            cVar.N(zW);
            cVar.T(zV);
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(C1.l.c(appendable)));
        } catch (IOException e6) {
            throw new k(e6);
        }
    }

    e(C1.d dVar, A1.d dVar2, Map<Type, A1.f<?>> map, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, s sVar, String str, int i5, int i6, List<u> list, List<u> list2, List<u> list3) {
        this.f37a = new ThreadLocal<>();
        this.f38b = new ConcurrentHashMap();
        this.f42f = dVar;
        this.f43g = dVar2;
        this.f44h = map;
        C1.c cVar = new C1.c(map);
        this.f39c = cVar;
        this.f45i = z5;
        this.f46j = z6;
        this.f47k = z7;
        this.f48l = z8;
        this.f49m = z9;
        this.f50n = z10;
        this.f51o = z11;
        this.f55s = sVar;
        this.f52p = str;
        this.f53q = i5;
        this.f54r = i6;
        this.f56t = list;
        this.f57u = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(D1.n.f1128Y);
        arrayList.add(D1.h.f1069b);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(D1.n.f1107D);
        arrayList.add(D1.n.f1142m);
        arrayList.add(D1.n.f1136g);
        arrayList.add(D1.n.f1138i);
        arrayList.add(D1.n.f1140k);
        t<Number> tVarN = n(sVar);
        arrayList.add(D1.n.b(Long.TYPE, Long.class, tVarN));
        arrayList.add(D1.n.b(Double.TYPE, Double.class, e(z11)));
        arrayList.add(D1.n.b(Float.TYPE, Float.class, f(z11)));
        arrayList.add(D1.n.f1153x);
        arrayList.add(D1.n.f1144o);
        arrayList.add(D1.n.f1146q);
        arrayList.add(D1.n.a(AtomicLong.class, b(tVarN)));
        arrayList.add(D1.n.a(AtomicLongArray.class, c(tVarN)));
        arrayList.add(D1.n.f1148s);
        arrayList.add(D1.n.f1155z);
        arrayList.add(D1.n.f1109F);
        arrayList.add(D1.n.f1111H);
        arrayList.add(D1.n.a(BigDecimal.class, D1.n.f1105B));
        arrayList.add(D1.n.a(BigInteger.class, D1.n.f1106C));
        arrayList.add(D1.n.f1113J);
        arrayList.add(D1.n.f1115L);
        arrayList.add(D1.n.f1119P);
        arrayList.add(D1.n.f1121R);
        arrayList.add(D1.n.f1126W);
        arrayList.add(D1.n.f1117N);
        arrayList.add(D1.n.f1133d);
        arrayList.add(D1.c.f1049b);
        arrayList.add(D1.n.f1124U);
        arrayList.add(D1.k.f1091b);
        arrayList.add(D1.j.f1089b);
        arrayList.add(D1.n.f1122S);
        arrayList.add(D1.a.f1043c);
        arrayList.add(D1.n.f1131b);
        arrayList.add(new D1.b(cVar));
        arrayList.add(new D1.g(cVar, z6));
        D1.d dVar3 = new D1.d(cVar);
        this.f40d = dVar3;
        arrayList.add(dVar3);
        arrayList.add(D1.n.f1129Z);
        arrayList.add(new D1.i(cVar, dVar2, dVar, dVar3));
        this.f41e = Collections.unmodifiableList(arrayList);
    }
}
