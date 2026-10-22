package rc;

/* renamed from: rc.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5282g extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39296d;

    public C5282g(AbstractC5276d abstractC5276d) {
        this.f39296d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        if (this.f39296d == null) {
            return new U0(0.0f, 0.0f, 0.0f, 0.0f);
        }
        Y0 y0B = y02.b(y02.n().copy());
        y0B.n().G(true);
        return this.f39296d.f(y0B);
    }
}
