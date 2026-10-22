package r8;

import W8.l;
import Z7.t;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import t8.C2024a;
import u8.C2049d;

/* loaded from: classes4.dex */
public final class j extends C1880b {
    public static final /* synthetic */ t[] g;
    public final W8.h f;

    static {
        n nVar = m.f4928a;
        g = new t[]{nVar.g(new PropertyReference1Impl(nVar.b(j.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n8.d annotation, K1.a c) {
        super(c, annotation, e8.n.f4421t);
        k.f(annotation, "annotation");
        k.f(c, "c");
        l lVar = ((C2024a) c.f903a).f6670a;
        C2049d c2049d = new C2049d(this, 1);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.f = new W8.h(iVar, c2049d);
    }

    @Override // r8.C1880b, i8.InterfaceC1556b
    public final Map a() {
        return (Map) S0.b.g1(this.f, g[0]);
    }
}
