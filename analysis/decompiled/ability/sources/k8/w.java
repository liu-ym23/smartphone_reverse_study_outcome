package k8;

import h8.InterfaceC1498F;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import i8.C1560f;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes4.dex */
public final class w extends AbstractC1644m implements InterfaceC1498F {
    public static final /* synthetic */ Z7.t[] h;
    public final z c;
    public final G8.c d;
    public final W8.h e;
    public final W8.h f;
    public final Q8.k g;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        h = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(w.class), "fragments", "getFragments()Ljava/util/List;")), nVar.g(new PropertyReference1Impl(nVar.b(w.class), "empty", "getEmpty()Z"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(z zVar, G8.c fqName, W8.i storageManager) {
        super(C1560f.f4611a, fqName.g());
        kotlin.jvm.internal.k.f(fqName, "fqName");
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.c = zVar;
        this.d = fqName;
        this.e = new W8.h(storageManager, new v(this, 0));
        this.f = new W8.h(storageManager, new v(this, 1));
        this.g = new Q8.k(storageManager, new v(this, 2));
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.j(this, obj);
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        G8.c cVar = this.d;
        if (cVar.d()) {
            return null;
        }
        return this.c.V(cVar.e());
    }

    public final boolean equals(Object obj) {
        InterfaceC1498F interfaceC1498F = obj instanceof InterfaceC1498F ? (InterfaceC1498F) obj : null;
        if (interfaceC1498F == null) {
            return false;
        }
        w wVar = (w) interfaceC1498F;
        return kotlin.jvm.internal.k.b(this.d, wVar.d) && kotlin.jvm.internal.k.b(this.c, wVar.c);
    }

    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() * 31);
    }
}
