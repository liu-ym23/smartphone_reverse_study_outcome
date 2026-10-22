package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    public void findExpandedIndex() {
        MenuItemImpl r100 = this.mAdapterMenu.getExpandedItem();
        if (r100 == null) goto L11;
        ArrayList<MenuItemImpl> r101 = this.mAdapterMenu.getNonActionItems();
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        if (((MenuItemImpl) ListProtector.get(r101, r103)) == r100) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        this.mExpandedIndex = r103;
        return;
    L11:
        this.mExpandedIndex = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r100 = this.mAdapterMenu.getNonActionItems();
    L7:
        if (this.mExpandedIndex >= 0) goto L11;
        return r100.size();
    L11:
        return r100.size() - 1;
    L5:
        r100 = this.mAdapterMenu.getVisibleItems();
        goto L7
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int r100) {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r101 = this.mAdapterMenu.getNonActionItems();
    L6:
        int r102 = this.mExpandedIndex;
        if (r102 < 0) goto L11;
        if (r100 < r102) goto L11;
        r100 = r100 + 1;
    L11:
        return (MenuItemImpl) ListProtector.get(r101, r100);
    L5:
        r101 = this.mAdapterMenu.getVisibleItems();
        goto L6
    }

    public void setForceShowIcon(boolean r100) {
        this.mForceShowIcon = r100;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r100) {
        return getItem(r100);
    }

    @Override // android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L5;
        r101 = this.mInflater.inflate(this.mItemLayoutRes, r102, false);
    L5:
        int r103 = getItem(r100).getGroupId();
        int r104 = r100 - 1;
        if (r104 < 0) goto L8;
        int r105 = getItem(r104).getGroupId();
    L9:
        ListMenuItemView r106 = (ListMenuItemView) r101;
        if (this.mAdapterMenu.isGroupDividerEnabled() == false) goto L13;
        if (r103 == r105) goto L13;
        boolean r107 = true;
    L14:
        r106.setGroupDividerEnabled(r107);
        MenuView.ItemView r108 = (MenuView.ItemView) r101;
        if (this.mForceShowIcon == false) goto L17;
        r106.setForceShowIcon(true);
    L17:
        r108.initialize(getItem(r100), 0);
        return r101;
    L13:
        r107 = false;
        goto L14
    L8:
        r105 = r103;
        goto L9
    }

    public MenuAdapter(MenuBuilder r100, LayoutInflater r101, boolean r102, int r103) {
        this.mExpandedIndex = -1;
        this.mOverflowOnly = r102;
        this.mInflater = r101;
        this.mAdapterMenu = r100;
        this.mItemLayoutRes = r103;
        findExpandedIndex();
    }
}
