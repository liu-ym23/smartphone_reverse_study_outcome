package rc;

/* loaded from: classes5.dex */
public class m1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public static R0 f39359d = new R0(0, 0.7f, 0.0f, 0.0f);

    /* renamed from: e, reason: collision with root package name */
    public static R0 f39360e = new R0(0, 0.06f, 0.0f, 0.0f);

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fN = y02.n().N(y02.m());
        Q q10 = new Q(f39360e.f(y02));
        q10.b(new S(fN, f39359d.f(y02).k(), 0.0f));
        return q10;
    }
}
