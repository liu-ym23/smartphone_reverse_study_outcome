package k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.room.AbstractC0351g;

/* renamed from: k.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SubMenuC0646G extends C0661o implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    public final C0663q f13161A;

    /* renamed from: z, reason: collision with root package name */
    public final C0661o f13162z;

    public SubMenuC0646G(Context context, C0661o c0661o, C0663q c0663q) {
        super(context);
        this.f13162z = c0661o;
        this.f13161A = c0663q;
    }

    @Override // k.C0661o
    public final boolean d(C0663q c0663q) {
        return this.f13162z.d(c0663q);
    }

    @Override // k.C0661o
    public final boolean e(C0661o c0661o, MenuItem menuItem) {
        return super.e(c0661o, menuItem) || this.f13162z.e(c0661o, menuItem);
    }

    @Override // k.C0661o
    public final boolean f(C0663q c0663q) {
        return this.f13162z.f(c0663q);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f13161A;
    }

    @Override // k.C0661o
    public final String j() {
        C0663q c0663q = this.f13161A;
        int i4 = c0663q != null ? c0663q.f13269a : 0;
        if (i4 == 0) {
            return null;
        }
        return AbstractC0351g.m("android:menu:actionviewstates:", i4);
    }

    @Override // k.C0661o
    public final C0661o k() {
        return this.f13162z.k();
    }

    @Override // k.C0661o
    public final boolean m() {
        return this.f13162z.m();
    }

    @Override // k.C0661o
    public final boolean n() {
        return this.f13162z.n();
    }

    @Override // k.C0661o
    public final boolean o() {
        return this.f13162z.o();
    }

    @Override // k.C0661o, android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
        this.f13162z.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i4) {
        u(0, null, i4, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i4) {
        u(i4, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f13161A.setIcon(drawable);
        return this;
    }

    @Override // k.C0661o, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f13162z.setQwertyMode(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i4) {
        this.f13161A.setIcon(i4);
        return this;
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
}
