package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAssistantStateIDLIpcWrapper implements IFlowAssistantStateIDL {
    boolean log;
    final IFlowAssistantStateIDL origin;

    FlowAssistantStateIDLIpcWrapper(IFlowAssistantStateIDL r3) {
        this((IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAssistantStateIDLIpcWrapper(IFlowAssistantStateIDL r3, boolean r4) {
        this.origin = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isActive() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isActive()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "isActive() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "isActive", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isActive()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isActive()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isActive();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "isActive = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "isActive() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "isActive", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r21) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerActiveStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAssistantActiveStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L19;
        r15 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = t.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAssistantActiveStateListenerIDL r7 = r4;
    L35:
        r13.registerActiveStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "registerActiveStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerActiveStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L33;
        r7 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = t.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r21) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterActiveStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAssistantActiveStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L19;
        r15 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = t.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAssistantActiveStateListenerIDL r7 = r4;
    L35:
        r13.unregisterActiveStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterActiveStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L33;
        r7 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = t.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r21) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerTTSStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAssistantTTSStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L19;
        r15 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = v.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAssistantTTSStateListenerIDL r7 = r4;
    L35:
        r13.registerTTSStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "registerTTSStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerTTSStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L33;
        r7 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = v.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r21) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterTTSStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAssistantTTSStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L19;
        r15 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = v.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAssistantTTSStateListenerIDL r7 = r4;
    L35:
        r13.unregisterTTSStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterTTSStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L33;
        r7 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = v.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isBackgroundIntercepting() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isBackgroundIntercepting();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "isBackgroundIntercepting", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r21) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerBackgroundInterceptingListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowBackgroundInterceptStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L19;
        r15 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = w.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowBackgroundInterceptStateListenerIDL r7 = r4;
    L35:
        r13.registerBackgroundInterceptingListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerBackgroundInterceptingListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L33;
        r7 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = w.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r21) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterBackgroundInterceptingListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowBackgroundInterceptStateListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L19;
        r15 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = w.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowBackgroundInterceptStateListenerIDL r7 = r4;
    L35:
        r13.unregisterBackgroundInterceptingListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterBackgroundInterceptingListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L33;
        r7 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = w.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public int getCurrentNightMode() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getCurrentNightMode();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "getCurrentNightMode = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "getCurrentNightMode", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r21) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerNightModeListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowNightModeChangeListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L19;
        r15 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ao.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowNightModeChangeListenerIDL r7 = r4;
    L35:
        r13.registerNightModeListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "registerNightModeListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "registerNightModeListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L33;
        r7 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = ao.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r21) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterNightModeListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowNightModeChangeListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAssistantStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L19;
        r15 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ao.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAssistantStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowNightModeChangeListenerIDL r7 = r4;
    L35:
        r13.unregisterNightModeListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAssistantStateIDLIPC", "unregisterNightModeListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAssistantStateIDLIPC", "unregisterNightModeListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L33;
        r7 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = ao.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
