package c5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
class j extends c<A.a> implements Menu {
    j(Context context, A.a aVar) {
        super(context, aVar);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(((A.a) this.f12007a).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((A.a) this.f12007a).addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr[i9] = c(menuItemArr2[i9]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(((A.a) this.f12007a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        ((A.a) this.f12007a).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((A.a) this.f12007a).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i5) {
        return c(((A.a) this.f12007a).findItem(i5));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i5) {
        return c(((A.a) this.f12007a).getItem(i5));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((A.a) this.f12007a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return ((A.a) this.f12007a).isShortcutKey(i5, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i5, int i6) {
        return ((A.a) this.f12007a).performIdentifierAction(i5, i6);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return ((A.a) this.f12007a).performShortcut(i5, keyEvent, i6);
    }

    @Override // android.view.Menu
    public void removeGroup(int i5) {
        f(i5);
        ((A.a) this.f12007a).removeGroup(i5);
    }

    @Override // android.view.Menu
    public void removeItem(int i5) {
        g(i5);
        ((A.a) this.f12007a).removeItem(i5);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i5, boolean z5, boolean z6) {
        ((A.a) this.f12007a).setGroupCheckable(i5, z5, z6);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i5, boolean z5) {
        ((A.a) this.f12007a).setGroupEnabled(i5, z5);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i5, boolean z5) {
        ((A.a) this.f12007a).setGroupVisible(i5, z5);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        ((A.a) this.f12007a).setQwertyMode(z5);
    }

    @Override // android.view.Menu
    public int size() {
        return ((A.a) this.f12007a).size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i5) {
        return c(((A.a) this.f12007a).add(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5) {
        return d(((A.a) this.f12007a).addSubMenu(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return c(((A.a) this.f12007a).add(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return d(((A.a) this.f12007a).addSubMenu(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, int i8) {
        return c(((A.a) this.f12007a).add(i5, i6, i7, i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return d(((A.a) this.f12007a).addSubMenu(i5, i6, i7, i8));
    }
}
