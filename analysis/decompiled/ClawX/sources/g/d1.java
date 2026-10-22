package g;

import android.widget.AbsListView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d1 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f2688a;

    public d1(j1 j1Var) {
        this.f2688a = j1Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i8) {
        j1 j1Var = this.f2688a;
        b1 b1Var = j1Var.f2749o;
        x xVar = j1Var.f2757w;
        if (i8 != 1 || xVar.getInputMethodMode() == 2 || xVar.getContentView() == null) {
            return;
        }
        j1Var.f2753s.removeCallbacks(b1Var);
        b1Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i8, int i9, int i10) {
    }
}
