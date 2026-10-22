package o2;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends e0 {
    public f0(j0 j0Var, WindowInsets windowInsets) {
        super(j0Var, windowInsets);
    }

    @Override // o2.y, o2.g0
    public List<Rect> e(int i2) {
        return this.f7249b.getBoundingRects(i0.a(i2));
    }

    @Override // o2.y, o2.g0
    public List<Rect> f(int i2) {
        return this.f7249b.getBoundingRectsIgnoringVisibility(i0.a(i2));
    }

    @Override // o2.y, o2.g0
    public void m() {
    }
}
