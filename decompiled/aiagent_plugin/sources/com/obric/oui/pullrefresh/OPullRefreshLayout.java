package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.l;
import androidx.core.view.r;
import androidx.core.view.s;
import com.obric.aiagent.plugin.R;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.i;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OPullRefreshLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPullRefreshLayout extends ViewGroup implements r {
    public static final a Companion = null;
    private static final int MIN_OFFSET_FOR_ANIMATION_PX = 2;
    private static final long ON_PULLING_MIN_INTERVAL_MS = 16;
    private boolean _isAnimatingOffset;
    private com.obric.oui.pullrefresh.c _state;
    private int contentOriginalLayerType;
    private View contentView;
    private int currentOffset;
    private float dragDamping;
    private int headerHeight;
    private int headerInsetStart;
    private int headerOriginalLayerType;
    private View headerView;
    private float initialDownX;
    private float initialDownY;
    private boolean isBeingDragged;
    private boolean isPerformedHapticFeedback;
    private float lastMotionY;
    private long lastOnPullingDispatchTime;
    private boolean layerTypeOverriddenForAnimation;
    private boolean nestedScrollEnabledWhileAnimatingOffset;
    private com.obric.common.oea.foundation.animation.manager.d offsetAnimationManager;
    private com.obric.oui.pullrefresh.a onRefreshListener;
    private com.obric.oui.pullrefresh.b onStateChangeListener;
    private final s parentHelper;
    private boolean refreshEnable;
    private com.obric.oui.pullrefresh.header.a refreshHeader;
    private float rubberRemainder;
    private View scrollChild;
    private int selfOriginalLayerType;
    private final int touchSlop;
    private float triggerRate;

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class b extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPullRefreshLayout f36104a;

        b(OPullRefreshLayout r1) {
            this.f36104a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "$noName_2");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            OPullRefreshLayout.access$moveSpinner(this.f36104a, (int) r5);
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class c extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPullRefreshLayout f36105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f36106b;

        c(OPullRefreshLayout r3, d.h.a.a<x> r4) {
            d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36105a = r3;
            this.f36106b = r5;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            OPullRefreshLayout.access$set_isAnimatingOffset$p(this.f36105a, false);
            OPullRefreshLayout.access$updateLayerTypeForAnimation(this.f36105a, false);
            OPullRefreshLayout.access$setOffsetAnimationManager$p(this.f36105a, null);
            d.h.a.a<x> r0 = this.f36106b;
            if (r0 == null) goto L7;
            r0.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class d extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPullRefreshLayout f36107a;

        d(OPullRefreshLayout r1) {
            this.f36107a = r1;
            super(0);
        }

        public final void a() {
            OPullRefreshLayout.access$setState(this.f36107a, com.obric.oui.pullrefresh.c.f36111a);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPullRefreshLayout f36108a;

        e(OPullRefreshLayout r1) {
            this.f36108a = r1;
            super(0);
        }

        public final void a() {
            OPullRefreshLayout.access$setState(this.f36108a, com.obric.oui.pullrefresh.c.f36111a);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class f implements com.obric.oui.pullrefresh.a, i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ d.h.a.b f36109a;

        f(d.h.a.b r3) {
            this.f36109a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(this.f36109a, d.c.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.pullrefresh.a
        public final /* synthetic */ void a(OPullRefreshLayout r1) {
            this.f36109a.invoke(r1);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.pullrefresh.a.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L7;
            return false;
        L7:
            return o.a(a(), ((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    static final class g implements com.obric.oui.pullrefresh.b, i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ q f36110a;

        g(q r3) {
            this.f36110a = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(this.f36110a, d.c.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.oui.pullrefresh.b
        public final /* synthetic */ void a(OPullRefreshLayout r1, com.obric.oui.pullrefresh.c r2, com.obric.oui.pullrefresh.c r3) {
            this.f36110a.invoke(r1, r2, r3);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.pullrefresh.b.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L7;
            return false;
        L7:
            return o.a(a(), ((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    static {
        Companion = new a(null);
    }

    public OPullRefreshLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPullRefreshLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$6A0zgmJXTW6WpQ1j3818fXwnOaM(OPullRefreshLayout r0, boolean r1) {
        m1149finishRefresh$lambda8(r0, r1);
    }

    public static /* synthetic */ void lambda$EV9ERZ5bsgOFkCCyo31yccQBufY(OPullRefreshLayout r0) {
        m1148autoRefresh$lambda7(r0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        o.e(r1, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        o.e(r1, "target");
        return false;
    }

    public /* synthetic */ OPullRefreshLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ void access$moveSpinner(OPullRefreshLayout r0, int r1) {
        r0.moveSpinner(r1);
    }

    public static final /* synthetic */ void access$setOffsetAnimationManager$p(OPullRefreshLayout r0, com.obric.common.oea.foundation.animation.manager.d r1) {
        r0.offsetAnimationManager = r1;
    }

    public static final /* synthetic */ void access$setState(OPullRefreshLayout r0, com.obric.oui.pullrefresh.c r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$set_isAnimatingOffset$p(OPullRefreshLayout r0, boolean r1) {
        r0._isAnimatingOffset = r1;
    }

    public static final /* synthetic */ void access$updateLayerTypeForAnimation(OPullRefreshLayout r0, boolean r1) {
        r0.updateLayerTypeForAnimation(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPullRefreshLayout(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r16, "context");
        super(r16, r17, r15);
        this.parentHelper = new s((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.dragDamping = 0.8f;
        this.triggerRate = 1.0f;
        this._state = com.obric.oui.pullrefresh.c.f36111a;
        this.touchSlop = ViewConfiguration.get(r16).getScaledTouchSlop();
        this.nestedScrollEnabledWhileAnimatingOffset = true;
        this.refreshEnable = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        AttributeSet r4 = null;
        Object[] r5 = 0;
        if (r17 == null) goto L25;
        TypedArray r18 = r16.obtainStyledAttributes(r17, R.styleable.OPullRefreshLayout, r15, 0);
        o.c(r18, "context.obtainStyledAttr…          0\n            )");
        this.dragDamping = n.a(r18.getFloat(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_dragDamping, "styleable", "OPullRefreshLayout_o_pr_dragDamping"), 0.8f), 0.2f, 1.0f);
        this.triggerRate = n.a(r18.getFloat(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_triggerRate, "styleable", "OPullRefreshLayout_o_pr_triggerRate"), 1.0f), 0.5f);
        this.headerInsetStart = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_headerInsetStart, "styleable", "OPullRefreshLayout_o_pr_headerInsetStart"), 0);
        this.refreshEnable = r18.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_refreshEnable, "styleable", "OPullRefreshLayout_o_pr_refreshEnable"), true);
        String r19 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextPull, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextPull"));
        String r0 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRelease, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextRelease"));
        String r2 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing"));
        String r3 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextSuccess, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextSuccess"));
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextColor")) == false) goto L7;
        Integer r7 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextColor"), 0));
    L9:
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderIconColor")) == false) goto L11;
        Integer r8 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderIconColor"), 0));
    L13:
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor")) == false) goto L15;
        Integer r9 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor"), 0));
    L16:
        int r6 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_headerView, "styleable", "OPullRefreshLayout_o_pr_headerView"), 0);
        r18.recycle();
        if (r6 == 0) goto L27;
        final View r110 = ViewGroup.inflate(r16, r6, null);
        if (ZeusTransformUtils.instanceOf(r110, com.obric.oui.pullrefresh.header.a.class) == false) goto L21;
        com.obric.oui.pullrefresh.header.a r10 = (com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(r110, com.obric.oui.pullrefresh.header.a.class, "com.obric.aiagent.plugin");
    L22:
        if (r10 == null) goto L24;
        setRefreshHeader(r10);
        goto L27
    L24:
        setRefreshHeader((com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r110), com.obric.oui.pullrefresh.header.a.class, "com.obric.aiagent.plugin"));
        goto L27
    L21:
        r10 = null;
    L27:
        if (this.refreshHeader != null) goto L29;
        setRefreshHeader((com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(new ODefaultRefreshHeader(r16, r4, 2, r5 == true ? 1 : 0), com.obric.oui.pullrefresh.header.a.class, "com.obric.aiagent.plugin"));
    L29:
        setDefaultHeaderTexts((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 == null) goto L33;
        setDefaultHeaderTextColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
    L33:
        if (r9 == null) goto L36;
        setDefaultHeaderProgressBackgroundColor(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue());
    L36:
        if (r8 == null) goto L40;
        setDefaultHeaderIconColor(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L40:
        return;
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
        goto L13
    L7:
        r7 = null;
        goto L9
    L25:
        r19 = null;
        r0 = null;
        r2 = null;
        r3 = null;
        r7 = null;
        r8 = null;
        r9 = null;
        goto L27
    }

    public final com.obric.oui.pullrefresh.c getState() {
        return this._state;
    }

    public final boolean isAnimatingOffset() {
        return this._isAnimatingOffset;
    }

    public final boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final void setRefreshEnable(boolean r1) {
        this.refreshEnable = r1;
    }

    public final void setDragDamping(float r1) {
        this.dragDamping = r1;
    }

    public final void setTriggerRate(float r1) {
        this.triggerRate = r1;
    }

    public final void setHeaderInsetStartDp(float r3) {
        this.headerInsetStart = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void setHeaderInsetStartPx(int r1) {
        this.headerInsetStart = r1;
    }

    public final void setOnRefreshListener(com.obric.oui.pullrefresh.a r3) {
        this.onRefreshListener = (com.obric.oui.pullrefresh.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.a.class, "com.obric.aiagent.plugin");
    }

    public final void setOnRefreshListener(d.h.a.b<? super OPullRefreshLayout, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "block");
        this.onRefreshListener = (com.obric.oui.pullrefresh.a) ZeusTransformUtils.preCheckCast(new f(r4), com.obric.oui.pullrefresh.a.class, "com.obric.aiagent.plugin");
    }

    public final void setOnStateChangeListener(com.obric.oui.pullrefresh.b r3) {
        this.onStateChangeListener = (com.obric.oui.pullrefresh.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.b.class, "com.obric.aiagent.plugin");
    }

    public final void setOnStateChangeListener(q<? super OPullRefreshLayout, ? super com.obric.oui.pullrefresh.c, ? super com.obric.oui.pullrefresh.c, x> r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        o.e(r4, "block");
        this.onStateChangeListener = (com.obric.oui.pullrefresh.b) ZeusTransformUtils.preCheckCast(new g(r4), com.obric.oui.pullrefresh.b.class, "com.obric.aiagent.plugin");
    }

    public final void setRefreshHeader(com.obric.oui.pullrefresh.header.a r3) {
        com.obric.oui.pullrefresh.header.a r4 = (com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.header.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "header");
        View r0 = this.headerView;
        if (r0 == null) goto L6;
        removeView(r0);
    L6:
        this.refreshHeader = r4;
        View r5 = r4.getView();
        this.headerView = r5;
        addView(r5, 0);
        requestLayout();
    }

    public static /* synthetic */ void setDefaultHeaderTexts$default(OPullRefreshLayout r1, CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r10 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r11 = null;
    L14:
        r1.setDefaultHeaderTexts(r8, r9, r10, r11);
    }

    public final void setDefaultHeaderTexts(CharSequence r3, CharSequence r4, CharSequence r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L10;
        r11.setTexts(r7, r8, r9, r10);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setTextColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(ColorStateList r3) {
        o.e(r3, "colors");
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setTextColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderIconColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setIconColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setProgressBackgroundColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final boolean isRefreshing() {
        if (this._state != com.obric.oui.pullrefresh.c.f36114d) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r1) {
        this.nestedScrollEnabledWhileAnimatingOffset = r1;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ensureContentView();
        this.scrollChild = findScrollableChild(this.contentView);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class);
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        ensureContentView();
        int r0 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        if (r0 == 0) goto L15;
        if (r1 == 0) goto L16;
        int r2 = View.MeasureSpec.makeMeasureSpec((r0 - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec((r1 - getPaddingTop()) - getPaddingBottom(), 1073741824);
        View r4 = this.contentView;
        if (r4 == null) goto L10;
        r4.measure(r2, r3);
    L10:
        View r7 = this.headerView;
        if (r7 == null) goto L17;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r7.measure(ViewGroup.getChildMeasureSpec(r5, ((getPaddingLeft() + getPaddingRight()) + r9.leftMargin) + r9.rightMargin, r9.width), ViewGroup.getChildMeasureSpec(r6, ((getPaddingTop() + getPaddingBottom()) + r9.topMargin) + r9.bottomMargin, r9.height));
        this.headerHeight = r7.getMeasuredHeight();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        ensureContentView();
        int r13 = getMeasuredWidth();
        int r14 = getMeasuredHeight();
        if (r13 == 0) goto L16;
        if (r14 == 0) goto L17;
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = r13 - getPaddingRight();
        int r18 = r14 - getPaddingBottom();
        View r19 = this.headerView;
        if (r19 == null) goto L10;
        ViewGroup.LayoutParams r2 = r19.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r19.getMeasuredHeight();
        int r5 = r3.leftMargin + r15;
        int r6 = ((r16 - r4) + this.headerInsetStart) + r3.topMargin;
        r19.layout(r5, r6, r19.getMeasuredWidth() + r5, r4 + r6);
    L10:
        View r110 = this.contentView;
        if (r110 == null) goto L14;
        ViewGroup.LayoutParams r7 = r110.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r110.layout(r15 + r0.leftMargin, r16 + r0.topMargin, r17 - r0.rightMargin, r18 - r0.bottomMargin);
    L14:
        applyCurrentOffsetToTranslation();
        return;
    L17:
        return;
    }

    @Override // androidx.core.view.q
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        o.e(r1, "child");
        o.e(r2, "target");
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.refreshEnable == false) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // androidx.core.view.q
    public void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        o.e(r2, "child");
        o.e(r3, "target");
        this.parentHelper.a(r2, r3, r4, r5);
    }

    @Override // androidx.core.view.q
    public void onStopNestedScroll(View r2, int r3) {
        o.e(r2, "target");
        this.parentHelper.a(r2, r3);
        if (r3 == 0) goto L5;
        return;
    L5:
        if (this._state == com.obric.oui.pullrefresh.c.f36114d) goto L9;
        finishSpinner();
        return;
    }

    @Override // androidx.core.view.q
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        o.e(r1, "target");
        o.e(r4, "consumed");
        if (r5 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == true) goto L14;
        if (this._isAnimatingOffset == false) goto L14;
        return;
    L14:
        if (r3 <= 0) goto L18;
        int r6 = this.currentOffset;
        if (r6 <= 0) goto L18;
        int r7 = Math.min(r3, r6);
        moveSpinner(this.currentOffset - r7);
        r4[1] = r7;
    L18:
        if (r3 < 0) goto L20;
        return;
    L20:
        if (canScrollUpInner() == false) goto L22;
        return;
    L22:
        if (this._state == com.obric.oui.pullrefresh.c.f36114d) goto L29;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r3));
        if (r8 <= 0) goto L30;
        moveSpinner(this.currentOffset + r8);
        r4[1] = r3;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.q
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        o.e(r10, "target");
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    @Override // androidx.core.view.r
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        o.e(r1, "target");
        o.e(r7, "consumed");
        if (r6 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == false) goto L11;
    L13:
        if (r5 < 0) goto L15;
        return;
    L15:
        if (canScrollUpInner() == false) goto L17;
        return;
    L17:
        if (isRefreshing() == true) goto L24;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r5));
        if (r8 <= 0) goto L25;
        moveSpinner(this.currentOffset + r8);
        r7[1] = r7[1] + r5;
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this._isAnimatingOffset == false) goto L13;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.parentHelper.a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r8) {
        o.e(r8, "ev");
        boolean r1 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.refreshEnable == false) goto L57;
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L10;
        this.isBeingDragged = false;
        this.initialDownY = r8.getY();
        this.initialDownX = r8.getX();
        this.lastMotionY = this.initialDownY;
    L56:
        return this.isBeingDragged;
    L10:
        if (r0 != 1) goto L12;
    L53:
        this.isBeingDragged = false;
        goto L56
    L12:
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L53;
    L17:
        if (this.isBeingDragged == true) goto L56;
        float r2 = r8.getY() - this.initialDownY;
        float r3 = r8.getX() - this.initialDownX;
        float r4 = Math.abs(r2);
        float r5 = Math.abs(r3);
        if (r4 <= this.touchSlop) goto L56;
        if (r4 <= r5) goto L56;
        if (this.scrollChild != null) goto L25;
    L28:
        boolean r6 = true;
    L30:
        if (r2 <= 0.0f) goto L32;
        boolean r7 = true;
    L34:
        if (r2 < 0.0f) goto L36;
    L38:
        boolean r9 = false;
    L40:
        if (ZeusTransformUtils.instanceOf(this.scrollChild, l.class) == true) goto L42;
    L44:
        if (r7 == false) goto L47;
        if (r1 == true) goto L47;
        if (r6 == false) goto L47;
    L49:
        this.isBeingDragged = true;
        this.lastMotionY = r8.getY();
        ViewParent r10 = getParent();
        if (r10 == null) goto L56;
        r10.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r9 == false) goto L56;
        if (r1 == true) goto L56;
    L42:
        if (ZeusTransformUtils.instanceOf(this.contentView, CoordinatorLayout.class) == true) goto L44;
        r1 = true;
        goto L44
    L36:
        if (this.currentOffset <= 0) goto L38;
        r9 = true;
        goto L40
    L32:
        r7 = false;
        goto L34
    L25:
        if (canScrollUpInner() == false) goto L28;
        r6 = false;
        goto L30
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        o.e(r10, "event");
        if (isEnabled() == false) goto L62;
        if (this.refreshEnable == false) goto L62;
        int r0 = r10.getActionMasked();
        if (r0 == 0) goto L59;
        if (r0 == 1) goto L52;
        if (r0 != 2) goto L13;
        float r1 = r10.getY();
        float r3 = r1 - this.lastMotionY;
        this.lastMotionY = r1;
        if (this.isBeingDragged == true) goto L32;
        float r4 = r1 - this.initialDownY;
        float r6 = r10.getX() - this.initialDownX;
        float r7 = Math.abs(r4);
        float r8 = Math.abs(r6);
        if (r7 <= this.touchSlop) goto L32;
        if (r7 <= r8) goto L32;
        if (r4 <= 0.0f) goto L32;
        if (this.scrollChild != null) goto L26;
    L27:
        this.isBeingDragged = true;
        this.lastMotionY = r1;
        ViewParent r2 = getParent();
        if (r2 == null) goto L32;
        r2.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (canScrollUpInner() == false) goto L27;
    L32:
        if (this.isBeingDragged == true) goto L34;
    L58:
        return super.onTouchEvent(r10);
    L34:
        if (r3 < 0.0f) goto L36;
    L38:
        if (r3 >= 0.0f) goto L48;
        int r11 = Math.min((int) Math.abs(r3), this.currentOffset);
        if (r11 <= 0) goto L42;
        moveSpinner(this.currentOffset - r11);
    L42:
        this.rubberRemainder = 0.0f;
        if (((int) Math.abs(r3)) <= r11) goto L46;
        this.isBeingDragged = false;
        return false;
    L46:
        return true;
    L48:
        if (isRefreshing() == true) goto L50;
        int r12 = this.currentOffset;
        moveSpinner(r12 + computeRubberIncrement(r12, r3));
    L50:
        return true;
    L36:
        if (this.currentOffset > 0) goto L38;
        return false;
    L13:
        if (r0 != 3) goto L58;
    L52:
        if (this.isBeingDragged == false) goto L58;
        this.isBeingDragged = false;
        if (this._state == com.obric.oui.pullrefresh.c.f36114d) goto L56;
        finishSpinner();
    L56:
        return true;
    L59:
        this.isBeingDragged = false;
        this.initialDownY = r10.getY();
        this.initialDownX = r10.getX();
        this.lastMotionY = this.initialDownY;
        return true;
    L62:
        return super.onTouchEvent(r10);
    }

    private final void setState(com.obric.oui.pullrefresh.c r3) {
        com.obric.oui.pullrefresh.c r0 = this._state;
        if (r0 != r3) goto L5;
        return;
    L5:
        this._state = r3;
        com.obric.oui.pullrefresh.header.a r1 = this.refreshHeader;
        if (r1 == null) goto L9;
        r1.onStateChanged(this, r0, r3);
    L9:
        com.obric.oui.pullrefresh.b r2 = this.onStateChangeListener;
        if (r2 == null) goto L14;
        r2.a(this, r0, r3);
        return;
    }

    private final void updateStateByOffset() {
        if (this._state != com.obric.oui.pullrefresh.c.f36114d) goto L5;
        return;
    L5:
        if (this._state == com.obric.oui.pullrefresh.c.f36115e) goto L19;
        int r0 = (int) (this.headerHeight * this.triggerRate);
        int r1 = this.currentOffset;
        if (r1 > 0) goto L10;
        com.obric.oui.pullrefresh.c r2 = com.obric.oui.pullrefresh.c.f36111a;
    L16:
        setState(r2);
        return;
    L10:
        if (r1 >= r0) goto L13;
        this.isPerformedHapticFeedback = false;
        r2 = com.obric.oui.pullrefresh.c.f36112b;
        goto L16
    L13:
        if (this.isPerformedHapticFeedback == true) goto L15;
        this.isPerformedHapticFeedback = true;
        com.obric.oui.b.a.f34003a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
    L15:
        r2 = com.obric.oui.pullrefresh.c.f36113c;
        goto L16
    }

    private final void finishSpinner() {
        int r0 = this.headerHeight;
        if (r0 > 0) goto L6;
        return;
    L6:
        if (this.currentOffset >= ((int) (r0 * this.triggerRate))) goto L8;
    L12:
        animateOffsetTo(0, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        if (this._state != com.obric.oui.pullrefresh.c.f36113c) goto L10;
    L11:
        startRefreshing();
        return;
    L10:
        if (this._state != com.obric.oui.pullrefresh.c.f36112b) goto L12;
        goto L11
    }

    public final void autoRefresh() {
        if (this.refreshEnable == true) goto L6;
        return;
    L6:
        if (this._state != com.obric.oui.pullrefresh.c.f36114d) goto L9;
        return;
    L9:
        if (ViewCompat.F((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L12;
        post(new $$Lambda$OPullRefreshLayout$EV9ERZ5bsgOFkCCyo31yccQBufY(this));
        return;
    L12:
        startRefreshing();
    }

    /* JADX INFO: renamed from: autoRefresh$lambda-7, reason: not valid java name */
    private static final void m1148autoRefresh$lambda7(OPullRefreshLayout r1) {
        o.e(r1, "this$0");
        r1.autoRefresh();
    }

    private final void startRefreshing() {
        if (this.headerHeight > 0) goto L11;
        View r0 = this.headerView;
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        this.headerHeight = r1;
        if (r1 > 0) goto L11;
        return;
    L7:
        r1 = r0.getMeasuredHeight();
    L11:
        setState(com.obric.oui.pullrefresh.c.f36114d);
        animateOffsetTo(this.headerHeight, null);
        com.obric.oui.pullrefresh.a r2 = this.onRefreshListener;
        if (r2 == null) goto L16;
        r2.a(this);
        return;
    }

    public static /* synthetic */ void finishRefresh$default(OPullRefreshLayout r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.finishRefresh(r1);
    }

    public final void finishRefresh(final boolean r4) {
        if (this._state != com.obric.oui.pullrefresh.c.f36114d) goto L5;
    L7:
        setState(com.obric.oui.pullrefresh.c.f36115e);
        postDelayed(new $$Lambda$OPullRefreshLayout$6A0zgmJXTW6WpQ1j3818fXwnOaM(this, r4), 200);
        return;
    L5:
        if (this._state == com.obric.oui.pullrefresh.c.f36113c) goto L7;
    }

    /* JADX INFO: renamed from: finishRefresh$lambda-8, reason: not valid java name */
    private static final void m1149finishRefresh$lambda8(OPullRefreshLayout r3, boolean r4) {
        o.e(r3, "this$0");
        com.obric.oui.pullrefresh.header.a r0 = r3.refreshHeader;
        if (r0 == null) goto L6;
        r0.onFinish(r3, r4);
    L6:
        r3.animateOffsetTo(0, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void moveSpinner(int r3) {
        int r4 = Math.max(0, r3);
        if (r4 != this.currentOffset) goto L5;
        return;
    L5:
        this.currentOffset = r4;
        applyCurrentOffsetToTranslation();
        int r5 = this.headerHeight;
        if (r5 <= 0) goto L9;
        dispatchOnPullingThrottled(n.a(this.currentOffset / r5, 0.0f, 1.0f), this.currentOffset, this.headerHeight);
    L9:
        if (this._state == com.obric.oui.pullrefresh.c.f36114d) goto L11;
    L14:
        updateStateByOffset();
        ViewCompat.f((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        if (this.currentOffset != 0) goto L14;
        finishRefresh(true);
        ViewCompat.f((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void animateOffsetTo$default(OPullRefreshLayout r1, int r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.animateOffsetTo(r2, r6);
    }

    private final void animateOffsetTo(int r14, d.h.a.a<x> r15) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        int r0 = this.currentOffset;
        if (r0 != r14) goto L8;
        if (r16 == null) goto L30;
        r16.invoke();
        return;
    L30:
        return;
    L8:
        int r1 = Math.abs(r0 - r14);
        if (ViewCompat.F((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L11;
    L21:
        com.obric.common.oea.foundation.animation.manager.d r2 = this.offsetAnimationManager;
        if (r2 == null) goto L25;
        com.obric.common.oea.foundation.animation.manager.d.a(r2, false, 1, null);
    L25:
        moveSpinner(r14);
        if (r16 == null) goto L31;
        r16.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r1 <= 2) goto L21;
        com.obric.common.oea.foundation.animation.manager.d r3 = this.offsetAnimationManager;
        if (r3 == null) goto L19;
        com.obric.common.oea.foundation.animation.manager.d.a(r3, false, 1, null);
    L19:
        this.offsetAnimationManager = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), this.currentOffset, r14, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new b(this), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new c(this, r16), m.class, "com.obric.aiagent.plugin")).a().a();
        this._isAnimatingOffset = true;
        updateLayerTypeForAnimation(true);
    }

    private final void ensureContentView() {
        if (this.contentView == null) goto L5;
        return;
    L5:
        int r0 = 0;
        int r1 = getChildCount();
    L6:
        if (r0 >= r1) goto L14;
        int r2 = r0 + 1;
        View r3 = getChildAt(r0);
        if (r3 != this.headerView) goto L9;
        r0 = r2;
        goto L6
    L9:
        this.contentView = r3;
        return;
    }

    private final View findScrollableChild(View r7) {
        if (r7 != null) goto L5;
    L24:
        return null;
    L5:
        if (r7 == this.headerView) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, ScrollView.class) == false) goto L10;
    L23:
        return r7;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, AbsListView.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L22;
        int r1 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L17:
        if (r1 >= r2) goto L22;
        int r4 = r1 + 1;
        View r3 = findScrollableChild(((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r1));
        if (r3 != null) goto L20;
        r1 = r4;
        goto L17
    L20:
        return r3;
    L22:
        return null;
    }

    private final boolean canScrollUpInner() {
        View r3 = this.scrollChild;
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.canScrollVertically(-1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    private final void applyCurrentOffsetToTranslation() {
        float r0 = this.currentOffset;
        View r1 = this.headerView;
        boolean r2 = true;
        if (r1 != null) goto L6;
    L11:
        View r5 = this.contentView;
        if (r5 != null) goto L15;
        return;
    L15:
        if (r5.getTranslationY() == r0) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L21;
        r5.setTranslationY(r0);
        return;
    L21:
        return;
    L6:
        if (r1.getTranslationY() != r0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r1.setTranslationY(r0);
        goto L11
    L8:
        r4 = false;
        goto L9
    }

    private final void dispatchOnPullingThrottled(float r7, int r8, int r9) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.lastOnPullingDispatchTime) >= 16) goto L8;
        if (r8 == 0) goto L8;
        if (r8 == r9) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        this.lastOnPullingDispatchTime = r0;
        com.obric.oui.pullrefresh.header.a r1 = this.refreshHeader;
        if (r1 == null) goto L16;
        r1.onPulling(this, r7, r8, r9);
        return;
    L16:
        return;
    L8:
        r2 = true;
        goto L9
    }

    private final void updateLayerTypeForAnimation(boolean r5) {
        View r0 = this.headerView;
        View r1 = this.contentView;
        int r2 = 0;
        if (r5 == false) goto L23;
        if (this.layerTypeOverriddenForAnimation == true) goto L15;
        this.layerTypeOverriddenForAnimation = true;
        this.selfOriginalLayerType = getLayerType();
        if (r0 != null) goto L9;
        int r6 = 0;
    L10:
        this.headerOriginalLayerType = r6;
        if (r1 == null) goto L14;
        r2 = r1.getLayerType();
    L14:
        this.contentOriginalLayerType = r2;
        goto L15
    L9:
        r6 = r0.getLayerType();
    L15:
        setLayerType(2, null);
        if (r0 == null) goto L19;
        r0.setLayerType(2, null);
    L19:
        if (r1 == null) goto L34;
        r1.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.layerTypeOverriddenForAnimation == false) goto L33;
        this.layerTypeOverriddenForAnimation = false;
        setLayerType(this.selfOriginalLayerType, null);
        if (r0 == null) goto L28;
        r0.setLayerType(this.headerOriginalLayerType, null);
    L28:
        if (r1 == null) goto L35;
        r1.setLayerType(this.contentOriginalLayerType, null);
        return;
    L35:
        return;
    }

    private final int computeRubberIncrement(int r3, float r4) {
        int r0 = this.headerHeight;
        if (r0 <= 0) goto L5;
        float r1 = r0 * 2.0f;
    L6:
        float r5 = r3;
        float r6 = (rubberMap(n.a(r5 + r4, 0.0f), r1, this.dragDamping) - rubberMap(r5, r1, this.dragDamping)) + this.rubberRemainder;
        int r7 = (int) r6;
        this.rubberRemainder = r6 - r7;
        return r7;
    L5:
        r1 = n.a(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    private final float rubberMap(float r2, float r3, float r4) {
        float r1 = n.a(r4, 0.01f, 1.0f);
        float r5 = Math.max(1.0f, r3);
        return (1.0f - (1.0f / (((r2 * r1) / r5) + 1.0f))) * r5;
    }
}
