package com.obric.autoaction.app.launcherpage.module.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ah;
import com.obric.autoaction.app.launcherpage.utils.k;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AutoActionEventTaskManagementCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.app.launcherpage.ui.f<com.obric.autoaction.app.launcherpage.module.a.a.b> implements com.obric.autoaction.app.launcherpage.ui.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f23977a;
    private final d.f s;
    private final d.f t;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoActionEventTaskManagementCell.kt */
    @d.c.b.a.f(b = "AutoActionEventTaskManagementCell.kt", c = {92}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.cell.AutoActionEventTaskManagementCell$onBindItemView$1$1")
    static final class C0542a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f23978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f23982e;
        final /* synthetic */ a f;
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.a.a.b g;

        C0542a(View r3, a r4, com.obric.autoaction.app.launcherpage.module.a.a.b r5, d.c.d<? super C0542a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23982e = r3;
            this.f = r4;
            this.g = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0542a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0542a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0542a(this.f23982e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23981d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.f23980c;
            long r4 = this.f23978a;
            OSwitch r3 = (OSwitch) ZeusTransformUtils.preCheckCast(this.f23979b, OSwitch.class, "com.obric.aiagent.plugin");
            o.a(r8);
        L13:
            if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() >= r2) goto L15;
        L18:
            a.a(this.f).e(this.g.a());
            com.obric.event.task.base.report.b.f32757a.a(!r3.isChecked(), d.c.b.a.b.a(System.currentTimeMillis() - r4));
            return x.f38692a;
        L15:
            if (r3.isChecked() == true) goto L18;
            AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.condition_event_limit_max_number_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_limit_max_number_toast"), new Object[]{String.valueOf(r2)}), CharSequence.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            r4 = System.currentTimeMillis();
            View r9 = this.f23982e;
            d.h.b.o.a(r9, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
            r3 = (OSwitch) ZeusTransformUtils.preCheckCast(r9, OSwitch.class, "com.obric.aiagent.plugin");
            int r10 = com.obric.autoaction.app.launcherpage.detail.condition.b.a();
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23979b = r3;
            this.f23978a = r4;
            this.f23980c = r10;
            this.f23981d = 1;
            Object r7 = com.obric.autoaction.app.launcherpage.detail.condition.b.a(r6);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r10;
            r8 = r7;
            goto L13
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class b implements d.f<com.obric.autoaction.app.launcherpage.module.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f23983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.module.d f23986d;

        public b(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f23983a = r3;
            this.f23984b = r6;
            this.f23985c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.module.d b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.module.d] */
        public com.obric.autoaction.app.launcherpage.module.d a() {
            com.obric.autoaction.app.launcherpage.module.d r0 = this.f23986d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23983a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            d.h.b.o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f23984b;
            if (r4 == null) goto L10;
            androidx.lifecycle.am.b r5 = (androidx.lifecycle.am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), androidx.lifecycle.am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f23985c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new androidx.lifecycle.am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.module.d.class);
            this.f23986d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23983a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class c implements d.f<com.obric.event.task.base.report.p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.ui.f f23987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f23989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.event.task.base.report.p f23990d;

        public c(com.obric.autoaction.app.launcherpage.ui.f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f23987a = r3;
            this.f23988b = r6;
            this.f23989c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        @Override // d.f
        public /* synthetic */ com.obric.event.task.base.report.p b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.event.task.base.report.p] */
        public com.obric.event.task.base.report.p a() {
            com.obric.event.task.base.report.p r0 = this.f23990d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23987a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            d.h.b.o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f23988b;
            if (r4 == null) goto L10;
            androidx.lifecycle.am.b r5 = (androidx.lifecycle.am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), androidx.lifecycle.am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f23989c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new androidx.lifecycle.am(r3, r5, r7).a(com.obric.event.task.base.report.p.class);
            this.f23990d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            d.h.b.o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            d.h.b.o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23987a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    public static /* synthetic */ void lambda$2Lb6pi8BvaKu5KKtNRjhRC5Y1KY(com.obric.autoaction.app.launcherpage.module.a.a.b r0, a r1, DialogInterface r2, int r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean lambda$PSSrgXIoeMbUgkeHcg0jC9Vf7S0(a r0, View r1, int[] r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$TXgp97Ppqp8aQ938yS59fuxAzWY(z.f r0, a r1, OPopoverEntranceMenuView.a r2, d.h.a.a r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$TsnX9_wN9XATSNShuLtBbU5KbXA(a r0, com.obric.autoaction.app.launcherpage.module.a.a.b r1, View r2) {
        b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$o0LkHA5-Lt7dKjRIsY0acvxRJIg, reason: not valid java name */
    public static /* synthetic */ void m538lambda$o0LkHA5Lt7dKjRIsY0acvxRJIg(a r0, com.obric.autoaction.app.launcherpage.module.a.a.b r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$q-lLrytaib0umZJ61dc3fhjwv94, reason: not valid java name */
    public static /* synthetic */ x m539lambda$qlLrytaib0umZJ61dc3fhjwv94(d.h.a.a r0, OPopoverEntranceMenuView.a r1, com.obric.autoaction.app.launcherpage.module.a.a.b r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$xHzFKLSODrjVC7s3A7tTSSBYn1w(d.h.a.a r0, a r1, com.obric.autoaction.app.launcherpage.module.a.a.b r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$zAxH4pIEw0ISSEmLSY51DIUXu_g(z.f r0) {
        return a(r0);
    }

    public a() {
        this.s = (d.f) ZeusTransformUtils.preCheckCast(new b((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
        this.t = (d.f) ZeusTransformUtils.preCheckCast(new c((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(this, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.d a(a r0) {
        return r0.I();
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.module.d I() {
        return (com.obric.autoaction.app.launcherpage.module.d) ZeusTransformUtils.preCheckCast(this.s.b(), com.obric.autoaction.app.launcherpage.module.d.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.event.task.base.report.p J() {
        return (com.obric.event.task.base.report.p) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.event.task.base.report.p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r8) {
        d.h.b.o.e(r8, "parent");
        ah r0 = ah.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r8, false);
        d.h.b.o.c(r0, "inflate(...)");
        this.f23977a = r0;
        ah r3 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.b().setChangeAlphaWhenPress(false);
        ah r1 = this.f23977a;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        r1.g.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")));
        ah r7 = this.f23977a;
        if (r7 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        OUICardConstraintLayout r9 = r3.b();
        d.h.b.o.c(r9, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin");
    L11:
        r3 = r7;
        goto L12
    }

    public void a(com.obric.autoaction.app.launcherpage.module.a.a.b r5, List<? extends Object> r6) {
        List<? extends Object> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "item");
        d.h.b.o.e(r7, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r7);
        c(r5);
        d(r5);
        b(r5);
        k r8 = k.f24509a;
        ah r0 = this.f23977a;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        ImageView r1 = r0.f22738e;
        d.h.b.o.c(r1, "semanticIcon");
        com.obric.autoaction.app.launcherpage.module.datasource.f r2 = r5.b();
        if (r2 == null) goto L10;
        EventTask r3 = r2.a();
        if (r3 == null) goto L10;
        Map<String, String> r4 = r3.getExt();
    L12:
        if (r5.h() != 0) goto L14;
        boolean r9 = true;
    L15:
        r8.a(r1, r4, r9);
        com.obric.autoaction.app.launcherpage.module.view.a r10 = com.obric.autoaction.app.launcherpage.module.view.a.f24286a;
        String r11 = r5.g();
        View r12 = this.f35660b;
        d.h.b.o.c(r12, "itemView");
        r10.a(r11, r12);
        J().a("repeat_manage_session_modules", null, r5.a().toString(), null);
        return;
    L14:
        r9 = false;
    L10:
        r4 = null;
        goto L12
    }

    public void a(final com.obric.autoaction.app.launcherpage.module.a.a.b r5) {
        d.h.b.o.e(r5, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
        ah r0 = this.f23977a;
        ah r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22734a.setAutoCheck(false);
        ah r2 = this.f23977a;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22734a.setOnClickListener(new $$Lambda$a$o0LkHA5Lt7dKjRIsY0acvxRJIg(this, r5));
        K();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void a(a r8, com.obric.autoaction.app.launcherpage.module.a.a.b r9, View r10) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast((AppCompatActivity) ZeusTransformUtils.preCheckCast(r0, AppCompatActivity.class, "com.obric.aiagent.plugin"), androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0542a(r10, r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void b(com.obric.autoaction.app.launcherpage.module.a.a.b r7) {
        ah r0 = this.f23977a;
        ah r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.i(), CharSequence.class, "com.obric.aiagent.plugin"));
        String r8 = r7.i();
        boolean r2 = true;
        if (r8 != null) goto L8;
    L13:
        r2 = false;
    L14:
        if (r2 == false) goto L23;
        ah r9 = this.f23977a;
        if (r9 != null) goto L18;
        d.h.b.o.c("binding");
        r9 = null;
    L18:
        OTextView r10 = r9.f;
        d.h.b.o.c(r10, "tag");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        ah r6 = this.f23977a;
        if (r6 != null) goto L21;
        d.h.b.o.c("binding");
    L22:
        View r11 = r1.f22736c;
        d.h.b.o.c(r11, "conditionDivider");
        com.obric.oui.common.util.k.a(r11);
        return;
    L21:
        r1 = r6;
        goto L22
    L23:
        ah r12 = this.f23977a;
        if (r12 != null) goto L26;
        d.h.b.o.c("binding");
        r12 = null;
    L26:
        r12.f.setVisibility(8);
        ah r13 = this.f23977a;
        if (r13 != null) goto L29;
        d.h.b.o.c("binding");
    L30:
        r1.f22736c.setVisibility(8);
        return;
    L29:
        r1 = r13;
        goto L30
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r14 = true;
    L11:
        if (r14 != true) goto L13;
    L10:
        r14 = false;
        goto L11
    }

    private final void c(final com.obric.autoaction.app.launcherpage.module.a.a.b r7) {
        ah r0 = this.f23977a;
        ah r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.g.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.e(), CharSequence.class, "com.obric.aiagent.plugin"));
        ah r2 = this.f23977a;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        r2.f22737d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.d(), CharSequence.class, "com.obric.aiagent.plugin"));
        ah r3 = this.f23977a;
        if (r3 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        r1.b().setOnClickListener(new $$Lambda$a$TsnX9_wN9XATSNShuLtBbU5KbXA(this, r7));
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private static final void b(a r2, com.obric.autoaction.app.launcherpage.module.a.a.b r3, View r4) {
        com.obric.autoaction.app.launcherpage.module.d r5 = r2.I();
        ah r6 = r2.f23977a;
        if (r6 != null) goto L5;
        d.h.b.o.c("binding");
        r6 = null;
    L5:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r7, "null cannot be cast to non-null type android.app.Activity");
        r5.a((Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin"), "enter_from_detail_main_cell", r3.a(), r3.b());
    }

    private final void d(com.obric.autoaction.app.launcherpage.module.a.a.b r6) {
        int r0 = r6.h();
        ah r2 = null;
        if (r0 != 0) goto L5;
        ah r7 = this.f23977a;
        if (r7 != null) goto L40;
        d.h.b.o.c("binding");
        r7 = null;
    L40:
        r7.f22734a.setChecked(true);
        ah r5 = this.f23977a;
        if (r5 != null) goto L43;
        d.h.b.o.c("binding");
    L44:
        r2.f22734a.setEnabled(true);
        return;
    L43:
        r2 = r5;
        goto L44
    L5:
        if (r0 != 1) goto L7;
        ah r1 = this.f23977a;
        if (r1 != null) goto L27;
        d.h.b.o.c("binding");
        r1 = null;
    L27:
        r1.f22734a.setChecked(false);
        ah r3 = this.f23977a;
        if (r3 != null) goto L30;
        d.h.b.o.c("binding");
        r3 = null;
    L30:
        r3.f22734a.setEnabled(false);
        if (ZeusTransformUtils.instanceOf(r6.b(), com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L48;
        ah r8 = this.f23977a;
        if (r8 != null) goto L35;
        d.h.b.o.c("binding");
    L36:
        r2.f22734a.setEnabled(true);
        return;
    L35:
        r2 = r8;
        goto L36
    L48:
        return;
    L7:
        if (r0 == 2) goto L16;
        ah r9 = this.f23977a;
        if (r9 != null) goto L11;
        d.h.b.o.c("binding");
        r9 = null;
    L11:
        r9.f22734a.setChecked(false);
        ah r10 = this.f23977a;
        if (r10 != null) goto L14;
        d.h.b.o.c("binding");
    L15:
        r2.f22734a.setEnabled(false);
        return;
    L14:
        r2 = r10;
        goto L15
    L16:
        ah r11 = this.f23977a;
        if (r11 != null) goto L19;
        d.h.b.o.c("binding");
        r11 = null;
    L19:
        r11.f22734a.setChecked(false);
        ah r12 = this.f23977a;
        if (r12 != null) goto L22;
        d.h.b.o.c("binding");
    L23:
        r2.f22734a.setEnabled(true);
        return;
    L22:
        r2 = r12;
        goto L23
    }

    private final void K() {
        ah r0 = this.f23977a;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OUICardConstraintLayout r1 = r0.b();
        d.h.b.o.c(r1, "getRoot(...)");
        p.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), new $$Lambda$a$PSSrgXIoeMbUgkeHcg0jC9Vf7S0(this));
    }

    private static final boolean a(a r3, View r4, int[] r5) {
        d.h.b.o.e(r4, "<unused var>");
        d.h.b.o.e(r5, "rawPos");
        com.obric.autoaction.app.launcherpage.ui.d r6 = ((com.obric.autoaction.app.launcherpage.ui.f) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.app.launcherpage.ui.f.class, "com.obric.aiagent.plugin")).b();
        com.obric.autoaction.app.launcherpage.ui.c r1 = null;
        if (r6 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.g r7 = r6.b();
        if (r7 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.c r8 = r7.a().get(com.obric.autoaction.app.launcherpage.ui.k.class);
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autoaction.app.launcherpage.ui.k.class) == false) goto L10;
        r1 = r8;
    L10:
        r1 = (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.k) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.ui.k.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 == null) goto L14;
        return false;
    L14:
        r3.a(r5);
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.b
    public d.h.a.a<x> a(int[] r4) {
        d.h.b.o.e(r4, "rawPos");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.Activity");
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
        final z.f r2 = new z.f();
        m<? super OPopoverEntranceMenuView.a, ? super d.h.a.a<x>, x> r3 = new $$Lambda$a$TXgp97Ppqp8aQ938yS59fuxAzWY(r2, this);
        if (a() == null) goto L6;
        h.f24077a.a(r1, r4, r3);
    L6:
        return new $$Lambda$a$zAxH4pIEw0ISSEmLSY51DIUXu_g(r2);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [T, d.h.a.a, java.lang.Object] */
    private static final x a(z.f r4, final a r5, final OPopoverEntranceMenuView.a r6, d.h.a.a r7) {
        final ?? r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "$this$popupBuilder");
        d.h.b.o.e(r8, "dismiss");
        r4.f38504a = r8;
        final com.obric.autoaction.app.launcherpage.module.a.a.b r9 = (com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(r5.a(), com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L5;
        h.f24077a.b(r6, ZeusTransformUtils.mapRes(R.string.task_copy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy"), new $$Lambda$a$qlLrytaib0umZJ61dc3fhjwv94(r8, r6, r9));
        h.f24077a.a(r6, new $$Lambda$a$xHzFKLSODrjVC7s3A7tTSSBYn1w(r8, r5, r9));
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private static final x a(d.h.a.a r4, OPopoverEntranceMenuView.a r5, com.obric.autoaction.app.launcherpage.module.a.a.b r6) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        h.f24077a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6.e(), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_copy_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy_success")));
        return x.f38692a;
    }

    private static final x a(d.h.a.a r12, final a r13, final com.obric.autoaction.app.launcherpage.module.a.a.b r14) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "getContext(...)");
        p.a(r2, p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event"), null, 1, null), (CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event_desc"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), p.a(ZeusTransformUtils.mapRes(R.string.delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "delete"), null, 1, null), null, true, false, new $$Lambda$a$2Lb6pi8BvaKu5KKtNRjhRC5Y1KY(r14, r13), 80, null);
        return x.f38692a;
    }

    private static final void a(com.obric.autoaction.app.launcherpage.module.a.a.b r1, a r2, DialogInterface r3, int r4) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        com.obric.event.task.base.report.o.f32870a.a(r1.a());
        r2.I().a(r1.a());
    }

    private static final x a(z.f r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r2.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.invoke();
    L6:
        return x.f38692a;
    }
}
