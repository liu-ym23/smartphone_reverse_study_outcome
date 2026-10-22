package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int r100);

        void setActionBarUpIndicator(Drawable r100, int r101);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    public static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar r100 = this.mActivity.getActionBar();
            if (r100 == null) goto L7;
            return r100.getThemedContext();
        L7:
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar r100 = this.mActivity.getActionBar();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r100.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray r100 = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable r101 = r100.getDrawable(0);
            r100.recycle();
            return r101;
        }

        public FrameworkActionBarDelegate(Activity r100) {
            this.mActivity = r100;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r100) {
            android.app.ActionBar r101 = this.mActivity.getActionBar();
            if (r101 == null) goto L6;
            r101.setHomeActionContentDescription(r100);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r100, int r101) {
            android.app.ActionBar r102 = this.mActivity.getActionBar();
            if (r102 == null) goto L6;
            r102.setHomeAsUpIndicator(r100);
            r102.setHomeActionContentDescription(r101);
            return;
        }
    }

    public static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        public ToolbarCompatDelegate(Toolbar r100) {
            this.mToolbar = r100;
            this.mDefaultUpIndicator = r100.getNavigationIcon();
            this.mDefaultContentDescription = r100.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r100) {
            if (r100 != 0) goto L4;
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            return;
        L4:
            this.mToolbar.setNavigationContentDescription(r100);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r100, int r101) {
            this.mToolbar.setNavigationIcon(r100);
            setActionBarDescription(r101);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r100) {
    }

    public Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        setPosition(1.0f);
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        DrawerArrowDrawable r100 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r101 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r100, r101);
        return;
    L11:
        r101 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        setPosition(0.0f);
        goto L7
    }

    public void toggle() {
        int r100 = this.mDrawerLayout.getDrawerLockMode(GravityCompat.START);
        if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) == false) goto L8;
        if (r100 == 2) goto L8;
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
        return;
    L8:
        if (r100 == 1) goto L12;
        this.mDrawerLayout.openDrawer(GravityCompat.START);
        return;
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    private void setPosition(float r100) {
        if (r100 != 1.0f) goto L6;
        this.mSlider.setVerticalMirror(true);
    L8:
        this.mSlider.setProgress(r100);
        return;
    L6:
        if (r100 != 0.0f) goto L8;
        this.mSlider.setVerticalMirror(false);
        goto L8
    }

    public void onConfigurationChanged(Configuration r100) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r100) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r100) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == false) goto L12;
        toggle();
        return true;
    L12:
        return false;
    }

    public void setActionBarDescription(int r100) {
        this.mActivityImpl.setActionBarDescription(r100);
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable r100) {
        this.mSlider = r100;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean r100) {
        if (r100 == this.mDrawerIndicatorEnabled) goto L13;
        if (r100 == false) goto L10;
        DrawerArrowDrawable r101 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r102 = this.mCloseDrawerContentDescRes;
    L9:
        setActionBarUpIndicator(r101, r102);
    L11:
        this.mDrawerIndicatorEnabled = r100;
        return;
    L8:
        r102 = this.mOpenDrawerContentDescRes;
        goto L9
    L10:
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        goto L11
    }

    public void setDrawerSlideAnimationEnabled(boolean r100) {
        this.mDrawerSlideAnimationEnabled = r100;
        if (r100 == true) goto L6;
        setPosition(0.0f);
        return;
    }

    public void setHomeAsUpIndicator(Drawable r100) {
        if (r100 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r100;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setToolbarNavigationClickListener(View.OnClickListener r100) {
        this.mToolbarNavigationClickListener = r100;
    }

    public void setHomeAsUpIndicator(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = this.mDrawerLayout.getResources().getDrawable(r100);
    L5:
        setHomeAsUpIndicator(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r100, float r101) {
        if (this.mDrawerSlideAnimationEnabled == false) goto L5;
        setPosition(Math.min(1.0f, Math.max(0.0f, r101)));
        return;
    L5:
        setPosition(0.0f);
    }

    public void setActionBarUpIndicator(Drawable r100, int r101) {
        if (this.mWarnedForDisplayHomeAsUp == false) goto L5;
    L7:
        this.mActivityImpl.setActionBarUpIndicator(r100, r101);
        return;
    L5:
        if (this.mActivityImpl.isNavigationVisible() == true) goto L7;
        this.mWarnedForDisplayHomeAsUp = true;
        goto L7
    }

    public ActionBarDrawerToggle(Activity r100, DrawerLayout r101, int r110, int r111) {
        this(r100, null, r101, null, r110, r111);
    }

    public ActionBarDrawerToggle(Activity r100, DrawerLayout r101, Toolbar r110, int r111, int r112) {
        this(r100, r110, r101, null, r111, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r100, Toolbar r101, DrawerLayout r102, DrawerArrowDrawable r103, int r104, int r105) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (r101 == null) goto L6;
        this.mActivityImpl = new ToolbarCompatDelegate(r101);
        r101.setNavigationOnClickListener(new AnonymousClass1(this));
    L9:
        this.mDrawerLayout = r102;
        this.mOpenDrawerContentDescRes = r104;
        this.mCloseDrawerContentDescRes = r105;
        if (r103 != null) goto L12;
        this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
    L13:
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        return;
    L12:
        this.mSlider = r103;
        goto L13
    L6:
        if ((r100 instanceof DelegateProvider) == false) goto L8;
        this.mActivityImpl = ((DelegateProvider) r100).getDrawerToggleDelegate();
        goto L9
    L8:
        this.mActivityImpl = new FrameworkActionBarDelegate(r100);
        goto L9
    }
}
