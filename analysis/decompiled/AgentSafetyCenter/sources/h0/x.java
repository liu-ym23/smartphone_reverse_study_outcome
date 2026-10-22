package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f5236c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d1.j0 f5237f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v f5238g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ w f5239h;
    public final /* synthetic */ s0.c i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w0.m mVar, d1.j0 j0Var, v vVar, w wVar, s0.c cVar, int i) {
        super(2);
        this.f5236c = mVar;
        this.f5237f = j0Var;
        this.f5238g = vVar;
        this.f5239h = wVar;
        this.i = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iD = k0.z.D(196609);
        b1.c(this.f5236c, this.f5237f, this.f5238g, this.f5239h, this.i, (k0.s) obj, iD);
        return jb.v.f6774a;
    }
}
