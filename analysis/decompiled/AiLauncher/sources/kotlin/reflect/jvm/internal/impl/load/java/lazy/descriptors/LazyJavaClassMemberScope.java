package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import C9.j;
import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.O;
import E9.P;
import E9.b0;
import E9.i0;
import H9.C0830i;
import H9.C0838q;
import H9.L;
import H9.M;
import H9.V;
import Ia.k;
import S9.C1011j;
import S9.E;
import S9.K;
import S9.r;
import S9.v;
import T9.o;
import U9.d;
import V9.c;
import V9.h;
import V9.k;
import W9.C1093b;
import W9.C1095d;
import W9.C1105n;
import W9.C1107p;
import W9.C1108q;
import W9.C1109s;
import W9.C1110t;
import W9.C1111u;
import W9.C1112v;
import W9.C1113w;
import W9.C1114x;
import W9.C1115y;
import W9.r;
import Z8.A;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Z;
import Z9.f;
import Z9.g;
import Z9.n;
import Z9.q;
import Z9.w;
import Z9.x;
import Z9.y;
import aa.l0;
import ba.u;
import ga.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ka.C4827g;
import ka.C4828h;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import p9.InterfaceC5074l;
import ra.C5231d;
import ua.InterfaceC5636v;
import v9.C5685n;
import xa.InterfaceC5864g;
import xa.InterfaceC5865h;
import ya.H0;
import ya.S;

/* loaded from: classes5.dex */
public final class LazyJavaClassMemberScope extends a {

    /* renamed from: n, reason: collision with root package name */
    public final InterfaceC0797b f35124n;

    /* renamed from: o, reason: collision with root package name */
    public final g f35125o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f35126p;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC5865h<List<kotlin.reflect.jvm.internal.impl.descriptors.b>> f35127q;

    /* renamed from: r, reason: collision with root package name */
    public final InterfaceC5865h<Set<e>> f35128r;

    /* renamed from: s, reason: collision with root package name */
    public final InterfaceC5865h<Set<e>> f35129s;

    /* renamed from: t, reason: collision with root package name */
    public final InterfaceC5865h<Map<e, n>> f35130t;

    /* renamed from: u, reason: collision with root package name */
    public final InterfaceC5864g<e, InterfaceC0797b> f35131u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(k c10, InterfaceC0797b ownerDescriptor, g jClass, boolean z10, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(c10, lazyJavaClassMemberScope);
        p.i(c10, "c");
        p.i(ownerDescriptor, "ownerDescriptor");
        p.i(jClass, "jClass");
        this.f35124n = ownerDescriptor;
        this.f35125o = jClass;
        this.f35126p = z10;
        this.f35127q = c10.e().i(new C1107p(this, c10));
        this.f35128r = c10.e().i(new C1108q(this));
        this.f35129s = c10.e().i(new r(c10, this));
        this.f35130t = c10.e().i(new C1109s(this));
        this.f35131u = c10.e().f(new C1110t(this, c10));
    }

