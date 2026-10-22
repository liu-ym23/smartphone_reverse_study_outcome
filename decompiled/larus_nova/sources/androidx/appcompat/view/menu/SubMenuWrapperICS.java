package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes2.dex */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu mSubMenu;

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return getMenuItemWrapper(this.mSubMenu.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r100) {
        this.mSubMenu.setHeaderIcon(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r100) {
        this.mSubMenu.setHeaderTitle(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r100) {
        this.mSubMenu.setHeaderView(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r100) {
        this.mSubMenu.setIcon(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r100) {
        this.mSubMenu.setHeaderIcon(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r100) {
        this.mSubMenu.setHeaderTitle(r100);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r100) {
        this.mSubMenu.setIcon(r100);
        return this;
    }

    public SubMenuWrapperICS(Context r100, SupportSubMenu r101) {
        super(r100, r101);
        this.mSubMenu = r101;
    }
}
