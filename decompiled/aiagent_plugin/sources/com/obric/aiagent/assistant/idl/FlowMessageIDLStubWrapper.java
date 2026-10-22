package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowMessageIDLStubWrapper extends IFlowMessageIDL.Stub {
    boolean log;
    final IFlowMessageIDL.Stub origin;

    FlowMessageIDLStubWrapper(IFlowMessageIDL.Stub r2) {
        this(r2, true);
    }

    FlowMessageIDLStubWrapper(IFlowMessageIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallback(IFlowMessageCallbackIDL r21) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "registerCallback(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerCallback(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerCallback", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "registerCallback(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowMessageCallbackIDL r7 = r4;
    L19:
        r12.registerCallback(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "registerCallback = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerCallback(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerCallback", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L17;
        r7 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = aj.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterCallback(IFlowMessageCallbackIDL r21) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "unregisterCallback(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterCallback(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterCallback", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "unregisterCallback(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowMessageCallbackIDL r7 = r4;
    L19:
        r12.unregisterCallback(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "unregisterCallback = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterCallback(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterCallback", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L17;
        r7 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = aj.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void appendMessageExt(String r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "appendMessageExt(" + r22 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "appendMessageExt(" + r22 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "appendMessageExt", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "appendMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.appendMessageExt(r22, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "appendMessageExt = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "appendMessageExt(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "appendMessageExt", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String generateLocalMessageId() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "generateLocalMessageId()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "generateLocalMessageId() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "generateLocalMessageId", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "generateLocalMessageId()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.generateLocalMessageId();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "generateLocalMessageId = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "generateLocalMessageId() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "generateLocalMessageId", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void addMessage(IMMessage r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "addMessage", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.addMessage(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "addMessage = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "addMessage", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteMessage(String r25, IFlowDeleteMessageCallbackIDL r26) {
        IFlowDeleteMessageCallbackIDL r6 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "deleteMessage(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "deleteMessage(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "deleteMessage", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "deleteMessage(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowDeleteMessageCallbackIDL r9 = r6;
    L19:
        r14.deleteMessage(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "deleteMessage = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "deleteMessage(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "deleteMessage", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowDeleteMessageCallbackIDL.Stub.class) == false) goto L17;
        r9 = y.a((IFlowDeleteMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowDeleteMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = y.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findMessagebyId(String r25, IFlowFindMessageCallbackIDL r26) {
        IFlowFindMessageCallbackIDL r6 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "findMessagebyId(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "findMessagebyId(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "findMessagebyId", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "findMessagebyId(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFindMessageCallbackIDL r9 = r6;
    L19:
        r14.findMessagebyId(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "findMessagebyId = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "findMessagebyId(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "findMessagebyId", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessageCallbackIDL.Stub.class) == false) goto L17;
        r9 = aa.a((IFlowFindMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = aa.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r21) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "registerSendMessageExtCallback(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerSendMessageExtCallback(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerSendMessageExtCallback", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "registerSendMessageExtCallback(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowSendMessageExtCallbackIDL r7 = r4;
    L19:
        r12.registerSendMessageExtCallback(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "registerSendMessageExtCallback = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerSendMessageExtCallback(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerSendMessageExtCallback", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L17;
        r7 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = as.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r21) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "unregisterSendMessageExtCallback(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterSendMessageExtCallback(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterSendMessageExtCallback", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "unregisterSendMessageExtCallback(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowSendMessageExtCallbackIDL r7 = r4;
    L19:
        r12.unregisterSendMessageExtCallback(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "unregisterSendMessageExtCallback = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterSendMessageExtCallback(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterSendMessageExtCallback", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L17;
        r7 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = as.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void imageXUpload(String r25, IImageXUploadCallbackIDL r26) {
        IImageXUploadCallbackIDL r6 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "imageXUpload(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "imageXUpload(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "imageXUpload", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "imageXUpload(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IImageXUploadCallbackIDL r9 = r6;
    L19:
        r14.imageXUpload(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "imageXUpload = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "imageXUpload(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "imageXUpload", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IImageXUploadCallbackIDL.Stub.class) == false) goto L17;
        r9 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ay.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEvent(String r25, String r26, Map r27, IFlowSemanticEditCallbackIDL r28) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r9 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r10 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r22 - r10) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ") = fail", r3, r11);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEvent", r3, r11, r22);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r9 != null) goto L10;
    L18:
        IFlowSemanticEditCallbackIDL r8 = r9;
    L19:
        r12.notifySemanticUserEditEvent(r25, r26, r7, r8);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "notifySemanticUserEditEvent = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ") = void", r13);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEvent", r13, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r9, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L17;
        r8 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r9, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r8 = ar.a(r9, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithIdentifier(String r30, String r31, String r32, Map r33, IFlowSemanticEditCallbackIDL r34) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r15 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r34, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L32:
        e = e;
        String r4 = r32;
        String r21 = ")";
    L34:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + r21, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier(" + r30 + ", " + r31 + ", " + r32 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L32
    L6:
        IFlowMessageIDL.Stub r2 = this.origin;     // Catch: Exception -> L32
        if (r15 != null) goto L10;
    L19:
        IFlowSemanticEditCallbackIDL r20 = r15;
    L20:
        r21 = ")";
        r2.notifySemanticUserEditEventWithIdentifier(r30, r31, r32, r14, r20);     // Catch: Exception -> L30
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier = void");     // Catch: Exception -> L30
    L24:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L30
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L30
        r4 = r32;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L28
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithIdentifier", r0, r27);     // Catch: Exception -> L28
        return;
    L28:
        e = e;
    L30:
        e = e;
        r4 = r32;
        r5 = 0;
        goto L34
    L10:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L17;
        IFlowSemanticEditCallbackIDL r3 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L32
    L18:
        r20 = r3;
        goto L20
    L17:
        r3 = ar.a(r15, true);     // Catch: Exception -> L32
        goto L18
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithUri(String r30, String r31, String r32, Map r33, IFlowSemanticEditCallbackIDL r34) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r15 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r34, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L32:
        e = e;
        String r4 = r32;
        String r21 = ")";
    L34:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + r21, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri(" + r30 + ", " + r31 + ", " + r32 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L32
    L6:
        IFlowMessageIDL.Stub r2 = this.origin;     // Catch: Exception -> L32
        if (r15 != null) goto L10;
    L19:
        IFlowSemanticEditCallbackIDL r20 = r15;
    L20:
        r21 = ")";
        r2.notifySemanticUserEditEventWithUri(r30, r31, r32, r14, r20);     // Catch: Exception -> L30
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri = void");     // Catch: Exception -> L30
    L24:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L30
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L30
        r4 = r32;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L28
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "notifySemanticUserEditEventWithUri", r0, r27);     // Catch: Exception -> L28
        return;
    L28:
        e = e;
    L30:
        e = e;
        r4 = r32;
        r5 = 0;
        goto L34
    L10:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L17;
        IFlowSemanticEditCallbackIDL r3 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L32
    L18:
        r20 = r3;
        goto L20
    L17:
        r3 = ar.a(r15, true);     // Catch: Exception -> L32
        goto L18
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessage(String r33, String r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "sendMessage", r5, r28, r30);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.sendMessage(r33, r34, r35, r36);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "sendMessage = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "sendMessage", r11, r22);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void isMessageLocalInterrupted(String r25, IFlowIsMessageInterruptedCallbackIDL r26) {
        IFlowIsMessageInterruptedCallbackIDL r6 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "isMessageLocalInterrupted", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowIsMessageInterruptedCallbackIDL r9 = r6;
    L19:
        r14.isMessageLocalInterrupted(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "isMessageLocalInterrupted = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "isMessageLocalInterrupted", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class) == false) goto L17;
        r9 = ah.a((IFlowIsMessageInterruptedCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ah.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteRemoteResource(List<String> r21) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "deleteRemoteResource(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "deleteRemoteResource(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "deleteRemoteResource", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "deleteRemoteResource(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.deleteRemoteResource(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "deleteRemoteResource = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "deleteRemoteResource(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "deleteRemoteResource", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void uploadImage(String r26, String r27, IImageXUploadCallbackIDL r28) {
        IImageXUploadCallbackIDL r7 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "uploadImage(" + r26 + ", " + r27 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "uploadImage(" + r26 + ", " + r27 + ", " + r7 + ") = fail", r3, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "uploadImage", r3, r8, r23);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "uploadImage(" + r26 + ", " + r27 + ", " + r7 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IImageXUploadCallbackIDL r10 = r7;
    L19:
        r11.uploadImage(r26, r27, r10);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "uploadImage = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "uploadImage(" + r26 + ", " + r27 + ", " + r7 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "uploadImage", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IImageXUploadCallbackIDL.Stub.class) == false) goto L17;
        r10 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r10 = ay.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerStreamObserver(IFlowStreamObserverIDL r21) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "registerStreamObserver(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerStreamObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerStreamObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "registerStreamObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowStreamObserverIDL r7 = r4;
    L19:
        r12.registerStreamObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "registerStreamObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerStreamObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerStreamObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L17;
        r7 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = au.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterStreamObserver(IFlowStreamObserverIDL r21) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "unregisterStreamObserver(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterStreamObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterStreamObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "unregisterStreamObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowStreamObserverIDL r7 = r4;
    L19:
        r12.unregisterStreamObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "unregisterStreamObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "unregisterStreamObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "unregisterStreamObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L17;
        r7 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = au.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public boolean isConversationTtsEnabled(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "isConversationTtsEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "isConversationTtsEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "isConversationTtsEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "isConversationTtsEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isConversationTtsEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "isConversationTtsEnabled = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "isConversationTtsEnabled(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "isConversationTtsEnabled", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessageWithExtra(String r29, String r30, String r31, String r32, Map r33) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L19:
        e = e;
        String r4 = r32;
        String r20 = ")";
    L21:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + r20, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "sendMessageWithExtra", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r15 + ")");     // Catch: Exception -> L19
    L6:
        r20 = ")";
        this.origin.sendMessageWithExtra(r29, r30, r31, r32, r15);     // Catch: Exception -> L17
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "sendMessageWithExtra = void");     // Catch: Exception -> L17
    L11:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L17
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L17
        r4 = r32;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L15
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "sendMessageWithExtra", r0, r27);     // Catch: Exception -> L15
        return;
    L15:
        e = e;
    L17:
        e = e;
        r4 = r32;
        r5 = 0;
        goto L21
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMessageExt(String r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "updateMessageExt(" + r22 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMessageExt(" + r22 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMessageExt", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "updateMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateMessageExt(r22, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "updateMessageExt = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMessageExt(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMessageExt", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void retryFetchMessage(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "retryFetchMessage(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "retryFetchMessage(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "retryFetchMessage", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "retryFetchMessage(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.retryFetchMessage(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "retryFetchMessage = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "retryFetchMessage(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "retryFetchMessage", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void refreshLatestMessages(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "refreshLatestMessages(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "refreshLatestMessages(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "refreshLatestMessages", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "refreshLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.refreshLatestMessages(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "refreshLatestMessages = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "refreshLatestMessages(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "refreshLatestMessages", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void fetchLatestMessages(int r25, IFlowFindMessagesCallbackIDL r26) {
        IFlowFindMessagesCallbackIDL r6 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "fetchLatestMessages(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "fetchLatestMessages(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "fetchLatestMessages", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "fetchLatestMessages(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFindMessagesCallbackIDL r9 = r6;
    L19:
        r14.fetchLatestMessages(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "fetchLatestMessages = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "fetchLatestMessages(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "fetchLatestMessages", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L17;
        r9 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ab.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void getMainTxtContentForMessage(String r25, IFlowMessageMainTextBlockCallbackIDL r26) {
        IFlowMessageMainTextBlockCallbackIDL r6 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "getMainTxtContentForMessage", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowMessageMainTextBlockCallbackIDL r9 = r6;
    L19:
        r14.getMainTxtContentForMessage(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "getMainTxtContentForMessage = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "getMainTxtContentForMessage", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class) == false) goto L17;
        r9 = al.a((IFlowMessageMainTextBlockCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = al.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String getMainTxtContentFromMessage(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "getMainTxtContentFromMessage(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "getMainTxtContentFromMessage(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "getMainTxtContentFromMessage", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "getMainTxtContentFromMessage(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        String r11 = this.origin.getMainTxtContentFromMessage(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "getMainTxtContentFromMessage = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "getMainTxtContentFromMessage(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "getMainTxtContentFromMessage", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findAnswersbyQueryId(String r25, IFlowFindMessagesCallbackIDL r26) {
        IFlowFindMessagesCallbackIDL r6 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "findAnswersbyQueryId(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "findAnswersbyQueryId(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "findAnswersbyQueryId", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "findAnswersbyQueryId(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFindMessagesCallbackIDL r9 = r6;
    L19:
        r14.findAnswersbyQueryId(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "findAnswersbyQueryId = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "findAnswersbyQueryId(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "findAnswersbyQueryId", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L17;
        r9 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ab.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableMessageContent(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "updateMutableMessageContent(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMutableMessageContent", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "updateMutableMessageContent(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateMutableMessageContent(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "updateMutableMessageContent = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMutableMessageContent", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r25, int r26) {
        IFlowMessageCallbackIDL r6 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "registerCallbackWithEvents(" + r6 + ", " + r26 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerCallbackWithEvents(" + r6 + ", " + r26 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerCallbackWithEvents", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "registerCallbackWithEvents(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L24
    L6:
        IFlowMessageIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowMessageCallbackIDL r9 = r6;
    L19:
        r14.registerCallbackWithEvents(r9, r26);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "registerCallbackWithEvents = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "registerCallbackWithEvents(" + r6 + ", " + r26 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "registerCallbackWithEvents", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageCallbackIDL.Stub.class) == false) goto L17;
        r9 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = aj.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableWidgetRenderData(String r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowMessageIDLStub", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMutableWidgetRenderData", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowMessageIDLStub", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateMutableWidgetRenderData(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowMessageIDLStub", "updateMutableWidgetRenderData = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowMessageIDLStub", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowMessageIDLStub", "updateMutableWidgetRenderData", r14, r21);     // Catch: Exception -> L11
    }
}
