package androidx.preference;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class x extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f4172a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f4173b;

    /* renamed from: c, reason: collision with root package name */
    public final Preference f4174c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4175d;

    public x(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
        this.f4172a = adapter;
        this.f4173b = recyclerView;
        this.f4174c = preference;
        this.f4175d = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        RecyclerView.Adapter adapter = this.f4172a;
        adapter.unregisterAdapterDataObserver(this);
        Preference preference = this.f4174c;
        int preferenceAdapterPosition = preference != null ? ((z) adapter).getPreferenceAdapterPosition(preference) : ((z) adapter).getPreferenceAdapterPosition(this.f4175d);
        if (preferenceAdapterPosition != -1) {
            this.f4173b.scrollToPosition(preferenceAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i4, int i5) {
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i4, int i5) {
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i4, int i5, int i6) {
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i4, int i5) {
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i4, int i5, Object obj) {
        a();
    }
}
