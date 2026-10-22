package k;

import android.view.MenuItem;

/* renamed from: k.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class MenuItemOnMenuItemClickListenerC0667u implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f13301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MenuItemC0668v f13302b;

    public MenuItemOnMenuItemClickListenerC0667u(MenuItemC0668v menuItemC0668v, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13302b = menuItemC0668v;
        this.f13301a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f13301a.onMenuItemClick(this.f13302b.i(menuItem));
    }
}
