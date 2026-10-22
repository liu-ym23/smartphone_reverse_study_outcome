package b8;

import h8.InterfaceC1500H;
import h8.InterfaceC1520c;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes4.dex */
public abstract class h0 extends d0 implements Z7.h {
    public static final /* synthetic */ Z7.t[] i;
    public final p0 g = N9.j.E(null, new g0(this, 0));
    public final Object h = kotlin.a.b(LazyThreadSafetyMode.b, new g0(this, 1));

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        i = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(h0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;"))};
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0857s
    public final c8.e d() {
        return (c8.e) this.h.getF4884a();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h0) && kotlin.jvm.internal.k.b(p(), ((h0) obj).p());
    }

    @Override // b8.AbstractC0857s
    public final InterfaceC1520c g() {
        Z7.t tVar = i[0];
        Object objInvoke = this.g.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        return (k8.J) objInvoke;
    }

    @Override // Z7.c
    public final String getName() {
        return B7.a.g('>', p().h, new StringBuilder("<set-"));
    }

    public final int hashCode() {
        return p().hashCode();
    }

    @Override // b8.d0
    public final InterfaceC1500H o() {
        Z7.t tVar = i[0];
        Object objInvoke = this.g.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        return (k8.J) objInvoke;
    }

    public final String toString() {
        return "setter of " + p();
    }
}
