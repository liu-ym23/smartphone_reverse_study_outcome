package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentSettingsIDLIpcWrapper implements IAgentSettingsIDL {
    boolean log;
    final IAgentSettingsIDL origin;

    AgentSettingsIDLIpcWrapper(IAgentSettingsIDL r3) {
        this((IAgentSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSettingsIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentSettingsIDLIpcWrapper(IAgentSettingsIDL r3, boolean r4) {
        this.origin = (IAgentSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSettingsIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isAutoGuiInstall() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAutoGuiInstall();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSettingsIDLIPC", "isAutoGuiInstall = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "isAutoGuiInstall", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public boolean isMemoryRecommendActivityEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isMemoryRecommendActivityEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "isMemoryRecommendActivityEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSettingsIDL
    public void setSystemProperty(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "setSystemProperty", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setSystemProperty(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSettingsIDLIPC", "setSystemProperty = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSettingsIDLIPC", "setSystemProperty(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSettingsIDLIPC", "setSystemProperty", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
