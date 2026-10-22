package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public class k extends c implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SupportMenu f619d;

    public k(Context r10, SupportMenu r11) {
        super(r10);
        if (r11 == null) goto L7;
        this.f619d = r11;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r10) {
        return a(this.f619d.add(r10));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r13, int r14, int r15, ComponentName r16, Intent[] r17, Intent r18, int r19, MenuItem[] r20) {
        if (r20 == null) goto L5;
        MenuItem[] r10 = new MenuItem[r20.length];
    L6:
        int r11 = this.f619d.addIntentOptions(r13, r14, r15, r16, r17, r18, r19, r10);
        if (r10 == null) goto L11;
        int r12 = r10.length;
        int r21 = 0;
    L9:
        if (r21 >= r12) goto L11;
        r20[r21] = a(r10[r21]);
        r21 = r21 + 1;
    L11:
        return r11;
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r10) {
        return b(this.f619d.addSubMenu(r10));
    }

    @Override // android.view.Menu
    public void clear() {
        c();
        this.f619d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f619d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r10) {
        return a(this.f619d.findItem(r10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r10) {
        return a(this.f619d.getItem(r10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f619d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r10, KeyEvent r11) {
        return this.f619d.isShortcutKey(r10, r11);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r10, int r11) {
        return this.f619d.performIdentifierAction(r10, r11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r10, KeyEvent r11, int r12) {
        return this.f619d.performShortcut(r10, r11, r12);
    }

    @Override // android.view.Menu
    public void removeGroup(int r10) {
        d(r10);
        this.f619d.removeGroup(r10);
    }

    @Override // android.view.Menu
    public void removeItem(int r10) {
        e(r10);
        this.f619d.removeItem(r10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r10, boolean r11, boolean r12) {
        this.f619d.setGroupCheckable(r10, r11, r12);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r10, boolean r11) {
        this.f619d.setGroupEnabled(r10, r11);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r10, boolean r11) {
        this.f619d.setGroupVisible(r10, r11);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r10) {
        this.f619d.setQwertyMode(r10);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f619d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int r10) {
        return a(this.f619d.add(r10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10) {
        return b(this.f619d.addSubMenu(r10));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, CharSequence r13) {
        return a(this.f619d.add(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, CharSequence r13) {
        return b(this.f619d.addSubMenu(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, int r13) {
        return a(this.f619d.add(r10, r11, r12, r13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, int r13) {
        return b(this.f619d.addSubMenu(r10, r11, r12, r13));
    }
}
