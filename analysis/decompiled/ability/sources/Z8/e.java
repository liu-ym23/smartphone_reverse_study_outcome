package Z8;

import X8.w;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import k8.H;
import k8.I;
import k8.J;
import k8.r;
import k8.u;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;

/* loaded from: classes4.dex */
public final class e implements InterfaceC1501I {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ H f1617a;

    public e() {
        i iVar = i.f1619a;
        a aVar = i.c;
        Modality modality = Modality.d;
        C1531n c1531n = AbstractC1532o.e;
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        H hS0 = H.S0(aVar, modality, c1531n, true, G8.f.g("<Error property>"), CallableMemberDescriptor$Kind.f4950a, InterfaceC1503K.f4577I);
        g gVar = i.e;
        EmptyList emptyList = EmptyList.f4893a;
        hS0.Y0(gVar, emptyList, null, null, emptyList);
        this.f1617a = hS0;
    }

    @Override // h8.InterfaceC1519b
    public final u E() {
        return this.f1617a.f4834t;
    }

    @Override // h8.InterfaceC1510S
    public final boolean H() {
        return this.f1617a.f;
    }

    @Override // h8.InterfaceC1519b
    public final u I() {
        return this.f1617a.u;
    }

    @Override // h8.InterfaceC1501I
    public final r J() {
        return this.f1617a.f4838z;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        H h = this.f1617a;
        h.getClass();
        return interfaceC1529l.p(h, obj);
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        this.f1617a.getClass();
        return false;
    }

    @Override // h8.InterfaceC1520c
    public final InterfaceC1520c U(InterfaceC1522e interfaceC1522e, Modality modality, C1531n c1531n) {
        return this.f1617a.U(interfaceC1522e, modality, c1531n);
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1501I a() {
        InterfaceC1501I interfaceC1501IA = this.f1617a.a();
        k.e(interfaceC1501IA, "getOriginal(...)");
        return interfaceC1501IA;
    }

    @Override // h8.InterfaceC1505M
    public final InterfaceC1501I b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        k.f(substitutor, "substitutor");
        return this.f1617a.b(substitutor);
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        InterfaceC1527j interfaceC1527jD = this.f1617a.d();
        k.e(interfaceC1527jD, "getContainingDeclaration(...)");
        return interfaceC1527jD;
    }

    @Override // h8.InterfaceC1520c, h8.InterfaceC1519b
    public final Collection e() {
        Collection collectionE = this.f1617a.e();
        k.e(collectionE, "getOverriddenDescriptors(...)");
        return collectionE;
    }

    @Override // h8.InterfaceC1519b
    public final boolean e0() {
        this.f1617a.getClass();
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return this.f1617a.p;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        InterfaceC1561g annotations = this.f1617a.getAnnotations();
        k.e(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // h8.InterfaceC1501I
    public final I getGetter() {
        return this.f1617a.f4836w;
    }

    @Override // h8.InterfaceC1520c
    public final CallableMemberDescriptor$Kind getKind() {
        CallableMemberDescriptor$Kind kind = this.f1617a.getKind();
        k.e(kind, "getKind(...)");
        return kind;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        G8.f name = this.f1617a.getName();
        k.e(name, "getName(...)");
        return name;
    }

    @Override // h8.InterfaceC1519b
    public final w getReturnType() {
        return this.f1617a.getReturnType();
    }

    @Override // h8.InterfaceC1501I
    public final J getSetter() {
        return this.f1617a.f4837x;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        InterfaceC1503K source = this.f1617a.getSource();
        k.e(source, "getSource(...)");
        return source;
    }

    @Override // h8.InterfaceC1509Q
    public final w getType() {
        w type = this.f1617a.getType();
        k.e(type, "getType(...)");
        return type;
    }

    @Override // h8.InterfaceC1519b
    public final List getTypeParameters() {
        return this.f1617a.getTypeParameters();
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n visibility = this.f1617a.getVisibility();
        k.e(visibility, "getVisibility(...)");
        return visibility;
    }

    @Override // h8.InterfaceC1539v
    public final Modality i() {
        Modality modalityI = this.f1617a.i();
        k.e(modalityI, "getModality(...)");
        return modalityI;
    }

    @Override // h8.InterfaceC1510S
    public final L8.g i0() {
        return this.f1617a.i0();
    }

    @Override // h8.InterfaceC1510S
    public final boolean isConst() {
        return this.f1617a.isConst();
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return this.f1617a.isExternal();
    }

    @Override // h8.InterfaceC1501I
    public final ArrayList l() {
        return this.f1617a.l();
    }

    @Override // h8.InterfaceC1501I
    public final r o0() {
        return this.f1617a.y;
    }

    @Override // h8.InterfaceC1519b
    public final List p0() {
        List listP0 = this.f1617a.p0();
        k.e(listP0, "getContextReceiverParameters(...)");
        return listP0;
    }

    @Override // h8.InterfaceC1510S
    public final boolean q0() {
        return this.f1617a.n;
    }

    @Override // h8.InterfaceC1501I
    public final boolean s() {
        return this.f1617a.f4832r;
    }

    @Override // h8.InterfaceC1520c
    public final void u0(Collection collection) {
        this.f1617a.k = collection;
    }

    @Override // h8.InterfaceC1519b
    public final Object v0(InterfaceC1518a interfaceC1518a) {
        this.f1617a.getClass();
        return null;
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        this.f1617a.x();
        List list = Collections.EMPTY_LIST;
        k.e(list, "getValueParameters(...)");
        return list;
    }
}
