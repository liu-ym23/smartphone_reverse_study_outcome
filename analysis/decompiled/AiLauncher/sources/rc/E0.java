package rc;

/* loaded from: classes5.dex */
public class E0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39040d;

    public E0(AbstractC5276d abstractC5276d) {
        this.f39040d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        if (this.f39040d == null) {
            return new U0(0.0f, 0.0f, 0.0f, 0.0f);
        }
        Y0 y0B = y02.b(y02.n().copy());
        y0B.n().a(true);
        return this.f39040d.f(y0B);
    }
}
