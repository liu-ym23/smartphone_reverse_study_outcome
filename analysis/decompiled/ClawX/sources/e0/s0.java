package e0;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 extends q0 {
    public s0(x0 x0Var, WindowInsets windowInsets) {
        super(x0Var, windowInsets);
    }

    @Override // e0.k0, e0.t0
    public List<Rect> e(int i8) {
        return this.f2316c.getBoundingRects(w0.a(i8));
    }

    @Override // e0.k0, e0.t0
    public List<Rect> f(int i8) {
        return this.f2316c.getBoundingRectsIgnoringVisibility(w0.a(i8));
    }

    @Override // e0.k0, e0.t0
    public void l() {
    }
}