    public static final Collection A0(LazyJavaClassMemberScope lazyJavaClassMemberScope, e it) {
        p.i(it, "it");
        return lazyJavaClassMemberScope.q1(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection] */
    public static final List C0(LazyJavaClassMemberScope lazyJavaClassMemberScope, k kVar) {
        Collection<Z9.k> collectionH = lazyJavaClassMemberScope.f35125o.h();
        ArrayList arrayList = new ArrayList(collectionH.size());
        Iterator<Z9.k> it = collectionH.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope.n1(it.next()));
        }
        if (lazyJavaClassMemberScope.f35125o.q()) {
            kotlin.reflect.jvm.internal.impl.descriptors.b bVarF0 = lazyJavaClassMemberScope.F0();
            String strC = u.c(bVarF0, false, false, 2, null);
            if (arrayList.isEmpty()) {
                arrayList.add(bVarF0);
                kVar.a().h().a(lazyJavaClassMemberScope.f35125o, bVarF0);
            } else {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (p.d(u.c((kotlin.reflect.jvm.internal.impl.descriptors.b) it2.next(), false, false, 2, null), strC)) {
                        break;
                    }
                }
                arrayList.add(bVarF0);
                kVar.a().h().a(lazyJavaClassMemberScope.f35125o, bVarF0);
            }
        }
        kVar.a().w().f(lazyJavaClassMemberScope.Q(), arrayList, kVar);
        l0 l0VarR = kVar.a().r();
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayListQ = arrayList;
        if (zIsEmpty) {
            arrayListQ = C1173v.q(lazyJavaClassMemberScope.E0());
        }
        return F.m1(l0VarR.p(kVar, arrayListQ));
    }

    public static /* synthetic */ U9.e K0(LazyJavaClassMemberScope lazyJavaClassMemberScope, Z9.r rVar, S s10, Modality modality, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            s10 = null;
        }
        return lazyJavaClassMemberScope.J0(rVar, s10, modality);
    }

    public static final Map T0(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        Collection<n> fields = lazyJavaClassMemberScope.f35125o.getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((n) obj).E()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((n) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }

    public static final Set X0(k kVar, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return F.r1(kVar.a().w().e(lazyJavaClassMemberScope.Q(), kVar));
    }

    public static final Collection f1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, LazyJavaClassMemberScope lazyJavaClassMemberScope, e accessorName) {
        p.i(accessorName, "accessorName");
        return p.d(gVar.getName(), accessorName) ? C1172u.e(gVar) : F.S0(lazyJavaClassMemberScope.p1(accessorName), lazyJavaClassMemberScope.q1(accessorName));
    }

    public static final Set g1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return F.r1(lazyJavaClassMemberScope.f35125o.y());
    }

    public static final InterfaceC0797b h1(LazyJavaClassMemberScope lazyJavaClassMemberScope, k kVar, e name) {
        p.i(name, "name");
        if (lazyJavaClassMemberScope.f35128r.invoke().contains(name)) {
            S9.r rVarD = kVar.a().d();
            ga.b bVarN = DescriptorUtilsKt.n(lazyJavaClassMemberScope.Q());
            p.f(bVarN);
            g gVarC = rVarD.c(new r.a(bVarN.d(name), null, lazyJavaClassMemberScope.f35125o, 2, null));
            if (gVarC == null) {
                return null;
            }
            C1105n c1105n = new C1105n(kVar, lazyJavaClassMemberScope.Q(), gVarC, null, 8, null);
            kVar.a().e().a(c1105n);
            return c1105n;
        }
        if (!lazyJavaClassMemberScope.f35129s.invoke().contains(name)) {
            n nVar = lazyJavaClassMemberScope.f35130t.invoke().get(name);
            if (nVar == null) {
                return null;
            }
            return C0838q.F0(kVar.e(), lazyJavaClassMemberScope.Q(), name, kVar.e().i(new C1115y(lazyJavaClassMemberScope)), h.a(kVar, nVar), kVar.a().t().a(nVar));
        }
        List<InterfaceC0797b> listC = C1172u.c();
        kVar.a().w().h(lazyJavaClassMemberScope.Q(), name, listC, kVar);
        List listA = C1172u.a(listC);
        int size = listA.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (InterfaceC0797b) F.X0(listA);
        }
        throw new IllegalStateException(("Multiple classes with same name are generated: " + listA).toString());
    }

    public static final Set i1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        return Z.o(lazyJavaClassMemberScope.b(), lazyJavaClassMemberScope.getVariableNames());
    }

    public static final boolean y0(q it) {
        p.i(it, "it");
        return !it.isStatic();
    }

    public static final Collection z0(LazyJavaClassMemberScope lazyJavaClassMemberScope, e it) {
        p.i(it, "it");
        return lazyJavaClassMemberScope.p1(it);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void A(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> result, e name) {
        p.i(result, "result");
        p.i(name, "name");
        Set<kotlin.reflect.jvm.internal.impl.descriptors.g> setA1 = a1(name);
        if (!SpecialGenericSignatures.f35098a.k(name) && !kotlin.reflect.jvm.internal.impl.load.java.b.f35118o.n(name)) {
            Set<kotlin.reflect.jvm.internal.impl.descriptors.g> set = setA1;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((kotlin.reflect.jvm.internal.impl.descriptors.e) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                if (e1((kotlin.reflect.jvm.internal.impl.descriptors.g) obj)) {
                    arrayList.add(obj);
                }
            }
            s0(result, name, arrayList, false);
            return;
        }
        Ia.k kVarA = Ia.k.f3419c.a();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionD = T9.a.d(name, setA1, C1173v.m(), Q(), InterfaceC5636v.f42653a, K().a().k().a());
        p.h(collectionD, "resolveOverridesForNonStaticMembers(...)");
        t0(name, result, collectionD, result, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        t0(name, result, collectionD, kVarA, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setA1) {
            if (e1((kotlin.reflect.jvm.internal.impl.descriptors.g) obj2)) {
                arrayList2.add(obj2);
            }
        }
        s0(result, name, F.S0(arrayList2, kVarA), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void B(e name, Collection<O> result) {
        p.i(name, "name");
        p.i(result, "result");
        if (this.f35125o.o()) {
            v0(name, result);
        }
        Set<O> setC1 = c1(name);
        if (setC1.isEmpty()) {
            return;
        }
        k.b bVar = Ia.k.f3419c;
        Ia.k kVarA = bVar.a();
        Ia.k kVarA2 = bVar.a();
        u0(setC1, result, kVarA, new C1113w(this));
        u0(Z.m(setC1, kVarA), kVarA2, null, new C1114x(this));
        Collection<? extends O> collectionD = T9.a.d(name, Z.o(setC1, kVarA2), result, Q(), K().a().c(), K().a().k().a());
        p.h(collectionD, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(collectionD);
    }

    public final Collection<S> B0() {
        if (!this.f35126p) {
            return K().a().k().d().g(Q());
        }
        Collection<S> collectionE = Q().j().e();
        p.h(collectionE, "getSupertypes(...)");
        return collectionE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<e> C(C5231d kindFilter, InterfaceC5074l<? super e, Boolean> interfaceC5074l) {
        p.i(kindFilter, "kindFilter");
        if (this.f35125o.o()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(M().invoke().d());
        Collection<S> collectionE = Q().j().e();
        p.h(collectionE, "getSupertypes(...)");
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            A.E(linkedHashSet, ((S) it.next()).m().getVariableNames());
        }
        return linkedHashSet;
    }

    public final List<i0> D0(C0830i c0830i) {
        LazyJavaClassMemberScope lazyJavaClassMemberScope;
        C0830i c0830i2;
        Pair pair;
        Collection<Z9.r> collectionZ = this.f35125o.z();
        ArrayList arrayList = new ArrayList(collectionZ.size());
        X9.a aVarB = X9.b.b(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionZ) {
            if (p.d(((Z9.r) obj).getName(), S9.F.f5685c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.a();
        List<Z9.r> list2 = (List) pair2.b();
        list.size();
        Z9.r rVar = (Z9.r) F.s0(list);
        if (rVar != null) {
            x returnType = rVar.getReturnType();
            if (returnType instanceof f) {
                f fVar = (f) returnType;
                pair = new Pair(K().g().l(fVar, aVarB, true), K().g().p(fVar.n(), aVarB));
            } else {
                pair = new Pair(K().g().p(returnType, aVarB), null);
            }
            S s10 = (S) pair.a();
            S s11 = (S) pair.b();
            lazyJavaClassMemberScope = this;
            c0830i2 = c0830i;
            lazyJavaClassMemberScope.r0(arrayList, c0830i2, 0, rVar, s10, s11);
        } else {
            lazyJavaClassMemberScope = this;
            c0830i2 = c0830i;
        }
        int i10 = 0;
        int i11 = rVar == null ? 0 : 1;
        for (Z9.r rVar2 : list2) {
            lazyJavaClassMemberScope.r0(arrayList, c0830i2, i10 + i11, rVar2, lazyJavaClassMemberScope.K().g().p(rVar2.getReturnType(), aVarB), null);
            i10++;
        }
        return arrayList;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.b E0() {
        boolean zO = this.f35125o.o();
        if ((this.f35125o.F() || !this.f35125o.r()) && !zO) {
            return null;
        }
        InterfaceC0797b interfaceC0797bQ = Q();
        U9.b bVarN1 = U9.b.n1(interfaceC0797bQ, F9.g.f2609m0.b(), true, K().a().t().a(this.f35125o));
        p.h(bVarN1, "createJavaConstructor(...)");
        List<i0> listD0 = zO ? D0(bVarN1) : Collections.EMPTY_LIST;
        bVarN1.T0(false);
        bVarN1.k1(listD0, Y0(interfaceC0797bQ));
        bVarN1.S0(true);
        bVarN1.a1(interfaceC0797bQ.n());
        K().a().h().a(this.f35125o, bVarN1);
        return bVarN1;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.b F0() {
        InterfaceC0797b interfaceC0797bQ = Q();
        U9.b bVarN1 = U9.b.n1(interfaceC0797bQ, F9.g.f2609m0.b(), true, K().a().t().a(this.f35125o));
        p.h(bVarN1, "createJavaConstructor(...)");
        List<i0> listL0 = L0(bVarN1);
        bVarN1.T0(false);
        bVarN1.k1(listL0, Y0(interfaceC0797bQ));
        bVarN1.S0(false);
        bVarN1.a1(interfaceC0797bQ.n());
        return bVarN1;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g G0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection) {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return gVar;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 : collection2) {
            if (!p.d(gVar, gVar2) && gVar2.m0() == null && P0(gVar2, aVar)) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = gVar.s().g().build();
                p.f(eVarBuild);
                return (kotlin.reflect.jvm.internal.impl.descriptors.g) eVarBuild;
            }
        }
        return gVar;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g H0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, InterfaceC5074l<? super e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        Object next;
        e name = eVar.getName();
        p.h(name, "getName(...)");
        Iterator<T> it = interfaceC5074l.invoke(name).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (d1((kotlin.reflect.jvm.internal.impl.descriptors.g) next, eVar)) {
                break;
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) next;
        if (gVar == null) {
            return null;
        }
        e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> aVarS = gVar.s();
        List<i0> listI = eVar.i();
        p.h(listI, "getValueParameters(...)");
        List<i0> list = listI;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((i0) it2.next()).getType());
        }
        List<i0> listI2 = gVar.i();
        p.h(listI2, "getValueParameters(...)");
        aVarS.b(U9.g.a(arrayList, listI2, eVar));
        aVarS.t();
        aVarS.j();
        aVarS.e(JavaMethodDescriptor.f35121H, Boolean.TRUE);
        return (kotlin.reflect.jvm.internal.impl.descriptors.g) aVarS.build();
    }

    public final U9.e I0(O o10, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarW0;
        M m10 = null;
        if (!O0(o10, interfaceC5074l)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarV0 = V0(o10, interfaceC5074l);
        p.f(gVarV0);
        if (o10.J()) {
            gVarW0 = W0(o10, interfaceC5074l);
            p.f(gVarW0);
        } else {
            gVarW0 = null;
        }
        if (gVarW0 != null) {
            gVarW0.p();
            gVarV0.p();
        }
        d dVar = new d(Q(), gVarV0, gVarW0, o10);
        S returnType = gVarV0.getReturnType();
        p.f(returnType);
        dVar.V0(returnType, C1173v.m(), N(), null, C1173v.m());
        L lK = C4827g.k(dVar, gVarV0.getAnnotations(), false, false, false, gVarV0.e());
        lK.H0(gVarV0);
        lK.K0(dVar.getType());
        p.h(lK, "apply(...)");
        if (gVarW0 != null) {
            List<i0> listI = gVarW0.i();
            p.h(listI, "getValueParameters(...)");
            i0 i0Var = (i0) F.s0(listI);
            if (i0Var == null) {
                throw new AssertionError("No parameter found for " + gVarW0);
            }
            m10 = C4827g.m(dVar, gVarW0.getAnnotations(), i0Var.getAnnotations(), false, false, false, gVarW0.getVisibility(), gVarW0.e());
            m10.H0(gVarW0);
        }
        dVar.O0(lK, m10);
        return dVar;
    }

    public final U9.e J0(Z9.r rVar, S s10, Modality modality) {
        U9.e eVar;
        LazyJavaClassMemberScope lazyJavaClassMemberScope;
        S sZ;
        U9.e eVarZ0 = U9.e.Z0(Q(), h.a(K(), rVar), modality, S9.O.d(rVar.getVisibility()), false, rVar.getName(), K().a().t().a(rVar), false);
        p.h(eVarZ0, "create(...)");
        L lD = C4827g.d(eVarZ0, F9.g.f2609m0.b());
        p.h(lD, "createDefaultGetter(...)");
        eVarZ0.O0(lD, null);
        if (s10 == null) {
            V9.k kVarI = c.i(K(), eVarZ0, rVar, 0, 4, null);
            eVar = eVarZ0;
            lazyJavaClassMemberScope = this;
            sZ = lazyJavaClassMemberScope.z(rVar, kVarI);
        } else {
            eVar = eVarZ0;
            lazyJavaClassMemberScope = this;
            sZ = s10;
        }
        eVar.V0(sZ, C1173v.m(), lazyJavaClassMemberScope.N(), null, C1173v.m());
        lD.K0(sZ);
        return eVar;
    }

    public final List<i0> L0(C0830i c0830i) {
        Collection<w> collectionM = this.f35125o.m();
        ArrayList arrayList = new ArrayList(collectionM.size());
        X9.a aVarB = X9.b.b(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<T> it = collectionM.iterator();
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (!it.hasNext()) {
                return arrayList;
            }
            i10 = i11 + 1;
            w wVar = (w) it.next();
            S sP = K().g().p(wVar.getType(), aVarB);
            arrayList.add(new V(c0830i, null, i11, F9.g.f2609m0.b(), wVar.getName(), sP, false, false, false, wVar.a() ? K().a().m().g().k(sP) : null, K().a().t().a(wVar)));
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g M0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, ga.e eVar) {
        e.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> aVarS = gVar.s();
        aVarS.n(eVar);
        aVarS.t();
        aVarS.j();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = aVarS.build();
        p.f(eVarBuild);
        return (kotlin.reflect.jvm.internal.impl.descriptors.g) eVarBuild;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public E9.S N() {
        return C4828h.l(Q());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.g N0(kotlin.reflect.jvm.internal.impl.descriptors.g r5) {
        /*
            r4 = this;
            java.util.List r4 = r5.i()
            java.lang.String r0 = "getValueParameters(...)"
            kotlin.jvm.internal.p.h(r4, r0)
            java.lang.Object r4 = Z8.F.E0(r4)
            E9.i0 r4 = (E9.i0) r4
            r1 = 0
            if (r4 == 0) goto L7d
            ya.S r2 = r4.getType()
            ya.v0 r2 = r2.H0()
            E9.d r2 = r2.d()
            if (r2 == 0) goto L35
            ga.d r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.p(r2)
            if (r2 == 0) goto L35
            boolean r3 = r2.f()
            if (r3 == 0) goto L2d
            goto L2e
        L2d:
            r2 = r1
        L2e:
            if (r2 == 0) goto L35
            ga.c r2 = r2.m()
            goto L36
        L35:
            r2 = r1
        L36:
            ga.c r3 = C9.o.f1842w
            boolean r2 = kotlin.jvm.internal.p.d(r2, r3)
            if (r2 == 0) goto L3f
            goto L40
        L3f:
            r4 = r1
        L40:
            if (r4 != 0) goto L43
            goto L7d
        L43:
            kotlin.reflect.jvm.internal.impl.descriptors.e$a r1 = r5.s()
            java.util.List r5 = r5.i()
            kotlin.jvm.internal.p.h(r5, r0)
            r0 = 1
            java.util.List r5 = Z8.F.i0(r5, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.e$a r5 = r1.b(r5)
            ya.S r4 = r4.getType()
            java.util.List r4 = r4.F0()
            r1 = 0
            java.lang.Object r4 = r4.get(r1)
            ya.B0 r4 = (ya.B0) r4
            ya.S r4 = r4.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.e$a r4 = r5.o(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.e r4 = r4.build()
            kotlin.reflect.jvm.internal.impl.descriptors.g r4 = (kotlin.reflect.jvm.internal.impl.descriptors.g) r4
            r5 = r4
            H9.O r5 = (H9.O) r5
            if (r5 == 0) goto L7c
            r5.b1(r0)
        L7c:
            return r4
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.N0(kotlin.reflect.jvm.internal.impl.descriptors.g):kotlin.reflect.jvm.internal.impl.descriptors.g");
    }

    public final boolean O0(O o10, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        if (C1095d.a(o10)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarV0 = V0(o10, interfaceC5074l);
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarW0 = W0(o10, interfaceC5074l);
        if (gVarV0 == null) {
            return false;
        }
        if (o10.J()) {
            return gVarW0 != null && gVarW0.p() == gVarV0.p();
        }
        return true;
    }

    public final boolean P0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil.OverrideCompatibilityInfo.Result resultC = OverridingUtil.f35978f.F(aVar2, aVar, true).c();
        p.h(resultC, "getResult(...)");
        return resultC == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !kotlin.reflect.jvm.internal.impl.load.java.c.f35119a.a(aVar2, aVar);
    }

    public final boolean Q0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f35098a;
        ga.e name = gVar.getName();
        p.h(name, "getName(...)");
        ga.e eVarB = aVar.b(name);
        if (eVarB == null) {
            return false;
        }
        Set<kotlin.reflect.jvm.internal.impl.descriptors.g> setA1 = a1(eVarB);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setA1) {
            if (kotlin.reflect.jvm.internal.impl.load.java.d.d((kotlin.reflect.jvm.internal.impl.descriptors.g) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarM0 = M0(gVar, eVarB);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (R0((kotlin.reflect.jvm.internal.impl.descriptors.g) it.next(), gVarM0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean R0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.a.f35117o.m(gVar)) {
            eVar = eVar.a();
        }
        p.f(eVar);
        return P0(eVar, gVar);
    }

    public final boolean S0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarN0 = N0(gVar);
        if (gVarN0 == null) {
            return false;
        }
        ga.e name = gVar.getName();
        p.h(name, "getName(...)");
        Set<kotlin.reflect.jvm.internal.impl.descriptors.g> setA1 = a1(name);
        if ((setA1 instanceof Collection) && setA1.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 : setA1) {
            if (gVar2.isSuspend() && P0(gVarN0, gVar2)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public boolean U(JavaMethodDescriptor javaMethodDescriptor) {
        p.i(javaMethodDescriptor, "<this>");
        if (this.f35125o.o()) {
            return false;
        }
        return e1(javaMethodDescriptor);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g U0(O o10, String str, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar;
        ga.e eVarJ = ga.e.j(str);
        p.h(eVarJ, "identifier(...)");
        Iterator<T> it = interfaceC5074l.invoke(eVarJ).iterator();
        do {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) it.next();
            if (gVar2.i().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.b bVar = kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a;
                S returnType = gVar2.getReturnType();
                if (returnType == null ? false : bVar.b(returnType, o10.getType())) {
                    gVar = gVar2;
                }
            }
        } while (gVar == null);
        return gVar;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g V0(O o10, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        P getter = o10.getGetter();
        P p10 = getter != null ? (P) kotlin.reflect.jvm.internal.impl.load.java.d.g(getter) : null;
        String strB = p10 != null ? C1011j.f5756a.b(p10) : null;
        if (strB != null && !kotlin.reflect.jvm.internal.impl.load.java.d.l(Q(), p10)) {
            return U0(o10, strB, interfaceC5074l);
        }
        String strB2 = o10.getName().b();
        p.h(strB2, "asString(...)");
        return U0(o10, E.b(strB2), interfaceC5074l);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g W0(O o10, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar;
        S returnType;
        String strB = o10.getName().b();
        p.h(strB, "asString(...)");
        ga.e eVarJ = ga.e.j(E.e(strB));
        p.h(eVarJ, "identifier(...)");
        Iterator<T> it = interfaceC5074l.invoke(eVarJ).iterator();
        do {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) it.next();
            if (gVar2.i().size() == 1 && (returnType = gVar2.getReturnType()) != null && j.D0(returnType)) {
                kotlin.reflect.jvm.internal.impl.types.checker.b bVar = kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a;
                List<i0> listI = gVar2.i();
                p.h(listI, "getValueParameters(...)");
                if (bVar.c(((i0) F.X0(listI)).getType(), o10.getType())) {
                    gVar = gVar2;
                }
            }
        } while (gVar == null);
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public a.C0439a X(Z9.r method, List<? extends b0> methodTypeParameters, S returnType, List<? extends i0> valueParameters) {
        p.i(method, "method");
        p.i(methodTypeParameters, "methodTypeParameters");
        p.i(returnType, "returnType");
        p.i(valueParameters, "valueParameters");
        o.b bVarA = K().a().s().a(method, Q(), returnType, null, valueParameters, methodTypeParameters);
        p.h(bVarA, "resolvePropagatedSignature(...)");
        S sD = bVarA.d();
        p.h(sD, "getReturnType(...)");
        S sC = bVarA.c();
        List<i0> listF = bVarA.f();
        p.h(listF, "getValueParameters(...)");
        List<b0> listE = bVarA.e();
        p.h(listE, "getTypeParameters(...)");
        boolean zG = bVarA.g();
        List<String> listB = bVarA.b();
        p.h(listB, "getErrors(...)");
        return new a.C0439a(sD, sC, listF, listE, zG, listB);
    }

    public final AbstractC0811p Y0(InterfaceC0797b interfaceC0797b) {
        AbstractC0811p visibility = interfaceC0797b.getVisibility();
        p.h(visibility, "getVisibility(...)");
        if (!p.d(visibility, v.f5777b)) {
            return visibility;
        }
        AbstractC0811p PROTECTED_AND_PACKAGE = v.f5778c;
        p.h(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
        return PROTECTED_AND_PACKAGE;
    }

    public final InterfaceC5865h<List<kotlin.reflect.jvm.internal.impl.descriptors.b>> Z0() {
        return this.f35127q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a, ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        m1(name, location);
        return super.a(name, location);
    }

    public final Set<kotlin.reflect.jvm.internal.impl.descriptors.g> a1(ga.e eVar) {
        Collection<S> collectionB0 = B0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionB0.iterator();
        while (it.hasNext()) {
            A.E(linkedHashSet, ((S) it.next()).m().c(eVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b Q() {
        return this.f35124n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a, ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        m1(name, location);
        return super.c(name, location);
    }

    public final Set<O> c1(ga.e eVar) {
        Collection<S> collectionB0 = B0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionB0.iterator();
        while (it.hasNext()) {
            Collection<? extends O> collectionA = ((S) it.next()).m().a(eVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(C1174w.x(collectionA, 10));
            Iterator<T> it2 = collectionA.iterator();
            while (it2.hasNext()) {
                arrayList2.add((O) it2.next());
            }
            A.E(arrayList, arrayList2);
        }
        return F.r1(arrayList);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        InterfaceC5864g<ga.e, InterfaceC0797b> interfaceC5864g;
        InterfaceC0797b interfaceC0797bInvoke;
        p.i(name, "name");
        p.i(location, "location");
        m1(name, location);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) P();
        return (lazyJavaClassMemberScope == null || (interfaceC5864g = lazyJavaClassMemberScope.f35131u) == null || (interfaceC0797bInvoke = interfaceC5864g.invoke(name)) == null) ? this.f35131u.invoke(name) : interfaceC0797bInvoke;
    }

    public final boolean d1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        String strC = u.c(gVar, false, false, 2, null);
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = eVar.a();
        p.h(eVarA, "getOriginal(...)");
        return p.d(strC, u.c(eVarA, false, false, 2, null)) && !P0(gVar, eVar);
    }

    public final boolean e1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
        ga.e name = gVar.getName();
        p.h(name, "getName(...)");
        List<ga.e> listA = K.a(name);
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Set<O> setC1 = c1((ga.e) it.next());
                if (!(setC1 instanceof Collection) || !setC1.isEmpty()) {
                    for (O o10 : setC1) {
                        if (O0(o10, new C1112v(gVar, this))) {
                            if (!o10.J()) {
                                String strB = gVar.getName().b();
                                p.h(strB, "asString(...)");
                                if (!E.d(strB)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (Q0(gVar) || r1(gVar) || S0(gVar)) ? false : true;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g j1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVarH0;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarL = kotlin.reflect.jvm.internal.impl.load.java.b.l(gVar);
        if (eVarL != null && (gVarH0 = H0(eVarL, interfaceC5074l)) != null) {
            if (!e1(gVarH0)) {
                gVarH0 = null;
            }
            if (gVarH0 != null) {
                return G0(gVarH0, eVarL, collection);
            }
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g k1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l, ga.e eVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.g) kotlin.reflect.jvm.internal.impl.load.java.d.g(gVar);
        if (gVar2 == null) {
            return null;
        }
        String strE = kotlin.reflect.jvm.internal.impl.load.java.d.e(gVar2);
        p.f(strE);
        ga.e eVarJ = ga.e.j(strE);
        p.h(eVarJ, "identifier(...)");
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> it = interfaceC5074l.invoke(eVarJ).iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.g gVarM0 = M0(it.next(), eVar);
            if (R0(gVar2, gVarM0)) {
                return G0(gVarM0, gVar2, collection);
            }
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g l1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        if (!gVar.isSuspend()) {
            return null;
        }
        ga.e name = gVar.getName();
        p.h(name, "getName(...)");
        Iterator<T> it = interfaceC5074l.invoke(name).iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.g gVarN0 = N0((kotlin.reflect.jvm.internal.impl.descriptors.g) it.next());
            if (gVarN0 == null || !P0(gVarN0, gVar)) {
                gVarN0 = null;
            }
            if (gVarN0 != null) {
                return gVarN0;
            }
        }
        return null;
    }

    public void m1(ga.e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        L9.a.a(K().a().l(), location, Q(), name);
    }

    public final U9.b n1(Z9.k kVar) {
        InterfaceC0797b interfaceC0797bQ = Q();
        U9.b bVarN1 = U9.b.n1(interfaceC0797bQ, h.a(K(), kVar), false, K().a().t().a(kVar));
        p.h(bVarN1, "createJavaConstructor(...)");
        V9.k kVarH = c.h(K(), bVarN1, kVar, interfaceC0797bQ.o().size());
        a.b bVarC0 = c0(kVarH, bVarN1, kVar.i());
        List<b0> listO = interfaceC0797bQ.o();
        p.h(listO, "getDeclaredTypeParameters(...)");
        List<b0> list = listO;
        List<y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(C1174w.x(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            b0 b0VarA = kVarH.f().a((y) it.next());
            p.f(b0VarA);
            arrayList.add(b0VarA);
        }
        bVarN1.l1(bVarC0.a(), S9.O.d(kVar.getVisibility()), F.S0(list, arrayList));
        bVarN1.S0(false);
        bVarN1.T0(bVarC0.b());
        bVarN1.a1(interfaceC0797bQ.n());
        kVarH.a().h().a(kVar, bVarN1);
        return bVarN1;
    }

    public final JavaMethodDescriptor o1(w wVar) {
        JavaMethodDescriptor javaMethodDescriptorJ1 = JavaMethodDescriptor.j1(Q(), h.a(K(), wVar), wVar.getName(), K().a().t().a(wVar), true);
        p.h(javaMethodDescriptorJ1, "createJavaMethod(...)");
        javaMethodDescriptorJ1.i1(null, N(), C1173v.m(), C1173v.m(), C1173v.m(), K().g().p(wVar.getType(), X9.b.b(TypeUsage.COMMON, false, false, null, 6, null)), Modality.Companion.a(false, false, true), C0810o.f2473e, null);
        javaMethodDescriptorJ1.m1(false, false);
        K().a().h().b(wVar, javaMethodDescriptorJ1);
        return javaMethodDescriptorJ1;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> p1(ga.e eVar) {
        Collection<Z9.r> collectionF = M().invoke().f(eVar);
        ArrayList arrayList = new ArrayList(C1174w.x(collectionF, 10));
        Iterator<T> it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(Y((Z9.r) it.next()));
        }
        return arrayList;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> q1(ga.e eVar) {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.g> setA1 = a1(eVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setA1) {
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) obj;
            if (!kotlin.reflect.jvm.internal.impl.load.java.d.d(gVar) && kotlin.reflect.jvm.internal.impl.load.java.b.l(gVar) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void r0(List<i0> list, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, int i10, Z9.r rVar, S s10, S s11) {
        F9.g gVarB = F9.g.f2609m0.b();
        ga.e name = rVar.getName();
        S sN = H0.n(s10);
        p.h(sN, "makeNotNullable(...)");
        list.add(new V(cVar, null, i10, gVarB, name, sN, rVar.J(), false, false, s11 != null ? H0.n(s11) : null, K().a().t().a(rVar)));
    }

    public final boolean r1(kotlin.reflect.jvm.internal.impl.descriptors.g gVar) {
        kotlin.reflect.jvm.internal.impl.load.java.b bVar = kotlin.reflect.jvm.internal.impl.load.java.b.f35118o;
        ga.e name = gVar.getName();
        p.h(name, "getName(...)");
        if (!bVar.n(name)) {
            return false;
        }
        ga.e name2 = gVar.getName();
        p.h(name2, "getName(...)");
        Set<kotlin.reflect.jvm.internal.impl.descriptors.g> setA1 = a1(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setA1.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarL = kotlin.reflect.jvm.internal.impl.load.java.b.l((kotlin.reflect.jvm.internal.impl.descriptors.g) it.next());
            if (eVarL != null) {
                arrayList.add(eVarL);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (d1(gVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public final void s0(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collection, ga.e eVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection2, boolean z10) {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collectionD = T9.a.d(eVar, collection2, collection, Q(), K().a().c(), K().a().k().a());
        p.h(collectionD, "resolveOverridesForNonStaticMembers(...)");
        if (!z10) {
            collection.addAll(collectionD);
            return;
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection3 = collectionD;
        List listS0 = F.S0(collection, collection3);
        ArrayList arrayList = new ArrayList(C1174w.x(collection3, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.g gVarG0 : collection3) {
            kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) kotlin.reflect.jvm.internal.impl.load.java.d.j(gVarG0);
            if (gVar == null) {
                p.f(gVarG0);
            } else {
                p.f(gVarG0);
                gVarG0 = G0(gVarG0, gVar, listS0);
            }
            arrayList.add(gVarG0);
        }
        collection.addAll(arrayList);
    }

    public final void t0(ga.e eVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> collection2, Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collection3, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.g gVar : collection2) {
            Ia.a.a(collection3, k1(gVar, interfaceC5074l, eVar, collection));
            Ia.a.a(collection3, j1(gVar, interfaceC5074l, collection));
            Ia.a.a(collection3, l1(gVar, interfaceC5074l));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public String toString() {
        return "Lazy Java member scope for " + this.f35125o.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public Set<ga.e> u(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        p.i(kindFilter, "kindFilter");
        return Z.o(this.f35128r.invoke(), this.f35130t.invoke().keySet());
    }

    public final void u0(Set<? extends O> set, Collection<O> collection, Set<O> set2, InterfaceC5074l<? super ga.e, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g>> interfaceC5074l) {
        for (O o10 : set) {
            U9.e eVarI0 = I0(o10, interfaceC5074l);
            if (eVarI0 != null) {
                collection.add(eVarI0);
                if (set2 != null) {
                    set2.add(o10);
                    return;
                }
                return;
            }
        }
    }

    public final void v0(ga.e eVar, Collection<O> collection) {
        Z9.r rVar = (Z9.r) F.Y0(M().invoke().f(eVar));
        if (rVar == null) {
            return;
        }
        collection.add(K0(this, rVar, null, Modality.FINAL, 2, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<ga.e> w(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l) {
        p.i(kindFilter, "kindFilter");
        Collection<S> collectionE = Q().j().e();
        p.h(collectionE, "getSupertypes(...)");
        LinkedHashSet<ga.e> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            A.E(linkedHashSet, ((S) it.next()).m().b());
        }
        linkedHashSet.addAll(M().invoke().b());
        linkedHashSet.addAll(M().invoke().c());
        linkedHashSet.addAll(u(kindFilter, interfaceC5074l));
        linkedHashSet.addAll(K().a().w().c(Q(), K()));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    public void x(Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> result, ga.e name) {
        p.i(result, "result");
        p.i(name, "name");
        if (this.f35125o.q() && M().invoke().a(name) != null) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.g> collection = result;
            if (collection.isEmpty()) {
                w wVarA = M().invoke().a(name);
                p.f(wVarA);
                result.add(o1(wVarA));
            } else {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((kotlin.reflect.jvm.internal.impl.descriptors.g) it.next()).i().isEmpty()) {
                        break;
                    }
                }
                w wVarA2 = M().invoke().a(name);
                p.f(wVarA2);
                result.add(o1(wVarA2));
            }
        }
        K().a().w().a(Q(), name, result, K());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public C1093b y() {
        return new C1093b(this.f35125o, C1111u.f6777a);
    }

    public /* synthetic */ LazyJavaClassMemberScope(V9.k kVar, InterfaceC0797b interfaceC0797b, g gVar, boolean z10, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i10, i iVar) {
        this(kVar, interfaceC0797b, gVar, z10, (i10 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }
}
