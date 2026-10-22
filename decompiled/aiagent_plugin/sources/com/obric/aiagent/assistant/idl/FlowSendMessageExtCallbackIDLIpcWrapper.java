package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowSendMessageExtCallbackIDLIpcWrapper implements IFlowSendMessageExtCallbackIDL {
    boolean log;
    final IFlowSendMessageExtCallbackIDL origin;

    FlowSendMessageExtCallbackIDLIpcWrapper(IFlowSendMessageExtCallbackIDL r3) {
        this((IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowSendMessageExtCallbackIDLIpcWrapper(IFlowSendMessageExtCallbackIDL r3, boolean r4) {
        this.origin = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public String getScene() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getScene();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSendMessageExtCallbackIDLIPC", "getScene = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSendMessageExtCallbackIDLIPC", "getScene", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public Map getExt(Map r23, String r24) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
        Map r13 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt(" + r6 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt(" + r6 + ", " + r24 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt", r2, r8, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt(" + r6 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt(" + r6 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.getExt(r6, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowSendMessageExtCallbackIDLIPC", "getExt = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt(" + r6 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowSendMessageExtCallbackIDLIPC", "getExt", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
