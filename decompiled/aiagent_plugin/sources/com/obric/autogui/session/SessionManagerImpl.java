package com.obric.autogui.session;

import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.IAutoActionSessionManager;
import d.h.b.o;
import java.util.List;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: SessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionManagerImpl implements IAutoActionSessionManager {
    private final /* synthetic */ c $$delegate_0;

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public boolean dequeueSession(String r2) {
        o.e(r2, "sessionKey");
        return this.$$delegate_0.dequeueSession(r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public boolean removeSessionByTimerTaskId(String r2) {
        o.e(r2, "timerTaskId");
        return this.$$delegate_0.removeSessionByTimerTaskId(r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionSessionManager
    public h<List<IAutoActionAgentEventListener.SessionInfo>> sessionQueue() {
        return this.$$delegate_0.sessionQueue();
    }

    public SessionManagerImpl() {
        this.$$delegate_0 = c.f30777a;
    }
}
