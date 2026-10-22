package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class e extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f12744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarCoordinatorLayout f12745b;

    public e(ActionBarCoordinatorLayout actionBarCoordinatorLayout, StepOSRecyclerView stepOSRecyclerView) {
        this.f12745b = actionBarCoordinatorLayout;
        this.f12744a = stepOSRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i3) {
        super.onScrolled(recyclerView, i, i3);
        ActionBarCoordinatorLayout.L(this.f12745b, this.f12744a);
    }
}
