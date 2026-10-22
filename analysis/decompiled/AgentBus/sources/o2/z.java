package o2;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class z extends y {

    /* renamed from: g, reason: collision with root package name */
    public k2.a f7254g;

    public z(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var, windowInsets);
        this.f7254g = null;
    }

    @Override // o2.g0
    public j0 b() {
        return j0.a(null, this.f7249b.consumeStableInsets());
    }

    @Override // o2.g0
    public j0 c() {
        return j0.a(null, this.f7249b.consumeSystemWindowInsets());
    }

    @Override // o2.g0
    public final k2.a j() {
        if (this.f7254g == null) {
            WindowInsets windowInsets = this.f7249b;
            this.f7254g = k2.a.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f7254g;
    }

    @Override // o2.g0
    public boolean n() {
        return this.f7249b.isConsumed();
    }
}
