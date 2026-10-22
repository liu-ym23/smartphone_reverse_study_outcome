package k8;

import f8.C1444e;
import h8.InterfaceC1503K;
import h8.InterfaceC1519b;
import i8.InterfaceC1561g;

/* loaded from: classes4.dex */
public final class P extends Q {
    public final C7.f l;

    public P(InterfaceC1519b interfaceC1519b, Q q5, int i, InterfaceC1561g interfaceC1561g, G8.f fVar, X8.w wVar, boolean z10, boolean z11, boolean z12, X8.w wVar2, InterfaceC1503K interfaceC1503K, S7.a aVar) {
        super(interfaceC1519b, q5, i, interfaceC1561g, fVar, wVar, z10, z11, z12, wVar2, interfaceC1503K);
        this.l = kotlin.a.a(aVar);
    }

    @Override // k8.Q
    public final Q R0(C1444e c1444e, G8.f fVar, int i) {
        InterfaceC1561g annotations = getAnnotations();
        kotlin.jvm.internal.k.e(annotations, "<get-annotations>(...)");
        X8.w type = getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        return new P(c1444e, null, i, annotations, fVar, type, S0(), this.h, this.i, this.f4842j, InterfaceC1503K.f4577I, new I8.e(this, 26));
    }
}
