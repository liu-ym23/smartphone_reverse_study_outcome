package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class H extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f14824a;

    public H(I i4) {
        this.f14824a = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i4, int i5) {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyItemRangeChanged(i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i4, int i5) {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyItemRangeInserted(i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i4, int i5, int i6) {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyItemMoved(i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i4, int i5) {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyItemRangeRemoved(i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i4, int i5, Object obj) {
        X x4 = this.f14824a.f14829c;
        if (x4 != null) {
            x4.notifyItemRangeChanged(i4, i5, obj);
        }
    }
}
