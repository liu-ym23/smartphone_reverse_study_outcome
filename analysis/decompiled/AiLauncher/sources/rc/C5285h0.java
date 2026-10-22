package rc;

/* renamed from: rc.h0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5285h0 extends K0 {

    /* renamed from: g, reason: collision with root package name */
    public float f39314g;

    /* JADX WARN: Illegal instructions before constructor call */
    public C5285h0(AbstractC5276d abstractC5276d, float f10) {
        double d10 = f10;
        super(abstractC5276d, d10, d10);
        this.f39314g = f10;
    }

    @Override // rc.K0, rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        Y0 y0A = y02.a();
        float fI = y0A.i();
        y0A.x(this.f39314g);
        return new L0(this.f39119d.f(y0A), this.f39314g / fI);
    }
}
