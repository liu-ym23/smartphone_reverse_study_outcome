package com.obric.aiagent.flow.applog.idl;

import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogSessionObserverIDLStubWrapper extends IFlowAppLogSessionObserverIDL.Stub {
    boolean log;
    final IFlowAppLogSessionObserverIDL.Stub origin;

    FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r2) {
        this(r2, true);
    }

    FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ")", e);
        g r4 = new g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r20 - r8) / 1000;
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ") = fail", r4, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionStart", r4, r7, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionStart(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogSessionObserverIDLStub", "onSessionStart = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionStart", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ")", e);
        g r4 = new g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r20 - r8) / 1000;
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ") = fail", r4, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r4, r7, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionTerminate(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogSessionObserverIDLStub", "onSessionTerminate = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ")", e);
        g r4 = new g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r20 - r8) / 1000;
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = fail", r4, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r4, r7, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionBatchEvent(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r14, r21);     // Catch: Exception -> L11
    }
}
