package q8;

import androidx.autofill.HintConstants;
import g8.C1468d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* renamed from: q8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1832e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5599a;
    public static final LinkedHashMap b;
    public static final Set c;
    public static final Set d;

    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.Object, java.util.Map] */
    static {
        G8.e eVar = e8.n.f4417j;
        Pair pair = new Pair(eVar.b(G8.f.e(HintConstants.AUTOFILL_HINT_NAME)).g(), e8.o.d);
        Pair pair2 = new Pair(eVar.b(G8.f.e("ordinal")).g(), G8.f.e("ordinal"));
        Pair pair3 = new Pair(e8.n.f4390C.c(G8.f.e("size")), G8.f.e("size"));
        G8.c cVar = e8.n.f4393G;
        Map mapR = kotlin.collections.a.R(pair, pair2, pair3, new Pair(cVar.c(G8.f.e("size")), G8.f.e("size")), new Pair(e8.n.e.b(G8.f.e("length")).g(), G8.f.e("length")), new Pair(cVar.c(G8.f.e("keys")), G8.f.e("keySet")), new Pair(cVar.c(G8.f.e("values")), G8.f.e("values")), new Pair(cVar.c(G8.f.e("entries")), G8.f.e("entrySet")));
        f5599a = mapR;
        Set<Map.Entry> setEntrySet = mapR.entrySet();
        ArrayList arrayList = new ArrayList(D7.w.c0(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new Pair(((G8.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair4 = (Pair) it.next();
            G8.f fVar = (G8.f) pair4.b;
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((G8.f) pair4.f4886a);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), D7.v.v0((Iterable) entry2.getValue()));
        }
        b = linkedHashMap2;
        ?? r02 = f5599a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry3 : r02.entrySet()) {
            String str = C1468d.f4490a;
            G8.e eVarI = ((G8.c) entry3.getKey()).e().i();
            kotlin.jvm.internal.k.e(eVarI, "toUnsafe(...)");
            G8.b bVarF = C1468d.f(eVarI);
            kotlin.jvm.internal.k.c(bVarF);
            linkedHashSet.add(bVarF.a().c((G8.f) entry3.getValue()));
        }
        Set setKeySet = f5599a.keySet();
        c = setKeySet;
        Set set = setKeySet;
        ArrayList arrayList3 = new ArrayList(D7.w.c0(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((G8.c) it2.next()).f());
        }
        d = D7.v.j1(arrayList3);
    }
}
