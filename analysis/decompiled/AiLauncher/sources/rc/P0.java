package rc;

/* loaded from: classes5.dex */
public class P0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39145d;

    public P0(AbstractC5276d abstractC5276d) {
        this.f39145d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        boolean zK = y02.k();
        y02.y(true);
        AbstractC5284h abstractC5284hF = this.f39145d.f(y02);
        y02.y(zK);
        return abstractC5284hF;
    }
}
