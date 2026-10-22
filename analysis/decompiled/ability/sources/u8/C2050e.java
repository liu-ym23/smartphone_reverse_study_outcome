package u8;

import a.AbstractC0291a;
import g1.AbstractC1451a;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.InterfaceC1539v;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import t8.C2024a;

/* renamed from: u8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2050e implements Q8.o {
    public static final /* synthetic */ Z7.t[] f;
    public final K1.a b;
    public final p c;
    public final u d;
    public final W8.h e;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        f = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(C2050e.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public C2050e(K1.a aVar, n8.r rVar, p pVar) {
        this.b = aVar;
        this.c = pVar;
        this.d = new u(aVar, rVar, pVar);
        W8.l lVar = ((C2024a) aVar.f903a).f6670a;
        C2049d c2049d = new C2049d(this, 0);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.e = new W8.h(iVar, c2049d);
    }

    @Override // Q8.o
    public final Set a() {
        Q8.o[] oVarArrG = g();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Q8.o oVar : oVarArrG) {
            D7.A.e0(oVar.a(), linkedHashSet);
        }
        linkedHashSet.addAll(this.d.a());
        return linkedHashSet;
    }

    @Override // Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        h(name, location);
        u uVar = this.d;
        uVar.getClass();
        InterfaceC1524g interfaceC1524g = null;
        InterfaceC1522e interfaceC1522eU = uVar.u(name, null);
        if (interfaceC1522eU != null) {
            return interfaceC1522eU;
        }
        for (Q8.o oVar : g()) {
            InterfaceC1524g interfaceC1524gB = oVar.b(name, location);
            if (interfaceC1524gB != null) {
                if (!(interfaceC1524gB instanceof InterfaceC1525h) || !((InterfaceC1539v) interfaceC1524gB).g0()) {
                    return interfaceC1524gB;
                }
                if (interfaceC1524g == null) {
                    interfaceC1524g = interfaceC1524gB;
                }
            }
        }
        return interfaceC1524g;
    }

    @Override // Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        Q8.o[] oVarArrG = g();
        Collection collectionC = this.d.c(kindFilter, kVar);
        for (Q8.o oVar : oVarArrG) {
            collectionC = AbstractC0291a.r(collectionC, oVar.c(kindFilter, kVar));
        }
        return collectionC == null ? EmptySet.f4895a : collectionC;
    }

    @Override // Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        h(name, noLookupLocation);
        Q8.o[] oVarArrG = g();
        this.d.getClass();
        Collection collectionR = EmptyList.f4893a;
        for (Q8.o oVar : oVarArrG) {
            collectionR = AbstractC0291a.r(collectionR, oVar.d(name, noLookupLocation));
        }
        return collectionR == null ? EmptySet.f4895a : collectionR;
    }

    @Override // Q8.o
    public final Set e() {
        HashSet hashSetB = AbstractC1451a.B(D7.q.K(g()));
        if (hashSetB == null) {
            return null;
        }
        hashSetB.addAll(this.d.e());
        return hashSetB;
    }

    @Override // Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        h(name, aVar);
        Q8.o[] oVarArrG = g();
        Collection collectionF = this.d.f(name, aVar);
        for (Q8.o oVar : oVarArrG) {
            collectionF = AbstractC0291a.r(collectionF, oVar.f(name, aVar));
        }
        return collectionF == null ? EmptySet.f4895a : collectionF;
    }

    public final Q8.o[] g() {
        return (Q8.o[]) S0.b.g1(this.e, f[0]);
    }

    @Override // Q8.o
    public final Set getVariableNames() {
        Q8.o[] oVarArrG = g();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Q8.o oVar : oVarArrG) {
            D7.A.e0(oVar.getVariableNames(), linkedHashSet);
        }
        linkedHashSet.addAll(this.d.getVariableNames());
        return linkedHashSet;
    }

    public final void h(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        U7.a.P(((C2024a) this.b.f903a).n, location, this.c, name);
    }

    public final String toString() {
        return "scope for " + this.c;
    }
}
