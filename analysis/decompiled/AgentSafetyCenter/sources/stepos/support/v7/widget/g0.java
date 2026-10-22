package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class g0 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f12754a;

    public g0(h0 h0Var) {
        this.f12754a = h0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i3) {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyItemRangeChanged(i, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i3) {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyItemRangeInserted(i, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i, int i3, int i10) {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyItemMoved(i, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i3) {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyItemRangeRemoved(i, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i3, Object obj) {
        x0 x0Var = this.f12754a.f12761c;
        if (x0Var != null) {
            x0Var.notifyItemRangeChanged(i, i3, obj);
        }
    }
}
