package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: stepos.support.v7.widget.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0885e extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f15079a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarCoordinatorLayout f15080b;

    public C0885e(ActionBarCoordinatorLayout actionBarCoordinatorLayout, StepOSRecyclerView stepOSRecyclerView) {
        this.f15080b = actionBarCoordinatorLayout;
        this.f15079a = stepOSRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i4, int i5) {
        super.onScrolled(recyclerView, i4, i5);
        ActionBarCoordinatorLayout.K(this.f15080b, this.f15079a);
    }
}
