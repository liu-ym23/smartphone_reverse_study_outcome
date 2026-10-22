package G2;

import android.content.Intent;

/* loaded from: classes.dex */
public class A extends AbstractC0293a {
    public A(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        v vVarK = k();
        if (i6 != -1) {
            vVarK.q(F2.z.MINOR_MODE_ON);
        } else if (i5 == 5) {
            I2.b.d(dVar, 6);
        } else if (i5 == 6) {
            k().q(F2.z.MINOR_MODE_ON);
        }
        return super.a(dVar, i5, i6, intent);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void g(stepos.support.v7.app.d dVar, u uVar) {
        super.g(dVar, uVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        I2.b.c(dVar, 5);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (m(i5)) {
            return true;
        }
        return super.i(dVar, i5);
    }
}
