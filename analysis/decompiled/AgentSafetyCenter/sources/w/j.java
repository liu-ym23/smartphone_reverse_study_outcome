package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14986c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w0.c f14987f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(w0.c cVar, int i) {
        super(2);
        this.f14986c = i;
        this.f14987f = cVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f14986c) {
            case 0:
                return Integer.valueOf(this.f14987f.a(0, ((Number) obj).intValue(), (o2.l) obj2));
            default:
                int i = (int) (((o2.k) obj).f9122a >> 32);
                return o2.i.a(td.h.c(this.f14987f.a(0, i, (o2.l) obj2), 0));
        }
    }
}
