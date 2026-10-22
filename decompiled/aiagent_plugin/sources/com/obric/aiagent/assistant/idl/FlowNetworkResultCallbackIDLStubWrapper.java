package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowNetworkResultCallbackIDLStubWrapper extends IFlowNetworkResultCallbackIDL.Stub {
    boolean log;
    final IFlowNetworkResultCallbackIDL.Stub origin;

    FlowNetworkResultCallbackIDLStubWrapper(IFlowNetworkResultCallbackIDL.Stub r2) {
        this(r2, true);
    }

    FlowNetworkResultCallbackIDLStubWrapper(IFlowNetworkResultCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL
    public void onResult(boolean r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkResultCallbackIDLStub", "onResult(" + r22 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkResultCallbackIDLStub", "onResult(" + r22 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkResultCallbackIDLStub", "onResult", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkResultCallbackIDLStub", "onResult(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r22, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkResultCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkResultCallbackIDLStub", "onResult(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkResultCallbackIDLStub", "onResult", r13, r110);     // Catch: Exception -> L11
    }
}
