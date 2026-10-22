package v0;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10321g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q f10322h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(q qVar, int i2) {
        super(1);
        this.f10321g = i2;
        this.f10322h = qVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f10321g) {
            case 0:
                double dDoubleValue = ((Number) obj).doubleValue();
                return Double.valueOf(this.f10322h.f10334n.b(nb.i.i(dDoubleValue, r8.f10325e, r8.f10326f)));
            default:
                return Double.valueOf(nb.i.i(this.f10322h.f10331k.b(((Number) obj).doubleValue()), r8.f10325e, r8.f10326f));
        }
    }
}
