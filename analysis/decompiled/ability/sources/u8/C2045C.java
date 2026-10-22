package u8;

import h8.InterfaceC1501I;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import t8.C2024a;

/* renamed from: u8.C, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2045C extends D {
    public static final /* synthetic */ int p = 0;
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a n;
    public final j o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2045C(K1.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a jClass, j jVar) {
        super(aVar, null);
        kotlin.jvm.internal.k.f(jClass, "jClass");
        this.n = jClass;
        this.o = jVar;
    }

    public static InterfaceC1501I u(InterfaceC1501I interfaceC1501I) {
        CallableMemberDescriptor$Kind kind = interfaceC1501I.getKind();
        kind.getClass();
        if (kind != CallableMemberDescriptor$Kind.b) {
            return interfaceC1501I;
        }
        Collection collectionE = interfaceC1501I.e();
        kotlin.jvm.internal.k.e(collectionE, "getOverriddenDescriptors(...)");
        Collection<InterfaceC1501I> collection = collectionE;
        ArrayList arrayList = new ArrayList(D7.w.c0(collection, 10));
        for (InterfaceC1501I interfaceC1501I2 : collection) {
            kotlin.jvm.internal.k.c(interfaceC1501I2);
            arrayList.add(u(interfaceC1501I2));
        }
        return (InterfaceC1501I) D7.v.U0(D7.v.v0(arrayList));
    }

    @Override // Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        return null;
    }

    @Override // u8.z
    public final Set g(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return EmptySet.f4895a;
    }

    @Override // u8.z
    public final Set h(Q8.f kindFilter, Q8.l lVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        Set setI1 = D7.v.i1(((InterfaceC2048c) this.e.invoke()).a());
        j jVar = this.o;
        C2045C c2045cZ = N9.j.z(jVar);
        Set setA = c2045cZ != null ? c2045cZ.a() : null;
        if (setA == null) {
            setA = EmptySet.f4895a;
        }
        setI1.addAll(setA);
        if (this.n.f4985a.isEnum()) {
            setI1.addAll(H4.o.N(e8.o.c, e8.o.f4426a));
        }
        K1.a aVar = this.b;
        setI1.addAll(((O8.a) ((C2024a) aVar.f903a).f6678x).g(jVar, aVar));
        return setI1;
    }

    @Override // u8.z
    public final void i(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
        K1.a aVar = this.b;
        ((O8.a) ((C2024a) aVar.f903a).f6678x).d(this.o, name, arrayList, aVar);
    }

    @Override // u8.z
    public final InterfaceC2048c j() {
        return new C2046a(this.n, m.d);
    }

    @Override // u8.z
    public final void l(LinkedHashSet linkedHashSet, G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        j jVar = this.o;
        C2045C c2045cZ = N9.j.z(jVar);
        Collection collectionJ1 = c2045cZ == null ? EmptySet.f4895a : D7.v.j1(c2045cZ.f(name, NoLookupLocation.e));
        C2024a c2024a = (C2024a) this.b.f903a;
        linkedHashSet.addAll(com.stepos.ability.task.executor.e.J(name, collectionJ1, linkedHashSet, this.o, c2024a.f, ((Y8.l) c2024a.u).d));
        if (this.n.f4985a.isEnum()) {
            if (name.equals(e8.o.c)) {
                linkedHashSet.add(J8.m.i(jVar));
            } else if (name.equals(e8.o.f4426a)) {
                linkedHashSet.add(J8.m.j(jVar));
            }
        }
    }

    @Override // u8.D, u8.z
    public final void m(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        J4.b bVar = new J4.b(name, 25);
        j jVar = this.o;
        g9.l.g(H4.o.M(jVar), C2043A.f6713a, new C2044B(jVar, linkedHashSet, bVar));
        boolean zIsEmpty = arrayList.isEmpty();
        K1.a aVar = this.b;
        if (zIsEmpty) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : linkedHashSet) {
                InterfaceC1501I interfaceC1501IU = u((InterfaceC1501I) obj);
                Object arrayList2 = linkedHashMap.get(interfaceC1501IU);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(interfaceC1501IU, arrayList2);
                }
                ((List) arrayList2).add(obj);
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) ((Map.Entry) it.next()).getValue();
                C2024a c2024a = (C2024a) aVar.f903a;
                D7.A.e0(com.stepos.ability.task.executor.e.J(name, collection, arrayList, this.o, c2024a.f, ((Y8.l) c2024a.u).d), arrayList3);
            }
            arrayList.addAll(arrayList3);
        } else {
            C2024a c2024a2 = (C2024a) aVar.f903a;
            arrayList.addAll(com.stepos.ability.task.executor.e.J(name, linkedHashSet, arrayList, this.o, c2024a2.f, ((Y8.l) c2024a2.u).d));
        }
        if (this.n.f4985a.isEnum() && name.equals(e8.o.b)) {
            g9.l.b(arrayList, J8.m.h(jVar));
        }
    }

    @Override // u8.z
    public final Set n(Q8.f kindFilter) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        Set setI1 = D7.v.i1(((InterfaceC2048c) this.e.invoke()).c());
        m mVar = m.e;
        j jVar = this.o;
        g9.l.g(H4.o.M(jVar), C2043A.f6713a, new C2044B(jVar, setI1, mVar));
        if (this.n.f4985a.isEnum()) {
            setI1.add(e8.o.b);
        }
        return setI1;
    }

    @Override // u8.z
    public final InterfaceC1527j p() {
        return this.o;
    }
}
