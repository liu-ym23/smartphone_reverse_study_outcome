package L3;

import android.view.MenuItem;

/* loaded from: classes2.dex */
public final class o extends I.h implements MenuItem.OnActionExpandListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f1334c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        super(4, onActionExpandListener);
        this.f1334c = qVar;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f825b).onMenuItemActionCollapse(this.f1334c.h(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f825b).onMenuItemActionExpand(this.f1334c.h(menuItem));
    }
}
