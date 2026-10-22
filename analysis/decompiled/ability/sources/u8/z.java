package u8;

import X8.U;
import a.AbstractC0291a;
import h8.C1504L;
import h8.InterfaceC1507O;
import h8.InterfaceC1527j;
import h8.InterfaceC1540w;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k8.Q;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import t8.C2024a;
import t8.C2026c;
import t8.InterfaceC2028e;
import v8.C2065a;

/* loaded from: classes4.dex */
public abstract class z extends Q8.p {
    public static final /* synthetic */ Z7.t[] m;
    public final K1.a b;
    public final z c;
    public final W8.c d;
    public final W8.h e;
    public final W8.e f;
    public final kotlin.reflect.jvm.internal.impl.storage.b g;
    public final W8.e h;
    public final W8.h i;

    /* renamed from: j, reason: collision with root package name */
    public final W8.h f6739j;
    public final W8.h k;
    public final W8.e l;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        m = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(z.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), nVar.g(new PropertyReference1Impl(nVar.b(z.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), nVar.g(new PropertyReference1Impl(nVar.b(z.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public z(K1.a c, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar) {
        kotlin.jvm.internal.k.f(c, "c");
        this.b = c;
        this.c = aVar;
        W8.l lVar = ((C2024a) c.f903a).f6670a;
        v vVar = new v(this, 0);
        EmptyList emptyList = EmptyList.f4893a;
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        if (emptyList == null) {
            W8.i.a(27);
            throw null;
        }
        this.d = new W8.c(iVar, vVar, emptyList);
        v vVar2 = new v(this, 1);
        W8.i iVar2 = (W8.i) lVar;
        iVar2.getClass();
        this.e = new W8.h(iVar2, vVar2);
        this.f = ((W8.i) lVar).c(new x(this, 0));
        this.g = ((W8.i) lVar).d(new x(this, 1));
        this.h = ((W8.i) lVar).c(new x(this, 2));
        v vVar3 = new v(this, 2);
        W8.i iVar3 = (W8.i) lVar;
        iVar3.getClass();
        this.i = new W8.h(iVar3, vVar3);
        v vVar4 = new v(this, 3);
        W8.i iVar4 = (W8.i) lVar;
        iVar4.getClass();
        this.f6739j = new W8.h(iVar4, vVar4);
        v vVar5 = new v(this, 4);
        W8.i iVar5 = (W8.i) lVar;
        iVar5.getClass();
        this.k = new W8.h(iVar5, vVar5);
        this.l = ((W8.i) lVar).c(new x(this, 3));
    }

    public static X8.w k(n8.q method, K1.a aVar) {
        kotlin.jvm.internal.k.f(method, "method");
        Class<?> declaringClass = ((Method) method.b()).getDeclaringClass();
        kotlin.jvm.internal.k.e(declaringClass, "getDeclaringClass(...)");
        return ((A5.c) aVar.e).C(method.f(), M.a.o0(TypeUsage.b, declaringClass.isAnnotation(), null, 6));
    }

    public static C4.a t(K1.a aVar, k8.t tVar, List jValueParameters) {
        Pair pair;
        X8.w wVar;
        G8.f fVar;
        G8.f fVarE;
        A5.c cVar = (A5.c) aVar.e;
        C2024a c2024a = (C2024a) aVar.f903a;
        InterfaceC1540w interfaceC1540w = c2024a.o;
        kotlin.jvm.internal.k.f(jValueParameters, "jValueParameters");
        D7.s sVarL1 = D7.v.l1(jValueParameters);
        ArrayList arrayList = new ArrayList(D7.w.c0(sVarL1, 10));
        Iterator it = sVarL1.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            D7.E e = (D7.E) it;
            if (!e.b.hasNext()) {
                return new C4.a(D7.v.f1(arrayList), z11);
            }
            D7.D d = (D7.D) e.next();
            int i = d.f393a;
            n8.w wVar2 = (n8.w) d.b;
            C2026c c2026cG = AbstractC0291a.G(aVar, wVar2);
            C2065a c2065aO0 = M.a.o0(TypeUsage.b, z10, null, 7);
            boolean z12 = wVar2.d;
            n8.u uVar = wVar2.f5367a;
            if (z12) {
                n8.h hVar = uVar instanceof n8.h ? (n8.h) uVar : null;
                if (hVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + wVar2);
                }
                U uB = cVar.B(hVar, c2065aO0, true);
                pair = new Pair(uB, interfaceC1540w.c().f(uB));
            } else {
                pair = new Pair(cVar.C(uVar, c2065aO0), null);
            }
            X8.w wVar3 = (X8.w) pair.f4886a;
            X8.w wVar4 = (X8.w) pair.b;
            if (kotlin.jvm.internal.k.b(tVar.getName().b(), "equals") && jValueParameters.size() == 1 && interfaceC1540w.c().o().equals(wVar3)) {
                fVarE = G8.f.e("other");
            } else {
                String str = wVar2.c;
                G8.f fVarD = str != null ? G8.f.d(str) : null;
                if (fVarD == null) {
                    z11 = true;
                }
                if (fVarD == null) {
                    fVarE = G8.f.e("p" + i);
                } else {
                    wVar = wVar3;
                    fVar = fVarD;
                    arrayList.add(new Q(tVar, null, i, c2026cG, fVar, wVar, false, false, false, wVar4, c2024a.f6671j.b(wVar2)));
                    z10 = false;
                }
            }
            fVar = fVarE;
            wVar = wVar3;
            arrayList.add(new Q(tVar, null, i, c2026cG, fVar, wVar, false, false, false, wVar4, c2024a.f6671j.b(wVar2)));
            z10 = false;
        }
    }

    @Override // Q8.p, Q8.o
    public final Set a() {
        return (Set) S0.b.g1(this.i, m[0]);
    }

    @Override // Q8.p, Q8.q
    public Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return (Collection) this.d.invoke();
    }

    @Override // Q8.p, Q8.o
    public Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return !getVariableNames().contains(name) ? EmptyList.f4893a : (Collection) this.l.invoke(name);
    }

    @Override // Q8.p, Q8.o
    public final Set e() {
        return (Set) S0.b.g1(this.k, m[2]);
    }

    @Override // Q8.p, Q8.o
    public Collection f(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return !a().contains(name) ? EmptyList.f4893a : (Collection) this.h.invoke(name);
    }

    public abstract Set g(Q8.f fVar, S7.k kVar);

    @Override // Q8.p, Q8.o
    public final Set getVariableNames() {
        return (Set) S0.b.g1(this.f6739j, m[1]);
    }

    public abstract Set h(Q8.f fVar, Q8.l lVar);

    public void i(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
    }

    public abstract InterfaceC2048c j();

    public abstract void l(LinkedHashSet linkedHashSet, G8.f fVar);

    public abstract void m(G8.f fVar, ArrayList arrayList);

    public abstract Set n(Q8.f fVar);

    public abstract k8.u o();

    public abstract InterfaceC1527j p();

    public boolean q(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        return true;
    }

    public abstract y r(n8.q qVar, ArrayList arrayList, X8.w wVar, List list);

    /* JADX WARN: Type inference failed for: r3v2, types: [C7.f, java.lang.Object] */
    public final kotlin.reflect.jvm.internal.impl.load.java.descriptors.a s(n8.q method) {
        kotlin.jvm.internal.k.f(method, "method");
        K1.a aVar = this.b;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVarG1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.a.g1(p(), AbstractC0291a.G(aVar, method), method.c(), ((C2024a) aVar.f903a).f6671j.b(method), ((InterfaceC2048c) this.e.invoke()).f(method.c()) != null && ((ArrayList) method.g()).isEmpty());
        kotlin.jvm.internal.k.f(aVar, "<this>");
        K1.a aVar2 = new K1.a((C2024a) aVar.f903a, new D9.t(aVar, aVarG1, method, 0), (C7.f) aVar.c);
        ArrayList typeParameters = method.getTypeParameters();
        ArrayList arrayList = new ArrayList(D7.w.c0(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            InterfaceC1507O interfaceC1507OA = ((InterfaceC2028e) aVar2.b).a((n8.v) it.next());
            kotlin.jvm.internal.k.c(interfaceC1507OA);
            arrayList.add(interfaceC1507OA);
        }
        C4.a aVarT = t(aVar2, aVarG1, method.g());
        y yVarR = r(method, arrayList, k(method, aVar2), (List) aVarT.c);
        List list = yVarR.d;
        k8.u uVarO = o();
        EmptyList emptyList = EmptyList.f4893a;
        ArrayList arrayList2 = yVarR.c;
        List list2 = yVarR.b;
        X8.w wVar = yVarR.f6738a;
        C1504L c1504l = Modality.f4953a;
        boolean zIsAbstract = Modifier.isAbstract(((Method) method.b()).getModifiers());
        boolean zIsFinal = Modifier.isFinal(((Method) method.b()).getModifiers());
        c1504l.getClass();
        aVarG1.f1(null, uVarO, emptyList, arrayList2, list2, wVar, zIsAbstract ? Modality.e : !zIsFinal ? Modality.d : Modality.b, U7.a.X(method.e()), kotlin.collections.a.M());
        aVarG1.h1(false, aVarT.b);
        if (list.isEmpty()) {
            return aVarG1;
        }
        ((C2024a) aVar2.f903a).e.getClass();
        if (list != null) {
            throw new UnsupportedOperationException("Should not be called");
        }
        r8.h.a(6);
        throw null;
    }

    public String toString() {
        return "Lazy scope for " + p();
    }
}
