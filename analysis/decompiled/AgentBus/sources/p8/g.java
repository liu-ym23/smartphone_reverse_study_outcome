package p8;

import c8.m;
import java.util.Map;
import q7.k;
import q7.p;
import q7.w;
import q7.x;
import w7.t;

/* loaded from: classes.dex */
public final class g extends b {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ t[] f8516g;

    /* renamed from: f, reason: collision with root package name */
    public final u9.i f8517f;

    static {
        x xVar = w.f8821a;
        f8516g = new t[]{xVar.f(new p(xVar.b(g.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(l8.e eVar, a3.b bVar) {
        super(bVar, eVar, m.f2042m);
        k.e(bVar, "c");
        u9.k kVar = (u9.k) ((r8.a) bVar.f162f).f9002a;
        kVar.getClass();
        this.f8517f = new u9.i(kVar, f.f8515g);
    }

    @Override // p8.b, g8.c
    public final Map b() {
        return (Map) n7.b.q(this.f8517f, f8516g[0]);
    }
}
