package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class ScreenshotCallbackIDLIpcWrapper implements IScreenshotCallbackIDL {
    boolean log;
    final IScreenshotCallbackIDL origin;

    ScreenshotCallbackIDLIpcWrapper(IScreenshotCallbackIDL r3) {
        this((IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    ScreenshotCallbackIDLIpcWrapper(IScreenshotCallbackIDL r3, boolean r4) {
        this.origin = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshot(Bitmap r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onReceivedScreenshot(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IScreenshotCallbackIDLIPC", "onReceivedScreenshot = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshot", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshotUri(Uri r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onReceivedScreenshotUri(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onReceivedScreenshotUri", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onError(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onError(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onError(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onError", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onError(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IScreenshotCallbackIDLIPC", "onError(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onError(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IScreenshotCallbackIDLIPC", "onError = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IScreenshotCallbackIDLIPC", "onError(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IScreenshotCallbackIDLIPC", "onError", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
