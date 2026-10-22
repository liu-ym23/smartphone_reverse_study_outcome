package rc;

/* loaded from: classes5.dex */
public class g1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public String f39299d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39300e;

    public g1(AbstractC5276d abstractC5276d, String str) {
        this.f39299d = str;
        this.f39300e = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        String strO = y02.o();
        y02.A(this.f39299d);
        AbstractC5284h abstractC5284hF = this.f39300e.f(y02);
        y02.A(strO);
        return abstractC5284hF;
    }
}
