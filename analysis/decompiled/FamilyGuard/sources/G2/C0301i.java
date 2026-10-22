package G2;

import androidx.fragment.app.ComponentCallbacksC0511f;

/* renamed from: G2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0301i extends AbstractC0300h {
    public C0301i(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 != 1) {
            return false;
        }
        k().q(F2.z.INIT_PASSWORD);
        return true;
    }

    @Override // G2.AbstractC0300h
    protected ComponentCallbacksC0511f n() {
        return new H2.F();
    }
}
