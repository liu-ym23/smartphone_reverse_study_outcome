package L3;

import android.view.MenuItem;

/* loaded from: classes2.dex */
public final class p extends I.h implements MenuItem.OnMenuItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f1335c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        super(4, onMenuItemClickListener);
        this.f1335c = qVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ((MenuItem.OnMenuItemClickListener) this.f825b).onMenuItemClick(this.f1335c.h(menuItem));
    }
}
