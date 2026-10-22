package k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: k.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class MenuC0643D extends AbstractC0650d implements Menu {

    /* renamed from: d, reason: collision with root package name */
    public final F.a f13140d;

    public MenuC0643D(Context context, F.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f13140d = aVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return i(this.f13140d.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f13140d.addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = i(menuItemArr2[i8]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f13140d.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        q.l lVar = (q.l) this.f13182b;
        if (lVar != null) {
            lVar.clear();
        }
        q.l lVar2 = (q.l) this.f13183c;
        if (lVar2 != null) {
            lVar2.clear();
        }
        this.f13140d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f13140d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        return i(this.f13140d.findItem(i4));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return i(this.f13140d.getItem(i4));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f13140d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return this.f13140d.isShortcutKey(i4, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return this.f13140d.performIdentifierAction(i4, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return this.f13140d.performShortcut(i4, keyEvent, i5);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        if (((q.l) this.f13182b) != null) {
            int i5 = 0;
            while (true) {
                q.l lVar = (q.l) this.f13182b;
                if (i5 >= lVar.f13970c) {
                    break;
                }
                if (((F.b) lVar.f(i5)).getGroupId() == i4) {
                    ((q.l) this.f13182b).g(i5);
                    i5--;
                }
                i5++;
            }
        }
        this.f13140d.removeGroup(i4);
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        if (((q.l) this.f13182b) != null) {
            int i5 = 0;
            while (true) {
                q.l lVar = (q.l) this.f13182b;
                if (i5 >= lVar.f13970c) {
                    break;
                }
                if (((F.b) lVar.f(i5)).getItemId() == i4) {
                    ((q.l) this.f13182b).g(i5);
                    break;
                }
                i5++;
            }
        }
        this.f13140d.removeItem(i4);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        this.f13140d.setGroupCheckable(i4, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        this.f13140d.setGroupEnabled(i4, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        this.f13140d.setGroupVisible(i4, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f13140d.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f13140d.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return i(this.f13140d.add(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return this.f13140d.addSubMenu(i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return i(this.f13140d.add(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return this.f13140d.addSubMenu(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return i(this.f13140d.add(i4, i5, i6, i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return this.f13140d.addSubMenu(i4, i5, i6, i7);
    }
}
