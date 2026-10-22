package com.obric.autogui.vdplayer.adapter.orchestrator;

import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: AgentSessionManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentSessionManagerImpl implements IAgentSessionManager {
    private final /* synthetic */ b $$delegate_0;

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager
    public h<IAgentSessionManager.a> getActiveSession() {
        return this.$$delegate_0.getActiveSession();
    }

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager
    public IAgentSessionManager.a getSession(String r1) {
        return this.$$delegate_0.getSession(r1);
    }

    public AgentSessionManagerImpl() {
        this.$$delegate_0 = b.f31668a;
    }
}
