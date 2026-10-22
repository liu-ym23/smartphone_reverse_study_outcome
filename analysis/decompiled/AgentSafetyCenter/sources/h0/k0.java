package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f5039c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f5040f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5041g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5042h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(w0.m mVar, float f5, long j10, int i, int i3) {
        super(2);
        this.f5039c = mVar;
        this.f5040f = f5;
        this.f5041g = j10;
        this.f5042h = i;
        this.i = i3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        b1.d(this.f5039c, this.f5040f, this.f5041g, (k0.s) obj, k0.z.D(this.f5042h | 1), this.i);
        return jb.v.f6774a;
    }
}
