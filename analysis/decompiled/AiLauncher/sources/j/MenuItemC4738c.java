package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.AbstractC1314b;
import i.InterfaceC4157c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import v0.InterfaceMenuItemC5651b;

/* renamed from: j.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class MenuItemC4738c extends AbstractC4737b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceMenuItemC5651b f34413d;

    /* renamed from: e, reason: collision with root package name */
    public Method f34414e;

    /* renamed from: j.c$a */
    public class a extends AbstractC1314b implements ActionProvider.VisibilityListener {

        /* renamed from: d, reason: collision with root package name */
        public AbstractC1314b.InterfaceC0160b f34415d;

        /* renamed from: e, reason: collision with root package name */
        public final ActionProvider f34416e;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f34416e = actionProvider;
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean a() {
            return this.f34416e.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean b() {
            return this.f34416e.isVisible();
        }

        @Override // androidx.core.view.AbstractC1314b
        public View c() {
            return this.f34416e.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC1314b
        public View d(MenuItem menuItem) {
            return this.f34416e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean e() {
            return this.f34416e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC1314b
        public void f(SubMenu subMenu) {
            this.f34416e.onPrepareSubMenu(MenuItemC4738c.this.d(subMenu));
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean g() {
            return this.f34416e.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC1314b
        public void j(AbstractC1314b.InterfaceC0160b interfaceC0160b) {
            this.f34415d = interfaceC0160b;
            ActionProvider actionProvider = this.f34416e;
            if (interfaceC0160b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            AbstractC1314b.InterfaceC0160b interfaceC0160b = this.f34415d;
            if (interfaceC0160b != null) {
                interfaceC0160b.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    /* renamed from: j.c$b */
    public static class b extends FrameLayout implements InterfaceC4157c {

        /* renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f34418a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view) {
            super(view.getContext());
            this.f34418a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f34418a;
        }

        @Override // i.InterfaceC4157c
        public void onActionViewCollapsed() {
            this.f34418a.onActionViewCollapsed();
        }

        @Override // i.InterfaceC4157c
        public void onActionViewExpanded() {
            this.f34418a.onActionViewExpanded();
        }
    }

    /* renamed from: j.c$c, reason: collision with other inner class name */
    public class MenuItemOnActionExpandListenerC0421c implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f34419a;

        public MenuItemOnActionExpandListenerC0421c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f34419a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f34419a.onMenuItemActionCollapse(MenuItemC4738c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f34419a.onMenuItemActionExpand(MenuItemC4738c.this.c(menuItem));
        }
    }

    /* renamed from: j.c$d */
    public class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f34421a;

        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f34421a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f34421a.onMenuItemClick(MenuItemC4738c.this.c(menuItem));
        }
    }

    public MenuItemC4738c(Context context, InterfaceMenuItemC5651b interfaceMenuItemC5651b) {
        super(context);
        if (interfaceMenuItemC5651b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f34413d = interfaceMenuItemC5651b;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f34413d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f34413d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC1314b abstractC1314bA = this.f34413d.a();
        if (abstractC1314bA instanceof a) {
            return ((a) abstractC1314bA).f34416e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f34413d.getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f34413d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f34413d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f34413d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f34413d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f34413d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f34413d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f34413d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f34413d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f34413d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f34413d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f34413d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f34413d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f34413d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f34413d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f34413d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f34413d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f34413d.getTooltipText();
    }

    public void h(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f34414e == null) {
                this.f34414e = this.f34413d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f34414e.invoke(this.f34413d, Boolean.valueOf(z10));
        } catch (Exception e10) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f34413d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f34413d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f34413d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f34413d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f34413d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f34413d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        a aVar = new a(this.f34410a, actionProvider);
        InterfaceMenuItemC5651b interfaceMenuItemC5651b = this.f34413d;
        if (actionProvider == null) {
            aVar = null;
        }
        interfaceMenuItemC5651b.b(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f34413d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f34413d.setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f34413d.setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f34413d.setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f34413d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f34413d.setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f34413d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f34413d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f34413d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f34413d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f34413d.setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f34413d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0421c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f34413d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f34413d.setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        this.f34413d.setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        this.f34413d.setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f34413d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f34413d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f34413d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return this.f34413d.setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f34413d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f34413d.setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f34413d.setNumericShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f34413d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f34413d.setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        this.f34413d.setActionView(i10);
        View actionView = this.f34413d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f34413d.setActionView(new b(actionView));
        }
        return this;
    }
}
