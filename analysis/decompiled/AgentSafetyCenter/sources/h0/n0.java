package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h1.b f5083c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f5084f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w0.m f5085g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f5086h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(h1.b bVar, String str, w0.m mVar, long j10, int i) {
        super(2);
        this.f5083c = bVar;
        this.f5084f = str;
        this.f5085g = mVar;
        this.f5086h = j10;
        this.i = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        o0.a(this.f5083c, this.f5084f, this.f5085g, this.f5086h, (k0.s) obj, k0.z.D(this.i | 1));
        return jb.v.f6774a;
    }
}
