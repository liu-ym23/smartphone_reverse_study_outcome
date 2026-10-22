package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.h.b.o;
import d.k;
import d.l.n;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OCarouselIndicator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OCarouselIndicator extends OBaseIndicator {
    public static final a Companion = null;
    private static final int DEFAULT_CORNER_RADIUS = 100;
    private static final float DEFAULT_DOT_HEIGHT_DP = 6.0f;
    private static final float DEFAULT_DOT_SPACING_DP = 4.0f;
    private static final float DEFAULT_DOT_WIDTH_DP = 6.0f;
    private static final float EDGE_DOT_SCALE = 0.5f;
    private static final boolean IF_DEBUG = false;
    private static final float SIZE_STYLE_SMALL_DP = 4.0f;
    private static final float SIZE_STYLE_SMALL_SPACING_DP = 2.0f;
    private static final float SMALL_PIC_BACKGROUND_HORIZONTAL_PADDING_DP = 4.0f;
    private static final float SMALL_PIC_BACKGROUND_VERTICAL_PADDING_DP = 4.0f;
    private static final float START_ICON_DOT_SIZE_DP = 10.0f;
    private static final float START_ICON_SMALL_DOT_SIZE_DP = 6.0f;
    public static final String TAG = "OCarouselIndicator";
    private final ArgbEvaluator argbEvaluator;
    private LinearLayout dotsTrackLayout;
    private IndicatorGroupLayout groupLayout;
    private boolean hasExplicitDotsHeight;
    private boolean hasExplicitDotsSpacing;
    private boolean hasExplicitDotsWidth;
    private com.obric.oui.indicator.b indicatorAnimator;
    private int maxVisibleDots;
    private final ArrayDeque<IndicatorDotView> recycledDefaultDots;
    private final List<c> renderedSlot;
    private int selectedDotColor;
    private int sizeStyle;
    private IndicatorImageDotView startDrawableDotView;
    private final DecelerateInterpolator viewportTransitionInterpolator;

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f35352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f35353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f35354c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(Float.valueOf(this.f35352a), Float.valueOf(r6.f35352a)) == true) goto L12;
            return false;
        L12:
            if (o.a(Float.valueOf(this.f35353b), Float.valueOf(r6.f35353b)) == true) goto L15;
            return false;
        L15:
            if (o.a(Float.valueOf(this.f35354c), Float.valueOf(r6.f35354c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f35352a) * 31) + Float.hashCode(this.f35353b)) * 31) + Float.hashCode(this.f35354c);
        }

        public String toString() {
            return "DotLayoutProfile(width=" + this.f35352a + ", height=" + this.f35353b + ", spacing=" + this.f35354c + ')';
        }

        public b(float r1, float r2, float r3) {
            this.f35352a = r1;
            this.f35353b = r2;
            this.f35354c = r3;
        }

        public final float a() {
            return this.f35352a;
        }

        public final float b() {
            return this.f35353b;
        }

        public final float c() {
            return this.f35354c;
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f35355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f35356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.oui.indicator.e f35357c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f35355a, r6.f35355a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f35356b, r6.f35356b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f35357c, r6.f35357c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f35355a.hashCode() * 31) + this.f35356b.hashCode()) * 31) + this.f35357c.hashCode();
        }

        public String toString() {
            return "RenderSlot(binding=" + this.f35355a + ", view=" + this.f35356b + ", indicator=" + this.f35357c + ')';
        }

        public c(d r3, View r4, com.obric.oui.indicator.e r5) {
            com.obric.oui.indicator.e r6 = (com.obric.oui.indicator.e) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.indicator.e.class, "com.obric.aiagent.plugin");
            o.e(r3, "binding");
            o.e(r4, "view");
            o.e(r6, "indicator");
            this.f35355a = r3;
            this.f35356b = r4;
            this.f35357c = r6;
        }

        public final d a() {
            return this.f35355a;
        }

        public final View b() {
            return this.f35356b;
        }

        public final com.obric.oui.indicator.e c() {
            return this.f35357c;
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    private static abstract class d {

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f35358a = null;

            static {
                f35358a = new a();
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f35359a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (this.f35359a == r6.f35359a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.f35359a);
            }

            public String toString() {
                return "Page(pageIndex=" + this.f35359a + ')';
            }

            public b(int r2) {
                super(null);
                this.f35359a = r2;
            }

            public final int a() {
                return this.f35359a;
            }
        }

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f35360a = null;

            static {
                f35360a = new c();
            }

            private c() {
                super(null);
            }
        }

        public /* synthetic */ d(d.h.b.h r1) {
            this();
        }

        private d() {
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35361a = null;

        static {
            int[] r0 = new int[com.obric.oui.indicator.c.values().length];
            r0[com.obric.oui.indicator.c.f35388c.ordinal()] = 1;
            r0[com.obric.oui.indicator.c.f35389d.ordinal()] = 2;
            f35361a = r0;
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    public static final class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f35362a;

        f(OCarouselIndicator r1) {
            this.f35362a = r1;
        }

        @Override // com.obric.oui.indicator.j
        public void a(int r1, int r2, float r3) {
            OCarouselIndicator.access$applyPageScroll(this.f35362a, r1, r2, r3);
        }

        @Override // com.obric.oui.indicator.j
        public int a() {
            return this.f35362a.pagerCount();
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    public static final class g implements com.obric.oui.indicator.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f35363a;

        g(OCarouselIndicator r1) {
            this.f35363a = r1;
        }

        @Override // com.obric.oui.indicator.b.c
        public int a() {
            return this.f35363a.pagerCount();
        }

        @Override // com.obric.oui.indicator.b.c
        public int b() {
            return this.f35363a.getMaxVisibleDots();
        }

        @Override // com.obric.oui.indicator.b.c
        public boolean a(d.l.j r2) {
            o.e(r2, "targetRange");
            return OCarouselIndicator.access$shouldRebindVisibleSlots(this.f35363a, r2);
        }

        @Override // com.obric.oui.indicator.b.c
        public float c() {
            return OCarouselIndicator.access$resolveViewportStepDistance(this.f35363a);
        }

        @Override // com.obric.oui.indicator.b.c
        public void a(com.obric.oui.indicator.g r2, com.obric.oui.indicator.b.d r3) {
            o.e(r2, "state");
            o.e(r3, "reason");
            OCarouselIndicator.access$rebindVisibleSlots(this.f35363a, r2, r3);
        }

        @Override // com.obric.oui.indicator.b.c
        public void a(com.obric.oui.indicator.g r2) {
            o.e(r2, "state");
            OCarouselIndicator.access$applyViewportState(this.f35363a, r2);
        }

        @Override // com.obric.oui.indicator.b.c
        public void a(com.obric.oui.indicator.g r2, com.obric.oui.indicator.g r3, float r4) {
            o.e(r2, "sourceState");
            o.e(r3, "targetState");
            OCarouselIndicator.access$applyViewportTransitionProgress(this.f35363a, r2, r3, r4);
        }
    }

    static {
        Companion = new a(null);
    }

    public OCarouselIndicator(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCarouselIndicator(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    private final float interpolate(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    public static /* synthetic */ void lambda$KwMov2E5kUBleq0LC3if6S489es(c r0, OCarouselIndicator r1, View r2) {
        m1097bindSlot$lambda12(r0, r1, r2);
    }

    public /* synthetic */ OCarouselIndicator(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public static final /* synthetic */ void access$applyPageScroll(OCarouselIndicator r0, int r1, int r2, float r3) {
        r0.applyPageScroll(r1, r2, r3);
    }

    public static final /* synthetic */ void access$applyViewportState(OCarouselIndicator r0, com.obric.oui.indicator.g r1) {
        r0.applyViewportState(r1);
    }

    public static final /* synthetic */ void access$applyViewportTransitionProgress(OCarouselIndicator r0, com.obric.oui.indicator.g r1, com.obric.oui.indicator.g r2, float r3) {
        r0.applyViewportTransitionProgress(r1, r2, r3);
    }

    public static final /* synthetic */ void access$cancelVisibleDotAnimations(OCarouselIndicator r0) {
        r0.cancelVisibleDotAnimations();
    }

    public static final /* synthetic */ void access$rebindVisibleSlots(OCarouselIndicator r0, com.obric.oui.indicator.g r1, com.obric.oui.indicator.b.d r2) {
        r0.rebindVisibleSlots(r1, r2);
    }

    public static final /* synthetic */ float access$resolveViewportStepDistance(OCarouselIndicator r0) {
        return r0.resolveViewportStepDistance();
    }

    public static final /* synthetic */ boolean access$shouldRebindVisibleSlots(OCarouselIndicator r0, d.l.j r1) {
        return r0.shouldRebindVisibleSlots(r1);
    }

    public OCarouselIndicator(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.renderedSlot = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.recycledDefaultDots = new ArrayDeque();
        this.viewportTransitionInterpolator = new DecelerateInterpolator();
        this.maxVisibleDots = Integer.MAX_VALUE;
        this.selectedDotColor = androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1"));
        this.argbEvaluator = new ArgbEvaluator();
        init(r7);
        setInitComplete();
    }

    public final int getMaxVisibleDots() {
        return this.maxVisibleDots;
    }

    public final void setMaxVisibleDots(int r2) {
        if (this.maxVisibleDots == r2) goto L6;
        this.maxVisibleDots = r2;
        refreshDots();
        return;
    }

    public final int getSizeStyle() {
        return this.sizeStyle;
    }

    public final void setSizeStyle(int r2) {
        if (this.sizeStyle == r2) goto L6;
        this.sizeStyle = r2;
        applySizeStyle();
        updateDotsTrackMinimumHeight();
        refreshDots();
        return;
    }

    public final void setStartDotDrawable(int r5) {
        if (r5 == 0) goto L5;
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
        if (r1 == null) goto L11;
        setStartDotDrawable(r1);
        return;
    L11:
        if (IF_DEBUG == false) goto L17;
        com.obric.oui.d.a.b.c(TAG, o.a("setStartDotDrawable(iconResId) ignored, drawable not found for resId=", Integer.valueOf(r5)));
        return;
    L17:
        return;
    L5:
        if (IF_DEBUG == false) goto L16;
        com.obric.oui.d.a.b.c(TAG, "setStartDotDrawable(iconResId) ignored, iconResId=0");
        return;
    }

    public final void setStartDotDrawable(Drawable r6) {
        o.e(r6, "drawable");
        Drawable.ConstantState r7 = r6.getConstantState();
        if (r7 != null) goto L6;
        com.obric.oui.d.a.b.d(TAG, "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L6:
        Drawable r8 = r7.newDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin")).mutate();
        o.c(r8, "constantState.newDrawable(resources).mutate()");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        this.startDrawableDotView = new IndicatorImageDotView(r3, r8);
        updateDotsTrackMinimumHeight();
        if (IF_DEBUG == false) goto L20;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L11;
    L13:
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        if (o.a(((c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.aiagent.plugin")).a(), new d.b(0)) == false) goto L15;
        r4 = true;
    L19:
        com.obric.oui.d.a.b.b(TAG, o.a("Registered start drawable dot, visible=", Boolean.valueOf(r4)));
        goto L20
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
    L20:
        refreshDots();
    }

    public final int getSelectedDotColor() {
        return this.selectedDotColor;
    }

    public final void setSelectedDotColor(int r4) {
        if (getType() != 1) goto L5;
        this.selectedDotColor = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, "color", "oui_on_accent_text_1"));
        refreshDotsDraws();
        return;
    L5:
        if (this.selectedDotColor == r4) goto L9;
        this.selectedDotColor = r4;
        refreshDotsDraws();
        return;
    }

    private final void init(AttributeSet r12) {
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        IndicatorGroupLayout r0 = new IndicatorGroupLayout(r3, null, 0, 6, null);
        r0.setGravity(17);
        this.groupLayout = r0;
        LinearLayout r1 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r1.setOrientation(0);
        r1.setGravity(17);
        this.dotsTrackLayout = r1;
        IndicatorGroupLayout r5 = null;
        if (getType() != 1) goto L14;
        IndicatorGroupLayout r2 = this.groupLayout;
        if (r2 != null) goto L7;
        o.c("groupLayout");
        r2 = null;
    L7:
        r2.setBgColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.carousel_indicator_bg_color, "color", "carousel_indicator_bg_color")));
        IndicatorGroupLayout r4 = this.groupLayout;
        if (r4 != null) goto L10;
        o.c("groupLayout");
        r4 = null;
    L10:
        r4.setCornerRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 100));
        IndicatorGroupLayout r6 = this.groupLayout;
        if (r6 != null) goto L13;
        o.c("groupLayout");
        r6 = null;
    L13:
        r6.setDrawBackground(true);
    L18:
        IndicatorGroupLayout r7 = this.groupLayout;
        if (r7 != null) goto L21;
        o.c("groupLayout");
        r7 = null;
    L21:
        r7.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r8 = this.groupLayout;
        if (r8 != null) goto L24;
        o.c("groupLayout");
        r8 = null;
    L24:
        LinearLayout r9 = this.dotsTrackLayout;
        if (r9 != null) goto L27;
        o.c("dotsTrackLayout");
        r9 = null;
    L27:
        r8.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        IndicatorGroupLayout r10 = this.groupLayout;
        if (r10 != null) goto L30;
        o.c("groupLayout");
    L31:
        addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, getLayoutHeight()), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.indicatorAnimator = createViewportTransitionAnimator();
        if (r13 == null) goto L34;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "context");
        TypedArray r14 = r11.obtainStyledAttributes(r13, getCustom().d(), 0, 0);
        o.c(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.hasExplicitDotsWidth = r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsWidth, "styleable", "OCarouselIndicator_oui_dotsWidth"));
        this.hasExplicitDotsHeight = r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsHeight, "styleable", "OCarouselIndicator_oui_dotsHeight"));
        this.hasExplicitDotsSpacing = r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsSpacing, "styleable", "OCarouselIndicator_oui_dotsSpacing"));
        setSelectedDotColor(r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_selectedDotColor, "styleable", "OCarouselIndicator_oui_selectedDotColor"), getSelectedDotColor()));
        setMaxVisibleDots(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_maxVisibleDots, "styleable", "OCarouselIndicator_oui_maxVisibleDots"), getMaxVisibleDots()));
        setSizeStyle(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_sizeStyle, "styleable", "OCarouselIndicator_oui_sizeStyle"), 0));
        r14.recycle();
    L34:
        applySizeStyle();
        if (getType() == 1) goto L37;
        return;
    L37:
        if (this.sizeStyle != 1) goto L41;
        applySmallPicBackgroundPadding();
        return;
    L41:
        return;
    L30:
        r5 = r10;
        goto L31
    L14:
        IndicatorGroupLayout r15 = this.groupLayout;
        if (r15 != null) goto L17;
        o.c("groupLayout");
        r15 = null;
    L17:
        r15.setDrawBackground(false);
        goto L18
    }

    private final com.obric.oui.indicator.b createViewportTransitionAnimator() {
        LinearLayout r1 = this.dotsTrackLayout;
        if (r1 != null) goto L6;
        o.c("dotsTrackLayout");
        r1 = null;
    L6:
        return new com.obric.oui.indicator.b((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (TimeInterpolator) ZeusTransformUtils.preCheckCast(this.viewportTransitionInterpolator, TimeInterpolator.class, "com.obric.aiagent.plugin"), (com.obric.oui.indicator.b.c) ZeusTransformUtils.preCheckCast(new g(this), com.obric.oui.indicator.b.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void onRefreshIndicator() {
        updatePicStableContentWidth();
        OBaseIndicator.d r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        renderViewportState(r1, com.obric.oui.indicator.b.d.f35377b);
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void onRefreshDotsDraws() {
        refreshVisibleDotsDraws();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void onRefreshDotsSpacing() {
        updatePicStableContentWidth();
        updateVisibleDotsSpacing();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void onRefreshDotsSize() {
        updateDotsTrackMinimumHeight();
        updatePicStableContentWidth();
        refreshVisibleDotsSize();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public j buildOnPageChangedListener() {
        return (j) ZeusTransformUtils.preCheckCast(new f(this), j.class, "com.obric.aiagent.plugin");
    }

    public final void dispatchManualPageScroll(int r1, int r2, float r3) {
        applyPageScroll(r1, r2, r3);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void addDot(int r3) {
        com.obric.oui.d.a.b.d(TAG, "addDot(index=" + r3 + ") is deprecated. Update adapter/pageCount data first, then rely on observer refresh.");
        refreshDots();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void removeDot(int r3) {
        com.obric.oui.d.a.b.d(TAG, "removeDot(index=" + r3 + ") is deprecated. Update adapter/pageCount data first, then rely on observer refresh.");
        refreshDots();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void refreshDotDraw(int r1) {
        refreshVisibleDotsDraws();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void refreshParentLayout() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r5 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r0 = this.groupLayout;
        if (r0 != null) goto L11;
        o.c("groupLayout");
        r0 = null;
    L11:
        r0.setBgColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.carousel_indicator_bg_color, "color", "carousel_indicator_bg_color")));
        IndicatorGroupLayout r1 = this.groupLayout;
        if (r1 != null) goto L14;
        o.c("groupLayout");
        r1 = null;
    L14:
        r1.setCornerRadius(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 100));
        IndicatorGroupLayout r2 = this.groupLayout;
        if (r2 != null) goto L17;
        o.c("groupLayout");
        r2 = null;
    L17:
        r2.setDrawBackground(true);
    L26:
        if (getType() == 1) goto L28;
    L30:
        IndicatorGroupLayout r3 = this.groupLayout;
        if (r3 != null) goto L33;
        o.c("groupLayout");
        r3 = null;
    L33:
        r3.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
    L34:
        updatePicStableContentWidth();
        IndicatorGroupLayout r4 = this.groupLayout;
        if (r4 != null) goto L37;
        o.c("groupLayout");
        r4 = null;
    L37:
        IndicatorGroupLayout r6 = this.groupLayout;
        if (r6 != null) goto L40;
        o.c("groupLayout");
    L41:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        r7.height = getLayoutHeight();
        r4.setLayoutParams(r7);
        requestLayout();
        return;
    L40:
        r5 = r6;
        goto L41
    L28:
        if (this.sizeStyle != 1) goto L30;
        applySmallPicBackgroundPadding();
        goto L34
    L18:
        IndicatorGroupLayout r8 = this.groupLayout;
        if (r8 != null) goto L21;
        o.c("groupLayout");
        r8 = null;
    L21:
        r8.setBgColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.Transparent, "color", "Transparent")));
        IndicatorGroupLayout r9 = this.groupLayout;
        if (r9 != null) goto L24;
        o.c("groupLayout");
        r9 = null;
    L24:
        r9.setDrawBackground(false);
        goto L26
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OBaseIndicator.a getCustom() {
        float r1 = com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6.0f);
        float r3 = com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6.0f);
        float r4 = com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4.0f);
        int[] r5 = R.styleable.OCarouselIndicator;
        o.c(r5, TAG);
        return new OBaseIndicator.a(r1, r3, r4, r5, ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_type, "styleable", "OCarouselIndicator_oui_type"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_layoutHeight, "styleable", "OCarouselIndicator_oui_layoutHeight"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsWidth, "styleable", "OCarouselIndicator_oui_dotsWidth"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsHeight, "styleable", "OCarouselIndicator_oui_dotsHeight"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsSpacing, "styleable", "OCarouselIndicator_oui_dotsSpacing"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsColor, "styleable", "OCarouselIndicator_oui_dotsColor"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsCornerRadius, "styleable", "OCarouselIndicator_oui_dotsCornerRadius"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsClickable, "styleable", "OCarouselIndicator_oui_dotsClickable"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsStrokeColor, "styleable", "OCarouselIndicator_oui_dotsStrokeColor"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsStrokeWidth, "styleable", "OCarouselIndicator_oui_dotsStrokeWidth"));
    }

    private final b resolveDotLayoutProfile(int r7) {
        b r0 = new b(getCustom().a(), getCustom().b(), getCustom().c());
        if (r7 != 1) goto L6;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        float r9 = com.obric.oui.common.util.g.c(r8, 4.0f);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        float r3 = com.obric.oui.common.util.g.c(r4, 4.0f);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        return new b(r9, r3, com.obric.oui.common.util.g.c(r6, SIZE_STYLE_SMALL_SPACING_DP));
    L6:
        return r0;
    }

    private final void applySmallPicBackgroundPadding() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        int r1 = com.obric.oui.common.util.g.b(r0, 4.0f);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        int r3 = com.obric.oui.common.util.g.b(r2, 4.0f);
        IndicatorGroupLayout r6 = this.groupLayout;
        if (r6 != null) goto L5;
        o.c("groupLayout");
        r6 = null;
    L5:
        r6.setPadding(r1, r3, r1, r3);
    }

    private final void applySizeStyle() {
        b r0 = resolveDotLayoutProfile(this.sizeStyle);
        if (this.hasExplicitDotsWidth == true) goto L6;
        setDotsWidth(r0.a());
    L6:
        if (this.hasExplicitDotsHeight == true) goto L9;
        setDotsHeight(r0.b());
    L9:
        if (this.hasExplicitDotsSpacing == true) goto L12;
        setDotsSpacing(r0.c());
    L12:
        if (IF_DEBUG == false) goto L15;
        com.obric.oui.d.a.b.b(TAG, "sizeStyle=" + this.sizeStyle + " resolved to w=" + getDotsWidth() + " h=" + getDotsHeight() + " spacing=" + getDotsSpacing() + " explicit=[" + this.hasExplicitDotsWidth + ',' + this.hasExplicitDotsHeight + ',' + this.hasExplicitDotsSpacing + ']');
        return;
    }

    private final void renderViewportState(int r2, com.obric.oui.indicator.b.d r3) {
        com.obric.oui.indicator.g r4 = resolveViewportState(pagerCount(), r2);
        com.obric.oui.indicator.b r1 = this.indicatorAnimator;
        if (r1 != null) goto L5;
        o.c("indicatorAnimator");
        r1 = null;
    L5:
        r1.a(r3, r4);
    }

    private final com.obric.oui.indicator.g resolveViewportState(int r1, int r2) {
        return h.a(r1, r2, this.maxVisibleDots);
    }

    private final void applyPageScroll(int r6, int r7, float r8) {
        int r0 = pagerCount();
        com.obric.oui.indicator.g r1 = resolveViewportState(r0, r6);
        com.obric.oui.indicator.g r2 = resolveViewportState(r0, r7);
        com.obric.oui.indicator.b r3 = null;
        if (o.a(r1.b(), r2.b()) == true) goto L9;
        com.obric.oui.indicator.b r4 = this.indicatorAnimator;
        if (r4 != null) goto L7;
        o.c("indicatorAnimator");
    L8:
        renderViewportState(r3.a(r6, r7, r8), com.obric.oui.indicator.b.d.f35376a);
    L14:
        applyScrollColors(r6, r7, r8);
        invalidate();
        return;
    L7:
        r3 = r4;
        goto L8
    L9:
        com.obric.oui.indicator.b r5 = this.indicatorAnimator;
        if (r5 != null) goto L12;
        o.c("indicatorAnimator");
    L13:
        r3.a(com.obric.oui.indicator.b.d.f35377b, r1);
        applyViewportTransitionProgress(r1, r2, r8);
        goto L14
    L12:
        r3 = r5;
        goto L13
    }

    private final float resolveViewportStepDistance() {
        return getDotsWidth() + (getDotsSpacing() * SIZE_STYLE_SMALL_SPACING_DP);
    }

    private final void updatePicStableContentWidth() {
        Integer r0 = resolvePicStableContentWidth();
        IndicatorGroupLayout r1 = this.groupLayout;
        IndicatorGroupLayout r2 = null;
        if (r1 != null) goto L6;
        o.c("groupLayout");
        r1 = null;
    L6:
        if (o.a(r1.getFixedContentWidthPx(), r0) == false) goto L8;
        return;
    L8:
        IndicatorGroupLayout r3 = this.groupLayout;
        if (r3 != null) goto L11;
        o.c("groupLayout");
    L12:
        r2.setFixedContentWidthPx(r0);
        if (IF_DEBUG == false) goto L16;
        com.obric.oui.d.a.b.b(TAG, "PIC stable content width updated, width=" + r0 + " pagerCount=" + pagerCount() + " maxVisibleDots=" + this.maxVisibleDots);
        return;
    L16:
        return;
    L11:
        r2 = r3;
        goto L12
    }

    private final Integer resolvePicStableContentWidth() {
        if (getType() == 1) goto L5;
        return null;
    L5:
        int r0 = pagerCount();
        if (r0 <= 0) goto L16;
        int r3 = this.maxVisibleDots;
        if (r0 <= r3) goto L16;
        int r1 = n.c(r3, 0);
        if (r1 != 0) goto L15;
        com.obric.oui.d.a.b.d(TAG, o.a("Skip PIC stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(this.maxVisibleDots)));
        return null;
    L15:
        return Integer.valueOf(d.i.a.a((r1 * getDotsWidth()) + (((r1 - 1) * getDotsSpacing()) * SIZE_STYLE_SMALL_SPACING_DP)));
    L16:
        return null;
    }

    private final void cancelVisibleDotAnimations() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        cancelDotAnimation(((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")).b());
        goto L4
    }

    private final boolean shouldRebindVisibleSlots(d.l.j r9) {
        List<d> r10 = resolveRenderSlotBindings(pagerCount(), r9);
        if (this.renderedSlot.size() == r10.size()) goto L5;
        return true;
    L5:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r11.hasNext() == false) goto L26;
        Object r4 = r11.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        p.c();
    L11:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.preCheckCast(p.d(this.renderedSlot, r3), c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        IndicatorImageDotView r8 = resolveReplacementView(r6);
        if (o.a(r7.a(), r6) == false) goto L16;
        if (r8 != null) goto L19;
    L21:
        if (r8 != null) goto L25;
        if (ZeusTransformUtils.instanceOf(r7.b(), IndicatorDotView.class) == true) goto L25;
        return true;
    L25:
        r3 = r5;
        goto L7
    L19:
        if (r7.b() == r8) goto L21;
        return true;
    L16:
        return true;
    L13:
        return true;
    L26:
        return false;
    }

    private final void rebindVisibleSlots(com.obric.oui.indicator.g r12, com.obric.oui.indicator.b.d r13) {
        cancelVisibleDotAnimations();
        d.l.j r0 = r12.b();
        ArrayDeque<IndicatorDotView> r1 = new ArrayDeque();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        IndicatorDotView r5 = null;
        if (r2.hasNext() == false) goto L11;
        View r3 = ((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r3, IndicatorDotView.class) == false) goto L8;
        r5 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(r3, IndicatorDotView.class, "com.obric.aiagent.plugin");
    L8:
        if (r5 == null) goto L3;
        r1.addLast(r5);
        goto L3
    L11:
        LinearLayout r4 = this.dotsTrackLayout;
        if (r4 != null) goto L14;
        o.c("dotsTrackLayout");
        r4 = null;
    L14:
        r4.removeAllViews();
        this.renderedSlot.clear();
        List<d> r14 = resolveRenderSlotBindings(r12.a(), r0);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r6.hasNext() == false) goto L31;
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.aiagent.plugin");
        Object r8 = resolveReplacementView(r7);
        if (r8 != null) goto L20;
        r8 = acquireDefaultDotView(r1);
    L20:
        ViewParent r9 = ((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin")).getParent();
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.class) == false) goto L23;
        ViewGroup r10 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin");
    L24:
        if (r10 == null) goto L27;
        r10.removeView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
    L27:
        c r11 = new c(r7, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), (com.obric.oui.indicator.e) ZeusTransformUtils.preCheckCast(r8, com.obric.oui.indicator.e.class, "com.obric.aiagent.plugin"));
        bindSlot(r11);
        LinearLayout r15 = this.dotsTrackLayout;
        if (r15 != null) goto L30;
        o.c("dotsTrackLayout");
        r15 = null;
    L30:
        r15.addView(r11.b());
        this.renderedSlot.add(r11);
        goto L16
    L23:
        r10 = null;
        goto L24
    L31:
        recycleDefaultDots(r1);
        updateVisibleDotsSpacing();
        if (IF_DEBUG == false) goto L43;
        com.obric.oui.d.a.b.b(TAG, "Rebound slots, reason=" + r13.a() + " range=" + r0 + " bindings=" + r14 + " visible=" + this.renderedSlot.size() + " recycled=" + this.recycledDefaultDots.size());
        return;
    }

    private final IndicatorImageDotView resolveReplacementView(d r4) {
        if (ZeusTransformUtils.instanceOf(r4, d.b.class) == false) goto L8;
        if (((d.b) ZeusTransformUtils.preCheckCast(r4, d.b.class, "com.obric.aiagent.plugin")).a() == 0) goto L15;
        return null;
    L15:
        return this.startDrawableDotView;
    L8:
        if (o.a(r4, d.a.f35358a) == false) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return null;
    L14:
        throw new k();
    L10:
        r3 = o.a(r4, d.c.f35360a);
        goto L11
    }

    private final void cancelDotAnimation(View r1) {
        r1.animate().setListener(null).cancel();
    }

    private final IndicatorDotView acquireDefaultDotView(ArrayDeque<IndicatorDotView> r9) {
        IndicatorDotView r10 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(r9.pollFirst(), IndicatorDotView.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L14;
        r10 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(this.recycledDefaultDots.pollFirst(), IndicatorDotView.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L12;
        if (IF_DEBUG == false) goto L9;
        com.obric.oui.d.a.b.b(TAG, "Create new default dot");
    L9:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        return new IndicatorDotView(r3, null, 0, 6, null);
    L12:
        if (IF_DEBUG == false) goto L14;
        com.obric.oui.d.a.b.b(TAG, o.a("Reuse pooled default dot, remaining=", Integer.valueOf(this.recycledDefaultDots.size())));
    L14:
        return r10;
    }

    private final void recycleDefaultDots(ArrayDeque<IndicatorDotView> r4) {
    L3:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        this.recycledDefaultDots.addLast((IndicatorDotView) ZeusTransformUtils.preCheckCast(r4.removeFirst(), IndicatorDotView.class, "com.obric.aiagent.plugin"));
        goto L3
    }

    private final void bindSlot(final c r3) {
        int r1 = 0;
        updateDotLayout(r3.b(), false);
        OBaseIndicator.d r0 = getPager();
        if (r0 == null) goto L6;
        r1 = r0.b();
    L6:
        refreshRenderedSlot(r3, r1);
        r3.b().setOnClickListener(new $$Lambda$OCarouselIndicator$KwMov2E5kUBleq0LC3if6S489es(r3, this));
    }

    /* JADX INFO: renamed from: bindSlot$lambda-12, reason: not valid java name */
    private static final void m1097bindSlot$lambda12(c r2, OCarouselIndicator r3, View r4) {
        o.e(r2, "$slot");
        o.e(r3, "this$0");
        d r5 = r2.a();
        if (ZeusTransformUtils.instanceOf(r5, d.b.class) == true) goto L5;
        return;
    L5:
        if (r3.getDotsClickable() == true) goto L7;
        return;
    L7:
        if (((d.b) ZeusTransformUtils.preCheckCast(r5, d.b.class, "com.obric.aiagent.plugin")).a() >= r3.pagerCount()) goto L15;
        OBaseIndicator.d r6 = r3.getPager();
        if (r6 == null) goto L16;
        r6.a(((d.b) ZeusTransformUtils.preCheckCast(r5, d.b.class, "com.obric.aiagent.plugin")).a(), false);
        return;
    L16:
        return;
    }

    private final void updateDotLayout(View r6, boolean r7) {
        int r0 = resolveStartIconSizePx();
        if (r6 != this.startDrawableDotView) goto L5;
        int r1 = r0;
    L7:
        if (r6 == this.startDrawableDotView) goto L10;
        r0 = (int) getDotsHeight();
    L10:
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        LinearLayout.LayoutParams r4 = null;
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L14:
        if (r8 == null) goto L17;
        r4 = new LinearLayout.LayoutParams(r8);
    L17:
        if (r4 != null) goto L19;
        r4 = new LinearLayout.LayoutParams(r1, r0);
    L19:
        r4.width = r1;
        r4.height = r0;
        if (r7 == true) goto L22;
        r4.setMargins(0, 0, 0, 0);
    L22:
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r8 = null;
        goto L14
    L5:
        r1 = (int) getDotsWidth();
        goto L7
    }

    private final int resolveStartIconSizePx() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        if (this.sizeStyle != 1) goto L5;
        float r3 = 6.0f;
    L7:
        return com.obric.oui.common.util.g.b(r0, r3);
    L5:
        r3 = 10.0f;
        goto L7
    }

    private final void updateDotsTrackMinimumHeight() {
        LinearLayout r0 = this.dotsTrackLayout;
        if (r0 != null) goto L6;
        o.c("dotsTrackLayout");
        r0 = null;
    L6:
        if (this.startDrawableDotView != null) goto L8;
        int r2 = 0;
    L9:
        r0.setMinimumHeight(r2);
        return;
    L8:
        r2 = Math.max((int) getDotsHeight(), resolveStartIconSizePx());
        goto L9
    }

    private final void refreshVisibleDotsDraws() {
        OBaseIndicator.d r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        refreshRenderedSlot((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin"), r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void refreshVisibleDotsSize() {
        OBaseIndicator.d r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");
        updateDotLayout(r3.b(), true);
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.recycledDefaultDots, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        IndicatorDotView r5 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(r4.next(), IndicatorDotView.class, "com.obric.aiagent.plugin");
        o.c(r5, "it");
        updateDotLayout((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), true);
        goto L12
    L14:
        IndicatorImageDotView r6 = this.startDrawableDotView;
        if (r6 == null) goto L21;
        updateDotLayout((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), true);
        return;
    L21:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void updateVisibleDotsSpacing() {
        if (this.renderedSlot.isEmpty() == false) goto L5;
        return;
    L5:
        d.l.j r0 = p.a((Collection) ZeusTransformUtils.preCheckCast(this.renderedSlot, Collection.class, "com.obric.aiagent.plugin"));
        int r1 = (int) getDotsSpacing();
        int r3 = 0;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L16;
        Object r4 = r8.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        p.c();
    L11:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        com.obric.oui.indicator.a r7 = i.a(r3, r1, r0);
        if (r7.a() != r7.b()) goto L14;
        r6.c().setHorizontalMargin(r7.a());
    L15:
        r3 = r5;
        goto L7
    L14:
        r6.c().setStartMargin(r7.a());
        r6.c().setEndMargin(r7.b());
        goto L15
    }

    private final void applyViewportState(com.obric.oui.indicator.g r7) {
        OBaseIndicator.d r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");
        applyDotVisualState(r3.b(), resolveSlotVisualState(r3, r7));
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void applyViewportTransitionProgress(com.obric.oui.indicator.g r8, com.obric.oui.indicator.g r9, float r10) {
        OBaseIndicator.d r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");
        applyDotTransitionVisualState(r3.b(), resolveSlotVisualState(r3, r8), resolveSlotVisualState(r3, r9), r10);
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final com.obric.oui.indicator.c resolveSlotVisualState(c r2, com.obric.oui.indicator.g r3) {
        d r1 = r2.a();
        if (ZeusTransformUtils.instanceOf(r1, d.b.class) == false) goto L6;
        return r3.a(((d.b) ZeusTransformUtils.preCheckCast(r1, d.b.class, "com.obric.aiagent.plugin")).a());
    L6:
        if (o.a(r1, d.a.f35358a) == false) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        return com.obric.oui.indicator.c.f35389d;
    L13:
        throw new k();
    L8:
        r4 = o.a(r1, d.c.f35360a);
        goto L9
    }

    private final float resolveDotTargetScale(com.obric.oui.indicator.c r1) {
        int r0 = e.f35361a[r1.ordinal()];
        if (r0 != 1) goto L5;
        return EDGE_DOT_SCALE;
    L5:
        if (r0 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    private final float resolveDotTargetAlpha(com.obric.oui.indicator.c r1) {
        if (e.f35361a[r1.ordinal()] != 2) goto L5;
        return 0.0f;
    L5:
        return 1.0f;
    }

    private final void applyDotVisualState(View r6, com.obric.oui.indicator.c r7) {
        boolean r1 = false;
        if (r7 != com.obric.oui.indicator.c.f35389d) goto L5;
        int r0 = 4;
    L6:
        float r2 = resolveDotTargetScale(r7);
        float r8 = resolveDotTargetAlpha(r7);
        if (r6.getVisibility() == r0) goto L9;
    L23:
        cancelDotAnimation(r6);
        r6.setVisibility(r0);
        r6.setScaleX(r2);
        r6.setScaleY(r2);
        r6.setAlpha(r8);
        return;
    L9:
        if (r6.getScaleX() != r2) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        if (r6.getScaleY() != r2) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L23;
        if (r6.getAlpha() != r8) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L23;
        return;
    L16:
        r4 = false;
        goto L17
    L11:
        r3 = false;
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    private final void applyDotTransitionVisualState(View r4, com.obric.oui.indicator.c r5, com.obric.oui.indicator.c r6, float r7) {
        if (r5 != r6) goto L5;
        applyDotVisualState(r4, r5);
        return;
    L5:
        float r0 = resolveDotTargetScale(r5);
        float r1 = resolveDotTargetScale(r6);
        float r8 = resolveDotTargetAlpha(r5);
        float r2 = resolveDotTargetAlpha(r6);
        float r3 = interpolate(r0, r1, r7);
        float r9 = interpolate(r8, r2, r7);
        boolean r10 = false;
        if (r7 >= 1.0f) goto L8;
    L10:
        int r11 = 0;
    L12:
        if (r4.getVisibility() == r11) goto L14;
    L28:
        cancelDotAnimation(r4);
        r4.setVisibility(r11);
        r4.setScaleX(r3);
        r4.setScaleY(r3);
        r4.setAlpha(r9);
        return;
    L14:
        if (r4.getScaleX() != r3) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L28;
        if (r4.getScaleY() != r3) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L28;
        if (r4.getAlpha() != r9) goto L26;
        r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L21:
        r13 = false;
        goto L22
    L16:
        r12 = false;
        goto L17
    L8:
        if (r6 != com.obric.oui.indicator.c.f35389d) goto L10;
        r11 = 4;
        goto L12
    }

    private final void applyScrollColors(int r8, int r9, float r10) {
        com.obric.oui.indicator.b r0 = this.indicatorAnimator;
        if (r0 != null) goto L5;
        o.c("indicatorAnimator");
        r0 = null;
    L5:
        com.obric.oui.indicator.g r1 = r0.b();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.b(r8) == true) goto L11;
        return;
    L11:
        if (r1.b(r9) == false) goto L24;
        Object r2 = this.argbEvaluator.evaluate(r10, Integer.valueOf(this.selectedDotColor), Integer.valueOf(getDotsColor()));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type kotlin.Int");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue();
        Object r11 = this.argbEvaluator.evaluate(r10, Integer.valueOf(getDotsColor()), Integer.valueOf(this.selectedDotColor));
        Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Int");
        applyDotColorIfVisible(r9, ((Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.aiagent.plugin")).intValue(), r1);
        OBaseIndicator.d r12 = getPager();
        boolean r13 = false;
        if (r12 != null) goto L17;
    L19:
        if (r13 == false) goto L21;
        r3 = this.selectedDotColor;
    L21:
        applyDotColorIfVisible(r8, r3, r1);
        return;
    L17:
        if (r8 != r12.b()) goto L19;
        r13 = true;
        goto L19
    }

    private final void applyDotColorIfVisible(int r1, int r2, com.obric.oui.indicator.g r3) {
        if (r3.b(r1) == true) goto L5;
        return;
    L5:
        c r0 = findVisibleSlot(r1);
        if (r0 != null) goto L8;
        return;
    L8:
        r0.c().setDotColor(r2);
        r0.c().invalidate();
    }

    private final void refreshRenderedSlot(c r5, int r6) {
        com.obric.oui.indicator.e r0 = r5.c();
        d r1 = r5.a();
        if (ZeusTransformUtils.instanceOf(r1, d.b.class) == false) goto L9;
        if (((d.b) ZeusTransformUtils.preCheckCast(r1, d.b.class, "com.obric.aiagent.plugin")).a() != r6) goto L7;
        int r7 = this.selectedDotColor;
    L14:
        r0.setDotColor(r7);
        r5.c().setCornerRadius(getDotsCornerRadius());
        r5.c().setStrokeWidth(getDotsStrokeWidth());
        r5.c().setStrokeColor(getDotsStrokeColor());
        r5.c().invalidate();
        return;
    L7:
        r7 = getDotsColor();
        goto L14
    L9:
        if (o.a(r1, d.a.f35358a) == false) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L17;
        r7 = getDotsColor();
        goto L14
    L17:
        throw new k();
    L11:
        r8 = o.a(r1, d.c.f35360a);
        goto L12
    }

    private final c findVisibleSlot(int r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.renderedSlot, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L19;
        Object r0 = r6.next();
        d r2 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).a();
        boolean r4 = false;
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r2, d.b.class) == false) goto L11;
        if (((d.b) ZeusTransformUtils.preCheckCast(r2, d.b.class, "com.obric.aiagent.plugin")).a() != r7) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L4;
    L21:
        return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
    L11:
        if (o.a(r2, d.a.f35358a) == true) goto L14;
        r5 = o.a(r2, d.c.f35360a);
    L14:
        if (r5 == true) goto L15;
        throw new k();
    L19:
        r0 = null;
        goto L21
    }

    private final List<d> resolveRenderSlotBindings(int r6, d.l.j r7) {
        if (r6 <= 0) goto L24;
        if (r7.d() == true) goto L24;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r0, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.add(new d.b(((al) ZeusTransformUtils.preCheckCast(r1, al.class, "com.obric.aiagent.plugin")).a()));
        goto L8
    L10:
        List<d> r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        if (r6 > size(r7)) goto L13;
        return r3;
    L13:
        List r5 = p.a(r3.size() + 2);
        if (r7.a() <= 0) goto L16;
        d r4 = (d) ZeusTransformUtils.preCheckCast(new d.b(r7.a() - 1), d.class, "com.obric.aiagent.plugin");
    L17:
        r5.add(r4);
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"));
        if (r7.b() >= (r6 - 1)) goto L20;
        d r8 = (d) ZeusTransformUtils.preCheckCast(new d.b(r7.b() + 1), d.class, "com.obric.aiagent.plugin");
    L21:
        r5.add(r8);
        return p.a(r5);
    L20:
        r8 = (d) ZeusTransformUtils.preCheckCast(d.c.f35360a, d.class, "com.obric.aiagent.plugin");
        goto L21
    L16:
        r4 = (d) ZeusTransformUtils.preCheckCast(d.a.f35358a, d.class, "com.obric.aiagent.plugin");
    L24:
        return p.b();
    }

    private final int size(d.l.j r1) {
        if (r1.d() == false) goto L6;
        return 0;
    L6:
        return (r1.b() - r1.a()) + 1;
    }
}
