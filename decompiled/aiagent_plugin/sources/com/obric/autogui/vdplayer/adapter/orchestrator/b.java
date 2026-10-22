package com.obric.autogui.vdplayer.adapter.orchestrator;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.w;

/* JADX INFO: compiled from: AgentSessionManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAgentSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f31669b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final w<IAgentSessionManager.a> f31670c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h<IAgentSessionManager.a> f31671d = null;

    private b() {
    }

    static {
        f31668a = new b();
        f31669b = new ConcurrentHashMap();
        w<IAgentSessionManager.a> r0 = ad.a(1, 64, null, 4, null);
        f31670c = r0;
        f31671d = (h) ZeusTransformUtils.preCheckCast(j.a(r0), h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager
    public h<IAgentSessionManager.a> getActiveSession() {
        return f31671d;
    }

    public final void a(String r2) {
        o.e(r2, "sessionKey");
        f31670c.a(b(r2));
    }

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager
    public IAgentSessionManager.a getSession(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (IAgentSessionManager.a) ZeusTransformUtils.preCheckCast(f31669b.get(r2), IAgentSessionManager.a.class, "com.obric.aiagent.plugin");
    }

    public final a b(String r5) {
        o.e(r5, "sessionKey");
        ConcurrentMap r4 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f31669b, ConcurrentMap.class, "com.obric.aiagent.plugin");
        Object r0 = r4.get(r5);
        if (r0 != null) goto L8;
        Loog.INSTANCE.i("AgentOrchestratorImpl", "create session " + r5);
        r0 = new a();
        Object r6 = r4.putIfAbsent(r5, r0);
        if (r6 == null) goto L8;
        r0 = r6;
    L8:
        o.c(r0, "getOrPut(...)");
        return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
    }

    public final void c(String r3) {
        o.e(r3, "sessionKey");
        Loog.INSTANCE.i("AgentOrchestratorImpl", "destroy session " + r3);
        f31669b.remove(r3);
    }
}
