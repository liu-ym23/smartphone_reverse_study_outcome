package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowMessageIDLIpcWrapper implements IFlowMessageIDL {
    boolean log;
    final IFlowMessageIDL origin;

    FlowMessageIDLIpcWrapper(IFlowMessageIDL r3) {
        this((IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowMessageIDLIpcWrapper(IFlowMessageIDL r3, boolean r4) {
        this.origin = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallback(IFlowMessageCallbackIDL r21) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerCallback(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerCallback(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerCallback", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerCallback(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L19;
        r15 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = aj.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r7 = r4;
    L35:
        r13.registerCallback(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "registerCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerCallback(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerCallback", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L33;
        r7 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = aj.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterCallback(IFlowMessageCallbackIDL r21) {
        IFlowMessageCallbackIDL r4 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterCallback(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterCallback(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterCallback", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterCallback(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L19;
        r15 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = aj.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r7 = r4;
    L35:
        r13.unregisterCallback(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "unregisterCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterCallback(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterCallback", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowMessageCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowMessageCallbackIDL.Stub.class) == false) goto L33;
        r7 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = aj.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void appendMessageExt(String r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r6 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r6 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "appendMessageExt", r2, r8, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.appendMessageExt(r22, r6);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "appendMessageExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "appendMessageExt(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "appendMessageExt", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String generateLocalMessageId() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "generateLocalMessageId()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "generateLocalMessageId() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "generateLocalMessageId", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "generateLocalMessageId()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "generateLocalMessageId()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.generateLocalMessageId();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "generateLocalMessageId = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "generateLocalMessageId() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "generateLocalMessageId", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void addMessage(IMMessage r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "addMessage", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.addMessage(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "addMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "addMessage(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "addMessage", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteMessage(String r25, IFlowDeleteMessageCallbackIDL r26) {
        IFlowDeleteMessageCallbackIDL r6 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "deleteMessage(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "deleteMessage(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "deleteMessage", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "deleteMessage(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("deleteMessage(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowDeleteMessageCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowDeleteMessageCallbackIDL.Stub.class) == false) goto L19;
        r11 = y.a((IFlowDeleteMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowDeleteMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = y.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowDeleteMessageCallbackIDL r9 = r6;
    L35:
        r12.deleteMessage(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "deleteMessage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "deleteMessage(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "deleteMessage", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowDeleteMessageCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowDeleteMessageCallbackIDL.Stub.class) == false) goto L33;
        r9 = y.a((IFlowDeleteMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowDeleteMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = y.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findMessagebyId(String r25, IFlowFindMessageCallbackIDL r26) {
        IFlowFindMessageCallbackIDL r6 = (IFlowFindMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "findMessagebyId(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "findMessagebyId(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "findMessagebyId", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "findMessagebyId(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("findMessagebyId(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFindMessageCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessageCallbackIDL.Stub.class) == false) goto L19;
        r11 = aa.a((IFlowFindMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = aa.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFindMessageCallbackIDL r9 = r6;
    L35:
        r12.findMessagebyId(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "findMessagebyId = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "findMessagebyId(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "findMessagebyId", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessageCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessageCallbackIDL.Stub.class) == false) goto L33;
        r9 = aa.a((IFlowFindMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = aa.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r21) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerSendMessageExtCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowSendMessageExtCallbackIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L19;
        r15 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = as.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowSendMessageExtCallbackIDL r7 = r4;
    L35:
        r13.registerSendMessageExtCallback(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "registerSendMessageExtCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerSendMessageExtCallback", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L33;
        r7 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = as.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r21) {
        IFlowSendMessageExtCallbackIDL r4 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterSendMessageExtCallback(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowSendMessageExtCallbackIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L19;
        r15 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = as.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowSendMessageExtCallbackIDL r7 = r4;
    L35:
        r13.unregisterSendMessageExtCallback(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterSendMessageExtCallback", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowSendMessageExtCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowSendMessageExtCallbackIDL.Stub.class) == false) goto L33;
        r7 = as.a((IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = as.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void imageXUpload(String r25, IImageXUploadCallbackIDL r26) {
        IImageXUploadCallbackIDL r6 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "imageXUpload(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "imageXUpload(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "imageXUpload", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "imageXUpload(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("imageXUpload(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IImageXUploadCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IImageXUploadCallbackIDL.Stub.class) == false) goto L19;
        r11 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ay.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IImageXUploadCallbackIDL r9 = r6;
    L35:
        r12.imageXUpload(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "imageXUpload = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "imageXUpload(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "imageXUpload", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IImageXUploadCallbackIDL.Stub.class) == false) goto L33;
        r9 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ay.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEvent(String r25, String r26, Map r27, IFlowSemanticEditCallbackIDL r28) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r9 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r10 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r11 = Math.max(0, r22 - r10) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ") = fail", r3, r11);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent", r3, r11, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("notifySemanticUserEditEvent(").append(r25).append(", ").append(r26).append(", ").append(r7).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r9 != null) goto L12;
    L20:
        IFlowSemanticEditCallbackIDL r15 = r9;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r9, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L19;
        r15 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r9, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = ar.a(r9, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r9 != null) goto L26;
    L34:
        IFlowSemanticEditCallbackIDL r8 = r9;
    L35:
        r13.notifySemanticUserEditEvent(r25, r26, r7, r8);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEvent = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent(" + r25 + ", " + r26 + ", " + r7 + ", " + r9 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEvent", r16, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r9, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r9, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L33;
        r8 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r9, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r8 = ar.a(r9, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithIdentifier(String r29, String r30, String r31, Map r32, IFlowSemanticEditCallbackIDL r33) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r15 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L48:
        e = e;
        String r4 = r31;
        String r20 = ")";
        long r5 = 0;
    L50:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + r20, e);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L52
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L52
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier", r1, r24, r26);     // Catch: Throwable -> L52
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier(" + r29 + ", " + r30 + ", " + r31 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L48 Throwable -> L52
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L48 Throwable -> L52
        StringBuilder r6 = new StringBuilder().append("notifySemanticUserEditEventWithIdentifier(").append(r29).append(", ").append(r30).append(", ").append(r31).append(", ").append(r14).append(", ");     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L12;
    L20:
        IFlowSemanticEditCallbackIDL r7 = r15;
    L21:
        r2.a("IFlowMessageIDLIPC", r6.append(r7).append(")").toString());     // Catch: Exception -> L48 Throwable -> L52
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L19;
        r7 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
        goto L21
    L19:
        r7 = ar.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    L22:
        IFlowMessageIDL r3 = this.origin;     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L26;
    L35:
        IFlowSemanticEditCallbackIDL r8 = r15;
    L36:
        r20 = ")";
        r3.notifySemanticUserEditEventWithIdentifier(r29, r30, r31, r14, r8);     // Catch: Exception -> L46 Throwable -> L52
        if (this.log == false) goto L40;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier = void");     // Catch: Exception -> L46 Throwable -> L52
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L52
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L46 Throwable -> L52
        r4 = r31;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L44 Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithIdentifier", r0, r27);     // Catch: Exception -> L44 Throwable -> L52
        return;
    L44:
        e = e;
    L46:
        e = e;
        r4 = r31;
        r5 = 0;
        goto L50
    L26:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L33;
        IFlowSemanticEditCallbackIDL r9 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
    L34:
        r8 = r9;
        goto L36
    L33:
        r9 = ar.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void notifySemanticUserEditEventWithUri(String r29, String r30, String r31, Map r32, IFlowSemanticEditCallbackIDL r33) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r15 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L48:
        e = e;
        String r4 = r31;
        String r20 = ")";
        long r5 = 0;
    L50:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + r20, e);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L52
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L52
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri", r1, r24, r26);     // Catch: Throwable -> L52
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri(" + r29 + ", " + r30 + ", " + r31 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L48 Throwable -> L52
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L48 Throwable -> L52
        StringBuilder r6 = new StringBuilder().append("notifySemanticUserEditEventWithUri(").append(r29).append(", ").append(r30).append(", ").append(r31).append(", ").append(r14).append(", ");     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L12;
    L20:
        IFlowSemanticEditCallbackIDL r7 = r15;
    L21:
        r2.a("IFlowMessageIDLIPC", r6.append(r7).append(")").toString());     // Catch: Exception -> L48 Throwable -> L52
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L19;
        r7 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
        goto L21
    L19:
        r7 = ar.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    L22:
        IFlowMessageIDL r3 = this.origin;     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L26;
    L35:
        IFlowSemanticEditCallbackIDL r8 = r15;
    L36:
        r20 = ")";
        r3.notifySemanticUserEditEventWithUri(r29, r30, r31, r14, r8);     // Catch: Exception -> L46 Throwable -> L52
        if (this.log == false) goto L40;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri = void");     // Catch: Exception -> L46 Throwable -> L52
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L52
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L46 Throwable -> L52
        r4 = r31;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L44 Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "notifySemanticUserEditEventWithUri", r0, r27);     // Catch: Exception -> L44 Throwable -> L52
        return;
    L44:
        e = e;
    L46:
        e = e;
        r4 = r31;
        r5 = 0;
        goto L50
    L26:
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLIpcWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, FlowSemanticEditCallbackIDLStubWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, IFlowSemanticEditCallbackIDL.Stub.class) == false) goto L33;
        IFlowSemanticEditCallbackIDL r9 = ar.a((IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
    L34:
        r8 = r9;
        goto L36
    L33:
        r9 = ar.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessage(String r33, String r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "sendMessage", r5, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendMessage(r33, r34, r35, r36);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "sendMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "sendMessage(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "sendMessage", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void isMessageLocalInterrupted(String r25, IFlowIsMessageInterruptedCallbackIDL r26) {
        IFlowIsMessageInterruptedCallbackIDL r6 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("isMessageLocalInterrupted(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowIsMessageInterruptedCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class) == false) goto L19;
        r11 = ah.a((IFlowIsMessageInterruptedCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ah.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowIsMessageInterruptedCallbackIDL r9 = r6;
    L35:
        r12.isMessageLocalInterrupted(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "isMessageLocalInterrupted = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "isMessageLocalInterrupted", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowIsMessageInterruptedCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class) == false) goto L33;
        r9 = ah.a((IFlowIsMessageInterruptedCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowIsMessageInterruptedCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ah.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void deleteRemoteResource(List<String> r21) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "deleteRemoteResource", r1, r6, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.deleteRemoteResource(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "deleteRemoteResource = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "deleteRemoteResource(" + r4 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "deleteRemoteResource", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void uploadImage(String r25, String r26, IImageXUploadCallbackIDL r27) {
        IImageXUploadCallbackIDL r7 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "uploadImage(" + r25 + ", " + r26 + ", " + r7 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r8 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "uploadImage(" + r25 + ", " + r26 + ", " + r7 + ") = fail", r3, r8);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "uploadImage", r3, r8, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "uploadImage(" + r25 + ", " + r26 + ", " + r7 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("uploadImage(").append(r25).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IImageXUploadCallbackIDL r13 = r7;
    L21:
        r11.a("IFlowMessageIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IImageXUploadCallbackIDL.Stub.class) == false) goto L19;
        r13 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = ay.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IImageXUploadCallbackIDL r10 = r7;
    L35:
        r12.uploadImage(r25, r26, r10);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "uploadImage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "uploadImage(" + r25 + ", " + r26 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "uploadImage", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, ImageXUploadCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IImageXUploadCallbackIDL.Stub.class) == false) goto L33;
        r10 = ay.a((IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r10 = ay.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerStreamObserver(IFlowStreamObserverIDL r21) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerStreamObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerStreamObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowStreamObserverIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L19;
        r15 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = au.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowStreamObserverIDL r7 = r4;
    L35:
        r13.registerStreamObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "registerStreamObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerStreamObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerStreamObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L33;
        r7 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = au.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void unregisterStreamObserver(IFlowStreamObserverIDL r21) {
        IFlowStreamObserverIDL r4 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterStreamObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterStreamObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowStreamObserverIDL r15 = r4;
    L21:
        r12.a("IFlowMessageIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L19;
        r15 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = au.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowStreamObserverIDL r7 = r4;
    L35:
        r13.unregisterStreamObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "unregisterStreamObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "unregisterStreamObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "unregisterStreamObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowStreamObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowStreamObserverIDL.Stub.class) == false) goto L33;
        r7 = au.a((IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = au.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public boolean isConversationTtsEnabled(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isConversationTtsEnabled(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "isConversationTtsEnabled = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "isConversationTtsEnabled", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void sendMessageWithExtra(String r29, String r30, String r31, String r32, Map r33) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L22:
        e = e;
        String r4 = r32;
        String r20 = ")";
    L24:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + r20, e);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L26
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L26
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + ") = fail", r1, r24);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "sendMessageWithExtra", r1, r24, r26);     // Catch: Throwable -> L26
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r15 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r32 + ", " + r15 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L9:
        r20 = ")";
        this.origin.sendMessageWithExtra(r29, r30, r31, r32, r15);     // Catch: Exception -> L20 Throwable -> L26
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "sendMessageWithExtra = void");     // Catch: Exception -> L20 Throwable -> L26
    L14:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L20 Throwable -> L26
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L20 Throwable -> L26
        r4 = r32;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "sendMessageWithExtra(" + r29 + ", " + r30 + ", " + r31 + ", " + r4 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L18 Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "sendMessageWithExtra", r0, r27);     // Catch: Exception -> L18 Throwable -> L26
        return;
    L18:
        e = e;
    L20:
        e = e;
        r4 = r32;
        r5 = 0;
        goto L24
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMessageExt(String r22, Map r23) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r6 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r6 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMessageExt", r2, r8, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMessageExt(r22, r6);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "updateMessageExt = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMessageExt(" + r22 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMessageExt", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void retryFetchMessage(IMMessage r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "retryFetchMessage", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.retryFetchMessage(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "retryFetchMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "retryFetchMessage(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "retryFetchMessage", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void refreshLatestMessages(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "refreshLatestMessages", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.refreshLatestMessages(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "refreshLatestMessages = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "refreshLatestMessages(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "refreshLatestMessages", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void fetchLatestMessages(int r25, IFlowFindMessagesCallbackIDL r26) {
        IFlowFindMessagesCallbackIDL r6 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "fetchLatestMessages", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("fetchLatestMessages(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFindMessagesCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L19;
        r11 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ab.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFindMessagesCallbackIDL r9 = r6;
    L35:
        r12.fetchLatestMessages(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "fetchLatestMessages = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "fetchLatestMessages(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "fetchLatestMessages", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L33;
        r9 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ab.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void getMainTxtContentForMessage(String r25, IFlowMessageMainTextBlockCallbackIDL r26) {
        IFlowMessageMainTextBlockCallbackIDL r6 = (IFlowMessageMainTextBlockCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowMessageMainTextBlockCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("getMainTxtContentForMessage(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowMessageMainTextBlockCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class) == false) goto L19;
        r11 = al.a((IFlowMessageMainTextBlockCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = al.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowMessageMainTextBlockCallbackIDL r9 = r6;
    L35:
        r12.getMainTxtContentForMessage(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "getMainTxtContentForMessage = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "getMainTxtContentForMessage", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageMainTextBlockCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class) == false) goto L33;
        r9 = al.a((IFlowMessageMainTextBlockCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageMainTextBlockCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = al.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public String getMainTxtContentFromMessage(IMMessage r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        String r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getMainTxtContentFromMessage(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "getMainTxtContentFromMessage = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "getMainTxtContentFromMessage", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void findAnswersbyQueryId(String r25, IFlowFindMessagesCallbackIDL r26) {
        IFlowFindMessagesCallbackIDL r6 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("findAnswersbyQueryId(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFindMessagesCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L19;
        r11 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ab.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFindMessagesCallbackIDL r9 = r6;
    L35:
        r12.findAnswersbyQueryId(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "findAnswersbyQueryId = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "findAnswersbyQueryId", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFindMessagesCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFindMessagesCallbackIDL.Stub.class) == false) goto L33;
        r9 = ab.a((IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ab.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableMessageContent(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMutableMessageContent", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMutableMessageContent(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "updateMutableMessageContent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMutableMessageContent(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMutableMessageContent", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void registerCallbackWithEvents(IFlowMessageCallbackIDL r25, int r26) {
        IFlowMessageCallbackIDL r6 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r6 + ", " + r26 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r6 + ", " + r26 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("registerCallbackWithEvents(");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowMessageCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowMessageIDLIPC", r10.append(r11).append(", ").append(r26).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageCallbackIDL.Stub.class) == false) goto L19;
        r11 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = aj.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowMessageIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowMessageCallbackIDL r9 = r6;
    L35:
        r12.registerCallbackWithEvents(r9, r26);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "registerCallbackWithEvents = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents(" + r6 + ", " + r26 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "registerCallbackWithEvents", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowMessageCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowMessageCallbackIDL.Stub.class) == false) goto L33;
        r9 = aj.a((IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = aj.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
    public void updateMutableWidgetRenderData(String r23, String r24, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateMutableWidgetRenderData(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowMessageIDLIPC", "updateMutableWidgetRenderData = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowMessageIDLIPC", "updateMutableWidgetRenderData", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
