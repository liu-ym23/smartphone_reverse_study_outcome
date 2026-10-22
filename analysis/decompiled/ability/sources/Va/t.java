package Va;

import android.view.MenuItem;

/* loaded from: classes4.dex */
public final class t extends A8.b implements MenuItem.OnActionExpandListener {
    public final /* synthetic */ v b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(v vVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        super(onActionExpandListener);
        this.b = vVar;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f160a).onMenuItemActionCollapse(this.b.P0(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f160a).onMenuItemActionExpand(this.b.P0(menuItem));
    }
}
