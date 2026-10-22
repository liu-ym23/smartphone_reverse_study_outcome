package rc;

/* loaded from: classes5.dex */
public class r1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public float f39390d;

    /* renamed from: e, reason: collision with root package name */
    public float f39391e;

    /* renamed from: f, reason: collision with root package name */
    public int f39392f;

    public r1(int i10) {
        this.f39392f = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        int i10;
        if (this.f39392f == 0) {
            return new U0(0.0f, 0.0f, 0.0f, 0.0f);
        }
        float fN = y02.n().N(y02.m());
        S s10 = new S(this.f39390d, fN, this.f39391e);
        U0 u02 = new U0(fN * 2.0f, 0.0f, 0.0f, 0.0f);
        Q q10 = new Q();
        int i11 = 0;
        while (true) {
            i10 = this.f39392f;
            if (i11 >= i10 - 1) {
                break;
            }
            q10.b(s10);
            q10.b(u02);
            i11++;
        }
        if (i10 > 0) {
            q10.b(s10);
        }
        return q10;
    }

    public float i(Y0 y02) {
        if (this.f39392f != 0) {
            return y02.n().N(y02.m()) * ((this.f39392f * 3) - 2);
        }
        return 0.0f;
    }

    public void j(float f10) {
        this.f39390d = f10;
    }

    public void k(float f10) {
        this.f39391e = f10;
    }
}
