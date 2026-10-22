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

/* JADX INFO: compiled from: UserInterruptStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UserInterruptStateHandler extends a {
    /* JADX INFO: renamed from: lambda$-TnrUdhh837_gNccmfcLPAooyI8, reason: not valid java name */
    public static /* synthetic */ x m635lambda$TnrUdhh837_gNccmfcLPAooyI8(UserInterruptStateHandler r0) {
        return onUserInterrupt$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ x lambda$mQHaYmccE2vAnx_F9sfzOrr0pYc(UserInterruptStateHandler r0) {
        return onUserInterrupt$lambda$6$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$t4OvI0zkbzhvlFfio-DNjtXUVLE, reason: not valid java name */
    public static /* synthetic */ x m636lambda$t4OvI0zkbzhvlFfioDNjtXUVLE(UserInterruptStateHandler r0) {
        return onUserInterrupt$lambda$1$lambda$0(r0);
    }

    public UserInterruptStateHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onUserInterrupt(WidgetState.UserInterrupt r21) {
        o.e(r21, "state");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IslandWidget r13 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_stop", null, r1.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_paused")), null, 10, null), null, 1, null);
        r13.setOnCardClickCallback(new $$Lambda$UserInterruptStateHandler$t4OvI0zkbzhvlFfioDNjtXUVLE(this));
        com.obric.autoaction.presentation.island.template.a r14 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r2 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_paused"));
        o.c(r2, "getString(...)");
        CommonExpandedTemplate r3 = r14.a("svg:island_stop_expand", "svg:play", r2, String.valueOf(r21.getSessionInfo().getTask().getUserTask()), true);
        Button r4 = (Button) ZeusTransformUtils.preCheckCast(p.l(r3.getButtonList()), Button.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        ResourceUtils r5 = ResourceUtils.INSTANCE;
        IAutoActionAgentEventListener.OperatingAppInfo r6 = r21.getOperatingApp();
        if (r6 == null) goto L8;
        String r7 = r6.getPackageName();
        if (r7 == null) goto L8;
    L9:
        r4.setBackgroundIcon(r5.getApplicationIcon(r7));
    L8:
        r7 = "";
    L10:
        IslandWidget r15 = CommonExpandedTemplate.create$default(r3, null, 1, null);
        r15.setOnCardClickCallback(new $$Lambda$UserInterruptStateHandler$mQHaYmccE2vAnx_F9sfzOrr0pYc(this));
        r15.addOnViewClickCallback("btn_default", new $$Lambda$UserInterruptStateHandler$TnrUdhh837_gNccmfcLPAooyI8(this));
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), r13, r15, false, 4, null);
    }

    private static final x onUserInterrupt$lambda$1$lambda$0(UserInterruptStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x onUserInterrupt$lambda$6$lambda$4(UserInterruptStateHandler r0) {
        r0.openPlayer();
        return x.f38692a;
    }

    private static final x onUserInterrupt$lambda$6$lambda$5(UserInterruptStateHandler r0) {
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
