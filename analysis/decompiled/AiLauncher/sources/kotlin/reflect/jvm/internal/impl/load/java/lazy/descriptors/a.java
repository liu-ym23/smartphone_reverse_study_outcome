package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import C9.j;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import E9.b0;
import E9.i0;
import E9.j0;
import H9.V;
import V9.c;
import V9.h;
import V9.k;
import W9.G;
import W9.H;
import W9.I;
import W9.InterfaceC1094c;
import W9.J;
import W9.K;
import W9.L;
import W9.M;
import W9.N;
import W9.P;
import W9.Q;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.IndexedValue;
import Z9.B;
import Z9.f;
import Z9.n;
import Z9.r;
import Z9.x;
import Z9.y;
import ba.u;
import ga.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ka.C4827g;
import ka.C4828h;
import ka.C4835o;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import ma.AbstractC4927g;
import p9.InterfaceC5074l;
import ra.AbstractC5230c;
import ra.AbstractC5239l;
import ra.C5231d;
import ra.InterfaceC5238k;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5863f;
import xa.InterfaceC5864g;
import xa.InterfaceC5865h;
import xa.InterfaceC5866i;
import ya.H0;
import ya.S;

/* loaded from: classes5.dex */
public abstract class a extends AbstractC5239l {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f35132m = {t.i(new PropertyReference1Impl(a.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), t.i(new PropertyReference1Impl(a.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), t.i(new PropertyReference1Impl(a.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};

    /* renamed from: b, reason: collision with root package name */
    public final k f35133b;

    /* renamed from: c, reason: collision with root package name */
    public final a f35134c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h<Collection<InterfaceC0803h>> f35135d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h<InterfaceC1094c> f35136e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5863f<e, Collection<g>> f35137f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5864g<e, O> f35138g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC5863f<e, Collection<g>> f35139h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC5865h f35140i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5865h f35141j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC5865h f35142k;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC5863f<e, List<O>> f35143l;

    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a$a, reason: collision with other inner class name */
    public static final class C0439a {

        /* renamed from: a, reason: collision with root package name */
        public final S f35144a;

        /* renamed from: b, reason: collision with root package name */
        public final S f35145b;

        /* renamed from: c, reason: collision with root package name */
        public final List<i0> f35146c;

        /* renamed from: d, reason: collision with root package name */
        public final List<b0> f35147d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f35148e;

        /* renamed from: f, reason: collision with root package name */
        public final List<String> f35149f;

        /* JADX WARN: Multi-variable type inference failed */
        public C0439a(S returnType, S s10, List<? extends i0> valueParameters, List<? extends b0> typeParameters, boolean z10, List<String> errors) {
            p.i(returnType, "returnType");
            p.i(valueParameters, "valueParameters");
            p.i(typeParameters, "typeParameters");
            p.i(errors, "errors");
            this.f35144a = returnType;
            this.f35145b = s10;
            this.f35146c = valueParameters;
            this.f35147d = typeParameters;
            this.f35148e = z10;
            this.f35149f = errors;
        }

        public final List<String> a() {
            return this.f35149f;
        }

        public final boolean b() {
            return this.f35148e;
        }

        public final S c() {
            return this.f35145b;
        }

        public final S d() {
            return this.f35144a;
        }

        public final List<b0> e() {
            return this.f35147d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0439a)) {
                return false;
            }
            C0439a c0439a = (C0439a) obj;
            return p.d(this.f35144a, c0439a.f35144a) && p.d(this.f35145b, c0439a.f35145b) && p.d(this.f35146c, c0439a.f35146c) && p.d(this.f35147d, c0439a.f35147d) && this.f35148e == c0439a.f35148e && p.d(this.f35149f, c0439a.f35149f);
        }

        public final List<i0> f() {
            return this.f35146c;
        }

        public int hashCode() {
            int iHashCode = this.f35144a.hashCode() * 31;
            S s10 = this.f35145b;
            return ((((((((iHashCode + (s10 == null ? 0 : s10.hashCode())) * 31) + this.f35146c.hashCode()) * 31) + this.f35147d.hashCode()) * 31) + Boolean.hashCode(this.f35148e)) * 31) + this.f35149f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.f35144a + ", receiverType=" + this.f35145b + ", valueParameters=" + this.f35146c + ", typeParameters=" + this.f35147d + ", hasStableParameterNames=" + this.f35148e + ", errors=" + this.f35149f + ')';
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<i0> f35150a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f35151b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends i0> descriptors, boolean z10) {
            p.i(descriptors, "descriptors");
            this.f35150a = descriptors;
            this.f35151b = z10;
        }

        public final List<i0> a() {
            return this.f35150a;
        }

        public final boolean b() {
            return this.f35151b;
        }
    }

    public a(k c10, a aVar) {
        p.i(c10, "c");
        this.f35133b = c10;
        this.f35134c = aVar;
        this.f35135d = c10.e().d(new G(this), C1173v.m());
        this.f35136e = c10.e().i(new J(this));
        this.f35137f = c10.e().c(new K(this));
        this.f35138g = c10.e().f(new L(this));
        this.f35139h = c10.e().c(new M(this));
        this.f35140i = c10.e().i(new N(this));
        this.f35141j = c10.e().i(new W9.O(this));
        this.f35142k = c10.e().i(new P(this));
        this.f35143l = c10.e().c(new Q(this));
    }

    public static final O E(a aVar, e name) {
        p.i(name, "name");
        a aVar2 = aVar.f35134c;
        if (aVar2 != null) {
            return aVar2.f35138g.invoke(name);
        }
        n nVarE = aVar.f35136e.invoke().e(name);
        if (nVarE == null || nVarE.E()) {
            return null;
        }
        return aVar.Z(nVarE);
    }

    public static final Collection F(a aVar, e name) {
        p.i(name, "name");
        a aVar2 = aVar.f35134c;
        if (aVar2 != null) {
            return aVar2.f35137f.invoke(name);
        }
        ArrayList arrayList = new ArrayList();
        for (r rVar : aVar.f35136e.invoke().f(name)) {
            JavaMethodDescriptor javaMethodDescriptorY = aVar.Y(rVar);
            if (aVar.U(javaMethodDescriptorY)) {
                aVar.f35133b.a().h().b(rVar, javaMethodDescriptorY);
                arrayList.add(javaMethodDescriptorY);
            }
        }
        aVar.x(arrayList, name);
        return arrayList;
    }

    public static final InterfaceC1094c G(a aVar) {
        return aVar.y();
    }

    public static final Set H(a aVar) {
        return aVar.w(C5231d.f38876v, null);
    }

    public static final Collection I(a aVar, e name) {
        p.i(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet(aVar.f35137f.invoke(name));
        aVar.d0(linkedHashSet);
        aVar.A(linkedHashSet, name);
        return F.m1(aVar.f35133b.a().r().p(aVar.f35133b, linkedHashSet));
    }

    public static final List V(a aVar, e name) {
        p.i(name, "name");
        ArrayList arrayList = new ArrayList();
        Ia.a.a(arrayList, aVar.f35138g.invoke(name));
        aVar.B(name, arrayList);
        return C4828h.t(aVar.Q()) ? F.m1(arrayList) : F.m1(aVar.f35133b.a().r().p(aVar.f35133b, arrayList));
    }

    public static final Set W(a aVar) {
        return aVar.C(C5231d.f38877w, null);
    }

    public static final InterfaceC5866i a0(a aVar, n nVar, Ref$ObjectRef ref$ObjectRef) {
        return aVar.f35133b.e().h(new I(aVar, nVar, ref$ObjectRef));
    }

    public static final AbstractC4927g b0(a aVar, n nVar, Ref$ObjectRef ref$ObjectRef) {
        return aVar.f35133b.a().g().a(nVar, (O) ref$ObjectRef.f34820a);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.a e0(g selectMostSpecificInEachOverridableGroup) {
        p.i(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final Collection s(a aVar) {
        return aVar.v(C5231d.f38869o, InterfaceC5238k.f38895a.c());
    }

    public static final Set t(a aVar) {
        return aVar.u(C5231d.f38874t, null);
    }

    public abstract void A(Collection<g> collection, e eVar);

    public abstract void B(e eVar, Collection<O> collection);

    public abstract Set<e> C(C5231d c5231d, InterfaceC5074l<? super e, Boolean> interfaceC5074l);

    public final H9.K D(n nVar) {
        U9.e eVarZ0 = U9.e.Z0(Q(), h.a(this.f35133b, nVar), Modality.FINAL, S9.O.d(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f35133b.a().t().a(nVar), T(nVar));
        p.h(eVarZ0, "create(...)");
        return eVarZ0;
    }

    public final InterfaceC5865h<Collection<InterfaceC0803h>> J() {
        return this.f35135d;
    }

    public final k K() {
        return this.f35133b;
    }

    public final Set<e> L() {
        return (Set) C5868k.a(this.f35142k, this, f35132m[2]);
    }

    public final InterfaceC5865h<InterfaceC1094c> M() {
        return this.f35136e;
    }

    public abstract E9.S N();

    public final Set<e> O() {
        return (Set) C5868k.a(this.f35140i, this, f35132m[0]);
    }

    public final a P() {
        return this.f35134c;
    }

    public abstract InterfaceC0803h Q();

    public final Set<e> R() {
        return (Set) C5868k.a(this.f35141j, this, f35132m[1]);
    }

    public final S S(n nVar) {
        S sP = this.f35133b.g().p(nVar.getType(), X9.b.b(TypeUsage.COMMON, false, false, null, 7, null));
        if ((!j.t0(sP) && !j.w0(sP)) || !T(nVar) || !nVar.K()) {
            return sP;
        }
        S sN = H0.n(sP);
        p.h(sN, "makeNotNullable(...)");
        return sN;
    }

    public final boolean T(n nVar) {
        return nVar.isFinal() && nVar.isStatic();
    }

    public boolean U(JavaMethodDescriptor javaMethodDescriptor) {
        p.i(javaMethodDescriptor, "<this>");
        return true;
    }

    public abstract C0439a X(r rVar, List<? extends b0> list, S s10, List<? extends i0> list2);

    public final JavaMethodDescriptor Y(r method) {
        p.i(method, "method");
        JavaMethodDescriptor javaMethodDescriptorJ1 = JavaMethodDescriptor.j1(Q(), h.a(this.f35133b, method), method.getName(), this.f35133b.a().t().a(method), this.f35136e.invoke().a(method.getName()) != null && method.i().isEmpty());
        p.h(javaMethodDescriptorJ1, "createJavaMethod(...)");
        k kVarI = c.i(this.f35133b, javaMethodDescriptorJ1, method, 0, 4, null);
        List<y> typeParameters = method.getTypeParameters();
        List<? extends b0> arrayList = new ArrayList<>(C1174w.x(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            b0 b0VarA = kVarI.f().a((y) it.next());
            p.f(b0VarA);
            arrayList.add(b0VarA);
        }
        b bVarC0 = c0(kVarI, javaMethodDescriptorJ1, method.i());
        C0439a c0439aX = X(method, arrayList, z(method, kVarI), bVarC0.a());
        S sC = c0439aX.c();
        javaMethodDescriptorJ1.i1(sC != null ? C4827g.i(javaMethodDescriptorJ1, sC, F9.g.f2609m0.b()) : null, N(), C1173v.m(), c0439aX.e(), c0439aX.f(), c0439aX.d(), Modality.Companion.a(false, method.isAbstract(), true ^ method.isFinal()), S9.O.d(method.getVisibility()), c0439aX.c() != null ? Z8.Q.f(Y8.j.a(JavaMethodDescriptor.f35120G, F.q0(bVarC0.a()))) : kotlin.collections.a.i());
        javaMethodDescriptorJ1.m1(c0439aX.b(), bVarC0.b());
        if (!c0439aX.a().isEmpty()) {
            kVarI.a().s().b(javaMethodDescriptorJ1, c0439aX.a());
        }
        return javaMethodDescriptorJ1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [H9.K, T] */
    /* JADX WARN: Type inference failed for: r1v14, types: [H9.K, T] */
    public final O Z(n nVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? D10 = D(nVar);
        ref$ObjectRef.f34820a = D10;
        D10.P0(null, null, null, null);
        ((H9.K) ref$ObjectRef.f34820a).V0(S(nVar), C1173v.m(), N(), null, C1173v.m());
        InterfaceC0803h interfaceC0803hQ = Q();
        InterfaceC0797b interfaceC0797b = interfaceC0803hQ instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hQ : null;
        if (interfaceC0797b != null) {
            ref$ObjectRef.f34820a = this.f35133b.a().w().b(interfaceC0797b, (H9.K) ref$ObjectRef.f34820a, this.f35133b);
        }
        T t10 = ref$ObjectRef.f34820a;
        if (C4828h.K((j0) t10, ((H9.K) t10).getType())) {
            ((H9.K) ref$ObjectRef.f34820a).F0(new H(this, nVar, ref$ObjectRef));
        }
        this.f35133b.a().h().c(nVar, (O) ref$ObjectRef.f34820a);
        return (O) ref$ObjectRef.f34820a;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<O> a(e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        return !getVariableNames().contains(name) ? C1173v.m() : this.f35143l.invoke(name);
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<e> b() {
        return O();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<g> c(e name, M9.b location) {
        p.i(name, "name");
        p.i(location, "location");
        return !b().contains(name) ? C1173v.m() : this.f35139h.invoke(name);
    }

    public final b c0(k c10, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<? extends B> jValueParameters) {
        Pair pairA;
        e name;
        p.i(c10, "c");
        kotlin.reflect.jvm.internal.impl.descriptors.e function = eVar;
        p.i(function, "function");
        p.i(jValueParameters, "jValueParameters");
        Iterable<IndexedValue> iterableU1 = F.u1(jValueParameters);
        ArrayList arrayList = new ArrayList(C1174w.x(iterableU1, 10));
        boolean z10 = false;
        for (IndexedValue indexedValue : iterableU1) {
            int index = indexedValue.getIndex();
            B b10 = (B) indexedValue.b();
            F9.g gVarA = h.a(c10, b10);
            X9.a aVarB = X9.b.b(TypeUsage.COMMON, false, false, null, 7, null);
            if (b10.a()) {
                x type = b10.getType();
                f fVar = type instanceof f ? (f) type : null;
                if (fVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + b10);
                }
                S sL = c10.g().l(fVar, aVarB, true);
                pairA = Y8.j.a(sL, c10.d().g().k(sL));
            } else {
                pairA = Y8.j.a(c10.g().p(b10.getType(), aVarB), null);
            }
            S s10 = (S) pairA.a();
            S s11 = (S) pairA.b();
            if (p.d(function.getName().b(), "equals") && jValueParameters.size() == 1 && p.d(c10.d().g().J(), s10)) {
                name = e.j("other");
            } else {
                name = b10.getName();
                if (name == null) {
                    z10 = true;
                }
                if (name == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('p');
                    sb2.append(index);
                    name = e.j(sb2.toString());
                    p.h(name, "identifier(...)");
                }
            }
            boolean z11 = z10;
            p.f(name);
            arrayList.add(new V(function, null, index, gVarA, name, s10, false, false, false, s11, c10.a().t().a(b10)));
            function = eVar;
            z10 = z11;
        }
        return new b(F.m1(arrayList), z10);
    }

    public final void d0(Set<g> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strC = u.c((g) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection<? extends g> collectionB = C4835o.b(list2, W9.S.f6706a);
                set.removeAll(list2);
                set.addAll(collectionB);
            }
        }
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public Collection<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super e, Boolean> nameFilter) {
        p.i(kindFilter, "kindFilter");
        p.i(nameFilter, "nameFilter");
        return this.f35135d.invoke();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<e> f() {
        return L();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Set<e> getVariableNames() {
        return R();
    }

    public String toString() {
        return "Lazy scope for " + Q();
    }

    public abstract Set<e> u(C5231d c5231d, InterfaceC5074l<? super e, Boolean> interfaceC5074l);

    public final List<InterfaceC0803h> v(C5231d kindFilter, InterfaceC5074l<? super e, Boolean> nameFilter) {
        p.i(kindFilter, "kindFilter");
        p.i(nameFilter, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.a(C5231d.f38857c.c())) {
            for (e eVar : u(kindFilter, nameFilter)) {
                if (nameFilter.invoke(eVar).booleanValue()) {
                    Ia.a.a(linkedHashSet, d(eVar, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(C5231d.f38857c.d()) && !kindFilter.l().contains(AbstractC5230c.a.f38854a)) {
            for (e eVar2 : w(kindFilter, nameFilter)) {
                if (nameFilter.invoke(eVar2).booleanValue()) {
                    linkedHashSet.addAll(c(eVar2, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(C5231d.f38857c.i()) && !kindFilter.l().contains(AbstractC5230c.a.f38854a)) {
            for (e eVar3 : C(kindFilter, nameFilter)) {
                if (nameFilter.invoke(eVar3).booleanValue()) {
                    linkedHashSet.addAll(a(eVar3, noLookupLocation));
                }
            }
        }
        return F.m1(linkedHashSet);
    }

    public abstract Set<e> w(C5231d c5231d, InterfaceC5074l<? super e, Boolean> interfaceC5074l);

    public void x(Collection<g> result, e name) {
        p.i(result, "result");
        p.i(name, "name");
    }

    public abstract InterfaceC1094c y();

    public final S z(r method, k c10) {
        p.i(method, "method");
        p.i(c10, "c");
        return c10.g().p(method.getReturnType(), X9.b.b(TypeUsage.COMMON, method.L().o(), false, null, 6, null));
    }

    public /* synthetic */ a(k kVar, a aVar, int i10, i iVar) {
        this(kVar, (i10 & 2) != 0 ? null : aVar);
    }
}
