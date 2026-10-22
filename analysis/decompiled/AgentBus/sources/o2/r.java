package o2;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class r extends x {

    /* renamed from: d, reason: collision with root package name */
    public final WindowInsets.Builder f7245d = new WindowInsets.Builder();

    @Override // o2.x
    public void c(k2.a aVar) {
        this.f7245d.setMandatorySystemGestureInsets(aVar.d());
    }

    @Override // o2.x
    public void d(k2.a aVar) {
        this.f7245d.setSystemGestureInsets(aVar.d());
    }

    @Override // o2.x
    public void e(k2.a aVar) {
        this.f7245d.setSystemWindowInsets(aVar.d());
    }

    @Override // o2.x
    public void f(k2.a aVar) {
        this.f7245d.setTappableElementInsets(aVar.d());
    }

    public j0 g() {
        a();
        j0 j0VarA = j0.a(null, this.f7245d.build());
        g0 g0Var = j0VarA.f7236a;
        g0Var.r(null);
        g0Var.q(null);
        g0Var.u(this.f7247b);
        g0Var.v(this.f7248c);
        return j0VarA;
    }
}
