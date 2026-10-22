package com.obric.agent;

import android.content.Intent;
import com.obric.agent.autoaction.IAutoActionService;
import com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppIntentIPCLifecycleImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIntentIPCLifecycleImpl implements IAgentIPCLifecycleDispatchSPI {
    public AppIntentIPCLifecycleImpl() {
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onAppReset(String r1, Intent r2) {
        IAgentIPCLifecycleDispatchSPI.a.b(this, r1, r2);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onUnbind(String r1, Intent r2) {
        d.h.b.o.e(r1, "pkg");
        d.h.b.o.e(r2, MemorySourceLinkType.INTENT);
        IAgentService r0 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.onFlowUnbind();
    L5:
        IAutoActionService r3 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.onFlowUnbind();
        return;
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onBind(String r1, Intent r2) {
        d.h.b.o.e(r1, "pkg");
        d.h.b.o.e(r2, MemorySourceLinkType.INTENT);
        IAutoActionService r0 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.onFlowBind();
        return;
    }
}
