package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* loaded from: classes5.dex */
public class p1 extends AbstractC5276d {
    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        AbstractC5284h abstractC5284hF = W0.p("ldotp").f(y02);
        q1 q1Var = new q1(abstractC5284hF, 0.0f, 4);
        AbstractC5284h abstractC5284hF2 = new R0(5, 0.0f, 4.0f, 0.0f).f(y02);
        q1Var.b(abstractC5284hF2);
        q1Var.b(abstractC5284hF);
        q1Var.b(abstractC5284hF2);
        q1Var.b(abstractC5284hF);
        float fG = q1Var.g();
        float fH = q1Var.h();
        q1Var.m(0.0f);
        q1Var.n(fG + fH);
        return q1Var;
    }
}
