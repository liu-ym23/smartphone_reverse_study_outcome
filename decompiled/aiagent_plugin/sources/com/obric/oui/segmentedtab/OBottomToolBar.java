package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.common.oea.foundation.animation.manager.d;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.d.i;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: OBottomToolBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomToolBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener, g {
    public static final a Companion = null;
    private static final long TAB_ANIM_DURATION = 350;
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private float animAccuracy;
    private float barCornerRadiusPx;
    private final Paint barPaint;
    private final RectF barRectF;
    private final Paint barStrokePaint;
    private final RectF barStrokeRectF;
    private boolean enableMaterial;
    private float initScale;
    private boolean isBackdropView;
    private int mBarColor;
    private int mBarStrokeColor;
    private float mBarStrokeWidth;
    private int mContainerViewId;
    private OUIFrameLayout mContentRoot;
    private final Context mContext;
    private float mCurrentIndicatorHeight;
    private final b mCurrentP;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private final Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private int mHeight;
    private float mIndicatorMinHeightScale;
    private final SparseArray<Boolean> mInitSetMap;
    private final PathInterpolator mInterpolator;
    private boolean mIsFirstDraw;
    private final b mLastP;
    private int mLastTab;
    private c mListener;
    private int mPressedTab;
    private final float[] mRadiusArr;
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
    private boolean materialApplied;
    private int materialSrcType;
    private d pressAnim;
    private float pressScale;
    private d releaseAnim;
    private List<j> shadowsNormal;
    private List<j> shadowsPressed;
    private int tabCount;
    private List<View> tabList;

    /* JADX INFO: compiled from: OBottomToolBar.kt */
    public final class PointEvaluator implements TypeEvaluator<b> {
        final /* synthetic */ OBottomToolBar this$0;

        public PointEvaluator(OBottomToolBar r2) {
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

    /* JADX INFO: compiled from: OBottomToolBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OBottomToolBar.kt */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomToolBar f36147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f36149c;

        public b(OBottomToolBar r2) {
            o.e(r2, "this$0");
            this.f36147a = r2;
        }

        public final float a() {
            return this.f36148b;
        }

        public final void a(float r1) {
            this.f36148b = r1;
        }

        public final float b() {
            return this.f36149c;
        }

        public final void b(float r1) {
            this.f36149c = r1;
        }

        public String toString() {
            return "(left = " + this.f36148b + ", right = " + this.f36149c + ')';
        }
    }

    /* JADX INFO: compiled from: OBottomToolBar.kt */
    public interface c {
        void a(int r1);

        void b(int r1);
    }

    static {
        Companion = new a(null);
    }

    public OBottomToolBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomToolBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$N1A6x8M4SNbPPPtp2xdAUFTe-bA, reason: not valid java name */
    public static /* synthetic */ boolean m1156lambda$N1A6x8M4SNbPPPtp2xdAUFTebA(OBottomToolBar r0, View r1, MotionEvent r2) {
        return m1154addTab$lambda14(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Vj9QKW5Wm3jtmnxPQ1kvbu-ZSPg, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1157lambda$Vj9QKW5Wm3jtmnxPQ1kvbuZSPg(OBottomToolBar r0, View r1, WindowInsets r2) {
        return m1158obtainAttributes$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dQ2zmptOPpkZzAy12cMN_QEnxmM(OBottomToolBar r0, View r1) {
        m1155addTab$lambda15(r0, r1);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r1) {
        o.e(r1, "p0");
    }

    public /* synthetic */ OBottomToolBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OBottomToolBar(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        super(r16, r17, r15, null, 8, null);
        this.mPressedTab = -1;
        this.mDividerPaint = new Paint(1);
        this.mInterpolator = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mRadiusArr = new float[8];
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.barPaint = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        this.barStrokePaint = r1;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.pressScale = 0.988f;
        this.animAccuracy = 0.01f;
        this.initScale = 1.0f;
        this.mIndicatorMinHeightScale = 0.85f;
        this.materialSrcType = -1;
        this.tabList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray();
        b r18 = new b(this);
        this.mCurrentP = r18;
        b r2 = new b(this);
        this.mLastP = r2;
        refreshDimensionCache();
        setWillNotDraw(false);
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.enableMaterial = r3;
        this.materialApplied = r3;
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = ZeusTransformUtils.wrapperContext(r16, "com.obric.aiagent.plugin");
        this.mTabsContainer = new LinearLayout(r16);
        OUIFrameLayout r11 = new OUIFrameLayout(r16, null, 0, null, 14, null);
        this.mContentRoot = r11;
        r11.setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        addView((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"));
        obtainAttributes(r16, r17);
        o.a(r17);
        String r4 = r17.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (o.a(r4, "-1") == false) goto L12;
    L15:
        ValueAnimator r19 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new PointEvaluator(this), TypeEvaluator.class, "com.obric.aiagent.plugin"), new Object[]{r2, r18});
        o.c(r19, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.mValueAnimator = r19;
        r19.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(this, ValueAnimator.AnimatorUpdateListener.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (o.a(r4, "-2") == true) goto L15;
        TypedArray r110 = r16.obtainStyledAttributes(r17, new int[]{R.attr.layout_height});
        o.c(r110, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.mHeight = r110.getDimensionPixelSize(0, -2);
        r110.recycle();
        goto L15
    L5:
        if (l.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    private final void initShadows(Context r6, TypedArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        List<j> r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_shadow_normal, "styleable", "OTabLayout_shadow_normal"));
        if (r0 != null) goto L5;
        r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetShadowNormal, "styleable", "OTabLayout_oui_widgetShadowNormal"));
    L5:
        if (r0 == null) goto L7;
        this.shadowsNormal = r0;
        o.a(r0);
        j r1 = (j) ZeusTransformUtils.preCheckCast(p.d(r0, 0), j.class, "com.obric.aiagent.plugin");
        List<j> r3 = this.shadowsNormal;
        o.a(r3);
        a(r1, (j) ZeusTransformUtils.preCheckCast(p.d(r3, 1), j.class, "com.obric.aiagent.plugin"));
    L7:
        List<j> r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_shadow_pressed, "styleable", "OTabLayout_shadow_pressed"));
        if (r2 != null) goto L10;
        r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetShadowPressed, "styleable", "OTabLayout_oui_widgetShadowPressed"));
    L10:
        if (r2 == null) goto L13;
        this.shadowsPressed = r2;
        return;
    }

    private final void obtainAttributes(Context r18, AttributeSet r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        TypedArray r3 = r1.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.OTabLayout);
        o.c(r3, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.mContentRoot.addView((View) ZeusTransformUtils.preCheckCast(this.mTabsContainer, View.class, "com.obric.aiagent.plugin"));
        this.mDividerWidth = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), dp2px(1.0f));
        this.mDividerPadding = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.mTextsize = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), sp2px(12.0f));
        this.mTextSelectColor = r3.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), this.mContext.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_text_1, "color", "oui_text_1")));
        this.mTextUnselectColor = r3.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.mContext.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_text_3b, "color", "oui_text_3b")));
        boolean r7 = false;
        this.mTextBold = r3.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textBold, "styleable", "OTabLayout_tab_textBold"), 0);
        this.mTextAllCaps = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.mTabSpaceEqual = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.mTabWidth = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), dp2px(-1.0f));
        int r4 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.mTabSpaceEqual == false) goto L5;
    L8:
        int r9 = dp2px(0.0f);
    L9:
        this.mTabPadding = r3.getDimension(r4, r9);
        this.mBarColor = r3.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), -1);
        this.mBarStrokeColor = r3.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.mBarColor);
        this.mBarStrokeWidth = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), dp2px(0.0f));
        this.mVibrateOnTabSelected = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), false);
        initShadows(r1, r3);
        if (r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetFitInsetBottom, "styleable", "OTabLayout_oui_widgetFitInsetBottom"), true) == false) goto L13;
        com.obric.oui.window.a r2 = com.obric.oui.window.a.f36851a;
        updateLayoutForInsetBottom(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), null, true).f36824e);
        setOnApplyWindowInsetsListener(new $$Lambda$OBottomToolBar$Vj9QKW5Wm3jtmnxPQ1kvbuZSPg(this));
    L13:
        if (this.enableMaterial == false) goto L28;
        this.materialSrcType = r3.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        String r5 = r3.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetMaterial, "styleable", "OTabLayout_oui_widgetMaterial"));
        if (r5 != null) goto L17;
        r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));
    L17:
        com.obric.oui.material.c[] r11 = MaterialToken.parseSet(r5, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")));
        r3.recycle();
        if (r11 == null) goto L20;
        r7 = true;
    L20:
        this.enableMaterial = r7;
        this.materialApplied = r7;
        if (r7 == false) goto L28;
        if (r11 == null) goto L28;
        if (this.materialSrcType == (-1)) goto L27;
        k.a((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), r11, false, this.materialSrcType, null, 10, null);
        goto L28
    L27:
        k.a((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), r11, false, 0, null, 14, null);
    L28:
        setShadowCornerRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        return;
    L5:
        if (this.mTabWidth > 0.0f) goto L8;
        r9 = dp2px(10.0f);
        goto L9
    }

    /* JADX INFO: renamed from: obtainAttributes$lambda-4, reason: not valid java name */
    private static final WindowInsets m1158obtainAttributes$lambda4(OBottomToolBar r1, View r2, WindowInsets r3) {
        o.e(r1, "this$0");
        o.e(r2, "$noName_0");
        o.e(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f36851a;
        r1.updateLayoutForInsetBottom(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r3, true).f36824e);
        return r3;
    }

    private final boolean isDarkTheme() {
        int r0 = this.mBarColor;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        return com.obric.oui.color.d.a(r0);
    }

    public final void updateLayoutForInsetBottom(int r3) {
        i.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), n.c(0, r3));
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

    private final void setShadow() {
        a(new j(this.mContext.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.black_30, "color", "black_30")), com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 20), com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10), com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 10), com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0.5d), null, 0.0f, 96, null), null);
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
        OSegmentTabMiniView r6 = OSegmentTabMiniView.Companion.a(this.mContext);
        r6.setOriginTextColor(this.mTextSelectColor, this.mTextUnselectColor);
        r6.setOriginIconAlpha(255);
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        ((OSegmentTabMiniView) ZeusTransformUtils.preCheckCast(r7, OSegmentTabMiniView.class, "com.obric.aiagent.plugin")).setTag(Integer.valueOf(r2));
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
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
        View r1 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon_small, DbHelper.COL_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.aiagent.plugin");
        String[] r4 = this.mTitles;
        x r5 = null;
        Drawable r6 = null;
        if (r4 != null) goto L6;
        x r7 = null;
    L15:
        if (r7 != null) goto L17;
        OBottomToolBar r10 = (OBottomToolBar) ZeusTransformUtils.preCheckCast(this, OBottomToolBar.class, "com.obric.aiagent.plugin");
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
        OBottomToolBar r0 = (OBottomToolBar) ZeusTransformUtils.preCheckCast(this, OBottomToolBar.class, "com.obric.aiagent.plugin");
        r3.setVisibility(8);
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r12, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r13.setMargins(0, 0, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L27:
        r9.setOnTouchListener(new $$Lambda$OBottomToolBar$N1A6x8M4SNbPPPtp2xdAUFTebA(this));
        r9.setOnClickListener(new $$Lambda$OBottomToolBar$dQ2zmptOPpkZzAy12cMN_QEnxmM(this));
        this.tabList.add(r9);
        if (this.mTabSpaceEqual == false) goto L30;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 52), -1, 1.0f);
    L32:
        if (this.mTabWidth <= 0.0f) goto L34;
        r14 = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
    L34:
        this.mTabsContainer.addView(r9, r8, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.mTabsContainer.setPadding(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12), 0);
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

    /* JADX INFO: renamed from: addTab$lambda-14, reason: not valid java name */
    private static final boolean m1154addTab$lambda14(OBottomToolBar r1, View r2, MotionEvent r3) {
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

    /* JADX INFO: renamed from: addTab$lambda-15, reason: not valid java name */
    private static final void m1155addTab$lambda15(OBottomToolBar r3, View r4) {
        o.e(r3, "this$0");
        if (r3.mVibrateOnTabSelected == false) goto L5;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
    L5:
        Object r5 = r4.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (r3.mCurrentTab == r6) goto L12;
        r3.setCurrentTab(r6);
        c r7 = r3.mListener;
        if (r7 == null) goto L18;
        if (r7 == null) goto L21;
        r7.a(r6);
        return;
    L21:
        return;
    L18:
        return;
    L12:
        c r8 = r3.mListener;
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
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(this.mTabsContainer.getChildAt(r1).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon_small, DbHelper.COL_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.width = r7;
        r5.height = r8;
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1 = r2;
        goto L3
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r3) {
        this.materialApplied = r3;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), this.materialApplied, this.isBackdropView);
        invalidate();
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        k.a((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        k.c((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r3) {
        this.materialSrcType = r3;
        k.a((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        o.e(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        doPressAnim(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        doPressAnim(true);
        goto L11
    }

    private final void doPressAnim(boolean r5) {
        d r0 = this.pressAnim;
        if (r0 == null) goto L6;
        d.a(r0, false, 1, null);
    L6:
        d r1 = this.releaseAnim;
        if (r1 == null) goto L11;
        d.a(r1, false, 1, null);
    L11:
        if (r5 == false) goto L13;
        this.pressAnim = com.obric.oui.common.style.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.initScale, this.pressScale, getCurrentShadows(), this.shadowsPressed);
        return;
    L13:
        this.releaseAnim = com.obric.oui.common.style.k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.pressScale, this.initScale, getCurrentShadows(), this.shadowsNormal);
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
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
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
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon_small, DbHelper.COL_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.aiagent.plugin");
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
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon_small, DbHelper.COL_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.aiagent.plugin");
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
        OSegmentTabMiniView r13 = (OSegmentTabMiniView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabMiniView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L24;
        r13.updateSelectState(r5);
    L24:
        r2 = r3;
        goto L3
    L19:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabMiniView.class) == false) goto L17;
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

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        o.e(r13, "canvas");
        super.onDraw(r13);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.tabCount <= 0) goto L21;
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        if (this.materialApplied == true) goto L11;
        this.barPaint.setColor(this.mBarColor);
        this.barRectF.set(0.0f, getPaddingTop(), getWidth(), r0 - getPaddingBottom());
        com.obric.oui.common.style.l.a(r13, this.barRectF, this.barCornerRadiusPx, this.barPaint);
    L11:
        if (this.mBarStrokeWidth <= 0.0f) goto L13;
        this.barStrokePaint.setColor(this.mBarStrokeColor);
        this.barStrokePaint.setStrokeWidth(this.mBarStrokeWidth);
        float r5 = 2;
        this.barStrokeRectF.set(this.mBarStrokeWidth / r5, getPaddingTop() + (this.mBarStrokeWidth / r5), getWidth() - (this.mBarStrokeWidth / r5), (r0 - getPaddingBottom()) - (this.mBarStrokeWidth / r5));
    L13:
        float r2 = this.mDividerWidth;
        if (r2 <= 0.0f) goto L20;
        this.mDividerPaint.setStrokeWidth(r2);
        this.mDividerPaint.setColor(this.mDividerColor);
        int r3 = 0;
        int r4 = this.tabCount - 1;
    L16:
        if (r3 >= r4) goto L22;
        int r6 = r3 + 1;
        View r7 = this.mTabsContainer.getChildAt(r3);
        r13.drawLine(r7.getRight() + r1, this.mDividerPadding, r7.getRight() + r1, r0 - this.mDividerPadding, this.mDividerPaint);
        r3 = r6;
        goto L16
    L22:
        return;
    L20:
        return;
    }

    public final int getCurrentTab() {
        return this.mCurrentTab;
    }

    public final void setCurrentTab(int r2) {
        int r0 = this.mCurrentTab;
        if (r2 != r0) goto L5;
        return;
    L5:
        this.mLastTab = r0;
        this.mCurrentTab = r2;
        updateTabSelection(r2);
        setFragments(r2);
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
        View r2 = this.mTabsContainer.getChildAt(r3).findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
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
        View r10 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
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

    public final void setOnTabSelectListener(c r3) {
        this.mListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
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
        this.barCornerRadiusPx = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99);
    }

    private final int dp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
