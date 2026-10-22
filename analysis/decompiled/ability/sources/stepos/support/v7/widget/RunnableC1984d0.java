package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: stepos.support.v7.widget.d0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1984d0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f6607a;
    public final /* synthetic */ StepOSRecyclerView b;

    public RunnableC1984d0(StepOSRecyclerView stepOSRecyclerView, boolean z10) {
        this.b = stepOSRecyclerView;
        this.f6607a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSRecyclerView stepOSRecyclerView = this.b;
        RecyclerView.Adapter adapter = stepOSRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, stepOSRecyclerView.getItemCount());
            RecyclerView.ItemAnimator itemAnimator = stepOSRecyclerView.getItemAnimator();
            if (itemAnimator != null) {
                stepOSRecyclerView.post(new RunnableC1982c0(itemAnimator));
            }
            if (this.f6607a) {
                stepOSRecyclerView.requestLayout();
            }
        }
    }
}
