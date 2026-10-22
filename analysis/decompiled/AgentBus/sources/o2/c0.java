package o2;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class c0 extends b0 {

    /* renamed from: h, reason: collision with root package name */
    public static final j0 f7224h = j0.a(null, WindowInsets.CONSUMED);

    public c0(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var, windowInsets);
    }

    @Override // o2.g0
    public final void d(View view) {
    }

    @Override // o2.y, o2.g0
    public k2.a h(int i2) {
        return k2.a.c(this.f7249b.getInsets(h0.a(i2)));
    }

    @Override // o2.y, o2.g0
    public k2.a i(int i2) {
        return k2.a.c(this.f7249b.getInsetsIgnoringVisibility(h0.a(i2)));
    }

    @Override // o2.g0
    public boolean p(int i2) {
        return this.f7249b.isVisible(h0.a(i2));
    }
}
