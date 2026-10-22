package com.obric.autoaction.vdplayer.legacy.components;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.q;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
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
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecHistoryListPopupComponent extends BaseVDPlayerSlotComponent<com.obric.autoaction.vdplayer.legacy.components.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f25728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f25729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.vdplayer.a.c f25730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f25732e;

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f25733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CharSequence f25735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f25736d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f25733a == r6.f25733a) goto L12;
            return false;
        L12:
            if (o.a(this.f25734b, r6.f25734b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25735c, r6.f25735c) == true) goto L18;
            return false;
        L18:
            if (this.f25736d == r6.f25736d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f25733a) * 31) + this.f25734b.hashCode()) * 31) + this.f25735c.hashCode()) * 31) + Boolean.hashCode(this.f25736d);
        }

        public String toString() {
            return "AppHistory(id=" + this.f25733a + ", packageName=" + this.f25734b + ", appLabel=" + this.f25735c + ", isLast=" + this.f25736d + ')';
        }

        public a(int r3, String r4, CharSequence r5, boolean r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r4, "packageName");
            o.e(r7, "appLabel");
            this.f25733a = r3;
            this.f25734b = r4;
            this.f25735c = r7;
            this.f25736d = r6;
        }

        public final String a() {
            return this.f25734b;
        }

        public final CharSequence b() {
            return this.f25735c;
        }

        public final boolean c() {
            return this.f25736d;
        }
    }

    /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
    private static final class b extends q<a, c> {

        /* JADX INFO: compiled from: ExecHistoryListPopupComponent.kt */
        private static final class a extends j.e<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f25737a = null;

            static {
                f25737a = new a();
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
            super((j.e) ZeusTransformUtils.preCheckCast(a.f25737a, j.e.class, "com.obric.aiagent.plugin"));
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

        public static /* synthetic */ ObjectAnimator lambda$TSCo0_gcIL_pRAQYRyi_JLJcOsE(c r0) {
            return a(r0);
        }

        public c(com.obric.autogui.vdplayer.a.b r4) {
            o.e(r4, "binding");
            super((View) ZeusTransformUtils.preCheckCast(r4.b(), View.class, "com.obric.aiagent.plugin"));
            this.r = r4;
            this.s = g.a(new $$Lambda$ExecHistoryListPopupComponent$c$TSCo0_gcIL_pRAQYRyi_JLJcOsE(this));
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
    @d.c.b.a.f(b = "ExecHistoryListPopupComponent.kt", c = {65}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.ExecHistoryListPopupComponent$onAttach$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExecHistoryListPopupComponent f25739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25740c;

        e(ExecHistoryListPopupComponent r3, com.obric.autoaction.a.c r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25739b = r3;
            this.f25740c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f25739b, this.f25740c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25738a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L16:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = this.f25739b.b();
            if (r7 == null) goto L18;
            ab<com.obric.autoaction.vdplayer.legacy.d.q> r8 = r7.c();
            if (r8 == null) goto L18;
            final ExecHistoryListPopupComponent r3 = this.f25739b;
            final com.obric.autoaction.a.c r4 = this.f25740c;
            i<? super com.obric.autoaction.vdplayer.legacy.d.q> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25738a = 1;
            if (r8.collect(r2, r5) != r0) goto L16;
            return r0;
        L18:
            return x.f38692a;
        }
    }

    static {
        f25728a = new d(null);
    }

    public static /* synthetic */ x lambda$0v8QvmB8BwGo8gYRsKjPbxxGLkU(ExecHistoryListPopupComponent r0, View r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$RRRL8ggyry8mL8Wo7EuaQiOyNU4(com.obric.autogui.vdplayer.a.c r0, com.obric.autoaction.vdplayer.legacy.components.c r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$f-FdkEF_BzAcLyB9Hwp1zWBtrHQ, reason: not valid java name */
    public static /* synthetic */ x m690lambda$fFdkEF_BzAcLyB9Hwp1zWBtrHQ(FrameLayout r0, FrameLayout r1, ExecHistoryListPopupComponent r2, boolean r3, Throwable r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$rHgHL-z74eX160PZc3Mz2hFfxLI, reason: not valid java name */
    public static /* synthetic */ com.obric.autoaction.vdplayer.legacy.components.c m691lambda$rHgHLz74eX160PZc3Mz2hFfxLI(s r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$sMjNuWb1CT-FkZg3PAdxoFoYPMk, reason: not valid java name */
    public static /* synthetic */ x m692lambda$sMjNuWb1CTFkZg3PAdxoFoYPMk(ExecHistoryListPopupComponent r0, View r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uUA89nmB3GPSmKCTmLMZCB7-4Ek, reason: not valid java name */
    public static /* synthetic */ void m693lambda$uUA89nmB3GPSmKCTmLMZCB74Ek(com.obric.autogui.vdplayer.a.c r0) {
        a(r0);
    }

    public static /* synthetic */ b lambda$wHsUHJGHSPFzHHBp_ZyPegvgi18() {
        return e();
    }

    public static final /* synthetic */ void a(ExecHistoryListPopupComponent r0, com.obric.autoaction.a.c r1, com.obric.autoaction.vdplayer.legacy.components.c r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(ExecHistoryListPopupComponent r0, boolean r1) {
        r0.a(r1);
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((com.obric.autoaction.vdplayer.legacy.components.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.legacy.components.c.class, "com.obric.aiagent.plugin"));
    }

    public ExecHistoryListPopupComponent() {
        super($$Lambda$ExecHistoryListPopupComponent$rHgHLz74eX160PZc3Mz2hFfxLI.INSTANCE);
        this.f25732e = g.a($$Lambda$ExecHistoryListPopupComponent$wHsUHJGHSPFzHHBp_ZyPegvgi18.INSTANCE);
    }

    private static final com.obric.autoaction.vdplayer.legacy.components.c a(s r1) {
        o.e(r1, "it");
        return new com.obric.autoaction.vdplayer.legacy.components.c(r1.d());
    }

    private final b d() {
        return (b) ZeusTransformUtils.preCheckCast(this.f25732e.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b e() {
        return new b();
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
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

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        o.e(r2, "boundView");
        o.e(r3, "componentHost");
        super.a(r2, r3);
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.class) == false) goto L5;
        FrameLayout r4 = (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin");
    L6:
        this.f25729b = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void a(com.obric.autoaction.vdplayer.legacy.components.c r2) {
        o.e(r2, "state");
        super.a(r2);
        if (this.f25731d == false) goto L8;
        com.obric.autogui.vdplayer.a.c r0 = this.f25730c;
        if (r0 == null) goto L9;
        o.a(r0);
        a(r0, r2);
        return;
    L9:
        return;
    }

    private final void a(com.obric.autoaction.a.c r9, com.obric.autoaction.vdplayer.legacy.components.c r10) {
        FrameLayout r0 = this.f25729b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r10.a().isEmpty() == false) goto L10;
        a(true);
        return;
    L10:
        if (this.f25731d == false) goto L15;
        com.obric.autogui.vdplayer.a.c r1 = this.f25730c;
        if (r1 == null) goto L15;
        o.a(r1);
        a(r1, r10);
        return;
    L15:
        final com.obric.autogui.vdplayer.a.c r11 = com.obric.autogui.vdplayer.a.c.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin"), false);
        o.c(r11, "inflate(...)");
        this.f25730c = r11;
        this.f25731d = true;
        RecyclerView r3 = r11.f31595b;
        r3.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r3.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(d(), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r3.setHasFixedSize(false);
        a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r11);
        a(r11, r10);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 8388691;
        FrameLayout r12 = r11.b();
        Resources r4 = Resources.getSystem();
        o.c(r4, "Resources.getSystem()");
        r12.setTranslationX(TypedValue.applyDimension(1, -25.0f, r4.getDisplayMetrics()));
        FrameLayout r13 = r11.b();
        Resources r5 = Resources.getSystem();
        o.c(r5, "Resources.getSystem()");
        r13.setTranslationY(TypedValue.applyDimension(1, 25.0f, r5.getDisplayMetrics()));
        r11.b().setAlpha(0.0f);
        r11.b().setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.shadow, "drawable", "shadow"));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r11.b(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r11.b().post(new $$Lambda$ExecHistoryListPopupComponent$uUA89nmB3GPSmKCTmLMZCB74Ek(r11));
    }

    private static final void a(com.obric.autogui.vdplayer.a.c r18) {
        FrameLayout r0 = r18.b();
        float r1 = 48;
        Resources r2 = Resources.getSystem();
        o.c(r2, "Resources.getSystem()");
        r0.setPivotX(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        FrameLayout r3 = r18.b();
        float r4 = r18.b().getHeight();
        Resources r5 = Resources.getSystem();
        o.c(r5, "Resources.getSystem()");
        r3.setPivotY(r4 - TypedValue.applyDimension(1, r1, r5.getDisplayMetrics()));
        r18.b().setScaleX(0.16f);
        r18.b().setScaleY(0.16f);
        FrameLayout r6 = r18.b();
        o.c(r6, "getRoot(...)");
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b.a(), 0, com.obric.common.oea.foundation.animation.h.e.d.j, 2, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null), 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32431d, com.obric.common.oea.foundation.animation.h.e.c.f32442e, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).b(), null, null, 3, null);
    }

    private final void a(View r9, com.obric.autogui.vdplayer.a.c r10) {
        r10.b().setClickable(true);
        r10.b().setFocusable(true);
        r9.setClickable(true);
        com.obric.autoaction.view.a.a(r9, 0, new $$Lambda$ExecHistoryListPopupComponent$0v8QvmB8BwGo8gYRsKjPbxxGLkU(this), 1, null);
        FrameLayout r11 = r10.b();
        o.c(r11, "getRoot(...)");
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$ExecHistoryListPopupComponent$sMjNuWb1CTFkZg3PAdxoFoYPMk(this), 1, null);
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

    private final void a(final com.obric.autogui.vdplayer.a.c r13, final com.obric.autoaction.vdplayer.legacy.components.c r14) {
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
        com.obric.autoaction.vdplayer.legacy.d.h r9 = (com.obric.autoaction.vdplayer.legacy.d.h) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.vdplayer.legacy.d.h.class, "com.obric.aiagent.plugin");
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
        r12.a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), new $$Lambda$ExecHistoryListPopupComponent$RRRL8ggyry8mL8Wo7EuaQiOyNU4(r13, r14));
        return;
    L12:
        r3 = r0.getString(ZeusTransformUtils.mapRes(R.string.obric_vd_app_history_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_app_history_title"));
        o.c(r3, "getString(...)");
        goto L14
    }

    private static final void b(com.obric.autogui.vdplayer.a.c r1, com.obric.autoaction.vdplayer.legacy.components.c r2) {
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
        if (this.f25731d == true) goto L5;
        return;
    L5:
        final FrameLayout r1 = this.f25729b;
        if (r1 != null) goto L8;
        return;
    L8:
        com.obric.autogui.vdplayer.a.c r2 = this.f25730c;
        if (r2 == null) goto L19;
        final FrameLayout r3 = r2.b();
        if (r3 == null) goto L20;
        this.f25731d = false;
        r1.setOnClickListener(null);
        r1.setClickable(false);
        r3.animate().cancel();
        if (r23 == false) goto L17;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        this.f25730c = null;
        return;
    L17:
        com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), 0.0f, 1, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b.a(), 0, com.obric.common.oea.foundation.animation.h.e.d.j, 2, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null), 0.16f, 0.16f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32431d, com.obric.common.oea.foundation.animation.h.e.c.f32442e, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$ExecHistoryListPopupComponent$fFdkEF_BzAcLyB9Hwp1zWBtrHQ(r3, r1, this)).b(), null, null, 3, null);
        return;
    L20:
        return;
    }

    private static final x a(FrameLayout r0, FrameLayout r1, ExecHistoryListPopupComponent r2, boolean r3, Throwable r4) {
        if (o.a(r0.getParent(), r1) == false) goto L5;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
    L5:
        com.obric.autogui.vdplayer.a.c r5 = r2.f25730c;
        if (r5 == null) goto L8;
        FrameLayout r6 = r5.b();
    L10:
        if (o.a(r6, r0) == false) goto L13;
        r2.f25730c = null;
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
    public void e(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        this.f25730c = null;
        this.f25729b = null;
        super.e(r4);
    }
}
