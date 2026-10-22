package com.obric.autogui.common.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.l;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
/* synthetic */ class AOAgentRobotsTools$sOperationTargetDispatcher$1 extends l implements m<String, AgentOperationStatus, x> {
    AOAgentRobotsTools$sOperationTargetDispatcher$1(Object r8) {
        super(2, r8, AOAgentRobotsTools.class, "notifyOperationState", "notifyOperationState(Ljava/lang/String;Lcom/obric/autogui/common/api/AgentOperationStatus;)V", 0);
    }

    @Override // d.h.a.m
    public /* synthetic */ x invoke(String r3, AgentOperationStatus r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (AgentOperationStatus) ZeusTransformUtils.preCheckCast(r4, AgentOperationStatus.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, AgentOperationStatus r4) {
        o.e(r3, "p0");
        o.e(r4, "p1");
        AOAgentRobotsTools.access$notifyOperationState((AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this.receiver, AOAgentRobotsTools.class, "com.obric.aiagent.plugin"), r3, r4);
    }
}
