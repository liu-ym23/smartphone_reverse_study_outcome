package com.obric.autoaction.app.launcherpage.module.datasource;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: NewSetupTimerTasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewAddedTimerTaskRecordImpl implements IAutoActionAgentEventListener {
    public NewAddedTimerTaskRecordImpl() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        IAutoActionAgentEventListener.DefaultImpls.onBizStatusChanged(this, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, QueueStatus r2) {
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onSessionEnqueued(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5, IAutoActionAgentEventListener.AgentStepExecInfo r6) {
        o.e(r4, "sessionInfo");
        o.e(r5, "stepInfo");
        o.e(r6, "execInfo");
        if (r5.getActionType() != 4) goto L12;
        Object r0 = r6.getPayload();
        if (ZeusTransformUtils.instanceOf(r0, TimerTaskV2.class) == false) goto L7;
        TimerTaskV2 r1 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r0, TimerTaskV2.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L12;
        String r2 = r1.getId();
        if (r2 == null) goto L12;
        c.f24201a.a().add(r2);
        goto L12
    L7:
        r1 = null;
    L12:
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r4, r5, r6);
    }
}
