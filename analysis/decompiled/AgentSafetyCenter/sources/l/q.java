package l;

import android.view.MenuItem;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f7638a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ s f7639b;

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f7638a.onMenuItemActionCollapse(this.f7639b.g(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f7638a.onMenuItemActionExpand(this.f7639b.g(menuItem));
    }
}
