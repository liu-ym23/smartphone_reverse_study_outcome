package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppStateIDLIpcWrapper implements IFlowAppStateIDL {
    boolean log;
    final IFlowAppStateIDL origin;

    FlowAppStateIDLIpcWrapper(IFlowAppStateIDL r3) {
        this((IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppStateIDLIpcWrapper(IFlowAppStateIDL r3, boolean r4) {
        this.origin = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppBackground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppBackground()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "isAppBackground() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "isAppBackground", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAppBackground();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppStateIDLIPC", "isAppBackground = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "isAppBackground() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "isAppBackground", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public boolean isAppPaused() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppPaused()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "isAppPaused() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "isAppPaused", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppPaused()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "isAppPaused()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAppPaused();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppStateIDLIPC", "isAppPaused = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "isAppPaused() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "isAppPaused", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public String getCurrentActivity() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "getCurrentActivity()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "getCurrentActivity() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "getCurrentActivity", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "getCurrentActivity()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "getCurrentActivity()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getCurrentActivity();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppStateIDLIPC", "getCurrentActivity = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "getCurrentActivity() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "getCurrentActivity", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r21) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "registerAppStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerAppStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowOnAppStateChangedListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAppStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L19;
        r15 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ap.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowOnAppStateChangedListenerIDL r7 = r4;
    L35:
        r13.registerAppStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppStateIDLIPC", "registerAppStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "registerAppStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "registerAppStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L33;
        r7 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = ap.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r21) {
        IFlowOnAppStateChangedListenerIDL r4 = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterAppStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowOnAppStateChangedListenerIDL r15 = r4;
    L21:
        r12.a("IFlowAppStateIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L19;
        r15 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ap.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppStateIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowOnAppStateChangedListenerIDL r7 = r4;
    L35:
        r13.unregisterAppStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppStateIDLIPC", "unregisterAppStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppStateIDLIPC", "unregisterAppStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowOnAppStateChangedListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowOnAppStateChangedListenerIDL.Stub.class) == false) goto L33;
        r7 = ap.a((IFlowOnAppStateChangedListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowOnAppStateChangedListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = ap.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
