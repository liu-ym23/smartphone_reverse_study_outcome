package l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a0 extends h.b0 implements Menu {

    /* renamed from: c, reason: collision with root package name */
    public final h3.a f7521c;

    public a0(Context context, h3.a aVar) {
        super(context);
        if (aVar != null) {
            this.f7521c = aVar;
        } else {
            g5.f.s("Wrapped Object can not be null.");
            throw null;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return g(this.f7521c.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f7521c.addIntentOptions(i, i3, i10, componentName, intentArr, intent, i11, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i12 = 0; i12 < length; i12++) {
                menuItemArr[i12] = g(menuItemArr2[i12]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f7521c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        p0 p0Var = (p0) this.f4751b;
        if (p0Var != null) {
            p0Var.clear();
        }
        this.f7521c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f7521c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return g(this.f7521c.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return g(this.f7521c.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f7521c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f7521c.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return this.f7521c.performIdentifierAction(i, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        return this.f7521c.performShortcut(i, keyEvent, i3);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((p0) this.f4751b) != null) {
            int i3 = 0;
            while (true) {
                p0 p0Var = (p0) this.f4751b;
                if (i3 >= p0Var.f9610g) {
                    break;
                }
                if (((h3.b) p0Var.e(i3)).getGroupId() == i) {
                    ((p0) this.f4751b).f(i3);
                    i3--;
                }
                i3++;
            }
        }
        this.f7521c.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((p0) this.f4751b) != null) {
            int i3 = 0;
            while (true) {
                p0 p0Var = (p0) this.f4751b;
                if (i3 >= p0Var.f9610g) {
                    break;
                }
                if (((h3.b) p0Var.e(i3)).getItemId() == i) {
                    ((p0) this.f4751b).f(i3);
                    break;
                }
                i3++;
            }
        }
        this.f7521c.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        this.f7521c.setGroupCheckable(i, z10, z11);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        this.f7521c.setGroupEnabled(i, z10);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        this.f7521c.setGroupVisible(i, z10);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f7521c.setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7521c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.f7521c.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, CharSequence charSequence) {
        return this.f7521c.addSubMenu(i, i3, i10, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, int i11) {
        return this.f7521c.addSubMenu(i, i3, i10, i11);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return g(this.f7521c.add(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, CharSequence charSequence) {
        return g(this.f7521c.add(i, i3, i10, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, int i11) {
        return g(this.f7521c.add(i, i3, i10, i11));
    }
}
