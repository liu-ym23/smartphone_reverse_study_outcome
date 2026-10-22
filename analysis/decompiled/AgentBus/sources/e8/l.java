package e8;

import d7.e0;
import d7.z;
import j9.w;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3158g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o f3159h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(o oVar, int i2) {
        super(0);
        this.f3158g = i2;
        this.f3159h = oVar;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f3158g;
        o oVar = this.f3159h;
        switch (i2) {
            case 0:
                return oVar.f3166a.f4739i.e();
            default:
                c8.h hVar = oVar.f3166a.f4739i;
                e9.f fVar = g8.f.f3883a;
                q7.k.e(hVar, "<this>");
                List listS = a.a.S(new g8.l(hVar, c8.m.f2042m, e0.U(new c7.j(g8.f.f3883a, new w("This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version")), new c7.j(g8.f.f3884b, new j9.a((Object) new g8.l(hVar, c8.m.f2044o, e0.U(new c7.j(g8.f.f3886d, new w("")), new c7.j(g8.f.f3887e, new j9.b(z.f2978f, new c1.w(1, hVar))))))), new c7.j(g8.f.f3885c, new j9.i(e9.b.j(c8.m.f2043n), e9.f.e("WARNING"))))));
                return listS.isEmpty() ? g8.h.f3888a : new g8.k(0, listS);
        }
    }
}
