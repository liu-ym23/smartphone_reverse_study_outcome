package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PicInfo;

/* JADX INFO: loaded from: classes2.dex */
class AgentMessageIDLStubWrapper extends IAgentMessageIDL.Stub {
    boolean log;
    final IAgentMessageIDL.Stub origin;

    AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r2) {
        this(r2, true);
    }

    AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentMessageIDLStub", "getScreenPicInfo()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentMessageIDLStub", "getScreenPicInfo() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentMessageIDLStub", "getScreenPicInfo", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentMessageIDLStub", "getScreenPicInfo()");     // Catch: Exception -> L11
    L6:
        PicInfo r9 = this.origin.getScreenPicInfo();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentMessageIDLStub", "getScreenPicInfo = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentMessageIDLStub", "getScreenPicInfo() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentMessageIDLStub", "getScreenPicInfo", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
