package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class ImageXUploadCallbackIDLStubWrapper extends IImageXUploadCallbackIDL.Stub {
    boolean log;
    final IImageXUploadCallbackIDL.Stub origin;

    ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r2) {
        this(r2, true);
    }

    ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r29, String r30, String r31, String r32, String r33) {
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L19:
        e = e;
        String r4 = r33;
        String r20 = ")";
    L21:
        com.obric.aiagent.ipc.utils.j.f18676a.a("ImageXUploadCallbackIDLStub", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + r20, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("ImageXUploadCallbackIDLStub", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("ImageXUploadCallbackIDLStub", "onResult", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("ImageXUploadCallbackIDLStub", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L19
    L6:
        r20 = ")";
        this.origin.onResult(r29, r30, r31, r32, r33);     // Catch: Exception -> L17
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.j.f18676a.c("ImageXUploadCallbackIDLStub", "onResult = void");     // Catch: Exception -> L17
    L11:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L17
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L17
        r4 = r33;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("ImageXUploadCallbackIDLStub", "onResult(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L15
        com.obric.aiagent.ipc.utils.d.f18654a.b("ImageXUploadCallbackIDLStub", "onResult", r0, r27);     // Catch: Exception -> L15
        return;
    L15:
        e = e;
    L17:
        e = e;
        r4 = r33;
        r5 = 0;
        goto L21
    }
}
