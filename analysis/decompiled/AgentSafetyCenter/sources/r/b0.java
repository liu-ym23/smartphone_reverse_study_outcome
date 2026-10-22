package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10246c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.l f10247f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(xb.l lVar, int i) {
        super(1);
        this.f10246c = i;
        this.f10247f = lVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f10246c) {
            case 0:
                return o2.i.a(td.h.c(((Number) this.f10247f.invoke(Integer.valueOf((int) (((o2.k) obj).f9122a >> 32)))).intValue(), 0));
            case 1:
                return o2.i.a(td.h.c(0, ((Number) this.f10247f.invoke(Integer.valueOf((int) (((o2.k) obj).f9122a & 4294967295L)))).intValue()));
            case 2:
                return o2.i.a(td.h.c(((Number) this.f10247f.invoke(Integer.valueOf((int) (((o2.k) obj).f9122a >> 32)))).intValue(), 0));
            default:
                return o2.i.a(td.h.c(0, ((Number) this.f10247f.invoke(Integer.valueOf((int) (((o2.k) obj).f9122a & 4294967295L)))).intValue()));
        }
    }
}
