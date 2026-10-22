package ge;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@TargetApi(14)
/* loaded from: classes.dex */
public class h extends ge.d<p0.b> implements MenuItem {

    /* renamed from: e, reason: collision with root package name */
    public Method f9168e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends v0.b {

        /* renamed from: b, reason: collision with root package name */
        public final ActionProvider f9169b;

        public a(ActionProvider actionProvider) {
            this.f9169b = actionProvider;
        }

        @Override // v0.b
        public final boolean a() {
            return this.f9169b.hasSubMenu();
        }

        @Override // v0.b
        public final View c() {
            return this.f9169b.onCreateActionView();
        }

        @Override // v0.b
        public final boolean e() {
            return this.f9169b.onPerformDefaultAction();
        }

        @Override // v0.b
        public final void f(SubMenu subMenu) {
            this.f9169b.onPrepareSubMenu(h.this.d(subMenu));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends FrameLayout implements k.b {

        /* renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f9171a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view) {
            super(view.getContext());
            this.f9171a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // k.b
        public final void onActionViewCollapsed() {
            this.f9171a.onActionViewCollapsed();
        }

        @Override // k.b
        public final void onActionViewExpanded() {
            this.f9171a.onActionViewExpanded();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends e implements MenuItem.OnActionExpandListener {
        public c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener, 0);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f9167a).onMenuItemActionCollapse(h.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f9167a).onMenuItemActionExpand(h.this.c(menuItem));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends e implements MenuItem.OnMenuItemClickListener {
        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener, 0);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f9167a).onMenuItemClick(h.this.c(menuItem));
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return ((p0.b) this.f9167a).collapseActionView();
    }

    public a e(ActionProvider actionProvider) {
        return new a(actionProvider);
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return ((p0.b) this.f9167a).expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        v0.b bVarB = ((p0.b) this.f9167a).b();
        if (bVarB instanceof a) {
            return ((a) bVarB).f9169b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = ((p0.b) this.f9167a).getActionView();
        return actionView instanceof b ? (View) ((b) actionView).f9171a : actionView;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return ((p0.b) this.f9167a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return ((p0.b) this.f9167a).getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return ((p0.b) this.f9167a).getIcon();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return ((p0.b) this.f9167a).getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return ((p0.b) this.f9167a).getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((p0.b) this.f9167a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return ((p0.b) this.f9167a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return ((p0.b) this.f9167a).getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return d(((p0.b) this.f9167a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return ((p0.b) this.f9167a).getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return ((p0.b) this.f9167a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return ((p0.b) this.f9167a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return ((p0.b) this.f9167a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return ((p0.b) this.f9167a).isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return ((p0.b) this.f9167a).isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return ((p0.b) this.f9167a).isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return ((p0.b) this.f9167a).isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        ((p0.b) this.f9167a).a(actionProvider != null ? e(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((p0.b) this.f9167a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        ((p0.b) this.f9167a).setAlphabeticShortcut(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        ((p0.b) this.f9167a).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        ((p0.b) this.f9167a).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        ((p0.b) this.f9167a).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        ((p0.b) this.f9167a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        ((p0.b) this.f9167a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        ((p0.b) this.f9167a).setNumericShortcut(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((p0.b) this.f9167a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((p0.b) this.f9167a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        ((p0.b) this.f9167a).setShortcut(c9, c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
        ((p0.b) this.f9167a).setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        ((p0.b) this.f9167a).setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        ((p0.b) this.f9167a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        ((p0.b) this.f9167a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        return ((p0.b) this.f9167a).setVisible(z);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        ((p0.b) this.f9167a).setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        ((p0.b) this.f9167a).setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        Object obj = this.f9167a;
        ((p0.b) obj).setActionView(i10);
        View actionView = ((p0.b) obj).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((p0.b) obj).setActionView(new b(actionView));
        }
        return this;
    }
}
