package rc;

/* loaded from: classes5.dex */
public class l1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39353d;

    public l1(AbstractC5276d abstractC5276d) {
        this.f39353d = abstractC5276d;
        this.f39248a = 0;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fN = y02.n().N(y02.m());
        AbstractC5276d abstractC5276d = this.f39353d;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02);
        q1 q1Var = new q1();
        q1Var.b(u02);
        q1Var.b(new U0(0.0f, 3.0f * fN, 0.0f, 0.0f));
        q1Var.b(new S(fN, u02.k(), 0.0f));
        q1Var.m(u02.g() + (fN * 5.0f));
        q1Var.n(u02.h());
        return q1Var;
    }
}
