package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class DowngradeAuthForDoraCallbackIDLStubWrapper extends IDowngradeAuthForDoraCallbackIDL.Stub {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL.Stub origin;

    DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r2) {
        this(r2, true);
    }

    DowngradeAuthForDoraCallbackIDLStubWrapper(IDowngradeAuthForDoraCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade()");     // Catch: Exception -> L11
    L6:
        this.origin.onNotDowngrade();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onNotDowngrade", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToNoneAuth", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint()");     // Catch: Exception -> L11
    L6:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("DowngradeAuthForDoraCallbackIDLStub", "onDowngradeToVoicePrint", r13, r15);     // Catch: Exception -> L11
    }
}
