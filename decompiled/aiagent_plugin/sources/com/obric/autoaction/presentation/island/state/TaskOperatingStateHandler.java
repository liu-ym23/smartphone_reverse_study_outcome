package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.utils.ResourceUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TaskOperatingStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskOperatingStateHandler extends a {
    /* JADX INFO: renamed from: lambda$-15-ZxFEqqr4LliA6UoDUW621Yw, reason: not valid java name */
    public static /* synthetic */ x m632lambda$15ZxFEqqr4LliA6UoDUW621Yw(TaskOperatingStateHandler r0) {
        return updateIslandForOperating$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ x lambda$KaOvfhZGCZ76xs8pLCmNgFaIVCA(TaskOperatingStateHandler r0) {
        return updateIslandForOperating$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ x lambda$QfA6P59DJaWnOk4Oz37VujqJ3Lo(TaskOperatingStateHandler r0) {
        return updateIslandForOperating$lambda$4$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$tDFy0CBIEf06OZdsZ-u9TGuTAkA, reason: not valid java name */
    public static /* synthetic */ x m633lambda$tDFy0CBIEf06OZdsZu9TGuTAkA(TaskOperatingStateHandler r0) {
        return updateIslandForClarifyFinish$lambda$10$lambda$9(r0);
    }

    /* JADX INFO: renamed from: lambda$xntEfW5OEJhl0KOqlNB0b-9Sv_w, reason: not valid java name */
    public static /* synthetic */ x m634lambda$xntEfW5OEJhl0KOqlNB0b9Sv_w(TaskOperatingStateHandler r0) {
        return updateIslandForClarifyFinish$lambda$8$lambda$7(r0);
    }

    public TaskOperatingStateHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onOperating(WidgetState.Operating r3) {
        o.e(r3, "state");
        if (r3.getOperatingReason() != 1401) goto L5;
        updateIslandForClarifyFinish(r3);
        return;
    L5:
        updateIslandForOperating(r3);
    }

    private final void updateIslandForOperating(WidgetState.Operating r21) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.island.template.a r3 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r6 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_executing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_executing"));
        o.c(r6, "getString(...)");
        String r2 = r21.getSessionInfo().getTask().getUserTask();
        String r9 = "";
        if (r2 != null) goto L5;
        String r7 = "";
    L6:
        CommonExpandedTemplate r4 = r3.a("svg:island_expand_normal", "lottie:auto_processing_overlay", r6, r7, true);
        Button r5 = (Button) ZeusTransformUtils.preCheckCast(p.l(r4.getButtonList()), Button.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        ResourceUtils r8 = ResourceUtils.INSTANCE;
        IAutoActionAgentEventListener.OperatingAppInfo r10 = r21.getOperatingApp();
        if (r10 == null) goto L12;
        String r11 = r10.getPackageName();
        if (r11 == null) goto L12;
    L13:
        r5.setBackgroundIcon(r8.getApplicationIcon(r11));
    L12:
        r11 = "";
    L14:
        IslandWidget r12 = CommonExpandedTemplate.create$default(r4, null, 1, null);
        r12.setOnCardClickCallback(new $$Lambda$TaskOperatingStateHandler$QfA6P59DJaWnOk4Oz37VujqJ3Lo(this));
        r12.addOnViewClickCallback("btn_default", new $$Lambda$TaskOperatingStateHandler$15ZxFEqqr4LliA6UoDUW621Yw(this));
        com.obric.autoaction.presentation.island.template.a r13 = com.obric.autoaction.presentation.island.template.a.f25101a;
        ResourceUtils r14 = ResourceUtils.INSTANCE;
        IAutoActionAgentEventListener.OperatingAppInfo r15 = r21.getOperatingApp();
        if (r15 == null) goto L20;
        String r16 = r15.getPackageName();
        if (r16 == null) goto L20;
        r9 = r16;
    L20:
        IslandWidget r17 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(r13, "svg:island_normal", "lottie:auto_processing_overlay", null, r14.getApplicationIcon(r9), 4, null), null, 1, null);
        r17.setOnCardClickCallback(new $$Lambda$TaskOperatingStateHandler$KaOvfhZGCZ76xs8pLCmNgFaIVCA(this));
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), r17, r12, false, 4, null);
        return;
    L5:
        r7 = r2;
        goto L6
    }

    private static final x updateIslandForOperating$lambda$4$lambda$2(TaskOperatingStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x updateIslandForOperating$lambda$4$lambda$3(TaskOperatingStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x updateIslandForOperating$lambda$6$lambda$5(TaskOperatingStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private final void updateIslandForClarifyFinish(WidgetState.Operating r18) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.island.b r2 = com.obric.autoaction.presentation.island.a.a();
        IslandWidget r3 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_normal", null, r1.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_received, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_received")), null, 10, null), null, 1, null);
        r3.setOnCardClickCallback(new $$Lambda$TaskOperatingStateHandler$xntEfW5OEJhl0KOqlNB0b9Sv_w(this));
        com.obric.autoaction.presentation.island.template.a r11 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r14 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_received_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_received_reply"));
        o.c(r14, "getString(...)");
        String r4 = r18.getSessionInfo().getTask().getUserTask();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        IslandWidget r5 = CommonExpandedTemplate.create$default(r11.a("svg:island_expand_normal", "svg:right_arrow", r14, r4, true), null, 1, null);
        r5.setOnCardClickCallback(new $$Lambda$TaskOperatingStateHandler$tDFy0CBIEf06OZdsZu9TGuTAkA(this));
        x r0 = x.f38692a;
        com.obric.autoaction.presentation.island.b.a(r2, r3, r5, false, 4, null);
    }

    private static final x updateIslandForClarifyFinish$lambda$8$lambda$7(TaskOperatingStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x updateIslandForClarifyFinish$lambda$10$lambda$9(TaskOperatingStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private final void openPlayer() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        IAutoActionPresentationApi.DefaultImpls.openPlayer$default(r1, r2, "click_dynamic_island", null, 4, null);
        return;
    }
}
