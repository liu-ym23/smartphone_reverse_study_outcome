package com.obric.autogui.vdplayer.adapter.orchestrator.a.a;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: BaseEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements com.obric.autogui.vdplayer.adapter.orchestrator.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.h.a.b<? super List<? extends com.obric.autogui.vdplayer.api.a.a>, x> f31657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.h.a.b<? super d.h.a.b<? super com.obric.autogui.vdplayer.api.a.b, com.obric.autogui.vdplayer.api.a.b>, x> f31658b;

    public a() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, QueueStatus r2) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r1) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.b(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return com.obric.autogui.vdplayer.adapter.orchestrator.a.a.C0869a.a(this);
    }

    public final void a(d.h.a.b<? super List<? extends com.obric.autogui.vdplayer.api.a.a>, x> r3) {
        this.f31657a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final void b(d.h.a.b<? super d.h.a.b<? super com.obric.autogui.vdplayer.api.a.b, com.obric.autogui.vdplayer.api.a.b>, x> r3) {
        this.f31658b = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final void c(d.h.a.b<? super com.obric.autogui.vdplayer.api.a.b, com.obric.autogui.vdplayer.api.a.b> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "transform");
        d.h.a.b<? super d.h.a.b<? super com.obric.autogui.vdplayer.api.a.b, com.obric.autogui.vdplayer.api.a.b>, x> r2 = this.f31658b;
        if (r2 == null) goto L6;
        r2.invoke(r4);
        return;
    }

    public final void a(List<? extends com.obric.autogui.vdplayer.api.a.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "actions");
        d.h.a.b<? super List<? extends com.obric.autogui.vdplayer.api.a.a>, x> r2 = this.f31657a;
        if (r2 == null) goto L6;
        r2.invoke(r4);
        return;
    }

    public final void a(com.obric.autogui.vdplayer.api.a.a r2) {
        o.e(r2, "action");
        a(p.a(r2));
    }
}
