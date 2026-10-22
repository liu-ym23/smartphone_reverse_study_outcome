package j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import v0.InterfaceSubMenuC5652c;

/* renamed from: j.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class SubMenuC4742g extends MenuC4740e implements SubMenu {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceSubMenuC5652c f34425e;

    public SubMenuC4742g(Context context, InterfaceSubMenuC5652c interfaceSubMenuC5652c) {
        super(context, interfaceSubMenuC5652c);
        this.f34425e = interfaceSubMenuC5652c;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f34425e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f34425e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        this.f34425e.setHeaderIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        this.f34425e.setHeaderTitle(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f34425e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f34425e.setIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f34425e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f34425e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f34425e.setIcon(drawable);
        return this;
    }
}
