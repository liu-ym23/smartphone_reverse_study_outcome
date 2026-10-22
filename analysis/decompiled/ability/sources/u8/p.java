package u8;

import a.AbstractC0291a;
import h8.InterfaceC1503K;
import i8.C1560f;
import i8.InterfaceC1561g;
import k8.AbstractC1629B;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import t8.C2024a;

/* loaded from: classes4.dex */
public final class p extends AbstractC1629B {
    public static final /* synthetic */ Z7.t[] m;
    public final n8.r g;
    public final K1.a h;
    public final W8.h i;

    /* renamed from: j, reason: collision with root package name */
    public final C2050e f6732j;
    public final W8.c k;
    public final InterfaceC1561g l;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        m = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(p.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), nVar.g(new PropertyReference1Impl(nVar.b(p.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p(K1.a outerContext, n8.r rVar) {
        kotlin.jvm.internal.k.f(outerContext, "outerContext");
        C2024a c2024a = (C2024a) outerContext.f903a;
        super(c2024a.o, rVar.f5363a);
        this.g = rVar;
        K1.a aVarO = Z6.k.o(outerContext, this, null, 6);
        this.h = aVarO;
        kotlin.jvm.internal.k.f(c2024a.d.c().c, "<this>");
        F8.f fVar = F8.f.g;
        C2024a c2024a2 = (C2024a) aVarO.f903a;
        W8.l lVar = c2024a2.f6670a;
        o oVar = new o(this, 0);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.i = new W8.h(iVar, oVar);
        this.f6732j = new C2050e(aVarO, rVar, this);
        o oVar2 = new o(this, 1);
        EmptyList emptyList = EmptyList.f4893a;
        W8.i iVar2 = (W8.i) lVar;
        iVar2.getClass();
        if (emptyList == null) {
            W8.i.a(27);
            throw null;
        }
        this.k = new W8.c(iVar2, oVar2, emptyList);
        this.l = c2024a2.f6676v.c ? C1560f.f4611a : AbstractC0291a.G(aVarO, rVar);
        ((W8.i) lVar).b(new o(this, 2));
    }

    @Override // A8.b, i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return this.l;
    }

    @Override // k8.AbstractC1629B, k8.AbstractC1645n, h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        return new A8.d(this, 8);
    }

    @Override // k8.AbstractC1629B, k8.AbstractC1644m
    public final String toString() {
        return "Lazy Java package fragment: " + this.e + " of module " + ((C2024a) this.h.f903a).o;
    }

    @Override // h8.InterfaceC1494B
    public final Q8.o w() {
        return this.f6732j;
    }
}
