package rc;

import org.scilab.forge.jlatexmath.InvalidUnitException;
import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.s0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5306s0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC5276d f39393d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39394e;

    /* renamed from: f, reason: collision with root package name */
    public final W0 f39395f;

    /* renamed from: g, reason: collision with root package name */
    public final R0 f39396g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f39397h;

    public C5306s0(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, W0 w02, int i10, float f10, boolean z10) throws InvalidUnitException {
        this.f39248a = 7;
        this.f39393d = abstractC5276d;
        this.f39394e = abstractC5276d2;
        this.f39395f = w02;
        this.f39396g = new R0(i10, 0.0f, f10, 0.0f);
        this.f39397h = z10;
    }

    public static float j(AbstractC5284h abstractC5284h, AbstractC5284h abstractC5284h2, AbstractC5284h abstractC5284h3) {
        float fMax = Math.max(abstractC5284h.k(), abstractC5284h2.h() + abstractC5284h2.g());
        return abstractC5284h3 != null ? Math.max(fMax, abstractC5284h3.k()) : fMax;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        AbstractC5284h abstractC5284hF;
        AbstractC5276d abstractC5276d = this.f39393d;
        AbstractC5284h u02 = abstractC5276d == null ? new U0(0.0f, 0.0f, 0.0f, 0.0f) : abstractC5276d.f(y02);
        AbstractC5284h abstractC5284hA = C5311v.a(this.f39395f.q(), y02, u02.k());
        AbstractC5276d abstractC5276d2 = this.f39394e;
        if (abstractC5276d2 != null) {
            abstractC5284hF = abstractC5276d2.f(this.f39397h ? y02.C() : y02.B());
        } else {
            abstractC5284hF = null;
        }
        float fJ = j(u02, abstractC5284hA, abstractC5284hF);
        return new C5304r0(fJ - u02.k() > 1.0E-7f ? new Q(u02, fJ, 2) : u02, new q1(abstractC5284hA, fJ, 2), (abstractC5284hF == null || fJ - abstractC5284hF.k() <= 1.0E-7f) ? abstractC5284hF : new Q(abstractC5284hF, fJ, 2), this.f39396g.f(y02).h(), this.f39397h);
    }

    public void i(AbstractC5276d abstractC5276d) {
        this.f39394e = abstractC5276d;
    }

    public boolean k() {
        return this.f39397h;
    }
}
