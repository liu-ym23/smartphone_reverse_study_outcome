package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends f implements SubMenu {
    public final f D;
    public final h E;

    public m(Context context, f fVar, h hVar) {
        super(context);
        this.D = fVar;
        this.E = hVar;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean d(h hVar) {
        return this.D.d(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean e(f fVar, MenuItem menuItem) {
        return super.e(fVar, menuItem) || this.D.e(fVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean f(h hVar) {
        return this.D.f(hVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.E;
    }

    @Override // androidx.appcompat.view.menu.f
    public final String j() {
        h hVar = this.E;
        int i10 = hVar != null ? hVar.f501a : 0;
        if (i10 == 0) {
            return null;
        }
        return ai.onnxruntime.providers.a.a(i10, "android:menu:actionviewstates:");
    }

    @Override // androidx.appcompat.view.menu.f
    public final f k() {
        return this.D.k();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean m() {
        return this.D.m();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean n() {
        return this.D.n();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean o() {
        return this.D.o();
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.D.setGroupDividerEnabled(z);
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
        this.E.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.D.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i10) {
        u(0, null, i10, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i10) {
        u(i10, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i10) {
        this.E.setIcon(i10);
        return this;
    }
}
