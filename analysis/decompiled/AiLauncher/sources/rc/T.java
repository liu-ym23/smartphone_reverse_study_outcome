package rc;

/* loaded from: classes5.dex */
public class T extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public boolean f39164d;

    public T(boolean z10) {
        this.f39164d = z10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        C5296n c5296n = new C5296n(y02.n().F(this.f39164d ? 'I' : 'i', "mathnormal", y02.m()));
        C5296n c5296n2 = new C5296n(y02.n().F(this.f39164d ? 'J' : 'j', "mathnormal", y02.m()));
        Q q10 = new Q(c5296n);
        q10.b(new R0(0, -0.065f, 0.0f, 0.0f).f(y02));
        q10.b(c5296n2);
        return q10;
    }
}
