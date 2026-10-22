package T8;

import h8.InterfaceC1503K;

/* loaded from: classes4.dex */
public final class x extends J5.b {
    public final G8.c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(G8.c fqName, D8.f nameResolver, D8.j jVar, InterfaceC1503K interfaceC1503K) {
        super(nameResolver, jVar, interfaceC1503K);
        kotlin.jvm.internal.k.f(fqName, "fqName");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        this.e = fqName;
    }

    @Override // J5.b
    public final G8.c a() {
        return this.e;
    }
}
