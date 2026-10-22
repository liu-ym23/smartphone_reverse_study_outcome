package S9;

import C9.o;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* renamed from: S9.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1008g {

    /* renamed from: a, reason: collision with root package name */
    public static final C1008g f5749a = new C1008g();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<ga.c, ga.e> f5750b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<ga.e, List<ga.e>> f5751c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<ga.c> f5752d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<ga.c> f5753e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<ga.e> f5754f;

    static {
        ga.d dVar = o.a.f1930s;
        Pair pairA = Y8.j.a(C1009h.d(dVar, "name"), C9.o.f1832m);
        Pair pairA2 = Y8.j.a(C1009h.d(dVar, "ordinal"), ga.e.j("ordinal"));
        Pair pairA3 = Y8.j.a(C1009h.c(o.a.f1891X, ContentDisposition.Parameters.Size), ga.e.j(ContentDisposition.Parameters.Size));
        ga.c cVar = o.a.f1897b0;
        Map<ga.c, ga.e> mapM = kotlin.collections.a.m(pairA, pairA2, pairA3, Y8.j.a(C1009h.c(cVar, ContentDisposition.Parameters.Size), ga.e.j(ContentDisposition.Parameters.Size)), Y8.j.a(C1009h.d(o.a.f1906g, "length"), ga.e.j("length")), Y8.j.a(C1009h.c(cVar, "keys"), ga.e.j("keySet")), Y8.j.a(C1009h.c(cVar, "values"), ga.e.j("values")), Y8.j.a(C1009h.c(cVar, "entries"), ga.e.j("entrySet")), Y8.j.a(C1009h.c(o.a.f1877P0, ContentDisposition.Parameters.Size), ga.e.j("length")), Y8.j.a(C1009h.c(o.a.f1879Q0, ContentDisposition.Parameters.Size), ga.e.j("length")), Y8.j.a(C1009h.c(o.a.f1881R0, ContentDisposition.Parameters.Size), ga.e.j("length")));
        f5750b = mapM;
        Set<Map.Entry<ga.c, ga.e>> setEntrySet = mapM.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(C1174w.x(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((ga.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            ga.e eVar = (ga.e) pair.f();
            Object arrayList2 = linkedHashMap.get(eVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(eVar, arrayList2);
            }
            ((List) arrayList2).add((ga.e) pair.e());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Q.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), Z8.F.g0((Iterable) entry2.getValue()));
        }
        f5751c = linkedHashMap2;
        Map<ga.c, ga.e> map = f5750b;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<ga.c, ga.e> entry3 : map.entrySet()) {
            ga.b bVarN = D9.a.f2270a.n(entry3.getKey().d().i());
            kotlin.jvm.internal.p.f(bVarN);
            linkedHashSet.add(bVarN.a().b(entry3.getValue()));
        }
        f5752d = linkedHashSet;
        Set<ga.c> setKeySet = f5750b.keySet();
        f5753e = setKeySet;
        Set<ga.c> set = setKeySet;
        ArrayList arrayList3 = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ga.c) it2.next()).f());
        }
        f5754f = Z8.F.r1(arrayList3);
    }

    public final Map<ga.c, ga.e> a() {
        return f5750b;
    }

    public final List<ga.e> b(ga.e name1) {
        kotlin.jvm.internal.p.i(name1, "name1");
        List<ga.e> list = f5751c.get(name1);
        return list == null ? C1173v.m() : list;
    }

    public final Set<ga.c> c() {
        return f5753e;
    }

    public final Set<ga.e> d() {
        return f5754f;
    }
}
