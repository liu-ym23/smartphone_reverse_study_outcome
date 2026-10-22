package com.obric.autogui.agents.stateprovider;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AgentStateProviderEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentStateProviderEventListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static IAutoActionAgentEventListener.OperatingAppInfo sOperatingApp;
    private static IAutoActionAgentEventListener.AgentStepExecInfo sStepExecInfo;
    private static IAutoActionAgentEventListener.AgentStepInfo sStepInfo;

    /* JADX INFO: compiled from: AgentStateProviderEventListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final IAutoActionAgentEventListener.OperatingAppInfo a() {
            return AgentStateProviderEventListener.access$getSOperatingApp$cp();
        }

        public final IAutoActionAgentEventListener.AgentStepInfo b() {
            return AgentStateProviderEventListener.access$getSStepInfo$cp();
        }
    }

    static {
        Companion = new a(null);
    }

    public AgentStateProviderEventListener() {
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.OperatingAppInfo access$getSOperatingApp$cp() {
        return sOperatingApp;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.AgentStepExecInfo access$getSStepExecInfo$cp() {
        return sStepExecInfo;
    }

    public static final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo access$getSStepInfo$cp() {
        return sStepInfo;
    }

    public static final /* synthetic */ void access$setSOperatingApp$cp(IAutoActionAgentEventListener.OperatingAppInfo r0) {
        sOperatingApp = r0;
    }

    public static final /* synthetic */ void access$setSStepExecInfo$cp(IAutoActionAgentEventListener.AgentStepExecInfo r0) {
        sStepExecInfo = r0;
    }

    public static final /* synthetic */ void access$setSStepInfo$cp(IAutoActionAgentEventListener.AgentStepInfo r0) {
        sStepInfo = r0;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r1, r2);
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
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        o.e(r1, "sessionInfo");
        o.e(r2, "stepInfo");
        o.e(r3, "execInfo");
        sStepInfo = r2;
        sStepExecInfo = r3;
        AgentStateProviderImpl.Companion.a("step-exec");
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        o.e(r1, "sessionInfo");
        sOperatingApp = r2;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        o.e(r1, "sessionInfo");
        o.e(r2, "oldStatus");
        o.e(r3, "status");
        o.e(r5, "reasonDetails");
        boolean r7 = true;
        if (r3 != BizStatus.TERMINATED) goto L6;
        sStepInfo = null;
        sStepExecInfo = null;
        sOperatingApp = null;
    L9:
        if (r7 == false) goto L12;
        AgentStateProviderImpl.Companion.a("running-status");
        return;
    L12:
        return;
    L6:
        if (r3 == BizStatus.PREPARING) goto L9;
        r7 = false;
        goto L9
    }
}
