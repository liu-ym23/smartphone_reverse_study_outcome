package com.obric.aiagent.executionengine.eventstaskmanager.common;

import com.obric.agent.IAgentService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ExecuteTaskHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16681a = null;

    static {
        f16681a = new b();
    }

    private b() {
    }

    public final void a(int r3, String r4, String r5) {
        o.e(r4, DownloadConstants.QUERY_KEY);
        o.e(r5, "targetPackage");
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.scheduleTimerTask(r3, r5, r4, null);
        return;
    }

    public final void b(int r3, String r4, String r5) {
        o.e(r4, MemorySourceLinkType.INTENT);
        o.e(r5, "targetPackage");
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.scheduleTimerTask(r3, r5, null, r4);
        return;
    }
}
