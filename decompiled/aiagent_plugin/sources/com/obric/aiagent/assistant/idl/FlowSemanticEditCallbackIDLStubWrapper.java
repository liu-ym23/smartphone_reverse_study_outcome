package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class FlowSemanticEditCallbackIDLStubWrapper extends IFlowSemanticEditCallbackIDL.Stub {
    boolean log;
    final IFlowSemanticEditCallbackIDL.Stub origin;

    FlowSemanticEditCallbackIDLStubWrapper(IFlowSemanticEditCallbackIDL.Stub r2) {
        this(r2, true);
    }

    FlowSemanticEditCallbackIDLStubWrapper(IFlowSemanticEditCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onSuccess() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSemanticEditCallbackIDLStub", "onSuccess()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSemanticEditCallbackIDLStub", "onSuccess() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSemanticEditCallbackIDLStub", "onSuccess", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSemanticEditCallbackIDLStub", "onSuccess()");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSemanticEditCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSemanticEditCallbackIDLStub", "onSuccess() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSemanticEditCallbackIDLStub", "onSuccess", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onFail(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowSemanticEditCallbackIDLStub", "onFail(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSemanticEditCallbackIDLStub", "onFail(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSemanticEditCallbackIDLStub", "onFail", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowSemanticEditCallbackIDLStub", "onFail(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onFail(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowSemanticEditCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowSemanticEditCallbackIDLStub", "onFail(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowSemanticEditCallbackIDLStub", "onFail", r14, r17);     // Catch: Exception -> L11
    }
}
