package H0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final r f2006a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2007b;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0034a<?>> f2008a = new HashMap();

        /* renamed from: H0.p$a$a, reason: collision with other inner class name */
        private static class C0034a<Model> {

            /* renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f2009a;

            public C0034a(List<n<Model, ?>> list) {
                this.f2009a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f2008a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0034a<?> c0034a = this.f2008a.get(cls);
            if (c0034a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0034a.f2009a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f2008a.put(cls, new C0034a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(D.e<List<Throwable>> eVar) {
        this(new r(eVar));
    }

    private static <A> Class<A> b(A a6) {
        return (Class<A>) a6.getClass();
    }

    private synchronized <A> List<n<A, ?>> e(Class<A> cls) {
        List<n<A, ?>> listB;
        listB = this.f2007b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f2006a.e(cls));
            this.f2007b.c(cls, listB);
        }
        return listB;
    }

    private <Model, Data> void g(List<o<? extends Model, ? extends Data>> list) {
        Iterator<o<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f2006a.b(cls, cls2, oVar);
        this.f2007b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f2006a.g(cls);
    }

    public <A> List<n<A, ?>> d(A a6) {
        List<n<A, ?>> listE = e(b(a6));
        int size = listE.size();
        List<n<A, ?>> arrayList = Collections.EMPTY_LIST;
        boolean z5 = true;
        for (int i5 = 0; i5 < size; i5++) {
            n<A, ?> nVar = listE.get(i5);
            if (nVar.a(a6)) {
                if (z5) {
                    arrayList = new ArrayList<>(size - i5);
                    z5 = false;
                }
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void f(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        g(this.f2006a.j(cls, cls2, oVar));
        this.f2007b.a();
    }

    private p(r rVar) {
        this.f2007b = new a();
        this.f2006a = rVar;
    }
}
