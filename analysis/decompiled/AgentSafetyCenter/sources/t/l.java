package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f13029c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d1.f0 f13030f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f13031g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f13032h;
    public final /* synthetic */ float i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f13033j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f13034k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f1.g f13035l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(boolean z10, d1.l0 l0Var, long j10, float f5, float f10, long j11, long j12, f1.g gVar) {
        super(1);
        this.f13029c = z10;
        this.f13030f = l0Var;
        this.f13031g = j10;
        this.f13032h = f5;
        this.i = f10;
        this.f13033j = j11;
        this.f13034k = j12;
        this.f13035l = gVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        u1.i0 i0Var = (u1.i0) obj;
        i0Var.b();
        f1.b bVar = i0Var.f13838c;
        if (this.f13029c) {
            f1.d.p(i0Var, this.f13030f, 0L, 0L, this.f13031g, null, 246);
        } else {
            long j10 = this.f13031g;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
            float f5 = this.f13032h;
            if (fIntBitsToFloat < f5) {
                float f10 = this.i;
                float fE = c1.e.e(bVar.e());
                float f11 = this.i;
                float f12 = fE - f11;
                float fC = c1.e.c(bVar.e()) - f11;
                d1.f0 f0Var = this.f13030f;
                long j11 = this.f13031g;
                p5.m mVar = bVar.f3859f;
                long jD = mVar.D();
                mVar.y().i();
                try {
                    ((p5.m) ((a1.g) mVar.f9741f).f19f).y().m(f10, f10, f12, fC, 0);
                    f1.d.p(i0Var, f0Var, 0L, 0L, j11, null, 246);
                } finally {
                    mVar.y().o();
                    mVar.R(jD);
                }
            } else {
                f1.d.p(i0Var, this.f13030f, this.f13033j, this.f13034k, p5.f.J(f5, j10), this.f13035l, 208);
            }
        }
        return jb.v.f6774a;
    }
}
