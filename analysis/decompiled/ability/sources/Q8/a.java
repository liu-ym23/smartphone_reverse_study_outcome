package Q8;

import D7.A;
import a.AbstractC0291a;
import g1.AbstractC1451a;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.InterfaceC1539v;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class a implements o {
    public final String b;
    public final o[] c;

    public a(String str, o[] oVarArr) {
        this.b = str;
        this.c = oVarArr;
    }

    @Override // Q8.o
    public final Set a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (o oVar : this.c) {
            A.e0(oVar.a(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        InterfaceC1524g interfaceC1524g = null;
        for (o oVar : this.c) {
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
    public final Collection c(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        o[] oVarArr = this.c;
        int length = oVarArr.length;
        if (length == 0) {
            return EmptyList.f4893a;
        }
        if (length == 1) {
            return oVarArr[0].c(kindFilter, kVar);
        }
        Collection collectionR = null;
        for (o oVar : oVarArr) {
            collectionR = AbstractC0291a.r(collectionR, oVar.c(kindFilter, kVar));
        }
        return collectionR == null ? EmptySet.f4895a : collectionR;
    }

    @Override // Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        o[] oVarArr = this.c;
        int length = oVarArr.length;
        if (length == 0) {
            return EmptyList.f4893a;
        }
        if (length == 1) {
            return oVarArr[0].d(name, noLookupLocation);
        }
        Collection collectionR = null;
        for (o oVar : oVarArr) {
            collectionR = AbstractC0291a.r(collectionR, oVar.d(name, noLookupLocation));
        }
        return collectionR == null ? EmptySet.f4895a : collectionR;
    }

    @Override // Q8.o
    public final Set e() {
        return AbstractC1451a.B(D7.q.K(this.c));
    }

    @Override // Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        o[] oVarArr = this.c;
        int length = oVarArr.length;
        if (length == 0) {
            return EmptyList.f4893a;
        }
        if (length == 1) {
            return oVarArr[0].f(name, aVar);
        }
        Collection collectionR = null;
        for (o oVar : oVarArr) {
            collectionR = AbstractC0291a.r(collectionR, oVar.f(name, aVar));
        }
        return collectionR == null ? EmptySet.f4895a : collectionR;
    }

    @Override // Q8.o
    public final Set getVariableNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (o oVar : this.c) {
            A.e0(oVar.getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    public final String toString() {
        return this.b;
    }
}
