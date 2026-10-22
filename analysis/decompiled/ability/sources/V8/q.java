package V8;

import D7.A;
import h8.InterfaceC1494B;
import h8.InterfaceC1524g;
import j8.InterfaceC1604c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k8.AbstractC1629B;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import z8.C2197i;

/* loaded from: classes4.dex */
public final class q extends p {
    public final InterfaceC1494B g;
    public final String h;
    public final G8.c i;

    public q(InterfaceC1494B interfaceC1494B, ProtoBuf$Package proto, D8.f nameResolver, D8.a metadataVersion, C2197i c2197i, T8.k components, String debugName, S7.a aVar) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.k.f(components, "components");
        kotlin.jvm.internal.k.f(debugName, "debugName");
        ProtoBuf$TypeTable protoBuf$TypeTable = proto.g;
        kotlin.jvm.internal.k.e(protoBuf$TypeTable, "getTypeTable(...)");
        D8.j jVar = new D8.j(protoBuf$TypeTable);
        D8.k kVar = D8.k.b;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = proto.h;
        kotlin.jvm.internal.k.e(protoBuf$VersionRequirementTable, "getVersionRequirementTable(...)");
        T8.m mVarA = components.a(interfaceC1494B, nameResolver, jVar, N9.j.o(protoBuf$VersionRequirementTable), metadataVersion, c2197i);
        List list = proto.d;
        kotlin.jvm.internal.k.e(list, "getFunctionList(...)");
        List list2 = proto.e;
        kotlin.jvm.internal.k.e(list2, "getPropertyList(...)");
        List list3 = proto.f;
        kotlin.jvm.internal.k.e(list3, "getTypeAliasList(...)");
        super(mVarA, list, list2, list3, aVar);
        this.g = interfaceC1494B;
        this.h = debugName;
        this.i = ((AbstractC1629B) interfaceC1494B).e;
    }

    @Override // V8.p, Q8.p, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(location, "location");
        U7.a.P(this.b.f1228a.i, location, this.g, name);
        return super.b(name, location);
    }

    @Override // Q8.p, Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.f4986a;
        Collection collectionH = h(kindFilter, kVar);
        Iterable iterable = this.b.f1228a.k;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            A.e0(((InterfaceC1604c) it.next()).c(this.i), arrayList);
        }
        return D7.v.Q0(arrayList, collectionH);
    }

    @Override // V8.p
    public final void g(ArrayList arrayList, S7.k kVar) {
    }

    @Override // V8.p
    public final G8.b k(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return new G8.b(this.i, name);
    }

    @Override // V8.p
    public final Set m() {
        return EmptySet.f4895a;
    }

    @Override // V8.p
    public final Set n() {
        return EmptySet.f4895a;
    }

    @Override // V8.p
    public final Set o() {
        return EmptySet.f4895a;
    }

    @Override // V8.p
    public final boolean p(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        if (super.p(name)) {
            return true;
        }
        Iterable iterable = this.b.f1228a.k;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((InterfaceC1604c) it.next()).b(this.i, name)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return this.h;
    }
}
