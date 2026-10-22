package o8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f7829a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f7830b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f7829a = linkedHashMap;
        b(e9.i.f3223q, a("java.util.ArrayList", "java.util.LinkedList"));
        b(e9.i.f3224r, a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b(e9.i.f3225s, a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b(e9.b.j(new e9.c("java.util.function.Function")), a("java.util.function.UnaryOperator"));
        b(e9.b.j(new e9.c("java.util.function.BiFunction")), a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new c7.j(((e9.b) entry.getKey()).b(), ((e9.b) entry.getValue()).b()));
        }
        f7830b = d7.e0.Z(arrayList);
    }

    public static ArrayList a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(e9.b.j(new e9.c(str)));
        }
        return arrayList;
    }

    public static void b(e9.b bVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            f7829a.put(next, bVar);
        }
    }
}
