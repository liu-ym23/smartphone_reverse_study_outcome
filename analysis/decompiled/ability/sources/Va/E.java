package Va;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenu;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class E extends AbstractC0269g implements Menu {
    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return P0(((SupportMenu) this.f160a).add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i6, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((SupportMenu) this.f160a).addIntentOptions(i, i6, i10, componentName, intentArr, intent, i11, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i12 = 0; i12 < length; i12++) {
                menuItemArr[i12] = P0(menuItemArr2[i12]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return Q0(((SupportMenu) this.f160a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        ArrayMap arrayMap = this.c;
        if (arrayMap != null) {
            arrayMap.clear();
        }
        ArrayMap arrayMap2 = this.d;
        if (arrayMap2 != null) {
            arrayMap2.clear();
        }
        ((SupportMenu) this.f160a).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((SupportMenu) this.f160a).close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return P0(((SupportMenu) this.f160a).findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return P0(((SupportMenu) this.f160a).getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((SupportMenu) this.f160a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.f160a).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i6) {
        return ((SupportMenu) this.f160a).performIdentifierAction(i, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i6) {
        return ((SupportMenu) this.f160a).performShortcut(i, keyEvent, i6);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayMap arrayMap = this.c;
        if (arrayMap != null) {
            Iterator it = arrayMap.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((SupportMenu) this.f160a).removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayMap arrayMap = this.c;
        if (arrayMap != null) {
            Iterator it = arrayMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((SupportMenu) this.f160a).removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ((SupportMenu) this.f160a).setGroupCheckable(i, z10, z11);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ((SupportMenu) this.f160a).setGroupEnabled(i, z10);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ((SupportMenu) this.f160a).setGroupVisible(i, z10);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z10) {
        ((SupportMenu) this.f160a).setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((SupportMenu) this.f160a).size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return P0(((SupportMenu) this.f160a).add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return Q0(((SupportMenu) this.f160a).addSubMenu(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i10, CharSequence charSequence) {
        return P0(((SupportMenu) this.f160a).add(i, i6, i10, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i10, CharSequence charSequence) {
        return Q0(((SupportMenu) this.f160a).addSubMenu(i, i6, i10, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i10, int i11) {
        return P0(((SupportMenu) this.f160a).add(i, i6, i10, i11));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i10, int i11) {
        return Q0(((SupportMenu) this.f160a).addSubMenu(i, i6, i10, i11));
    }
}
