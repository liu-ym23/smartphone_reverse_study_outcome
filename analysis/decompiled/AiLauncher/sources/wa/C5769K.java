package wa;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import Z8.Y;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import ea.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.C5231d;
import ua.C5627m;
import ua.C5629o;

/* renamed from: wa.K, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5769K extends u {

    /* renamed from: g, reason: collision with root package name */
    public final E9.E f43148g;

    /* renamed from: h, reason: collision with root package name */
    public final String f43149h;

    /* renamed from: i, reason: collision with root package name */
    public final ga.c f43150i;

    public C5769K(E9.E packageDescriptor, ProtoBuf$Package proto, InterfaceC4020d nameResolver, AbstractC4017a metadataVersion, InterfaceC5793q interfaceC5793q, C5627m components, String debugName, InterfaceC5063a<? extends Collection<ga.e>> classNames) {
        kotlin.jvm.internal.p.i(packageDescriptor, "packageDescriptor");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.p.i(components, "components");
        kotlin.jvm.internal.p.i(debugName, "debugName");
        kotlin.jvm.internal.p.i(classNames, "classNames");
        ProtoBuf$TypeTable protoBuf$TypeTableV = proto.V();
        kotlin.jvm.internal.p.h(protoBuf$TypeTableV, "getTypeTable(...)");
        ea.h hVar = new ea.h(protoBuf$TypeTableV);
        j.a aVar = ea.j.f32424b;
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableW = proto.W();
        kotlin.jvm.internal.p.h(protoBuf$VersionRequirementTableW, "getVersionRequirementTable(...)");
        C5629o c5629oA = components.a(packageDescriptor, nameResolver, hVar, aVar.a(protoBuf$VersionRequirementTableW), metadataVersion, interfaceC5793q);
        List<ProtoBuf$Function> listO = proto.O();
        kotlin.jvm.internal.p.h(listO, "getFunctionList(...)");
        List<ProtoBuf$Property> listR = proto.R();
        kotlin.jvm.internal.p.h(listR, "getPropertyList(...)");
        List<ProtoBuf$TypeAlias> listU = proto.U();
        kotlin.jvm.internal.p.h(listU, "getTypeAliasList(...)");
        super(c5629oA, listO, listR, listU, classNames);
        this.f43148g = packageDescriptor;
        this.f43149h = debugName;
        this.f43150i = packageDescriptor.f();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public List<InterfaceC0803h> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        Collection<InterfaceC0803h> collectionL = l(kindFilter, nameFilter, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<G9.b> iterableL = r().c().l();
        ArrayList arrayList = new ArrayList();
        Iterator<G9.b> it = iterableL.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, it.next().b(this.f43150i));
        }
        return Z8.F.S0(collectionL, arrayList);
    }

    public void B(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        L9.a.b(r().c().p(), location, this.f43148g, name);
    }

    @Override // wa.u, ra.AbstractC5239l, ra.InterfaceC5241n
    public InterfaceC0799d d(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        B(name, location);
        return super.d(name, location);
    }

    @Override // wa.u
    public void i(Collection<InterfaceC0803h> result, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
    }

    @Override // wa.u
    public ga.b o(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return new ga.b(this.f43150i, name);
    }

    public String toString() {
        return this.f43149h;
    }

    @Override // wa.u
    public Set<ga.e> u() {
        return Y.e();
    }

    @Override // wa.u
    public Set<ga.e> v() {
        return Y.e();
    }

    @Override // wa.u
    public Set<ga.e> w() {
        return Y.e();
    }

    @Override // wa.u
    public boolean y(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (super.y(name)) {
            return true;
        }
        Iterable<G9.b> iterableL = r().c().l();
        if ((iterableL instanceof Collection) && ((Collection) iterableL).isEmpty()) {
            return false;
        }
        Iterator<G9.b> it = iterableL.iterator();
        while (it.hasNext()) {
            if (it.next().c(this.f43150i, name)) {
                return true;
            }
        }
        return false;
    }
}
