package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.lifecycle.ab;
import androidx.lifecycle.p;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.a.g;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpaceTypeDebugBadgeComponent implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f25312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f25313b;

    /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25314a = null;

        static {
            int[] r0 = new int[AOOperatingSpace.SpaceType.values().length];
            r0[AOOperatingSpace.SpaceType.ComputerControl.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AOOperatingSpace.SpaceType.VirtualDisplay.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AOOperatingSpace.SpaceType.MainDisplay.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f25314a = r0;
        }
    }

    /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
    @f(b = "SpaceTypeDebugBadgeComponent.kt", c = {75}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$onViewCreated$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SpaceTypeDebugBadgeComponent f25317c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
        @f(b = "SpaceTypeDebugBadgeComponent.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$onViewCreated$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25318a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SpaceTypeDebugBadgeComponent f25319b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$c$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
            @f(b = "SpaceTypeDebugBadgeComponent.kt", c = {78, 79}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$onViewCreated$1$1$1")
            static final class C06141 extends l implements m<i<? super AOOperatingSpace.SpaceType>, d.c.d<? super x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f25320a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f25321b;

                C06141(d.c.d<? super C06141> r3) {
                    super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(i<? super AOOperatingSpace.SpaceType> r3, d.c.d<? super x> r4) {
                    return ((C06141) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C06141.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                    C06141 r4 = new C06141((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                    r4.f25321b = r2;
                    return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(i<? super AOOperatingSpace.SpaceType> r3, d.c.d<? super x> r4) {
                    return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0076 -> B:7:0x001d). Please report as a decompilation issue!!! */
                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f25320a;
                    if (r1 == 0) goto L11;
                    if (r1 == 1) goto L10;
                    if (r1 != 2) goto L9;
                    i r2 = (i) ZeusTransformUtils.preCheckCast(this.f25321b, i.class, "com.obric.aiagent.plugin");
                    o.a(r8);
                L7:
                    i r9 = r2;
                L12:
                    AOOperatingSpace r3 = OperatingSpaceManager.INSTANCE.getActiveSpace();
                    if (r3 == null) goto L15;
                    AOOperatingSpace.SpaceType r4 = r3.getType();
                L16:
                    d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f25321b = r9;
                    this.f25320a = 1;
                    if (r9.emit(r4, r5) != r0) goto L19;
                    return r0;
                L19:
                    r2 = r9;
                L20:
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f25321b = r2;
                    this.f25320a = 2;
                    if (ax.a(500, r10) != r0) goto L7;
                    return r0;
                L15:
                    r4 = null;
                    goto L16
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    r2 = (i) ZeusTransformUtils.preCheckCast(this.f25321b, i.class, "com.obric.aiagent.plugin");
                    o.a(r8);
                    goto L20
                L11:
                    o.a(r8);
                    r9 = (i) ZeusTransformUtils.preCheckCast(this.f25321b, i.class, "com.obric.aiagent.plugin");
                    goto L12
                }
            }

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent$c$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: SpaceTypeDebugBadgeComponent.kt */
            /* synthetic */ class AnonymousClass2 implements d.h.b.i, i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ SpaceTypeDebugBadgeComponent f25322a;

                AnonymousClass2(SpaceTypeDebugBadgeComponent r1) {
                    this.f25322a = r1;
                }

                @Override // d.h.b.i
                public final d.c<?> a() {
                    return (d.c) ZeusTransformUtils.preCheckCast(new d.h.b.a(2, this.f25322a, SpaceTypeDebugBadgeComponent.class, "renderSpaceType", "renderSpaceType(Lcom/obric/autogui/common/api/space/AOOperatingSpace$SpaceType;)V", 4), d.c.class, "com.obric.aiagent.plugin");
                }

                public final boolean equals(Object r3) {
                    if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L5;
                    return false;
                L5:
                    if (ZeusTransformUtils.instanceOf(r3, d.h.b.i.class) == true) goto L7;
                    return false;
                L7:
                    return d.h.b.o.a(((d.h.b.i) ZeusTransformUtils.preCheckCast(this, d.h.b.i.class, "com.obric.aiagent.plugin")).a(), ((d.h.b.i) ZeusTransformUtils.preCheckCast(r3, d.h.b.i.class, "com.obric.aiagent.plugin")).a());
                }

                public final int hashCode() {
                    return ((d.h.b.i) ZeusTransformUtils.preCheckCast(this, d.h.b.i.class, "com.obric.aiagent.plugin")).a().hashCode();
                }

                public final Object a(AOOperatingSpace.SpaceType r3, d.c.d<? super x> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    Object r2 = AnonymousClass1.a(this.f25322a, r3, r5);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }

                @Override // kotlinx.coroutines.b.i
                public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                    d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    return a((AOOperatingSpace.SpaceType) ZeusTransformUtils.preCheckCast(r3, AOOperatingSpace.SpaceType.class, "com.obric.aiagent.plugin"), r5);
                }
            }

            AnonymousClass1(SpaceTypeDebugBadgeComponent r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25319b = r3;
                super(2, r5);
            }

            public static final /* synthetic */ Object a(SpaceTypeDebugBadgeComponent r2, AOOperatingSpace.SpaceType r3, d.c.d r4) {
                return b(r2, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25319b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25318a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                kotlinx.coroutines.b.h r7 = j.b(j.a((m) ZeusTransformUtils.preCheckCast(new C06141(null), m.class, "com.obric.aiagent.plugin")));
                i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f25319b), i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25318a = 1;
                if (r7.collect(r2, r3) != r0) goto L12;
                return r0;
            }

            private static final /* synthetic */ Object b(SpaceTypeDebugBadgeComponent r2, AOOperatingSpace.SpaceType r3, d.c.d r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                SpaceTypeDebugBadgeComponent.a(r2, r3);
                return x.f38692a;
            }
        }

        c(com.obric.autoaction.a.c r3, SpaceTypeDebugBadgeComponent r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25316b = r3;
            this.f25317c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25316b, this.f25317c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25315a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            p r8 = this.f25316b.b();
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2057d;
            m r3 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25317c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25315a = 1;
            if (ab.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        f25312a = new a(null);
    }

    public static /* synthetic */ al lambda$4ESO_148OSN2ieweYUzwPF8fORY(int r0, View r1, al r2) {
        return a(r0, r1, r2);
    }

    public SpaceTypeDebugBadgeComponent() {
    }

    public static final /* synthetic */ void a(SpaceTypeDebugBadgeComponent r0, AOOperatingSpace.SpaceType r1) {
        r0.a(r1);
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r1) {
        g.a.a(this, r1);
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r7, com.obric.autoaction.a.c r8) {
        d.h.b.o.e(r7, "container");
        d.h.b.o.e(r8, "componentHost");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r9);
        int r1 = a(r9, 10);
        int r2 = a(r9, 5);
        final int r0 = a(r9, 10);
        TextView r3 = new TextView(r9);
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast("Space Pending", CharSequence.class, "com.obric.aiagent.plugin"));
        r3.setTextColor(-1);
        r3.setTextSize(2, 12.0f);
        r3.setTypeface(Typeface.DEFAULT_BOLD);
        r3.setLetterSpacing(0.04f);
        r3.setPadding(r1, r2, r1, r2);
        r3.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.vd_debug_space_badge_bg, "drawable", "vd_debug_space_badge_bg"));
        r3.setElevation(a(r9, 8));
        r3.setClickable(false);
        r3.setFocusable(false);
        r3.setImportantForAccessibility(2);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2, 8388659);
        r10.setMarginStart(r0);
        r10.topMargin = r0;
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), new $$Lambda$SpaceTypeDebugBadgeComponent$4ESO_148OSN2ieweYUzwPF8fORY(r0));
        ViewCompat.u((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        this.f25313b = r3;
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    private static final al a(int r4, View r5, al r6) {
        d.h.b.o.e(r5, "view");
        d.h.b.o.e(r6, "insets");
        int r0 = r6.a(al.m.a()).f1211c;
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L10;
        int r3 = r0 + r4;
        if (r2.topMargin == r3) goto L10;
        r2.topMargin = r3;
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L10:
        return r6;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.autoaction.a.h
    public void a(View r7, com.obric.autoaction.a.c r8) {
        d.h.b.o.e(r7, "boundView");
        d.h.b.o.e(r8, "componentHost");
        kotlinx.coroutines.i.a(r8.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r8, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        d.h.b.o.e((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin"), "owner");
        this.f25313b = null;
    }

    private final void a(AOOperatingSpace.SpaceType r4) {
        TextView r3 = this.f25313b;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        int r1 = -1;
    L8:
        if (r1 != (-1)) goto L10;
        String r0 = "Space Pending";
    L21:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r4 != null) goto L24;
        float r5 = 0.65f;
    L25:
        r3.setAlpha(r5);
        return;
    L24:
        r5 = 1.0f;
        goto L25
    L10:
        if (r1 != 1) goto L12;
        r0 = "CC Space";
        goto L21
    L12:
        if (r1 != 2) goto L14;
        r0 = "VD Space";
        goto L21
    L14:
        if (r1 != 3) goto L17;
        r0 = "Main Display";
        goto L21
    L17:
        throw new k();
    L7:
        r1 = b.f25314a[r4.ordinal()];
        goto L8
    }

    private final int a(Context r2, int r3) {
        return d.i.a.a(r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }
}
