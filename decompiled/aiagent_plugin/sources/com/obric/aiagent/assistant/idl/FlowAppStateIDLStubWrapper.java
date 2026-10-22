package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppStateIDLStubWrapper extends IFlowAppStateIDL.Stub {
    boolean log;
    final IFlowAppStateIDL.Stub origin;

    FlowAppStateIDLStubWrapper(IFlowAppStateIDL.Stub r2) {
        this(r2, true);
    }

    FlowAppStateIDLStubWrapper(IFlowAppStateIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAppStateIDLStub", "isAppBackground()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "isAppBackground() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "isAppBackground", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAppStateIDLStub", "isAppBackground()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAppBackground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAppStateIDLStub", "isAppBackground = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "isAppBackground() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "isAppBackground", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAppStateIDLStub", "isAppPaused()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "isAppPaused() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "isAppPaused", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAppStateIDLStub", "isAppPaused()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAppPaused();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAppStateIDLStub", "isAppPaused = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "isAppPaused() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "isAppPaused", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAppStateIDLStub", "getCurrentActivity()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "getCurrentActivity() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "getCurrentActivity", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAppStateIDLStub", "getCurrentActivity()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getCurrentActivity();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAppStateIDLStub", "getCurrentActivity = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "getCurrentActivity() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "getCurrentActivity", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r21) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAppStateIDLStub", "registerAppStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "registerAppStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "registerAppStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAppStateIDLStub", "registerAppStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowOnAppStateChangedListenerIDL r7 = r4;
    L19:
        r12.registerAppStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAppStateIDLStub", "registerAppStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "registerAppStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "registerAppStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L17;
        r7 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = ap.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r21) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowAppStateIDLStub", "unregisterAppStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "unregisterAppStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "unregisterAppStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowAppStateIDLStub", "unregisterAppStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppStateIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowOnAppStateChangedListenerIDL r7 = r4;
    L19:
        r12.unregisterAppStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowAppStateIDLStub", "unregisterAppStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowAppStateIDLStub", "unregisterAppStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppStateIDLStub", "unregisterAppStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L17;
        r7 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = ap.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }
}
