package rc;

import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;

/* renamed from: rc.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5278e extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public W0 f39268d;

    /* renamed from: e, reason: collision with root package name */
    public int f39269e;

    public C5278e(W0 w02, int i10) {
        this.f39268d = w02;
        this.f39269e = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        AbstractC5284h abstractC5284hB = C5311v.b(this.f39268d, y02, this.f39269e);
        Q q10 = new Q();
        float fH = abstractC5284hB.h();
        abstractC5284hB.o((((-(abstractC5284hB.g() + fH)) / 2.0f) + fH) - y02.n().k(y02.m()));
        q10.b(abstractC5284hB);
        return q10;
    }
}
