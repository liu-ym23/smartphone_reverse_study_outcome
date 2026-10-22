package G2;

import H2.C0349z;
import android.os.Bundle;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.minor.ui.MinorMainActivity;

/* loaded from: classes.dex */
public class j extends AbstractC0300h {
    public j(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    private void p(stepos.support.v7.app.d dVar) {
        if (dVar instanceof MinorMainActivity) {
            ((MinorMainActivity) dVar).z0();
        }
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
        if (i5 != 2) {
            return super.i(dVar, i5);
        }
        k().q(F2.z.MINOR_MODE_ON);
        return true;
    }

    @Override // G2.AbstractC0300h
    protected ComponentCallbacksC0511f n() {
        C0349z c0349z = new C0349z();
        Bundle bundle = new Bundle();
        bundle.putInt("edit_minor_action", 0);
        c0349z.G1(bundle);
        return c0349z;
    }
}
