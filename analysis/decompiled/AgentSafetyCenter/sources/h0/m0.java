package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5066c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f5067f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5068g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5069h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(long j10, d2.l0 l0Var, s0.c cVar, int i) {
        super(2);
        this.f5067f = j10;
        this.f5069h = l0Var;
        this.i = cVar;
        this.f5068g = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5066c) {
            case 0:
                ((Number) obj2).intValue();
                i1.f fVar = (i1.f) this.f5069h;
                w0.m mVar = (w0.m) this.i;
                o0.b(fVar, mVar, this.f5067f, (k0.s) obj, k0.z.D(this.f5068g | 1));
                break;
            default:
                ((Number) obj2).intValue();
                d2.l0 l0Var = (d2.l0) this.f5069h;
                s0.c cVar = (s0.c) this.i;
                p5.f.c(this.f5067f, l0Var, cVar, (k0.s) obj, k0.z.D(this.f5068g | 1));
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(i1.f fVar, w0.m mVar, long j10, int i) {
        super(2);
        this.f5069h = fVar;
        this.i = mVar;
        this.f5067f = j10;
        this.f5068g = i;
    }
}
