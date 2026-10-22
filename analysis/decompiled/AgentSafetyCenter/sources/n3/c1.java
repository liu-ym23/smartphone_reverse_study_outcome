package n3;

import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c1 extends b1 {

    /* renamed from: n, reason: collision with root package name */
    public f3.b f8698n;

    public c1(m1 m1Var, c1 c1Var) {
        super(m1Var, c1Var);
        this.f8698n = null;
        this.f8698n = c1Var.f8698n;
    }

    @Override // n3.j1
    public m1 b() {
        return m1.h(null, this.f8687c.consumeStableInsets());
    }

    @Override // n3.j1
    public m1 c() {
        return m1.h(null, this.f8687c.consumeSystemWindowInsets());
    }

    @Override // n3.j1
    public final f3.b l() {
        if (this.f8698n == null) {
            WindowInsets windowInsets = this.f8687c;
            this.f8698n = f3.b.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f8698n;
    }

    @Override // n3.j1
    public boolean s() {
        return this.f8687c.isConsumed();
    }

    public c1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
        this.f8698n = null;
    }
}
