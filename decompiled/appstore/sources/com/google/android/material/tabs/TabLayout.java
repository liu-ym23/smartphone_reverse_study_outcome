package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.g0;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.util.d;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.e;
import androidx.core.view.k;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.common.primitives.Ints;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = 0;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools$Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;

    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;

    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools$Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;

    @Nullable
    ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        public AdapterChangeListener(TabLayout r10) {
            this.this$0 = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r10, @Nullable PagerAdapter r11, @Nullable PagerAdapter r12) {
            TabLayout r13 = this.this$0;
            if (r13.viewPager != r10) goto L6;
            r13.setPagerAdapter(r12, this.autoRefresh);
            return;
        }

        public void setAutoRefresh(boolean r10) {
            this.autoRefresh = r10;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T r10);

        void onTabSelected(T r10);

        void onTabUnselected(T r10);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ TabLayout this$0;

        public PagerAdapterObserver(TabLayout r10) {
            this.this$0 = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;
        int selectedPosition;
        float selectionOffset;
        final /* synthetic */ TabLayout this$0;

        public SlidingTabIndicator(TabLayout r10, Context r11) {
            this.this$0 = r10;
            super(r11);
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            setWillNotDraw(false);
        }

        public static /* synthetic */ void access$1300(SlidingTabIndicator r10, View r11, View r12, float r13) {
            r10.tweenIndicatorPosition(r11, r12, r13);
        }

        private void jumpIndicatorToSelectedPosition() {
            View r10 = getChildAt(this.selectedPosition);
            TabIndicatorInterpolator r11 = TabLayout.access$1200(this.this$0);
            TabLayout r12 = this.this$0;
            r11.setIndicatorBoundsForTab(r12, r10, r12.tabSelectedIndicator);
        }

        private void tweenIndicatorPosition(View r10, View r11, float r12) {
            if (r10 != null) goto L4;
        L6:
            Drawable r13 = this.this$0.tabSelectedIndicator;
            r13.setBounds(-1, r13.getBounds().top, -1, this.this$0.tabSelectedIndicator.getBounds().bottom);
        L7:
            ViewCompat.g0(this);
            return;
        L4:
            if (r10.getWidth() <= 0) goto L6;
            TabIndicatorInterpolator r14 = TabLayout.access$1200(this.this$0);
            TabLayout r15 = this.this$0;
            r14.setIndicatorBoundsForOffset(r15, r10, r11, r12, r15.tabSelectedIndicator);
            goto L7
        }

        private void updateOrRecreateIndicatorAnimation(boolean r10, final int r11, int r12) {
            final View r13 = getChildAt(this.selectedPosition);
            final View r14 = getChildAt(r11);
            if (r14 != null) goto L6;
            jumpIndicatorToSelectedPosition();
            return;
        L6:
            ValueAnimator.AnimatorUpdateListener r15 = new AnonymousClass1(this, r13, r14);
            if (r10 == false) goto L9;
            ValueAnimator r16 = new ValueAnimator();
            this.indicatorAnimator = r16;
            r16.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            r16.setDuration(r12);
            r16.setFloatValues(new float[]{0.0f, 1.0f});
            r16.addUpdateListener(r15);
            r16.addListener(new AnonymousClass2(this, r11));
            r16.start();
            return;
        L9:
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r15);
        }

        public void animateIndicatorToPosition(int r10, int r11) {
            ValueAnimator r12 = this.indicatorAnimator;
            if (r12 != null) goto L5;
        L7:
            updateOrRecreateIndicatorAnimation(true, r10, r11);
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        public boolean childrenNeedLayout() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            if (getChildAt(r11).getWidth() <= 0) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas r10) {
            int r11 = this.this$0.tabSelectedIndicator.getBounds().height();
            if (r11 >= 0) goto L5;
            r11 = this.this$0.tabSelectedIndicator.getIntrinsicHeight();
        L5:
            int r12 = this.this$0.tabIndicatorGravity;
            if (r12 != 0) goto L8;
            int r13 = getHeight() - r11;
            r11 = getHeight();
        L18:
            if (this.this$0.tabSelectedIndicator.getBounds().width() <= 0) goto L23;
            Rect r14 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r14.left, r13, r14.right, r11);
            TabLayout r15 = this.this$0;
            Drawable r16 = r15.tabSelectedIndicator;
            if (TabLayout.access$1400(r15) == 0) goto L22;
            r16 = a.l(r16);
            a.h(r16, TabLayout.access$1400(this.this$0));
        L22:
            r16.draw(r10);
        L23:
            super.draw(r10);
            return;
        L8:
            if (r12 == 1) goto L15;
            r13 = 0;
            if (r12 == 2) goto L18;
            if (r12 == 3) goto L14;
            r11 = 0;
            goto L18
        L14:
            r11 = getHeight();
            goto L18
        L15:
            r13 = (getHeight() - r11) / 2;
            r11 = (getHeight() + r11) / 2;
            goto L18
        }

        public float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            ValueAnimator r15 = this.indicatorAnimator;
            if (r15 != null) goto L5;
        L7:
            jumpIndicatorToSelectedPosition();
            return;
        L5:
            if (r15.isRunning() == false) goto L7;
            updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
            return;
        L5:
            TabLayout r12 = this.this$0;
            boolean r13 = true;
            if (r12.tabGravity != 1) goto L8;
        L9:
            int r14 = getChildCount();
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
        L10:
            if (r16 >= r14) goto L15;
            View r18 = getChildAt(r16);
            if (r18.getVisibility() != 0) goto L14;
            r17 = Math.max(r17, r18.getMeasuredWidth());
        L14:
            r16 = r16 + 1;
            goto L10
        L15:
            if (r17 > 0) goto L18;
            return;
        L18:
            if ((r17 * r14) > (getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2))) goto L28;
            boolean r19 = false;
        L20:
            if (r15 >= r14) goto L27;
            LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) getChildAt(r15).getLayoutParams();
            if (r20.width == r17) goto L24;
        L25:
            r20.width = r17;
            r20.weight = 0.0f;
            r19 = true;
        L26:
            r15 = r15 + 1;
            goto L20
        L24:
            if (r20.weight == 0.0f) goto L26;
        L27:
            r13 = r19;
        L29:
            if (r13 == false) goto L39;
            super.onMeasure(r10, r11);
            return;
        L39:
            return;
        L28:
            TabLayout r21 = this.this$0;
            r21.tabGravity = 0;
            r21.updateTabViews(false);
            goto L29
        L8:
            if (r12.mode == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r10) {
            super.onRtlPropertiesChanged(r10);
        }

        public void setIndicatorPositionFromTabPosition(int r10, float r11) {
            ValueAnimator r12 = this.indicatorAnimator;
            if (r12 != null) goto L5;
        L7:
            this.selectedPosition = r10;
            this.selectionOffset = r11;
            tweenIndicatorPosition(getChildAt(r10), getChildAt(this.selectedPosition + 1), this.selectionOffset);
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        public void setSelectedIndicatorHeight(int r10) {
            Rect r11 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r11.left, 0, r11.right, r10);
            requestLayout();
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @Nullable
        private CharSequence contentDesc;

        @Nullable
        private View customView;

        @Nullable
        private Drawable icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private int f10330id;

        @LabelVisibility
        private int labelVisibilityMode;

        @Nullable
        public TabLayout parent;
        private int position;

        @Nullable
        private Object tag;

        @Nullable
        private CharSequence text;

        @NonNull
        public TabView view;

        public Tab() {
            this.position = -1;
            this.labelVisibilityMode = 1;
            this.f10330id = -1;
        }

        public static /* synthetic */ int access$000(Tab r10) {
            return r10.f10330id;
        }

        public static /* synthetic */ int access$1100(Tab r10) {
            return r10.labelVisibilityMode;
        }

        public static /* synthetic */ CharSequence access$200(Tab r10) {
            return r10.contentDesc;
        }

        public static /* synthetic */ CharSequence access$300(Tab r10) {
            return r10.text;
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return TabView.access$900(this.view);
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView r10 = this.view;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.f10330id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return TabView.access$700(this.view);
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout r10 = this.parent;
            if (r10 == null) goto L10;
            if (r10.getSelectedTabPosition() != this.position) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            TabView.access$800(this.view);
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.f10330id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout r10 = this.parent;
            if (r10 == null) goto L7;
            r10.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int r10) {
            TabLayout r11 = this.parent;
            if (r11 == null) goto L7;
            return setContentDescription(r11.getResources().getText(r10));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View r10) {
            this.customView = r10;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable r10) {
            this.icon = r10;
            TabLayout r11 = this.parent;
            if (r11.tabGravity != 1) goto L5;
        L6:
            r11.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$500(this.view) == false) goto L14;
            if (TabView.access$600(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r11.mode != 2) goto L7;
            goto L6
        }

        @NonNull
        public Tab setId(int r10) {
            this.f10330id = r10;
            TabView r11 = this.view;
            if (r11 == null) goto L5;
            r11.setId(r10);
        L5:
            return this;
        }

        public void setPosition(int r10) {
            this.position = r10;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int r10) {
            this.labelVisibilityMode = r10;
            TabLayout r11 = this.parent;
            if (r11.tabGravity != 1) goto L5;
        L6:
            r11.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$500(this.view) == false) goto L14;
            if (TabView.access$600(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r11.mode != 2) goto L7;
            goto L6
        }

        @NonNull
        public Tab setTag(@Nullable Object r10) {
            this.tag = r10;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence r10) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r10;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r10) == true) goto L7;
            this.view.setContentDescription(r10);
            goto L7
        }

        public void updateView() {
            TabView r10 = this.view;
            if (r10 == null) goto L6;
            r10.update();
            return;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int r10) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r10, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence r10) {
            this.contentDesc = r10;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int r10) {
            TabLayout r11 = this.parent;
            if (r11 == null) goto L7;
            return setText(r11.getResources().getText(r10));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int r10) {
            TabLayout r11 = this.parent;
            if (r11 == null) goto L7;
            return setIcon(c.a.b(r11.getContext(), r10));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r10) {
            this.tabLayoutRef = new WeakReference(r10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
            TabLayout r13 = this.tabLayoutRef.get();
            if (r13 == null) goto L17;
            int r14 = this.scrollState;
            boolean r15 = false;
            if (r14 == 2) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r14 == 2) goto L13;
        L14:
            r15 = true;
        L15:
            r13.setScrollPosition(r10, r11, r16, r15);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r16 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            TabLayout r11 = this.tabLayoutRef.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.scrollState;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.selectTab(r11.getTabAt(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {

        @Nullable
        private View badgeAnchorView;

        @Nullable
        private BadgeDrawable badgeDrawable;

        @Nullable
        private Drawable baseBackgroundDrawable;

        @Nullable
        private ImageView customIconView;

        @Nullable
        private TextView customTextView;

        @Nullable
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;
        final /* synthetic */ TabLayout this$0;

        public TabView(@NonNull TabLayout r10, Context r11) {
            this.this$0 = r10;
            super(r11);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(r11);
            ViewCompat.D0(this, r10.tabPaddingStart, r10.tabPaddingTop, r10.tabPaddingEnd, r10.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r10.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.E0(this, k.b(getContext(), 1002));
        }

        public static /* synthetic */ void access$100(TabView r10, Context r11) {
            r10.updateBackgroundDrawable(r11);
        }

        public static /* synthetic */ void access$1000(TabView r10, View r11) {
            r10.tryUpdateBadgeDrawableBounds(r11);
        }

        public static /* synthetic */ void access$400(TabView r10, Canvas r11) {
            r10.drawBackground(r11);
        }

        public static /* synthetic */ boolean access$500(TabView r10) {
            return r10.hasBadgeDrawable();
        }

        public static /* synthetic */ BadgeDrawable access$600(TabView r10) {
            return r10.badgeDrawable;
        }

        public static /* synthetic */ BadgeDrawable access$700(TabView r10) {
            return r10.getOrCreateBadge();
        }

        public static /* synthetic */ void access$800(TabView r10) {
            r10.removeBadge();
        }

        public static /* synthetic */ BadgeDrawable access$900(TabView r10) {
            return r10.getBadge();
        }

        private void addOnLayoutChangeListener(@Nullable final View r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r10.addOnLayoutChangeListener(new AnonymousClass1(this, r10));
        }

        private float approximateLineWidth(@NonNull Layout r10, int r11, float r12) {
            return r10.getLineWidth(r11) * (r12 / r10.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean r10) {
            setClipChildren(r10);
            setClipToPadding(r10);
            ViewGroup r11 = (ViewGroup) getParent();
            if (r11 == null) goto L6;
            r11.setClipChildren(r10);
            r11.setClipToPadding(r10);
            return;
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout r10 = new FrameLayout(getContext());
            r10.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r10;
        }

        private void drawBackground(@NonNull Canvas r10) {
            Drawable r11 = this.baseBackgroundDrawable;
            if (r11 == null) goto L6;
            r11.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r10);
            return;
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View r10) {
            if (r10 == this.iconView) goto L8;
            if (r10 == this.textView) goto L8;
            return null;
        L8:
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
            return null;
        L10:
            return (FrameLayout) r10.getParent();
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable != null) goto L5;
            this.badgeDrawable = BadgeDrawable.create(getContext());
        L5:
            tryUpdateBadgeAnchor();
            BadgeDrawable r10 = this.badgeDrawable;
            if (r10 == null) goto L9;
            return r10;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean hasBadgeDrawable() {
            if (this.badgeDrawable == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void inflateAndAddDefaultIconView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r10 = createPreApi18BadgeAnchorRoot();
            addView(r10, 0);
            ViewGroup r11 = r10;
        L6:
            ImageView r12 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, r11, false);
            this.iconView = r12;
            r11.addView(r12, 0);
            return;
        L5:
            r11 = this;
            goto L6
        }

        private void inflateAndAddDefaultTextView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r10 = createPreApi18BadgeAnchorRoot();
            addView(r10);
            ViewGroup r11 = r10;
        L6:
            TextView r12 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, r11, false);
            this.textView = r12;
            r11.addView(r12);
            return;
        L5:
            r11 = this;
            goto L6
        }

        private void removeBadge() {
            if (this.badgeAnchorView == null) goto L5;
            tryRemoveBadgeFromAnchor();
        L5:
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View r10) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r10 == null) goto L8;
            clipViewToPaddingForBadge(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r10, getCustomParentForBadge(r10));
            this.badgeAnchorView = r10;
            return;
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            clipViewToPaddingForBadge(true);
            View r10 = this.badgeAnchorView;
            if (r10 == null) goto L9;
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r10);
            this.badgeAnchorView = null;
            return;
        }

        private void tryUpdateBadgeAnchor() {
            if (hasBadgeDrawable() == true) goto L6;
            return;
        L6:
            if (this.customView == null) goto L9;
            tryRemoveBadgeFromAnchor();
            return;
        L9:
            if (this.iconView == null) goto L19;
            Tab r10 = this.tab;
            if (r10 == null) goto L19;
            if (r10.getIcon() == null) goto L19;
            View r11 = this.badgeAnchorView;
            ImageView r12 = this.iconView;
            if (r11 == r12) goto L17;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.iconView);
            return;
        L17:
            tryUpdateBadgeDrawableBounds(r12);
            return;
        L19:
            if (this.textView == null) goto L28;
            Tab r13 = this.tab;
            if (r13 == null) goto L28;
            if (r13.getTabLabelVisibility() != 1) goto L28;
            View r14 = this.badgeAnchorView;
            TextView r15 = this.textView;
            if (r14 == r15) goto L27;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.textView);
            return;
        L27:
            tryUpdateBadgeDrawableBounds(r15);
            return;
        L28:
            tryRemoveBadgeFromAnchor();
        }

        private void tryUpdateBadgeDrawableBounds(@NonNull View r10) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r10 != this.badgeAnchorView) goto L9;
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r10, getCustomParentForBadge(r10));
            return;
        }

        private void updateBackgroundDrawable(Context r10) {
            int r11 = this.this$0.tabBackgroundResId;
            GradientDrawable r12 = null;
            if (r11 == 0) goto L9;
            Drawable r13 = c.a.b(r10, r11);
            this.baseBackgroundDrawable = r13;
            if (r13 != null) goto L7;
        L10:
            GradientDrawable r14 = new GradientDrawable();
            r14.setColor(0);
            Drawable r15 = r14;
            if (this.this$0.tabRippleColorStateList == null) goto L19;
            GradientDrawable r16 = new GradientDrawable();
            r16.setCornerRadius(1.0E-5f);
            r16.setColor(-1);
            ColorStateList r17 = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            boolean r18 = this.this$0.unboundedRipple;
            GradientDrawable r19 = r14;
            if (r18 == false) goto L15;
            r19 = null;
        L15:
            if (r18 == true) goto L18;
            r12 = r16;
        L18:
            r15 = new RippleDrawable(r17, r19, r12);
        L19:
            ViewCompat.t0(this, r15);
            this.this$0.invalidate();
            return;
        L7:
            if (r13.isStateful() == false) goto L10;
            this.baseBackgroundDrawable.setState(getDrawableState());
            goto L10
        L9:
            this.baseBackgroundDrawable = null;
            goto L10
        }

        private void updateTextAndIcon(@Nullable TextView r10, @Nullable ImageView r11) {
            Tab r12 = this.tab;
            CharSequence r13 = null;
            if (r12 != null) goto L5;
        L7:
            Drawable r14 = null;
        L8:
            Tab r15 = this.tab;
            if (r15 == null) goto L11;
            CharSequence r16 = r15.getText();
        L13:
            if (r11 == null) goto L17;
            if (r14 == null) goto L16;
            r11.setImageDrawable(r14);
            r11.setVisibility(0);
            setVisibility(0);
            goto L17
        L16:
            r11.setVisibility(8);
            r11.setImageDrawable(null);
        L17:
            boolean r17 = TextUtils.isEmpty(r16);
            if (r10 == null) goto L26;
            if (r17 == true) goto L25;
            r10.setText(r16);
            if (Tab.access$1100(this.tab) != 1) goto L23;
            r10.setVisibility(0);
        L24:
            setVisibility(0);
            goto L26
        L23:
            r10.setVisibility(8);
            goto L24
        L25:
            r10.setVisibility(8);
            r10.setText(null);
        L26:
            if (r11 == null) goto L41;
            ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            if (r17 == false) goto L30;
        L32:
            int r19 = 0;
        L34:
            if (this.this$0.inlineLabel == false) goto L39;
            if (r19 == e.a(r18)) goto L41;
            e.c(r18, r19);
            r18.bottomMargin = 0;
            r11.setLayoutParams(r18);
            r11.requestLayout();
            goto L41
        L39:
            if (r19 == r18.bottomMargin) goto L41;
            r18.bottomMargin = r19;
            e.c(r18, 0);
            r11.setLayoutParams(r18);
            r11.requestLayout();
            goto L41
        L30:
            if (r11.getVisibility() != 0) goto L32;
            r19 = (int) ViewUtils.dpToPx(getContext(), 8);
        L41:
            Tab r20 = this.tab;
            if (r20 == null) goto L44;
            r13 = Tab.access$200(r20);
        L44:
            if (r17 == false) goto L47;
            r16 = r13;
        L47:
            g0.a(this, r16);
            return;
        L11:
            r16 = null;
            goto L13
        L5:
            if (r12.getIcon() == null) goto L7;
            r14 = a.l(this.tab.getIcon()).mutate();
            goto L8
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r10 = getDrawableState();
            Drawable r11 = this.baseBackgroundDrawable;
            if (r11 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r12 == false) goto L11;
            invalidate();
            this.this$0.invalidate();
            return;
        L11:
            return;
        L5:
            if (r11.isStateful() == false) goto L7;
            r12 = this.baseBackgroundDrawable.setState(r10);
            goto L8
        }

        public int getContentHeight() {
            int r10 = 0;
            View[] r11 = {this.textView, this.iconView, this.customView};
            int r12 = 0;
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r10 >= 3) goto L17;
            View r15 = r11[r10];
            if (r15 == null) goto L15;
            if (r15.getVisibility() != 0) goto L15;
            if (r14 == false) goto L10;
            r13 = Math.min(r13, r15.getTop());
        L11:
            if (r14 == false) goto L13;
            r12 = Math.max(r12, r15.getBottom());
        L14:
            r14 = true;
            goto L15
        L13:
            r12 = r15.getBottom();
            goto L14
        L10:
            r13 = r15.getTop();
        L15:
            r10 = r10 + 1;
            goto L3
        L17:
            return r12 - r13;
        }

        public int getContentWidth() {
            int r10 = 0;
            View[] r11 = {this.textView, this.iconView, this.customView};
            int r12 = 0;
            int r13 = 0;
            boolean r14 = false;
        L3:
            if (r10 >= 3) goto L17;
            View r15 = r11[r10];
            if (r15 == null) goto L15;
            if (r15.getVisibility() != 0) goto L15;
            if (r14 == false) goto L10;
            r13 = Math.min(r13, r15.getLeft());
        L11:
            if (r14 == false) goto L13;
            r12 = Math.max(r12, r15.getRight());
        L14:
            r14 = true;
            goto L15
        L13:
            r12 = r15.getRight();
            goto L14
        L10:
            r13 = r15.getLeft();
        L15:
            r10 = r10 + 1;
            goto L3
        L17:
            return r12 - r13;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            BadgeDrawable r11 = this.badgeDrawable;
            if (r11 != null) goto L5;
        L7:
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.B0(r10);
            r12.Y(AccessibilityNodeInfoCompat.c.a(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r12.W(false);
            r12.O(AccessibilityNodeInfoCompat.a.f2742i);
        L10:
            r12.p0(getResources().getString(R.string.item_view_role_description));
            return;
        L5:
            if (r11.isVisible() == false) goto L7;
            r10.setContentDescription(getContentDescription() + ", " + this.badgeDrawable.getContentDescription());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            int r12 = View.MeasureSpec.getSize(r10);
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = this.this$0.getTabMaxWidth();
            if (r14 <= 0) goto L7;
            if (r13 == 0) goto L6;
            if (r12 <= r14) goto L7;
        L6:
            r10 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r10, r11);
            if (this.textView == null) goto L34;
            float r15 = this.this$0.tabTextSize;
            int r16 = this.defaultMaxLines;
            ImageView r17 = this.iconView;
            if (r17 != null) goto L12;
        L14:
            TextView r18 = this.textView;
            if (r18 != null) goto L17;
        L19:
            float r19 = this.textView.getTextSize();
            int r20 = this.textView.getLineCount();
            int r21 = TextViewCompat.d(this.textView);
            if (r15 != r19) goto L24;
            if (r21 < 0) goto L35;
            if (r16 != r21) goto L24;
            return;
        L35:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r15 <= r19) goto L32;
            if (r20 != 1) goto L32;
            Layout r22 = this.textView.getLayout();
            if (r22 != null) goto L30;
            return;
        L30:
            if (approximateLineWidth(r22, 0, r15) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L32;
            return;
        L32:
            this.textView.setTextSize(0, r15);
            this.textView.setMaxLines(r16);
            super.onMeasure(r10, r11);
            return;
        L17:
            if (r18.getLineCount() <= 1) goto L19;
            r15 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r17.getVisibility() != 0) goto L14;
            r16 = 1;
            goto L19
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r10 = super.performClick();
            if (this.tab == null) goto L8;
            if (r10 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.tab.select();
            return true;
        L8:
            return r10;
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean r10) {
            isSelected();
            super.setSelected(r10);
            TextView r11 = this.textView;
            if (r11 == null) goto L5;
            r11.setSelected(r10);
        L5:
            ImageView r12 = this.iconView;
            if (r12 == null) goto L8;
            r12.setSelected(r10);
        L8:
            View r13 = this.customView;
            if (r13 == null) goto L12;
            r13.setSelected(r10);
            return;
        }

        public void setTab(@Nullable Tab r10) {
            if (r10 == this.tab) goto L6;
            this.tab = r10;
            update();
            return;
        }

        public final void update() {
            Tab r10 = this.tab;
            Drawable r11 = null;
            if (r10 == null) goto L5;
            View r12 = r10.getCustomView();
        L6:
            if (r12 == null) goto L22;
            ViewParent r13 = r12.getParent();
            if (r13 == this) goto L12;
            if (r13 == null) goto L11;
            ((ViewGroup) r13).removeView(r12);
        L11:
            addView(r12);
        L12:
            this.customView = r12;
            TextView r14 = this.textView;
            if (r14 == null) goto L15;
            r14.setVisibility(8);
        L15:
            ImageView r15 = this.iconView;
            if (r15 == null) goto L18;
            r15.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L18:
            TextView r16 = (TextView) r12.findViewById(android.R.id.text1);
            this.customTextView = r16;
            if (r16 == null) goto L21;
            this.defaultMaxLines = TextViewCompat.d(r16);
        L21:
            this.customIconView = (ImageView) r12.findViewById(android.R.id.icon);
        L27:
            if (this.customView == null) goto L29;
            TextView r17 = this.customTextView;
            if (r17 == null) goto L49;
        L50:
            updateTextAndIcon(r17, this.customIconView);
        L51:
            if (r10 != null) goto L53;
        L55:
            if (r10 != null) goto L57;
        L59:
            boolean r18 = false;
        L60:
            setSelected(r18);
            return;
        L57:
            if (r10.isSelected() == false) goto L59;
            r18 = true;
            goto L60
        L53:
            if (TextUtils.isEmpty(Tab.access$200(r10)) == true) goto L55;
            setContentDescription(Tab.access$200(r10));
            goto L55
        L49:
            if (this.customIconView == null) goto L51;
        L29:
            if (this.iconView != null) goto L31;
            inflateAndAddDefaultIconView();
        L31:
            if (r10 != null) goto L33;
        L35:
            if (r11 == null) goto L40;
            a.i(r11, this.this$0.tabIconTint);
            PorterDuff.Mode r19 = this.this$0.tabIconTintMode;
            if (r19 == null) goto L40;
            a.j(r11, r19);
        L40:
            if (this.textView != null) goto L42;
            inflateAndAddDefaultTextView();
            this.defaultMaxLines = TextViewCompat.d(this.textView);
        L42:
            TextViewCompat.n(this.textView, this.this$0.tabTextAppearance);
            ColorStateList r20 = this.this$0.tabTextColors;
            if (r20 == null) goto L45;
            this.textView.setTextColor(r20);
        L45:
            updateTextAndIcon(this.textView, this.iconView);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
            goto L51
        L33:
            if (r10.getIcon() == null) goto L35;
            r11 = a.l(r10.getIcon()).mutate();
            goto L35
        L22:
            View r21 = this.customView;
            if (r21 == null) goto L25;
            removeView(r21);
            this.customView = null;
        L25:
            this.customTextView = null;
            this.customIconView = null;
            goto L27
        L5:
            r12 = null;
            goto L6
        }

        public final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r10 = this.customTextView;
            if (r10 == null) goto L5;
        L8:
            updateTextAndIcon(r10, this.customIconView);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView);
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager r10) {
            this.viewPager = r10;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r10) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab r10) {
            this.viewPager.setCurrentItem(r10.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r10) {
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
        tabPool = new Pools$SynchronizedPool(16);
    }

    public TabLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ TabIndicatorInterpolator access$1200(TabLayout r10) {
        return r10.tabIndicatorInterpolator;
    }

    public static /* synthetic */ int access$1400(TabLayout r10) {
        return r10.tabSelectedIndicatorColor;
    }

    private void addTabFromItemView(@NonNull TabItem r10) {
        Tab r11 = newTab();
        CharSequence r12 = r10.text;
        if (r12 == null) goto L5;
        r11.setText(r12);
    L5:
        Drawable r13 = r10.icon;
        if (r13 == null) goto L8;
        r11.setIcon(r13);
    L8:
        int r14 = r10.customLayout;
        if (r14 == 0) goto L12;
        r11.setCustomView(r14);
    L12:
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L14;
        r11.setContentDescription(r10.getContentDescription());
    L14:
        addTab(r11);
    }

    private void addTabView(@NonNull Tab r10) {
        TabView r11 = r10.view;
        r11.setSelected(false);
        r11.setActivated(false);
        this.slidingTabIndicator.addView(r11, r10.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View r10) {
        if ((r10 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r10);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int r10) {
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        setScrollPosition(r10, 0.0f, true);
        return;
    L8:
        if (ViewCompat.T(this) == false) goto L17;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L17;
        int r11 = getScrollX();
        int r12 = calculateScrollXForTab(r10, 0.0f);
        if (r11 == r12) goto L15;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r11, r12});
        this.scrollAnimator.start();
    L15:
        this.slidingTabIndicator.animateIndicatorToPosition(r10, this.tabIndicatorAnimationDuration);
    }

    private void applyGravityForModeScrollable(int r10) {
        if (r10 != 0) goto L4;
        Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.slidingTabIndicator.setGravity(8388611);
        return;
    L4:
        if (r10 != 1) goto L6;
        this.slidingTabIndicator.setGravity(1);
        return;
    L6:
        if (r10 == 2) goto L10;
    }

    private void applyModeAndGravity() {
        int r10 = this.mode;
        if (r10 == 0) goto L7;
        if (r10 == 2) goto L7;
        int r11 = 0;
    L8:
        ViewCompat.D0(this.slidingTabIndicator, r11, 0, 0, 0);
        int r12 = this.mode;
        if (r12 == 0) goto L17;
        if (r12 == 1) goto L14;
        if (r12 == 2) goto L14;
    L18:
        updateTabViews(true);
        return;
    L14:
        if (this.tabGravity != 2) goto L16;
        Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
    L16:
        this.slidingTabIndicator.setGravity(1);
        goto L18
    L17:
        applyGravityForModeScrollable(this.tabGravity);
    L7:
        r11 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        goto L8
    }

    private int calculateScrollXForTab(int r10, float r11) {
        int r12 = this.mode;
        int r13 = 0;
        if (r12 == 0) goto L7;
        if (r12 == 2) goto L7;
        return 0;
    L7:
        View r14 = this.slidingTabIndicator.getChildAt(r10);
        int r15 = r10 + 1;
        if (r15 >= this.slidingTabIndicator.getChildCount()) goto L10;
        View r16 = this.slidingTabIndicator.getChildAt(r15);
    L11:
        if (r14 == null) goto L13;
        int r17 = r14.getWidth();
    L14:
        if (r16 == null) goto L16;
        r13 = r16.getWidth();
    L16:
        int r18 = (r14.getLeft() + (r17 / 2)) - (getWidth() / 2);
        int r19 = (int) (((r17 + r13) * 0.5f) * r11);
        if (ViewCompat.A(this) != 0) goto L20;
        return r18 + r19;
    L20:
        return r18 - r19;
    L13:
        r17 = 0;
        goto L14
    L10:
        r16 = null;
        goto L11
    }

    private void configureTab(@NonNull Tab r10, int r11) {
        r10.setPosition(r11);
        this.tabs.add(r11, r10);
        int r12 = this.tabs.size();
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L6;
        this.tabs.get(r11).setPosition(r11);
        goto L3
    }

    @NonNull
    private static ColorStateList createColorStateList(int r10, int r11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r11, r10});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r10);
        return r10;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab r10) {
        Pools$Pool<TabView> r11 = this.tabViewPool;
        if (r11 == null) goto L5;
        TabView r12 = r11.acquire();
    L6:
        if (r12 != null) goto L8;
        r12 = new TabView(this, getContext());
    L8:
        r12.setTab(r10);
        r12.setFocusable(true);
        r12.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$200(r10)) == false) goto L11;
        r12.setContentDescription(Tab.access$300(r10));
    L12:
        return r12;
    L11:
        r12.setContentDescription(Tab.access$200(r10));
        goto L12
    L5:
        r12 = null;
        goto L6
    }

    private void dispatchTabReselected(@NonNull Tab r10) {
        int r11 = this.selectedListeners.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.selectedListeners.get(r11).onTabReselected(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void dispatchTabSelected(@NonNull Tab r10) {
        int r11 = this.selectedListeners.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.selectedListeners.get(r11).onTabSelected(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void dispatchTabUnselected(@NonNull Tab r10) {
        int r11 = this.selectedListeners.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        this.selectedListeners.get(r11).onTabUnselected(r10);
        r11 = r11 - 1;
        goto L3
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r10 = new ValueAnimator();
        this.scrollAnimator = r10;
        r10.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int r10 = this.tabs.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        Tab r12 = this.tabs.get(r11);
        if (r12 == null) goto L13;
        if (r12.getIcon() == null) goto L13;
        if (TextUtils.isEmpty(r12.getText()) == true) goto L13;
        if (this.inlineLabel == true) goto L14;
        return 72;
    L13:
        r11 = r11 + 1;
    L14:
        return 48;
    }

    private int getTabMinWidth() {
        int r10 = this.requestedTabMinWidth;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = this.mode;
        if (r11 == 0) goto L12;
        if (r11 == 2) goto L12;
        return 0;
    L12:
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int r10) {
        TabView r11 = (TabView) this.slidingTabIndicator.getChildAt(r10);
        this.slidingTabIndicator.removeViewAt(r10);
        if (r11 == null) goto L5;
        r11.reset();
        this.tabViewPool.release(r11);
    L5:
        requestLayout();
    }

    private void setSelectedTabView(int r10) {
        int r11 = this.slidingTabIndicator.getChildCount();
        if (r10 >= r11) goto L15;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L19;
        View r13 = this.slidingTabIndicator.getChildAt(r12);
        boolean r14 = true;
        if (r12 != r10) goto L9;
        boolean r15 = true;
    L10:
        r13.setSelected(r15);
        if (r12 == r10) goto L14;
        r14 = false;
    L14:
        r13.setActivated(r14);
        r12 = r12 + 1;
        goto L5
    L9:
        r15 = false;
        goto L10
    L19:
        return;
    }

    private void updateAllTabs() {
        int r10 = this.tabs.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.tabs.get(r11).updateView();
        r11 = r11 + 1;
        goto L3
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams r10) {
        if (this.mode == 1) goto L5;
    L7:
        r10.width = -2;
        r10.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r10.width = 0;
        r10.weight = 1.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener r10) {
        addOnTabSelectedListener(r10);
    }

    public void addTab(@NonNull Tab r10) {
        addTab(r10, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10) {
        addViewInternal(r10);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab r10 = tabPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new Tab();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public int getSelectedTabPosition() {
        Tab r10 = this.selectedTab;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getPosition();
    }

    @Nullable
    public Tab getTabAt(int r10) {
        if (r10 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r10 >= getTabCount()) goto L7;
        return this.tabs.get(r10);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab r10 = createTabFromPool();
        r10.parent = this;
        r10.view = createTabView(r10);
        if (Tab.access$000(r10) == (-1)) goto L5;
        r10.view.setId(Tab.access$000(r10));
    L5:
        return r10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r10, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        if ((r12 instanceof TabView) == false) goto L8;
        TabView.access$400((TabView) r12, r10);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        super.onDraw(r10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.B0(r10).X(AccessibilityNodeInfoCompat.b.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int r13 = View.MeasureSpec.getMode(r11);
        if (r13 == Integer.MIN_VALUE) goto L8;
        if (r13 != 0) goto L12;
        r11 = View.MeasureSpec.makeMeasureSpec((r12 + getPaddingTop()) + getPaddingBottom(), Ints.MAX_POWER_OF_TWO);
    L12:
        int r14 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L19;
        int r15 = this.requestedTabMaxWidth;
        if (r15 > 0) goto L18;
        r15 = (int) (r14 - ViewUtils.dpToPx(getContext(), 56));
    L18:
        this.tabMaxWidth = r15;
    L19:
        super.onMeasure(r10, r11);
        if (getChildCount() != 1) goto L34;
        View r16 = getChildAt(0);
        int r17 = this.mode;
        if (r17 == 0) goto L31;
        if (r17 == 1) goto L28;
        if (r17 == 2) goto L31;
        return;
    L28:
        if (r16.getMeasuredWidth() == getMeasuredWidth()) goto L35;
    L32:
        r16.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), HorizontalScrollView.getChildMeasureSpec(r11, getPaddingTop() + getPaddingBottom(), r16.getLayoutParams().height));
        return;
    L35:
        return;
    L31:
        if (r16.getMeasuredWidth() < getMeasuredWidth()) goto L32;
        return;
    L34:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r11) < r12) goto L12;
        getChildAt(0).setMinimumHeight(r12);
        goto L12
    }

    public void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r10 = this.pagerAdapter;
        if (r10 == null) goto L17;
        int r11 = r10.getCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r12)), false);
        r12 = r12 + 1;
        goto L5
    L7:
        ViewPager r13 = this.viewPager;
        if (r13 == null) goto L18;
        if (r11 <= 0) goto L19;
        int r14 = r13.getCurrentItem();
        if (r14 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r14 >= getTabCount()) goto L21;
        selectTab(getTabAt(r14));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public boolean releaseFromTabPool(Tab r10) {
        return tabPool.release(r10);
    }

    public void removeAllTabs() {
        int r10 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r10 < 0) goto L5;
        removeTabViewAt(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        Iterator<Tab> r11 = this.tabs.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Tab r12 = r11.next();
        r11.remove();
        r12.reset();
        releaseFromTabPool(r12);
        goto L7
    L9:
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener r10) {
        removeOnTabSelectedListener(r10);
    }

    public void removeTab(@NonNull Tab r10) {
        if (r10.parent != this) goto L7;
        removeTabAt(r10.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r10) {
        Tab r11 = this.selectedTab;
        if (r11 == null) goto L5;
        int r12 = r11.getPosition();
    L6:
        removeTabViewAt(r10);
        Tab r13 = this.tabs.remove(r10);
        if (r13 == null) goto L9;
        r13.reset();
        releaseFromTabPool(r13);
    L9:
        int r14 = this.tabs.size();
        int r15 = r10;
    L10:
        if (r15 >= r14) goto L12;
        this.tabs.get(r15).setPosition(r15);
        r15 = r15 + 1;
        goto L10
    L12:
        if (r12 == r10) goto L14;
        return;
    L14:
        if (this.tabs.isEmpty() == false) goto L16;
        Tab r16 = null;
    L17:
        selectTab(r16);
        return;
    L16:
        r16 = this.tabs.get(Math.max(0, r10 - 1));
        goto L17
    L5:
        r12 = 0;
        goto L6
    }

    public void selectTab(@Nullable Tab r10) {
        selectTab(r10, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        MaterialShapeUtils.setElevation(this, r10);
    }

    public void setInlineLabel(boolean r10) {
        if (this.inlineLabel == r10) goto L16;
        this.inlineLabel = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        if ((r12 instanceof TabView) == false) goto L10;
        ((TabView) r12).updateOrientation();
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(@BoolRes int r10) {
        setInlineLabel(getResources().getBoolean(r10));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener r10) {
        setOnTabSelectedListener(r10);
    }

    public void setPagerAdapter(@Nullable PagerAdapter r10, boolean r11) {
        PagerAdapter r12 = this.pagerAdapter;
        if (r12 == null) goto L7;
        DataSetObserver r13 = this.pagerAdapterObserver;
        if (r13 == null) goto L7;
        r12.unregisterDataSetObserver(r13);
    L7:
        this.pagerAdapter = r10;
        if (r11 == false) goto L14;
        if (r10 == null) goto L14;
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r10.registerDataSetObserver(this.pagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r10) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r10);
    }

    public void setScrollPosition(int r10, float r11, boolean r12) {
        setScrollPosition(r10, r11, r12, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable r10) {
        if (this.tabSelectedIndicator == r10) goto L9;
        if (r10 != null) goto L7;
        r10 = new GradientDrawable();
    L7:
        this.tabSelectedIndicator = r10;
        return;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r10) {
        this.tabSelectedIndicatorColor = r10;
    }

    public void setSelectedTabIndicatorGravity(int r10) {
        if (this.tabIndicatorGravity == r10) goto L6;
        this.tabIndicatorGravity = r10;
        ViewCompat.g0(this.slidingTabIndicator);
        return;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r10) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(r10);
    }

    public void setTabGravity(int r10) {
        if (this.tabGravity == r10) goto L6;
        this.tabGravity = r10;
        applyModeAndGravity();
        return;
    }

    public void setTabIconTint(@Nullable ColorStateList r10) {
        if (this.tabIconTint == r10) goto L6;
        this.tabIconTint = r10;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(@ColorRes int r10) {
        setTabIconTint(c.a.a(getContext(), r10));
    }

    public void setTabIndicatorAnimationMode(int r10) {
        this.tabIndicatorAnimationMode = r10;
        if (r10 != 0) goto L5;
        this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        return;
    L5:
        if (r10 != 1) goto L8;
        this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        return;
    L8:
        throw new IllegalArgumentException(r10 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean r10) {
        this.tabIndicatorFullWidth = r10;
        ViewCompat.g0(this.slidingTabIndicator);
    }

    public void setTabMode(int r10) {
        if (r10 == this.mode) goto L6;
        this.mode = r10;
        applyModeAndGravity();
        return;
    }

    public void setTabRippleColor(@Nullable ColorStateList r10) {
        if (this.tabRippleColorStateList == r10) goto L11;
        this.tabRippleColorStateList = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        if ((r12 instanceof TabView) == false) goto L10;
        TabView.access$100((TabView) r12, getContext());
    L10:
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(@ColorRes int r10) {
        setTabRippleColor(c.a.a(getContext(), r10));
    }

    public void setTabTextColors(@Nullable ColorStateList r10) {
        if (this.tabTextColors == r10) goto L6;
        this.tabTextColors = r10;
        updateAllTabs();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r10) {
        setPagerAdapter(r10, false);
    }

    public void setUnboundedRipple(boolean r10) {
        if (this.unboundedRipple == r10) goto L11;
        this.unboundedRipple = r10;
        int r11 = 0;
    L6:
        if (r11 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        if ((r12 instanceof TabView) == false) goto L10;
        TabView.access$100((TabView) r12, getContext());
    L10:
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(@BoolRes int r10) {
        setUnboundedRipple(getResources().getBoolean(r10));
    }

    public void setupWithViewPager(@Nullable ViewPager r10) {
        setupWithViewPager(r10, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateTabViews(boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r12 = this.slidingTabIndicator.getChildAt(r11);
        r12.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r12.getLayoutParams());
        if (r10 == false) goto L8;
        r12.requestLayout();
    L8:
        r11 = r11 + 1;
        goto L4
    }

    public TabLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r10) {
        if (this.selectedListeners.contains(r10) == true) goto L6;
        this.selectedListeners.add(r10);
        return;
    }

    public void addTab(@NonNull Tab r10, int r11) {
        addTab(r10, r11, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11) {
        addViewInternal(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r10) {
        this.selectedListeners.remove(r10);
    }

    public void selectTab(@Nullable Tab r10, boolean r11) {
        Tab r12 = this.selectedTab;
        if (r12 != r10) goto L7;
        if (r12 == null) goto L25;
        dispatchTabReselected(r10);
        animateToTab(r10.getPosition());
        return;
    L25:
        return;
    L7:
        if (r10 == null) goto L9;
        int r13 = r10.getPosition();
    L10:
        if (r11 == false) goto L19;
        if (r12 != null) goto L13;
    L14:
        if (r13 == (-1)) goto L16;
        setScrollPosition(r13, 0.0f, true);
    L17:
        if (r13 == (-1)) goto L19;
        setSelectedTabView(r13);
    L16:
        animateToTab(r13);
        goto L17
    L13:
        if (r12.getPosition() != (-1)) goto L16;
    L19:
        this.selectedTab = r10;
        if (r12 == null) goto L22;
        dispatchTabUnselected(r12);
    L22:
        if (r10 == null) goto L27;
        dispatchTabSelected(r10);
        return;
    L27:
        return;
    L9:
        r13 = -1;
        goto L10
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r10) {
        BaseOnTabSelectedListener r11 = this.selectedListener;
        if (r11 == null) goto L5;
        removeOnTabSelectedListener(r11);
    L5:
        this.selectedListener = r10;
        if (r10 == null) goto L9;
        addOnTabSelectedListener(r10);
        return;
    }

    public void setScrollPosition(int r10, float r11, boolean r12, boolean r13) {
        int r14 = Math.round(r10 + r11);
        if (r14 >= 0) goto L5;
        return;
    L5:
        if (r14 >= this.slidingTabIndicator.getChildCount()) goto L20;
        if (r13 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r10, r11);
    L9:
        ValueAnimator r15 = this.scrollAnimator;
        if (r15 != null) goto L12;
    L14:
        scrollTo(calculateScrollXForTab(r10, r11), 0);
        if (r12 == false) goto L19;
        setSelectedTabView(r14);
        return;
    L19:
        return;
    L12:
        if (r15.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }

    public void setupWithViewPager(@Nullable ViewPager r10, boolean r11) {
        setupWithViewPager(r10, r11, false);
    }

    public TabLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r10), r12, r13);
        this.tabs = new ArrayList();
        this.tabSelectedIndicator = new GradientDrawable();
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Channel.UNLIMITED;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new d(12);
        Context r14 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r15 = new SlidingTabIndicator(this, r14);
        this.slidingTabIndicator = r15;
        super.addView(r15, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] r16 = R.styleable.TabLayout;
        int r17 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray r18 = ThemeEnforcement.obtainStyledAttributes(r14, r12, r16, r13, r10, new int[]{r17});
        if ((getBackground() instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r19 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r20 = new MaterialShapeDrawable();
        r20.setFillColor(ColorStateList.valueOf(r19.getColor()));
        r20.initializeElevationOverlay(r14);
        r20.setElevation(ViewCompat.v(this));
        ViewCompat.t0(this, r20);
    L5:
        setSelectedTabIndicator(MaterialResources.getDrawable(r14, r18, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(r18.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        r15.setSelectedIndicatorHeight(r18.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(r18.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(r18.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(r18.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int r110 = r18.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = r110;
        this.tabPaddingEnd = r110;
        this.tabPaddingTop = r110;
        this.tabPaddingStart = r110;
        this.tabPaddingStart = r18.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, r110);
        this.tabPaddingTop = r18.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = r18.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = r18.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int r111 = r18.getResourceId(r17, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = r111;
        TypedArray r112 = r14.obtainStyledAttributes(r111, R$styleable.TextAppearance);
        this.tabTextSize = r112.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L15
        this.tabTextColors = MaterialResources.getColorStateList(r14, r112, R$styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L15
        r112.recycle();
        int r113 = R.styleable.TabLayout_tabTextColor;
        if (r18.hasValue(r113) == false) goto L10;
        this.tabTextColors = MaterialResources.getColorStateList(r14, r18, r113);
    L10:
        int r114 = R.styleable.TabLayout_tabSelectedTextColor;
        if (r18.hasValue(r114) == false) goto L13;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r18.getColor(r114, 0));
    L13:
        this.tabIconTint = MaterialResources.getColorStateList(r14, r18, R.styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode(r18.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r14, r18, R.styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = r18.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.requestedTabMinWidth = r18.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        this.requestedTabMaxWidth = r18.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.tabBackgroundResId = r18.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = r18.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mode = r18.getInt(R.styleable.TabLayout_tabMode, 1);
        this.tabGravity = r18.getInt(R.styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = r18.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = r18.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        r18.recycle();
        Resources r115 = getResources();
        this.tabTextMultiLineSize = r115.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = r115.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
        return;
    L15:
        th = move-exception;
        r112.recycle();
        throw th;
    }

    private void setupWithViewPager(@Nullable ViewPager r10, boolean r11, boolean r12) {
        ViewPager r13 = this.viewPager;
        if (r13 == null) goto L10;
        TabLayoutOnPageChangeListener r14 = this.pageChangeListener;
        if (r14 == null) goto L7;
        r13.removeOnPageChangeListener(r14);
    L7:
        AdapterChangeListener r15 = this.adapterChangeListener;
        if (r15 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r15);
    L10:
        BaseOnTabSelectedListener r16 = this.currentVpSelectedListener;
        if (r16 == null) goto L13;
        removeOnTabSelectedListener(r16);
        this.currentVpSelectedListener = null;
    L13:
        if (r10 == null) goto L24;
        this.viewPager = r10;
        if (this.pageChangeListener != null) goto L17;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L17:
        this.pageChangeListener.reset();
        r10.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r17 = new ViewPagerOnTabSelectedListener(r10);
        this.currentVpSelectedListener = r17;
        addOnTabSelectedListener(r17);
        PagerAdapter r18 = r10.getAdapter();
        if (r18 == null) goto L21;
        setPagerAdapter(r18, r11);
    L21:
        if (this.adapterChangeListener != null) goto L23;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L23:
        this.adapterChangeListener.setAutoRefresh(r11);
        r10.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r10.getCurrentItem(), 0.0f, true);
    L25:
        this.setupViewPagerImplicitly = r12;
        return;
    L24:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L25
    }

    public void addTab(@NonNull Tab r10, boolean r11) {
        addTab(r10, this.tabs.size(), r11);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        addViewInternal(r10);
    }

    public void setSelectedTabIndicator(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        setSelectedTabIndicator(c.a.b(getContext(), r10));
        return;
    L4:
        setSelectedTabIndicator(null);
    }

    public void addTab(@NonNull Tab r10, int r11, boolean r12) {
        if (r10.parent != this) goto L9;
        configureTab(r10, r11);
        addTabView(r10);
        if (r12 == false) goto L10;
        r10.select();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        addViewInternal(r10);
    }

    public void setTabTextColors(int r10, int r11) {
        setTabTextColors(createColorStateList(r10, r11));
    }
}
