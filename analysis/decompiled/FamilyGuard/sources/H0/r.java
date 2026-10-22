package H0;

import H0.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v0.h;
import z0.C1342h;

/* loaded from: classes.dex */
public class r {

    /* renamed from: e, reason: collision with root package name */
    private static final c f2019e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f2020f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f2021a;

    /* renamed from: b, reason: collision with root package name */
    private final c f2022b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f2023c;

    /* renamed from: d, reason: collision with root package name */
    private final D.e<List<Throwable>> f2024d;

    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // H0.n
        public boolean a(Object obj) {
            return false;
        }

        @Override // H0.n
        public n.a<Object> b(Object obj, int i5, int i6, C1342h c1342h) {
            return null;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Model> f2025a;

        /* renamed from: b, reason: collision with root package name */
        final Class<Data> f2026b;

        /* renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f2027c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f2025a = cls;
            this.f2026b = cls2;
            this.f2027c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.f2025a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f2026b.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, D.e<List<Throwable>> eVar) {
            return new q<>(list, eVar);
        }
    }

    public r(D.e<List<Throwable>> eVar) {
        this(eVar, f2019e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z5) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f2021a;
        list.add(z5 ? list.size() : 0, bVar);
    }

    private <Model, Data> n<Model, Data> c(b<?, ?> bVar) {
        return (n) X0.j.d(bVar.f2027c.a(this));
    }

    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f2020f;
    }

    private <Model, Data> o<Model, Data> h(b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f2027c;
    }

    synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z5 = false;
            for (b<?, ?> bVar : this.f2021a) {
                if (this.f2023c.contains(bVar)) {
                    z5 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f2023c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f2023c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f2022b.a(arrayList, this.f2024d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z5) {
                throw new h.c(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f2023c.clear();
            throw th;
        }
    }

    synchronized <Model> List<n<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f2021a) {
                if (!this.f2023c.contains(bVar) && bVar.a(cls)) {
                    this.f2023c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f2023c.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f2021a) {
            if (!arrayList.contains(bVar.f2026b) && bVar.a(cls)) {
                arrayList.add(bVar.f2026b);
            }
        }
        return arrayList;
    }

    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> i(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f2021a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> listI;
        listI = i(cls, cls2);
        b(cls, cls2, oVar);
        return listI;
    }

    r(D.e<List<Throwable>> eVar, c cVar) {
        this.f2021a = new ArrayList();
        this.f2023c = new HashSet();
        this.f2024d = eVar;
        this.f2022b = cVar;
    }
}
