package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;

/* JADX INFO: loaded from: classes2.dex */
class FlowStreamObserverIDLStubWrapper extends IFlowStreamObserverIDL.Stub {
    boolean log;
    final IFlowStreamObserverIDL.Stub origin;

    FlowStreamObserverIDLStubWrapper(IFlowStreamObserverIDL.Stub r2) {
        this(r2, true);
    }

    FlowStreamObserverIDLStubWrapper(IFlowStreamObserverIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamBegin(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowStreamObserverIDLStub", "onStreamBegin(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowStreamObserverIDLStub", "onStreamBegin(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowStreamObserverIDLStub", "onStreamBegin", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowStreamObserverIDLStub", "onStreamBegin(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onStreamBegin(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowStreamObserverIDLStub", "onStreamBegin = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowStreamObserverIDLStub", "onStreamBegin(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowStreamObserverIDLStub", "onStreamBegin", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamEnd(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowStreamObserverIDLStub", "onStreamEnd(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowStreamObserverIDLStub", "onStreamEnd(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowStreamObserverIDLStub", "onStreamEnd", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowStreamObserverIDLStub", "onStreamEnd(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onStreamEnd(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowStreamObserverIDLStub", "onStreamEnd = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowStreamObserverIDLStub", "onStreamEnd(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowStreamObserverIDLStub", "onStreamEnd", r14, r17);     // Catch: Exception -> L11
    }
}
