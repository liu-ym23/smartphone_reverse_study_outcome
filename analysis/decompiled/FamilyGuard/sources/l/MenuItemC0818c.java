package l;

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
import androidx.core.view.AbstractC0457b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: l.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class MenuItemC0818c extends AbstractC0817b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    private final A.b f18004d;

    /* renamed from: e, reason: collision with root package name */
    private Method f18005e;

    /* renamed from: l.c$a */
    private class a extends AbstractC0457b implements ActionProvider.VisibilityListener {

        /* renamed from: d, reason: collision with root package name */
        private AbstractC0457b.InterfaceC0123b f18006d;

        /* renamed from: e, reason: collision with root package name */
        private final ActionProvider f18007e;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f18007e = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean a() {
            return this.f18007e.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean b() {
            return this.f18007e.isVisible();
        }

        @Override // androidx.core.view.AbstractC0457b
        public View c() {
            return this.f18007e.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC0457b
        public View d(MenuItem menuItem) {
            return this.f18007e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean e() {
            return this.f18007e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0457b
        public void f(SubMenu subMenu) {
            this.f18007e.onPrepareSubMenu(MenuItemC0818c.this.d(subMenu));
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean g() {
            return this.f18007e.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0457b
        public void j(AbstractC0457b.InterfaceC0123b interfaceC0123b) {
            this.f18006d = interfaceC0123b;
            ActionProvider actionProvider = this.f18007e;
            if (interfaceC0123b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z5) {
            AbstractC0457b.InterfaceC0123b interfaceC0123b = this.f18006d;
            if (interfaceC0123b != null) {
                interfaceC0123b.onActionProviderVisibilityChanged(z5);
            }
        }
    }

    /* renamed from: l.c$b */
    static class b extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f18009a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f18009a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f18009a;
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewCollapsed() {
            this.f18009a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewExpanded() {
            this.f18009a.onActionViewExpanded();
        }
    }

    /* renamed from: l.c$c, reason: collision with other inner class name */
    private class MenuItemOnActionExpandListenerC0224c implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f18010a;

        MenuItemOnActionExpandListenerC0224c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f18010a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f18010a.onMenuItemActionCollapse(MenuItemC0818c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f18010a.onMenuItemActionExpand(MenuItemC0818c.this.c(menuItem));
        }
    }

    /* renamed from: l.c$d */
    private class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f18012a;

        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f18012a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f18012a.onMenuItemClick(MenuItemC0818c.this.c(menuItem));
        }
    }

    public MenuItemC0818c(Context context, A.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f18004d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f18004d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f18004d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0457b abstractC0457bB = this.f18004d.b();
        if (abstractC0457bB instanceof a) {
            return ((a) abstractC0457bB).f18007e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f18004d.getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f18004d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f18004d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f18004d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f18004d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f18004d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f18004d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f18004d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f18004d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f18004d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f18004d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f18004d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f18004d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f18004d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f18004d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f18004d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f18004d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f18004d.getTooltipText();
    }

    public void h(boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f18005e == null) {
                this.f18005e = this.f18004d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f18005e.invoke(this.f18004d, Boolean.valueOf(z5));
        } catch (Exception e6) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e6);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f18004d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f18004d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f18004d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f18004d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f18004d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f18004d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        a aVar = new a(this.f18001a, actionProvider);
        A.b bVar = this.f18004d;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f18004d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        this.f18004d.setAlphabeticShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        this.f18004d.setCheckable(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        this.f18004d.setChecked(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f18004d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f18004d.setEnabled(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f18004d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f18004d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f18004d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f18004d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        this.f18004d.setNumericShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f18004d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0224c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f18004d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f18004d.setShortcut(c6, c7);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i5) {
        this.f18004d.setShowAsAction(i5);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i5) {
        this.f18004d.setShowAsActionFlags(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f18004d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f18004d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f18004d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        return this.f18004d.setVisible(z5);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i5) {
        this.f18004d.setAlphabeticShortcut(c6, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        this.f18004d.setIcon(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i5) {
        this.f18004d.setNumericShortcut(c6, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i5, int i6) {
        this.f18004d.setShortcut(c6, c7, i5, i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        this.f18004d.setTitle(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i5) {
        this.f18004d.setActionView(i5);
        View actionView = this.f18004d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f18004d.setActionView(new b(actionView));
        }
        return this;
    }
}
