package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import A5.c;
import D7.A;
import D7.N;
import D7.v;
import J4.f;
import T8.o;
import W8.h;
import W8.i;
import W8.l;
import X8.S;
import X8.U;
import X8.w;
import Y8.d;
import a.AbstractC0291a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import e8.n;
import h8.AbstractC1532o;
import h8.C1504L;
import h8.InterfaceC1501I;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.C1560f;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k8.I;
import k8.J;
import k8.K;
import k8.Q;
import k8.u;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;
import kotlin.reflect.jvm.internal.impl.storage.b;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import n8.AbstractC1744c;
import n8.g;
import n8.q;
import n8.t;
import q8.AbstractC1829b;
import q8.AbstractC1831d;
import q8.AbstractC1832e;
import q8.AbstractC1847t;
import q8.C1830c;
import t8.C2024a;
import t8.C2026c;
import u8.C2046a;
import u8.InterfaceC2048c;
import u8.m;
import u8.y;
import u8.z;

/* loaded from: classes4.dex */
public final class a extends z {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f4997v = 0;
    public final InterfaceC1522e n;
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a o;
    public final boolean p;

    /* renamed from: q, reason: collision with root package name */
    public final h f4998q;

    /* renamed from: r, reason: collision with root package name */
    public final h f4999r;

    /* renamed from: s, reason: collision with root package name */
    public final h f5000s;

