package wa;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.W;
import ea.C4018b;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* renamed from: wa.L, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5770L extends H9.K implements InterfaceC5778b {

    /* renamed from: C, reason: collision with root package name */
    public final ProtoBuf$Property f43151C;

    /* renamed from: D, reason: collision with root package name */
    public final InterfaceC4020d f43152D;

    /* renamed from: E, reason: collision with root package name */
    public final ea.h f43153E;

    /* renamed from: F, reason: collision with root package name */
    public final ea.j f43154F;

    /* renamed from: G, reason: collision with root package name */
    public final InterfaceC5793q f43155G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5770L(InterfaceC0803h containingDeclaration, E9.O o10, F9.g annotations, Modality modality, AbstractC0811p visibility, boolean z10, ga.e name, CallableMemberDescriptor.Kind kind, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, ProtoBuf$Property proto, InterfaceC4020d nameResolver, ea.h typeTable, ea.j versionRequirementTable, InterfaceC5793q interfaceC5793q) {
        super(containingDeclaration, o10, annotations, modality, visibility, z10, name, kind, W.f2444a, z11, z12, z15, false, z13, z14);
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(modality, "modality");
        kotlin.jvm.internal.p.i(visibility, "visibility");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(versionRequirementTable, "versionRequirementTable");
        this.f43151C = proto;
        this.f43152D = nameResolver;
        this.f43153E = typeTable;
        this.f43154F = versionRequirementTable;
        this.f43155G = interfaceC5793q;
    }

    @Override // wa.InterfaceC5794r
    public ea.h C() {
        return this.f43153E;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC4020d F() {
        return this.f43152D;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC5793q G() {
        return this.f43155G;
    }

    @Override // H9.K
    public H9.K J0(InterfaceC0803h newOwner, Modality newModality, AbstractC0811p newVisibility, E9.O o10, CallableMemberDescriptor.Kind kind, ga.e newName, W source) {
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(newModality, "newModality");
        kotlin.jvm.internal.p.i(newVisibility, "newVisibility");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(newName, "newName");
        kotlin.jvm.internal.p.i(source, "source");
        return new C5770L(newOwner, o10, getAnnotations(), newModality, newVisibility, J(), newName, kind, t0(), isConst(), isExternal(), z(), e0(), a0(), F(), C(), a1(), G());
    }

    @Override // wa.InterfaceC5794r
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Property a0() {
        return this.f43151C;
    }

    public ea.j a1() {
        return this.f43154F;
    }

    @Override // H9.K, E9.InterfaceC0816v
    public boolean isExternal() {
        Boolean boolD = C4018b.f32361G.d(a0().H0());
        kotlin.jvm.internal.p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }
}
