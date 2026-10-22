package o;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f7082g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u0.z f7083h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f7084i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f7085j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ float f7086k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f7087l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f7088m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w0.g f7089n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(boolean z4, u0.e0 e0Var, long j2, float f10, float f11, long j4, long j10, w0.g gVar) {
        super(1);
        this.f7082g = z4;
        this.f7083h = e0Var;
        this.f7084i = j2;
        this.f7085j = f10;
        this.f7086k = f11;
        this.f7087l = j4;
        this.f7088m = j10;
        this.f7089n = gVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        i1.h0 h0Var = (i1.h0) obj;
        h0Var.a();
        w0.b bVar = h0Var.f4489f;
        if (this.f7082g) {
            w0.d.w(h0Var, this.f7083h, 0L, 0L, this.f7084i, null, 246);
        } else {
            long j2 = this.f7084i;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            float f10 = this.f7085j;
            if (fIntBitsToFloat < f10) {
                float f11 = this.f7086k;
                float fD = t0.e.d(bVar.d());
                float f12 = this.f7086k;
                float f13 = fD - f12;
                float fB = t0.e.b(bVar.d()) - f12;
                u0.z zVar = this.f7083h;
                long j4 = this.f7084i;
                u5.h hVar = bVar.f10630g;
                long jB = hVar.b();
                hVar.a().h();
                try {
                    ((u5.h) ((o4.d0) hVar.f10129a).f7326g).a().e(f11, f11, f13, fB, 0);
                    w0.d.w(h0Var, zVar, 0L, 0L, j4, null, 246);
                } finally {
                    hVar.a().g();
                    hVar.j(jB);
                }
            } else {
                w0.d.w(h0Var, this.f7083h, this.f7087l, this.f7088m, n7.a.z(f10, j2), this.f7089n, 208);
            }
        }
        return c7.r.f1986a;
    }
}
