package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class M extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f6473a;

    public M(N n) {
        this.f6473a = n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i6) {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyItemRangeChanged(i, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i6) {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyItemRangeInserted(i, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i, int i6, int i10) {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyItemMoved(i, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i6) {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyItemRangeRemoved(i, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i6, Object obj) {
        AbstractC1988f0 abstractC1988f0 = this.f6473a.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.notifyItemRangeChanged(i, i6, obj);
        }
    }
}
