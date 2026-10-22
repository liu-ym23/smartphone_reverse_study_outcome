package Jc;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import v0.InterfaceMenuItemC5651b;
import v0.InterfaceSubMenuC5652c;

/* loaded from: classes5.dex */
public abstract class d<T> extends e<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Context f3838b;

    /* renamed from: c, reason: collision with root package name */
    public Map<InterfaceMenuItemC5651b, MenuItem> f3839c;

    /* renamed from: d, reason: collision with root package name */
    public Map<InterfaceSubMenuC5652c, SubMenu> f3840d;

    public d(Context context, T t10) {
        super(t10);
        this.f3838b = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC5651b)) {
            return menuItem;
        }
        InterfaceMenuItemC5651b interfaceMenuItemC5651b = (InterfaceMenuItemC5651b) menuItem;
        if (this.f3839c == null) {
            this.f3839c = new androidx.collection.a();
        }
        MenuItem menuItem2 = this.f3839c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemB = j.b(this.f3838b, interfaceMenuItemC5651b);
        this.f3839c.put(interfaceMenuItemC5651b, menuItemB);
        return menuItemB;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof InterfaceSubMenuC5652c)) {
            return subMenu;
        }
        InterfaceSubMenuC5652c interfaceSubMenuC5652c = (InterfaceSubMenuC5652c) subMenu;
        if (this.f3840d == null) {
            this.f3840d = new androidx.collection.a();
        }
        SubMenu subMenu2 = this.f3840d.get(interfaceSubMenuC5652c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuC = j.c(this.f3838b, interfaceSubMenuC5652c);
        this.f3840d.put(interfaceSubMenuC5652c, subMenuC);
        return subMenuC;
    }

    public final void e() {
        Map<InterfaceMenuItemC5651b, MenuItem> map = this.f3839c;
        if (map != null) {
            map.clear();
        }
        Map<InterfaceSubMenuC5652c, SubMenu> map2 = this.f3840d;
        if (map2 != null) {
            map2.clear();
        }
    }

    public final void f(int i10) {
        Map<InterfaceMenuItemC5651b, MenuItem> map = this.f3839c;
        if (map == null) {
            return;
        }
        Iterator<InterfaceMenuItemC5651b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i10 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    public final void g(int i10) {
        Map<InterfaceMenuItemC5651b, MenuItem> map = this.f3839c;
        if (map == null) {
            return;
        }
        Iterator<InterfaceMenuItemC5651b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i10 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
