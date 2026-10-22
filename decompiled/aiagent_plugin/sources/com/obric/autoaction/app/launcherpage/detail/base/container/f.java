package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: DetailDateViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends z<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.f f23314b;

    public f() {
        this(false, 1, null);
    }

    public static /* synthetic */ void lambda$1GbJLcVMtMviTa0wpVDH8pAs_O0(f r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$54geoulKMt2Mpe6XDFYcCtHpPo4(ODatePickerView r0, d.h.a.b r1, OSheet r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d.x lambda$9fuNB1wW0Y8JRMIWpVESyTwl6hM(f r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$P7angW6tRrsfrv_577g2BV6XCs0(d.h.a.a r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$PtlzbWMpmVTGo5L21i7kaZKALzY(f r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$W43g62mjU8_zhpQqGbFK4eG59x0(f r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$Z5V-hM2nomWpUz_5o6MT9jo7uyE, reason: not valid java name */
    public static /* synthetic */ d.x m474lambda$Z5VhM2nomWpUz_5o6MT9jo7uyE(f r0) {
        return b(r0);
    }

    public static /* synthetic */ d.x lambda$_F40Y2rjA1q1UdZC0w0FmrdlUgE(d.h.a.a r0, d.h.a.a r1, View r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$hRl3oSXVmd5hmZEe-CaFskm2ynQ, reason: not valid java name */
    public static /* synthetic */ d.x m475lambda$hRl3oSXVmd5hmZEeCaFskm2ynQ(d.h.a.a r0, f r1, d.h.a.a r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$k-pGoXb_IWsQ52UZTd3GDocua2M, reason: not valid java name */
    public static /* synthetic */ void m476lambda$kpGoXb_IWsQ52UZTd3GDocua2M(OSheet r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$m2QDTqvu45Z-9sJC7VY4uGSCMGg, reason: not valid java name */
    public static /* synthetic */ d.x m477lambda$m2QDTqvu45Z9sJC7VY4uGSCMGg(f r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$oFrHqMcitkDYs9QeiHvZXn-L7HY, reason: not valid java name */
    public static /* synthetic */ d.x m478lambda$oFrHqMcitkDYs9QeiHvZXnL7HY(LocalDate r0, f r1, d.h.a.a r2, d.h.a.a r3, OPopoverEntranceMenuView.a r4, d.h.a.a r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean lambda$uXEMI9dzBswGOTxomhUWZal31fg(f r0, LocalDate r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vhGJPm-AmqqFCU6f3cQ9824wsSc, reason: not valid java name */
    public static /* synthetic */ boolean m479lambda$vhGJPmAmqqFCU6f3cQ9824wsSc(f r0, LocalDate r1) {
        return b(r0, r1);
    }

    public /* synthetic */ f(boolean r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    public f(boolean r1) {
        this.f23313a = r1;
    }

    private final String a(LocalDate r1) {
        String r0 = r1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        d.h.b.o.c(r0, "format(...)");
        return r0;
    }

    private final LocalDate a(String r4) {
        Object r1 = null;
        if (r4 != null) goto L15;
        return null;
    L15:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
        f r3 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r5 = d.n.f(LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r5) == true) goto L14;
        r1 = r5;
    L14:
        return (LocalDate) ZeusTransformUtils.preCheckCast(r1, LocalDate.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L10
    }

    private final String b(LocalDate r2) {
        return new StringBuilder().append(r2.getYear()).append(24180).append(r2.getMonthValue()).append(26376).append(r2.getDayOfMonth()).append(26085).toString();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.f r5 = com.obric.autoaction.app.launcherpage.a.f.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23314b = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public e a(com.obric.autoaction.app.launcherpage.detail.base.a r4) {
        d.h.b.o.e(r4, "context");
        EventTask r5 = r4.c().a();
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, ConditionTask.class) == false) goto L5;
        ConditionTask r6 = (ConditionTask) ZeusTransformUtils.preCheckCast(r5, ConditionTask.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 == null) goto L8;
        PeriodicPolicy r7 = r6.getPeriodicPolicy();
    L10:
        if (r7 == null) goto L12;
        String r2 = r7.getStartDate();
    L13:
        LocalDate r3 = a(r2);
        if (r7 == null) goto L17;
        r1 = r7.getExpireDate();
    L17:
        return new e(r3, a(r1), this.f23313a);
    L12:
        r2 = null;
        goto L13
    L8:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        j();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        i();
    }

    private final void i() {
        n();
        com.obric.autoaction.app.launcherpage.a.f r1 = null;
        if (((e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin")).c() == false) goto L9;
        com.obric.autoaction.app.launcherpage.a.f r5 = this.f23314b;
        if (r5 != null) goto L7;
        d.h.b.o.c("binding");
    L8:
        OTextView r6 = r1.f22813a;
        d.h.b.o.c(r6, "conditionEventDateSetting");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r1 = r5;
        goto L8
    L9:
        com.obric.autoaction.app.launcherpage.a.f r7 = this.f23314b;
        if (r7 != null) goto L12;
        d.h.b.o.c("binding");
    L13:
        OTextView r8 = r1.f22813a;
        d.h.b.o.c(r8, "conditionEventDateSetting");
        com.obric.oui.common.util.k.b((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        r1 = r7;
        goto L13
    }

    private final void j() {
        com.obric.autoaction.app.launcherpage.a.f r0 = this.f23314b;
        com.obric.autoaction.app.launcherpage.a.f r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22815c.setOnContentClickListener(new $$Lambda$f$PtlzbWMpmVTGo5L21i7kaZKALzY(this));
        com.obric.autoaction.app.launcherpage.a.f r2 = this.f23314b;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22814b.setOnContentClickListener(new $$Lambda$f$1GbJLcVMtMviTa0wpVDH8pAs_O0(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void a(final f r3, View r4) {
        LocalDate r5 = ((e) ZeusTransformUtils.preCheckCast(r3.f(), e.class, "com.obric.aiagent.plugin")).a();
        com.obric.autoaction.app.launcherpage.a.f r0 = r3.f23314b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22815c;
        d.h.b.o.c(r1, "conditionEventRepeatModeStartDate");
        r3.a(r5, (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), new $$Lambda$f$9fuNB1wW0Y8JRMIWpVESyTwl6hM(r3), new $$Lambda$f$Z5VhM2nomWpUz_5o6MT9jo7uyE(r3));
    }

    private static final d.x a(f r3) {
        ((e) ZeusTransformUtils.preCheckCast(r3.f(), e.class, "com.obric.aiagent.plugin")).a(null);
        r3.m();
        return d.x.f38692a;
    }

    private static final d.x b(f r0) {
        r0.k();
        return d.x.f38692a;
    }

    private static final void b(final f r3, View r4) {
        LocalDate r5 = ((e) ZeusTransformUtils.preCheckCast(r3.f(), e.class, "com.obric.aiagent.plugin")).b();
        com.obric.autoaction.app.launcherpage.a.f r0 = r3.f23314b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22814b;
        d.h.b.o.c(r1, "conditionEventRepeatModeExpireDate");
        r3.a(r5, (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), new $$Lambda$f$m2QDTqvu45Z9sJC7VY4uGSCMGg(r3), new $$Lambda$f$W43g62mjU8_zhpQqGbFK4eG59x0(r3));
    }

    private static final d.x c(f r3) {
        ((e) ZeusTransformUtils.preCheckCast(r3.f(), e.class, "com.obric.aiagent.plugin")).b(null);
        r3.m();
        return d.x.f38692a;
    }

    private static final d.x d(f r0) {
        r0.l();
        return d.x.f38692a;
    }

    private final void a(final LocalDate r6, View r7, d.h.a.a<d.x> r8, d.h.a.a<d.x> r9) {
        final d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.a.h r0 = com.obric.autoaction.app.launcherpage.module.a.h.f24077a;
        com.obric.autoaction.app.launcherpage.a.f r2 = this.f23314b;
        Dialog r3 = null;
        if (r2 != null) goto L5;
        d.h.b.o.c("binding");
        r2 = null;
    L5:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "getContext(...)");
        ComponentActivity r5 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r4), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
        return;
    L8:
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.detail.base.a r12 = getContext();
        if (r12 == null) goto L13;
        com.obric.autoaction.app.launcherpage.detail.base.d r13 = r12.a();
        if (r13 == null) goto L13;
        r3 = r13.getDialog();
    L13:
        r0.a(r1, r3, com.obric.autoaction.app.launcherpage.utils.p.a(r7), new $$Lambda$f$oFrHqMcitkDYs9QeiHvZXnL7HY(r6, this, r10, r11));
    }

    private static final d.x a(LocalDate r22, final f r23, d.h.a.a r24, d.h.a.a r25, OPopoverEntranceMenuView.a r26, d.h.a.a r27) {
        final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r26, "$this$showPopup");
        d.h.b.o.e(r5, "dismiss");
        String r6 = com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_none"), null, 1, null);
        if (r22 == null) goto L6;
        String r9 = r23.b(r22);
        if (r9 == null) goto L6;
    L7:
        String r13 = r9;
        r26.b();
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L10;
        boolean r17 = true;
    L11:
        OPopoverEntranceMenuView.a.a(r26, null, null, null, r11, null, false, false, r17, new $$Lambda$f$_F40Y2rjA1q1UdZC0w0FmrdlUgE(r5, r2), IdlErrors.E_RejectInferDeviceOverheat, null);
        if (r22 == null) goto L14;
        boolean r15 = true;
    L15:
        OPopoverEntranceMenuView.a.a(r26, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.o_ic_popmenu_arrow, "drawable", "o_ic_popmenu_arrow")), null, (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), null, false, false, r15, new $$Lambda$f$hRl3oSXVmd5hmZEeCaFskm2ynQ(r5, r23, r4), 117, null);
        return d.x.f38692a;
    L14:
        r15 = false;
        goto L15
    L10:
        r17 = false;
    L6:
        r9 = com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_self_select, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_self_select"), null, 1, null);
        goto L7
    }

    private static final d.x a(d.h.a.a r1, d.h.a.a r2, View r3, int r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<unused var>");
        r5.invoke();
        r6.invoke();
        return d.x.f38692a;
    }

    private static final d.x a(d.h.a.a r1, f r2, d.h.a.a r3, View r4, int r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<unused var>");
        r6.invoke();
        com.obric.autoaction.app.launcherpage.a.f r8 = r2.f23314b;
        if (r8 != null) goto L5;
        d.h.b.o.c("binding");
        r8 = null;
    L5:
        r8.b().post(new $$Lambda$f$P7angW6tRrsfrv_577g2BV6XCs0(r7));
        return d.x.f38692a;
    }

    private static final void a(d.h.a.a r2) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    }

    private final void k() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        LocalDate r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        d.h.b.o.a(r1);
        a(r1, com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_start_date_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_start_date_title"), null, 1, null), new $$Lambda$f$uXEMI9dzBswGOTxomhUWZal31fg(this));
        return;
    L6:
        r1 = LocalDate.now();
        goto L7
    }

    private static final boolean a(f r9, LocalDate r10) {
        d.h.b.o.e(r10, "selectDate");
        if (r10.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(LocalDate.now(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L9;
        AOUserInterfaceTools r11 = AOUserInterfaceTools.INSTANCE;
        com.obric.autoaction.app.launcherpage.a.f r12 = r9.f23314b;
        if (r12 != null) goto L7;
        d.h.b.o.c("binding");
        r12 = null;
    L7:
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r13, "getContext(...)");
        r11.showAppToast(r13, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_start_date_error_hint_before_now, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_start_date_error_hint_before_now"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        return false;
    L9:
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9.f(), e.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L16;
        LocalDate r1 = r0.b();
        if (r1 == null) goto L16;
        if (r10.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r1, ChronoLocalDate.class, "com.obric.aiagent.plugin")) != true) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L23;
        AOUserInterfaceTools r14 = AOUserInterfaceTools.INSTANCE;
        com.obric.autoaction.app.launcherpage.a.f r15 = r9.f23314b;
        if (r15 != null) goto L21;
        d.h.b.o.c("binding");
        r15 = null;
    L21:
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r16, "getContext(...)");
        r14.showAppToast(r16, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_start_date_error_hint_after_deadline, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_start_date_error_hint_after_deadline"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        return false;
    L23:
        e r3 = (e) ZeusTransformUtils.preCheckCast(r9.f(), e.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L26;
        r3.a(r10);
    L26:
        r9.m();
        return true;
    L16:
        r2 = false;
        goto L17
    }

    private final void l() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        LocalDate r1 = r0.b();
        if (r1 == null) goto L6;
    L7:
        d.h.b.o.a(r1);
        a(r1, com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_title"), null, 1, null), new $$Lambda$f$vhGJPmAmqqFCU6f3cQ9824wsSc(this));
        return;
    L6:
        r1 = LocalDate.now();
        goto L7
    }

    private static final boolean b(f r9, LocalDate r10) {
        d.h.b.o.e(r10, "selectDate");
        if (r10.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(LocalDate.now(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L9;
        AOUserInterfaceTools r11 = AOUserInterfaceTools.INSTANCE;
        com.obric.autoaction.app.launcherpage.a.f r12 = r9.f23314b;
        if (r12 != null) goto L7;
        d.h.b.o.c("binding");
        r12 = null;
    L7:
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r13, "getContext(...)");
        r11.showAppToast(r13, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_error_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_error_hint"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        return false;
    L9:
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9.f(), e.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L16;
        LocalDate r1 = r0.a();
        if (r1 == null) goto L16;
        if (r10.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r1, ChronoLocalDate.class, "com.obric.aiagent.plugin")) != true) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L23;
        AOUserInterfaceTools r14 = AOUserInterfaceTools.INSTANCE;
        com.obric.autoaction.app.launcherpage.a.f r15 = r9.f23314b;
        if (r15 != null) goto L21;
        d.h.b.o.c("binding");
        r15 = null;
    L21:
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r16, "getContext(...)");
        r14.showAppToast(r16, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_error_hint_before_start, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_error_hint_before_start"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        return false;
    L23:
        e r3 = (e) ZeusTransformUtils.preCheckCast(r9.f(), e.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L26;
        r3.b(r10);
    L26:
        r9.m();
        return true;
    L16:
        r2 = false;
        goto L17
    }

    private final void a(LocalDate r31, String r32, d.h.a.b<? super LocalDate, Boolean> r33) {
        final d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r33, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.a.f r2 = this.f23314b;
        if (r2 != null) goto L5;
        d.h.b.o.c("binding");
        r2 = null;
    L5:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r3);
        final ODatePickerView r11 = new ODatePickerView(r3, null, 0, ODatePickerView.b.f34345a, false, 16, null);
        r11.setCurrentTimeMillis(r31.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
        final OSheet r12 = new OSheet(r3, 0, 0, false, false, 30, null);
        r12.setHeightMode(OSheet.c.f36216b);
        r12.setBodyView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r12, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), OSheet.b.f36212c, null, null, r32, null, false, new $$Lambda$f$kpGoXb_IWsQ52UZTd3GDocua2M(r12), new $$Lambda$f$54geoulKMt2Mpe6XDFYcCtHpPo4(r11, r0, r12), null, null, null, null, null, null, 16150, null);
        r12.show();
    }

    private static final void a(OSheet r0, View r1) {
        r0.dismiss();
    }

    private static final void a(ODatePickerView r3, d.h.a.b r4, OSheet r5, View r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        LocalDate r8 = Instant.ofEpochMilli(r3.getSelectTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate();
        d.h.b.o.a(r8);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r8), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L6;
        r5.dismiss();
        return;
    }

    private final void m() {
        n();
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = getContext();
        if (r0 == null) goto L17;
        e r2 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        String r3 = null;
        if (r2 == null) goto L9;
        LocalDate r4 = r2.a();
        if (r4 == null) goto L9;
        String r5 = a(r4);
    L10:
        e r6 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L15;
        LocalDate r7 = r6.b();
        if (r7 == null) goto L15;
        r3 = a(r7);
    L15:
        r0.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.e(r5, r3), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r5 = null;
        goto L10
    }

    private final void n() {
        com.obric.autoaction.app.launcherpage.a.f r0 = this.f23314b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22815c;
        e r3 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        LocalDate r4 = r3.a();
        if (r4 == null) goto L11;
        String r5 = b(r4);
        if (r5 == null) goto L11;
    L12:
        OCardListItem.setEndDetailText$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        com.obric.autoaction.app.launcherpage.a.f r2 = this.f23314b;
        if (r2 != null) goto L15;
        d.h.b.o.c("binding");
        r2 = null;
    L15:
        OCardListItem r6 = r2.f22814b;
        e r7 = (e) ZeusTransformUtils.preCheckCast(f(), e.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        LocalDate r8 = r7.b();
        if (r8 == null) goto L21;
        String r10 = b(r8);
        if (r10 == null) goto L21;
    L22:
        OCardListItem.setEndDetailText$default(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        return;
    L21:
        r10 = com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_none"), null, 1, null);
    L11:
        r5 = com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_expire_date_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_expire_date_none"), null, 1, null);
        goto L12
    }
}
