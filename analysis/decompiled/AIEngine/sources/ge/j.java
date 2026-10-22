package ge;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import p.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class j extends d<p0.a> implements Menu {
    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return c(((p0.a) this.f9167a).add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((p0.a) this.f9167a).addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr[i14] = c(menuItemArr2[i14]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return d(((p0.a) this.f9167a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        p.a aVar = this.f9165c;
        if (aVar != null) {
            aVar.clear();
        }
        p.a aVar2 = this.f9166d;
        if (aVar2 != null) {
            aVar2.clear();
        }
        ((p0.a) this.f9167a).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((p0.a) this.f9167a).close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i10) {
        return c(((p0.a) this.f9167a).findItem(i10));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i10) {
        return c(((p0.a) this.f9167a).getItem(i10));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((p0.a) this.f9167a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return ((p0.a) this.f9167a).isShortcutKey(i10, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i10, int i11) {
        return ((p0.a) this.f9167a).performIdentifierAction(i10, i11);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return ((p0.a) this.f9167a).performShortcut(i10, keyEvent, i11);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i10) {
        p.a aVar = this.f9165c;
        if (aVar != null) {
            Iterator it = ((a.c) aVar.keySet()).iterator();
            while (true) {
                p.c cVar = (p.c) it;
                if (!cVar.hasNext()) {
                    break;
                } else if (i10 == ((MenuItem) cVar.next()).getGroupId()) {
                    cVar.remove();
                }
            }
        }
        ((p0.a) this.f9167a).removeGroup(i10);
    }

    @Override // android.view.Menu
    public final void removeItem(int i10) {
        p.a aVar = this.f9165c;
        if (aVar != null) {
            Iterator it = ((a.c) aVar.keySet()).iterator();
            while (true) {
                p.c cVar = (p.c) it;
                if (!cVar.hasNext()) {
                    break;
                } else if (i10 == ((MenuItem) cVar.next()).getItemId()) {
                    cVar.remove();
                    break;
                }
            }
        }
        ((p0.a) this.f9167a).removeItem(i10);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i10, boolean z, boolean z3) {
        ((p0.a) this.f9167a).setGroupCheckable(i10, z, z3);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i10, boolean z) {
        ((p0.a) this.f9167a).setGroupEnabled(i10, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i10, boolean z) {
        ((p0.a) this.f9167a).setGroupVisible(i10, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        ((p0.a) this.f9167a).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((p0.a) this.f9167a).size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10) {
        return c(((p0.a) this.f9167a).add(i10));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10) {
        return d(((p0.a) this.f9167a).addSubMenu(i10));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return c(((p0.a) this.f9167a).add(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return d(((p0.a) this.f9167a).addSubMenu(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, int i13) {
        return c(((p0.a) this.f9167a).add(i10, i11, i12, i13));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return d(((p0.a) this.f9167a).addSubMenu(i10, i11, i12, i13));
    }
}
