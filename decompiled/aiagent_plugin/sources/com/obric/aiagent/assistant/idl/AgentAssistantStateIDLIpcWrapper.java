package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentAssistantStateIDLIpcWrapper implements IAgentAssistantStateIDL {
    boolean log;
    final IAgentAssistantStateIDL origin;

    AgentAssistantStateIDLIpcWrapper(IAgentAssistantStateIDL r3) {
        this((IAgentAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentAssistantStateIDLIpcWrapper(IAgentAssistantStateIDL r3, boolean r4) {
        this.origin = (IAgentAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
