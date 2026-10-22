package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AgentSkillManagerIDLStubWrapper extends IAgentSkillManagerIDL.Stub {
    boolean log;
    final IAgentSkillManagerIDL.Stub origin;

    AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r2) {
        this(r2, true);
    }

    AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "listSkills()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "listSkills() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "listSkills", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "listSkills()");     // Catch: Exception -> L11
    L6:
        List<OSkill> r9 = this.origin.listSkills();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "listSkills = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "listSkills() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "listSkills", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "getSkillListVersion()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillListVersion() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillListVersion", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "getSkillListVersion()");     // Catch: Exception -> L11
    L6:
        long r9 = this.origin.getSkillListVersion();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "getSkillListVersion = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillListVersion() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillListVersion", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r21) {
        IAgentSkillManagerObserverIDL r4 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "registerSkillObserver(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "registerSkillObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "registerSkillObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "registerSkillObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentSkillManagerIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IAgentSkillManagerObserverIDL r7 = r4;
    L19:
        r12.registerSkillObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "registerSkillObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "registerSkillObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "registerSkillObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, AgentSkillManagerObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IAgentSkillManagerObserverIDL.Stub.class) == false) goto L17;
        r7 = k.a((IAgentSkillManagerObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentSkillManagerObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = k.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "getSkillManagerConfig()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillManagerConfig() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillManagerConfig", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "getSkillManagerConfig()");     // Catch: Exception -> L11
    L6:
        OSkillManagerConfig r9 = this.origin.getSkillManagerConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "getSkillManagerConfig = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillManagerConfig() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillManagerConfig", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.setSkillManagerConfigValues(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "setSkillManagerConfigValues = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillManagerStatus", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        String r11 = this.origin.getSkillManagerStatus(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentSkillManagerIDLStub", "getSkillManagerStatus = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentSkillManagerIDLStub", "getSkillManagerStatus", r14, r19);     // Catch: Exception -> L11
        return r11;
    }
}
