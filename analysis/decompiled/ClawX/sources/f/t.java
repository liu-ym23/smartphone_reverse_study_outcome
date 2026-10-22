package f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends j implements SubMenu {

    /* renamed from: v, reason: collision with root package name */
    public final j f2526v;

    /* renamed from: w, reason: collision with root package name */
    public final k f2527w;

    public t(Context context, j jVar, k kVar) {
        super(context);
        this.f2526v = jVar;
        this.f2527w = kVar;
    }

    @Override // f.j
    public final boolean d(k kVar) {
        return this.f2526v.d(kVar);
    }

    @Override // f.j
    public final boolean e(j jVar, MenuItem menuItem) {
        return super.e(jVar, menuItem) || this.f2526v.e(jVar, menuItem);
    }

    @Override // f.j
    public final boolean f(k kVar) {
        return this.f2526v.f(kVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f2527w;
    }

    @Override // f.j
    public final j j() {
        return this.f2526v.j();
    }

    @Override // f.j
    public final boolean l() {
        return this.f2526v.l();
    }

    @Override // f.j
    public final boolean m() {
        return this.f2526v.m();
    }

    @Override // f.j
    public final boolean n() {
        return this.f2526v.n();
    }

    @Override // f.j, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.f2526v.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        q(0, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        q(0, charSequence, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        q(0, null, 0, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f2527w.setIcon(drawable);
        return this;
    }

    @Override // f.j, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f2526v.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i8) {
        q(0, null, i8, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i8) {
        q(i8, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i8) {
        this.f2527w.setIcon(i8);
        return this;
    }
}
