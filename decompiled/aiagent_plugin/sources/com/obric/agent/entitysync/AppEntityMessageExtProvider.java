package com.obric.agent.entitysync;

import com.obric.agent.message.IAgentMessageExtProvider;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: AppEntityMessageExtProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppEntityMessageExtProvider implements IAgentMessageExtProvider {
    public AppEntityMessageExtProvider() {
    }

    @Override // com.obric.agent.message.IAgentMessageExtProvider
    public Map<String, String> getExtraForSendMessage(com.obric.agent.message.b r1) {
        o.e(r1, AutoTestConstant.PARAM);
        return b.f14469a.a(r1.a());
    }
}
