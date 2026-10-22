package l;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import q.i;

/* renamed from: l.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0817b {

    /* renamed from: a, reason: collision with root package name */
    final Context f18001a;

    /* renamed from: b, reason: collision with root package name */
    private i<A.b, MenuItem> f18002b;

    /* renamed from: c, reason: collision with root package name */
    private i<A.c, SubMenu> f18003c;

    AbstractC0817b(Context context) {
        this.f18001a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof A.b)) {
            return menuItem;
        }
        A.b bVar = (A.b) menuItem;
        if (this.f18002b == null) {
            this.f18002b = new i<>();
        }
        MenuItem menuItem2 = this.f18002b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC0818c menuItemC0818c = new MenuItemC0818c(this.f18001a, bVar);
        this.f18002b.put(bVar, menuItemC0818c);
        return menuItemC0818c;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof A.c)) {
            return subMenu;
        }
        A.c cVar = (A.c) subMenu;
        if (this.f18003c == null) {
            this.f18003c = new i<>();
        }
        SubMenu subMenu2 = this.f18003c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuC0821f subMenuC0821f = new SubMenuC0821f(this.f18001a, cVar);
        this.f18003c.put(cVar, subMenuC0821f);
        return subMenuC0821f;
    }

    final void e() {
        i<A.b, MenuItem> iVar = this.f18002b;
        if (iVar != null) {
            iVar.clear();
        }
        i<A.c, SubMenu> iVar2 = this.f18003c;
        if (iVar2 != null) {
            iVar2.clear();
        }
    }

    final void f(int i5) {
        if (this.f18002b == null) {
            return;
        }
        int i6 = 0;
        while (i6 < this.f18002b.size()) {
            if (this.f18002b.f(i6).getGroupId() == i5) {
                this.f18002b.h(i6);
                i6--;
            }
            i6++;
        }
    }

    final void g(int i5) {
        if (this.f18002b == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f18002b.size(); i6++) {
            if (this.f18002b.f(i6).getItemId() == i5) {
                this.f18002b.h(i6);
                return;
            }
        }
    }
}
