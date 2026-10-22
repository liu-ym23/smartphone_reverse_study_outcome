package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ToolbarActionBar extends ActionBar {
    final DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    final AppCompatDelegateImpl.ActionBarMenuCallback mMenuCallback;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    boolean mToolbarMenuPrepared;
    final Window.Callback mWindowCallback;

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;
        final /* synthetic */ ToolbarActionBar this$0;

        ActionMenuPresenterCallback(ToolbarActionBar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r2) {
            this.this$0.mWindowCallback.onMenuOpened(108, r2);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r2, boolean r3) {
            if (this.mClosingActionMenu == false) goto L5;
            return;
        L5:
            this.mClosingActionMenu = true;
            this.this$0.mDecorToolbar.dismissPopupMenus();
            this.this$0.mWindowCallback.onPanelClosed(108, r2);
            this.mClosingActionMenu = false;
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ToolbarActionBar this$0;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2) {
            return false;
        }

        MenuBuilderCallback(ToolbarActionBar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r5) {
            if (this.this$0.mDecorToolbar.isOverflowMenuShowing() == false) goto L6;
            this.this$0.mWindowCallback.onPanelClosed(108, r5);
            return;
        L6:
            if (this.this$0.mWindowCallback.onPreparePanel(0, null, r5) == false) goto L10;
            this.this$0.mWindowCallback.onMenuOpened(108, r5);
            return;
        }
    }

    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        final /* synthetic */ ToolbarActionBar this$0;

        ToolbarMenuCallback(ToolbarActionBar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean onPreparePanel(int r1) {
            if (r1 == 0) goto L4;
            return false;
        L4:
            if (this.this$0.mToolbarMenuPrepared == true) goto L9;
            this.this$0.mDecorToolbar.setMenuPrepared();
            this.this$0.mToolbarMenuPrepared = true;
            return false;
        L9:
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View onCreatePanelView(int r1) {
            if (r1 == 0) goto L4;
            return null;
        L4:
            return new View(this.this$0.mDecorToolbar.getContext());
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r1) {
    }

    ToolbarActionBar(Toolbar r4, CharSequence r5, Window.Callback r6) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new AnonymousClass1(this);
        Toolbar.OnMenuItemClickListener r0 = new AnonymousClass2(this);
        this.mMenuClicker = r0;
        Preconditions.checkNotNull(r4);
        ToolbarWidgetWrapper r1 = new ToolbarWidgetWrapper(r4, false);
        this.mDecorToolbar = r1;
        this.mWindowCallback = (Window.Callback) Preconditions.checkNotNull(r6);
        r1.setWindowCallback(r6);
        r4.setOnMenuItemClickListener(r0);
        r1.setWindowTitle(r5);
        this.mMenuCallback = new ToolbarMenuCallback(this);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r3) {
        setCustomView(r3, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r1, ActionBar.LayoutParams r2) {
        if (r1 == null) goto L4;
        r1.setLayoutParams(r2);
    L4:
        this.mDecorToolbar.setCustomView(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r4) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(r4, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r1) {
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r1) {
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r1) {
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r1) {
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r1) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r1) {
        this.mDecorToolbar.setNavigationIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r1) {
        this.mDecorToolbar.setNavigationIcon(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r1) {
        this.mDecorToolbar.setNavigationContentDescription(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r1) {
        this.mDecorToolbar.setNavigationContentDescription(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r2, ActionBar.OnNavigationListener r3) {
        this.mDecorToolbar.setDropdownParams(r2, new NavItemSelectedListener(r3));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r3) {
        if (this.mDecorToolbar.getNavigationMode() != 1) goto L7;
        this.mDecorToolbar.setDropdownSelectedPosition(r3);
        return;
    L7:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r1) {
        this.mDecorToolbar.setTitle(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r2) {
        DecorToolbar r1 = this.mDecorToolbar;
        if (r2 == 0) goto L5;
        CharSequence r3 = r1.getContext().getText(r2);
    L6:
        r1.setTitle(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r1) {
        this.mDecorToolbar.setWindowTitle(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r1 = this.mDecorToolbar.getViewGroup();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.hasFocus() == true) goto L10;
        r1.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r1) {
        this.mDecorToolbar.setSubtitle(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r2) {
        DecorToolbar r1 = this.mDecorToolbar;
        if (r2 == 0) goto L5;
        CharSequence r3 = r1.getContext().getText(r2);
    L6:
        r1.setSubtitle(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r2) {
        setDisplayOptions(r2, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r2, int r3) {
        int r0 = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions((r2 & r3) | ((~r3) & r0));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r2) {
        setDisplayOptions(r2 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        setDisplayOptions(r3, 2);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        setDisplayOptions(r3, 4);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 8;
    L6:
        setDisplayOptions(r3, 8);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r2) {
        if (r2 == false) goto L5;
        int r3 = 16;
    L6:
        setDisplayOptions(r3, 16);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable r1) {
        this.mDecorToolbar.setBackgroundDrawable(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r2) {
        if (r2 == 2) goto L7;
        this.mDecorToolbar.setNavigationMode(r2);
        return;
    L7:
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r1, boolean r2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r1, int r2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r1, int r2, boolean r3) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int r1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        if (this.mDecorToolbar.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        if (this.mDecorToolbar.hasExpandedActionView() == false) goto L6;
        this.mDecorToolbar.collapseActionView();
        return true;
    L6:
        return false;
    }

    void populateOptionsMenu() {
        Menu r0 = getMenu();
        if ((r0 instanceof MenuBuilder) == false) goto L5;
        MenuBuilder r1 = (MenuBuilder) r0;
    L6:
        if (r1 == null) goto L20;
        r1.stopDispatchingItemsChanged();
    L20:
        r0.clear();     // Catch: Throwable -> L16
        if (this.mWindowCallback.onCreatePanelMenu(0, r0) == true) goto L11;
    L12:
        r0.clear();     // Catch: Throwable -> L16
    L13:
        if (r1 == null) goto L22;
        r1.startDispatchingItemsChanged();
        return;
    L22:
        return;
    L11:
        if (this.mWindowCallback.onPreparePanel(0, null, r0) == true) goto L13;
    L16:
        th = move-exception;
        if (r1 == null) goto L19;
        r1.startDispatchingItemsChanged();
    L19:
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent r2) {
        if (r2.getAction() != 1) goto L5;
        openOptionsMenu();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r4, KeyEvent r5) {
        Menu r3 = getMenu();
        if (r3 == null) goto L13;
        if (r5 == null) goto L6;
        int r1 = r5.getDeviceId();
    L7:
        boolean r2 = true;
        if (KeyCharacterMap.load(r1).getKeyboardType() != 1) goto L11;
        r2 = false;
    L11:
        r3.setQwertyMode(r2);
        return r3.performShortcut(r4, r5, 0);
    L6:
        r1 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r1) {
        this.mMenuVisibilityListeners.add(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r1) {
        this.mMenuVisibilityListeners.remove(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r4) {
        if (r4 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r4;
        int r0 = this.mMenuVisibilityListeners.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        this.mMenuVisibilityListeners.get(r1).onMenuVisibilityChanged(r4);
        r1 = r1 + 1;
        goto L6
    }

    private Menu getMenu() {
        if (this.mMenuCallbackSet == true) goto L6;
        this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
        this.mMenuCallbackSet = true;
    L6:
        return this.mDecorToolbar.getMenu();
    }
}
