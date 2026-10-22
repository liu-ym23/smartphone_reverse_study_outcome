package G2;

import android.content.Intent;
import com.stepos.minor.ui.MinorVerifyResetPasswordActivity;
import z3.C1347a;

/* loaded from: classes.dex */
public class H extends AbstractC0293a {

    /* renamed from: c, reason: collision with root package name */
    private boolean f1886c;

    public H(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public F2.z o(F2.z zVar) {
        return (zVar != F2.z.INIT_MINOR_AND_START || k().g().o0()) ? F2.z.MINOR_MODE_ON : F2.z.MINOR_MODE_OFF;
    }

    private void p() {
        v vVarK = k();
        vVarK.i().E(new D3.h() { // from class: G2.G
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1885a.o((F2.z) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new C(vVarK), S1.a.b());
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        if (i5 == 11) {
            if (i6 == -1) {
                this.f1886c = true;
                I2.b.d(dVar, 6);
            } else {
                dVar.finish();
            }
            return true;
        }
        if (i5 != 6) {
            return super.a(dVar, i5, i6, intent);
        }
        if (i6 == -1) {
            this.f1886c = false;
            p();
        } else {
            this.f1886c = false;
            dVar.finish();
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
        this.f1886c = false;
        MinorVerifyResetPasswordActivity.T0(dVar, 11);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        if (i5 != 7) {
            return super.i(dVar, i5);
        }
        String strE = k().e();
        if (!this.f1886c && strE != null && strE.equals(MinorVerifyResetPasswordActivity.class.getName())) {
            return true;
        }
        if (this.f1886c) {
            I2.b.d(dVar, 6);
        } else {
            MinorVerifyResetPasswordActivity.T0(dVar, 11);
        }
        return true;
    }
}
