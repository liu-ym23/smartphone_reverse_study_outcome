package com.obric.oui.swipeaction.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.b.a;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseSwipeAdapter extends BaseAdapter implements a {
    protected com.obric.oui.swipeaction.a.a mItemManger;

    public abstract void fillValues(int r1, View r2);

    public abstract View generateView(int r1, ViewGroup r2);

    @Override // com.obric.oui.swipeaction.b.a
    public abstract int getSwipeLayoutResourceId(int r1);

    public BaseSwipeAdapter() {
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    @Override // com.obric.oui.swipeaction.b.a
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final View getView(int r1, View r2, ViewGroup r3) {
        if (r2 != null) goto L4;
        r2 = generateView(r1, r3);
    L4:
        this.mItemManger.a(r2, r1);
        fillValues(r1, r2);
        return r2;
    }

    public void openItem(int r1) {
        this.mItemManger.a(r1);
    }

    public void closeItem(int r1) {
        this.mItemManger.b(r1);
    }

    public void closeAllExcept(OSwipeLayout r1) {
        this.mItemManger.a(r1);
    }

    public void closeAllItems() {
        this.mItemManger.b();
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.c();
    }

    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.d();
    }

    public void removeShownLayouts(OSwipeLayout r1) {
        this.mItemManger.b(r1);
    }

    public boolean isOpen(int r1) {
        return this.mItemManger.c(r1);
    }

    public com.obric.oui.swipeaction.c.a.EnumC0996a getMode() {
        return this.mItemManger.a();
    }

    public void setMode(com.obric.oui.swipeaction.c.a.EnumC0996a r1) {
        this.mItemManger.a(r1);
    }
}
