package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class EntityDeleteCallbackIDLIpcWrapper implements IEntityDeleteCallbackIDL {
    boolean log;
    final IEntityDeleteCallbackIDL origin;

    EntityDeleteCallbackIDLIpcWrapper(IEntityDeleteCallbackIDL r3) {
        this((IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    EntityDeleteCallbackIDLIpcWrapper(IEntityDeleteCallbackIDL r3, boolean r4) {
        this.origin = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL
    public void onResult(int r23, String r24, String[] r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IEntityDeleteCallbackIDLIPC", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IEntityDeleteCallbackIDLIPC", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IEntityDeleteCallbackIDLIPC", "onResult", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IEntityDeleteCallbackIDLIPC", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IEntityDeleteCallbackIDLIPC", "onResult(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IEntityDeleteCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IEntityDeleteCallbackIDLIPC", "onResult(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IEntityDeleteCallbackIDLIPC", "onResult", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
