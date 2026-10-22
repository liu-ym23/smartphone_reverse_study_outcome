package com.obric.autoaction.vdplayer.components.panel;

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
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.lifecycle.p;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.animation.OeaSpringTimeInterpolator;
import com.obric.autoaction.vdplayer.components.BaseVDPlayerSlotComponent;
import com.obric.autoaction.vdplayer.d.j;
import com.obric.autoaction.vdplayer.d.k;
import com.obric.autoaction.vdplayer.d.l;
import com.obric.autoaction.vdplayer.d.m;
import com.obric.autoaction.vdplayer.d.o;
import com.obric.autoaction.vdplayer.d.q;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autoaction.vdplayer.d.u;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.vdplayer.a.e;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.aa;
import d.x;
import java.util.Iterator;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: PanelContainerComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PanelContainerComponent extends BaseVDPlayerSlotComponent<a> implements com.obric.autoaction.vdplayer.components.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f25407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f25408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f25409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f25410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f25411e;
    private Long f;
    private a g;
    private int h;
    private int i;
    private com.obric.autoaction.vdplayer.components.a.a.EnumC0618a j;
    private final Runnable k;

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f25412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m f25413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final o f25414c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25412a, r6.f25412a) == true) goto L12;
            return false;
        L12:
            if (this.f25413b == r6.f25413b) goto L15;
            return false;
        L15:
            if (this.f25414c == r6.f25414c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f25412a.hashCode() * 31) + this.f25413b.hashCode()) * 31) + this.f25414c.hashCode();
        }

        public String toString() {
            return "PanelRenderState(panelState=" + this.f25412a + ", secureState=" + this.f25413b + ", userOperateMode=" + this.f25414c + ')';
        }

        public a(k r2, m r3, o r4) {
            d.h.b.o.e(r2, "panelState");
            d.h.b.o.e(r3, "secureState");
            d.h.b.o.e(r4, "userOperateMode");
            this.f25412a = r2;
            this.f25413b = r3;
            this.f25414c = r4;
        }

        public final k a() {
            return this.f25412a;
        }

        public final m b() {
            return this.f25413b;
        }

        public final o c() {
            return this.f25414c;
        }
    }

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25415a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25416b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f25417c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f25418d = null;

        static {
            int[] r0 = new int[DraggableFloatingLayout.b.values().length];
            r0[DraggableFloatingLayout.b.f26076a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            r0[DraggableFloatingLayout.b.f26077b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L46:
            r0[DraggableFloatingLayout.b.f26078c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L8:
            f25415a = r0;
            int[] r1 = new int[l.values().length];
            r1[l.f25507a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L10:
            f25416b = r1;
            int[] r2 = new int[j.values().length];
            r2[j.f25497a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L30:
            r2[j.f25499c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L36:
            r2[j.f25498b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L14:
            f25417c = r2;
            int[] r3 = new int[com.obric.autoaction.vdplayer.components.a.a.EnumC0618a.values().length];
            r3[com.obric.autoaction.vdplayer.components.a.a.EnumC0618a.f25351a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L32:
            r3[com.obric.autoaction.vdplayer.components.a.a.EnumC0618a.f25352b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L40:
            r3[com.obric.autoaction.vdplayer.components.a.a.EnumC0618a.f25353c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L18:
            f25418d = r3;
        }
    }

    /* JADX INFO: compiled from: PanelContainerComponent.kt */
    @f(b = "PanelContainerComponent.kt", c = {116}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.panel.PanelContainerComponent$onViewCreated$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PanelContainerComponent f25420b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements h<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f25422a;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.panel.PanelContainerComponent$c$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f25423a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.panel.PanelContainerComponent$c$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @f(b = "PanelContainerComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.components.panel.PanelContainerComponent$onViewCreated$2$invokeSuspend$$inlined$map$1$2")
                public static final class C06221 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f25424a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f25425b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25426c;

                    public C06221(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f25426c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f25424a = r3;
                        this.f25425b |= Integer.MIN_VALUE;
                        return this.f25426c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f25423a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C06221.class) == false) goto L7;
                    C06221 r0 = (C06221) ZeusTransformUtils.preCheckCast(r8, C06221.class, "com.obric.aiagent.plugin");
                    if ((r0.f25425b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f25425b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f25424a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f25425b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    i r5 = this.f25423a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    Boolean r11 = d.c.b.a.b.a(ZeusTransformUtils.instanceOf((q) ZeusTransformUtils.preCheckCast(r6, q.class, "com.obric.aiagent.plugin"), q.i.class));
                    r0.f25425b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C06221(this, r8);
                    goto L8
                }
            }

            public a(h r3) {
                this.f25422a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super Boolean> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f25422a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        c(PanelContainerComponent r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25420b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25420b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25419a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = PanelContainerComponent.a(this.f25420b);
            if (r7 == null) goto L16;
            ab<q> r8 = r7.c();
            if (r8 == null) goto L16;
            h r9 = (h) ZeusTransformUtils.preCheckCast(new a((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
            final PanelContainerComponent r4 = this.f25420b;
            i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25419a = 1;
            if (r9.collect(r2, r3) != r0) goto L16;
            return r0;
        }
    }

    private static final void b(View r0) {
    }

    public static /* synthetic */ void lambda$1QpKOnXgX2ToZSy5CKeUHjAVtzk(PanelContainerComponent r0, DraggableFloatingLayout r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$44dR9-tGRzIEflcA1OxfPzUoSB0, reason: not valid java name */
    public static /* synthetic */ a m669lambda$44dR9tGRzIEflcA1OxfPzUoSB0(s r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$8d5hzj6eeKKj0NZXmWTdUHSu-sQ, reason: not valid java name */
    public static /* synthetic */ x m670lambda$8d5hzj6eeKKj0NZXmWTdUHSusQ(PanelContainerComponent r0) {
        return f(r0);
    }

    public static /* synthetic */ x lambda$8vt3_0GLTWVWaStcLBc7CYKx4Qg(com.obric.autoaction.a.l r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$F77rGOodn0raUGUk216YqoBHKD0(PanelContainerComponent r0, View r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$J22GFobMX-HX_TrPGIN3ls2WLvM, reason: not valid java name */
    public static /* synthetic */ x m671lambda$J22GFobMXHX_TrPGIN3ls2WLvM(PanelContainerComponent r0) {
        return g(r0);
    }

    public static /* synthetic */ void lambda$K7dKED2de66deYw6J7sNnwIh97g(PanelContainerComponent r0) {
        e(r0);
    }

    public static /* synthetic */ void lambda$U8jw3zDh7V4wvFdkv375BaYyPuM(PanelContainerComponent r0, DraggableFloatingLayout r1) {
        c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Wz3Fz-15s9Jzm259f9gWlaYziEA, reason: not valid java name */
    public static /* synthetic */ x m672lambda$Wz3Fz15s9Jzm259f9gWlaYziEA(PanelContainerComponent r0) {
        return h(r0);
    }

    public static /* synthetic */ x lambda$_MwUCKbJFxY_QkRIJVbxHQFDPzc(PanelContainerComponent r0, DraggableFloatingLayout r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$fAX1Ytav0Urqa8RKcjb3j2PcVbs(com.obric.autoaction.a.l r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$fkCWmLVtDQ3Y3Bw89kvL9pRQ2ZE(com.obric.autoaction.a.l r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$ipQjTNRtn1Wf5idz1HkoZ1ZZWsI(View r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$mEHO_70a1038fo18_0Ph-6hs1x8, reason: not valid java name */
    public static /* synthetic */ x m673lambda$mEHO_70a1038fo18_0Ph6hs1x8(com.obric.autoaction.a.a r0) {
        return a(r0);
    }

    public static /* synthetic */ WindowInsets lambda$xH5E8hHmILCrnaKSBL22RZgnd3E(PanelContainerComponent r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public PanelContainerComponent() {
        super($$Lambda$PanelContainerComponent$44dR9tGRzIEflcA1OxfPzUoSB0.INSTANCE);
        this.k = new $$Lambda$PanelContainerComponent$K7dKED2de66deYw6J7sNnwIh97g(this);
    }

    public static final /* synthetic */ u a(PanelContainerComponent r0) {
        return r0.b();
    }

    public static final /* synthetic */ void a(PanelContainerComponent r0, View r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(PanelContainerComponent r0, DraggableFloatingLayout r1, com.obric.autoaction.vdplayer.components.a.a.EnumC0618a r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ e b(PanelContainerComponent r0) {
        return r0.f25407a;
    }

    public static final /* synthetic */ a c(PanelContainerComponent r0) {
        return r0.g;
    }

    public static final /* synthetic */ void d(PanelContainerComponent r0) {
        r0.i();
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
    }

    private static final a a(s r3) {
        d.h.b.o.e(r3, "it");
        return new a(r3.b(), r3.j(), r3.e());
    }

    private static final void e(PanelContainerComponent r4) {
        a r0 = r4.g;
        if (r0 == null) goto L7;
        k r1 = r0.a();
        if (r1 == null) goto L7;
        j r2 = r1.c();
    L9:
        if (r2 != j.f25498b) goto L16;
        e r5 = r4.f25407a;
        if (r5 == null) goto L17;
        OUIConstraintLayout r6 = r5.g;
        if (r6 == null) goto L18;
        Resources r3 = Resources.getSystem();
        d.h.b.o.c(r3, "Resources.getSystem()");
        r6.setRadius(d.i.a.a(TypedValue.applyDimension(1, 24, r3.getDisplayMetrics())));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        d.h.b.o.e(r3, "container");
        d.h.b.o.e(r4, "componentHost");
        this.f25408b = r3;
        b(r4);
        ViewGroup r5 = com.obric.autoaction.a.b.a(r4, ZeusTransformUtils.mapRes(R.layout.vd_component_panel_container, "layout", "vd_component_panel_container"), $$Lambda$PanelContainerComponent$mEHO_70a1038fo18_0Ph6hs1x8.INSTANCE);
        this.f25407a = e.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        r4.a(com.obric.autoaction.vdplayer.components.a.a.class, this);
        return (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
    }

    private static final x a(com.obric.autoaction.a.a r1) {
        d.h.b.o.e(r1, "$this$assemble");
        r1.b($$Lambda$PanelContainerComponent$fkCWmLVtDQ3Y3Bw89kvL9pRQ2ZE.INSTANCE);
        r1.b($$Lambda$PanelContainerComponent$8vt3_0GLTWVWaStcLBc7CYKx4Qg.INSTANCE);
        r1.b($$Lambda$PanelContainerComponent$fAX1Ytav0Urqa8RKcjb3j2PcVbs.INSTANCE);
        return x.f38692a;
    }

    private static final x a(com.obric.autoaction.a.l r3) {
        d.h.b.o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelBubbleComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_fab_slot, DbHelper.COL_ID, "panel_fab_slot")));
        return x.f38692a;
    }

    private static final x b(com.obric.autoaction.a.l r3) {
        d.h.b.o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelExpandedComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_expanded_slot, DbHelper.COL_ID, "panel_expanded_slot")));
        return x.f38692a;
    }

    private static final x c(com.obric.autoaction.a.l r3) {
        d.h.b.o.e(r3, "$this$uiSlotComponent");
        r3.a(aa.b(PanelAutoExitComponent.class));
        r3.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.id.panel_expanded_auto_exit_slot, DbHelper.COL_ID, "panel_expanded_auto_exit_slot")));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r9, com.obric.autoaction.a.c r10) {
        d.h.b.o.e(r9, "boundView");
        d.h.b.o.e(r10, "componentHost");
        a r11 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L5;
        a(r11);
    L5:
        d();
        e();
        kotlinx.coroutines.i.a(r10.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void d() {
        e r0 = this.f25407a;
        if (r0 != null) goto L5;
        return;
    L5:
        final DraggableFloatingLayout r1 = r0.f31604a;
        d.h.b.o.c(r1, "panelContainer");
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$PanelContainerComponent$F77rGOodn0raUGUk216YqoBHKD0(this), 1, null);
        r1.setChangeAlphaWhenPress(false);
        r0.g.setChangeAlphaWhenPress(false);
        r0.f.setOnClickListener($$Lambda$PanelContainerComponent$ipQjTNRtn1Wf5idz1HkoZ1ZZWsI.INSTANCE);
        r1.setOnDragStartListener(new $$Lambda$PanelContainerComponent$8d5hzj6eeKKj0NZXmWTdUHSusQ(this));
        r1.setOnDragEndListener(new $$Lambda$PanelContainerComponent$J22GFobMXHX_TrPGIN3ls2WLvM(this));
        r1.setOnDockStateChanged(new $$Lambda$PanelContainerComponent$Wz3Fz15s9Jzm259f9gWlaYziEA(this));
        r1.setOnRightRevealAutoRetract(new $$Lambda$PanelContainerComponent$_MwUCKbJFxY_QkRIJVbxHQFDPzc(this, r1));
    }

    private static final x b(PanelContainerComponent r1, View r2) {
        d.h.b.o.e(r2, "it");
        r1.h();
        return x.f38692a;
    }

    private static final x f(PanelContainerComponent r3) {
        a r0 = r3.g;
        if (r0 != null) goto L7;
        return x.f38692a;
    L7:
        if (r0.c() != o.f25519a) goto L9;
    L11:
        r3.i();
        return x.f38692a;
    L9:
        if (r0.a().d() == null) goto L11;
        r3.a((r) ZeusTransformUtils.preCheckCast(r.l.f25551a, r.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    private static final x g(PanelContainerComponent r0) {
        r0.i();
        return x.f38692a;
    }

    private static final x h(PanelContainerComponent r0) {
        r0.i();
        return x.f38692a;
    }

    private static final x a(PanelContainerComponent r1, DraggableFloatingLayout r2) {
        r1.g();
        DraggableFloatingLayout.dockRightPeek$default(r2, null, 1, null);
        return x.f38692a;
    }

    private final void e() {
        e r0 = this.f25407a;
        if (r0 == null) goto L9;
        FrameLayout r1 = r0.b();
        if (r1 == null) goto L10;
        r1.setOnApplyWindowInsetsListener(new $$Lambda$PanelContainerComponent$xH5E8hHmILCrnaKSBL22RZgnd3E(this));
        ViewCompat.u((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        return;
    }

    private static final WindowInsets a(PanelContainerComponent r2, View r3, WindowInsets r4) {
        d.h.b.o.e(r3, "<unused var>");
        d.h.b.o.e(r4, "insets");
        int r5 = r4.getInsets(al.m.b()).bottom;
        int r0 = r4.getInsets(al.m.e()).bottom;
        if (r2.h == r5) goto L5;
    L6:
        r2.h = r5;
        r2.i = r0;
        r2.f();
        a r6 = r2.g;
        if (r6 != null) goto L9;
    L29:
        return r4;
    L9:
        if (r6.a().c() != j.f25497a) goto L11;
    L28:
        r2.a(r6.a().a().a());
        goto L29
    L11:
        if (r6.a().c() == j.f25499c) goto L28;
        e r7 = r2.f25407a;
        if (r7 == null) goto L29;
        DraggableFloatingLayout r8 = r7.f31604a;
        if (r8 == null) goto L29;
        DraggableFloatingLayout.b r9 = r8.currentDock();
        int r10 = b.f25415a[r9.ordinal()];
        if (r10 != 1) goto L20;
        r8.dockBottom();
        goto L29
    L20:
        if (r10 != 2) goto L22;
        DraggableFloatingLayout.dockRightPeek$default(r8, null, 1, null);
        goto L29
    L22:
        if (r10 != 3) goto L25;
        r8.revealRightDock();
        goto L29
    L25:
        throw new d.k();
    L5:
        if (r2.i == r0) goto L29;
        goto L6
    }

    public void a(a r14) {
        d.h.b.o.e(r14, "state");
        e r0 = this.f25407a;
        if (r0 != null) goto L5;
        return;
    L5:
        this.g = r14;
        k r1 = r14.a();
        DraggableFloatingLayout r2 = r0.f31604a;
        d.h.b.o.c(r2, "panelContainer");
        PrivacyBadgeView.b r3 = b(r14);
        Long r4 = this.f;
        Long r5 = r1.d();
        this.f = r5;
        boolean r8 = false;
        if (r4 != null) goto L8;
    L10:
        boolean r10 = false;
    L11:
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r10 == true) goto L22;
        if (r6 == false) goto L22;
        if (r2.isRightDockPeek() == false) goto L22;
        g();
        r2.revealRightDock();
    L22:
        if (r2.isDragging() == false) goto L30;
        if (d.h.b.o.a(r5, r4) == true) goto L30;
        if (r14.c() == o.f25519a) goto L30;
        if (r5 == null) goto L30;
        a((r) ZeusTransformUtils.preCheckCast(r.l.f25551a, r.class, "com.obric.aiagent.plugin"));
    L30:
        if (r1.c() != j.f25498b) goto L32;
        boolean r15 = true;
    L33:
        r2.setDragEnabled(r15);
        if (r2.isDragging() == true) goto L36;
        g();
    L36:
        r0.f.render(r3);
        i();
        if (b.f25416b[r1.a().a().ordinal()] != 1) goto L39;
        r0.g.setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_3_high_elevation, "color", "oui_bg_base_3_high_elevation")));
    L41:
        if (this.f25409c == r1.c()) goto L43;
        boolean r16 = true;
    L45:
        if (this.f25410d == r1.a().a()) goto L47;
        boolean r7 = true;
    L49:
        if (r1.c() != j.f25498b) goto L54;
        if (r16 == false) goto L54;
        if (this.j != null) goto L54;
        r8 = true;
    L54:
        int r9 = b.f25417c[r1.c().ordinal()];
        if (r9 != 1) goto L57;
    L64:
        if (r16 == true) goto L66;
        if (r7 == true) goto L66;
    L67:
        this.f25409c = r1.c();
        if (r7 == false) goto L70;
        this.f25410d = r1.a().a();
    L70:
        l();
        if (this.f25411e != r1.f()) goto L73;
        return;
    L73:
        if (this.f25409c == j.f25498b) goto L80;
        this.f25411e = r1.f();
        if (r1.f() == false) goto L77;
        j();
        return;
    L77:
        k();
        return;
    L80:
        return;
    L66:
        a(r1.a().a());
        goto L67
    L57:
        if (r9 == 2) goto L64;
        if (r9 != 3) goto L63;
        if (r16 == false) goto L67;
        a(r8);
        goto L67
    L63:
        throw new d.k();
    L47:
        r7 = false;
        goto L49
    L43:
        r16 = false;
        goto L45
    L39:
        r0.g.setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_2_2_low_elevation, "color", "oui_basic_bg_base_2_2_low_elevation")));
        goto L41
    L32:
        r15 = false;
        goto L33
    L13:
        if (r5.longValue() > 5000) goto L15;
        r6 = true;
        goto L16
    L8:
        if (r4.longValue() > 5000) goto L10;
        r10 = true;
        goto L11
    }

    private final void f() {
        e r0 = this.f25407a;
        if (r0 == null) goto L8;
        DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 == null) goto L9;
        r1.setBottomDockMarginPx(m());
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        r1.setRightDockVisibleWidthPx(d.i.a.a(TypedValue.applyDimension(1, 41, r2.getDisplayMetrics())));
        Resources r3 = Resources.getSystem();
        d.h.b.o.c(r3, "Resources.getSystem()");
        r1.setRightSlideOutMarginPx(d.i.a.a(TypedValue.applyDimension(1, 13, r3.getDisplayMetrics())));
        Resources r4 = Resources.getSystem();
        d.h.b.o.c(r4, "Resources.getSystem()");
        r1.setTopClampMinPx(d.i.a.a(TypedValue.applyDimension(1, 62, r4.getDisplayMetrics())));
        r1.setSideClampMarginPx(m());
        int r5 = this.h;
        Resources r6 = Resources.getSystem();
        d.h.b.o.c(r6, "Resources.getSystem()");
        r1.setBottomSnapZonePx(r5 + d.i.a.a(TypedValue.applyDimension(1, 74, r6.getDisplayMetrics())));
        Resources r7 = Resources.getSystem();
        d.h.b.o.c(r7, "Resources.getSystem()");
        r1.setBottomSnapRightExclusionPx(d.i.a.a(TypedValue.applyDimension(1, 118, r7.getDisplayMetrics())));
        return;
    L9:
        return;
    }

    private final void g() {
        e r0 = this.f25407a;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r1 = this.f25408b;
        if (r1 != null) goto L8;
        return;
    L8:
        OeaSpringTimeInterpolator r2 = new OeaSpringTimeInterpolator(com.obric.common.oea.foundation.animation.h.e.c.h, com.obric.common.oea.foundation.animation.h.e.a.f32432e);
        TransitionSet r3 = new TransitionSet();
        r3.setOrdering(0);
        ChangeTransform r4 = new ChangeTransform();
        r4.setDuration(r2.getDurationMillis());
        r4.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addTransition((Transition) ZeusTransformUtils.preCheckCast(r4, Transition.class, "com.obric.aiagent.plugin"));
        ChangeBounds r5 = new ChangeBounds();
        r5.setDuration(r2.getDurationMillis());
        r5.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addTransition((Transition) ZeusTransformUtils.preCheckCast(r5, Transition.class, "com.obric.aiagent.plugin"));
        Fade r6 = new Fade(2);
        r6.setDuration(r2.getDurationMillis());
        r6.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addTransition((Transition) ZeusTransformUtils.preCheckCast(r6, Transition.class, "com.obric.aiagent.plugin"));
        Fade r7 = new Fade(1);
        r7.setDuration(r2.getDurationMillis());
        r7.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r2, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r3.addTransition((Transition) ZeusTransformUtils.preCheckCast(r7, Transition.class, "com.obric.aiagent.plugin"));
        Iterator<View> r8 = androidx.core.view.ab.b(r1).a();
    L10:
        if (r8.hasNext() == false) goto L14;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8.next(), View.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r9, r0.b()) == true) goto L10;
        r3.excludeTarget(r9, true);
        goto L10
    L14:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "begin transition");
        TransitionManager.endTransitions(r1);
        TransitionManager.beginDelayedTransition(r1, (Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.aiagent.plugin"));
    }

    private final void a(l r7) {
        e r0 = this.f25407a;
        if (r0 == null) goto L51;
        final DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 == null) goto L52;
        e r2 = this.f25407a;
        if (r2 == null) goto L12;
        OUIConstraintLayout r3 = r2.g;
        if (r3 == null) goto L12;
        r3.removeCallbacks(this.k);
    L12:
        r1.syncDockState(DraggableFloatingLayout.b.f26076a);
        r1.setBottomDockMarginPx(d(r7));
        a(r1, r7);
        b(r7);
        e r4 = this.f25407a;
        if (r4 == null) goto L17;
        OUIConstraintLayout r5 = r4.g;
        if (r5 == null) goto L17;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r8.width = -1;
        r8.height = -2;
        r6.setLayoutParams(r8);
    L17:
        e r9 = this.f25407a;
        if (r9 == null) goto L22;
        OUIConstraintLayout r10 = r9.g;
        if (r10 == null) goto L22;
        Resources r11 = Resources.getSystem();
        d.h.b.o.c(r11, "Resources.getSystem()");
        r10.setRadius(d.i.a.a(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics())));
    L22:
        r1.setTranslationX(0.0f);
        r1.setTranslationY(0.0f);
        e r12 = this.f25407a;
        if (r12 == null) goto L28;
        FrameLayout r13 = r12.f31607d;
        if (r13 == null) goto L28;
        r13.setVisibility(8);
    L28:
        if (r7 != l.g) goto L39;
        e r14 = this.f25407a;
        if (r14 == null) goto L34;
        FrameLayout r15 = r14.f31606c;
        if (r15 == null) goto L34;
        r15.setVisibility(8);
    L34:
        e r16 = this.f25407a;
        if (r16 == null) goto L49;
        FrameLayout r17 = r16.f31605b;
        if (r17 == null) goto L49;
        r17.setVisibility(0);
    L49:
        r1.post(new $$Lambda$PanelContainerComponent$1QpKOnXgX2ToZSy5CKeUHjAVtzk(this, r1));
        return;
    L39:
        e r18 = this.f25407a;
        if (r18 == null) goto L44;
        FrameLayout r19 = r18.f31606c;
        if (r19 == null) goto L44;
        r19.setVisibility(0);
    L44:
        e r20 = this.f25407a;
        if (r20 == null) goto L49;
        FrameLayout r21 = r20.f31605b;
        if (r21 == null) goto L49;
        r21.setVisibility(8);
        goto L49
    L52:
        return;
    }

    private static final void b(PanelContainerComponent r3, DraggableFloatingLayout r4) {
        e r0 = r3.f25407a;
        if (r0 == null) goto L5;
        DraggableFloatingLayout r1 = r0.f31604a;
    L6:
        if (r1 == r4) goto L8;
        return;
    L8:
        a r2 = r3.g;
        if (r2 == null) goto L19;
        k r5 = r2.a();
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.c() != j.f25497a) goto L16;
    L17:
        r3.a(r4, r5.a().a());
        r4.setTranslationX(0.0f);
        r4.setTranslationY(0.0f);
        r3.i();
        return;
    L16:
        if (r5.c() == j.f25499c) goto L17;
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void a(DraggableFloatingLayout r7, l r8) {
        int r0 = c(r8);
        int r6 = d(r8);
        View r9 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r11 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r11, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.width = -1;
        r1.height = -2;
        r1.gravity = 81;
        Resources r4 = Resources.getSystem();
        d.h.b.o.c(r4, "Resources.getSystem()");
        r1.setMargins(r0, d.i.a.a(TypedValue.applyDimension(1, 12, r4.getDisplayMetrics())), r0, r6);
        r9.setLayoutParams(r11);
    }

    private final void b(l r8) {
        if (e(r8) == false) goto L6;
        Resources r5 = Resources.getSystem();
        d.h.b.o.c(r5, "Resources.getSystem()");
        int r0 = d.i.a.a(TypedValue.applyDimension(1, 12, r5.getDisplayMetrics()));
    L10:
        if (e(r8) == false) goto L12;
        Resources r6 = Resources.getSystem();
        d.h.b.o.c(r6, "Resources.getSystem()");
        int r7 = d.i.a.a(TypedValue.applyDimension(1, 12, r6.getDisplayMetrics()));
    L14:
        if (e(r8) == false) goto L16;
        Resources r1 = Resources.getSystem();
        d.h.b.o.c(r1, "Resources.getSystem()");
        int r9 = d.i.a.a(TypedValue.applyDimension(1, 12, r1.getDisplayMetrics()));
    L17:
        e r10 = this.f25407a;
        if (r10 == null) goto L23;
        FrameLayout r11 = r10.f31606c;
        if (r11 == null) goto L24;
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        r11.setPadding(r0, d.i.a.a(TypedValue.applyDimension(1, 8, r2.getDisplayMetrics())), r7, r9);
        return;
    L24:
        return;
    L23:
        return;
    L16:
        Resources r3 = Resources.getSystem();
        d.h.b.o.c(r3, "Resources.getSystem()");
        r9 = d.i.a.a(TypedValue.applyDimension(1, 8, r3.getDisplayMetrics()));
        goto L17
    L12:
        Resources r12 = Resources.getSystem();
        d.h.b.o.c(r12, "Resources.getSystem()");
        r7 = d.i.a.a(TypedValue.applyDimension(1, 8, r12.getDisplayMetrics()));
        goto L14
    L6:
        if (r8 != l.f25507a) goto L8;
        Resources r13 = Resources.getSystem();
        d.h.b.o.c(r13, "Resources.getSystem()");
        r0 = d.i.a.a(TypedValue.applyDimension(1, 16, r13.getDisplayMetrics()));
        goto L10
    L8:
        Resources r14 = Resources.getSystem();
        d.h.b.o.c(r14, "Resources.getSystem()");
        r0 = d.i.a.a(TypedValue.applyDimension(1, 8, r14.getDisplayMetrics()));
        goto L10
    }

    private final void a(final boolean r11) {
        e r0 = this.f25407a;
        if (r0 != null) goto L5;
        return;
    L5:
        final DraggableFloatingLayout r1 = r0.f31604a;
        d.h.b.o.c(r1, "panelContainer");
        f();
        if (r11 == false) goto L8;
        r1.syncDockState(DraggableFloatingLayout.b.f26076a);
    L8:
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r7.width = -2;
        r7.height = -2;
        r7.gravity = 81;
        r7.setMargins(0, 0, 0, 0);
        r3.setLayoutParams(r6);
        r1.setScaleX(1.0f);
        r1.setScaleY(1.0f);
        OUIConstraintLayout r4 = r0.g;
        d.h.b.o.c(r4, "panelSlotsWrapper");
        View r8 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r9.width = -2;
        r9.height = -2;
        r8.setLayoutParams(r9);
        r0.g.removeCallbacks(this.k);
        r0.g.postDelayed(this.k, 300);
        FrameLayout r10 = r0.f31607d;
        d.h.b.o.c(r10, "panelFabSlot");
        View r12 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r13.width = -2;
        r13.height = -2;
        r12.setLayoutParams(r13);
        r0.f31607d.setVisibility(0);
        r0.f31606c.setVisibility(8);
        r0.f31605b.setVisibility(8);
        if (r1.isDragging() == false) goto L11;
        return;
    L11:
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        if (ViewCompat.F(r2) == true) goto L14;
    L36:
        r2.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new PanelContainerComponent$collapseLayout$$inlined$doOnLayout$1(this, r1, r11), View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        if (r2.isLayoutRequested() == true) goto L36;
        a r14 = c(this);
        if (r14 != null) goto L19;
        return;
    L19:
        if (r14.a().c() == j.f25498b) goto L21;
        return;
    L21:
        if (r1.isDragging() == true) goto L39;
        if (r11 == false) goto L24;
        r1.dockBottom();
    L35:
        d(this);
        return;
    L24:
        DraggableFloatingLayout.b r15 = r1.currentDock();
        int r16 = b.f25415a[r15.ordinal()];
        if (r16 != 1) goto L27;
        r1.dockBottom();
        goto L35
    L27:
        if (r16 != 2) goto L29;
        DraggableFloatingLayout.dockRightPeek$default(r1, null, 1, null);
        goto L35
    L29:
        if (r16 != 3) goto L32;
        r1.revealRightDock();
        goto L35
    L32:
        throw new d.k();
    }

    private final void h() {
        e r0 = this.f25407a;
        if (r0 == null) goto L14;
        DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isDragging() == false) goto L11;
        return;
    L11:
        if (r1.isRightDockPeek() == false) goto L15;
        g();
        r1.revealRightDock();
        return;
    L15:
        return;
    }

    private final void i() {
        e r2 = this.f25407a;
        if (r2 != null) goto L5;
        return;
    L5:
        PrivacyBadgeView r0 = r2.f;
        d.h.b.o.c(r0, "panelPrivacyBadge");
        DraggableFloatingLayout r3 = r2.f31604a;
        d.h.b.o.c(r3, "panelContainer");
        if (r3.isDragging() == false) goto L8;
        r0.setVisibility(4);
    L10:
        if (r3.isRightDockPeek() == false) goto L12;
        r0.setTranslationX((r3.getRightDockVisibleWidthPx() - r3.getWidth()) / 2.0f);
        return;
    L12:
        r0.setTranslationX(0.0f);
        return;
    L8:
        r0.setVisibility(0);
        goto L10
    }

    private final void j() {
        e r5 = this.f25407a;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.f31604a.setScaleX(0.9f);
        r5.f31604a.setScaleY(0.9f);
        OUIConstraintLayout r6 = r5.g;
        d.h.b.o.c(r6, "panelSlotsWrapper");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        float r1 = OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP;
        Resources r3 = Resources.getSystem();
        d.h.b.o.c(r3, "Resources.getSystem()");
        r0.height = d.i.a.a(TypedValue.applyDimension(1, r1, r3.getDisplayMetrics()));
        r7.setLayoutParams(r0);
    }

    private final void k() {
        e r2 = this.f25407a;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.f31604a.setScaleX(1.0f);
        r2.f31604a.setScaleY(1.0f);
        OUIConstraintLayout r3 = r2.g;
        d.h.b.o.c(r3, "panelSlotsWrapper");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.height = -2;
        r4.setLayoutParams(r0);
    }

    private final void l() {
        e r0 = this.f25407a;
        if (r0 == null) goto L26;
        final DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 == null) goto L28;
        final com.obric.autoaction.vdplayer.components.a.a.EnumC0618a r2 = this.j;
        if (r2 != null) goto L10;
        return;
    L10:
        a r3 = this.g;
        if (r3 == null) goto L15;
        k r4 = r3.a();
        if (r4 == null) goto L15;
        j r5 = r4.c();
    L17:
        if (r5 == j.f25498b) goto L19;
        return;
    L19:
        this.j = null;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        if (ViewCompat.F(r6) == true) goto L22;
    L24:
        r6.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new PanelContainerComponent$applyPendingDebugDockIfReady$$inlined$doOnLayout$1(this, r1, r2), View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        if (r6.isLayoutRequested() == true) goto L24;
        a(this, r1, r2);
        return;
    L15:
        r5 = null;
        goto L17
    L28:
        return;
    }

    private final void a(final DraggableFloatingLayout r4, com.obric.autoaction.vdplayer.components.a.a.EnumC0618a r5) {
        g();
        int r6 = b.f25418d[r5.ordinal()];
        if (r6 != 1) goto L5;
        r4.dockBottom();
    L19:
        i();
        return;
    L5:
        if (r6 != 2) goto L7;
        DraggableFloatingLayout.dockRightPeek$default(r4, null, 1, null);
        goto L19
    L7:
        if (r6 != 3) goto L16;
        if (r4.currentDock() != DraggableFloatingLayout.b.f26077b) goto L11;
    L14:
        r4.revealRightDock();
        goto L19
    L11:
        if (r4.currentDock() == DraggableFloatingLayout.b.f26078c) goto L14;
        DraggableFloatingLayout.dockRightPeek$default(r4, null, 1, null);
        r4.post(new $$Lambda$PanelContainerComponent$U8jw3zDh7V4wvFdkv375BaYyPuM(this, r4));
        goto L19
    L16:
        throw new d.k();
    }

    private static final void c(PanelContainerComponent r0, DraggableFloatingLayout r1) {
        r0.g();
        r1.revealRightDock();
    }

    @Override // com.obric.autoaction.vdplayer.components.a.a
    public boolean h_() {
        e r0 = this.f25407a;
        if (r0 == null) goto L11;
        DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 == null) goto L11;
        if (r1.isRightDockPeek() == false) goto L11;
        g();
        return r1.revealRightDock();
    L11:
        return false;
    }

    @Override // com.obric.autoaction.vdplayer.components.a.a
    public boolean i_() {
        e r0 = this.f25407a;
        if (r0 == null) goto L13;
        DraggableFloatingLayout r1 = r0.f31604a;
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.isRightDockPeek() == false) goto L11;
        g();
        return r1.revealRightDock();
    L11:
        a((r) ZeusTransformUtils.preCheckCast(r.C0625r.f25557a, r.class, "com.obric.aiagent.plugin"));
        return true;
    L13:
        return false;
    }

    @Override // androidx.lifecycle.d
    public void b(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.b(r4);
        this.k.run();
    }

    @Override // androidx.lifecycle.d
    public void d(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        e r0 = this.f25407a;
        if (r0 == null) goto L7;
        OUIConstraintLayout r1 = r0.g;
        if (r1 == null) goto L7;
        r1.removeCallbacks(this.k);
    L7:
        super.d(r4);
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        e r0 = this.f25407a;
        if (r0 == null) goto L7;
        OUIConstraintLayout r1 = r0.g;
        if (r1 == null) goto L7;
        r1.removeCallbacks(this.k);
    L7:
        super.e(r4);
        this.f25407a = null;
    }

    @Override // com.obric.autoaction.vdplayer.components.a.a
    public int a() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        k r1 = r0.a();
        if (r1 == null) goto L7;
        j r2 = r1.c();
    L9:
        if (r2 != j.f25498b) goto L11;
        return 0;
    L11:
        e r3 = this.f25407a;
        if (r3 == null) goto L17;
        DraggableFloatingLayout r4 = r3.f31604a;
        if (r4 != null) goto L16;
        return 0;
    L16:
        return r4.getTop();
    L17:
        return 0;
    L7:
        r2 = null;
        goto L9
    }

    private final PrivacyBadgeView.b b(a r6) {
        int r5 = b.f25417c[r6.a().c().ordinal()];
        boolean r0 = true;
        if (r5 != 1) goto L5;
    L11:
        PrivacyBadgeView.a r7 = PrivacyBadgeView.a.f25438b;
    L13:
        if (r6.b() == m.f25514c) goto L15;
        boolean r2 = true;
    L17:
        if (r7 == PrivacyBadgeView.a.f25438b) goto L19;
    L21:
        r0 = false;
    L23:
        return new PrivacyBadgeView.b(r2, r0, r7);
    L19:
        if (d.h.b.o.a(r6.a().a().d(), "security_normal") == false) goto L21;
    L15:
        r2 = false;
        goto L17
    L5:
        if (r5 == 2) goto L11;
        if (r5 != 3) goto L10;
        r7 = PrivacyBadgeView.a.f25437a;
        goto L13
    L10:
        throw new d.k();
    }

    private final int c(l r3) {
        if (e(r3) == false) goto L5;
        int r2 = 8;
    L6:
        Resources r1 = Resources.getSystem();
        d.h.b.o.c(r1, "Resources.getSystem()");
        return d.i.a.a(TypedValue.applyDimension(1, r2, r1.getDisplayMetrics()));
    L5:
        r2 = 12;
        goto L6
    }

    private final int d(l r2) {
        int r0 = this.i;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return c(r2);
    }

    private final int m() {
        if (this.i > 0) goto L7;
        int r4 = this.h;
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        return r4 + d.i.a.a(TypedValue.applyDimension(1, 4, r2.getDisplayMetrics()));
    L7:
        return this.h;
    }

    private final boolean e(l r1) {
        if (r1 != l.f25511e) goto L5;
    L16:
        return true;
    L5:
        if (r1 == l.f) goto L16;
        if (r1 == l.f25508b) goto L16;
        if (r1 == l.f25509c) goto L16;
        if (r1 == l.f25510d) goto L16;
        if (r1 == l.g) goto L16;
        return false;
    }

    private final void a(View r13) {
        float r0 = TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics());
        float r7 = -r0;
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, r7, r7, r0, r0, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, 0.0f, r7, r7, r0, 0.0f})});
        d.h.b.o.c(r12, "ofPropertyValuesHolder(...)");
        r12.setDuration(300);
        r12.start();
    }
}
