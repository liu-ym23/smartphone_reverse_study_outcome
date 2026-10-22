package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public MenuAdapter(MenuBuilder r2, LayoutInflater r3, boolean r4, int r5) {
        this.mExpandedIndex = -1;
        this.mOverflowOnly = r4;
        this.mInflater = r3;
        this.mAdapterMenu = r2;
        this.mItemLayoutRes = r5;
        findExpandedIndex();
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r0 = this.mAdapterMenu.getNonActionItems();
    L7:
        if (this.mExpandedIndex >= 0) goto L11;
        return r0.size();
    L11:
        return r0.size() - 1;
    L5:
        r0 = this.mAdapterMenu.getVisibleItems();
        goto L7
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int r2) {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r0 = this.mAdapterMenu.getNonActionItems();
    L6:
        int r1 = this.mExpandedIndex;
        if (r1 < 0) goto L11;
        if (r2 < r1) goto L11;
        r2 = r2 + 1;
    L11:
        return (MenuItemImpl) ZeusTransformUtils.preCheckCast(r0.get(r2), MenuItemImpl.class, "com.obric.aiagent.plugin");
    L5:
        r0 = this.mAdapterMenu.getVisibleItems();
        goto L6
    }

    @Override // android.widget.Adapter
    public View getView(int r7, View r8, ViewGroup r9) {
        if (r8 != null) goto L5;
        r8 = ZeusTransformUtils.inflate(this.mInflater, this.mItemLayoutRes, r9, false, "com.obric.aiagent.plugin");
    L5:
        int r10 = getItem(r7).getGroupId();
        int r2 = r7 - 1;
        if (r2 < 0) goto L8;
        int r3 = getItem(r2).getGroupId();
    L9:
        ListMenuItemView r4 = (ListMenuItemView) ZeusTransformUtils.preCheckCast(r8, ListMenuItemView.class, "com.obric.aiagent.plugin");
        if (this.mAdapterMenu.isGroupDividerEnabled() == false) goto L13;
        if (r10 == r3) goto L13;
        boolean r11 = true;
    L14:
        r4.setGroupDividerEnabled(r11);
        e.a r12 = (e.a) ZeusTransformUtils.preCheckCast(r8, e.a.class, "com.obric.aiagent.plugin");
        if (this.mForceShowIcon == false) goto L17;
        ((ListMenuItemView) ZeusTransformUtils.preCheckCast(r8, ListMenuItemView.class, "com.obric.aiagent.plugin")).setForceShowIcon(true);
    L17:
        r12.initialize(getItem(r7), 0);
        return r8;
    L13:
        r11 = false;
        goto L14
    L8:
        r3 = r10;
        goto L9
    }

    void findExpandedIndex() {
        MenuItemImpl r0 = this.mAdapterMenu.getExpandedItem();
        if (r0 == null) goto L11;
        ArrayList<MenuItemImpl> r1 = this.mAdapterMenu.getNonActionItems();
        int r2 = r1.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r3), MenuItemImpl.class, "com.obric.aiagent.plugin")) == r0) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        this.mExpandedIndex = r3;
        return;
    L11:
        this.mExpandedIndex = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }
}
