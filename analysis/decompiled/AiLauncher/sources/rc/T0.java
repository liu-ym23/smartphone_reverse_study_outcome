package rc;

/* loaded from: classes5.dex */
public class T0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39165d;

    public T0(AbstractC5276d abstractC5276d) {
        this.f39165d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Z0 z0N = y02.n();
        int iM = y02.m();
        float fK = z0N.k(iM);
        float fN = z0N.N(iM);
        AbstractC5284h abstractC5284hF = this.f39165d.f(y02);
        S s10 = new S(fN, abstractC5284hF.k(), (-fK) + fN, false);
        Q q10 = new Q();
        q10.b(abstractC5284hF);
        q10.b(new U0(-abstractC5284hF.k(), 0.0f, 0.0f, 0.0f));
        q10.b(s10);
        return q10;
    }
}
