package u8;

import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import t8.C2024a;

/* loaded from: classes4.dex */
public final class u extends D {
    public final n8.r n;
    public final p o;
    public final kotlin.reflect.jvm.internal.impl.storage.a p;

    /* renamed from: q, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.storage.b f6734q;

    public u(K1.a aVar, n8.r rVar, p pVar) {
        super(aVar, null);
        this.n = rVar;
        this.o = pVar;
        W8.l lVar = ((C2024a) aVar.f903a).f6670a;
        J4.e eVar = new J4.e(20, aVar, this);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.p = new kotlin.reflect.jvm.internal.impl.storage.a(iVar, eVar);
        this.f6734q = ((W8.i) lVar).d(new J4.f(5, this, aVar));
    }

    @Override // Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return u(name, null);
    }

    @Override // u8.z, Q8.p, Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        if (!kindFilter.a(Q8.f.l | Q8.f.e)) {
            return EmptyList.f4893a;
        }
        Iterable iterable = (Iterable) this.d.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            InterfaceC1527j interfaceC1527j = (InterfaceC1527j) obj;
            if (interfaceC1527j instanceof InterfaceC1522e) {
                G8.f name = ((InterfaceC1522e) interfaceC1527j).getName();
                kotlin.jvm.internal.k.e(name, "getName(...)");
                if (((Boolean) kVar.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // u8.z, Q8.p, Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        return EmptyList.f4893a;
    }

    @Override // u8.z
    public final Set g(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        if (!kindFilter.a(Q8.f.e)) {
            return EmptySet.f4895a;
        }
        Set set = (Set) this.p.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(G8.f.e((String) it.next()));
            }
            return hashSet;
        }
        this.n.getClass();
        EmptyList emptyList = EmptyList.f4893a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        emptyList.getClass();
        return linkedHashSet;
    }

    @Override // u8.z
    public final Set h(Q8.f kindFilter, Q8.l lVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return EmptySet.f4895a;
    }

    @Override // u8.z
    public final InterfaceC2048c j() {
        return C2047b.f6715a;
    }

    @Override // u8.z
    public final void l(LinkedHashSet linkedHashSet, G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
    }

    @Override // u8.z
    public final Set n(Q8.f kindFilter) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return EmptySet.f4895a;
    }

    @Override // u8.z
    public final InterfaceC1527j p() {
        return this.o;
    }

    public final InterfaceC1522e u(G8.f name, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar) {
        G8.f fVar = G8.h.f692a;
        kotlin.jvm.internal.k.f(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        if (strB.length() <= 0 || name.b) {
            return null;
        }
        Set set = (Set) this.p.invoke();
        if (aVar == null && set != null && !set.contains(name.b())) {
            return null;
        }
        return (InterfaceC1522e) this.f6734q.invoke(new q(name, aVar));
    }
}
