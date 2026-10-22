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
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class ToolbarActionBar extends ActionBar {
    DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners;
    boolean mToolbarMenuPrepared;
    Window.Callback mWindowCallback;

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean mClosingActionMenu;
        final /* synthetic */ ToolbarActionBar this$0;

        public ActionMenuPresenterCallback(ToolbarActionBar r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r100) {
            Window.Callback r101 = this.this$0.mWindowCallback;
            if (r101 == null) goto L6;
            r101.onMenuOpened(108, r100);
            return true;
        L6:
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r100, boolean r101) {
            if (this.mClosingActionMenu == false) goto L5;
            return;
        L5:
            this.mClosingActionMenu = true;
            this.this$0.mDecorToolbar.dismissPopupMenus();
            Window.Callback r102 = this.this$0.mWindowCallback;
            if (r102 == null) goto L8;
            r102.onPanelClosed(108, r100);
        L8:
            this.mClosingActionMenu = false;
        }
    }

    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ToolbarActionBar this$0;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r100, MenuItem r101) {
            return false;
        }

        public MenuBuilderCallback(ToolbarActionBar r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r100) {
            ToolbarActionBar r101 = this.this$0;
            if (r101.mWindowCallback != null) goto L5;
            return;
        L5:
            if (r101.mDecorToolbar.isOverflowMenuShowing() == false) goto L8;
            this.this$0.mWindowCallback.onPanelClosed(108, r100);
            return;
        L8:
            if (this.this$0.mWindowCallback.onPreparePanel(0, null, r100) == false) goto L13;
            this.this$0.mWindowCallback.onMenuOpened(108, r100);
            return;
        }
    }

    public class ToolbarCallbackWrapper extends WindowCallbackWrapper {
        final /* synthetic */ ToolbarActionBar this$0;

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int r100) {
            if (r100 != 0) goto L6;
            return new View(this.this$0.mDecorToolbar.getContext());
        L6:
            return super.onCreatePanelView(r100);
        }

        public ToolbarCallbackWrapper(ToolbarActionBar r100, Window.Callback r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r100, View r101, Menu r102) {
            boolean r103 = super.onPreparePanel(r100, r101, r102);
            if (r103 == false) goto L7;
            ToolbarActionBar r104 = this.this$0;
            if (r104.mToolbarMenuPrepared == true) goto L7;
            r104.mDecorToolbar.setMenuPrepared();
            this.this$0.mToolbarMenuPrepared = true;
        L7:
            return r103;
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
    public void setDefaultDisplayHomeAsUpEnabled(boolean r100) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean r100) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean r100) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable r100) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable r100) {
    }

    private Menu getMenu() {
        if (this.mMenuCallbackSet == true) goto L6;
        this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
        this.mMenuCallbackSet = true;
    L6:
        return this.mDecorToolbar.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        if (this.mDecorToolbar.hasExpandedActionView() == false) goto L6;
        this.mDecorToolbar.collapseActionView();
        return true;
    L6:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        if (this.mDecorToolbar.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup r100 = this.mDecorToolbar.getViewGroup();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.hasFocus() == true) goto L10;
        r100.requestFocus();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public void populateOptionsMenu() {
        Menu r100 = getMenu();
        if ((r100 instanceof MenuBuilder) == false) goto L5;
        MenuBuilder r101 = (MenuBuilder) r100;
    L6:
        if (r101 == null) goto L20;
        r101.stopDispatchingItemsChanged();
    L20:
        r100.clear();     // Catch: Throwable -> L16
        if (this.mWindowCallback.onCreatePanelMenu(0, r100) == true) goto L11;
    L12:
        r100.clear();     // Catch: Throwable -> L16
    L13:
        if (r101 == null) goto L22;
        r101.startDispatchingItemsChanged();
        return;
    L22:
        return;
    L11:
        if (this.mWindowCallback.onPreparePanel(0, null, r100) == true) goto L13;
    L16:
        th = move-exception;
        if (r101 == null) goto L19;
        r101.startDispatchingItemsChanged();
    L19:
        throw th;
    L5:
        r101 = null;
        goto L6
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r100) {
        this.mMenuVisibilityListeners.add(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r100) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean r100) {
        if (r100 != this.mLastMenuVisibility) goto L5;
        return;
    L5:
        this.mLastMenuVisibility = r100;
        int r101 = this.mMenuVisibilityListeners.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        ((ActionBar.OnMenuVisibilityListener) ListProtector.get(this.mMenuVisibilityListeners, r102)).onMenuVisibilityChanged(r100);
        r102 = r102 + 1;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int r100) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onMenuKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 1) goto L5;
        openOptionsMenu();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener r100) {
        this.mMenuVisibilityListeners.remove(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab r100) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int r100) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab r100) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable r100) {
        this.mDecorToolbar.setBackgroundDrawable(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int r100) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(r100, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 4;
    L6:
        setDisplayOptions(r101, 4);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r100) {
        setDisplayOptions(r100, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 16;
    L6:
        setDisplayOptions(r101, 16);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 2;
    L6:
        setDisplayOptions(r101, 2);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 8;
    L6:
        setDisplayOptions(r101, 8);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean r100) {
        setDisplayOptions(r100 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float r100) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int r100) {
        this.mDecorToolbar.setNavigationContentDescription(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int r100) {
        this.mDecorToolbar.setNavigationIcon(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int r100) {
        this.mDecorToolbar.setIcon(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int r100) {
        this.mDecorToolbar.setLogo(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int r100) {
        if (r100 == 2) goto L7;
        this.mDecorToolbar.setNavigationMode(r100);
        return;
    L7:
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int r100) {
        if (this.mDecorToolbar.getNavigationMode() != 1) goto L7;
        this.mDecorToolbar.setDropdownSelectedPosition(r100);
        return;
    L7:
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int r100) {
        DecorToolbar r101 = this.mDecorToolbar;
        if (r100 == 0) goto L5;
        CharSequence r102 = r101.getContext().getText(r100);
    L6:
        r101.setSubtitle(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int r100) {
        DecorToolbar r101 = this.mDecorToolbar;
        if (r100 == 0) goto L5;
        CharSequence r102 = r101.getContext().getText(r100);
    L6:
        r101.setTitle(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence r100) {
        this.mDecorToolbar.setWindowTitle(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r100) {
        setCustomView(r100, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence r100) {
        this.mDecorToolbar.setNavigationContentDescription(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable r100) {
        this.mDecorToolbar.setNavigationIcon(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable r100) {
        this.mDecorToolbar.setIcon(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable r100) {
        this.mDecorToolbar.setLogo(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence r100) {
        this.mDecorToolbar.setSubtitle(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence r100) {
        this.mDecorToolbar.setTitle(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r100, int r101) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int r100, KeyEvent r101) {
        Menu r102 = getMenu();
        if (r102 == null) goto L13;
        if (r101 == null) goto L6;
        int r103 = r101.getDeviceId();
    L7:
        boolean r104 = true;
        if (KeyCharacterMap.load(r103).getKeyboardType() != 1) goto L11;
        r104 = false;
    L11:
        r102.setQwertyMode(r104);
        return r102.performShortcut(r100, r101, 0);
    L6:
        r103 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View r100, ActionBar.LayoutParams r101) {
        if (r100 == null) goto L4;
        r100.setLayoutParams(r101);
    L4:
        this.mDecorToolbar.setCustomView(r100);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int r100, int r101) {
        int r102 = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions((r100 & r101) | ((~r101) & r102));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter r100, ActionBar.OnNavigationListener r101) {
        this.mDecorToolbar.setDropdownParams(r100, new NavItemSelectedListener(r101));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r100, boolean r101) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public ToolbarActionBar(Toolbar r100, CharSequence r101, Window.Callback r102) {
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new AnonymousClass1(this);
        Toolbar.OnMenuItemClickListener r103 = new AnonymousClass2(this);
        this.mMenuClicker = r103;
        this.mDecorToolbar = new ToolbarWidgetWrapper(r100, false);
        ToolbarCallbackWrapper r104 = new ToolbarCallbackWrapper(this, r102);
        this.mWindowCallback = r104;
        this.mDecorToolbar.setWindowCallback(r104);
        r100.setOnMenuItemClickListener(r103);
        this.mDecorToolbar.setWindowTitle(r101);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab r100, int r101, boolean r102) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
}
