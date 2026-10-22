package rc;

import org.scilab.forge.jlatexmath.InvalidSymbolTypeException;
import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;
import org.scilab.forge.jlatexmath.SymbolNotFoundException;

/* renamed from: rc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5270a extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final W0 f39194d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39195e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39196f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC5276d f39197g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractC5276d f39198h;

    public C5270a(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2) throws InvalidSymbolTypeException {
        this.f39195e = false;
        this.f39196f = true;
        this.f39198h = null;
        this.f39197g = abstractC5276d;
        if (abstractC5276d instanceof C5270a) {
            this.f39198h = ((C5270a) abstractC5276d).f39198h;
        } else {
            this.f39198h = abstractC5276d;
        }
        if (!(abstractC5276d2 instanceof W0)) {
            throw new InvalidSymbolTypeException("Invalid accent");
        }
        this.f39194d = (W0) abstractC5276d2;
        this.f39195e = true;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        Z0 z0N = y02.n();
        int iM = y02.m();
        AbstractC5276d abstractC5276d = this.f39197g;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02.c());
        float fK = u02.k();
        AbstractC5276d abstractC5276d2 = this.f39198h;
        float fW = abstractC5276d2 instanceof AbstractC5300p ? z0N.w(((AbstractC5300p) abstractC5276d2).i(z0N), iM) : 0.0f;
        C5292l c5292lJ = z0N.j(this.f39194d.q(), iM);
        while (z0N.C(c5292lJ)) {
            C5292l c5292lK = z0N.K(c5292lJ, iM);
            if (c5292lK.i() > fK) {
                break;
            }
            c5292lJ = c5292lK;
        }
        float fMin = -R0.j(5, y02);
        if (!this.f39195e) {
            fMin = Math.min(u02.h(), z0N.t(iM, c5292lJ.e()));
        }
        q1 q1Var = new q1();
        float fG = c5292lJ.g();
        AbstractC5284h c5296n = new C5296n(c5292lJ);
        if (this.f39195e) {
            W0 w02 = this.f39194d;
            if (this.f39196f) {
                y02 = y02.B();
            }
            c5296n = w02.f(y02);
        }
        if (Math.abs(fG) > 1.0E-7f) {
            Q q10 = new Q(new U0(-fG, 0.0f, 0.0f, 0.0f));
            q10.b(c5296n);
            c5296n = q10;
        }
        float fK2 = (fK - c5296n.k()) / 2.0f;
        c5296n.o(fW + (fK2 > 0.0f ? fK2 : 0.0f));
        if (fK2 < 0.0f) {
            u02 = new Q(u02, c5296n.k(), 2);
        }
        q1Var.b(c5296n);
        q1Var.b(new U0(0.0f, this.f39196f ? -fMin : -u02.h(), 0.0f, 0.0f));
        q1Var.b(u02);
        float fH = q1Var.h() + q1Var.g();
        float fG2 = u02.g();
        q1Var.m(fG2);
        q1Var.n(fH - fG2);
        if (fK2 >= 0.0f) {
            return q1Var;
        }
        Q q11 = new Q(new U0(fK2, 0.0f, 0.0f, 0.0f));
        q11.b(q1Var);
        q11.p(fK);
        return q11;
    }

    public C5270a(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, boolean z10) throws InvalidSymbolTypeException {
        this(abstractC5276d, abstractC5276d2);
        this.f39196f = z10;
    }

    public C5270a(AbstractC5276d abstractC5276d, String str) throws SymbolNotFoundException, InvalidSymbolTypeException {
        this.f39195e = false;
        this.f39196f = true;
        this.f39197g = null;
        this.f39198h = null;
        W0 w0P = W0.p(str);
        this.f39194d = w0P;
        if (w0P.f39248a == 10) {
            this.f39197g = abstractC5276d;
            if (abstractC5276d instanceof C5270a) {
                this.f39198h = ((C5270a) abstractC5276d).f39198h;
                return;
            } else {
                this.f39198h = abstractC5276d;
                return;
            }
        }
        throw new InvalidSymbolTypeException("The symbol with the name '" + str + "' is not defined as an accent (type='acc') in 'TeXSymbols.xml'!");
    }
}
