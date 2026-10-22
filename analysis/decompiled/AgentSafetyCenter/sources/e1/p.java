package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3390c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f3391f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(q qVar, int i) {
        super(1);
        this.f3390c = i;
        this.f3391f = qVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f3390c) {
            case 0:
                double dDoubleValue = ((Number) obj).doubleValue();
                return Double.valueOf(this.f3391f.f3402n.b(p5.f.o(dDoubleValue, r8.f3394e, r8.f3395f)));
            default:
                return Double.valueOf(p5.f.o(this.f3391f.f3399k.b(((Number) obj).doubleValue()), r8.f3394e, r8.f3395f));
        }
    }
}
