package c5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
class k extends j implements SubMenu {
    k(Context context, A.c cVar) {
        super(context, cVar);
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        h().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(h().getItem());
    }

    public A.c h() {
        return (A.c) this.f12007a;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i5) {
        h().setHeaderIcon(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i5) {
        h().setHeaderTitle(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        h().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i5) {
        h().setIcon(i5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        h().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        h().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        h().setIcon(drawable);
        return this;
    }
}
