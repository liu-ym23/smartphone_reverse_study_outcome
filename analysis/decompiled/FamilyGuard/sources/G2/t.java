package G2;

import H2.ViewOnClickListenerC0321j0;
import android.content.Intent;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.minor.ui.MinorMainActivity;
import z3.C1347a;

/* loaded from: classes.dex */
public class t extends AbstractC0300h {
    public t(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Integer num) {
        k().q(F2.z.MINOR_MODE_OFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer u(Boolean bool) {
        return Integer.valueOf(k().g().F0(bool.booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Integer num) {
        k().q(F2.z.MINOR_MODE_OFF);
    }

    private void w(stepos.support.v7.app.d dVar) {
        if (dVar instanceof MinorMainActivity) {
            ((MinorMainActivity) dVar).y0();
        }
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 != 9 || i6 != -1) {
            return super.a(dVar, i5, i6, intent);
        }
        x3.f.D(Boolean.FALSE).E(new D3.h() { // from class: G2.r
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1904a.u((Boolean) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: G2.s
            @Override // D3.c
            public final void accept(Object obj) {
                this.f1905a.v((Integer) obj);
            }
        }, S1.a.b());
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.AbstractC0300h, G2.AbstractC0293a, G2.u
    public void d(stepos.support.v7.app.d dVar) {
        super.d(dVar);
        w(dVar);
    }

    @Override // G2.AbstractC0300h, G2.AbstractC0293a, G2.u
    public void g(stepos.support.v7.app.d dVar, u uVar) {
        super.g(dVar, uVar);
        if ((uVar instanceof AbstractC0300h) && (dVar instanceof MinorMainActivity)) {
            ((MinorMainActivity) dVar).A0();
        }
    }

    @Override // G2.AbstractC0300h, G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        w(dVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        final v vVarK = k();
        if (i5 == 3) {
            if (vVarK.l()) {
                x3.f.D(Boolean.FALSE).E(new D3.h() { // from class: G2.p
                    @Override // D3.h
                    public final Object apply(Object obj) {
                        return Integer.valueOf(vVarK.g().F0(((Boolean) obj).booleanValue()));
                    }
                }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: G2.q
                    @Override // D3.c
                    public final void accept(Object obj) {
                        this.f1903a.t((Integer) obj);
                    }
                }, S1.a.b());
                vVarK.q(F2.z.MINOR_MODE_OFF);
            } else {
                I2.b.c(dVar, 9);
            }
            return true;
        }
        if (i5 == 5) {
            vVarK.q(F2.z.VERIFY_PASSWORD_TO_RESET_PASSWORD);
            return true;
        }
        if (i5 != 6) {
            return super.i(dVar, i5);
        }
        vVarK.q(F2.z.VERIFY_PHONE_TO_RESET_PHONE);
        return true;
    }

    @Override // G2.AbstractC0300h
    protected ComponentCallbacksC0511f n() {
        return new ViewOnClickListenerC0321j0();
    }
}
