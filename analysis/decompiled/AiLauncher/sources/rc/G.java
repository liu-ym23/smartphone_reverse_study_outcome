package rc;

import org.scilab.forge.jlatexmath.InvalidUnitException;

/* loaded from: classes5.dex */
public class G extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public boolean f39077d;

    /* renamed from: e, reason: collision with root package name */
    public int f39078e;

    /* renamed from: f, reason: collision with root package name */
    public int f39079f;

    /* renamed from: g, reason: collision with root package name */
    public int f39080g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractC5276d f39081h;

    /* renamed from: i, reason: collision with root package name */
    public AbstractC5276d f39082i;

    /* renamed from: j, reason: collision with root package name */
    public float f39083j;

    /* renamed from: k, reason: collision with root package name */
    public float f39084k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39085l;

    public G(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, boolean z10) {
        this(abstractC5276d, abstractC5276d2, !z10, 2, 0.0f);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fN;
        float fS;
        Z0 z0N = y02.n();
        int iM = y02.m();
        float fN2 = z0N.N(iM);
        if (this.f39077d) {
            this.f39083j *= R0.j(this.f39078e, y02);
        } else {
            this.f39083j = this.f39085l ? this.f39084k * fN2 : fN2;
        }
        AbstractC5276d abstractC5276d = this.f39081h;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02.q());
        AbstractC5276d abstractC5276d2 = this.f39082i;
        AbstractC5284h u03 = abstractC5276d2 == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d2.f(y02.d());
        if (u02.k() < u03.k()) {
            u02 = new Q(u02, u03.k(), this.f39079f);
        } else {
            u03 = new Q(u03, u02.k(), this.f39080g);
        }
        if (iM < 2) {
            fS = z0N.A(iM);
            fN = z0N.i(iM);
        } else {
            fN = z0N.n(iM);
            fS = this.f39083j > 0.0f ? z0N.s(iM) : z0N.v(iM);
        }
        q1 q1Var = new q1();
        q1Var.b(u02);
        float fK = z0N.k(iM);
        float f10 = this.f39083j;
        if (f10 > 0.0f) {
            float f11 = iM < 2 ? 3.0f * f10 : f10;
            float f12 = f10 / 2.0f;
            float fG = (fS - u02.g()) - (fK + f12);
            float fH = (fK - f12) - (u03.h() - fN);
            float f13 = f11 - fG;
            float f14 = f11 - fH;
            if (f13 > 0.0f) {
                fS += f13;
                fG += f13;
            }
            if (f14 > 0.0f) {
                fN += f14;
                fH += f14;
            }
            q1Var.b(new U0(0.0f, fG, 0.0f, 0.0f));
            q1Var.b(new S(this.f39083j, u02.k(), 0.0f));
            q1Var.b(new U0(0.0f, fH, 0.0f, 0.0f));
        } else {
            float f15 = iM < 2 ? fN2 * 7.0f : fN2 * 3.0f;
            float fG2 = (fS - u02.g()) - (u03.h() - fN);
            float f16 = (f15 - fG2) / 2.0f;
            if (f16 > 0.0f) {
                fS += f16;
                fN += f16;
                fG2 += f16 * 2.0f;
            }
            q1Var.b(new U0(0.0f, fG2, 0.0f, 0.0f));
        }
        q1Var.b(u03);
        q1Var.n(fS + u02.h());
        q1Var.m(fN + u03.g());
        return new Q(q1Var, q1Var.k() + (new R0(0, 0.12f, 0.0f, 0.0f).f(y02).k() * 2.0f), 2);
    }

    public final int i(int i10) {
        if (i10 == 0 || i10 == 1) {
            return i10;
        }
        return 2;
    }

    public G(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, boolean z10, int i10, float f10) throws InvalidUnitException {
        this.f39077d = false;
        this.f39079f = 2;
        this.f39080g = 2;
        this.f39085l = false;
        R0.i(i10);
        this.f39081h = abstractC5276d;
        this.f39082i = abstractC5276d2;
        this.f39077d = z10;
        this.f39083j = f10;
        this.f39078e = i10;
        this.f39248a = 7;
    }

    public G(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, boolean z10, int i10, int i11) {
        this(abstractC5276d, abstractC5276d2, z10);
        this.f39079f = i(i10);
        this.f39080g = i(i11);
    }

    public G(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, int i10, float f10) {
        this(abstractC5276d, abstractC5276d2, true, i10, f10);
    }
}
