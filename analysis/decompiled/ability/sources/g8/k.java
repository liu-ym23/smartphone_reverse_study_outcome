package g8;

import Q8.o;
import h8.InterfaceC1540w;
import k8.AbstractC1629B;

/* loaded from: classes4.dex */
public final class k extends AbstractC1629B {
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(InterfaceC1540w module, G8.c fqName, int i) {
        super(module, fqName);
        this.g = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.k.f(module, "module");
                kotlin.jvm.internal.k.f(fqName, "fqName");
                super(module, fqName);
                break;
            default:
                break;
        }
    }

    @Override // h8.InterfaceC1494B
    public final /* bridge */ /* synthetic */ o w() {
        switch (this.g) {
        }
        return Q8.n.b;
    }
}
