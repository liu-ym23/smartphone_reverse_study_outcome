package f8;

import java.util.List;

/* loaded from: classes.dex */
public final class d0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3472g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i5.f f3473h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(i5.f fVar, int i2) {
        super(1);
        this.f3472g = i2;
        this.f3473h = fVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        f fVarI;
        switch (this.f3472g) {
            case 0:
                b0 b0Var = (b0) obj;
                q7.k.e(b0Var, "<name for destructuring parameter 0>");
                e9.b bVar = b0Var.f3462a;
                List list = b0Var.f3463b;
                if (bVar.f3186c) {
                    throw new UnsupportedOperationException("Unresolved local class: " + bVar);
                }
                e9.b bVarF = bVar.f();
                i5.f fVar = this.f3473h;
                if (bVarF != null) {
                    fVarI = fVar.I(bVarF, d7.r.K0(list, 1));
                } else {
                    u9.e eVar = (u9.e) fVar.f4655i;
                    e9.c cVarG = bVar.g();
                    q7.k.d(cVarG, "classId.packageFqName");
                    fVarI = (f) eVar.invoke(cVarG);
                }
                f fVar2 = fVarI;
                boolean z4 = !bVar.f3185b.e().d();
                u9.k kVar = (u9.k) fVar.f4653g;
                e9.f fVarI2 = bVar.i();
                q7.k.d(fVarI2, "classId.shortClassName");
                Integer num = (Integer) d7.r.P0(list);
                return new c0(kVar, fVar2, fVarI2, z4, num != null ? num.intValue() : 0);
            default:
                e9.c cVar = (e9.c) obj;
                q7.k.e(cVar, "fqName");
                return new e8.k((z) this.f3473h.f4654h, cVar, 1);
        }
    }
}
