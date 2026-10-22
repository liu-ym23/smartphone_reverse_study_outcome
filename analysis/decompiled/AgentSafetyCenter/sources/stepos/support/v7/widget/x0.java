package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class x0 extends RecyclerView.Adapter implements m1 {
    private int mHeadCount;
    private RecyclerView rv;

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int immersiveItemType(int i) {
        return 3;
    }

    public boolean isSelectable(int i) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.rv = recyclerView;
    }

    public void setHeadCount(int i) {
        this.mHeadCount = i;
    }
}
