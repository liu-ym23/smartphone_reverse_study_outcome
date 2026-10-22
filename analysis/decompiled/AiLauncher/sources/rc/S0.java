package rc;

/* loaded from: classes5.dex */
public class S0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39163d;

    public S0(AbstractC5276d abstractC5276d) {
        this.f39163d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Y0 y0B = y02.b(y02.n().copy());
        y0B.n().L(true);
        AbstractC5284h abstractC5284hF = this.f39163d.f(y0B);
        y0B.n().L(false);
        return abstractC5284hF;
    }
}
