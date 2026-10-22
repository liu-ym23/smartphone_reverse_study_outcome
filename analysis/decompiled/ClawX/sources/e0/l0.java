package e0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l0 extends k0 {

    /* renamed from: h, reason: collision with root package name */
    public x.b f2323h;

    public l0(x0 x0Var, WindowInsets windowInsets) {
        super(x0Var, windowInsets);
        this.f2323h = null;
    }

    @Override // e0.t0
    public x0 b() {
        return x0.c(null, this.f2316c.consumeStableInsets());
    }

    @Override // e0.t0
    public x0 c() {
        return x0.c(null, this.f2316c.consumeSystemWindowInsets());
    }

    @Override // e0.t0
    public final x.b i() {
        if (this.f2323h == null) {
            WindowInsets windowInsets = this.f2316c;
            this.f2323h = x.b.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f2323h;
    }

    @Override // e0.t0
    public boolean n() {
        return this.f2316c.isConsumed();
    }
}
