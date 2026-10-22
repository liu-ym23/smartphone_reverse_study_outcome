package L3;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import q.C0819c;

/* loaded from: classes2.dex */
public class z extends e implements Menu {
    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return h(((F.a) this.f825b).add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((F.a) this.f825b).addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = h(menuItemArr2[i8]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return ((F.a) this.f825b).addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        q.f fVar = this.f1273d;
        if (fVar != null) {
            fVar.clear();
        }
        ((F.a) this.f825b).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((F.a) this.f825b).close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        return h(((F.a) this.f825b).findItem(i4));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return h(((F.a) this.f825b).getItem(i4));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((F.a) this.f825b).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return ((F.a) this.f825b).isShortcutKey(i4, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return ((F.a) this.f825b).performIdentifierAction(i4, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return ((F.a) this.f825b).performShortcut(i4, keyEvent, i5);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        q.f fVar = this.f1273d;
        if (fVar != null) {
            Iterator it = ((C0819c) fVar.keySet()).iterator();
            while (true) {
                q.h hVar = (q.h) it;
                if (!hVar.hasNext()) {
                    break;
                } else if (i4 == ((MenuItem) hVar.next()).getGroupId()) {
                    hVar.remove();
                }
            }
        }
        ((F.a) this.f825b).removeGroup(i4);
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        q.f fVar = this.f1273d;
        if (fVar != null) {
            Iterator it = ((C0819c) fVar.keySet()).iterator();
            while (true) {
                q.h hVar = (q.h) it;
                if (!hVar.hasNext()) {
                    break;
                } else if (i4 == ((MenuItem) hVar.next()).getItemId()) {
                    hVar.remove();
                    break;
                }
            }
        }
        ((F.a) this.f825b).removeItem(i4);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        ((F.a) this.f825b).setGroupCheckable(i4, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        ((F.a) this.f825b).setGroupEnabled(i4, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        ((F.a) this.f825b).setGroupVisible(i4, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        ((F.a) this.f825b).setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((F.a) this.f825b).size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return h(((F.a) this.f825b).add(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return ((F.a) this.f825b).addSubMenu(i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return h(((F.a) this.f825b).add(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return ((F.a) this.f825b).addSubMenu(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return h(((F.a) this.f825b).add(i4, i5, i6, i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return ((F.a) this.f825b).addSubMenu(i4, i5, i6, i7);
    }
}
