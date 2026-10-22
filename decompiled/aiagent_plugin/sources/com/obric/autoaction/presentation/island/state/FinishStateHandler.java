package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.LaunchMethodClient;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import d.s;
import d.x;

/* JADX INFO: compiled from: FinishStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FinishStateHandler extends a {
    public static /* synthetic */ x lambda$B3rnonk_F4_xxt0ZYdtN0AYvaJo(WidgetState.LastStep r0, FinishStateHandler r1) {
        return onLastStep$lambda$2$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$mV3hn-GL91srrGnpYt_03gVYs8g, reason: not valid java name */
    public static /* synthetic */ x m630lambda$mV3hnGL91srrGnpYt_03gVYs8g(IslandWidget r0) {
        return onLastStep$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ x lambda$mi1l3wQpF7i1G4gLWYouNCKTRkM(WidgetState.LastStep r0, FinishStateHandler r1) {
        return onLastStep$lambda$6$lambda$4(r0, r1);
    }

    public FinishStateHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(final WidgetState.LastStep r26) {
        o.e(r26, "state");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Bundle r4 = r26.getStepInfo().getExtras();
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getInt("term_reason_type"));
    L7:
        if (r26.getStepInfo().isSuccess() == false) goto L14;
        Bundle r6 = r26.getStepInfo().getExtras();
        if (r6 == null) goto L11;
        boolean r7 = r6.getBoolean("model_success");
    L12:
        if (r7 == false) goto L14;
        boolean r8 = true;
    L16:
        if (r5 == null) goto L21;
        if (r5.intValue() != 2) goto L21;
    L47:
        boolean r9 = true;
    L49:
        if (r8 == false) goto L51;
        m r3 = s.a(r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_done, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_done")), r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_completed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_completed")));
    L54:
        Object r10 = r3.c();
        o.c(r10, "component1(...)");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        Object r11 = r3.d();
        o.c(r11, "component2(...)");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        CommonCollapseTemplate r12 = com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_normal", null, r14, null, 10, null);
        if (r8 == true) goto L60;
        if (r9 == true) goto L60;
        Text r13 = r12.getEndText();
        if (r13 == null) goto L60;
        r13.setTextColor(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6"), false, 2, null));
    L60:
        IslandWidget r15 = CommonCollapseTemplate.create$default(r12, null, 1, null);
        r15.setOnCardClickCallback(new $$Lambda$FinishStateHandler$B3rnonk_F4_xxt0ZYdtN0AYvaJo(r26, this));
        com.obric.autoaction.presentation.island.template.a r16 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r17 = r26.getSessionInfo().getTask().getUserTask();
        if (r17 != null) goto L63;
        r17 = "";
    L63:
        CommonExpandedTemplate r19 = r16.a("svg:island_expand_normal", "svg:right_arrow", r18, r17, true);
        if (r8 == true) goto L69;
        if (r9 == true) goto L69;
        Text r20 = r19.getTitle();
        if (r20 == null) goto L69;
        r20.setTextColor(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6"), false, 2, null));
    L69:
        final IslandWidget r21 = CommonExpandedTemplate.create$default(r19, null, 1, null);
        r21.setOnCardClickCallback(new $$Lambda$FinishStateHandler$mi1l3wQpF7i1G4gLWYouNCKTRkM(r26, this));
        r21.addOnViewClickCallback("btn_default", new $$Lambda$FinishStateHandler$mV3hnGL91srrGnpYt_03gVYs8g(r21));
        if (r26.isPureTimerTask() == false) goto L74;
        if (r26.getEndType() != 1) goto L74;
    L75:
        com.obric.autoaction.presentation.island.a.a().c(0);
        return;
    L74:
        if (r26.getSessionInfo().getTask().getLaunchOrigin() == 33) goto L75;
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), r15, r21, false, 4, null);
        com.obric.autoaction.presentation.island.a.a().c(5000);
        return;
    L51:
        if (r9 == false) goto L53;
        r3 = s.a(r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_stopped, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_stopped")), r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_stopped, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_stopped")));
        goto L54
    L53:
        r3 = s.a(r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_failed")), r2.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_failed")));
    L21:
        if (r5 == null) goto L26;
        if (r5.intValue() == 106001) goto L47;
    L26:
        if (r5 == null) goto L31;
        if (r5.intValue() == 106004) goto L47;
    L31:
        if (r5 == null) goto L36;
        if (r5.intValue() == 106005) goto L47;
    L36:
        if (r5 == null) goto L41;
        if (r5.intValue() == 106002) goto L47;
    L41:
        if (r5 != null) goto L44;
    L46:
        r9 = false;
        goto L49
    L44:
        if (r5.intValue() != 106003) goto L46;
    L11:
        r7 = true;
    L14:
        r8 = false;
        goto L16
    L5:
        r5 = null;
        goto L7
    }

    private static final x onLastStep$lambda$2$lambda$1(WidgetState.LastStep r1, FinishStateHandler r2) {
        if (r1.getOperatingApp() != null) goto L5;
        r2.openLandingPage();
    L7:
        return x.f38692a;
    L5:
        r2.startAppOnMainDisplay(r1.getOperatingApp());
        goto L7
    }

    private static final x onLastStep$lambda$6$lambda$4(WidgetState.LastStep r1, FinishStateHandler r2) {
        if (r1.getOperatingApp() != null) goto L5;
        r2.openLandingPage();
    L7:
        return x.f38692a;
    L5:
        r2.startAppOnMainDisplay(r1.getOperatingApp());
        goto L7
    }

    private static final x onLastStep$lambda$6$lambda$5(IslandWidget r0) {
        d.h.a.a<x> r1 = r0.getOnCardClickCallback();
        if (r1 == null) goto L6;
        r1.invoke();
    L6:
        return x.f38692a;
    }

    private final void openLandingPage() {
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        Intent r2 = IAutoActionPresentationApi.DefaultImpls.getOpenLauncherPageIntent$default(r1, r8, null, null, null, 14, null);
        if (r2 == null) goto L9;
        LaunchMethodClient.INSTANCE.setLaunchMethod(r8, LaunchMethodClient.LAUNCH_METHOD_DYNAMIC_ISLAND);
        ZeusTransformUtils.startActivity(r8, r2, "com.obric.aiagent.plugin");
        return;
    L9:
        return;
    }

    private final void startAppOnMainDisplay(IAutoActionAgentEventListener.OperatingAppInfo r3) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        String r4 = r3.getPackageName();
        if (r4 == null) goto L9;
        AOPackagesTools.INSTANCE.openAppOnMainDisplay(r2, r4);
        return;
    L9:
        return;
    }
}
