package m;

import android.widget.AbsListView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u1 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ w1 f8086a;

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        w1 w1Var = this.f8086a;
        s1 s1Var = w1Var.f8130v;
        if (i != 1 || w1Var.D.getInputMethodMode() == 2 || w1Var.D.getContentView() == null) {
            return;
        }
        w1Var.f8134z.removeCallbacks(s1Var);
        s1Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i3, int i10) {
    }
}
