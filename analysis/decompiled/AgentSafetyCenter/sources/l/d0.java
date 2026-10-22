package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends l implements SubMenu {
    public final n A;

    /* renamed from: z, reason: collision with root package name */
    public final l f7544z;

    public d0(Context context, l lVar, n nVar) {
        super(context);
        this.f7544z = lVar;
        this.A = nVar;
    }

    @Override // l.l
    public final boolean d(n nVar) {
        return this.f7544z.d(nVar);
    }

    @Override // l.l
    public final boolean e(l lVar, MenuItem menuItem) {
        return super.e(lVar, menuItem) || this.f7544z.e(lVar, menuItem);
    }

    @Override // l.l
    public final boolean f(n nVar) {
        return this.f7544z.f(nVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // l.l
    public final String j() {
        n nVar = this.A;
        int i = nVar != null ? nVar.f7610a : 0;
        if (i == 0) {
            return null;
        }
        return k0.a.j(i, "android:menu:actionviewstates:");
    }

    @Override // l.l
    public final l k() {
        return this.f7544z.k();
    }

    @Override // l.l
    public final boolean m() {
        return this.f7544z.m();
    }

    @Override // l.l
    public final boolean n() {
        return this.f7544z.n();
    }

    @Override // l.l
    public final boolean o() {
        return this.f7544z.o();
    }

    @Override // l.l, android.view.Menu
    public final void setGroupDividerEnabled(boolean z10) {
        this.f7544z.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // l.l, android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f7544z.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }
}
