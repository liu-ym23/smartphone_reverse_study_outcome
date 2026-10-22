package e8;

import d7.s;
import ga.r;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import w7.e0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3123a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f3124b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f3125c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f3126d;

    /* renamed from: e, reason: collision with root package name */
    public static final e9.b f3127e;

    /* renamed from: f, reason: collision with root package name */
    public static final e9.c f3128f;

    /* renamed from: g, reason: collision with root package name */
    public static final e9.b f3129g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f3130h;

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f3131i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f3132j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f3133k;

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap f3134l;

    /* renamed from: m, reason: collision with root package name */
    public static final HashMap f3135m;

    /* renamed from: n, reason: collision with root package name */
    public static final List f3136n;

    static {
        StringBuilder sb2 = new StringBuilder();
        d8.e eVar = d8.e.f2994i;
        sb2.append(eVar.f2999f.f3188a.toString());
        sb2.append('.');
        sb2.append(eVar.f3000g);
        f3123a = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        d8.e eVar2 = d8.e.f2996k;
        sb3.append(eVar2.f2999f.f3188a.toString());
        sb3.append('.');
        sb3.append(eVar2.f3000g);
        f3124b = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        d8.e eVar3 = d8.e.f2995j;
        sb4.append(eVar3.f2999f.f3188a.toString());
        sb4.append('.');
        sb4.append(eVar3.f3000g);
        f3125c = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        d8.e eVar4 = d8.e.f2997l;
        sb5.append(eVar4.f2999f.f3188a.toString());
        sb5.append('.');
        sb5.append(eVar4.f3000g);
        f3126d = sb5.toString();
        e9.b bVarJ = e9.b.j(new e9.c("kotlin.jvm.functions.FunctionN"));
        f3127e = bVarJ;
        f3128f = bVarJ.b();
        f3129g = e9.i.f3220n;
        d(Class.class);
        f3130h = new HashMap();
        f3131i = new HashMap();
        f3132j = new HashMap();
        f3133k = new HashMap();
        f3134l = new HashMap();
        f3135m = new HashMap();
        e9.b bVarJ2 = e9.b.j(c8.m.A);
        e9.c cVar = c8.m.I;
        e9.c cVarG = bVarJ2.g();
        e9.c cVarG2 = bVarJ2.g();
        q7.k.d(cVarG2, "kotlinReadOnly.packageFqName");
        e9.c cVarM = e0.M(cVar, cVarG2);
        c cVar2 = new c(d(Iterable.class), bVarJ2, new e9.b(cVarG, cVarM, false));
        e9.b bVarJ3 = e9.b.j(c8.m.f2055z);
        e9.c cVar3 = c8.m.H;
        e9.c cVarG3 = bVarJ3.g();
        e9.c cVarG4 = bVarJ3.g();
        q7.k.d(cVarG4, "kotlinReadOnly.packageFqName");
        c cVar4 = new c(d(Iterator.class), bVarJ3, new e9.b(cVarG3, e0.M(cVar3, cVarG4), false));
        e9.b bVarJ4 = e9.b.j(c8.m.B);
        e9.c cVar5 = c8.m.J;
        e9.c cVarG5 = bVarJ4.g();
        e9.c cVarG6 = bVarJ4.g();
        q7.k.d(cVarG6, "kotlinReadOnly.packageFqName");
        c cVar6 = new c(d(Collection.class), bVarJ4, new e9.b(cVarG5, e0.M(cVar5, cVarG6), false));
        e9.b bVarJ5 = e9.b.j(c8.m.C);
        e9.c cVar7 = c8.m.K;
        e9.c cVarG7 = bVarJ5.g();
        e9.c cVarG8 = bVarJ5.g();
        q7.k.d(cVarG8, "kotlinReadOnly.packageFqName");
        c cVar8 = new c(d(List.class), bVarJ5, new e9.b(cVarG7, e0.M(cVar7, cVarG8), false));
        e9.b bVarJ6 = e9.b.j(c8.m.E);
        e9.c cVar9 = c8.m.M;
        e9.c cVarG9 = bVarJ6.g();
        e9.c cVarG10 = bVarJ6.g();
        q7.k.d(cVarG10, "kotlinReadOnly.packageFqName");
        c cVar10 = new c(d(Set.class), bVarJ6, new e9.b(cVarG9, e0.M(cVar9, cVarG10), false));
        e9.b bVarJ7 = e9.b.j(c8.m.D);
        e9.c cVar11 = c8.m.L;
        e9.c cVarG11 = bVarJ7.g();
        e9.c cVarG12 = bVarJ7.g();
        q7.k.d(cVarG12, "kotlinReadOnly.packageFqName");
        c cVar12 = new c(d(ListIterator.class), bVarJ7, new e9.b(cVarG11, e0.M(cVar11, cVarG12), false));
        e9.c cVar13 = c8.m.F;
        e9.b bVarJ8 = e9.b.j(cVar13);
        e9.c cVar14 = c8.m.N;
        e9.c cVarG13 = bVarJ8.g();
        e9.c cVarG14 = bVarJ8.g();
        q7.k.d(cVarG14, "kotlinReadOnly.packageFqName");
        c cVar15 = new c(d(Map.class), bVarJ8, new e9.b(cVarG13, e0.M(cVar14, cVarG14), false));
        e9.b bVarD = e9.b.j(cVar13).d(c8.m.G.f());
        e9.c cVar16 = c8.m.O;
        e9.c cVarG15 = bVarD.g();
        e9.c cVarG16 = bVarD.g();
        q7.k.d(cVarG16, "kotlinReadOnly.packageFqName");
        List<c> listU0 = s.u0(cVar2, cVar4, cVar6, cVar8, cVar10, cVar12, cVar15, new c(d(Map.Entry.class), bVarD, new e9.b(cVarG15, e0.M(cVar16, cVarG16), false)));
        f3136n = listU0;
        c(Object.class, c8.m.f2027a);
        c(String.class, c8.m.f2035f);
        c(CharSequence.class, c8.m.f2034e);
        a(d(Throwable.class), e9.b.j(c8.m.f2040k));
        c(Cloneable.class, c8.m.f2031c);
        c(Number.class, c8.m.f2038i);
        a(d(Comparable.class), e9.b.j(c8.m.f2041l));
        c(Enum.class, c8.m.f2039j);
        a(d(Annotation.class), e9.b.j(c8.m.f2048s));
        for (c cVar17 : listU0) {
            e9.b bVar = cVar17.f3120a;
            e9.b bVar2 = cVar17.f3121b;
            e9.b bVar3 = cVar17.f3122c;
            a(bVar, bVar2);
            b(bVar3.b(), bVar);
            f3134l.put(bVar3, bVar2);
            f3135m.put(bVar2, bVar3);
            e9.c cVarB = bVar2.b();
            e9.c cVarB2 = bVar3.b();
            HashMap map = f3132j;
            e9.e eVarI = bVar3.b().i();
            q7.k.d(eVarI, "mutableClassId.asSingleFqName().toUnsafe()");
            map.put(eVarI, cVarB);
            HashMap map2 = f3133k;
            e9.e eVarI2 = cVarB.i();
            q7.k.d(eVarI2, "readOnlyFqName.toUnsafe()");
            map2.put(eVarI2, cVarB2);
        }
        for (m9.c cVar18 : m9.c.values()) {
            e9.b bVarJ9 = e9.b.j(cVar18.e());
            c8.j jVarD = cVar18.d();
            q7.k.d(jVarD, "jvmType.primitiveType");
            a(bVarJ9, e9.b.j(c8.n.f2066k.c(jVarD.f2016f)));
        }
        for (e9.b bVar4 : c8.d.f1993a) {
            a(e9.b.j(new e9.c("kotlin.jvm.internal." + bVar4.i().b() + "CompanionObject")), bVar4.d(e9.h.f3201b));
        }
        for (int i2 = 0; i2 < 23; i2++) {
            a(e9.b.j(new e9.c(n.f.c(i2, "kotlin.jvm.functions.Function"))), new e9.b(c8.n.f2066k, e9.f.e("Function" + i2)));
            b(new e9.c(f3124b + i2), f3129g);
        }
        for (int i10 = 0; i10 < 22; i10++) {
            d8.e eVar5 = d8.e.f2997l;
            b(new e9.c((eVar5.f2999f.f3188a.toString() + '.' + eVar5.f3000g) + i10), f3129g);
        }
        b(c8.m.f2029b.g(), d(Void.class));
    }

    public static void a(e9.b bVar, e9.b bVar2) {
        e9.e eVarI = bVar.b().i();
        q7.k.d(eVarI, "javaClassId.asSingleFqName().toUnsafe()");
        f3130h.put(eVarI, bVar2);
        b(bVar2.b(), bVar);
    }

    public static void b(e9.c cVar, e9.b bVar) {
        e9.e eVarI = cVar.i();
        q7.k.d(eVarI, "kotlinFqNameUnsafe.toUnsafe()");
        f3131i.put(eVarI, bVar);
    }

    public static void c(Class cls, e9.e eVar) {
        a(d(cls), e9.b.j(eVar.g()));
    }

    public static e9.b d(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        return declaringClass == null ? e9.b.j(new e9.c(cls.getCanonicalName())) : d(declaringClass).d(e9.f.e(cls.getSimpleName()));
    }

    public static boolean e(e9.e eVar, String str) {
        Integer numI0;
        String str2 = eVar.f3193a;
        if (str2 == null) {
            e9.e.a(4);
            throw null;
        }
        String strF0 = ga.k.F0(str2, str, "");
        if (strF0.length() <= 0) {
            return false;
        }
        boolean z4 = false;
        if (strF0.length() > 0 && ib.c.w(strF0.charAt(0), '0', false)) {
            z4 = true;
        }
        return (z4 || (numI0 = r.i0(strF0)) == null || numI0.intValue() < 23) ? false : true;
    }

    public static e9.b f(e9.e eVar) {
        return (e(eVar, f3123a) || e(eVar, f3125c)) ? f3127e : (e(eVar, f3124b) || e(eVar, f3126d)) ? f3129g : (e9.b) f3131i.get(eVar);
    }
}
