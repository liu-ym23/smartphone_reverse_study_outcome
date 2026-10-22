package Jc;

import android.annotation.TargetApi;
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
import androidx.core.view.AbstractC1314b;
import i.InterfaceC4157c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import v0.InterfaceMenuItemC5651b;

@TargetApi(14)
/* loaded from: classes5.dex */
public class h extends Jc.d<InterfaceMenuItemC5651b> implements MenuItem {

    /* renamed from: e, reason: collision with root package name */
    public Method f3842e;

    public class a extends AbstractC1314b {

        /* renamed from: d, reason: collision with root package name */
        public final ActionProvider f3843d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f3843d = actionProvider;
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean a() {
            return this.f3843d.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC1314b
        public View c() {
            return this.f3843d.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean e() {
            return this.f3843d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC1314b
        public void f(SubMenu subMenu) {
            this.f3843d.onPrepareSubMenu(h.this.d(subMenu));
        }
    }

    public static class b extends FrameLayout implements InterfaceC4157c {

        /* renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f3845a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view) {
            super(view.getContext());
            this.f3845a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f3845a;
        }

        @Override // i.InterfaceC4157c
        public void onActionViewCollapsed() {
            this.f3845a.onActionViewCollapsed();
        }

        @Override // i.InterfaceC4157c
        public void onActionViewExpanded() {
            this.f3845a.onActionViewExpanded();
        }
    }

    public class c extends e<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        public c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f3841a).onMenuItemActionCollapse(h.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f3841a).onMenuItemActionExpand(h.this.c(menuItem));
        }
    }

    public class d extends e<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f3841a).onMenuItemClick(h.this.c(menuItem));
        }
    }

    public h(Context context, InterfaceMenuItemC5651b interfaceMenuItemC5651b) {
        super(context, interfaceMenuItemC5651b);
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((InterfaceMenuItemC5651b) this.f3841a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((InterfaceMenuItemC5651b) this.f3841a).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC1314b abstractC1314bA = ((InterfaceMenuItemC5651b) this.f3841a).a();
        if (abstractC1314bA instanceof a) {
            return ((a) abstractC1314bA).f3843d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((InterfaceMenuItemC5651b) this.f3841a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getIcon();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(((InterfaceMenuItemC5651b) this.f3841a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((InterfaceMenuItemC5651b) this.f3841a).getTitleCondensed();
    }

    public a h(ActionProvider actionProvider) {
        return new a(this.f3838b, actionProvider);
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((InterfaceMenuItemC5651b) this.f3841a).hasSubMenu();
    }

    public void i(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f3842e == null) {
                this.f3842e = ((InterfaceMenuItemC5651b) this.f3841a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f3842e.invoke(this.f3841a, Boolean.valueOf(z10));
        } catch (Exception e10) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
        }
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((InterfaceMenuItemC5651b) this.f3841a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((InterfaceMenuItemC5651b) this.f3841a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((InterfaceMenuItemC5651b) this.f3841a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((InterfaceMenuItemC5651b) this.f3841a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((InterfaceMenuItemC5651b) this.f3841a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((InterfaceMenuItemC5651b) this.f3841a).b(actionProvider != null ? h(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((InterfaceMenuItemC5651b) this.f3841a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((InterfaceMenuItemC5651b) this.f3841a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((InterfaceMenuItemC5651b) this.f3841a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((InterfaceMenuItemC5651b) this.f3841a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((InterfaceMenuItemC5651b) this.f3841a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        ((InterfaceMenuItemC5651b) this.f3841a).setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((InterfaceMenuItemC5651b) this.f3841a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((InterfaceMenuItemC5651b) this.f3841a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return ((InterfaceMenuItemC5651b) this.f3841a).setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        ((InterfaceMenuItemC5651b) this.f3841a).setActionView(i10);
        View actionView = ((InterfaceMenuItemC5651b) this.f3841a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((InterfaceMenuItemC5651b) this.f3841a).setActionView(new b(actionView));
        }
        return this;
    }
}
