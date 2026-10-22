package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowNetworkIDLIpcWrapper implements IFlowNetworkIDL {
    boolean log;
    final IFlowNetworkIDL origin;

    FlowNetworkIDLIpcWrapper(IFlowNetworkIDL r3) {
        this((IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowNetworkIDLIpcWrapper(IFlowNetworkIDL r3, boolean r4) {
        this.origin = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r25, boolean r26, IFlowNetworkResultCallbackIDL r27) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r26 + ", " + r8 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r26 + ", " + r8 + ") = fail", r2, r10);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp", r2, r10, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r26 + ", " + r8 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("sendIntentResultForCompensationByHttp(").append(r6).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r13 = r8;
    L21:
        r11.a("IFlowNetworkIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L35:
        r12.sendIntentResultForCompensationByHttp(r6, r26, r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp(" + r6 + ", " + r26 + ", " + r8 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendIntentResultForCompensationByHttp", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r25, boolean r26, IFlowNetworkResultCallbackIDL r27) {
        List<OPushEvent> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r26 + ", " + r8 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r26 + ", " + r8 + ") = fail", r2, r10);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp", r2, r10, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r26 + ", " + r8 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("sendIntentResultForAsyncNotifyByHttp(").append(r6).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r13 = r8;
    L21:
        r11.a("IFlowNetworkIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L35:
        r12.sendIntentResultForAsyncNotifyByHttp(r6, r26, r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp(" + r6 + ", " + r26 + ", " + r8 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendIntentResultForAsyncNotifyByHttp", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendNormalRouterByHttp(String r25, String r26, IFlowNetworkResultCallbackIDL r27) {
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r25 + ", " + r26 + ", " + r7 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r8 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r25 + ", " + r26 + ", " + r7 + ") = fail", r3, r8);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp", r3, r8, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r25 + ", " + r26 + ", " + r7 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("sendNormalRouterByHttp(").append(r25).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r13 = r7;
    L21:
        r11.a("IFlowNetworkIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = an.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r10 = r7;
    L35:
        r12.sendNormalRouterByHttp(r25, r26, r10);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "sendNormalRouterByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp(" + r25 + ", " + r26 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendNormalRouterByHttp", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r10 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r10 = an.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendReplyAskUserByHttp(String r29, String r30, String r31, Map r32, IFlowNetworkResultCallbackIDL r33) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r15 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L48:
        e = e;
        String r4 = r31;
        String r20 = ")";
        long r5 = 0;
    L50:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + r20, e);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L52
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L52
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = fail", r1, r24);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp", r1, r24, r26);     // Catch: Throwable -> L52
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp(" + r29 + ", " + r30 + ", " + r31 + ", " + r14 + ", " + r15 + ")");     // Catch: Exception -> L48 Throwable -> L52
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L48 Throwable -> L52
        StringBuilder r6 = new StringBuilder().append("sendReplyAskUserByHttp(").append(r29).append(", ").append(r30).append(", ").append(r31).append(", ").append(r14).append(", ");     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r7 = r15;
    L21:
        r2.a("IFlowNetworkIDLIPC", r6.append(r7).append(")").toString());     // Catch: Exception -> L48 Throwable -> L52
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
        goto L21
    L19:
        r7 = an.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    L22:
        IFlowNetworkIDL r3 = this.origin;     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L26;
    L35:
        IFlowNetworkResultCallbackIDL r8 = r15;
    L36:
        r20 = ")";
        r3.sendReplyAskUserByHttp(r29, r30, r31, r14, r8);     // Catch: Exception -> L46 Throwable -> L52
        if (this.log == false) goto L40;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp = void");     // Catch: Exception -> L46 Throwable -> L52
    L40:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L52
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L46 Throwable -> L52
        r4 = r31;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp(" + r29 + ", " + r30 + ", " + r4 + ", " + r14 + ", " + r15 + ") = void", r0);     // Catch: Exception -> L44 Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sendReplyAskUserByHttp", r0, r27);     // Catch: Exception -> L44 Throwable -> L52
        return;
    L44:
        e = e;
    L46:
        e = e;
        r4 = r31;
        r5 = 0;
        goto L50
    L26:
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        IFlowNetworkResultCallbackIDL r9 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
    L34:
        r8 = r9;
        goto L36
    L33:
        r9 = an.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttp(long r22) {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r5 = Math.max(0, r19 - r6) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r22 + ") = fail", r3, r5);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp", r3, r5, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTaskByHttp(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp(" + r22 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttp", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public int getCurrentNetworkStatus() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getCurrentNetworkStatus();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "getCurrentNetworkStatus = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "getCurrentNetworkStatus", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    /* JADX WARN: Not initialized variable reg: 21, insn: 0x01ea: MOVE (r12 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY]), block:B:70:0x01e7 */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadUserTakeOverByHttp(String r25, String r26, String r27, long r28, Map r30, IFlowNetworkResultCallbackIDL r31) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r31, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L71:
        e = e;
        Map r12 = r5;
        String r13 = ", ";
        String r21 = "IFlowNetworkIDLIPC";
        String r20 = ")";
        IFlowNetworkResultCallbackIDL r14 = r6;
    L73:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r21, "uploadUserTakeOverByHttp(" + r25 + r13 + r26 + r13 + r27 + r13 + r28 + r13 + r12 + r13 + r14 + r20, e);     // Catch: Throwable -> L75
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L75
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L75
        long r8 = Math.max(0, r7 - r16) / 1000;     // Catch: Throwable -> L75
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp(" + r25 + r13 + r26 + r13 + r27 + r13 + r28 + r13 + r12 + r13 + r14 + ") = fail", r1, r8);     // Catch: Throwable -> L75
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp", r1, r8, r7);     // Catch: Throwable -> L75
        return;
    L4:
        if (this.log == false) goto L85;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp(" + r25 + ", " + r26 + ", " + r27 + ", " + r28 + ", " + r5 + ", " + r6 + ")");     // Catch: Exception -> L71 Throwable -> L75
    L85:
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L71 Throwable -> L75
        StringBuilder r4 = new StringBuilder().append("uploadUserTakeOverByHttp(").append(r25).append(", ").append(r26).append(", ").append(r27).append(", ").append(r28).append(", ").append(r5).append(", ");     // Catch: Exception -> L71 Throwable -> L75
        if (r6 != null) goto L12;
    L22:
        IFlowNetworkResultCallbackIDL r3 = r6;
    L23:
        r2.a("IFlowNetworkIDLIPC", r4.append(r3).append(")").toString());     // Catch: Exception -> L69 Throwable -> L75
    L25:
        IFlowNetworkIDL r9 = this.origin;     // Catch: Exception -> L69 Throwable -> L75
        if (r6 != null) goto L29;
    L38:
        IFlowNetworkResultCallbackIDL r22 = r6;
    L39:
        Map r32 = r5;
        r21 = "IFlowNetworkIDLIPC";
        r9.uploadUserTakeOverByHttp(r25, r26, r27, r28, r32, r22);     // Catch: Exception -> L66 Throwable -> L75
        if (this.log == false) goto L43;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r21, "uploadUserTakeOverByHttp = void");     // Catch: Exception -> L66 Throwable -> L75
    L43:
        long r10 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L66 Throwable -> L75
        long r11 = Math.max(0, r10 - r16) / 1000;     // Catch: Exception -> L66 Throwable -> L75
        com.obric.aiagent.ipc.utils.k r0 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L66 Throwable -> L75
        r13 = ", ";
        r20 = ")";
        r14 = r6;
        StringBuilder r15 = new StringBuilder().append("uploadUserTakeOverByHttp(").append(r25).append(r13).append(r26).append(r13).append(r27).append(r13).append(r28).append(r13).append(r32).append(r13).append(r14);     // Catch: Exception -> L59 Throwable -> L75
        r32 = r32;
        r0.a(r21, r15.append(") = void").toString(), r11);     // Catch: Exception -> L57 Throwable -> L75
        r21 = r21;
        r12 = r32;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadUserTakeOverByHttp", r11, r10);     // Catch: Exception -> L55 Throwable -> L75
        return;
    L55:
        e = e;
    L57:
        e = e;
    L68:
        r12 = r32;
    L59:
        e = e;
    L63:
        r12 = r32;
    L61:
        e = e;
        r20 = ")";
        r14 = r6;
    L64:
        e = e;
        r20 = ")";
        r14 = r6;
    L66:
        e = e;
        r20 = ")";
        r14 = r6;
        r13 = ", ";
        goto L68
    L29:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L38;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L38;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L36;
        IFlowNetworkResultCallbackIDL r17 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L69 Throwable -> L75
    L37:
        r22 = r17;
        goto L39
    L36:
        r17 = an.a(r6, true);     // Catch: Exception -> L69 Throwable -> L75
        goto L37
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L21;
        r3 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L69 Throwable -> L75
        goto L23
    L21:
        r3 = an.a(r6, true);     // Catch: Exception -> L69 Throwable -> L75
        goto L23
    L24:
        r5 = r5;
    L69:
        e = e;
        r13 = ", ";
        r20 = ")";
        r12 = r21;
        r14 = r6;
        r21 = "IFlowNetworkIDLIPC";
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11391. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttp(java.lang.String r27, java.lang.String r28, int r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.util.List<java.lang.String> r34, java.lang.String r35, java.lang.String r36, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL r37) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: MOVE (r7v0 ?? I:??[OBJECT, ARRAY]) = (r36v0 java.lang.String) A[DECLARE_VAR] in method: com.obric.aiagent.assistant.idl.FlowNetworkIDLIpcWrapper.uploadOmniScreenshotByHttp(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List<java.lang.String>, java.lang.String, java.lang.String, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL):void, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.assistant.idl.FlowNetworkIDLIpcWrapper.uploadOmniScreenshotByHttp(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL):void");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyUserOperateQueue(String r25, IFlowNetworkResultCallbackIDL r26) {
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("notifyUserOperateQueue(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowNetworkIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r11 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = an.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r9 = r6;
    L35:
        r12.notifyUserOperateQueue(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "notifyUserOperateQueue = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyUserOperateQueue", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r9 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = an.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopOmniTaskByHttp(String r25, Map r26, IFlowNetworkResultCallbackIDL r27) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r25 + ", " + r6 + ", " + r8 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r25 + ", " + r6 + ", " + r8 + ") = fail", r2, r10);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp", r2, r10, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r25 + ", " + r6 + ", " + r8 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("notifyStopOmniTaskByHttp(").append(r25).append(", ").append(r6).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r13 = r8;
    L21:
        r11.a("IFlowNetworkIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L35:
        r12.notifyStopOmniTaskByHttp(r25, r6, r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp(" + r25 + ", " + r6 + ", " + r8 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopOmniTaskByHttp", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void clearOmniTasks(Map r23, IFlowNetworkResultCallbackIDL r24) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r7 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r24, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r5 + ", " + r7 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r5 + ", " + r7 + ") = fail", r1, r9);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "clearOmniTasks", r1, r9, r20);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r5 + ", " + r7 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("clearOmniTasks(").append(r5).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r11 = r7;
    L21:
        r14.a("IFlowNetworkIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r11 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = an.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r6 = r7;
    L35:
        r12.clearOmniTasks(r5, r6);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "clearOmniTasks = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r19 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "clearOmniTasks(" + r5 + ", " + r7 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "clearOmniTasks", r13, r19);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r6 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r6 = an.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttpWithScene(long r23, String r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = fail", r4, r7);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene", r4, r7, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTaskByHttpWithScene(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene(" + r23 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "notifyStopComplexTaskByHttpWithScene", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.obric.aiagent.assistant.idl.IFlowNetworkIDL] */
    /* JADX WARN: Type inference failed for: r1v51, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r45v12 */
    /* JADX WARN: Type inference failed for: r45v13, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r45v14 */
    /* JADX WARN: Type inference failed for: r45v15 */
    /* JADX WARN: Type inference failed for: r45v16 */
    /* JADX WARN: Type inference failed for: r45v22 */
    /* JADX WARN: Type inference failed for: r45v23 */
    /* JADX WARN: Type inference failed for: r45v28 */
    /* JADX WARN: Type inference failed for: r45v29 */
    /* JADX WARN: Type inference failed for: r45v3 */
    /* JADX WARN: Type inference failed for: r45v5 */
    /* JADX WARN: Type inference failed for: r45v9 */
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
    public void createConditionalTask(String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, Map r45, IFlowNetworkResultCallbackIDL r46) {
        String r14 = r32;
        String r13 = r33;
        String r17 = "IFlowNetworkIDLIPC";
        String r2 = ", ";
        Map r47 = (Map) ZeusTransformUtils.wrapperContextForParams(r45, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r46, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
    L130:
        e = e;
        Map r48 = r47;
    L132:
        String r15 = r31;
        String r26 = ")";
        Map r49 = r48;
    L133:
        ?? r410 = r49;
    L134:
        String r16 = ", ";
        String r3 = r35;
        String r11 = r34;
        String r12 = "createConditionalTask(";
    L135:
        com.obric.aiagent.ipc.utils.j r1 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Throwable -> L137
        String r4 = r13;
        ?? r6 = new StringBuilder().append(r12).append(r15).append(r16).append(r14).append(r16).append(r13).append(r16).append(r11).append(r16).append(r3).append(r16).append(r36).append(r16).append(r37).append(r16).append(r38).append(r16).append(r39).append(r16).append(r40).append(r16).append(r41).append(r16).append(r42).append(r16).append(r43).append(r16).append(r44).append(r16);     // Catch: Throwable -> L137
        ?? r10 = r410;
        StringBuilder r7 = r6.append(r10).append(r16);     // Catch: Throwable -> L137
        IFlowNetworkResultCallbackIDL r19 = r5;
        r1.a(r17, r7.append(r19).append(r26).toString(), e);     // Catch: Throwable -> L137
        com.obric.aiagent.ipc.utils.g r8 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L137
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L137
        long r0 = Math.max(0, r110 - r18) / 1000;     // Catch: Throwable -> L137
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", r12 + r15 + r16 + r14 + r16 + r4 + r16 + r11 + r16 + r3 + r16 + r36 + r16 + r37 + r16 + r38 + r16 + r39 + r16 + r40 + r16 + r41 + r16 + r42 + r16 + r43 + r16 + r44 + r16 + r10 + r16 + r19 + ") = fail", r8, r0);     // Catch: Throwable -> L137
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "createConditionalTask", r8, r0, r110);     // Catch: Throwable -> L137
        return;
    L4:
        if (this.log == false) goto L16;
        com.obric.aiagent.ipc.utils.j r9 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L130 Throwable -> L137
        String r20 = r17;
        StringBuilder r21 = new StringBuilder().append("createConditionalTask(").append(r31).append(", ").append(r14).append(", ").append(r13).append(", ").append(r34).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r41).append(", ").append(r42).append(", ").append(r43).append(", ").append(r44).append(", ").append(r47).append(", ").append(r5);     // Catch: Exception -> L12 Throwable -> L137
        Map r411 = r47;
        r26 = ")";
        r9.a(r20, r21.append(r26).toString());     // Catch: Exception -> L128 Throwable -> L137
        r411 = r411;
    L17:
        if (this.log == true) goto L153;
        Map r22 = r411;
        String r111 = "createConditionalTask(";
        r2 = ", ";
        String r112 = r20;
        String r23 = "com.obric.aiagent.plugin";
    L51:
        ?? r24 = this.origin;     // Catch: Exception -> L126 Throwable -> L137
        if (r5 != null) goto L55;
    L64:
        IFlowNetworkResultCallbackIDL r25 = r5;
    L65:
        String r27 = r111;
        String r28 = r2;
        r5 = r5;
        r410 = r22;
        r26 = r26;
        String r29 = r112;
        r24.createConditionalTask(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r410, r25);     // Catch: Exception -> L124 Throwable -> L137
        if (this.log == false) goto L71;
        r17 = r29;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r17, "createConditionalTask = void");     // Catch: Exception -> L121 Throwable -> L137
    L72:
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L121 Throwable -> L137
        long r50 = Math.max(0, r30 - r18) / 1000;     // Catch: Exception -> L121 Throwable -> L137
        com.obric.aiagent.ipc.utils.k r51 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L121 Throwable -> L137
        r12 = r27;
        r15 = r31;
        r16 = r28;
        r14 = r32;
        r13 = r33;
        StringBuilder r52 = new StringBuilder().append(r12).append(r15).append(r16).append(r14).append(r16).append(r13).append(r16).append(r34).append(r16).append(r35).append(r16).append(r36).append(r16).append(r37).append(r16).append(r38).append(r16).append(r39).append(r16).append(r40).append(r16).append(r41).append(r16).append(r42).append(r16).append(r43).append(r16).append(r44).append(r16).append(r410).append(r16);     // Catch: Exception -> L101 Throwable -> L137
        r410 = r410;
        r51.a(r17, r52.append(r5).append(") = void").toString(), r50);     // Catch: Exception -> L97 Throwable -> L137
        r17 = r17;
        r3 = r35;
        r5 = r5;
        r11 = r34;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "createConditionalTask", r50, r30);     // Catch: Exception -> L95 Throwable -> L137
        return;
    L95:
        e = e;
    L97:
        e = e;
        r5 = r5;
        r3 = r35;
        r410 = r410;
    L103:
        r11 = r34;
    L99:
        e = e;
        r3 = r35;
        r5 = r5;
        r410 = r410;
    L101:
        e = e;
        r3 = r35;
        r410 = r410;
    L104:
        e = e;
        r17 = r17;
        r3 = r35;
        r11 = r34;
        r13 = r13;
    L106:
        e = e;
        r11 = r34;
    L110:
        r13 = r13;
    L123:
        r3 = r35;
    L108:
        e = e;
        r11 = r34;
    L111:
        e = e;
    L115:
        r13 = r33;
        r11 = r34;
        r17 = r17;
    L113:
        e = e;
        r14 = r32;
    L116:
        e = e;
    L120:
        r14 = r32;
        r13 = r33;
        r11 = r34;
        r17 = r17;
        r16 = r28;
    L118:
        e = e;
        r15 = r31;
    L121:
        e = e;
        r15 = r31;
        r14 = r32;
        r13 = r33;
        r11 = r34;
        r17 = r17;
        r16 = r28;
        r12 = r27;
        goto L123
    L71:
        r17 = r29;
    L124:
        e = e;
        r15 = r31;
        r14 = r32;
        r13 = r33;
        r11 = r34;
        r3 = r35;
        r16 = r28;
        r12 = r27;
        r17 = r29;
        goto L135
    L55:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L62;
        IFlowNetworkResultCallbackIDL r53 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r23), true);     // Catch: Exception -> L126 Throwable -> L137
    L63:
        r25 = r53;
        goto L65
    L62:
        r53 = an.a(r5, true);     // Catch: Exception -> L126 Throwable -> L137
        goto L63
    L153:
        com.obric.aiagent.ipc.utils.j r54 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L48 Throwable -> L137
        r112 = r20;
        Map r55 = r411;
        StringBuilder r56 = new StringBuilder().append("createConditionalTask(").append(r31).append(", ").append(r14).append(", ").append(r13).append(", ").append(r34).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r41).append(", ").append(r42).append(", ").append(r43).append(", ").append(r44).append(", ").append(r55).append(", ");     // Catch: Exception -> L43 Throwable -> L137
        if (r5 != null) goto L27;
        r111 = "createConditionalTask(";
    L26:
        r23 = r22;
        IFlowNetworkResultCallbackIDL r57 = r5;
    L40:
        r54.a(r112, r56.append(r57).append(r26).toString());     // Catch: Exception -> L126 Throwable -> L137
        r22 = r55;
        goto L51
    L27:
        r111 = "createConditionalTask(";
    L41:
        e = e;
        r5 = r5;
        r26 = r26;
        r410 = r55;
        r13 = r13;
        r17 = r112;
        r15 = r31;
        r14 = r14;
        r16 = ", ";
        r3 = r35;
        r11 = r34;
        r12 = r111;
        goto L135
    L29:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == true) goto L36;
        r23 = r22;
        r57 = an.a(r5, true);     // Catch: Exception -> L126 Throwable -> L137
        goto L40
    L36:
        r23 = r22;
        r57 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r23), true);     // Catch: Exception -> L126 Throwable -> L137
    L43:
        e = e;
        Map r412 = r55;
    L47:
        r17 = r112;
        r15 = r31;
        r49 = r412;
    L45:
        e = e;
        r412 = r411;
    L48:
        e = e;
        r5 = r5;
        r26 = r26;
        r17 = r20;
        r13 = r13;
        r15 = r31;
        r410 = r411;
    L126:
        e = e;
        r5 = r5;
        r26 = r26;
        r410 = r38;
        r3 = r35;
        r11 = r34;
        r13 = r13;
        r12 = ")";
        r15 = r31;
        r14 = r14;
        r16 = r17;
        r17 = r31;
    L128:
        e = e;
        r5 = r5;
        r26 = r26;
        r17 = r20;
        r15 = r31;
        r49 = r411;
    L12:
        e = e;
        r47 = r47;
    L15:
        r17 = r20;
        r48 = r47;
    L14:
        e = e;
        goto L15
    L16:
        r26 = ")";
        r20 = r17;
        r411 = r47;
        goto L17
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r25, IFlowNetworkResultCallbackIDL r26) {
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sweepConditionalTask", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("sweepConditionalTask(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowNetworkIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r11 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = an.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r9 = r6;
    L35:
        r12.sweepConditionalTask(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "sweepConditionalTask = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "sweepConditionalTask(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "sweepConditionalTask", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r9 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = an.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void deleteConditionalTask(String r25, Map r26, IFlowNetworkResultCallbackIDL r27) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r8 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r25 + ", " + r6 + ", " + r8 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r10 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r25 + ", " + r6 + ", " + r8 + ") = fail", r2, r10);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "deleteConditionalTask", r2, r10, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r25 + ", " + r6 + ", " + r8 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("deleteConditionalTask(").append(r25).append(", ").append(r6).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L12;
    L20:
        IFlowNetworkResultCallbackIDL r13 = r8;
    L21:
        r11.a("IFlowNetworkIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowNetworkIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r8 != null) goto L26;
    L34:
        IFlowNetworkResultCallbackIDL r7 = r8;
    L35:
        r12.deleteConditionalTask(r25, r6, r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowNetworkIDLIPC", "deleteConditionalTask = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", "deleteConditionalTask(" + r25 + ", " + r6 + ", " + r8 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "deleteConditionalTask", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r8, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L33;
        r7 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r8, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = an.a(r8, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttp(String r30, String r31, int r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, List<String> r41, String r42, String r43, IFlowNetworkResultCallbackIDL r44) {
        String r15 = r30;
        int r13 = r32;
        String r12 = r33;
        String r11 = r34;
        String r16 = ")";
        String r17 = "IFlowNetworkIDLIPC";
        String r2 = ", ";
        List<String> r45 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r44, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        r2 = "com.obric.aiagent.plugin";
    L136:
        e = e;
    L138:
        String r24 = r16;
    L139:
        String r19 = r31;
        String r14 = ", ";
        r11 = r11;
        r12 = r12;
        String r110 = "uploadOmniDataFeedbackByHttp(";
    L140:
        com.obric.aiagent.ipc.utils.j r1 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Throwable -> L142
        int r4 = r13;
        List<String> r9 = r45;
        StringBuilder r3 = new StringBuilder().append(r110).append(r15).append(r14).append(r19).append(r14).append(r13).append(r14).append(r12).append(r14).append(r11).append(r14).append(r35).append(r14).append(r36).append(r14).append(r37).append(r14).append(r38).append(r14).append(r39).append(r14).append(r40).append(r14).append(r9).append(r14).append(r42).append(r14).append(r43).append(r14);     // Catch: Throwable -> L142
        IFlowNetworkResultCallbackIDL r10 = r5;
        r1.a(r17, r3.append(r10).append(r24).toString(), e);     // Catch: Throwable -> L142
        com.obric.aiagent.ipc.utils.g r6 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L142
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L142
        long r0 = Math.max(0, r111 - r18) / 1000;     // Catch: Throwable -> L142
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", r110 + r15 + r14 + r19 + r14 + r4 + r14 + r12 + r14 + r11 + r14 + r35 + r14 + r36 + r14 + r37 + r14 + r38 + r14 + r39 + r14 + r40 + r14 + r9 + r14 + r42 + r14 + r43 + r14 + r10 + ") = fail", r6, r0);     // Catch: Throwable -> L142
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttp", r6, r0, r111);     // Catch: Throwable -> L142
        return;
    L4:
        if (this.log == false) goto L18;
        com.obric.aiagent.ipc.utils.j r7 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L136 Throwable -> L142
        StringBuilder r8 = new StringBuilder().append("uploadOmniDataFeedbackByHttp(").append(r15).append(", ").append(r31).append(", ").append(r13).append(", ").append(r12).append(", ").append(r11).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r45).append(", ");     // Catch: Exception -> L16 Throwable -> L142
        r45 = r45;
        String r20 = r8.append(r42).append(", ").append(r43).append(", ").append(r5).append(r16).toString();     // Catch: Exception -> L14 Throwable -> L142
        r16 = r16;
        String r21 = r17;
        r7.a(r21, r20);     // Catch: Exception -> L134 Throwable -> L142
    L20:
        if (this.log == true) goto L183;
        r17 = "uploadOmniDataFeedbackByHttp(";
        r2 = ", ";
        String r22 = r16;
        String r23 = r2;
    L54:
        IFlowNetworkIDL r25 = this.origin;     // Catch: Exception -> L131 Throwable -> L142
        if (r5 != null) goto L58;
    L67:
        IFlowNetworkResultCallbackIDL r112 = r5;
    L68:
        String r26 = r17;
        String r27 = r22;
        String r28 = r21;
        String r29 = r2;
        r24 = r27;
        r5 = r5;
        r25.uploadOmniDataFeedbackByHttp(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r45, r42, r43, r112);     // Catch: Exception -> L129 Throwable -> L142
        if (this.log == false) goto L74;
        r17 = r28;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r17, "uploadOmniDataFeedbackByHttp = void");     // Catch: Exception -> L126 Throwable -> L142
    L75:
        long r46 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L126 Throwable -> L142
        long r47 = Math.max(0, r46 - r18) / 1000;     // Catch: Exception -> L126 Throwable -> L142
        r110 = r26;
        r15 = r30;
        r14 = r29;
        r19 = r31;
        r13 = r32;
    L109:
        e = e;
        r17 = r17;
        r11 = r34;
        r12 = r33;
        r13 = r13;
        goto L140
    L90:
        List<String> r113 = r45;
        r45 = r113;
        com.obric.aiagent.ipc.utils.k.f18677a.a(r17, r110 + r15 + r14 + r19 + r14 + r13 + r14 + r33 + r14 + r34 + r14 + r35 + r14 + r36 + r14 + r37 + r14 + r38 + r14 + r39 + r14 + r40 + r14 + r113 + r14 + r42 + r14 + r43 + r14 + r5 + ") = void", r47);     // Catch: Exception -> L102 Throwable -> L142
        r17 = r17;
        r11 = r34;
        r5 = r5;
        r12 = r33;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadOmniDataFeedbackByHttp", r47, r46);     // Catch: Exception -> L100 Throwable -> L142
        return;
    L100:
        e = e;
    L102:
        e = e;
        r5 = r5;
        r11 = r34;
    L108:
        r12 = r33;
    L104:
        e = e;
        r11 = r34;
        r5 = r5;
    L106:
        e = e;
        r11 = r34;
        r45 = r113;
    L111:
        e = e;
        r12 = r33;
    L115:
        r13 = r13;
    L128:
        r11 = r34;
    L113:
        e = e;
        r12 = r33;
    L116:
        e = e;
    L120:
        r13 = r32;
        r12 = r33;
        r17 = r17;
    L118:
        e = e;
        r19 = r31;
    L121:
        e = e;
    L125:
        r19 = r31;
        r13 = r32;
        r12 = r33;
        r17 = r17;
        r14 = r29;
    L123:
        e = e;
        r15 = r30;
    L126:
        e = e;
        r15 = r30;
        r19 = r31;
        r13 = r32;
        r12 = r33;
        r17 = r17;
        r14 = r29;
        r110 = r26;
        goto L128
    L74:
        r17 = r28;
    L129:
        e = e;
        r15 = r30;
        r19 = r31;
        r13 = r32;
        r12 = r33;
        r11 = r34;
        r17 = r28;
        r14 = r29;
        r110 = r26;
        goto L140
    L58:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L65;
        IFlowNetworkResultCallbackIDL r48 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r23), true);     // Catch: Exception -> L131 Throwable -> L142
    L66:
        r112 = r48;
        goto L68
    L65:
        r48 = an.a(r5, true);     // Catch: Exception -> L131 Throwable -> L142
        goto L66
    L183:
        com.obric.aiagent.ipc.utils.j r49 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L51 Throwable -> L142
        List<String> r50 = r45;
        r45 = r50;
        StringBuilder r51 = new StringBuilder().append("uploadOmniDataFeedbackByHttp(").append(r15).append(", ").append(r31).append(", ").append(r13).append(", ").append(r12).append(", ").append(r11).append(", ").append(r35).append(", ").append(r36).append(", ").append(r37).append(", ").append(r38).append(", ").append(r39).append(", ").append(r40).append(", ").append(r50).append(", ").append(r42).append(", ").append(r43).append(", ");     // Catch: Exception -> L134 Throwable -> L142
        if (r5 != null) goto L29;
        r17 = "uploadOmniDataFeedbackByHttp(";
    L28:
        r23 = r2;
        IFlowNetworkResultCallbackIDL r52 = r5;
    L42:
        StringBuilder r53 = r51.append(r52);     // Catch: Exception -> L45 Throwable -> L142
        r22 = r16;
        r49.a(r21, r53.append(r22).toString());     // Catch: Exception -> L131 Throwable -> L142
    L131:
        e = e;
        r24 = r22;
    L133:
        r110 = r17;
        r17 = r21;
        r19 = r31;
        r14 = r2;
        goto L140
    L29:
        r17 = "uploadOmniDataFeedbackByHttp(";
    L47:
        e = e;
        r5 = r5;
        r13 = r13;
        r15 = r15;
        r24 = r16;
        r19 = r31;
        r14 = ", ";
        r11 = r11;
        r12 = r12;
        r110 = r17;
        r17 = r21;
        goto L140
    L31:
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L28;
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L28;
        if (ZeusTransformUtils.instanceOf(r5, IFlowNetworkResultCallbackIDL.Stub.class) == true) goto L38;
        r23 = r2;
        r52 = an.a(r5, true);     // Catch: Exception -> L45 Throwable -> L142
        goto L42
    L38:
        r23 = r2;
        r52 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r5, IFlowNetworkResultCallbackIDL.Stub.class, r23), true);     // Catch: Exception -> L45 Throwable -> L142
    L45:
        e = e;
        r24 = r16;
    L49:
        e = e;
        r17 = r21;
        r45 = r50;
    L51:
        e = e;
    L135:
        r17 = r21;
    L134:
        e = e;
    L14:
        e = e;
        r5 = r5;
        r24 = r16;
    L16:
        e = e;
        r45 = r45;
        goto L138
    L18:
        r21 = r17;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL] */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.obric.aiagent.assistant.idl.IFlowNetworkIDL] */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v21 */
    /* JADX WARN: Type inference failed for: r25v22 */
    /* JADX WARN: Type inference failed for: r25v23 */
    /* JADX WARN: Type inference failed for: r25v24 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r35v10 */
    /* JADX WARN: Type inference failed for: r35v11 */
    /* JADX WARN: Type inference failed for: r35v12 */
    /* JADX WARN: Type inference failed for: r35v19 */
    /* JADX WARN: Type inference failed for: r35v20 */
    /* JADX WARN: Type inference failed for: r35v21 */
    /* JADX WARN: Type inference failed for: r35v5 */
    /* JADX WARN: Type inference failed for: r35v6 */
    /* JADX WARN: Type inference failed for: r35v7 */
    /* JADX WARN: Type inference failed for: r39v10 */
    /* JADX WARN: Type inference failed for: r39v11 */
    /* JADX WARN: Type inference failed for: r39v12 */
    /* JADX WARN: Type inference failed for: r39v13 */
    /* JADX WARN: Type inference failed for: r39v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r39v15 */
    /* JADX WARN: Type inference failed for: r39v16 */
    /* JADX WARN: Type inference failed for: r39v17 */
    /* JADX WARN: Type inference failed for: r39v18 */
    /* JADX WARN: Type inference failed for: r39v19 */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r39v20 */
    /* JADX WARN: Type inference failed for: r39v21 */
    /* JADX WARN: Type inference failed for: r39v22 */
    /* JADX WARN: Type inference failed for: r39v23 */
    /* JADX WARN: Type inference failed for: r39v24 */
    /* JADX WARN: Type inference failed for: r39v25 */
    /* JADX WARN: Type inference failed for: r39v26 */
    /* JADX WARN: Type inference failed for: r39v27 */
    /* JADX WARN: Type inference failed for: r39v28 */
    /* JADX WARN: Type inference failed for: r39v29 */
    /* JADX WARN: Type inference failed for: r39v4 */
    /* JADX WARN: Type inference failed for: r39v5 */
    /* JADX WARN: Type inference failed for: r39v7 */
    /* JADX WARN: Type inference failed for: r39v8 */
    /* JADX WARN: Type inference failed for: r39v9 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v55, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
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
    public void uploadOmniScreenshotByHttpV2(String r28, String r29, int r30, String r31, String r32, String r33, String r34, List<String> r35, String r36, String r37, boolean r38, IFlowNetworkResultCallbackIDL r39) {
        String r14 = r28;
        String r15 = r29;
        int r13 = r30;
        String r12 = r31;
        r32 = r32;
        String r16 = "IFlowNetworkIDLIPC";
        String r17 = ")";
        ?? r5 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        IFlowNetworkResultCallbackIDL r6 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r39, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r18 = SystemClock.elapsedRealtimeNanos();
        IFlowNetworkResultCallbackIDL r310 = r6;
    L133:
        e = e;
    L134:
        ?? r25 = r310;
    L135:
        List r311 = r5;
        ?? r26 = r25;
    L136:
        String r24 = r17;
        ?? r27 = r26;
        ?? r312 = r311;
    L137:
        String r19 = ", ";
        String r110 = "uploadOmniScreenshotByHttpV2(";
    L138:
        ?? r7 = r312;
        ?? r8 = r27;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r16, r110 + r14 + r19 + r15 + r19 + r13 + r19 + r12 + r19 + r32 + r19 + r33 + r19 + r34 + r19 + r7 + r19 + r36 + r19 + r37 + r19 + r38 + r19 + r8 + r24, e);     // Catch: Throwable -> L140
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L140
        long r111 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L140
        long r0 = Math.max(0, r111 - r18) / 1000;     // Catch: Throwable -> L140
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowNetworkIDLIPC", r110 + r14 + r19 + r15 + r19 + r13 + r19 + r12 + r19 + r32 + r19 + r33 + r19 + r34 + r19 + r7 + r19 + r36 + r19 + r37 + r19 + r38 + r19 + r8 + ") = fail", r1, r0);     // Catch: Throwable -> L140
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttpV2", r1, r0, r111);     // Catch: Throwable -> L140
        return;
    L4:
        if (this.log == true) goto L178;
        String r9 = r37;
        String r3 = r16;
        r5 = r310;
    L21:
        if (this.log == true) goto L141;
        ?? r10 = r5;
        String r23 = ", ";
        r110 = "uploadOmniScreenshotByHttpV2(";
        r5 = r5;
        String r11 = r17;
        String r4 = "com.obric.aiagent.plugin";
    L58:
        ?? r2 = this.origin;     // Catch: Exception -> L127 Throwable -> L140
        if (r10 != 0) goto L62;
    L71:
        ?? r112 = r10;
    L72:
        String r20 = r23;
        String r22 = r11;
        String r21 = r3;
        r110 = r110;
        r312 = r5;
        r24 = r22;
        r27 = r10;
        r2.uploadOmniScreenshotByHttpV2(r28, r29, r30, r31, r32, r33, r34, r312, r36, r37, r38, r112);     // Catch: Exception -> L125 Throwable -> L140
        if (this.log == false) goto L76;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r21, "uploadOmniScreenshotByHttpV2 = void");     // Catch: Exception -> L125 Throwable -> L140
    L76:
        long r40 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L125 Throwable -> L140
        long r41 = Math.max(0, r40 - r18) / 1000;     // Catch: Exception -> L125 Throwable -> L140
        com.obric.aiagent.ipc.utils.k r42 = com.obric.aiagent.ipc.utils.k.f18677a;     // Catch: Exception -> L125 Throwable -> L140
        r14 = r28;
        r16 = r21;
        r19 = r20;
        r15 = r29;
        r13 = r30;
    L108:
        e = e;
        r32 = r32;
        ?? r313 = r312;
    L112:
        r13 = r13;
        r27 = r27;
        r312 = r313;
    L113:
        r12 = r31;
        goto L138
    L176:
        StringBuilder r43 = new StringBuilder().append(r110).append(r14).append(r19).append(r15).append(r19).append(r13).append(r19).append(r31).append(r19).append(r32).append(r19).append(r33).append(r19).append(r34).append(r19).append(r312).append(r19);     // Catch: Exception -> L105 Throwable -> L140
        r312 = r312;
        r42.a(r16, r43.append(r36).append(r19).append(r37).append(r19).append(r38).append(r19).append(r27).append(") = void").toString(), r41);     // Catch: Exception -> L101 Throwable -> L140
        r27 = r27;
        r32 = r32;
        r16 = r16;
        r12 = r31;
        r13 = r13;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowNetworkIDLIPC", "uploadOmniScreenshotByHttpV2", r41, r40);     // Catch: Exception -> L99 Throwable -> L140
        return;
    L99:
        e = e;
    L101:
        e = e;
        r13 = r13;
        r27 = r27;
        r32 = r32;
        r312 = r312;
    L103:
        e = e;
        ?? r210 = r27;
        ?? r314 = r312;
    L107:
        r32 = r32;
        r27 = r210;
        r312 = r314;
    L105:
        e = e;
        r314 = r312;
        r210 = r27;
    L110:
        e = e;
        r32 = r32;
        r313 = r312;
    L114:
        e = e;
        r13 = r13;
    L124:
        r12 = r31;
    L116:
        e = e;
    L120:
        r13 = r30;
    L118:
        e = e;
        r15 = r29;
    L122:
        e = e;
        r15 = r29;
        r13 = r30;
        r32 = r32;
        r19 = r20;
    L125:
        e = e;
        r14 = r28;
        r13 = r30;
        r12 = r31;
        r32 = r32;
        r16 = r21;
        r19 = r20;
        r15 = r29;
        goto L138
    L62:
        if (ZeusTransformUtils.instanceOf(r10, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L71;
        if (ZeusTransformUtils.instanceOf(r10, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L71;
        if (ZeusTransformUtils.instanceOf(r10, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L69;
        IInterface r44 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r10, IFlowNetworkResultCallbackIDL.Stub.class, r4), true);     // Catch: Exception -> L127 Throwable -> L140
    L70:
        r112 = r44;
        goto L72
    L69:
        r44 = an.a(r10, true);     // Catch: Exception -> L127 Throwable -> L140
        goto L70
    L141:
        com.obric.aiagent.ipc.utils.j r45 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L55 Throwable -> L140
        StringBuilder r46 = new StringBuilder().append("uploadOmniScreenshotByHttpV2(").append(r14).append(", ").append(r15).append(", ").append(r13).append(", ").append(r12).append(", ").append(r32).append(", ").append(r33).append(", ").append(r34).append(", ").append(r5).append(", ").append(r36).append(", ").append(r9).append(", ");     // Catch: Exception -> L55 Throwable -> L140
        ?? r47 = r5;
        r110 = "uploadOmniScreenshotByHttpV2(";
        ?? r48 = r46.append(r38).append(", ");     // Catch: Exception -> L53 Throwable -> L140
        if (r47 != 0) goto L29;
        r23 = ", ";
    L28:
        r4 = r3;
        ?? r49 = r47;
    L44:
        StringBuilder r50 = r48.append(r49);     // Catch: Exception -> L47 Throwable -> L140
        r11 = r17;
        r45.a(r3, r50.append(r11).toString());     // Catch: Exception -> L127 Throwable -> L140
        r10 = r47;
    L127:
        e = e;
        ?? r315 = r5;
        r24 = r11;
    L129:
        r19 = r23;
        r27 = r47;
        r312 = r315;
    L130:
        r16 = r3;
        goto L138
    L29:
        r23 = ", ";
        if (ZeusTransformUtils.instanceOf(r47, FlowNetworkResultCallbackIDLIpcWrapper.class) == true) goto L28;
    L41:
        e = e;
        ?? r316 = r5;
    L52:
        r24 = r17;
        r315 = r316;
        goto L129
    L33:
        if (ZeusTransformUtils.instanceOf(r47, FlowNetworkResultCallbackIDLStubWrapper.class) == true) goto L28;
        if (ZeusTransformUtils.instanceOf(r47, IFlowNetworkResultCallbackIDL.Stub.class) == false) goto L40;
        r4 = r3;
        r49 = an.a((IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r47, IFlowNetworkResultCallbackIDL.Stub.class, r4), true);     // Catch: Exception -> L47 Throwable -> L140
        goto L44
    L40:
        r4 = r3;
        r49 = an.a(r47, true);     // Catch: Exception -> L47 Throwable -> L140
    L49:
        e = e;
        ?? r317 = r5;
    L51:
        r316 = r317;
    L47:
        e = e;
        r317 = r5;
    L53:
        e = e;
        r312 = r5;
        r27 = r47;
        r32 = r32;
        r13 = r13;
        r14 = r14;
        r15 = r15;
        r110 = r110;
        r24 = r17;
        r19 = ", ";
    L55:
        e = e;
        r311 = r5;
        r16 = r3;
        r26 = r5;
    L131:
        e = e;
        r25 = r5;
        r16 = r3;
        goto L135
    L178:
        com.obric.aiagent.ipc.utils.j r51 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L18 Throwable -> L140
        r9 = r37;
        StringBuilder r52 = new StringBuilder().append("uploadOmniScreenshotByHttpV2(").append(r14).append(", ").append(r15).append(", ").append(r13).append(", ").append(r12).append(", ").append(r32).append(", ").append(r33).append(", ").append(r34).append(", ").append(r5).append(", ").append(r36).append(", ").append(r9).append(", ").append(r38).append(", ").append(r310);     // Catch: Exception -> L16 Throwable -> L140
        r5 = r310;
        String r53 = r52.append(r17).toString();     // Catch: Exception -> L14 Throwable -> L140
        r17 = r17;
        r3 = r16;
        r51.a(r3, r53);     // Catch: Exception -> L131 Throwable -> L140
        r5 = r5;
    L14:
        e = e;
        r27 = r5;
        r24 = r17;
        r312 = r5;
    L16:
        e = e;
        r310 = r310;
    L18:
        e = e;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 14901. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttpV2(java.lang.String r31, java.lang.String r32, int r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.util.List<java.lang.String> r42, java.lang.String r43, java.lang.String r44, boolean r45, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL r46) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0042: CHECK_CAST (r5v6 ?? I:com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL) = (com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL) (r3v4 java.lang.Object) in method: com.obric.aiagent.assistant.idl.FlowNetworkIDLIpcWrapper.uploadOmniDataFeedbackByHttpV2(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List<java.lang.String>, java.lang.String, java.lang.String, boolean, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL):void, file: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aiagent.assistant.idl.FlowNetworkIDLIpcWrapper.uploadOmniDataFeedbackByHttpV2(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, boolean, com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL):void");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
