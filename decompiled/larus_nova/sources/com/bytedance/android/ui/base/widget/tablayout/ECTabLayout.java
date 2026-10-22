package com.bytedance.android.ui.base.widget.tablayout;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.tabs.TabItem;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes14.dex */
@ViewPager.DecorView
public class ECTabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private boolean defaultUnSelected;
    private int indicatorBottomMargin;
    boolean inlineLabel;
    int mode;
    private boolean needBindListener;
    private boolean needHideIndicatorWhenSingleTab;
    private OnScrollChangeListener onScrollChangeListener;
    private TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    private final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ ECTabLayout this$0;

        public AdapterChangeListener(ECTabLayout r100) {
            this.this$0 = r100;
        }

        public void setAutoRefresh(boolean r100) {
            this.autoRefresh = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r100, PagerAdapter r101, PagerAdapter r102) {
            ECTabLayout r103 = this.this$0;
            if (r103.viewPager != r100) goto L6;
            r103.setPagerAdapter(r102, this.autoRefresh);
            return;
        }
    }

    public interface BaseOnTabSelectedListener<T extends Tab> {

        /* JADX INFO: renamed from: com.bytedance.android.ui.base.widget.tablayout.ECTabLayout$BaseOnTabSelectedListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC<T extends Tab> {
            public static void $default$onTabSelected(BaseOnTabSelectedListener r100, Tab r101, boolean r102) {
            }
        }

        void onTabReselected(T r100);

        void onTabSelected(T r100);

        void onTabSelected(T r100, boolean r101);

        void onTabUnselected(T r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnScrollChangeListener {
        void onScrollChange(View r100, int r101, int r102, int r103, int r104);
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ ECTabLayout this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }

        public PagerAdapterObserver(ECTabLayout r100) {
            this.this$0 = r100;
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        private final GradientDrawable defaultSelectionIndicator;
        private int fixedIndicatorWidth;
        private ValueAnimator indicatorAnimator;
        private int indicatorLeft;
        private int indicatorRight;
        private int layoutDirection;
        private int selectedIndicatorHeight;
        private final Paint selectedIndicatorPaint;
        int selectedPosition;
        float selectionOffset;
        final /* synthetic */ ECTabLayout this$0;

        private void updateIndicatorPosition() {
            View r100 = getChildAt(this.selectedPosition);
            if (r100 != null) goto L5;
        L24:
            int r101 = -1;
            int r102 = -1;
        L25:
            setIndicatorPosition(r101, r102);
            return;
        L5:
            if (r100.getWidth() <= 0) goto L24;
            r101 = r100.getLeft();
            r102 = r100.getRight();
            ECTabLayout r103 = this.this$0;
            if (r103.tabIndicatorFullWidth == true) goto L12;
            if ((r100 instanceof TabView) == false) goto L12;
            calculateTabViewContentBounds((TabView) r100, ECTabLayout.access$500(r103));
            r101 = (int) ECTabLayout.access$500(this.this$0).left;
            r102 = (int) ECTabLayout.access$500(this.this$0).right;
        L12:
            if (this.selectionOffset > 0.0f) goto L14;
        L21:
            int r104 = this.fixedIndicatorWidth;
            if (r104 <= 0) goto L25;
            int r105 = (r101 + r102) / 2;
            int r106 = r105 - (r104 / 2);
            int r107 = (r104 / 2) + r105;
            r101 = r106;
            r102 = r107;
            goto L25
        L14:
            if (this.selectedPosition >= (getChildCount() - 1)) goto L21;
            View r108 = getChildAt(this.selectedPosition + 1);
            int r109 = r108.getLeft();
            int r110 = r108.getRight();
            ECTabLayout r111 = this.this$0;
            if (r111.tabIndicatorFullWidth == false) goto L18;
        L20:
            float r112 = this.selectionOffset;
            r101 = (int) ((r109 * r112) + ((1.0f - r112) * r101));
            r102 = (int) ((r110 * r112) + ((1.0f - r112) * r102));
            goto L21
        L18:
            if ((r108 instanceof TabView) == false) goto L20;
            calculateTabViewContentBounds((TabView) r108, ECTabLayout.access$500(r111));
            r109 = (int) ECTabLayout.access$500(this.this$0).left;
            r110 = (int) ECTabLayout.access$500(this.this$0).right;
            goto L20
        }

        public float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        public boolean childrenNeedLayout() {
            int r100 = getChildCount();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L9;
            if (getChildAt(r101).getWidth() <= 0) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas r100) {
            Drawable r101 = this.this$0.tabSelectedIndicator;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.getIntrinsicHeight();
        L6:
            int r104 = this.selectedIndicatorHeight;
            if (r104 < 0) goto L9;
            r103 = r104;
        L9:
            int r105 = this.this$0.tabIndicatorGravity;
            if (r105 != 0) goto L12;
            r102 = (getHeight() - r103) - ECTabLayout.access$700(this.this$0);
            r103 = getHeight() - ECTabLayout.access$700(this.this$0);
        L20:
            int r106 = this.indicatorLeft;
            if (r106 >= 0) goto L23;
        L41:
            super.draw(r100);
            return;
        L23:
            if (this.indicatorRight <= r106) goto L41;
            Drawable r107 = this.this$0.tabSelectedIndicator;
            if (r107 != null) goto L28;
            r107 = this.defaultSelectionIndicator;
        L28:
            Drawable r108 = DrawableCompat.wrap(r107);
            r108.setBounds(this.indicatorLeft, r102, this.indicatorRight, r103);
            Paint r109 = this.selectedIndicatorPaint;
            if (r109 == null) goto L37;
            if (r109.getColor() == 0) goto L37;
            if (Build.VERSION.SDK_INT != 21) goto L35;
            r108.setColorFilter(this.selectedIndicatorPaint.getColor(), PorterDuff.Mode.SRC_IN);
            goto L37
        L35:
            DrawableCompat.setTint(r108, this.selectedIndicatorPaint.getColor());
        L37:
            if (ECTabLayout.access$800(this.this$0) == true) goto L39;
        L40:
            r108.draw(r100);
            goto L41
        L39:
            if (ECTabLayout.access$900(this.this$0).size() == 1) goto L41;
        L12:
            if (r105 == 1) goto L18;
            if (r105 == 2) goto L20;
            if (r105 == 3) goto L17;
            r103 = 0;
            goto L20
        L17:
            r103 = getHeight();
            goto L20
        L18:
            r102 = (getHeight() - r103) / 2;
            r103 = (getHeight() + r103) / 2;
            goto L20
        L5:
            r103 = 0;
            goto L6
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r100) {
            super.onRtlPropertiesChanged(r100);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.layoutDirection == r100) goto L9;
            requestLayout();
            this.layoutDirection = r100;
            return;
        }

        public void setSelectedIndicatorColor(int r100) {
            if (this.selectedIndicatorPaint.getColor() == r100) goto L6;
            this.selectedIndicatorPaint.setColor(r100);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void setSelectedIndicatorFixedWidth(int r100) {
            if (this.fixedIndicatorWidth == r100) goto L6;
            this.fixedIndicatorWidth = r100;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void setSelectedIndicatorHeight(int r100) {
            if (this.selectedIndicatorHeight == r100) goto L6;
            this.selectedIndicatorHeight = r100;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public SlidingTabIndicator(ECTabLayout r100, Context r101) {
            this.this$0 = r100;
            super(r101);
            this.fixedIndicatorWidth = -1;
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            this.indicatorLeft = -1;
            this.indicatorRight = -1;
            setClipChildren(false);
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new Paint();
            this.defaultSelectionIndicator = new GradientDrawable();
        }

        private void calculateTabViewContentBounds(TabView r100, RectF r101) {
            int r102 = TabView.access$600(r100);
            if (r102 >= this.this$0.dpToPx(24)) goto L5;
            r102 = this.this$0.dpToPx(24);
        L5:
            int r103 = (r100.getLeft() + r100.getRight()) / 2;
            int r104 = r102 / 2;
            r101.set(r103 - r104, 0.0f, r103 + r104, 0.0f);
        }

        public void animateIndicatorToPosition(final int r110, int r111) {
            ValueAnimator r100 = this.indicatorAnimator;
            if (r100 != null) goto L5;
        L7:
            View r101 = getChildAt(r110);
            if (r101 != null) goto L11;
            updateIndicatorPosition();
            return;
        L11:
            int r102 = r101.getLeft();
            int r103 = r101.getRight();
            ECTabLayout r104 = this.this$0;
            if (r104.tabIndicatorFullWidth == false) goto L14;
        L16:
            int r105 = this.fixedIndicatorWidth;
            if (r105 <= 0) goto L19;
            int r106 = (r102 + r103) / 2;
            final int r107 = (r105 / 2) + r106;
            final int r108 = r106 - (r105 / 2);
        L20:
            final int r109 = this.indicatorLeft;
            final int r112 = this.indicatorRight;
            if (r109 != r108) goto L23;
            if (r112 != r107) goto L23;
            return;
        L23:
            ValueAnimator r113 = new ValueAnimator();
            this.indicatorAnimator = r113;
            r113.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            r113.setDuration(r111);
            r113.setFloatValues(new float[]{0.0f, 1.0f});
            r113.addUpdateListener(new AnonymousClass1(this, r109, r108, r112, r107));
            r113.addListener(new AnonymousClass2(this, r110));
            r113.start();
            return;
        L19:
            r108 = r102;
            r107 = r103;
            goto L20
        L14:
            if ((r101 instanceof TabView) == false) goto L16;
            calculateTabViewContentBounds((TabView) r101, ECTabLayout.access$500(r104));
            r102 = (int) ECTabLayout.access$500(this.this$0).left;
            r103 = (int) ECTabLayout.access$500(this.this$0).right;
            goto L16
        L5:
            if (r100.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r100, int r110) {
            super.onMeasure(r100, r110);
            if (View.MeasureSpec.getMode(r100) == 1073741824) goto L5;
            return;
        L5:
            ECTabLayout r101 = this.this$0;
            boolean r102 = true;
            if (r101.mode == 1) goto L8;
            return;
        L8:
            if (r101.tabGravity != 1) goto L39;
            int r103 = getChildCount();
            int r104 = 0;
            int r105 = 0;
            int r106 = 0;
        L10:
            if (r105 >= r103) goto L15;
            View r107 = getChildAt(r105);
            if (r107.getVisibility() != 0) goto L14;
            r106 = Math.max(r106, r107.getMeasuredWidth());
        L14:
            r105 = r105 + 1;
            goto L10
        L15:
            if (r106 > 0) goto L17;
            return;
        L17:
            int r108 = this.this$0.dpToPx(16);
            if ((r106 * r103) > (getMeasuredWidth() - (r108 * 2))) goto L28;
            boolean r109 = false;
        L20:
            if (r104 >= r103) goto L27;
            LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) getChildAt(r104).getLayoutParams();
            if (r111.width == r106) goto L24;
        L25:
            r111.width = r106;
            r111.weight = 0.0f;
            r109 = true;
        L26:
            r104 = r104 + 1;
            goto L20
        L24:
            if (r111.weight == 0.0f) goto L26;
        L27:
            r102 = r109;
        L29:
            if (r102 == false) goto L40;
            super.onMeasure(r100, r110);
            return;
        L40:
            return;
        L28:
            ECTabLayout r112 = this.this$0;
            r112.tabGravity = 0;
            r112.updateTabViews(false);
            goto L29
        }

        public void setIndicatorPosition(int r100, int r101) {
            if (r100 == this.indicatorLeft) goto L5;
        L6:
            this.indicatorLeft = r100;
            this.indicatorRight = r101;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r101 != this.indicatorRight) goto L6;
        }

        public void setIndicatorPositionFromTabPosition(int r100, float r101) {
            ValueAnimator r102 = this.indicatorAnimator;
            if (r102 != null) goto L5;
        L7:
            this.selectedPosition = r100;
            this.selectionOffset = r101;
            updateIndicatorPosition();
            return;
        L5:
            if (r102.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            ValueAnimator r105 = this.indicatorAnimator;
            if (r105 != null) goto L5;
        L7:
            updateIndicatorPosition();
            return;
        L5:
            if (r105.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            animateIndicatorToPosition(this.selectedPosition, Math.round((1.0f - this.indicatorAnimator.getAnimatedFraction()) * this.indicatorAnimator.getDuration()));
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence contentDesc;
        private View customView;
        private Drawable icon;
        public ECTabLayout parent;
        private int position;
        private Object tag;
        private CharSequence text;
        public TabView view;

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            select(false);
        }

        public CharSequence getContentDescription() {
            TabView r100 = this.view;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getContentDescription();
        }

        public boolean isSelected() {
            ECTabLayout r100 = this.parent;
            if (r100 == null) goto L14;
            if (ECTabLayout.access$400(r100) == false) goto L10;
            if (this.parent.getSelectedTabPosition() != (-1)) goto L10;
            return false;
        L10:
            if (this.parent.getSelectedTabPosition() != this.position) goto L15;
            return true;
        L15:
            return false;
        L14:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void updateView() {
            TabView r100 = this.view;
            if (r100 == null) goto L6;
            r100.update();
            return;
        }

        public Tab() {
            this.position = -1;
        }

        public View getCustomView() {
            return this.customView;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public int getPosition() {
            return this.position;
        }

        public Object getTag() {
            return this.tag;
        }

        public CharSequence getText() {
            return this.text;
        }

        public View getView() {
            return this.view;
        }

        public static /* synthetic */ CharSequence access$100(Tab r100) {
            return r100.contentDesc;
        }

        public static /* synthetic */ CharSequence access$200(Tab r100) {
            return r100.text;
        }

        public void select(boolean r100) {
            ECTabLayout r101 = this.parent;
            if (r101 == null) goto L7;
            r101.selectTab(this, r100);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(int r100) {
            ECTabLayout r101 = this.parent;
            if (r101 == null) goto L7;
            return setContentDescription(r101.getResources().getText(r100));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setCustomView(int r100) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r100, this.view, false));
        }

        public Tab setIcon(int r100) {
            ECTabLayout r101 = this.parent;
            if (r101 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r101.getContext(), r100));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void setPosition(int r100) {
            this.position = r100;
        }

        public Tab setTag(Object r100) {
            this.tag = r100;
            return this;
        }

        public Tab setText(int r100) {
            ECTabLayout r101 = this.parent;
            if (r101 == null) goto L7;
            return setText(r101.getResources().getText(r100));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(CharSequence r100) {
            this.contentDesc = r100;
            updateView();
            return this;
        }

        public Tab setCustomView(View r100) {
            this.customView = r100;
            updateView();
            return this;
        }

        public Tab setIcon(Drawable r100) {
            this.icon = r100;
            updateView();
            return this;
        }

        public Tab setText(CharSequence r100) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r100;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L7;
            this.view.setContentDescription(r100);
            goto L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<ECTabLayout> tabLayoutRef;

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }

        public TabLayoutOnPageChangeListener(ECTabLayout r100) {
            this.tabLayoutRef = new WeakReference(r100);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r100) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r100) {
            ECTabLayout r101 = this.tabLayoutRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getSelectedTabPosition() != r100) goto L7;
            return;
        L7:
            if (r100 >= r101.getTabCount()) goto L21;
            int r102 = this.scrollState;
            if (r102 != 0) goto L11;
        L16:
            boolean r103 = true;
        L17:
            r101.selectTab(r101.getTabAt(r100), r103, false, true);
            return;
        L11:
            if (r102 == 2) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r100, float r101, int r102) {
            ECTabLayout r103 = this.tabLayoutRef.get();
            if (r103 == null) goto L17;
            int r104 = this.scrollState;
            boolean r105 = false;
            if (r104 == 2) goto L7;
        L10:
            boolean r106 = true;
        L11:
            if (r104 == 2) goto L13;
        L14:
            r105 = true;
        L15:
            r103.setScrollPosition(r100, r101, r106, r105);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r106 = false;
            goto L11
        }
    }

    public class TabView extends LinearLayout {
        private Drawable baseBackgroundDrawable;
        private ImageView customIconView;
        private TextView customTextView;
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;

        /* JADX INFO: renamed from: tab, reason: collision with root package name */
        private Tab f187656tab;
        private TextView textView;
        final /* synthetic */ ECTabLayout this$0;

        private int getContentWidth() {
            int r100 = 0;
            View[] r101 = {this.textView, this.iconView, this.customView};
            int r102 = 0;
            int r103 = 0;
            boolean r104 = false;
        L3:
            if (r100 >= 3) goto L17;
            View r105 = r101[r100];
            if (r105 == null) goto L15;
            if (r105.getVisibility() != 0) goto L15;
            if (r104 == false) goto L10;
            r103 = Math.min(r103, r105.getLeft());
        L11:
            if (r104 == false) goto L13;
            r102 = Math.max(r102, r105.getRight());
        L14:
            r104 = true;
            goto L15
        L13:
            r102 = r105.getRight();
            goto L14
        L10:
            r103 = r105.getLeft();
        L15:
            r100 = r100 + 1;
            goto L3
        L17:
            return r102 - r103;
        }

        private void updateBackgroundDrawable(Context r100) {
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        public final void update() {
            Tab r100 = this.f187656tab;
            if (r100 != null) goto L5;
            return;
        L5:
            View r101 = r100.getCustomView();
            Drawable r102 = null;
            if (r101 == null) goto L22;
            ViewParent r103 = r101.getParent();
            if (r103 == this) goto L12;
            if (r103 == null) goto L11;
            ((ViewGroup) r103).removeView(r101);
        L11:
            addView(r101);
        L12:
            this.customView = r101;
            TextView r104 = this.textView;
            if (r104 == null) goto L15;
            r104.setVisibility(8);
        L15:
            ImageView r105 = this.iconView;
            if (r105 == null) goto L18;
            r105.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L18:
            TextView r106 = (TextView) r101.findViewById(R.id.text1);
            this.customTextView = r106;
            if (r106 == null) goto L21;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r106);
        L21:
            this.customIconView = (ImageView) r101.findViewById(R.id.icon);
        L27:
            if (this.customView == null) goto L29;
            TextView r107 = this.customTextView;
            if (r107 == null) goto L57;
        L58:
            updateTextAndIcon(r107, this.customIconView);
        L60:
            if (TextUtils.isEmpty(Tab.access$100(r100)) == true) goto L62;
            setContentDescription(Tab.access$100(r100));
        L62:
            setSelected(r100.isSelected());
            return;
        L57:
            if (this.customIconView == null) goto L60;
        L29:
            if (this.iconView != null) goto L34;
            if (r100.getIcon() == null) goto L34;
            ImageView r108 = (ImageView) LayoutInflater.from(getContext()).inflate(com.larus.nova.R.layout.design_layout_tab_icon, this, false);
            addView(r108, 0);
            this.iconView = r108;
        L34:
            if (r100.getIcon() == null) goto L36;
            r102 = DrawableCompat.wrap(r100.getIcon()).mutate();
        L36:
            if (r102 == null) goto L41;
            DrawableCompat.setTintList(r102, this.this$0.tabIconTint);
            PorterDuff.Mode r109 = this.this$0.tabIconTintMode;
            if (r109 == null) goto L41;
            DrawableCompat.setTintMode(r102, r109);
        L41:
            if (this.textView == null) goto L43;
        L45:
            TextView r110 = this.textView;
            if (r110 == null) goto L48;
            TextViewCompat.setTextAppearance(r110, this.this$0.tabTextAppearance);
        L48:
            ColorStateList r111 = this.this$0.tabTextColors;
            if (r111 == null) goto L53;
            TextView r112 = this.textView;
            if (r112 == null) goto L53;
            r112.setTextColor(r111);
        L53:
            updateTextAndIcon(this.textView, this.iconView);
            goto L60
        L43:
            if (Tab.access$200(r100) == null) goto L45;
            TextView r113 = (TextView) LayoutInflater.from(getContext()).inflate(com.larus.nova.R.layout.design_layout_tab_text, this, false);
            addView(r113);
            this.textView = r113;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r113);
            goto L45
        L22:
            View r114 = this.customView;
            if (r114 == null) goto L25;
            removeView(r114);
            this.customView = null;
        L25:
            this.customTextView = null;
            this.customIconView = null;
            goto L27
        }

        public final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r100 = this.customTextView;
            if (r100 == null) goto L5;
        L8:
            updateTextAndIcon(r100, this.customIconView);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r100 = getDrawableState();
            Drawable r101 = this.baseBackgroundDrawable;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L7:
            if (r102 == false) goto L10;
            invalidate();
            this.this$0.invalidate();
            return;
        L10:
            return;
        L5:
            if (r101.isStateful() == false) goto L7;
            r102 = false | this.baseBackgroundDrawable.setState(r100);
            goto L7
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r100 = super.performClick();
            if (this.f187656tab == null) goto L8;
            if (r100 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.f187656tab.select(true);
            return true;
        L8:
            return r100;
        }

        public Tab getTab() {
            return this.f187656tab;
        }

        public static /* synthetic */ int access$600(TabView r100) {
            return r100.getContentWidth();
        }

        private void drawBackground(Canvas r100) {
            Drawable r101 = this.baseBackgroundDrawable;
            if (r101 == null) goto L6;
            r101.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r100);
            return;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            super.onInitializeAccessibilityEvent(r100);
            r100.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
            super.onInitializeAccessibilityNodeInfo(r100);
            r100.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void setSelected(boolean r100) {
            if (isSelected() != r100) goto L6;
        L6:
            super.setSelected(r100);
            TextView r101 = this.textView;
            if (r101 == null) goto L9;
            r101.setSelected(r100);
        L9:
            ImageView r102 = this.iconView;
            if (r102 == null) goto L12;
            r102.setSelected(r100);
        L12:
            View r103 = this.customView;
            if (r103 == null) goto L16;
            r103.setSelected(r100);
            return;
        }

        public void setTab(Tab r100) {
            if (r100 == this.f187656tab) goto L6;
            this.f187656tab = r100;
            update();
            return;
        }

        public TabView(ECTabLayout r100, Context r101) {
            this.this$0 = r100;
            super(r101);
            this.defaultMaxLines = 2;
            setClipChildren(false);
            updateBackgroundDrawable(r101);
            ViewCompat.setPaddingRelative(this, r100.tabPaddingStart, r100.tabPaddingTop, r100.tabPaddingEnd, r100.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r100.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public static /* synthetic */ void access$000(TabView r100, Context r101) {
            r100.updateBackgroundDrawable(r101);
        }

        public static /* synthetic */ void access$300(TabView r100, Canvas r101) {
            r100.drawBackground(r101);
        }

        private void updateTextAndIcon(TextView r100, ImageView r101) {
            Tab r102 = this.f187656tab;
            CharSequence r103 = null;
            if (r102 != null) goto L5;
        L7:
            Drawable r104 = null;
        L8:
            Tab r105 = this.f187656tab;
            if (r105 == null) goto L11;
            CharSequence r106 = r105.getText();
        L13:
            if (r101 == null) goto L17;
            if (r104 == null) goto L16;
            r101.setImageDrawable(r104);
            r101.setVisibility(0);
            setVisibility(0);
            goto L17
        L16:
            r101.setVisibility(8);
            r101.setImageDrawable(null);
        L17:
            boolean r107 = !TextUtils.isEmpty(r106);
            if (r100 == null) goto L22;
            if (r107 == false) goto L21;
            r100.setText(r106);
            r100.setVisibility(0);
            setVisibility(0);
            goto L22
        L21:
            r100.setVisibility(8);
            r100.setText(null);
        L22:
            if (r101 == null) goto L37;
            ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
            if (r107 == true) goto L26;
        L28:
            int r109 = 0;
        L30:
            if (this.this$0.inlineLabel == false) goto L35;
            if (r109 == MarginLayoutParamsCompat.getMarginEnd(r108)) goto L37;
            MarginLayoutParamsCompat.setMarginEnd(r108, r109);
            r108.bottomMargin = 0;
            r101.setLayoutParams(r108);
            r101.requestLayout();
            goto L37
        L35:
            if (r109 == r108.bottomMargin) goto L37;
            r108.bottomMargin = r109;
            MarginLayoutParamsCompat.setMarginEnd(r108, 0);
            r101.setLayoutParams(r108);
            r101.requestLayout();
            goto L37
        L26:
            if (r101.getVisibility() != 0) goto L28;
            r109 = this.this$0.dpToPx(8);
        L37:
            Tab r110 = this.f187656tab;
            if (r110 == null) goto L40;
            CharSequence r111 = Tab.access$100(r110);
        L41:
            if (r107 == true) goto L44;
            r103 = r111;
        L44:
            TooltipCompat.setTooltipText(this, r103);
            return;
        L40:
            r111 = null;
            goto L41
        L11:
            r106 = null;
            goto L13
        L5:
            if (r102.getIcon() == null) goto L7;
            r104 = DrawableCompat.wrap(this.f187656tab.getIcon()).mutate();
            goto L8
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r100, int r101) {
            int r102 = View.MeasureSpec.getSize(r100);
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = this.this$0.getTabMaxWidth();
            if (r104 <= 0) goto L7;
            if (r103 == 0) goto L6;
            if (r102 <= r104) goto L7;
        L6:
            r100 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r100, r101);
            if (this.textView == null) goto L35;
            float r105 = this.this$0.tabTextSize;
            int r106 = this.defaultMaxLines;
            ImageView r107 = this.iconView;
            boolean r108 = true;
            if (r107 != null) goto L12;
        L14:
            TextView r109 = this.textView;
            if (r109 != null) goto L17;
        L19:
            float r110 = this.textView.getTextSize();
            int r111 = this.textView.getLineCount();
            int r112 = TextViewCompat.getMaxLines(this.textView);
            if (r105 != r110) goto L24;
            if (r112 < 0) goto L36;
            if (r106 != r112) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r105 <= r110) goto L32;
            if (r111 != 1) goto L32;
            Layout r113 = this.textView.getLayout();
            if (r113 != null) goto L30;
        L31:
            r108 = false;
            goto L32
        L30:
            if (approximateLineWidth(r113, 0, r105) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r108 == false) goto L38;
            this.textView.setTextSize(0, r105);
            this.textView.setMaxLines(r106);
            super.onMeasure(r100, r101);
            return;
        L38:
            return;
        L17:
            if (r109.getLineCount() <= 1) goto L19;
            r105 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r107.getVisibility() != 0) goto L14;
            r106 = 1;
            goto L19
        }

        private float approximateLineWidth(Layout r100, int r101, float r102) {
            return r100.getLineWidth(r101) * (r102 / r100.getPaint().getTextSize());
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r100) {
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r100) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager r100) {
            this.viewPager = r100;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab r100) {
            this.viewPager.setCurrentItem(r100.getPosition());
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab r100, boolean r101) {
            if (this.viewPager.isAttachedToWindow() == true) goto L10;
            return;
        L10:
            this.viewPager.setCurrentItem(r100.getPosition());     // Catch: IllegalArgumentException -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    static {
        tabPool = new Pools.SynchronizedPool(16);
    }

    private void applyModeAndGravity() {
        if (this.mode != 0) goto L5;
        int r100 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
    L6:
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, r100, 0, 0, 0);
        int r101 = this.mode;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L12;
        this.slidingTabIndicator.setGravity(1);
    L12:
        updateTabViews(true);
        return;
    L11:
        this.slidingTabIndicator.setGravity(GravityCompat.START);
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r100);
        return r100;
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r100 = new ValueAnimator();
        this.scrollAnimator = r100;
        r100.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    private int getDefaultHeight() {
        int r100 = this.tabs.size();
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        Tab r103 = (Tab) ListProtector.get(this.tabs, r102);
        if (r103 == null) goto L11;
        if (r103.getIcon() == null) goto L11;
        if (TextUtils.isEmpty(r103.getText()) == true) goto L11;
        r101 = true;
    L11:
        r102 = r102 + 1;
    L12:
        if (r101 == true) goto L14;
    L16:
        return 48;
    L14:
        if (this.inlineLabel == true) goto L16;
        return 72;
    }

    private int getTabMinWidth() {
        int r100 = this.requestedTabMinWidth;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        if (this.mode == 0) goto L10;
        return 0;
    L10:
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void updateAllTabs() {
        int r100 = this.tabs.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ((Tab) ListProtector.get(this.tabs, r101)).updateView();
        r101 = r101 + 1;
        goto L3
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab r100 = tabPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Tab();
    }

    public int getSelectedTabPosition() {
        Tab r100 = this.selectedTab;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getPosition();
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public void removeAllTabs() {
        int r100 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r100 < 0) goto L5;
        removeTabViewAt(r100);
        r100 = r100 - 1;
        goto L3
    L5:
        Iterator<Tab> r101 = this.tabs.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Tab r102 = r101.next();
        r101.remove();
        r102.reset();
        releaseFromTabPool(r102);
        goto L7
    L9:
        this.selectedTab = null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getRightFadingEdgeStrength() {
        return super.getRightFadingEdgeStrength();
    }

    public Tab newTab() {
        Tab r100 = createTabFromPool();
        r100.parent = this;
        r100.view = createTabView(r100);
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.viewPager != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r100, true, true);
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

    public void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r100 = this.pagerAdapter;
        if (r100 == null) goto L17;
        int r101 = r100.getCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r102)), false);
        r102 = r102 + 1;
        goto L5
    L7:
        ViewPager r103 = this.viewPager;
        if (r103 == null) goto L18;
        if (r101 <= 0) goto L19;
        int r104 = r103.getCurrentItem();
        if (r104 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r104 >= getTabCount()) goto L21;
        selectTab(getTabAt(r104), false);
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getIndicatorBottomMargin() {
        return this.indicatorBottomMargin;
    }

    public boolean getNeedHideIndicatorWhenSingleTab() {
        return this.needHideIndicatorWhenSingleTab;
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

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

    public ECTabLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_base_widget_tablayout_ECTabLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ boolean access$400(ECTabLayout r100) {
        return r100.defaultUnSelected;
    }

    public static /* synthetic */ RectF access$500(ECTabLayout r100) {
        return r100.tabViewContentBounds;
    }

    public static /* synthetic */ int access$700(ECTabLayout r100) {
        return r100.indicatorBottomMargin;
    }

    public static /* synthetic */ boolean access$800(ECTabLayout r100) {
        return r100.needHideIndicatorWhenSingleTab;
    }

    public static /* synthetic */ ArrayList access$900(ECTabLayout r100) {
        return r100.tabs;
    }

    private void addTabFromItemView(TabItem r100) {
        Tab r101 = newTab();
        CharSequence r102 = r100.text;
        if (r102 == null) goto L5;
        r101.setText(r102);
    L5:
        Drawable r103 = r100.icon;
        if (r103 == null) goto L8;
        r101.setIcon(r103);
    L8:
        int r104 = r100.customLayout;
        if (r104 == 0) goto L12;
        r101.setCustomView(r104);
    L12:
        if (TextUtils.isEmpty(r100.getContentDescription()) == true) goto L14;
        r101.setContentDescription(r100.getContentDescription());
    L14:
        addTab(r101);
    }

    private void addTabView(Tab r100) {
        TabView r101 = r100.view;
        this.slidingTabIndicator.addView(r101, r100.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View r100) {
        if ((r100 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r100);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private TabView createTabView(Tab r100) {
        Pools.Pool<TabView> r101 = this.tabViewPool;
        if (r101 == null) goto L5;
        TabView r102 = r101.acquire();
    L6:
        if (r102 != null) goto L8;
        r102 = new TabView(this, getContext());
    L8:
        r102.setTab(r100);
        r102.setFocusable(true);
        r102.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$100(r100)) == false) goto L11;
        r102.setContentDescription(Tab.access$200(r100));
    L12:
        return r102;
    L11:
        r102.setContentDescription(Tab.access$100(r100));
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    private void dispatchTabReselected(Tab r100) {
        int r101 = this.selectedListeners.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r101)).onTabReselected(r100);
        r101 = r101 - 1;
        goto L3
    }

    private void dispatchTabUnselected(Tab r100) {
        int r101 = this.selectedListeners.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r101)).onTabUnselected(r100);
        r101 = r101 - 1;
        goto L3
    }

    private void removeTabViewAt(int r100) {
        TabView r101 = (TabView) this.slidingTabIndicator.getChildAt(r100);
        this.slidingTabIndicator.removeViewAt(r100);
        if (r101 == null) goto L5;
        r101.reset();
        this.tabViewPool.release(r101);
    L5:
        requestLayout();
    }

    private void setSelectedTabView(int r100) {
        int r101 = this.slidingTabIndicator.getChildCount();
        if (r100 >= r101) goto L15;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L19;
        View r103 = this.slidingTabIndicator.getChildAt(r102);
        boolean r104 = true;
        if (r102 != r100) goto L9;
        boolean r105 = true;
    L10:
        r103.setSelected(r105);
        if (r102 == r100) goto L14;
        r104 = false;
    L14:
        r103.setActivated(r104);
        r102 = r102 + 1;
        goto L5
    L9:
        r105 = false;
        goto L10
    L19:
        return;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams r100) {
        if (this.mode == 1) goto L5;
    L7:
        r100.width = -2;
        r100.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r100.width = 0;
        r100.weight = 1.0f;
    }

    public void addOnTabSelectedListener(BaseOnTabSelectedListener r100) {
        if (this.selectedListeners.contains(r100) == true) goto L6;
        this.selectedListeners.add(r100);
        return;
    }

    public void addTab(Tab r100) {
        addTab(r100, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100) {
        addViewInternal(r100);
    }

    int dpToPx(int r100) {
        return Math.round(INVOKEVIRTUAL_com_bytedance_android_ui_base_widget_tablayout_ECTabLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density * r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public Tab getTabAt(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r100 >= getTabCount()) goto L7;
        return (Tab) ListProtector.get(this.tabs, r100);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r102 = this.slidingTabIndicator.getChildAt(r101);
        if ((r102 instanceof TabView) == false) goto L8;
        TabView.access$300((TabView) r102, r100);
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        super.onDraw(r100);
    }

    public boolean releaseFromTabPool(Tab r100) {
        return tabPool.release(r100);
    }

    public void removeOnTabSelectedListener(BaseOnTabSelectedListener r100) {
        this.selectedListeners.remove(r100);
    }

    public void removeTab(Tab r100) {
        if (r100.parent != this) goto L7;
        removeTabAt(r100.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r100) {
        Tab r101 = this.selectedTab;
        if (r101 == null) goto L5;
        int r102 = r101.getPosition();
    L6:
        removeTabViewAt(r100);
        Tab r103 = (Tab) ListProtector.remove(this.tabs, r100);
        if (r103 == null) goto L9;
        r103.reset();
        releaseFromTabPool(r103);
    L9:
        int r104 = this.tabs.size();
        int r105 = r100;
    L10:
        if (r105 >= r104) goto L12;
        ((Tab) ListProtector.get(this.tabs, r105)).setPosition(r105);
        r105 = r105 + 1;
        goto L10
    L12:
        if (r102 == r100) goto L14;
        return;
    L14:
        if (this.tabs.isEmpty() == false) goto L16;
        Tab r106 = null;
    L17:
        selectTab(r106, false);
        return;
    L16:
        r106 = (Tab) ListProtector.get(this.tabs, Math.max(0, r100 - 1));
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public void selectTab(int r100) {
        if (getSelectedTabPosition() != r100) goto L6;
        return;
    L6:
        if (r100 < this.tabs.size()) goto L8;
        return;
    L8:
        selectTab((Tab) ListProtector.get(this.tabs, r100), true, false, true);
    }

    public void selectTabWithoutAnimation(int r100) {
        if (getSelectedTabPosition() != r100) goto L6;
        return;
    L6:
        if (r100 < this.tabs.size()) goto L8;
        return;
    L8:
        selectTab((Tab) ListProtector.get(this.tabs, r100), true, false, false);
    }

    public void setBindListenerAble(boolean r100) {
        this.needBindListener = r100;
    }

    public void setDefaultUnSelected(boolean r100) {
        this.defaultUnSelected = r100;
    }

    public void setIndicatorBottomMargin(int r100) {
        this.indicatorBottomMargin = r100;
    }

    public void setInlineLabel(boolean r100) {
        if (this.inlineLabel == r100) goto L16;
        this.inlineLabel = r100;
        int r101 = 0;
    L6:
        if (r101 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r102 = this.slidingTabIndicator.getChildAt(r101);
        if ((r102 instanceof TabView) == false) goto L10;
        ((TabView) r102).updateOrientation();
    L10:
        r101 = r101 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(int r100) {
        setInlineLabel(getResources().getBoolean(r100));
    }

    public void setNeedHideIndicatorWhenSingleTab(boolean r100) {
        this.needHideIndicatorWhenSingleTab = r100;
    }

    public void setOnScrollChangeListenerCompat(OnScrollChangeListener r100) {
        this.onScrollChangeListener = r100;
    }

    public void setOnTabSelectedListener(BaseOnTabSelectedListener r100) {
        BaseOnTabSelectedListener r101 = this.selectedListener;
        if (r101 == null) goto L5;
        removeOnTabSelectedListener(r101);
    L5:
        this.selectedListener = r100;
        if (r100 == null) goto L9;
        addOnTabSelectedListener(r100);
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r100) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r100);
    }

    public void setSelectedTabIndicator(int r100) {
        if (r100 == 0) goto L4;
        setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r100));
        return;
    L4:
        setSelectedTabIndicator(null);
    }

    public void setSelectedTabIndicatorColor(int r100) {
        this.slidingTabIndicator.setSelectedIndicatorColor(r100);
    }

    public void setSelectedTabIndicatorFixedWidth(int r100) {
        this.slidingTabIndicator.setSelectedIndicatorFixedWidth(r100);
    }

    public void setSelectedTabIndicatorGravity(int r100) {
        if (this.tabIndicatorGravity == r100) goto L6;
        this.tabIndicatorGravity = r100;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r100) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(r100);
    }

    public void setTabGravity(int r100) {
        if (this.tabGravity == r100) goto L6;
        this.tabGravity = r100;
        applyModeAndGravity();
        return;
    }

    public void setTabIconTint(ColorStateList r100) {
        if (this.tabIconTint == r100) goto L6;
        this.tabIconTint = r100;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(int r100) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r100));
    }

    public void setTabIndicatorFullWidth(boolean r100) {
        this.tabIndicatorFullWidth = r100;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMaxWidth(int r100) {
        this.requestedTabMaxWidth = r100;
    }

    public void setTabMode(int r100) {
        if (r100 == this.mode) goto L6;
        this.mode = r100;
        applyModeAndGravity();
        return;
    }

    public void setTabPaddingBottom(int r100) {
        this.tabPaddingBottom = r100;
    }

    public void setTabPaddingEnd(int r100) {
        this.tabPaddingEnd = r100;
    }

    public void setTabPaddingStart(int r100) {
        this.tabPaddingStart = r100;
    }

    public void setTabPaddingTop(int r100) {
        this.tabPaddingTop = r100;
    }

    public void setTabRippleColor(ColorStateList r100) {
        if (this.tabRippleColorStateList == r100) goto L11;
        this.tabRippleColorStateList = r100;
        int r101 = 0;
    L6:
        if (r101 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r102 = this.slidingTabIndicator.getChildAt(r101);
        if ((r102 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r102, getContext());
    L10:
        r101 = r101 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(int r100) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r100));
    }

    public void setTabTextColors(ColorStateList r100) {
        if (this.tabTextColors == r100) goto L6;
        this.tabTextColors = r100;
        updateAllTabs();
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r100) {
        setPagerAdapter(r100, false);
    }

    public void setUnboundedRipple(boolean r100) {
        if (this.unboundedRipple == r100) goto L11;
        this.unboundedRipple = r100;
        int r101 = 0;
    L6:
        if (r101 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r102 = this.slidingTabIndicator.getChildAt(r101);
        if ((r102 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r102, getContext());
    L10:
        r101 = r101 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(int r100) {
        setUnboundedRipple(getResources().getBoolean(r100));
    }

    public void setupWithViewPager(ViewPager r100) {
        setupWithViewPager(r100, true);
    }

    void updateTabViews(boolean r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r102 = this.slidingTabIndicator.getChildAt(r101);
        r102.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r102.getLayoutParams());
        if (r100 == false) goto L8;
        r102.requestLayout();
    L8:
        r101 = r101 + 1;
        goto L4
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateDefaultLayoutParams();
    }

    public void selectTab(Tab r100) {
        selectTab(r100, false);
    }

    public void selectTabWithoutAnimation(Tab r100) {
        selectTab(r100, true, true, false);
    }

    public void setSelectedTabIndicator(Drawable r100) {
        if (this.tabSelectedIndicator == r100) goto L6;
        this.tabSelectedIndicator = r100;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public ECTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.tabStyle);
    }

    private void animateToTab(int r100, boolean r101) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L20:
        setScrollPosition(r100, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L20;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L20;
        int r102 = getScrollX();
        int r103 = calculateScrollXForTab(r100, 0.0f);
        if (r102 != r103) goto L15;
    L18:
        this.slidingTabIndicator.animateIndicatorToPosition(r100, this.tabIndicatorAnimationDuration);
        return;
    L15:
        if (r101 == false) goto L17;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r102, r103});
        this.scrollAnimator.start();
        goto L18
    L17:
        scrollTo(r103, 0);
        goto L18
    }

    private int calculateScrollXForTab(int r100, float r101) {
        int r102 = 0;
        if (this.mode != 0) goto L21;
        View r103 = this.slidingTabIndicator.getChildAt(r100);
        int r104 = r100 + 1;
        if (r104 >= this.slidingTabIndicator.getChildCount()) goto L7;
        View r105 = this.slidingTabIndicator.getChildAt(r104);
    L8:
        if (r103 == null) goto L10;
        int r106 = r103.getWidth();
    L11:
        if (r105 == null) goto L13;
        int r107 = r105.getWidth();
    L14:
        if (r103 == null) goto L16;
        r102 = r103.getLeft();
    L16:
        int r108 = (r102 + (r106 / 2)) - (getWidth() / 2);
        int r109 = (int) (((r106 + r107) * 0.5f) * r101);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r108 + r109;
    L20:
        return r108 - r109;
    L13:
        r107 = 0;
        goto L14
    L10:
        r106 = 0;
        goto L11
    L7:
        r105 = null;
        goto L8
    L21:
        return 0;
    }

    private void configureTab(Tab r100, int r101) {
        r100.setPosition(r101);
        ListProtector.add(this.tabs, r101, r100);
        int r102 = this.tabs.size();
    L3:
        r101 = r101 + 1;
        if (r101 >= r102) goto L6;
        ((Tab) ListProtector.get(this.tabs, r101)).setPosition(r101);
        goto L3
    }

    private static ColorStateList createColorStateList(int r100, int r101) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r101, r100});
    }

    private void dispatchTabSelected(Tab r100, boolean r101) {
        int r102 = this.selectedListeners.size() - 1;
    L3:
        if (r102 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r102)).onTabSelected(r100);
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r102)).onTabSelected(r100, r101);
        r102 = r102 - 1;
        goto L3
    }

    public void addTab(Tab r100, int r101) {
        addTab(r100, r101, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100, int r101) {
        addViewInternal(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = (dpToPx(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 0) goto L8;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L8:
        int r104 = View.MeasureSpec.getSize(r100);
        if (View.MeasureSpec.getMode(r100) == 0) goto L15;
        int r105 = this.requestedTabMaxWidth;
        if (r105 > 0) goto L14;
        r105 = r104 - dpToPx(56);
    L14:
        this.tabMaxWidth = r105;
    L15:
        super.onMeasure(r100, r101);
        boolean r106 = true;
        if (getChildCount() != 1) goto L32;
        boolean r107 = false;
        View r108 = getChildAt(0);
        int r109 = this.mode;
        if (r109 == 0) goto L25;
        if (r109 == 1) goto L22;
    L29:
        if (r107 == false) goto L33;
        int r110 = HorizontalScrollView.getChildMeasureSpec(r101, getPaddingTop() + getPaddingBottom(), r108.getLayoutParams().height);
        r108.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r110);
        return;
    L33:
        return;
    L22:
        if (r108.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r106 = false;
    L28:
        r107 = r106;
        goto L29
    L25:
        if (r108.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r101 = View.MeasureSpec.makeMeasureSpec(Math.min(r102, View.MeasureSpec.getSize(r101)), 1073741824);
        goto L8
    }

    public void selectTab(Tab r100, boolean r101) {
        selectTab(r100, true, r101, true);
    }

    void setPagerAdapter(PagerAdapter r100, boolean r101) {
        PagerAdapter r102 = this.pagerAdapter;
        if (r102 == null) goto L7;
        DataSetObserver r103 = this.pagerAdapterObserver;
        if (r103 == null) goto L7;
        r102.unregisterDataSetObserver(r103);
    L7:
        this.pagerAdapter = r100;
        if (r101 == false) goto L15;
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r100.registerDataSetObserver(this.pagerAdapterObserver);
        return;
    }

    public void setTabTextColors(int r100, int r101) {
        setTabTextColors(createColorStateList(r100, r101));
    }

    public void setupWithViewPager(ViewPager r100, boolean r101) {
        setupWithViewPager(r100, r101, false);
    }

    public void addTab(Tab r100, boolean r101) {
        addTab(r100, this.tabs.size(), r101);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r100, ViewGroup.LayoutParams r101) {
        addViewInternal(r100);
    }

    public ECTabLayout(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        this.defaultUnSelected = false;
        this.indicatorBottomMargin = 0;
        this.tabs = new ArrayList();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList();
        this.needHideIndicatorWhenSingleTab = false;
        this.tabViewPool = new Pools.SimplePool(12);
        this.needBindListener = true;
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r100 = new SlidingTabIndicator(this, r210);
        this.slidingTabIndicator = r100;
        super.addView(r100, 0, new FrameLayout.LayoutParams(-2, -1));
        int r110 = 5;
        int r101 = 9;
        int r111 = 8;
        int r112 = 25;
        int r113 = 10;
        TypedArray r102 = ThemeEnforcement.obtainStyledAttributes(r210, r211, new int[]{com.larus.nova.R.attr.tabBackground, com.larus.nova.R.attr.tabContentStart, com.larus.nova.R.attr.tabGravity, com.larus.nova.R.attr.tabIconTint, com.larus.nova.R.attr.tabIconTintMode, com.larus.nova.R.attr.tabIndicator, com.larus.nova.R.attr.tabIndicatorAnimationDuration, com.larus.nova.R.attr.tabIndicatorColor, com.larus.nova.R.attr.tabIndicatorFullWidth, com.larus.nova.R.attr.tabIndicatorGravity, com.larus.nova.R.attr.tabIndicatorHeight, com.larus.nova.R.attr.tabInlineLabel, com.larus.nova.R.attr.tabMaxWidth, com.larus.nova.R.attr.tabMinWidth, com.larus.nova.R.attr.tabMode, com.larus.nova.R.attr.tabPadding, com.larus.nova.R.attr.tabPaddingBottom, com.larus.nova.R.attr.tabPaddingEnd, com.larus.nova.R.attr.tabPaddingStart, com.larus.nova.R.attr.tabPaddingTop, com.larus.nova.R.attr.tabRippleColor, com.larus.nova.R.attr.tabSelectedTextColor, com.larus.nova.R.attr.tabTextAppearance, com.larus.nova.R.attr.tabTextColor, com.larus.nova.R.attr.tabUnboundedRipple}, r212, com.larus.nova.R.style.Widget_Design_TabLayout, new int[]{22});     // Catch: Exception -> L22
    L9:
        this.slidingTabIndicator.setSelectedIndicatorHeight(r102.getDimensionPixelSize(r113, -1));
        this.slidingTabIndicator.setSelectedIndicatorColor(r102.getColor(7, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(r210, r102, r110));
        setSelectedTabIndicatorGravity(r102.getInt(r101, 0));
        setTabIndicatorFullWidth(r102.getBoolean(r111, true));
        int r103 = r102.getDimensionPixelSize(15, 0);
        this.tabPaddingBottom = r103;
        this.tabPaddingEnd = r103;
        this.tabPaddingTop = r103;
        this.tabPaddingStart = r103;
        this.tabPaddingStart = r102.getDimensionPixelSize(18, r103);
        this.tabPaddingTop = r102.getDimensionPixelSize(19, this.tabPaddingTop);
        this.tabPaddingEnd = r102.getDimensionPixelSize(17, this.tabPaddingEnd);
        this.tabPaddingBottom = r102.getDimensionPixelSize(16, this.tabPaddingBottom);
        int r104 = r102.getResourceId(22, com.larus.nova.R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = r104;
        TypedArray r105 = r210.obtainStyledAttributes(r104, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        this.tabTextSize = r105.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L19
        this.tabTextColors = MaterialResources.getColorStateList(r210, r105, 3);     // Catch: Throwable -> L19
        r105.recycle();
        if (r102.hasValue(23) == false) goto L15;
        this.tabTextColors = MaterialResources.getColorStateList(r210, r102, 23);
    L15:
        if (r102.hasValue(21) == false) goto L17;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r102.getColor(21, 0));
    L17:
        this.tabIconTint = MaterialResources.getColorStateList(r210, r102, 3);
        this.tabIconTintMode = ViewUtils.parseTintMode(r102.getInt(4, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r210, r102, 20);
        this.tabIndicatorAnimationDuration = r102.getInt(6, 300);
        this.requestedTabMinWidth = r102.getDimensionPixelSize(13, -1);
        this.requestedTabMaxWidth = r102.getDimensionPixelSize(12, -1);
        this.tabBackgroundResId = r102.getResourceId(0, 0);
        this.contentInsetStart = r102.getDimensionPixelSize(1, 0);
        this.mode = r102.getInt(14, 1);
        this.tabGravity = r102.getInt(2, 0);
        this.inlineLabel = r102.getBoolean(11, false);
        this.unboundedRipple = r102.getBoolean(24, false);
        r102.recycle();
        Resources r106 = getResources();
        this.tabTextMultiLineSize = r106.getDimensionPixelSize(com.larus.nova.R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = r106.getDimensionPixelSize(com.larus.nova.R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
        return;
    L19:
        th = move-exception;
        r105.recycle();
        throw th;
    L8:
        int[] r107 = new int[r112];
        r107 = {x0252: FILL_ARRAY_DATA  (LINE:50332242), data: [2130974357, 2130974358, 2130974359, 2130974360, 2130974361, 2130974362, 2130974363, 2130974364, 2130974365, 2130974366, 2130974367, 2130974370, 2130974371, 2130974372, 2130974373, 2130974375, 2130974376, 2130974377, 2130974378, 2130974379, 2130974380, 2130974381, 2130974383, 2130974384, 2130974385} // fill-array;
        r102 = r210.obtainStyledAttributes(r211, r107);
    L7:
        r101 = 9;
        r111 = 8;
        r113 = 10;
        r110 = 5;
        r112 = 25;
        goto L8
    }

    private void setupWithViewPager(ViewPager r100, boolean r101, boolean r102) {
        ViewPager r103 = this.viewPager;
        if (r103 == null) goto L10;
        TabLayoutOnPageChangeListener r104 = this.pageChangeListener;
        if (r104 == null) goto L7;
        r103.removeOnPageChangeListener(r104);
    L7:
        AdapterChangeListener r105 = this.adapterChangeListener;
        if (r105 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r105);
    L10:
        BaseOnTabSelectedListener r106 = this.currentVpSelectedListener;
        if (r106 == null) goto L13;
        removeOnTabSelectedListener(r106);
        this.currentVpSelectedListener = null;
    L13:
        if (r100 == null) goto L27;
        this.viewPager = r100;
        if (this.needBindListener == true) goto L17;
    L20:
        PagerAdapter r107 = r100.getAdapter();
        if (r107 == null) goto L24;
        setPagerAdapter(r107, r101);
    L24:
        if (this.adapterChangeListener != null) goto L26;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L26:
        this.adapterChangeListener.setAutoRefresh(r101);
        r100.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r100.getCurrentItem(), 0.0f, true);
    L28:
        this.setupViewPagerImplicitly = r102;
        return;
    L17:
        if (this.pageChangeListener != null) goto L19;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L19:
        this.pageChangeListener.reset();
        r100.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r108 = new ViewPagerOnTabSelectedListener(r100);
        this.currentVpSelectedListener = r108;
        addOnTabSelectedListener(r108);
        goto L20
    L27:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L28
    }

    public void addTab(Tab r100, int r101, boolean r102) {
        if (r100.parent != this) goto L9;
        configureTab(r100, r101);
        addTabView(r100);
        if (r102 == false) goto L10;
        r100.select(false);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        addViewInternal(r100);
    }

    public void setScrollPosition(int r100, float r101, boolean r102) {
        setScrollPosition(r100, r101, r102, true);
    }

    @Override // android.view.View
    public void onScrollChanged(int r100, int r101, int r102, int r110) {
        super.onScrollChanged(r100, r101, r102, r110);
        OnScrollChangeListener r103 = this.onScrollChangeListener;
        if (r103 == null) goto L6;
        r103.onScrollChange(this, r100, r101, r102, r110);
        return;
    }

    public void selectTab(Tab r100, boolean r101, boolean r102, boolean r103) {
        Tab r104 = this.selectedTab;
        if (r104 != r100) goto L7;
        if (r104 == null) goto L26;
        dispatchTabReselected(r100);
        animateToTab(r100.getPosition(), r103);
        return;
    L26:
        return;
    L7:
        if (r100 == null) goto L9;
        int r105 = r100.getPosition();
    L10:
        if (r101 == true) goto L12;
    L20:
        this.selectedTab = r100;
        if (r104 == null) goto L23;
        dispatchTabUnselected(r104);
    L23:
        if (r100 == null) goto L28;
        dispatchTabSelected(r100, r102);
        return;
    L28:
        return;
    L12:
        if (r104 != null) goto L14;
    L15:
        if (r105 == (-1)) goto L17;
        setScrollPosition(r105, 0.0f, true);
    L18:
        if (r105 == (-1)) goto L20;
        setSelectedTabView(r105);
    L17:
        animateToTab(r105, true);
        goto L18
    L14:
        if (r104.getPosition() != (-1)) goto L17;
    L9:
        r105 = -1;
        goto L10
    }

    public void setScrollPosition(int r100, float r101, boolean r102, boolean r103) {
        int r104 = Math.round(r100 + r101);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r104 >= this.slidingTabIndicator.getChildCount()) goto L20;
        if (r103 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r100, r101);
    L9:
        ValueAnimator r105 = this.scrollAnimator;
        if (r105 != null) goto L12;
    L14:
        scrollTo(calculateScrollXForTab(r100, r101), 0);
        if (r102 == false) goto L19;
        setSelectedTabView(r104);
        return;
    L19:
        return;
    L12:
        if (r105.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }
}
