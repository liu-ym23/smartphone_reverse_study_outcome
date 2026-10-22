package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowNetworkIDLStubWrapper extends IFlowNetworkIDL.Stub {
    boolean log;
    final IFlowNetworkIDL.Stub origin;

    FlowNetworkIDLStubWrapper(IFlowNetworkIDL.Stub r2) {
        this(r2, true);
    }

    FlowNetworkIDLStubWrapper(IFlowNetworkIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r26, boolean r27, IFlowNetworkResultCallbackIDL r28) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r27 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r27 + ", " + r8 + ") = fail", r2, r10);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp", r2, r10, r23);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r27 + ", " + r8 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r8 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L19:
        r11.sendIntentResultForCompensationByHttp(r6, r27, r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r27 + ", " + r8 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendIntentResultForCompensationByHttp", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = an.a(r8, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r26, boolean r27, IFlowNetworkResultCallbackIDL r28) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r27 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r27 + ", " + r8 + ") = fail", r2, r10);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp", r2, r10, r23);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r27 + ", " + r8 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r8 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L19:
        r11.sendIntentResultForAsyncNotifyByHttp(r6, r27, r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r27 + ", " + r8 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendIntentResultForAsyncNotifyByHttp", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = an.a(r8, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendNormalRouterByHttp(String r26, String r27, IFlowNetworkResultCallbackIDL r28) {
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r26 + ", " + r27 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r26 + ", " + r27 + ", " + r7 + ") = fail", r3, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendNormalRouterByHttp", r3, r8, r23);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r26 + ", " + r27 + ", " + r7 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r10 = r7;
    L19:
        r11.sendNormalRouterByHttp(r26, r27, r10);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "sendNormalRouterByHttp = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendNormalRouterByHttp(" + r26 + ", " + r27 + ", " + r7 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendNormalRouterByHttp", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r10 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r10 = an.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendReplyAskUserByHttp(String r30, String r31, String r32, Map r33, IFlowNetworkResultCallbackIDL r34) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r15 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r34, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L32:
        e = e;
        String r4 = r32;
        String r21 = ")";
    L34:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "sendReplyAskUserByHttp(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + r21, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendReplyAskUserByHttp(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendReplyAskUserByHttp", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "sendReplyAskUserByHttp(" + r30 + ", " + r31 + ", " + r32 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L32
    L6:
        IFlowNetworkIDL.Stub r2 = this.origin;     // Catch: Exception -> L32
        if (r15 != null) goto L10;
    L19:
        IFlowNetworkResultCallbackIDL r20 = r15;
    L20:
        r21 = ")";
        r2.sendReplyAskUserByHttp(r30, r31, r32, r14, r20);     // Catch: Exception -> L30
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "sendReplyAskUserByHttp = void");     // Catch: Exception -> L30
    L24:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L30
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L30
        r4 = r32;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sendReplyAskUserByHttp(" + r30 + ", " + r31 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L28
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sendReplyAskUserByHttp", r0, r27);     // Catch: Exception -> L28
        return;
    L28:
        e = e;
    L30:
        e = e;
        r4 = r32;
        r5 = 0;
        goto L34
    L10:
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        IFlowNetworkResultCallbackIDL r3 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L32
    L18:
        r20 = r3;
        goto L20
    L17:
        r3 = an.a(r15, true);     // Catch: Exception -> L32
        goto L18
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttp(long r22) {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r22 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r19 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r22 + ") = fail", r3, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp", r3, r5, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r22 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTaskByHttp(r22);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp(" + r22 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttp", r14, r18);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public int getCurrentNetworkStatus() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "getCurrentNetworkStatus()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "getCurrentNetworkStatus() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "getCurrentNetworkStatus", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "getCurrentNetworkStatus()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getCurrentNetworkStatus();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "getCurrentNetworkStatus = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "getCurrentNetworkStatus() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "getCurrentNetworkStatus", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadUserTakeOverByHttp(String r24, String r25, String r26, long r27, Map r29, IFlowNetworkResultCallbackIDL r30) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r30, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L50:
        e = e;
        Map r12 = r5;
        String r13 = ", ";
        String r21 = "FlowNetworkIDLStub";
        String r20 = ")";
        IFlowNetworkResultCallbackIDL r14 = r6;
    L52:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r21, "uploadUserTakeOverByHttp(" + r24 + r13 + r25 + r13 + r26 + r13 + r27 + r13 + r12 + r13 + r14 + r20, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r7 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r7 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "uploadUserTakeOverByHttp(" + r24 + r13 + r25 + r13 + r26 + r13 + r27 + r13 + r12 + r13 + r14 + ") = fail", r1, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadUserTakeOverByHttp", r1, r8, r7);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "uploadUserTakeOverByHttp(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ", " + r5 + ", " + r6 + ")");     // Catch: Exception -> L50
    L6:
        IFlowNetworkIDL.Stub r2 = this.origin;     // Catch: Exception -> L50
        if (r6 != null) goto L10;
    L19:
        IFlowNetworkResultCallbackIDL r22 = r6;
    L20:
        Map r210 = r5;
        r2.uploadUserTakeOverByHttp(r24, r25, r26, r27, r210, r22);     // Catch: Exception -> L47
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "uploadUserTakeOverByHttp = void");     // Catch: Exception -> L47
    L24:
        long r9 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L47
        long r10 = Math.max(0, r9 - r16) / 1000;     // Catch: Exception -> L47
        com.obric.aiagent.ipc.utils.k r0 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L47
        r13 = ", ";
        r20 = ")";
        r14 = r6;
        StringBuilder r3 = new StringBuilder().append("uploadUserTakeOverByHttp(").append(r24).append(r13).append(r25).append(r13).append(r26).append(r13).append(r27).append(r13).append(r210).append(r13).append(r14);     // Catch: Exception -> L40
        r210 = r210;
        r0.b("FlowNetworkIDLStub", r3.append(") = void").toString(), r10);     // Catch: Exception -> L38
        r21 = "FlowNetworkIDLStub";
        r12 = r210;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadUserTakeOverByHttp", r10, r9);     // Catch: Exception -> L36
        return;
    L36:
        e = e;
    L38:
        e = e;
    L49:
        r21 = "FlowNetworkIDLStub";
        r12 = r210;
    L40:
        e = e;
    L44:
        r21 = "FlowNetworkIDLStub";
        r12 = r210;
    L42:
        e = e;
        r20 = ")";
        r14 = r6;
    L45:
        e = e;
        r20 = ")";
        r14 = r6;
    L47:
        e = e;
        r20 = ")";
        r14 = r6;
        r13 = ", ";
        goto L49
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        IFlowNetworkResultCallbackIDL r4 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L50
    L18:
        r22 = r4;
        goto L20
    L17:
        r4 = an.a(r6, true);     // Catch: Exception -> L50
        goto L18
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttp(String r27, String r28, int r29, String r30, String r31, String r32, String r33, List<String> r34, String r35, String r36, IFlowNetworkResultCallbackIDL r37) {
        String r14 = r28;
        String r12 = r30;
        String r3 = ", ";
        String r16 = "FlowNetworkIDLStub";
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r37, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L108;
        List<String> r38 = r4;
        String r5 = r16;
        String r7 = ")";
    L15:
        IFlowNetworkIDL.Stub r1 = this.origin;     // Catch: Exception -> L83
        if (r6 != null) goto L19;
    L17:
        String r17 = ", ";
        IFlowNetworkResultCallbackIDL r19 = r6;
    L32:
        String r23 = r17;
        List<String> r39 = r38;
        r16 = r5;
        String r15 = "uploadOmniScreenshotByHttp(";
        String r24 = r7;
        r6 = r6;
        r1.uploadOmniScreenshotByHttp(r27, r28, r29, r30, r31, r32, r33, r39, r35, r36, r19);     // Catch: Exception -> L80
        if (this.log == false) goto L36;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r16, "uploadOmniScreenshotByHttp = void");     // Catch: Exception -> L80
    L36:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L80
        long r9 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L80
        com.obric.aiagent.ipc.utils.k r0 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L80
        r3 = r23;
        r14 = r28;
        int r11 = r29;
    L67:
        e = e;
        r12 = r30;
        r11 = r11;
        r16 = r16;
        String r110 = r31;
    L90:
        List<String> r10 = r39;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r16, r15 + r27 + r3 + r14 + r3 + r11 + r3 + r12 + r3 + r110 + r3 + r32 + r3 + r33 + r3 + r10 + r3 + r35 + r3 + r36 + r3 + r6 + r24, e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r111 - r18) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", r15 + r27 + r3 + r14 + r3 + r11 + r3 + r12 + r3 + r110 + r3 + r32 + r3 + r33 + r3 + r10 + r3 + r35 + r3 + r36 + r3 + r6 + ") = fail", r2, r13);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniScreenshotByHttp", r2, r13, r111);
        throw r2;
    L106:
        StringBuilder r20 = new StringBuilder().append(r15).append(r27).append(r3).append(r14).append(r3).append(r11).append(r3).append(r30).append(r3).append(r31).append(r3).append(r32).append(r3).append(r33).append(r3).append(r39).append(r3);     // Catch: Exception -> L63
        r39 = r39;
        r0.b(r16, r20.append(r35).append(r3).append(r36).append(r3).append(r6).append(") = void").toString(), r9);     // Catch: Exception -> L59
        r16 = r16;
        r110 = r31;
        r6 = r6;
        r12 = r30;
        r11 = r11;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniScreenshotByHttp", r9, r8);     // Catch: Exception -> L57
        return;
    L57:
        e = e;
    L59:
        e = e;
        r11 = r11;
        r6 = r6;
        r110 = r31;
    L66:
        r12 = r30;
    L61:
        e = e;
        r6 = r6;
    L65:
        r110 = r31;
    L63:
        e = e;
        r39 = r39;
    L69:
        e = e;
        r12 = r30;
    L73:
        r11 = r11;
    L82:
        r110 = r31;
    L71:
        e = e;
        r12 = r30;
    L74:
        e = e;
    L78:
        r11 = r29;
        r12 = r30;
    L76:
        e = e;
        r14 = r28;
    L80:
        e = e;
        r14 = r28;
        r11 = r29;
        r12 = r30;
        r3 = r23;
        goto L82
    L19:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L17;
        r17 = ", ";
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L27;
        IFlowNetworkResultCallbackIDL r21 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L29
    L28:
        r19 = r21;
        goto L32
    L27:
        r21 = an.a(r6, true);     // Catch: Exception -> L29
    L29:
        e = e;
        r39 = r38;
        r24 = r7;
        r3 = r17;
        r16 = r5;
    L89:
        r110 = r31;
        r11 = r29;
        r15 = "uploadOmniScreenshotByHttp(";
    L83:
        e = e;
        r39 = r38;
        r16 = r5;
    L85:
        r24 = r7;
        goto L89
    L108:
        r7 = ")";
        String r22 = "uploadOmniScreenshotByHttp(" + r27 + ", " + r14 + ", " + r29 + ", " + r12 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ", " + r35 + ", " + r36 + ", " + r6 + r7;     // Catch: Exception -> L10
        r38 = r4;
        r5 = r16;
        com.obric.aiagent.ipc.utils.j.f18676a.b(r5, r22);     // Catch: Exception -> L83
    L10:
        e = e;
        r39 = r4;
    L12:
        e = e;
        r39 = r4;
    L88:
        r24 = ")";
    L86:
        e = e;
        r39 = r4;
        goto L88
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyUserOperateQueue(String r25, IFlowNetworkResultCallbackIDL r26) {
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyUserOperateQueue", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r9 = r6;
    L19:
        r14.notifyUserOperateQueue(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "notifyUserOperateQueue = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyUserOperateQueue(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyUserOperateQueue", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r9 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = an.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopOmniTaskByHttp(String r24, Map r25, IFlowNetworkResultCallbackIDL r26) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r24 + ", " + r6 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r21 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r21 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r24 + ", " + r6 + ", " + r8 + ") = fail", r2, r10);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp", r2, r10, r21);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r24 + ", " + r6 + ", " + r8 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r8 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L19:
        r11.notifyStopOmniTaskByHttp(r24, r6, r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp = void");     // Catch: Exception -> L24
    L22:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r20 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp(" + r24 + ", " + r6 + ", " + r8 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopOmniTaskByHttp", r12, r20);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = an.a(r8, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void clearOmniTasks(Map r23, IFlowNetworkResultCallbackIDL r24) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r24, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "clearOmniTasks(" + r5 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "clearOmniTasks(" + r5 + ", " + r7 + ") = fail", r1, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "clearOmniTasks", r1, r9, r20);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "clearOmniTasks(" + r5 + ", " + r7 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r6 = r7;
    L19:
        r14.clearOmniTasks(r5, r6);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "clearOmniTasks = void");     // Catch: Exception -> L24
    L22:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r19 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "clearOmniTasks(" + r5 + ", " + r7 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "clearOmniTasks", r10, r19);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r6 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r6 = an.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttpWithScene(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = fail", r4, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene", r4, r7, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTaskByHttpWithScene(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "notifyStopComplexTaskByHttpWithScene", r14, r21);     // Catch: Exception -> L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r17v13, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v44, types: [com.obric.aiagent.assistant.idl.IFlowNetworkIDL$Stub] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void createConditionalTask(String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, Map r44, IFlowNetworkResultCallbackIDL r45) {
        String r13 = r32;
        String r12 = r33;
        String r11 = r34;
        String r16 = ")";
        String r17 = "FlowNetworkIDLStub";
        Map r46 = (Map) ZeusTransformUtils.wrapperContextForParams(r44, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r45, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L115;
        Map r6 = r46;
        String r15 = r17;
        String r19 = ", ";
        String r2 = r16;
        Object r22 = "createConditionalTask(";
        String r1 = "com.obric.aiagent.plugin";
    L24:
        ?? r3 = this.origin;     // Catch: Exception -> L103
        if (r5 != null) goto L28;
    L41:
        String r4 = r2;
        r22 = r5;
    L42:
        String r24 = r4;
        String r23 = r19;
        Object r25 = r22;
        r5 = r5;
        r46 = r6;
        String r27 = r15;
        r3.createConditionalTask(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r46, r22);     // Catch: Exception -> L101
        if (this.log == false) goto L48;
        r17 = r27;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r17, "createConditionalTask = void");     // Catch: Exception -> L98
    L49:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L98
        long r7 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L98
        com.obric.aiagent.ipc.utils.k r0 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L98
        ?? r14 = r25;
        r30 = r30;
        String r110 = r23;
        String r111 = r31;
        r13 = r32;
        StringBuilder r9 = new StringBuilder().append(r14).append(r30).append(r110).append(r111).append(r110).append(r13).append(r110).append(r33).append(r110).append(r34).append(r110).append(r35).append(r110).append(r36).append(r110).append(r37).append(r110).append(r38).append(r110).append(r39).append(r110).append(r40).append(r110).append(r41).append(r110).append(r42).append(r110).append(r43).append(r110).append(r46).append(r110);     // Catch: Exception -> L78
        r46 = r46;
        r0.b(r17, r9.append(r5).append(") = void").toString(), r7);     // Catch: Exception -> L74
        r17 = r17;
        r11 = r34;
        r5 = r5;
        r12 = r33;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "createConditionalTask", r7, r8);     // Catch: Exception -> L72
        return;
    L72:
        e = e;
    L109:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r17, r14 + r30 + r110 + r111 + r110 + r13 + r110 + r12 + r110 + r11 + r110 + r35 + r110 + r36 + r110 + r37 + r110 + r38 + r110 + r39 + r110 + r40 + r110 + r41 + r110 + r42 + r110 + r43 + r110 + r46 + r110 + r5 + r24, e);
        com.obric.aiagent.ipc.utils.g r10 = new com.obric.aiagent.ipc.utils.g(e);
        long r112 = SystemClock.elapsedRealtimeNanos();
        long r20 = Math.max(0, r112 - r18) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", r14 + r30 + r110 + r111 + r110 + r13 + r110 + r12 + r110 + r11 + r110 + r35 + r110 + r36 + r110 + r37 + r110 + r38 + r110 + r39 + r110 + r40 + r110 + r41 + r110 + r42 + r110 + r43 + r110 + r46 + r110 + r5 + ") = fail", r10, r20);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "createConditionalTask", r10, r20, r112);
        throw r10;
    L74:
        e = e;
        r5 = r5;
        r11 = r34;
    L80:
        r12 = r33;
    L76:
        e = e;
        r11 = r34;
        r5 = r5;
    L78:
        e = e;
        r11 = r34;
        r46 = r46;
    L81:
        e = e;
        r17 = r17;
        r11 = r34;
        r12 = r33;
        r13 = r13;
    L83:
        e = e;
        r12 = r33;
    L87:
        r13 = r13;
        r14 = r14;
    L100:
        r11 = r34;
    L85:
        e = e;
        r12 = r33;
    L88:
        e = e;
    L92:
        r13 = r32;
        r12 = r33;
        r17 = r17;
        r14 = r14;
    L90:
        e = e;
        r111 = r31;
    L93:
        e = e;
    L97:
        r111 = r31;
        r13 = r32;
        r12 = r33;
        r17 = r17;
        r110 = r23;
        r14 = r14;
    L95:
        e = e;
        r30 = r30;
    L98:
        e = e;
        r30 = r30;
        r111 = r31;
        r13 = r32;
        r12 = r33;
        r17 = r17;
        r110 = r23;
        r14 = r25;
        goto L100
    L48:
        r17 = r27;
    L101:
        e = e;
        r30 = r30;
        r111 = r31;
        r13 = r32;
        r12 = r33;
        r11 = r34;
        r110 = r23;
        r14 = r25;
        r17 = r27;
        goto L109
    L28:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L41;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L41;
        r16 = r2;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L36;
        Object r21 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r1), true);     // Catch: Exception -> L38
    L37:
        r4 = r16;
        r22 = r21;
        goto L42
    L36:
        r21 = an.a(r5, true);     // Catch: Exception -> L38
    L38:
        e = e;
    L39:
        r46 = r6;
    L40:
        r24 = r16;
    L105:
        r14 = r22;
    L106:
        String r28 = r15;
        r111 = r31;
        r110 = r19;
        r17 = r28;
    L103:
        e = e;
        r24 = r2;
        r5 = r5;
        r46 = r6;
        goto L105
    L115:
        r22 = "createConditionalTask(";
        r1 = "com.obric.aiagent.plugin";
        r15 = r17;
        r6 = r46;
        r19 = ", ";
        r2 = r16;
        com.obric.aiagent.ipc.utils.j.f18676a.b(r15, "createConditionalTask(" + r30 + ", " + r31 + ", " + r13 + ", " + r12 + ", " + r11 + ", " + r35 + ", " + r36 + ", " + r37 + ", " + r38 + ", " + r39 + ", " + r40 + ", " + r41 + ", " + r42 + ", " + r43 + ", " + r6 + ", " + r5 + r2);     // Catch: Exception -> L103
    L14:
        e = e;
        r19 = ", ";
    L16:
        e = e;
    L20:
        r19 = ", ";
    L18:
        e = e;
        r15 = r17;
    L21:
        e = e;
        r15 = r17;
        r19 = ", ";
        r5 = r5;
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r24 = r16;
        r14 = "createConditionalTask(";
    L107:
        e = e;
        r5 = r5;
        r13 = r13;
        r30 = r30;
        r24 = r16;
        r111 = r31;
        r110 = ", ";
        r11 = r11;
        r12 = r12;
        r14 = "createConditionalTask(";
        goto L109
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r25, IFlowNetworkResultCallbackIDL r26) {
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "sweepConditionalTask(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sweepConditionalTask(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sweepConditionalTask", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "sweepConditionalTask(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r9 = r6;
    L19:
        r14.sweepConditionalTask(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "sweepConditionalTask = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "sweepConditionalTask(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "sweepConditionalTask", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r9 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = an.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void deleteConditionalTask(String r24, Map r25, IFlowNetworkResultCallbackIDL r26) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowNetworkIDLStub", "deleteConditionalTask(" + r24 + ", " + r6 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r21 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r21 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "deleteConditionalTask(" + r24 + ", " + r6 + ", " + r8 + ") = fail", r2, r10);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "deleteConditionalTask", r2, r10, r21);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowNetworkIDLStub", "deleteConditionalTask(" + r24 + ", " + r6 + ", " + r8 + ")");     // Catch: Exception -> L24
    L6:
        IFlowNetworkIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r8 != null) goto L10;
    L18:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L19:
        r11.deleteConditionalTask(r24, r6, r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowNetworkIDLStub", "deleteConditionalTask = void");     // Catch: Exception -> L24
    L22:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r20 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", "deleteConditionalTask(" + r24 + ", " + r6 + ", " + r8 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "deleteConditionalTask", r12, r20);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L17;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = an.a(r8, true);     // Catch: Exception -> L24
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r16v6, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v42, types: [com.obric.aiagent.assistant.idl.IFlowNetworkIDL$Stub] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttp(String r31, String r32, int r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, List<String> r42, String r43, String r44, IFlowNetworkResultCallbackIDL r45) {
        String r15 = r31;
        int r13 = r33;
        String r12 = r34;
        String r11 = r35;
        String r16 = ")";
        String r17 = "FlowNetworkIDLStub";
        String r2 = ", ";
        List r46 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r45, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L120;
        r2 = ", ";
        String r3 = r17;
        Object r22 = "uploadOmniDataFeedbackByHttp(";
        String r1 = "com.obric.aiagent.plugin";
    L29:
        ?? r4 = this.origin;     // Catch: Exception -> L110
        if (r5 != null) goto L33;
    L31:
        r17 = r3;
        r22 = r5;
    L47:
        String r25 = r16;
        String r24 = r17;
        String r6 = r2;
        Object r27 = r22;
        r5 = r5;
        r4.uploadOmniDataFeedbackByHttp(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r46, r43, r44, r22);     // Catch: Exception -> L108
        if (this.log == false) goto L53;
        r24 = r24;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r24, "uploadOmniDataFeedbackByHttp = void");     // Catch: Exception -> L105
    L54:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L105
        long r7 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L105
        ?? r14 = r27;
        r15 = r31;
        String r19 = r6;
        String r110 = r32;
        r13 = r33;
    L88:
        e = e;
        r24 = r24;
        r11 = r35;
        r12 = r34;
        r13 = r13;
    L116:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r24, new StringBuilder().append(r14).append(r15).append(r19).append(r110).append(r19).append(r13).append(r19).append(r12).append(r19).append(r11).append(r19).append(r36).append(r19).append(r37).append(r19).append(r38).append(r19).append(r39).append(r19).append(r40).append(r19).append(r41).append(r19).append(r46).append(r19).append(r43).append(r19).append(r44).append(r19).append(r5).append(r25).toString(), e);
        com.obric.aiagent.ipc.utils.g r9 = new com.obric.aiagent.ipc.utils.g(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r0 = Math.max(0, r111 - r18) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", new StringBuilder().append(r14).append(r15).append(r19).append(r110).append(r19).append(r13).append(r19).append(r12).append(r19).append(r11).append(r19).append(r36).append(r19).append(r37).append(r19).append(r38).append(r19).append(r39).append(r19).append(r40).append(r19).append(r41).append(r19).append(r46).append(r19).append(r43).append(r19).append(r44).append(r19).append(r5).append(") = fail").toString(), r9, r0);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttp", r9, r0, r111);
        throw r9;
    L69:
        List r112 = r46;
        r46 = r112;
        com.obric.aiagent.ipc.utils.k.f18677a.b(r24, r14 + r15 + r19 + r110 + r19 + r13 + r19 + r34 + r19 + r35 + r19 + r36 + r19 + r37 + r19 + r38 + r19 + r39 + r19 + r40 + r19 + r41 + r19 + r112 + r19 + r43 + r19 + r44 + r19 + r5 + ") = void", r7);     // Catch: Exception -> L81
        r24 = r24;
        r11 = r35;
        r5 = r5;
        r12 = r34;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttp", r7, r8);     // Catch: Exception -> L79
        return;
    L79:
        e = e;
    L81:
        e = e;
        r5 = r5;
        r11 = r35;
    L87:
        r12 = r34;
    L83:
        e = e;
        r11 = r35;
        r5 = r5;
    L85:
        e = e;
        r11 = r35;
        r46 = r112;
    L90:
        e = e;
        r12 = r34;
    L94:
        r13 = r13;
        r14 = r14;
    L107:
        r11 = r35;
    L92:
        e = e;
        r12 = r34;
    L95:
        e = e;
    L99:
        r13 = r33;
        r12 = r34;
        r24 = r24;
        r14 = r14;
    L97:
        e = e;
        r110 = r32;
    L100:
        e = e;
    L104:
        r110 = r32;
        r13 = r33;
        r12 = r34;
        r24 = r24;
        r19 = r6;
        r14 = r14;
    L102:
        e = e;
        r15 = r31;
    L105:
        e = e;
        r15 = r31;
        r110 = r32;
        r13 = r33;
        r12 = r34;
        r24 = r24;
        r19 = r6;
        r14 = r27;
        goto L107
    L53:
        r24 = r24;
    L108:
        e = e;
        r15 = r31;
        r110 = r32;
        r13 = r33;
        r12 = r34;
        r11 = r35;
        r19 = r6;
        r14 = r27;
        goto L116
    L33:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L31;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L31;
        r17 = r3;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L41;
        Object r10 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r1), true);     // Catch: Exception -> L43
    L42:
        r22 = r10;
        goto L47
    L41:
        r10 = an.a(r5, true);     // Catch: Exception -> L43
    L43:
        e = e;
    L44:
        r25 = r16;
    L45:
        r24 = r17;
    L112:
        r14 = r22;
    L113:
        r110 = r32;
        r19 = r2;
    L110:
        e = e;
        r24 = r3;
        r5 = r5;
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r15 = r15;
        r25 = r16;
        goto L112
    L120:
        com.obric.aiagent.ipc.utils.j r20 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L25
        StringBuilder r21 = new StringBuilder().append("uploadOmniDataFeedbackByHttp(").append(r15).append(", ").append(r32).append(", ").append(r13).append(", ").append(r12).append(", ").append(r11).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r41).append(", ").append(r46).append(", ");     // Catch: Exception -> L23
        r46 = r46;
        r22 = "uploadOmniDataFeedbackByHttp(";
        r1 = "com.obric.aiagent.plugin";
        r2 = ", ";
        String r23 = r21.append(r43).append(", ").append(r44).append(", ").append(r5).append(r16).toString();     // Catch: Exception -> L16
        r16 = r16;
        r3 = r17;
        r20.b(r3, r23);     // Catch: Exception -> L110
    L16:
        e = e;
        r25 = r16;
    L18:
        e = e;
    L22:
        r2 = ", ";
    L20:
        e = e;
    L23:
        e = e;
        r46 = r46;
    L27:
        r5 = r5;
        r11 = r11;
        r12 = r12;
        r13 = r13;
        r15 = r15;
        r25 = r16;
        r24 = r17;
        r14 = "uploadOmniDataFeedbackByHttp(";
    L25:
        e = e;
    L114:
        e = e;
        r5 = r5;
        r13 = r13;
        r15 = r15;
        r25 = r16;
        r24 = r17;
        r110 = r32;
        r19 = ", ";
        r11 = r11;
        r12 = r12;
        r14 = "uploadOmniDataFeedbackByHttp(";
        goto L116
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttpV2(String r27, String r28, int r29, String r30, String r31, String r32, String r33, List<String> r34, String r35, String r36, boolean r37, IFlowNetworkResultCallbackIDL r38) {
        int r13 = r29;
        String r12 = r30;
        r31 = r31;
        String r16 = "FlowNetworkIDLStub";
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r38, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        IFlowNetworkResultCallbackIDL r39 = r6;
        if (this.log == true) goto L131;
        r39 = r39;
        List<String> r310 = r5;
        String r7 = ")";
        String r17 = "uploadOmniScreenshotByHttpV2(";
        String r4 = r16;
    L30:
        IFlowNetworkIDL.Stub r1 = this.origin;     // Catch: Exception -> L103
        if (r39 != null) goto L34;
    L32:
        String r19 = ", ";
        IFlowNetworkResultCallbackIDL r22 = r39;
    L47:
        String r8 = r19;
        r16 = r4;
        IFlowNetworkResultCallbackIDL r110 = r39;
        String r15 = r17;
        List<String> r311 = r310;
        String r23 = r7;
        IFlowNetworkResultCallbackIDL r24 = r110;
        r1.uploadOmniScreenshotByHttpV2(r27, r28, r29, r30, r31, r32, r33, r311, r35, r36, r37, r22);     // Catch: Exception -> L99
        if (this.log == false) goto L51;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r16, "uploadOmniScreenshotByHttpV2 = void");     // Catch: Exception -> L99
    L51:
        long r9 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L99
        long r10 = Math.max(0, r9 - r18) / 1000;     // Catch: Exception -> L99
        com.obric.aiagent.ipc.utils.k r0 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L99
        r27 = r27;
        String r14 = r8;
        String r111 = r28;
        r13 = r29;
    L83:
        e = e;
        r31 = r31;
    L87:
        r13 = r13;
    L88:
        r12 = r30;
    L109:
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;
        List<String> r11 = r311;
        StringBuilder r3 = new StringBuilder().append(r15).append(r27).append(r14).append(r111).append(r14).append(r13).append(r14).append(r12).append(r14).append(r31).append(r14).append(r32).append(r14).append(r33).append(r14).append(r11).append(r14).append(r35).append(r14).append(r36).append(r14).append(r37).append(r14);
        String r20 = r3.append(r24).append(r23).toString();
        r2.a(r16, r20, e);
        com.obric.aiagent.ipc.utils.g r21 = new com.obric.aiagent.ipc.utils.g(e);
        long r112 = SystemClock.elapsedRealtimeNanos();
        long r25 = Math.max(0, r112 - r18) / 1000;
        com.obric.aiagent.ipc.utils.k r26 = com.obric.aiagent.ipc.utils.k.f18677a;
        StringBuilder r40 = new StringBuilder().append(r15).append(r27).append(r14).append(r111).append(r14);
        StringBuilder r41 = r40.append(r13).append(r14).append(r12).append(r14).append(r31).append(r14).append(r32).append(r14).append(r33).append(r14).append(r11).append(r14).append(r35).append(r14).append(r36).append(r14).append(r37).append(r14);
        r26.b("FlowNetworkIDLStub", r41.append(r24).append(") = fail").toString(), r21, r25);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniScreenshotByHttpV2", r21, r25, r112);
        throw r21;
    L137:
        StringBuilder r42 = new StringBuilder().append(r15).append(r27).append(r14).append(r111).append(r14).append(r13).append(r14).append(r30).append(r14).append(r31).append(r14).append(r32).append(r14).append(r33).append(r14).append(r311).append(r14);     // Catch: Exception -> L80
        r311 = r311;
        r0.b(r16, r42.append(r35).append(r14).append(r36).append(r14).append(r37).append(r14).append(r24).append(") = void").toString(), r10);     // Catch: Exception -> L76
        r24 = r24;
        r31 = r31;
        r16 = r16;
        r12 = r30;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniScreenshotByHttpV2", r10, r9);     // Catch: Exception -> L74
        return;
    L74:
        e = e;
    L76:
        e = e;
        r13 = r13;
        r24 = r24;
        r31 = r31;
    L78:
        e = e;
        r24 = r24;
    L82:
        r31 = r31;
    L80:
        e = e;
        r311 = r311;
    L85:
        e = e;
        r31 = r31;
    L89:
        e = e;
        r13 = r13;
    L102:
        r12 = r30;
    L91:
        e = e;
    L95:
        r13 = r29;
    L93:
        e = e;
        r111 = r28;
    L97:
        e = e;
    L101:
        r111 = r28;
        r13 = r29;
        r31 = r31;
        r14 = r8;
    L99:
        e = e;
        r27 = r27;
        goto L101
    L34:
        if (ZeusTransformUtils.instanceOf(r39, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r39, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L32;
        r19 = ", ";
        if (ZeusTransformUtils.instanceOf(r39, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L42;
        IFlowNetworkResultCallbackIDL r43 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r39, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L44
    L43:
        r22 = r43;
        goto L47
    L42:
        r43 = an.a(r39, true);     // Catch: Exception -> L44
    L44:
        e = e;
        r27 = r27;
        r311 = r310;
        r23 = r7;
        r12 = r12;
        r13 = r13;
        r24 = r39;
        r14 = r19;
        r15 = r17;
        r111 = r28;
        r16 = r4;
    L103:
        e = e;
        r311 = r310;
        r16 = r4;
    L105:
        r23 = r7;
        r24 = r39;
        r15 = r17;
        r111 = r28;
    L108:
        r14 = ", ";
        goto L109
    L131:
        com.obric.aiagent.ipc.utils.j r44 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L24
        r39 = r39;
        StringBuilder r45 = new StringBuilder().append("uploadOmniScreenshotByHttpV2(").append(r27).append(", ").append(r28).append(", ").append(r13).append(", ").append(r12).append(", ").append(r31).append(", ").append(r32).append(", ").append(r33).append(", ").append(r5).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r39);     // Catch: Exception -> L18
        r310 = r5;
        r7 = ")";
        r17 = "uploadOmniScreenshotByHttpV2(";
        r4 = r16;
        r44.b(r4, r45.append(r7).toString());     // Catch: Exception -> L103
    L16:
        e = e;
    L28:
        r17 = "uploadOmniScreenshotByHttpV2(";
        r311 = r310;
    L18:
        e = e;
    L27:
        r310 = r5;
        r7 = ")";
    L20:
        e = e;
        r39 = r39;
    L22:
        e = e;
    L24:
        e = e;
    L106:
        e = e;
        r24 = r39;
        r311 = r5;
        r27 = r27;
        r111 = r28;
        r23 = ")";
        r15 = "uploadOmniScreenshotByHttpV2(";
        goto L108
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r17v11, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v44, types: [com.obric.aiagent.assistant.idl.IFlowNetworkIDL$Stub] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttpV2(String r30, String r31, int r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, List<String> r41, String r42, String r43, boolean r44, IFlowNetworkResultCallbackIDL r45) {
        int r13 = r32;
        String r12 = r33;
        r34 = r34;
        String r16 = ")";
        String r17 = "FlowNetworkIDLStub";
        List r46 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r45, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L113;
        r17 = r17;
        String r19 = ", ";
        String r2 = r16;
        Object r22 = "uploadOmniDataFeedbackByHttpV2(";
        String r1 = "com.obric.aiagent.plugin";
    L25:
        ?? r3 = this.origin;     // Catch: Exception -> L105
        if (r5 != null) goto L29;
    L41:
        String r4 = r2;
        r22 = r5;
    L42:
        String r23 = r4;
        String r6 = r19;
        Object r25 = r22;
        r5 = r5;
        String r27 = r17;
        r3.uploadOmniDataFeedbackByHttpV2(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r46, r42, r43, r44, r22);     // Catch: Exception -> L103
        if (this.log == false) goto L48;
        r17 = r27;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r17, "uploadOmniDataFeedbackByHttpV2 = void");     // Catch: Exception -> L100
    L49:
        long r8 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L100
        long r7 = Math.max(0, r8 - r18) / 1000;     // Catch: Exception -> L100
        ?? r14 = r25;
        r30 = r30;
        String r15 = r6;
        String r110 = r31;
        r13 = r32;
        r12 = r33;
    L83:
        e = e;
        r34 = r34;
    L87:
        r12 = r12;
        r13 = r13;
    L111:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r17, new StringBuilder().append(r14).append(r30).append(r15).append(r110).append(r15).append(r13).append(r15).append(r12).append(r15).append(r34).append(r15).append(r35).append(r15).append(r36).append(r15).append(r37).append(r15).append(r38).append(r15).append(r39).append(r15).append(r40).append(r15).append(r46).append(r15).append(r42).append(r15).append(r43).append(r15).append(r44).append(r15).append(r5).append(r23).toString(), e);
        com.obric.aiagent.ipc.utils.g r9 = new com.obric.aiagent.ipc.utils.g(e);
        long r111 = SystemClock.elapsedRealtimeNanos();
        long r0 = Math.max(0, r111 - r18) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowNetworkIDLStub", new StringBuilder().append(r14).append(r30).append(r15).append(r110).append(r15).append(r13).append(r15).append(r12).append(r15).append(r34).append(r15).append(r35).append(r15).append(r36).append(r15).append(r37).append(r15).append(r38).append(r15).append(r39).append(r15).append(r40).append(r15).append(r46).append(r15).append(r42).append(r15).append(r43).append(r15).append(r44).append(r15).append(r5).append(") = fail").toString(), r9, r0);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttpV2", r9, r0, r111);
        throw r9;
    L64:
        List r11 = r46;
        r46 = r11;
        com.obric.aiagent.ipc.utils.k.f18677a.b(r17, r14 + r30 + r15 + r110 + r15 + r13 + r15 + r12 + r15 + r34 + r15 + r35 + r15 + r36 + r15 + r37 + r15 + r38 + r15 + r39 + r15 + r40 + r15 + r11 + r15 + r42 + r15 + r43 + r15 + r44 + r15 + r5 + ") = void", r7);     // Catch: Exception -> L76
        r5 = r5;
        r34 = r34;
        r17 = r17;
        r12 = r12;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowNetworkIDLStub", "uploadOmniDataFeedbackByHttpV2", r7, r8);     // Catch: Exception -> L74
        return;
    L74:
        e = e;
    L76:
        e = e;
        r17 = r17;
        r12 = r12;
        r13 = r13;
        r5 = r5;
        r34 = r34;
    L78:
        e = e;
        r5 = r5;
    L82:
        r34 = r34;
    L80:
        e = e;
        r46 = r11;
    L85:
        e = e;
        r34 = r34;
    L88:
        e = e;
        r17 = r17;
        r13 = r13;
        r14 = r14;
    L102:
        r12 = r33;
    L90:
        e = e;
    L94:
        r13 = r32;
        r17 = r17;
        r14 = r14;
    L92:
        e = e;
        r110 = r31;
    L95:
        e = e;
    L99:
        r110 = r31;
        r13 = r32;
        r17 = r17;
        r15 = r6;
        r14 = r14;
    L97:
        e = e;
        r30 = r30;
    L100:
        e = e;
        r30 = r30;
        r110 = r31;
        r13 = r32;
        r17 = r17;
        r15 = r6;
        r14 = r25;
        goto L102
    L48:
        r17 = r27;
    L103:
        e = e;
        r30 = r30;
        r110 = r31;
        r13 = r32;
        r12 = r33;
        r34 = r34;
        r15 = r6;
        r14 = r25;
        r17 = r27;
        goto L111
    L29:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L41;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L41;
        r16 = r2;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L37;
        Object r10 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r1), true);     // Catch: Exception -> L39
    L38:
        r4 = r16;
        r22 = r10;
        goto L42
    L37:
        r10 = an.a(r5, true);     // Catch: Exception -> L39
    L39:
        e = e;
    L40:
        r23 = r16;
    L107:
        r14 = r22;
    L108:
        String r28 = r17;
        r110 = r31;
        r15 = r19;
        r17 = r28;
    L105:
        e = e;
        r23 = r2;
        goto L107
    L113:
        com.obric.aiagent.ipc.utils.j r20 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L21
        StringBuilder r21 = new StringBuilder().append("uploadOmniDataFeedbackByHttpV2(").append(r30).append(", ").append(r31).append(", ").append(r13).append(", ").append(r12).append(", ").append(r34).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r46).append(", ");     // Catch: Exception -> L19
        r46 = r46;
        r22 = "uploadOmniDataFeedbackByHttpV2(";
        r1 = "com.obric.aiagent.plugin";
        r17 = r17;
        r19 = ", ";
        r2 = r16;
        r20.b(r17, r21.append(r42).append(", ").append(r43).append(", ").append(r44).append(", ").append(r5).append(r2).toString());     // Catch: Exception -> L105
    L14:
        e = e;
    L18:
        r19 = ", ";
    L16:
        e = e;
        r17 = r17;
    L19:
        e = e;
        r46 = r46;
    L23:
        r19 = ", ";
        r5 = r5;
        r12 = r12;
        r13 = r13;
        r23 = r16;
        r14 = "uploadOmniDataFeedbackByHttpV2(";
    L21:
        e = e;
    L109:
        e = e;
        r5 = r5;
        r13 = r13;
        r30 = r30;
        r23 = r16;
        r110 = r31;
        r15 = ", ";
        r12 = r12;
        r14 = "uploadOmniDataFeedbackByHttpV2(";
        goto L111
    }
}
