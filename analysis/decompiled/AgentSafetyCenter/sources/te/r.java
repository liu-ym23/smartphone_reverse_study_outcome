package te;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class r extends e implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public Method f13393d;

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return ((h3.b) this.f13336a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return ((h3.b) this.f13336a).expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        n3.d dVarA = ((h3.b) this.f13336a).a();
        if (dVarA instanceof q) {
            return ((q) dVarA).f13391a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = ((h3.b) this.f13336a).getActionView();
        return actionView instanceof n ? (View) ((n) actionView).f13388c : actionView;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return ((h3.b) this.f13336a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return ((h3.b) this.f13336a).getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return ((h3.b) this.f13336a).getIcon();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return ((h3.b) this.f13336a).getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return ((h3.b) this.f13336a).getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((h3.b) this.f13336a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return ((h3.b) this.f13336a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return ((h3.b) this.f13336a).getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return ((h3.b) this.f13336a).getSubMenu();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return ((h3.b) this.f13336a).getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return ((h3.b) this.f13336a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return ((h3.b) this.f13336a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return ((h3.b) this.f13336a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return ((h3.b) this.f13336a).isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return ((h3.b) this.f13336a).isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return ((h3.b) this.f13336a).isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return ((h3.b) this.f13336a).isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        q qVar;
        h3.b bVar = (h3.b) this.f13336a;
        if (actionProvider != null) {
            qVar = new q();
            qVar.f13391a = actionProvider;
            VarHandle.storeStoreFence();
        } else {
            qVar = null;
        }
        bVar.b(qVar);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        Object obj = this.f13336a;
        ((h3.b) obj).setActionView(i);
        View actionView = ((h3.b) obj).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((h3.b) obj).setActionView(new n(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        ((h3.b) this.f13336a).setAlphabeticShortcut(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        ((h3.b) this.f13336a).setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        ((h3.b) this.f13336a).setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        ((h3.b) this.f13336a).setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        ((h3.b) this.f13336a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        ((h3.b) this.f13336a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        ((h3.b) this.f13336a).setNumericShortcut(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((h3.b) this.f13336a).setOnActionExpandListener(onActionExpandListener != null ? new o(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((h3.b) this.f13336a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new p(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        ((h3.b) this.f13336a).setShortcut(c9, c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        ((h3.b) this.f13336a).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        ((h3.b) this.f13336a).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        ((h3.b) this.f13336a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        ((h3.b) this.f13336a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        return ((h3.b) this.f13336a).setVisible(z10);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        ((h3.b) this.f13336a).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        ((h3.b) this.f13336a).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new n(view);
        }
        ((h3.b) this.f13336a).setActionView(view);
        return this;
    }
}
