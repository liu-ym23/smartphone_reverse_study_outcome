package stepos.support.v7.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: stepos.support.v7.widget.f0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1988f0 extends RecyclerView.Adapter implements t0 {
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
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.rv = recyclerView;
    }

    public void setHeadCount(int i) {
        this.mHeadCount = i;
    }
}
