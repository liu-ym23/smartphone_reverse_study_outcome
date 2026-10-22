package k8;

import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1506N;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1525h;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public final class N extends t implements M {

    /* renamed from: G, reason: collision with root package name */
    public static final C1630C f4839G;

    /* renamed from: D, reason: collision with root package name */
    public final W8.l f4840D;
    public final InterfaceC1506N E;

    /* renamed from: F, reason: collision with root package name */
    public C1640i f4841F;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        nVar.g(new PropertyReference1Impl(nVar.b(N.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"));
        f4839G = new C1630C();
    }

    public N(W8.l lVar, InterfaceC1506N interfaceC1506N, C1640i c1640i, M m, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        super(G8.h.e, interfaceC1506N, m, interfaceC1503K, interfaceC1561g, callableMemberDescriptor$Kind);
        this.f4840D = lVar;
        this.E = interfaceC1506N;
        J4.e eVar = new J4.e(15, this, c1640i);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        new kotlin.reflect.jvm.internal.impl.storage.a(iVar, eVar);
        this.f4841F = c1640i;
    }

    @Override // k8.t
    public final t T0(G8.f fVar, InterfaceC1527j newOwner, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g annotations, CallableMemberDescriptor$Kind kind) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = CallableMemberDescriptor$Kind.f4950a;
        if (kind != callableMemberDescriptor$Kind) {
            CallableMemberDescriptor$Kind callableMemberDescriptor$Kind2 = CallableMemberDescriptor$Kind.d;
        }
        return new N(this.f4840D, this.E, this.f4841F, this, annotations, callableMemberDescriptor$Kind, interfaceC1503K);
    }

    @Override // k8.t, h8.InterfaceC1520c
    public final InterfaceC1520c U(InterfaceC1522e newOwner, Modality modality, C1531n visibility) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(visibility, "visibility");
        C1649s c1649sX0 = X0(kotlin.reflect.jvm.internal.impl.types.a.b);
        c1649sX0.b = newOwner;
        c1649sX0.c = modality;
        c1649sX0.d = visibility;
        c1649sX0.f = CallableMemberDescriptor$Kind.b;
        c1649sX0.m = false;
        InterfaceC1536s interfaceC1536sU0 = c1649sX0.f4860x.U0(c1649sX0);
        kotlin.jvm.internal.k.d(interfaceC1536sU0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (M) interfaceC1536sU0;
    }

    @Override // h8.InterfaceC1526i
    public final boolean a0() {
        return this.f4841F.f4847D;
    }

    @Override // h8.InterfaceC1526i
    public final InterfaceC1522e b0() {
        InterfaceC1522e interfaceC1522eB0 = this.f4841F.b0();
        kotlin.jvm.internal.k.e(interfaceC1522eB0, "getConstructedClass(...)");
        return interfaceC1522eB0;
    }

    @Override // k8.t, k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public final M a() {
        InterfaceC1536s interfaceC1536sA = super.a();
        kotlin.jvm.internal.k.d(interfaceC1536sA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (M) interfaceC1536sA;
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1527j
    public final InterfaceC1525h d() {
        return this.E;
    }

    @Override // k8.t, h8.InterfaceC1536s, h8.InterfaceC1505M
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public final N b(kotlin.reflect.jvm.internal.impl.types.a substitutor) {
        kotlin.jvm.internal.k.f(substitutor, "substitutor");
        InterfaceC1536s interfaceC1536sB = super.b(substitutor);
        kotlin.jvm.internal.k.d(interfaceC1536sB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        N n = (N) interfaceC1536sB;
        X8.w wVar = n.g;
        kotlin.jvm.internal.k.c(wVar);
        C1640i c1640iB = this.f4841F.Q0().b(kotlin.reflect.jvm.internal.impl.types.a.d(wVar));
        if (c1640iB == null) {
            return null;
        }
        n.f4841F = c1640iB;
        return n;
    }

    @Override // k8.t, h8.InterfaceC1519b
    public final X8.w getReturnType() {
        X8.w wVar = this.g;
        kotlin.jvm.internal.k.c(wVar);
        return wVar;
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return this.E;
    }
}
