package com.obric.autoaction.presentation.input.states;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistInputAgentStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputAgentStateListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "AssistInput-AS";

    /* JADX INFO: compiled from: AssistInputAgentStateListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AssistInputAgentStateListener() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r1, r2, r3);
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
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        o.e(r1, "sessionInfo");
        o.e(r2, "oldStatus");
        o.e(r3, "status");
        o.e(r5, "reasonDetails");
        IAssistInputStateManager.AssistInputMode r0 = c.f25027a.getAssistInputMode();
        Loog.INSTANCE.d(TAG, " - [AssistInput] biz-status -> " + r3 + " (reason=" + r4 + ", input-mode=" + r0 + ')');
        if (r3 != BizStatus.TERMINATED) goto L7;
        c.f25027a.e();
        return;
    L7:
        if (r2 == BizStatus.PAUSED) goto L9;
        return;
    L9:
        if (r3 == BizStatus.OPERATING) goto L11;
        return;
    L11:
        if (r0 != IAssistInputStateManager.AssistInputMode.CLARIFY) goto L16;
        c.f25027a.c();
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4) {
        o.e(r3, "sessionInfo");
        o.e(r4, "stepInfo");
        int r2 = r4.getActionType();
        Loog.INSTANCE.d(TAG, " - [AssistInput] with agentSte=" + r2 + " -> " + r4.getActionProtocolType());
        if (r2 != 3) goto L6;
        c.f25027a.b();
        return;
    L6:
        if (r4.getSupportsUserAddition() == false) goto L8;
        c.f25027a.c();
        return;
    L8:
        c.f25027a.d();
    }
}
