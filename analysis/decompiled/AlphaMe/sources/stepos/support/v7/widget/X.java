package stepos.support.v7.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class X extends RecyclerView.Adapter implements l0 {
    private int mHeadCount;
    private RecyclerView rv;

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int immersiveItemType(int i4) {
        return 3;
    }

    public boolean isSelectable(int i4) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.rv = recyclerView;
    }

    public void setHeadCount(int i4) {
        this.mHeadCount = i4;
    }
}
