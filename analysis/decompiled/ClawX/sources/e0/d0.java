package e0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d0 extends j0 {
    public final WindowInsets.Builder d;

    public d0() {
        this.d = new WindowInsets.Builder();
    }

    @Override // e0.j0
    public x0 b() {
        a();
        x0 x0VarC = x0.c(null, this.d.build());
        t0 t0Var = x0VarC.f2338a;
        t0Var.q(null);
        t0Var.p(null);
        t0Var.t(this.f2314b);
        t0Var.u(this.f2315c);
        return x0VarC;
    }

    @Override // e0.j0
    public void d(x.b bVar) {
        this.d.setMandatorySystemGestureInsets(bVar.d());
    }

    @Override // e0.j0
    public void e(x.b bVar) {
        this.d.setSystemGestureInsets(bVar.d());
    }

    @Override // e0.j0
    public void f(x.b bVar) {
        this.d.setSystemWindowInsets(bVar.d());
    }

    @Override // e0.j0
    public void g(x.b bVar) {
        this.d.setTappableElementInsets(bVar.d());
    }

    public d0(x0 x0Var) {
        WindowInsets.Builder builder;
        super(x0Var);
        WindowInsets windowInsetsB = x0Var.b();
        if (windowInsetsB != null) {
            builder = new WindowInsets.Builder(windowInsetsB);
        } else {
            builder = new WindowInsets.Builder();
        }
        this.d = builder;
    }
}
