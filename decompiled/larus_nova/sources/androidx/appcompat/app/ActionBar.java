package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.gravity = 0;
            this.gravity = r100.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.gravity = 0;
        }

        public LayoutParams(int r100) {
            this(-2, -1, r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.gravity = 0;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_gravity});
            this.gravity = r102.getInt(0, 0);
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.gravity = 8388627;
        }

        public LayoutParams(int r100, int r101, int r102) {
            super(r100, r101);
            this.gravity = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean r100);
    }

    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int r100, long r101);
    }

    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public Tab() {
        }

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(int r100);

        public abstract Tab setContentDescription(CharSequence r100);

        public abstract Tab setCustomView(int r100);

        public abstract Tab setCustomView(View r100);

        public abstract Tab setIcon(int r100);

        public abstract Tab setIcon(Drawable r100);

        public abstract Tab setTabListener(TabListener r100);

        public abstract Tab setTag(Object r100);

        public abstract Tab setText(int r100);

        public abstract Tab setText(CharSequence r100);
    }

    public interface TabListener {
        void onTabReselected(Tab r100, FragmentTransaction r101);

        void onTabSelected(Tab r100, FragmentTransaction r101);

        void onTabUnselected(Tab r100, FragmentTransaction r101);
    }

    public ActionBar() {
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener r100);

    public abstract void addTab(Tab r100);

    public abstract void addTab(Tab r100, int r101);

    public abstract void addTab(Tab r100, int r101, boolean r102);

    public abstract void addTab(Tab r100, boolean r101);

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean r100) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    public abstract int getNavigationItemCount();

    public abstract int getNavigationMode();

    public abstract int getSelectedNavigationIndex();

    public abstract Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    public abstract Tab getTabAt(int r100);

    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isTitleTruncated() {
        return false;
    }

    public abstract Tab newTab();

    public void onConfigurationChanged(Configuration r100) {
    }

    public void onDestroy() {
    }

    public boolean onKeyShortcut(int r100, KeyEvent r101) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent r100) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener r100);

    public abstract void removeTab(Tab r100);

    public abstract void removeTabAt(int r100);

    public boolean requestFocus() {
        return false;
    }

    public abstract void selectTab(Tab r100);

    public abstract void setBackgroundDrawable(Drawable r100);

    public abstract void setCustomView(int r100);

    public abstract void setCustomView(View r100);

    public abstract void setCustomView(View r100, LayoutParams r101);

    public void setDefaultDisplayHomeAsUpEnabled(boolean r100) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean r100);

    public abstract void setDisplayOptions(int r100);

    public abstract void setDisplayOptions(int r100, int r101);

    public abstract void setDisplayShowCustomEnabled(boolean r100);

    public abstract void setDisplayShowHomeEnabled(boolean r100);

    public abstract void setDisplayShowTitleEnabled(boolean r100);

    public abstract void setDisplayUseLogoEnabled(boolean r100);

    public void setHomeActionContentDescription(int r100) {
    }

    public void setHomeActionContentDescription(CharSequence r100) {
    }

    public void setHomeAsUpIndicator(int r100) {
    }

    public void setHomeAsUpIndicator(Drawable r100) {
    }

    public void setHomeButtonEnabled(boolean r100) {
    }

    public abstract void setIcon(int r100);

    public abstract void setIcon(Drawable r100);

    public abstract void setListNavigationCallbacks(SpinnerAdapter r100, OnNavigationListener r101);

    public abstract void setLogo(int r100);

    public abstract void setLogo(Drawable r100);

    public abstract void setNavigationMode(int r100);

    public abstract void setSelectedNavigationItem(int r100);

    public void setShowHideAnimationEnabled(boolean r100) {
    }

    public void setSplitBackgroundDrawable(Drawable r100) {
    }

    public void setStackedBackgroundDrawable(Drawable r100) {
    }

    public abstract void setSubtitle(int r100);

    public abstract void setSubtitle(CharSequence r100);

    public abstract void setTitle(int r100);

    public abstract void setTitle(CharSequence r100);

    public void setWindowTitle(CharSequence r100) {
    }

    public abstract void show();

    public ActionMode startActionMode(ActionMode.Callback r100) {
        return null;
    }

    public void setElevation(float r100) {
        if (r100 != 0.0f) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int r100) {
        if (r100 != 0) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }
}
