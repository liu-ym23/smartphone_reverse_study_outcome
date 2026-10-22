package G2;

import android.content.Intent;
import f2.C0702g;
import z3.C1347a;

/* loaded from: classes.dex */
public class F extends AbstractC0293a {
    public F(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public F2.z o(F2.z zVar) {
        return (zVar != F2.z.INIT_MINOR_AND_START || k().g().o0()) ? F2.z.MINOR_MODE_ON : F2.z.MINOR_MODE_OFF;
    }

    private void p() {
        v vVarK = k();
        vVarK.i().E(new D3.h() { // from class: G2.E
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1884a.o((F2.z) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new C(vVarK), S1.a.b());
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 != 4) {
            return super.a(dVar, i5, i6, intent);
        }
        if (i6 != -1) {
            dVar.finish();
            return true;
        }
        if (intent == null || !intent.getBooleanExtra("reset", false)) {
            p();
            return true;
        }
        k().q(F2.z.VERIFY_PHONE_TO_RESET_PASSWORD);
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
        C0702g.b("VerifyPasswordToStartState", "onEnter: startConfirm activity = " + dVar);
        I2.b.c(dVar, 4);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 == 9 || i5 == 7) {
            I2.b.c(dVar, 4);
            return true;
        }
        if (i5 != 8) {
            return super.i(dVar, i5);
        }
        k().q(F2.z.VERIFY_PASSWORD_TO_START_HOME);
        return true;
    }
}
