package com.obric.autoaction.vdplayer.b.b;

import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: ActiveSessionInfoUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public a() {
    }

    public final IAgentSessionManager.a a() {
        String r3 = AutoActionAgent.INSTANCE.getOnGoingSessionKey();
        IAgentSessionManager r0 = (IAgentSessionManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSessionManager.class), IAgentSessionManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        IAgentSessionManager.a r4 = r0.getSession(r3);
    L7:
        if (AutoActionAgent.INSTANCE.isOngoingSessionActive() == false) goto L10;
        if (r4 == null) goto L10;
        return r4;
    L10:
        return null;
    L5:
        r4 = null;
        goto L7
    }

    public final h<IAgentSessionManager.a> b() {
        IAgentSessionManager r2 = (IAgentSessionManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentSessionManager.class), IAgentSessionManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        h<IAgentSessionManager.a> r3 = r2.getActiveSession();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return j.a();
    }
}
