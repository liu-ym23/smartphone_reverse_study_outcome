package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5114c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5115f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5116g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5117h;
    public final /* synthetic */ xb.p i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(Object obj, Object obj2, Object obj3, xb.p pVar, int i, int i3) {
        super(2);
        this.f5114c = i3;
        this.f5115f = obj;
        this.f5116g = obj2;
        this.f5117h = obj3;
        this.i = pVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5114c) {
            case 0:
                ((Number) obj2).intValue();
                r0.a((z) this.f5115f, (l1) this.f5116g, (v1) this.f5117h, (s0.c) this.i, (k0.s) obj, k0.z.D(3457));
                break;
            default:
                ((Number) obj2).intValue();
                xb.a aVar = (xb.a) this.f5115f;
                w0.m mVar = (w0.m) this.f5116g;
                y.e0 e0Var = (y.e0) this.f5117h;
                t.m0.d(aVar, mVar, e0Var, this.i, (k0.s) obj, k0.z.D(1));
                break;
        }
        return jb.v.f6774a;
    }
}
