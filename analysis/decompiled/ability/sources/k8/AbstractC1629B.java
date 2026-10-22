package k8;

import h8.InterfaceC1494B;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1540w;
import i8.C1560f;

/* renamed from: k8.B, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1629B extends AbstractC1645n implements InterfaceC1494B {
    public final G8.c e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1629B(InterfaceC1540w module, G8.c fqName) {
        super(module, C1560f.f4611a, fqName.g(), InterfaceC1503K.f4577I);
        kotlin.jvm.internal.k.f(module, "module");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        this.e = fqName;
        this.f = "package " + fqName + " of " + module;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.u(this, obj);
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1527j
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1540w d() {
        InterfaceC1527j interfaceC1527jD = super.d();
        kotlin.jvm.internal.k.d(interfaceC1527jD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (InterfaceC1540w) interfaceC1527jD;
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1528k
    public InterfaceC1503K getSource() {
        return InterfaceC1503K.f4577I;
    }

    @Override // k8.AbstractC1644m
    public String toString() {
        return this.f;
    }
}
