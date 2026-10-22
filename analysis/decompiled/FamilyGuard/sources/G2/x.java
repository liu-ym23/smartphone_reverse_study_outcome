package G2;

import android.content.Intent;

/* loaded from: classes.dex */
public class x extends AbstractC0293a {
    public x(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 == 2) {
            if (i6 == -1) {
                k().q(F2.z.INIT_PARENT_PHONE);
            } else {
                dVar.finish();
            }
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
        I2.b.d(dVar, 2);
    }
}
