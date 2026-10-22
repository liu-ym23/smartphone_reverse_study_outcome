package com.obric.autoaction.app.launcherpage.module.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.aj;
import com.obric.event.task.base.report.p;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: AutoActionTaskSimpleFutureCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aj f24060a;
    private final d.f s;
    private final d.f t;
    private final d.f u;

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class a implements d.f<com.obric.autoaction.app.launcherpage.module.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.c f24064d;

        public a(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24061a = r3;
            this.f24062b = r6;
            this.f24063c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.c b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        public com.obric.autoaction.app.launcherpage.module.c a() {
            com.obric.autoaction.app.launcherpage.module.c r0 = this.f24064d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24061a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24062b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24063c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.c.class);
            this.f24064d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24061a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class b implements d.f<com.obric.autoaction.app.launcherpage.module.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.d f24068d;

        public b(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24065a = r3;
            this.f24066b = r6;
            this.f24067c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.d b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        public com.obric.autoaction.app.launcherpage.module.d a() {
            com.obric.autoaction.app.launcherpage.module.d r0 = this.f24068d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24065a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24066b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24067c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.d.class);
            this.f24068d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24065a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class c implements d.f<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private p f24072d;

        public c(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24069a = r3;
            this.f24070b = r6;
            this.f24071c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        @Override // d.f
        public /* synthetic */ p b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        public p a() {
            p r0 = this.f24072d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24069a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24070b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24071c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(p.class);
            this.f24072d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24069a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    public static /* synthetic */ x lambda$DuYrmpVqV3t_XLkURzJ4XibCUug(com.obric.autoaction.app.launcherpage.module.a.a.c r0, Context r1, List r2, OPopoverEntranceMenuView.a r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$EwsGrMi9KBlOOlUAk0ByKEH9fQc(d.h.a.a r0, Context r1, com.obric.autoaction.app.launcherpage.module.a.a.c r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$MKxgD_o76bnEK_9PKsDi9cLZ750(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ x lambda$QJLtcDXAQGBuBM10DPGcaW2nvVg(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ void lambda$cQ3sqTgQMhACDNn5g1SC2Nz872M(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$eIoLyoMPl7u835XjygF2ieANvy4(f r0, m r1, View r2, int[] r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$edsqTaGGKuzuxaJNsdmkHJkNBM4(d.h.a.a r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1, Context r2, List r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$zzJrkNE959Ng7-xuJapW-Cy3eEY, reason: not valid java name */
    public static /* synthetic */ void m546lambda$zzJrkNE959Ng7xuJapWCy3eEY(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        b(r0, r1);
    }

    public f() {
        this.s = (d.f) ZeusTransformUtils.preCheckCast(new a((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.t = (d.f) ZeusTransformUtils.preCheckCast(new b((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.u = (d.f) ZeusTransformUtils.preCheckCast(new c((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.c) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.module.a.a.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.c.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.module.c I() {
        return (com.obric.autoaction.app.launcherpage.module.c) ZeusTransformUtils.preCheckCast(this.s.b(), com.obric.autoaction.app.launcherpage.module.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.module.d J() {
        return (com.obric.autoaction.app.launcherpage.module.d) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.autoaction.app.launcherpage.module.d.class, "com.obric.aiagent.plugin");
    }

    private final p K() {
        return (p) ZeusTransformUtils.preCheckCast(this.u.b(), p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r8) {
        o.e(r8, "parent");
        aj r0 = aj.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r8, false);
        o.c(r0, "inflate(...)");
        this.f24060a = r0;
        aj r2 = null;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        r0.f22742a.getTextView().setTextAppearance(ZeusTransformUtils.mapRes(R.style.Label_L, "style", "Label_L"));
        aj r1 = this.f24060a;
        if (r1 != null) goto L8;
        o.c("binding");
        r1 = null;
    L8:
        r1.f22742a.getTextView().setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_2, "color", "oui_text_2")));
        aj r9 = this.f24060a;
        if (r9 != null) goto L11;
        o.c("binding");
        r9 = null;
    L11:
        r9.b().setRadius(d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        aj r7 = this.f24060a;
        if (r7 != null) goto L14;
        o.c("binding");
    L15:
        OUILinearLayout r10 = r2.b();
        o.c(r10, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
    L14:
        r2 = r7;
        goto L15
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.c r4) {
        o.e(r4, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
        K().a("future_session_module", "pending_execution", r4.a().toString(), null);
    }

    public void a(final com.obric.autoaction.app.launcherpage.module.a.a.c r4, List<? extends Object> r5) {
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "item");
        o.e(r6, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r6);
        aj r7 = this.f24060a;
        if (r7 != null) goto L5;
        o.c("binding");
        r7 = null;
    L5:
        r7.f22742a.setTextImmediately((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.aiagent.plugin"));
        this.f35660b.setOnClickListener(new $$Lambda$f$cQ3sqTgQMhACDNn5g1SC2Nz872M(this, r4));
        this.f35660b.post(new $$Lambda$f$zzJrkNE959Ng7xuJapWCy3eEY(this, r4));
        b(r4);
    }

    private static final void a(f r1, com.obric.autoaction.app.launcherpage.module.a.a.c r2) {
        boolean r3 = r1.I().c(r2.g());
        aj r4 = r1.f24060a;
        if (r4 != null) goto L5;
        o.c("binding");
        r4 = null;
    L5:
        r4.f22742a.setCollapsed(!r3);
    }

    private static final void a(f r2, com.obric.autoaction.app.launcherpage.module.a.a.c r3, View r4) {
        if (r2.I().c(r3.g()) == false) goto L5;
        r2.I().a(r3.g(), false);
    L6:
        a(r2, r3);
        return;
    L5:
        r2.I().a(r3.g(), true);
        goto L6
    }

    private static final void b(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        a(r0, r1);
    }

    private final void b(final com.obric.autoaction.app.launcherpage.module.a.a.c r8) {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r8.b() == false) goto L5;
        String r4 = r0.getString(ZeusTransformUtils.mapRes(R.string.future_task_delete_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "future_task_delete_all"));
        o.c(r4, "getString(...)");
        final List r2 = d.a.p.a(new h.a(r4, new $$Lambda$f$MKxgD_o76bnEK_9PKsDi9cLZ750(this, r8)));
    L6:
        final m r3 = new $$Lambda$f$DuYrmpVqV3t_XLkURzJ4XibCUug(r8, r0, r2);
        aj r9 = this.f24060a;
        if (r9 != null) goto L9;
        o.c("binding");
        r9 = null;
    L9:
        OUILinearLayout r10 = r9.b();
        o.c(r10, "getRoot(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), new $$Lambda$f$eIoLyoMPl7u835XjygF2ieANvy4(this, r3));
        return;
    L5:
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete"));
        o.c(r5, "getString(...)");
        r2 = d.a.p.a(new h.a(r5, new $$Lambda$f$QJLtcDXAQGBuBM10DPGcaW2nvVg(this, r8)));
        goto L6
    }

    private static final x c(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        r0.J().a(r1.a());
        return x.f38692a;
    }

    private static final x d(f r0, com.obric.autoaction.app.launcherpage.module.a.a.c r1) {
        r0.J().a(r1.a());
        return x.f38692a;
    }

    private static final x a(final com.obric.autoaction.app.launcherpage.module.a.a.c r4, Context r5, List r6, OPopoverEntranceMenuView.a r7, d.h.a.a r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a<x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "<this>");
        o.e(r11, "dismissPopup");
        h.f24077a.b(r7, ZeusTransformUtils.mapRes(R.string.task_copy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy"), new $$Lambda$f$EwsGrMi9KBlOOlUAk0ByKEH9fQc(r11, r9, r4));
        h.f24077a.a(r7, r4.a(), r11);
        h.f24077a.a(r7, new $$Lambda$f$edsqTaGGKuzuxaJNsdmkHJkNBM4(r11, r4, r9, r10));
        return x.f38692a;
    }

    private static final x a(d.h.a.a r6, Context r7, com.obric.autoaction.app.launcherpage.module.a.a.c r8) {
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        r9.invoke();
        h r0 = h.f24077a;
        o.a(r1);
        h.a(r0, r1, r8.c(), null, 4, null);
        return x.f38692a;
    }

    private static final x a(d.h.a.a r3, com.obric.autoaction.app.launcherpage.module.a.a.c r4, Context r5, List r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        List<h.a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        r7.invoke();
        if (r4.b() == false) goto L5;
        h r10 = h.f24077a;
        o.a(r8);
        String r0 = r8.getString(ZeusTransformUtils.mapRes(R.string.future_task_delete_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "future_task_delete_confirm_title"));
        o.c(r0, "getString(...)");
        r10.a(r8, r0, r9);
    L7:
        return x.f38692a;
    L5:
        h r11 = h.f24077a;
        o.a(r8);
        String r1 = r8.getString(ZeusTransformUtils.mapRes(R.string.task_delete_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete_confirm_title"));
        o.c(r1, "getString(...)");
        r11.a(r8, r1, r9);
        goto L7
    }

    private static final boolean a(f r2, m r3, View r4, int[] r5) {
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "<unused var>");
        o.e(r5, "rawPos");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r7, "null cannot be cast to non-null type android.app.Activity");
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin");
        h.f24077a.a(r8, r5, r6);
        return true;
    }
}
