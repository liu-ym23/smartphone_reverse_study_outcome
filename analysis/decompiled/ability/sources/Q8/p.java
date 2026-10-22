package Q8;

import g9.C1475b;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import k8.K;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public abstract class p implements o {
    @Override // Q8.o
    public Set a() {
        Collection collectionC = c(f.p, C1475b.f4500a);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionC) {
            if (obj instanceof K) {
                G8.f name = ((K) obj).getName();
                kotlin.jvm.internal.k.e(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // Q8.q
    public InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return null;
    }

    @Override // Q8.q
    public Collection c(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return EmptyList.f4893a;
    }

    @Override // Q8.o
    public Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return EmptyList.f4893a;
    }

    @Override // Q8.o
    public Set e() {
        return null;
    }

    @Override // Q8.o
    public Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return EmptyList.f4893a;
    }

    @Override // Q8.o
    public Set getVariableNames() {
        Collection collectionC = c(f.f1122q, C1475b.f4500a);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionC) {
            if (obj instanceof K) {
                G8.f name = ((K) obj).getName();
                kotlin.jvm.internal.k.e(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }
}
