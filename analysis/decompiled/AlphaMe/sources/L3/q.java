package L3;

import K.AbstractC0072d;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class q extends e implements MenuItem {

    /* renamed from: e, reason: collision with root package name */
    public Method f1336e;

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return ((F.b) this.f825b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return ((F.b) this.f825b).expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        AbstractC0072d abstractC0072dA = ((F.b) this.f825b).a();
        if (abstractC0072dA instanceof m) {
            return ((m) abstractC0072dA).f1331a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = ((F.b) this.f825b).getActionView();
        return actionView instanceof n ? (View) ((n) actionView).f1333a : actionView;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return ((F.b) this.f825b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return ((F.b) this.f825b).getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return ((F.b) this.f825b).getIcon();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return ((F.b) this.f825b).getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return ((F.b) this.f825b).getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((F.b) this.f825b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return ((F.b) this.f825b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return ((F.b) this.f825b).getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return ((F.b) this.f825b).getSubMenu();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return ((F.b) this.f825b).getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return ((F.b) this.f825b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return ((F.b) this.f825b).hasSubMenu();
    }

    public abstract m i(ActionProvider actionProvider);

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return ((F.b) this.f825b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return ((F.b) this.f825b).isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return ((F.b) this.f825b).isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return ((F.b) this.f825b).isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return ((F.b) this.f825b).isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        ((F.b) this.f825b).b(actionProvider != null ? i(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new n(view);
        }
        ((F.b) this.f825b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        ((F.b) this.f825b).setAlphabeticShortcut(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        ((F.b) this.f825b).setCheckable(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        ((F.b) this.f825b).setChecked(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        ((F.b) this.f825b).setEnabled(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        ((F.b) this.f825b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        ((F.b) this.f825b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        ((F.b) this.f825b).setNumericShortcut(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((F.b) this.f825b).setOnActionExpandListener(onActionExpandListener != null ? new o(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((F.b) this.f825b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new p(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        ((F.b) this.f825b).setShortcut(c4, c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
        ((F.b) this.f825b).setShowAsAction(i4);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        ((F.b) this.f825b).setShowAsActionFlags(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        ((F.b) this.f825b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        ((F.b) this.f825b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        return ((F.b) this.f825b).setVisible(z4);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        ((F.b) this.f825b).setIcon(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        ((F.b) this.f825b).setTitle(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        ((F.b) this.f825b).setActionView(i4);
        View actionView = ((F.b) this.f825b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((F.b) this.f825b).setActionView(new n(actionView));
        }
        return this;
    }
}
