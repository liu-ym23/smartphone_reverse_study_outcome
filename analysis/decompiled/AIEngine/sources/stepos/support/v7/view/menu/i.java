package stepos.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends c implements SubMenu {
    public final c A;
    public final e B;

    public i(Context context, c cVar, e eVar) {
        super(context);
        this.A = cVar;
        this.B = eVar;
    }

    @Override // stepos.support.v7.view.menu.c
    public final boolean d(e eVar) {
        return this.A.d(eVar);
    }

    @Override // stepos.support.v7.view.menu.c
    public final boolean e(c cVar, MenuItem menuItem) {
        return super.e(cVar, menuItem) || this.A.e(cVar, menuItem);
    }

    @Override // stepos.support.v7.view.menu.c
    public final boolean f(e eVar) {
        return this.A.f(eVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.B;
    }

    @Override // stepos.support.v7.view.menu.c
    public final String j() {
        e eVar = this.B;
        int i10 = eVar != null ? eVar.f12397a : 0;
        if (i10 == 0) {
            return null;
        }
        return ai.onnxruntime.providers.a.a(i10, "android:menu:actionviewstates:");
    }

    @Override // stepos.support.v7.view.menu.c
    public final c k() {
        return this.A;
    }

    @Override // stepos.support.v7.view.menu.c
    public final boolean m() {
        return this.A.m();
    }

    @Override // stepos.support.v7.view.menu.c
    public final boolean n() {
        return this.A.n();
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i10) {
        t(null, this.f12374a.getDrawable(i10), null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i10) {
        t(this.f12374a.getResources().getString(i10), null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        t(null, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.B.setIcon(drawable);
        return this;
    }

    @Override // stepos.support.v7.view.menu.c, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.A.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i10) {
        this.B.setIcon(i10);
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
