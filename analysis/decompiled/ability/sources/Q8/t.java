package Q8;

import X8.P;
import h8.InterfaceC1505M;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class t implements o {
    public final o b;
    public final kotlin.reflect.jvm.internal.impl.types.a c;
    public HashMap d;
    public final C7.f e;

    public t(o workerScope, kotlin.reflect.jvm.internal.impl.types.a givenSubstitutor) {
        kotlin.jvm.internal.k.f(workerScope, "workerScope");
        kotlin.jvm.internal.k.f(givenSubstitutor, "givenSubstitutor");
        this.b = workerScope;
        kotlin.a.a(new I8.e(givenSubstitutor, 3));
        P pF = givenSubstitutor.f();
        kotlin.jvm.internal.k.e(pF, "getSubstitution(...)");
        this.c = new kotlin.reflect.jvm.internal.impl.types.a(M.a.p0(pF));
        this.e = kotlin.a.a(new I8.e(this, 4));
    }

    @Override // Q8.o
    public final Set a() {
        return this.b.a();
    }

    @Override // Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        InterfaceC1524g interfaceC1524gB = this.b.b(name, location);
        if (interfaceC1524gB != null) {
            return (InterfaceC1524g) g(interfaceC1524gB);
        }
        return null;
    }

    @Override // Q8.q
    public final Collection c(f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return (Collection) this.e.getF4884a();
    }

    @Override // Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return h(this.b.d(name, noLookupLocation));
    }

    @Override // Q8.o
    public final Set e() {
        return this.b.e();
    }

    @Override // Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        return h(this.b.f(name, aVar));
    }

    public final InterfaceC1527j g(InterfaceC1527j interfaceC1527j) {
        kotlin.reflect.jvm.internal.impl.types.a aVar = this.c;
        if (aVar.f5144a.e()) {
            return interfaceC1527j;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        HashMap map = this.d;
        kotlin.jvm.internal.k.c(map);
        Object objB = map.get(interfaceC1527j);
        if (objB == null) {
            if (!(interfaceC1527j instanceof InterfaceC1505M)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + interfaceC1527j).toString());
            }
            objB = ((InterfaceC1505M) interfaceC1527j).b(aVar);
            if (objB == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + interfaceC1527j + " substitution fails");
            }
            map.put(interfaceC1527j, objB);
        }
        return (InterfaceC1527j) objB;
    }

    @Override // Q8.o
    public final Set getVariableNames() {
        return this.b.getVariableNames();
    }

    public final Collection h(Collection collection) {
        if (this.c.f5144a.e() || collection.isEmpty()) {
            return collection;
        }
        int size = collection.size();
        LinkedHashSet linkedHashSet = new LinkedHashSet(size >= 3 ? (size / 3) + size + 1 : 3);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(g((InterfaceC1527j) it.next()));
        }
        return linkedHashSet;
    }
}
