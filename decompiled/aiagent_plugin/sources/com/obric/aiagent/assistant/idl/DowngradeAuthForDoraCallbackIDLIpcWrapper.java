package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class DowngradeAuthForDoraCallbackIDLIpcWrapper implements IDowngradeAuthForDoraCallbackIDL {
    boolean log;
    final IDowngradeAuthForDoraCallbackIDL origin;

    DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r3) {
        this((IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    DowngradeAuthForDoraCallbackIDLIpcWrapper(IDowngradeAuthForDoraCallbackIDL r3, boolean r4) {
        this.origin = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onNotDowngrade();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onNotDowngrade", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToNoneAuth();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToNoneAuth", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onDowngradeToVoicePrint();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IDowngradeAuthForDoraCallbackIDLIPC", "onDowngradeToVoicePrint", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
