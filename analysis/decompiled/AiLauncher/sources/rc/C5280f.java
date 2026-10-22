package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5280f extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39285d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39286e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC5276d f39287f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39288g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39289h = false;

    public C5280f(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, AbstractC5276d abstractC5276d3) {
        this.f39287f = abstractC5276d;
        this.f39285d = abstractC5276d2;
        this.f39286e = abstractC5276d3;
        this.f39248a = 1;
    }

    public static AbstractC5284h i(AbstractC5284h abstractC5284h, float f10) {
        return (abstractC5284h == null || Math.abs(f10 - abstractC5284h.k()) <= 1.0E-7f) ? abstractC5284h : new Q(abstractC5284h, f10, 2);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        I0 i02;
        AbstractC5276d abstractC5276d;
        int i10;
        AbstractC5284h q10;
        float fG;
        float fMax;
        Z0 z0N = y02.n();
        int iM = y02.m();
        AbstractC5276d abstractC5276d2 = this.f39287f;
        if (abstractC5276d2 instanceof i1) {
            AbstractC5276d abstractC5276dI = ((i1) abstractC5276d2).i();
            if (abstractC5276dI instanceof I0) {
                i02 = (I0) abstractC5276dI;
                if (i02.f39102e && this.f39287f.f39249b != 2) {
                    this.f39287f = i02.k();
                }
            }
            this.f39287f = abstractC5276dI;
            i02 = null;
        } else {
            i02 = null;
        }
        boolean z10 = this.f39288g;
        if ((z10 && !this.f39289h) || ((!z10 && iM >= 2) || (i10 = (abstractC5276d = this.f39287f).f39249b) == 1 || (i10 == 0 && iM >= 2))) {
            if (i02 == null) {
                return new M0(this.f39287f, this.f39285d, this.f39286e).f(y02);
            }
            i02.i(new M0(this.f39287f, this.f39285d, this.f39286e));
            AbstractC5284h abstractC5284hF = i02.f(y02);
            i02.k();
            i02.i(this.f39287f);
            this.f39287f = abstractC5276d2;
            return abstractC5284hF;
        }
        if ((abstractC5276d instanceof W0) && abstractC5276d.f39248a == 1) {
            C5292l c5292lJ = z0N.j(((W0) abstractC5276d).q(), iM);
            q10 = this.f39287f.f(y02);
            fG = c5292lJ.g();
        } else {
            AbstractC5276d abstractC5276d3 = this.f39287f;
            q10 = new Q(abstractC5276d3 == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d3.f(y02));
            fG = 0.0f;
        }
        AbstractC5276d abstractC5276d4 = this.f39286e;
        AbstractC5284h abstractC5284hF2 = abstractC5276d4 != null ? abstractC5276d4.f(y02.C()) : null;
        AbstractC5276d abstractC5276d5 = this.f39285d;
        AbstractC5284h abstractC5284hF3 = abstractC5276d5 != null ? abstractC5276d5.f(y02.B()) : null;
        float fMax2 = Math.max(Math.max(abstractC5284hF2 == null ? 0.0f : abstractC5284hF2.k(), q10.k()), abstractC5284hF3 == null ? 0.0f : abstractC5284hF3.k());
        AbstractC5284h abstractC5284hI = i(abstractC5284hF2, fMax2);
        AbstractC5284h abstractC5284hI2 = i(q10, fMax2);
        AbstractC5284h abstractC5284hI3 = i(abstractC5284hF3, fMax2);
        q1 q1Var = new q1();
        float fD = z0N.D(iM);
        if (this.f39286e != null) {
            q1Var.b(new U0(0.0f, fD, 0.0f, 0.0f));
            abstractC5284hI.o(fG / 2.0f);
            q1Var.b(abstractC5284hI);
            fMax = Math.max(z0N.P(iM), z0N.B(iM) - abstractC5284hI.g());
            q1Var.b(new U0(0.0f, fMax, 0.0f, 0.0f));
            q1Var.h();
            q1Var.g();
        } else {
            fMax = 0.0f;
        }
        q1Var.b(abstractC5284hI2);
        if (this.f39285d != null) {
            q1Var.b(new U0(0.0f, Math.max(z0N.x(iM), z0N.y(iM) - abstractC5284hI3.h()), 0.0f, 0.0f));
            abstractC5284hI3.o((-fG) / 2.0f);
            q1Var.b(abstractC5284hI3);
            q1Var.b(new U0(0.0f, fD, 0.0f, 0.0f));
        }
        float fH = abstractC5284hI2.h();
        float fH2 = q1Var.h() + q1Var.g();
        if (abstractC5284hI != null) {
            fH += fD + fMax + abstractC5284hI.h() + abstractC5284hI.g();
        }
        q1Var.n(fH);
        q1Var.m(fH2 - fH);
        if (i02 == null) {
            return q1Var;
        }
        Q q11 = new Q(i02.f(y02));
        i02.i(this.f39287f);
        q11.b(q1Var);
        this.f39287f = abstractC5276d2;
        return q11;
    }
}
