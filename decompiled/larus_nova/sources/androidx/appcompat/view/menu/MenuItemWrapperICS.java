package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    public class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider mInner;
        final /* synthetic */ MenuItemWrapperICS this$0;

        @Override // androidx.core.view.ActionProvider
        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu r100) {
            this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(r100));
        }

        public ActionProviderWrapper(MenuItemWrapperICS r100, Context r101, android.view.ActionProvider r102) {
            this.this$0 = r100;
            super(r101);
            this.mInner = r102;
        }
    }

    public class ActionProviderWrapperJB extends ActionProviderWrapper implements android.view.ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener mListener;
        final /* synthetic */ MenuItemWrapperICS this$0;

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r100) {
            ActionProvider.VisibilityListener r101 = this.mListener;
            if (r101 == null) goto L6;
            r101.onActionProviderVisibilityChanged(r100);
            return;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem r100) {
            return this.mInner.onCreateActionView(r100);
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener r100) {
            this.mListener = r100;
            android.view.ActionProvider r101 = this.mInner;
            if (r100 == null) goto L5;
            ActionProviderWrapperJB r102 = this;
        L6:
            r101.setVisibilityListener(r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        public ActionProviderWrapperJB(MenuItemWrapperICS r100, Context r101, android.view.ActionProvider r102) {
            this.this$0 = r100;
            super(r100, r101, r102);
        }
    }

    public static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        public View getWrappedView() {
            return (View) this.mWrappedView;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CollapsibleActionViewWrapper(View r100) {
            super(r100.getContext());
            this.mWrappedView = (android.view.CollapsibleActionView) r100;
            addView(r100);
        }
    }

    public class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem r100) {
            return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(r100));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem r100) {
            return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(r100));
        }

        public OnActionExpandListenerWrapper(MenuItemWrapperICS r100, MenuItem.OnActionExpandListener r101) {
            this.this$0 = r100;
            this.mObject = r101;
        }
    }

    public class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;
        final /* synthetic */ MenuItemWrapperICS this$0;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r100) {
            return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(r100));
        }

        public OnMenuItemClickListenerWrapper(MenuItemWrapperICS r100, MenuItem.OnMenuItemClickListener r101) {
            this.this$0 = r100;
            this.mObject = r101;
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        ActionProvider r100 = this.mWrappedObject.getSupportActionProvider();
        if ((r100 instanceof ActionProviderWrapper) == true) goto L5;
        return null;
    L5:
        return ((ActionProviderWrapper) r100).mInner;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View r100 = this.mWrappedObject.getActionView();
        if ((r100 instanceof CollapsibleActionViewWrapper) == true) goto L5;
        return r100;
    L5:
        return ((CollapsibleActionViewWrapper) r100).getWrappedView();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r100) {
        ActionProviderWrapperJB r101 = new ActionProviderWrapperJB(this, this.mContext, r100);
        SupportMenuItem r102 = this.mWrappedObject;
        if (r100 != null) goto L6;
        r101 = null;
    L6:
        r102.setSupportActionProvider(r101);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int r100) {
        this.mWrappedObject.setActionView(r100);
        View r101 = this.mWrappedObject.getActionView();
        if ((r101 instanceof android.view.CollapsibleActionView) == false) goto L5;
        this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(r101));
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r100) {
        this.mWrappedObject.setAlphabeticShortcut(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r100) {
        this.mWrappedObject.setCheckable(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r100) {
        this.mWrappedObject.setChecked(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence r100) {
        this.mWrappedObject.setContentDescription(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r100) {
        this.mWrappedObject.setEnabled(r100);
        return this;
    }

    public void setExclusiveCheckable(boolean r100) {
        if (this.mSetExclusiveCheckableMethod != null) goto L5;
        this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
    L5:
        this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L7
        return;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r100) {
        this.mWrappedObject.setIcon(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r100) {
        this.mWrappedObject.setIconTintList(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r100) {
        this.mWrappedObject.setIconTintMode(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r100) {
        this.mWrappedObject.setIntent(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r100) {
        this.mWrappedObject.setNumericShortcut(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r100) {
        SupportMenuItem r101 = this.mWrappedObject;
        if (r100 == null) goto L5;
        OnActionExpandListenerWrapper r102 = new OnActionExpandListenerWrapper(this, r100);
    L6:
        r101.setOnActionExpandListener(r102);
        return this;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r100) {
        SupportMenuItem r101 = this.mWrappedObject;
        if (r100 == null) goto L5;
        OnMenuItemClickListenerWrapper r102 = new OnMenuItemClickListenerWrapper(this, r100);
    L6:
        r101.setOnMenuItemClickListener(r102);
        return this;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int r100) {
        this.mWrappedObject.setShowAsAction(r100);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int r100) {
        this.mWrappedObject.setShowAsActionFlags(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r100) {
        this.mWrappedObject.setTitle(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r100) {
        this.mWrappedObject.setTitleCondensed(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence r100) {
        this.mWrappedObject.setTooltipText(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r100) {
        return this.mWrappedObject.setVisible(r100);
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View r100) {
        if ((r100 instanceof android.view.CollapsibleActionView) == false) goto L5;
        r100 = new CollapsibleActionViewWrapper(r100);
    L5:
        this.mWrappedObject.setActionView(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r100) {
        this.mWrappedObject.setIcon(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r100) {
        this.mWrappedObject.setTitle(r100);
        return this;
    }

    public MenuItemWrapperICS(Context r100, SupportMenuItem r101) {
        super(r100);
        if (r101 == null) goto L7;
        this.mWrappedObject = r101;
        return;
    L7:
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r100, int r101) {
        this.mWrappedObject.setAlphabeticShortcut(r100, r101);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r100, int r101) {
        this.mWrappedObject.setNumericShortcut(r100, r101);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101) {
        this.mWrappedObject.setShortcut(r100, r101);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101, int r102, int r103) {
        this.mWrappedObject.setShortcut(r100, r101, r102, r103);
        return this;
    }
}
