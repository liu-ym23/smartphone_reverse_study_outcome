package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f12863a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f12864b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ItemAnimator f12865a;

        public a(RecyclerView.ItemAnimator itemAnimator) {
            this.f12865a = itemAnimator;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12865a.endAnimations();
        }
    }

    public u(StepOSRecyclerView stepOSRecyclerView, boolean z) {
        this.f12864b = stepOSRecyclerView;
        this.f12863a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSRecyclerView stepOSRecyclerView = this.f12864b;
        RecyclerView.Adapter adapter = stepOSRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, stepOSRecyclerView.getItemCount());
            RecyclerView.ItemAnimator itemAnimator = stepOSRecyclerView.getItemAnimator();
            if (itemAnimator != null) {
                stepOSRecyclerView.post(new a(itemAnimator));
            }
            if (this.f12863a) {
                stepOSRecyclerView.requestLayout();
            }
        }
    }
}
