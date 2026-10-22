package Jc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import v0.InterfaceMenuC5650a;

/* loaded from: classes5.dex */
public class k extends d<InterfaceMenuC5650a> implements Menu {
    public k(Context context, InterfaceMenuC5650a interfaceMenuC5650a) {
        super(context, interfaceMenuC5650a);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(((InterfaceMenuC5650a) this.f3841a).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((InterfaceMenuC5650a) this.f3841a).addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr[i14] = c(menuItemArr2[i14]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(((InterfaceMenuC5650a) this.f3841a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        ((InterfaceMenuC5650a) this.f3841a).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((InterfaceMenuC5650a) this.f3841a).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        return c(((InterfaceMenuC5650a) this.f3841a).findItem(i10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return c(((InterfaceMenuC5650a) this.f3841a).getItem(i10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((InterfaceMenuC5650a) this.f3841a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return ((InterfaceMenuC5650a) this.f3841a).isShortcutKey(i10, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return ((InterfaceMenuC5650a) this.f3841a).performIdentifierAction(i10, i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return ((InterfaceMenuC5650a) this.f3841a).performShortcut(i10, keyEvent, i11);
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        f(i10);
        ((InterfaceMenuC5650a) this.f3841a).removeGroup(i10);
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        g(i10);
        ((InterfaceMenuC5650a) this.f3841a).removeItem(i10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        ((InterfaceMenuC5650a) this.f3841a).setGroupCheckable(i10, z10, z11);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        ((InterfaceMenuC5650a) this.f3841a).setGroupEnabled(i10, z10);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        ((InterfaceMenuC5650a) this.f3841a).setGroupVisible(i10, z10);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        ((InterfaceMenuC5650a) this.f3841a).setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public int size() {
        return ((InterfaceMenuC5650a) this.f3841a).size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return c(((InterfaceMenuC5650a) this.f3841a).add(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return d(((InterfaceMenuC5650a) this.f3841a).addSubMenu(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return c(((InterfaceMenuC5650a) this.f3841a).add(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return d(((InterfaceMenuC5650a) this.f3841a).addSubMenu(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return c(((InterfaceMenuC5650a) this.f3841a).add(i10, i11, i12, i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return d(((InterfaceMenuC5650a) this.f3841a).addSubMenu(i10, i11, i12, i13));
    }
}
