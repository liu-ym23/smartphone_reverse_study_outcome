package G2;

import android.content.Intent;
import com.stepos.minor.ui.MinorVerifyAddPhoneActivity;
import com.stepos.minor.ui.MinorVerifyResetPhoneActivity;

/* loaded from: classes.dex */
public class I extends AbstractC0293a {

    /* renamed from: c, reason: collision with root package name */
    private boolean f1887c;

    public I(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        v vVarK = k();
        if (i6 != -1) {
            this.f1887c = false;
            vVarK.q(F2.z.MINOR_MODE_ON);
            return false;
        }
        if (i5 == 7) {
            this.f1887c = true;
            MinorVerifyAddPhoneActivity.T0(dVar, 8);
        } else if (i5 == 8) {
            vVarK.q(F2.z.MINOR_MODE_ON);
        }
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.u
    public boolean e() {
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void g(stepos.support.v7.app.d dVar, u uVar) {
        super.g(dVar, uVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        this.f1887c = false;
        MinorVerifyResetPhoneActivity.T0(dVar, 7);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 != 7) {
            if (m(i5)) {
                return true;
            }
            return super.i(dVar, i5);
        }
        String strE = k().e();
        if (this.f1887c) {
            if (strE != null && strE.equals(MinorVerifyAddPhoneActivity.class.getName())) {
                return true;
            }
            MinorVerifyAddPhoneActivity.T0(dVar, 8);
        } else {
            if (strE != null && strE.equals(MinorVerifyResetPhoneActivity.class.getName())) {
                return true;
            }
            MinorVerifyResetPhoneActivity.T0(dVar, 7);
        }
        return true;
    }
}
