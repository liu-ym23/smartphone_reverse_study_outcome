package c5;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import q.C0933a;

/* loaded from: classes.dex */
abstract class c<T> extends d<T> {

    /* renamed from: b, reason: collision with root package name */
    final Context f12004b;

    /* renamed from: c, reason: collision with root package name */
    private Map<A.b, MenuItem> f12005c;

    /* renamed from: d, reason: collision with root package name */
    private Map<A.c, SubMenu> f12006d;

    c(Context context, T t5) {
        super(t5);
        this.f12004b = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof A.b)) {
            return menuItem;
        }
        A.b bVar = (A.b) menuItem;
        if (this.f12005c == null) {
            this.f12005c = new C0933a();
        }
        MenuItem menuItem2 = this.f12005c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemB = i.b(this.f12004b, bVar);
        this.f12005c.put(bVar, menuItemB);
        return menuItemB;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof A.c)) {
            return subMenu;
        }
        A.c cVar = (A.c) subMenu;
        if (this.f12006d == null) {
            this.f12006d = new C0933a();
        }
        SubMenu subMenu2 = this.f12006d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuC = i.c(this.f12004b, cVar);
        this.f12006d.put(cVar, subMenuC);
        return subMenuC;
    }

    final void e() {
        Map<A.b, MenuItem> map = this.f12005c;
        if (map != null) {
            map.clear();
        }
        Map<A.c, SubMenu> map2 = this.f12006d;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void f(int i5) {
        Map<A.b, MenuItem> map = this.f12005c;
        if (map == null) {
            return;
        }
        Iterator<A.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i5 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void g(int i5) {
        Map<A.b, MenuItem> map = this.f12005c;
        if (map == null) {
            return;
        }
        Iterator<A.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i5 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
