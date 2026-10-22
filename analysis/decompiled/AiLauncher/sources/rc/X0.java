package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* loaded from: classes5.dex */
public class X0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public boolean f39180d;

    public X0(boolean z10) {
        this.f39180d = z10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        C5292l c5292lJ = y02.n().j("bar", y02.m());
        float fG = c5292lJ.g();
        C5296n c5296n = new C5296n(y02.n().F(this.f39180d ? 'T' : 't', "mathnormal", y02.m()));
        AbstractC5284h c5296n2 = new C5296n(c5292lJ);
        if (Math.abs(fG) > 1.0E-7f) {
            AbstractC5284h q10 = new Q(new U0(-fG, 0.0f, 0.0f, 0.0f));
            q10.b(c5296n2);
            c5296n2 = q10;
        }
        Q q11 = new Q(c5296n2, c5296n.k(), 2);
        q1 q1Var = new q1();
        q1Var.b(c5296n);
        q1Var.b(new U0(0.0f, c5296n.h() * (-0.5f), 0.0f, 0.0f));
        q1Var.b(q11);
        return q1Var;
    }
}
