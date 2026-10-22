package Aa;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0812q;
import E9.O;
import E9.P;
import E9.Q;
import E9.S;
import E9.W;
import E9.b0;
import E9.i0;
import H9.K;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import ma.AbstractC4927g;

/* loaded from: classes5.dex */
public final class e implements O {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f1338a;

    public e() {
        i iVar = i.f1351a;
        K kI0 = K.I0(iVar.h(), F9.g.f2609m0.b(), Modality.OPEN, C0810o.f2473e, true, ga.e.m(ErrorEntity.ERROR_PROPERTY.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, W.f2444a, false, false, false, false, false, false);
        kI0.V0(iVar.k(), C1173v.m(), null, null, C1173v.m());
        this.f1338a = kI0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public S H() {
        return this.f1338a.H();
    }

    @Override // E9.j0
    public boolean J() {
        return this.f1338a.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public S K() {
        return this.f1338a.K();
    }

    @Override // E9.O
    public InterfaceC0812q L() {
        return this.f1338a.L();
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return this.f1338a.S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, E9.InterfaceC0803h
    public O a() {
        O oA = this.f1338a.a();
        p.h(oA, "getOriginal(...)");
        return oA;
    }

    @Override // E9.InterfaceC0804i, E9.InterfaceC0803h
    public InterfaceC0803h b() {
        InterfaceC0803h interfaceC0803hB = this.f1338a.b();
        p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        return interfaceC0803hB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return this.f1338a.b0();
    }

    @Override // E9.Y
    public O c(TypeSubstitutor substitutor) {
        p.i(substitutor, "substitutor");
        return this.f1338a.c(substitutor);
    }

    @Override // E9.O, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends O> d() {
        Collection<? extends O> collectionD = this.f1338a.d();
        p.h(collectionD, "getOverriddenDescriptors(...)");
        return collectionD;
    }

    @Override // E9.InterfaceC0806k
    public W e() {
        W wE = this.f1338a.e();
        p.h(wE, "getSource(...)");
        return wE;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return this.f1338a.e0();
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        F9.g annotations = this.f1338a.getAnnotations();
        p.h(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // E9.O
    public P getGetter() {
        return this.f1338a.getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f1338a.getKind();
        p.h(kind, "getKind(...)");
        return kind;
    }

    @Override // E9.A
    public ga.e getName() {
        ga.e name = this.f1338a.getName();
        p.h(name, "getName(...)");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        return this.f1338a.getReturnType();
    }

    @Override // E9.O
    public Q getSetter() {
        return this.f1338a.getSetter();
    }

    @Override // E9.h0
    public ya.S getType() {
        ya.S type = this.f1338a.getType();
        p.h(type, "getType(...)");
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<b0> getTypeParameters() {
        List<b0> typeParameters = this.f1338a.getTypeParameters();
        p.h(typeParameters, "getTypeParameters(...)");
        return typeParameters;
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p visibility = this.f1338a.getVisibility();
        p.h(visibility, "getVisibility(...)");
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        List<i0> listI = this.f1338a.i();
        p.h(listI, "getValueParameters(...)");
        return listI;
    }

    @Override // E9.j0
    public AbstractC4927g<?> i0() {
        return this.f1338a.i0();
    }

    @Override // E9.j0
    public boolean isConst() {
        return this.f1338a.isConst();
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return this.f1338a.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V o0(a.InterfaceC0437a<V> interfaceC0437a) {
        return (V) this.f1338a.o0(interfaceC0437a);
    }

    @Override // E9.InterfaceC0816v
    public Modality p() {
        Modality modalityP = this.f1338a.p();
        p.h(modalityP, "getModality(...)");
        return modalityP;
    }

    @Override // E9.O
    public InterfaceC0812q r0() {
        return this.f1338a.r0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<S> s0() {
        List<S> listS0 = this.f1338a.s0();
        p.h(listS0, "getContextReceiverParameters(...)");
        return listS0;
    }

    @Override // E9.O
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f> t() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.f> listT = this.f1338a.t();
        p.h(listT, "getAccessors(...)");
        return listT;
    }

    @Override // E9.j0
    public boolean t0() {
        return this.f1338a.t0();
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return (R) this.f1338a.v(interfaceC0805j, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void x0(Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        p.i(overriddenDescriptors, "overriddenDescriptors");
        this.f1338a.x0(overriddenDescriptors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        O oH0 = this.f1338a.y(interfaceC0803h, modality, abstractC0811p, kind, z10);
        p.h(oH0, "copy(...)");
        return oH0;
    }

    @Override // E9.k0
    public boolean z() {
        return this.f1338a.z();
    }
}
