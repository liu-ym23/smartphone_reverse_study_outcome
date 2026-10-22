package v0;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10315a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f10316b;

    public /* synthetic */ m(q qVar, int i2) {
        this.f10315a = i2;
        this.f10316b = qVar;
    }

    @Override // v0.i
    public final double b(double d6) {
        switch (this.f10315a) {
            case 0:
                return nb.i.i(this.f10316b.f10331k.b(d6), r8.f10325e, r8.f10326f);
            default:
                return this.f10316b.f10334n.b(nb.i.i(d6, r8.f10325e, r8.f10326f));
        }
    }
}
