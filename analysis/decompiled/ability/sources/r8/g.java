package r8;

import Z7.t;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import t8.C2024a;

/* loaded from: classes4.dex */
public final class g extends C1880b {
    public static final /* synthetic */ t[] g;
    public final W8.h f;

    static {
        n nVar = m.f4928a;
        g = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(g.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(n8.d dVar, K1.a c) {
        super(c, dVar, e8.n.m);
        k.f(c, "c");
        W8.i iVar = (W8.i) ((C2024a) c.f903a).f6670a;
        iVar.getClass();
        this.f = new W8.h(iVar, f.f5684a);
    }

    @Override // r8.C1880b, i8.InterfaceC1556b
    public final Map a() {
        return (Map) S0.b.g1(this.f, g[0]);
    }
}
