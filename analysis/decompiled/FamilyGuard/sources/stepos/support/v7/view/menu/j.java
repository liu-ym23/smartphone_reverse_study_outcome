package stepos.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import stepos.support.v7.view.menu.d;

/* loaded from: classes.dex */
public class j extends d implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    private f f21366A;

    /* renamed from: z, reason: collision with root package name */
    private d f21367z;

    public j(Context context, d dVar, f fVar) {
        super(context);
        this.f21367z = dVar;
        this.f21366A = fVar;
    }

    @Override // stepos.support.v7.view.menu.d
    public d D() {
        return this.f21367z;
    }

    @Override // stepos.support.v7.view.menu.d
    public boolean F() {
        return this.f21367z.F();
    }

    @Override // stepos.support.v7.view.menu.d
    public boolean G() {
        return this.f21367z.G();
    }

    @Override // stepos.support.v7.view.menu.d
    public void Q(d.a aVar) {
        this.f21367z.Q(aVar);
    }

    public Menu c0() {
        return this.f21367z;
    }

    @Override // stepos.support.v7.view.menu.d
    public boolean f(f fVar) {
        return this.f21367z.f(fVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f21366A;
    }

    @Override // stepos.support.v7.view.menu.d
    boolean h(d dVar, MenuItem menuItem) {
        return super.h(dVar, menuItem) || this.f21367z.h(dVar, menuItem);
    }

    @Override // stepos.support.v7.view.menu.d
    public boolean k(f fVar) {
        return this.f21367z.k(fVar);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.T(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.V(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.W(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f21366A.setIcon(drawable);
        return this;
    }

    @Override // stepos.support.v7.view.menu.d, android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f21367z.setQwertyMode(z5);
    }

    @Override // stepos.support.v7.view.menu.d
    public String t() {
        f fVar = this.f21366A;
        int itemId = fVar != null ? fVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i5) {
        super.T(androidx.core.content.a.e(u(), i5));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i5) {
        super.V(u().getResources().getString(i5));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i5) {
        this.f21366A.setIcon(i5);
        return this;
    }
}
