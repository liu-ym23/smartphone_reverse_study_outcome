package rc;

/* loaded from: classes5.dex */
public class Y extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public boolean f39181d;

    public Y(boolean z10) {
        this.f39181d = z10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        C5296n c5296n = new C5296n(y02.n().j("textapos", y02.m()));
        Q q10 = new Q(new C5296n(y02.n().F(this.f39181d ? 'L' : 'l', "mathnormal", y02.m())));
        if (this.f39181d) {
            q10.b(new R0(0, -0.3f, 0.0f, 0.0f).f(y02));
        } else {
            q10.b(new R0(0, -0.13f, 0.0f, 0.0f).f(y02));
        }
        q10.b(c5296n);
        return q10;
    }
}
