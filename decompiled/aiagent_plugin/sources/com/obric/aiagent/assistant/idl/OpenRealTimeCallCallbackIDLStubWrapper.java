package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class OpenRealTimeCallCallbackIDLStubWrapper extends IOpenRealTimeCallCallbackIDL.Stub {
    boolean log;
    final IOpenRealTimeCallCallbackIDL.Stub origin;

    OpenRealTimeCallCallbackIDLStubWrapper(IOpenRealTimeCallCallbackIDL.Stub r2) {
        this(r2, true);
    }

    OpenRealTimeCallCallbackIDLStubWrapper(IOpenRealTimeCallCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResult(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("OpenRealTimeCallCallbackIDLStub", "onResult(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("OpenRealTimeCallCallbackIDLStub", "onResult(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("OpenRealTimeCallCallbackIDLStub", "onResult", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("OpenRealTimeCallCallbackIDLStub", "onResult(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("OpenRealTimeCallCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("OpenRealTimeCallCallbackIDLStub", "onResult(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("OpenRealTimeCallCallbackIDLStub", "onResult", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResultWithMsg(int r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResultWithMsg(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg", r13, r110);     // Catch: Exception -> L11
    }
}
