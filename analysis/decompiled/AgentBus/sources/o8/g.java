package o8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7825a;

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f7826b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f7827c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f7828d;

    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, java.util.Map] */
    static {
        e9.e eVar = c8.m.f2039j;
        c7.j jVar = new c7.j(eVar.b(e9.f.e("name")).g(), e9.f.e("name"));
        c7.j jVar2 = new c7.j(eVar.b(e9.f.e("ordinal")).g(), e9.f.e("ordinal"));
        c7.j jVar3 = new c7.j(c8.m.B.c(e9.f.e("size")), e9.f.e("size"));
        e9.c cVar = c8.m.F;
        Map mapU = d7.e0.U(jVar, jVar2, jVar3, new c7.j(cVar.c(e9.f.e("size")), e9.f.e("size")), new c7.j(c8.m.f2034e.b(e9.f.e("length")).g(), e9.f.e("length")), new c7.j(cVar.c(e9.f.e("keys")), e9.f.e("keySet")), new c7.j(cVar.c(e9.f.e("values")), e9.f.e("values")), new c7.j(cVar.c(e9.f.e("entries")), e9.f.e("entrySet")));
        f7825a = mapU;
        Set<Map.Entry> setEntrySet = mapU.entrySet();
        ArrayList arrayList = new ArrayList(d7.t.A0(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new c7.j(((e9.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c7.j jVar4 = (c7.j) it.next();
            e9.f fVar = (e9.f) jVar4.f1974g;
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((e9.f) jVar4.f1973f);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(d7.e0.S(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), d7.r.J0((Iterable) entry2.getValue()));
        }
        f7826b = linkedHashMap2;
        Set setKeySet = f7825a.keySet();
        f7827c = setKeySet;
        Set set = setKeySet;
        ArrayList arrayList3 = new ArrayList(d7.t.A0(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((e9.c) it2.next()).f());
        }
        f7828d = d7.r.q1(arrayList3);
    }
}
