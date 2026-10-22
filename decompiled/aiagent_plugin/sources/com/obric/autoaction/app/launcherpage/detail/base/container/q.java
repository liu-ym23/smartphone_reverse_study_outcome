package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.eventkit.task.model.EventTask;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailOperateTaskViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends z<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.k f23342a;

    public static /* synthetic */ void lambda$I5DiiSA3lcdB3tYbfGCLbNyaKk4(q r0, DialogInterface r1, int r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ZyR4a_R-m6e2h_OGL02-sjbNwJw, reason: not valid java name */
    public static /* synthetic */ void m485lambda$ZyR4a_Rm6e2h_OGL02sjbNwJw(q r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$whIeTGK7NE8xwOiBREOUklfyOFc(q r0, View r1) {
        b(r0, r1);
    }

    public q() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.k r5 = com.obric.autoaction.app.launcherpage.a.k.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23342a = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public p a(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        d.h.b.o.e(r2, "context");
        EventTask r1 = r2.c().a();
        if (r1 == null) goto L5;
        String r0 = r1.getId();
    L6:
        if (r1 == null) goto L8;
        int r3 = r1.getType();
    L10:
        return new p(r0, r3);
    L8:
        r3 = 3;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        i();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        b(((p) ZeusTransformUtils.preCheckCast(f(), p.class, "com.obric.aiagent.plugin")).b());
    }

    private final void b(int r25) {
        com.obric.autoaction.app.launcherpage.a.k r1 = this.f23342a;
        if (r1 != null) goto L5;
        d.h.b.o.c("binding");
        r1 = null;
    L5:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.a.k r5 = this.f23342a;
        if (r5 != null) goto L8;
        d.h.b.o.c("binding");
        r5 = null;
    L8:
        OCardListItem r12 = r5.f22833b;
        d.h.b.o.a(r2);
        OTextView r13 = new OTextView(r2, null, 0, null, 14, null);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r13.setGravity(17);
        r13.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Medium, "style", "Title_1_Medium"));
        if (r25 != 3) goto L11;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.detail_shortcut_instant_execute, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_shortcut_instant_execute")), CharSequence.class, "com.obric.aiagent.plugin");
    L12:
        r13.setText(r6);
        r13.setTextColor(com.obric.autoaction.app.launcherpage.utils.p.b(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, "color", "oui_accent_7_fg"), r2, null, 2, null));
        r12.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.k r7 = this.f23342a;
        if (r7 != null) goto L15;
        d.h.b.o.c("binding");
        r7 = null;
    L15:
        OCardListItem r8 = r7.f22833b;
        d.h.b.o.c(r8, "detailPilotRunBtn");
        com.obric.autoaction.app.launcherpage.utils.p.a(r8, 0, 1, null);
        com.obric.autoaction.app.launcherpage.a.k r9 = this.f23342a;
        if (r9 != null) goto L18;
        d.h.b.o.c("binding");
        r9 = null;
    L18:
        OCardListItem r10 = r9.f22832a;
        OTextView r14 = new OTextView(r2, null, 0, null, 14, null);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r14.setGravity(17);
        r14.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Medium, "style", "Title_1_Medium"));
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "delete")), CharSequence.class, "com.obric.aiagent.plugin"));
        r14.setTextColor(com.obric.autoaction.app.launcherpage.utils.p.b(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"), r2, null, 2, null));
        r10.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.k r11 = this.f23342a;
        if (r11 != null) goto L21;
        d.h.b.o.c("binding");
        r11 = null;
    L21:
        OCardListItem r0 = r11.f22832a;
        d.h.b.o.c(r0, "detailDeleteItemBtn");
        com.obric.autoaction.app.launcherpage.utils.p.a(r0, 0, 1, null);
        return;
    L11:
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.condition_event_pilot_run, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_pilot_run")), CharSequence.class, "com.obric.aiagent.plugin");
        goto L12
    }

    private final void i() {
        com.obric.autoaction.app.launcherpage.a.k r0 = this.f23342a;
        com.obric.autoaction.app.launcherpage.a.k r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22833b.setOnContentClickListener(new $$Lambda$q$ZyR4a_Rm6e2h_OGL02sjbNwJw(this));
        com.obric.autoaction.app.launcherpage.a.k r2 = this.f23342a;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        r1.f22832a.setOnContentClickListener(new $$Lambda$q$whIeTGK7NE8xwOiBREOUklfyOFc(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void a(q r2, View r3) {
        com.obric.autoaction.app.launcherpage.detail.base.a r4 = r2.getContext();
        if (r4 == null) goto L6;
        r4.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.detail.base.j.c.f23386a, com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void b(q r0, View r1) {
        r0.j();
    }

    private final void j() {
        com.obric.autoaction.app.launcherpage.a.k r0 = this.f23342a;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "getContext(...)");
        com.obric.autoaction.app.launcherpage.utils.p.a(r3, com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event"), null, 1, null), (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event_desc"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "delete"), null, 1, null), null, true, false, new $$Lambda$q$I5DiiSA3lcdB3tYbfGCLbNyaKk4(this), 80, null);
    }

    private static final void a(q r1, DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        String r5 = ((p) ZeusTransformUtils.preCheckCast(r1.f(), p.class, "com.obric.aiagent.plugin")).a();
        if (r5 == null) goto L8;
        com.obric.autoaction.app.launcherpage.detail.base.a r6 = r1.getContext();
        if (r6 == null) goto L9;
        r6.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.a(r5), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        return;
    }
}