    /* renamed from: t, reason: collision with root package name */
    public final h f5001t;
    public final b u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(K1.a c, InterfaceC1522e interfaceC1522e, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a jClass, boolean z10, a aVar) {
        super(c, aVar);
        k.f(c, "c");
        k.f(jClass, "jClass");
        this.n = interfaceC1522e;
        this.o = jClass;
        this.p = z10;
        l lVar = ((C2024a) c.f903a).f6670a;
        u8.k kVar = new u8.k(this, c);
        i iVar = (i) lVar;
        iVar.getClass();
        this.f4998q = new h(iVar, kVar);
        u8.l lVar2 = new u8.l(this, 0);
        i iVar2 = (i) lVar;
        iVar2.getClass();
        this.f4999r = new h(iVar2, lVar2);
        u8.k kVar2 = new u8.k(c, this);
        i iVar3 = (i) lVar;
        iVar3.getClass();
        this.f5000s = new h(iVar3, kVar2);
        u8.l lVar3 = new u8.l(this, 1);
        i iVar4 = (i) lVar;
        iVar4.getClass();
        this.f5001t = new h(iVar4, lVar3);
        this.u = ((i) lVar).d(new f(3, this, c));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k8.K A(k8.K r5) {
        /*
            java.util.List r0 = r5.x()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            java.lang.Object r0 = D7.v.L0(r0)
            k8.Q r0 = (k8.Q) r0
            r2 = 0
            if (r0 == 0) goto L7c
            r3 = r0
            k8.S r3 = (k8.S) r3
            X8.w r3 = r3.getType()
            X8.K r3 = r3.Q()
            h8.g r3 = r3.d()
            if (r3 == 0) goto L36
            G8.e r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(r3)
            boolean r4 = r3.d()
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r3 = r2
        L2f:
            if (r3 == 0) goto L36
            G8.c r3 = r3.g()
            goto L37
        L36:
            r3 = r2
        L37:
            G8.c r4 = e8.o.g
            boolean r3 = kotlin.jvm.internal.k.b(r3, r4)
            if (r3 == 0) goto L40
            goto L41
        L40:
            r0 = r2
        L41:
            if (r0 != 0) goto L44
            goto L7c
        L44:
            h8.r r2 = r5.x0()
            java.util.List r5 = r5.x()
            kotlin.jvm.internal.k.e(r5, r1)
            r1 = 1
            java.util.List r5 = D7.v.x0(r1, r5)
            h8.r r5 = r2.e(r5)
            k8.S r0 = (k8.S) r0
            X8.w r0 = r0.getType()
            java.util.List r0 = r0.L()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            X8.N r0 = (X8.N) r0
            X8.w r0 = r0.b()
            h8.r r5 = r5.A(r0)
            h8.s r5 = r5.build()
            k8.K r5 = (k8.K) r5
            if (r5 == 0) goto L7b
            r5.u = r1
        L7b:
            return r5
        L7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a.A(k8.K):k8.K");
    }

    public static boolean C(InterfaceC1536s interfaceC1536s, InterfaceC1536s interfaceC1536s2) {
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB = J8.k.c.n(interfaceC1536s2, interfaceC1536s, true).b();
        k.e(overridingUtil$OverrideCompatibilityInfo$ResultB, "getResult(...)");
        return overridingUtil$OverrideCompatibilityInfo$ResultB == OverridingUtil$OverrideCompatibilityInfo$Result.f5116a && !N.y(interfaceC1536s2, interfaceC1536s);
    }

    public static boolean D(K k, K k5) {
        int i = AbstractC1829b.l;
        k.f(k, "<this>");
        if (k.b(k.getName().b(), "removeAt") && k.b(e.u(k), q8.z.g.e)) {
            k5 = k5.a();
        }
        k.c(k5);
        return C(k5, k);
    }

    public static K E(InterfaceC1501I interfaceC1501I, String str, S7.k kVar) {
        K k;
        Iterator it = ((Iterable) kVar.invoke(G8.f.e(str))).iterator();
        do {
            k = null;
            if (!it.hasNext()) {
                break;
            }
            K k5 = (K) it.next();
            if (k5.x().size() == 0) {
                Y8.l lVar = d.f1572a;
                w wVar = k5.g;
                if (wVar == null ? false : lVar.b(wVar, interfaceC1501I.getType())) {
                    k = k5;
                }
            }
        } while (k == null);
        return k;
    }

    public static K G(InterfaceC1501I interfaceC1501I, S7.k kVar) {
        K k;
        w wVar;
        String strB = interfaceC1501I.getName().b();
        k.e(strB, "asString(...)");
        Iterator it = ((Iterable) kVar.invoke(G8.f.e(AbstractC1847t.b(strB)))).iterator();
        do {
            k = null;
            if (!it.hasNext()) {
                break;
            }
            K k5 = (K) it.next();
            if (k5.x().size() == 1 && (wVar = k5.g) != null) {
                G8.f fVar = e8.i.e;
                if (e8.i.D(wVar, n.d)) {
                    Y8.l lVar = d.f1572a;
                    List listX = k5.x();
                    k.e(listX, "getValueParameters(...)");
                    if (lVar.a(((Q) v.U0(listX)).getType(), interfaceC1501I.getType())) {
                        k = k5;
                    }
                }
            }
        } while (k == null);
        return k;
    }

    public static boolean J(K k, InterfaceC1536s interfaceC1536s) {
        String strT = e.t(k, 2);
        InterfaceC1536s interfaceC1536sA = interfaceC1536s.a();
        k.e(interfaceC1536sA, "getOriginal(...)");
        return strT.equals(e.t(interfaceC1536sA, 2)) && !C(k, interfaceC1536s);
    }

    public static K z(K k, InterfaceC1536s interfaceC1536s, AbstractCollection abstractCollection) {
        if (abstractCollection.isEmpty()) {
            return k;
        }
        Iterator it = abstractCollection.iterator();
        while (it.hasNext()) {
            K k5 = (K) it.next();
            if (!k.equals(k5) && k5.f4862B == null && C(k5, interfaceC1536s)) {
                InterfaceC1536s interfaceC1536sBuild = k.x0().p().build();
                k.c(interfaceC1536sBuild);
                return (K) interfaceC1536sBuild;
            }
        }
        return k;
    }

    public final boolean B(InterfaceC1501I interfaceC1501I, S7.k kVar) {
        if (z2.l.B(interfaceC1501I)) {
            return false;
        }
        K kF = F(interfaceC1501I, kVar);
        K kG = G(interfaceC1501I, kVar);
        if (kF == null) {
            return false;
        }
        if (interfaceC1501I.H()) {
            return kG != null && kG.i() == kF.i();
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    public final K F(InterfaceC1501I interfaceC1501I, S7.k kVar) {
        G8.f fVar;
        I getter = interfaceC1501I.getGetter();
        String strB = null;
        I i = getter != null ? (I) S0.b.e1(getter) : null;
        if (i != null) {
            e8.i.z(i);
            InterfaceC1520c interfaceC1520cB = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(i), C1830c.d);
            if (interfaceC1520cB != null && (fVar = (G8.f) AbstractC1832e.f5599a.get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(interfaceC1520cB))) != null) {
                strB = fVar.b();
            }
        }
        if (strB != null && !S0.b.i1(this.n, i)) {
            return E(interfaceC1501I, strB, kVar);
        }
        String strB2 = interfaceC1501I.getName().b();
        k.e(strB2, "asString(...)");
        return E(interfaceC1501I, AbstractC1847t.a(strB2), kVar);
    }

    public final LinkedHashSet H(G8.f fVar) {
        Collection collectionY = y();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionY.iterator();
        while (it.hasNext()) {
            A.e0(((w) it.next()).w().f(fVar, NoLookupLocation.e), linkedHashSet);
        }
        return linkedHashSet;
    }

    public final Set I(G8.f fVar) {
        Collection collectionY = y();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionY.iterator();
        while (it.hasNext()) {
            Collection collectionD = ((w) it.next()).w().d(fVar, NoLookupLocation.e);
            ArrayList arrayList2 = new ArrayList(D7.w.c0(collectionD, 10));
            Iterator it2 = collectionD.iterator();
            while (it2.hasNext()) {
                arrayList2.add((InterfaceC1501I) it2.next());
            }
            A.e0(arrayList2, arrayList);
        }
        return v.j1(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01cf A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean K(k8.K r12) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a.K(k8.K):boolean");
    }

    public final void L(G8.f name, p8.a location) {
        k.f(name, "name");
        k.f(location, "location");
        k.f(((C2024a) this.b.f903a).n, "<this>");
        InterfaceC1522e scopeOwner = this.n;
        k.f(scopeOwner, "scopeOwner");
    }

    public final ArrayList M(G8.f fVar) {
        Collection collectionE = ((InterfaceC2048c) this.e.invoke()).e(fVar);
        ArrayList arrayList = new ArrayList(D7.w.c0(collectionE, 10));
        Iterator it = collectionE.iterator();
        while (it.hasNext()) {
            arrayList.add(s((q) it.next()));
        }
        return arrayList;
    }

    public final ArrayList N(G8.f fVar) {
        LinkedHashSet linkedHashSetH = H(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetH) {
            K k = (K) obj;
            k.f(k, "<this>");
            if (S0.b.e1(k) == null && AbstractC1831d.a(k) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        b bVar;
        InterfaceC1522e interfaceC1522e;
        k.f(name, "name");
        k.f(location, "location");
        L(name, location);
        a aVar = (a) this.c;
        return (aVar == null || (bVar = aVar.u) == null || (interfaceC1522e = (InterfaceC1522e) bVar.invoke(name)) == null) ? (InterfaceC1524g) this.u.invoke(name) : interfaceC1522e;
    }

    @Override // u8.z, Q8.p, Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        k.f(name, "name");
        L(name, noLookupLocation);
        return super.d(name, noLookupLocation);
    }

    @Override // u8.z, Q8.p, Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        k.f(name, "name");
        L(name, aVar);
        return super.f(name, aVar);
    }

    @Override // u8.z
    public final Set g(Q8.f kindFilter, S7.k kVar) {
        k.f(kindFilter, "kindFilter");
        return N.L((Set) this.f4999r.invoke(), ((Map) this.f5001t.invoke()).keySet());
    }

    @Override // u8.z
    public final Set h(Q8.f kindFilter, Q8.l lVar) {
        k.f(kindFilter, "kindFilter");
        InterfaceC1522e interfaceC1522e = this.n;
        Collection collectionE = interfaceC1522e.m().e();
        k.e(collectionE, "getSupertypes(...)");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionE.iterator();
        while (it.hasNext()) {
            A.e0(((w) it.next()).w().a(), linkedHashSet);
        }
        h hVar = this.e;
        linkedHashSet.addAll(((InterfaceC2048c) hVar.invoke()).a());
        linkedHashSet.addAll(((InterfaceC2048c) hVar.invoke()).b());
        linkedHashSet.addAll(g(kindFilter, lVar));
        K1.a aVar = this.b;
        linkedHashSet.addAll(((O8.a) ((C2024a) aVar.f903a).f6678x).e(interfaceC1522e, aVar));
        return linkedHashSet;
    }

    @Override // u8.z
    public final void i(G8.f name, ArrayList arrayList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        k.f(name, "name");
        boolean zH = this.o.h();
        InterfaceC1522e interfaceC1522e = this.n;
        K1.a aVar = this.b;
        if (zH) {
            h hVar = this.e;
            if (((InterfaceC2048c) hVar.invoke()).f(name) != null) {
                if (arrayList.isEmpty()) {
                    t tVarF = ((InterfaceC2048c) hVar.invoke()).f(name);
                    k.c(tVarF);
                    C2026c c2026cG = AbstractC0291a.G(aVar, tVarF);
                    C2024a c2024a = (C2024a) aVar.f903a;
                    kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVarG1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.a.g1(interfaceC1522e, c2026cG, tVarF.c(), c2024a.f6671j.b(tVarF), true);
                    w wVarC = ((c) aVar.e).C(tVarF.f(), M.a.o0(TypeUsage.b, false, null, 6));
                    u uVarO = o();
                    EmptyList emptyList = EmptyList.f4893a;
                    Modality.f4953a.getClass();
                    aVarG1.f1(null, uVarO, emptyList, emptyList, emptyList, wVarC, Modality.d, AbstractC1532o.e, null);
                    aVarG1.h1(false, false);
                    c2024a.g.getClass();
                    arrayList.add(aVarG1);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((K) it.next()).x().isEmpty()) {
                            break;
                        }
                    }
                    t tVarF2 = ((InterfaceC2048c) hVar.invoke()).f(name);
                    k.c(tVarF2);
                    C2026c c2026cG2 = AbstractC0291a.G(aVar, tVarF2);
                    C2024a c2024a2 = (C2024a) aVar.f903a;
                    kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVarG12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.a.g1(interfaceC1522e, c2026cG2, tVarF2.c(), c2024a2.f6671j.b(tVarF2), true);
                    w wVarC2 = ((c) aVar.e).C(tVarF2.f(), M.a.o0(TypeUsage.b, false, null, 6));
                    u uVarO2 = o();
                    EmptyList emptyList2 = EmptyList.f4893a;
                    Modality.f4953a.getClass();
                    aVarG12.f1(null, uVarO2, emptyList2, emptyList2, emptyList2, wVarC2, Modality.d, AbstractC1532o.e, null);
                    aVarG12.h1(false, false);
                    c2024a2.g.getClass();
                    arrayList.add(aVarG12);
                }
            }
        }
        ((O8.a) ((C2024a) aVar.f903a).f6678x).b(interfaceC1522e, name, arrayList, aVar);
    }

    @Override // u8.z
    public final InterfaceC2048c j() {
        return new C2046a(this.o, m.b);
    }

    @Override // u8.z
    public final void l(LinkedHashSet linkedHashSet, G8.f name) {
        k.f(name, "name");
        LinkedHashSet linkedHashSetH = H(name);
        ArrayList arrayList = q8.z.f5620a;
        if (!q8.z.f5621j.contains(name) && !AbstractC1831d.b(name)) {
            if (!linkedHashSetH.isEmpty()) {
                Iterator it = linkedHashSetH.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC1536s) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : linkedHashSetH) {
                if (K((K) obj)) {
                    arrayList2.add(obj);
                }
            }
            v(linkedHashSet, name, arrayList2, false);
            return;
        }
        int i = g9.i.c;
        g9.i iVarF = g9.l.f();
        LinkedHashSet linkedHashSetI = e.I(name, linkedHashSetH, EmptyList.f4893a, this.n, o.f1229a, ((Y8.l) ((C2024a) this.b.f903a).u).d);
        w(name, linkedHashSet, linkedHashSetI, linkedHashSet, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(1, this));
        w(name, linkedHashSet, linkedHashSetI, iVarF, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(1, this));
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : linkedHashSetH) {
            if (K((K) obj2)) {
                arrayList3.add(obj2);
            }
        }
        v(linkedHashSet, name, v.Q0(iVarF, arrayList3), true);
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [C7.f, java.lang.Object] */
    @Override // u8.z
    public final void m(G8.f name, ArrayList arrayList) {
        Set setJ1;
        q qVar;
        k.f(name, "name");
        boolean zIsAnnotation = this.o.f4985a.isAnnotation();
        K1.a aVar = this.b;
        if (zIsAnnotation && (qVar = (q) v.V0(((InterfaceC2048c) this.e.invoke()).e(name))) != null) {
            C1504L c1504l = Modality.f4953a;
            s8.e eVarZ0 = s8.e.Z0(this.n, AbstractC0291a.G(aVar, qVar), U7.a.X(qVar.e()), false, qVar.c(), ((C2024a) aVar.f903a).f6671j.b(qVar), false);
            I iF = J8.m.f(eVarZ0, C1560f.f4611a);
            eVarZ0.V0(iF, null, null, null);
            k.f(aVar, "<this>");
            w wVarK = z.k(qVar, new K1.a((C2024a) aVar.f903a, new D9.t(aVar, eVarZ0, qVar, 0), (C7.f) aVar.c));
            EmptyList emptyList = EmptyList.f4893a;
            eVarZ0.Y0(wVarK, emptyList, o(), null, emptyList);
            iF.m = wVarK;
            arrayList.add(eVarZ0);
        }
        Set setI = I(name);
        if (setI.isEmpty()) {
            return;
        }
        int i = g9.i.c;
        g9.i iVarF = g9.l.f();
        g9.i iVarF2 = g9.l.f();
        x(setI, arrayList, iVarF, new u8.n(this, 0));
        Collection<?> collectionH0 = A.h0(iVarF);
        if (collectionH0.isEmpty()) {
            setJ1 = v.j1(setI);
        } else if (collectionH0 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object obj : setI) {
                if (!((Set) collectionH0).contains(obj)) {
                    linkedHashSet.add(obj);
                }
            }
            setJ1 = linkedHashSet;
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(setI);
            linkedHashSet2.removeAll(collectionH0);
            setJ1 = linkedHashSet2;
        }
        x(setJ1, iVarF2, null, new u8.n(this, 1));
        LinkedHashSet linkedHashSetL = N.L(setI, iVarF2);
        C2024a c2024a = (C2024a) aVar.f903a;
        arrayList.addAll(e.I(name, linkedHashSetL, arrayList, this.n, c2024a.f, ((Y8.l) c2024a.u).d));
    }

    @Override // u8.z
    public final Set n(Q8.f kindFilter) {
        k.f(kindFilter, "kindFilter");
        if (this.o.f4985a.isAnnotation()) {
            return a();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((InterfaceC2048c) this.e.invoke()).c());
        Collection collectionE = this.n.m().e();
        k.e(collectionE, "getSupertypes(...)");
        Iterator it = collectionE.iterator();
        while (it.hasNext()) {
            A.e0(((w) it.next()).w().getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // u8.z
    public final u o() {
        InterfaceC1522e interfaceC1522e = this.n;
        if (interfaceC1522e != null) {
            int i = J8.e.f883a;
            return interfaceC1522e.B0();
        }
        J8.e.a(0);
        throw null;
    }

    @Override // u8.z
    public final InterfaceC1527j p() {
        return this.n;
    }

    @Override // u8.z
    public final boolean q(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        if (this.o.f4985a.isAnnotation()) {
            return false;
        }
        return K(aVar);
    }

    @Override // u8.z
    public final y r(q method, ArrayList arrayList, w wVar, List valueParameters) {
        k.f(method, "method");
        k.f(valueParameters, "valueParameters");
        ((C2024a) this.b.f903a).e.getClass();
        if (this.n == null) {
            r8.h.a(1);
            throw null;
        }
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return new y(wVar, valueParameters, arrayList, list);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", AppAgent.CONSTRUCT));
    }

    @Override // u8.z
    public final String toString() {
        return "Lazy Java member scope for " + this.o.d();
    }

    public final void u(ArrayList arrayList, s8.b bVar, int i, q qVar, w wVar, w wVar2) {
        n8.e mVar;
        G8.f fVarC = qVar.c();
        if (wVar == null) {
            S.a(2);
            throw null;
        }
        U uG = S.g(wVar, false);
        Object defaultValue = qVar.f5362a.getDefaultValue();
        if (defaultValue != null) {
            Class<?> cls = defaultValue.getClass();
            List list = AbstractC1744c.f5355a;
            mVar = Enum.class.isAssignableFrom(cls) ? new n8.m(null, (Enum) defaultValue) : defaultValue instanceof Annotation ? new n8.f(null, (Annotation) defaultValue) : defaultValue instanceof Object[] ? new g(null, (Object[]) defaultValue) : defaultValue instanceof Class ? new n8.i(null, (Class) defaultValue) : new n8.o(null, defaultValue);
        } else {
            mVar = null;
        }
        arrayList.add(new Q(bVar, null, i, C1560f.f4611a, fVarC, uG, mVar != null, false, false, wVar2 != null ? S.g(wVar2, false) : null, ((C2024a) this.b.f903a).f6671j.b(qVar)));
    }

    public final void v(LinkedHashSet linkedHashSet, G8.f fVar, ArrayList arrayList, boolean z10) {
        C2024a c2024a = (C2024a) this.b.f903a;
        LinkedHashSet<K> linkedHashSetI = e.I(fVar, arrayList, linkedHashSet, this.n, c2024a.f, ((Y8.l) c2024a.u).d);
        if (!z10) {
            linkedHashSet.addAll(linkedHashSetI);
            return;
        }
        ArrayList arrayListQ0 = v.Q0(linkedHashSetI, linkedHashSet);
        ArrayList arrayList2 = new ArrayList(D7.w.c0(linkedHashSetI, 10));
        for (K kZ : linkedHashSetI) {
            K k = (K) S0.b.f1(kZ);
            if (k != null) {
                kZ = z(kZ, k, arrayListQ0);
            }
            arrayList2.add(kZ);
        }
        linkedHashSet.addAll(arrayList2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(G8.f r11, java.util.LinkedHashSet r12, java.util.LinkedHashSet r13, java.util.AbstractSet r14, S7.k r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a.w(G8.f, java.util.LinkedHashSet, java.util.LinkedHashSet, java.util.AbstractSet, S7.k):void");
    }

    public final void x(Set set, AbstractCollection abstractCollection, g9.i iVar, S7.k kVar) {
        K kG;
        J jM;
        s8.d dVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            InterfaceC1501I interfaceC1501I = (InterfaceC1501I) it.next();
            if (B(interfaceC1501I, kVar)) {
                K kF = F(interfaceC1501I, kVar);
                k.c(kF);
                if (interfaceC1501I.H()) {
                    kG = G(interfaceC1501I, kVar);
                    k.c(kG);
                } else {
                    kG = null;
                }
                if (kG != null) {
                    kG.i();
                    kF.i();
                }
                InterfaceC1522e ownerDescriptor = this.n;
                k.f(ownerDescriptor, "ownerDescriptor");
                s8.d dVar2 = new s8.d(ownerDescriptor, C1560f.f4611a, kF.i(), kF.getVisibility(), kG != null, interfaceC1501I.getName(), kF.getSource(), null, CallableMemberDescriptor$Kind.f4950a, false, null);
                w wVar = kF.g;
                k.c(wVar);
                EmptyList emptyList = EmptyList.f4893a;
                dVar2.Y0(wVar, emptyList, o(), null, emptyList);
                I iL = J8.m.l(dVar2, kF.getAnnotations(), false, kF.getSource());
                iL.l = kF;
                iL.U0(dVar2.getType());
                if (kG != null) {
                    List listX = kG.x();
                    k.e(listX, "getValueParameters(...)");
                    Q q5 = (Q) v.C0(listX);
                    if (q5 == null) {
                        throw new AssertionError("No parameter found for " + kG);
                    }
                    jM = J8.m.m(dVar2, kG.getAnnotations(), q5.getAnnotations(), false, kG.getVisibility(), kG.getSource());
                    jM.l = kG;
                } else {
                    jM = null;
                }
                dVar2.V0(iL, jM, null, null);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                abstractCollection.add(dVar);
                if (iVar != null) {
                    iVar.add(interfaceC1501I);
                    return;
                }
                return;
            }
        }
    }

    public final Collection y() {
        boolean z10 = this.p;
        InterfaceC1522e classDescriptor = this.n;
        if (z10) {
            Collection collectionE = classDescriptor.m().e();
            k.e(collectionE, "getSupertypes(...)");
            return collectionE;
        }
        ((Y8.l) ((C2024a) this.b.f903a).u).getClass();
        k.f(classDescriptor, "classDescriptor");
        Collection collectionE2 = classDescriptor.m().e();
        k.e(collectionE2, "getSupertypes(...)");
        return collectionE2;
    }
}
