package com.obric.autoaction.app.launcherpage.module.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.history.historydetail.HistoryDetailActivity;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskListItemTaskView;
import com.obric.event.task.base.report.p;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AutoActionTaskHistoryCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24033a = null;
    private final d.f s;
    private final d.f t;
    private final d.f u;

    /* JADX INFO: compiled from: AutoActionTaskHistoryCell.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionTaskHistoryCell.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24034a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.app.launcherpage.module.a.a.h.a.values().length];
            r0[com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24021c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24022d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24023e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f24034a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class C0543c implements d.f<com.obric.autoaction.app.launcherpage.module.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.c f24038d;

        public C0543c(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24035a = r3;
            this.f24036b = r6;
            this.f24037c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.c b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.c] */
        public com.obric.autoaction.app.launcherpage.module.c a() {
            com.obric.autoaction.app.launcherpage.module.c r0 = this.f24038d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24035a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24036b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24037c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.c.class);
            this.f24038d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24035a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class d implements d.f<com.obric.autoaction.app.launcherpage.module.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.d f24042d;

        public d(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24039a = r3;
            this.f24040b = r6;
            this.f24041c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.d b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        public com.obric.autoaction.app.launcherpage.module.d a() {
            com.obric.autoaction.app.launcherpage.module.d r0 = this.f24042d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24039a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24040b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24041c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.d.class);
            this.f24042d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24039a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class e implements d.f<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f24043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private p f24046d;

        public e(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24043a = r3;
            this.f24044b = r6;
            this.f24045c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        @Override // d.f
        public /* synthetic */ p b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        public p a() {
            p r0 = this.f24046d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24043a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24044b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24045c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(p.class);
            this.f24046d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24043a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    static {
        f24033a = new a(null);
    }

    public static /* synthetic */ x lambda$ALsS_PDrGhhMJbYgUT5cAovYeik(d.h.a.a r0, Context r1, com.obric.autoaction.app.launcherpage.module.a.a.h r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$KAWPYL5H2qMYNoES_cQqqkTviLg(c r0, com.obric.autoaction.app.launcherpage.module.a.a.h r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$RZNCzvJ7eU8d8fCn3u-bC6GHyoE, reason: not valid java name */
    public static /* synthetic */ x m540lambda$RZNCzvJ7eU8d8fCn3ubC6GHyoE(d.h.a.a r0, Context r1, com.obric.autoaction.app.launcherpage.module.a.a.h r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$TaE1nVlMRkrVvR65Lt7dEWxSjX4(Context r0, String r1, com.obric.autoaction.app.launcherpage.module.a.a.h r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$VKrBVjDVxy2byTGQ5MJMi0sx_Sg(com.obric.autoaction.app.launcherpage.module.a.a.h r0, c r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$bRS-r2evwgtxcOIHO3ohL393hgo, reason: not valid java name */
    public static /* synthetic */ x m541lambda$bRSr2evwgtxcOIHO3ohL393hgo(boolean r0, com.obric.autoaction.app.launcherpage.module.a.a.h r1, Context r2, List r3, OPopoverEntranceMenuView.a r4, d.h.a.a r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$dpJZL4C0960P-czWm6g8QD9SaJI, reason: not valid java name */
    public static /* synthetic */ x m542lambda$dpJZL4C0960PczWm6g8QD9SaJI(d.h.a.a r0, Context r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$hUc4aHg04FAY1pNe9gkYrZtpx3k(d.h.a.a r0, Context r1, com.obric.autoaction.app.launcherpage.module.a.a.h r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$oN4E8CIjVqd77xaLSUN6XUFfhVQ(c r0, m r1, View r2, int[] r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$y_nmfgFWx4MTfELTcIEWODYq8QI(com.obric.autoaction.app.launcherpage.module.a.a.h r0, c r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ x lambda$ycXfheXYmIQM3CySfh5H9V_Y27o(com.obric.autoaction.app.launcherpage.module.a.a.h r0, c r1) {
        return b(r0, r1);
    }

    public c() {
        this.s = (d.f) ZeusTransformUtils.preCheckCast(new C0543c((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.t = (d.f) ZeusTransformUtils.preCheckCast(new d((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.u = (d.f) ZeusTransformUtils.preCheckCast(new e((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.h) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.h.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.module.a.a.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.h.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.module.d I() {
        return (com.obric.autoaction.app.launcherpage.module.d) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.autoaction.app.launcherpage.module.d.class, "com.obric.aiagent.plugin");
    }

    private final p J() {
        return (p) ZeusTransformUtils.preCheckCast(this.u.b(), p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r8) {
        o.e(r8, "parent");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "getContext(...)");
        return (View) ZeusTransformUtils.preCheckCast(new AutoActionTaskListItemTaskView(r1, null, 0, 6, null), View.class, "com.obric.aiagent.plugin");
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.h r3) {
        o.e(r3, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
    }

    public void a(final com.obric.autoaction.app.launcherpage.module.a.a.h r5, List<? extends Object> r6) {
        List<? extends Object> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "item");
        o.e(r7, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r7);
        View r8 = this.f35660b;
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r8, AutoActionTaskListItemTaskView.class) == false) goto L5;
        AutoActionTaskListItemTaskView r9 = (AutoActionTaskListItemTaskView) ZeusTransformUtils.preCheckCast(r8, AutoActionTaskListItemTaskView.class, "com.obric.aiagent.plugin");
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.module.a.a.h> r0 = b();
        if (r0 == null) goto L16;
        com.obric.autoaction.app.launcherpage.ui.g r1 = r0.b();
        if (r1 == null) goto L16;
        com.obric.autoaction.app.launcherpage.ui.c r3 = r1.a().get(i.class);
        if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L15;
        r3 = null;
    L15:
        i r4 = (i) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin"), i.class, "com.obric.aiagent.plugin");
    L17:
        r9.fitData(r5, r4);
        b(r9, r5);
        a(r9, r5);
        this.f35660b.setOnClickListener(new $$Lambda$c$KAWPYL5H2qMYNoES_cQqqkTviLg(this, r5));
        b(r5);
        p r10 = J();
        int r11 = b.f24034a[r5.j().ordinal()];
        if (r11 != 1) goto L20;
        String r12 = "completed";
    L27:
        String r13 = r5.a();
        if (r13 == null) goto L30;
        r2 = r13.toString();
    L30:
        r10.a("history_sesssion_module", r12, r2, r5.h());
        return;
    L20:
        if (r11 != 2) goto L22;
        r12 = "failed";
        goto L27
    L22:
        if (r11 == 3) goto L24;
        r12 = SensitiveType.UNKNOWN;
        goto L27
    L24:
        r12 = "user_term";
    L16:
        r4 = null;
        goto L17
    L5:
        r9 = null;
        goto L6
    }

    private static final void a(c r2, com.obric.autoaction.app.launcherpage.module.a.a.h r3, View r4) {
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "getContext(...)");
        r2.a(r5, r3);
    }

    private final void a(Context r5, com.obric.autoaction.app.launcherpage.module.a.a.h r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.s(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L17;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.r(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == true) goto L17;
        Intent r10 = new Intent();
        r10.setClassName("com.larus.nova", "com.obric.assistant.omnidetailpage.OmniDetailActivity");
        r10.putExtra("message_id", r6.s());
        r10.putExtra("resource_id", r6.r());
        ZeusTransformUtils.startActivity(r4, r10, "com.obric.aiagent.plugin");
        return;
    L13:
        if (r9.length() != 0) goto L15;
    L17:
        com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r4);
        HistoryDetailActivity.a r11 = HistoryDetailActivity.Companion;
        long r0 = r6.b();
        String r12 = r6.h();
        if (r12 != null) goto L20;
        r12 = "";
    L20:
        r11.a(r4, r0, r12);
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(AutoActionTaskListItemTaskView r8, com.obric.autoaction.app.launcherpage.module.a.a.h r9) {
        com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.module.a.a.h> r7 = b();
        i r0 = null;
        com.obric.autoaction.app.launcherpage.ui.c r1 = null;
        r0 = null;
        if (r7 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.g r10 = r7.b();
        if (r10 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.c r11 = r10.a().get(i.class);
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L10;
        r1 = r11;
    L10:
        r0 = (i) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin"), i.class, "com.obric.aiagent.plugin");
    L11:
        r8.getTitle().setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.k(), CharSequence.class, "com.obric.aiagent.plugin"));
        r8.getContent().setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.m(), CharSequence.class, "com.obric.aiagent.plugin"));
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.m(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        int r3 = 0;
        if (r12 != null) goto L14;
    L17:
        Object[] r13 = true;
    L19:
        if (r13 == false) goto L29;
        r8.getContent().setVisibility(8);
        if (r9.j() != com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24022d) goto L30;
        if (r0 != null) goto L24;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L30;
        r8.getContent().setVisibility(0);
        r8.getContent().setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_execution_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_execution_failed")), CharSequence.class, "com.obric.aiagent.plugin"));
        goto L30
    L24:
        if (r0.a() == true) goto L26;
    L30:
        if (r0 == null) goto L37;
        View r14 = (View) ZeusTransformUtils.preCheckCast(r8.getTitle(), View.class, "com.obric.aiagent.plugin");
        if (r0.a() == true) goto L35;
        r3 = 8;
    L35:
        r14.setVisibility(r3);
        return;
    L37:
        return;
    L29:
        r8.getContent().setVisibility(0);
        goto L30
    L14:
        if (d.o.o.d(r12) == true) goto L17;
        r13 = false;
        goto L19
    }

    private static final String a(c r8, long r9) {
        long r10 = r9 / ((long) 1000);
        long r0 = 60;
        long r2 = r10 / r0;
        long r11 = r10 % r0;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 != 0) goto L6;
        String r13 = r12.getString(ZeusTransformUtils.mapRes(R.string.tli_duration_sec, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_duration_sec"), new Object[]{Long.valueOf(r11)});
        o.a(r13);
        return r13;
    L6:
        if (r11 != 0) goto L8;
        String r14 = r12.getString(ZeusTransformUtils.mapRes(R.string.tli_duration_min, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_duration_min"), new Object[]{Long.valueOf(r2)});
        o.a(r14);
        return r14;
    L8:
        String r15 = r12.getString(ZeusTransformUtils.mapRes(R.string.tli_duration_min_sec, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_duration_min_sec"), new Object[]{Long.valueOf(r2), Long.valueOf(r11)});
        o.a(r15);
        return r15;
    }

    private final void b(AutoActionTaskListItemTaskView r24, com.obric.autoaction.app.launcherpage.module.a.a.h r25) {
        List<g> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r25.j().a());
        o.c(r5, "getString(...)");
        r1.add(new g(r5, Integer.valueOf(r25.j().b()), false, 4, null));
        if (com.obric.autogui.common.b.a.f29000a.a(r25.e(), 2) != true) goto L6;
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_cell_test_run_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_cell_test_run_text"));
        o.c(r12, "getString(...)");
        r1.add(new g(r12, null, false, 6, null));
    L12:
        r1.add(new g(r25.q(), null, false, 6, null));
        if (r25.l() <= 0) goto L15;
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.tli_duration, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_duration"), new Object[]{a(this, r25.l())});
        o.c(r13, "getString(...)");
        r1.add(new g(r13, null, false, 6, null));
    L15:
        ConstraintLayout r0 = r24.getMFirstLine();
        if (r0 == null) goto L19;
        g.f24073a.a(r0, r1);
        return;
    L19:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r25.d(), com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L8;
    L11:
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_cell_auto_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_cell_auto_task"));
        o.c(r6, "getString(...)");
        r1.add(new g(r6, null, false, 6, null));
        goto L12
    L8:
        if (ZeusTransformUtils.instanceOf(r25.d(), com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == true) goto L11;
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_cell_single_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_cell_single_task"));
        o.c(r14, "getString(...)");
        r1.add(new g(r14, null, false, 6, null));
        goto L12
    }

    private final void b(final com.obric.autoaction.app.launcherpage.module.a.a.h r13) {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r2 = new $$Lambda$c$VKrBVjDVxy2byTGQ5MJMi0sx_Sg(r13, this);
        d.h.a.a r3 = new $$Lambda$c$ycXfheXYmIQM3CySfh5H9V_Y27o(r13, this);
        d.h.a.a r4 = new $$Lambda$c$y_nmfgFWx4MTfELTcIEWODYq8QI(r13, this);
        final boolean r6 = true;
        if (r13.o() == false) goto L5;
        String r10 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_records_delete_one, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_records_delete_one"));
        o.c(r10, "getString(...)");
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.string.task_records_delete_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_records_delete_all"));
        o.c(r5, "getString(...)");
        final List r7 = d.a.p.b(new h.a[]{new h.a(r10, r2), new h.a(r5, r3)});
    L6:
        com.obric.autoaction.app.launcherpage.ui.d<com.obric.autoaction.app.launcherpage.module.a.a.h> r8 = b();
        if (r8 == null) goto L16;
        com.obric.autoaction.app.launcherpage.ui.g r9 = r8.b();
        if (r9 == null) goto L16;
        com.obric.autoaction.app.launcherpage.ui.c r11 = r9.a().get(i.class);
        if (ZeusTransformUtils.instanceOf(r11, i.class) == true) goto L13;
        r11 = null;
    L13:
        i r1 = (i) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin"), i.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L16;
        r6 = r1.a();
    L16:
        final m r12 = new $$Lambda$c$bRSr2evwgtxcOIHO3ohL393hgo(r6, r13, r0, r7);
        View r14 = this.f35660b;
        o.c(r14, "itemView");
        com.obric.autoaction.app.launcherpage.utils.p.a(r14, new $$Lambda$c$oN4E8CIjVqd77xaLSUN6XUFfhVQ(this, r12));
        return;
    L5:
        String r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_delete"));
        o.c(r15, "getString(...)");
        r7 = d.a.p.a(new h.a(r15, r4));
        goto L6
    }

    private static final x a(com.obric.autoaction.app.launcherpage.module.a.a.h r4, c r5) {
        if (r4.b() == (-1)) goto L6;
        r5.I().a(r4.b());
    L6:
        if (r4.c() == null) goto L14;
        com.obric.autoaction.app.launcherpage.module.datasource.f r0 = r4.d();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L11;
        r5.I().b(d.a.p.a(r4.c()));
        goto L14
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L14;
        r5.I().a(d.a.p.a(Integer.valueOf((int) r4.c().longValue())));
    L14:
        return x.f38692a;
    }

    private static final x b(com.obric.autoaction.app.launcherpage.module.a.a.h r0, c r1) {
        String r2 = r0.a();
        if (r2 == null) goto L5;
        r1.I().c(r2);
        return x.f38692a;
    L5:
        return null;
    }

    private static final x c(com.obric.autoaction.app.launcherpage.module.a.a.h r4, c r5) {
        if (r4.b() == (-1)) goto L5;
        r5.I().a(r4.b());
    L5:
        String r6 = r4.a();
        if (r6 == null) goto L8;
        r5.I().a(r6);
        return x.f38692a;
    L8:
        return null;
    }

    private static final x a(boolean r19, final com.obric.autoaction.app.launcherpage.module.a.a.h r20, Context r21, List r22, OPopoverEntranceMenuView.a r23, d.h.a.a r24) {
        final Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        final List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r23, "<this>");
        o.e(r15, "dismissPopup");
        if (r19 == false) goto L5;
        h.f24077a.b(r23, ZeusTransformUtils.mapRes(R.string.task_copy_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy_title"), new $$Lambda$c$hUc4aHg04FAY1pNe9gkYrZtpx3k(r15, r13, r20));
    L5:
        h.f24077a.b(r23, ZeusTransformUtils.mapRes(R.string.task_copy_result, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy_result"), new $$Lambda$c$RZNCzvJ7eU8d8fCn3ubC6GHyoE(r15, r13, r20));
        if (r20.d() != null) goto L8;
        String r1 = r13.getString(ZeusTransformUtils.mapRes(R.string.historly_cell_add_to_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "historly_cell_add_to_shortcut"));
        OPopoverEntranceMenuView.a.a(r23, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.obric_add_task_star, "drawable", "obric_add_task_star")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$c$ALsS_PDrGhhMJbYgUT5cAovYeik(r15, r13, r20), 246, null);
    L20:
        h.f24077a.a(r23, new $$Lambda$c$dpJZL4C0960PczWm6g8QD9SaJI(r15, r13, r14));
        return x.f38692a;
    L8:
        com.obric.autoaction.app.launcherpage.module.datasource.f r3 = r20.d();
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L11;
    L18:
        final String r4 = IMainTab.Companion.b();
    L19:
        String r2 = r13.getString(ZeusTransformUtils.mapRes(R.string.history_cell_check_shortcut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_cell_check_shortcut"));
        OPopoverEntranceMenuView.a.a(r23, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.o_ic_list_find, "drawable", "o_ic_list_find")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$c$TaE1nVlMRkrVvR65Lt7dEWxSjX4(r13, r4, r20), 246, null);
        goto L20
    L11:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L17;
        r4 = IMainTab.Companion.a();
        goto L19
    L17:
        throw new k();
    }

    private static final x a(d.h.a.a r3, Context r4, com.obric.autoaction.app.launcherpage.module.a.a.h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        r6.invoke();
        h r8 = h.f24077a;
        o.a(r7);
        r8.a(r7, r5.k(), r7.getString(ZeusTransformUtils.mapRes(R.string.task_title_copy_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_title_copy_success")));
        return x.f38692a;
    }

    private static final x b(d.h.a.a r3, Context r4, com.obric.autoaction.app.launcherpage.module.a.a.h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        r6.invoke();
        h r8 = h.f24077a;
        o.a(r7);
        String r9 = r5.m();
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        r8.a(r7, r9, r7.getString(ZeusTransformUtils.mapRes(R.string.task_content_copy_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_content_copy_success")));
        return x.f38692a;
    }

    private static final x a(d.h.a.a r9, Context r10, com.obric.autoaction.app.launcherpage.module.a.a.h r11, View r12, int r13) {
        d.h.a.a r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "v");
        r14.invoke();
        com.obric.autoaction.app.launcherpage.detail.shortcut.a r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
        o.a(r15, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r1, (FragmentActivity) ZeusTransformUtils.preCheckCast(r15, FragmentActivity.class, "com.obric.aiagent.plugin"), "enter_from_history", (EventTask) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a(r11.k(), r11.p()), EventTask.class, "com.obric.aiagent.plugin"), null, false, 24, null);
        return x.f38692a;
    }

    private static final x a(Context r1, String r2, com.obric.autoaction.app.launcherpage.module.a.a.h r3, View r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "v");
        com.obric.autoaction.app.launcherpage.a r7 = com.obric.autoaction.app.launcherpage.a.f22698a;
        o.a(r6, "null cannot be cast to non-null type android.app.Activity");
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
        Bundle r9 = new Bundle();
        r9.putString("key_task_id", r3.a());
        x r10 = x.f38692a;
        r7.a(r8, r2, r9);
        return x.f38692a;
    }

    private static final x a(d.h.a.a r3, Context r4, List r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        List<h.a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        r6.invoke();
        h r9 = h.f24077a;
        o.a(r7);
        String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.task_records_delete_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_records_delete_confirm_title"));
        o.c(r0, "getString(...)");
        r9.a(r7, r0, r8);
        return x.f38692a;
    }

    private static final boolean a(c r2, m r3, View r4, int[] r5) {
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
