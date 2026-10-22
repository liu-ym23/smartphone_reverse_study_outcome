package U8;

import D8.g;
import I8.e;
import Q8.o;
import T8.D;
import V8.q;
import W8.i;
import h8.InterfaceC1494B;
import h8.InterfaceC1540w;
import k8.AbstractC1629B;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import u1.d;

/* loaded from: classes4.dex */
public final class b extends AbstractC1629B implements InterfaceC1494B {
    public final C8.a g;
    public final g h;
    public final d i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$PackageFragment f1278j;
    public q k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(G8.c fqName, i iVar, InterfaceC1540w module, ProtoBuf$PackageFragment protoBuf$PackageFragment, C8.a aVar) {
        super(module, fqName);
        k.f(fqName, "fqName");
        k.f(module, "module");
        this.g = aVar;
        ProtoBuf$StringTable protoBuf$StringTable = protoBuf$PackageFragment.d;
        k.e(protoBuf$StringTable, "getStrings(...)");
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = protoBuf$PackageFragment.e;
        k.e(protoBuf$QualifiedNameTable, "getQualifiedNames(...)");
        g gVar = new g(protoBuf$StringTable, protoBuf$QualifiedNameTable);
        this.h = gVar;
        this.i = new d(protoBuf$PackageFragment, gVar, aVar, new D(this));
        this.f1278j = protoBuf$PackageFragment;
    }

    public final void S0(T8.k components) {
        k.f(components, "components");
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this.f1278j;
        if (protoBuf$PackageFragment == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f1278j = null;
        ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.f;
        k.e(protoBuf$Package, "getPackage(...)");
        this.k = new q(this, protoBuf$Package, this.h, this.g, null, components, "scope of " + this, new e(this, 5));
    }

    @Override // k8.AbstractC1629B, k8.AbstractC1644m
    public final String toString() {
        return "builtins package fragment for " + this.e + " from " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(this);
    }

    @Override // h8.InterfaceC1494B
    public final o w() {
        q qVar = this.k;
        if (qVar != null) {
            return qVar;
        }
        k.n("_memberScope");
        throw null;
    }
}
