package Q0;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.ActivityC0516k;
import androidx.fragment.app.ComponentCallbacksC0511f;
import java.util.HashSet;
import java.util.Set;
import v0.ComponentCallbacks2C1180c;

/* loaded from: classes.dex */
public class o extends ComponentCallbacksC0511f {

    /* renamed from: f0, reason: collision with root package name */
    private final Q0.a f4895f0;

    /* renamed from: g0, reason: collision with root package name */
    private final m f4896g0;

    /* renamed from: h0, reason: collision with root package name */
    private final Set<o> f4897h0;

    /* renamed from: i0, reason: collision with root package name */
    private o f4898i0;

    /* renamed from: j0, reason: collision with root package name */
    private v0.j f4899j0;

    /* renamed from: k0, reason: collision with root package name */
    private ComponentCallbacksC0511f f4900k0;

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new Q0.a());
    }

    private void U1(o oVar) {
        this.f4897h0.add(oVar);
    }

    private ComponentCallbacksC0511f W1() {
        ComponentCallbacksC0511f componentCallbacksC0511fJ = J();
        return componentCallbacksC0511fJ != null ? componentCallbacksC0511fJ : this.f4900k0;
    }

    private void Z1(ActivityC0516k activityC0516k) {
        d2();
        o oVarI = ComponentCallbacks2C1180c.c(activityC0516k).k().i(activityC0516k);
        this.f4898i0 = oVarI;
        if (equals(oVarI)) {
            return;
        }
        this.f4898i0.U1(this);
    }

    private void a2(o oVar) {
        this.f4897h0.remove(oVar);
    }

    private void d2() {
        o oVar = this.f4898i0;
        if (oVar != null) {
            oVar.a2(this);
            this.f4898i0 = null;
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        this.f4895f0.c();
        d2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void D0() {
        super.D0();
        this.f4900k0 = null;
        d2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        this.f4895f0.d();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        super.T0();
        this.f4895f0.e();
    }

    Q0.a V1() {
        return this.f4895f0;
    }

    public v0.j X1() {
        return this.f4899j0;
    }

    public m Y1() {
        return this.f4896g0;
    }

    void b2(ComponentCallbacksC0511f componentCallbacksC0511f) {
        this.f4900k0 = componentCallbacksC0511f;
        if (componentCallbacksC0511f == null || componentCallbacksC0511f.q() == null) {
            return;
        }
        Z1(componentCallbacksC0511f.q());
    }

    public void c2(v0.j jVar) {
        this.f4899j0 = jVar;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void s0(Context context) {
        super.s0(context);
        try {
            Z1(q());
        } catch (IllegalStateException e6) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e6);
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public String toString() {
        return super.toString() + "{parent=" + W1() + "}";
    }

    public o(Q0.a aVar) {
        this.f4896g0 = new a();
        this.f4897h0 = new HashSet();
        this.f4895f0 = aVar;
    }
}
