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
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
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
import androidx.appcompat.widget.aa;
import androidx.core.view.ViewCompat;
import androidx.core.view.g;
import androidx.core.view.w;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.i;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.a
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
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final androidx.core.util.f.a<d> tabPool = null;
    private a adapterChangeListener;
    private int contentInsetStart;
    private b currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private e pageChangeListener;
    private androidx.viewpager.widget.a pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private b selectedListener;
    private final ArrayList<b> selectedListeners;
    private d selectedTab;
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
    private com.google.android.material.tabs.c tabIndicatorInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final androidx.core.util.f.a<TabView> tabViewPool;
    private final ArrayList<d> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

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
        int selectedPosition;
        float selectionOffset;
        final /* synthetic */ TabLayout this$0;

        static /* synthetic */ void access$100(SlidingTabIndicator r0) {
            r0.jumpIndicatorToSelectedPosition();
        }

        static /* synthetic */ void access$1400(SlidingTabIndicator r0, View r1, View r2, float r3) {
            r0.tweenIndicatorPosition(r1, r2, r3);
        }

        SlidingTabIndicator(TabLayout r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
            this.selectedPosition = -1;
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

        void setIndicatorPositionFromTabPosition(int r2, float r3) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            this.selectedPosition = r2;
            this.selectionOffset = r3;
            tweenIndicatorPosition(getChildAt(r2), getChildAt(this.selectedPosition + 1), this.selectionOffset);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.layoutDirection == r3) goto L9;
            requestLayout();
            this.layoutDirection = r3;
            return;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r10, int r11) {
            super.onMeasure(r10, r11);
            if (View.MeasureSpec.getMode(r10) == 1073741824) goto L5;
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
            if ((r5 * r0) > (getMeasuredWidth() - (((int) r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 16)) * 2))) goto L28;
            boolean r1 = false;
        L20:
            if (r3 >= r0) goto L27;
            LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r3).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
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
            super.onMeasure(r10, r11);
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
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.indicatorAnimator;
            if (r6 != null) goto L5;
        L7:
            jumpIndicatorToSelectedPosition();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
        }

        private void jumpIndicatorToSelectedPosition() {
            View r0 = getChildAt(this.selectedPosition);
            com.google.android.material.tabs.c r1 = TabLayout.access$1300(this.this$0);
            TabLayout r3 = this.this$0;
            r1.a(r3, r0, r3.tabSelectedIndicator);
        }

        private void tweenIndicatorPosition(View r8, View r9, float r10) {
            if (r8 != null) goto L4;
        L6:
            boolean r0 = false;
        L7:
            if (r0 == false) goto L9;
            com.google.android.material.tabs.c r1 = TabLayout.access$1300(this.this$0);
            TabLayout r2 = this.this$0;
            r1.a(r2, r8, r9, r10, r2.tabSelectedIndicator);
        L10:
            ViewCompat.f(this);
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
        L7:
            updateOrRecreateIndicatorAnimation(true, r2, r3);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        private void updateOrRecreateIndicatorAnimation(boolean r4, final int r5, int r6) {
            final View r0 = getChildAt(this.selectedPosition);
            final View r1 = getChildAt(r5);
            if (r1 != null) goto L6;
            jumpIndicatorToSelectedPosition();
            return;
        L6:
            ValueAnimator.AnimatorUpdateListener r2 = new AnonymousClass1(this, r0, r1);
            if (r4 == false) goto L9;
            ValueAnimator r7 = new ValueAnimator();
            this.indicatorAnimator = r7;
            r7.setInterpolator(com.google.android.material.animation.a.f13143b);
            r7.setDuration(r6);
            r7.setFloatValues(new float[]{0.0f, 1.0f});
            r7.addUpdateListener(r2);
            r7.addListener(new AnonymousClass2(this, r5));
            r7.start();
            return;
        L9:
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r2);
        }

        @Override // android.view.View
        public void draw(Canvas r6) {
            int r0 = this.this$0.tabSelectedIndicator.getBounds().height();
            if (r0 >= 0) goto L5;
            r0 = this.this$0.tabSelectedIndicator.getIntrinsicHeight();
        L5:
            int r1 = this.this$0.tabIndicatorGravity;
            int r2 = 0;
            if (r1 != 0) goto L8;
            r2 = getHeight() - r0;
            r0 = getHeight();
        L17:
            if (this.this$0.tabSelectedIndicator.getBounds().width() <= 0) goto L29;
            Rect r3 = this.this$0.tabSelectedIndicator.getBounds();
            this.this$0.tabSelectedIndicator.setBounds(r3.left, r2, r3.right, r0);
            Drawable r4 = this.this$0.tabSelectedIndicator;
            if (TabLayout.access$1500(this.this$0) == 0) goto L25;
            r4 = androidx.core.graphics.drawable.a.g(r4);
            if (Build.VERSION.SDK_INT != 21) goto L23;
            r4.setColorFilter(TabLayout.access$1500(this.this$0), PorterDuff.Mode.SRC_IN);
        L28:
            r4.draw(r6);
            goto L29
        L23:
            androidx.core.graphics.drawable.a.a(r4, TabLayout.access$1500(this.this$0));
            goto L28
        L25:
            if (Build.VERSION.SDK_INT != 21) goto L27;
            r4.setColorFilter(null);
            goto L28
        L27:
            androidx.core.graphics.drawable.a.a(r4, null);
        L29:
            super.draw(r6);
            return;
        L8:
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L13;
            r0 = 0;
            goto L17
        L13:
            r0 = getHeight();
            goto L17
        L14:
            r2 = (getHeight() - r0) / 2;
            r0 = (getHeight() + r0) / 2;
            goto L17
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
        private d tab;
        private TextView textView;
        final /* synthetic */ TabLayout this$0;

        static /* synthetic */ BadgeDrawable access$1000(TabView r0) {
            return r0.getBadge();
        }

        static /* synthetic */ void access$1100(TabView r0, View r1) {
            r0.tryUpdateBadgeDrawableBounds(r1);
        }

        static /* synthetic */ void access$200(TabView r2, Context r3) {
            r2.updateBackgroundDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
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

        public TabView(TabLayout r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r5;
            super(r7);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(r7);
            ViewCompat.b(this, r5.tabPaddingStart, r5.tabPaddingTop, r5.tabPaddingEnd, r5.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r5.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.a(this, w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1002));
        }

        private void updateBackgroundDrawable(Context r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            GradientDrawable r2 = null;
            if (this.this$0.tabBackgroundResId == 0) goto L9;
            Drawable r9 = androidx.appcompat.a.a.a.b(r8, this.this$0.tabBackgroundResId);
            this.baseBackgroundDrawable = r9;
            if (r9 != null) goto L7;
        L10:
            Drawable r10 = new GradientDrawable();
            ((GradientDrawable) ZeusTransformUtils.preCheckCast(r10, GradientDrawable.class, "com.obric.aiagent.plugin")).setColor(0);
            if (this.this$0.tabRippleColorStateList == null) goto L23;
            GradientDrawable r0 = new GradientDrawable();
            r0.setCornerRadius(1.0E-5f);
            r0.setColor(-1);
            ColorStateList r3 = com.google.android.material.ripple.a.a(this.this$0.tabRippleColorStateList);
            if (Build.VERSION.SDK_INT >= 21) goto L15;
            Drawable r1 = androidx.core.graphics.drawable.a.g(r0);
            androidx.core.graphics.drawable.a.a(r1, r3);
            r10 = new LayerDrawable(new Drawable[]{r10, r1});
            goto L23
        L15:
            if (this.this$0.unboundedRipple == false) goto L18;
            r10 = null;
        L18:
            if (this.this$0.unboundedRipple == true) goto L21;
            r2 = r0;
        L21:
            r10 = new RippleDrawable(r3, r10, r2);
        L23:
            ViewCompat.a(this, r10);
            this.this$0.invalidate();
            return;
        L7:
            if (r9.isStateful() == false) goto L10;
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
        public void drawableStateChanged() {
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
            this.tab.f();
            return true;
        L8:
            return r0;
        }

        @Override // android.view.View
        public void setSelected(boolean r3) {
            if (isSelected() == r3) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r3);
            if (r0 == false) goto L12;
            if (r3 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            TextView r1 = this.textView;
            if (r1 == null) goto L15;
            r1.setSelected(r3);
        L15:
            ImageView r2 = this.iconView;
            if (r2 == null) goto L18;
            r2.setSelected(r3);
        L18:
            View r4 = this.customView;
            if (r4 == null) goto L22;
            r4.setSelected(r3);
            return;
        L22:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r7) {
            super.onInitializeAccessibilityNodeInfo(r7);
            BadgeDrawable r0 = this.badgeDrawable;
            if (r0 != null) goto L5;
        L7:
            androidx.core.view.accessibility.b r8 = androidx.core.view.accessibility.b.a(r7);
            r8.c(androidx.core.view.accessibility.b.g.a(0, 1, this.tab.c(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r8.h(false);
            r8.b(androidx.core.view.accessibility.b.a.f1442e);
        L10:
            r8.j(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.item_view_role_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "item_view_role_description")));
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
            int r12 = TextViewCompat.a(this.textView);
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

        void setTab(d r2) {
            if (r2 == this.tab) goto L6;
            this.tab = r2;
            update();
            return;
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        final void update() {
            d r0 = this.tab;
            if (r0 == null) goto L5;
            View r2 = r0.a();
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.customView = r2;
            TextView r4 = this.textView;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.iconView;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L18:
            TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.text1), TextView.class, "com.obric.aiagent.plugin");
            this.customTextView = r1;
            if (r1 == null) goto L21;
            this.defaultMaxLines = TextViewCompat.a(r1);
        L21:
            this.customIconView = (ImageView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.icon), ImageView.class, "com.obric.aiagent.plugin");
        L27:
            if (this.customView == null) goto L29;
            TextView r6 = this.customTextView;
            if (r6 == null) goto L41;
        L42:
            updateTextAndIcon(r6, this.customIconView);
        L43:
            if (r0 != null) goto L45;
        L47:
            if (r0 != null) goto L49;
        L51:
            boolean r7 = false;
        L52:
            setSelected(r7);
            return;
        L49:
            if (r0.g() == false) goto L51;
            r7 = true;
            goto L52
        L45:
            if (TextUtils.isEmpty(d.b(r0)) == true) goto L47;
            setContentDescription(d.b(r0));
            goto L47
        L41:
            if (this.customIconView == null) goto L43;
        L29:
            if (this.iconView != null) goto L32;
            inflateAndAddDefaultIconView();
        L32:
            if (this.textView != null) goto L34;
            inflateAndAddDefaultTextView();
            this.defaultMaxLines = TextViewCompat.a(this.textView);
        L34:
            TextViewCompat.a(this.textView, this.this$0.tabTextAppearance);
            if (this.this$0.tabTextColors == null) goto L37;
            this.textView.setTextColor(this.this$0.tabTextColors);
        L37:
            updateTextAndIcon(this.textView, this.iconView);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
            goto L43
        L22:
            View r8 = this.customView;
            if (r8 == null) goto L25;
            removeView(r8);
            this.customView = null;
        L25:
            this.customTextView = null;
            this.customIconView = null;
            goto L27
        L5:
            r2 = null;
            goto L6
        }

        private void inflateAndAddDefaultIconView() {
            if (com.google.android.material.badge.a.f13204a == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0, 0);
            ViewGroup r1 = r0;
        L6:
            ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_icon, "layout", "design_layout_tab_icon"), r1, false, "com.obric.aiagent.plugin"), ImageView.class, "com.obric.aiagent.plugin");
            this.iconView = r2;
            r1.addView(r2, 0);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private void inflateAndAddDefaultTextView() {
            if (com.google.android.material.badge.a.f13204a == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0);
            ViewGroup r1 = r0;
        L6:
            TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_text, "layout", "design_layout_tab_text"), r1, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin");
            this.textView = r2;
            r1.addView(r2);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r0;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable != null) goto L5;
            this.badgeDrawable = BadgeDrawable.create((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        L5:
            tryUpdateBadgeAnchor();
            BadgeDrawable r3 = this.badgeDrawable;
            if (r3 == null) goto L9;
            return r3;
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
            d r0 = this.tab;
            if (r0 == null) goto L19;
            if (r0.b() == null) goto L19;
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
            d r3 = this.tab;
            if (r3 == null) goto L28;
            if (r3.e() != 1) goto L28;
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
            com.google.android.material.badge.a.a(this.badgeDrawable, r3, getCustomParentForBadge(r3));
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
            com.google.android.material.badge.a.a(this.badgeDrawable, r0);
            this.badgeAnchorView = null;
            return;
        }

        private void clipViewToPaddingForBadge(boolean r3) {
            setClipChildren(r3);
            setClipToPadding(r3);
            ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L6;
            r2.setClipChildren(r3);
            r2.setClipToPadding(r3);
            return;
        }

        final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r0 = this.customTextView;
            if (r0 == null) goto L5;
        L8:
            updateTextAndIcon(r0, this.customIconView);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView);
        }

        private void updateTextAndIcon(TextView r9, ImageView r10) {
            d r0 = this.tab;
            CharSequence r1 = null;
            if (r0 != null) goto L5;
        L7:
            Drawable r2 = null;
        L8:
            if (r2 == null) goto L12;
            androidx.core.graphics.drawable.a.a(r2, this.this$0.tabIconTint);
            if (this.this$0.tabIconTintMode == null) goto L12;
            androidx.core.graphics.drawable.a.a(r2, this.this$0.tabIconTintMode);
        L12:
            d r3 = this.tab;
            if (r3 == null) goto L15;
            CharSequence r4 = r3.d();
        L17:
            if (r10 == null) goto L21;
            if (r2 == null) goto L20;
            r10.setImageDrawable(r2);
            r10.setVisibility(0);
            setVisibility(0);
            goto L21
        L20:
            r10.setVisibility(8);
            r10.setImageDrawable(null);
        L21:
            boolean r5 = !TextUtils.isEmpty(r4);
            if (r9 == null) goto L30;
            if (r5 == false) goto L29;
            r9.setText(r4);
            if (d.d(this.tab) != 1) goto L27;
            r9.setVisibility(0);
        L28:
            setVisibility(0);
            goto L30
        L27:
            r9.setVisibility(8);
            goto L28
        L29:
            r9.setVisibility(8);
            r9.setText(null);
        L30:
            if (r10 == null) goto L45;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
            if (r5 == true) goto L34;
        L36:
            int r6 = 0;
        L38:
            if (this.this$0.inlineLabel == false) goto L43;
            if (r6 == g.b(r11)) goto L45;
            g.b(r11, r6);
            r11.bottomMargin = 0;
            r10.setLayoutParams(r11);
            r10.requestLayout();
            goto L45
        L43:
            if (r6 == r11.bottomMargin) goto L45;
            r11.bottomMargin = r6;
            g.b(r11, 0);
            r10.setLayoutParams(r11);
            r10.requestLayout();
            goto L45
        L34:
            if (r10.getVisibility() != 0) goto L36;
            r6 = (int) r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 8);
        L45:
            d r12 = this.tab;
            if (r12 == null) goto L49;
            r1 = d.b(r12);
        L49:
            if (Build.VERSION.SDK_INT >= 21) goto L51;
        L52:
            if (r5 == true) goto L55;
            r4 = r1;
        L55:
            aa.a(this, r4);
            return;
        L51:
            if (Build.VERSION.SDK_INT > 23) goto L52;
            return;
        L15:
            r4 = null;
            goto L17
        L5:
            if (r0.b() == null) goto L7;
            r2 = androidx.core.graphics.drawable.a.g(this.tab.b()).mutate();
            goto L8
        }

        private void tryUpdateBadgeDrawableBounds(View r2) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r2 != this.badgeAnchorView) goto L9;
            com.google.android.material.badge.a.b(this.badgeDrawable, r2, getCustomParentForBadge(r2));
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
            if (com.google.android.material.badge.a.f13204a == true) goto L10;
            return null;
        L10:
            return (FrameLayout) ZeusTransformUtils.preCheckCast(r3.getParent(), FrameLayout.class, "com.obric.aiagent.plugin");
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

        public d getTab() {
            return this.tab;
        }

        private float approximateLineWidth(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }
    }

    private class a implements ViewPager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f13617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13618b;

        a(TabLayout r1) {
            this.f13617a = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void onAdapterChanged(ViewPager r1, androidx.viewpager.widget.a r2, androidx.viewpager.widget.a r3) {
            if (this.f13617a.viewPager != r1) goto L6;
            this.f13617a.setPagerAdapter(r3, this.f13618b);
            return;
        }

        void a(boolean r1) {
            this.f13618b = r1;
        }
    }

    @Deprecated
    public interface b<T extends d> {
        void a(T r1);

        void b(T r1);

        void c(T r1);
    }

    public interface c extends b<d> {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TabLayout f13619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TabView f13620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f13621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Drawable f13622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f13623e;
        private CharSequence f;
        private int g;
        private View h;
        private int i;
        private int j;

        static /* synthetic */ int a(d r0) {
            return r0.j;
        }

        static /* synthetic */ CharSequence b(d r0) {
            return r0.f;
        }

        static /* synthetic */ CharSequence c(d r0) {
            return r0.f13623e;
        }

        static /* synthetic */ int d(d r0) {
            return r0.i;
        }

        public d() {
            this.g = -1;
            this.i = 1;
            this.j = -1;
        }

        public View a() {
            return this.h;
        }

        public d a(View r1) {
            this.h = r1;
            h();
            return this;
        }

        public d a(int r5) {
            return a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13620b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r5, this.f13620b, false, "com.obric.aiagent.plugin"));
        }

        public Drawable b() {
            return this.f13622d;
        }

        public int c() {
            return this.g;
        }

        void b(int r1) {
            this.g = r1;
        }

        public CharSequence d() {
            return this.f13623e;
        }

        public d a(Drawable r3) {
            this.f13622d = r3;
            if (this.f13619a.tabGravity != 1) goto L5;
        L6:
            this.f13619a.updateTabViews(true);
        L7:
            h();
            if (com.google.android.material.badge.a.f13204a == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$600(this.f13620b) == false) goto L14;
            if (TabView.access$700(this.f13620b).isVisible() == false) goto L14;
            this.f13620b.invalidate();
            goto L14
        L5:
            if (this.f13619a.mode != 2) goto L7;
            goto L6
        }

        public d a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(this.f) == true) goto L5;
        L7:
            this.f13623e = r4;
            h();
            return this;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L7;
            this.f13620b.setContentDescription(r4);
            goto L7
        }

        public int e() {
            return this.i;
        }

        public void f() {
            TabLayout r0 = this.f13619a;
            if (r0 == null) goto L7;
            r0.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            TabLayout r0 = this.f13619a;
            if (r0 == null) goto L12;
            int r1 = r0.getSelectedTabPosition();
            if (r1 != (-1)) goto L7;
        L9:
            return false;
        L7:
            if (r1 != this.g) goto L9;
            return true;
        L12:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public d b(CharSequence r3) {
            this.f = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            h();
            return this;
        }

        void h() {
            TabView r0 = this.f13620b;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void i() {
            this.f13619a = null;
            this.f13620b = null;
            this.f13621c = null;
            this.f13622d = null;
            this.j = -1;
            this.f13623e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    public static class e implements ViewPager.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<TabLayout> f13624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13626c;

        public e(TabLayout r2) {
            this.f13624a = new WeakReference(r2);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int r2) {
            this.f13625b = this.f13626c;
            this.f13626c = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int r6, float r7, int r8) {
            TabLayout r9 = (TabLayout) ZeusTransformUtils.preCheckCast(this.f13624a.get(), TabLayout.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            int r0 = this.f13626c;
            boolean r1 = false;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L14:
            r1 = true;
        L15:
            r9.setScrollPosition(r6, r7, r4, r1);
            return;
        L13:
            if (this.f13625b == 0) goto L15;
        L7:
            if (this.f13625b == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int r4) {
            TabLayout r0 = (TabLayout) ZeusTransformUtils.preCheckCast(this.f13624a.get(), TabLayout.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.f13626c;
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
            if (this.f13625b != 0) goto L15;
        }

        void a() {
            this.f13626c = 0;
            this.f13625b = 0;
        }
    }

    public static class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f13627a;

        @Override // com.google.android.material.tabs.TabLayout.b
        public void b(d r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void c(d r1) {
        }

        public f(ViewPager r1) {
            this.f13627a = r1;
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void a(d r1) {
            this.f13627a.setCurrentItem(r1.c());
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ com.google.android.material.tabs.c access$1300(TabLayout r0) {
        return r0.tabIndicatorInterpolator;
    }

    static /* synthetic */ int access$1500(TabLayout r0) {
        return r0.tabSelectedIndicatorColor;
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_TabLayout, "style", "Widget_Design_TabLayout");
        tabPool = new androidx.core.util.f.c(16);
    }

    public TabLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public TabLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.tabStyle, "attr", "tabStyle"));
    }

    public TabLayout(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r16, r3, r15, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r15);
        this.tabs = new ArrayList();
        this.tabSelectedIndicator = new GradientDrawable();
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new androidx.core.util.f.b(12);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r8 = new SlidingTabIndicator(this, r0);
        this.slidingTabIndicator = r8;
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r17 = l.a(r0, r3, R.styleable.TabLayout, r15, r6, new int[]{ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance")});
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L5;
        ColorDrawable r2 = (ColorDrawable) ZeusTransformUtils.preCheckCast(getBackground(), ColorDrawable.class, "com.obric.aiagent.plugin");
        MaterialShapeDrawable r4 = new MaterialShapeDrawable();
        r4.setFillColor(ColorStateList.valueOf(r2.getColor()));
        r4.initializeElevationOverlay(r0);
        r4.setElevation(ViewCompat.q(this));
        ViewCompat.a(this, r4);
    L5:
        setSelectedTabIndicator(com.google.android.material.g.c.b(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicator, "styleable", "TabLayout_tabIndicator")));
        setSelectedTabIndicatorColor(r17.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorColor, "styleable", "TabLayout_tabIndicatorColor"), 0));
        r8.setSelectedIndicatorHeight(r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorHeight, "styleable", "TabLayout_tabIndicatorHeight"), -1));
        setSelectedTabIndicatorGravity(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorGravity, "styleable", "TabLayout_tabIndicatorGravity"), 0));
        setTabIndicatorAnimationMode(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorAnimationMode, "styleable", "TabLayout_tabIndicatorAnimationMode"), 0));
        setTabIndicatorFullWidth(r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorFullWidth, "styleable", "TabLayout_tabIndicatorFullWidth"), true));
        int r5 = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPadding, "styleable", "TabLayout_tabPadding"), 0);
        this.tabPaddingBottom = r5;
        this.tabPaddingEnd = r5;
        this.tabPaddingTop = r5;
        this.tabPaddingStart = r5;
        this.tabPaddingStart = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingStart, "styleable", "TabLayout_tabPaddingStart"), this.tabPaddingStart);
        this.tabPaddingTop = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingTop, "styleable", "TabLayout_tabPaddingTop"), this.tabPaddingTop);
        this.tabPaddingEnd = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingEnd, "styleable", "TabLayout_tabPaddingEnd"), this.tabPaddingEnd);
        this.tabPaddingBottom = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingBottom, "styleable", "TabLayout_tabPaddingBottom"), this.tabPaddingBottom);
        int r7 = r17.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_Tab, "style", "TextAppearance_Design_Tab"));
        this.tabTextAppearance = r7;
        TypedArray r9 = r0.obtainStyledAttributes(r7, R.styleable.TextAppearance);
        this.tabTextSize = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);     // Catch: Throwable -> L15
        this.tabTextColors = com.google.android.material.g.c.a(r0, r9, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));     // Catch: Throwable -> L15
        r9.recycle();
        if (r17.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor")) == false) goto L11;
        this.tabTextColors = com.google.android.material.g.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor"));
    L11:
        if (r17.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor")) == false) goto L13;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r17.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"), 0));
    L13:
        this.tabIconTint = com.google.android.material.g.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIconTint, "styleable", "TabLayout_tabIconTint"));
        this.tabIconTintMode = r.a(r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIconTintMode, "styleable", "TabLayout_tabIconTintMode"), -1), null);
        this.tabRippleColorStateList = com.google.android.material.g.c.a(r0, r17, ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabRippleColor, "styleable", "TabLayout_tabRippleColor"));
        this.tabIndicatorAnimationDuration = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorAnimationDuration, "styleable", "TabLayout_tabIndicatorAnimationDuration"), 300);
        this.requestedTabMinWidth = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), -1);
        this.requestedTabMaxWidth = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMaxWidth, "styleable", "TabLayout_tabMaxWidth"), -1);
        this.tabBackgroundResId = r17.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabBackground, "styleable", "TabLayout_tabBackground"), 0);
        this.contentInsetStart = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabContentStart, "styleable", "TabLayout_tabContentStart"), 0);
        this.mode = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMode, "styleable", "TabLayout_tabMode"), 1);
        this.tabGravity = r17.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabGravity, "styleable", "TabLayout_tabGravity"), 0);
        this.inlineLabel = r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabInlineLabel, "styleable", "TabLayout_tabInlineLabel"), false);
        this.unboundedRipple = r17.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabUnboundedRipple, "styleable", "TabLayout_tabUnboundedRipple"), false);
        r17.recycle();
        Resources r18 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        this.tabTextMultiLineSize = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_text_size_2line, "dimen", "design_tab_text_size_2line"));
        this.scrollableTabMinWidth = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_scrollable_min_width, "dimen", "design_tab_scrollable_min_width"));
        applyModeAndGravity();
        return;
    L15:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    public void setSelectedTabIndicatorColor(int r1) {
        this.tabSelectedIndicatorColor = r1;
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

    public void setScrollPosition(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L24;
        if (r6 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r3, r4);
    L9:
        ValueAnimator r7 = this.scrollAnimator;
        if (r7 == null) goto L15;
        if (r7.isRunning() == false) goto L15;
        this.scrollAnimator.cancel();
    L15:
        if (r3 >= 0) goto L17;
        int r8 = 0;
    L18:
        scrollTo(r8, 0);
        if (r5 == false) goto L23;
        setSelectedTabView(r0);
        return;
    L23:
        return;
    L17:
        r8 = calculateScrollXForTab(r3, r4);
        goto L18
    }

    public void addTab(d r2) {
        addTab(r2, this.tabs.isEmpty());
    }

    public void addTab(d r2, int r3) {
        addTab(r2, r3, this.tabs.isEmpty());
    }

    public void addTab(d r2, boolean r3) {
        addTab(r2, this.tabs.size(), r3);
    }

    public void addTab(d r2, int r3, boolean r4) {
        if (r2.f13619a != this) goto L9;
        configureTab(r2, r3);
        addTabView(r2);
        if (r4 == false) goto L10;
        r2.f();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void addTabFromItemView(TabItem r3) {
        d r0 = newTab();
        if (r3.text == null) goto L6;
        r0.a(r3.text);
    L6:
        if (r3.icon == null) goto L9;
        r0.a(r3.icon);
    L9:
        if (r3.customLayout == 0) goto L12;
        r0.a(r3.customLayout);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.b(r3.getContentDescription());
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
    public void setOnTabSelectedListener(c r3) {
        setOnTabSelectedListener((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public void setOnTabSelectedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        b r0 = this.selectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.selectedListener = r4;
        if (r4 == null) goto L9;
        addOnTabSelectedListener(r4);
        return;
    }

    public void addOnTabSelectedListener(c r3) {
        addOnTabSelectedListener((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public void addOnTabSelectedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.selectedListeners.contains(r4) == true) goto L6;
        this.selectedListeners.add(r4);
        return;
    }

    public void removeOnTabSelectedListener(c r3) {
        removeOnTabSelectedListener((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public void removeOnTabSelectedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.selectedListeners.remove(r4);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public d newTab() {
        d r0 = createTabFromPool();
        r0.f13619a = this;
        r0.f13620b = createTabView(r0);
        if (d.a(r0) == (-1)) goto L5;
        r0.f13620b.setId(d.a(r0));
    L5:
        return r0;
    }

    public d createTabFromPool() {
        d r2 = (d) ZeusTransformUtils.preCheckCast(tabPool.a(), d.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new d();
    }

    public boolean releaseFromTabPool(d r1) {
        return tabPool.a(r1);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public d getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (d) ZeusTransformUtils.preCheckCast(this.tabs.get(r2), d.class, "com.obric.aiagent.plugin");
    }

    public int getSelectedTabPosition() {
        d r0 = this.selectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c();
    }

    public void removeTab(d r2) {
        if (r2.f13619a != this) goto L7;
        removeTabAt(r2.c());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r8) {
        d r0 = this.selectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.c();
    L6:
        removeTabViewAt(r8);
        d r2 = (d) ZeusTransformUtils.preCheckCast(this.tabs.remove(r8), d.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.i();
        releaseFromTabPool(r2);
    L9:
        int r3 = this.tabs.size();
        int r4 = r8;
    L10:
        if (r4 >= r3) goto L12;
        ((d) ZeusTransformUtils.preCheckCast(this.tabs.get(r4), d.class, "com.obric.aiagent.plugin")).b(r4);
        r4 = r4 + 1;
        goto L10
    L12:
        if (r1 == r8) goto L14;
        return;
    L14:
        if (this.tabs.isEmpty() == false) goto L16;
        d r9 = null;
    L17:
        selectTab(r9);
        return;
    L16:
        r9 = (d) ZeusTransformUtils.preCheckCast(this.tabs.get(Math.max(0, r8 - 1)), d.class, "com.obric.aiagent.plugin");
        goto L17
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
        Iterator<d> r1 = this.tabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.aiagent.plugin");
        r1.remove();
        r2.i();
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
        ViewCompat.f(this.slidingTabIndicator);
        return;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public void setTabIndicatorAnimationMode(int r2) {
        this.tabIndicatorAnimationMode = r2;
        if (r2 != 0) goto L5;
        this.tabIndicatorInterpolator = new com.google.android.material.tabs.c();
        return;
    L5:
        if (r2 != 1) goto L7;
        this.tabIndicatorInterpolator = new com.google.android.material.tabs.a();
        return;
    L7:
        if (r2 != 2) goto L10;
        this.tabIndicatorInterpolator = new com.google.android.material.tabs.b();
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
        ViewCompat.f(this.slidingTabIndicator);
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public void setInlineLabel(boolean r4) {
        if (this.inlineLabel == r4) goto L16;
        this.inlineLabel = r4;
        int r5 = 0;
    L6:
        if (r5 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r0 = this.slidingTabIndicator.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r0, TabView.class) == false) goto L10;
        ((TabView) ZeusTransformUtils.preCheckCast(r0, TabView.class, "com.obric.aiagent.plugin")).updateOrientation();
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(int r2) {
        setInlineLabel(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getBoolean(r2));
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public void setUnboundedRipple(boolean r5) {
        if (this.unboundedRipple == r5) goto L11;
        this.unboundedRipple = r5;
        int r6 = 0;
    L6:
        if (r6 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r0, TabView.class) == false) goto L10;
        TabView.access$200((TabView) ZeusTransformUtils.preCheckCast(r0, TabView.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L10:
        r6 = r6 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(int r2) {
        setUnboundedRipple(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getBoolean(r2));
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

    public void setTabIconTintResource(int r4) {
        setTabIconTint(androidx.appcompat.a.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public void setTabRippleColor(ColorStateList r5) {
        if (this.tabRippleColorStateList == r5) goto L11;
        this.tabRippleColorStateList = r5;
        int r6 = 0;
    L6:
        if (r6 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r0, TabView.class) == false) goto L10;
        TabView.access$200((TabView) ZeusTransformUtils.preCheckCast(r0, TabView.class, "com.obric.aiagent.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L10:
        r6 = r6 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(int r4) {
        setTabRippleColor(androidx.appcompat.a.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public void setSelectedTabIndicator(Drawable r3) {
        if (this.tabSelectedIndicator == r3) goto L13;
        if (r3 != null) goto L7;
        r3 = new GradientDrawable();
    L7:
        this.tabSelectedIndicator = r3;
        int r0 = this.tabIndicatorHeight;
        if (r0 != (-1)) goto L11;
        r0 = r3.getIntrinsicHeight();
    L11:
        this.slidingTabIndicator.setSelectedIndicatorHeight(r0);
        return;
    }

    public void setSelectedTabIndicator(int r4) {
        if (r4 == 0) goto L4;
        setSelectedTabIndicator(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
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
        e r1 = this.pageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        a r2 = this.adapterChangeListener;
        if (r2 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r2);
    L10:
        b r6 = this.currentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.currentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L24;
        this.viewPager = r3;
        if (this.pageChangeListener != null) goto L17;
        this.pageChangeListener = new e(this);
    L17:
        this.pageChangeListener.a();
        r3.addOnPageChangeListener(this.pageChangeListener);
        f r7 = new f(r3);
        this.currentVpSelectedListener = r7;
        addOnTabSelectedListener(r7);
        androidx.viewpager.widget.a r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        setPagerAdapter(r8, r4);
    L21:
        if (this.adapterChangeListener != null) goto L23;
        this.adapterChangeListener = new a(this);
    L23:
        this.adapterChangeListener.a(r4);
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
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a r2) {
        setPagerAdapter(r2, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
        if (this.viewPager != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewPager.class) == false) goto L9;
        setupWithViewPager((ViewPager) ZeusTransformUtils.preCheckCast(r0, ViewPager.class, "com.obric.aiagent.plugin"), true, true);
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

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(androidx.viewpager.widget.a r3, boolean r4) {
        androidx.viewpager.widget.a r0 = this.pagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.pagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.b(r1);
    L7:
        this.pagerAdapter = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.a(this.pagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        androidx.viewpager.widget.a r0 = this.pagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.a();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab().a(this.pagerAdapter.a(r2)), false);
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
        ((d) ZeusTransformUtils.preCheckCast(this.tabs.get(r1), d.class, "com.obric.aiagent.plugin")).h();
        r1 = r1 + 1;
        goto L3
    }

    private TabView createTabView(d r5) {
        androidx.core.util.f.a<TabView> r0 = this.tabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = (TabView) ZeusTransformUtils.preCheckCast(r0.a(), TabView.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        r1 = new TabView(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L8:
        r1.setTab(r5);
        r1.setFocusable(true);
        r1.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(d.b(r5)) == false) goto L11;
        r1.setContentDescription(d.c(r5));
    L12:
        return r1;
    L11:
        r1.setContentDescription(d.b(r5));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private void configureTab(d r4, int r5) {
        r4.b(r5);
        this.tabs.add(r5, r4);
        int r6 = this.tabs.size();
    L3:
        r5 = r5 + 1;
        if (r5 >= r6) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(this.tabs.get(r5), d.class, "com.obric.aiagent.plugin")).b(r5);
        goto L3
    }

    private void addTabView(d r3) {
        TabView r0 = r3.f13620b;
        r0.setSelected(false);
        r0.setActivated(false);
        this.slidingTabIndicator.addView(r0, r3.c(), createLayoutParamsForTabs());
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

    private void addViewInternal(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, TabItem.class) == false) goto L7;
        addTabFromItemView((TabItem) ZeusTransformUtils.preCheckCast(r3, TabItem.class, "com.obric.aiagent.plugin"));
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
        i.a(this, r1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        androidx.core.view.accessibility.b.a(r3).b(androidx.core.view.accessibility.b.f.a(1, getTabCount(), false, 1));
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r1, TabView.class) == false) goto L8;
        TabView.access$500((TabView) ZeusTransformUtils.preCheckCast(r1, TabView.class, "com.obric.aiagent.plugin"), r5);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onDraw(r5);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        int r0 = Math.round(r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), getDefaultHeight()));
        int r2 = View.MeasureSpec.getMode(r9);
        boolean r5 = false;
        if (r2 == Integer.MIN_VALUE) goto L8;
        if (r2 != 0) goto L12;
        r9 = View.MeasureSpec.makeMeasureSpec((r0 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L12:
        int r1 = View.MeasureSpec.getSize(r8);
        if (View.MeasureSpec.getMode(r8) == 0) goto L19;
        int r3 = this.requestedTabMaxWidth;
        if (r3 > 0) goto L18;
        r3 = (int) (r1 - r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 56));
    L18:
        this.tabMaxWidth = r3;
    L19:
        super.onMeasure(r8, r9);
        if (getChildCount() != 1) goto L36;
        View r10 = getChildAt(0);
        int r4 = this.mode;
        if (r4 == 0) goto L31;
        if (r4 == 1) goto L28;
        if (r4 == 2) goto L31;
    L33:
        if (r5 == false) goto L37;
        r10.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(r9, getPaddingTop() + getPaddingBottom(), r10.getLayoutParams().height));
        return;
    L37:
        return;
    L28:
        if (r10.getMeasuredWidth() == getMeasuredWidth()) goto L33;
    L29:
        r5 = true;
    L31:
        if (r10.getMeasuredWidth() >= getMeasuredWidth()) goto L33;
    L36:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r9) < r0) goto L12;
        getChildAt(0).setMinimumHeight(r0);
        goto L12
    }

    private void removeTabViewAt(int r4) {
        TabView r0 = (TabView) ZeusTransformUtils.preCheckCast(this.slidingTabIndicator.getChildAt(r4), TabView.class, "com.obric.aiagent.plugin");
        this.slidingTabIndicator.removeViewAt(r4);
        if (r0 == null) goto L5;
        r0.reset();
        this.tabViewPool.a(r0);
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
        if (ViewCompat.F(this) == false) goto L17;
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
        r0.setInterpolator(com.google.android.material.animation.a.f13143b);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r4);
    }

    private void setSelectedTabView(int r7) {
        int r0 = this.slidingTabIndicator.getChildCount();
        if (r7 >= r0) goto L15;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L19;
        View r3 = this.slidingTabIndicator.getChildAt(r2);
        boolean r4 = true;
        if (r2 != r7) goto L9;
        boolean r5 = true;
    L10:
        r3.setSelected(r5);
        if (r2 == r7) goto L14;
        r4 = false;
    L14:
        r3.setActivated(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r5 = false;
        goto L10
    L19:
        return;
    }

    public void selectTab(d r2) {
        selectTab(r2, true);
    }

    public void selectTab(d r5, boolean r6) {
        d r0 = this.selectedTab;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L25;
        dispatchTabReselected(r5);
        animateToTab(r5.c());
        return;
    L25:
        return;
    L7:
        if (r5 == null) goto L9;
        int r2 = r5.c();
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
        if (r0.c() != (-1)) goto L16;
    L19:
        this.selectedTab = r5;
        if (r0 == null) goto L22;
        dispatchTabUnselected(r0);
    L22:
        if (r5 == null) goto L27;
        dispatchTabSelected(r5);
        return;
    L27:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    private void dispatchTabSelected(d r5) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((b) ZeusTransformUtils.preCheckCast(this.selectedListeners.get(r0), b.class, "com.obric.aiagent.plugin")).a(r5);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(d r5) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((b) ZeusTransformUtils.preCheckCast(this.selectedListeners.get(r0), b.class, "com.obric.aiagent.plugin")).b(r5);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabReselected(d r5) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((b) ZeusTransformUtils.preCheckCast(this.selectedListeners.get(r0), b.class, "com.obric.aiagent.plugin")).c(r5);
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
        if (ViewCompat.i(this) != 0) goto L21;
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
        ViewCompat.b(this.slidingTabIndicator, r1, 0, 0, 0);
        int r2 = this.mode;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
    L18:
        updateTabViews(true);
        return;
    L14:
        if (this.tabGravity != 2) goto L16;
        INVOKESTATIC_com_google_android_material_tabs_TabLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
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
        INVOKESTATIC_com_google_android_material_tabs_TabLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.slidingTabIndicator.setGravity(8388611);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.slidingTabIndicator.setGravity(1);
        return;
    L6:
        if (r2 == 2) goto L10;
    }

    void updateTabViews(boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (r6 == false) goto L8;
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
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.tabs.get(r2), d.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        if (r3.b() == null) goto L11;
        if (TextUtils.isEmpty(r3.d()) == true) goto L11;
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
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_tabs_TabLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
