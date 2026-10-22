package e9;

import d7.e0;
import d7.i0;
import d7.n;
import d7.t;
import java.util.LinkedHashMap;
import java.util.Set;
import q7.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3207a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f3208b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f3209c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f3210d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f3211e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f3212f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f3213g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f3214h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f3215i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f3216j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f3217k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f3218l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f3219m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f3220n;

    /* renamed from: o, reason: collision with root package name */
    public static final Set f3221o;

    /* renamed from: p, reason: collision with root package name */
    public static final Set f3222p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f3223q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f3224r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f3225s;

    /* renamed from: t, reason: collision with root package name */
    public static final b f3226t;

    static {
        c cVar = new c("kotlin");
        f3207a = cVar;
        c cVarC = cVar.c(f.e("reflect"));
        f3208b = cVarC;
        c cVarC2 = cVar.c(f.e("collections"));
        f3209c = cVarC2;
        c cVarC3 = cVar.c(f.e("ranges"));
        f3210d = cVarC3;
        cVar.c(f.e("jvm")).c(f.e("internal"));
        c cVarC4 = cVar.c(f.e("annotation"));
        f3211e = cVarC4;
        c cVarC5 = cVar.c(f.e("internal"));
        cVarC5.c(f.e("ir"));
        c cVarC6 = cVar.c(f.e("coroutines"));
        f3212f = cVarC6;
        f3213g = cVar.c(f.e("enums"));
        n.x0(new c[]{cVar, cVarC2, cVarC3, cVarC4, cVarC, cVarC5, cVarC6});
        j.a("Nothing");
        j.a("Unit");
        j.a("Any");
        j.a("Enum");
        j.a("Annotation");
        f3214h = j.a("Array");
        b bVarA = j.a("Boolean");
        b bVarA2 = j.a("Char");
        b bVarA3 = j.a("Byte");
        b bVarA4 = j.a("Short");
        b bVarA5 = j.a("Int");
        b bVarA6 = j.a("Long");
        b bVarA7 = j.a("Float");
        b bVarA8 = j.a("Double");
        f3215i = j.f(bVarA3);
        f3216j = j.f(bVarA4);
        f3217k = j.f(bVarA5);
        f3218l = j.f(bVarA6);
        j.a("CharSequence");
        f3219m = j.a("String");
        j.a("Throwable");
        j.a("Cloneable");
        j.e("KProperty");
        j.e("KMutableProperty");
        j.e("KProperty0");
        j.e("KMutableProperty0");
        j.e("KProperty1");
        j.e("KMutableProperty1");
        j.e("KProperty2");
        j.e("KMutableProperty2");
        f3220n = j.e("KFunction");
        j.e("KClass");
        j.e("KCallable");
        j.a("Comparable");
        j.a("Number");
        j.a("Function");
        Set setX0 = n.x0(new b[]{bVarA, bVarA2, bVarA3, bVarA4, bVarA5, bVarA6, bVarA7, bVarA8});
        f3221o = setX0;
        Set set = setX0;
        int iS = e0.S(t.A0(set, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
        for (Object obj : set) {
            f fVarI = ((b) obj).i();
            k.d(fVarI, "id.shortClassName");
            linkedHashMap.put(obj, j.d(fVarI));
        }
        j.c(linkedHashMap);
        Set setX02 = n.x0(new b[]{f3215i, f3216j, f3217k, f3218l});
        f3222p = setX02;
        Set set2 = setX02;
        int iS2 = e0.S(t.A0(set2, 10));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iS2 >= 16 ? iS2 : 16);
        for (Object obj2 : set2) {
            f fVarI2 = ((b) obj2).i();
            k.d(fVarI2, "id.shortClassName");
            linkedHashMap2.put(obj2, j.d(fVarI2));
        }
        j.c(linkedHashMap2);
        i0.Z(i0.Y(f3221o, f3222p), f3219m);
        c cVar2 = f3212f;
        f fVarE = f.e("Continuation");
        if (cVar2 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE);
        j.b("Iterator");
        j.b("Iterable");
        j.b("Collection");
        j.b("List");
        j.b("ListIterator");
        j.b("Set");
        b bVarB = j.b("Map");
        j.b("MutableIterator");
        j.b("CharIterator");
        j.b("MutableIterable");
        j.b("MutableCollection");
        f3223q = j.b("MutableList");
        j.b("MutableListIterator");
        f3224r = j.b("MutableSet");
        b bVarB2 = j.b("MutableMap");
        f3225s = bVarB2;
        bVarB.d(f.e("Entry"));
        bVarB2.d(f.e("MutableEntry"));
        j.a("Result");
        c cVar3 = f3210d;
        f fVarE2 = f.e("IntRange");
        if (cVar3 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE2);
        c.j(f.e("LongRange"));
        c.j(f.e("CharRange"));
        c cVar4 = f3211e;
        f fVarE3 = f.e("AnnotationRetention");
        if (cVar4 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE3);
        c.j(f.e("AnnotationTarget"));
        f3226t = new b(f3213g, f.e("EnumEntries"));
    }
}
