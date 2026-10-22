package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class MusicStateListenerIDLIpcWrapper implements IMusicStateListenerIDL {
    boolean log;
    final IMusicStateListenerIDL origin;

    MusicStateListenerIDLIpcWrapper(IMusicStateListenerIDL r3) {
        this((IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin"), true);
    }

    MusicStateListenerIDLIpcWrapper(IMusicStateListenerIDL r3, boolean r4) {
        this.origin = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(Bundle r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onMusicStateChanged(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IMusicStateListenerIDLIPC", "onMusicStateChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IMusicStateListenerIDLIPC", "onMusicStateChanged", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
