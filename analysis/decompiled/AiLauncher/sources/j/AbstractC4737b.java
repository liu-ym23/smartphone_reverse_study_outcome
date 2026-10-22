package j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.t;
import v0.InterfaceMenuItemC5651b;
import v0.InterfaceSubMenuC5652c;

/* renamed from: j.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4737b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f34410a;

    /* renamed from: b, reason: collision with root package name */
    public t<InterfaceMenuItemC5651b, MenuItem> f34411b;

    /* renamed from: c, reason: collision with root package name */
    public t<InterfaceSubMenuC5652c, SubMenu> f34412c;

    public AbstractC4737b(Context context) {
        this.f34410a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC5651b)) {
            return menuItem;
        }
        InterfaceMenuItemC5651b interfaceMenuItemC5651b = (InterfaceMenuItemC5651b) menuItem;
        if (this.f34411b == null) {
            this.f34411b = new t<>();
        }
        MenuItem menuItem2 = this.f34411b.get(interfaceMenuItemC5651b);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC4738c menuItemC4738c = new MenuItemC4738c(this.f34410a, interfaceMenuItemC5651b);
        this.f34411b.put(interfaceMenuItemC5651b, menuItemC4738c);
        return menuItemC4738c;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof InterfaceSubMenuC5652c)) {
            return subMenu;
        }
        InterfaceSubMenuC5652c interfaceSubMenuC5652c = (InterfaceSubMenuC5652c) subMenu;
        if (this.f34412c == null) {
            this.f34412c = new t<>();
        }
        SubMenu subMenu2 = this.f34412c.get(interfaceSubMenuC5652c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuC4742g subMenuC4742g = new SubMenuC4742g(this.f34410a, interfaceSubMenuC5652c);
        this.f34412c.put(interfaceSubMenuC5652c, subMenuC4742g);
        return subMenuC4742g;
    }

    public final void e() {
        t<InterfaceMenuItemC5651b, MenuItem> tVar = this.f34411b;
        if (tVar != null) {
            tVar.clear();
        }
        t<InterfaceSubMenuC5652c, SubMenu> tVar2 = this.f34412c;
        if (tVar2 != null) {
            tVar2.clear();
        }
    }

    public final void f(int i10) {
        if (this.f34411b == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f34411b.getSize()) {
            if (this.f34411b.keyAt(i11).getGroupId() == i10) {
                this.f34411b.removeAt(i11);
                i11--;
            }
            i11++;
        }
    }

    public final void g(int i10) {
        if (this.f34411b == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f34411b.getSize(); i11++) {
            if (this.f34411b.keyAt(i11).getItemId() == i10) {
                this.f34411b.removeAt(i11);
                return;
            }
        }
    }
}
