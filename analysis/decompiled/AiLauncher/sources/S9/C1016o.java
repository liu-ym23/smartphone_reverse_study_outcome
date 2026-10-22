package S9;

import ga.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: S9.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1016o {

    /* renamed from: a, reason: collision with root package name */
    public static final C1016o f5760a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<ga.b, ga.b> f5761b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<ga.c, ga.c> f5762c;

    static {
        C1016o c1016o = new C1016o();
        f5760a = c1016o;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f5761b = linkedHashMap;
        ga.h hVar = ga.h.f32812a;
        c1016o.c(hVar.m(), c1016o.a("java.util.ArrayList", "java.util.LinkedList"));
        c1016o.c(hVar.o(), c1016o.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        c1016o.c(hVar.n(), c1016o.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b.a aVar = ga.b.f32721d;
        c1016o.c(aVar.c(new ga.c("java.util.function.Function")), c1016o.a("java.util.function.UnaryOperator"));
        c1016o.c(aVar.c(new ga.c("java.util.function.BiFunction")), c1016o.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(Y8.j.a(((ga.b) entry.getKey()).a(), ((ga.b) entry.getValue()).a()));
        }
        f5762c = kotlin.collections.a.y(arrayList);
    }

    public final List<ga.b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ga.b.f32721d.c(new ga.c(str)));
        }
        return arrayList;
    }

    public final ga.c b(ga.c classFqName) {
        kotlin.jvm.internal.p.i(classFqName, "classFqName");
        return f5762c.get(classFqName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(ga.b bVar, List<ga.b> list) {
        Map<ga.b, ga.b> map = f5761b;
        for (Object obj : list) {
            map.put(obj, bVar);
        }
    }
}
