package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class FlowOnAppStateChangedListenerIDLStubWrapper extends IFlowOnAppStateChangedListenerIDL.Stub {
    boolean log;
    final IFlowOnAppStateChangedListenerIDL.Stub origin;

    FlowOnAppStateChangedListenerIDLStubWrapper(IFlowOnAppStateChangedListenerIDL.Stub r2) {
        this(r2, true);
    }

    FlowOnAppStateChangedListenerIDLStubWrapper(IFlowOnAppStateChangedListenerIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppBackground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowOnAppStateChangedListenerIDLStub", "onAppBackground()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground()");     // Catch: Exception -> L11
    L6:
        this.origin.onAppBackground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowOnAppStateChangedListenerIDLStub", "onAppBackground = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAppBackground", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppForeground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowOnAppStateChangedListenerIDLStub", "onAppForeground()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground()");     // Catch: Exception -> L11
    L6:
        this.origin.onAppForeground();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowOnAppStateChangedListenerIDLStub", "onAppForeground = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAppForeground", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAllActivityDestroyed() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed()");     // Catch: Exception -> L11
    L6:
        this.origin.onAllActivityDestroyed();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onAllActivityDestroyed", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onMainBotChatPageResume(boolean r22, boolean r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onMainBotChatPageResume(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowOnAppStateChangedListenerIDLStub", "onMainBotChatPageResume", r13, r110);     // Catch: Exception -> L11
    }
}
