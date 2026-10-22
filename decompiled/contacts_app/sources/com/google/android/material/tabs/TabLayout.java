package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = 0;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
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
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    private Tab selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;
    private int viewPagerScrollState;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        AdapterChangeListener(TabLayout r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            if (this.this$0.viewPager != r1) goto L6;
            this.this$0.setPagerAdapter(r3, this.autoRefresh);
            return;
        }

        void setAutoRefresh(boolean r1) {
            this.autoRefresh = r1;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T r1);

        void onTabSelected(T r1);

        void onTabUnselected(T r1);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    private class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ TabLayout this$0;

        PagerAdapterObserver(TabLayout r1) {
            this.this$0 = r1;
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

    class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;
        final /* synthetic */ TabLayout this$0;

        static /* synthetic */ void access$100(SlidingTabIndicator r0) {
            r0.jumpIndicatorToSelectedPosition();
        }

        static /* synthetic */ void access$1800(SlidingTabIndicator r0, View r1, View r2, float r3) {
            r0.tweenIndicatorPosition(r1, r2, r3);
        }

        SlidingTabIndicator(TabLayout r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.layoutDirection = -1;
            setWillNotDraw(false);
        }

        void setSelectedIndicatorHeight(int r5) {
            Rect r0 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r0.left, 0, r0.right, r5);
            requestLayout();
        }

        boolean childrenNeedLayout() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (getChildAt(r2).getWidth() <= 0) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        void setIndicatorPositionFromTabPosition(int r3, float r4) {
            this.this$0.indicatorPosition = Math.round(r3 + r4);
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            tweenIndicatorPosition(getChildAt(r3), getChildAt(r3 + 1), r4);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r1) {
            super.onRtlPropertiesChanged(r1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int r9, int r10) {
            super.onMeasure(r9, r10);
            if (View.MeasureSpec.getMode(r9) == 1073741824) goto L5;
            return;
        L5:
            boolean r2 = true;
            if (this.this$0.tabGravity != 1) goto L8;
        L9:
            int r0 = getChildCount();
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
        L10:
            if (r4 >= r0) goto L15;
            View r6 = getChildAt(r4);
            if (r6.getVisibility() != 0) goto L14;
            r5 = Math.max(r5, r6.getMeasuredWidth());
        L14:
            r4 = r4 + 1;
            goto L10
        L15:
            if (r5 > 0) goto L18;
            return;
        L18:
            if ((r5 * r0) > (getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2))) goto L28;
            boolean r1 = false;
        L20:
            if (r3 >= r0) goto L27;
            LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) getChildAt(r3).getLayoutParams();
            if (r7.width == r5) goto L24;
        L25:
            r7.width = r5;
            r7.weight = 0.0f;
            r1 = true;
        L26:
            r3 = r3 + 1;
            goto L20
        L24:
            if (r7.weight == 0.0f) goto L26;
        L27:
            r2 = r1;
        L29:
            if (r2 == false) goto L39;
            super.onMeasure(r9, r10);
            return;
        L39:
            return;
        L28:
            this.this$0.tabGravity = 0;
            this.this$0.updateTabViews(false);
            goto L29
        L8:
            if (this.this$0.mode == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.indicatorAnimator;
            if (r6 != null) goto L5;
        L7:
            jumpIndicatorToIndicatorPosition();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            updateOrRecreateIndicatorAnimation(false, this.this$0.getSelectedTabPosition(), -1);
        }

        private void jumpIndicatorToPosition(int r5) {
            if (TabLayout.access$1600(this.this$0) != 0) goto L5;
        L9:
            View r0 = getChildAt(r5);
            TabIndicatorInterpolator r1 = TabLayout.access$1700(this.this$0);
            TabLayout r2 = this.this$0;
            r1.setIndicatorBoundsForTab(r2, r0, r2.tabSelectedIndicator);
            this.this$0.indicatorPosition = r5;
            return;
        L5:
            if (this.this$0.getTabSelectedIndicator().getBounds().left == (-1)) goto L7;
            return;
        L7:
            if (this.this$0.getTabSelectedIndicator().getBounds().right == (-1)) goto L9;
        }

        private void jumpIndicatorToSelectedPosition() {
            jumpIndicatorToPosition(this.this$0.getSelectedTabPosition());
        }

        private void jumpIndicatorToIndicatorPosition() {
            if (this.this$0.indicatorPosition != (-1)) goto L5;
            TabLayout r0 = this.this$0;
            r0.indicatorPosition = r0.getSelectedTabPosition();
        L5:
            jumpIndicatorToPosition(this.this$0.indicatorPosition);
        }

        private void tweenIndicatorPosition(View r8, View r9, float r10) {
            if (r8 != null) goto L4;
        L6:
            boolean r0 = false;
        L7:
            if (r0 == false) goto L9;
            TabIndicatorInterpolator r1 = TabLayout.access$1700(this.this$0);
            TabLayout r2 = this.this$0;
            r1.updateIndicatorForOffset(r2, r8, r9, r10, r2.tabSelectedIndicator);
        L10:
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L9:
            this.this$0.tabSelectedIndicator.setBounds(-1, this.this$0.tabSelectedIndicator.getBounds().top, -1, this.this$0.tabSelectedIndicator.getBounds().bottom);
            goto L10
        L4:
            if (r8.getWidth() <= 0) goto L6;
            r0 = true;
            goto L7
        }

        void animateIndicatorToPosition(int r2, int r3) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L9:
            updateOrRecreateIndicatorAnimation(true, r2, r3);
            return;
        L5:
            if (r0.isRunning() == false) goto L9;
            if (this.this$0.indicatorPosition == r2) goto L9;
            this.indicatorAnimator.cancel();
            goto L9
        }

        private void updateOrRecreateIndicatorAnimation(boolean r4, int r5, int r6) {
            if (this.this$0.indicatorPosition != r5) goto L5;
            return;
        L5:
            final View r0 = getChildAt(this.this$0.getSelectedTabPosition());
            final View r1 = getChildAt(r5);
            if (r1 != null) goto L9;
            jumpIndicatorToSelectedPosition();
            return;
        L9:
            this.this$0.indicatorPosition = r5;
            ValueAnimator.AnimatorUpdateListener r7 = new AnonymousClass1(this, r0, r1);
            if (r4 == false) goto L12;
            ValueAnimator r8 = new ValueAnimator();
            this.indicatorAnimator = r8;
            r8.setInterpolator(TabLayout.access$1900(this.this$0));
            r8.setDuration(r6);
            r8.setFloatValues(new float[]{0.0f, 1.0f});
            r8.addUpdateListener(r7);
            r8.start();
            return;
        L12:
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r7);
        }

        @Override // android.view.View
        public void draw(Canvas r6) {
            int r0 = this.this$0.tabSelectedIndicator.getBounds().height();
            if (r0 >= 0) goto L5;
            r0 = this.this$0.tabSelectedIndicator.getIntrinsicHeight();
        L5:
            int r1 = this.this$0.tabIndicatorGravity;
            if (r1 != 0) goto L8;
            int r2 = getHeight() - r0;
            r0 = getHeight();
        L18:
            if (this.this$0.tabSelectedIndicator.getBounds().width() <= 0) goto L20;
            Rect r3 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r3.left, r2, r3.right, r0);
            this.this$0.tabSelectedIndicator.draw(r6);
        L20:
            super.draw(r6);
            return;
        L8:
            if (r1 == 1) goto L15;
            r2 = 0;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L14;
            r0 = 0;
            goto L18
        L14:
            r0 = getHeight();
            goto L18
        L15:
            r2 = (getHeight() - r0) / 2;
            r0 = (getHeight() + r0) / 2;
            goto L18
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence contentDesc;
        private View customView;
        private Drawable icon;
        private int id;
        private int labelVisibilityMode;
        public TabLayout parent;
        private int position;
        private Object tag;
        private CharSequence text;
        public TabView view;

        static /* synthetic */ int access$000(Tab r0) {
            return r0.id;
        }

        static /* synthetic */ int access$1500(Tab r0) {
            return r0.labelVisibilityMode;
        }

        static /* synthetic */ CharSequence access$300(Tab r0) {
            return r0.contentDesc;
        }

        static /* synthetic */ CharSequence access$400(Tab r0) {
            return r0.text;
        }

        public Tab() {
            this.position = -1;
            this.labelVisibilityMode = 1;
            this.id = -1;
        }

        public Object getTag() {
            return this.tag;
        }

        public Tab setTag(Object r1) {
            this.tag = r1;
            return this;
        }

        public Tab setId(int r2) {
            this.id = r2;
            TabView r0 = this.view;
            if (r0 == null) goto L5;
            r0.setId(r2);
        L5:
            return this;
        }

        public int getId() {
            return this.id;
        }

        public View getCustomView() {
            return this.customView;
        }

        public Tab setCustomView(View r1) {
            this.customView = r1;
            updateView();
            return this;
        }

        public Tab setCustomView(int r4) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r4, this.view, false));
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public int getPosition() {
            return this.position;
        }

        void setPosition(int r1) {
            this.position = r1;
        }

        public CharSequence getText() {
            return this.text;
        }

        public Tab setIcon(Drawable r3) {
            this.icon = r3;
            if (this.parent.tabGravity != 1) goto L5;
        L6:
            this.parent.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$600(this.view) == false) goto L14;
            if (TabView.access$700(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (this.parent.mode != 2) goto L7;
            goto L6
        }

        public Tab setIcon(int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r0.getContext(), r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setText(CharSequence r2) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r2;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r2) == true) goto L7;
            this.view.setContentDescription(r2);
            goto L7
        }

        public Tab setText(int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setText(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public BadgeDrawable getOrCreateBadge() {
            return TabView.access$800(this.view);
        }

        public void removeBadge() {
            TabView.access$900(this.view);
        }

        public BadgeDrawable getBadge() {
            return TabView.access$1000(this.view);
        }

        public Tab setTabLabelVisibility(int r3) {
            this.labelVisibilityMode = r3;
            if (this.parent.tabGravity != 1) goto L5;
        L6:
            this.parent.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$600(this.view) == false) goto L14;
            if (TabView.access$700(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (this.parent.mode != 2) goto L7;
            goto L6
        }

        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        public void select() {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            r0.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean isSelected() {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L12;
            int r1 = r0.getSelectedTabPosition();
            if (r1 != (-1)) goto L7;
        L9:
            return false;
        L7:
            if (r1 != this.position) goto L9;
            return true;
        L12:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setContentDescription(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(CharSequence r1) {
            this.contentDesc = r1;
            updateView();
            return this;
        }

        public CharSequence getContentDescription() {
            TabView r0 = this.view;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getContentDescription();
        }

        void updateView() {
            TabView r0 = this.view;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
            TabLayout r3 = this.tabLayoutRef.get();
            if (r3 == null) goto L6;
            r3.updateViewPagerScrollState(this.scrollState);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r7, float r8, int r9) {
            TabLayout r0 = this.tabLayoutRef.get();
            if (r0 == null) goto L19;
            int r10 = this.scrollState;
            if (r10 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r10 == 2) goto L13;
        L16:
            boolean r6 = true;
        L17:
            r0.setScrollPosition(r7, r8, r4, r6, false);
            return;
        L13:
            if (this.previousScrollState != 0) goto L16;
            r6 = false;
            goto L17
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            TabLayout r0 = this.tabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.selectTab(r0.getTabAt(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {
        private View badgeAnchorView;
        private BadgeDrawable badgeDrawable;
        private Drawable baseBackgroundDrawable;
        private ImageView customIconView;
        private TextView customTextView;
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;
        final /* synthetic */ TabLayout this$0;

        static /* synthetic */ BadgeDrawable access$1000(TabView r0) {
            return r0.getBadge();
        }

        static /* synthetic */ void access$1400(TabView r0, View r1) {
            r0.tryUpdateBadgeDrawableBounds(r1);
        }

        static /* synthetic */ void access$200(TabView r0, Context r1) {
            r0.updateBackgroundDrawable(r1);
        }

        static /* synthetic */ void access$500(TabView r0, Canvas r1) {
            r0.drawBackground(r1);
        }

        static /* synthetic */ boolean access$600(TabView r0) {
            return r0.hasBadgeDrawable();
        }

        static /* synthetic */ BadgeDrawable access$700(TabView r0) {
            return r0.badgeDrawable;
        }

        static /* synthetic */ BadgeDrawable access$800(TabView r0) {
            return r0.getOrCreateBadge();
        }

        static /* synthetic */ void access$900(TabView r0) {
            r0.removeBadge();
        }

        public TabView(TabLayout r4, Context r5) {
            this.this$0 = r4;
            super(r5);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(r5);
            ViewCompat.setPaddingRelative(this, r4.tabPaddingStart, r4.tabPaddingTop, r4.tabPaddingEnd, r4.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r4.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void updateBackgroundDrawable(Context r6) {
            GradientDrawable r1 = null;
            if (this.this$0.tabBackgroundResId == 0) goto L9;
            Drawable r7 = AppCompatResources.getDrawable(r6, this.this$0.tabBackgroundResId);
            this.baseBackgroundDrawable = r7;
            if (r7 != null) goto L7;
        L10:
            GradientDrawable r8 = new GradientDrawable();
            r8.setColor(0);
            Drawable r9 = r8;
            if (this.this$0.tabRippleColorStateList == null) goto L20;
            GradientDrawable r0 = new GradientDrawable();
            r0.setCornerRadius(1.0E-5f);
            r0.setColor(-1);
            ColorStateList r2 = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            GradientDrawable r10 = r8;
            if (this.this$0.unboundedRipple == false) goto L16;
            r10 = null;
        L16:
            if (this.this$0.unboundedRipple == true) goto L19;
            r1 = r0;
        L19:
            r9 = new RippleDrawable(r2, r10, r1);
        L20:
            ViewCompat.setBackground(this, r9);
            this.this$0.invalidate();
            return;
        L7:
            if (r7.isStateful() == false) goto L10;
            this.baseBackgroundDrawable.setState(getDrawableState());
            goto L10
        L9:
            this.baseBackgroundDrawable = null;
            goto L10
        }

        private void drawBackground(Canvas r6) {
            Drawable r0 = this.baseBackgroundDrawable;
            if (r0 == null) goto L6;
            r0.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r6);
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r0 = getDrawableState();
            Drawable r1 = this.baseBackgroundDrawable;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            if (r2 == false) goto L10;
            invalidate();
            this.this$0.invalidate();
            return;
        L10:
            return;
        L5:
            if (r1.isStateful() == false) goto L7;
            r2 = false | this.baseBackgroundDrawable.setState(r0);
            goto L7
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.tab == null) goto L8;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.tab.select();
            return true;
        L8:
            return r0;
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            if (isSelected() != r2) goto L6;
        L6:
            super.setSelected(r2);
            TextView r0 = this.textView;
            if (r0 == null) goto L9;
            r0.setSelected(r2);
        L9:
            ImageView r1 = this.iconView;
            if (r1 == null) goto L12;
            r1.setSelected(r2);
        L12:
            View r3 = this.customView;
            if (r3 == null) goto L16;
            r3.setSelected(r2);
            return;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r7) {
            super.onInitializeAccessibilityNodeInfo(r7);
            BadgeDrawable r0 = this.badgeDrawable;
            if (r0 != null) goto L5;
        L7:
            AccessibilityNodeInfoCompat r8 = AccessibilityNodeInfoCompat.wrap(r7);
            r8.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r8.setClickable(false);
            r8.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        L10:
            r8.setRoleDescription(getResources().getString(R.string.item_view_role_description));
            return;
        L5:
            if (r0.isVisible() == false) goto L7;
            r7.setContentDescription(getContentDescription() + ", " + this.badgeDrawable.getContentDescription());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r8, int r9) {
            int r0 = View.MeasureSpec.getSize(r8);
            int r1 = View.MeasureSpec.getMode(r8);
            int r2 = this.this$0.getTabMaxWidth();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r8 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r8, r9);
            if (this.textView == null) goto L35;
            float r3 = this.this$0.tabTextSize;
            int r4 = this.defaultMaxLines;
            ImageView r5 = this.iconView;
            boolean r6 = true;
            if (r5 != null) goto L12;
        L14:
            TextView r7 = this.textView;
            if (r7 != null) goto L17;
        L19:
            float r10 = this.textView.getTextSize();
            int r11 = this.textView.getLineCount();
            int r12 = TextViewCompat.getMaxLines(this.textView);
            if (r3 != r10) goto L24;
            if (r12 < 0) goto L36;
            if (r4 != r12) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r3 <= r10) goto L32;
            if (r11 != 1) goto L32;
            Layout r13 = this.textView.getLayout();
            if (r13 != null) goto L30;
        L31:
            r6 = false;
            goto L32
        L30:
            if (approximateLineWidth(r13, 0, r3) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r6 == false) goto L38;
            this.textView.setTextSize(0, r3);
            this.textView.setMaxLines(r4);
            super.onMeasure(r8, r9);
            return;
        L38:
            return;
        L17:
            if (r7.getLineCount() <= 1) goto L19;
            r3 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r5.getVisibility() != 0) goto L14;
            r4 = 1;
            goto L19
        }

        void setTab(Tab r2) {
            if (r2 == this.tab) goto L6;
            this.tab = r2;
            update();
            return;
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        final void updateTab() {
            Tab r0 = this.tab;
            if (r0 == null) goto L5;
            View r2 = r0.getCustomView();
        L6:
            if (r2 == null) goto L27;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L17;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r2);
        L11:
            View r4 = this.customView;
            if (r4 == null) goto L16;
            ViewParent r5 = r4.getParent();
            if (r5 == null) goto L16;
            ((ViewGroup) r5).removeView(this.customView);
        L16:
            addView(r2);
        L17:
            this.customView = r2;
            TextView r6 = this.textView;
            if (r6 == null) goto L20;
            r6.setVisibility(8);
        L20:
            ImageView r7 = this.iconView;
            if (r7 == null) goto L23;
            r7.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L23:
            TextView r1 = (TextView) r2.findViewById(android.R.id.text1);
            this.customTextView = r1;
            if (r1 == null) goto L26;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r1);
        L26:
            this.customIconView = (ImageView) r2.findViewById(android.R.id.icon);
        L32:
            if (this.customView == null) goto L34;
            TextView r8 = this.customTextView;
            if (r8 == null) goto L52;
        L53:
            updateTextAndIcon(r8, this.customIconView, false);
        L54:
            if (r0 != null) goto L56;
            return;
        L56:
            if (TextUtils.isEmpty(Tab.access$300(r0)) == true) goto L60;
            setContentDescription(Tab.access$300(r0));
            return;
        L60:
            return;
        L52:
            if (this.customIconView == null) goto L54;
        L34:
            if (this.iconView != null) goto L37;
            inflateAndAddDefaultIconView();
        L37:
            if (this.textView != null) goto L39;
            inflateAndAddDefaultTextView();
            this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
        L39:
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1100(this.this$0));
            if (isSelected() == true) goto L42;
        L44:
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1300(this.this$0));
        L46:
            if (this.this$0.tabTextColors == null) goto L48;
            this.textView.setTextColor(this.this$0.tabTextColors);
        L48:
            updateTextAndIcon(this.textView, this.iconView, true);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
            goto L54
        L42:
            if (TabLayout.access$1200(this.this$0) == (-1)) goto L44;
            TextViewCompat.setTextAppearance(this.textView, TabLayout.access$1200(this.this$0));
            goto L46
        L27:
            View r9 = this.customView;
            if (r9 == null) goto L30;
            removeView(r9);
            this.customView = null;
        L30:
            this.customTextView = null;
            this.customIconView = null;
            goto L32
        L5:
            r2 = null;
            goto L6
        }

        final void update() {
            updateTab();
            Tab r0 = this.tab;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            setSelected(r1);
            return;
        L5:
            if (r0.isSelected() == false) goto L7;
            r1 = true;
            goto L8
        }

        private void inflateAndAddDefaultIconView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0, 0);
            ViewGroup r1 = r0;
        L6:
            ImageView r2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, r1, false);
            this.iconView = r2;
            r1.addView(r2, 0);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private void inflateAndAddDefaultTextView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0);
            ViewGroup r1 = r0;
        L6:
            TextView r2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, r1, false);
            this.textView = r2;
            r1.addView(r2);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout r0 = new FrameLayout(getContext());
            r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r0;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable != null) goto L5;
            this.badgeDrawable = BadgeDrawable.create(getContext());
        L5:
            tryUpdateBadgeAnchor();
            BadgeDrawable r1 = this.badgeDrawable;
            if (r1 == null) goto L9;
            return r1;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        private void removeBadge() {
            if (this.badgeAnchorView == null) goto L5;
            tryRemoveBadgeFromAnchor();
        L5:
            this.badgeDrawable = null;
        }

        private void addOnLayoutChangeListener(final View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r2.addOnLayoutChangeListener(new AnonymousClass1(this, r2));
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
            Tab r0 = this.tab;
            if (r0 == null) goto L19;
            if (r0.getIcon() == null) goto L19;
            View r1 = this.badgeAnchorView;
            ImageView r2 = this.iconView;
            if (r1 == r2) goto L17;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.iconView);
            return;
        L17:
            tryUpdateBadgeDrawableBounds(r2);
            return;
        L19:
            if (this.textView == null) goto L28;
            Tab r3 = this.tab;
            if (r3 == null) goto L28;
            if (r3.getTabLabelVisibility() != 1) goto L28;
            View r4 = this.badgeAnchorView;
            TextView r5 = this.textView;
            if (r4 == r5) goto L27;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.textView);
            return;
        L27:
            tryUpdateBadgeDrawableBounds(r5);
            return;
        L28:
            tryRemoveBadgeFromAnchor();
        }

        private void tryAttachBadgeToAnchor(View r3) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r3 == null) goto L8;
            clipViewToPaddingForBadge(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r3, getCustomParentForBadge(r3));
            this.badgeAnchorView = r3;
            return;
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            clipViewToPaddingForBadge(true);
            View r0 = this.badgeAnchorView;
            if (r0 == null) goto L9;
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r0);
            this.badgeAnchorView = null;
            return;
        }

        private void clipViewToPaddingForBadge(boolean r1) {
            setClipChildren(r1);
            setClipToPadding(r1);
            ViewGroup r0 = (ViewGroup) getParent();
            if (r0 == null) goto L6;
            r0.setClipChildren(r1);
            r0.setClipToPadding(r1);
            return;
        }

        final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r0 = this.customTextView;
            if (r0 == null) goto L5;
        L8:
            updateTextAndIcon(r0, this.customIconView, false);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView, true);
        }

        private void updateTextAndIcon(TextView r8, ImageView r9, boolean r10) {
            Tab r0 = this.tab;
            CharSequence r1 = null;
            if (r0 != null) goto L5;
        L7:
            Drawable r2 = null;
        L8:
            if (r2 == null) goto L12;
            DrawableCompat.setTintList(r2, this.this$0.tabIconTint);
            if (this.this$0.tabIconTintMode == null) goto L12;
            DrawableCompat.setTintMode(r2, this.this$0.tabIconTintMode);
        L12:
            Tab r3 = this.tab;
            if (r3 == null) goto L15;
            CharSequence r4 = r3.getText();
        L17:
            if (r9 == null) goto L21;
            if (r2 == null) goto L20;
            r9.setImageDrawable(r2);
            r9.setVisibility(0);
            setVisibility(0);
            goto L21
        L20:
            r9.setVisibility(8);
            r9.setImageDrawable(null);
        L21:
            boolean r5 = true;
            boolean r6 = !TextUtils.isEmpty(r4);
            if (r8 == null) goto L38;
            if (r6 == true) goto L25;
        L27:
            r5 = false;
        L28:
            if (r6 == false) goto L30;
            CharSequence r7 = r4;
        L31:
            r8.setText(r7);
            if (r5 == false) goto L34;
            int r11 = 0;
        L35:
            r8.setVisibility(r11);
            if (r6 == false) goto L39;
            setVisibility(0);
        L39:
            if (r10 == false) goto L55;
            if (r9 == null) goto L55;
            ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r9.getLayoutParams();
            if (r5 == true) goto L44;
        L46:
            int r13 = 0;
        L48:
            if (this.this$0.inlineLabel == false) goto L53;
            if (r13 == MarginLayoutParamsCompat.getMarginEnd(r12)) goto L55;
            MarginLayoutParamsCompat.setMarginEnd(r12, r13);
            r12.bottomMargin = 0;
            r9.setLayoutParams(r12);
            r9.requestLayout();
            goto L55
        L53:
            if (r13 == r12.bottomMargin) goto L55;
            r12.bottomMargin = r13;
            MarginLayoutParamsCompat.setMarginEnd(r12, 0);
            r9.setLayoutParams(r12);
            r9.requestLayout();
            goto L55
        L44:
            if (r9.getVisibility() != 0) goto L46;
            r13 = (int) ViewUtils.dpToPx(getContext(), 8);
        L55:
            Tab r14 = this.tab;
            if (r14 == null) goto L58;
            r1 = Tab.access$300(r14);
        L58:
            if (r6 == true) goto L61;
            r4 = r1;
        L61:
            TooltipCompat.setTooltipText(this, r4);
            return;
        L34:
            r11 = 8;
            goto L35
        L30:
            r7 = null;
            goto L31
        L25:
            if (Tab.access$1500(this.tab) != 1) goto L27;
        L38:
            r5 = false;
            goto L39
        L15:
            r4 = null;
            goto L17
        L5:
            if (r0.getIcon() == null) goto L7;
            r2 = DrawableCompat.wrap(this.tab.getIcon()).mutate();
            goto L8
        }

        private void tryUpdateBadgeDrawableBounds(View r2) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r2 != this.badgeAnchorView) goto L9;
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r2, getCustomParentForBadge(r2));
            return;
        }

        private boolean hasBadgeDrawable() {
            if (this.badgeDrawable == null) goto L5;
            return true;
        L5:
            return false;
        }

        private FrameLayout getCustomParentForBadge(View r3) {
            if (r3 == this.iconView) goto L8;
            if (r3 == this.textView) goto L8;
            return null;
        L8:
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
            return null;
        L10:
            return (FrameLayout) r3.getParent();
        }

        int getContentWidth() {
            int r3 = 0;
            View[] r1 = {this.textView, this.iconView, this.customView};
            int r8 = 0;
            int r2 = 0;
            boolean r5 = false;
        L3:
            if (r3 >= 3) goto L17;
            View r6 = r1[r3];
            if (r6 == null) goto L15;
            if (r6.getVisibility() != 0) goto L15;
            if (r5 == false) goto L10;
            r2 = Math.min(r2, r6.getLeft());
        L11:
            if (r5 == false) goto L13;
            r8 = Math.max(r8, r6.getRight());
        L14:
            r5 = true;
            goto L15
        L13:
            r8 = r6.getRight();
            goto L14
        L10:
            r2 = r6.getLeft();
        L15:
            r3 = r3 + 1;
            goto L3
        L17:
            return r8 - r2;
        }

        int getContentHeight() {
            int r3 = 0;
            View[] r1 = {this.textView, this.iconView, this.customView};
            int r8 = 0;
            int r2 = 0;
            boolean r5 = false;
        L3:
            if (r3 >= 3) goto L17;
            View r6 = r1[r3];
            if (r6 == null) goto L15;
            if (r6.getVisibility() != 0) goto L15;
            if (r5 == false) goto L10;
            r2 = Math.min(r2, r6.getTop());
        L11:
            if (r5 == false) goto L13;
            r8 = Math.max(r8, r6.getBottom());
        L14:
            r5 = true;
            goto L15
        L13:
            r8 = r6.getBottom();
            goto L14
        L10:
            r2 = r6.getTop();
        L15:
            r3 = r3 + 1;
            goto L3
        L17:
            return r8 - r2;
        }

        public Tab getTab() {
            return this.tab;
        }

        private float approximateLineWidth(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r1) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager r1) {
            this.viewPager = r1;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab r1) {
            this.viewPager.setCurrentItem(r1.getPosition());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    static /* synthetic */ int access$1100(TabLayout r0) {
        return r0.defaultTabTextAppearance;
    }

    static /* synthetic */ int access$1200(TabLayout r0) {
        return r0.selectedTabTextAppearance;
    }

    static /* synthetic */ int access$1300(TabLayout r0) {
        return r0.tabTextAppearance;
    }

    static /* synthetic */ int access$1600(TabLayout r0) {
        return r0.viewPagerScrollState;
    }

    static /* synthetic */ TabIndicatorInterpolator access$1700(TabLayout r0) {
        return r0.tabIndicatorInterpolator;
    }

    static /* synthetic */ TimeInterpolator access$1900(TabLayout r0) {
        return r0.tabIndicatorTimeInterpolator;
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
        tabPool = new Pools.SynchronizedPool(16);
    }

    public TabLayout(Context r2) {
        this(r2, null);
    }

    public TabLayout(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.tabStyle);
    }

    public TabLayout(Context r11, AttributeSet r12, int r13) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r4), r12, r13);
        this.indicatorPosition = -1;
        this.tabs = new ArrayList();
        this.selectedTabTextAppearance = -1;
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new Pools.SimplePool(12);
        Context r7 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r8 = new SlidingTabIndicator(this, r7);
        this.slidingTabIndicator = r8;
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r7, r12, R.styleable.TabLayout, r13, r4, new int[]{R.styleable.TabLayout_tabTextAppearance});
        if ((getBackground() instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r15 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        r0.setFillColor(ColorStateList.valueOf(r15.getColor()));
        r0.initializeElevationOverlay(r7);
        r0.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r0);
    L5:
        setSelectedTabIndicator(MaterialResources.getDrawable(r7, r14, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(r14.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        r8.setSelectedIndicatorHeight(r14.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(r14.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(r14.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(r14.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int r16 = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = r16;
        this.tabPaddingEnd = r16;
        this.tabPaddingTop = r16;
        this.tabPaddingStart = r16;
        this.tabPaddingStart = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
        this.tabPaddingTop = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        if (ThemeEnforcement.isMaterial3Theme(r7) == false) goto L8;
        this.defaultTabTextAppearance = R.attr.textAppearanceTitleSmall;
    L9:
        int r17 = r14.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = r17;
        TypedArray r1 = r7.obtainStyledAttributes(r17, androidx.appcompat.R.styleable.TextAppearance);
        this.tabTextSize = r1.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L32
        this.tabTextColors = MaterialResources.getColorStateList(r7, r1, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L32
        r1.recycle();
        if (r14.hasValue(R.styleable.TabLayout_tabSelectedTextAppearance) == false) goto L14;
        this.selectedTabTextAppearance = r14.getResourceId(R.styleable.TabLayout_tabSelectedTextAppearance, r17);
    L14:
        int r18 = this.selectedTabTextAppearance;
        if (r18 == (-1)) goto L25;
        TypedArray r19 = r7.obtainStyledAttributes(r18, androidx.appcompat.R.styleable.TextAppearance);
        this.selectedTabTextSize = r19.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, (int) this.tabTextSize);     // Catch: Throwable -> L21
        ColorStateList r2 = MaterialResources.getColorStateList(r7, r19, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r2.getColorForState(new int[]{android.R.attr.state_selected}, r2.getDefaultColor()));     // Catch: Throwable -> L21
    L20:
        r19.recycle();
    L21:
        th = move-exception;
        r19.recycle();
        throw th;
    L25:
        if (r14.hasValue(R.styleable.TabLayout_tabTextColor) == false) goto L28;
        this.tabTextColors = MaterialResources.getColorStateList(r7, r14, R.styleable.TabLayout_tabTextColor);
    L28:
        if (r14.hasValue(R.styleable.TabLayout_tabSelectedTextColor) == false) goto L30;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r14.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
    L30:
        this.tabIconTint = MaterialResources.getColorStateList(r7, r14, R.styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode(r14.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r7, r14, R.styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = r14.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.tabIndicatorTimeInterpolator = MotionUtils.resolveThemeInterpolator(r7, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.requestedTabMinWidth = r14.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        this.requestedTabMaxWidth = r14.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.tabBackgroundResId = r14.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = r14.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mode = r14.getInt(R.styleable.TabLayout_tabMode, 1);
        this.tabGravity = r14.getInt(R.styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = r14.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = r14.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        r14.recycle();
        Resources r110 = getResources();
        this.tabTextMultiLineSize = r110.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = r110.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
        return;
    L32:
        th = move-exception;
        r1.recycle();
        throw th;
    L8:
        this.defaultTabTextAppearance = R.attr.textAppearanceButton;
        goto L9
    }

    public void setSelectedTabIndicatorColor(int r2) {
        this.tabSelectedIndicatorColor = r2;
        DrawableUtils.setTint(this.tabSelectedIndicator, r2);
        updateTabViews(false);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r1) {
        this.tabIndicatorHeight = r1;
        this.slidingTabIndicator.setSelectedIndicatorHeight(r1);
    }

    public void setScrollPosition(int r2, float r3, boolean r4) {
        setScrollPosition(r2, r3, r4, true);
    }

    public void setScrollPosition(int r7, float r8, boolean r9, boolean r10) {
        setScrollPosition(r7, r8, r9, r10, true);
    }

    void setScrollPosition(int r6, float r7, boolean r8, boolean r9, boolean r10) {
        int r0 = Math.round(r6 + r7);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L48;
        if (r9 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r6, r7);
    L9:
        ValueAnimator r11 = this.scrollAnimator;
        if (r11 != null) goto L12;
    L14:
        int r12 = calculateScrollXForTab(r6, r7);
        int r13 = getScrollX();
        if (r6 >= getSelectedTabPosition()) goto L18;
        if (r12 < r13) goto L18;
    L22:
        boolean r1 = true;
    L25:
        if (ViewCompat.getLayoutDirection(this) == 1) goto L27;
    L36:
        if (r1 == false) goto L38;
    L40:
        if (r6 >= 0) goto L42;
        r12 = 0;
    L42:
        scrollTo(r12, 0);
    L43:
        if (r8 == false) goto L47;
        setSelectedTabView(r0);
        return;
    L47:
        return;
    L38:
        if (this.viewPagerScrollState == 1) goto L40;
        if (r10 == false) goto L43;
    L27:
        if (r6 >= getSelectedTabPosition()) goto L30;
        if (r12 > r13) goto L30;
    L34:
        r1 = true;
    L30:
        if (r6 <= getSelectedTabPosition()) goto L33;
        if (r12 >= r13) goto L34;
    L33:
        if (r6 == getSelectedTabPosition()) goto L34;
        r1 = false;
    L18:
        if (r6 <= getSelectedTabPosition()) goto L21;
        if (r12 <= r13) goto L22;
    L21:
        if (r6 == getSelectedTabPosition()) goto L22;
        r1 = false;
        goto L25
    L12:
        if (r11.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }

    public void addTab(Tab r2) {
        addTab(r2, this.tabs.isEmpty());
    }

    public void addTab(Tab r2, int r3) {
        addTab(r2, r3, this.tabs.isEmpty());
    }

    public void addTab(Tab r2, boolean r3) {
        addTab(r2, this.tabs.size(), r3);
    }

    public void addTab(Tab r2, int r3, boolean r4) {
        if (r2.parent != this) goto L9;
        configureTab(r2, r3);
        addTabView(r2);
        if (r4 == false) goto L10;
        r2.select();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void addTabFromItemView(TabItem r3) {
        Tab r0 = newTab();
        if (r3.text == null) goto L6;
        r0.setText(r3.text);
    L6:
        if (r3.icon == null) goto L9;
        r0.setIcon(r3.icon);
    L9:
        if (r3.customLayout == 0) goto L12;
        r0.setCustomView(r3.customLayout);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.setContentDescription(r3.getContentDescription());
    L14:
        addTab(r0);
    }

    private boolean isScrollingEnabled() {
        if (getTabMode() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getTabMode() == 2) goto L8;
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (isScrollingEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getActionMasked() != 8) goto L9;
        if (isScrollingEnabled() == true) goto L9;
        return false;
    L9:
        return super.onTouchEvent(r3);
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener r1) {
        setOnTabSelectedListener(r1);
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener r2) {
        BaseOnTabSelectedListener r0 = this.selectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.selectedListener = r2;
        if (r2 == null) goto L9;
        addOnTabSelectedListener(r2);
        return;
    }

    public void addOnTabSelectedListener(OnTabSelectedListener r1) {
        addOnTabSelectedListener(r1);
    }

    @Deprecated
    public void addOnTabSelectedListener(BaseOnTabSelectedListener r2) {
        if (this.selectedListeners.contains(r2) == true) goto L6;
        this.selectedListeners.add(r2);
        return;
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener r1) {
        removeOnTabSelectedListener(r1);
    }

    @Deprecated
    public void removeOnTabSelectedListener(BaseOnTabSelectedListener r1) {
        this.selectedListeners.remove(r1);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab newTab() {
        Tab r0 = createTabFromPool();
        r0.parent = this;
        r0.view = createTabView(r0);
        if (Tab.access$000(r0) == (-1)) goto L5;
        r0.view.setId(Tab.access$000(r0));
    L5:
        return r0;
    }

    protected Tab createTabFromPool() {
        Tab r0 = tabPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Tab();
    }

    protected boolean releaseFromTabPool(Tab r1) {
        return tabPool.release(r1);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public Tab getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return this.tabs.get(r2);
    }

    public int getSelectedTabPosition() {
        Tab r0 = this.selectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPosition();
    }

    public void removeTab(Tab r2) {
        if (r2.parent != this) goto L7;
        removeTabAt(r2.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r8) {
        Tab r0 = this.selectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.getPosition();
    L6:
        removeTabViewAt(r8);
        Tab r2 = this.tabs.remove(r8);
        if (r2 == null) goto L9;
        r2.reset();
        releaseFromTabPool(r2);
    L9:
        int r3 = this.tabs.size();
        int r4 = -1;
        int r5 = r8;
    L10:
        if (r5 >= r3) goto L15;
        if (this.tabs.get(r5).getPosition() != this.indicatorPosition) goto L14;
        r4 = r5;
    L14:
        this.tabs.get(r5).setPosition(r5);
        r5 = r5 + 1;
        goto L10
    L15:
        this.indicatorPosition = r4;
        if (r1 == r8) goto L18;
        return;
    L18:
        if (this.tabs.isEmpty() == false) goto L20;
        Tab r9 = null;
    L21:
        selectTab(r9);
        return;
    L20:
        r9 = this.tabs.get(Math.max(0, r8 - 1));
        goto L21
    L5:
        r1 = 0;
        goto L6
    }

    public void removeAllTabs() {
        int r0 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        removeTabViewAt(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<Tab> r1 = this.tabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Tab r2 = r1.next();
        r1.remove();
        r2.reset();
        releaseFromTabPool(r2);
        goto L7
    L9:
        this.selectedTab = null;
    }

    public void setTabMode(int r2) {
        if (r2 == this.mode) goto L6;
        this.mode = r2;
        applyModeAndGravity();
        return;
    }

    public int getTabMode() {
        return this.mode;
    }

    public void setTabGravity(int r2) {
        if (this.tabGravity == r2) goto L6;
        this.tabGravity = r2;
        applyModeAndGravity();
        return;
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public void setSelectedTabIndicatorGravity(int r2) {
        if (this.tabIndicatorGravity == r2) goto L6;
        this.tabIndicatorGravity = r2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public void setTabIndicatorAnimationMode(int r2) {
        this.tabIndicatorAnimationMode = r2;
        if (r2 != 0) goto L5;
        this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        return;
    L5:
        if (r2 != 1) goto L7;
        this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        return;
    L7:
        if (r2 != 2) goto L10;
        this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        return;
    L10:
        throw new IllegalArgumentException(r2 + " is not a valid TabIndicatorAnimationMode");
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public void setTabIndicatorFullWidth(boolean r1) {
        this.tabIndicatorFullWidth = r1;
        SlidingTabIndicator.access$100(this.slidingTabIndicator);
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public void setInlineLabel(boolean r3) {
        if (this.inlineLabel == r3) goto L16;
        this.inlineLabel = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        ((TabView) r0).updateOrientation();
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(int r2) {
        setInlineLabel(getResources().getBoolean(r2));
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public void setUnboundedRipple(boolean r3) {
        if (this.unboundedRipple == r3) goto L11;
        this.unboundedRipple = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$200((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(int r2) {
        setUnboundedRipple(getResources().getBoolean(r2));
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public void setTabTextColors(ColorStateList r2) {
        if (this.tabTextColors == r2) goto L6;
        this.tabTextColors = r2;
        updateAllTabs();
        return;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public void setTabTextColors(int r1, int r2) {
        setTabTextColors(createColorStateList(r1, r2));
    }

    public void setTabIconTint(ColorStateList r2) {
        if (this.tabIconTint == r2) goto L6;
        this.tabIconTint = r2;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(int r2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public void setTabRippleColor(ColorStateList r3) {
        if (this.tabRippleColorStateList == r3) goto L11;
        this.tabRippleColorStateList = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$200((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(int r2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public void setSelectedTabIndicator(Drawable r2) {
        if (r2 != null) goto L4;
        r2 = new GradientDrawable();
    L4:
        Drawable r3 = DrawableCompat.wrap(r2).mutate();
        this.tabSelectedIndicator = r3;
        DrawableUtils.setTint(r3, this.tabSelectedIndicatorColor);
        int r4 = this.tabIndicatorHeight;
        if (r4 != (-1)) goto L7;
        r4 = this.tabSelectedIndicator.getIntrinsicHeight();
    L7:
        this.slidingTabIndicator.setSelectedIndicatorHeight(r4);
    }

    public void setSelectedTabIndicator(int r2) {
        if (r2 == 0) goto L4;
        setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r2));
        return;
    L4:
        setSelectedTabIndicator(null);
    }

    public void setupWithViewPager(ViewPager r2) {
        setupWithViewPager(r2, true);
    }

    public void setupWithViewPager(ViewPager r2, boolean r3) {
        setupWithViewPager(r2, r3, false);
    }

    private void setupWithViewPager(ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.viewPager;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.pageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.adapterChangeListener;
        if (r2 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r2);
    L10:
        BaseOnTabSelectedListener r6 = this.currentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.currentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L24;
        this.viewPager = r3;
        if (this.pageChangeListener != null) goto L17;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L17:
        this.pageChangeListener.reset();
        r3.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r7 = new ViewPagerOnTabSelectedListener(r3);
        this.currentVpSelectedListener = r7;
        addOnTabSelectedListener(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        setPagerAdapter(r8, r4);
    L21:
        if (this.adapterChangeListener != null) goto L23;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L23:
        this.adapterChangeListener.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.setupViewPagerImplicitly = r5;
        return;
    L24:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L25
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter r2) {
        setPagerAdapter(r2, false);
    }

    void updateViewPagerScrollState(int r1) {
        this.viewPagerScrollState = r1;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r0, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
        return;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.pagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.pagerAdapter = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.registerDataSetObserver(this.pagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r2)), false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r3 = this.viewPager;
        if (r3 == null) goto L18;
        if (r1 <= 0) goto L19;
        int r4 = r3.getCurrentItem();
        if (r4 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r4 >= getTabCount()) goto L21;
        selectTab(getTabAt(r4));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    private void updateAllTabs() {
        int r0 = this.tabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.tabs.get(r1).updateView();
        r1 = r1 + 1;
        goto L3
    }

    private TabView createTabView(Tab r3) {
        Pools.Pool<TabView> r0 = this.tabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = r0.acquire();
    L6:
        if (r1 != null) goto L8;
        r1 = new TabView(this, getContext());
    L8:
        r1.setTab(r3);
        r1.setFocusable(true);
        r1.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$300(r3)) == false) goto L11;
        r1.setContentDescription(Tab.access$400(r3));
    L12:
        return r1;
    L11:
        r1.setContentDescription(Tab.access$300(r3));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private void configureTab(Tab r4, int r5) {
        r4.setPosition(r5);
        this.tabs.add(r5, r4);
        int r6 = this.tabs.size();
        int r7 = r5 + 1;
        int r0 = -1;
    L3:
        if (r7 >= r6) goto L8;
        if (this.tabs.get(r7).getPosition() != this.indicatorPosition) goto L7;
        r0 = r7;
    L7:
        this.tabs.get(r7).setPosition(r7);
        r7 = r7 + 1;
        goto L3
    L8:
        this.indicatorPosition = r0;
    }

    private void addTabView(Tab r3) {
        TabView r0 = r3.view;
        r0.setSelected(false);
        r0.setActivated(false);
        this.slidingTabIndicator.addView(r0, r3.getPosition(), createLayoutParamsForTabs());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1) {
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        addViewInternal(r1);
    }

    private void addViewInternal(View r2) {
        if ((r2 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r2);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r0);
        return r0;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams r3) {
        if (this.mode == 1) goto L5;
    L7:
        r3.width = -2;
        r3.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r3.width = 0;
        r3.weight = 1.0f;
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.view.View
    protected void onDraw(Canvas r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        if ((r1 instanceof TabView) == false) goto L8;
        TabView.access$500((TabView) r1, r4);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onDraw(r4);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r7, int r8) {
        int r0 = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int r1 = View.MeasureSpec.getMode(r8);
        boolean r4 = false;
        if (r1 == Integer.MIN_VALUE) goto L8;
        if (r1 != 0) goto L12;
        r8 = View.MeasureSpec.makeMeasureSpec((r0 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L12:
        int r2 = View.MeasureSpec.getSize(r7);
        if (View.MeasureSpec.getMode(r7) == 0) goto L19;
        int r3 = this.requestedTabMaxWidth;
        if (r3 > 0) goto L18;
        r3 = (int) (r2 - ViewUtils.dpToPx(getContext(), 56));
    L18:
        this.tabMaxWidth = r3;
    L19:
        super.onMeasure(r7, r8);
        if (getChildCount() != 1) goto L36;
        View r9 = getChildAt(0);
        int r5 = this.mode;
        if (r5 == 0) goto L31;
        if (r5 == 1) goto L28;
        if (r5 == 2) goto L31;
    L33:
        if (r4 == false) goto L37;
        r9.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(r8, getPaddingTop() + getPaddingBottom(), r9.getLayoutParams().height));
        return;
    L37:
        return;
    L28:
        if (r9.getMeasuredWidth() == getMeasuredWidth()) goto L33;
    L29:
        r4 = true;
    L31:
        if (r9.getMeasuredWidth() >= getMeasuredWidth()) goto L33;
    L36:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r8) < r0) goto L12;
        getChildAt(0).setMinimumHeight(r0);
        goto L12
    }

    private void removeTabViewAt(int r3) {
        TabView r0 = (TabView) this.slidingTabIndicator.getChildAt(r3);
        this.slidingTabIndicator.removeViewAt(r3);
        if (r0 == null) goto L5;
        r0.reset();
        this.tabViewPool.release(r0);
    L5:
        requestLayout();
    }

    private void animateToTab(int r7) {
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        setScrollPosition(r7, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L17;
        int r0 = getScrollX();
        int r2 = calculateScrollXForTab(r7, 0.0f);
        if (r0 == r2) goto L15;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r0, r2});
        this.scrollAnimator.start();
    L15:
        this.slidingTabIndicator.animateIndicatorToPosition(r7, this.tabIndicatorAnimationDuration);
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.scrollAnimator = r0;
        r0.setInterpolator(this.tabIndicatorTimeInterpolator);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r1) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r1);
    }

    private void setSelectedTabView(int r7) {
        int r0 = this.slidingTabIndicator.getChildCount();
        if (r7 >= r0) goto L32;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L37;
        View r3 = this.slidingTabIndicator.getChildAt(r2);
        boolean r4 = true;
        if (r2 == r7) goto L9;
    L10:
        if (r2 != r7) goto L12;
    L23:
        if (r2 != r7) goto L25;
        boolean r5 = true;
    L26:
        r3.setSelected(r5);
        if (r2 == r7) goto L30;
        r4 = false;
    L30:
        r3.setActivated(r4);
    L31:
        r2 = r2 + 1;
        goto L5
    L25:
        r5 = false;
        goto L26
    L12:
        if (r3.isSelected() == false) goto L23;
    L13:
        if (r2 != r7) goto L15;
        boolean r6 = true;
    L16:
        r3.setSelected(r6);
        if (r2 == r7) goto L20;
        r4 = false;
    L20:
        r3.setActivated(r4);
        if ((r3 instanceof TabView) == false) goto L31;
        ((TabView) r3).updateTab();
        goto L31
    L15:
        r6 = false;
        goto L16
    L9:
        if (r3.isSelected() == false) goto L13;
    L37:
        return;
    }

    public void selectTab(Tab r2) {
        selectTab(r2, true);
    }

    public void selectTab(Tab r5, boolean r6) {
        Tab r0 = this.selectedTab;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L27;
        dispatchTabReselected(r5);
        animateToTab(r5.getPosition());
        return;
    L27:
        return;
    L7:
        if (r5 == null) goto L9;
        int r2 = r5.getPosition();
    L10:
        if (r6 == false) goto L19;
        if (r0 != null) goto L13;
    L14:
        if (r2 == (-1)) goto L16;
        setScrollPosition(r2, 0.0f, true);
    L17:
        if (r2 == (-1)) goto L19;
        setSelectedTabView(r2);
    L16:
        animateToTab(r2);
        goto L17
    L13:
        if (r0.getPosition() != (-1)) goto L16;
    L19:
        this.selectedTab = r5;
        if (r0 != null) goto L22;
    L24:
        if (r5 == null) goto L29;
        dispatchTabSelected(r5);
        return;
    L29:
        return;
    L22:
        if (r0.parent == null) goto L24;
        dispatchTabUnselected(r0);
        goto L24
    L9:
        r2 = -1;
        goto L10
    }

    private void dispatchTabSelected(Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabSelected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabUnselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabReselected(Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabReselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private int calculateScrollXForTab(int r5, float r6) {
        int r0 = this.mode;
        int r1 = 0;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        return 0;
    L7:
        View r2 = this.slidingTabIndicator.getChildAt(r5);
        if (r2 != null) goto L10;
        return 0;
    L10:
        int r7 = r5 + 1;
        if (r7 >= this.slidingTabIndicator.getChildCount()) goto L13;
        View r8 = this.slidingTabIndicator.getChildAt(r7);
    L14:
        int r3 = r2.getWidth();
        if (r8 == null) goto L17;
        r1 = r8.getWidth();
    L17:
        int r9 = (r2.getLeft() + (r3 / 2)) - (getWidth() / 2);
        int r10 = (int) (((r3 + r1) * 0.5f) * r6);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L21;
        return r9 + r10;
    L21:
        return r9 - r10;
    L13:
        r8 = null;
        goto L14
    }

    private void applyModeAndGravity() {
        int r0 = this.mode;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        int r1 = 0;
    L8:
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, r1, 0, 0, 0);
        int r2 = this.mode;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
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
        r1 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        goto L8
    }

    private void applyGravityForModeScrollable(int r2) {
        if (r2 != 0) goto L4;
        Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.slidingTabIndicator.setGravity(GravityCompat.START);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.slidingTabIndicator.setGravity(1);
        return;
    L6:
        if (r2 == 2) goto L10;
    }

    void updateTabViews(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private static ColorStateList createColorStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    private int getDefaultHeight() {
        int r0 = this.tabs.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Tab r3 = this.tabs.get(r2);
        if (r3 == null) goto L11;
        if (r3.getIcon() == null) goto L11;
        if (TextUtils.isEmpty(r3.getText()) == true) goto L11;
        r1 = true;
    L11:
        r2 = r2 + 1;
    L12:
        if (r1 == true) goto L14;
    L16:
        return 48;
    L14:
        if (this.inlineLabel == true) goto L16;
        return 72;
    }

    private int getTabMinWidth() {
        int r0 = this.requestedTabMinWidth;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = this.mode;
        if (r1 == 0) goto L12;
        if (r1 == 2) goto L12;
        return 0;
    L12:
        return this.scrollableTabMinWidth;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }
}
