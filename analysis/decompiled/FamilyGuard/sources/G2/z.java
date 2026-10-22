package G2;

import android.content.Intent;

/* loaded from: classes.dex */
public class z extends AbstractC0293a {
    public z(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i6 != -1) {
            dVar.finish();
            return false;
        }
        if (i5 != 10) {
            return true;
        }
        k().q(F2.z.INIT_PARENT_PHONE);
        return true;
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
        I2.b.c(dVar, 10);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 != 9 && i5 != 7) {
            return super.i(dVar, i5);
        }
        I2.b.c(dVar, 10);
        return true;
    }
}
