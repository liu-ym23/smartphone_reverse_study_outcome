package rc;

/* renamed from: rc.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5313w extends A {
    public C5313w(AbstractC5276d abstractC5276d) {
        super(abstractC5276d);
    }

    @Override // rc.A, rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39012e.f(y02);
        float fN = y02.n().N(y02.m());
        float fJ = this.f39011d * R0.j(0, y02);
        float f10 = 1.5f * fN;
        return new H(new H(abstractC5284hF, fN * 0.75f, fJ), f10, (R0.j(3, y02) * 0.5f) + f10);
    }
}
