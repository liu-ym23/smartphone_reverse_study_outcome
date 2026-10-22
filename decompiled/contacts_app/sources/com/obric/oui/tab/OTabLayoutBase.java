package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oui.R;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.ViewUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, MaterialOwner {
    private static final int ANIMATION_DURATION = 200;
    private static final int[] APPCOMPAT_CHECK_ATTRS = null;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 56;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 56;
    private static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = null;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final Pools.Pool<Tab> SYNCHRONIZED_TAB_POOL = null;
    private static final long TAB_ANIM_DURATION = 350;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final String TAG = "OTabLayoutBase";
    private Typeface DEFAULT_TAB_TYPE_FACE;
    private Typeface SELECTED_TAB_TYPE_FACE;
    private final Paint barPaint;
    private final RectF barRectF;
    private final Paint barShadowPaint;
    private final Paint barStrokePaint;
    private final RectF barStrokeRectF;
    protected boolean enableMaterial;
    private float indicatorSpacing;
    boolean isAutoFillWhenScrollable;
    private boolean isIndicatorAnimEnable;
    private boolean isIndicatorBounceEnable;
    private boolean isTabEnableMaterial;
    private AdapterChangeListener mAdapterChangeListener;
    protected WeakReference<View> mBackdropTargetWk;
    private int mBarColor;
    private int mContentInsetStart;
    private final IndicatorPoint mCurrentP;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    int mCustomTabResId;
    private final OTabLayoutEdgeFadeHelper mEdgeFadeHelper;
    private final RectF mEdgeFadeLayerBounds;
    private final RectF mEdgeFadeOverlayBounds;
    private Drawable mIndicatorBackground;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private float mIndicatorCornerX;
    private float mIndicatorCornerY;
    private float mIndicatorHeight;
    private final Paint mIndicatorPaint;
    private final Rect mIndicatorPressedRect;
    private final Rect mIndicatorRect;
    private int mIndicatorUnSelectedColor;
    private final PathInterpolator mInterpolator;
    private boolean mIsFirstDraw;
    private boolean mIsInLargeFont;
    private final IndicatorPoint mLastP;
    private Tab mLastTab;
    int mMode;
    private int mOriginalScreenOrientation;
    TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private int mPressedTabPosition;
    private final float[] mRadiusArr;
    private int mRequestedTabMaxWidth;
    private int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private Tab mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    int mTabBackgroundResId;
    int mTabGravity;
    private int mTabMargin;
    private MaterialConfig[] mTabMaterialConfigs;
    private MaterialConfig[] mTabMaterialSelectedConfigs;
    private String mTabMaterialSelectedToken;
    private String mTabMaterialToken;
    int mTabMaxWidth;
    int mTabMaxWidthInGravityCenter;
    int mTabMinWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private List<Shadow> mTabPressedShadows;
    int mTabPressedTextColor;
    private boolean mTabScrollAnimFix;
    float mTabSelectedTextSize;
    protected int mTabShadowStyle;
    private int mTabSideMargin;
    private final SlidingTabStrip mTabStrip;

    @Deprecated
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextSize;
    private int mTabTopMargin;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<Tab> mTabs;
    private final ValueAnimator mValueAnimator;
    ViewPager mViewPager;
    private OnTabClickListener onTabClickListener;
    int tabSpacing;
    private int tabTextSelectedStyle;
    private int tabTextStyle;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean mAutoRefresh;
        final /* synthetic */ OTabLayoutBase this$0;

        AdapterChangeListener(OTabLayoutBase r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            if (this.this$0.mViewPager != r1) goto L6;
            this.this$0.setPagerAdapter(r3, this.mAutoRefresh);
            return;
        }

        void setAutoRefresh(boolean r1) {
            this.mAutoRefresh = r1;
        }
    }

    public class IndicatorPoint {
        public float left;
        public float right;
        final /* synthetic */ OTabLayoutBase this$0;

        public IndicatorPoint(OTabLayoutBase r1) {
            this.this$0 = r1;
            this.left = 0.0f;
            this.right = 0.0f;
        }

        public String toString() {
            return "(left = " + this.left + ", right = " + this.right + ")";
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabClickListener {
        void onTabClick(Tab r1);
    }

    public interface OnTabSelectedListener {
        void onTabReselected(Tab r1);

        void onTabSelected(Tab r1);

        void onTabUnselected(Tab r1);
    }

    private class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ OTabLayoutBase this$0;

        PagerAdapterObserver(OTabLayoutBase r1) {
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

    public class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        final /* synthetic */ OTabLayoutBase this$0;

        public PointEvaluator(OTabLayoutBase r1) {
            this.this$0 = r1;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ IndicatorPoint evaluate(float r1, IndicatorPoint r2, IndicatorPoint r3) {
            return evaluate2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public IndicatorPoint evaluate2(float r4, IndicatorPoint r5, IndicatorPoint r6) {
            float r0 = r5.left + ((r6.left - r5.left) * r4);
            float r1 = r5.right + (r4 * (r6.right - r5.right));
            IndicatorPoint r7 = new IndicatorPoint(this.this$0);
            r7.left = r0;
            r7.right = r1;
            return r7;
        }
    }

    private class SlidingTabStrip extends OUILinearLayout {
        private float left;
        private ValueAnimator mIndicatorAnimator;
        private int mIndicatorLeft;
        private int mIndicatorRight;
        public boolean mIsDragged;
        private int mLayoutDirection;
        private int mMinTabWidth;
        private boolean mSelectedIndicatorFullWidth;
        private int mSelectedIndicatorHeight;
        private int mSelectedIndicatorPadding;
        private final Paint mSelectedIndicatorPaint;
        private int mSelectedIndicatorWidth;
        int mSelectedPosition;
        float mSelectionOffset;
        private float right;
        private boolean showBottomLine;
        private Paint showBottomLinePaint;
        private boolean showSelectedIndicator;
        private boolean showTopLine;
        private Paint showTopLinePaint;
        final /* synthetic */ OTabLayoutBase this$0;
        private final float topLineWidth;

        static /* synthetic */ float access$1102(SlidingTabStrip r0, float r1) {
            r0.left = r1;
            return r1;
        }

        static /* synthetic */ float access$1202(SlidingTabStrip r0, float r1) {
            r0.right = r1;
            return r1;
        }

        SlidingTabStrip(OTabLayoutBase r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.mSelectedPosition = -1;
            this.mLayoutDirection = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            this.mSelectedIndicatorWidth = r1.dpToPx(27);
            this.mMinTabWidth = Integer.MAX_VALUE;
            setChangeAlphaWhenPress(false);
            setClipChildren(false);
            setClipToPadding(false);
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
            this.topLineWidth = r1.dpToPxFloat(0.6f);
        }

        void setShowBottomLine(boolean r3) {
            this.showBottomLine = r3;
            if (r3 == false) goto L6;
            Paint r4 = new Paint();
            this.showBottomLinePaint = r4;
            r4.setColor(ContextCompat.getColor(getContext(), R.color.oui_line_2));
            this.showBottomLinePaint.setStyle(Paint.Style.FILL);
            return;
        }

        void setShowTopLine(boolean r3) {
            this.showTopLine = r3;
            if (r3 == false) goto L6;
            Paint r4 = new Paint();
            this.showTopLinePaint = r4;
            r4.setColor(ContextCompat.getColor(getContext(), R.color.oui_line_2));
            this.showTopLinePaint.setStyle(Paint.Style.FILL);
            this.showTopLinePaint.setStrokeWidth(this.topLineWidth);
            return;
        }

        void setShowSelectedIndicator(boolean r1) {
            this.showSelectedIndicator = r1;
        }

        void setSelectedIndicatorColor(int r2) {
            if (this.mSelectedIndicatorPaint.getColor() == r2) goto L6;
            this.mSelectedIndicatorPaint.setColor(r2);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void setSelectedIndicatorHeight(int r2) {
            if (this.mSelectedIndicatorHeight == r2) goto L6;
            this.mSelectedIndicatorHeight = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        void setSelectedIndicatorFullWidth(boolean r2) {
            if (this.mSelectedIndicatorFullWidth == r2) goto L6;
            this.mSelectedIndicatorFullWidth = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
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
            ValueAnimator r0 = this.mIndicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            this.mSelectedPosition = r2;
            this.mSelectionOffset = r3;
            updateIndicatorPosition();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.mIndicatorAnimator.cancel();
            goto L7
        }

        float getIndicatorPosition() {
            return this.mSelectedPosition + this.mSelectionOffset;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r4) {
            super.setEnabled(r4);
            int r0 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            this.this$0.getTabView(r1).setEnabled(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r1) {
            super.onRtlPropertiesChanged(r1);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        protected void onMeasure(int r11, int r12) {
            super.onMeasure(r11, r12);
            int r0 = getChildCount();
            boolean r4 = true;
            int r5 = 0;
            if (View.MeasureSpec.getMode(r11) != 1073741824) goto L5;
            Drawable r1 = getDividerDrawable();
            if (r1 == null) goto L28;
            int r2 = r1.getIntrinsicWidth();
        L29:
            int r3 = 0;
            int r6 = 0;
        L30:
            if (r3 >= r0) goto L35;
            View r7 = getChildAt(r3);
            if (r7.getVisibility() != 0) goto L34;
            r6 = Math.max(r6, r7.getMeasuredWidth());
            this.mMinTabWidth = Math.min(this.mMinTabWidth, r7.getMeasuredWidth());
        L34:
            r3 = r3 + 1;
            goto L30
        L35:
            int r8 = (getPaddingLeft() + getPaddingRight()) + (r2 * (r0 - 1));
            if (this.this$0.mMode != 1) goto L56;
            if (this.this$0.mTabGravity != 1) goto L56;
            if (r6 > 0) goto L42;
            return;
        L42:
            if ((r6 * r0) > (getMeasuredWidth() - r8)) goto L52;
            boolean r9 = false;
        L44:
            if (r5 >= r0) goto L51;
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) getChildAt(r5).getLayoutParams();
            if (r10.width == r6) goto L48;
        L49:
            r10.width = r6;
            r10.weight = 0.0f;
            r9 = true;
        L50:
            r5 = r5 + 1;
            goto L44
        L48:
            if (r10.weight == 0.0f) goto L50;
        L51:
            r4 = r9;
        L53:
            if (r4 == false) goto L119;
            super.onMeasure(r11, r12);
            return;
        L119:
            return;
        L52:
            this.this$0.mTabGravity = 0;
            this.this$0.updateTabViews(false);
        L56:
            if (this.this$0.mMode == 0) goto L58;
            return;
        L58:
            if (this.this$0.isAutoFillWhenScrollable == true) goto L60;
            return;
        L60:
            if (OTabLayoutBase.access$700(this.this$0) == getResources().getConfiguration().orientation) goto L62;
            return;
        L62:
            if (r6 > 0) goto L64;
            return;
        L64:
            int r13 = 0;
            int r14 = 0;
        L66:
            if (r13 >= r0) goto L71;
            View r15 = getChildAt(r13);
            if (r15.getVisibility() == 8) goto L70;
            r14 = r14 + r15.getMeasuredWidth();
        L70:
            r13 = r13 + 1;
            goto L66
        L71:
            if (r14 > 0) goto L73;
            return;
        L73:
            int r16 = getMeasuredWidth() - r8;
            if (r14 < r16) goto L76;
        L92:
            if (r5 == 0) goto L123;
            super.onMeasure(r11, r12);
            return;
        L123:
            return;
        L76:
            if ((r6 * r0) >= r16) goto L85;
            int r17 = 0;
            int r18 = 0;
        L78:
            if (r17 >= r0) goto L91;
            LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) getChildAt(r17).getLayoutParams();
            if (r19.width == 0) goto L82;
        L83:
            r19.width = 0;
            r19.weight = 1.0f;
            r18 = 1;
        L84:
            r17 = r17 + 1;
            goto L78
        L82:
            if (r19.weight == 1.0f) goto L84;
        L91:
            r5 = r18;
            goto L92
        L85:
            int r20 = (r16 - r14) / (r0 * 2);
            r18 = 0;
        L86:
            if (r5 >= r0) goto L91;
            if (getChildAt(r5).getVisibility() == 8) goto L90;
            LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) getChildAt(r5).getLayoutParams();
            r21.leftMargin = r20;
            r21.rightMargin = r20;
            r18 = 1;
        L90:
            r5 = r5 + 1;
            goto L86
        L28:
            r2 = 0;
            goto L29
        L5:
            if (this.this$0.mMode == 1) goto L7;
            return;
        L7:
            if (this.this$0.mTabGravity != 1) goto L117;
            int r22 = 0;
            int r23 = 0;
        L9:
            if (r22 >= r0) goto L14;
            View r24 = getChildAt(r22);
            if (r24.getVisibility() != 0) goto L13;
            r23 = Math.max(r23, r24.getMeasuredWidth());
            this.mMinTabWidth = Math.min(this.mMinTabWidth, r24.getMeasuredWidth());
        L13:
            r22 = r22 + 1;
            goto L9
        L14:
            int r25 = Math.min(this.this$0.mTabMaxWidthInGravityCenter, r23);
            boolean r26 = false;
        L15:
            if (r5 >= r0) goto L22;
            LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) getChildAt(r5).getLayoutParams();
            if (r27.width == r25) goto L19;
        L20:
            r27.width = r25;
            r27.weight = 0.0f;
            r26 = true;
        L21:
            r5 = r5 + 1;
            goto L15
        L19:
            if (r27.weight == 0.0f) goto L21;
        L22:
            if (r26 == false) goto L118;
            super.onMeasure(r11, r12);
            return;
        L118:
            return;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.mIndicatorAnimator;
            if (r6 != null) goto L5;
        L7:
            updateIndicatorPosition();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            this.mIndicatorAnimator.cancel();
            animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0f - this.mIndicatorAnimator.getAnimatedFraction()) * this.mIndicatorAnimator.getDuration()));
        }

        private void updateIndicatorPosition() {
            View r0 = getChildAt(this.mSelectedPosition);
            if (r0 != null) goto L5;
        L11:
            int r1 = -1;
            int r2 = -1;
        L12:
            setIndicatorPosition(r1, r2);
            return;
        L5:
            if (r0.getWidth() <= 0) goto L11;
            r1 = r0.getLeft();
            r2 = r0.getRight();
            if (this.mSelectionOffset <= 0.0f) goto L12;
            if (this.mSelectedPosition >= (getChildCount() - 1)) goto L12;
            View r3 = getChildAt(this.mSelectedPosition + 1);
            float r4 = this.mSelectionOffset * r3.getLeft();
            float r5 = this.mSelectionOffset;
            r1 = (int) (r4 + ((1.0f - r5) * r1));
            r2 = (int) ((r5 * r3.getRight()) + ((1.0f - this.mSelectionOffset) * r2));
            goto L12
        }

        void setIndicatorPosition(int r2, int r3) {
            if (r2 == this.mIndicatorLeft) goto L5;
        L6:
            this.mIndicatorLeft = r2;
            this.mIndicatorRight = r3;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r3 != this.mIndicatorRight) goto L6;
        }

        void animateIndicatorToPosition(final int r10, int r11) {
            ValueAnimator r0 = this.mIndicatorAnimator;
            if (r0 == null) goto L8;
            if (r0.isRunning() == false) goto L8;
            this.mIndicatorAnimator.cancel();
        L8:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
            boolean r1 = true;
        L11:
            View r2 = getChildAt(r10);
            if (r2 != null) goto L15;
            updateIndicatorPosition();
            return;
        L15:
            final int r6 = r2.getLeft();
            final int r8 = r2.getRight();
            if (Math.abs(r10 - this.mSelectedPosition) > 1) goto L18;
            final int r5 = this.mIndicatorLeft;
            final int r7 = this.mIndicatorRight;
        L26:
            if (r5 != r6) goto L28;
            if (r7 != r8) goto L28;
            return;
        L28:
            ValueAnimator r3 = new ValueAnimator();
            this.mIndicatorAnimator = r3;
            r3.setInterpolator(OTabLayoutBase.access$800());
            r3.setDuration(r11);
            r3.setFloatValues(new float[]{0.0f, 1.0f});
            r3.addUpdateListener(new AnonymousClass1(this, r5, r6, r7, r8));
            r3.addListener(new AnonymousClass2(this, r10));
            r3.start();
            return;
        L18:
            int r4 = this.this$0.dpToPx(24);
            if (r10 >= this.mSelectedPosition) goto L22;
            if (r1 == true) goto L24;
        L23:
            r5 = r4 + r8;
        L25:
            r7 = r5;
        L24:
            r5 = r6 - r4;
            goto L25
        L22:
            if (r1 == false) goto L24;
        L10:
            r1 = false;
            goto L11
        }

        int lerp(int r1, int r2, float r3) {
            return r1 + Math.round(r3 * (r2 - r1));
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void draw(Canvas r18) {
            super.draw(r18);
            if (this.showBottomLine == false) goto L6;
            r18.drawLine(getLeft(), getBottom() - this.this$0.dpToPxFloat(0.6f), getRight() * 2, getBottom(), this.showBottomLinePaint);
        L6:
            if (this.showTopLine == false) goto L8;
            r18.drawLine(getLeft(), this.topLineWidth + getTop(), getRight() * 2, this.topLineWidth + getTop(), this.showTopLinePaint);
        L8:
            int r1 = this.mIndicatorLeft;
            if (r1 >= 0) goto L11;
            return;
        L11:
            if (this.mIndicatorRight > r1) goto L13;
            return;
        L13:
            if (this.showSelectedIndicator == false) goto L35;
            View r2 = getChildAt(this.this$0.getSelectedTabPosition());
            if (r2 == null) goto L26;
            View r13 = r2.findViewById(R.id.layout_tab_indicator);
            if (r13 == null) goto L26;
            if (this.this$0.mViewPager != null) goto L21;
        L22:
            int r3 = this.mIndicatorLeft;
            float r4 = r3 + (((this.mIndicatorRight - r3) - r13.getWidth()) / 2);
            this.left = r4;
            this.right = r4 + r13.getWidth();
        L23:
            Path r5 = new Path();
            r5.addRoundRect(new RectF(((this.left + this.right) / 2.0f) - this.this$0.dpToPx(3), (getHeight() - getPaddingBottom()) - this.this$0.dpToPx(4), ((this.left + this.right) / 2.0f) + this.this$0.dpToPx(3), getHeight() - getPaddingBottom()), new float[]{this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(1), this.this$0.dpToPx(1), this.this$0.dpToPx(1), this.this$0.dpToPx(1)}, Path.Direction.CCW);
            r18.drawPath(r5, this.mSelectedIndicatorPaint);
            return;
        L21:
            if (this.mIsDragged == true) goto L23;
        L26:
            if (this.mSelectedIndicatorFullWidth == false) goto L28;
        L30:
            float r14 = this.mIndicatorLeft;
            float r6 = this.mIndicatorRight;
        L31:
            Path r7 = new Path();
            float r15 = (r14 + r6) / 2.0f;
            r7.addRoundRect(new RectF(r15 - this.this$0.dpToPx(3), (getHeight() - getPaddingBottom()) - this.this$0.dpToPx(4), r15 + this.this$0.dpToPx(3), getHeight() - getPaddingBottom()), new float[]{this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(3), this.this$0.dpToPx(1), this.this$0.dpToPx(1), this.this$0.dpToPx(1), this.this$0.dpToPx(1)}, Path.Direction.CCW);
            r18.drawPath(r7, this.mSelectedIndicatorPaint);
            return;
        L28:
            if ((r2 instanceof TabView) == false) goto L30;
            float r8 = (this.mIndicatorLeft + this.mIndicatorRight) * 0.5f;
            TabView r9 = (TabView) r2;
            r14 = r8 - (r9.getContentWidth() * 0.5f);
            r6 = r8 + (r9.getContentWidth() * 0.5f);
            goto L31
        }

        public void setSelectedTabHorizontalPadding(int r1) {
            this.mSelectedIndicatorPadding = r1;
        }
    }

    public static final class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        OTabLayoutBase mParent;
        private int mPosition;
        private Object mTag;
        private CharSequence mText;
        TabView mView;

        Tab() {
            this.mPosition = -1;
        }

        public Object getTag() {
            return this.mTag;
        }

        public Tab setTag(Object r1) {
            this.mTag = r1;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View r1) {
            this.mCustomView = r1;
            updateView();
            return this;
        }

        public Tab setCustomView(int r4) {
            return setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(r4, this.mView, false));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        void setPosition(int r1) {
            this.mPosition = r1;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setIcon(Drawable r1) {
            this.mIcon = r1;
            updateView();
            return this;
        }

        public Tab setIcon(int r2) {
            OTabLayoutBase r0 = this.mParent;
            if (r0 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r0.getContext(), r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setText(CharSequence r1) {
            this.mText = r1;
            updateView();
            return this;
        }

        public Tab setText(int r2) {
            OTabLayoutBase r0 = this.mParent;
            if (r0 == null) goto L7;
            return setText(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void select() {
            OTabLayoutBase r0 = this.mParent;
            if (r0 == null) goto L7;
            r0.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean isSelected() {
            OTabLayoutBase r0 = this.mParent;
            if (r0 == null) goto L10;
            if (r0.getSelectedTabPosition() != this.mPosition) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(int r2) {
            OTabLayoutBase r0 = this.mParent;
            if (r0 == null) goto L7;
            return setContentDescription(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(CharSequence r1) {
            this.mContentDesc = r1;
            updateView();
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public TabView getView() {
            return this.mView;
        }

        void updateView() {
            TabView r0 = this.mView;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void updateMaterial(boolean r1) {
            this.mView.applyContentMaterial(r1);
        }

        void setBackdropTarget(View r1) {
            this.mView.setBackdropTarget(r1);
        }

        void updateBackdropTargetType(boolean r1) {
            this.mView.updateBackdropTargetType(r1);
        }

        void updateBackdropSrcType(int r1) {
            this.mView.updateBackdropSrcType(r1);
        }

        void reset() {
            this.mParent = null;
            this.mView = null;
            this.mTag = null;
            this.mIcon = null;
            this.mText = null;
            this.mContentDesc = null;
            this.mPosition = -1;
            this.mCustomView = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int mEndColor;
        private DecelerateInterpolator mEndInterpolator;
        private ArgbEvaluator mEvaluator;
        private int mPreviousScrollState;
        private int mScrollState;
        private int mStartColor;
        private AccelerateInterpolator mStartInterpolator;
        private final WeakReference<OTabLayoutBase> mTabLayoutRef;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r4) {
            this.mEvaluator = new ArgbEvaluator();
            this.mStartInterpolator = new AccelerateInterpolator();
            this.mEndInterpolator = new DecelerateInterpolator(1.6f);
            this.mTabLayoutRef = new WeakReference(r4);
            this.mStartColor = r4.getTabTextColors().getColorForState(OTabLayoutBase.access$900(), 0);
            this.mEndColor = r4.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r11, float r12, int r13) {
            OTabLayoutBase r14 = this.mTabLayoutRef.get();
            if (r14 == null) goto L34;
            int r0 = this.mScrollState;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L17:
            r14.setScrollPosition(r11, r12, r4, r1);
            if (this.mScrollState == 2) goto L20;
        L22:
            OTabLayoutBase.access$1000(r14).mIsDragged = true;
            View r15 = OTabLayoutBase.access$1000(r14).getChildAt(OTabLayoutBase.access$1000(r14).mSelectedPosition);
            View r2 = OTabLayoutBase.access$1000(r14).getChildAt(OTabLayoutBase.access$1000(r14).mSelectedPosition + 1);
            if (r15 == null) goto L30;
            if (r2 == null) goto L30;
            View r3 = r15.findViewById(R.id.layout_tab_indicator);
            View r5 = r2.findViewById(R.id.layout_tab_indicator);
            if (r3 == null) goto L32;
            if (r5 == null) goto L32;
            float r16 = r15.getLeft() + ((r15.getWidth() - r3.getWidth()) / 2);
            float r6 = r3.getWidth() + r16;
            float r7 = r2.getLeft() + ((r2.getWidth() - r5.getWidth()) / 2);
            float r8 = r5.getWidth() + r7;
            ImageView r9 = (ImageView) r3.findViewById(R.id.tab_item_img);
            TextView r10 = (TextView) r3.findViewById(R.id.tab_item_text);
            ImageView r17 = (ImageView) r5.findViewById(R.id.tab_item_img);
            TextView r18 = (TextView) r5.findViewById(R.id.tab_item_text);
            changeTabColor(r9, r10, ((Integer) this.mEvaluator.evaluate(r12, Integer.valueOf(this.mStartColor), Integer.valueOf(this.mEndColor))).intValue());
            changeTabColor(r17, r18, ((Integer) this.mEvaluator.evaluate(r12, Integer.valueOf(this.mEndColor), Integer.valueOf(this.mStartColor))).intValue());
            SlidingTabStrip.access$1102(OTabLayoutBase.access$1000(r14), r16 + ((r7 - r16) * this.mStartInterpolator.getInterpolation(r12)));
            SlidingTabStrip.access$1202(OTabLayoutBase.access$1000(r14), r6 + ((r8 - r6) * this.mStartInterpolator.getInterpolation(r12)));
        L32:
            ViewCompat.postInvalidateOnAnimation(OTabLayoutBase.access$1000(r14));
            return;
        L30:
            if (OTabLayoutBase.access$1300(r14) == false) goto L32;
            OTabLayoutBase.access$1000(r14).mIsDragged = false;
            goto L32
        L20:
            if (this.mPreviousScrollState != 0) goto L22;
            OTabLayoutBase.access$1000(r14).mIsDragged = false;
            goto L32
        L13:
            if (this.mPreviousScrollState != 0) goto L16;
            r1 = false;
            goto L17
        L7:
            if (this.mPreviousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        private void changeTabColor(ImageView r1, TextView r2, int r3) {
            if (r1 == null) goto L7;
            if (r2 == null) goto L8;
            r2.setTextColor(r3);
            r1.setImageAlpha(Color.alpha(r3));
            return;
        L8:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = this.mTabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.mScrollState;
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
            if (this.mPreviousScrollState != 0) goto L15;
        }

        void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {
        final boolean isRtl;
        private int lastPosition;
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<OTabLayoutBase> mTabLayoutRef;

        public TabLayoutOnPageChangeListenerIndependent(OTabLayoutBase r3) {
            boolean r0 = false;
            this.lastPosition = 0;
            this.mTabLayoutRef = new WeakReference(r3);
            if (ViewCompat.getLayoutDirection(r3) != 1) goto L5;
            r0 = true;
        L5:
            this.isRtl = r0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int r11, float r12, int r13) {
            final OTabLayoutBase r14 = this.mTabLayoutRef.get();
            if (this.lastPosition != r11) goto L5;
            return;
        L5:
            if (r14 == null) goto L21;
            int r15 = this.mScrollState;
            if (r15 == 2) goto L9;
        L12:
            boolean r7 = true;
        L13:
            if (r15 == 2) goto L15;
        L18:
            boolean r16 = true;
        L19:
            ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            final int r2 = this.lastPosition;
            final boolean r5 = r7;
            final boolean r6 = r16;
            r8.addUpdateListener(new OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent$$ExternalSyntheticLambda0(this, r2, r11, r14, r5, r6));
            this.lastPosition = r11;
            final boolean r4 = r7;
            final boolean r9 = r16;
            r8.addListener(new AnonymousClass1(this, r14, r11, r4, r9));
            r8.start();
            return;
        L15:
            if (this.mPreviousScrollState != 0) goto L18;
            r16 = false;
            goto L19
        L9:
            if (this.mPreviousScrollState == 1) goto L12;
            r7 = false;
            goto L13
        }

        /* JADX INFO: renamed from: lambda$onPageScrolled$0$com-obric-oui-tab-OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent, reason: not valid java name */
        /* synthetic */ void m716xe919e369(int r1, int r2, OTabLayoutBase r3, boolean r4, boolean r5, ValueAnimator r6) {
            float r7 = ((Float) r6.getAnimatedValue()).floatValue();
            if (r1 < r2) goto L5;
        L7:
            r7 = 1.0f - r7;
        L8:
            r3.setScrollPosition(r2, r7, r4, r5);
            return;
        L5:
            if (this.isRtl == true) goto L7;
            r2 = r2 - 1;
            goto L8
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = this.mTabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.mScrollState;
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
            if (this.mPreviousScrollState != 0) goto L15;
        }

        void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    public class TabView extends OUILinearLayout implements MaterialOwner {
        private boolean isBackdropView;
        private MaterialConfig[] mAllMaterialConfigs;
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines;
        private boolean mEnableMaterial;
        private ImageView mIconView;
        private MaterialConfig[] mMaterialConfigs;
        private AnimationManager mPressAnim;
        private AnimationManager mReleaseAnim;
        private MaterialConfig[] mSelectedMaterialConfigs;
        private Tab mTab;
        private TextView mTextView;
        final /* synthetic */ OTabLayoutBase this$0;

        public TabView(OTabLayoutBase r2, Context r3, boolean r4, MaterialConfig[] r5, MaterialConfig[] r6) {
            this.this$0 = r2;
            super(r3);
            this.mDefaultMaxLines = 1;
            this.isBackdropView = true;
            this.mEnableMaterial = r4;
            updateMaterialConfigs(r5, r6);
            setEnableShadowWidthRadius(true);
            if (OTabLayoutBase.access$100(r2) == null) goto L5;
            boolean r7 = true;
        L6:
            setChangeAlphaWhenPress(r7);
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            if (OTabLayoutBase.access$100(r2) == null) goto L10;
            setOverridePressColor(ContextCompat.getColor(r3, R.color.oui_basic_fill_element_2));
            refreshColors(OTabLayoutBase.TAG);
        L10:
            if (r2.mTabBackgroundResId == 0) goto L12;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r3, r2.mTabBackgroundResId));
        L12:
            ViewCompat.setPaddingRelative(this, r2.mTabPaddingStart, r2.mTabPaddingTop, r2.mTabPaddingEnd, r2.mTabPaddingBottom);
            setMinimumWidth(r2.mTabMinWidth);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
            if (this.mEnableMaterial == false) goto L16;
            updateMaterialBySelectedState(isSelected());
            return;
        L16:
            return;
        L5:
            r7 = false;
            goto L6
        }

        public void updateEnableMaterial(boolean r1) {
            this.mEnableMaterial = r1;
            if (r1 == false) goto L5;
            updateMaterialBySelectedState(isSelected());
            return;
        L5:
            restoreDefaultBackground();
            clearTabShadow();
            applyContentMaterial(false);
        }

        public void updateMaterialConfigs(MaterialConfig[] r1, MaterialConfig[] r2) {
            this.mAllMaterialConfigs = r1;
            this.mSelectedMaterialConfigs = r2;
            this.mMaterialConfigs = r1;
        }

        public void updateMaterial(MaterialConfig[] r2) {
            if (this.mEnableMaterial == true) goto L6;
            return;
        L6:
            if (this.mMaterialConfigs == null) goto L9;
            this.mMaterialConfigs = r2;
            return;
        }

        private void updateMaterialBySelectedState(boolean r3) {
            if (this.mEnableMaterial == true) goto L6;
            restoreDefaultBackground();
            clearTabShadow();
            applyContentMaterial(false);
            return;
        L6:
            if (r3 == false) goto L10;
            MaterialConfig[] r4 = this.mSelectedMaterialConfigs;
            if (r4 == null) goto L10;
        L11:
            this.mMaterialConfigs = r4;
            if (r4 == null) goto L14;
            applyMaterial();
            applyContentMaterial(true);
            return;
        L14:
            restoreDefaultBackground();
            clearTabShadow();
            applyContentMaterial(false);
            return;
        L10:
            r4 = this.mAllMaterialConfigs;
            goto L11
        }

        private void applyMaterial() {
            if (this.mMaterialConfigs != null) goto L5;
            return;
        L5:
            int r0 = (int) OUnitExtensionKt.dp2px(99.0f, getContext());
            setShadowCornerRadius(r0);
            setRadius(r0);
            if (OTabLayoutBase.access$100(this.this$0) == null) goto L8;
            ((OUIAlphaHelper) getAlphaHelper()).setRadius(r0);
        L8:
            boolean r1 = this.isBackdropView;
            if (r1 == false) goto L11;
            int r2 = 2;
        L13:
            if (r1 == false) goto L15;
            OMaterialExtBaseKt.materials(this, this.mMaterialConfigs, false, r2, null);
        L17:
            if (currentMaterialHasShadow() == true) goto L19;
            clearTabShadow();
        L19:
            GradientDrawable r3 = new GradientDrawable();
            r3.setShape(0);
            r3.setCornerRadius(OUnitExtensionKt.dp2px(99.0f, getContext()));
            r3.setColor(0);
            setBackground(r3);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            return;
        L15:
            OMaterialExtBaseKt.materialsFromWindow(this, this.mMaterialConfigs, false, null);
            goto L17
        L11:
            r2 = 3;
            goto L13
        }

        private boolean currentMaterialHasShadow() {
            MaterialConfig[] r0 = this.mMaterialConfigs;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.length == 0) goto L19;
            int r1 = OMaterialHelper.getMaterialLevel(getContext());
            int r2 = Math.max(0, Math.min(this.mMaterialConfigs.length - 1, r1 - 1));
            MaterialConfig r4 = this.mMaterialConfigs[r2];
            if (r4 != null) goto L10;
            return false;
        L10:
            if (r4.getShadow() != null) goto L12;
            return false;
        L12:
            if (r4.getShadow().length > 0) goto L14;
            return false;
        L14:
            return true;
        L19:
            return false;
        }

        private void clearTabShadow() {
            setShadow(Shadow.NONE.copy(), Shadow.NONE.copy());
        }

        private void restoreDefaultBackground() {
            if (this.this$0.mTabBackgroundResId == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(getContext(), this.this$0.mTabBackgroundResId));
        L6:
            setOutlineProvider(null);
            return;
        L5:
            setBackground(null);
            goto L6
        }

        @Override // com.obric.oui.material.MaterialOwner
        public void applyContentMaterial(boolean r4) {
            boolean r1 = true;
            if (this.isBackdropView == false) goto L11;
            if (this.mEnableMaterial == false) goto L8;
            if (r4 == false) goto L8;
        L9:
            OMaterialHelper.applyMaterial(this, r1);
            return;
        L8:
            r1 = false;
            goto L9
        L11:
            if (this.mEnableMaterial == false) goto L14;
            if (r4 == false) goto L14;
        L15:
            OMaterialHelper.applyMaterialFromWindow(this, r1);
            return;
        L14:
            r1 = false;
            goto L15
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void setBackdropTarget(View r2) {
            if (this.mEnableMaterial == true) goto L5;
            return;
        L5:
            OMaterialHelper.setEffectSrcTarget(this, r2);
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void updateBackdropTargetType(boolean r2) {
            if (this.mEnableMaterial == true) goto L6;
            return;
        L6:
            if (this.isBackdropView == r2) goto L12;
            this.isBackdropView = r2;
            if (r2 == false) goto L10;
            OMaterialHelper.setEffectSrc(this, 2);
            return;
        L10:
            OMaterialHelper.setEffectSrc(this, 3);
            return;
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void updateBackdropSrcType(int r2) {
            if (this.mEnableMaterial == true) goto L5;
            return;
        L5:
            OMaterialHelper.setEffectSrc(this, r2);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r3) {
            boolean r0 = super.dispatchTouchEvent(r3);
            int r4 = r3.getActionMasked();
            if (r4 == 0) goto L9;
            if (r4 != 1) goto L6;
        L8:
            doPressAnim(false, getCurrentShadows());
        L10:
            return r0;
        L6:
            if (r4 == 3) goto L8;
        L9:
            doPressAnim(true, getCurrentShadows());
            goto L10
        }

        private void doPressAnim(boolean r3, List<Shadow> r4) {
            if (isEnabled() == true) goto L5;
            return;
        L5:
            if (OTabLayoutBase.access$100(this.this$0) == null) goto L30;
            AnimationManager r0 = this.mPressAnim;
            if (r0 == null) goto L10;
            r0.cancelAnimation(false);
        L10:
            AnimationManager r1 = this.mReleaseAnim;
            if (r1 == null) goto L13;
            r1.cancelAnimation(false);
        L13:
            if (r3 == false) goto L19;
            List<Shadow> r5 = getCurrentShadows();
            if (OTabLayoutBase.access$100(this.this$0) == null) goto L17;
            List<Shadow> r6 = OTabLayoutBase.access$100(this.this$0);
        L18:
            this.mPressAnim = ShadowAnimator.startWithScaleAnimation(this, getScaleX(), 0.98f, r5, r6);
            return;
        L17:
            r6 = r5;
            goto L18
        L19:
            if (r4 != null) goto L23;
            r4 = getCurrentShadows();
        L23:
            if (OTabLayoutBase.access$100(this.this$0) == null) goto L25;
            List<Shadow> r7 = OTabLayoutBase.access$100(this.this$0);
        L26:
            this.mReleaseAnim = ShadowAnimator.startWithScaleAnimation(this, getScaleX(), 1.0f, r7, r4);
            return;
        L25:
            r7 = r4;
            goto L26
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.mTab == null) goto L12;
            if (r0 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.access$200(this.this$0) == null) goto L9;
            OTabLayoutBase.access$200(this.this$0).onTabClick(this.mTab);
        L10:
            VibratorSmt.vibrateEffectWithHapticPlayer(getContext(), 1);
            return true;
        L9:
            this.mTab.select();
            goto L10
        L12:
            return r0;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setSelected(boolean r4) {
            if (isSelected() != r4) goto L6;
        L6:
            super.setSelected(r4);
            updateMaterialBySelectedState(r4);
            if (this.mTextView == null) goto L19;
            if (r4 == true) goto L10;
        L12:
            this.mTextView.setTextSize(0, this.this$0.mTabTextSize);
        L13:
            TextView r0 = this.mTextView;
            OTabLayoutBase r3 = this.this$0;
            if (r4 == false) goto L16;
            Typeface r5 = OTabLayoutBase.access$400(r3, OTabLayoutBase.access$300(r3), 500);
        L17:
            r0.setTypeface(r5);
            return;
        L16:
            r5 = OTabLayoutBase.access$300(r3);
            goto L17
        L10:
            if (this.this$0.mTabSelectedTextSize <= 0.0f) goto L12;
            this.mTextView.setTextSize(0, this.this$0.mTabSelectedTextSize);
            goto L13
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r0 = View.MeasureSpec.getSize(r11);
            int r1 = View.MeasureSpec.getMode(r11);
            int r2 = this.this$0.getTabMaxWidth();
            LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.this$0.mTabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.mTextView == null) goto L37;
            getResources();
            float r4 = this.this$0.mTabTextSize;
            int r5 = this.mDefaultMaxLines;
            int r6 = OTabLayoutBase.access$500(this.this$0);
            int r7 = OTabLayoutBase.access$600(this.this$0);
            ImageView r8 = this.mIconView;
            boolean r9 = true;
            if (r8 == null) goto L15;
            if (r8.getVisibility() != 0) goto L15;
            r5 = 1;
        L15:
            if (this.mTextView != null) goto L17;
        L21:
            float r10 = this.mTextView.getTextSize();
            int r13 = this.mTextView.getLineCount();
            int r14 = TextViewCompat.getMaxLines(this.mTextView);
            if (r4 != r10) goto L26;
            if (r14 < 0) goto L38;
            if (r5 != r14) goto L26;
            return;
        L38:
            return;
        L26:
            if (this.this$0.mMode != 1) goto L34;
            if (r4 <= r10) goto L34;
            if (r13 != 1) goto L34;
            Layout r15 = this.mTextView.getLayout();
            if (r15 != null) goto L32;
        L33:
            r9 = false;
            goto L34
        L32:
            if (approximateLineWidth(r15, 0, r4) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L33;
        L34:
            if (r9 == false) goto L40;
            this.mTextView.setTextSize(0, r4);
            this.mTextView.setMaxLines(r5);
            r3.topMargin = r6;
            r3.leftMargin = r7;
            r3.rightMargin = r7;
            this.mTextView.setLayoutParams(r3);
            super.onMeasure(r11, r12);
            return;
        L40:
            return;
        L17:
            if (isSelected() == false) goto L21;
            if (this.this$0.mTabSelectedTextSize <= 0.0f) goto L21;
            r4 = this.this$0.mTabSelectedTextSize;
            r6 = 0;
            r7 = 0;
            goto L21
        }

        void setTab(Tab r2) {
            if (r2 == this.mTab) goto L6;
            this.mTab = r2;
            update();
            return;
        }

        void setTab(Tab r2, boolean r3) {
            if (r2 == this.mTab) goto L8;
            this.mTab = r2;
            if (r3 == false) goto L9;
            update();
            return;
        L9:
            return;
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        final void update() {
            Tab r0 = this.mTab;
            if (r0 == null) goto L5;
            View r2 = r0.getCustomView();
        L6:
            boolean r3 = true;
            if (r2 == null) goto L29;
            ViewParent r4 = r2.getParent();
            if (r4 == this) goto L13;
            if (r4 == null) goto L12;
            ((ViewGroup) r4).removeView(r2);
        L12:
            addView(r2);
        L13:
            this.mCustomView = r2;
            TextView r5 = this.mTextView;
            if (r5 == null) goto L16;
            r5.setVisibility(8);
        L16:
            ImageView r6 = this.mIconView;
            if (r6 == null) goto L19;
            r6.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L19:
            TextView r1 = (TextView) r2.findViewById(R.id.title);
            this.mCustomTextView = r1;
            if (r1 == null) goto L26;
            r1.setDuplicateParentStateEnabled(true);
            this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
            if (OTabLayoutBase.access$300(this.this$0) != null) goto L26;
            if (this.mTextView == null) goto L26;
            OTabLayoutBase.access$302(this.this$0, this.mCustomTextView.getTypeface());
        L26:
            ImageView r7 = (ImageView) r2.findViewById(android.R.id.icon);
            this.mCustomIconView = r7;
            if (r7 == null) goto L34;
            r7.setDuplicateParentStateEnabled(true);
        L34:
            if (this.mCustomView == null) goto L36;
            TextView r8 = this.mCustomTextView;
            if (r8 == null) goto L52;
        L53:
            updateTextAndIcon(r8, this.mCustomIconView);
        L54:
            if (r0 != null) goto L56;
        L58:
            r3 = false;
        L59:
            setSelected(r3);
            return;
        L56:
            if (r0.isSelected() == false) goto L58;
        L52:
            if (this.mCustomIconView == null) goto L54;
        L36:
            if (this.mIconView != null) goto L39;
            ImageView r9 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r9, 0);
            this.mIconView = r9;
            r9.setDuplicateParentStateEnabled(true);
        L39:
            if (this.mTextView != null) goto L45;
            TextView r10 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r10, new LinearLayout.LayoutParams(-1, -2));
            this.mTextView = r10;
            r10.setMaxLines(1);
            this.mTextView.setDuplicateParentStateEnabled(true);
            this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
            if (OTabLayoutBase.access$300(this.this$0) != null) goto L45;
            TextView r11 = this.mTextView;
            if (r11 == null) goto L45;
            OTabLayoutBase.access$302(this.this$0, r11.getTypeface());
        L45:
            this.mTextView.setAllCaps(false);
            if (this.this$0.mTabTextColors == null) goto L48;
            this.mTextView.setTextColor(this.this$0.mTabTextColors);
        L48:
            updateTextAndIcon(this.mTextView, this.mIconView);
            goto L54
        L29:
            View r12 = this.mCustomView;
            if (r12 == null) goto L32;
            removeView(r12);
            this.mCustomView = null;
        L32:
            this.mCustomTextView = null;
            this.mCustomIconView = null;
            goto L34
        L5:
            r2 = null;
            goto L6
        }

        private void updateTextAndIcon(TextView r7, ImageView r8) {
            Tab r0 = this.mTab;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            Drawable r2 = r0.getIcon();
        L6:
            Tab r3 = this.mTab;
            if (r3 == null) goto L9;
            CharSequence r4 = r3.getText();
        L10:
            Tab r5 = this.mTab;
            if (r5 == null) goto L13;
            CharSequence r6 = r5.getContentDescription();
        L14:
            int r9 = 0;
            if (r8 == null) goto L20;
            if (r2 == null) goto L18;
            r8.setImageDrawable(r2);
            r8.setVisibility(0);
            setVisibility(0);
        L19:
            r8.setContentDescription(r6);
            goto L20
        L18:
            r8.setVisibility(8);
            r8.setImageDrawable(null);
        L20:
            boolean r10 = !TextUtils.isEmpty(r4);
            if (r7 == null) goto L26;
            if (r10 == false) goto L24;
            r7.setText(r4);
            r7.setVisibility(0);
            setVisibility(0);
        L25:
            r7.setContentDescription(r6);
            goto L26
        L24:
            r7.setVisibility(8);
            r7.setText(null);
        L26:
            if (r8 == null) goto L35;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
            if (r10 == false) goto L33;
            if (r8.getVisibility() != 0) goto L33;
            r9 = this.this$0.dpToPx(8);
        L33:
            if (r9 == r11.bottomMargin) goto L35;
            r11.bottomMargin = r9;
            r8.requestLayout();
        L35:
            if (r10 == true) goto L38;
            r1 = r6;
        L38:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L13:
            r6 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public Tab getTab() {
            return this.mTab;
        }

        public TextView getTextView() {
            return this.mTextView;
        }

        public int getContentWidth() {
            TextView r0 = this.mTextView;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
            int r3 = 0;
            int r4 = 0;
        L8:
            ImageView r5 = this.mIconView;
            if (r5 != null) goto L11;
        L19:
            r1 = r2;
        L20:
            View r6 = this.mCustomView;
            if (r6 == null) goto L32;
            if (r6.getVisibility() != 0) goto L32;
            int r7 = this.mCustomView.getLeft();
            if (r1 == false) goto L27;
            r7 = Math.min(r3, r7);
        L27:
            r3 = r7;
            int r8 = this.mCustomView.getRight();
            if (r1 == false) goto L30;
            r8 = Math.max(r4, r8);
        L30:
            r4 = r8;
        L32:
            return r4 - r3;
        L11:
            if (r5.getVisibility() != 0) goto L19;
            if (r2 == false) goto L14;
            r3 = Math.min(r3, this.mIconView.getLeft());
        L15:
            if (r2 == false) goto L17;
            int r9 = Math.max(r4, this.mIconView.getRight());
        L18:
            r4 = r9;
            goto L20
        L17:
            r9 = this.mIconView.getRight();
            goto L18
        L14:
            r3 = this.mIconView.getLeft();
            goto L15
        L5:
            if (r0.getVisibility() != 0) goto L7;
            int r10 = this.mTextView.getLeft();
            r4 = this.mTextView.getRight();
            r3 = r10;
            r2 = true;
            goto L8
        }

        private float approximateLineWidth(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(Tab r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(Tab r1) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager r1) {
            this.mViewPager = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(Tab r1) {
            this.mViewPager.setCurrentItem(r1.getPosition());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    static /* synthetic */ int access$002(OTabLayoutBase r0, int r1) {
        r0.mPressedTabPosition = r1;
        return r1;
    }

    static /* synthetic */ List access$100(OTabLayoutBase r0) {
        return r0.mTabPressedShadows;
    }

    static /* synthetic */ SlidingTabStrip access$1000(OTabLayoutBase r0) {
        return r0.mTabStrip;
    }

    static /* synthetic */ boolean access$1300(OTabLayoutBase r0) {
        return r0.mTabScrollAnimFix;
    }

    static /* synthetic */ OnTabClickListener access$200(OTabLayoutBase r0) {
        return r0.onTabClickListener;
    }

    static /* synthetic */ Typeface access$300(OTabLayoutBase r0) {
        return r0.DEFAULT_TAB_TYPE_FACE;
    }

    static /* synthetic */ Typeface access$302(OTabLayoutBase r0, Typeface r1) {
        r0.DEFAULT_TAB_TYPE_FACE = r1;
        return r1;
    }

    static /* synthetic */ Typeface access$400(OTabLayoutBase r0, Typeface r1, int r2) {
        return r0.getSelectedTypeFace(r1, r2);
    }

    static /* synthetic */ int access$500(OTabLayoutBase r0) {
        return r0.mTabTopMargin;
    }

    static /* synthetic */ int access$600(OTabLayoutBase r0) {
        return r0.mTabSideMargin;
    }

    static /* synthetic */ int access$700(OTabLayoutBase r0) {
        return r0.mOriginalScreenOrientation;
    }

    static /* synthetic */ Interpolator access$800() {
        return FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    static /* synthetic */ int[] access$900() {
        return SELECTED_STATE_SET;
    }

    static {
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        SYNCHRONIZED_TAB_POOL = new Pools.SynchronizedPool(16);
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        IndicatorPoint r4 = (IndicatorPoint) r3.getAnimatedValue();
        Rect r0 = this.mIndicatorRect;
        r0.left = (int) r4.left;
        Rect r1 = this.mIndicatorRect;
        r1.right = (int) r4.right;
        invalidate();
    }

    public void setAutoFillWhenScrollable(boolean r1) {
        this.isAutoFillWhenScrollable = r1;
    }

    public void setTabMargin(int r5) {
        this.mTabMargin = dpToPx(r5);
        int r0 = 0;
    L4:
        if (r0 >= getTabCount()) goto L6;
        View r1 = this.mTabStrip.getChildAt(r0);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r2.leftMargin = dpToPx(r5);
        r2.rightMargin = dpToPx(r5);
        r1.setLayoutParams(r2);
        r0 = r0 + 1;
        goto L4
    }

    public void setSideAndTopMargin(int r2, int r3) {
        this.mTabSideMargin = dpToPx(r2);
        if (this.mTabSelectedTextSize <= dpToPx(20)) goto L6;
        this.mTabTopMargin = dpToPx(r3);
        return;
    }

    public ViewGroup getTabContainer() {
        return this.mTabStrip;
    }

    public void setTabStripPadding(int r1, int r2, int r3, int r4) {
        this.mTabStrip.setPadding(r1, r2, r3, r4);
    }

    public int getTabStripLeftPadding() {
        return this.mTabStrip.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.mTabStrip.getPaddingRight();
    }

    public void setOnTabClickListener(OnTabClickListener r1) {
        this.onTabClickListener = r1;
    }

    public OTabLayoutBase(Context r2) {
        this(r2, null);
    }

    public OTabLayoutBase(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OTabLayoutBase(Context r18, AttributeSet r19, int r20) {
        super(r18, r19, r20);
        this.mTabs = new ArrayList();
        this.mBackdropTargetWk = null;
        this.mTabSideMargin = 0;
        this.mTabTopMargin = 0;
        this.tabSpacing = 0;
        this.mTabPressedTextColor = 0;
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mTabMaxWidthInGravityCenter = Integer.MAX_VALUE;
        this.mSelectedListeners = new ArrayList();
        this.mTabScrollAnimFix = false;
        this.mIndicatorUnSelectedColor = 0;
        this.mIndicatorBackground = null;
        this.mIndicatorHeight = 0.0f;
        this.indicatorSpacing = 0.0f;
        this.mIndicatorCornerRadius = 0.0f;
        Paint r6 = new Paint(1);
        this.barPaint = r6;
        this.barShadowPaint = new Paint(1);
        Paint r8 = new Paint(1);
        this.barStrokePaint = r8;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.mEdgeFadeLayerBounds = new RectF();
        this.mEdgeFadeOverlayBounds = new RectF();
        this.isIndicatorAnimEnable = true;
        this.isIndicatorBounceEnable = false;
        this.isTabEnableMaterial = false;
        this.mTabMaterialToken = null;
        this.mTabMaterialConfigs = null;
        this.mTabMaterialSelectedToken = null;
        this.mTabMaterialSelectedConfigs = null;
        this.mTabPressedShadows = null;
        this.mIsFirstDraw = true;
        this.mIndicatorRect = new Rect();
        this.mIndicatorPressedRect = new Rect();
        this.mIndicatorPaint = new Paint();
        OTabLayoutEdgeFadeHelper r9 = new OTabLayoutEdgeFadeHelper();
        this.mEdgeFadeHelper = r9;
        this.mInterpolator = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mRadiusArr = new float[8];
        IndicatorPoint r10 = new IndicatorPoint(this);
        this.mCurrentP = r10;
        IndicatorPoint r11 = new IndicatorPoint(this);
        this.mLastP = r11;
        this.mPressedTabPosition = -1;
        this.mIsInLargeFont = false;
        this.mTabViewPool = new Pools.SimplePool(12);
        this.DEFAULT_TAB_TYPE_FACE = null;
        this.SELECTED_TAB_TYPE_FACE = null;
        this.mIsInLargeFont = ViewUtil.isInLargeFont(r18.getResources().getConfiguration().fontScale);
        if (OMaterialHelper.isMaterialEffectEnabled(r18) == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.enableMaterial = r4;
        setHorizontalScrollBarEnabled(false);
        SlidingTabStrip r5 = new SlidingTabStrip(this, r18);
        this.mTabStrip = r5;
        r5.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r5, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r13 = r18.obtainStyledAttributes(r19, R.styleable.TabLayout, r20, R.style.OTabText);
        r5.setSelectedIndicatorHeight(r13.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        r5.setSelectedIndicatorColor(r13.getColor(R.styleable.TabLayout_tabIndicatorColor, ContextCompat.getColor(getContext(), R.color.oui_accent_7)));
        this.mTabMinWidth = r13.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, dpToPx(56));
        int r7 = r13.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.mTabPaddingStart = r7;
        this.mTabPaddingTop = r7;
        this.mTabPaddingEnd = r7;
        this.mTabPaddingBottom = r7;
        this.mTabPaddingStart = r13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
        this.mTabPaddingTop = r13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
        this.mTabPaddingEnd = r13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
        this.mTabPaddingBottom = r13.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
        int r12 = r13.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.mTabTextAppearance = r12;
        int r14 = this.mTabPaddingStart;
        if (r14 > 0) goto L11;
    L13:
        int r15 = this.mTabPaddingEnd;
        if (r15 > 0) goto L16;
    L18:
        TypedArray r16 = r18.obtainStyledAttributes(r12, R.styleable.TextAppearance);
        this.mTabTextSize = r16.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L104
        this.mTabTextColors = r16.getColorStateList(R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L104
        r16.recycle();
        if (r13.hasValue(R.styleable.TabLayout_tabTextColor) == false) goto L23;
        this.mTabTextColors = r13.getColorStateList(R.styleable.TabLayout_tabTextColor);
    L23:
        boolean r17 = r13.hasValue(R.styleable.TabLayout_tabSelectedTextColor);
        if (r17 == false) goto L26;
        int r110 = r13.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
    L27:
        this.mRequestedTabMinWidth = r13.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        int r111 = r13.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.mRequestedTabMaxWidth = r111;
        if (r111 <= 0) goto L30;
        this.mTabMaxWidthInGravityCenter = r111;
    L30:
        this.mTabBackgroundResId = r13.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.mContentInsetStart = r13.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mMode = r13.getInt(R.styleable.TabLayout_tabMode, 1);
        this.mTabGravity = r13.getInt(R.styleable.TabLayout_tabGravity, 1);
        TypedArray r3 = r18.obtainStyledAttributes(r19, new int[]{android.R.attr.minHeight}, r20, 0);
        int r112 = r3.getDimensionPixelSize(0, 0);
        if (r112 <= 0) goto L33;
        setMinimumHeight(r112);
    L33:
        r3.recycle();
        TypedArray r21 = r18.obtainStyledAttributes(r19, R.styleable.OTabLayoutSupple);
        r5.setSelectedIndicatorFullWidth(r21.getBoolean(R.styleable.OTabLayoutSupple_oui_tabIndicatorFullWidth, true));     // Catch: Throwable -> L101
        r5.setShowBottomLine(r21.getBoolean(R.styleable.OTabLayoutSupple_oui_showBottomLine, false));     // Catch: Throwable -> L101
        r5.setShowTopLine(r21.getBoolean(R.styleable.OTabLayoutSupple_oui_showTopLine, false));     // Catch: Throwable -> L101
        r5.setShowSelectedIndicator(r21.getBoolean(R.styleable.OTabLayoutSupple_oui_showSelectedIndicator, true));     // Catch: Throwable -> L101
        this.mTabSelectedTextSize = r21.getDimensionPixelSize(R.styleable.OTabLayoutSupple_oui_tabSelectedTextSize, 0);     // Catch: Throwable -> L101
        this.mTabTextSize = r21.getDimensionPixelSize(R.styleable.OTabLayoutSupple_oui_tabTextSize, (int) this.mTabTextSize);     // Catch: Throwable -> L101
        this.mTabShadowStyle = r21.getResourceId(R.styleable.OTabLayoutSupple_oui_widgetShadow, R.style.OUIShadow_Oui_Shadow_Regular);     // Catch: Throwable -> L101
        if (this.enableMaterial == false) goto L37;
        this.enableMaterial = r21.getBoolean(R.styleable.OTabLayoutSupple_oui_widgetEnableMaterial, true);     // Catch: Throwable -> L101
    L37:
        int r113 = r21.getInt(R.styleable.OTabLayoutSupple_oui_tab_spec, -1);     // Catch: Throwable -> L101
        if (r113 != 0) goto L40;
    L45:
        int r22 = dpToPx(4);     // Catch: Throwable -> L101
        setTabStripPadding(r22, r22, r22, r22);     // Catch: Throwable -> L101
        this.tabSpacing = dpToPx(4);     // Catch: Throwable -> L101
    L46:
        String r23 = r21.getString(R.styleable.OTabLayoutSupple_oui_widgetMaterial);     // Catch: Throwable -> L101
        if (r23 != null) goto L49;
        r23 = r18.getString(R.string.oui_material_bg_floating);     // Catch: Throwable -> L101
    L49:
        r21.recycle();
        this.mScrollableTabMinWidth = getResources().getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        this.mIndicatorCornerX = OUnitExtensionKt.dp2px(1.5f, r18);
        this.mIndicatorCornerY = OUnitExtensionKt.dp2px(1.5f, r18);
        this.mOriginalScreenOrientation = getResources().getConfiguration().orientation;
        r13.recycle();
        TypedArray r2 = r18.obtainStyledAttributes(r19, R.styleable.OTabLayout);
        Drawable r24 = r2.getDrawable(R.styleable.OTabLayout_tab_divider);     // Catch: Throwable -> L98
        if (r24 == null) goto L53;
        r5.setDividerDrawable(r24);     // Catch: Throwable -> L98
        r5.setShowDividers(2);     // Catch: Throwable -> L98
    L53:
        this.mIndicatorColor = r2.getColor(R.styleable.OTabLayout_indicator_color, 0);     // Catch: Throwable -> L98
        this.mIndicatorUnSelectedColor = r2.getColor(R.styleable.OTabLayout_indicator_unselected_color, 0);     // Catch: Throwable -> L98
        this.mIndicatorBackground = r2.getDrawable(R.styleable.OTabLayout_indicator_background);     // Catch: Throwable -> L98
        this.mIndicatorHeight = r2.getDimension(R.styleable.OTabLayout_indicator_height, -1.0f);     // Catch: Throwable -> L98
        float r25 = r2.getDimension(R.styleable.OTabLayout_indicator_corner_radius, -1.0f);     // Catch: Throwable -> L98
        this.mIndicatorCornerRadius = r25;     // Catch: Throwable -> L98
        Drawable r26 = this.mIndicatorBackground;     // Catch: Throwable -> L98
        if ((r26 instanceof GradientDrawable) == false) goto L56;
        ((GradientDrawable) r26).setCornerRadius(r25);     // Catch: Throwable -> L98
    L56:
        this.indicatorSpacing = r2.getDimension(R.styleable.OTabLayout_indicator_spacing, dpToPx(4));     // Catch: Throwable -> L98
        int r27 = r2.getColor(R.styleable.OTabLayout_bar_color, 0);     // Catch: Throwable -> L98
        this.mBarColor = r27;     // Catch: Throwable -> L98
        if (r27 != 0) goto L59;
        setTabStripPadding(0, 0, 0, 0);     // Catch: Throwable -> L98
    L59:
        this.isIndicatorAnimEnable = r2.getBoolean(R.styleable.OTabLayout_indicator_anim_enable, false);     // Catch: Throwable -> L98
        this.isIndicatorBounceEnable = r2.getBoolean(R.styleable.OTabLayout_indicator_bounce_enable, true);     // Catch: Throwable -> L98
        r9.setEnabled(r2.getBoolean(R.styleable.OTabLayout_tab_edgeFadeEnabled, false));     // Catch: Throwable -> L98
        r9.setFadeLength(r2.getDimension(R.styleable.OTabLayout_tab_edgeFadeLength, dpToPxFloat(16.0f)));     // Catch: Throwable -> L98
        this.tabTextSelectedStyle = r2.getResourceId(R.styleable.OTabLayout_tab_textSelectedStyle, 0);     // Catch: Throwable -> L98
        this.tabTextStyle = r2.getResourceId(R.styleable.OTabLayout_tab_textStyle, 0);     // Catch: Throwable -> L98
        this.mTabPressedTextColor = r2.getColor(R.styleable.OTabLayout_tab_textPressedColor, 0);     // Catch: Throwable -> L98
        boolean r28 = r2.getBoolean(R.styleable.OTabLayout_tab_enableMaterial, false);     // Catch: Throwable -> L98
        this.isTabEnableMaterial = r28;     // Catch: Throwable -> L98
        if (r28 == false) goto L75;
        this.mTabMaterialToken = r2.getString(R.styleable.OTabLayout_tab_material);     // Catch: Throwable -> L98
        this.mTabMaterialSelectedToken = r2.getString(R.styleable.OTabLayout_tab_material_selected);     // Catch: Throwable -> L98
        if (TextUtils.isEmpty(this.mTabMaterialToken) == false) goto L64;
        this.mTabMaterialToken = r18.getString(R.string.oui_material_bg_floating);     // Catch: Throwable -> L98
    L64:
        String r29 = this.mTabMaterialToken;     // Catch: Throwable -> L98
        if (isDarkTheme() == true) goto L67;
        boolean r30 = true;
    L68:
        this.mTabMaterialConfigs = MaterialToken.parseSet(r29, r30);     // Catch: Throwable -> L98
        if (TextUtils.isEmpty(this.mTabMaterialSelectedToken) == true) goto L75;
        String r31 = this.mTabMaterialSelectedToken;     // Catch: Throwable -> L98
        if (isDarkTheme() == true) goto L73;
        boolean r32 = true;
    L74:
        this.mTabMaterialSelectedConfigs = MaterialToken.parseSet(r31, r32);     // Catch: Throwable -> L98
        goto L75
    L73:
        r32 = false;
        goto L74
    L67:
        r30 = false;
    L75:
        int r33 = r2.getResourceId(R.styleable.OTabLayout_shadow_pressed, 0);     // Catch: Throwable -> L98
        if (r33 == 0) goto L78;
        List<Shadow> r34 = OUILayoutHelper.extractShadowInfo(r18, r33);     // Catch: Throwable -> L98
        ArrayList r35 = new ArrayList(2);     // Catch: Throwable -> L98
        this.mTabPressedShadows = r35;     // Catch: Throwable -> L98
        r35.add(r34.get(0));     // Catch: Throwable -> L98
        this.mTabPressedShadows.add(r34.get(1));     // Catch: Throwable -> L98
    L78:
        r2.recycle();
        if (r17 == true) goto L81;
    L84:
        ValueAnimator r36 = ValueAnimator.ofObject(new PointEvaluator(this), new Object[]{r11, r10});
        this.mValueAnimator = r36;
        r36.addUpdateListener(this);
        r6.setStyle(Paint.Style.FILL);
        r8.setStyle(Paint.Style.STROKE);
        r8.setColor(0);
        float r37 = this.mIndicatorCornerRadius + (this.indicatorSpacing / 2.0f);
        if (this.enableMaterial == false) goto L96;
        this.mBackdropTargetWk = new WeakReference(this);
        MaterialConfig[] r38 = MaterialToken.parseSet(r23, !isDarkTheme());
        if (r38 == null) goto L96;
        OMaterialHelper.setMaterials(this, 2, r38);
        GradientDrawable r39 = new GradientDrawable();
        r39.setShape(0);
        r39.setCornerRadius(r37);
        r39.setColor(0);
        setBackground(r39);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Drawable r40 = this.mIndicatorBackground;
        if ((r40 instanceof GradientDrawable) == false) goto L92;
        ((GradientDrawable) r40).setColor(0);
    L92:
        if (OMaterialHelper.getMaterialLevel(r18) != 1) goto L96;
        MaterialConfig r1 = r38[0];
        if (r1.getStroke() == null) goto L96;
        r8.setColor(r1.getStroke().getColor());
        r8.setStrokeWidth(dpToPx((int) r1.getStroke().getWidth()));
    L96:
        updateShadow();
        applyModeAndGravity();
        return;
    L81:
        if (this.mTabPressedTextColor == 0) goto L83;
        this.mTabTextColors = createPressedOverlayColorStateList(this.mTabTextColors.getDefaultColor(), r110, this.mTabPressedTextColor);
        goto L84
    L83:
        this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), r110);
    L98:
        th = move-exception;
        r2.recycle();
        throw th;
    L40:
        if (r113 == 1) goto L45;
        if (r113 == 2) goto L44;
        setTabStripPadding(dpToPx(16), dpToPx(4), dpToPx(16), dpToPx(12));     // Catch: Throwable -> L101
        goto L46
    L44:
        setTabStripPadding(dpToPx(12), dpToPx(6), dpToPx(12), dpToPx(6));     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        r21.recycle();
        throw th;
    L26:
        r110 = 0;
    L104:
        th = move-exception;
        r16.recycle();
        throw th;
    L16:
        if (this.mIsInLargeFont == false) goto L18;
        this.mTabPaddingEnd = (r15 * 2) / 3;
        goto L18
    L11:
        if (this.mIsInLargeFont == false) goto L13;
        this.mTabPaddingStart = (r14 * 2) / 3;
        goto L13
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        r4 = true;
        goto L8
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mTabStrip.setEnabled(r1);
    }

    private boolean isDarkTheme() {
        int r0 = this.mTabTextColors.getDefaultColor();
        if (r0 != 0) goto L7;
        return isDarkMode();
    L7:
        return !OPalette.isDarkColor(r0);
    }

    private boolean isDarkMode() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r4) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = this.mTabs.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        this.mTabs.get(r1).updateMaterial(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r4) {
        if (r4 != null) goto L4;
        this.mBackdropTargetWk = new WeakReference(this);
    L5:
        View r0 = this.mBackdropTargetWk.get();
        if (r0 == null) goto L15;
        if (r4 != null) goto L9;
        OMaterialHelper.setEffectSrcTarget(this, null);
    L11:
        if (this.isTabEnableMaterial == false) goto L17;
        int r5 = this.mTabs.size();
        int r1 = 0;
    L13:
        if (r1 >= r5) goto L18;
        this.mTabs.get(r1).setBackdropTarget(r0);
        r1 = r1 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L9:
        OMaterialHelper.setEffectSrcTarget(this, r0);
        goto L11
    L15:
        return;
    L4:
        this.mBackdropTargetWk = new WeakReference(r4);
        goto L5
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r4) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = this.mTabs.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        this.mTabs.get(r1).updateBackdropTargetType(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r4) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = this.mTabs.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        this.mTabs.get(r1).updateBackdropSrcType(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private void updateShadow() {
        if (this.isIndicatorAnimEnable == false) goto L5;
        this.mTabStrip.setShadowStyle(this.mTabShadowStyle);
        this.mTabStrip.setShadowCornerRadius((int) this.mIndicatorCornerRadius);
        return;
    L5:
        this.mTabStrip.setShadowStyle(R.style.OUIShadow_None);
    }

    static void checkAppCompatTheme(Context r1) {
        TypedArray r2 = r1.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean r0 = !r2.hasValue(0);
        r2.recycle();
        if (r0 == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }

    public void fixTabScrollAnim() {
        this.mTabScrollAnimFix = true;
    }

    public void setTabMaxWidth(int r1) {
        this.mRequestedTabMaxWidth = r1;
        this.mTabMaxWidthInGravityCenter = r1;
    }

    public void setTabMinWidth(int r1) {
        this.mRequestedTabMinWidth = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.mTabPaddingStart = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.mTabPaddingTop = r1;
    }

    public void setContentInsetStart(int r1) {
        this.mContentInsetStart = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.mTabPaddingEnd = r1;
    }

    public void setTabBackgroundResId(int r1) {
        this.mTabBackgroundResId = r1;
    }

    public void setTabPaddingBottom(int r1) {
        this.mTabPaddingBottom = r1;
    }

    public void setSelectedTabIndicatorColor(int r1) {
        this.mTabStrip.setSelectedIndicatorColor(r1);
    }

    public void setSelectedTabIndicatorHeight(int r1) {
        this.mTabStrip.setSelectedIndicatorHeight(r1);
    }

    public void setSelectedTabHorizontalPadding(int r1) {
        this.mTabStrip.setSelectedTabHorizontalPadding(r1);
    }

    public void setScrollPosition(int r2, float r3, boolean r4) {
        setScrollPosition(r2, r3, r4, true);
    }

    void setScrollPosition(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.mTabStrip.getChildCount()) goto L20;
        if (r6 == false) goto L9;
        this.mTabStrip.setIndicatorPositionFromTabPosition(r3, r4);
    L9:
        ValueAnimator r7 = this.mScrollAnimator;
        if (r7 != null) goto L12;
    L14:
        scrollTo(calculateScrollXForTab(r3, r4), 0);
        if (r5 == false) goto L19;
        setSelectedTabView(r0);
        return;
    L19:
        return;
    L12:
        if (r7.isRunning() == false) goto L14;
        this.mScrollAnimator.cancel();
        goto L14
    }

    public void showTabBgAndIndicatorBg(int r1, int r2) {
        this.mBarColor = r1;
        this.mIndicatorColor = r2;
        this.isIndicatorAnimEnable = true;
        updateShadow();
        invalidate();
        this.mTabStrip.invalidate();
    }

    public void hiddenTabBgAndIndicatorBg(int r2, int r3) {
        this.mBarColor = 0;
        this.mIndicatorColor = r2;
        this.mIndicatorUnSelectedColor = r3;
        this.isIndicatorAnimEnable = false;
        updateShadow();
        invalidate();
        this.mTabStrip.invalidate();
    }

    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }

    public void setShowTopLine(Boolean r1) {
        this.mTabStrip.setShowTopLine(r1.booleanValue());
    }

    public void setShowSelectedIndicator(Boolean r1) {
        this.mTabStrip.setShowSelectedIndicator(r1.booleanValue());
    }

    public void addTab(Tab r2) {
        addTab(r2, this.mTabs.isEmpty());
    }

    public void addTab(Tab r2, int r3) {
        addTab(r2, r3, this.mTabs.isEmpty());
    }

    public void addTab(Tab r2, boolean r3) {
        addTab(r2, this.mTabs.size(), r3);
    }

    public void addTab(Tab r3, final int r4, boolean r5) {
        if (r3.mParent != this) goto L9;
        configureTab(r3, r4);
        addTabView(r3);
        r3.getView().setOnTouchListener(new AnonymousClass1(this, r4));
        if (r5 == false) goto L10;
        r3.select();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void addTabFromItemView(OTabItem r3) {
        Tab r0 = newTab(0);
        if (r3.mText == null) goto L6;
        r0.setText(r3.mText);
    L6:
        if (r3.mIcon == null) goto L9;
        r0.setIcon(r3.mIcon);
    L9:
        if (r3.mCustomLayout == 0) goto L12;
        r0.setCustomView(r3.mCustomLayout);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.setContentDescription(r3.getContentDescription());
    L14:
        addTab(r0);
    }

    private void addTabFromBottomItemView(OBottomTabItem r5) {
        OBottomTabItemCustomView r0 = new OBottomTabItemCustomView(getContext());
        Tab r1 = newTab(0);
        if (r5.getText() == null) goto L6;
        r0.getTitle().setText(r5.getText());
        r1.setText(r5.getText());
    L6:
        if (r5.getIcon() == null) goto L8;
        r0.getIcon().setImageDrawable(r5.getIcon());
    L8:
        r0.setTextColor(this.mTabTextColors);
        r0.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), R.color.oui_accent_bg_light)));
        r1.setCustomView(r0);
        addTab(r1);
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener r2) {
        OnTabSelectedListener r0 = this.mSelectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.mSelectedListener = r2;
        if (r2 == null) goto L9;
        addOnTabSelectedListener(r2);
        return;
    }

    public void addOnTabSelectedListener(OnTabSelectedListener r2) {
        if (this.mSelectedListeners.contains(r2) == true) goto L6;
        this.mSelectedListeners.add(r2);
        return;
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener r1) {
        this.mSelectedListeners.remove(r1);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public Tab newTab(int r3) {
        Tab r0 = SYNCHRONIZED_TAB_POOL.acquire();
        if (r0 != null) goto L5;
        r0 = new Tab();
    L5:
        r0.mParent = this;
        r0.mView = createTabView();
        if (r3 <= 0) goto L8;
        r0.mView.setTab(r0, false);
        r0.setCustomView(r3);
    L9:
        return r0;
    L8:
        r0.mView.setTab(r0);
        goto L9
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Tab getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return this.mTabs.get(r2);
    }

    public int getSelectedTabPosition() {
        Tab r0 = this.mSelectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPosition();
    }

    public void removeTab(Tab r2) {
        if (r2.mParent != this) goto L7;
        removeTabAt(r2.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r6) {
        Tab r0 = this.mSelectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.getPosition();
    L6:
        removeTabViewAt(r6);
        Tab r2 = this.mTabs.remove(r6);
        if (r2 == null) goto L9;
        r2.reset();
        SYNCHRONIZED_TAB_POOL.release(r2);
    L9:
        int r3 = this.mTabs.size();
        int r4 = r6;
    L10:
        if (r4 >= r3) goto L12;
        this.mTabs.get(r4).setPosition(r4);
        r4 = r4 + 1;
        goto L10
    L12:
        if (r1 == r6) goto L14;
        return;
    L14:
        if (this.mTabs.isEmpty() == false) goto L16;
        Tab r7 = null;
    L17:
        selectTab(r7);
        return;
    L16:
        r7 = this.mTabs.get(Math.max(0, r6 - 1));
        goto L17
    L5:
        r1 = 0;
        goto L6
    }

    public void removeAllTabs() {
        int r0 = this.mTabStrip.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        removeTabViewAt(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<Tab> r1 = this.mTabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Tab r2 = r1.next();
        r1.remove();
        r2.reset();
        SYNCHRONIZED_TAB_POOL.release(r2);
        goto L7
    L9:
        this.mSelectedTab = null;
    }

    public void setTabMode(int r2) {
        if (r2 == this.mMode) goto L6;
        this.mMode = r2;
        applyModeAndGravity();
        return;
    }

    public void setTabMode(String r2) {
        r2.hashCode();
        if (r2.equals("scrollable") == true) goto L11;
        if (r2.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.mMode == 1) goto L14;
        this.mMode = 1;
        applyModeAndGravity();
        return;
    L14:
        return;
    L11:
        if (this.mMode == 0) goto L16;
        this.mMode = 0;
        applyModeAndGravity();
        return;
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int r2) {
        if (this.mTabGravity == r2) goto L6;
        this.mTabGravity = r2;
        applyModeAndGravity();
        return;
    }

    @Deprecated
    public void setTabTextAppearance(int r1) {
        this.mTabTextAppearance = r1;
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    public void setTabTextColors(ColorStateList r2) {
        if (this.mTabTextColors == r2) goto L6;
        this.mTabTextColors = r2;
        updateAllTabs();
        return;
    }

    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public void setTabTextColors(int r1, int r2) {
        setTabTextColors(createColorStateList(r1, r2));
    }

    public void setTabTextSize(float r2) {
        if (this.mTabTextSize == r2) goto L6;
        this.mTabTextSize = r2;
        updateAllTabs();
        return;
    }

    public void setupWithViewPager(ViewPager r2) {
        setupWithViewPager(r2, true);
    }

    public void setupWithViewPager(ViewPager r2, boolean r3) {
        setupWithViewPager(r2, r3, false);
    }

    private void setupWithViewPager(ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.mViewPager;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.mPageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.mAdapterChangeListener;
        if (r2 == null) goto L10;
        this.mViewPager.removeOnAdapterChangeListener(r2);
    L10:
        OnTabSelectedListener r6 = this.mCurrentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.mCurrentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L24;
        this.mViewPager = r3;
        if (this.mPageChangeListener != null) goto L17;
        this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
    L17:
        this.mPageChangeListener.reset();
        r3.addOnPageChangeListener(this.mPageChangeListener);
        ViewPagerOnTabSelectedListener r7 = new ViewPagerOnTabSelectedListener(r3);
        this.mCurrentVpSelectedListener = r7;
        addOnTabSelectedListener(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        setPagerAdapter(r8, r4);
    L21:
        if (this.mAdapterChangeListener != null) goto L23;
        this.mAdapterChangeListener = new AdapterChangeListener(this);
    L23:
        this.mAdapterChangeListener.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.mAdapterChangeListener);
        setScrollPosition(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.mSetupViewPagerImplicitly = r5;
        return;
    L24:
        this.mViewPager = null;
        setPagerAdapter(null, false);
        goto L25
    }

    public void setCustomTabViewResId(int r1) {
        this.mCustomTabResId = r1;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter r2) {
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r0, true, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.mSetupViewPagerImplicitly = false;
        return;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.mPagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.mPagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.mPagerAdapter = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.mPagerAdapterObserver != null) goto L13;
        this.mPagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.registerDataSetObserver(this.mPagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r0 = this.mPagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab(this.mCustomTabResId).setText(this.mPagerAdapter.getPageTitle(r2)), false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r3 = this.mViewPager;
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
        int r0 = this.mTabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTabs.get(r1).updateView();
        r1 = r1 + 1;
        goto L3
    }

    private TabView createTabView() {
        Pools.Pool<TabView> r0 = this.mTabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = r0.acquire();
    L6:
        if (r1 != null) goto L17;
        r1 = new TabView(this, getContext(), this.isTabEnableMaterial, this.mTabMaterialConfigs, this.mTabMaterialSelectedConfigs);
        WeakReference<View> r2 = this.mBackdropTargetWk;
        if (r2 != null) goto L10;
    L12:
        Drawable r3 = this.mIndicatorBackground;
        if (r3 != null) goto L15;
    L18:
        r1.setFocusable(true);
        return r1;
    L15:
        if (this.isTabEnableMaterial == true) goto L18;
        r1.setBackground(r3.mutate());
        r1.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        goto L18
    L10:
        if (r2.get() == null) goto L12;
        r1.setBackdropTarget(this.mBackdropTargetWk.get());
        goto L12
    L17:
        r1.updateEnableMaterial(this.isTabEnableMaterial);
        r1.updateMaterialConfigs(this.mTabMaterialConfigs, this.mTabMaterialSelectedConfigs);
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    private void configureTab(Tab r2, int r3) {
        r2.setPosition(r3);
        this.mTabs.add(r3, r2);
        int r4 = this.mTabs.size();
    L3:
        r3 = r3 + 1;
        if (r3 >= r4) goto L6;
        this.mTabs.get(r3).setPosition(r3);
        goto L3
    }

    private void addTabView(Tab r3) {
        TabView r0 = r3.mView;
        this.mTabStrip.addView(r0, r3.getPosition(), createLayoutParamsForTabs());
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

    private void addViewInternal(View r4) {
        if ((r4 instanceof OTabItem) == false) goto L6;
        addTabFromItemView((OTabItem) r4);
        return;
    L6:
        if ((r4 instanceof SlidingTabStrip) == false) goto L11;
        if (indexOfChild(r4) != (-1)) goto L15;
        super.addView(r4, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L15:
        return;
    L11:
        if ((r4 instanceof OBottomTabItem) == false) goto L17;
        addTabFromBottomItemView((OBottomTabItem) r4);
        return;
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r0);
        return r0;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams r3) {
        if (this.mMode == 1) goto L5;
    L7:
        r3.width = -2;
        r3.weight = 0.0f;
    L8:
        int r0 = this.mTabMargin;
        if (r0 == 0) goto L12;
        r3.leftMargin = r0;
        r3.rightMargin = this.mTabMargin;
        return;
    L12:
        return;
    L5:
        if (this.mTabGravity != 0) goto L7;
        r3.width = 0;
        r3.weight = 1.0f;
        goto L8
    }

    int dpToPx(int r1) {
        return (int) ((getResources().getDisplayMetrics().density * r1) + 0.5f);
    }

    float dpToPxFloat(float r1) {
        return (getResources().getDisplayMetrics().density * r1) + 0.5f;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = (dpToPx(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r1 = getMinimumHeight();
        if (r1 <= 0) goto L5;
        r0 = r1;
    L5:
        int r2 = View.MeasureSpec.getMode(r7);
        if (r2 == Integer.MIN_VALUE) goto L10;
        if (r2 == 0) goto L9;
        int r8 = View.MeasureSpec.makeMeasureSpec(Math.max(r0, View.MeasureSpec.getSize(r7)), 1073741824);
    L11:
        int r3 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L18;
        int r4 = this.mRequestedTabMaxWidth;
        if (r4 > 0) goto L17;
        r4 = r3 - dpToPx(56);
    L17:
        this.mTabMaxWidth = r4;
    L18:
        super.onMeasure(r6, r8);
        boolean r5 = true;
        if (getChildCount() != 1) goto L35;
        boolean r9 = false;
        View r10 = getChildAt(0);
        int r11 = this.mMode;
        if (r11 == 0) goto L28;
        if (r11 == 1) goto L25;
    L32:
        if (r9 == false) goto L36;
        r10.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(r8, getPaddingTop() + getPaddingBottom(), r10.getLayoutParams().height));
        return;
    L36:
        return;
    L25:
        if (r10.getMeasuredWidth() != getMeasuredWidth()) goto L31;
    L30:
        r5 = false;
    L31:
        r9 = r5;
        goto L32
    L28:
        if (r10.getMeasuredWidth() >= getMeasuredWidth()) goto L30;
    L35:
        return;
    L9:
        r8 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        goto L11
    L10:
        r8 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, View.MeasureSpec.getSize(r7)), 1073741824);
        goto L11
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r14) {
        float r0 = getBounceTranslation();
        float r1 = OUnitExtensionKt.dp2px(0.5f, getContext());
        boolean r3 = false;
        if (r0 >= (-r1)) goto L5;
        boolean r2 = true;
    L7:
        if (r0 <= r1) goto L9;
        boolean r4 = true;
    L11:
        if (canScrollHorizontally(-1) == true) goto L15;
        if (r2 == true) goto L15;
        boolean r5 = false;
    L17:
        if (canScrollHorizontally(1) == true) goto L19;
        if (r4 == true) goto L19;
    L21:
        if (this.mEdgeFadeHelper.shouldApply(getWidth(), getHeight(), r5, r3) == false) goto L32;
        float r6 = getScrollX();
        float r7 = Math.max(getPaddingLeft(), getTabStripLeftPadding());
        float r8 = Math.max(getPaddingRight(), getTabStripRightPadding());
        OTabLayoutHelper.updateEdgeFadeBounds(this.mTabStrip, r6, getWidth(), getHeight(), r5, r3, this.mEdgeFadeLayerBounds, this.mEdgeFadeOverlayBounds);
        int r9 = r14.saveLayer(this.mEdgeFadeLayerBounds.left, this.mEdgeFadeLayerBounds.top, this.mEdgeFadeLayerBounds.right, this.mEdgeFadeLayerBounds.bottom, null);
        drawTabContent(r14);
        OTabLayoutEdgeFadeHelper r10 = this.mEdgeFadeHelper;
        float r11 = this.mEdgeFadeOverlayBounds.left;
        if (r5 == true) goto L26;
        r7 = 0.0f;
    L26:
        float r12 = r7 + r11;
        float r13 = this.mEdgeFadeOverlayBounds.top;
        float r15 = this.mEdgeFadeOverlayBounds.right;
        if (r3 == true) goto L30;
        r8 = 0.0f;
    L30:
        r10.drawOverlay(r14, r12, r13, r15 - r8, this.mEdgeFadeOverlayBounds.bottom, r5, r3);
        r14.restoreToCount(r9);
        return;
    L32:
        drawTabContent(r14);
        return;
    L19:
        r3 = true;
    L15:
        r5 = true;
        goto L17
    L9:
        r4 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    private void drawTabContent(Canvas r2) {
        if (isInEditMode() == false) goto L5;
    L7:
        super.dispatchDraw(r2);
        return;
    L5:
        if (getTabCount() <= 0) goto L7;
        drawTabBackgroundAndIndicators(r2, getBounceTranslation());
        goto L7
    }

    private void drawTabBackgroundAndIndicators(Canvas r12, float r13) {
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        int r2 = getPaddingTop();
        int r3 = getPaddingBottom();
        if (this.mIndicatorHeight >= 0.0f) goto L5;
        this.mIndicatorHeight = r0 - (this.indicatorSpacing * 2.0f);
    L5:
        float r4 = this.mIndicatorCornerRadius;
        if (r4 >= 0.0f) goto L8;
    L9:
        this.mIndicatorCornerRadius = this.mIndicatorHeight;
    L10:
        float r5 = this.mIndicatorCornerRadius + (this.indicatorSpacing / 2.0f);
        float r6 = getWidth() + r13;
        if (this.enableMaterial == true) goto L16;
        int r7 = this.mBarColor;
        if (r7 == 0) goto L16;
        this.barPaint.setColor(r7);
        this.barRectF.set(r13, r2, r6, r0 - r3);
        r12.drawRoundRect(this.barRectF, r5, r5, this.barPaint);
    L16:
        if (this.barStrokePaint.getColor() == 0) goto L18;
        this.barRectF.set(r13, r2, r6, r0 - r3);
        r12.drawRoundRect(this.barRectF, r5, r5, this.barStrokePaint);
    L18:
        int r8 = 0;
        if (this.isIndicatorAnimEnable == true) goto L21;
        calcIndicatorRect();
    L24:
        int r9 = this.mIndicatorColor;
        if (r9 == 0) goto L28;
        this.mIndicatorPaint.setColor(r9);
        SmoothCornerH.drawRoundRect(r12, (this.mIndicatorRect.left + r1) + r13, this.indicatorSpacing, (this.mIndicatorRect.right + r1) + r13, this.indicatorSpacing + this.mIndicatorHeight, this.mIndicatorCornerRadius, this.mIndicatorPaint);
    L28:
        if (this.mIndicatorUnSelectedColor != 0) goto L30;
        return;
    L30:
        if (this.mBarColor == 0) goto L32;
        return;
    L32:
        if (r8 >= getTabCount()) goto L42;
        if (r8 == getSelectedTabPosition()) goto L36;
        View r10 = getTabView(r8);
        this.mIndicatorPaint.setColor(this.mIndicatorUnSelectedColor);
        SmoothCornerH.drawRoundRect(r12, (r10.getLeft() + r1) + r13, this.indicatorSpacing, (r10.getRight() + r1) + r13, this.indicatorSpacing + this.mIndicatorHeight, this.mIndicatorCornerRadius, this.mIndicatorPaint);
    L36:
        r8 = r8 + 1;
        goto L32
    L42:
        return;
    L21:
        if (this.mIsFirstDraw == false) goto L24;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L24
    L8:
        if (r4 <= (this.mIndicatorHeight / 2.0f)) goto L10;
        goto L9
    }

    private void calcIndicatorRect() {
        View r0 = getTabView(getSelectedTabPosition());
        if (r0 == null) goto L6;
        Rect r1 = this.mIndicatorRect;
        r1.left = r0.getLeft();
        Rect r3 = this.mIndicatorRect;
        r3.right = r0.getRight();
        return;
    }

    private void removeTabViewAt(int r3) {
        TabView r0 = (TabView) this.mTabStrip.getChildAt(r3);
        this.mTabStrip.removeViewAt(r3);
        if (r0 == null) goto L5;
        r0.reset();
        this.mTabViewPool.release(r0);
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
        if (this.mTabStrip.childrenNeedLayout() == true) goto L17;
        int r0 = getScrollX();
        int r2 = calculateScrollXForTab(r7, 0.0f);
        if (r0 == r2) goto L15;
        ensureScrollAnimator();
        this.mScrollAnimator.setIntValues(new int[]{r0, r2});
        this.mScrollAnimator.start();
    L15:
        this.mTabStrip.animateIndicatorToPosition(r7, 200);
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.mScrollAnimator = r0;
        r0.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.mScrollAnimator.setDuration(200);
        this.mScrollAnimator.addUpdateListener(new AnonymousClass2(this));
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r1) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(r1);
    }

    private void setSelectedTabView(int r6) {
        int r0 = this.mTabStrip.getChildCount();
        if (r6 >= r0) goto L11;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L15;
        View r3 = this.mTabStrip.getChildAt(r2);
        if (r2 != r6) goto L9;
        boolean r4 = true;
    L10:
        r3.setSelected(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L15:
        return;
    }

    public void selectTab(int r2) {
        if (r2 < this.mTabs.size()) goto L5;
        return;
    L5:
        if (this.mTabs.isEmpty() == true) goto L13;
        Tab r3 = this.mTabs.get(r2);
        if (r3 == null) goto L12;
        selectTab(r3);
        return;
    L12:
        return;
    }

    void selectTab(Tab r2) {
        selectTab(r2, true);
    }

    void selectTab(Tab r5, boolean r6) {
        Tab r0 = this.mSelectedTab;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L30;
        dispatchTabReselected(r5);
        animateToTab(r5.getPosition());
        return;
    L30:
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
        if (r0 == null) goto L21;
        dispatchTabUnselected(r0);
    L21:
        Tab r7 = this.mSelectedTab;
        if (r7 != null) goto L24;
        r7 = r5;
    L24:
        this.mLastTab = r7;
        this.mSelectedTab = r5;
        if (this.isIndicatorAnimEnable == false) goto L27;
        calcOffset();
    L27:
        if (r5 == null) goto L32;
        dispatchTabSelected(r5);
        return;
    L32:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    private void calcOffset() {
        View r0 = getTabView(getSelectedTabPosition());
        if (r0 != null) goto L5;
        return;
    L5:
        this.mCurrentP.left = r0.getLeft();
        this.mCurrentP.right = r0.getRight();
        TabView r1 = this.mLastTab.getView();
        this.mLastP.left = r1.getLeft();
        this.mLastP.right = r1.getRight();
        if (this.mLastP.left == this.mCurrentP.left) goto L8;
    L10:
        this.mValueAnimator.setObjectValues(new Object[]{this.mLastP, this.mCurrentP});
        if (this.isIndicatorBounceEnable == false) goto L13;
        this.mValueAnimator.setInterpolator(this.mInterpolator);
    L13:
        this.mValueAnimator.setDuration(TAB_ANIM_DURATION);
        this.mValueAnimator.start();
        return;
    L8:
        if (this.mLastP.right != this.mCurrentP.right) goto L10;
        invalidate();
    }

    private void dispatchTabSelected(Tab r3) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mSelectedListeners.get(r0).onTabSelected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(Tab r3) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mSelectedListeners.get(r0).onTabUnselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabReselected(Tab r3) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mSelectedListeners.get(r0).onTabReselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private int calculateScrollXForTab(int r4, float r5) {
        int r1 = 0;
        if (this.mMode != 0) goto L21;
        View r0 = this.mTabStrip.getChildAt(r4);
        int r6 = r4 + 1;
        if (r6 >= this.mTabStrip.getChildCount()) goto L7;
        View r7 = this.mTabStrip.getChildAt(r6);
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.getWidth();
    L11:
        if (r7 == null) goto L13;
        int r8 = r7.getWidth();
    L14:
        if (r0 == null) goto L16;
        r1 = r0.getLeft();
    L16:
        int r3 = (r1 + (r2 / 2)) - (getWidth() / 2);
        int r9 = (int) ((((r2 + r8) + (this.mTabMargin * 4)) * 0.5f) * r5);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r3 + r9;
    L20:
        return r3 - r9;
    L13:
        r8 = 0;
        goto L14
    L10:
        r2 = 0;
        goto L11
    L7:
        r7 = null;
        goto L8
    L21:
        return 0;
    }

    private void applyModeAndGravity() {
        int r0 = this.mMode;
        if (r0 == 0) goto L7;
        if (r0 != 1) goto L8;
        this.mTabStrip.setGravity(1);
        setOverScrollMode(2);
    L8:
        updateTabViews(true);
        return;
    L7:
        this.mTabStrip.setGravity(GravityCompat.START);
        setOverScrollMode(0);
        goto L8
    }

    void updateTabViews(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTabStrip.getChildCount()) goto L9;
        View r1 = this.mTabStrip.getChildAt(r0);
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private Typeface getSelectedTypeFace(Typeface r2, int r3) {
        if (this.SELECTED_TAB_TYPE_FACE != null) goto L6;
        this.SELECTED_TAB_TYPE_FACE = Typeface.create(r2, r3, false);
    L6:
        return this.SELECTED_TAB_TYPE_FACE;
    }

    private static ColorStateList createColorStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    private static ColorStateList createPressedOverlayColorStateList(int r7, int r8, int r9) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{ColorUtils.compositeColors(r9, r8), ColorUtils.compositeColors(r9, r7), r8, r7});
    }

    private int getDefaultHeight() {
        int r0 = this.mTabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Tab r2 = this.mTabs.get(r1);
        if (r2 == null) goto L13;
        if (r2.getIcon() == null) goto L11;
        if (TextUtils.isEmpty(r2.getText()) == true) goto L11;
        return 56;
    L11:
        if (r2.getCustomView() == null) goto L13;
        return 56;
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return 56;
    }

    private int getTabMinWidth() {
        int r0 = this.mRequestedTabMinWidth;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.mMode == 0) goto L10;
        return 0;
    L10:
        return this.mScrollableTabMinWidth;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }

    public View getTabView(int r1) {
        return this.mTabStrip.getChildAt(r1);
    }

    public void setIndicatorCornerRadius(float r1) {
        this.mIndicatorCornerRadius = r1;
        invalidate();
    }

    public float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public void setIndicatorAnimEnable(boolean r1) {
        this.isIndicatorAnimEnable = r1;
        invalidate();
    }

    public boolean isIndicatorAnimEnable() {
        return this.isIndicatorAnimEnable;
    }

    public void setIndicatorBounceEnable(boolean r1) {
        this.isIndicatorBounceEnable = r1;
    }

    public boolean isIndicatorBounceEnable() {
        return this.isIndicatorBounceEnable;
    }

    public void setEdgeFadeEnabled(boolean r2) {
        if (this.mEdgeFadeHelper.setEnabled(r2) == false) goto L6;
        invalidate();
        return;
    }

    public boolean isEdgeFadeEnabled() {
        return this.mEdgeFadeHelper.isEnabled();
    }

    public void setEdgeFadeLength(float r2) {
        if (this.mEdgeFadeHelper.setFadeLength(r2) == false) goto L6;
        invalidate();
        return;
    }

    public float getEdgeFadeLength() {
        return this.mEdgeFadeHelper.getFadeLength();
    }
}
