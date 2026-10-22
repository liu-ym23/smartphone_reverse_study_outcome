package Va;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class v extends AbstractC0269g implements MenuItem {
    public Method e;

    public abstract r R0(ActionProvider actionProvider);

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return ((SupportMenuItem) this.f160a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return ((SupportMenuItem) this.f160a).expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = ((SupportMenuItem) this.f160a).getSupportActionProvider();
        if (supportActionProvider instanceof r) {
            return ((r) supportActionProvider).f1463a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = ((SupportMenuItem) this.f160a).getActionView();
        return actionView instanceof s ? (View) ((s) actionView).f1464a : actionView;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.f160a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return ((SupportMenuItem) this.f160a).getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return ((SupportMenuItem) this.f160a).getIcon();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return ((SupportMenuItem) this.f160a).getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return ((SupportMenuItem) this.f160a).getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.f160a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return ((SupportMenuItem) this.f160a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return ((SupportMenuItem) this.f160a).getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return Q0(((SupportMenuItem) this.f160a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return ((SupportMenuItem) this.f160a).getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.f160a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return ((SupportMenuItem) this.f160a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.f160a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return ((SupportMenuItem) this.f160a).isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return ((SupportMenuItem) this.f160a).isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return ((SupportMenuItem) this.f160a).isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return ((SupportMenuItem) this.f160a).isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        ((SupportMenuItem) this.f160a).setSupportActionProvider(actionProvider != null ? R0(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new s(view);
        }
        ((SupportMenuItem) this.f160a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.f160a).setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        ((SupportMenuItem) this.f160a).setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        ((SupportMenuItem) this.f160a).setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        ((SupportMenuItem) this.f160a).setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.f160a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.f160a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.f160a).setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.f160a).setOnActionExpandListener(onActionExpandListener != null ? new t(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.f160a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new u(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.f160a).setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        ((SupportMenuItem) this.f160a).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.f160a).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.f160a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.f160a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        return ((SupportMenuItem) this.f160a).setVisible(z10);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        ((SupportMenuItem) this.f160a).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        ((SupportMenuItem) this.f160a).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        Object obj = this.f160a;
        ((SupportMenuItem) obj).setActionView(i);
        View actionView = ((SupportMenuItem) obj).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) obj).setActionView(new s(actionView));
        }
        return this;
    }
}
