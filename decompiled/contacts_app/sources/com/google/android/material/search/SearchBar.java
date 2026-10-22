package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = 0;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;
    private Integer navigationIconTint;
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public static abstract class OnLoadAnimationCallback {
        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }

        public OnLoadAnimationCallback() {
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String text;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.text = r1.readString();
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
        }
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized;

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior() {
            this.initialized = false;
        }

        public ScrollingViewBehavior(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.initialized = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
            boolean r4 = super.onDependentViewChanged(r1, r2, r3);
            if (this.initialized == false) goto L5;
        L7:
            return r4;
        L5:
            if ((r3 instanceof AppBarLayout) == false) goto L7;
            this.initialized = true;
            setAppBarLayoutTransparent((AppBarLayout) r3);
            goto L7
        }

        private void setAppBarLayoutTransparent(AppBarLayout r1) {
            r1.setBackgroundColor(0);
            r1.setTargetElevation(0.0f);
        }
    }

    private int defaultIfZero(int r1, int r2) {
        if (r1 == 0) goto L4;
        return r1;
    L4:
        return r2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r1) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r1) {
    }

    static /* synthetic */ AccessibilityManager access$000(SearchBar r0) {
        return r0.accessibilityManager;
    }

    static /* synthetic */ AccessibilityManagerCompat.TouchExplorationStateChangeListener access$100(SearchBar r0) {
        return r0.touchExplorationStateChangeListener;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m252lambda$new$0$comgoogleandroidmaterialsearchSearchBar(boolean r1) {
        setFocusableInTouchMode(r1);
    }

    public SearchBar(Context r2) {
        this(r2, null);
    }

    public SearchBar(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.materialSearchBarStyle);
    }

    public SearchBar(Context r10, AttributeSet r11, int r12) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r6), r11, r12);
        this.menuResId = -1;
        this.touchExplorationStateChangeListener = new SearchBar$$ExternalSyntheticLambda0(this);
        Context r7 = getContext();
        validateAttributes(r11);
        this.defaultNavigationIcon = AppCompatResources.getDrawable(r7, R.drawable.ic_search_black_24);
        this.searchBarAnimationHelper = new SearchBarAnimationHelper();
        TypedArray r0 = ThemeEnforcement.obtainStyledAttributes(r7, r11, R.styleable.SearchBar, r12, r6, new int[0]);
        ShapeAppearanceModel r13 = ShapeAppearanceModel.builder(r7, r11, r12, r6).build();
        float r14 = r0.getDimension(R.styleable.SearchBar_elevation, 0.0f);
        this.defaultMarginsEnabled = r0.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.defaultScrollFlagsEnabled = r0.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean r1 = r0.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.forceDefaultNavigationOnClickListener = r0.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.tintNavigationIcon = r0.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        if (r0.hasValue(R.styleable.SearchBar_navigationIconTint) == false) goto L5;
        this.navigationIconTint = Integer.valueOf(r0.getColor(R.styleable.SearchBar_navigationIconTint, -1));
    L5:
        int r15 = r0.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String r3 = r0.getString(R.styleable.SearchBar_android_text);
        String r4 = r0.getString(R.styleable.SearchBar_android_hint);
        float r5 = r0.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int r8 = r0.getColor(R.styleable.SearchBar_strokeColor, 0);
        r0.recycle();
        if (r1 == true) goto L8;
        initNavigationIcon();
    L8:
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(r7).inflate(R.layout.mtrl_search_bar, this);
        this.layoutInflated = true;
        this.textView = (TextView) findViewById(R.id.search_bar_text_view);
        ViewCompat.setElevation(this, r14);
        initTextView(r15, r3, r4);
        initBackground(r13, r14, r5, r8);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setupTouchExplorationStateChangeListener();
    }

    private void setupTouchExplorationStateChangeListener() {
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEnabled() == true) goto L7;
    L9:
        addOnAttachStateChangeListener(new AnonymousClass1(this));
        return;
    L7:
        if (this.accessibilityManager.isTouchExplorationEnabled() == false) goto L9;
        setFocusableInTouchMode(true);
        goto L9
    }

    private void validateAttributes(AttributeSet r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getAttributeValue(NAMESPACE_APP, "title") != null) goto L12;
        if (r2.getAttributeValue(NAMESPACE_APP, "subtitle") != null) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
    L12:
        throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
    }

    private void initNavigationIcon() {
        if (getNavigationIcon() != null) goto L5;
        Drawable r0 = this.defaultNavigationIcon;
    L6:
        setNavigationIcon(r0);
        setNavigationIconDecorative(true);
        return;
    L5:
        r0 = getNavigationIcon();
        goto L6
    }

    private void initTextView(int r2, String r3, String r4) {
        if (r2 == (-1)) goto L5;
        TextViewCompat.setTextAppearance(this.textView, r2);
    L5:
        setText(r3);
        setHint(r4);
        if (getNavigationIcon() != null) goto L9;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        return;
    }

    private void initBackground(ShapeAppearanceModel r2, float r3, float r4, int r5) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r2);
        this.backgroundShape = r0;
        r0.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(r3);
        if (r4 < 0.0f) goto L5;
        this.backgroundShape.setStroke(r4, r5);
    L5:
        int r6 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r7 = MaterialColors.getColor(this, R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(r6));
        ColorStateList r8 = ColorStateList.valueOf(r7);
        MaterialShapeDrawable r9 = this.backgroundShape;
        ViewCompat.setBackground(this, new RippleDrawable(r8, r9, r9));
    }

    private ColorStateList getCompatBackgroundColorStateList(int r6, int r7) {
        int[][] r0 = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[0]};
        int r8 = MaterialColors.layer(r6, r7);
        return new ColorStateList(r0, new int[]{r8, r8, r6});
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (this.layoutInflated == true) goto L5;
    L9:
        super.addView(r2, r3, r4);
        return;
    L5:
        if (this.centerView != null) goto L9;
        if ((r2 instanceof ActionMenuView) == true) goto L9;
        this.centerView = r2;
        r2.setAlpha(0.0f);
        goto L9
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeDrawable r0 = this.backgroundShape;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        r4.setClassName(EditText.class.getCanonicalName());
        CharSequence r0 = getText();
        boolean r1 = TextUtils.isEmpty(r0);
        r4.setHintText(getHint());
        r4.setShowingHintText(r1);
        if (r1 == false) goto L5;
        r0 = getHint();
    L5:
        r4.setText(r0);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener r2) {
        if (this.forceDefaultNavigationOnClickListener == false) goto L5;
        return;
    L5:
        super.setNavigationOnClickListener(r2);
        if (r2 != null) goto L8;
        boolean r3 = true;
    L9:
        setNavigationIconDecorative(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r1) {
        super.setNavigationIcon(maybeTintNavigationIcon(r1));
    }

    private Drawable maybeTintNavigationIcon(Drawable r2) {
        if (this.tintNavigationIcon == false) goto L16;
        if (r2 == null) goto L17;
        Integer r0 = this.navigationIconTint;
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
    L14:
        Drawable r3 = DrawableCompat.wrap(r2.mutate());
        DrawableCompat.setTint(r3, r1);
        return r3;
    L10:
        if (r2 != this.defaultNavigationIcon) goto L12;
        int r4 = R.attr.colorOnSurfaceVariant;
    L13:
        r1 = MaterialColors.getColor(this, r4);
        goto L14
    L12:
        r4 = R.attr.colorOnSurface;
        goto L13
    L17:
        return r2;
    L16:
        return r2;
    }

    private void setNavigationIconDecorative(boolean r3) {
        ImageButton r0 = ToolbarUtils.getNavigationIconButton(this);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setClickable(!r3);
        r0.setFocusable(!r3);
        Drawable r1 = r0.getBackground();
        if (r1 == null) goto L8;
        this.originalNavigationIconBackground = r1;
    L8:
        if (r3 == false) goto L10;
        Drawable r2 = null;
    L11:
        r0.setBackgroundDrawable(r2);
        return;
    L10:
        r2 = this.originalNavigationIconBackground;
        goto L11
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int r1) {
        super.inflateMenu(r1);
        this.menuResId = r1;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        measureCenterView(r1, r2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        layoutCenterView();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled == true) goto L5;
        return;
    L5:
        if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        Resources r0 = getResources();
        int r1 = r0.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
        int r2 = r0.getDimensionPixelSize(R.dimen.m3_searchbar_margin_vertical);
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) getLayoutParams();
        r3.leftMargin = defaultIfZero(r3.leftMargin, r1);
        r3.topMargin = defaultIfZero(r3.topMargin, r2);
        r3.rightMargin = defaultIfZero(r3.rightMargin, r1);
        r3.bottomMargin = defaultIfZero(r3.bottomMargin, r2);
        return;
    }

    private void setOrClearDefaultScrollFlags() {
        if ((getLayoutParams() instanceof AppBarLayout.LayoutParams) == false) goto L13;
        AppBarLayout.LayoutParams r0 = (AppBarLayout.LayoutParams) getLayoutParams();
        if (this.defaultScrollFlagsEnabled == false) goto L10;
        if (r0.getScrollFlags() != 0) goto L14;
        r0.setScrollFlags(53);
        return;
    L14:
        return;
    L10:
        if (r0.getScrollFlags() != 53) goto L16;
        r0.setScrollFlags(0);
        return;
    L16:
        return;
    }

    private void measureCenterView(int r1, int r2) {
        View r0 = this.centerView;
        if (r0 == null) goto L6;
        r0.measure(r1, r2);
        return;
    }

    private void layoutCenterView() {
        View r0 = this.centerView;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getMeasuredWidth();
        int r5 = (getMeasuredWidth() / 2) - (r1 / 2);
        int r7 = r5 + r1;
        int r2 = this.centerView.getMeasuredHeight();
        int r6 = (getMeasuredHeight() / 2) - (r2 / 2);
        View r4 = this.centerView;
        layoutChild(r4, r5, r6, r7, r6 + r2);
    }

    private void layoutChild(View r3, int r4, int r5, int r6, int r7) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        r3.layout(getMeasuredWidth() - r6, r5, getMeasuredWidth() - r4, r7);
        return;
    L5:
        r3.layout(r4, r5, r6, r7);
    }

    public View getCenterView() {
        return this.centerView;
    }

    public void setCenterView(View r2) {
        View r0 = this.centerView;
        if (r0 == null) goto L5;
        removeView(r0);
        this.centerView = null;
    L5:
        if (r2 == null) goto L8;
        addView(r2);
        return;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public CharSequence getText() {
        return this.textView.getText();
    }

    public void setText(CharSequence r1) {
        this.textView.setText(r1);
    }

    public void setText(int r1) {
        this.textView.setText(r1);
    }

    public void clearText() {
        this.textView.setText("");
    }

    public CharSequence getHint() {
        return this.textView.getHint();
    }

    public void setHint(CharSequence r1) {
        this.textView.setHint(r1);
    }

    public void setHint(int r1) {
        this.textView.setHint(r1);
    }

    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    public void setStrokeColor(int r2) {
        if (getStrokeColor() == r2) goto L6;
        this.backgroundShape.setStrokeColor(ColorStateList.valueOf(r2));
        return;
    }

    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    public void setStrokeWidth(float r2) {
        if (getStrokeWidth() == r2) goto L6;
        this.backgroundShape.setStrokeWidth(r2);
        return;
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public void setDefaultScrollFlagsEnabled(boolean r1) {
        this.defaultScrollFlagsEnabled = r1;
        setOrClearDefaultScrollFlags();
    }

    /* JADX INFO: renamed from: lambda$startOnLoadAnimation$1$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m253x58362b63() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    public void startOnLoadAnimation() {
        post(new SearchBar$$ExternalSyntheticLambda1(this));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    public void setOnLoadAnimationFadeInEnabled(boolean r1) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(r1);
    }

    public void addOnLoadAnimationCallback(OnLoadAnimationCallback r1) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(r1);
    }

    public boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback r1) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(r1);
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean expand(View r2) {
        return expand(r2, null);
    }

    public boolean expand(View r2, AppBarLayout r3) {
        return expand(r2, r3, false);
    }

    public boolean expand(View r2, AppBarLayout r3, boolean r4) {
        if (r2.getVisibility() == 0) goto L7;
        if (isExpanding() == true) goto L7;
    L8:
        this.searchBarAnimationHelper.startExpandAnimation(this, r2, r3, r4);
        return true;
    L7:
        if (isCollapsing() == true) goto L8;
        return false;
    }

    public void addExpandAnimationListener(AnimatorListenerAdapter r1) {
        this.searchBarAnimationHelper.addExpandAnimationListener(r1);
    }

    public boolean removeExpandAnimationListener(AnimatorListenerAdapter r1) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(r1);
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean collapse(View r2) {
        return collapse(r2, null);
    }

    public boolean collapse(View r2, AppBarLayout r3) {
        return collapse(r2, r3, false);
    }

    public boolean collapse(View r2, AppBarLayout r3, boolean r4) {
        if (r2.getVisibility() != 0) goto L7;
        if (isCollapsing() == true) goto L7;
    L8:
        this.searchBarAnimationHelper.startCollapseAnimation(this, r2, r3, r4);
        return true;
    L7:
        if (isExpanding() == true) goto L8;
        return false;
    }

    public void addCollapseAnimationListener(AnimatorListenerAdapter r1) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(r1);
    }

    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter r1) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(r1);
    }

    int getMenuResId() {
        return this.menuResId;
    }

    float getCompatElevation() {
        MaterialShapeDrawable r0 = this.backgroundShape;
        if (r0 == null) goto L6;
        return r0.getElevation();
    L6:
        return ViewCompat.getElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        CharSequence r2 = getText();
        if (r2 != null) goto L5;
        String r3 = null;
    L6:
        r0.text = r3;
        return r0;
    L5:
        r3 = r2.toString();
        goto L6
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setText(r3.text);
    }
}
