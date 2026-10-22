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
import android.os.Build;
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
import androidx.appcompat.widget.aa;
import androidx.core.view.ViewCompat;
import androidx.core.view.w;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.common.style.j;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@ViewPager.a
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, com.obric.oui.material.g {
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
    private static final androidx.core.util.f.a<e> SYNCHRONIZED_TAB_POOL = null;
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
    protected boolean isSysSupportMaterial;
    private boolean isTabEnableMaterial;
    private a mAdapterChangeListener;
    protected WeakReference<View> mBackdropTargetWk;
    private int mBarColor;
    private int mContentInsetStart;
    private final b mCurrentP;
    private d mCurrentVpSelectedListener;
    int mCustomTabResId;
    private final com.obric.oui.tab.a mEdgeFadeHelper;
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
    private final b mLastP;
    private e mLastTab;
    int mMode;
    private int mOriginalScreenOrientation;
    f mPageChangeListener;
    private androidx.viewpager.widget.a mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private int mPressedTabPosition;
    private final float[] mRadiusArr;
    private int mRequestedTabMaxWidth;
    private int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private d mSelectedListener;
    private final ArrayList<d> mSelectedListeners;
    private e mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    int mTabBackgroundResId;
    private float mTabDisabledAlpha;
    int mTabGravity;
    private int mTabMargin;
    private com.obric.oui.material.c[] mTabMaterialConfigs;
    private com.obric.oui.material.c[] mTabMaterialSelectedConfigs;
    private String mTabMaterialSelectedToken;
    private String mTabMaterialToken;
    int mTabMaxWidth;
    int mTabMaxWidthInGravityCenter;
    int mTabMinWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private List<j> mTabPressedShadows;
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
    private final androidx.core.util.f.a<TabView> mTabViewPool;
    private final ArrayList<e> mTabs;
    private final ValueAnimator mValueAnimator;
    ViewPager mViewPager;
    private c onTabClickListener;
    int tabSpacing;
    private int tabTextSelectedStyle;
    private int tabTextStyle;

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

    public class PointEvaluator implements TypeEvaluator<b> {
        final /* synthetic */ OTabLayoutBase this$0;

        public PointEvaluator(OTabLayoutBase r1) {
            this.this$0 = r1;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ b evaluate(float r3, b r4, b r5) {
            return evaluate2(r3, (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public b evaluate2(float r4, b r5, b r6) {
            float r0 = r5.f36301a + ((r6.f36301a - r5.f36301a) * r4);
            float r1 = r5.f36302b + (r4 * (r6.f36302b - r5.f36302b));
            b r7 = new b(this.this$0);
            r7.f36301a = r0;
            r7.f36302b = r1;
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

        static /* synthetic */ float access$1402(SlidingTabStrip r0, float r1) {
            r0.left = r1;
            return r1;
        }

        static /* synthetic */ float access$1502(SlidingTabStrip r0, float r1) {
            r0.right = r1;
            return r1;
        }

        SlidingTabStrip(OTabLayoutBase r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
            this.mSelectedPosition = -1;
            this.mLayoutDirection = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            this.mSelectedIndicatorWidth = r3.dpToPx(27);
            this.mMinTabWidth = Integer.MAX_VALUE;
            setChangeAlphaWhenPress(false);
            setClipChildren(false);
            setClipToPadding(false);
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
            this.topLineWidth = r3.dpToPxFloat(0.6f);
            setChangeAlphaWhenDisable(false);
        }

        void setShowBottomLine(boolean r5) {
            this.showBottomLine = r5;
            if (r5 == false) goto L6;
            Paint r6 = new Paint();
            this.showBottomLinePaint = r6;
            r6.setColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2")));
            this.showBottomLinePaint.setStyle(Paint.Style.FILL);
            return;
        }

        void setShowTopLine(boolean r5) {
            this.showTopLine = r5;
            if (r5 == false) goto L6;
            Paint r6 = new Paint();
            this.showTopLinePaint = r6;
            r6.setColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2")));
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
            ViewCompat.f(this);
            return;
        }

        void setSelectedIndicatorHeight(int r2) {
            if (this.mSelectedIndicatorHeight == r2) goto L6;
            this.mSelectedIndicatorHeight = r2;
            ViewCompat.f(this);
            return;
        }

        void setSelectedIndicatorFullWidth(boolean r2) {
            if (this.mSelectedIndicatorFullWidth == r2) goto L6;
            this.mSelectedIndicatorFullWidth = r2;
            ViewCompat.f(this);
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
        public void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.mLayoutDirection == r3) goto L9;
            requestLayout();
            this.mLayoutDirection = r3;
            return;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r12, int r13) {
            super.onMeasure(r12, r13);
            int r0 = getChildCount();
            boolean r4 = true;
            int r5 = 0;
            if (View.MeasureSpec.getMode(r12) != 1073741824) goto L5;
            Drawable r1 = getDividerDrawable();
            if (r1 == null) goto L28;
            int r2 = r1.getIntrinsicWidth();
        L29:
            int r6 = 0;
            int r7 = 0;
        L30:
            if (r6 >= r0) goto L35;
            View r8 = getChildAt(r6);
            if (r8.getVisibility() != 0) goto L34;
            r7 = Math.max(r7, r8.getMeasuredWidth());
            this.mMinTabWidth = Math.min(this.mMinTabWidth, r8.getMeasuredWidth());
        L34:
            r6 = r6 + 1;
            goto L30
        L35:
            int r9 = (getPaddingLeft() + getPaddingRight()) + (r2 * (r0 - 1));
            if (this.this$0.mMode != 1) goto L56;
            if (this.this$0.mTabGravity != 1) goto L56;
            if (r7 > 0) goto L42;
            return;
        L42:
            if ((r7 * r0) > (getMeasuredWidth() - r9)) goto L52;
            boolean r3 = false;
        L44:
            if (r5 >= r0) goto L51;
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r10.width == r7) goto L48;
        L49:
            r10.width = r7;
            r10.weight = 0.0f;
            r3 = true;
        L50:
            r5 = r5 + 1;
            goto L44
        L48:
            if (r10.weight == 0.0f) goto L50;
        L51:
            r4 = r3;
        L53:
            if (r4 == false) goto L119;
            super.onMeasure(r12, r13);
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
            if (OTabLayoutBase.access$1000(this.this$0) == ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().orientation) goto L62;
            return;
        L62:
            if (r7 > 0) goto L64;
            return;
        L64:
            int r11 = 0;
            int r14 = 0;
        L66:
            if (r11 >= r0) goto L71;
            View r15 = getChildAt(r11);
            if (r15.getVisibility() == 8) goto L70;
            r14 = r14 + r15.getMeasuredWidth();
        L70:
            r11 = r11 + 1;
            goto L66
        L71:
            if (r14 > 0) goto L73;
            return;
        L73:
            int r16 = getMeasuredWidth() - r9;
            if (r14 < r16) goto L76;
        L92:
            if (r5 == 0) goto L123;
            super.onMeasure(r12, r13);
            return;
        L123:
            return;
        L76:
            if ((r7 * r0) >= r16) goto L85;
            int r17 = 0;
            int r18 = 0;
        L78:
            if (r17 >= r0) goto L91;
            LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r17).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
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
            LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
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
            LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r5).getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
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
            super.onMeasure(r12, r13);
            return;
        L118:
            return;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
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
            int r1 = -1;
            if (r0 != null) goto L5;
        L11:
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
            ViewCompat.f(this);
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
            if (ViewCompat.i(this) != 1) goto L10;
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
            r3.setInterpolator(OTabLayoutBase.access$1100());
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
            View r13 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, DbHelper.COL_ID, "layout_tab_indicator"));
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
            if (ZeusTransformUtils.instanceOf(r2, TabView.class) == false) goto L30;
            float r8 = (this.mIndicatorLeft + this.mIndicatorRight) * 0.5f;
            r14 = r8 - (((TabView) ZeusTransformUtils.preCheckCast(r2, TabView.class, "com.obric.aiagent.plugin")).getContentWidth() * 0.5f);
            r6 = r8 + (((TabView) ZeusTransformUtils.preCheckCast(r2, TabView.class, "com.obric.aiagent.plugin")).getContentWidth() * 0.5f);
            goto L31
        }

        public void setSelectedTabHorizontalPadding(int r1) {
            this.mSelectedIndicatorPadding = r1;
        }
    }

    public class TabView extends OUILinearLayout implements com.obric.oui.material.g {
        private boolean isBackdropView;
        private com.obric.oui.material.c[] mAllMaterialConfigs;
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines;
        private boolean mEnableMaterial;
        private ImageView mIconView;
        private com.obric.oui.material.c[] mMaterialConfigs;
        private com.obric.common.oea.foundation.animation.manager.d mPressAnim;
        private com.obric.common.oea.foundation.animation.manager.d mReleaseAnim;
        private com.obric.oui.material.c[] mSelectedMaterialConfigs;
        private e mTab;
        private TextView mTextView;
        final /* synthetic */ OTabLayoutBase this$0;

        static /* synthetic */ void access$100(TabView r0, float r1) {
            r0.updateContentAlpha(r1);
        }

        public TabView(OTabLayoutBase r5, Context r6, boolean r7, com.obric.oui.material.c[] r8, com.obric.oui.material.c[] r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r5;
            super(r10);
            this.mDefaultMaxLines = 1;
            this.isBackdropView = true;
            setEnableShadowWidthRadius(true);
            setRadius((int) OTabLayoutBase.access$200(r5));
            setShadowCornerRadius((int) OTabLayoutBase.access$200(r5));
            ((com.obric.oui.common.style.c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), com.obric.oui.common.style.c.class, "com.obric.aiagent.plugin")).a((int) OTabLayoutBase.access$200(r5));
            this.mEnableMaterial = r7;
            updateMaterialConfigs(r8, r9);
            if (OTabLayoutBase.access$300(r5) == null) goto L6;
            setOverridePressColor(androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, "color", "oui_basic_fill_element_2")));
            refreshColors(OTabLayoutBase.TAG);
        L6:
            if (r5.mTabBackgroundResId == 0) goto L9;
            ViewCompat.a(this, androidx.appcompat.a.a.a.b(r10, r5.mTabBackgroundResId));
        L9:
            if (OTabLayoutBase.access$300(r5) == null) goto L11;
            boolean r11 = true;
        L12:
            setChangeAlphaWhenPress(r11);
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            ViewCompat.b(this, r5.mTabPaddingStart, r5.mTabPaddingTop, r5.mTabPaddingEnd, r5.mTabPaddingBottom);
            setMinimumWidth(r5.mTabMinWidth);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.a(this, w.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1002));
            if (this.mEnableMaterial == false) goto L16;
            updateMaterialBySelectedState(isSelected());
            return;
        L16:
            return;
        L11:
            r11 = false;
            goto L12
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

        public void updateMaterialConfigs(com.obric.oui.material.c[] r1, com.obric.oui.material.c[] r2) {
            this.mAllMaterialConfigs = r1;
            this.mSelectedMaterialConfigs = r2;
            this.mMaterialConfigs = r1;
        }

        public void updateMaterial(com.obric.oui.material.c[] r2) {
            if (this.mEnableMaterial == true) goto L6;
            return;
        L6:
            if (this.mMaterialConfigs == null) goto L9;
            this.mMaterialConfigs = r2;
            return;
        }

        private void updateMaterialBySelectedState(boolean r6) {
            j r1 = null;
            if (this.mEnableMaterial == true) goto L15;
            restoreDefaultBackground();
            if (r6 == true) goto L7;
        L12:
            clearTabShadow();
        L13:
            applyContentMaterial(false);
            return;
        L7:
            if (OTabLayoutBase.access$300(this.this$0) == null) goto L12;
            j r7 = (j) ZeusTransformUtils.preCheckCast(OTabLayoutBase.access$300(this.this$0).get(0), j.class, "com.obric.aiagent.plugin");
            if (OTabLayoutBase.access$300(this.this$0).size() <= 1) goto L11;
            r1 = (j) ZeusTransformUtils.preCheckCast(OTabLayoutBase.access$300(this.this$0).get(1), j.class, "com.obric.aiagent.plugin");
        L11:
            a(r7, r1);
            goto L13
        L15:
            if (r6 == false) goto L19;
            com.obric.oui.material.c[] r0 = this.mSelectedMaterialConfigs;
            if (r0 == null) goto L19;
        L20:
            this.mMaterialConfigs = r0;
            if (r0 == null) goto L30;
            applyMaterial();
            applyContentMaterial(true);
            if (r6 == true) goto L25;
            return;
        L25:
            if (OTabLayoutBase.access$300(this.this$0) == null) goto L33;
            j r8 = (j) ZeusTransformUtils.preCheckCast(OTabLayoutBase.access$300(this.this$0).get(0), j.class, "com.obric.aiagent.plugin");
            if (OTabLayoutBase.access$300(this.this$0).size() <= 1) goto L29;
            r1 = (j) ZeusTransformUtils.preCheckCast(OTabLayoutBase.access$300(this.this$0).get(1), j.class, "com.obric.aiagent.plugin");
        L29:
            a(r8, r1);
            return;
        L33:
            return;
        L30:
            restoreDefaultBackground();
            clearTabShadow();
            applyContentMaterial(false);
            return;
        L19:
            r0 = this.mAllMaterialConfigs;
            goto L20
        }

        private void applyMaterial() {
            if (this.mMaterialConfigs != null) goto L5;
            return;
        L5:
            int r0 = (int) com.obric.oui.common.util.g.a(99.0f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            setShadowCornerRadius(r0);
            setRadius(r0);
            if (OTabLayoutBase.access$300(this.this$0) == null) goto L8;
            ((com.obric.oui.common.style.c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), com.obric.oui.common.style.c.class, "com.obric.aiagent.plugin")).a(r0);
        L8:
            boolean r1 = this.isBackdropView;
            if (r1 == false) goto L11;
            int r3 = 2;
        L13:
            if (r1 == false) goto L15;
            k.a(this, this.mMaterialConfigs, false, r3, null);
        L17:
            if (currentMaterialHasShadow() == true) goto L19;
            clearTabShadow();
        L19:
            GradientDrawable r2 = new GradientDrawable();
            r2.setShape(0);
            r2.setCornerRadius(com.obric.oui.common.util.g.a(99.0f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
            r2.setColor(0);
            setBackground(r2);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            return;
        L15:
            k.a(this, this.mMaterialConfigs, false, null);
            goto L17
        L11:
            r3 = 3;
            goto L13
        }

        private boolean currentMaterialHasShadow() {
            com.obric.oui.material.c[] r0 = this.mMaterialConfigs;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.length == 0) goto L19;
            int r1 = l.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            int r2 = Math.max(0, Math.min(this.mMaterialConfigs.length - 1, r1 - 1));
            com.obric.oui.material.c r4 = this.mMaterialConfigs[r2];
            if (r4 != null) goto L10;
            return false;
        L10:
            if (r4.i() != null) goto L12;
            return false;
        L12:
            if (r4.i().length > 0) goto L14;
            return false;
        L14:
            return true;
        L19:
            return false;
        }

        private void clearTabShadow() {
            a(j.f34540b.j(), j.f34540b.j());
        }

        private void restoreDefaultBackground() {
            if (this.this$0.mTabBackgroundResId == 0) goto L5;
            ViewCompat.a(this, androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.this$0.mTabBackgroundResId));
        L6:
            setOutlineProvider(null);
            return;
        L5:
            setBackground(null);
            goto L6
        }

        @Override // com.obric.oui.material.g
        public void applyContentMaterial(boolean r4) {
            boolean r1 = true;
            if (this.isBackdropView == false) goto L11;
            if (this.mEnableMaterial == false) goto L8;
            if (r4 == false) goto L8;
        L9:
            l.a(this, r1);
            return;
        L8:
            r1 = false;
            goto L9
        L11:
            if (this.mEnableMaterial == false) goto L14;
            if (r4 == false) goto L14;
        L15:
            l.b(this, r1);
            return;
        L14:
            r1 = false;
            goto L15
        }

        @Override // com.obric.oui.material.g
        public void setBackdropTarget(View r2) {
            if (this.mEnableMaterial == true) goto L5;
            return;
        L5:
            l.a(this, r2);
        }

        @Override // com.obric.oui.material.g
        public void updateBackdropTargetType(boolean r2) {
            if (this.mEnableMaterial == true) goto L6;
            return;
        L6:
            if (this.isBackdropView == r2) goto L12;
            this.isBackdropView = r2;
            if (r2 == false) goto L10;
            l.b(this, 2);
            return;
        L10:
            l.b(this, 3);
            return;
        }

        @Override // com.obric.oui.material.g
        public void updateBackdropSrcType(int r2) {
            if (this.mEnableMaterial == true) goto L5;
            return;
        L5:
            l.b(this, r2);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r4) {
            boolean r0 = super.dispatchTouchEvent(r4);
            int r5 = r4.getActionMasked();
            if (r5 != 0) goto L5;
            doPressAnim(true, getCurrentShadows());
        L15:
            return r0;
        L5:
            if (r5 != 1) goto L7;
            doPressAnim(false, getCurrentShadows());
            goto L15
        L7:
            if (r5 != 3) goto L15;
            if (this.mEnableMaterial == false) goto L12;
            restorePressedStateForMaterial();
            goto L15
        L12:
            doPressAnim(false, getCurrentShadows());
            goto L15
        }

        private void doPressAnim(boolean r3, List<j> r4) {
            List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if (isEnabled() == true) goto L5;
            return;
        L5:
            if (OTabLayoutBase.access$300(this.this$0) == null) goto L22;
            com.obric.common.oea.foundation.animation.manager.d r0 = this.mPressAnim;
            if (r0 == null) goto L10;
            r0.a(false);
        L10:
            com.obric.common.oea.foundation.animation.manager.d r1 = this.mReleaseAnim;
            if (r1 == null) goto L13;
            r1.a(false);
        L13:
            if (r3 == false) goto L15;
            List<j> r6 = getCurrentShadows();
            this.mPressAnim = com.obric.oui.common.style.k.a(this, getScaleX(), 0.98f, r6, OTabLayoutBase.access$300(this.this$0));
            return;
        L15:
            if (r5 != null) goto L18;
            r5 = getCurrentShadows();
        L18:
            this.mReleaseAnim = com.obric.oui.common.style.k.a(this, getScaleX(), 1.0f, OTabLayoutBase.access$300(this.this$0), r5);
            return;
        }

        private void restorePressedStateForMaterial() {
            com.obric.common.oea.foundation.animation.manager.d r0 = this.mPressAnim;
            if (r0 == null) goto L5;
            r0.a(false);
        L5:
            com.obric.common.oea.foundation.animation.manager.d r1 = this.mReleaseAnim;
            if (r1 == null) goto L8;
            r1.a(false);
        L8:
            setScaleX(1.0f);
            setScaleY(1.0f);
            updateMaterialBySelectedState(isSelected());
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.mTab == null) goto L12;
            if (r0 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.access$400(this.this$0) == null) goto L9;
            OTabLayoutBase.access$400(this.this$0).a(this.mTab);
        L10:
            com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
            return true;
        L9:
            this.mTab.e();
            goto L10
        L12:
            return r0;
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setSelected(boolean r4) {
            if (isSelected() == r4) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r4);
            updateMaterialBySelectedState(r4);
            if (r0 == false) goto L12;
            if (r4 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            if (r4 == true) goto L17;
            if (OTabLayoutBase.access$300(this.this$0) == null) goto L17;
            restorePressedStateForMaterial();
        L17:
            if (this.mTextView == null) goto L29;
            if (r4 == true) goto L20;
        L22:
            this.mTextView.setTextSize(0, this.this$0.mTabTextSize);
        L23:
            TextView r1 = this.mTextView;
            OTabLayoutBase r3 = this.this$0;
            if (r4 == false) goto L26;
            Typeface r5 = OTabLayoutBase.access$600(r3, OTabLayoutBase.access$500(r3), 500);
        L27:
            r1.setTypeface(r5);
            return;
        L26:
            r5 = OTabLayoutBase.access$500(r3);
            goto L27
        L20:
            if (this.this$0.mTabSelectedTextSize <= 0.0f) goto L22;
            this.mTextView.setTextSize(0, this.this$0.mTabSelectedTextSize);
            goto L23
        L29:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ActionBar.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ActionBar.c.class.getName());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r0 = View.MeasureSpec.getSize(r11);
            int r1 = View.MeasureSpec.getMode(r11);
            int r2 = this.this$0.getTabMaxWidth();
            LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.mTextView.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.this$0.mTabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.mTextView == null) goto L37;
            ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
            float r4 = this.this$0.mTabTextSize;
            int r5 = this.mDefaultMaxLines;
            int r6 = OTabLayoutBase.access$700(this.this$0);
            int r7 = OTabLayoutBase.access$800(this.this$0);
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
            int r14 = TextViewCompat.a(this.mTextView);
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

        void setTab(e r2) {
            if (r2 == this.mTab) goto L6;
            this.mTab = r2;
            update();
            return;
        }

        void setTab(e r2, boolean r3) {
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
            e r0 = this.mTab;
            if (r0 == null) goto L5;
            View r2 = r0.a();
        L6:
            boolean r3 = true;
            if (r2 == null) goto L29;
            ViewParent r5 = r2.getParent();
            if (r5 == this) goto L13;
            if (r5 == null) goto L12;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r2);
        L12:
            addView(r2);
        L13:
            this.mCustomView = r2;
            TextView r6 = this.mTextView;
            if (r6 == null) goto L16;
            r6.setVisibility(8);
        L16:
            ImageView r7 = this.mIconView;
            if (r7 == null) goto L19;
            r7.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L19:
            TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
            this.mCustomTextView = r1;
            if (r1 == null) goto L26;
            r1.setDuplicateParentStateEnabled(true);
            this.mDefaultMaxLines = TextViewCompat.a(this.mCustomTextView);
            if (OTabLayoutBase.access$500(this.this$0) != null) goto L26;
            if (this.mTextView == null) goto L26;
            OTabLayoutBase.access$502(this.this$0, this.mCustomTextView.getTypeface());
        L26:
            ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r2.findViewById(android.R.id.icon), ImageView.class, "com.obric.aiagent.plugin");
            this.mCustomIconView = r4;
            if (r4 == null) goto L34;
            r4.setDuplicateParentStateEnabled(true);
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
            if (isEnabled() == false) goto L62;
            float r9 = 1.0f;
        L63:
            updateContentAlpha(r9);
            return;
        L62:
            r9 = OTabLayoutBase.access$900(this.this$0);
            goto L63
        L56:
            if (r0.f() == false) goto L58;
        L52:
            if (this.mCustomIconView == null) goto L54;
        L36:
            if (this.mIconView != null) goto L39;
            ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_icon, "layout", "design_layout_tab_icon"), this, false, "com.obric.aiagent.plugin"), ImageView.class, "com.obric.aiagent.plugin");
            addView(r10, 0);
            this.mIconView = r10;
            r10.setDuplicateParentStateEnabled(true);
        L39:
            if (this.mTextView != null) goto L45;
            TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.design_layout_tab_text, "layout", "design_layout_tab_text"), this, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin");
            addView(r11, new LinearLayout.LayoutParams(-1, -2));
            this.mTextView = r11;
            r11.setMaxLines(1);
            this.mTextView.setDuplicateParentStateEnabled(true);
            this.mDefaultMaxLines = TextViewCompat.a(this.mTextView);
            if (OTabLayoutBase.access$500(this.this$0) != null) goto L45;
            TextView r12 = this.mTextView;
            if (r12 == null) goto L45;
            OTabLayoutBase.access$502(this.this$0, r12.getTypeface());
        L45:
            this.mTextView.setAllCaps(false);
            if (this.this$0.mTabTextColors == null) goto L48;
            this.mTextView.setTextColor(this.this$0.mTabTextColors);
        L48:
            updateTextAndIcon(this.mTextView, this.mIconView);
            goto L54
        L29:
            View r13 = this.mCustomView;
            if (r13 == null) goto L32;
            removeView(r13);
            this.mCustomView = null;
        L32:
            this.mCustomTextView = null;
            this.mCustomIconView = null;
            goto L34
        L5:
            r2 = null;
            goto L6
        }

        private void updateContentAlpha(float r2) {
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            TextView r0 = this.mTextView;
            if (r0 == null) goto L5;
            r0.setAlpha(r2);
        L5:
            ImageView r1 = this.mIconView;
            if (r1 == null) goto L8;
            r1.setAlpha(r2);
        L8:
            TextView r3 = this.mCustomTextView;
            if (r3 == null) goto L11;
            r3.setAlpha(r2);
        L11:
            ImageView r4 = this.mCustomIconView;
            if (r4 == null) goto L14;
            r4.setAlpha(r2);
        L14:
            View r5 = this.mCustomView;
            if (r5 == null) goto L18;
            r5.setAlpha(r2);
            return;
        }

        private void updateTextAndIcon(TextView r8, ImageView r9) {
            e r0 = this.mTab;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            Drawable r2 = r0.b();
        L6:
            e r3 = this.mTab;
            if (r3 == null) goto L9;
            CharSequence r4 = r3.d();
        L10:
            e r5 = this.mTab;
            if (r5 == null) goto L13;
            CharSequence r6 = r5.g();
        L14:
            int r7 = 0;
            if (r9 == null) goto L20;
            if (r2 == null) goto L18;
            r9.setImageDrawable(r2);
            r9.setVisibility(0);
            setVisibility(0);
        L19:
            r9.setContentDescription(r6);
            goto L20
        L18:
            r9.setVisibility(8);
            r9.setImageDrawable(null);
        L20:
            boolean r10 = !TextUtils.isEmpty(r4);
            if (r8 == null) goto L26;
            if (r10 == false) goto L24;
            r8.setText(r4);
            r8.setVisibility(0);
            setVisibility(0);
        L25:
            r8.setContentDescription(r6);
            goto L26
        L24:
            r8.setVisibility(8);
            r8.setText(null);
        L26:
            if (r9 == null) goto L35;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
            if (r10 == false) goto L33;
            if (r9.getVisibility() != 0) goto L33;
            r7 = this.this$0.dpToPx(8);
        L33:
            if (r7 == r11.bottomMargin) goto L35;
            r11.bottomMargin = r7;
            r9.requestLayout();
        L35:
            if (r10 == true) goto L38;
            r1 = r6;
        L38:
            aa.a(this, r1);
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

        public e getTab() {
            return this.mTab;
        }

        public TextView getTextView() {
            return this.mTextView;
        }

        public int getContentWidth() {
            TextView r0 = this.mTextView;
            boolean r1 = true;
            boolean r2 = false;
            if (r0 != null) goto L5;
        L7:
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
            if (r1 == false) goto L26;
            r3 = Math.min(r3, this.mCustomView.getLeft());
        L27:
            int r7 = this.mCustomView.getRight();
            if (r1 == false) goto L30;
            r7 = Math.max(r4, r7);
        L30:
            r4 = r7;
            goto L32
        L26:
            r3 = this.mCustomView.getLeft();
        L32:
            return r4 - r3;
        L11:
            if (r5.getVisibility() != 0) goto L19;
            if (r2 == false) goto L14;
            r3 = Math.min(r3, this.mIconView.getLeft());
        L15:
            if (r2 == false) goto L17;
            int r8 = Math.max(r4, this.mIconView.getRight());
        L18:
            r4 = r8;
            goto L20
        L17:
            r8 = this.mIconView.getRight();
            goto L18
        L14:
            r3 = this.mIconView.getLeft();
            goto L15
        L5:
            if (r0.getVisibility() != 0) goto L7;
            int r9 = this.mTextView.getLeft();
            r4 = this.mTextView.getRight();
            r3 = r9;
            r2 = true;
            goto L8
        }

        private float approximateLineWidth(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r1) {
            super.setEnabled(r1);
            if (r1 == false) goto L5;
            float r2 = 1.0f;
        L6:
            updateContentAlpha(r2);
            return;
        L5:
            r2 = OTabLayoutBase.access$900(this.this$0);
            goto L6
        }
    }

    private class a implements ViewPager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f36299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f36300b;

        a(OTabLayoutBase r1) {
            this.f36299a = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void onAdapterChanged(ViewPager r1, androidx.viewpager.widget.a r2, androidx.viewpager.widget.a r3) {
            if (this.f36299a.mViewPager != r1) goto L6;
            this.f36299a.setPagerAdapter(r3, this.f36300b);
            return;
        }

        void a(boolean r1) {
            this.f36300b = r1;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f36301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f36302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f36303c;

        public b(OTabLayoutBase r1) {
            this.f36303c = r1;
            this.f36301a = 0.0f;
            this.f36302b = 0.0f;
        }

        public String toString() {
            return "(left = " + this.f36301a + ", right = " + this.f36302b + ")";
        }
    }

    public interface c {
        void a(e r1);
    }

    public interface d {
        void a(e r1);

        void b(e r1);

        void c(e r1);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OTabLayoutBase f36304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TabView f36305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f36306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Drawable f36307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f36308e;
        private CharSequence f;
        private int g;
        private View h;

        e() {
            this.g = -1;
        }

        public View a() {
            return this.h;
        }

        public e a(View r1) {
            this.h = r1;
            i();
            return this;
        }

        public e a(int r5) {
            return a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36305b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r5, this.f36305b, false, "com.obric.aiagent.plugin"));
        }

        public Drawable b() {
            return this.f36307d;
        }

        public int c() {
            return this.g;
        }

        void b(int r1) {
            this.g = r1;
        }

        public CharSequence d() {
            return this.f36308e;
        }

        public e a(Drawable r1) {
            this.f36307d = r1;
            i();
            return this;
        }

        public e a(CharSequence r3) {
            this.f36308e = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            i();
            return this;
        }

        public void e() {
            OTabLayoutBase r0 = this.f36304a;
            if (r0 == null) goto L7;
            r0.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean f() {
            OTabLayoutBase r0 = this.f36304a;
            if (r0 == null) goto L10;
            if (r0.getSelectedTabPosition() != this.g) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public e b(CharSequence r3) {
            this.f = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            i();
            return this;
        }

        public CharSequence g() {
            return this.f;
        }

        public TabView h() {
            return this.f36305b;
        }

        void i() {
            TabView r0 = this.f36305b;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        void a(boolean r1) {
            this.f36305b.applyContentMaterial(r1);
        }

        void b(View r1) {
            this.f36305b.setBackdropTarget(r1);
        }

        void b(boolean r1) {
            this.f36305b.updateBackdropTargetType(r1);
        }

        void c(int r1) {
            this.f36305b.updateBackdropSrcType(r1);
        }

        void j() {
            this.f36304a = null;
            this.f36305b = null;
            this.f36306c = null;
            this.f36307d = null;
            this.f36308e = null;
            this.f = null;
            this.g = -1;
            this.h = null;
        }
    }

    public static class f implements ViewPager.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<OTabLayoutBase> f36309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36313e;
        private ArgbEvaluator f;
        private AccelerateInterpolator g;
        private DecelerateInterpolator h;

        public f(OTabLayoutBase r4) {
            this.f = new ArgbEvaluator();
            this.g = new AccelerateInterpolator();
            this.h = new DecelerateInterpolator(1.6f);
            this.f36309a = new WeakReference(r4);
            this.f36313e = r4.getTabTextColors().getColorForState(OTabLayoutBase.access$1200(), 0);
            this.f36312d = r4.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int r2) {
            this.f36310b = this.f36311c;
            this.f36311c = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int r12, float r13, int r14) {
            OTabLayoutBase r15 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.f36309a.get(), OTabLayoutBase.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L34;
            int r0 = this.f36311c;
            if (r0 == 2) goto L7;
        L10:
            boolean r5 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L17:
            r15.setScrollPosition(r12, r13, r5, r1);
            if (this.f36311c == 2) goto L20;
        L22:
            OTabLayoutBase.access$1300(r15).mIsDragged = true;
            View r16 = OTabLayoutBase.access$1300(r15).getChildAt(OTabLayoutBase.access$1300(r15).mSelectedPosition);
            View r2 = OTabLayoutBase.access$1300(r15).getChildAt(OTabLayoutBase.access$1300(r15).mSelectedPosition + 1);
            if (r16 == null) goto L30;
            if (r2 == null) goto L30;
            View r3 = r16.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, DbHelper.COL_ID, "layout_tab_indicator"));
            View r6 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.layout_tab_indicator, DbHelper.COL_ID, "layout_tab_indicator"));
            if (r3 == null) goto L32;
            if (r6 == null) goto L32;
            float r17 = r16.getLeft() + ((r16.getWidth() - r3.getWidth()) / 2);
            float r7 = r3.getWidth() + r17;
            float r4 = r2.getLeft() + ((r2.getWidth() - r6.getWidth()) / 2);
            float r8 = r6.getWidth() + r4;
            ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_img, DbHelper.COL_ID, "tab_item_img")), ImageView.class, "com.obric.aiagent.plugin");
            TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_text, DbHelper.COL_ID, "tab_item_text")), TextView.class, "com.obric.aiagent.plugin");
            ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_img, DbHelper.COL_ID, "tab_item_img")), ImageView.class, "com.obric.aiagent.plugin");
            TextView r18 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tab_item_text, DbHelper.COL_ID, "tab_item_text")), TextView.class, "com.obric.aiagent.plugin");
            a(r9, r10, ((Integer) ZeusTransformUtils.preCheckCast(this.f.evaluate(r13, Integer.valueOf(this.f36313e), Integer.valueOf(this.f36312d)), Integer.class, "com.obric.aiagent.plugin")).intValue());
            a(r11, r18, ((Integer) ZeusTransformUtils.preCheckCast(this.f.evaluate(r13, Integer.valueOf(this.f36312d), Integer.valueOf(this.f36313e)), Integer.class, "com.obric.aiagent.plugin")).intValue());
            SlidingTabStrip.access$1402(OTabLayoutBase.access$1300(r15), r17 + ((r4 - r17) * this.g.getInterpolation(r13)));
            SlidingTabStrip.access$1502(OTabLayoutBase.access$1300(r15), r7 + ((r8 - r7) * this.g.getInterpolation(r13)));
        L32:
            ViewCompat.f(OTabLayoutBase.access$1300(r15));
            return;
        L30:
            if (OTabLayoutBase.access$1600(r15) == false) goto L32;
            OTabLayoutBase.access$1300(r15).mIsDragged = false;
            goto L32
        L20:
            if (this.f36310b != 0) goto L22;
            OTabLayoutBase.access$1300(r15).mIsDragged = false;
            goto L32
        L13:
            if (this.f36310b != 0) goto L16;
            r1 = false;
            goto L17
        L7:
            if (this.f36310b == 1) goto L10;
            r5 = false;
            goto L11
        }

        private void a(ImageView r1, TextView r2, int r3) {
            if (r1 == null) goto L7;
            if (r2 == null) goto L8;
            r2.setTextColor(r3);
            r1.setImageAlpha(Color.alpha(r3));
            return;
        L8:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.f36309a.get(), OTabLayoutBase.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.f36311c;
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
            if (this.f36310b != 0) goto L15;
        }

        void a() {
            this.f36310b = 0;
            this.f36311c = 0;
        }
    }

    public static class g implements ViewPager.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f36314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<OTabLayoutBase> f36315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36317d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36318e;

        public static /* synthetic */ void lambda$LZzZA7wW_CEfJGLNbODC5YjWKw4(g r0, int r1, int r2, OTabLayoutBase r3, boolean r4, boolean r5, ValueAnimator r6) {
            r0.a(r1, r2, r3, r4, r5, r6);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int r2) {
            this.f36316c = this.f36317d;
            this.f36317d = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(final int r11, float r12, int r13) {
            final OTabLayoutBase r14 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.f36315b.get(), OTabLayoutBase.class, "com.obric.aiagent.plugin");
            if (this.f36318e != r11) goto L5;
            return;
        L5:
            if (r14 == null) goto L21;
            int r15 = this.f36317d;
            if (r15 == 2) goto L9;
        L12:
            boolean r7 = true;
        L13:
            if (r15 == 2) goto L15;
        L18:
            boolean r16 = true;
        L19:
            ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            final int r2 = this.f36318e;
            final boolean r5 = r7;
            final boolean r6 = r16;
            r8.addUpdateListener(new $$Lambda$OTabLayoutBase$g$LZzZA7wW_CEfJGLNbODC5YjWKw4(this, r2, r11, r14, r5, r6));
            this.f36318e = r11;
            final boolean r4 = r7;
            final boolean r9 = r16;
            r8.addListener(new OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent$1(this, r14, r11, r4, r9));
            r8.start();
            return;
        L15:
            if (this.f36316c != 0) goto L18;
            r16 = false;
            goto L19
        L9:
            if (this.f36316c == 1) goto L12;
            r7 = false;
            goto L13
        }

        private /* synthetic */ void a(int r3, int r4, OTabLayoutBase r5, boolean r6, boolean r7, ValueAnimator r8) {
            float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8.getAnimatedValue(), Float.class, "com.obric.aiagent.plugin")).floatValue();
            if (r3 < r4) goto L5;
        L7:
            r9 = 1.0f - r9;
        L8:
            r5.setScrollPosition(r4, r9, r6, r7);
            return;
        L5:
            if (this.f36314a == true) goto L7;
            r4 = r4 - 1;
            goto L8
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = (OTabLayoutBase) ZeusTransformUtils.preCheckCast(this.f36315b.get(), OTabLayoutBase.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.f36317d;
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
            if (this.f36316c != 0) goto L15;
        }
    }

    public static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f36319a;

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(e r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(e r1) {
        }

        public h(ViewPager r1) {
            this.f36319a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(e r1) {
            this.f36319a.setCurrentItem(r1.c());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ int access$002(OTabLayoutBase r0, int r1) {
        r0.mPressedTabPosition = r1;
        return r1;
    }

    static /* synthetic */ int access$1000(OTabLayoutBase r0) {
        return r0.mOriginalScreenOrientation;
    }

    static /* synthetic */ Interpolator access$1100() {
        return FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    static /* synthetic */ int[] access$1200() {
        return SELECTED_STATE_SET;
    }

    static /* synthetic */ SlidingTabStrip access$1300(OTabLayoutBase r0) {
        return r0.mTabStrip;
    }

    static /* synthetic */ boolean access$1600(OTabLayoutBase r0) {
        return r0.mTabScrollAnimFix;
    }

    static /* synthetic */ float access$200(OTabLayoutBase r0) {
        return r0.mIndicatorCornerRadius;
    }

    static /* synthetic */ List access$300(OTabLayoutBase r0) {
        return r0.mTabPressedShadows;
    }

    static /* synthetic */ c access$400(OTabLayoutBase r0) {
        return r0.onTabClickListener;
    }

    static /* synthetic */ Typeface access$500(OTabLayoutBase r0) {
        return r0.DEFAULT_TAB_TYPE_FACE;
    }

    static /* synthetic */ Typeface access$502(OTabLayoutBase r0, Typeface r1) {
        r0.DEFAULT_TAB_TYPE_FACE = r1;
        return r1;
    }

    static /* synthetic */ Typeface access$600(OTabLayoutBase r0, Typeface r1, int r2) {
        return r0.getSelectedTypeFace(r1, r2);
    }

    static /* synthetic */ int access$700(OTabLayoutBase r0) {
        return r0.mTabTopMargin;
    }

    static /* synthetic */ int access$800(OTabLayoutBase r0) {
        return r0.mTabSideMargin;
    }

    static /* synthetic */ float access$900(OTabLayoutBase r0) {
        return r0.mTabDisabledAlpha;
    }

    static {
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        SYNCHRONIZED_TAB_POOL = new androidx.core.util.f.c(16);
        APPCOMPAT_CHECK_ATTRS = new int[]{ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary")};
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.getAnimatedValue(), b.class, "com.obric.aiagent.plugin");
        Rect r0 = this.mIndicatorRect;
        r0.left = (int) r4.f36301a;
        Rect r1 = this.mIndicatorRect;
        r1.right = (int) r4.f36302b;
        invalidate();
    }

    public void setAutoFillWhenScrollable(boolean r1) {
        this.isAutoFillWhenScrollable = r1;
    }

    public void setTabMargin(int r6) {
        this.mTabMargin = dpToPx(r6);
        int r0 = 0;
    L4:
        if (r0 >= getTabCount()) goto L6;
        View r1 = this.mTabStrip.getChildAt(r0);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.leftMargin = dpToPx(r6);
        r2.rightMargin = dpToPx(r6);
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

    public void setOnTabClickListener(c r3) {
        this.onTabClickListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public OTabLayoutBase(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OTabLayoutBase(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OTabLayoutBase(Context r21, AttributeSet r22, int r23) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r2, r4, r23);
        this.mTabs = new ArrayList();
        this.isSysSupportMaterial = false;
        this.mBackdropTargetWk = null;
        this.mTabDisabledAlpha = 0.3f;
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
        Paint r7 = new Paint(1);
        this.barPaint = r7;
        this.barShadowPaint = new Paint(1);
        Paint r9 = new Paint(1);
        this.barStrokePaint = r9;
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
        com.obric.oui.tab.a r10 = new com.obric.oui.tab.a();
        this.mEdgeFadeHelper = r10;
        this.mInterpolator = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mRadiusArr = new float[8];
        b r11 = new b(this);
        this.mCurrentP = r11;
        b r12 = new b(this);
        this.mLastP = r12;
        this.mPressedTabPosition = -1;
        this.mIsInLargeFont = false;
        this.mTabViewPool = new androidx.core.util.f.b(12);
        this.DEFAULT_TAB_TYPE_FACE = null;
        this.SELECTED_TAB_TYPE_FACE = null;
        this.mIsInLargeFont = com.obric.oui.d.h.a(ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin").getConfiguration().fontScale);
        if (l.a(r2) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        this.isSysSupportMaterial = r6;
        this.enableMaterial = r6;
        setHorizontalScrollBarEnabled(false);
        SlidingTabStrip r8 = new SlidingTabStrip(this, r2);
        this.mTabStrip = r8;
        r8.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r13 = r2.obtainStyledAttributes(r4, R.styleable.TabLayout, r23, ZeusTransformUtils.mapRes(R.style.OTabText, "style", "OTabText"));
        r8.setSelectedIndicatorHeight(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorHeight, "styleable", "TabLayout_tabIndicatorHeight"), 0));
        r8.setSelectedIndicatorColor(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabIndicatorColor, "styleable", "TabLayout_tabIndicatorColor"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_7, "color", "oui_accent_7"))));
        this.mTabMinWidth = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), dpToPx(56));
        int r5 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPadding, "styleable", "TabLayout_tabPadding"), 0);
        this.mTabPaddingStart = r5;
        this.mTabPaddingTop = r5;
        this.mTabPaddingEnd = r5;
        this.mTabPaddingBottom = r5;
        this.mTabPaddingStart = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingStart, "styleable", "TabLayout_tabPaddingStart"), this.mTabPaddingStart);
        this.mTabPaddingTop = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingTop, "styleable", "TabLayout_tabPaddingTop"), this.mTabPaddingTop);
        this.mTabPaddingEnd = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingEnd, "styleable", "TabLayout_tabPaddingEnd"), this.mTabPaddingEnd);
        this.mTabPaddingBottom = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabPaddingBottom, "styleable", "TabLayout_tabPaddingBottom"), this.mTabPaddingBottom);
        int r14 = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextAppearance, "styleable", "TabLayout_tabTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_Tab, "style", "TextAppearance_Design_Tab"));
        this.mTabTextAppearance = r14;
        int r15 = this.mTabPaddingStart;
        if (r15 > 0) goto L11;
    L13:
        int r16 = this.mTabPaddingEnd;
        if (r16 > 0) goto L16;
    L18:
        TypedArray r17 = r2.obtainStyledAttributes(r14, R.styleable.TextAppearance);
        this.mTabTextSize = r17.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);     // Catch: Throwable -> L109
        this.mTabTextColors = r17.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));     // Catch: Throwable -> L109
        r17.recycle();
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor")) == false) goto L23;
        this.mTabTextColors = r13.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabTextColor, "styleable", "TabLayout_tabTextColor"));
    L23:
        boolean r18 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"));
        if (r18 == false) goto L26;
        int r19 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabSelectedTextColor, "styleable", "TabLayout_tabSelectedTextColor"), 0);
    L27:
        this.mRequestedTabMinWidth = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMinWidth, "styleable", "TabLayout_tabMinWidth"), -1);
        int r20 = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMaxWidth, "styleable", "TabLayout_tabMaxWidth"), -1);
        this.mRequestedTabMaxWidth = r20;
        if (r20 <= 0) goto L30;
        this.mTabMaxWidthInGravityCenter = r20;
    L30:
        this.mTabBackgroundResId = r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabBackground, "styleable", "TabLayout_tabBackground"), 0);
        this.mContentInsetStart = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabContentStart, "styleable", "TabLayout_tabContentStart"), 0);
        this.mMode = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabMode, "styleable", "TabLayout_tabMode"), 1);
        this.mTabGravity = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.TabLayout_tabGravity, "styleable", "TabLayout_tabGravity"), 1);
        TypedArray r1 = r2.obtainStyledAttributes(r4, new int[]{android.R.attr.minHeight}, r23, 0);
        int r24 = r1.getDimensionPixelSize(0, 0);
        if (r24 <= 0) goto L33;
        setMinimumHeight(r24);
    L33:
        r1.recycle();
        TypedArray r3 = r2.obtainStyledAttributes(r4, R.styleable.OTabLayoutSupple);
        r8.setSelectedIndicatorFullWidth(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabIndicatorFullWidth, "styleable", "OTabLayoutSupple_oui_tabIndicatorFullWidth"), true));     // Catch: Throwable -> L106
        r8.setShowBottomLine(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showBottomLine, "styleable", "OTabLayoutSupple_oui_showBottomLine"), false));     // Catch: Throwable -> L106
        r8.setShowTopLine(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showTopLine, "styleable", "OTabLayoutSupple_oui_showTopLine"), false));     // Catch: Throwable -> L106
        r8.setShowSelectedIndicator(r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_showSelectedIndicator, "styleable", "OTabLayoutSupple_oui_showSelectedIndicator"), true));     // Catch: Throwable -> L106
        this.mTabSelectedTextSize = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabSelectedTextSize, "styleable", "OTabLayoutSupple_oui_tabSelectedTextSize"), 0);     // Catch: Throwable -> L106
        this.mTabTextSize = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tabTextSize, "styleable", "OTabLayoutSupple_oui_tabTextSize"), (int) this.mTabTextSize);     // Catch: Throwable -> L106
        this.mTabShadowStyle = r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetShadow, "styleable", "OTabLayoutSupple_oui_widgetShadow"), ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular"));     // Catch: Throwable -> L106
        if (this.enableMaterial == false) goto L37;
        this.enableMaterial = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetEnableMaterial, "styleable", "OTabLayoutSupple_oui_widgetEnableMaterial"), true);     // Catch: Throwable -> L106
    L37:
        int r25 = r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_tab_spec, "styleable", "OTabLayoutSupple_oui_tab_spec"), -1);     // Catch: Throwable -> L106
        if (r25 != 0) goto L40;
    L45:
        int r26 = dpToPx(4);     // Catch: Throwable -> L106
        setTabStripPadding(r26, r26, r26, r26);     // Catch: Throwable -> L106
        this.tabSpacing = dpToPx(4);     // Catch: Throwable -> L106
    L46:
        String r27 = r3.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayoutSupple_oui_widgetMaterial, "styleable", "OTabLayoutSupple_oui_widgetMaterial"));     // Catch: Throwable -> L106
        if (r27 != null) goto L50;
        r27 = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));     // Catch: Throwable -> L106
    L50:
        r3.recycle();
        String r110 = r27;
        this.mScrollableTabMinWidth = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_tab_scrollable_min_width, "dimen", "design_tab_scrollable_min_width"));
        this.mIndicatorCornerX = com.obric.oui.common.util.g.a(1.5f, r2);
        this.mIndicatorCornerY = com.obric.oui.common.util.g.a(1.5f, r2);
        this.mOriginalScreenOrientation = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().orientation;
        r13.recycle();
        TypedArray r28 = r2.obtainStyledAttributes(r4, R.styleable.OTabLayout);
        Drawable r29 = r28.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_divider, "styleable", "OTabLayout_tab_divider"));     // Catch: Throwable -> L103
        if (r29 == null) goto L54;
        r8.setDividerDrawable(r29);     // Catch: Throwable -> L103
        r8.setShowDividers(2);     // Catch: Throwable -> L103
    L54:
        this.mIndicatorColor = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), 0);     // Catch: Throwable -> L103
        this.mIndicatorUnSelectedColor = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_unselected_color, "styleable", "OTabLayout_indicator_unselected_color"), 0);     // Catch: Throwable -> L103
        this.mIndicatorBackground = r28.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_background, "styleable", "OTabLayout_indicator_background"));     // Catch: Throwable -> L103
        this.mIndicatorHeight = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f);     // Catch: Throwable -> L103
        this.mIndicatorCornerRadius = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f);     // Catch: Throwable -> L103
        if (ZeusTransformUtils.instanceOf(this.mIndicatorBackground, GradientDrawable.class) == false) goto L57;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.mIndicatorBackground, GradientDrawable.class, "com.obric.aiagent.plugin")).setCornerRadius(this.mIndicatorCornerRadius);     // Catch: Throwable -> L103
    L57:
        this.indicatorSpacing = r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), dpToPx(4));     // Catch: Throwable -> L103
        int r30 = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);     // Catch: Throwable -> L103
        this.mBarColor = r30;     // Catch: Throwable -> L103
        if (r30 != 0) goto L60;
        setTabStripPadding(0, 0, 0, 0);     // Catch: Throwable -> L103
    L60:
        this.isIndicatorAnimEnable = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false);     // Catch: Throwable -> L103
        this.isIndicatorBounceEnable = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);     // Catch: Throwable -> L103
        r10.a(r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_edgeFadeEnabled, "styleable", "OTabLayout_tab_edgeFadeEnabled"), false));     // Catch: Throwable -> L103
        r10.a(r28.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_edgeFadeLength, "styleable", "OTabLayout_tab_edgeFadeLength"), dpToPxFloat(20.0f)));     // Catch: Throwable -> L103
        this.mTabDisabledAlpha = clampAlpha(r28.getFloat(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_alpha_disabled, "styleable", "OTabLayout_oui_alpha_disabled"), this.mTabDisabledAlpha));     // Catch: Throwable -> L103
        this.tabTextSelectedStyle = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textSelectedStyle, "styleable", "OTabLayout_tab_textSelectedStyle"), 0);     // Catch: Throwable -> L103
        this.tabTextStyle = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textStyle, "styleable", "OTabLayout_tab_textStyle"), 0);     // Catch: Throwable -> L103
        this.mTabPressedTextColor = r28.getColor(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_textPressedColor, "styleable", "OTabLayout_tab_textPressedColor"), 0);     // Catch: Throwable -> L103
        if (this.isSysSupportMaterial == false) goto L64;
        this.isTabEnableMaterial = r28.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_enableMaterial, "styleable", "OTabLayout_tab_enableMaterial"), false);     // Catch: Throwable -> L103
    L64:
        if (this.isTabEnableMaterial == false) goto L79;
        this.mTabMaterialToken = r28.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_material, "styleable", "OTabLayout_tab_material"));     // Catch: Throwable -> L103
        this.mTabMaterialSelectedToken = r28.getString(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_tab_material_selected, "styleable", "OTabLayout_tab_material_selected"));     // Catch: Throwable -> L103
        if (TextUtils.isEmpty(this.mTabMaterialToken) == false) goto L68;
        this.mTabMaterialToken = r2.getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));     // Catch: Throwable -> L103
    L68:
        String r31 = this.mTabMaterialToken;     // Catch: Throwable -> L103
        if (isDarkTheme() == true) goto L71;
        boolean r32 = true;
    L72:
        this.mTabMaterialConfigs = MaterialToken.parseSet(r31, r32);     // Catch: Throwable -> L103
        if (TextUtils.isEmpty(this.mTabMaterialSelectedToken) == true) goto L79;
        String r33 = this.mTabMaterialSelectedToken;     // Catch: Throwable -> L103
        if (isDarkTheme() == true) goto L77;
        boolean r34 = true;
    L78:
        this.mTabMaterialSelectedConfigs = MaterialToken.parseSet(r33, r34);     // Catch: Throwable -> L103
        goto L79
    L77:
        r34 = false;
        goto L78
    L71:
        r32 = false;
    L79:
        int r35 = r28.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_shadow_pressed, "styleable", "OTabLayout_shadow_pressed"), 0);     // Catch: Throwable -> L103
        if (r35 == 0) goto L82;
        List<j> r36 = com.obric.oui.common.style.f.a(r2, r35);     // Catch: Throwable -> L103
        ArrayList r37 = new ArrayList(2);     // Catch: Throwable -> L103
        this.mTabPressedShadows = r37;     // Catch: Throwable -> L103
        r37.add((j) ZeusTransformUtils.preCheckCast(r36.get(0), j.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
        this.mTabPressedShadows.add((j) ZeusTransformUtils.preCheckCast(r36.get(1), j.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
    L82:
        r28.recycle();
        if (r18 == true) goto L85;
    L88:
        ValueAnimator r38 = ValueAnimator.ofObject(new PointEvaluator(this), new Object[]{r12, r11});
        this.mValueAnimator = r38;
        r38.addUpdateListener(this);
        r7.setStyle(Paint.Style.FILL);
        r9.setStyle(Paint.Style.STROKE);
        r9.setColor(0);
        float r39 = this.mIndicatorCornerRadius + (this.indicatorSpacing / 2.0f);
        if (this.enableMaterial == false) goto L101;
        this.mBackdropTargetWk = new WeakReference(this);
        com.obric.oui.material.c[] r40 = MaterialToken.parseSet(r110, !isDarkTheme());
        if (r40 == null) goto L101;
        l.a(this, 2, r40, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density);
        GradientDrawable r41 = new GradientDrawable();
        r41.setShape(0);
        r41.setCornerRadius(r39);
        r41.setColor(0);
        setBackground(r41);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        if (ZeusTransformUtils.instanceOf(this.mIndicatorBackground, GradientDrawable.class) == false) goto L95;
        char r42 = 0;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.mIndicatorBackground, GradientDrawable.class, "com.obric.aiagent.plugin")).setColor(0);
    L97:
        if (l.b(r2) != 1) goto L101;
        com.obric.oui.material.c r43 = r40[r42];
        if (r43.e() == null) goto L101;
        r9.setColor(r43.e().b());
        r9.setStrokeWidth(dpToPx((int) r43.e().a()));
        goto L101
    L95:
        r42 = 0;
    L101:
        updateShadow();
        applyModeAndGravity();
        return;
    L85:
        if (this.mTabPressedTextColor == 0) goto L87;
        this.mTabTextColors = createPressedOverlayColorStateList(this.mTabTextColors.getDefaultColor(), r19, this.mTabPressedTextColor);
        goto L88
    L87:
        this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), r19);
    L103:
        th = move-exception;
        r28.recycle();
        throw th;
    L40:
        if (r25 == 1) goto L45;
        if (r25 == 2) goto L44;
        setTabStripPadding(dpToPx(16), dpToPx(4), dpToPx(16), dpToPx(12));     // Catch: Throwable -> L106
        goto L46
    L44:
        setTabStripPadding(dpToPx(12), dpToPx(6), dpToPx(12), dpToPx(6));     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        r3.recycle();
        throw th;
    L26:
        r19 = 0;
    L109:
        th = move-exception;
        r17.recycle();
        throw th;
    L16:
        if (this.mIsInLargeFont == false) goto L18;
        this.mTabPaddingEnd = (r16 * 2) / 3;
        goto L18
    L11:
        if (this.mIsInLargeFont == false) goto L13;
        this.mTabPaddingStart = (r15 * 2) / 3;
        goto L13
    L5:
        if (l.d() == false) goto L7;
        r6 = true;
        goto L8
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mTabStrip.setEnabled(r1);
    }

    public void setTabDisabledAlpha(float r1) {
        this.mTabDisabledAlpha = clampAlpha(r1);
    }

    public float getTabDisabledAlpha() {
        return this.mTabDisabledAlpha;
    }

    private float clampAlpha(float r1) {
        return Math.max(0.0f, Math.min(1.0f, r1));
    }

    private boolean isDarkTheme() {
        int r0 = this.mTabTextColors.getDefaultColor();
        if (r0 != 0) goto L7;
        return isDarkMode();
    L7:
        return !com.obric.oui.color.d.a(r0);
    }

    private boolean isDarkMode() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r6) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = 0;
        int r1 = this.mTabs.size();
    L5:
        if (r0 >= r1) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r0), e.class, "com.obric.aiagent.plugin")).a(r6);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r6) {
        if (r6 != null) goto L4;
        this.mBackdropTargetWk = new WeakReference(this);
    L5:
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mBackdropTargetWk.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
        if (r6 != null) goto L9;
        l.a(this, null);
    L11:
        if (this.isTabEnableMaterial == false) goto L17;
        int r7 = 0;
        int r1 = this.mTabs.size();
    L13:
        if (r7 >= r1) goto L18;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r7), e.class, "com.obric.aiagent.plugin")).b(r0);
        r7 = r7 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L9:
        l.a(this, r0);
        goto L11
    L15:
        return;
    L4:
        this.mBackdropTargetWk = new WeakReference(r6);
        goto L5
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r6) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = 0;
        int r1 = this.mTabs.size();
    L5:
        if (r0 >= r1) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r0), e.class, "com.obric.aiagent.plugin")).b(r6);
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r6) {
        if (this.isTabEnableMaterial == false) goto L7;
        int r0 = 0;
        int r1 = this.mTabs.size();
    L5:
        if (r0 >= r1) goto L9;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r0), e.class, "com.obric.aiagent.plugin")).c(r6);
        r0 = r0 + 1;
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
        this.mTabStrip.setShadowStyle(ZeusTransformUtils.mapRes(R.style.OUIShadow_None, "style", "OUIShadow_None"));
    }

    static void checkAppCompatTheme(Context r2) {
        TypedArray r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean r0 = !r3.hasValue(0);
        r3.recycle();
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

    public void addTab(e r2) {
        addTab(r2, this.mTabs.isEmpty());
    }

    public void addTab(e r2, int r3) {
        addTab(r2, r3, this.mTabs.isEmpty());
    }

    public void addTab(e r2, boolean r3) {
        addTab(r2, this.mTabs.size(), r3);
    }

    public void addTab(e r3, final int r4, boolean r5) {
        if (r3.f36304a != this) goto L9;
        configureTab(r3, r4);
        addTabView(r3);
        r3.h().setOnTouchListener(new AnonymousClass1(this, r4));
        if (r5 == false) goto L10;
        r3.e();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void addTabFromItemView(OTabItem r3) {
        e r0 = newTab(0);
        if (r3.mText == null) goto L6;
        r0.a(r3.mText);
    L6:
        if (r3.mIcon == null) goto L9;
        r0.a(r3.mIcon);
    L9:
        if (r3.mCustomLayout == 0) goto L12;
        r0.a(r3.mCustomLayout);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.b(r3.getContentDescription());
    L14:
        addTab(r0);
    }

    private void addTabFromBottomItemView(OBottomTabItem r6) {
        OBottomTabItemCustomView r0 = new OBottomTabItemCustomView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        e r1 = newTab(0);
        if (r6.getText() == null) goto L6;
        r0.getTitle().setText(r6.getText());
        r1.a(r6.getText());
    L6:
        if (r6.getIcon() == null) goto L8;
        r0.getIcon().setImageDrawable(r6.getIcon());
    L8:
        r0.setTextColor(this.mTabTextColors);
        r0.setSelectedBgColor(Integer.valueOf(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg_light, "color", "oui_accent_bg_light"))));
        r1.a(r0);
        addTab(r1);
    }

    @Deprecated
    public void setOnTabSelectedListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d r0 = this.mSelectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.mSelectedListener = r4;
        if (r4 == null) goto L9;
        addOnTabSelectedListener(r4);
        return;
    }

    public void addOnTabSelectedListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (this.mSelectedListeners.contains(r4) == true) goto L6;
        this.mSelectedListeners.add(r4);
        return;
    }

    public void removeOnTabSelectedListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        this.mSelectedListeners.remove(r4);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public e newTab(int r4) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(SYNCHRONIZED_TAB_POOL.a(), e.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new e();
    L5:
        r0.f36304a = this;
        r0.f36305b = createTabView();
        if (r4 <= 0) goto L8;
        r0.f36305b.setTab(r0, false);
        r0.a(r4);
    L9:
        return r0;
    L8:
        r0.f36305b.setTab(r0);
        goto L9
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public e getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r2), e.class, "com.obric.aiagent.plugin");
    }

    public int getSelectedTabPosition() {
        e r0 = this.mSelectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c();
    }

    public void removeTab(e r2) {
        if (r2.f36304a != this) goto L7;
        removeTabAt(r2.c());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r8) {
        e r0 = this.mSelectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.c();
    L6:
        removeTabViewAt(r8);
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.mTabs.remove(r8), e.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.j();
        SYNCHRONIZED_TAB_POOL.a(r2);
    L9:
        int r3 = this.mTabs.size();
        int r4 = r8;
    L10:
        if (r4 >= r3) goto L12;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r4), e.class, "com.obric.aiagent.plugin")).b(r4);
        r4 = r4 + 1;
        goto L10
    L12:
        if (r1 == r8) goto L14;
        return;
    L14:
        if (this.mTabs.isEmpty() == false) goto L16;
        e r9 = null;
    L17:
        selectTab(r9);
        return;
    L16:
        r9 = (e) ZeusTransformUtils.preCheckCast(this.mTabs.get(Math.max(0, r8 - 1)), e.class, "com.obric.aiagent.plugin");
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
        Iterator<e> r1 = this.mTabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.aiagent.plugin");
        r1.remove();
        r2.j();
        SYNCHRONIZED_TAB_POOL.a(r2);
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
        f r1 = this.mPageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        a r2 = this.mAdapterChangeListener;
        if (r2 == null) goto L10;
        this.mViewPager.removeOnAdapterChangeListener(r2);
    L10:
        d r6 = this.mCurrentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.mCurrentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L24;
        this.mViewPager = r3;
        if (this.mPageChangeListener != null) goto L17;
        this.mPageChangeListener = new f(this);
    L17:
        this.mPageChangeListener.a();
        r3.addOnPageChangeListener(this.mPageChangeListener);
        h r7 = new h(r3);
        this.mCurrentVpSelectedListener = r7;
        addOnTabSelectedListener(r7);
        androidx.viewpager.widget.a r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        setPagerAdapter(r8, r4);
    L21:
        if (this.mAdapterChangeListener != null) goto L23;
        this.mAdapterChangeListener = new a(this);
    L23:
        this.mAdapterChangeListener.a(r4);
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
        if (this.mViewPager != null) goto L8;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewPager.class) == false) goto L9;
        setupWithViewPager((ViewPager) ZeusTransformUtils.preCheckCast(r0, ViewPager.class, "com.obric.aiagent.plugin"), true, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.mSetupViewPagerImplicitly = false;
        return;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(androidx.viewpager.widget.a r3, boolean r4) {
        androidx.viewpager.widget.a r0 = this.mPagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.mPagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.b(r1);
    L7:
        this.mPagerAdapter = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.mPagerAdapterObserver != null) goto L13;
        this.mPagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.a(this.mPagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        androidx.viewpager.widget.a r0 = this.mPagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.a();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab(this.mCustomTabResId).a(this.mPagerAdapter.a(r2)), false);
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
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r1), e.class, "com.obric.aiagent.plugin")).i();
        r1 = r1 + 1;
        goto L3
    }

    private TabView createTabView() {
        androidx.core.util.f.a<TabView> r0 = this.mTabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = (TabView) ZeusTransformUtils.preCheckCast(r0.a(), TabView.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L17;
        r1 = new TabView(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.isTabEnableMaterial, this.mTabMaterialConfigs, this.mTabMaterialSelectedConfigs);
        WeakReference<View> r2 = this.mBackdropTargetWk;
        if (r2 != null) goto L10;
    L12:
        Drawable r3 = this.mIndicatorBackground;
        if (r3 == null) goto L19;
        if (this.isTabEnableMaterial == true) goto L19;
        r1.setBackground(r3.mutate());
        r1.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L19:
        if (isEnabled() == false) goto L21;
        float r8 = 1.0f;
    L22:
        TabView.access$100(r1, r8);
        r1.setFocusable(true);
        return r1;
    L21:
        r8 = this.mTabDisabledAlpha;
        goto L22
    L10:
        if (r2.get() == null) goto L12;
        r1.setBackdropTarget((View) ZeusTransformUtils.preCheckCast(this.mBackdropTargetWk.get(), View.class, "com.obric.aiagent.plugin"));
        goto L12
    L17:
        r1.updateEnableMaterial(this.isTabEnableMaterial);
        r1.updateMaterialConfigs(this.mTabMaterialConfigs, this.mTabMaterialSelectedConfigs);
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    private void configureTab(e r4, int r5) {
        r4.b(r5);
        this.mTabs.add(r5, r4);
        int r6 = this.mTabs.size();
    L3:
        r5 = r5 + 1;
        if (r5 >= r6) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r5), e.class, "com.obric.aiagent.plugin")).b(r5);
        goto L3
    }

    private void addTabView(e r3) {
        TabView r0 = r3.f36305b;
        this.mTabStrip.addView(r0, r3.c(), createLayoutParamsForTabs());
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

    private void addViewInternal(View r5) {
        if (ZeusTransformUtils.instanceOf(r5, OTabItem.class) == false) goto L6;
        addTabFromItemView((OTabItem) ZeusTransformUtils.preCheckCast(r5, OTabItem.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SlidingTabStrip.class) == false) goto L11;
        if (indexOfChild(r5) != (-1)) goto L15;
        super.addView(r5, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L15:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, OBottomTabItem.class) == false) goto L17;
        addTabFromBottomItemView((OBottomTabItem) ZeusTransformUtils.preCheckCast(r5, OBottomTabItem.class, "com.obric.aiagent.plugin"));
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

    int dpToPx(int r2) {
        return (int) ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density * r2) + 0.5f);
    }

    float dpToPxFloat(float r2) {
        return (ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density * r2) + 0.5f;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r6, int r7) {
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
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r14) {
        float r0 = getBounceTranslation();
        float r1 = com.obric.oui.common.util.g.a(0.5f, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
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
    L20:
        this.mEdgeFadeHelper.a(r5, r3, this);
        boolean r6 = this.mEdgeFadeHelper.a();
        boolean r9 = this.mEdgeFadeHelper.b();
        if (this.mEdgeFadeHelper.a(getWidth(), getHeight()) == false) goto L32;
        float r7 = getScrollX();
        float r10 = getTabStripLeftPadding();
        float r11 = getTabStripRightPadding();
        com.obric.oui.tab.b.a(this.mTabStrip, r7, getWidth(), getHeight(), r6, r9, this.mEdgeFadeLayerBounds, this.mEdgeFadeOverlayBounds);
        int r12 = r14.saveLayer(this.mEdgeFadeLayerBounds.left, this.mEdgeFadeLayerBounds.top, this.mEdgeFadeLayerBounds.right, this.mEdgeFadeLayerBounds.bottom, null);
        drawTabContent(r14);
        com.obric.oui.tab.a r8 = this.mEdgeFadeHelper;
        float r13 = this.mEdgeFadeOverlayBounds.left;
        if (r6 == true) goto L26;
        r10 = 0.0f;
    L26:
        float r15 = r13 + r10;
        float r16 = this.mEdgeFadeOverlayBounds.top;
        float r17 = this.mEdgeFadeOverlayBounds.right;
        if (r9 == true) goto L30;
        r11 = 0.0f;
    L30:
        r8.a(r14, r15, r16, r17 - r11, this.mEdgeFadeOverlayBounds.bottom, r6, r9);
        r14.restoreToCount(r12);
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

    private void drawTabBackgroundAndIndicators(Canvas r13, float r14) {
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
        float r6 = getWidth() + r14;
        if (this.enableMaterial == true) goto L16;
        int r7 = this.mBarColor;
        if (r7 == 0) goto L16;
        this.barPaint.setColor(r7);
        this.barRectF.set(r14, r2, r6, r0 - r3);
        r13.drawRoundRect(this.barRectF, r5, r5, this.barPaint);
    L16:
        if (this.barStrokePaint.getColor() == 0) goto L18;
        this.barRectF.set(r14, r2, r6, r0 - r3);
        r13.drawRoundRect(this.barRectF, r5, r5, this.barStrokePaint);
    L18:
        int r8 = 0;
        if (this.isIndicatorAnimEnable == true) goto L21;
        calcIndicatorRect();
    L25:
        if (this.isTabEnableMaterial == true) goto L39;
        int r9 = this.mIndicatorColor;
        if (r9 == 0) goto L30;
        this.mIndicatorPaint.setColor(r9);
        float r10 = (this.mIndicatorRect.left + r1) + r14;
        float r11 = this.indicatorSpacing;
        float r12 = (this.mIndicatorRect.right + r1) + r14;
        float r15 = this.indicatorSpacing + this.mIndicatorHeight;
        float r16 = this.mIndicatorCornerRadius;
        r13.drawRoundRect(r10, r11, r12, r15, r16, r16, this.mIndicatorPaint);
    L30:
        if (this.mIndicatorUnSelectedColor != 0) goto L32;
        return;
    L32:
        if (this.mBarColor == 0) goto L34;
        return;
    L34:
        if (r8 >= getTabCount()) goto L45;
        if (r8 == getSelectedTabPosition()) goto L38;
        View r17 = getTabView(r8);
        this.mIndicatorPaint.setColor(this.mIndicatorUnSelectedColor);
        float r18 = (r17.getLeft() + r1) + r14;
        float r19 = this.indicatorSpacing;
        float r20 = (r17.getRight() + r1) + r14;
        float r21 = this.indicatorSpacing + this.mIndicatorHeight;
        float r110 = this.mIndicatorCornerRadius;
        r13.drawRoundRect(r18, r19, r20, r21, r110, r110, this.mIndicatorPaint);
    L38:
        r8 = r8 + 1;
        goto L34
    L45:
        return;
    L39:
        return;
    L21:
        if (this.mIsFirstDraw == false) goto L25;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L25
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

    private void removeTabViewAt(int r4) {
        TabView r0 = (TabView) ZeusTransformUtils.preCheckCast(this.mTabStrip.getChildAt(r4), TabView.class, "com.obric.aiagent.plugin");
        this.mTabStrip.removeViewAt(r4);
        if (r0 == null) goto L5;
        r0.reset();
        this.mTabViewPool.a(r0);
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

    void setScrollAnimatorListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(r4);
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

    public void selectTab(int r3) {
        if (r3 < this.mTabs.size()) goto L5;
        return;
    L5:
        if (this.mTabs.isEmpty() == true) goto L13;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r3), e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        selectTab(r4);
        return;
    L12:
        return;
    }

    void selectTab(e r2) {
        selectTab(r2, true);
    }

    void selectTab(e r5, boolean r6) {
        e r0 = this.mSelectedTab;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L30;
        dispatchTabReselected(r5);
        animateToTab(r5.c());
        return;
    L30:
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
        if (r0 == null) goto L21;
        dispatchTabUnselected(r0);
    L21:
        e r7 = this.mSelectedTab;
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
        this.mCurrentP.f36301a = r0.getLeft();
        this.mCurrentP.f36302b = r0.getRight();
        TabView r1 = this.mLastTab.h();
        this.mLastP.f36301a = r1.getLeft();
        this.mLastP.f36302b = r1.getRight();
        if (this.mLastP.f36301a == this.mCurrentP.f36301a) goto L8;
    L10:
        this.mValueAnimator.setObjectValues(new Object[]{this.mLastP, this.mCurrentP});
        if (this.isIndicatorBounceEnable == false) goto L13;
        this.mValueAnimator.setInterpolator(this.mInterpolator);
    L13:
        this.mValueAnimator.setDuration(TAB_ANIM_DURATION);
        this.mValueAnimator.start();
        return;
    L8:
        if (this.mLastP.f36302b != this.mCurrentP.f36302b) goto L10;
        invalidate();
    }

    private void dispatchTabSelected(e r5) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((d) ZeusTransformUtils.preCheckCast(this.mSelectedListeners.get(r0), d.class, "com.obric.aiagent.plugin")).a(r5);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(e r5) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((d) ZeusTransformUtils.preCheckCast(this.mSelectedListeners.get(r0), d.class, "com.obric.aiagent.plugin")).b(r5);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabReselected(e r5) {
        int r0 = this.mSelectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((d) ZeusTransformUtils.preCheckCast(this.mSelectedListeners.get(r0), d.class, "com.obric.aiagent.plugin")).c(r5);
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
        if (ViewCompat.i(this) != 0) goto L20;
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
        this.mTabStrip.setGravity(8388611);
        setOverScrollMode(0);
        goto L8
    }

    void updateTabViews(boolean r6) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTabStrip.getChildCount()) goto L9;
        View r1 = this.mTabStrip.getChildAt(r0);
        updateTabViewLayoutParams((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (r6 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private Typeface getSelectedTypeFace(Typeface r3, int r4) {
        if (this.SELECTED_TAB_TYPE_FACE != null) goto L8;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.SELECTED_TAB_TYPE_FACE = Typeface.create(r3, r4, false);
    L8:
        return this.SELECTED_TAB_TYPE_FACE;
    }

    private static ColorStateList createColorStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    private static ColorStateList createPressedOverlayColorStateList(int r7, int r8, int r9) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{androidx.core.graphics.e.a(r9, r8), androidx.core.graphics.e.a(r9, r7), r8, r7});
    }

    private int getDefaultHeight() {
        int r0 = this.mTabs.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        e r3 = (e) ZeusTransformUtils.preCheckCast(this.mTabs.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        if (r3.b() == null) goto L11;
        if (TextUtils.isEmpty(r3.d()) == true) goto L11;
    L14:
        return 56;
    L11:
        if (r3.a() != null) goto L14;
    L13:
        r2 = r2 + 1;
        goto L3
    L21:
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
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
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
        if (this.mEdgeFadeHelper.a(r2) == false) goto L6;
        invalidate();
        return;
    }

    public boolean isEdgeFadeEnabled() {
        return this.mEdgeFadeHelper.c();
    }

    public void setEdgeFadeLength(float r2) {
        if (this.mEdgeFadeHelper.a(r2) == false) goto L6;
        invalidate();
        return;
    }

    public float getEdgeFadeLength() {
        return this.mEdgeFadeHelper.d();
    }
}
