package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowUiIDLStubWrapper extends IFlowUiIDL.Stub {
    boolean log;
    final IFlowUiIDL.Stub origin;

    FlowUiIDLStubWrapper(IFlowUiIDL.Stub r2) {
        this(r2, true);
    }

    FlowUiIDLStubWrapper(IFlowUiIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void addCustomBarAction(String r31, String r32, String r33, long r34) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L19:
        e = e;
        long r4 = r34;
        long r10 = 0;
    L21:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r10, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "addCustomBarAction", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L19
    L6:
        r10 = 0;
        this.origin.addCustomBarAction(r31, r32, r33, r34);     // Catch: Exception -> L17
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "addCustomBarAction = void");     // Catch: Exception -> L17
    L11:
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L17
        long r0 = Math.max(0, r25 - r16) / 1000;     // Catch: Exception -> L17
        r4 = r34;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L15
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "addCustomBarAction", r0, r25);     // Catch: Exception -> L15
        return;
    L15:
        e = e;
    L17:
        e = e;
        r4 = r34;
        goto L21
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void handleObricAction(String r26, String r27, IObricActionResultCallbackIDL r28) {
        IObricActionResultCallbackIDL r7 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "handleObricAction(" + r26 + ", " + r27 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "handleObricAction(" + r26 + ", " + r27 + ", " + r7 + ") = fail", r3, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "handleObricAction", r3, r8, r23);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "handleObricAction(" + r26 + ", " + r27 + ", " + r7 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IObricActionResultCallbackIDL r10 = r7;
    L19:
        r11.handleObricAction(r26, r27, r10);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "handleObricAction = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "handleObricAction(" + r26 + ", " + r27 + ", " + r7 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "handleObricAction", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IObricActionResultCallbackIDL.Stub.class) == false) goto L17;
        r10 = ba.a((IObricActionResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IObricActionResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r10 = ba.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void suspendDismissKeyguard(String r29, String[] r30, IDismissKeyguardCallbackIDL r31, boolean r32, Bundle r33) {
        IDismissKeyguardCallbackIDL r15 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r31, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L32:
        e = e;
        Bundle r4 = r33;
        String r20 = ")";
    L34:
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "suspendDismissKeyguard(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + r20, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "suspendDismissKeyguard(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "suspendDismissKeyguard", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "suspendDismissKeyguard(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L32
    L6:
        IFlowUiIDL.Stub r2 = this.origin;     // Catch: Exception -> L32
        if (r15 != null) goto L10;
    L19:
        IDismissKeyguardCallbackIDL r6 = r15;
    L20:
        r20 = ")";
        r2.suspendDismissKeyguard(r29, r30, r6, r32, r33);     // Catch: Exception -> L30
        if (this.log == false) goto L24;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "suspendDismissKeyguard = void");     // Catch: Exception -> L30
    L24:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L30
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L30
        r4 = r33;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "suspendDismissKeyguard(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L28
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "suspendDismissKeyguard", r0, r27);     // Catch: Exception -> L28
        return;
    L28:
        e = e;
    L30:
        e = e;
        r4 = r33;
        r5 = 0;
        goto L34
    L10:
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLIpcWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLStubWrapper.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r15, IDismissKeyguardCallbackIDL.Stub.class) == false) goto L17;
        IDismissKeyguardCallbackIDL r3 = o.a((IDismissKeyguardCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IDismissKeyguardCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L32
    L18:
        r6 = r3;
        goto L20
    L17:
        r3 = o.a(r15, true);     // Catch: Exception -> L32
        goto L18
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void dismissKeyguard() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "dismissKeyguard()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "dismissKeyguard() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "dismissKeyguard", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "dismissKeyguard()");     // Catch: Exception -> L11
    L6:
        this.origin.dismissKeyguard();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "dismissKeyguard = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "dismissKeyguard() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "dismissKeyguard", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public int getWindowState() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "getWindowState()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getWindowState() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getWindowState", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "getWindowState()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getWindowState();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "getWindowState = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getWindowState() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getWindowState", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showToast(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "showToast(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "showToast(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "showToast", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "showToast(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showToast(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "showToast = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "showToast(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "showToast", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyMessageInAutoGui(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "notifyMessageInAutoGui(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyMessageInAutoGui(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyMessageInAutoGui", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "notifyMessageInAutoGui(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyMessageInAutoGui(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "notifyMessageInAutoGui = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyMessageInAutoGui(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyMessageInAutoGui", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openRealtimeCall(int r25, IOpenRealTimeCallCallbackIDL r26) {
        IOpenRealTimeCallCallbackIDL r6 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "openRealtimeCall(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openRealtimeCall(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openRealtimeCall", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "openRealtimeCall(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IOpenRealTimeCallCallbackIDL r9 = r6;
    L19:
        r14.openRealtimeCall(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "openRealtimeCall = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openRealtimeCall(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openRealtimeCall", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IOpenRealTimeCallCallbackIDL.Stub.class) == false) goto L17;
        r9 = bb.a((IOpenRealTimeCallCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IOpenRealTimeCallCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = bb.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void finishChatPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "finishChatPage()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "finishChatPage() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "finishChatPage", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "finishChatPage()");     // Catch: Exception -> L11
    L6:
        this.origin.finishChatPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "finishChatPage = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "finishChatPage() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "finishChatPage", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAutoIncreaseWindow(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "setAutoIncreaseWindow(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "setAutoIncreaseWindow(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "setAutoIncreaseWindow", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "setAutoIncreaseWindow(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setAutoIncreaseWindow(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "setAutoIncreaseWindow = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "setAutoIncreaseWindow(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "setAutoIncreaseWindow", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openAssistantInputPanel(String r23, StateInfo r24, boolean r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openAssistantInputPanel", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openAssistantInputPanel(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "openAssistantInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openAssistantInputPanel", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void closeAssistantInputPanel(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "closeAssistantInputPanel(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "closeAssistantInputPanel(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "closeAssistantInputPanel", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "closeAssistantInputPanel(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.closeAssistantInputPanel(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "closeAssistantInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "closeAssistantInputPanel(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "closeAssistantInputPanel", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyAssistantState(String r23, boolean r24, StateInfo r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyAssistantState", r4, r9, r20);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyAssistantState(r23, r24, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "notifyAssistantState = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyAssistantState", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAssistantInteractionListener(String r25, IAssistantInteractionListenerIDL r26) {
        IAssistantInteractionListenerIDL r6 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "setAssistantInteractionListener(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "setAssistantInteractionListener(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "setAssistantInteractionListener", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "setAssistantInteractionListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IAssistantInteractionListenerIDL r9 = r6;
    L19:
        r14.setAssistantInteractionListener(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "setAssistantInteractionListener = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "setAssistantInteractionListener(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "setAssistantInteractionListener", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IAssistantInteractionListenerIDL.Stub.class) == false) goto L17;
        r9 = n.a((IAssistantInteractionListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAssistantInteractionListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = n.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPass() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isAuthenticationPass()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPass() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPass", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isAuthenticationPass()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAuthenticationPass();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isAuthenticationPass = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPass() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPass", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r25, Bundle r26) {
        IRequestAuthenticationCallbackIDL r6 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestVoicePrintAuthentication", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r9 = r6;
    L19:
        r14.requestVoicePrintAuthentication(r9, r26);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "requestVoicePrintAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestVoicePrintAuthentication", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L17;
        r9 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = be.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r26, boolean r27, Bundle r28) {
        IRequestAuthenticationCallbackIDL r7 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "requestBiometricAuthentication(" + r7 + ", " + r27 + ", " + r28 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestBiometricAuthentication(" + r7 + ", " + r27 + ", " + r28 + ") = fail", r3, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestBiometricAuthentication", r3, r8, r23);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "requestBiometricAuthentication(" + r7 + ", " + r27 + ", " + r28 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r10 = r7;
    L19:
        r11.requestBiometricAuthentication(r10, r27, r28);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "requestBiometricAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestBiometricAuthentication(" + r7 + ", " + r27 + ", " + r28 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestBiometricAuthentication", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L17;
        r10 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r10 = be.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r25, Bundle r26) {
        IRequestAuthenticationCallbackIDL r6 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IRequestAuthenticationCallbackIDL r9 = r6;
    L19:
        r14.requestDeviceCredentialAuthentication(r9, r26);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "requestDeviceCredentialAuthentication = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "requestDeviceCredentialAuthentication", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L17;
        r9 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = be.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openChatActivity(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "openChatActivity(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openChatActivity(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openChatActivity", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "openChatActivity(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openChatActivity(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "openChatActivity = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "openChatActivity(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "openChatActivity", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPassV2(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isAuthenticationPassV2(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPassV2(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPassV2", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isAuthenticationPassV2(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isAuthenticationPassV2(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isAuthenticationPassV2 = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPassV2(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPassV2", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyOAutoDied() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "notifyOAutoDied()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyOAutoDied() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyOAutoDied", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "notifyOAutoDied()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyOAutoDied();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "notifyOAutoDied = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "notifyOAutoDied() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "notifyOAutoDied", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public Authentication isAuthenticationPassV3(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isAuthenticationPassV3(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPassV3(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPassV3", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isAuthenticationPassV3(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        Authentication r11 = this.origin.isAuthenticationPassV3(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isAuthenticationPassV3 = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAuthenticationPassV3(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAuthenticationPassV3", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAssistantRequestFromAIKey() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isAssistantRequestFromAIKey()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAssistantRequestFromAIKey() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAssistantRequestFromAIKey", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAssistantRequestFromAIKey();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isAssistantRequestFromAIKey = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAssistantRequestFromAIKey() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAssistantRequestFromAIKey", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAudioMessage(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isAudioMessage(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAudioMessage(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAudioMessage", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isAudioMessage(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isAudioMessage(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isAudioMessage = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isAudioMessage(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isAudioMessage", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void shouldDowngradeAuthForDora(int r25, IDowngradeAuthForDoraCallbackIDL r26) {
        IDowngradeAuthForDoraCallbackIDL r6 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "shouldDowngradeAuthForDora", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowUiIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IDowngradeAuthForDoraCallbackIDL r9 = r6;
    L19:
        r14.shouldDowngradeAuthForDora(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "shouldDowngradeAuthForDora = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "shouldDowngradeAuthForDora", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class) == false) goto L17;
        r9 = p.a((IDowngradeAuthForDoraCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = p.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void processRequiresAuthentication() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "processRequiresAuthentication()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "processRequiresAuthentication() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "processRequiresAuthentication", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "processRequiresAuthentication()");     // Catch: Exception -> L11
    L6:
        this.origin.processRequiresAuthentication();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "processRequiresAuthentication = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "processRequiresAuthentication() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "processRequiresAuthentication", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showWindow() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "showWindow()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "showWindow() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "showWindow", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "showWindow()");     // Catch: Exception -> L11
    L6:
        this.origin.showWindow();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "showWindow = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "showWindow() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "showWindow", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowMode() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isWindowMode()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isWindowMode() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isWindowMode", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isWindowMode()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isWindowMode();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isWindowMode = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isWindowMode() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isWindowMode", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void popWindow() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "popWindow()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "popWindow() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "popWindow", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "popWindow()");     // Catch: Exception -> L11
    L6:
        this.origin.popWindow();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "popWindow = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "popWindow() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "popWindow", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowShowing() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "isWindowShowing()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isWindowShowing() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isWindowShowing", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "isWindowShowing()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isWindowShowing();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "isWindowShowing = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "isWindowShowing() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "isWindowShowing", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getTaskSkillModelJson() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "getTaskSkillModelJson()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getTaskSkillModelJson() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getTaskSkillModelJson", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "getTaskSkillModelJson()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getTaskSkillModelJson();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "getTaskSkillModelJson = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getTaskSkillModelJson() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getTaskSkillModelJson", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getCurrentDisplayModel() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowUiIDLStub", "getCurrentDisplayModel()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getCurrentDisplayModel() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getCurrentDisplayModel", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowUiIDLStub", "getCurrentDisplayModel()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getCurrentDisplayModel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowUiIDLStub", "getCurrentDisplayModel = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowUiIDLStub", "getCurrentDisplayModel() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowUiIDLStub", "getCurrentDisplayModel", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
