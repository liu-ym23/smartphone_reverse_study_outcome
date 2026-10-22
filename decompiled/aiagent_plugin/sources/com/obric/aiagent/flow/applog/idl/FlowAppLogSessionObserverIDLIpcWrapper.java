package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogSessionObserverIDLIpcWrapper implements IFlowAppLogSessionObserverIDL {
    boolean log;
    final IFlowAppLogSessionObserverIDL origin;

    FlowAppLogSessionObserverIDLIpcWrapper(IFlowAppLogSessionObserverIDL r3) {
        this((IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppLogSessionObserverIDLIpcWrapper(IFlowAppLogSessionObserverIDL r3, boolean r4) {
        this.origin = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        g r4 = new g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ") = fail", r4, r7);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart", r4, r7, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionStart(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionStart = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        g r4 = new g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ") = fail", r4, r7);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate", r4, r7, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionTerminate(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        g r4 = new g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = fail", r4, r7);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent", r4, r7, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionBatchEvent(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
