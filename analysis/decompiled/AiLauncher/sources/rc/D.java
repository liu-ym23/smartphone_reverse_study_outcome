package rc;

import java.util.List;
import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* loaded from: classes5.dex */
public class D extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39029d;

    /* renamed from: e, reason: collision with root package name */
    public W0 f39030e;

    /* renamed from: f, reason: collision with root package name */
    public W0 f39031f;

    /* renamed from: g, reason: collision with root package name */
    public final List<C5283g0> f39032g;

    public D(AbstractC5276d abstractC5276d, W0 w02, W0 w03) {
        this(abstractC5276d, w02, null, w03);
    }

    public static void i(AbstractC5284h abstractC5284h, float f10) {
        float fH = abstractC5284h.h();
        abstractC5284h.o((-(((abstractC5284h.g() + fH) / 2.0f) - fH)) - f10);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        Z0 z0N = y02.n();
        AbstractC5284h abstractC5284hF = this.f39029d.f(y02);
        float fJ = R0.j(3, y02) * 5.0f;
        float fK = z0N.k(y02.m());
        float fMax = Math.max(abstractC5284hF.h() - fK, abstractC5284hF.g() + fK);
        float fMax2 = Math.max((fMax / 500.0f) * 901.0f, (fMax * 2.0f) - fJ);
        Q q10 = new Q();
        if (this.f39032g != null) {
            for (int i10 = 0; i10 < this.f39032g.size(); i10++) {
                C5283g0 c5283g0 = this.f39032g.get(i10);
                AbstractC5276d abstractC5276d = c5283g0.f39297d;
                if (abstractC5276d instanceof W0) {
                    AbstractC5284h abstractC5284hA = C5311v.a(((W0) abstractC5276d).q(), y02, fMax2);
                    i(abstractC5284hA, fK);
                    c5283g0.f39298e = abstractC5284hA;
                }
            }
            if (this.f39032g.size() != 0) {
                abstractC5284hF = this.f39029d.f(y02);
            }
        }
        W0 w02 = this.f39030e;
        if (w02 != null) {
            AbstractC5284h abstractC5284hA2 = C5311v.a(w02.q(), y02, fMax2);
            i(abstractC5284hA2, fK);
            q10.b(abstractC5284hA2);
        }
        AbstractC5276d abstractC5276d2 = this.f39029d;
        if (!(abstractC5276d2 instanceof R0)) {
            q10.b(K.b(4, abstractC5276d2.g(), y02));
        }
        q10.b(abstractC5284hF);
        AbstractC5276d abstractC5276d3 = this.f39029d;
        if (!(abstractC5276d3 instanceof R0)) {
            q10.b(K.b(abstractC5276d3.h(), 5, y02));
        }
        W0 w03 = this.f39031f;
        if (w03 != null) {
            AbstractC5284h abstractC5284hA3 = C5311v.a(w03.q(), y02, fMax2);
            i(abstractC5284hA3, fK);
            q10.b(abstractC5284hA3);
        }
        return q10;
    }

    @Override // rc.AbstractC5276d
    public int g() {
        return 7;
    }

    @Override // rc.AbstractC5276d
    public int h() {
        return 7;
    }

    public D(AbstractC5276d abstractC5276d, W0 w02, List<C5283g0> list, W0 w03) {
        this.f39030e = null;
        this.f39031f = null;
        if (abstractC5276d == null) {
            this.f39029d = new I0();
        } else {
            this.f39029d = abstractC5276d;
        }
        if (w02 == null || !w02.q().equals("normaldot")) {
            this.f39030e = w02;
        }
        if (w03 == null || !w03.q().equals("normaldot")) {
            this.f39031f = w03;
        }
        this.f39032g = list;
    }
}
