package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentMessageIDLIpcWrapper implements IAgentMessageIDL {
    boolean log;
    final IAgentMessageIDL origin;

    AgentMessageIDLIpcWrapper(IAgentMessageIDL r3) {
        this((IAgentMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentMessageIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentMessageIDLIpcWrapper(IAgentMessageIDL r3, boolean r4) {
        this.origin = (IAgentMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentMessageIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        PicInfo r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentMessageIDLIPC", "getScreenPicInfo()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentMessageIDLIPC", "getScreenPicInfo() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentMessageIDLIPC", "getScreenPicInfo", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentMessageIDLIPC", "getScreenPicInfo()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentMessageIDLIPC", "getScreenPicInfo()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getScreenPicInfo();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentMessageIDLIPC", "getScreenPicInfo = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentMessageIDLIPC", "getScreenPicInfo() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentMessageIDLIPC", "getScreenPicInfo", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
