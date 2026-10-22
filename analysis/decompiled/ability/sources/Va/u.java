package Va;

import android.view.MenuItem;

/* loaded from: classes4.dex */
public final class u extends A8.b implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ v b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        super(onMenuItemClickListener);
        this.b = vVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ((MenuItem.OnMenuItemClickListener) this.f160a).onMenuItemClick(this.b.P0(menuItem));
    }
}
