package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12984c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h1 f12985f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(h1 h1Var, int i) {
        super(0);
        this.f12984c = i;
        this.f12985f = h1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f12984c) {
            case 0:
                return Boolean.valueOf(this.f12985f.f12998a.g() > 0);
            default:
                h1 h1Var = this.f12985f;
                return Boolean.valueOf(h1Var.f12998a.g() < h1Var.f13001d.g());
        }
    }
}
