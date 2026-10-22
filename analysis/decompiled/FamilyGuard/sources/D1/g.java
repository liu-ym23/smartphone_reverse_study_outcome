package D1;

import A1.o;
import A1.r;
import A1.t;
import A1.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class g implements u {

    /* renamed from: a, reason: collision with root package name */
    private final C1.c f1063a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f1064b;

    private final class a<K, V> extends t<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final t<K> f1065a;

        /* renamed from: b, reason: collision with root package name */
        private final t<V> f1066b;

        /* renamed from: c, reason: collision with root package name */
        private final C1.i<? extends Map<K, V>> f1067c;

        public a(A1.e eVar, Type type, t<K> tVar, Type type2, t<V> tVar2, C1.i<? extends Map<K, V>> iVar) {
            this.f1065a = new m(eVar, tVar, type);
            this.f1066b = new m(eVar, tVar2, type2);
            this.f1067c = iVar;
        }

        private String e(A1.j jVar) {
            if (!jVar.n()) {
                if (jVar.i()) {
                    return "null";
                }
                throw new AssertionError();
            }
            o oVarF = jVar.f();
            if (oVarF.x()) {
                return String.valueOf(oVarF.t());
            }
            if (oVarF.v()) {
                return Boolean.toString(oVarF.o());
            }
            if (oVarF.z()) {
                return oVarF.u();
            }
            throw new AssertionError();
        }

        @Override // A1.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(G1.a aVar) throws IOException {
            G1.b bVarV = aVar.V();
            if (bVarV == G1.b.NULL) {
                aVar.O();
                return null;
            }
            Map<K, V> mapA = this.f1067c.a();
            if (bVarV != G1.b.BEGIN_ARRAY) {
                aVar.c();
                while (aVar.w()) {
                    C1.f.f565a.a(aVar);
                    K kB = this.f1065a.b(aVar);
                    if (mapA.put(kB, this.f1066b.b(aVar)) != null) {
                        throw new r("duplicate key: " + kB);
                    }
                }
                aVar.u();
                return mapA;
            }
            aVar.a();
            while (aVar.w()) {
                aVar.a();
                K kB2 = this.f1065a.b(aVar);
                if (mapA.put(kB2, this.f1066b.b(aVar)) != null) {
                    throw new r("duplicate key: " + kB2);
                }
                aVar.r();
            }
            aVar.r();
            return mapA;
        }

        @Override // A1.t
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(G1.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.D();
                return;
            }
            if (!g.this.f1064b) {
                cVar.m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.A(String.valueOf(entry.getKey()));
                    this.f1066b.d(cVar, entry.getValue());
                }
                cVar.u();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i5 = 0;
            boolean z5 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                A1.j jVarC = this.f1065a.c(entry2.getKey());
                arrayList.add(jVarC);
                arrayList2.add(entry2.getValue());
                z5 |= jVarC.h() || jVarC.m();
            }
            if (!z5) {
                cVar.m();
                int size = arrayList.size();
                while (i5 < size) {
                    cVar.A(e((A1.j) arrayList.get(i5)));
                    this.f1066b.d(cVar, arrayList2.get(i5));
                    i5++;
                }
                cVar.u();
                return;
            }
            cVar.f();
            int size2 = arrayList.size();
            while (i5 < size2) {
                cVar.f();
                C1.l.b((A1.j) arrayList.get(i5), cVar);
                this.f1066b.d(cVar, arrayList2.get(i5));
                cVar.r();
                i5++;
            }
            cVar.r();
        }
    }

    public g(C1.c cVar, boolean z5) {
        this.f1063a = cVar;
        this.f1064b = z5;
    }

    private t<?> a(A1.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f1135f : eVar.k(com.google.gson.reflect.a.get(type));
    }

    @Override // A1.u
    public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] typeArrJ = C1.b.j(type, C1.b.k(type));
        return new a(eVar, typeArrJ[0], a(eVar, typeArrJ[0]), typeArrJ[1], eVar.k(com.google.gson.reflect.a.get(typeArrJ[1])), this.f1063a.a(aVar));
    }
}
