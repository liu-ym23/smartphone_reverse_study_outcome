package com.obric.autogui.common.api.agent;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.obric.autogui.common.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.h.b.o;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: AutoActionAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionAgent implements IAutoActionAgentApi {
    public static final AutoActionAgent INSTANCE = null;

    static {
        INSTANCE = new AutoActionAgent();
    }

    private AutoActionAgent() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void initLib() {
        acquireApi().initLib();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object postUserQuery(String r7, boolean r8, Bundle r9, int r10, d<? super e> r11) {
        d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        return acquireApi().postUserQuery(r7, r8, r9, r10, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object userTerminateQuery(String r3, d<? super e> r4) {
        d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return acquireApi().userTerminateQuery(r3, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public e systemTerminateQuery(String r7, String r8, int r9, EndStepParams r10, Map<String, String> r11) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "message");
        o.e(r5, "ext");
        return acquireApi().systemTerminateQuery(r7, r8, r9, r10, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object enterUserAddition(d<? super e> r3) {
        d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return acquireApi().enterUserAddition(r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitApplyAddition(String r3, d<? super x> r4) {
        d<? super x> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        Object r2 = acquireApi().exitApplyAddition(r3, r5);
        if (r2 != b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitUserAddition(String r3, d<? super e> r4) {
        d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return acquireApi().exitUserAddition(r3, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitUserClarify(String r3, String r4, d<? super e> r5) {
        d<? super e> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return acquireApi().exitUserClarify(r3, r4, r6);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object intentReply(String r3, d<? super x> r4) {
        d<? super x> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        Object r2 = acquireApi().intentReply(r3, r5);
        if (r2 != b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean beforeCallUser() {
        return acquireApi().beforeCallUser();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object enterCallUser(d<? super e> r3) {
        d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return acquireApi().enterCallUser(r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String getOnGoingSessionKey() {
        return acquireApi().getOnGoingSessionKey();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object exitCallUser(d<? super e> r3) {
        d<? super e> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return acquireApi().exitCallUser(r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean hasOngoingTask() {
        return acquireApi().hasOngoingTask();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean isOngoingSessionActive() {
        return acquireApi().isOngoingSessionActive();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public boolean isOngoingSessionPaused() {
        return acquireApi().isOngoingSessionPaused();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object fetchSessionShareUrl(String r3, d<? super IAutoActionAgentApi.SessionShareInfo> r4) {
        d<? super IAutoActionAgentApi.SessionShareInfo> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return acquireApi().fetchSessionShareUrl(r3, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<IAutoActionAgentEventListener.AgentStepInfo> getActiveStepInfo() {
        return acquireApi().getActiveStepInfo();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<IAutoActionAgentEventListener.SessionInfo> getOngoingSessionInfo() {
        return acquireApi().getOngoingSessionInfo();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void cleanDanglingTask() {
        acquireApi().cleanDanglingTask();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public com.obric.autogui.common.d<VDTrackingApp> getTrackingApp() {
        return acquireApi().getTrackingApp();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object startFunction(String r3, d<? super e> r4) {
        d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return acquireApi().startFunction(r3, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public Object stopFunction(String r3, d<? super e> r4) {
        d<? super e> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return acquireApi().stopFunction(r3, r5);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public void stopPredicting() {
        acquireApi().stopPredicting();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String calcJournalAbsoluteDir(String r2) {
        o.e(r2, "sessionKey");
        return acquireApi().calcJournalAbsoluteDir(r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentApi
    public String calcJournalAbsoluteDir(String r2, String r3) {
        o.e(r3, "sessionKey");
        return acquireApi().calcJournalAbsoluteDir(r2, r3);
    }

    private final IAutoActionAgentApi acquireApi() {
        IAutoActionAgentApi r2 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAgentApi.class), IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new RuntimeException("AutoActionAgent service not found.");
    }
}
