package ge;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class d<T> extends e {

    /* renamed from: b, reason: collision with root package name */
    public final Context f9164b;

    /* renamed from: c, reason: collision with root package name */
    public p.a f9165c;

    /* renamed from: d, reason: collision with root package name */
    public p.a f9166d;

    public d(Context context, T t8) {
        super(t8, 0);
        this.f9164b = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof p0.b)) {
            return menuItem;
        }
        p0.b bVar = (p0.b) menuItem;
        if (this.f9165c == null) {
            this.f9165c = new p.a();
        }
        MenuItem menuItem2 = (MenuItem) this.f9165c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        i iVar = new i(this.f9164b, bVar);
        this.f9165c.put(bVar, iVar);
        return iVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof p0.c)) {
            return subMenu;
        }
        p0.c cVar = (p0.c) subMenu;
        if (this.f9166d == null) {
            this.f9166d = new p.a();
        }
        SubMenu subMenu2 = (SubMenu) this.f9166d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        k kVar = new k(this.f9164b, cVar);
        this.f9166d.put(cVar, kVar);
        return kVar;
    }
}
