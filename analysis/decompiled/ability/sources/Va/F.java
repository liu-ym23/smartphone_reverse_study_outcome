package Va;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;

/* loaded from: classes4.dex */
public final class F extends n implements SubMenu {

    /* renamed from: w, reason: collision with root package name */
    public final n f1429w;

    /* renamed from: x, reason: collision with root package name */
    public final q f1430x;

    public F(Context context, n nVar, q qVar) {
        super(context);
        this.f1429w = nVar;
        this.f1430x = qVar;
    }

    @Override // Va.n
    public final boolean d(q qVar) {
        return this.f1429w.d(qVar);
    }

    @Override // Va.n
    public final boolean e(n nVar, MenuItem menuItem) {
        return super.e(nVar, menuItem) || this.f1429w.e(nVar, menuItem);
    }

    @Override // Va.n
    public final boolean f(q qVar) {
        return this.f1429w.f(qVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f1430x;
    }

    @Override // Va.n
    public final String j() {
        q qVar = this.f1430x;
        int i = qVar != null ? qVar.f1453a : 0;
        if (i == 0) {
            return null;
        }
        return B7.a.h(i, "android:menu:actionviewstates:");
    }

    @Override // Va.n
    public final n k() {
        return this.f1429w;
    }

    @Override // Va.n
    public final boolean m() {
        return this.f1429w.m();
    }

    @Override // Va.n
    public final boolean n() {
        return this.f1429w.n();
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        t(null, ContextCompat.getDrawable(this.f1442a, i), null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        t(this.f1442a.getResources().getString(i), null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        t(null, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f1430x.setIcon(drawable);
        return this;
    }

    @Override // Va.n, android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f1429w.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f1430x.setIcon(i);
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
