package com.obric.aiagent.ipc.notifier;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IAgentIPCLifecycleDispatchSPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentIPCLifecycleDispatchSPI {

    /* JADX INFO: compiled from: IAgentIPCLifecycleDispatchSPI.kt */
    public static final class a {
        public static void a(IAgentIPCLifecycleDispatchSPI r2, String r3, Intent r4) {
            IAgentIPCLifecycleDispatchSPI r5 = (IAgentIPCLifecycleDispatchSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentIPCLifecycleDispatchSPI.class, "com.obric.aiagent.plugin");
            o.e(r3, "pkg");
            o.e(r4, MemorySourceLinkType.INTENT);
        }

        public static void b(IAgentIPCLifecycleDispatchSPI r2, String r3, Intent r4) {
            IAgentIPCLifecycleDispatchSPI r5 = (IAgentIPCLifecycleDispatchSPI) ZeusTransformUtils.wrapperContextForParams(r2, IAgentIPCLifecycleDispatchSPI.class, "com.obric.aiagent.plugin");
            o.e(r3, "pkg");
            o.e(r4, MemorySourceLinkType.INTENT);
        }
    }

    void onAppReset(String r1, Intent r2);

    void onBind(String r1, Intent r2);

    void onUnbind(String r1, Intent r2);
}
