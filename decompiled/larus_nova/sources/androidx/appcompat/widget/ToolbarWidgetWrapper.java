package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r100) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    private int detectDisplayOptions() {
        if (this.mToolbar.getNavigationIcon() == null) goto L5;
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        return 15;
    L5:
        return 11;
    }

    private void ensureSpinner() {
        if (this.mSpinner != null) goto L6;
        this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        Toolbar.LayoutParams r100 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams(r100);
        return;
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mHomeDescription) == false) goto L7;
        this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    L7:
        this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) == 0) goto L9;
        Toolbar r100 = this.mToolbar;
        Drawable r101 = this.mNavIcon;
        if (r101 != null) goto L8;
        r101 = this.mDefaultNavigationIcon;
    L8:
        r100.setNavigationIcon(r101);
        return;
    L9:
        this.mToolbar.setNavigationIcon(null);
    }

    private void updateToolbarLogo() {
        int r100 = this.mDisplayOpts;
        if ((r100 & 2) != 0) goto L5;
        Drawable r101 = null;
    L12:
        this.mToolbar.setLogo(r101);
        return;
    L5:
        if ((r100 & 1) == 0) goto L10;
        r101 = this.mLogo;
        if (r101 != null) goto L12;
        r101 = this.mIcon;
        goto L12
    L10:
        r101 = this.mIcon;
        goto L12
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.mToolbar.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner r100 = this.mSpinner;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r100 = this.mSpinner;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        if (this.mTabView == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        if (this.mIcon == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        if (this.mLogo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    private void setTitleInt(CharSequence r100) {
        this.mTitle = r100;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setTitle(r100);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r100) {
        ViewPropertyAnimatorCompat r101 = setupAnimatorToVisibility(r100, 200);
        if (r101 == null) goto L6;
        r101.start();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> r100) {
        this.mToolbar.restoreHierarchyState(r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> r100) {
        this.mToolbar.saveHierarchyState(r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r100) {
        ViewCompat.setBackground(this.mToolbar, r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r100) {
        this.mToolbar.setCollapsible(r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r100) {
        View r101 = this.mCustomView;
        if (r101 != null) goto L5;
    L7:
        this.mCustomView = r100;
        if (r100 != null) goto L10;
        return;
    L10:
        if ((this.mDisplayOpts & 16) == 0) goto L14;
        this.mToolbar.addView(r100);
        return;
    L14:
        return;
    L5:
        if ((this.mDisplayOpts & 16) == 0) goto L7;
        this.mToolbar.removeView(r101);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r100) {
        if (r100 != this.mDefaultNavigationContentDescription) goto L5;
        return;
    L5:
        this.mDefaultNavigationContentDescription = r100;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r100) {
        if (this.mDefaultNavigationIcon == r100) goto L6;
        this.mDefaultNavigationIcon = r100;
        updateNavigationIcon();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r100) {
        int r101 = this.mDisplayOpts ^ r100;
        this.mDisplayOpts = r100;
        if (r101 != 0) goto L5;
        return;
    L5:
        if ((r101 & 4) == 0) goto L11;
        if ((r100 & 4) == 0) goto L9;
        updateHomeAccessibility();
    L9:
        updateNavigationIcon();
    L11:
        if ((r101 & 3) == 0) goto L14;
        updateToolbarLogo();
    L14:
        if ((r101 & 8) == 0) goto L20;
        if ((r100 & 8) == 0) goto L18;
        this.mToolbar.setTitle(this.mTitle);
        this.mToolbar.setSubtitle(this.mSubtitle);
        goto L20
    L18:
        this.mToolbar.setTitle(null);
        this.mToolbar.setSubtitle(null);
    L20:
        if ((r101 & 16) == 0) goto L29;
        View r102 = this.mCustomView;
        if (r102 != null) goto L24;
        return;
    L24:
        if ((r100 & 16) == 0) goto L26;
        this.mToolbar.addView(r102);
        return;
    L26:
        this.mToolbar.removeView(r102);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r100) {
        Spinner r101 = this.mSpinner;
        if (r101 == null) goto L7;
        r101.setSelection(r100);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r100) {
        View r101 = this.mTabView;
        if (r101 == null) goto L7;
        ViewParent r102 = r101.getParent();
        Toolbar r103 = this.mToolbar;
        if (r102 != r103) goto L7;
        r103.removeView(this.mTabView);
    L7:
        this.mTabView = r100;
        if (r100 != null) goto L10;
        return;
    L10:
        if (this.mNavigationMode != 2) goto L14;
        this.mToolbar.addView(r100, 0);
        Toolbar.LayoutParams r104 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r104).width = -2;
        ((ViewGroup.MarginLayoutParams) r104).height = -2;
        r104.gravity = 8388691;
        r100.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setIcon(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setLogo(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r100) {
        if (r100 != 0) goto L4;
        String r101 = null;
    L5:
        setNavigationContentDescription(r101);
        return;
    L4:
        r101 = getContext().getString(r100);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
    L5:
        setNavigationIcon(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r100) {
        int r101 = this.mNavigationMode;
        if (r100 != r101) goto L5;
        return;
    L5:
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L18;
        View r102 = this.mTabView;
        if (r102 == null) goto L18;
        ViewParent r103 = r102.getParent();
        Toolbar r104 = this.mToolbar;
        if (r103 != r104) goto L18;
        r104.removeView(this.mTabView);
    L18:
        this.mNavigationMode = r100;
        if (r100 != 0) goto L21;
        return;
    L21:
        if (r100 == 1) goto L28;
        if (r100 != 2) goto L27;
        View r105 = this.mTabView;
        if (r105 == null) goto L32;
        this.mToolbar.addView(r105, 0);
        Toolbar.LayoutParams r106 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r106).width = -2;
        ((ViewGroup.MarginLayoutParams) r106).height = -2;
        r106.gravity = 8388691;
        return;
    L32:
        return;
    L27:
        throw new IllegalArgumentException("Invalid navigation mode " + r100);
    L28:
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
        return;
    L13:
        Spinner r107 = this.mSpinner;
        if (r107 == null) goto L18;
        ViewParent r108 = r107.getParent();
        Toolbar r109 = this.mToolbar;
        if (r108 != r109) goto L18;
        r109.removeView(this.mSpinner);
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r100) {
        this.mSubtitle = r100;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setSubtitle(r100);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r100) {
        this.mTitleSet = true;
        setTitleInt(r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r100) {
        this.mToolbar.setVisibility(r100);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r100) {
        this.mWindowCallback = r100;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r100) {
        if (this.mTitleSet == true) goto L6;
        setTitleInt(r100);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r100) {
        this.mIcon = r100;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r100) {
        this.mLogo = r100;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r100) {
        this.mHomeDescription = r100;
        updateHomeAccessibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r100) {
        this.mNavIcon = r100;
        updateNavigationIcon();
    }

    public ToolbarWidgetWrapper(Toolbar r100, boolean r101) {
        this(r100, r101, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r100, AdapterView.OnItemSelectedListener r101) {
        ensureSpinner();
        this.mSpinner.setAdapter(r100);
        this.mSpinner.setOnItemSelectedListener(r101);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r100, MenuPresenter.Callback r101) {
        if (this.mActionMenuPresenter != null) goto L5;
        ActionMenuPresenter r102 = new ActionMenuPresenter(this.mToolbar.getContext());
        this.mActionMenuPresenter = r102;
        r102.setId(R.id.action_menu_presenter);
    L5:
        this.mActionMenuPresenter.setCallback(r101);
        this.mToolbar.setMenu((MenuBuilder) r100, this.mActionMenuPresenter);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r100, MenuBuilder.Callback r101) {
        this.mToolbar.setMenuCallbacks(r100, r101);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r100, long r101) {
        ViewPropertyAnimatorCompat r102 = ViewCompat.animate(this.mToolbar);
        if (r100 != 0) goto L5;
        float r103 = 1.0f;
    L7:
        return r102.alpha(r103).setDuration(r101).setListener(new AnonymousClass2(this, r100));
    L5:
        r103 = 0.0f;
        goto L7
    }

    public ToolbarWidgetWrapper(Toolbar r100, boolean r101, int r102, int r103) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = r100;
        this.mTitle = r100.getTitle();
        this.mSubtitle = r100.getSubtitle();
        if (this.mTitle == null) goto L5;
        boolean r104 = true;
    L6:
        this.mTitleSet = r104;
        this.mNavIcon = r100.getNavigationIcon();
        TintTypedArray r105 = TintTypedArray.obtainStyledAttributes(r100.getContext(), null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = r105.getDrawable(15);
        if (r101 == false) goto L44;
        CharSequence r106 = r105.getText(27);
        if (TextUtils.isEmpty(r106) == true) goto L11;
        setTitle(r106);
    L11:
        CharSequence r107 = r105.getText(25);
        if (TextUtils.isEmpty(r107) == true) goto L14;
        setSubtitle(r107);
    L14:
        Drawable r108 = r105.getDrawable(20);
        if (r108 == null) goto L17;
        setLogo(r108);
    L17:
        Drawable r109 = r105.getDrawable(17);
        if (r109 == null) goto L21;
        setIcon(r109);
    L21:
        if (this.mNavIcon != null) goto L25;
        Drawable r110 = this.mDefaultNavigationIcon;
        if (r110 == null) goto L25;
        setNavigationIcon(r110);
    L25:
        setDisplayOptions(r105.getInt(10, 0));
        int r111 = r105.getResourceId(9, 0);
        if (r111 == 0) goto L28;
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(r111, this.mToolbar, false));
        setDisplayOptions(this.mDisplayOpts | 16);
    L28:
        int r112 = r105.getLayoutDimension(13, 0);
        if (r112 <= 0) goto L31;
        ViewGroup.LayoutParams r113 = this.mToolbar.getLayoutParams();
        r113.height = r112;
        this.mToolbar.setLayoutParams(r113);
    L31:
        int r114 = r105.getDimensionPixelOffset(7, -1);
        int r115 = r105.getDimensionPixelOffset(3, -1);
        if (r114 >= 0) goto L34;
        if (r115 >= 0) goto L34;
    L35:
        int r116 = r105.getResourceId(28, 0);
        if (r116 == 0) goto L38;
        Toolbar r117 = this.mToolbar;
        r117.setTitleTextAppearance(r117.getContext(), r116);
    L38:
        int r118 = r105.getResourceId(26, 0);
        if (r118 == 0) goto L41;
        Toolbar r119 = this.mToolbar;
        r119.setSubtitleTextAppearance(r119.getContext(), r118);
    L41:
        int r120 = r105.getResourceId(22, 0);
        if (r120 == 0) goto L45;
        this.mToolbar.setPopupTheme(r120);
    L45:
        r105.recycle();
        setDefaultNavigationContentDescription(r102);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new AnonymousClass1(this));
        return;
    L34:
        this.mToolbar.setContentInsetsRelative(Math.max(r114, 0), Math.max(r115, 0));
        goto L35
    L44:
        this.mDisplayOpts = detectDisplayOptions();
        goto L45
    L5:
        r104 = false;
        goto L6
    }
}
