package rc;

/* renamed from: rc.t0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5308t0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39417d;

    public C5308t0(AbstractC5276d abstractC5276d) {
        this.f39417d = abstractC5276d;
        this.f39248a = 0;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fN = y02.n().N(y02.m());
        AbstractC5276d abstractC5276d = this.f39417d;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02.c());
        C5303q0 c5303q0 = new C5303q0(u02, 3.0f * fN, fN);
        c5303q0.m(u02.g());
        c5303q0.n(u02.h() + (fN * 5.0f));
        return c5303q0;
    }
}
