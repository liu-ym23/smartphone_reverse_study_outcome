package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3386a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ double f3387b;

    @Override // e1.i
    public final double b(double d7) {
        switch (this.f3386a) {
            case 0:
                double d10 = this.f3387b;
                if (d7 < 0.0d) {
                    d7 = 0.0d;
                }
                return Math.pow(d7, 1.0d / d10);
            default:
                double d11 = this.f3387b;
                if (d7 < 0.0d) {
                    d7 = 0.0d;
                }
                return Math.pow(d7, d11);
        }
    }
}
