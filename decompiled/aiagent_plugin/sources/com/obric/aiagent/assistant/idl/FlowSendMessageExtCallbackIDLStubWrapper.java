package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowSendMessageExtCallbackIDLStubWrapper extends IFlowSendMessageExtCallbackIDL.Stub {
    boolean log;
    final IFlowSendMessageExtCallbackIDL.Stub origin;

    FlowSendMessageExtCallbackIDLStubWrapper(IFlowSendMessageExtCallbackIDL.Stub r2) {
        this(r2, true);
    }

    FlowSendMessageExtCallbackIDLStubWrapper(IFlowSendMessageExtCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public String getScene() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSendMessageExtCallbackIDLStub", "getScene()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSendMessageExtCallbackIDLStub", "getScene() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSendMessageExtCallbackIDLStub", "getScene", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSendMessageExtCallbackIDLStub", "getScene()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getScene();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSendMessageExtCallbackIDLStub", "getScene = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSendMessageExtCallbackIDLStub", "getScene() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSendMessageExtCallbackIDLStub", "getScene", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL
    public Map getExt(Map r23, String r24) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSendMessageExtCallbackIDLStub", "getExt(" + r6 + ", " + r24 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSendMessageExtCallbackIDLStub", "getExt(" + r6 + ", " + r24 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSendMessageExtCallbackIDLStub", "getExt", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSendMessageExtCallbackIDLStub", "getExt(" + r6 + ", " + r24 + ")");     // Catch: Exception -> L11
    L6:
        Map r13 = this.origin.getExt(r6, r24);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSendMessageExtCallbackIDLStub", "getExt = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSendMessageExtCallbackIDLStub", "getExt(" + r6 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSendMessageExtCallbackIDLStub", "getExt", r14, r20);     // Catch: Exception -> L11
        return r13;
    }
}
