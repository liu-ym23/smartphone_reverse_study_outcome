package rc;

/* renamed from: rc.d0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5277d0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public int f39251d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39252e;

    public C5277d0(AbstractC5276d abstractC5276d, int i10) {
        this.f39252e = abstractC5276d;
        this.f39251d = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Y0 y0B = y02.b(y02.n().copy());
        y0B.n().a(false);
        int iM = y0B.m();
        y0B.z(this.f39251d);
        AbstractC5284h abstractC5284hF = this.f39252e.f(y0B);
        y0B.z(iM);
        return abstractC5284hF;
    }
}
