package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.common.style.l;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OTabSegmentedLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OTabSegmentedLayout extends FrameLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    public static final a Companion = null;
    private static final long TAB_ANIM_DURATION = 350;
    private static final String TAG = "OTabSegmentedLayout";
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private final Paint barPaint;
    private final RectF barRectF;
    private final Paint barStrokePaint;
    private final RectF barStrokeRectF;
    private long indicatorAnimDuration;
    private float indicatorShadowDxPx;
    private float indicatorShadowDyPx;
    private float indicatorShadowRadiusPx;
    private float indicatorSpacing;
    private boolean isIndicatorAnimEnable;
    private boolean isIndicatorBounceEnable;
    private int mBarColor;
    private int mBarStrokeColor;
    private float mBarStrokeWidth;
    private int mContainerViewId;
    private final Context mContext;
    private final b mCurrentP;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private final Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private int mHeight;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private float mIndicatorHeight;
    private final Paint mIndicatorPaint;
    private final Rect mIndicatorPressedRect;
    private final Rect mIndicatorRect;
    private final SparseArray<Boolean> mInitSetMap;
    private final PathInterpolator mInterpolator;
    private boolean mIsFirstDraw;
    private final b mLastP;
    private int mLastTab;
    private d mListener;
    private int mPressedTab;
    private final float[] mRadiusArr;
    private c mSelectAnimListener;
    private Drawable[] mTabDrawables;
    private float mTabPadding;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private final LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private final Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private float mTextsize;
    private String[] mTitles;
    private final ValueAnimator mValueAnimator;
    private boolean mVibrateOnTabSelected;
    private int tabCount;
    private List<View> tabList;

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    public final class PointEvaluator implements TypeEvaluator<b> {
        final /* synthetic */ OTabSegmentedLayout this$0;

        public PointEvaluator(OTabSegmentedLayout r2) {
            o.e(r2, "this$0");
            this.this$0 = r2;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ b evaluate(float r3, b r4, b r5) {
            return evaluate2(r3, (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public b evaluate2(float r4, b r5, b r6) {
            o.e(r5, "startValue");
            o.e(r6, "endValue");
            float r0 = r5.a() + ((r6.a() - r5.a()) * r4);
            float r1 = r5.b() + (r4 * (r6.b() - r5.b()));
            b r7 = new b(this.this$0);
            r7.a(r0);
            r7.b(r1);
            return r7;
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabSegmentedLayout f36153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f36155c;

        public b(OTabSegmentedLayout r2) {
            o.e(r2, "this$0");
            this.f36153a = r2;
        }

        public final float a() {
            return this.f36154b;
        }

        public final void a(float r1) {
            this.f36154b = r1;
        }

        public final float b() {
            return this.f36155c;
        }

        public final void b(float r1) {
            this.f36155c = r1;
        }

        public String toString() {
            return "(left = " + this.f36154b + ", right = " + this.f36155c + ')';
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    public interface c {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    public interface d {
        void a(int r1);

        void b(int r1);
    }

    static {
        Companion = new a(null);
    }

    public OTabSegmentedLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTabSegmentedLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ boolean lambda$ZQy8aCmqu4h0ox8KYJwo1umkHxc(OTabSegmentedLayout r0, View r1, MotionEvent r2) {
        return m1159addTab$lambda11(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$fNpfBGKgTv9m59I9pyxPZue_s8I(OTabSegmentedLayout r0, View r1) {
        m1160addTab$lambda12(r0, r1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    public /* synthetic */ OTabSegmentedLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OTabSegmentedLayout(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11, r9);
        this.mPressedTab = -1;
        this.mIndicatorRect = new Rect();
        this.mIndicatorPressedRect = new Rect();
        this.mIndicatorPaint = new Paint();
        this.mDividerPaint = new Paint(1);
        this.indicatorAnimDuration = TAB_ANIM_DURATION;
        this.isIndicatorAnimEnable = true;
        this.mVibrateOnTabSelected = true;
        this.mInterpolator = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mRadiusArr = new float[8];
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        this.barPaint = r12;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.STROKE);
        this.barStrokePaint = r13;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.tabList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray();
        b r14 = new b(this);
        this.mCurrentP = r14;
        b r2 = new b(this);
        this.mLastP = r2;
        refreshDimensionCache();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        LinearLayout r4 = new LinearLayout(r10);
        this.mTabsContainer = r4;
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        obtainAttributes(r10, r11);
        o.a(r11);
        String r5 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (o.a(r5, "-1") == false) goto L6;
    L9:
        ValueAnimator r15 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new PointEvaluator(this), TypeEvaluator.class, "com.obric.aiagent.plugin"), new Object[]{r2, r14});
        o.c(r15, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.mValueAnimator = r15;
        r15.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(this, ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
        r15.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(this, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (o.a(r5, "-2") == true) goto L9;
        TypedArray r16 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        o.c(r16, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.mHeight = r16.getDimensionPixelSize(0, -2);
        r16.recycle();
        goto L9
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    public final float getIndicatorSpacing() {
        return this.indicatorSpacing;
    }

    public final long getIndicatorAnimDuration() {
        return this.indicatorAnimDuration;
    }

    public final void setIndicatorAnimDuration(long r1) {
        this.indicatorAnimDuration = r1;
    }

    public final boolean isIndicatorAnimEnable() {
        return this.isIndicatorAnimEnable;
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.isIndicatorAnimEnable = r1;
    }

    public final boolean isIndicatorBounceEnable() {
        return this.isIndicatorBounceEnable;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
        this.isIndicatorBounceEnable = r1;
    }

    private final void obtainAttributes(Context r7, AttributeSet r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.OTabLayout);
        o.c(r9, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.mIndicatorColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_fill_seg_selected, "color", "oui_fill_seg_selected")));
        this.mIndicatorHeight = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f);
        this.mIndicatorCornerRadius = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f);
        this.indicatorSpacing = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), dp2px(4.0f));
        LinearLayout r10 = this.mTabsContainer;
        int r2 = (int) (getIndicatorSpacing() / 2);
        r10.setPadding(r2, 0, r2, 0);
        this.isIndicatorAnimEnable = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false);
        this.isIndicatorBounceEnable = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);
        this.mDividerColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_color, "styleable", "OTabLayout_divider_color"), this.mIndicatorColor);
        this.mDividerWidth = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), dp2px(1.0f));
        this.mDividerPadding = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.mTextsize = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), sp2px(13.0f));
        this.mTextSelectColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), Color.parseColor("#ffffff"));
        this.mTextUnselectColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.mIndicatorColor);
        this.mTextBold = r9.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textBold, "styleable", "OTabLayout_tab_textBold"), 0);
        this.mTextAllCaps = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.mTabSpaceEqual = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.mTabWidth = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), dp2px(-1.0f));
        int r11 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.mTabSpaceEqual == false) goto L5;
    L8:
        int r1 = dp2px(0.0f);
    L9:
        this.mTabPadding = r9.getDimension(r11, r1);
        this.mBarColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);
        this.mBarStrokeColor = r9.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.mBarColor);
        this.mBarStrokeWidth = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), dp2px(0.0f));
        this.mVibrateOnTabSelected = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), true);
        r9.recycle();
        return;
    L5:
        if (this.mTabWidth > 0.0f) goto L8;
        r1 = dp2px(10.0f);
        goto L9
    }

    public final void setTabTitleAndDrawable(String[] r4, Drawable[] r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L23;
        if (r5 != null) goto L15;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L23;
    L24:
        if (r0 == false) goto L28;
        this.mTitles = r4;
        this.mTabDrawables = r5;
        notifyDataSetChanged();
        return;
    L28:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !".toString());
    L15:
        if (r5.length != 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L21;
        r3 = false;
        goto L22
    L17:
        r6 = false;
    L23:
        r0 = true;
        goto L24
    L5:
        if (r4.length != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r7 = false;
        goto L8
    }

    public final void setTabData(String[] r3, FragmentActivity r4, int r5, ArrayList<Fragment> r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.aiagent.plugin");
        o.e(r7, "fa");
        this.mFragmentManager = r7.getSupportFragmentManager();
        this.mContainerViewId = r5;
        this.mFragments = r6;
        initFragments();
        setTabTitleAndDrawable(r3, null);
    }

    private final void initFragments() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 == null) goto L12;
        Iterator<Fragment> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r1.next(), Fragment.class, "com.obric.aiagent.plugin");
        FragmentManager r3 = this.mFragmentManager;
        o.a(r3);
        r3.a().a(this.mContainerViewId, r2).b(r2).b();
        goto L7
    L9:
        setFragments(0);
        return;
    }

    private final void setFragments(int r8) {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L6:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        FragmentManager r4 = this.mFragmentManager;
        o.a(r4);
        m r5 = r4.a();
        o.c(r5, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r6 = this.mFragments;
        o.a(r6);
        Fragment r7 = r6.get(r1);
        o.c(r7, "mFragments!![i]");
        Fragment r9 = (Fragment) ZeusTransformUtils.preCheckCast(r7, Fragment.class, "com.obric.aiagent.plugin");
        if (r1 != r8) goto L10;
        r5.c(r9);
    L11:
        r5.b();
        r1 = r3;
        goto L6
    L10:
        r5.b(r9);
        goto L11
    L12:
        this.mCurrentTab = r8;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r0.get(this.mCurrentTab), Fragment.class, "com.obric.aiagent.plugin");
    }

    private final void notifyDataSetChanged() {
        this.mTabsContainer.removeAllViews();
        String[] r0 = this.mTitles;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        int r2 = 0;
        if (r1 != null) goto L12;
        Drawable[] r3 = this.mTabDrawables;
        if (r3 != null) goto L11;
        int r4 = 0;
    L13:
        this.tabCount = r4;
        this.tabList.clear();
        int r5 = this.tabCount;
    L14:
        if (r2 >= r5) goto L16;
        OSegmentTabView r6 = OSegmentTabView.Companion.a(this.mContext);
        r6.setOriginTextColor(this.mTextSelectColor, this.mTextUnselectColor);
        r6.setOriginIconAlpha(255);
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        ((OSegmentTabView) ZeusTransformUtils.preCheckCast(r7, OSegmentTabView.class, "com.obric.aiagent.plugin")).setTag(Integer.valueOf(r2));
        addTab(r2, r7);
        r2 = r2 + 1;
        goto L14
    L16:
        updateTabStyles();
        return;
    L11:
        r4 = r3.length;
        goto L13
    L12:
        r4 = r1.intValue();
        goto L13
    L5:
        r1 = Integer.valueOf(r0.length);
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        Iterator<View> r3 = this.tabList.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin")).setEnabled(r4);
        goto L4
    }

    public final List<View> getTabList() {
        return this.tabList;
    }

    public final void setTabList(List<View> r3) {
        List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.tabList = r4;
    }

    private final void addTab(int r8, View r9) {
        View r1 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        String[] r4 = this.mTitles;
        x r5 = null;
        Drawable r6 = null;
        if (r4 != null) goto L6;
        x r7 = null;
    L15:
        if (r7 != null) goto L17;
        OTabSegmentedLayout r10 = (OTabSegmentedLayout) ZeusTransformUtils.preCheckCast(this, OTabSegmentedLayout.class, "com.obric.aiagent.plugin");
        r2.setVisibility(8);
    L17:
        Drawable[] r11 = this.mTabDrawables;
        if (r11 == null) goto L25;
        if (r11 == null) goto L23;
        r6 = r11[r8];
    L23:
        r3.setImageDrawable(r6);
        r5 = x.f38692a;
    L25:
        if (r5 != null) goto L27;
        OTabSegmentedLayout r0 = (OTabSegmentedLayout) ZeusTransformUtils.preCheckCast(this, OTabSegmentedLayout.class, "com.obric.aiagent.plugin");
        r3.setVisibility(8);
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r12, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r13.setMargins(0, 0, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L27:
        r9.setOnTouchListener(new $$Lambda$OTabSegmentedLayout$ZQy8aCmqu4h0ox8KYJwo1umkHxc(this));
        r9.setOnClickListener(new $$Lambda$OTabSegmentedLayout$fNpfBGKgTv9m59I9pyxPZue_s8I(this));
        this.tabList.add(r9);
        if (this.mTabSpaceEqual == false) goto L30;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L32:
        if (this.mTabWidth <= 0.0f) goto L34;
        r14 = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
    L34:
        this.mTabsContainer.addView(r9, r8, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L30:
        r14 = new LinearLayout.LayoutParams(-2, -1);
        goto L32
    L6:
        if (r4 != null) goto L9;
    L7:
        Object r15 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        r2.setText((CharSequence) r15);
        r7 = x.f38692a;
        goto L15
    L9:
        String r16 = r4[r8];
        if (r16 == null) goto L7;
        r15 = ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        goto L13
    }

    /* JADX INFO: renamed from: addTab$lambda-11, reason: not valid java name */
    private static final boolean m1159addTab$lambda11(OTabSegmentedLayout r1, View r2, MotionEvent r3) {
        o.e(r1, "this$0");
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        Object r5 = r2.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r1.mPressedTab = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r1.postInvalidate();
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r1.mPressedTab = -1;
        r1.postInvalidate();
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }

    /* JADX INFO: renamed from: addTab$lambda-12, reason: not valid java name */
    private static final void m1160addTab$lambda12(OTabSegmentedLayout r3, View r4) {
        o.e(r3, "this$0");
        if (r3.mVibrateOnTabSelected == false) goto L5;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
    L5:
        Object r5 = r4.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r3.mCurrentTab == r6) goto L12;
        r3.setCurrentTab(r6);
        d r7 = r3.mListener;
        if (r7 == null) goto L18;
        if (r7 == null) goto L21;
        r7.a(r6);
        return;
    L21:
        return;
    L18:
        return;
    L12:
        d r8 = r3.mListener;
        if (r8 == null) goto L20;
        if (r8 == null) goto L22;
        r8.b(r6);
        return;
    L22:
        return;
    }

    public final void setImageSize(int r7, int r8) {
        int r0 = this.tabCount;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(this.mTabsContainer.getChildAt(r1).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.width = r7;
        r5.height = r8;
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1 = r2;
        goto L3
    }

    private final void updateTabStyles() {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        float r5 = this.mTabPadding;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        int r8 = this.mCurrentTab;
        if (r2 != r8) goto L7;
        boolean r10 = true;
    L8:
        if (r2 != r8) goto L10;
        int r9 = this.mTextSelectColor;
    L11:
        r7.setTextColor(r9);
        r7.setTextSize(0, this.mTextsize);
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 != this.mCurrentTab) goto L14;
        int r12 = this.mTextSelectColor;
    L15:
        r11.setImageTintList(ColorStateList.valueOf(r12));
        if (this.mTextAllCaps == false) goto L18;
        String r13 = r7.getText().toString();
        Locale r14 = Locale.ROOT;
        o.c(r14, "ROOT");
        String r15 = r13.toUpperCase(r14);
        o.c(r15, "this as java.lang.String).toUpperCase(locale)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"));
    L18:
        int r16 = this.mTextBold;
        if (r16 != 2) goto L21;
        TextPaint r17 = r7.getPaint();
        o.c(r17, "tvTabTitle.paint");
        applyBold(r17, true);
    L25:
        r2 = r3;
        goto L3
    L21:
        if (r16 != 0) goto L23;
        TextPaint r18 = r7.getPaint();
        o.c(r18, "tvTabTitle.paint");
        applyBold(r18, false);
        goto L25
    L23:
        if (r16 != 1) goto L25;
        TextPaint r19 = r7.getPaint();
        o.c(r19, "tvTabTitle.paint");
        applyBold(r19, r10);
        goto L25
    L14:
        r12 = this.mTextUnselectColor;
        goto L15
    L10:
        r9 = this.mTextUnselectColor;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    private final void applyBold(TextPaint r2, boolean r3) {
        if (r3 == false) goto L4;
        int r1 = 700;
    L5:
        r2.setTypeface(Typeface.create(null, r1, false));
        return;
    L4:
        r1 = 400;
        goto L5
    }

    private final void updateTabSelection(int r12) {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        if (r2 != r12) goto L7;
        boolean r5 = true;
    L8:
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L11;
        int r9 = this.mTextSelectColor;
    L12:
        r8.setImageTintList(ColorStateList.valueOf(r9));
        if (this.mTextBold != 1) goto L15;
        TextPaint r10 = r7.getPaint();
        o.c(r10, "tabTitle.paint");
        applyBold(r10, r5);
        r7.invalidate();
    L15:
        com.obric.oui.d.c r11 = com.obric.oui.d.c.f35012a;
        if (r4 != null) goto L19;
    L17:
        r4 = null;
    L20:
        OSegmentTabView r13 = (OSegmentTabView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L24;
        r13.updateSelectState(r5);
    L24:
        r2 = r3;
        goto L3
    L19:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L17;
    L11:
        r9 = this.mTextUnselectColor;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    private final void calcOffset() {
        View r0 = this.mTabsContainer.getChildAt(this.mCurrentTab);
        this.mCurrentP.a(r0.getLeft());
        this.mCurrentP.b(r0.getRight());
        View r1 = this.mTabsContainer.getChildAt(this.mLastTab);
        this.mLastP.a(r1.getLeft());
        this.mLastP.b(r1.getRight());
        if (this.mLastP.a() != this.mCurrentP.a()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L13:
        this.mValueAnimator.setObjectValues(new Object[]{this.mLastP, this.mCurrentP});
        if (this.isIndicatorBounceEnable == false) goto L16;
        this.mValueAnimator.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.mInterpolator, TimeInterpolator.class, "com.obric.aiagent.plugin"));
    L16:
        this.mValueAnimator.setDuration(TAB_ANIM_DURATION);
        this.mValueAnimator.start();
        return;
    L8:
        if (this.mLastP.b() != this.mCurrentP.b()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        invalidate();
        return;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private final void calcIndicatorRect() {
        View r0 = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float r1 = r0.getLeft();
        float r2 = r0.getRight();
        this.mIndicatorRect.left = (int) r1;
        this.mIndicatorRect.right = (int) r2;
        if (this.isIndicatorAnimEnable == true) goto L11;
        int r3 = this.mCurrentTab;
        if (r3 != 0) goto L8;
        float[] r4 = this.mRadiusArr;
        float r11 = this.mIndicatorCornerRadius;
        r4[0] = r11;
        r4[1] = r11;
        r4[2] = 0.0f;
        r4[3] = 0.0f;
        r4[4] = 0.0f;
        r4[5] = 0.0f;
        r4[6] = r11;
        r4[7] = r11;
        return;
    L8:
        if (r3 != (this.tabCount - 1)) goto L10;
        float[] r5 = this.mRadiusArr;
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        float r12 = this.mIndicatorCornerRadius;
        r5[2] = r12;
        r5[3] = r12;
        r5[4] = r12;
        r5[5] = r12;
        r5[6] = 0.0f;
        r5[7] = 0.0f;
        return;
    L10:
        float[] r13 = this.mRadiusArr;
        r13[0] = 0.0f;
        r13[1] = 0.0f;
        r13[2] = 0.0f;
        r13[3] = 0.0f;
        r13[4] = 0.0f;
        r13[5] = 0.0f;
        r13[6] = 0.0f;
        r13[7] = 0.0f;
        return;
    L11:
        float[] r6 = this.mRadiusArr;
        float r14 = this.mIndicatorCornerRadius;
        r6[0] = r14;
        r6[1] = r14;
        r6[2] = r14;
        r6[3] = r14;
        r6[4] = r14;
        r6[5] = r14;
        r6[6] = r14;
        r6[7] = r14;
    }

    private final void calcIndicatorPressedRect() {
        int r0 = this.mPressedTab;
        if (r0 == (-1)) goto L5;
        View r1 = this.mTabsContainer.getChildAt(r0);
    L6:
        if (r1 == null) goto L10;
        Rect r2 = this.mIndicatorPressedRect;
        r2.left = r1.getLeft();
        Rect r3 = this.mIndicatorPressedRect;
        r3.right = r1.getRight();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        o.e(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        Rect r0 = this.mIndicatorRect;
        r0.left = (int) r5.a();
        Rect r1 = this.mIndicatorRect;
        r1.right = (int) r5.b();
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r2) {
        o.e(r2, "animation");
        c r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        c r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        o.e(r2, "animation");
        c r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.c();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r15) {
        o.e(r15, "canvas");
        super.onDraw(r15);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.tabCount <= 0) goto L35;
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        if (this.mIndicatorHeight >= 0.0f) goto L10;
        this.mIndicatorHeight = r0 - (this.indicatorSpacing * 2);
    L10:
        float r2 = this.mIndicatorCornerRadius;
        if (r2 >= 0.0f) goto L13;
    L14:
        this.mIndicatorCornerRadius = this.mIndicatorHeight;
    L15:
        this.barPaint.setColor(this.mBarColor);
        this.barRectF.set(0.0f, getPaddingTop(), getWidth(), r0 - getPaddingBottom());
        float r4 = 2;
        float r3 = this.mIndicatorCornerRadius + (this.indicatorSpacing / r4);
        l.a(r15, this.barRectF, r3, this.barPaint);
        if (this.mBarStrokeWidth <= 0.0f) goto L19;
        this.barStrokePaint.setColor(this.mBarStrokeColor);
        this.barStrokePaint.setStrokeWidth(this.mBarStrokeWidth);
        this.barStrokeRectF.set(this.mBarStrokeWidth / r4, getPaddingTop() + (this.mBarStrokeWidth / r4), getWidth() - (this.mBarStrokeWidth / r4), (r0 - getPaddingBottom()) - (this.mBarStrokeWidth / r4));
        l.a(r15, this.barStrokeRectF, r3, this.barStrokePaint);
    L19:
        if (this.isIndicatorAnimEnable == true) goto L26;
        float r5 = this.mDividerWidth;
        if (r5 <= 0.0f) goto L26;
        this.mDividerPaint.setStrokeWidth(r5);
        this.mDividerPaint.setColor(this.mDividerColor);
        int r6 = this.tabCount - 1;
        int r7 = 0;
    L23:
        if (r7 >= r6) goto L26;
        int r8 = r7 + 1;
        View r9 = this.mTabsContainer.getChildAt(r7);
        r15.drawLine(r9.getRight() + r1, this.mDividerPadding, r9.getRight() + r1, r0 - this.mDividerPadding, this.mDividerPaint);
        r7 = r8;
    L26:
        if (this.isIndicatorAnimEnable == true) goto L28;
        calcIndicatorRect();
    L31:
        calcIndicatorPressedRect();
        float r10 = (this.indicatorSpacing / r4) + this.mBarStrokeWidth;
        Paint r11 = this.mIndicatorPaint;
        r11.setColor(this.mIndicatorColor);
        r11.setShadowLayer(this.indicatorShadowRadiusPx, this.indicatorShadowDxPx, this.indicatorShadowDyPx, androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.TabSegmentedShadowColor, "color", "TabSegmentedShadowColor")));
        l.a(r15, (r1 + r10) + this.mIndicatorRect.left, this.indicatorSpacing + this.mBarStrokeWidth, (r1 + this.mIndicatorRect.right) - r10, (this.indicatorSpacing + this.mIndicatorHeight) - this.mBarStrokeWidth, this.mIndicatorCornerRadius, this.mIndicatorPaint);
        return;
    L28:
        if (this.mIsFirstDraw == false) goto L31;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L31
    L13:
        if (r2 <= (this.mIndicatorHeight / 2)) goto L15;
    }

    public final int getCurrentTab() {
        return this.mCurrentTab;
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.mCurrentTab;
        if (r3 != r0) goto L5;
        return;
    L5:
        this.mIsFirstDraw = true;
        this.mLastTab = r0;
        this.mCurrentTab = r3;
        INVOKESTATIC_com_obric_oui_segmentedtab_OTabSegmentedLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "setCurrentTab, currentTab: " + r3 + ", lastTab: " + this.mLastTab);
        updateTabSelection(r3);
        setFragments(r3);
        if (this.isIndicatorAnimEnable == false) goto L8;
        calcOffset();
        return;
    L8:
        invalidate();
    }

    public final float getTabPadding() {
        return this.mTabPadding;
    }

    public final void setTabPadding(float r1) {
        this.mTabPadding = dp2px(r1);
        updateTabStyles();
    }

    public final boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public final void setTabSpaceEqual(boolean r1) {
        this.mTabSpaceEqual = r1;
        updateTabStyles();
    }

    public final float getTabWidth() {
        return this.mTabWidth;
    }

    public final void setTabWidth(float r1) {
        this.mTabWidth = dp2px(r1);
        updateTabStyles();
    }

    public final int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public final void setIndicatorColor(int r1) {
        this.mIndicatorColor = r1;
        invalidate();
    }

    public final float getIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public final void setIndicatorHeight(float r1) {
        this.mIndicatorHeight = dp2px(r1);
        invalidate();
    }

    public final float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public final void setIndicatorCornerRadius(float r1) {
        this.mIndicatorCornerRadius = dp2px(r1);
        invalidate();
    }

    public final int getDividerColor() {
        return this.mDividerColor;
    }

    public final void setDividerColor(int r1) {
        this.mDividerColor = r1;
        invalidate();
    }

    public final float getDividerWidth() {
        return this.mDividerWidth;
    }

    public final void setDividerWidth(float r1) {
        this.mDividerWidth = dp2px(r1);
        invalidate();
    }

    public final float getDividerPadding() {
        return this.mDividerPadding;
    }

    public final void setDividerPadding(float r1) {
        this.mDividerPadding = dp2px(r1);
        invalidate();
    }

    public final float getTextsize() {
        return this.mTextsize;
    }

    public final void setTextsize(float r1) {
        this.mTextsize = sp2px(r1);
        updateTabStyles();
    }

    public final int getTextSelectColor() {
        return this.mTextSelectColor;
    }

    public final void setTextSelectColor(int r1) {
        this.mTextSelectColor = r1;
        updateTabStyles();
    }

    public final int getTextUnselectColor() {
        return this.mTextUnselectColor;
    }

    public final void setTextUnselectColor(int r1) {
        this.mTextUnselectColor = r1;
        updateTabStyles();
    }

    public final int getTextBold() {
        return this.mTextBold;
    }

    public final void setTextBold(int r1) {
        this.mTextBold = r1;
        updateTabStyles();
    }

    public final boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public final void setTextAllCaps(boolean r1) {
        this.mTextAllCaps = r1;
        updateTabStyles();
    }

    public final TextView getTitleView(int r3) {
        View r2 = this.mTabsContainer.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
    }

    private final void showMsg(int r6, int r7) {
        int r0 = this.tabCount;
        if (r6 < r0) goto L5;
        r6 = r0 - 1;
    L5:
        View r1 = this.mTabsContainer.getChildAt(r6).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.rtv_msg_tip, DbHelper.COL_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        ((UnReadMsgView) ZeusTransformUtils.preCheckCast(r1, UnReadMsgView.class, "com.obric.aiagent.plugin")).show(r7);
        if (this.mInitSetMap.get(r6) == null) goto L10;
        Boolean r8 = this.mInitSetMap.get(r6);
        o.a(r8);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L10;
        return;
    L10:
        setMsgMargin(r6, 2.0f, 2.0f);
        this.mInitSetMap.put(r6, true);
    }

    public final void showDot(int r2) {
        int r0 = this.tabCount;
        if (r2 < r0) goto L5;
        r2 = r0 - 1;
    L5:
        showMsg(r2, 0);
    }

    public final void hideMsg(int r3) {
        int r0 = this.tabCount;
        if (r3 < r0) goto L5;
        r3 = r0 - 1;
    L5:
        View r2 = this.mTabsContainer.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.rtv_msg_tip, DbHelper.COL_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        ((UnReadMsgView) ZeusTransformUtils.preCheckCast(r2, UnReadMsgView.class, "com.obric.aiagent.plugin")).setVisibility(8);
    }

    private final void setMsgMargin(int r6, float r7, float r8) {
        int r0 = this.tabCount;
        if (r6 < r0) goto L5;
        r6 = r0 - 1;
    L5:
        View r9 = this.mTabsContainer.getChildAt(r6);
        View r1 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.rtv_msg_tip, DbHelper.COL_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        UnReadMsgView r2 = (UnReadMsgView) ZeusTransformUtils.preCheckCast(r1, UnReadMsgView.class, "com.obric.aiagent.plugin");
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.TextView");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        this.mTextPaint.setTextSize(this.mTextsize);
        this.mTextPaint.measureText(r11.getText().toString());
        float r12 = this.mTextPaint.descent() - this.mTextPaint.ascent();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r4.leftMargin = dp2px(r7);
        int r13 = this.mHeight;
        if (r13 <= 0) goto L8;
        int r14 = (((int) (r13 - r12)) / 2) - dp2px(r8);
    L9:
        r4.topMargin = r14;
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r14 = dp2px(r8);
        goto L9
    }

    public final UnReadMsgView getMsgView(int r3) {
        int r0 = this.tabCount;
        if (r3 < r0) goto L5;
        r3 = r0 - 1;
    L5:
        View r2 = this.mTabsContainer.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.rtv_msg_tip, DbHelper.COL_ID, "rtv_msg_tip"));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
        return (UnReadMsgView) ZeusTransformUtils.preCheckCast(r2, UnReadMsgView.class, "com.obric.aiagent.plugin");
    }

    public final void setOnTabSelectListener(d r3) {
        this.mListener = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    public final void setOnTabSelectAnimListener(c r3) {
        this.mSelectAnimListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.mCurrentTab);
        return (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
        o.e(r5, "state");
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L9;
        this.mCurrentTab = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin")).getInt("mCurrentTab");
        r5 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin")).getParcelable("instanceState");
        if (this.mCurrentTab == 0) goto L9;
        if (this.mTabsContainer.getChildCount() <= 0) goto L9;
        updateTabSelection(this.mCurrentTab);
    L9:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        this.indicatorShadowRadiusPx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10);
        this.indicatorShadowDxPx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0);
        this.indicatorShadowDyPx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
    }

    private final int dp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_segmentedtab_OTabSegmentedLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
