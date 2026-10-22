package te;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class y extends e implements Menu {
    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return e(((h3.a) this.f13336a).add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((h3.a) this.f13336a).addIntentOptions(i, i3, i10, componentName, intentArr, intent, i11, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i12 = 0; i12 < length; i12++) {
                menuItemArr[i12] = e(menuItemArr2[i12]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return ((h3.a) this.f13336a).addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        p.e eVar = this.f13335c;
        if (eVar != null) {
            eVar.clear();
        }
        ((h3.a) this.f13336a).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((h3.a) this.f13336a).close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return e(((h3.a) this.f13336a).findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return e(((h3.a) this.f13336a).getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((h3.a) this.f13336a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((h3.a) this.f13336a).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return ((h3.a) this.f13336a).performIdentifierAction(i, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        return ((h3.a) this.f13336a).performShortcut(i, keyEvent, i3);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        p.e eVar = this.f13335c;
        if (eVar != null) {
            Iterator it = ((p.b) eVar.keySet()).iterator();
            while (true) {
                p.a aVar = (p.a) it;
                if (!aVar.hasNext()) {
                    break;
                } else if (i == ((MenuItem) aVar.next()).getGroupId()) {
                    aVar.remove();
                }
            }
        }
        ((h3.a) this.f13336a).removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        p.e eVar = this.f13335c;
        if (eVar != null) {
            Iterator it = ((p.b) eVar.keySet()).iterator();
            while (true) {
                p.a aVar = (p.a) it;
                if (!aVar.hasNext()) {
                    break;
                } else if (i == ((MenuItem) aVar.next()).getItemId()) {
                    aVar.remove();
                    break;
                }
            }
        }
        ((h3.a) this.f13336a).removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ((h3.a) this.f13336a).setGroupCheckable(i, z10, z11);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ((h3.a) this.f13336a).setGroupEnabled(i, z10);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ((h3.a) this.f13336a).setGroupVisible(i, z10);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z10) {
        ((h3.a) this.f13336a).setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((h3.a) this.f13336a).size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return ((h3.a) this.f13336a).addSubMenu(i);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, CharSequence charSequence) {
        return ((h3.a) this.f13336a).addSubMenu(i, i3, i10, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, int i11) {
        return ((h3.a) this.f13336a).addSubMenu(i, i3, i10, i11);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return e(((h3.a) this.f13336a).add(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, CharSequence charSequence) {
        return e(((h3.a) this.f13336a).add(i, i3, i10, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, int i11) {
        return e(((h3.a) this.f13336a).add(i, i3, i10, i11));
    }
}
