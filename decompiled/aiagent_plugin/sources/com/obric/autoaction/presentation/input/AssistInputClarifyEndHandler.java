package com.obric.autoaction.presentation.input;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AssistInputClarifyEndHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputClarifyEndHandler implements IAutoActionAgentEventListener {
    public AssistInputClarifyEndHandler() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r1, r2);
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
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r19, BizStatus r20, BizStatus r21, int r22, BizStatus.StatusChangedReasonStruct r23, Bundle r24) {
        o.e(r19, "sessionInfo");
        o.e(r20, "oldStatus");
        o.e(r21, "status");
        o.e(r23, "reasonDetails");
        if (r19.getTask().getLaunchOrigin() == 33) goto L6;
        return;
    L6:
        if (r20 == BizStatus.PAUSED) goto L8;
        return;
    L8:
        if (r21 == BizStatus.OPERATING) goto L10;
        return;
    L10:
        if (r22 != 1401) goto L26;
        if (r24 == null) goto L27;
        String r0 = r24.getString("operating_reason_msg", "");
        if (r0 != null) goto L15;
        return;
    L15:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L18;
        r0 = null;
    L18:
        String r9 = r0;
        if (r9 == null) goto L29;
        IntentResult<?> r1 = new IntentResult(0, null, null, r9, false, false, 1, null, null, null, 950, null);
        r1.setFinal(false);
        IMAppActionExt r3 = new IMAppActionExt();
        r3.put("obric_reply_clarify", "1");
        r1.setExt((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r3, ConcurrentHashMap.class, "com.obric.aiagent.plugin"));
        DispatchContext r2 = getDispatchContext(r19);
        if (r2 == null) goto L30;
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(r1, r2, false);
        return;
    L30:
        return;
    L29:
        return;
    L27:
        return;
    }

    private final DispatchContext getDispatchContext(IAutoActionAgentEventListener.SessionInfo r7) {
        Bundle r6 = r7.getTask().getTaskExtras();
        Map r8 = null;
        if (r6 == null) goto L25;
        Bundle r9 = r6.getBundle("doubao_dispatch_context");
        if (r9 == null) goto L25;
        if (r9.containsKey("questionId") == false) goto L10;
        Long r0 = Long.valueOf(r9.getLong("questionId"));
    L11:
        Bundle r10 = r9.getBundle("ext");
        if (r10 == null) goto L24;
        Set<String> r2 = r10.keySet();
        if (r2 == null) goto L24;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        LinkedHashMap r3 = new LinkedHashMap(n.c(ao.a(p.a(r11, 10)), 16));
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L22;
        Object r4 = r12.next();
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
        String r13 = r10.getString((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        r5.put(r4, r13);
        goto L17
    L22:
        r8 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
    L24:
        return new DispatchContext((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r8);
    L10:
        r0 = null;
    L25:
        return null;
    }
}
