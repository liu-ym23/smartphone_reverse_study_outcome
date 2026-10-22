package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FlowFindMessagesCallbackIDLStubWrapper extends IFlowFindMessagesCallbackIDL.Stub {
    boolean log;
    final IFlowFindMessagesCallbackIDL.Stub origin;

    FlowFindMessagesCallbackIDLStubWrapper(IFlowFindMessagesCallbackIDL.Stub r2) {
        this(r2, true);
    }

    FlowFindMessagesCallbackIDLStubWrapper(IFlowFindMessagesCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onSuccess(List<IMMessage> r21) {
        List<IMMessage> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFindMessagesCallbackIDLStub", "onSuccess(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessagesCallbackIDLStub", "onSuccess(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessagesCallbackIDLStub", "onSuccess", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFindMessagesCallbackIDLStub", "onSuccess(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFindMessagesCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessagesCallbackIDLStub", "onSuccess(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessagesCallbackIDLStub", "onSuccess", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL
    public void onFail() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFindMessagesCallbackIDLStub", "onFail()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessagesCallbackIDLStub", "onFail() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessagesCallbackIDLStub", "onFail", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFindMessagesCallbackIDLStub", "onFail()");     // Catch: Exception -> L11
    L6:
        this.origin.onFail();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFindMessagesCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFindMessagesCallbackIDLStub", "onFail() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFindMessagesCallbackIDLStub", "onFail", r13, r15);     // Catch: Exception -> L11
    }
}
