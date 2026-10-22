package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h1.b f13036c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w0.m f13037f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w0.e f13038g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s1.j f13039h;
    public final /* synthetic */ float i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f13040j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f13041k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(h1.b bVar, w0.m mVar, w0.e eVar, s1.j jVar, float f5, int i, int i3) {
        super(2);
        this.f13036c = bVar;
        this.f13037f = mVar;
        this.f13038g = eVar;
        this.f13039h = jVar;
        this.i = f5;
        this.f13040j = i;
        this.f13041k = i3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        m0.b(this.f13036c, this.f13037f, this.f13038g, this.f13039h, this.i, (k0.s) obj, k0.z.D(this.f13040j | 1), this.f13041k);
        return jb.v.f6774a;
    }
}
