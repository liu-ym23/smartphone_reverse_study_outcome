package k;

import android.view.MenuItem;

/* renamed from: k.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class MenuItemOnActionExpandListenerC0666t implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f13299a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MenuItemC0668v f13300b;

    public MenuItemOnActionExpandListenerC0666t(MenuItemC0668v menuItemC0668v, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f13300b = menuItemC0668v;
        this.f13299a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f13299a.onMenuItemActionCollapse(this.f13300b.i(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f13299a.onMenuItemActionExpand(this.f13300b.i(menuItem));
    }
}
