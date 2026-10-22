package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes2.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public MenuItem add(int r100) {
        return getMenuItemWrapper(this.mWrappedObject.add(r100));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r100));
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r100) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(r100));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r100) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(r100));
    }

    @Override // android.view.Menu
    public void removeGroup(int r100) {
        internalRemoveGroup(r100);
        this.mWrappedObject.removeGroup(r100);
    }

    @Override // android.view.Menu
    public void removeItem(int r100) {
        internalRemoveItem(r100);
        this.mWrappedObject.removeItem(r100);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r100) {
        this.mWrappedObject.setQwertyMode(r100);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r100) {
        return getMenuItemWrapper(this.mWrappedObject.add(r100));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r100) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r100));
    }

    public MenuWrapperICS(Context r100, SupportMenu r101) {
        super(r100);
        if (r101 == null) goto L7;
        this.mWrappedObject = r101;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r100, KeyEvent r101) {
        return this.mWrappedObject.isShortcutKey(r100, r101);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r100, int r101) {
        return this.mWrappedObject.performIdentifierAction(r100, r101);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r100, boolean r101) {
        this.mWrappedObject.setGroupEnabled(r100, r101);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r100, boolean r101) {
        this.mWrappedObject.setGroupVisible(r100, r101);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r100, KeyEvent r101, int r102) {
        return this.mWrappedObject.performShortcut(r100, r101, r102);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r100, boolean r101, boolean r102) {
        this.mWrappedObject.setGroupCheckable(r100, r101, r102);
    }

    @Override // android.view.Menu
    public MenuItem add(int r100, int r101, int r102, int r103) {
        return getMenuItemWrapper(this.mWrappedObject.add(r100, r101, r102, r103));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, int r103) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r100, r101, r102, r103));
    }

    @Override // android.view.Menu
    public MenuItem add(int r100, int r101, int r102, CharSequence r103) {
        return getMenuItemWrapper(this.mWrappedObject.add(r100, r101, r102, r103));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, CharSequence r103) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(r100, r101, r102, r103));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r110, int r111, int r112, ComponentName r113, Intent[] r114, Intent r115, int r116, MenuItem[] r210) {
        if (r210 == null) goto L5;
        MenuItem[] r100 = new MenuItem[r210.length];
    L6:
        int r101 = this.mWrappedObject.addIntentOptions(r110, r111, r112, r113, r114, r115, r116, r100);
        if (r100 == null) goto L11;
        int r102 = r100.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        r210[r103] = getMenuItemWrapper(r100[r103]);
        r103 = r103 + 1;
    L11:
        return r101;
    L5:
        r100 = null;
        goto L6
    }
}
