package G8;

import D7.N;
import D7.q;
import D7.w;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final c f693a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final Set h;
    public static final Set i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f694j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final b p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f695q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f696r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f697s;

    /* renamed from: t, reason: collision with root package name */
    public static final Set f698t;
    public static final Set u;

    /* renamed from: v, reason: collision with root package name */
    public static final Set f699v;

    /* renamed from: w, reason: collision with root package name */
    public static final b f700w;

    /* renamed from: x, reason: collision with root package name */
    public static final b f701x;
    public static final b y;

    /* renamed from: z, reason: collision with root package name */
    public static final b f702z;

    static {
        c cVar = new c("kotlin");
        f693a = cVar;
        c cVarC = cVar.c(f.e("reflect"));
        b = cVarC;
        c cVarC2 = cVar.c(f.e("collections"));
        c = cVarC2;
        c cVarC3 = cVar.c(f.e("ranges"));
        d = cVarC3;
        c cVarC4 = cVar.c(f.e("jvm"));
        cVarC4.c(f.e("internal"));
        cVarC4.c(f.e("functions"));
        c cVarC5 = cVar.c(f.e("annotation"));
        e = cVarC5;
        c cVarC6 = cVar.c(f.e("internal"));
        cVarC6.c(f.e("ir"));
        c cVarC7 = cVar.c(f.e("coroutines"));
        f = cVarC7;
        g = cVar.c(f.e("enums"));
        cVar.c(f.e("contracts"));
        cVar.c(f.e("concurrent"));
        cVar.c(f.e("test"));
        h = q.K0(new c[]{cVar, cVarC2, cVarC3, cVarC5});
        i = q.K0(new c[]{cVar, cVarC2, cVarC3, cVarC5, cVarC, cVarC6, cVarC7});
        com.stepos.ability.task.executor.e.h("Nothing");
        f694j = com.stepos.ability.task.executor.e.h("Unit");
        k = com.stepos.ability.task.executor.e.h("Any");
        l = com.stepos.ability.task.executor.e.h("Enum");
        com.stepos.ability.task.executor.e.h("Annotation");
        m = com.stepos.ability.task.executor.e.h("Array");
        b bVarH = com.stepos.ability.task.executor.e.h("Boolean");
        b bVarH2 = com.stepos.ability.task.executor.e.h("Char");
        b bVarH3 = com.stepos.ability.task.executor.e.h("Byte");
        b bVarH4 = com.stepos.ability.task.executor.e.h("Short");
        b bVarH5 = com.stepos.ability.task.executor.e.h("Int");
        b bVarH6 = com.stepos.ability.task.executor.e.h("Long");
        b bVarH7 = com.stepos.ability.task.executor.e.h("Float");
        b bVarH8 = com.stepos.ability.task.executor.e.h("Double");
        n = com.stepos.ability.task.executor.e.n(bVarH3);
        o = com.stepos.ability.task.executor.e.n(bVarH4);
        p = com.stepos.ability.task.executor.e.n(bVarH5);
        f695q = com.stepos.ability.task.executor.e.n(bVarH6);
        com.stepos.ability.task.executor.e.h("CharSequence");
        f696r = com.stepos.ability.task.executor.e.h("String");
        com.stepos.ability.task.executor.e.h("Throwable");
        com.stepos.ability.task.executor.e.h("Cloneable");
        com.stepos.ability.task.executor.e.m("KProperty");
        com.stepos.ability.task.executor.e.m("KMutableProperty");
        com.stepos.ability.task.executor.e.m("KProperty0");
        com.stepos.ability.task.executor.e.m("KMutableProperty0");
        com.stepos.ability.task.executor.e.m("KProperty1");
        com.stepos.ability.task.executor.e.m("KMutableProperty1");
        com.stepos.ability.task.executor.e.m("KProperty2");
        com.stepos.ability.task.executor.e.m("KMutableProperty2");
        f697s = com.stepos.ability.task.executor.e.m("KFunction");
        com.stepos.ability.task.executor.e.m("KClass");
        com.stepos.ability.task.executor.e.m("KCallable");
        com.stepos.ability.task.executor.e.m("KType");
        com.stepos.ability.task.executor.e.h("Comparable");
        com.stepos.ability.task.executor.e.h("Number");
        com.stepos.ability.task.executor.e.h("Function");
        Set setK0 = q.K0(new b[]{bVarH, bVarH2, bVarH3, bVarH4, bVarH5, bVarH6, bVarH7, bVarH8});
        f698t = setK0;
        u = q.K0(new b[]{bVarH3, bVarH4, bVarH5, bVarH6});
        Set set = setK0;
        int iP = kotlin.collections.a.P(w.c0(set, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Object obj : set) {
            linkedHashMap.put(obj, com.stepos.ability.task.executor.e.l(((b) obj).f()));
        }
        com.stepos.ability.task.executor.e.j(linkedHashMap);
        Set setK02 = q.K0(new b[]{n, o, p, f695q});
        f699v = setK02;
        Set set2 = setK02;
        int iP2 = kotlin.collections.a.P(w.c0(set2, 10));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iP2 >= 16 ? iP2 : 16);
        for (Object obj2 : set2) {
            linkedHashMap2.put(obj2, com.stepos.ability.task.executor.e.l(((b) obj2).f()));
        }
        com.stepos.ability.task.executor.e.j(linkedHashMap2);
        Set set3 = f698t;
        Set set4 = f699v;
        LinkedHashSet linkedHashSetL = N.L(set3, set4);
        b bVar = f696r;
        N.M(linkedHashSetL, bVar);
        c packageFqName = f;
        f fVarE = f.e("Continuation");
        k.f(packageFqName, "packageFqName");
        c.j(fVarE).d();
        com.stepos.ability.task.executor.e.i("Iterator");
        com.stepos.ability.task.executor.e.i("Iterable");
        com.stepos.ability.task.executor.e.i("Collection");
        com.stepos.ability.task.executor.e.i("List");
        com.stepos.ability.task.executor.e.i("ListIterator");
        com.stepos.ability.task.executor.e.i("Set");
        b bVarI = com.stepos.ability.task.executor.e.i("Map");
        com.stepos.ability.task.executor.e.i("MutableIterator");
        com.stepos.ability.task.executor.e.i("CharIterator");
        com.stepos.ability.task.executor.e.i("MutableIterable");
        com.stepos.ability.task.executor.e.i("MutableCollection");
        f700w = com.stepos.ability.task.executor.e.i("MutableList");
        com.stepos.ability.task.executor.e.i("MutableListIterator");
        f701x = com.stepos.ability.task.executor.e.i("MutableSet");
        b bVarI2 = com.stepos.ability.task.executor.e.i("MutableMap");
        y = bVarI2;
        bVarI.d(f.e("Entry"));
        bVarI2.d(f.e("MutableEntry"));
        com.stepos.ability.task.executor.e.h("Result");
        c packageFqName2 = d;
        f fVarE2 = f.e("IntRange");
        k.f(packageFqName2, "packageFqName");
        c.j(fVarE2).d();
        f fVarE3 = f.e("LongRange");
        k.f(packageFqName2, "packageFqName");
        c.j(fVarE3).d();
        f fVarE4 = f.e("CharRange");
        k.f(packageFqName2, "packageFqName");
        c.j(fVarE4).d();
        c packageFqName3 = e;
        f fVarE5 = f.e("AnnotationRetention");
        k.f(packageFqName3, "packageFqName");
        c.j(fVarE5).d();
        f fVarE6 = f.e("AnnotationTarget");
        k.f(packageFqName3, "packageFqName");
        c.j(fVarE6).d();
        com.stepos.ability.task.executor.e.h("DeprecationLevel");
        f702z = new b(g, f.e("EnumEntries"));
        N.M(N.M(N.M(N.M(N.L(set3, set4), bVar), f694j), k), l);
    }
}
