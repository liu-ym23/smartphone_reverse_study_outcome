package Q8;

import h8.InterfaceC1506N;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class i extends p {
    public final o b;

    public i(o workerScope) {
        kotlin.jvm.internal.k.f(workerScope, "workerScope");
        this.b = workerScope;
    }

    @Override // Q8.p, Q8.o
    public final Set a() {
        return this.b.a();
    }

    @Override // Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        InterfaceC1524g interfaceC1524gB = this.b.b(name, location);
        if (interfaceC1524gB != null) {
            InterfaceC1522e interfaceC1522e = interfaceC1524gB instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gB : null;
            if (interfaceC1522e != null) {
                return interfaceC1522e;
            }
            if (interfaceC1524gB instanceof InterfaceC1506N) {
                return (InterfaceC1506N) interfaceC1524gB;
            }
        }
        return null;
    }

    @Override // Q8.p, Q8.q
    public final Collection c(f kindFilter, S7.k kVar) {
        Collection collection;
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        int i = f.l & kindFilter.b;
        f fVar = i == 0 ? null : new f(i, kindFilter.f1125a);
        if (fVar == null) {
            collection = EmptyList.f4893a;
        } else {
            Collection collectionC = this.b.c(fVar, kVar);
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionC) {
                if (obj instanceof InterfaceC1525h) {
                    arrayList.add(obj);
                }
            }
            collection = arrayList;
        }
        return collection;
    }

    @Override // Q8.p, Q8.o
    public final Set e() {
        return this.b.e();
    }

    @Override // Q8.p, Q8.o
    public final Set getVariableNames() {
        return this.b.getVariableNames();
    }

    public final String toString() {
        return "Classes from " + this.b;
    }
}
