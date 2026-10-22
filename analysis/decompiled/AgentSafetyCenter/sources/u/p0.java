package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13547c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f13548f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f13549g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f13550h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(Object obj, Object obj2, Object obj3, int i) {
        super(2);
        this.f13547c = i;
        this.f13548f = obj;
        this.f13549g = obj2;
        this.f13550h = obj3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f13547c) {
            case 0:
                float fFloatValue = ((Number) obj).floatValue();
                ((Number) obj2).floatValue();
                yb.r rVar = (yb.r) this.f13548f;
                float f5 = fFloatValue - rVar.f16095c;
                z0 z0Var = (z0) this.f13549g;
                y0 y0Var = (y0) this.f13550h;
                long jG = z0Var.g(z0Var.c(f5));
                z0 z0Var2 = y0Var.f13619a;
                rVar.f16095c += z0Var.c(z0Var.f(z0.a(z0Var2, z0Var2.f13631h, jG, 1)));
                break;
            case 1:
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    v1.a1.a((v1.t) this.f13548f, (v1.o0) this.f13549g, (xb.p) this.f13550h, sVar, 0);
                } else {
                    sVar.S();
                }
                break;
            case 2:
                ((Number) obj2).intValue();
                v1.a1.a((u1.n1) this.f13548f, (v1.o0) this.f13549g, (xb.p) this.f13550h, (k0.s) obj, k0.z.D(1));
                break;
            default:
                ((Number) obj2).intValue();
                t.m0.a((w0.m) this.f13548f, (w0.e) this.f13549g, (s0.c) this.f13550h, (k0.s) obj, k0.z.D(3073));
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(Object obj, Object obj2, xb.p pVar, int i, int i3) {
        super(2);
        this.f13547c = i3;
        this.f13548f = obj;
        this.f13549g = obj2;
        this.f13550h = pVar;
    }
}
