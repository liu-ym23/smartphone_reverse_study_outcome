package V8;

import D7.A;
import D7.w;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* loaded from: classes4.dex */
public final class h extends p {
    public final Y8.f g;
    public final W8.h h;
    public final W8.h i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b f1396j;

    public h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar, Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f1396j = bVar;
        T8.m mVar = bVar.l;
        ProtoBuf$Class protoBuf$Class = bVar.e;
        List list = protoBuf$Class.f5029q;
        kotlin.jvm.internal.k.e(list, "getFunctionList(...)");
        List list2 = protoBuf$Class.f5030r;
        kotlin.jvm.internal.k.e(list2, "getPropertyList(...)");
        List list3 = protoBuf$Class.f5031s;
        kotlin.jvm.internal.k.e(list3, "getTypeAliasList(...)");
        List list4 = protoBuf$Class.k;
        kotlin.jvm.internal.k.e(list4, "getNestedClassNameList(...)");
        List list5 = list4;
        D8.f fVar = bVar.l.b;
        ArrayList arrayList = new ArrayList(w.c0(list5, 10));
        Iterator it = list5.iterator();
        while (it.hasNext()) {
            arrayList.add(N9.j.x(fVar, ((Number) it.next()).intValue()));
        }
        super(mVar, list, list2, list3, new e(arrayList, 0));
        T8.k kVar = mVar.f1228a;
        this.g = kotlinTypeRefiner;
        W8.i iVar = kVar.f1222a;
        f fVar2 = new f(this, 0);
        iVar.getClass();
        this.h = new W8.h(iVar, fVar2);
        W8.i iVar2 = kVar.f1222a;
        f fVar3 = new f(this, 1);
        iVar2.getClass();
        this.i = new W8.h(iVar2, fVar3);
    }

    @Override // V8.p, Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        InterfaceC1522e interfaceC1522e;
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        r(name, location);
        u1.d dVar = this.f1396j.p;
        return (dVar == null || (interfaceC1522e = (InterfaceC1522e) ((kotlin.reflect.jvm.internal.impl.storage.b) dVar.c).invoke(name)) == null) ? super.b(name, location) : interfaceC1522e;
    }

    @Override // Q8.p, Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        return (Collection) this.h.invoke();
    }

    @Override // V8.p, Q8.p, Q8.o
    public final Collection d(G8.f name, NoLookupLocation noLookupLocation) {
        kotlin.jvm.internal.k.f(name, "name");
        r(name, noLookupLocation);
        return super.d(name, noLookupLocation);
    }

    @Override // V8.p, Q8.p, Q8.o
    public final Collection f(G8.f name, p8.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        r(name, aVar);
        return super.f(name, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    @Override // V8.p
    public final void g(ArrayList arrayList, S7.k kVar) {
        ?? arrayList2;
        u1.d dVar = this.f1396j.p;
        if (dVar != null) {
            Set<G8.f> setKeySet = ((LinkedHashMap) dVar.b).keySet();
            arrayList2 = new ArrayList();
            for (G8.f name : setKeySet) {
                kotlin.jvm.internal.k.f(name, "name");
                InterfaceC1522e interfaceC1522e = (InterfaceC1522e) ((kotlin.reflect.jvm.internal.impl.storage.b) dVar.c).invoke(name);
                if (interfaceC1522e != null) {
                    arrayList2.add(interfaceC1522e);
                }
            }
        } else {
            arrayList2 = 0;
        }
        if (arrayList2 == 0) {
            arrayList2 = EmptyList.f4893a;
        }
        arrayList.addAll(arrayList2);
    }

    @Override // V8.p
    public final void i(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.i.invoke()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((X8.w) it.next()).w().f(name, NoLookupLocation.c));
        }
        T8.m mVar = this.b;
        arrayList.addAll(mVar.f1228a.n.a(name, this.f1396j));
        ArrayList arrayList3 = new ArrayList(arrayList);
        ((Y8.l) mVar.f1228a.f1224q).d.h(name, arrayList2, arrayList3, this.f1396j, new g(arrayList, 0));
    }

    @Override // V8.p
    public final void j(G8.f name, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(name, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.i.invoke()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((X8.w) it.next()).w().d(name, NoLookupLocation.c));
        }
        ArrayList arrayList3 = new ArrayList(arrayList);
        ((Y8.l) this.b.f1228a.f1224q).d.h(name, arrayList2, arrayList3, this.f1396j, new g(arrayList, 0));
    }

    @Override // V8.p
    public final G8.b k(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this.f1396j.h.d(name);
    }

    @Override // V8.p
    public final Set m() {
        List listE = this.f1396j.n.e();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            Set setE = ((X8.w) it.next()).w().e();
            if (setE == null) {
                return null;
            }
            A.e0(setE, linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // V8.p
    public final Set n() {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = this.f1396j;
        List listE = bVar.n.e();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            A.e0(((X8.w) it.next()).w().a(), linkedHashSet);
        }
        linkedHashSet.addAll(this.b.f1228a.n.b(bVar));
        return linkedHashSet;
    }

    @Override // V8.p
    public final Set o() {
        List listE = this.f1396j.n.e();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            A.e0(((X8.w) it.next()).w().getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // V8.p
    public final boolean q(s sVar) {
        return this.b.f1228a.o.e(this.f1396j, sVar);
    }

    public final void r(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        kotlin.jvm.internal.k.f(this.b.f1228a.i, "<this>");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b scopeOwner = this.f1396j;
        kotlin.jvm.internal.k.f(scopeOwner, "scopeOwner");
    }
}
