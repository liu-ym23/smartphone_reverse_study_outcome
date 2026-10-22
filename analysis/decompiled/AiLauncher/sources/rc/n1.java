package rc;

/* loaded from: classes5.dex */
public class n1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39366d;

    public n1(AbstractC5276d abstractC5276d) {
        this.f39366d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39366d.f(y02);
        abstractC5284hF.o((-((abstractC5284hF.h() + abstractC5284hF.g()) / 2.0f)) - y02.n().k(y02.m()));
        return new Q(abstractC5284hF);
    }
}
