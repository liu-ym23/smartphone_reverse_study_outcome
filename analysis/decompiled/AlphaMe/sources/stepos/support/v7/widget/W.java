package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class W implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f15050a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f15051b;

    public W(StepOSRecyclerView stepOSRecyclerView, boolean z4) {
        this.f15051b = stepOSRecyclerView;
        this.f15050a = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSRecyclerView stepOSRecyclerView = this.f15051b;
        RecyclerView.Adapter adapter = stepOSRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, stepOSRecyclerView.getItemCount());
            RecyclerView.ItemAnimator itemAnimator = stepOSRecyclerView.getItemAnimator();
            if (itemAnimator != null) {
                stepOSRecyclerView.post(new V(itemAnimator));
            }
            if (this.f15050a) {
                stepOSRecyclerView.requestLayout();
            }
        }
    }
}
