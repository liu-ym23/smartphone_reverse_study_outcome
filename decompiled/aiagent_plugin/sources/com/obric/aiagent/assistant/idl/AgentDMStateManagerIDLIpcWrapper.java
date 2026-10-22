package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class AgentDMStateManagerIDLIpcWrapper implements IAgentDMStateManagerIDL {
    boolean log;
    final IAgentDMStateManagerIDL origin;

    AgentDMStateManagerIDLIpcWrapper(IAgentDMStateManagerIDL r3) {
        this((IAgentDMStateManagerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentDMStateManagerIDLIpcWrapper(IAgentDMStateManagerIDL r3, boolean r4) {
        this.origin = (IAgentDMStateManagerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void registerDMStateListener(IAgentDMStateListenerIDL r21) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerDMStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IAgentDMStateListenerIDL r15 = r4;
    L21:
        r12.a("IAgentDMStateManagerIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L19;
        r15 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = c.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentDMStateManagerIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IAgentDMStateListenerIDL r7 = r4;
    L35:
        r13.registerDMStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentDMStateManagerIDLIPC", "registerDMStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "registerDMStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L33;
        r7 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = c.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r21) {
        IAgentDMStateListenerIDL r4 = (IAgentDMStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unRegisterDMStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IAgentDMStateListenerIDL r15 = r4;
    L21:
        r12.a("IAgentDMStateManagerIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L19;
        r15 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = c.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentDMStateManagerIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IAgentDMStateListenerIDL r7 = r4;
    L35:
        r13.unRegisterDMStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "unRegisterDMStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, AgentDMStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IAgentDMStateListenerIDL.Stub.class) == false) goto L33;
        r7 = c.a((IAgentDMStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = c.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL
    public DMStateInfo getCurrentDMSteate() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        DMStateInfo r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getCurrentDMSteate();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentDMStateManagerIDLIPC", "getCurrentDMSteate", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
