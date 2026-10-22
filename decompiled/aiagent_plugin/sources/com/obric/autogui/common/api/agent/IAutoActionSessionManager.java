package com.obric.autogui.common.api.agent;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: IAutoActionSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionSessionManager {
    public static final IMPL IMPL = null;

    /* JADX INFO: compiled from: IAutoActionSessionManager.kt */
    public static final class IMPL implements IAutoActionSessionManager {
        static final /* synthetic */ IMPL $$INSTANCE = null;
        private final /* synthetic */ IAutoActionSessionManager $$delegate_0;

        static {
            $$INSTANCE = new IMPL();
        }

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

        private IMPL() {
            Object r0 = ServiceManager.get().getService(IAutoActionSessionManager.class);
            o.a(r0);
            this.$$delegate_0 = (IAutoActionSessionManager) ZeusTransformUtils.preCheckCast(r0, IAutoActionSessionManager.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        IMPL = IMPL.$$INSTANCE;
    }

    boolean dequeueSession(String r1);

    boolean removeSessionByTimerTaskId(String r1);

    h<List<IAutoActionAgentEventListener.SessionInfo>> sessionQueue();
}
