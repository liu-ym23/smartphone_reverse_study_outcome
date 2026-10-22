package p8;

import c8.m;
import java.util.Map;
import q7.k;
import q7.p;
import q7.w;
import q7.x;
import u9.n;
import w7.t;

/* loaded from: classes.dex */
public final class j extends b {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ t[] f8523g;

    /* renamed from: f, reason: collision with root package name */
    public final u9.i f8524f;

    static {
        x xVar = w.f8821a;
        f8523g = new t[]{xVar.f(new p(xVar.b(j.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l8.e eVar, a3.b bVar) {
        super(bVar, eVar, m.f2049t);
        k.e(eVar, "annotation");
        k.e(bVar, "c");
        n nVar = ((r8.a) bVar.f162f).f9002a;
        a8.c cVar = new a8.c(24, this);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f8524f = new u9.i(kVar, cVar);
    }

    @Override // p8.b, g8.c
    public final Map b() {
        return (Map) n7.b.q(this.f8524f, f8523g[0]);
    }
}
