package com.obric.autoaction;

import android.os.Bundle;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LegacyUIEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LegacyUIEventListener implements IAutoActionAgentEventListener {
    private AutoOperateTask mTask;

    public LegacyUIEventListener() {
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
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r2) {
        o.e(r2, "sessionInfo");
        this.mTask = r2.getTask();
        DebugActivity r1 = (DebugActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DebugActivity.Companion.a(), "com.obric.aiagent.plugin"), DebugActivity.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.onSessionStarted();
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r10, IAutoActionAgentEventListener.AgentStepInfo r11, IAutoActionAgentEventListener.AgentStepExecInfo r12) {
        o.e(r10, "sessionInfo");
        o.e(r11, "stepInfo");
        o.e(r12, "execInfo");
        if (r11.isLastStep() == true) goto L5;
        return;
    L5:
        if (r11.isSuccess() == false) goto L8;
        int r0 = 0;
    L7:
        int r3 = r0;
        String r1 = r10.getSessionId();
        if (r1 != null) goto L15;
        r1 = r10.getSessionKey();
    L15:
        String r4 = r1;
        DebugActivity r2 = (DebugActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DebugActivity.Companion.a(), "com.obric.aiagent.plugin"), DebugActivity.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L28;
        if (r11.isSuccess() == false) goto L20;
        String r5 = null;
    L21:
        String r6 = r5;
        String r7 = r10.getSessionKey();
        String r8 = r12.getJournalPath();
        AutoOperateTask r9 = this.mTask;
        if (r9 == null) goto L25;
        String r13 = r9.getUserTask();
        if (r13 == null) goto L25;
    L26:
        r2.onSessionEnded(r6, r3, r4, r7, r8, r13);
    L25:
        r13 = "";
        goto L26
    L20:
        r5 = r11.getThought();
    L28:
        if (r11.isSuccess() == false) goto L34;
        DebugActivity r14 = (DebugActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DebugActivity.Companion.a(), "com.obric.aiagent.plugin"), DebugActivity.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L35;
        r14.onFinalStep(r11.getThought());
        return;
    L35:
        return;
    L34:
        return;
    L8:
        Bundle r15 = r11.getExtras();
        if (r15 == null) goto L11;
        r0 = r15.getInt("term_reason_type");
        goto L7
    L11:
        r0 = 1;
        goto L7
    }
}
