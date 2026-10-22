package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.d.i;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: OBottomNavActionBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomNavActionBar extends OUIFrameLayout implements g {
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
    private View currentTabView;
    private boolean enableMaterial;
    private float indicatorCornerRadius;
    private final ONaviIndicatorDrawable indicatorDrawable;
    private int indicatorSpacing;
    private float initScale;
    private boolean isBackdropView;
    private boolean isIndicatorAnimEnable;
    private boolean isIndicatorBounceEnable;
    private int lastLayoutWidth;
    private int mBarColor;
    private int mBarStrokeColor;
    private float mBarStrokeWidth;
    private int mContainerViewId;
    private OUIFrameLayout mContentRoot;
    private final Context mContext;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private float mDividerPadding;
    private final Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private int mHeight;
    private final SparseArray<Boolean> mInitSetMap;
    private boolean mIsFirstDraw;
    private int mLastTabIndex;
    private d mListener;
    private int mPressedTab;
    private c mSelectAnimListener;
    private Drawable[] mTabDrawables;
    private float mTabPadding;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private final LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private final Paint mTextPaint;
    private int mTextSelectColor;
    private float mTextSize;
    private int mTextUnselectColor;
    private String[] mTitles;
    private boolean mVibrateOnTabSelected;
    private boolean materialApplied;
    private int materialSrcType;
    private com.obric.common.oea.foundation.animation.manager.d pressAnim;
    private float pressScale;
    private com.obric.common.oea.foundation.animation.manager.d releaseAnim;
    private List<j> shadowsNormal;
    private List<j> shadowsPressed;
    private int tabCount;
    private List<View> tabList;

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public final class PointEvaluator implements TypeEvaluator<b> {
        final /* synthetic */ OBottomNavActionBar this$0;

        public PointEvaluator(OBottomNavActionBar r2) {
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

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomNavActionBar f36142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f36143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f36144c;

        public b(OBottomNavActionBar r2) {
            o.e(r2, "this$0");
            this.f36142a = r2;
        }

        public final float a() {
            return this.f36143b;
        }

        public final void a(float r1) {
            this.f36143b = r1;
        }

        public final float b() {
            return this.f36144c;
        }

        public final void b(float r1) {
            this.f36144c = r1;
        }

        public String toString() {
            return "(left = " + this.f36143b + ", right = " + this.f36144c + ')';
        }
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public interface c {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public interface d {
        void a(int r1);

        void b(int r1);
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    public static final class e implements ONaviIndicatorDrawable.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomNavActionBar f36145a;

        e(OBottomNavActionBar r1) {
            this.f36145a = r1;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.a
        public void a() {
            c r0 = OBottomNavActionBar.access$getMSelectAnimListener$p(this.f36145a);
            if (r0 == null) goto L7;
            r0.a();
            return;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.a
        public void b() {
            c r0 = OBottomNavActionBar.access$getMSelectAnimListener$p(this.f36145a);
            if (r0 == null) goto L7;
            r0.b();
            return;
        }

        @Override // com.obric.oui.segmentedtab.ONaviIndicatorDrawable.a
        public void c() {
            c r0 = OBottomNavActionBar.access$getMSelectAnimListener$p(this.f36145a);
            if (r0 == null) goto L7;
            r0.c();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public OBottomNavActionBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomNavActionBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void isIndicatorBounceEnable$annotations() {
    }

    public static /* synthetic */ boolean lambda$7258ncJ1iWxieQXegYqFwneHHUc(OBottomNavActionBar r0, View r1, MotionEvent r2) {
        return m1152addTab$lambda16(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Y4uTlwuKRCxhtGmggx87tRUucZI(OBottomNavActionBar r0, View r1) {
        m1153addTab$lambda17(r0, r1);
    }

    public /* synthetic */ OBottomNavActionBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ c access$getMSelectAnimListener$p(OBottomNavActionBar r0) {
        return r0.mSelectAnimListener;
    }

    public OBottomNavActionBar(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13, null, 8, null);
        this.tabList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.mPressedTab = -1;
        this.mDividerPaint = new Paint(1);
        this.indicatorDrawable = new ONaviIndicatorDrawable();
        this.isIndicatorAnimEnable = true;
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.barPaint = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        this.barStrokePaint = r1;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.pressScale = 0.988f;
        this.initScale = 1.0f;
        this.isBackdropView = true;
        this.materialSrcType = -1;
        this.lastLayoutWidth = -1;
        if (k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        boolean r16 = false;
    L8:
        this.enableMaterial = r16;
        this.materialApplied = r16;
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = ZeusTransformUtils.wrapperContext(r14, "com.obric.aiagent.plugin");
        this.mTabsContainer = new LinearLayout(r14);
        OUIFrameLayout r17 = new OUIFrameLayout(r14, null, 0, null, 14, null);
        this.mContentRoot = r17;
        r17.setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        this.mContentRoot.setChangeAlphaWhenPress(false);
        this.mContentRoot.setChangeAlphaWhenDisable(false);
        this.mContentRoot.setChangeAlphaWhenSelected(false);
        addView((View) ZeusTransformUtils.preCheckCast(this.mContentRoot, View.class, "com.obric.aiagent.plugin"));
        o.a(r15);
        String r18 = r15.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (o.a(r18, "-1") == false) goto L12;
        return;
    L12:
        if (o.a(r18, "-2") == true) goto L17;
        TypedArray r19 = r14.obtainStyledAttributes(r15, new int[]{R.attr.layout_height});
        o.c(r19, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.mHeight = r19.getDimensionPixelSize(0, -2);
        r19.recycle();
        return;
    L17:
        return;
    L5:
        if (l.d() == false) goto L7;
        r16 = true;
        goto L8
    }

    public final List<View> getTabList() {
        return this.tabList;
    }

    public final void setTabList(List<View> r3) {
        List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.tabList = r4;
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    public final int getIndicatorSpacing() {
        return this.indicatorSpacing;
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

    public final void obtainAttributes(Context r14, AttributeSet r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        this.indicatorDrawable.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
        TypedArray r18 = r16.obtainStyledAttributes(r17, com.obric.aiagent.plugin.R.styleable.OTabLayout);
        o.c(r18, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.indicatorDrawable.setIndicatorColor(r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_fill_element_3, "color", "oui_fill_element_3"))));
        this.indicatorDrawable.setIndicatorHeight(r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f));
        this.indicatorDrawable.setIndicatorCornerRadius(r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f));
        setIndicatorCornerRadius(this.indicatorDrawable.getIndicatorCornerRadius());
        this.indicatorSpacing = r18.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), dp2px(4.0f));
        this.indicatorDrawable.setEnableAnimation(r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false));
        this.isIndicatorBounceEnable = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);
        this.mTabsContainer.setPadding(getIndicatorSpacing(), 0, getIndicatorSpacing(), 0);
        this.mContentRoot.addView((View) ZeusTransformUtils.preCheckCast(this.mTabsContainer, View.class, "com.obric.aiagent.plugin"));
        this.mDividerColor = r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_color, "styleable", "OTabLayout_divider_color"), this.indicatorDrawable.getIndicatorColor());
        this.mDividerWidth = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), 0.0f);
        this.mDividerPadding = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.mTextSize = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), dp2px(10.0f));
        this.mTextSelectColor = r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), this.mContext.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_text_1, "color", "oui_text_1")));
        this.mTextUnselectColor = r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.mContext.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_text_3b, "color", "oui_text_3b")));
        this.mTextAllCaps = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.mTabSpaceEqual = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.mTabWidth = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), dp2px(-1.0f));
        int r0 = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.mTabSpaceEqual == false) goto L5;
    L8:
        int r4 = dp2px(0.0f);
    L9:
        this.mTabPadding = r18.getDimension(r0, r4);
        this.mBarColor = r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);
        this.mBarStrokeColor = r18.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.mBarColor);
        this.mBarStrokeWidth = r18.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), dp2px(0.0f));
        this.mVibrateOnTabSelected = r18.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), false);
        initShadows(r16, r18);
        setShadowCornerRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        if (this.enableMaterial == false) goto L29;
        this.materialSrcType = r18.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        String r19 = r18.getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OTabLayout_oui_widgetMaterial, "styleable", "OTabLayout_oui_widgetMaterial"));
        if (r19 != null) goto L14;
        r19 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.oui_material_bg_floating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_material_bg_floating"));
    L14:
        com.obric.oui.material.c[] r7 = MaterialToken.parseSet(r19, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")));
        if (r7 == null) goto L17;
        boolean r110 = true;
    L18:
        this.enableMaterial = r110;
        this.materialApplied = r110;
        r18.recycle();
        if (this.materialApplied == false) goto L30;
        setEnableShadowWidthRadius(true);
        setRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        if (r7 == null) goto L31;
        int r111 = this.materialSrcType;
        if (r111 != (-1)) goto L27;
        r111 = 2;
    L27:
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r7, false, r111, null, 10, null);
        GradientDrawable r112 = new GradientDrawable();
        r112.setShape(0);
        r112.setCornerRadius(com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        r112.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r112, Drawable.class, "com.obric.aiagent.plugin"));
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r110 = false;
        goto L18
    L29:
        return;
    L5:
        if (this.mTabWidth > 0.0f) goto L8;
        r4 = dp2px(10.0f);
        goto L9
    }

    private final boolean isDarkTheme() {
        int r0 = this.mBarColor;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        return com.obric.oui.color.d.a(r0);
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

    public final void setTabTitle(int r3, String r4) {
        o.e(r4, DBDefinition.TITLE);
        String[] r0 = this.mTitles;
        if (r0 == null) goto L12;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= r0.length) goto L11;
        r0[r3] = r4;
        updateTabContent(r3);
        return;
    L11:
        return;
    }

    public final void setTabDrawable(int r3, Drawable r4) {
        o.e(r4, "drawable");
        Drawable[] r0 = this.mTabDrawables;
        if (r0 == null) goto L12;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= r0.length) goto L11;
        r0[r3] = r4;
        updateTabContent(r3);
        return;
    L11:
        return;
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
        this.mCurrentTabIndex = r8;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r0.get(this.mCurrentTabIndex), Fragment.class, "com.obric.aiagent.plugin");
    }

    private final void notifyDataSetChanged() {
        this.mIsFirstDraw = true;
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        Iterator<View> r3 = this.tabList.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin")).setEnabled(r4);
        goto L4
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r5) {
        if (this.materialApplied != r5) goto L5;
        return;
    L5:
        this.materialApplied = r5;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.materialApplied, this.isBackdropView);
        if (this.materialApplied == false) goto L8;
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(0);
        r6.setCornerRadius(com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99));
        r6.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.aiagent.plugin"));
    L8:
        invalidate();
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r3) {
        this.materialSrcType = r3;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    private final void addTab(int r11, View r12) {
        View r1 = r12.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        int r4 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2);
        String[] r5 = this.mTitles;
        x r7 = null;
        Drawable r8 = null;
        if (r5 != null) goto L6;
        x r6 = null;
    L15:
        if (r6 != null) goto L17;
        OBottomNavActionBar r9 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(this, OBottomNavActionBar.class, "com.obric.aiagent.plugin");
        r2.setVisibility(8);
    L17:
        Drawable[] r10 = this.mTabDrawables;
        if (r10 == null) goto L24;
        if (r10 == null) goto L23;
        r8 = r10[r11];
    L23:
        r3.setImageDrawable(r8);
        r7 = x.f38692a;
    L24:
        if (r7 != null) goto L26;
        OBottomNavActionBar r0 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(this, OBottomNavActionBar.class, "com.obric.aiagent.plugin");
        r3.setVisibility(8);
        ViewGroup.LayoutParams r13 = r2.getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r13, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r14.setMargins(0, r4, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L26:
        r12.setOnTouchListener(new $$Lambda$OBottomNavActionBar$7258ncJ1iWxieQXegYqFwneHHUc(this));
        r12.setOnClickListener(new $$Lambda$OBottomNavActionBar$Y4uTlwuKRCxhtGmggx87tRUucZI(this));
        this.tabList.add(r12);
        if (this.mTabSpaceEqual == false) goto L29;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L31:
        if (this.mTabWidth <= 0.0f) goto L33;
        r15 = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
    L33:
        this.mTabsContainer.addView(r12, r11, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L29:
        r15 = new LinearLayout.LayoutParams(-2, -1);
        goto L31
    L6:
        if (r5 != null) goto L9;
    L7:
        Object r16 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        r2.setText((CharSequence) r16);
        ViewGroup.LayoutParams r17 = r2.getLayoutParams();
        Objects.requireNonNull(r17, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r17, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r18.setMargins(0, r4, 0, 0);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r6 = x.f38692a;
        goto L15
    L9:
        String r19 = r5[r11];
        if (r19 == null) goto L7;
        r16 = ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin");
        goto L13
    }

    /* JADX INFO: renamed from: addTab$lambda-16, reason: not valid java name */
    private static final boolean m1152addTab$lambda16(OBottomNavActionBar r1, View r2, MotionEvent r3) {
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

    /* JADX INFO: renamed from: addTab$lambda-17, reason: not valid java name */
    private static final void m1153addTab$lambda17(OBottomNavActionBar r3, View r4) {
        o.e(r3, "this$0");
        if (r3.mVibrateOnTabSelected == false) goto L5;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
    L5:
        Object r5 = r4.getTag();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r3.setCurrentTab(((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());
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
        com.obric.common.oea.foundation.animation.manager.d r0 = this.pressAnim;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
    L6:
        com.obric.common.oea.foundation.animation.manager.d r1 = this.releaseAnim;
        if (r1 == null) goto L11;
        com.obric.common.oea.foundation.animation.manager.d.a(r1, false, 1, null);
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
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        float r5 = this.mTabPadding;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        if (r2 != this.mCurrentTabIndex) goto L7;
        boolean r8 = true;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L11;
        ((OSegmentTabView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabView.class, "com.obric.aiagent.plugin")).updateSelectState(r8);
        r7.setTextSize(0, this.mTextSize);
    L15:
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        if (r8 == false) goto L18;
        int r10 = this.mTextSelectColor;
    L19:
        r9.setImageTintList(ColorStateList.valueOf(r10));
        if (this.mTextAllCaps == false) goto L22;
        String r11 = r7.getText().toString();
        Locale r12 = Locale.ROOT;
        o.c(r12, "ROOT");
        String r13 = r11.toUpperCase(r12);
        o.c(r13, "this as java.lang.String).toUpperCase(locale)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"));
    L22:
        if (r8 == false) goto L24;
        this.currentTabView = r4;
    L24:
        r2 = r3;
        goto L3
    L18:
        r10 = this.mTextUnselectColor;
        goto L19
    L11:
        if (r8 == false) goto L13;
        int r14 = this.mTextSelectColor;
    L14:
        r7.setTextColor(r14);
        r7.setTextSize(0, this.mTextSize);
        goto L15
    L13:
        r14 = this.mTextUnselectColor;
        goto L14
    L7:
        r8 = false;
        goto L9
    }

    private final void updateTabContent(int r7) {
        View r0 = this.mTabsContainer.getChildAt(r7);
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_title, DbHelper.COL_ID, "tv_tab_title"));
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        ImageView r3 = (ImageView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        String[] r4 = this.mTitles;
        if (r4 != null) goto L6;
    L14:
        Drawable[] r6 = this.mTabDrawables;
        if (r6 == null) goto L22;
        if (r6 != null) goto L19;
        Drawable r8 = null;
    L20:
        r3.setImageDrawable(r8);
        return;
    L19:
        r8 = r6[r7];
        goto L20
    L22:
        return;
    L6:
        if (r4 != null) goto L9;
    L7:
        Object r5 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
    L13:
        r2.setText((CharSequence) r5);
        goto L14
    L9:
        String r9 = r4[r7];
        if (r9 == null) goto L7;
        r5 = ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        goto L13
    }

    private final void updateTabSelection(int r9) {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        if (r2 != r9) goto L7;
        boolean r5 = true;
    L8:
        ImageView r6 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tab_icon, DbHelper.COL_ID, "tv_tab_icon")), ImageView.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L11;
        int r7 = this.mTextSelectColor;
    L12:
        r6.setImageTintList(ColorStateList.valueOf(r7));
        com.obric.oui.d.c r8 = com.obric.oui.d.c.f35012a;
        View r10 = null;
        if (r4 != null) goto L16;
    L18:
        OSegmentTabView r11 = (OSegmentTabView) ZeusTransformUtils.preCheckCast(r10, OSegmentTabView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L22;
        r11.updateSelectState(r5);
    L22:
        if (r5 == false) goto L24;
        this.currentTabView = r4;
    L24:
        r2 = r3;
        goto L3
    L16:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L18;
        r10 = r4;
        goto L18
    L11:
        r7 = this.mTextUnselectColor;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    private final void trackNewTabPosition() {
        View r0 = this.currentTabView;
        o.a(r0);
        float r1 = r0.getLeft();
        View r2 = this.currentTabView;
        o.a(r2);
        float r3 = r2.getRight();
        ONaviIndicatorDrawable r4 = this.indicatorDrawable;
        r4.updateBound(r1, this.indicatorSpacing, r3 - r1, r4.getIndicatorHeight());
    }

    private final void calcIndicatorRect() {
        if (this.indicatorDrawable.isAnimRunning() == true) goto L6;
        View r0 = this.currentTabView;
        o.a(r0);
        float r1 = r0.getLeft();
        View r2 = this.currentTabView;
        o.a(r2);
        float r3 = r2.getRight();
        ONaviIndicatorDrawable r4 = this.indicatorDrawable;
        r4.setBound(r1, this.indicatorSpacing + this.mBarStrokeWidth, r3 - r1, r4.getIndicatorHeight());
        return;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        o.e(r2, "drawable");
        super.invalidateDrawable(r2);
        if (o.a(r2, this.indicatorDrawable) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r3) {
        o.e(r3, "canvas");
        super.onDraw(r3);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.tabCount <= 0) goto L10;
        float r0 = this.indicatorDrawable.getIndicatorCornerRadius() + (this.indicatorSpacing / 2);
        drawBar(r3, r0);
        drawStroke(r3, r0);
        drawDivider(r3);
        drawIndicator(r3);
        return;
    }

    private final void drawBar(Canvas r7, float r8) {
        if (this.materialApplied == false) goto L5;
        return;
    L5:
        this.barPaint.setColor(this.mBarColor);
        this.barRectF.set(0.0f, getPaddingTop(), getWidth(), getHeight() - getPaddingBottom());
        com.obric.oui.common.style.l.a(r7, this.barRectF, r8, this.barPaint);
    }

    private final void drawStroke(Canvas r8, float r9) {
        if (this.mBarStrokeWidth <= 0.0f) goto L6;
        this.barStrokePaint.setColor(this.mBarStrokeColor);
        this.barStrokePaint.setStrokeWidth(this.mBarStrokeWidth);
        float r2 = 2;
        this.barStrokeRectF.set(this.mBarStrokeWidth / r2, getPaddingTop() + (this.mBarStrokeWidth / r2), getWidth() - (this.mBarStrokeWidth / r2), (getHeight() - getPaddingBottom()) - (this.mBarStrokeWidth / r2));
        com.obric.oui.common.style.l.a(r8, this.barStrokeRectF, r9, this.barStrokePaint);
        return;
    }

    private final void drawDivider(Canvas r11) {
        if (this.indicatorDrawable.getEnableAnimation() == true) goto L9;
        float r0 = this.mDividerWidth;
        if (r0 <= 0.0f) goto L11;
        this.mDividerPaint.setStrokeWidth(r0);
        this.mDividerPaint.setColor(this.mDividerColor);
        int r1 = 0;
        int r2 = this.tabCount - 1;
    L7:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        View r4 = this.mTabsContainer.getChildAt(r1);
        r11.drawLine(getPaddingLeft() + r4.getRight(), this.mDividerPadding, getPaddingLeft() + r4.getRight(), getHeight() - this.mDividerPadding, this.mDividerPaint);
        r1 = r3;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private final void drawIndicator(Canvas r3) {
        if (this.indicatorDrawable.getEnableAnimation() == true) goto L5;
        calcIndicatorRect();
    L8:
        r3.translate(getPaddingLeft(), getPaddingTop());
        this.indicatorDrawable.draw(r3);
        r3.translate(-getPaddingLeft(), -getPaddingTop());
        return;
    L5:
        if (this.mIsFirstDraw == false) goto L8;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L8
    }

    public final int getCurrentTab() {
        return this.mCurrentTabIndex;
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.mCurrentTabIndex;
        if (r3 != r0) goto L10;
        d r2 = this.mListener;
        if (r2 == null) goto L20;
        if (r2 == null) goto L21;
        r2.b(r0);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        this.mIsFirstDraw = true;
        this.mLastTabIndex = r0;
        this.mCurrentTabIndex = r3;
        updateTabSelection(r3);
        setFragments(r3);
        d r4 = this.mListener;
        if (r4 == null) goto L16;
        if (r4 == null) goto L16;
        r4.a(this.mCurrentTabIndex);
    L16:
        if (this.indicatorDrawable.getEnableAnimation() == false) goto L18;
        trackNewTabPosition();
        return;
    L18:
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
        return this.indicatorDrawable.getIndicatorColor();
    }

    public final void setIndicatorColor(int r1) {
        this.indicatorDrawable.setIndicatorColor(r1);
    }

    public final float getIndicatorHeight() {
        return this.indicatorDrawable.getIndicatorHeight();
    }

    public final void setIndicatorHeight(float r2) {
        this.indicatorDrawable.setIndicatorHeight(dp2px(r2));
    }

    public final float getIndicatorCornerRadius() {
        return this.indicatorCornerRadius;
    }

    public final void setIndicatorCornerRadius(float r2) {
        this.indicatorDrawable.setIndicatorCornerRadius(dp2px(r2));
        this.indicatorCornerRadius = this.indicatorDrawable.getIndicatorCornerRadius();
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

    public final float getTextSize() {
        return this.mTextSize;
    }

    public final void setTextSize(float r1) {
        this.mTextSize = sp2px(r1);
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
        this.mTextPaint.setTextSize(this.mTextSize);
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
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        this.mSelectAnimListener = r4;
        if (r4 != null) goto L6;
        this.indicatorDrawable.setAnimListener(null);
        return;
    L6:
        this.indicatorDrawable.setAnimListener((ONaviIndicatorDrawable.a) ZeusTransformUtils.preCheckCast(new e(this), ONaviIndicatorDrawable.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putInt("mCurrentTab", this.mCurrentTabIndex);
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        return (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
        o.e(r5, "state");
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L12;
        int r0 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin")).getInt("mCurrentTab");
        this.mCurrentTabIndex = r0;
        this.mLastTabIndex = r0;
        r5 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin")).getParcelable("instanceState");
        if (this.mCurrentTabIndex == 0) goto L12;
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.mTabsContainer, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount() == 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        updateTabSelection(this.mCurrentTabIndex);
        goto L12
    L9:
        r1 = false;
    L12:
        super.onRestoreInstanceState(r5);
    }

    private final int dp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.indicatorDrawable.checkAndInitHeightAndRadius(getHeight(), this.indicatorSpacing);
        if (getWidth() == this.lastLayoutWidth) goto L6;
        this.lastLayoutWidth = getWidth();
        this.mIsFirstDraw = true;
        return;
    }
}
