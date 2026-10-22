package n3;

import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u0 extends a1 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f8755c;

    public u0(m1 m1Var) {
        super(m1Var);
        WindowInsets windowInsetsG = m1Var.g();
        this.f8755c = windowInsetsG != null ? new WindowInsets.Builder(windowInsetsG) : new WindowInsets.Builder();
    }

    @Override // n3.a1
    public m1 b() {
        a();
        m1 m1VarH = m1.h(null, this.f8755c.build());
        j1 j1Var = m1VarH.f8737a;
        j1Var.w(null);
        j1Var.v(null);
        j1Var.A(this.f8685a);
        j1Var.B(this.f8686b);
        return m1VarH;
    }

    @Override // n3.a1
    public void d(f3.b bVar) {
        this.f8755c.setStableInsets(bVar.c());
    }

    @Override // n3.a1
    public void e(f3.b bVar) {
        this.f8755c.setSystemWindowInsets(bVar.c());
    }

    public u0() {
        this.f8755c = new WindowInsets.Builder();
    }
}
