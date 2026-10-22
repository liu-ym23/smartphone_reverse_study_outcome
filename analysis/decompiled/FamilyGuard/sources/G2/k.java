package G2;

import android.content.Intent;
import com.stepos.minor.ui.MinorVerifyAddPhoneActivity;
import f2.C0702g;

/* loaded from: classes.dex */
public class k extends AbstractC0293a {
    public k(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 == 3) {
            if (i6 == -1) {
                k().q(F2.z.INIT_MINOR_AND_START);
            } else if (dVar.isChangingConfigurations()) {
                C0702g.b("InitParentPhoneState", "ignore add-phone cancel during config change");
            } else {
                dVar.finish();
            }
        }
        return super.a(dVar, i5, i6, intent);
    }

    @Override // G2.u
    public boolean e() {
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        C0702g.b("InitParentPhoneState", "onEnter() called with: activity = [" + dVar + "], from = [" + uVar + "]");
        MinorVerifyAddPhoneActivity.T0(dVar, 3);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 == 9) {
            C0702g.b("InitParentPhoneState", "ignore NEW_INTENT, wait for add-phone result");
            return true;
        }
        if (i5 != 7) {
            return super.i(dVar, i5);
        }
        String strE = k().e();
        if (strE == null) {
            MinorVerifyAddPhoneActivity.T0(dVar, 3);
            return true;
        }
        C0702g.b("InitParentPhoneState", "ignore TASK_MOVE_TO_FRONT, child still " + strE);
        return true;
    }
}
