package V8;

import H8.AbstractC0241b;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import i8.InterfaceC1561g;
import k8.H;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* loaded from: classes4.dex */
public final class r extends H implements b {

    /* renamed from: A, reason: collision with root package name */
    public final ProtoBuf$Property f1402A;

    /* renamed from: B, reason: collision with root package name */
    public final D8.f f1403B;

    /* renamed from: C, reason: collision with root package name */
    public final D8.j f1404C;

    /* renamed from: D, reason: collision with root package name */
    public final D8.k f1405D;
    public final j E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(InterfaceC1527j containingDeclaration, InterfaceC1501I interfaceC1501I, InterfaceC1561g annotations, Modality modality, C1531n visibility, boolean z10, G8.f name, CallableMemberDescriptor$Kind kind, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, ProtoBuf$Property proto, D8.f nameResolver, D8.j typeTable, D8.k versionRequirementTable, j jVar) {
        super(containingDeclaration, interfaceC1501I, annotations, modality, visibility, z10, name, kind, InterfaceC1503K.f4577I, z11, z12, z15, z13, z14);
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        kotlin.jvm.internal.k.f(modality, "modality");
        kotlin.jvm.internal.k.f(visibility, "visibility");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        kotlin.jvm.internal.k.f(versionRequirementTable, "versionRequirementTable");
        this.f1402A = proto;
        this.f1403B = nameResolver;
        this.f1404C = typeTable;
        this.f1405D = versionRequirementTable;
        this.E = jVar;
    }

    @Override // V8.k
    public final j B() {
        return this.E;
    }

    @Override // k8.H
    public final H T0(InterfaceC1527j newOwner, Modality newModality, C1531n newVisibility, InterfaceC1501I interfaceC1501I, CallableMemberDescriptor$Kind kind, G8.f newName) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(newModality, "newModality");
        kotlin.jvm.internal.k.f(newVisibility, "newVisibility");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(newName, "newName");
        return new r(newOwner, interfaceC1501I, getAnnotations(), newModality, newVisibility, this.f, newName, kind, this.n, this.o, isExternal(), this.f4832r, this.p, this.f1402A, this.f1403B, this.f1404C, this.f1405D, this.E);
    }

    @Override // V8.k
    public final AbstractC0241b d0() {
        return this.f1402A;
    }

    @Override // k8.H, h8.InterfaceC1539v
    public final boolean isExternal() {
        return D8.e.E.c(this.f1402A.d).booleanValue();
    }

    @Override // V8.k
    public final D8.j v() {
        return this.f1404C;
    }

    @Override // V8.k
    public final D8.f y() {
        return this.f1403B;
    }
}
