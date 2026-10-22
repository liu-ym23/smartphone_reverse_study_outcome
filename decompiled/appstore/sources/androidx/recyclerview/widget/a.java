package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f4315a;

    public a(RecyclerView.Adapter r10) {
        this.f4315a = r10;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r10, int r11, Object r12) {
        this.f4315a.notifyItemRangeChanged(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r10, int r11) {
        this.f4315a.notifyItemRangeInserted(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r10, int r11) {
        this.f4315a.notifyItemMoved(r10, r11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r10, int r11) {
        this.f4315a.notifyItemRangeRemoved(r10, r11);
    }
}
