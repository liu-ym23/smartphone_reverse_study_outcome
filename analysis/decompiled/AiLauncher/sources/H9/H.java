package H9;

import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0819y;

/* loaded from: classes5.dex */
public abstract class H extends AbstractC0835n implements E9.E {

    /* renamed from: e, reason: collision with root package name */
    public final ga.c f3018e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3019f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(InterfaceC0819y module, ga.c fqName) {
        super(module, F9.g.f2609m0.b(), fqName.g(), E9.W.f2444a);
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        this.f3018e = fqName;
        this.f3019f = "package " + fqName + " of " + module;
    }

    @Override // H9.AbstractC0835n, E9.InterfaceC0806k
    public E9.W e() {
        E9.W NO_SOURCE = E9.W.f2444a;
        kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // E9.E
    public final ga.c f() {
        return this.f3018e;
    }

    @Override // H9.AbstractC0834m
    public String toString() {
        return this.f3019f;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> visitor, D d10) {
        kotlin.jvm.internal.p.i(visitor, "visitor");
        return visitor.g(this, d10);
    }

    @Override // H9.AbstractC0835n, E9.InterfaceC0803h
    public InterfaceC0819y b() {
        InterfaceC0803h interfaceC0803hB = super.b();
        kotlin.jvm.internal.p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (InterfaceC0819y) interfaceC0803hB;
    }
}
