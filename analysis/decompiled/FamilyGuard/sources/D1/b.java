package D1;

import A1.t;
import A1.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final C1.c f1046a;

    private static final class a<E> extends t<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final t<E> f1047a;

        /* renamed from: b, reason: collision with root package name */
        private final C1.i<? extends Collection<E>> f1048b;

        public a(A1.e eVar, Type type, t<E> tVar, C1.i<? extends Collection<E>> iVar) {
            this.f1047a = new m(eVar, tVar, type);
            this.f1048b = iVar;
        }

        @Override // A1.t
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(G1.a aVar) throws IOException {
            if (aVar.V() == G1.b.NULL) {
                aVar.O();
                return null;
            }
            Collection<E> collectionA = this.f1048b.a();
            aVar.a();
            while (aVar.w()) {
                collectionA.add(this.f1047a.b(aVar));
            }
            aVar.r();
            return collectionA;
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.D();
                return;
            }
            cVar.f();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f1047a.d(cVar, it.next());
            }
            cVar.r();
        }
    }

    public b(C1.c cVar) {
        this.f1046a = cVar;
    }

    @Override // A1.u
    public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeH = C1.b.h(type, rawType);
        return new a(eVar, typeH, eVar.k(com.google.gson.reflect.a.get(typeH)), this.f1046a.a(aVar));
    }
}
