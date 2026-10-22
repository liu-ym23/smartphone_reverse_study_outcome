package c5;

import android.content.Context;
import android.content.Intent;
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

/* loaded from: classes.dex */
public class g extends c5.c<A.b> implements MenuItem {

    /* renamed from: e, reason: collision with root package name */
    private Method f12008e;

    class a extends AbstractC0457b {

        /* renamed from: d, reason: collision with root package name */
        final ActionProvider f12009d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f12009d = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean a() {
            return this.f12009d.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0457b
        public View c() {
            return this.f12009d.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean e() {
            return this.f12009d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0457b
        public void f(SubMenu subMenu) {
            this.f12009d.onPrepareSubMenu(g.this.d(subMenu));
        }
    }

    static class b extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f12011a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f12011a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f12011a;
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewCollapsed() {
            this.f12011a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewExpanded() {
            this.f12011a.onActionViewExpanded();
        }
    }

    private class c extends c5.d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f12007a).onMenuItemActionCollapse(g.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f12007a).onMenuItemActionExpand(g.this.c(menuItem));
        }
    }

    private class d extends c5.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f12007a).onMenuItemClick(g.this.c(menuItem));
        }
    }

    g(Context context, A.b bVar) {
        super(context, bVar);
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((A.b) this.f12007a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((A.b) this.f12007a).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0457b abstractC0457bB = ((A.b) this.f12007a).b();
        if (abstractC0457bB instanceof a) {
            return ((a) abstractC0457bB).f12009d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((A.b) this.f12007a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((A.b) this.f12007a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((A.b) this.f12007a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((A.b) this.f12007a).getIcon();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((A.b) this.f12007a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((A.b) this.f12007a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((A.b) this.f12007a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((A.b) this.f12007a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((A.b) this.f12007a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(((A.b) this.f12007a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((A.b) this.f12007a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((A.b) this.f12007a).getTitleCondensed();
    }

    a h(ActionProvider actionProvider) {
        return new a(this.f12004b, actionProvider);
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((A.b) this.f12007a).hasSubMenu();
    }

    public void i(boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f12008e == null) {
                this.f12008e = ((A.b) this.f12007a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f12008e.invoke(this.f12007a, Boolean.valueOf(z5));
        } catch (Exception e6) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e6);
        }
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((A.b) this.f12007a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((A.b) this.f12007a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((A.b) this.f12007a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((A.b) this.f12007a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((A.b) this.f12007a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((A.b) this.f12007a).a(actionProvider != null ? h(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((A.b) this.f12007a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        ((A.b) this.f12007a).setAlphabeticShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        ((A.b) this.f12007a).setCheckable(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        ((A.b) this.f12007a).setChecked(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        ((A.b) this.f12007a).setEnabled(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((A.b) this.f12007a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((A.b) this.f12007a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        ((A.b) this.f12007a).setNumericShortcut(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((A.b) this.f12007a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((A.b) this.f12007a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        ((A.b) this.f12007a).setShortcut(c6, c7);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i5) {
        ((A.b) this.f12007a).setShowAsAction(i5);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i5) {
        ((A.b) this.f12007a).setShowAsActionFlags(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((A.b) this.f12007a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((A.b) this.f12007a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        return ((A.b) this.f12007a).setVisible(z5);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        ((A.b) this.f12007a).setIcon(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        ((A.b) this.f12007a).setTitle(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i5) {
        ((A.b) this.f12007a).setActionView(i5);
        View actionView = ((A.b) this.f12007a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((A.b) this.f12007a).setActionView(new b(actionView));
        }
        return this;
    }
}
