package te;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class z extends l implements SubMenu {

    /* renamed from: w, reason: collision with root package name */
    public final l f13414w;

    /* renamed from: x, reason: collision with root package name */
    public final m f13415x;

    public z(Context context, l lVar, m mVar) {
        super(context);
        this.f13414w = lVar;
        this.f13415x = mVar;
    }

    @Override // te.l
    public final boolean d(m mVar) {
        return this.f13414w.d(mVar);
    }

    @Override // te.l
    public final boolean e(l lVar, MenuItem menuItem) {
        return super.e(lVar, menuItem) || this.f13414w.e(lVar, menuItem);
    }

    @Override // te.l
    public final boolean f(m mVar) {
        return this.f13414w.f(mVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f13415x;
    }

    @Override // te.l
    public final String j() {
        m mVar = this.f13415x;
        int i = mVar != null ? mVar.f13363a : 0;
        if (i == 0) {
            return null;
        }
        return k0.a.j(i, "android:menu:actionviewstates:");
    }

    @Override // te.l
    public final l k() {
        return this.f13414w;
    }

    @Override // te.l
    public final boolean m() {
        return this.f13414w.m();
    }

    @Override // te.l
    public final boolean n() {
        return this.f13414w.n();
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        t(null, this.f13343a.getDrawable(i), null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        t(this.f13343a.getResources().getString(i), null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        t(null, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f13415x.setIcon(drawable);
        return this;
    }

    @Override // te.l, android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f13414w.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f13415x.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        t(null, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        t(charSequence, null, null);
        return this;
    }
}
