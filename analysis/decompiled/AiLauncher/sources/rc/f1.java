package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* loaded from: classes5.dex */
public class f1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39295d;

    public f1(AbstractC5276d abstractC5276d) {
        this.f39295d = abstractC5276d;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        AbstractC5284h abstractC5284hF = W0.p("bigcirc").f(y02);
        abstractC5284hF.o(R0.j(1, y02) * (-0.07f));
        Q q10 = new Q(this.f39295d.f(y02), abstractC5284hF.k(), 2);
        q10.b(new U0(-q10.k(), 0.0f, 0.0f, 0.0f));
        q10.b(abstractC5284hF);
        return q10;
    }
}
