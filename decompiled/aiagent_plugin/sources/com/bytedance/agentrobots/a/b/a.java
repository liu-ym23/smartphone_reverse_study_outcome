package com.bytedance.agentrobots.a.b;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.agentmanager.AgentManager;
import com.aiassistant.security.agentmanager.AgentRegRes;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AssistantAgentManagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.agentrobots.a.a.a {
    public a() {
    }

    @Override // com.bytedance.agentrobots.a.a.a
    public com.bytedance.agentrobots.a.a.d a(Context r2, Bundle r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AgentManager r4 = AgentManager.getInstance();
        if (r4 != null) goto L11;
        return null;
    L11:
        AgentRegRes r5 = r4.registerAgent(r1, r3);     // Catch: Exception -> L10
        if (r5 == null) goto L13;
        return new d(r5);
    L13:
        return null;
    L14:
        return null;
    }
}
