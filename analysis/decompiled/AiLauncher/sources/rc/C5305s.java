package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5305s extends AbstractC5276d {
    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        float fK = a1.k("ldots").f39212d.f(y02).k();
        AbstractC5284h abstractC5284hF = W0.p("ldotp").f(y02);
        Q q10 = new Q(abstractC5284hF, fK, 0);
        Q q11 = new Q(abstractC5284hF, fK, 2);
        Q q12 = new Q(abstractC5284hF, fK, 1);
        AbstractC5284h abstractC5284hF2 = new R0(5, 0.0f, 4.0f, 0.0f).f(y02);
        q1 q1Var = new q1();
        q1Var.b(q10);
        q1Var.b(abstractC5284hF2);
        q1Var.b(q11);
        q1Var.b(abstractC5284hF2);
        q1Var.b(q12);
        q1Var.n(q1Var.h() + q1Var.g());
        q1Var.m(0.0f);
        return q1Var;
    }
}
