package y;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11387g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f11388h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ j0.d f11389i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f11390j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j2, r.c0 c0Var, j0.d dVar) {
        super(2);
        this.f11388h = j2;
        this.f11390j = c0Var;
        this.f11389i = dVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11387g) {
            case 0:
                b0.p pVar = (b0.p) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
                    pVar.O();
                } else {
                    z.a.a(this.f11388h, ((l0) pVar.j(m0.f11505a)).f11500m, j0.i.d(1327513942, new h9.b(6, (r.c0) this.f11390j, this.f11389i), pVar), pVar, 384);
                }
                break;
            default:
                ((Number) obj2).intValue();
                s1.h0 h0Var = (s1.h0) this.f11390j;
                z.a.a(this.f11388h, h0Var, this.f11389i, (b0.p) obj, b0.b.s(385));
                break;
        }
        return c7.r.f1986a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j2, s1.h0 h0Var, j0.d dVar, int i2) {
        super(2);
        this.f11388h = j2;
        this.f11390j = h0Var;
        this.f11389i = dVar;
    }
}
