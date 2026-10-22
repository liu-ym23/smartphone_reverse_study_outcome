package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogDataObserverIDLIpcWrapper implements IFlowAppLogDataObserverIDL {
    boolean log;
    final IFlowAppLogDataObserverIDL origin;

    FlowAppLogDataObserverIDLIpcWrapper(IFlowAppLogDataObserverIDL r3) {
        this((IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppLogDataObserverIDLIpcWrapper(IFlowAppLogDataObserverIDL r3, boolean r4) {
        this.origin = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onIdLoaded(String r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        g r4 = new g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onIdLoaded(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogDataObserverIDLIPC", "onIdLoaded = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogDataObserverIDLIPC", "onIdLoaded", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onRemoteIdGet(boolean r24, String r25, String r26, String r27, String r28, String r29, String r30) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r14 = ", ";
        String r20 = "IFlowAppLogDataObserverIDLIPC";
        String r15 = "onRemoteIdGet(";
        String r21 = ")";
    L28:
        String r4 = r14;
        j.f18676a.a(r20, r15 + r24 + r14 + r25 + r14 + r26 + r14 + r27 + r14 + r28 + r14 + r29 + r4 + r30 + r21, e);     // Catch: Throwable -> L30
        g r1 = new g(e);     // Catch: Throwable -> L30
        long r6 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r0 = Math.max(0, r6 - r16) / 1000;     // Catch: Throwable -> L30
        k.f18677a.a("IFlowAppLogDataObserverIDLIPC", r15 + r24 + r4 + r25 + r4 + r26 + r4 + r27 + r4 + r28 + r4 + r29 + r4 + r30 + ") = fail", r1, r0);     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet", r1, r0, r6);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ", " + r30 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ", " + r30 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r15 = "onRemoteIdGet(";
        r21 = ")";
        this.origin.onRemoteIdGet(r24, r25, r26, r27, r28, r29, r30);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        j.f18676a.c("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r5 = Math.max(0, r7 - r16) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        k.f18677a.a("IFlowAppLogDataObserverIDLIPC", r15 + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ", " + r30 + ") = void", r5);     // Catch: Exception -> L22 Throwable -> L30
        r20 = "IFlowAppLogDataObserverIDLIPC";
        r14 = ", ";
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogDataObserverIDLIPC", "onRemoteIdGet", r5, r7);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r20 = "IFlowAppLogDataObserverIDLIPC";
        r14 = ", ";
    L24:
        e = e;
        r20 = "IFlowAppLogDataObserverIDLIPC";
        r14 = ", ";
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
