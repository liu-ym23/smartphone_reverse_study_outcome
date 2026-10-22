package Jc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import v0.InterfaceSubMenuC5652c;

/* loaded from: classes5.dex */
public class l extends k implements SubMenu {
    public l(Context context, InterfaceSubMenuC5652c interfaceSubMenuC5652c) {
        super(context, interfaceSubMenuC5652c);
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        h().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(h().getItem());
    }

    public InterfaceSubMenuC5652c h() {
        return (InterfaceSubMenuC5652c) this.f3841a;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        h().setHeaderIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        h().setHeaderTitle(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        h().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        h().setIcon(i10);
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
