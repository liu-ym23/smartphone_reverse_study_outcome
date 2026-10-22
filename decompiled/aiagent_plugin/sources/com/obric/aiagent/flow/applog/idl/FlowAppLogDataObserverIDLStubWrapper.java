package com.obric.aiagent.flow.applog.idl;

import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogDataObserverIDLStubWrapper extends IFlowAppLogDataObserverIDL.Stub {
    boolean log;
    final IFlowAppLogDataObserverIDL.Stub origin;

    FlowAppLogDataObserverIDLStubWrapper(IFlowAppLogDataObserverIDL.Stub r2) {
        this(r2, true);
    }

    FlowAppLogDataObserverIDLStubWrapper(IFlowAppLogDataObserverIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onIdLoaded(String r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        g r4 = new g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        k.f18677a.b("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogDataObserverIDLStub", "onIdLoaded", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onIdLoaded(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogDataObserverIDLStub", "onIdLoaded = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogDataObserverIDLStub", "onIdLoaded(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogDataObserverIDLStub", "onIdLoaded", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
    public void onRemoteIdGet(boolean r24, String r25, String r26, String r27, String r28, String r29, String r30) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L23:
        e = e;
        String r14 = ", ";
        String r20 = "FlowAppLogDataObserverIDLStub";
        String r15 = "onRemoteIdGet(";
        String r21 = ")";
    L25:
        String r4 = r14;
        j.f18676a.a(r20, r15 + r24 + r14 + r25 + r14 + r26 + r14 + r27 + r14 + r28 + r14 + r29 + r4 + r30 + r21, e);
        g r1 = new g(e);
        long r6 = SystemClock.elapsedRealtimeNanos();
        long r0 = Math.max(0, r6 - r16) / 1000;
        k.f18677a.b("FlowAppLogDataObserverIDLStub", r15 + r24 + r4 + r25 + r4 + r26 + r4 + r27 + r4 + r28 + r4 + r29 + r4 + r30 + ") = fail", r1, r0);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogDataObserverIDLStub", "onRemoteIdGet", r1, r0, r6);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogDataObserverIDLStub", "onRemoteIdGet(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ", " + r30 + ")");     // Catch: Exception -> L23
    L6:
        r15 = "onRemoteIdGet(";
        r21 = ")";
        this.origin.onRemoteIdGet(r24, r25, r26, r27, r28, r29, r30);     // Catch: Exception -> L21
        if (this.log == false) goto L11;
        j.f18676a.c("FlowAppLogDataObserverIDLStub", "onRemoteIdGet = void");     // Catch: Exception -> L21
    L11:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L21
        long r5 = Math.max(0, r7 - r16) / 1000;     // Catch: Exception -> L21
        k.f18677a.b("FlowAppLogDataObserverIDLStub", r15 + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r29 + ", " + r30 + ") = void", r5);     // Catch: Exception -> L19
        r20 = "FlowAppLogDataObserverIDLStub";
        r14 = ", ";
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogDataObserverIDLStub", "onRemoteIdGet", r5, r7);     // Catch: Exception -> L17
        return;
    L17:
        e = e;
    L19:
        e = e;
        r20 = "FlowAppLogDataObserverIDLStub";
        r14 = ", ";
    L21:
        e = e;
        r20 = "FlowAppLogDataObserverIDLStub";
        r14 = ", ";
        goto L25
    }
}
