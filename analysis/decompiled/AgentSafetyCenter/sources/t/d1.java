package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12958c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e1 f12959f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(e1 e1Var, int i) {
        super(0);
        this.f12958c = i;
        this.f12959f = e1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f12958c) {
            case 0:
                return Float.valueOf(this.f12959f.f12967s.f12998a.g());
            default:
                return Float.valueOf(this.f12959f.f12967s.f13001d.g());
        }
    }
}
