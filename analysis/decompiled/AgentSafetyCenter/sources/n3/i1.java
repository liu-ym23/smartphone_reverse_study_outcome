package n3;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i1 extends h1 {
    public i1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
    }

    @Override // n3.b1, n3.j1
    public List<Rect> f(int i) {
        return this.f8687c.getBoundingRects(l1.a(i));
    }

    @Override // n3.b1, n3.j1
    public List<Rect> g(int i) {
        return this.f8687c.getBoundingRectsIgnoringVisibility(l1.a(i));
    }

    public i1(m1 m1Var, i1 i1Var) {
        super(m1Var, i1Var);
    }

    @Override // n3.b1, n3.j1
    public void q() {
    }
}
