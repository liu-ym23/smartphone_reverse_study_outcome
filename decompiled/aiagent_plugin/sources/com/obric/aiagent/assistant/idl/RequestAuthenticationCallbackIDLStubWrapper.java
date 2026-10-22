package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class RequestAuthenticationCallbackIDLStubWrapper extends IRequestAuthenticationCallbackIDL.Stub {
    boolean log;
    final IRequestAuthenticationCallbackIDL.Stub origin;

    RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r2) {
        this(r2, true);
    }

    RequestAuthenticationCallbackIDLStubWrapper(IRequestAuthenticationCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationPass() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationPass();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationPass", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationTimeout() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationTimeout();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationTimeout", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationFailed() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationFailed();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationFailed", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationNotAvailable() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationNotAvailable();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationNotAvailable", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationCancelled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled()");     // Catch: Exception -> L11
    L6:
        this.origin.onAuthenticationCancelled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("RequestAuthenticationCallbackIDLStub", "onAuthenticationCancelled", r13, r15);     // Catch: Exception -> L11
    }
}
