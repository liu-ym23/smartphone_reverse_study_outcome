package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11000c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f11001f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f11002g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f11003h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Number number, c0 c0Var, Number number2, b0 b0Var) {
        super(0);
        this.f11001f = number;
        this.f11003h = c0Var;
        this.f11002g = number2;
        this.i = b0Var;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f11000c) {
            case 0:
                Number number = (Number) this.f11002g;
                Number number2 = (Number) this.f11001f;
                c0 c0Var = (c0) this.f11003h;
                if (!number2.equals(c0Var.f10966c) || !number.equals(c0Var.f10967f)) {
                    b0 b0Var = (b0) this.i;
                    c0Var.f10966c = number2;
                    c0Var.f10967f = number;
                    c0Var.i = new w0(b0Var, c0Var.f10968g, number2, number, null);
                    c0Var.f10973m.f10986b.setValue(Boolean.TRUE);
                    c0Var.f10970j = false;
                    c0Var.f10971k = true;
                }
                break;
            default:
                ((s2.m) this.f11001f).e((xb.a) this.f11002g, (s2.k) this.f11003h, (o2.l) this.i);
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(s2.m mVar, xb.a aVar, s2.k kVar, o2.l lVar) {
        super(0);
        this.f11001f = mVar;
        this.f11002g = aVar;
        this.f11003h = kVar;
        this.i = lVar;
    }
}
