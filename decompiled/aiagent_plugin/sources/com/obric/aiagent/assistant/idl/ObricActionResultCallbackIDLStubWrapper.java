package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class ObricActionResultCallbackIDLStubWrapper extends IObricActionResultCallbackIDL.Stub {
    boolean log;
    final IObricActionResultCallbackIDL.Stub origin;

    ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r2) {
        this(r2, true);
    }

    ObricActionResultCallbackIDLStubWrapper(IObricActionResultCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL
    public void onResult(boolean r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("ObricActionResultCallbackIDLStub", "onResult", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("ObricActionResultCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("ObricActionResultCallbackIDLStub", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("ObricActionResultCallbackIDLStub", "onResult", r14, r21);     // Catch: Exception -> L11
    }
}
