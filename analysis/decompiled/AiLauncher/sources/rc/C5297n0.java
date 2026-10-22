package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.n0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5297n0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39365d;

    public C5297n0(AbstractC5276d abstractC5276d) {
        this.f39365d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        AbstractC5284h q10;
        AbstractC5284h abstractC5284hF = this.f39365d.f(y02);
        q1 q1Var = new q1();
        q1Var.b(abstractC5284hF);
        C5292l c5292lJ = y02.n().j("ogonek", y02.m());
        float fG = c5292lJ.g();
        C5296n c5296n = new C5296n(c5292lJ);
        if (Math.abs(fG) > 1.0E-7f) {
            q10 = new Q(new U0(-fG, 0.0f, 0.0f, 0.0f));
            q10.b(c5296n);
        } else {
            q10 = c5296n;
        }
        Q q11 = new Q(q10, abstractC5284hF.k(), 1);
        q1Var.b(new U0(0.0f, -c5296n.h(), 0.0f, 0.0f));
        q1Var.b(q11);
        float fH = q1Var.h() + q1Var.g();
        q1Var.n(abstractC5284hF.h());
        q1Var.m(fH - abstractC5284hF.h());
        return q1Var;
    }
}
