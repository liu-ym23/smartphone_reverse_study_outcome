package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0.m f11306c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.p f11307f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11308g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f11309h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(w0.m mVar, xb.p pVar, int i, int i3) {
        super(2);
        this.f11306c = mVar;
        this.f11307f = pVar;
        this.f11308g = i;
        this.f11309h = i3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iD = k0.z.D(this.f11308g | 1);
        int i = this.f11309h;
        v0.c(this.f11306c, this.f11307f, (k0.s) obj, iD, i);
        return jb.v.f6774a;
    }
}
