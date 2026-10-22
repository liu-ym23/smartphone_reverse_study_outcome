package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class ImageXUploadCallbackIDLIpcWrapper implements IImageXUploadCallbackIDL {
    boolean log;
    final IImageXUploadCallbackIDL origin;

    ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r3) {
        this((IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r3, boolean r4) {
        this.origin = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r29, String r30, String r31, String r32, String r33) {
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L22:
        e = e;
        String r4 = r33;
        String r20 = ")";
    L24:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IImageXUploadCallbackIDLIPC", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + r20, e);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L26
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L26
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.k.f18677a.a("IImageXUploadCallbackIDLIPC", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + ") = fail", r1, r24);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IImageXUploadCallbackIDLIPC", "onResult", r1, r24, r26);     // Catch: Throwable -> L26
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IImageXUploadCallbackIDLIPC", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IImageXUploadCallbackIDLIPC", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L9:
        r20 = ")";
        this.origin.onResult(r29, r30, r31, r32, r33);     // Catch: Exception -> L20 Throwable -> L26
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IImageXUploadCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L20 Throwable -> L26
    L14:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L20 Throwable -> L26
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L20 Throwable -> L26
        r4 = r33;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IImageXUploadCallbackIDLIPC", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L18 Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IImageXUploadCallbackIDLIPC", "onResult", r0, r27);     // Catch: Exception -> L18 Throwable -> L26
        return;
    L18:
        e = e;
    L20:
        e = e;
        r4 = r33;
        r5 = 0;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
