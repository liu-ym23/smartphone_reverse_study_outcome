package G2;

import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.familyguard.R;
import com.stepos.minor.ui.MinorMainActivity;

/* renamed from: G2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0300h extends AbstractC0293a {

    /* renamed from: c, reason: collision with root package name */
    private ComponentCallbacksC0511f f1896c;

    public AbstractC0300h(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    private void o(stepos.support.v7.app.d dVar) {
        if (!(this.f1896c instanceof H2.F) && (dVar instanceof MinorMainActivity)) {
            ((MinorMainActivity) dVar).C0();
        }
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean b() {
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f1896c;
        if (componentCallbacksC0511f == null) {
            return false;
        }
        return componentCallbacksC0511f.j0();
    }

    @Override // G2.AbstractC0293a, G2.u
    public void d(stepos.support.v7.app.d dVar) {
        super.d(dVar);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f1896c;
        if (componentCallbacksC0511f == null || componentCallbacksC0511f.q() != dVar) {
            this.f1896c = n();
        }
        androidx.fragment.app.x supportFragmentManager = dVar.getSupportFragmentManager();
        supportFragmentManager.m().s(R.id.fragment_container, this.f1896c).j();
        try {
            supportFragmentManager.c0();
        } catch (IllegalStateException unused) {
        }
        o(dVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean f() {
        return true;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void g(stepos.support.v7.app.d dVar, u uVar) {
        super.g(dVar, uVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f1896c;
        if (componentCallbacksC0511f == null || componentCallbacksC0511f.q() != dVar) {
            this.f1896c = n();
        }
        androidx.fragment.app.x supportFragmentManager = dVar.getSupportFragmentManager();
        supportFragmentManager.m().s(R.id.fragment_container, this.f1896c).j();
        try {
            supportFragmentManager.c0();
        } catch (IllegalStateException unused) {
        }
        o(dVar);
    }

    protected abstract ComponentCallbacksC0511f n();
}
