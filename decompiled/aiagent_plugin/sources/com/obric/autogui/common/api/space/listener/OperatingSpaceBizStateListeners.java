package com.obric.autogui.common.api.space.listener;

import android.content.Context;
import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.errtrack.AppErrorTracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OperatingSpaceBizStateListeners.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatingSpaceBizStateListeners implements IAutoActionAgentEventListener {
    public static final Companion Companion = null;
    private static final String TAG = "OpSpace-BizListener";

    /* JADX INFO: compiled from: OperatingSpaceBizStateListeners.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OperatingSpaceBizStateListeners() {
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
        Loog.INSTANCE.d(TAG, "onBizStatusChanged: " + r3 + ", " + r4);
        if (r3 != BizStatus.TERMINATED) goto L5;
        OperatingSpaceManager.INSTANCE.postDestroyAllSpaces((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        AppErrorTracker.INSTANCE.updateSessionInfo(r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        o.e(r1, "sessionInfo");
        o.e(r2, "stepInfo");
        if (r2.getActionType() != 2) goto L6;
        Loog.INSTANCE.d(TAG, "enter call user");
        return;
    }
}
