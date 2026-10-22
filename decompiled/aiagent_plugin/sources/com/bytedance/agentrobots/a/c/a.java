package com.bytedance.agentrobots.a.c;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.security.agentmanager.AgentManager;
import com.obric.security.agentmanager.AgentRegRes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ObricAgentManagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.agentrobots.a.a.a {
    public a() {
    }

    @Override // com.bytedance.agentrobots.a.a.a
    public com.bytedance.agentrobots.a.a.d a(Context r2, Bundle r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AgentManager r0 = AgentManager.getInstance();     // Catch: Exception -> L11
        if (r0 != null) goto L6;
        return null;
    L6:
        AgentRegRes r4 = r0.registerAgent(r1, r3);     // Catch: Exception -> L11
        if (r4 == null) goto L16;
        return new d(r4);
    L16:
        return null;
    L11:
        e = move-exception;
        a("ObricAdapter", "registerAgent failed", e);
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
