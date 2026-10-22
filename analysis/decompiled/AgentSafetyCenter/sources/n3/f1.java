package n3;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f1 extends e1 {

    /* renamed from: r, reason: collision with root package name */
    public static final m1 f8713r = m1.h(null, WindowInsets.CONSUMED);

    public f1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
    }

    @Override // n3.b1, n3.j1
    public f3.b i(int i) {
        return f3.b.b(this.f8687c.getInsets(k1.a(i)));
    }

    @Override // n3.b1, n3.j1
    public f3.b j(int i) {
        return f3.b.b(this.f8687c.getInsetsIgnoringVisibility(k1.a(i)));
    }

    @Override // n3.b1, n3.j1
    public boolean u(int i) {
        return this.f8687c.isVisible(k1.a(i));
    }

    public f1(m1 m1Var, f1 f1Var) {
        super(m1Var, f1Var);
    }

    @Override // n3.b1, n3.j1
    public final void d(View view) {
    }
}
