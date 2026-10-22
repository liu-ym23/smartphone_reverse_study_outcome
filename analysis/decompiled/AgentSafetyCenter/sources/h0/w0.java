package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f5231c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f5232f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f5233g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f5234h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(w0.m mVar, long j10, float f5, long j11, int i, int i3) {
        super(2);
        this.f5231c = mVar;
        this.f5232f = j10;
        this.f5233g = f5;
        this.f5234h = j11;
        this.i = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iD = k0.z.D(49);
        z0.a(this.f5231c, this.f5232f, this.f5233g, this.f5234h, this.i, (k0.s) obj, iD);
        return jb.v.f6774a;
    }
}
