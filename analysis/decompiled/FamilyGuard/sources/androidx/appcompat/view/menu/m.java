package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

/* loaded from: classes.dex */
public class m extends e implements SubMenu {

    /* renamed from: B, reason: collision with root package name */
    private e f7975B;

    /* renamed from: C, reason: collision with root package name */
    private g f7976C;

    public m(Context context, e eVar, g gVar) {
        super(context);
        this.f7975B = eVar;
        this.f7976C = gVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public e D() {
        return this.f7975B.D();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean G() {
        return this.f7975B.G();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean H() {
        return this.f7975B.H();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean I() {
        return this.f7975B.I();
    }

    @Override // androidx.appcompat.view.menu.e
    public void S(e.a aVar) {
        this.f7975B.S(aVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean f(g gVar) {
        return this.f7975B.f(gVar);
    }

    public Menu f0() {
        return this.f7975B;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f7976C;
    }

    @Override // androidx.appcompat.view.menu.e
    boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.f7975B.h(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean k(g gVar) {
        return this.f7975B.k(gVar);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
        this.f7975B.setGroupDividerEnabled(z5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.W(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.Z(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f7976C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f7975B.setQwertyMode(z5);
    }

    @Override // androidx.appcompat.view.menu.e
    public String t() {
        g gVar = this.f7976C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i5) {
        return (SubMenu) super.V(i5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i5) {
        return (SubMenu) super.Y(i5);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i5) {
        this.f7976C.setIcon(i5);
        return this;
    }
}
