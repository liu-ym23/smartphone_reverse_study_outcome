package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class AgentSettingsIDLStubWrapper extends IAgentSettingsIDL.Stub {
    boolean log;
    final IAgentSettingsIDL.Stub origin;

    AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r2) {
        this(r2, true);
    }

    AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSettingsIDLStub", "isAutoGuiInstall()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "isAutoGuiInstall() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "isAutoGuiInstall", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSettingsIDLStub", "isAutoGuiInstall()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAutoGuiInstall();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSettingsIDLStub", "isAutoGuiInstall = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "isAutoGuiInstall() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "isAutoGuiInstall", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isMemoryRecommendActivityEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "setSystemProperty", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setSystemProperty(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSettingsIDLStub", "setSystemProperty = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSettingsIDLStub", "setSystemProperty", r13, r110);     // Catch: Exception -> L11
    }
}
