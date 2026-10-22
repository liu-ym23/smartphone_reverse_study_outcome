package com.obric.autoaction.vdplayer.components;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autoaction.vdplayer.d.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecHistoryListPopupComponent extends BaseVDPlayerSlotComponent<com.obric.autoaction.vdplayer.components.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f25249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f25250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.vdplayer.a.c f25251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25253e;
    private final f f;

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CharSequence f25256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f25257d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f25254a == r6.f25254a) goto L12;
            return false;
        L12:
            if (o.a(this.f25255b, r6.f25255b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25256c, r6.f25256c) == true) goto L18;
            return false;
        L18:
            if (this.f25257d == r6.f25257d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f25254a) * 31) + this.f25255b.hashCode()) * 31) + this.f25256c.hashCode()) * 31) + Boolean.hashCode(this.f25257d);
        }

        public String toString() {
            return "AppHistory(id=" + this.f25254a + ", packageName=" + this.f25255b + ", appLabel=" + this.f25256c + ", isLast=" + this.f25257d + ')';
        }

        public a(int r3, String r4, CharSequence r5, boolean r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r4, "packageName");
            o.e(r7, "appLabel");
            this.f25254a = r3;
            this.f25255b = r4;
            this.f25256c = r7;
            this.f25257d = r6;
        }

        public final String a() {
            return this.f25255b;
        }

        public final CharSequence b() {
            return this.f25256c;
        }

        public final boolean c() {
            return this.f25257d;
        }
    }

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    private static final class b extends q<a, c> {

        /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
        private static final class a extends j.e<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f25258a = null;

            static {
                f25258a = new a();
            }

            private a() {
            }

            @Override // androidx.recyclerview.widget.j.e
            public /* synthetic */ boolean a(a r3, a r4) {
                return a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
            }

            @Override // androidx.recyclerview.widget.j.e
            public /* synthetic */ boolean b(a r3, a r4) {
                return b2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
            }

            @Override // androidx.recyclerview.widget.j.e
            public /* synthetic */ Object c(a r3, a r4) {
                return c2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public boolean a2(a r1, a r2) {
                o.e(r1, "oldItem");
                o.e(r2, "newItem");
                return o.a(r1.a(), r2.a());
            }

            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
            public boolean b2(a r1, a r2) {
                o.e(r1, "oldItem");
                o.e(r2, "newItem");
                return o.a(r1, r2);
            }

            /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
            public Object c2(a r2, a r3) {
                o.e(r2, "oldItem");
                o.e(r3, "newItem");
                if (o.a(r2.a(), r3.a()) == true) goto L5;
                return null;
            L5:
                if (r2.c() != r3.c()) goto L7;
                return null;
            L7:
                return Boolean.valueOf(r3.c());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
            return (RecyclerView.u) ZeusTransformUtils.preCheckCast(c(r1, r2), RecyclerView.u.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ void a(RecyclerView.u r3, int r4) {
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ void a(RecyclerView.u r3, int r4, List r5) {
            List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), r4, r6);
        }

        public b() {
            super((j.e) ZeusTransformUtils.preCheckCast(a.f25258a, j.e.class, "com.obric.aiagent.plugin"));
        }

        public c c(ViewGroup r2, int r3) {
            o.e(r2, "parent");
            com.obric.autogui.vdplayer.a.b r1 = com.obric.autogui.vdplayer.a.b.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r2, false);
            o.c(r1, "inflate(...)");
            return new c(r1);
        }

        public void a(c r2, int r3) {
            o.e(r2, "holder");
            a r1 = c(r3);
            o.c(r1, "getItem(...)");
            r2.a((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin"));
        }

        public void a(c r3, int r4, List<Object> r5) {
            List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "holder");
            o.e(r6, "payloads");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
            r3.b(((a) ZeusTransformUtils.preCheckCast(c(r4), a.class, "com.obric.aiagent.plugin")).c());
            return;
        L5:
            super.a((RecyclerView.u) ZeusTransformUtils.preCheckCast(r3, RecyclerView.u.class, "com.obric.aiagent.plugin"), r4, r6);
        }
    }

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    private static final class c extends RecyclerView.u {
        private final com.obric.autogui.vdplayer.a.b r;
        private final f s;

        public static /* synthetic */ ObjectAnimator lambda$X62R9IjbTMiPwB22HsTlopCYJu4(c r0) {
            return a(r0);
        }

        public c(com.obric.autogui.vdplayer.a.b r4) {
            o.e(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.b(), View.class, "com.obric.aiagent.plugin"));
            this.r = r4;
            this.s = g.a(new $$Lambda$ExecHistoryListPopupComponent$c$X62R9IjbTMiPwB22HsTlopCYJu4(this));
        }

        private final ObjectAnimator E() {
            Object r2 = this.s.b();
            o.c(r2, "getValue(...)");
            return (ObjectAnimator) ZeusTransformUtils.preCheckCast(r2, ObjectAnimator.class, "com.obric.aiagent.plugin");
        }

        private static final ObjectAnimator a(c r3) {
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r3.r.f31589a, View.ROTATION, new float[]{0.0f, 360.0f});
            r4.setDuration(1000);
            r4.setRepeatCount(-1);
            r4.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
            return r4;
        }

        public final void a(a r4) {
            o.e(r4, "item");
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.r.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            this.r.f31591c.setText(r4.b());
            ImageView r1 = this.r.f31590b;
            o.a(r0);
            r1.setImageDrawable(com.obric.autoaction.vdplayer.components.a.a(r0, r4.a()));
            b(r4.c());
        }

        public final void b(boolean r4) {
            View r0 = this.r.f31592d;
            o.c(r0, "divider");
            if ((!r4) == false) goto L5;
            int r1 = 0;
        L6:
            r0.setVisibility(r1);
            if (r4 == false) goto L12;
            this.r.f31589a.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_vd_loading, "drawable", "ic_vd_loading"));
            if (E().isRunning() == true) goto L11;
            E().start();
        L11:
            this.r.f31591c.setAlpha(1.0f);
            this.r.f31589a.setAlpha(1.0f);
            this.r.f31590b.setAlpha(1.0f);
            return;
        L12:
            E().cancel();
            this.r.f31589a.setRotation(0.0f);
            this.r.f31589a.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_vd_checkmark, "drawable", "ic_vd_checkmark"));
            this.r.f31591c.setAlpha(0.3f);
            this.r.f31589a.setAlpha(0.3f);
            this.r.f31590b.setAlpha(0.3f);
            return;
        L5:
            r1 = 8;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    public static final class d {
        public /* synthetic */ d(h r1) {
            this();
        }

        private d() {
        }
    }

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    @d.c.b.a.f(b = "ExecHistoryListPopupComponent.kt", c = {68}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.ExecHistoryListPopupComponent$onAttach$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExecHistoryListPopupComponent f25260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25261c;

        e(ExecHistoryListPopupComponent r3, com.obric.autoaction.a.c r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25260b = r3;
            this.f25261c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f25260b, this.f25261c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25259a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L16:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = this.f25260b.b();
            if (r7 == null) goto L18;
            ab<com.obric.autoaction.vdplayer.d.q> r8 = r7.c();
            if (r8 == null) goto L18;
            final ExecHistoryListPopupComponent r3 = this.f25260b;
            final com.obric.autoaction.a.c r4 = this.f25261c;
            i<? super com.obric.autoaction.vdplayer.d.q> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25259a = 1;
            if (r8.collect(r2, r5) != r0) goto L16;
            return r0;
        L18:
            return x.f38692a;
        }
    }

    static {
        f25249a = new d(null);
    }

    public static /* synthetic */ al lambda$8X5eK1fb30RkdIWC4Rm1fnRHA5o(ExecHistoryListPopupComponent r0, View r1, al r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$BPWpn-nWxwP8Iu1zTEE7mUHnGF8, reason: not valid java name */
    public static /* synthetic */ void m656lambda$BPWpnnWxwP8Iu1zTEE7mUHnGF8(com.obric.autogui.vdplayer.a.c r0, com.obric.autoaction.vdplayer.components.d r1) {
        b(r0, r1);
    }

    public static /* synthetic */ x lambda$BdXU0GhK6rTmnBQo24nRp8jO_bg(FrameLayout r0, FrameLayout r1, ExecHistoryListPopupComponent r2, boolean r3, Throwable r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.autoaction.vdplayer.components.d lambda$GO1tCR46BHB6yOMQHMmwxHASelM(s r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$_2DgsFqqMG9hL3YGdTd7Tr5h0l4(ExecHistoryListPopupComponent r0, com.obric.autogui.vdplayer.a.c r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$iGyS7N7vaNguo_zNPTKoIr-9ARs, reason: not valid java name */
    public static /* synthetic */ x m657lambda$iGyS7N7vaNguo_zNPTKoIr9ARs(ExecHistoryListPopupComponent r0, View r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ b lambda$uIKlMev2YCmyfJZUErbViEQbfL0() {
        return e();
    }

    public static /* synthetic */ x lambda$xNBuRyhuj0PZovo4udksburxC2Y(ExecHistoryListPopupComponent r0, View r1) {
        return a(r0, r1);
    }

    public static final /* synthetic */ void a(ExecHistoryListPopupComponent r0, com.obric.autoaction.a.c r1, com.obric.autoaction.vdplayer.components.d r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(ExecHistoryListPopupComponent r0, boolean r1) {
        r0.a(r1);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((com.obric.autoaction.vdplayer.components.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.components.d.class, "com.obric.aiagent.plugin"));
    }

    public ExecHistoryListPopupComponent() {
        super($$Lambda$ExecHistoryListPopupComponent$GO1tCR46BHB6yOMQHMmwxHASelM.INSTANCE);
        this.f = g.a($$Lambda$ExecHistoryListPopupComponent$uIKlMev2YCmyfJZUErbViEQbfL0.INSTANCE);
    }

    private static final com.obric.autoaction.vdplayer.components.d a(s r1) {
        o.e(r1, "it");
        return new com.obric.autoaction.vdplayer.components.d(r1.d());
    }

    private final b d() {
        return (b) ZeusTransformUtils.preCheckCast(this.f.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b e() {
        return new b();
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r8) {
        o.e(r8, "componentHost");
        super.a(r8);
        kotlinx.coroutines.i.a(r8.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r3, com.obric.autoaction.a.c r4) {
        o.e(r3, "container");
        o.e(r4, "componentHost");
        FrameLayout r2 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.setId(ZeusTransformUtils.mapRes(R.id.vd_component_app_list_popup_root_id, DbHelper.COL_ID, "vd_component_app_list_popup_root_id"));
        r2.setClickable(false);
        r2.setFocusable(false);
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.class) == false) goto L5;
        FrameLayout r4 = (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    L6:
        this.f25250b = r4;
        ViewCompat.a(r2, new $$Lambda$ExecHistoryListPopupComponent$8X5eK1fb30RkdIWC4Rm1fnRHA5o(this));
        ViewCompat.u(r2);
        return;
    L5:
        r4 = null;
        goto L6
    }

    private static final al a(ExecHistoryListPopupComponent r1, View r2, al r3) {
        o.e(r2, "<unused var>");
        o.e(r3, "insets");
        r1.f25253e = r3.a(al.m.e()).f1213e;
        com.obric.autogui.vdplayer.a.c r4 = r1.f25251c;
        if (r4 == null) goto L5;
        r1.a(r4);
    L5:
        return r3;
    }

    public void a(com.obric.autoaction.vdplayer.components.d r2) {
        o.e(r2, "state");
        super.a(r2);
        if (this.f25252d == false) goto L8;
        com.obric.autogui.vdplayer.a.c r0 = this.f25251c;
        if (r0 == null) goto L9;
        o.a(r0);
        a(r0, r2);
        return;
    L9:
        return;
    }

    private final void a(com.obric.autoaction.a.c r8, com.obric.autoaction.vdplayer.components.d r9) {
        FrameLayout r0 = this.f25250b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r9.a().isEmpty() == false) goto L10;
        a(true);
        return;
    L10:
        if (this.f25252d == false) goto L15;
        com.obric.autogui.vdplayer.a.c r1 = this.f25251c;
        if (r1 == null) goto L15;
        o.a(r1);
        a(r1, r9);
        return;
    L15:
        final com.obric.autogui.vdplayer.a.c r10 = com.obric.autogui.vdplayer.a.c.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin"), false);
        o.c(r10, "inflate(...)");
        this.f25251c = r10;
        this.f25252d = true;
        RecyclerView r2 = r10.f31595b;
        r2.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r2.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(d(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r2.setHasFixedSize(false);
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r10);
        a(r10, r9);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 8388691;
        r10.b().setAlpha(0.0f);
        r10.b().setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.shadow, "drawable", "shadow"));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r10.b(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        a(r10);
        r10.b().post(new $$Lambda$ExecHistoryListPopupComponent$_2DgsFqqMG9hL3YGdTd7Tr5h0l4(this, r10));
    }

    private static final void a(ExecHistoryListPopupComponent r18, com.obric.autogui.vdplayer.a.c r19) {
        if (r18.f25251c == r19) goto L5;
        return;
    L5:
        if (r18.f25252d == false) goto L10;
        r19.b().setPivotX(r19.b().getPaddingLeft());
        r19.b().setPivotY(r19.b().getHeight() - r19.b().getPaddingBottom());
        r19.b().setScaleX(0.16f);
        r19.b().setScaleY(0.16f);
        FrameLayout r0 = r19.b();
        o.c(r0, "getRoot(...)");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b.a(), 0, com.obric.common.oea.foundation.animation.h.e.d.j, 2, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null), 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32431d, com.obric.common.oea.foundation.animation.h.e.c.f32442e, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).b(), null, null, 3, null);
        return;
    }

    private final void a(com.obric.autogui.vdplayer.a.c r8) {
        int r7 = this.f25253e;
        if (r7 <= 0) goto L5;
        Resources r4 = Resources.getSystem();
        o.c(r4, "Resources.getSystem()");
        int r9 = r7 + d.i.a.a(TypedValue.applyDimension(1, 8, r4.getDisplayMetrics()));
    L6:
        FrameLayout r3 = r8.b();
        o.c(r3, "getRoot(...)");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r10 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        Resources r12 = Resources.getSystem();
        o.c(r12, "Resources.getSystem()");
        r11.leftMargin = d.i.a.a(TypedValue.applyDimension(1, 20, r12.getDisplayMetrics())) - r8.b().getPaddingLeft();
        r11.bottomMargin = r9 - r8.b().getPaddingBottom();
        r5.setLayoutParams(r10);
        return;
    L5:
        Resources r13 = Resources.getSystem();
        o.c(r13, "Resources.getSystem()");
        r9 = d.i.a.a(TypedValue.applyDimension(1, 20, r13.getDisplayMetrics()));
        goto L6
    }

    private final void a(View r9, com.obric.autogui.vdplayer.a.c r10) {
        r10.b().setClickable(true);
        r10.b().setFocusable(true);
        r9.setClickable(true);
        com.obric.autoaction.view.a.a(r9, 0, new $$Lambda$ExecHistoryListPopupComponent$xNBuRyhuj0PZovo4udksburxC2Y(this), 1, null);
        FrameLayout r11 = r10.b();
        o.c(r11, "getRoot(...)");
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$ExecHistoryListPopupComponent$iGyS7N7vaNguo_zNPTKoIr9ARs(this), 1, null);
    }

    private static final x a(ExecHistoryListPopupComponent r2, View r3) {
        o.e(r3, "it");
        a(r2, false, 1, null);
        return x.f38692a;
    }

    private static final x b(ExecHistoryListPopupComponent r2, View r3) {
        o.e(r3, "it");
        a(r2, false, 1, null);
        return x.f38692a;
    }

    private final void a(final com.obric.autogui.vdplayer.a.c r13, final com.obric.autoaction.vdplayer.components.d r14) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        u r2 = b();
        if (r2 == null) goto L12;
        String r3 = r2.f();
        if (r3 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
    L14:
        if (o.a(r13.f31597d.getText(), r3) == true) goto L17;
        r13.f31597d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    L17:
        if (r14.a().isEmpty() == false) goto L19;
        return;
    L19:
        b r12 = d();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r14.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r1.iterator();
        int r6 = 0;
    L21:
        if (r5.hasNext() == false) goto L36;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L25;
        p.c();
    L25:
        com.obric.autoaction.vdplayer.d.h r9 = (com.obric.autoaction.vdplayer.d.h) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.vdplayer.d.h.class, "com.obric.aiagent.plugin");
        if (r9.c() != null) goto L28;
        a r10 = null;
    L33:
        if (r10 == null) goto L35;
        r4.add(r10);
    L35:
        r6 = r8;
        goto L21
    L28:
        String r11 = r9.c();
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.b(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != p.b(r14.a())) goto L31;
        boolean r16 = true;
    L32:
        r10 = new a(r6, r11, r15, r16);
        goto L33
    L31:
        r16 = false;
        goto L32
    L36:
        r12.a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), new $$Lambda$ExecHistoryListPopupComponent$BPWpnnWxwP8Iu1zTEE7mUHnGF8(r13, r14));
        return;
    L12:
        r3 = r0.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_app_history_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_app_history_title"));
        o.c(r3, "getString(...)");
        goto L14
    }

    private static final void b(com.obric.autogui.vdplayer.a.c r1, com.obric.autoaction.vdplayer.components.d r2) {
        if (r1.f31595b.getScrollState() != 0) goto L6;
        r1.f31595b.scrollToPosition(p.b(r2.a()));
        return;
    }

    static /* synthetic */ void a(ExecHistoryListPopupComponent r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    private final void a(boolean r23) {
        if (this.f25252d == true) goto L5;
        return;
    L5:
        final FrameLayout r1 = this.f25250b;
        if (r1 != null) goto L8;
        return;
    L8:
        com.obric.autogui.vdplayer.a.c r2 = this.f25251c;
        if (r2 == null) goto L19;
        final FrameLayout r3 = r2.b();
        if (r3 == null) goto L20;
        this.f25252d = false;
        r1.setOnClickListener(null);
        r1.setClickable(false);
        r3.animate().cancel();
        if (r23 == false) goto L17;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        this.f25251c = null;
        return;
    L17:
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b.a(), 0, com.obric.common.oea.foundation.animation.h.e.d.j, 2, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null), 0.16f, 0.16f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32431d, com.obric.common.oea.foundation.animation.h.e.c.f32442e, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$ExecHistoryListPopupComponent$BdXU0GhK6rTmnBQo24nRp8jO_bg(r3, r1, this)).b(), null, null, 3, null);
        return;
    L20:
        return;
    }

    private static final x a(FrameLayout r0, FrameLayout r1, ExecHistoryListPopupComponent r2, boolean r3, Throwable r4) {
        if (o.a(r0.getParent(), r1) == false) goto L5;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    L5:
        com.obric.autogui.vdplayer.a.c r5 = r2.f25251c;
        if (r5 == null) goto L8;
        FrameLayout r6 = r5.b();
    L10:
        if (o.a(r6, r0) == false) goto L13;
        r2.f25251c = null;
    L13:
        return x.f38692a;
    L8:
        r6 = null;
        goto L10
    }

    @Override // androidx.lifecycle.d
    public void d(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.d(r4);
        a(true);
    }

    @Override // androidx.lifecycle.d
    public void e(androidx.lifecycle.p r5) {
        androidx.lifecycle.p r6 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r6, "owner");
        FrameLayout r0 = this.f25250b;
        if (r0 == null) goto L5;
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), null);
    L5:
        this.f25251c = null;
        this.f25250b = null;
        super.e(r6);
    }
}
