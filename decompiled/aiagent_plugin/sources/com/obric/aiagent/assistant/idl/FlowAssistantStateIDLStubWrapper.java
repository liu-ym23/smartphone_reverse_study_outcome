package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAssistantStateIDLStubWrapper extends IFlowAssistantStateIDL.Stub {
    boolean log;
    final IFlowAssistantStateIDL.Stub origin;

    FlowAssistantStateIDLStubWrapper(IFlowAssistantStateIDL.Stub r2) {
        this(r2, true);
    }

    FlowAssistantStateIDLStubWrapper(IFlowAssistantStateIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isActive() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "isActive()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "isActive() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "isActive", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "isActive()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isActive();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "isActive = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "isActive() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "isActive", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r21) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerActiveStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAssistantActiveStateListenerIDL r7 = r4;
    L19:
        r12.registerActiveStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "registerActiveStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerActiveStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerActiveStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L17;
        r7 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = t.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r21) {
        IFlowAssistantActiveStateListenerIDL r4 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAssistantActiveStateListenerIDL r7 = r4;
    L19:
        r12.unregisterActiveStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "unregisterActiveStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterActiveStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantActiveStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantActiveStateListenerIDL.Stub.class) == false) goto L17;
        r7 = t.a((IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = t.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r21) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerTTSStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAssistantTTSStateListenerIDL r7 = r4;
    L19:
        r12.registerTTSStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "registerTTSStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerTTSStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerTTSStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L17;
        r7 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = v.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r21) {
        IFlowAssistantTTSStateListenerIDL r4 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAssistantTTSStateListenerIDL r7 = r4;
    L19:
        r12.unregisterTTSStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "unregisterTTSStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterTTSStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAssistantTTSStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAssistantTTSStateListenerIDL.Stub.class) == false) goto L17;
        r7 = v.a((IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = v.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public boolean isBackgroundIntercepting() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "isBackgroundIntercepting()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isBackgroundIntercepting();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "isBackgroundIntercepting = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "isBackgroundIntercepting", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r21) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowBackgroundInterceptStateListenerIDL r7 = r4;
    L19:
        r12.registerBackgroundInterceptingListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerBackgroundInterceptingListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L17;
        r7 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = w.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r21) {
        IFlowBackgroundInterceptStateListenerIDL r4 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowBackgroundInterceptStateListenerIDL r7 = r4;
    L19:
        r12.unregisterBackgroundInterceptingListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterBackgroundInterceptingListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class) == false) goto L17;
        r7 = w.a((IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = w.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public int getCurrentNightMode() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "getCurrentNightMode()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "getCurrentNightMode() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "getCurrentNightMode", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "getCurrentNightMode()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getCurrentNightMode();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "getCurrentNightMode = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "getCurrentNightMode() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "getCurrentNightMode", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r21) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "registerNightModeListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerNightModeListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerNightModeListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "registerNightModeListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowNightModeChangeListenerIDL r7 = r4;
    L19:
        r12.registerNightModeListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "registerNightModeListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "registerNightModeListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "registerNightModeListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L17;
        r7 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = ao.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r21) {
        IFlowNightModeChangeListenerIDL r4 = (IFlowNightModeChangeListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowNightModeChangeListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterNightModeListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAssistantStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowNightModeChangeListenerIDL r7 = r4;
    L19:
        r12.unregisterNightModeListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAssistantStateIDLStub", "unregisterNightModeListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAssistantStateIDLStub", "unregisterNightModeListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAssistantStateIDLStub", "unregisterNightModeListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowNightModeChangeListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowNightModeChangeListenerIDL.Stub.class) == false) goto L17;
        r7 = ao.a((IFlowNightModeChangeListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNightModeChangeListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = ao.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }
}
