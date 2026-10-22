package L3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.room.AbstractC0351g;

/* loaded from: classes2.dex */
public final class A extends k implements SubMenu {

    /* renamed from: w, reason: collision with root package name */
    public final k f1243w;

    /* renamed from: x, reason: collision with root package name */
    public final l f1244x;

    public A(Context context, k kVar, l lVar) {
        super(context);
        this.f1243w = kVar;
        this.f1244x = lVar;
    }

    @Override // L3.k
    public final boolean d(l lVar) {
        return this.f1243w.d(lVar);
    }

    @Override // L3.k
    public final boolean e(k kVar, MenuItem menuItem) {
        return super.e(kVar, menuItem) || this.f1243w.e(kVar, menuItem);
    }

    @Override // L3.k
    public final boolean f(l lVar) {
        return this.f1243w.f(lVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f1244x;
    }

    @Override // L3.k
    public final String j() {
        l lVar = this.f1244x;
        int i4 = lVar != null ? lVar.f1305a : 0;
        if (i4 == 0) {
            return null;
        }
        return AbstractC0351g.m("android:menu:actionviewstates:", i4);
    }

    @Override // L3.k
    public final k k() {
        return this.f1243w;
    }

    @Override // L3.k
    public final boolean m() {
        return this.f1243w.m();
    }

    @Override // L3.k
    public final boolean n() {
        return this.f1243w.n();
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

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        t(null, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f1244x.setIcon(drawable);
        return this;
    }

    @Override // L3.k, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f1243w.setQwertyMode(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i4) {
        this.f1244x.setIcon(i4);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i4) {
        t(null, androidx.core.content.a.b(this.f1281a, i4), null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i4) {
        t(this.f1281a.getResources().getString(i4), null, null);
        return this;
    }
}
