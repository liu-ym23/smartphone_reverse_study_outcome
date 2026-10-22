package com.obric.autoaction.vdplayer.legacy.components.panel;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.al;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.p;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.animation.OeaSpringTimeInterpolator;
import com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.legacy.d.k;
import com.obric.autoaction.vdplayer.legacy.d.l;
import com.obric.autoaction.vdplayer.legacy.d.m;
import com.obric.autoaction.vdplayer.legacy.d.q;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.autoaction.view.legacy.DraggableFloatingLayout;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.vdplayer.a.j;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.d;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: PanelContainerComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelContainerComponent extends BaseVDPlayerSlotComponent<a> implements com.obric.autoaction.vdplayer.legacy.components.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f25819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f25820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.vdplayer.legacy.d.j f25821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f25822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f25823e;
    private int f;

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f25824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f25825b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25824a, r6.f25824a) == true) goto L12;
            return false;
        L12:
            if (this.f25825b == r6.f25825b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f25824a.hashCode() * 31) + this.f25825b.hashCode();
        }

        public String toString() {
            return "PanelRenderState(panelState=" + this.f25824a + ", secureState=" + this.f25825b + ')';
        }

        public a(k r2, m r3) {
            o.e(r2, "panelState");
            o.e(r3, "secureState");
            this.f25824a = r2;
            this.f25825b = r3;
        }

        public final k a() {
            return this.f25824a;
        }

        public final m b() {
            return this.f25825b;
        }
    }

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25826a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25827b = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f25914a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            f25826a = r0;
            int[] r1 = new int[com.obric.autoaction.vdplayer.legacy.d.j.values().length];
            r1[com.obric.autoaction.vdplayer.legacy.d.j.f25904a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[com.obric.autoaction.vdplayer.legacy.d.j.f25906c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[com.obric.autoaction.vdplayer.legacy.d.j.f25905b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            f25827b = r1;
        }
    }

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    @f(b = "PanelContainerComponent.kt", c = {107}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.panel.PanelContainerComponent$onViewCreated$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PanelContainerComponent f25829b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f25831a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.panel.PanelContainerComponent$c$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f25832a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.panel.PanelContainerComponent$c$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(b = "PanelContainerComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.components.panel.PanelContainerComponent$onViewCreated$2$invokeSuspend$$inlined$map$1$2")
                public static final class C06441 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25833a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25834b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25835c;

                    public C06441(AnonymousClass1 r3, d r4) {
                        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                        this.f25835c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25833a = r3;
                        this.f25834b |= Integer.MIN_VALUE;
                        return this.f25835c.emit(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f25832a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d r7) {
                    d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06441.class) == false) goto L7;
                    C06441 r0 = (C06441) ZeusTransformUtils.preCheckCast(r8, C06441.class, "com.obric.aiagent.plugin");
                    if ((r0.f25834b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25834b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25833a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25834b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    i r5 = this.f25832a;
                    d r10 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(ZeusTransformUtils.instanceOf((q) ZeusTransformUtils.preCheckCast(r6, q.class, "com.obric.aiagent.plugin"), q.h.class));
                    r0.f25834b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06441(this, r8);
                    goto L8
                }
            }

            public a(h r3) {
                this.f25831a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super Boolean> r3, d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d<? super x> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25831a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        c(PanelContainerComponent r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f25829b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f25829b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25828a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = PanelContainerComponent.a(this.f25829b);
            if (r7 == null) goto L16;
            ab<q> r8 = r7.c();
            if (r8 == null) goto L16;
            h r9 = (h) ZeusTransformUtils.preCheckCast(new a((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
            final PanelContainerComponent r4 = this.f25829b;
            i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), i.class, "com.obric.aiagent.plugin");
            d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25828a = 1;
            if (r9.collect(r2, r3) != r0) goto L16;
            return r0;
        }
    }

    private static final void b(View r0) {
    }

    public static /* synthetic */ x lambda$FxtLogwGhvYi_o85SlHOrv5uWgQ(com.obric.autoaction.a.l r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$W3mGq-5tJNJHoq3HrB8c7gUn9W4, reason: not valid java name */
    public static /* synthetic */ void m696lambda$W3mGq5tJNJHoq3HrB8c7gUn9W4(View r0) {
        b(r0);
    }

    public static /* synthetic */ WindowInsets lambda$WPwgHvDoqpHPO8vTslSL3R_5Ni4(PanelContainerComponent r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ZnP-dlwX77Z1NetfHGZATDpS3ZI, reason: not valid java name */
    public static /* synthetic */ void m697lambda$ZnPdlwX77Z1NetfHGZATDpS3ZI(PanelContainerComponent r0) {
        c(r0);
    }

    public static /* synthetic */ x lambda$bsB6Xs1rGJKHlrD_eDQyjHJcEgc(PanelContainerComponent r0, View r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$czXiNis-QZwSAOZr_ipCwDs-2L4, reason: not valid java name */
    public static /* synthetic */ x m698lambda$czXiNisQZwSAOZr_ipCwDs2L4(com.obric.autoaction.a.a r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$d0BYQYc33u2kzwRKL4DYSEI6nLU(com.obric.autoaction.a.l r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$r7fnNoSbf6HDzpwiO-5-u242QmI, reason: not valid java name */
    public static /* synthetic */ x m699lambda$r7fnNoSbf6HDzpwiO5u242QmI(com.obric.autoaction.a.l r0) {
        return c(r0);
    }

    public static /* synthetic */ a lambda$ub1xxoju7TbiVZ80BcvB6L_c8s4(s r0) {
        return a(r0);
    }

    public PanelContainerComponent() {
        super($$Lambda$PanelContainerComponent$ub1xxoju7TbiVZ80BcvB6L_c8s4.INSTANCE);
    }

    public static final /* synthetic */ u a(PanelContainerComponent r0) {
        return r0.b();
    }

    public static final /* synthetic */ void a(PanelContainerComponent r0, View r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ j b(PanelContainerComponent r0) {
        return r0.f25819a;
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
    }

    private static final a a(s r2) {
        o.e(r2, "it");
        return new a(r2.b(), r2.j());
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        this.f25820b = r3;
        b(r4);
        ViewGroup r5 = com.obric.autoaction.a.b.a(r4, ZeusTransformUtils.mapRes(R.layout.vd_legacy_component_panel_container, "layout", "vd_legacy_component_panel_container"), $$Lambda$PanelContainerComponent$czXiNisQZwSAOZr_ipCwDs2L4.INSTANCE);
        this.f25819a = j.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        r4.a(com.obric.autoaction.vdplayer.legacy.components.a.a.class, this);
        return (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
    }

    private static final x a(com.obric.autoaction.a.a r1) {
        o.e(r1, "$this$assemble");
        r1.b($$Lambda$PanelContainerComponent$FxtLogwGhvYi_o85SlHOrv5uWgQ.INSTANCE);
        r1.b($$Lambda$PanelContainerComponent$d0BYQYc33u2kzwRKL4DYSEI6nLU.INSTANCE);
        r1.b($$Lambda$PanelContainerComponent$r7fnNoSbf6HDzpwiO5u242QmI.INSTANCE);
        return x.f38692a;
    }

    private static final x a(com.obric.autoaction.a.l r3) {
        o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelBubbleComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_fab_slot, DbHelper.COL_ID, "panel_fab_slot")));
        return x.f38692a;
    }

    private static final x b(com.obric.autoaction.a.l r3) {
        o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelExpandedComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_expanded_slot, DbHelper.COL_ID, "panel_expanded_slot")));
        return x.f38692a;
    }

    private static final x c(com.obric.autoaction.a.l r3) {
        o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelAutoExitComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_expanded_auto_exit_slot, DbHelper.COL_ID, "panel_expanded_auto_exit_slot")));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r9, com.obric.autoaction.a.c r10) {
        o.e(r9, "boundView");
        o.e(r10, "componentHost");
        a r11 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L5;
        a(r11);
    L5:
        d();
        e();
        kotlinx.coroutines.i.a(r10.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void d() {
        j r0 = this.f25819a;
        if (r0 != null) goto L5;
        return;
    L5:
        DraggableFloatingLayout r1 = r0.f31624a;
        o.c(r1, "panelContainer");
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelContainerComponent$bsB6Xs1rGJKHlrD_eDQyjHJcEgc(this), 1, null);
        r0.f31624a.setChangeAlphaWhenPress(false);
        r0.f.setChangeAlphaWhenPress(false);
        r0.f31628e.setOnClickListener($$Lambda$PanelContainerComponent$W3mGq5tJNJHoq3HrB8c7gUn9W4.INSTANCE);
    }

    private static final x b(PanelContainerComponent r2, View r3) {
        o.e(r3, "it");
        r2.a((r) ZeusTransformUtils.preCheckCast(r.p.f25960a, r.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void e() {
        j r0 = this.f25819a;
        if (r0 == null) goto L9;
        DraggableFloatingLayout r1 = r0.b();
        if (r1 == null) goto L10;
        r1.setOnApplyWindowInsetsListener(new $$Lambda$PanelContainerComponent$WPwgHvDoqpHPO8vTslSL3R_5Ni4(this));
        return;
    L10:
        return;
    }

    private static final WindowInsets a(PanelContainerComponent r2, View r3, WindowInsets r4) {
        o.e(r3, "<unused var>");
        o.e(r4, "insets");
        int r5 = r4.getInsets(al.m.e()).bottom;
        if (r2.f == r5) goto L11;
        r2.f = r5;
        l r6 = r2.f25822d;
        if (r6 == null) goto L11;
        if (r2.f25821c != com.obric.autoaction.vdplayer.legacy.d.j.f25904a) goto L9;
    L10:
        r2.b(r6);
        goto L11
    L9:
        if (r2.f25821c == com.obric.autoaction.vdplayer.legacy.d.j.f25906c) goto L10;
    L11:
        return r4;
    }

    public void a(a r8) {
        o.e(r8, "state");
        j r0 = this.f25819a;
        if (r0 != null) goto L5;
        return;
    L5:
        k r1 = r8.a();
        PrivacyBadgeView.b r9 = b(r8);
        DraggableFloatingLayout r2 = r0.b();
        boolean r5 = false;
        if (r1.c() != com.obric.autoaction.vdplayer.legacy.d.j.f25905b) goto L8;
        boolean r3 = true;
    L9:
        r2.setDragEnabled(r3);
        if (r0.b().isDragging() == true) goto L13;
        f();
    L13:
        if (r0.b().isSnapping() == false) goto L15;
        r0.b().cancelSnapAnimation();
    L15:
        r0.f31628e.render(r9);
        if (b.f25826a[r1.a().a().ordinal()] != 1) goto L18;
        r0.f.setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_3_high_elevation, "color", "oui_bg_base_3_high_elevation")));
    L20:
        if (this.f25821c == r1.c()) goto L22;
        boolean r10 = true;
    L24:
        if (this.f25822d == r1.a().a()) goto L26;
        r5 = true;
    L26:
        int r4 = b.f25827b[r1.c().ordinal()];
        if (r4 != 1) goto L29;
    L36:
        if (r10 == true) goto L38;
        if (r5 == true) goto L38;
    L39:
        this.f25821c = r1.c();
        this.f25822d = r1.a().a();
        if (this.f25823e != r1.f()) goto L42;
        return;
    L42:
        if (this.f25821c == com.obric.autoaction.vdplayer.legacy.d.j.f25905b) goto L49;
        this.f25823e = r1.f();
        if (r1.f() == false) goto L46;
        h();
        return;
    L46:
        i();
        return;
    L49:
        return;
    L38:
        a(r1.a().a());
        goto L39
    L29:
        if (r4 == 2) goto L36;
        if (r4 != 3) goto L35;
        if (r10 == false) goto L39;
        g();
        goto L39
    L35:
        throw new d.k();
    L22:
        r10 = false;
        goto L24
    L18:
        r0.f.setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2_2_low_elevation, "color", "oui_basic_bg_base_2_2_low_elevation")));
        goto L20
    L8:
        r3 = false;
        goto L9
    }

    private final void f() {
        j r0 = this.f25819a;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r1 = this.f25820b;
        if (r1 != null) goto L8;
        return;
    L8:
        OeaSpringTimeInterpolator r2 = new OeaSpringTimeInterpolator(e.c.j, e.a.f32428a);
        FastOutSlowInInterpolator r3 = new FastOutSlowInInterpolator();
        TransitionSet r4 = new TransitionSet();
        r4.setOrdering(0);
        ChangeTransform r5 = new ChangeTransform();
        r5.setDuration(r2.getDurationMillis());
        r5.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(r5, Transition.class, "com.obric.aiagent.plugin"));
        ChangeBounds r6 = new ChangeBounds();
        r6.setDuration(r2.getDurationMillis());
        r6.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(r6, Transition.class, "com.obric.aiagent.plugin"));
        Fade r7 = new Fade(2);
        r7.setDuration(300);
        r7.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(r7, Transition.class, "com.obric.aiagent.plugin"));
        Fade r8 = new Fade(1);
        r8.setDuration(300);
        r8.setStartDelay(100);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(r8, Transition.class, "com.obric.aiagent.plugin"));
        Iterator<View> r9 = androidx.core.view.ab.b(r1).a();
    L10:
        if (r9.hasNext() == false) goto L14;
        View r10 = (View) ZeusTransformUtils.preCheckCast(r9.next(), View.class, "com.obric.aiagent.plugin");
        if (o.a(r10, r0.b()) == true) goto L10;
        r4.excludeTarget(r10, true);
        goto L10
    L14:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "begin transition");
        TransitionManager.endTransitions(r1);
        TransitionManager.beginDelayedTransition(r1, (Transition) ZeusTransformUtils.preCheckCast(r4, Transition.class, "com.obric.aiagent.plugin"));
    }

    private final void a(l r7) {
        j r0 = this.f25819a;
        if (r0 == null) goto L45;
        DraggableFloatingLayout r1 = r0.b();
        if (r1 == null) goto L51;
        b(r7);
        j r2 = this.f25819a;
        if (r2 == null) goto L12;
        OUIConstraintLayout r3 = r2.f;
        if (r3 == null) goto L12;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.width = -1;
        r5.height = -2;
        r4.setLayoutParams(r5);
    L12:
        j r6 = this.f25819a;
        if (r6 == null) goto L17;
        OUIConstraintLayout r8 = r6.f;
        if (r8 == null) goto L17;
        Resources r9 = Resources.getSystem();
        o.c(r9, "Resources.getSystem()");
        r8.setRadius(d.i.a.a(TypedValue.applyDimension(1, 32, r9.getDisplayMetrics())));
    L17:
        r1.setTranslationX(0.0f);
        r1.setTranslationY(0.0f);
        j r10 = this.f25819a;
        if (r10 == null) goto L23;
        FrameLayout r11 = r10.f31627d;
        if (r11 == null) goto L23;
        r11.setVisibility(8);
    L23:
        if (r7 != l.g) goto L34;
        j r12 = this.f25819a;
        if (r12 == null) goto L29;
        FrameLayout r13 = r12.f31626c;
        if (r13 == null) goto L29;
        r13.setVisibility(8);
    L29:
        j r14 = this.f25819a;
        if (r14 == null) goto L46;
        FrameLayout r15 = r14.f31625b;
        if (r15 == null) goto L47;
        r15.setVisibility(0);
        return;
    L47:
        return;
    L46:
        return;
    L34:
        j r16 = this.f25819a;
        if (r16 == null) goto L39;
        FrameLayout r17 = r16.f31626c;
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        j r18 = this.f25819a;
        if (r18 == null) goto L49;
        FrameLayout r19 = r18.f31625b;
        if (r19 == null) goto L50;
        r19.setVisibility(8);
        return;
    L50:
        return;
    L49:
        return;
    L51:
        return;
    }

    private final void b(l r5) {
        j r0 = this.f25819a;
        if (r0 == null) goto L9;
        DraggableFloatingLayout r1 = r0.b();
        if (r1 == null) goto L10;
        int r2 = c(r5);
        int r4 = d(r5);
        View r6 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r7 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r8.width = -1;
        r8.height = -2;
        r8.gravity = 80;
        r8.setMargins(r2, 0, r2, r4);
        r6.setLayoutParams(r7);
        return;
    L10:
        return;
    }

    private final int c(l r3) {
        if (e(r3) == false) goto L5;
        int r2 = 8;
    L6:
        Resources r1 = Resources.getSystem();
        o.c(r1, "Resources.getSystem()");
        return d.i.a.a(TypedValue.applyDimension(1, r2, r1.getDisplayMetrics()));
    L5:
        r2 = 12;
        goto L6
    }

    private final int d(l r2) {
        int r0 = this.f;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return c(r2);
    }

    private final boolean e(l r1) {
        if (r1 != l.f25918e) goto L5;
    L16:
        return true;
    L5:
        if (r1 == l.f) goto L16;
        if (r1 == l.f25915b) goto L16;
        if (r1 == l.f25916c) goto L16;
        if (r1 == l.f25917d) goto L16;
        if (r1 == l.g) goto L16;
        return false;
    }

    private final void g() {
        j r0 = this.f25819a;
        if (r0 == null) goto L37;
        DraggableFloatingLayout r1 = r0.b();
        if (r1 == null) goto L40;
        FrameLayout.LayoutParams r2 = r1.getLastSnapLayoutParams();
        if (r2 == null) goto L10;
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L11:
        j r3 = this.f25819a;
        if (r3 == null) goto L16;
        OUIConstraintLayout r4 = r3.f;
        if (r4 == null) goto L16;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r6.width = -2;
        r6.height = -2;
        r5.setLayoutParams(r6);
    L16:
        j r7 = this.f25819a;
        if (r7 == null) goto L21;
        OUIConstraintLayout r8 = r7.f;
        if (r8 == null) goto L21;
        r8.postDelayed(new $$Lambda$PanelContainerComponent$ZnPdlwX77Z1NetfHGZATDpS3ZI(this), 300);
    L21:
        j r9 = this.f25819a;
        if (r9 == null) goto L26;
        FrameLayout r10 = r9.f31627d;
        if (r10 == null) goto L26;
        r10.setVisibility(0);
    L26:
        j r11 = this.f25819a;
        if (r11 == null) goto L31;
        FrameLayout r12 = r11.f31626c;
        if (r12 == null) goto L31;
        r12.setVisibility(8);
    L31:
        j r13 = this.f25819a;
        if (r13 == null) goto L38;
        FrameLayout r14 = r13.f31625b;
        if (r14 == null) goto L39;
        r14.setVisibility(8);
        return;
    L39:
        return;
    L38:
        return;
    L10:
        View r15 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r17 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r16, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r17, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r18.width = -2;
        r18.height = -2;
        r18.gravity = 8388659;
        Resources r19 = Resources.getSystem();
        o.c(r19, "Resources.getSystem()");
        int r20 = d.i.a.a(TypedValue.applyDimension(1, 20, r19.getDisplayMetrics()));
        float r21 = AbstractDialog.HORIZONTAL_MAX_WIDTH;
        Resources r110 = Resources.getSystem();
        o.c(r110, "Resources.getSystem()");
        int r22 = d.i.a.a(TypedValue.applyDimension(1, r21, r110.getDisplayMetrics()));
        Resources r111 = Resources.getSystem();
        o.c(r111, "Resources.getSystem()");
        r18.setMargins(r20, r22, 0, d.i.a.a(TypedValue.applyDimension(1, 0, r111.getDisplayMetrics())));
        r15.setLayoutParams(r17);
        goto L11
    L40:
        return;
    }

    private static final void c(PanelContainerComponent r4) {
        j r5 = r4.f25819a;
        if (r5 == null) goto L8;
        OUIConstraintLayout r6 = r5.f;
        if (r6 == null) goto L9;
        Resources r2 = Resources.getSystem();
        o.c(r2, "Resources.getSystem()");
        r6.setRadius(d.i.a.a(TypedValue.applyDimension(1, 44, r2.getDisplayMetrics())));
        return;
    L9:
        return;
    }

    private final void h() {
        j r5 = this.f25819a;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.b().setScaleX(0.9f);
        r5.b().setScaleY(0.9f);
        OUIConstraintLayout r6 = r5.f;
        o.c(r6, "panelSlotsWrapper");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        float r1 = OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP;
        Resources r3 = Resources.getSystem();
        o.c(r3, "Resources.getSystem()");
        r0.height = d.i.a.a(TypedValue.applyDimension(1, r1, r3.getDisplayMetrics()));
        r7.setLayoutParams(r0);
    }

    private final void i() {
        j r2 = this.f25819a;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.b().setScaleX(1.0f);
        r2.b().setScaleY(1.0f);
        OUIConstraintLayout r3 = r2.f;
        o.c(r3, "panelSlotsWrapper");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.height = -2;
        r4.setLayoutParams(r0);
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25819a = null;
    }

    private final PrivacyBadgeView.b b(a r4) {
        if (r4.b() == m.f25921c) goto L5;
        boolean r0 = true;
    L6:
        int r5 = b.f25827b[r4.a().c().ordinal()];
        if (r5 != 1) goto L9;
    L15:
        PrivacyBadgeView.a r6 = PrivacyBadgeView.a.f25845b;
    L17:
        return new PrivacyBadgeView.b(r0, r6);
    L9:
        if (r5 == 2) goto L15;
        if (r5 != 3) goto L14;
        r6 = PrivacyBadgeView.a.f25844a;
        goto L17
    L14:
        throw new d.k();
    L5:
        r0 = false;
        goto L6
    }

    private final void a(View r13) {
        float r0 = TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics());
        float r7 = -r0;
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, r7, r7, r0, r0, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, 0.0f, r7, r7, r0, 0.0f})});
        o.c(r12, "ofPropertyValuesHolder(...)");
        r12.setDuration(300);
        r12.start();
    }
}
