package k8;

import f8.C1444e;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1499G;
import h8.InterfaceC1503K;
import h8.InterfaceC1510S;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* loaded from: classes4.dex */
public class Q extends S implements InterfaceC1499G, InterfaceC1510S {
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final X8.w f4842j;
    public final Q k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(InterfaceC1519b containingDeclaration, Q q5, int i, InterfaceC1561g annotations, G8.f name, X8.w outType, boolean z10, boolean z11, boolean z12, X8.w wVar, InterfaceC1503K source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(outType, "outType");
        kotlin.jvm.internal.k.f(source, "source");
        this.f = i;
        this.g = z10;
        this.h = z11;
        this.i = z12;
        this.f4842j = wVar;
        this.k = q5 == null ? this : q5;
    }

    @Override // h8.InterfaceC1510S
    public final boolean H() {
        return false;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.s(this, obj);
    }

    public Q R0(C1444e c1444e, G8.f fVar, int i) {
        InterfaceC1561g annotations = getAnnotations();
        kotlin.jvm.internal.k.e(annotations, "<get-annotations>(...)");
        X8.w type = getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        return new Q(c1444e, null, i, annotations, fVar, type, S0(), this.h, this.i, this.f4842j, InterfaceC1503K.f4577I);
    }

    public final boolean S0() {
        if (!this.g) {
            return false;
        }
        CallableMemberDescriptor$Kind kind = ((InterfaceC1520c) d()).getKind();
        kind.getClass();
        return kind != CallableMemberDescriptor$Kind.b;
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1527j
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1519b d() {
        InterfaceC1527j interfaceC1527jD = super.d();
        kotlin.jvm.internal.k.d(interfaceC1527jD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (InterfaceC1519b) interfaceC1527jD;
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public final Q a() {
        Q q5 = this.k;
        return q5 == this ? this : q5.a();
    }

    @Override // h8.InterfaceC1505M
    public final InterfaceC1528k b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        kotlin.jvm.internal.k.f(substitutor, "substitutor");
        if (substitutor.f5144a.e()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // h8.InterfaceC1519b
    public final Collection e() {
        Collection collectionE = d().e();
        kotlin.jvm.internal.k.e(collectionE, "getOverriddenDescriptors(...)");
        Collection collection = collectionE;
        ArrayList arrayList = new ArrayList(D7.w.c0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Q) ((InterfaceC1519b) it.next()).x().get(this.f));
        }
        return arrayList;
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n LOCAL = AbstractC1532o.f;
        kotlin.jvm.internal.k.e(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // h8.InterfaceC1510S
    public final /* bridge */ /* synthetic */ L8.g i0() {
        return null;
    }
}
