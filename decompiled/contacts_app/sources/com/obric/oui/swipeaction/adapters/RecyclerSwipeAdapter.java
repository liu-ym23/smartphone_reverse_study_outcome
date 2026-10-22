package com.obric.oui.swipeaction.adapters;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.implments.SwipeItemMangerImpl;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements SwipeItemMangerInterface, SwipeAdapterInterface {
    public SwipeItemMangerImpl mItemManger;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract void onBindViewHolder(VH r1, int r2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract VH onCreateViewHolder(ViewGroup r1, int r2);

    public RecyclerSwipeAdapter() {
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void openItem(int r1) {
        this.mItemManger.openItem(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeItem(int r1) {
        this.mItemManger.closeItem(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllExcept(OSwipeLayout r1) {
        this.mItemManger.closeAllExcept(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllItems() {
        this.mItemManger.closeAllItems();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<Integer> getOpenItems() {
        return this.mItemManger.getOpenItems();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.getOpenLayouts();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void removeShownLayouts(OSwipeLayout r1) {
        this.mItemManger.removeShownLayouts(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public boolean isOpen(int r1) {
        return this.mItemManger.isOpen(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public Attributes.Mode getMode() {
        return this.mItemManger.getMode();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void setMode(Attributes.Mode r1) {
        this.mItemManger.setMode(r1);
    }
}
