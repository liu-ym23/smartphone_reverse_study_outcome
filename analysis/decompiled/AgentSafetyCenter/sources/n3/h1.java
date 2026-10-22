package n3;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class h1 extends g1 {

    /* renamed from: s, reason: collision with root package name */
    public static final m1 f8718s = m1.h(null, WindowInsets.CONSUMED);

    public h1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
    }

    @Override // n3.f1, n3.b1, n3.j1
    public f3.b i(int i) {
        return f3.b.b(this.f8687c.getInsets(l1.a(i)));
    }

    @Override // n3.f1, n3.b1, n3.j1
    public f3.b j(int i) {
        return f3.b.b(this.f8687c.getInsetsIgnoringVisibility(l1.a(i)));
    }

    @Override // n3.f1, n3.b1, n3.j1
    public boolean u(int i) {
        return this.f8687c.isVisible(l1.a(i));
    }

    public h1(m1 m1Var, h1 h1Var) {
        super(m1Var, h1Var);
    }

    @Override // n3.b1, n3.j1
    public void p(View view) {
    }
}
