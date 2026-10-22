package stepos.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import io.ktor.sse.ServerSentEventKt;
import stepos.support.v7.view.menu.c;

/* loaded from: classes5.dex */
public class i extends c implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    public e f41024A;

    /* renamed from: z, reason: collision with root package name */
    public c f41025z;

    public i(Context context, c cVar, e eVar) {
        super(context);
        this.f41025z = cVar;
        this.f41024A = eVar;
    }

    @Override // stepos.support.v7.view.menu.c
    public c D() {
        return this.f41025z;
    }

    @Override // stepos.support.v7.view.menu.c
    public boolean F() {
        return this.f41025z.F();
    }

    @Override // stepos.support.v7.view.menu.c
    public boolean G() {
        return this.f41025z.G();
    }

    @Override // stepos.support.v7.view.menu.c
    public void Q(c.a aVar) {
        this.f41025z.Q(aVar);
    }

    public Menu c0() {
        return this.f41025z;
    }

    @Override // stepos.support.v7.view.menu.c
    public boolean f(e eVar) {
        return this.f41025z.f(eVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f41024A;
    }

    @Override // stepos.support.v7.view.menu.c
    public boolean h(c cVar, MenuItem menuItem) {
        return super.h(cVar, menuItem) || this.f41025z.h(cVar, menuItem);
    }

    @Override // stepos.support.v7.view.menu.c
    public boolean k(e eVar) {
        return this.f41025z.k(eVar);
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
        this.f41024A.setIcon(drawable);
        return this;
    }

    @Override // stepos.support.v7.view.menu.c, android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f41025z.setQwertyMode(z10);
    }

    @Override // stepos.support.v7.view.menu.c
    public String t() {
        e eVar = this.f41024A;
        int itemId = eVar != null ? eVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ServerSentEventKt.COLON + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        super.T(androidx.core.content.a.e(u(), i10));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        super.V(u().getResources().getString(i10));
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f41024A.setIcon(i10);
        return this;
    }
}
