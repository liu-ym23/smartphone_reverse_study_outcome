package Va;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes4.dex */
public final class G extends E implements SubMenu {
    @Override // android.view.SubMenu
    public final void clearHeader() {
        ((SupportSubMenu) this.f160a).clearHeader();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return P0(((SupportSubMenu) this.f160a).getItem());
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        ((SupportSubMenu) this.f160a).setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        ((SupportSubMenu) this.f160a).setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        ((SupportSubMenu) this.f160a).setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        ((SupportSubMenu) this.f160a).setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        ((SupportSubMenu) this.f160a).setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        ((SupportSubMenu) this.f160a).setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        ((SupportSubMenu) this.f160a).setIcon(drawable);
        return this;
    }
}
