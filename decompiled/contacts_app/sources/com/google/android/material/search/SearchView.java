package com.google.android.material.search;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final long TALKBACK_FOCUS_CHANGE_DELAY_MS = 100;
    private boolean animatedMenuItems;
    private boolean animatedNavigationIcon;
    private boolean autoShowKeyboard;
    final View backgroundView;
    private Map<View, Integer> childImportantForAccessibilityMap;
    final ImageButton clearButton;
    final TouchObserverFrameLayout contentContainer;
    private TransitionState currentTransitionState;
    final View divider;
    final Toolbar dummyToolbar;
    final EditText editText;
    private final ElevationOverlayProvider elevationOverlayProvider;
    final FrameLayout headerContainer;
    private final boolean layoutInflated;
    final ClippableRoundedCornerLayout rootView;
    final View scrim;
    private SearchBar searchBar;
    final TextView searchPrefix;
    private final SearchViewAnimationHelper searchViewAnimationHelper;
    private int softInputMode;
    final View statusBarSpacer;
    private boolean statusBarSpacerEnabledOverride;
    final MaterialToolbar toolbar;
    final FrameLayout toolbarContainer;
    private final Set<TransitionListener> transitionListeners;
    private boolean useWindowInsetsController;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
            return onDependentViewChanged(r1, (SearchView) r2, r3);
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r1, SearchView r2, View r3) {
            if (r2.isSetupWithSearchBar() == false) goto L5;
            return false;
        L5:
            if ((r3 instanceof SearchBar) == false) goto L10;
            r2.setupWithSearchBar((SearchBar) r3);
            return false;
        L10:
            return false;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String text;
        int visibility;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.text = r1.readString();
            this.visibility = r1.readInt();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeString(this.text);
            r1.writeInt(this.visibility);
        }
    }

    public interface TransitionListener {
        void onStateChanged(SearchView r1, TransitionState r2, TransitionState r3);
    }

    public static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState HIDDEN = null;
        public static final TransitionState HIDING = null;
        public static final TransitionState SHOWING = null;
        public static final TransitionState SHOWN = null;

        private TransitionState(String r1, int r2) {
            super(r1, r2);
        }

        public static TransitionState valueOf(String r1) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r1);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }

        static {
            TransitionState r0 = new TransitionState("HIDING", 0);
            HIDING = r0;
            TransitionState r1 = new TransitionState("HIDDEN", 1);
            HIDDEN = r1;
            TransitionState r3 = new TransitionState("SHOWING", 2);
            SHOWING = r3;
            TransitionState r5 = new TransitionState("SHOWN", 3);
            SHOWN = r5;
            $VALUES = new TransitionState[]{r0, r1, r3, r5};
        }
    }

    static /* synthetic */ boolean lambda$setUpRootView$0(View r0, MotionEvent r1) {
        return true;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_SearchView;
    }

    public SearchView(Context r2) {
        this(r2, null);
    }

    public SearchView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.materialSearchViewStyle);
    }

    public SearchView(Context r9, AttributeSet r10, int r11) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r9, r10, r11, r4), r10, r11);
        this.transitionListeners = new LinkedHashSet();
        this.softInputMode = 16;
        this.currentTransitionState = TransitionState.HIDDEN;
        Context r12 = getContext();
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r12, r10, R.styleable.SearchView, r11, r4, new int[0]);
        int r14 = r13.getResourceId(R.styleable.SearchView_headerLayout, -1);
        int r0 = r13.getResourceId(R.styleable.SearchView_android_textAppearance, -1);
        String r1 = r13.getString(R.styleable.SearchView_android_text);
        String r2 = r13.getString(R.styleable.SearchView_android_hint);
        String r3 = r13.getString(R.styleable.SearchView_searchPrefixText);
        boolean r5 = r13.getBoolean(R.styleable.SearchView_useDrawerArrowDrawable, false);
        this.animatedNavigationIcon = r13.getBoolean(R.styleable.SearchView_animateNavigationIcon, true);
        this.animatedMenuItems = r13.getBoolean(R.styleable.SearchView_animateMenuItems, true);
        boolean r6 = r13.getBoolean(R.styleable.SearchView_hideNavigationIcon, false);
        this.autoShowKeyboard = r13.getBoolean(R.styleable.SearchView_autoShowKeyboard, true);
        r13.recycle();
        LayoutInflater.from(r12).inflate(R.layout.mtrl_search_view, this);
        this.layoutInflated = true;
        this.scrim = findViewById(R.id.search_view_scrim);
        this.rootView = (ClippableRoundedCornerLayout) findViewById(R.id.search_view_root);
        this.backgroundView = findViewById(R.id.search_view_background);
        this.statusBarSpacer = findViewById(R.id.search_view_status_bar_spacer);
        this.headerContainer = (FrameLayout) findViewById(R.id.search_view_header_container);
        this.toolbarContainer = (FrameLayout) findViewById(R.id.search_view_toolbar_container);
        this.toolbar = (MaterialToolbar) findViewById(R.id.search_view_toolbar);
        this.dummyToolbar = (Toolbar) findViewById(R.id.search_view_dummy_toolbar);
        this.searchPrefix = (TextView) findViewById(R.id.search_view_search_prefix);
        this.editText = (EditText) findViewById(R.id.search_view_edit_text);
        this.clearButton = (ImageButton) findViewById(R.id.search_view_clear_button);
        this.divider = findViewById(R.id.search_view_divider);
        this.contentContainer = (TouchObserverFrameLayout) findViewById(R.id.search_view_content_container);
        this.searchViewAnimationHelper = new SearchViewAnimationHelper(this);
        this.elevationOverlayProvider = new ElevationOverlayProvider(r12);
        setUpRootView();
        setUpBackgroundViewElevationOverlay();
        setUpHeaderLayout(r14);
        setSearchPrefixText(r3);
        setUpEditText(r0, r1, r2);
        setUpBackButton(r5, r6);
        setUpClearButton();
        setUpContentOnTouchListener();
        setUpInsetListeners();
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (this.layoutInflated == false) goto L5;
        this.contentContainer.addView(r2, r3, r4);
        return;
    L5:
        super.addView(r2, r3, r4);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        setUpBackgroundViewElevationOverlay(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    private Window getActivityWindow() {
        Activity r0 = ContextUtils.getActivity(getContext());
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getWindow();
    }

    private void setUpRootView() {
        this.rootView.setOnTouchListener(new SearchView$$ExternalSyntheticLambda1());
    }

    private void setUpBackgroundViewElevationOverlay() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void setUpBackgroundViewElevationOverlay(float r3) {
        ElevationOverlayProvider r0 = this.elevationOverlayProvider;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.backgroundView == null) goto L10;
        int r4 = r0.compositeOverlayWithThemeSurfaceColorIfNeeded(r3);
        this.backgroundView.setBackgroundColor(r4);
        return;
    }

    private float getOverlayElevation() {
        SearchBar r0 = this.searchBar;
        if (r0 == null) goto L7;
        return r0.getCompatElevation();
    L7:
        return getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    private void setUpHeaderLayout(int r4) {
        if (r4 == (-1)) goto L6;
        addHeaderView(LayoutInflater.from(getContext()).inflate(r4, this.headerContainer, false));
        return;
    }

    private void setUpEditText(int r2, String r3, String r4) {
        if (r2 == (-1)) goto L5;
        TextViewCompat.setTextAppearance(this.editText, r2);
    L5:
        this.editText.setText(r3);
        this.editText.setHint(r4);
    }

    private void setUpBackButton(boolean r2, boolean r3) {
        if (r3 == false) goto L5;
        this.toolbar.setNavigationIcon(null);
        return;
    L5:
        this.toolbar.setNavigationOnClickListener(new SearchView$$ExternalSyntheticLambda2(this));
        if (r2 == false) goto L9;
        DrawerArrowDrawable r4 = new DrawerArrowDrawable(getContext());
        r4.setColor(MaterialColors.getColor(this, R.attr.colorOnSurface));
        this.toolbar.setNavigationIcon(r4);
        return;
    }

    /* JADX INFO: renamed from: lambda$setUpBackButton$1$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ void m257x40e9b054(View r1) {
        hide();
    }

    private void setUpClearButton() {
        this.clearButton.setOnClickListener(new SearchView$$ExternalSyntheticLambda7(this));
        this.editText.addTextChangedListener(new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: lambda$setUpClearButton$2$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ void m258xf4a71c3b(View r1) {
        clearText();
        requestFocusAndShowKeyboardIfNeeded();
    }

    private void setUpContentOnTouchListener() {
        this.contentContainer.setOnTouchListener(new SearchView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$setUpContentOnTouchListener$3$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ boolean m259x1cd2d198(View r1, MotionEvent r2) {
        if (isAdjustNothingSoftInputMode() == false) goto L7;
        clearFocusAndHideKeyboard();
        return false;
    L7:
        return false;
    }

    private void setUpStatusBarSpacer(int r2) {
        if (this.statusBarSpacer.getLayoutParams().height == r2) goto L6;
        this.statusBarSpacer.getLayoutParams().height = r2;
        this.statusBarSpacer.requestLayout();
        return;
    }

    private int getStatusBarHeight() {
        int r0 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r0 > 0) goto L5;
        return 0;
    L5:
        return getResources().getDimensionPixelSize(r0);
    }

    private void updateNavigationIconIfNeeded() {
        MaterialToolbar r0 = this.toolbar;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isNavigationIconDrawerArrowDrawable(r0) == false) goto L8;
        return;
    L8:
        int r1 = R.drawable.ic_arrow_back_black_24;
        if (this.searchBar != null) goto L11;
        this.toolbar.setNavigationIcon(r1);
        return;
    L11:
        Drawable r2 = DrawableCompat.wrap(AppCompatResources.getDrawable(getContext(), r1).mutate());
        if (this.toolbar.getNavigationIconTint() == null) goto L14;
        DrawableCompat.setTint(r2, this.toolbar.getNavigationIconTint().intValue());
    L14:
        this.toolbar.setNavigationIcon(new FadeThroughDrawable(this.searchBar.getNavigationIcon(), r2));
        updateNavigationIconProgressIfNeeded();
    }

    private boolean isNavigationIconDrawerArrowDrawable(Toolbar r1) {
        return DrawableCompat.unwrap(r1.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    private void setUpInsetListeners() {
        setUpToolbarInsetListener();
        setUpDividerInsetListener();
        setUpStatusBarSpacerInsetListener();
    }

    private void setUpToolbarInsetListener() {
        ViewUtils.doOnApplyWindowInsets(this.toolbar, new SearchView$$ExternalSyntheticLambda8(this));
    }

    /* JADX INFO: renamed from: lambda$setUpToolbarInsetListener$4$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m261x7371bf54(View r4, WindowInsetsCompat r5, ViewUtils.RelativePadding r6) {
        boolean r7 = ViewUtils.isLayoutRtl(this.toolbar);
        if (r7 == false) goto L5;
        int r0 = r6.end;
    L6:
        if (r7 == false) goto L8;
        int r8 = r6.start;
    L9:
        this.toolbar.setPadding(r0 + r5.getSystemWindowInsetLeft(), r6.top, r8 + r5.getSystemWindowInsetRight(), r6.bottom);
        return r5;
    L8:
        r8 = r6.end;
        goto L9
    L5:
        r0 = r6.start;
        goto L6
    }

    private void setUpStatusBarSpacerInsetListener() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.statusBarSpacer, new SearchView$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$setUpStatusBarSpacerInsetListener$5$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m260x941b8403(View r2, WindowInsetsCompat r3) {
        int r4 = r3.getSystemWindowInsetTop();
        setUpStatusBarSpacer(r4);
        if (this.statusBarSpacerEnabledOverride == true) goto L8;
        if (r4 <= 0) goto L6;
        boolean r5 = true;
    L7:
        setStatusBarSpacerEnabledInternal(r5);
        goto L8
    L6:
        r5 = false;
    L8:
        return r3;
    }

    private void setUpDividerInsetListener() {
        final ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.divider.getLayoutParams();
        final int r1 = r0.leftMargin;
        final int r2 = r0.rightMargin;
        ViewCompat.setOnApplyWindowInsetsListener(this.divider, new SearchView$$ExternalSyntheticLambda3(r0, r1, r2));
    }

    static /* synthetic */ WindowInsetsCompat lambda$setUpDividerInsetListener$6(ViewGroup.MarginLayoutParams r0, int r1, int r2, View r3, WindowInsetsCompat r4) {
        r0.leftMargin = r1 + r4.getSystemWindowInsetLeft();
        r0.rightMargin = r2 + r4.getSystemWindowInsetRight();
        return r4;
    }

    public boolean isSetupWithSearchBar() {
        if (this.searchBar == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setupWithSearchBar(SearchBar r2) {
        this.searchBar = r2;
        this.searchViewAnimationHelper.setSearchBar(r2);
        if (r2 == null) goto L5;
        r2.setOnClickListener(new SearchView$$ExternalSyntheticLambda6(this));
    L5:
        updateNavigationIconIfNeeded();
        setUpBackgroundViewElevationOverlay();
    }

    /* JADX INFO: renamed from: lambda$setupWithSearchBar$7$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ void m262x986696e6(View r1) {
        show();
    }

    public void addHeaderView(View r2) {
        this.headerContainer.addView(r2);
        this.headerContainer.setVisibility(0);
    }

    public void removeHeaderView(View r2) {
        this.headerContainer.removeView(r2);
        if (this.headerContainer.getChildCount() != 0) goto L6;
        this.headerContainer.setVisibility(8);
        return;
    }

    public void removeAllHeaderViews() {
        this.headerContainer.removeAllViews();
        this.headerContainer.setVisibility(8);
    }

    public void setAnimatedNavigationIcon(boolean r1) {
        this.animatedNavigationIcon = r1;
    }

    public boolean isAnimatedNavigationIcon() {
        return this.animatedNavigationIcon;
    }

    public void setMenuItemsAnimated(boolean r1) {
        this.animatedMenuItems = r1;
    }

    public boolean isMenuItemsAnimated() {
        return this.animatedMenuItems;
    }

    public void setAutoShowKeyboard(boolean r1) {
        this.autoShowKeyboard = r1;
    }

    public boolean isAutoShowKeyboard() {
        return this.autoShowKeyboard;
    }

    public void setUseWindowInsetsController(boolean r1) {
        this.useWindowInsetsController = r1;
    }

    public boolean isUseWindowInsetsController() {
        return this.useWindowInsetsController;
    }

    public void addTransitionListener(TransitionListener r1) {
        this.transitionListeners.add(r1);
    }

    public void removeTransitionListener(TransitionListener r1) {
        this.transitionListeners.remove(r1);
    }

    public void inflateMenu(int r1) {
        this.toolbar.inflateMenu(r1);
    }

    public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener r1) {
        this.toolbar.setOnMenuItemClickListener(r1);
    }

    public TextView getSearchPrefix() {
        return this.searchPrefix;
    }

    public void setSearchPrefixText(CharSequence r2) {
        this.searchPrefix.setText(r2);
        TextView r1 = this.searchPrefix;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public CharSequence getSearchPrefixText() {
        return this.searchPrefix.getText();
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public Editable getText() {
        return this.editText.getText();
    }

    public void setText(CharSequence r1) {
        this.editText.setText(r1);
    }

    public void setText(int r1) {
        this.editText.setText(r1);
    }

    public void clearText() {
        this.editText.setText("");
    }

    public CharSequence getHint() {
        return this.editText.getHint();
    }

    public void setHint(CharSequence r1) {
        this.editText.setHint(r1);
    }

    public void setHint(int r1) {
        this.editText.setHint(r1);
    }

    public int getSoftInputMode() {
        return this.softInputMode;
    }

    public void updateSoftInputMode() {
        Window r0 = getActivityWindow();
        if (r0 == null) goto L6;
        this.softInputMode = r0.getAttributes().softInputMode;
        return;
    }

    public void setStatusBarSpacerEnabled(boolean r2) {
        this.statusBarSpacerEnabledOverride = true;
        setStatusBarSpacerEnabledInternal(r2);
    }

    private void setStatusBarSpacerEnabledInternal(boolean r1) {
        View r0 = this.statusBarSpacer;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public TransitionState getCurrentTransitionState() {
        return this.currentTransitionState;
    }

    void setTransitionState(TransitionState r4) {
        if (this.currentTransitionState.equals(r4) == false) goto L5;
        return;
    L5:
        TransitionState r0 = this.currentTransitionState;
        this.currentTransitionState = r4;
        Iterator r1 = new LinkedHashSet(this.transitionListeners).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((TransitionListener) r1.next()).onStateChanged(this, r0, r4);
        goto L7
    }

    public boolean isShowing() {
        if (this.currentTransitionState.equals(TransitionState.SHOWN) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.currentTransitionState.equals(TransitionState.SHOWING) == true) goto L8;
        return false;
    }

    public void show() {
        if (this.currentTransitionState.equals(TransitionState.SHOWN) == false) goto L5;
        return;
    L5:
        if (this.currentTransitionState.equals(TransitionState.SHOWING) == true) goto L10;
        this.searchViewAnimationHelper.show();
        setModalForAccessibility(true);
        return;
    }

    public void hide() {
        if (this.currentTransitionState.equals(TransitionState.HIDDEN) == false) goto L5;
        return;
    L5:
        if (this.currentTransitionState.equals(TransitionState.HIDING) == true) goto L10;
        this.searchViewAnimationHelper.hide();
        setModalForAccessibility(false);
        return;
    }

    public void setVisible(boolean r4) {
        int r1 = 0;
        if (this.rootView.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        ClippableRoundedCornerLayout r2 = this.rootView;
        if (r4 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        updateNavigationIconProgressIfNeeded();
        if (r0 == r4) goto L13;
        setModalForAccessibility(r4);
    L13:
        if (r4 == false) goto L15;
        TransitionState r5 = TransitionState.SHOWN;
    L16:
        setTransitionState(r5);
        return;
    L15:
        r5 = TransitionState.HIDDEN;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    private void updateNavigationIconProgressIfNeeded() {
        ImageButton r0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.rootView.getVisibility() != 0) goto L8;
        int r3 = 1;
    L9:
        Drawable r1 = DrawableCompat.unwrap(r0.getDrawable());
        if ((r1 instanceof DrawerArrowDrawable) == false) goto L13;
        ((DrawerArrowDrawable) r1).setProgress(r3);
    L13:
        if ((r1 instanceof FadeThroughDrawable) == false) goto L16;
        ((FadeThroughDrawable) r1).setProgress(r3);
        return;
    L16:
        return;
    L8:
        r3 = 0;
        goto L9
    }

    void requestFocusAndShowKeyboardIfNeeded() {
        if (this.autoShowKeyboard == false) goto L6;
        requestFocusAndShowKeyboard();
        return;
    }

    public void requestFocusAndShowKeyboard() {
        this.editText.postDelayed(new SearchView$$ExternalSyntheticLambda5(this), 100);
    }

    /* JADX INFO: renamed from: lambda$requestFocusAndShowKeyboard$8$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ void m256x2b2700d7() {
        if (this.editText.requestFocus() == false) goto L5;
        this.editText.sendAccessibilityEvent(8);
    L5:
        ViewUtils.showKeyboard(this.editText, this.useWindowInsetsController);
    }

    public void clearFocusAndHideKeyboard() {
        this.editText.post(new SearchView$$ExternalSyntheticLambda9(this));
    }

    /* JADX INFO: renamed from: lambda$clearFocusAndHideKeyboard$9$com-google-android-material-search-SearchView, reason: not valid java name */
    /* synthetic */ void m255xff5aa7db() {
        this.editText.clearFocus();
        SearchBar r0 = this.searchBar;
        if (r0 == null) goto L5;
        r0.requestFocus();
    L5:
        ViewUtils.hideKeyboard(this.editText, this.useWindowInsetsController);
    }

    boolean isAdjustNothingSoftInputMode() {
        if (this.softInputMode != 48) goto L5;
        return true;
    L5:
        return false;
    }

    public void setModalForAccessibility(boolean r4) {
        ViewGroup r0 = (ViewGroup) getRootView();
        if (r4 == false) goto L5;
        this.childImportantForAccessibilityMap = new HashMap(r0.getChildCount());
    L5:
        updateChildImportantForAccessibility(r0, r4);
        if (r4 == true) goto L9;
        this.childImportantForAccessibilityMap = null;
        return;
    }

    public void setToolbarTouchscreenBlocksFocus(boolean r1) {
        this.toolbar.setTouchscreenBlocksFocus(r1);
    }

    private void updateChildImportantForAccessibility(ViewGroup r5, boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= r5.getChildCount()) goto L19;
        View r1 = r5.getChildAt(r0);
        if (r1 == this) goto L18;
        if (r1.findViewById(this.rootView.getId()) == null) goto L11;
        updateChildImportantForAccessibility((ViewGroup) r1, r6);
        goto L18
    L11:
        if (r6 == true) goto L17;
        Map<View, Integer> r2 = this.childImportantForAccessibilityMap;
        if (r2 == null) goto L18;
        if (r2.containsKey(r1) == false) goto L18;
        ViewCompat.setImportantForAccessibility(r1, this.childImportantForAccessibilityMap.get(r1).intValue());
        goto L18
    L17:
        this.childImportantForAccessibilityMap.put(r1, Integer.valueOf(r1.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r1, 4);
    L18:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        Editable r1 = getText();
        if (r1 != null) goto L5;
        String r2 = null;
    L6:
        r0.text = r2;
        r0.visibility = this.rootView.getVisibility();
        return r0;
    L5:
        r2 = r1.toString();
        goto L6
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setText(r3.text);
        if (r3.visibility != 0) goto L9;
        boolean r4 = true;
    L10:
        setVisible(r4);
        return;
    L9:
        r4 = false;
        goto L10
    }
}
