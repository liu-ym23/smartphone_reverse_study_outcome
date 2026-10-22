package com.obric.autoaction.app.launcherpage.module.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ai;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ChargingBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectBluetoothCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectWifiCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeRangeCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.EnterLocationCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ExitLocationCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.LowStorageCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.NoChargeBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ReceiveSmsCondition;
import com.obric.event.task.base.report.p;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AutoActionTaskNormalFutureCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24047a = null;
    private static final DateTimeFormatter w = null;
    private ai s;
    private final d.f t;
    private final d.f u;
    private final d.f v;

    /* JADX INFO: compiled from: AutoActionTaskNormalFutureCell.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class b implements d.f<com.obric.autoaction.app.launcherpage.module.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.c f24051d;

        public b(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24048a = r3;
            this.f24049b = r6;
            this.f24050c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.c b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        public com.obric.autoaction.app.launcherpage.module.c a() {
            com.obric.autoaction.app.launcherpage.module.c r0 = this.f24051d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24048a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24049b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24050c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.c.class);
            this.f24051d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24048a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class c implements d.f<com.obric.autoaction.app.launcherpage.module.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.d f24055d;

        public c(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24052a = r3;
            this.f24053b = r6;
            this.f24054c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.d b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        public com.obric.autoaction.app.launcherpage.module.d a() {
            com.obric.autoaction.app.launcherpage.module.d r0 = this.f24055d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24052a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24053b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24054c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.d.class);
            this.f24055d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24052a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class d implements d.f<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private p f24059d;

        public d(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24056a = r3;
            this.f24057b = r6;
            this.f24058c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        @Override // d.f
        public /* synthetic */ p b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        public p a() {
            p r0 = this.f24059d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24056a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24057b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24058c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(p.class);
            this.f24059d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24056a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    public static /* synthetic */ void lambda$2TNR111yzTdZ7wpcmJPp34eJpwo(e r0, com.obric.autoaction.app.launcherpage.module.a.a.a r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$M10mv2gnsi7cHGL-slSPy2lN9_s, reason: not valid java name */
    public static /* synthetic */ x m543lambda$M10mv2gnsi7cHGLslSPy2lN9_s(com.obric.autoaction.app.launcherpage.module.a.a.a r0, e r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ x lambda$aSqcRxxH4z66UvbXhPYCfZLN58Y(com.obric.autoaction.app.launcherpage.module.a.a.a r0, Context r1, List r2, OPopoverEntranceMenuView.a r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$amTBlGW0pKa4icHYjW_HtCt5JDc(d.h.a.a r0, Context r1, List r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$cs_bGjz0CA4VOmiLMjv__4dh-II, reason: not valid java name */
    public static /* synthetic */ x m544lambda$cs_bGjz0CA4VOmiLMjv__4dhII(d.h.a.a r0, Context r1, com.obric.autoaction.app.launcherpage.module.a.a.a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$huxKiXKjfgrox6Vizf16qlbMVIo(com.obric.autoaction.app.launcherpage.module.a.a.a r0, e r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ x lambda$nMQ__EQnnnaHLtaj913JFEi4MmM(com.obric.autoaction.app.launcherpage.module.a.a.a r0, e r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$u_419GMT-UBP7DUdk_SI_a6gqS8, reason: not valid java name */
    public static /* synthetic */ boolean m545lambda$u_419GMTUBP7DUdk_SI_a6gqS8(e r0, m r1, View r2, int[] r3) {
        return a(r0, r1, r2, r3);
    }

    public e() {
        this.t = (d.f) ZeusTransformUtils.preCheckCast(new b((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.u = (d.f) ZeusTransformUtils.preCheckCast(new c((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.v = (d.f) ZeusTransformUtils.preCheckCast(new d((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.a) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.module.a.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.a.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.module.c I() {
        return (com.obric.autoaction.app.launcherpage.module.c) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.autoaction.app.launcherpage.module.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autoaction.app.launcherpage.module.d J() {
        return (com.obric.autoaction.app.launcherpage.module.d) ZeusTransformUtils.preCheckCast(this.u.b(), com.obric.autoaction.app.launcherpage.module.d.class, "com.obric.aiagent.plugin");
    }

    private final p K() {
        return (p) ZeusTransformUtils.preCheckCast(this.v.b(), p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r8) {
        o.e(r8, "parent");
        ai r0 = ai.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r8, false);
        o.c(r0, "inflate(...)");
        this.s = r0;
        ai r2 = null;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        r0.b().setRadius(d.i.a.a(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())));
        ai r1 = this.s;
        if (r1 != null) goto L8;
        o.c("binding");
        r1 = null;
    L8:
        r1.f22740b.getTextView().setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")));
        ai r9 = this.s;
        if (r9 != null) goto L11;
        o.c("binding");
        r9 = null;
    L11:
        r9.f22740b.getTextView().setTextSize(16.0f);
        ai r7 = this.s;
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

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.a r3) {
        o.e(r3, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
    }

    public void a(final com.obric.autoaction.app.launcherpage.module.a.a.a r5, List<? extends Object> r6) {
        List<? extends Object> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "item");
        o.e(r7, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r7);
        ai r8 = this.s;
        if (r8 != null) goto L5;
        o.c("binding");
        r8 = null;
    L5:
        r8.f22740b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.e(), CharSequence.class, "com.obric.aiagent.plugin"));
        this.f35660b.setOnClickListener(new $$Lambda$e$2TNR111yzTdZ7wpcmJPp34eJpwo(this, r5));
        a(this, r5);
        c(r5);
        b(r5);
        K().a("future_session_module", "pending_execution", String.valueOf(r5.a()), null);
    }

    private static final void a(e r1, com.obric.autoaction.app.launcherpage.module.a.a.a r2) {
        boolean r3 = r1.I().c(r2.g());
        ai r4 = r1.s;
        if (r4 != null) goto L5;
        o.c("binding");
        r4 = null;
    L5:
        r4.f22740b.setCollapsed(!r3);
    }

    private static final void a(e r2, com.obric.autoaction.app.launcherpage.module.a.a.a r3, View r4) {
        if (r2.I().c(r3.g()) == false) goto L5;
        r2.I().a(r3.g(), false);
    L6:
        a(r2, r3);
        return;
    L5:
        r2.I().a(r3.g(), true);
        goto L6
    }

    private final void b(com.obric.autoaction.app.launcherpage.module.a.a.a r12) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        List<g> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r12.c() == null) goto L5;
        String r6 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_status_waiting, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_status_waiting"));
        o.c(r6, "getString(...)");
        r2.add(new g(r6, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.waiting_small, "drawable", "waiting_small")), false, 4, null));
    L11:
        com.obric.autoaction.app.launcherpage.module.datasource.f r13 = r12.b();
        if (r13 == null) goto L17;
        EventTask r14 = r13.a();
        if (r14 == null) goto L17;
        String r15 = r14.getOmniModel();
        if (r15 == null) goto L17;
    L18:
        r2.add(new g(r15, null, false, 6, null));
        g.a r16 = g.f24073a;
        ai r11 = this.s;
        if (r11 != null) goto L21;
        o.c("binding");
        r11 = null;
    L21:
        ConstraintLayout r17 = r11.f22739a;
        o.c(r17, "firstLine");
        r16.a(r17, r2);
        return;
    L17:
        r15 = IOmniModelService.Companion.a().defaultDisplayModel();
        goto L18
    L5:
        com.obric.autoaction.app.launcherpage.module.datasource.f r1 = r12.b();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L9;
        String r7 = w.format((TemporalAccessor) ZeusTransformUtils.preCheckCast(Instant.ofEpochMilli(r12.f()), TemporalAccessor.class, "com.obric.aiagent.plugin"));
        o.c(r7, "format(...)");
        r2.add(new g(r7, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.time_small, "drawable", "time_small")), false, 4, null));
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L11;
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(a((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r12.b(), com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    private final List<g> a(com.obric.autoaction.app.launcherpage.module.datasource.f.a r14) {
        List<g> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.condition.a.a.a(r14.b().getConditions()), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        Object r4 = r16.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r4, AutoCondition.class, "com.obric.aiagent.plugin")).getActive() == false) goto L4;
        r3.add(r4);
        goto L4
    L8:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        AutoCondition r5 = (AutoCondition) ZeusTransformUtils.preCheckCast(d.a.p.l(r17), AutoCondition.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.a.a.a r13 = (com.obric.autoaction.app.launcherpage.module.a.a.a) ZeusTransformUtils.preCheckCast(a(), com.obric.autoaction.app.launcherpage.module.a.a.a.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L12;
        Long.valueOf(r13.f());
    L12:
        if (r5 == null) goto L65;
        String r8 = "";
        if (ZeusTransformUtils.instanceOf(r5, DayTimeCondition.class) == false) goto L17;
        String r2 = ((DayTimeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeCondition.class, "com.obric.aiagent.plugin")).getDayTime();
    L60:
        if (r2 == null) goto L63;
        r8 = r2;
    L63:
        r0.add(new g(r8, Integer.valueOf(r5.getGroupInfo().getIcon()), true));
        goto L65
    L17:
        if (ZeusTransformUtils.instanceOf(r5, DayTimeRangeCondition.class) == false) goto L20;
        r2 = ((DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeRangeCondition.class, "com.obric.aiagent.plugin")).getStartTime() + '-' + ((DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r5, DayTimeRangeCondition.class, "com.obric.aiagent.plugin")).getEndTime();
        goto L60
    L20:
        if (ZeusTransformUtils.instanceOf(r5, EnterLocationCondition.class) == false) goto L26;
        int r7 = ZeusTransformUtils.mapRes(R.string.task_first_line_enter_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_enter_location");
        Object[] r9 = new Object[1];
        String r6 = ((EnterLocationCondition) ZeusTransformUtils.preCheckCast(r5, EnterLocationCondition.class, "com.obric.aiagent.plugin")).getGeofenceName();
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        r9[0] = r6;
        r2 = r1.getString(r7, r9);
        goto L60
    L26:
        if (ZeusTransformUtils.instanceOf(r5, ExitLocationCondition.class) == false) goto L31;
        int r10 = ZeusTransformUtils.mapRes(R.string.task_first_line_exit_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_exit_location");
        Object[] r11 = new Object[1];
        String r12 = ((ExitLocationCondition) ZeusTransformUtils.preCheckCast(r5, ExitLocationCondition.class, "com.obric.aiagent.plugin")).getGeofenceName();
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        r11[0] = r12;
        r2 = r1.getString(r10, r11);
        goto L60
    L31:
        String r18 = null;
        if (ZeusTransformUtils.instanceOf(r5, ChargingBatteryCondition.class) == false) goto L38;
        StringBuilder r19 = new StringBuilder().append(r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_charging_to, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_charging_to")));
        Integer r20 = ((ChargingBatteryCondition) ZeusTransformUtils.preCheckCast(r5, ChargingBatteryCondition.class, "com.obric.aiagent.plugin")).getPercent();
        if (r20 == null) goto L36;
        r18 = r20.toString();
    L36:
        r2 = r19.append(r18).toString();
        goto L60
    L38:
        if (ZeusTransformUtils.instanceOf(r5, NoChargeBatteryCondition.class) == false) goto L44;
        StringBuilder r21 = new StringBuilder().append(r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_consume_to, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_consume_to")));
        Integer r22 = ((NoChargeBatteryCondition) ZeusTransformUtils.preCheckCast(r5, NoChargeBatteryCondition.class, "com.obric.aiagent.plugin")).getPercent();
        if (r22 == null) goto L42;
        r18 = r22.toString();
    L42:
        r2 = r21.append(r18).toString();
        goto L60
    L44:
        if (ZeusTransformUtils.instanceOf(r5, ConnectBluetoothCondition.class) == false) goto L47;
        r2 = r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_bluetooth_connect, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_bluetooth_connect")) + ((ConnectBluetoothCondition) ZeusTransformUtils.preCheckCast(r5, ConnectBluetoothCondition.class, "com.obric.aiagent.plugin")).getName();
        goto L60
    L47:
        if (ZeusTransformUtils.instanceOf(r5, ConnectWifiCondition.class) == false) goto L50;
        r2 = r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_wifi_connect, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_wifi_connect")) + ((ConnectWifiCondition) ZeusTransformUtils.preCheckCast(r5, ConnectWifiCondition.class, "com.obric.aiagent.plugin")).getSsid();
        goto L60
    L50:
        if (ZeusTransformUtils.instanceOf(r5, LowStorageCondition.class) == false) goto L53;
        r2 = r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_low_storage, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_low_storage")) + ((LowStorageCondition) ZeusTransformUtils.preCheckCast(r5, LowStorageCondition.class, "com.obric.aiagent.plugin")).getPercent() + '%';
        goto L60
    L53:
        if (ZeusTransformUtils.instanceOf(r5, ReceiveSmsCondition.class) == false) goto L58;
        int r23 = ZeusTransformUtils.mapRes(R.string.task_first_line_sms_template, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_sms_template");
        Object[] r24 = new Object[1];
        String r25 = (String) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a().get(((ReceiveSmsCondition) ZeusTransformUtils.preCheckCast(r5, ReceiveSmsCondition.class, "com.obric.aiagent.plugin")).getCategoryType()), String.class, "com.obric.aiagent.plugin");
        if (r25 != null) goto L57;
        r25 = r1.getString(ZeusTransformUtils.mapRes(R.string.sms_category_otp_code, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sms_category_otp_code"));
        o.c(r25, "getString(...)");
    L57:
        r24[0] = r25;
        r2 = r1.getString(r23, r24);
        goto L60
    L58:
        r2 = "";
    L65:
        if (r17.size() <= 1) goto L67;
        String r26 = r1.getString(ZeusTransformUtils.mapRes(R.string.task_first_line_other_condition_count, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_first_line_other_condition_count"), new Object[]{Integer.valueOf(r17.size() - 1)});
        o.c(r26, "getString(...)");
        r0.add(new g(r26, null, false, 6, null));
    L67:
        return r0;
    }

    private final void c(final com.obric.autoaction.app.launcherpage.module.a.a.a r13) {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = new $$Lambda$e$nMQ__EQnnnaHLtaj913JFEi4MmM(r13, this);
        d.h.a.a r3 = new $$Lambda$e$M10mv2gnsi7cHGLslSPy2lN9_s(r13, this);
        d.h.a.a r4 = new $$Lambda$e$huxKiXKjfgrox6Vizf16qlbMVIo(r13, this);
        if (r13.d() == true) goto L5;
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete"));
        o.c(r5, "getString(...)");
        final List r6 = d.a.p.a(new h.a(r5, r4));
    L9:
        final m r7 = new $$Lambda$e$aSqcRxxH4z66UvbXhPYCfZLN58Y(r13, r0, r6);
        ai r14 = this.s;
        if (r14 != null) goto L12;
        o.c("binding");
        r14 = null;
    L12:
        OUILinearLayout r15 = r14.b();
        o.c(r15, "getRoot(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"), new $$Lambda$e$u_419GMTUBP7DUdk_SI_a6gqS8(this, r7));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r13.b(), com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L7;
        String r10 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_delete_one_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete_one_task"));
        o.c(r10, "getString(...)");
        String r8 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_delete_all_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete_all_task"));
        o.c(r8, "getString(...)");
        r6 = d.a.p.b(new h.a[]{new h.a(r10, r2), new h.a(r8, r3)});
        goto L9
    L7:
        String r9 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_delete_all_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete_all_task"));
        o.c(r9, "getString(...)");
        r6 = d.a.p.a(new h.a(r9, r3));
        goto L9
    }

    private static final x a(com.obric.autoaction.app.launcherpage.module.a.a.a r3, e r4) {
        if (r3.c() == null) goto L6;
        r4.J().d(r3.c());
    L9:
        return x.f38692a;
    L6:
        if (r3.a() == null) goto L9;
        r4.J().a(r3.a(), r3.f());
        goto L9
    }

    private static final x b(com.obric.autoaction.app.launcherpage.module.a.a.a r1, e r2) {
        if (r1.a() == null) goto L6;
        r2.J().a(r1.a());
    L6:
        return x.f38692a;
    }

    private static final x c(com.obric.autoaction.app.launcherpage.module.a.a.a r2, e r3) {
        if (r2.a() == null) goto L6;
        r3.J().a(r2.a());
    L6:
        if (r2.c() == null) goto L9;
        r3.J().d(r2.c());
    L9:
        return x.f38692a;
    }

    private static final x a(final com.obric.autoaction.app.launcherpage.module.a.a.a r4, Context r5, List r6, OPopoverEntranceMenuView.a r7, d.h.a.a r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a<x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "<this>");
        o.e(r11, "dismissPopup");
        h.f24077a.b(r7, ZeusTransformUtils.mapRes(R.string.task_copy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy"), new $$Lambda$e$cs_bGjz0CA4VOmiLMjv__4dhII(r11, r9, r4));
        if (r4.a() != null) goto L5;
    L7:
        h.f24077a.a(r7, new $$Lambda$e$amTBlGW0pKa4icHYjW_HtCt5JDc(r11, r9, r10));
        return x.f38692a;
    L5:
        if (r4.c() != null) goto L7;
        h.f24077a.a(r7, r4.a(), r11);
        goto L7
    }

    private static final x a(d.h.a.a r6, Context r7, com.obric.autoaction.app.launcherpage.module.a.a.a r8) {
        d.h.a.a r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        r9.invoke();
        h r0 = h.f24077a;
        o.a(r1);
        h.a(r0, r1, r8.e(), null, 4, null);
        return x.f38692a;
    }

    private static final x a(d.h.a.a r3, Context r4, List r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        List<h.a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        r6.invoke();
        h r9 = h.f24077a;
        o.a(r7);
        String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.task_delete_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete_confirm_title"));
        o.c(r0, "getString(...)");
        r9.a(r7, r0, r8);
        return x.f38692a;
    }

    private static final boolean a(e r2, m r3, View r4, int[] r5) {
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "<unused var>");
        o.e(r5, "rawPos");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r7, "null cannot be cast to non-null type android.app.Activity");
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin");
        h.f24077a.a(r8, r5, r6);
        return true;
    }

    static {
        f24047a = new a(null);
        w = DateTimeFormatter.ofPattern("HH:mm").withZone(ZoneId.systemDefault());
    }
}
