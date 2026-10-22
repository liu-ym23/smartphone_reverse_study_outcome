package o2;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class e0 extends d0 {

    /* renamed from: i, reason: collision with root package name */
    public static final j0 f7229i = j0.a(null, WindowInsets.CONSUMED);

    public e0(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var, windowInsets);
    }

    @Override // o2.c0, o2.y, o2.g0
    public k2.a h(int i2) {
        return k2.a.c(this.f7249b.getInsets(i0.a(i2)));
    }

    @Override // o2.c0, o2.y, o2.g0
    public k2.a i(int i2) {
        return k2.a.c(this.f7249b.getInsetsIgnoringVisibility(i0.a(i2)));
    }

    @Override // o2.y, o2.g0
    public void l(View view) {
    }

    @Override // o2.c0, o2.g0
    public boolean p(int i2) {
        return this.f7249b.isVisible(i0.a(i2));
    }
}
