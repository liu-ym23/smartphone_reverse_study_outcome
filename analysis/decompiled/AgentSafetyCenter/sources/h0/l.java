package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ xb.a f5048c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w0.m f5049f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s2.k f5050g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0.c f5051h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(xb.a aVar, w0.m mVar, s2.k kVar, s0.c cVar, int i) {
        super(2);
        this.f5048c = aVar;
        this.f5049f = mVar;
        this.f5050g = kVar;
        this.f5051h = cVar;
        this.i = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        m.d(this.f5048c, this.f5049f, this.f5050g, this.f5051h, (k0.s) obj, k0.z.D(this.i | 1));
        return jb.v.f6774a;
    }
}
