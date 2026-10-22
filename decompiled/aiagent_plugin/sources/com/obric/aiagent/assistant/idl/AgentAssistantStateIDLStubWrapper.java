package com.obric.aiagent.assistant.idl;

/* JADX INFO: loaded from: classes2.dex */
class AgentAssistantStateIDLStubWrapper extends IAgentAssistantStateIDL.Stub {
    boolean log;
    final IAgentAssistantStateIDL.Stub origin;

    AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r2) {
        this(r2, true);
    }

    AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }
}
