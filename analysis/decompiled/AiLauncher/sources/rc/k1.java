package rc;

import org.scilab.forge.jlatexmath.InvalidUnitException;

/* loaded from: classes5.dex */
public class k1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39340d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC5276d f39341e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC5276d f39342f;

    /* renamed from: g, reason: collision with root package name */
    public final float f39343g;

    /* renamed from: h, reason: collision with root package name */
    public final float f39344h;

    /* renamed from: i, reason: collision with root package name */
    public final int f39345i;

    /* renamed from: j, reason: collision with root package name */
    public final int f39346j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f39347k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f39348l;

    public k1(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, int i10, float f10, boolean z10, boolean z11) throws InvalidUnitException {
        R0.i(i10);
        this.f39340d = abstractC5276d;
        if (z11) {
            this.f39341e = null;
            this.f39343g = 0.0f;
            this.f39345i = 0;
            this.f39347k = false;
            this.f39342f = abstractC5276d2;
            this.f39346j = i10;
            this.f39344h = f10;
            this.f39348l = z10;
            return;
        }
        this.f39341e = abstractC5276d2;
        this.f39345i = i10;
        this.f39343g = f10;
        this.f39347k = z10;
        this.f39344h = 0.0f;
        this.f39342f = null;
        this.f39346j = 0;
        this.f39348l = false;
    }

    private static AbstractC5284h i(AbstractC5284h abstractC5284h, float f10) {
        return (abstractC5284h == null || Math.abs(f10 - abstractC5284h.k()) <= 1.0E-7f) ? abstractC5284h : new Q(abstractC5284h, f10, 2);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF;
        AbstractC5276d abstractC5276d = this.f39340d;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02);
        float fK = u02.k();
        AbstractC5276d abstractC5276d2 = this.f39342f;
        AbstractC5284h abstractC5284hF2 = null;
        if (abstractC5276d2 != null) {
            abstractC5284hF = abstractC5276d2.f(this.f39348l ? y02.B() : y02);
            fK = Math.max(fK, abstractC5284hF.k());
        } else {
            abstractC5284hF = null;
        }
        AbstractC5276d abstractC5276d3 = this.f39341e;
        if (abstractC5276d3 != null) {
            abstractC5284hF2 = abstractC5276d3.f(this.f39347k ? y02.B() : y02);
            fK = Math.max(fK, abstractC5284hF2.k());
        }
        q1 q1Var = new q1();
        y02.w(u02.i());
        if (this.f39342f != null) {
            q1Var.b(i(abstractC5284hF, fK));
            q1Var.b(new R0(this.f39346j, 0.0f, this.f39344h, 0.0f).f(y02));
        }
        AbstractC5284h abstractC5284hI = i(u02, fK);
        q1Var.b(abstractC5284hI);
        float fH = (q1Var.h() + q1Var.g()) - abstractC5284hI.g();
        if (this.f39341e != null) {
            q1Var.b(new R0(this.f39346j, 0.0f, this.f39343g, 0.0f).f(y02));
            q1Var.b(i(abstractC5284hF2, fK));
        }
        q1Var.m((q1Var.h() + q1Var.g()) - fH);
        q1Var.n(fH);
        return q1Var;
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return this.f39340d.g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return this.f39340d.h();
    }

    public k1(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, int i10, float f10, boolean z10, AbstractC5276d abstractC5276d3, int i11, float f11, boolean z11) throws InvalidUnitException {
        R0.i(i10);
        R0.i(i11);
        this.f39340d = abstractC5276d;
        this.f39341e = abstractC5276d2;
        this.f39345i = i10;
        this.f39343g = f10;
        this.f39347k = z10;
        this.f39342f = abstractC5276d3;
        this.f39346j = i11;
        this.f39344h = f11;
        this.f39348l = z11;
    }
}
