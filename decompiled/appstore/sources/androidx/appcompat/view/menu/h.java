package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.appcompat.view.menu.c implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SupportMenuItem f594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f595e;

    public class a extends ActionProvider {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final android.view.ActionProvider f596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f597e;

        public a(h r10, Context r11, android.view.ActionProvider r12) {
            this.f597e = r10;
            super(r11);
            this.f596d = r12;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean a() {
            return this.f596d.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean d() {
            return this.f596d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void e(SubMenu r10) {
            this.f596d.onPrepareSubMenu(this.f597e.b(r10));
        }
    }

    public class b extends a implements android.view.ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ActionProvider.VisibilityListener f598f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h f599g;

        public b(h r10, Context r11, android.view.ActionProvider r12) {
            this.f599g = r10;
            super(r10, r11, r12);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean b() {
            return this.f596d.isVisible();
        }

        @Override // androidx.core.view.ActionProvider
        public View c(MenuItem r10) {
            return this.f596d.onCreateActionView(r10);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean f() {
            return this.f596d.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void i(ActionProvider.VisibilityListener r10) {
            this.f598f = r10;
            android.view.ActionProvider r11 = this.f596d;
            if (r10 != null) goto L6;
            b this = null;
        L6:
            r11.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r10) {
            ActionProvider.VisibilityListener r11 = this.f598f;
            if (r11 == null) goto L6;
            r11.onActionProviderVisibilityChanged(r10);
            return;
        }
    }

    public static class c extends FrameLayout implements CollapsibleActionView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final android.view.CollapsibleActionView f600a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View r10) {
            super(r10.getContext());
            this.f600a = (android.view.CollapsibleActionView) r10;
            addView(r10);
        }

        public View a() {
            return (View) this.f600a;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.f600a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.f600a.onActionViewExpanded();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f602b;

        public d(h r10, MenuItem.OnActionExpandListener r11) {
            this.f602b = r10;
            this.f601a = r11;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem r10) {
            return this.f601a.onMenuItemActionCollapse(this.f602b.a(r10));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem r10) {
            return this.f601a.onMenuItemActionExpand(this.f602b.a(r10));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f604b;

        public e(h r10, MenuItem.OnMenuItemClickListener r11) {
            this.f604b = r10;
            this.f603a = r11;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
            return this.f603a.onMenuItemClick(this.f604b.a(r10));
        }
    }

    public h(Context r10, SupportMenuItem r11) {
        super(r10);
        if (r11 == null) goto L7;
        this.f594d = r11;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f594d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f594d.expandActionView();
    }

    public void f(boolean r10) {
    L5:
        e = move-exception;
        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        return;
    L3:
        if (this.f595e != null) goto L7;
        this.f595e = this.f594d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
    L7:
        this.f595e.invoke(this.f594d, new Object[]{Boolean.valueOf(r10)});     // Catch: Exception -> L5
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        ActionProvider r10 = this.f594d.getSupportActionProvider();
        if ((r10 instanceof a) == true) goto L5;
        return null;
    L5:
        return ((a) r10).f596d;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View r10 = this.f594d.getActionView();
        if ((r10 instanceof c) == true) goto L5;
        return r10;
    L5:
        return ((c) r10).a();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f594d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f594d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f594d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f594d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f594d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f594d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f594d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f594d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f594d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f594d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f594d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f594d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f594d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return b(this.f594d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f594d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f594d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f594d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f594d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f594d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f594d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f594d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f594d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f594d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r10) {
        b r11 = new b(this, this.f542a, r10);
        SupportMenuItem r12 = this.f594d;
        if (r10 != null) goto L6;
        r11 = null;
    L6:
        r12.setSupportActionProvider(r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View r10) {
        if ((r10 instanceof android.view.CollapsibleActionView) == false) goto L5;
        r10 = new c(r10);
    L5:
        this.f594d.setActionView(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        this.f594d.setAlphabeticShortcut(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        this.f594d.setCheckable(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        this.f594d.setChecked(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence r10) {
        this.f594d.setContentDescription(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        this.f594d.setEnabled(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.f594d.setIcon(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r10) {
        this.f594d.setIconTintList(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.f594d.setIconTintMode(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.f594d.setIntent(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        this.f594d.setNumericShortcut(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        SupportMenuItem r11 = this.f594d;
        if (r10 == null) goto L5;
        d r12 = new d(this, r10);
    L6:
        r11.setOnActionExpandListener(r12);
        return this;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r10) {
        SupportMenuItem r11 = this.f594d;
        if (r10 == null) goto L5;
        e r12 = new e(this, r10);
    L6:
        r11.setOnMenuItemClickListener(r12);
        return this;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11) {
        this.f594d.setShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int r10) {
        this.f594d.setShowAsAction(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int r10) {
        this.f594d.setShowAsActionFlags(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.f594d.setTitle(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.f594d.setTitleCondensed(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence r10) {
        this.f594d.setTooltipText(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        return this.f594d.setVisible(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        this.f594d.setAlphabeticShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.f594d.setIcon(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10, int r11) {
        this.f594d.setNumericShortcut(r10, r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.f594d.setShortcut(r10, r11, r12, r13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        this.f594d.setTitle(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int r10) {
        this.f594d.setActionView(r10);
        View r11 = this.f594d.getActionView();
        if ((r11 instanceof android.view.CollapsibleActionView) == false) goto L5;
        this.f594d.setActionView(new c(r11));
    L5:
        return this;
    }
}
