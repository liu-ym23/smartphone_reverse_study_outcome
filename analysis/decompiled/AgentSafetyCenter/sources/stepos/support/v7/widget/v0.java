package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f12869c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ StepOSRecyclerView f12870f;

    @Override // java.lang.Runnable
    public final void run() {
        StepOSRecyclerView stepOSRecyclerView = this.f12870f;
        RecyclerView.Adapter adapter = stepOSRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeChanged(0, stepOSRecyclerView.getItemCount());
            RecyclerView.ItemAnimator itemAnimator = stepOSRecyclerView.getItemAnimator();
            if (itemAnimator != null) {
                u0 u0Var = new u0();
                u0Var.f12840c = itemAnimator;
                VarHandle.storeStoreFence();
                stepOSRecyclerView.post(u0Var);
            }
            if (this.f12869c) {
                stepOSRecyclerView.requestLayout();
            }
        }
    }
}
