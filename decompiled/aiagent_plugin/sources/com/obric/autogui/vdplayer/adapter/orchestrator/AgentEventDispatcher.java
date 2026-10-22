package com.obric.autogui.vdplayer.adapter.orchestrator;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import d.h.b.o;

/* JADX INFO: compiled from: AgentEventDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentEventDispatcher implements IAutoActionAgentEventListener {
    public AgentEventDispatcher() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r9, BizStatus r10, BizStatus r11, int r12, BizStatus.StatusChangedReasonStruct r13, Bundle r14) {
        o.e(r9, "sessionInfo");
        o.e(r10, "oldStatus");
        o.e(r11, "status");
        o.e(r13, "reasonDetails");
        b.f31668a.b(r9.getSessionKey()).onBizStatusChanged(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r2) {
        o.e(r2, "sessionInfo");
        b.f31668a.b(r2.getSessionKey()).onSessionEnqueued(r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r2, QueueStatus r3) {
        o.e(r2, "sessionInfo");
        o.e(r3, "queueStatus");
        b.f31668a.b(r2.getSessionKey()).onQueueStatusChanged(r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3) {
        o.e(r2, "sessionInfo");
        o.e(r3, "stepInfo");
        b.f31668a.b(r2.getSessionKey()).onAgentStep(r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3, IAutoActionAgentEventListener.AgentStepExecInfo r4) {
        o.e(r2, "sessionInfo");
        o.e(r3, "stepInfo");
        o.e(r4, "execInfo");
        b.f31668a.b(r2.getSessionKey()).afterAgentStep(r2, r3, r4);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.OperatingAppInfo r3) {
        o.e(r2, "sessionInfo");
        b.f31668a.b(r2.getSessionKey()).onOperatingAppChanged(r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r2) {
        o.e(r2, "sessionInfo");
        b.f31668a.b(r2.getSessionKey()).onUIOperationHangup(r2);
    }
}
