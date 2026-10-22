package k8;

import h8.InterfaceC1540w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

/* loaded from: classes4.dex */
public final class L extends Q8.p {
    public final InterfaceC1540w b;
    public final G8.c c;

    public L(InterfaceC1540w moduleDescriptor, G8.c fqName) {
        kotlin.jvm.internal.k.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        this.b = moduleDescriptor;
        this.c = fqName;
    }

    @Override // Q8.p, Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        if (!kindFilter.a(Q8.f.h)) {
            return EmptyList.f4893a;
        }
        G8.c cVar = this.c;
        if (cVar.d() && kindFilter.f1125a.contains(Q8.c.f1119a)) {
            return EmptyList.f4893a;
        }
        InterfaceC1540w interfaceC1540w = this.b;
        Collection collectionF = interfaceC1540w.f(cVar, kVar);
        ArrayList arrayList = new ArrayList(collectionF.size());
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            G8.f fVarF = ((G8.c) it.next()).f();
            kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
            if (((Boolean) kVar.invoke(fVarF)).booleanValue()) {
                w wVar = null;
                if (!fVarF.b) {
                    w wVar2 = (w) interfaceC1540w.V(cVar.c(fVarF));
                    if (!((Boolean) S0.b.g1(wVar2.f, w.h[1])).booleanValue()) {
                        wVar = wVar2;
                    }
                }
                g9.l.b(arrayList, wVar);
            }
        }
        return arrayList;
    }

    @Override // Q8.p, Q8.o
    public final Set e() {
        return EmptySet.f4895a;
    }

    public final String toString() {
        return "subpackages of " + this.c + " from " + this.b;
    }
}
