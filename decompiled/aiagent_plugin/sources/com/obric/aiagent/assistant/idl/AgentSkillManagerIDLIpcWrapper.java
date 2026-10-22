package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AgentSkillManagerIDLIpcWrapper implements IAgentSkillManagerIDL {
    boolean log;
    final IAgentSkillManagerIDL origin;

    AgentSkillManagerIDLIpcWrapper(IAgentSkillManagerIDL r3) {
        this((IAgentSkillManagerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentSkillManagerIDLIpcWrapper(IAgentSkillManagerIDL r3, boolean r4) {
        this.origin = (IAgentSkillManagerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        List<OSkill> r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "listSkills()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "listSkills() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "listSkills", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "listSkills()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "listSkills()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.listSkills();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "listSkills = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "listSkills() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "listSkills", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00a4: MOVE (r7 I:??[long, double]) = (r9 I:??[long, double]), block:B:21:0x00a4 */
    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r9 = 0;
    L19:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion()", e);     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L21
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r2 = Math.max(0, r18 - r3) / 1000;     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion() = fail", r1, r2);     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion", r1, r2, r18);     // Catch: Throwable -> L21
        return r9;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r9 = this.origin.getSkillListVersion();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "getSkillListVersion = " + r9);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion() = " + r9, r14);     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillListVersion", r14, r17);     // Catch: Exception -> L15 Throwable -> L21
        return r9;
        goto L28
    L22:
        return r9;
    L28:
        return 0;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r21) {
        IAgentSkillManagerObserverIDL r4 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerSkillObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IAgentSkillManagerObserverIDL r15 = r4;
    L21:
        r12.a("IAgentSkillManagerIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IAgentSkillManagerObserverIDL.Stub.class) == false) goto L19;
        r15 = k.a((IAgentSkillManagerObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentSkillManagerObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = k.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentSkillManagerIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IAgentSkillManagerObserverIDL r7 = r4;
    L35:
        r13.registerSkillObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "registerSkillObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "registerSkillObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IAgentSkillManagerObserverIDL.Stub.class) == false) goto L33;
        r7 = k.a((IAgentSkillManagerObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentSkillManagerObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = k.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        OSkillManagerConfig r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getSkillManagerConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "getSkillManagerConfig = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillManagerConfig", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.setSkillManagerConfigValues(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "setSkillManagerConfigValues", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getSkillManagerStatus(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentSkillManagerIDLIPC", "getSkillManagerStatus = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentSkillManagerIDLIPC", "getSkillManagerStatus", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
