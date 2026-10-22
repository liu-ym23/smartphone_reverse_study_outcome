package com.obric.autogui.vdplayer.adapter.orchestrator.a;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IAgentEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends IAutoActionAgentEventListener {

    /* JADX INFO: renamed from: com.obric.autogui.vdplayer.adapter.orchestrator.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IAgentEventHandler.kt */
    public static final class C0869a {
        public static int a(a r2) {
            return IAutoActionAgentEventListener.DefaultImpls.order((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin"), IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"));
        }

        public static void a(a r2, IAutoActionAgentEventListener.SessionInfo r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            IAutoActionAgentEventListener.DefaultImpls.onSessionEnqueued((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3);
        }

        public static void a(a r7, IAutoActionAgentEventListener.SessionInfo r8, BizStatus r9, BizStatus r10, int r11, BizStatus.StatusChangedReasonStruct r12, Bundle r13) {
            a r14 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
            o.e(r8, "sessionInfo");
            o.e(r9, "oldStatus");
            o.e(r10, "status");
            o.e(r12, "reasonDetails");
            IAutoActionAgentEventListener.DefaultImpls.onBizStatusChanged((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r14, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13);
        }

        public static void a(a r2, IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            IAutoActionAgentEventListener.DefaultImpls.onAgentStep((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r5, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        public static void a(a r2, IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, IAutoActionAgentEventListener.AgentStepExecInfo r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            o.e(r5, "execInfo");
            IAutoActionAgentEventListener.DefaultImpls.afterAgentStep((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r6, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }

        public static void a(a r2, IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.OperatingAppInfo r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r5, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        public static void a(a r2, IAutoActionAgentEventListener.SessionInfo r3, QueueStatus r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "queueStatus");
            IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r5, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        public static void b(a r2, IAutoActionAgentEventListener.SessionInfo r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"), r3);
        }
    }

    BizStatus a();
}
