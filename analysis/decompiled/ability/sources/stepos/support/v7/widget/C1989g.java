package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: stepos.support.v7.widget.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1989g extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f6611a;
    public final /* synthetic */ ActionBarCoordinatorLayout b;

    public C1989g(ActionBarCoordinatorLayout actionBarCoordinatorLayout, StepOSRecyclerView stepOSRecyclerView) {
        this.b = actionBarCoordinatorLayout;
        this.f6611a = stepOSRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        super.onScrolled(recyclerView, i, i6);
        ActionBarCoordinatorLayout.e(this.b, this.f6611a);
    }
}
