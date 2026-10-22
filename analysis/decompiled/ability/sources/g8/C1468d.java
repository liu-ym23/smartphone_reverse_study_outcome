package g8;

import H4.o;
import ca.AbstractC0897f;
import f8.C1445f;
import f8.C1446g;
import f8.C1447h;
import f8.C1448i;
import j9.t;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* renamed from: g8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1468d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4490a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final G8.b e;
    public static final G8.c f;
    public static final G8.b g;
    public static final HashMap h;
    public static final HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f4491j;
    public static final HashMap k;
    public static final HashMap l;
    public static final HashMap m;
    public static final List n;

    static {
        StringBuilder sb = new StringBuilder();
        C1445f c1445f = C1445f.c;
        sb.append(c1445f.f4445a);
        sb.append('.');
        sb.append(c1445f.b);
        f4490a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        C1446g c1446g = C1446g.c;
        sb2.append(c1446g.f4445a);
        sb2.append('.');
        sb2.append(c1446g.b);
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        C1448i c1448i = C1448i.c;
        sb3.append(c1448i.f4445a);
        sb3.append('.');
        sb3.append(c1448i.b);
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        C1447h c1447h = C1447h.c;
        sb4.append(c1447h.f4445a);
        sb4.append('.');
        sb4.append(c1447h.b);
        d = sb4.toString();
        G8.b bVarN = AbstractC0897f.N(new G8.c("kotlin.jvm.functions.FunctionN"));
        e = bVarN;
        f = bVarN.a();
        g = G8.i.f697s;
        d(Class.class);
        h = new HashMap();
        i = new HashMap();
        f4491j = new HashMap();
        k = new HashMap();
        l = new HashMap();
        m = new HashMap();
        G8.b bVarN2 = AbstractC0897f.N(e8.n.f4389B);
        G8.c cVar = e8.n.f4396J;
        G8.c cVar2 = bVarN2.f687a;
        C1467c c1467c = new C1467c(d(Iterable.class), bVarN2, new G8.b(cVar2, kotlin.reflect.jvm.internal.impl.name.a.b(cVar, cVar2), false));
        G8.b bVarN3 = AbstractC0897f.N(e8.n.f4388A);
        G8.c cVar3 = e8.n.f4395I;
        G8.c cVar4 = bVarN3.f687a;
        C1467c c1467c2 = new C1467c(d(Iterator.class), bVarN3, new G8.b(cVar4, kotlin.reflect.jvm.internal.impl.name.a.b(cVar3, cVar4), false));
        G8.b bVarN4 = AbstractC0897f.N(e8.n.f4390C);
        G8.c cVar5 = e8.n.f4397K;
        G8.c cVar6 = bVarN4.f687a;
        C1467c c1467c3 = new C1467c(d(Collection.class), bVarN4, new G8.b(cVar6, kotlin.reflect.jvm.internal.impl.name.a.b(cVar5, cVar6), false));
        G8.b bVarN5 = AbstractC0897f.N(e8.n.f4391D);
        G8.c cVar7 = e8.n.f4398L;
        G8.c cVar8 = bVarN5.f687a;
        C1467c c1467c4 = new C1467c(d(List.class), bVarN5, new G8.b(cVar8, kotlin.reflect.jvm.internal.impl.name.a.b(cVar7, cVar8), false));
        G8.b bVarN6 = AbstractC0897f.N(e8.n.f4392F);
        G8.c cVar9 = e8.n.f4400N;
        G8.c cVar10 = bVarN6.f687a;
        C1467c c1467c5 = new C1467c(d(Set.class), bVarN6, new G8.b(cVar10, kotlin.reflect.jvm.internal.impl.name.a.b(cVar9, cVar10), false));
        G8.b bVarN7 = AbstractC0897f.N(e8.n.E);
        G8.c cVar11 = e8.n.f4399M;
        G8.c cVar12 = bVarN7.f687a;
        C1467c c1467c6 = new C1467c(d(ListIterator.class), bVarN7, new G8.b(cVar12, kotlin.reflect.jvm.internal.impl.name.a.b(cVar11, cVar12), false));
        G8.c cVar13 = e8.n.f4393G;
        G8.b bVarN8 = AbstractC0897f.N(cVar13);
        G8.c cVar14 = e8.n.f4401O;
        G8.c cVar15 = bVarN8.f687a;
        C1467c c1467c7 = new C1467c(d(Map.class), bVarN8, new G8.b(cVar15, kotlin.reflect.jvm.internal.impl.name.a.b(cVar14, cVar15), false));
        G8.b bVarN9 = AbstractC0897f.N(cVar13);
        G8.f fVarF = e8.n.f4394H.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        G8.b bVarD = bVarN9.d(fVarF);
        G8.c cVar16 = e8.n.f4402P;
        G8.c cVar17 = bVarD.f687a;
        List<C1467c> listN = o.N(c1467c, c1467c2, c1467c3, c1467c4, c1467c5, c1467c6, c1467c7, new C1467c(d(Map.Entry.class), bVarD, new G8.b(cVar17, kotlin.reflect.jvm.internal.impl.name.a.b(cVar16, cVar17), false)));
        n = listN;
        c(Object.class, e8.n.f4413a);
        c(String.class, e8.n.f);
        c(CharSequence.class, e8.n.e);
        b(Throwable.class, e8.n.k);
        c(Cloneable.class, e8.n.c);
        c(Number.class, e8.n.i);
        b(Comparable.class, e8.n.l);
        c(Enum.class, e8.n.f4417j);
        b(Annotation.class, e8.n.f4420s);
        for (C1467c c1467c8 : listN) {
            G8.b bVar = c1467c8.f4489a;
            G8.b bVar2 = c1467c8.b;
            G8.b bVar3 = c1467c8.c;
            a(bVar, bVar2);
            i.put(bVar3.a().i(), bVar);
            l.put(bVar3, bVar2);
            m.put(bVar2, bVar3);
            G8.c cVarA = bVar2.a();
            G8.c cVarA2 = bVar3.a();
            f4491j.put(bVar3.a().i(), cVarA);
            k.put(cVarA.i(), cVarA2);
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            G8.c cVar18 = jvmPrimitiveType.d;
            if (cVar18 == null) {
                JvmPrimitiveType.a(15);
                throw null;
            }
            G8.c cVarE = cVar18.e();
            G8.f fVarF2 = cVar18.f();
            kotlin.jvm.internal.k.e(fVarF2, "shortName(...)");
            G8.b bVar4 = new G8.b(cVarE, fVarF2);
            PrimitiveType primitiveTypeD = jvmPrimitiveType.d();
            kotlin.jvm.internal.k.e(primitiveTypeD, "getPrimitiveType(...)");
            G8.c cVarC = e8.o.l.c(primitiveTypeD.f4943a);
            G8.c cVarE2 = cVarC.e();
            G8.f fVarF3 = cVarC.f();
            kotlin.jvm.internal.k.e(fVarF3, "shortName(...)");
            a(bVar4, new G8.b(cVarE2, fVarF3));
        }
        for (G8.b bVar5 : e8.d.f4380a) {
            G8.c cVar19 = new G8.c("kotlin.jvm.internal." + bVar5.f().b() + "CompanionObject");
            G8.c cVarE3 = cVar19.e();
            G8.f fVarF4 = cVar19.f();
            kotlin.jvm.internal.k.e(fVarF4, "shortName(...)");
            a(new G8.b(cVarE3, fVarF4), bVar5.d(G8.h.b));
        }
        for (int i6 = 0; i6 < 23; i6++) {
            G8.c cVar20 = new G8.c(B7.a.h(i6, "kotlin.jvm.functions.Function"));
            G8.c cVarE4 = cVar20.e();
            G8.f fVarF5 = cVar20.f();
            kotlin.jvm.internal.k.e(fVarF5, "shortName(...)");
            a(new G8.b(cVarE4, fVarF5), new G8.b(e8.o.l, G8.f.e("Function" + i6)));
            i.put(new G8.c(b + i6).i(), g);
        }
        for (int i10 = 0; i10 < 22; i10++) {
            C1447h c1447h2 = C1447h.c;
            i.put(new G8.c((c1447h2.f4445a + '.' + c1447h2.b) + i10).i(), g);
        }
        i.put(e8.n.b.g().i(), d(Void.class));
    }

    public static void a(G8.b bVar, G8.b bVar2) {
        h.put(bVar.a().i(), bVar2);
        i.put(bVar2.a().i(), bVar);
    }

    public static void b(Class cls, G8.c topLevelFqName) {
        G8.b bVarD = d(cls);
        kotlin.jvm.internal.k.f(topLevelFqName, "topLevelFqName");
        G8.c cVarE = topLevelFqName.e();
        G8.f fVarF = topLevelFqName.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        a(bVarD, new G8.b(cVarE, fVarF));
    }

    public static void c(Class cls, G8.e eVar) {
        b(cls, eVar.g());
    }

    public static G8.b d(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            return d(declaringClass).d(G8.f.e(cls.getSimpleName()));
        }
        G8.c cVar = new G8.c(cls.getCanonicalName());
        G8.c cVarE = cVar.e();
        G8.f fVarF = cVar.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        return new G8.b(cVarE, fVarF);
    }

    public static boolean e(G8.e eVar, String str) {
        Integer numF0;
        String str2 = eVar.f689a;
        if (str2 == null) {
            G8.e.a(4);
            throw null;
        }
        if (t.e0(str2, str, false)) {
            String strSubstring = str2.substring(str.length());
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            if (!j9.m.F0(strSubstring, '0') && (numF0 = t.f0(strSubstring)) != null && numF0.intValue() >= 23) {
                return true;
            }
        }
        return false;
    }

    public static G8.b f(G8.e eVar) {
        return (e(eVar, f4490a) || e(eVar, c)) ? e : (e(eVar, b) || e(eVar, d)) ? g : (G8.b) i.get(eVar);
    }
}
