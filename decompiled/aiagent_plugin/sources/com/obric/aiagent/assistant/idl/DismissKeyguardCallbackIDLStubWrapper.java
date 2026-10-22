package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class DismissKeyguardCallbackIDLStubWrapper extends IDismissKeyguardCallbackIDL.Stub {
    boolean log;
    final IDismissKeyguardCallbackIDL.Stub origin;

    DismissKeyguardCallbackIDLStubWrapper(IDismissKeyguardCallbackIDL.Stub r2) {
        this(r2, true);
    }

    DismissKeyguardCallbackIDLStubWrapper(IDismissKeyguardCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL
    public void onResult(boolean r22, boolean r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("DismissKeyguardCallbackIDLStub", "onResult(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("DismissKeyguardCallbackIDLStub", "onResult(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("DismissKeyguardCallbackIDLStub", "onResult", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("DismissKeyguardCallbackIDLStub", "onResult(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("DismissKeyguardCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("DismissKeyguardCallbackIDLStub", "onResult(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("DismissKeyguardCallbackIDLStub", "onResult", r13, r110);     // Catch: Exception -> L11
    }
}
