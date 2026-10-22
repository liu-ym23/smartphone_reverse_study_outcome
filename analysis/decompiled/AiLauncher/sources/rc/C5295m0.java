package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.m0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5295m0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39357d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC5276d f39358e;

    public C5295m0(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2) {
        this.f39357d = abstractC5276d == null ? new C5317y() : abstractC5276d;
        this.f39358e = abstractC5276d2 == null ? new C5317y() : abstractC5276d2;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        Z0 z0N = y02.n();
        int iM = y02.m();
        float fN = z0N.N(iM);
        float fAbs = (Math.abs(iM < 2 ? z0N.t(iM, z0N.j("sqrt", iM).e()) : fN) / 4.0f) + fN;
        Q q10 = new Q(this.f39357d.f(y02.c()));
        q10.b(new R0(5, 1.0f, 0.0f, 0.0f).f(y02.c()));
        float fH = q10.h() + q10.g() + fAbs;
        AbstractC5284h abstractC5284hA = C5311v.a("sqrt", y02, fH + fN);
        float fG = fAbs + ((abstractC5284hA.g() - fH) / 2.0f);
        abstractC5284hA.o(-(q10.h() + fG));
        C5303q0 c5303q0 = new C5303q0(q10, fG, abstractC5284hA.h());
        c5303q0.o(-(q10.h() + fG + fN));
        Q q11 = new Q(abstractC5284hA);
        q11.b(c5303q0);
        AbstractC5276d abstractC5276d = this.f39358e;
        if (abstractC5276d == null) {
            return q11;
        }
        AbstractC5284h abstractC5284hF = abstractC5276d.f(y02.s());
        abstractC5284hF.o((q11.g() - abstractC5284hF.g()) - ((q11.h() + q11.g()) * 0.55f));
        AbstractC5284h abstractC5284hF2 = new R0(5, -10.0f, 0.0f, 0.0f).f(y02);
        Q q12 = new Q();
        float fK = abstractC5284hF.k() + abstractC5284hF2.k();
        if (fK < 0.0f) {
            q12.b(new U0(-fK, 0.0f, 0.0f, 0.0f));
        }
        q12.b(abstractC5284hF);
        q12.b(abstractC5284hF2);
        q12.b(q11);
        return q12;
    }
}
