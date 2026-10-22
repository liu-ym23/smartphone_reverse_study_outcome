package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl r100 = this.mItem;
        if (r100 == null) goto L5;
        int r101 = r100.getItemId();
    L6:
        if (r101 != 0) goto L10;
        return null;
    L10:
        return super.getActionViewStatesKey() + ":" + r101;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl r100) {
        return this.mParentMenu.collapseItemActionView(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl r100) {
        return this.mParentMenu.expandItemActionView(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback r100) {
        this.mParentMenu.setCallback(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r100) {
        this.mParentMenu.setGroupDividerEnabled(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r100) {
        return (SubMenu) super.setHeaderIconInt(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r100) {
        return (SubMenu) super.setHeaderTitleInt(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r100) {
        return (SubMenu) super.setHeaderViewInt(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r100) {
        this.mItem.setIcon(r100);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean r100) {
        this.mParentMenu.setQwertyMode(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean r100) {
        this.mParentMenu.setShortcutsVisible(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r100) {
        return (SubMenu) super.setHeaderIconInt(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r100) {
        return (SubMenu) super.setHeaderTitleInt(r100);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r100) {
        this.mItem.setIcon(r100);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean dispatchMenuItemSelected(MenuBuilder r100, MenuItem r101) {
        if (super.dispatchMenuItemSelected(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mParentMenu.dispatchMenuItemSelected(r100, r101) == true) goto L8;
        return false;
    }

    public SubMenuBuilder(Context r100, MenuBuilder r101, MenuItemImpl r102) {
        super(r100);
        this.mParentMenu = r101;
        this.mItem = r102;
    }
}
