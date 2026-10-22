package te;

import android.view.MenuItem;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p extends f implements MenuItem.OnMenuItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f13390b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(r rVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        super(onMenuItemClickListener);
        this.f13390b = rVar;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ((MenuItem.OnMenuItemClickListener) this.f13336a).onMenuItemClick(this.f13390b.e(menuItem));
    }
}
