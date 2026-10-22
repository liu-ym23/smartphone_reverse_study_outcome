package G2;

import H2.K0;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.minor.ui.MinorMainActivity;

/* loaded from: classes.dex */
public class o extends AbstractC0300h {
    public o(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    private void p(stepos.support.v7.app.d dVar) {
        if (dVar instanceof MinorMainActivity) {
            ((MinorMainActivity) dVar).A0();
        }
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 != 1 || i6 != -1) {
            return super.a(dVar, i5, i6, intent);
        }
        k().q(F2.z.MINOR_MODE_ON);
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.AbstractC0300h, G2.AbstractC0293a, G2.u
    public void d(stepos.support.v7.app.d dVar) {
        super.d(dVar);
        p(dVar);
    }

    @Override // G2.AbstractC0300h, G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        p(dVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 != 4) {
            return super.i(dVar, i5);
        }
        k().q(F2.z.MINOR_MODE_ON);
        return true;
    }

    @Override // G2.AbstractC0300h
    protected ComponentCallbacksC0511f n() {
        K0 k02 = new K0();
        Bundle bundle = new Bundle();
        bundle.putInt("select", 2);
        k02.G1(bundle);
        return k02;
    }
}
