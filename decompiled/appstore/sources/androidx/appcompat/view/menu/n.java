package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
public class n extends k implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SupportSubMenu f643e;

    public n(Context r10, SupportSubMenu r11) {
        super(r10, r11);
        this.f643e = r11;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f643e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return a(this.f643e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r10) {
        this.f643e.setHeaderIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r10) {
        this.f643e.setHeaderTitle(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r10) {
        this.f643e.setHeaderView(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r10) {
        this.f643e.setIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r10) {
        this.f643e.setHeaderIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r10) {
        this.f643e.setHeaderTitle(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r10) {
        this.f643e.setIcon(r10);
        return this;
    }
}
