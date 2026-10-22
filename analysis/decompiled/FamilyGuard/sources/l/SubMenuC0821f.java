package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: l.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class SubMenuC0821f extends MenuC0819d implements SubMenu {

    /* renamed from: e, reason: collision with root package name */
    private final A.c f18015e;

    SubMenuC0821f(Context context, A.c cVar) {
        super(context, cVar);
        this.f18015e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f18015e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f18015e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i5) {
        this.f18015e.setHeaderIcon(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i5) {
        this.f18015e.setHeaderTitle(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f18015e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i5) {
        this.f18015e.setIcon(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f18015e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f18015e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f18015e.setIcon(drawable);
        return this;
    }
}
