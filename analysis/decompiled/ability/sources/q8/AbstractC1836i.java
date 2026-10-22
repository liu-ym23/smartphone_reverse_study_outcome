package q8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* renamed from: q8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1836i {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f5601a;
    public static final Map b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f5601a = linkedHashMap;
        b(G8.i.f700w, a("java.util.ArrayList", "java.util.LinkedList"));
        b(G8.i.f701x, a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b(G8.i.y, a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        G8.c cVar = new G8.c("java.util.function.Function");
        G8.c cVarE = cVar.e();
        G8.f fVarF = cVar.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        b(new G8.b(cVarE, fVarF), a("java.util.function.UnaryOperator"));
        G8.c cVar2 = new G8.c("java.util.function.BiFunction");
        G8.c cVarE2 = cVar2.e();
        G8.f fVarF2 = cVar2.f();
        kotlin.jvm.internal.k.e(fVarF2, "shortName(...)");
        b(new G8.b(cVarE2, fVarF2), a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new Pair(((G8.b) entry.getKey()).a(), ((G8.b) entry.getValue()).a()));
        }
        b = kotlin.collections.a.X(arrayList);
    }

    public static ArrayList a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            G8.c cVar = new G8.c(str);
            G8.c cVarE = cVar.e();
            G8.f fVarF = cVar.f();
            kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
            arrayList.add(new G8.b(cVarE, fVarF));
        }
        return arrayList;
    }

    public static void b(G8.b bVar, ArrayList arrayList) {
        for (Object obj : arrayList) {
            f5601a.put(obj, bVar);
        }
    }
}
