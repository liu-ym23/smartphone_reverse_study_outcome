package rc;

/* loaded from: classes5.dex */
public class D0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39033d;

    /* renamed from: e, reason: collision with root package name */
    public int f39034e;

    /* renamed from: f, reason: collision with root package name */
    public int f39035f;

    /* renamed from: g, reason: collision with root package name */
    public float f39036g;

    /* renamed from: h, reason: collision with root package name */
    public float f39037h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39038i;

    public D0(AbstractC5276d abstractC5276d, String str, String str2, boolean z10) {
        this.f39248a = abstractC5276d.f39248a;
        this.f39033d = abstractC5276d;
        this.f39038i = z10;
        float[] fArrK = R0.k(str == null ? "" : str);
        float[] fArrK2 = R0.k(str2 == null ? "" : str2);
        if (fArrK.length != 2) {
            this.f39034e = -1;
        } else {
            this.f39034e = (int) fArrK[0];
            this.f39036g = fArrK[1];
        }
        if (fArrK2.length != 2) {
            this.f39035f = -1;
        } else {
            this.f39035f = (int) fArrK2[0];
            this.f39037h = fArrK2[1];
        }
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        double dMin;
        double d10;
        double d11;
        AbstractC5284h abstractC5284hF = this.f39033d.f(y02);
        int i10 = this.f39034e;
        if (i10 == -1 && this.f39035f == -1) {
            return abstractC5284hF;
        }
        if (i10 == -1 || this.f39035f == -1) {
            dMin = (i10 == -1 || this.f39035f != -1) ? (this.f39037h * R0.j(this.f39035f, y02)) / abstractC5284hF.f39306e : (this.f39036g * R0.j(i10, y02)) / abstractC5284hF.f39305d;
        } else {
            double dJ = (this.f39036g * R0.j(i10, y02)) / abstractC5284hF.f39305d;
            double dJ2 = (this.f39037h * R0.j(this.f39035f, y02)) / abstractC5284hF.f39306e;
            if (!this.f39038i) {
                d10 = dJ2;
                d11 = dJ;
                return new L0(abstractC5284hF, d11, d10);
            }
            dMin = Math.min(dJ, dJ2);
        }
        d11 = dMin;
        d10 = d11;
        return new L0(abstractC5284hF, d11, d10);
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39033d.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39033d.h();
    }
}
