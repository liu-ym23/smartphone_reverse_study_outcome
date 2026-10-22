package D9;

import C9.o;
import La.C;
import La.D;
import La.H;
import Z8.C1173v;
import ga.b;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2270a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2271b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f2272c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f2273d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f2274e;

    /* renamed from: f, reason: collision with root package name */
    public static final ga.b f2275f;

    /* renamed from: g, reason: collision with root package name */
    public static final ga.c f2276g;

    /* renamed from: h, reason: collision with root package name */
    public static final ga.b f2277h;

    /* renamed from: i, reason: collision with root package name */
    public static final ga.b f2278i;

    /* renamed from: j, reason: collision with root package name */
    public static final ga.b f2279j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap<ga.d, ga.b> f2280k;

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap<ga.d, ga.b> f2281l;

    /* renamed from: m, reason: collision with root package name */
    public static final HashMap<ga.d, ga.c> f2282m;

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap<ga.d, ga.c> f2283n;

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap<ga.b, ga.b> f2284o;

    /* renamed from: p, reason: collision with root package name */
    public static final HashMap<ga.b, ga.b> f2285p;

    /* renamed from: q, reason: collision with root package name */
    public static final List<C0022a> f2286q;

    /* renamed from: D9.a$a, reason: collision with other inner class name */
    public static final class C0022a {

        /* renamed from: a, reason: collision with root package name */
        public final ga.b f2287a;

        /* renamed from: b, reason: collision with root package name */
        public final ga.b f2288b;

        /* renamed from: c, reason: collision with root package name */
        public final ga.b f2289c;

        public C0022a(ga.b javaClass, ga.b kotlinReadOnly, ga.b kotlinMutable) {
            kotlin.jvm.internal.p.i(javaClass, "javaClass");
            kotlin.jvm.internal.p.i(kotlinReadOnly, "kotlinReadOnly");
            kotlin.jvm.internal.p.i(kotlinMutable, "kotlinMutable");
            this.f2287a = javaClass;
            this.f2288b = kotlinReadOnly;
            this.f2289c = kotlinMutable;
        }

        public final ga.b a() {
            return this.f2287a;
        }

        public final ga.b b() {
            return this.f2288b;
        }

        public final ga.b c() {
            return this.f2289c;
        }

        public final ga.b d() {
            return this.f2287a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0022a)) {
                return false;
            }
            C0022a c0022a = (C0022a) obj;
            return kotlin.jvm.internal.p.d(this.f2287a, c0022a.f2287a) && kotlin.jvm.internal.p.d(this.f2288b, c0022a.f2288b) && kotlin.jvm.internal.p.d(this.f2289c, c0022a.f2289c);
        }

        public int hashCode() {
            return (((this.f2287a.hashCode() * 31) + this.f2288b.hashCode()) * 31) + this.f2289c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f2287a + ", kotlinReadOnly=" + this.f2288b + ", kotlinMutable=" + this.f2289c + ')';
        }
    }

    static {
        a aVar = new a();
        f2270a = aVar;
        StringBuilder sb2 = new StringBuilder();
        e.a aVar2 = e.a.f34968f;
        sb2.append(aVar2.b());
        sb2.append('.');
        sb2.append(aVar2.a());
        f2271b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        e.b bVar = e.b.f34969f;
        sb3.append(bVar.b());
        sb3.append('.');
        sb3.append(bVar.a());
        f2272c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        e.d dVar = e.d.f34971f;
        sb4.append(dVar.b());
        sb4.append('.');
        sb4.append(dVar.a());
        f2273d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        e.c cVar = e.c.f34970f;
        sb5.append(cVar.b());
        sb5.append('.');
        sb5.append(cVar.a());
        f2274e = sb5.toString();
        b.a aVar3 = ga.b.f32721d;
        ga.b bVarC = aVar3.c(new ga.c("kotlin.jvm.functions.FunctionN"));
        f2275f = bVarC;
        f2276g = bVarC.a();
        ga.h hVar = ga.h.f32812a;
        f2277h = hVar.l();
        f2278i = hVar.k();
        f2279j = aVar.g(Class.class);
        f2280k = new HashMap<>();
        f2281l = new HashMap<>();
        f2282m = new HashMap<>();
        f2283n = new HashMap<>();
        f2284o = new HashMap<>();
        f2285p = new HashMap<>();
        ga.b bVarC2 = aVar3.c(o.a.f1890W);
        C0022a c0022a = new C0022a(aVar.g(Iterable.class), bVarC2, new ga.b(bVarC2.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1903e0, bVarC2.f()), false));
        ga.b bVarC3 = aVar3.c(o.a.f1888V);
        C0022a c0022a2 = new C0022a(aVar.g(Iterator.class), bVarC3, new ga.b(bVarC3.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1901d0, bVarC3.f()), false));
        ga.b bVarC4 = aVar3.c(o.a.f1891X);
        C0022a c0022a3 = new C0022a(aVar.g(Collection.class), bVarC4, new ga.b(bVarC4.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1905f0, bVarC4.f()), false));
        ga.b bVarC5 = aVar3.c(o.a.f1892Y);
        C0022a c0022a4 = new C0022a(aVar.g(List.class), bVarC5, new ga.b(bVarC5.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1907g0, bVarC5.f()), false));
        ga.b bVarC6 = aVar3.c(o.a.f1895a0);
        C0022a c0022a5 = new C0022a(aVar.g(Set.class), bVarC6, new ga.b(bVarC6.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1911i0, bVarC6.f()), false));
        ga.b bVarC7 = aVar3.c(o.a.f1893Z);
        C0022a c0022a6 = new C0022a(aVar.g(ListIterator.class), bVarC7, new ga.b(bVarC7.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1909h0, bVarC7.f()), false));
        ga.c cVar2 = o.a.f1897b0;
        ga.b bVarC8 = aVar3.c(cVar2);
        C0022a c0022a7 = new C0022a(aVar.g(Map.class), bVarC8, new ga.b(bVarC8.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1913j0, bVarC8.f()), false));
        ga.b bVarD = aVar3.c(cVar2).d(o.a.f1899c0.f());
        List<C0022a> listP = C1173v.p(c0022a, c0022a2, c0022a3, c0022a4, c0022a5, c0022a6, c0022a7, new C0022a(aVar.g(Map.Entry.class), bVarD, new ga.b(bVarD.f(), kotlin.reflect.jvm.internal.impl.name.a.g(o.a.f1915k0, bVarD.f()), false)));
        f2286q = listP;
        aVar.f(Object.class, o.a.f1896b);
        aVar.f(String.class, o.a.f1908h);
        aVar.f(CharSequence.class, o.a.f1906g);
        aVar.e(Throwable.class, o.a.f1934u);
        aVar.f(Cloneable.class, o.a.f1900d);
        aVar.f(Number.class, o.a.f1928r);
        aVar.e(Comparable.class, o.a.f1936v);
        aVar.f(Enum.class, o.a.f1930s);
        aVar.e(Annotation.class, o.a.f1858G);
        Iterator<C0022a> it = listP.iterator();
        while (it.hasNext()) {
            f2270a.d(it.next());
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            a aVar4 = f2270a;
            b.a aVar5 = ga.b.f32721d;
            ga.c wrapperFqName = jvmPrimitiveType.getWrapperFqName();
            kotlin.jvm.internal.p.h(wrapperFqName, "getWrapperFqName(...)");
            ga.b bVarC9 = aVar5.c(wrapperFqName);
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            kotlin.jvm.internal.p.h(primitiveType, "getPrimitiveType(...)");
            aVar4.a(bVarC9, aVar5.c(C9.o.c(primitiveType)));
        }
        for (ga.b bVar2 : C9.d.f1773a.a()) {
            f2270a.a(ga.b.f32721d.c(new ga.c("kotlin.jvm.internal." + bVar2.h().b() + "CompanionObject")), bVar2.d(ga.g.f32744d));
        }
        for (int i10 = 0; i10 < 23; i10++) {
            a aVar6 = f2270a;
            aVar6.a(ga.b.f32721d.c(new ga.c("kotlin.jvm.functions.Function" + i10)), C9.o.a(i10));
            aVar6.c(new ga.c(f2272c + i10), f2277h);
        }
        for (int i11 = 0; i11 < 22; i11++) {
            e.c cVar3 = e.c.f34970f;
            f2270a.c(new ga.c((cVar3.b() + '.' + cVar3.a()) + i11), f2277h);
        }
        a aVar7 = f2270a;
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicInt"), aVar7.g(AtomicInteger.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicLong"), aVar7.g(AtomicLong.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicBoolean"), aVar7.g(AtomicBoolean.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicReference"), aVar7.g(AtomicReference.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicIntArray"), aVar7.g(AtomicIntegerArray.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicLongArray"), aVar7.g(AtomicLongArray.class));
        aVar7.c(new ga.c("kotlin.concurrent.atomics.AtomicArray"), aVar7.g(AtomicReferenceArray.class));
        aVar7.c(o.a.f1898c.m(), aVar7.g(Void.class));
    }

    public final void a(ga.b bVar, ga.b bVar2) {
        b(bVar, bVar2);
        c(bVar2.a(), bVar);
    }

    public final void b(ga.b bVar, ga.b bVar2) {
        f2280k.put(bVar.a().i(), bVar2);
    }

    public final void c(ga.c cVar, ga.b bVar) {
        f2281l.put(cVar.i(), bVar);
    }

    public final void d(C0022a c0022a) {
        ga.b bVarA = c0022a.a();
        ga.b bVarB = c0022a.b();
        ga.b bVarC = c0022a.c();
        a(bVarA, bVarB);
        c(bVarC.a(), bVarA);
        f2284o.put(bVarC, bVarB);
        f2285p.put(bVarB, bVarC);
        ga.c cVarA = bVarB.a();
        ga.c cVarA2 = bVarC.a();
        f2282m.put(bVarC.a().i(), cVarA);
        f2283n.put(cVarA.i(), cVarA2);
    }

    public final void e(Class<?> cls, ga.c cVar) {
        a(g(cls), ga.b.f32721d.c(cVar));
    }

    public final void f(Class<?> cls, ga.d dVar) {
        e(cls, dVar.m());
    }

    public final ga.b g(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            b.a aVar = ga.b.f32721d;
            String canonicalName = cls.getCanonicalName();
            kotlin.jvm.internal.p.h(canonicalName, "getCanonicalName(...)");
            return aVar.c(new ga.c(canonicalName));
        }
        ga.b bVarG = g(declaringClass);
        ga.e eVarJ = ga.e.j(cls.getSimpleName());
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        return bVarG.d(eVarJ);
    }

    public final ga.c h() {
        return f2276g;
    }

    public final List<C0022a> i() {
        return f2286q;
    }

    public final boolean j(ga.d dVar, String str) {
        Integer numW;
        String strA = dVar.a();
        if (!D.X(strA, str, false, 2, null)) {
            return false;
        }
        String strSubstring = strA.substring(str.length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return (H.i1(strSubstring, '0', false, 2, null) || (numW = C.w(strSubstring)) == null || numW.intValue() < 23) ? false : true;
    }

    public final boolean k(ga.d dVar) {
        return f2282m.containsKey(dVar);
    }

    public final boolean l(ga.d dVar) {
        return f2283n.containsKey(dVar);
    }

    public final ga.b m(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return f2280k.get(fqName.i());
    }

    public final ga.b n(ga.d kotlinFqName) {
        kotlin.jvm.internal.p.i(kotlinFqName, "kotlinFqName");
        if (!j(kotlinFqName, f2271b) && !j(kotlinFqName, f2273d)) {
            if (!j(kotlinFqName, f2272c) && !j(kotlinFqName, f2274e)) {
                return f2281l.get(kotlinFqName);
            }
            return f2277h;
        }
        return f2275f;
    }

    public final ga.c o(ga.d dVar) {
        return f2282m.get(dVar);
    }

    public final ga.c p(ga.d dVar) {
        return f2283n.get(dVar);
    }
}
