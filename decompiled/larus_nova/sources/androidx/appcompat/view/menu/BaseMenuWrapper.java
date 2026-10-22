package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    public final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> r100 = this.mMenuItems;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        SimpleArrayMap<SupportSubMenu, SubMenu> r101 = this.mSubMenus;
        if (r101 == null) goto L9;
        r101.clear();
        return;
    }

    public BaseMenuWrapper(Context r100) {
        this.mContext = r100;
    }

    public final MenuItem getMenuItemWrapper(MenuItem r100) {
        if ((r100 instanceof SupportMenuItem) == false) goto L11;
        SupportMenuItem r101 = (SupportMenuItem) r100;
        if (this.mMenuItems != null) goto L7;
        this.mMenuItems = new SimpleArrayMap();
    L7:
        MenuItem r102 = this.mMenuItems.get(r100);
        if (r102 != null) goto L12;
        MenuItemWrapperICS r103 = new MenuItemWrapperICS(this.mContext, r101);
        this.mMenuItems.put(r101, r103);
        return r103;
    L12:
        return r102;
    L11:
        return r100;
    }

    public final SubMenu getSubMenuWrapper(SubMenu r100) {
        if ((r100 instanceof SupportSubMenu) == false) goto L11;
        SupportSubMenu r101 = (SupportSubMenu) r100;
        if (this.mSubMenus != null) goto L7;
        this.mSubMenus = new SimpleArrayMap();
    L7:
        SubMenu r102 = this.mSubMenus.get(r101);
        if (r102 != null) goto L12;
        SubMenuWrapperICS r103 = new SubMenuWrapperICS(this.mContext, r101);
        this.mSubMenus.put(r101, r103);
        return r103;
    L12:
        return r102;
    L11:
        return r100;
    }

    public final void internalRemoveGroup(int r100) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= this.mMenuItems.size()) goto L12;
        if (this.mMenuItems.keyAt(r101).getGroupId() != r100) goto L11;
        this.mMenuItems.removeAt(r101);
        r101 = r101 - 1;
    L11:
        r101 = r101 + 1;
        goto L7
    }

    public final void internalRemoveItem(int r100) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= this.mMenuItems.size()) goto L15;
        if (this.mMenuItems.keyAt(r101).getItemId() == r100) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        this.mMenuItems.removeAt(r101);
        return;
    }
}
