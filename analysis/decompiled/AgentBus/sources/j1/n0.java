package j1;

/* loaded from: classes.dex */
public final class n0 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5258g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5259h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f5260i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5261j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(i1.k1 k1Var, u0 u0Var, p7.n nVar, int i2) {
        super(2);
        this.f5258g = 1;
        this.f5261j = k1Var;
        this.f5259h = u0Var;
        this.f5260i = nVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5258g) {
            case 0:
                b0.p pVar = (b0.p) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
                    g1.a((y) this.f5261j, (u0) this.f5259h, (p7.n) this.f5260i, pVar, 0);
                } else {
                    pVar.O();
                }
                break;
            case 1:
                ((Number) obj2).intValue();
                g1.a((i1.k1) this.f5261j, (u0) this.f5259h, (p7.n) this.f5260i, (b0.p) obj, b0.b.s(1));
                break;
            default:
                float fFloatValue = ((Number) obj).floatValue();
                ((Number) obj2).floatValue();
                q7.s sVar = (q7.s) this.f5261j;
                float f10 = fFloatValue - sVar.f8817f;
                p.y0 y0Var = (p.y0) this.f5259h;
                p.w0 w0Var = (p.w0) this.f5260i;
                long jG = y0Var.g(y0Var.c(f10));
                p.y0 y0Var2 = w0Var.f8200a;
                sVar.f8817f += y0Var.c(y0Var.f(p.y0.a(y0Var2, y0Var2.f8223h, jG, 1)));
                break;
        }
        return c7.r.f1986a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(Object obj, Object obj2, Object obj3, int i2) {
        super(2);
        this.f5258g = i2;
        this.f5261j = obj;
        this.f5259h = obj2;
        this.f5260i = obj3;
    }
}
