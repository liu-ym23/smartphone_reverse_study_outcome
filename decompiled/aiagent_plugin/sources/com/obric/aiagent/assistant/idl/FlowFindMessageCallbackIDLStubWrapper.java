package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;

/* JADX INFO: loaded from: classes2.dex */
class FlowFindMessageCallbackIDLStubWrapper extends IFlowFindMessageCallbackIDL.Stub {
    boolean log;
    final IFlowFindMessageCallbackIDL.Stub origin;

    FlowFindMessageCallbackIDLStubWrapper(IFlowFindMessageCallbackIDL.Stub r2) {
        this(r2, true);
    }

    FlowFindMessageCallbackIDLStubWrapper(IFlowFindMessageCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onSuccess(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFindMessageCallbackIDLStub", "onSuccess(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessageCallbackIDLStub", "onSuccess(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessageCallbackIDLStub", "onSuccess", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFindMessageCallbackIDLStub", "onSuccess(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFindMessageCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessageCallbackIDLStub", "onSuccess(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessageCallbackIDLStub", "onSuccess", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onFail() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFindMessageCallbackIDLStub", "onFail()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessageCallbackIDLStub", "onFail() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessageCallbackIDLStub", "onFail", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFindMessageCallbackIDLStub", "onFail()");     // Catch: Exception -> L11
    L6:
        this.origin.onFail();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFindMessageCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessageCallbackIDLStub", "onFail() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessageCallbackIDLStub", "onFail", r13, r15);     // Catch: Exception -> L11
    }
}
