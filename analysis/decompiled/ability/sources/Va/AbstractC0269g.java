package Va;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* renamed from: Va.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0269g extends A8.b {
    public final Context b;
    public ArrayMap c;
    public ArrayMap d;

    public AbstractC0269g(Context context, Object obj) {
        super(obj);
        this.b = context;
    }

    public final MenuItem P0(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.c == null) {
            this.c = new ArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        x xVar = new x(this.b, supportMenuItem);
        this.c.put(supportMenuItem, xVar);
        return xVar;
    }

    public final SubMenu Q0(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.d == null) {
            this.d = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        G g = new G(this.b, supportSubMenu);
        this.d.put(supportSubMenu, g);
        return g;
    }
}
