package rc;

/* loaded from: classes5.dex */
public class O extends C5287i0 {

    /* renamed from: m, reason: collision with root package name */
    public static final AbstractC5276d f39139m = W0.p("ldotp");

    /* renamed from: n, reason: collision with root package name */
    public static final AbstractC5276d f39140n = new R0(1);

    /* renamed from: l, reason: collision with root package name */
    public float f39141l;

    public O(int i10, float f10) {
        super(i10, "c", f39139m);
        this.f39141l = f10;
    }

    @Override // rc.C5287i0, rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        U0 u02 = new U0(this.f39141l * f39140n.f(y02).k(), 0.0f, 0.0f, 0.0f);
        Q q10 = new Q(u02);
        q10.b(f39139m.f(y02));
        q10.b(u02);
        if (this.f39320f != 0.0f) {
            q10.k();
            Q q11 = new Q(q10);
            while (q11.k() < this.f39320f) {
                q11.b(q10);
            }
            q10 = new Q(q11, this.f39320f, 2);
        }
        q10.f39309h = 12;
        return q10;
    }
}
