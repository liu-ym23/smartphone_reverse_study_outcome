package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowUiIDLIpcWrapper implements IFlowUiIDL {
    boolean log;
    final IFlowUiIDL origin;

    FlowUiIDLIpcWrapper(IFlowUiIDL r3) {
        this((IFlowUiIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowUiIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowUiIDLIpcWrapper(IFlowUiIDL r3, boolean r4) {
        this.origin = (IFlowUiIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowUiIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void addCustomBarAction(String r31, String r32, String r33, long r34) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L22:
        e = e;
        long r4 = r34;
        long r10 = 0;
    L24:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ")", e);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L26
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L26
        long r24 = Math.max(r10, r26 - r16) / 1000;     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ") = fail", r1, r24);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "addCustomBarAction", r1, r24, r26);     // Catch: Throwable -> L26
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L9:
        r10 = 0;
        this.origin.addCustomBarAction(r31, r32, r33, r34);     // Catch: Exception -> L20 Throwable -> L26
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "addCustomBarAction = void");     // Catch: Exception -> L20 Throwable -> L26
    L14:
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L20 Throwable -> L26
        long r0 = Math.max(0, r25 - r16) / 1000;     // Catch: Exception -> L20 Throwable -> L26
        r4 = r34;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "addCustomBarAction(" + r31 + ", " + r32 + ", " + r33 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L18 Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "addCustomBarAction", r0, r25);     // Catch: Exception -> L18 Throwable -> L26
        return;
    L18:
        e = e;
    L20:
        e = e;
        r4 = r34;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void handleObricAction(String r25, String r26, IObricActionResultCallbackIDL r27) {
        IObricActionResultCallbackIDL r7 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "handleObricAction(" + r25 + ", " + r26 + ", " + r7 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r8 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "handleObricAction(" + r25 + ", " + r26 + ", " + r7 + ") = fail", r3, r8);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "handleObricAction", r3, r8, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "handleObricAction(" + r25 + ", " + r26 + ", " + r7 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("handleObricAction(").append(r25).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IObricActionResultCallbackIDL r13 = r7;
    L21:
        r11.a("IFlowUiIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IObricActionResultCallbackIDL.Stub.class) == false) goto L19;
        r13 = ba.a((IObricActionResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IObricActionResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = ba.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IObricActionResultCallbackIDL r10 = r7;
    L35:
        r12.handleObricAction(r25, r26, r10);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "handleObricAction = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "handleObricAction(" + r25 + ", " + r26 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "handleObricAction", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, ObricActionResultCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IObricActionResultCallbackIDL.Stub.class) == false) goto L33;
        r10 = ba.a((IObricActionResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IObricActionResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r10 = ba.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void suspendDismissKeyguard(String r31, String[] r32, IDismissKeyguardCallbackIDL r33, boolean r34, Bundle r35) {
        IDismissKeyguardCallbackIDL r15 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r33, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
    L48:
        e = e;
        Bundle r4 = r35;
        String r22 = ")";
        long r5 = 0;
    L50:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "suspendDismissKeyguard(" + r31 + ", " + r32 + ", " + r15 + ", " + r34 + ", " + r4 + r22, e);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L52
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L52
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "suspendDismissKeyguard(" + r31 + ", " + r32 + ", " + r15 + ", " + r34 + ", " + r4 + ") = fail", r1, r24);     // Catch: Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "suspendDismissKeyguard", r1, r24, r26);     // Catch: Throwable -> L52
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "suspendDismissKeyguard(" + r31 + ", " + r32 + ", " + r15 + ", " + r34 + ", " + r35 + ")");     // Catch: Exception -> L48 Throwable -> L52
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r2 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L48 Throwable -> L52
        StringBuilder r6 = new StringBuilder().append("suspendDismissKeyguard(").append(r31).append(", ").append(r32).append(", ");     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L12;
    L20:
        IDismissKeyguardCallbackIDL r7 = r15;
    L21:
        r2.a("IFlowUiIDLIPC", r6.append(r7).append(", ").append(r34).append(", ").append(r35).append(")").toString());     // Catch: Exception -> L48 Throwable -> L52
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r15, IDismissKeyguardCallbackIDL.Stub.class) == false) goto L19;
        r7 = o.a((IDismissKeyguardCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IDismissKeyguardCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
        goto L21
    L19:
        r7 = o.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
    L22:
        IFlowUiIDL r3 = this.origin;     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L26;
    L35:
        IDismissKeyguardCallbackIDL r8 = r15;
    L36:
        r22 = ")";
        r3.suspendDismissKeyguard(r31, r32, r8, r34, r35);     // Catch: Exception -> L46 Throwable -> L52
        if (this.log == false) goto L40;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "suspendDismissKeyguard = void");     // Catch: Exception -> L46 Throwable -> L52
    L40:
        long r28 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L52
        long r0 = Math.max(0, r28 - r16) / 1000;     // Catch: Exception -> L46 Throwable -> L52
        r4 = r35;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "suspendDismissKeyguard(" + r31 + ", " + r32 + ", " + r15 + ", " + r34 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L44 Throwable -> L52
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "suspendDismissKeyguard", r0, r28);     // Catch: Exception -> L44 Throwable -> L52
        return;
    L44:
        e = e;
    L46:
        e = e;
        r4 = r35;
        r5 = 0;
        goto L50
    L26:
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLIpcWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, DismissKeyguardCallbackIDLStubWrapper.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r15, IDismissKeyguardCallbackIDL.Stub.class) == false) goto L33;
        IDismissKeyguardCallbackIDL r9 = o.a((IDismissKeyguardCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r15, IDismissKeyguardCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L48 Throwable -> L52
    L34:
        r8 = r9;
        goto L36
    L33:
        r9 = o.a(r15, true);     // Catch: Exception -> L48 Throwable -> L52
        goto L34
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void dismissKeyguard() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "dismissKeyguard()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "dismissKeyguard() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "dismissKeyguard", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "dismissKeyguard()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "dismissKeyguard()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.dismissKeyguard();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "dismissKeyguard = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "dismissKeyguard() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "dismissKeyguard", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public int getWindowState() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getWindowState()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getWindowState() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getWindowState", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getWindowState()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getWindowState()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getWindowState();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "getWindowState = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getWindowState() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getWindowState", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showToast(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showToast(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "showToast(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "showToast", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showToast(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showToast(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showToast(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "showToast = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "showToast(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "showToast", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyMessageInAutoGui(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyMessageInAutoGui(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "notifyMessageInAutoGui = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyMessageInAutoGui", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openRealtimeCall(int r25, IOpenRealTimeCallCallbackIDL r26) {
        IOpenRealTimeCallCallbackIDL r6 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openRealtimeCall(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openRealtimeCall(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openRealtimeCall", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openRealtimeCall(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("openRealtimeCall(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IOpenRealTimeCallCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowUiIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IOpenRealTimeCallCallbackIDL.Stub.class) == false) goto L19;
        r11 = bb.a((IOpenRealTimeCallCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IOpenRealTimeCallCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = bb.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IOpenRealTimeCallCallbackIDL r9 = r6;
    L35:
        r12.openRealtimeCall(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "openRealtimeCall = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openRealtimeCall(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openRealtimeCall", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, OpenRealTimeCallCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IOpenRealTimeCallCallbackIDL.Stub.class) == false) goto L33;
        r9 = bb.a((IOpenRealTimeCallCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IOpenRealTimeCallCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = bb.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void finishChatPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "finishChatPage()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "finishChatPage() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "finishChatPage", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "finishChatPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "finishChatPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.finishChatPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "finishChatPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "finishChatPage() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "finishChatPage", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAutoIncreaseWindow(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAutoIncreaseWindow(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "setAutoIncreaseWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "setAutoIncreaseWindow", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openAssistantInputPanel(String r23, StateInfo r24, boolean r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openAssistantInputPanel", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.openAssistantInputPanel(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "openAssistantInputPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openAssistantInputPanel(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openAssistantInputPanel", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void closeAssistantInputPanel(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "closeAssistantInputPanel", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.closeAssistantInputPanel(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "closeAssistantInputPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "closeAssistantInputPanel(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "closeAssistantInputPanel", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyAssistantState(String r23, boolean r24, StateInfo r25) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyAssistantState", r4, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyAssistantState(r23, r24, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "notifyAssistantState = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyAssistantState(" + r23 + ", " + r24 + ", " + r25 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyAssistantState", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void setAssistantInteractionListener(String r25, IAssistantInteractionListenerIDL r26) {
        IAssistantInteractionListenerIDL r6 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "setAssistantInteractionListener", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("setAssistantInteractionListener(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IAssistantInteractionListenerIDL r11 = r6;
    L21:
        r14.a("IFlowUiIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IAssistantInteractionListenerIDL.Stub.class) == false) goto L19;
        r11 = n.a((IAssistantInteractionListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAssistantInteractionListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = n.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IAssistantInteractionListenerIDL r9 = r6;
    L35:
        r12.setAssistantInteractionListener(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "setAssistantInteractionListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "setAssistantInteractionListener(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "setAssistantInteractionListener", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, AssistantInteractionListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IAssistantInteractionListenerIDL.Stub.class) == false) goto L33;
        r9 = n.a((IAssistantInteractionListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAssistantInteractionListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = n.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPass() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPass()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPass() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPass", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPass()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAuthenticationPass();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isAuthenticationPass = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPass() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPass", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r25, Bundle r26) {
        IRequestAuthenticationCallbackIDL r6 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("requestVoicePrintAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowUiIDLIPC", r10.append(r11).append(", ").append(r26).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L19;
        r11 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = be.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r9 = r6;
    L35:
        r12.requestVoicePrintAuthentication(r9, r26);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "requestVoicePrintAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication(" + r6 + ", " + r26 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestVoicePrintAuthentication", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L33;
        r9 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = be.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r25, boolean r26, Bundle r27) {
        IRequestAuthenticationCallbackIDL r7 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r7 + ", " + r26 + ", " + r27 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r8 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r7 + ", " + r26 + ", " + r27 + ") = fail", r3, r8);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestBiometricAuthentication", r3, r8, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r7 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("requestBiometricAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r13 = r7;
    L21:
        r11.a("IFlowUiIDLIPC", r15.append(r13).append(", ").append(r26).append(", ").append(r27).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L19;
        r13 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = be.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r10 = r7;
    L35:
        r12.requestBiometricAuthentication(r10, r26, r27);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "requestBiometricAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestBiometricAuthentication(" + r7 + ", " + r26 + ", " + r27 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestBiometricAuthentication", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L33;
        r10 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r10 = be.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r25, Bundle r26) {
        IRequestAuthenticationCallbackIDL r6 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r25, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("requestDeviceCredentialAuthentication(");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IRequestAuthenticationCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowUiIDLIPC", r10.append(r11).append(", ").append(r26).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L19;
        r11 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = be.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IRequestAuthenticationCallbackIDL r9 = r6;
    L35:
        r12.requestDeviceCredentialAuthentication(r9, r26);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication(" + r6 + ", " + r26 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "requestDeviceCredentialAuthentication", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, RequestAuthenticationCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IRequestAuthenticationCallbackIDL.Stub.class) == false) goto L33;
        r9 = be.a((IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = be.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void openChatActivity(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openChatActivity(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openChatActivity(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openChatActivity", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openChatActivity(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "openChatActivity(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.openChatActivity(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "openChatActivity = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "openChatActivity(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "openChatActivity", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAuthenticationPassV2(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPassV2", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isAuthenticationPassV2(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isAuthenticationPassV2 = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPassV2(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPassV2", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void notifyOAutoDied() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyOAutoDied()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyOAutoDied() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyOAutoDied", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyOAutoDied()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "notifyOAutoDied()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyOAutoDied();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "notifyOAutoDied = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "notifyOAutoDied() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "notifyOAutoDied", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public Authentication isAuthenticationPassV3(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        Authentication r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPassV3", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isAuthenticationPassV3(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isAuthenticationPassV3 = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAuthenticationPassV3(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAuthenticationPassV3", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAssistantRequestFromAIKey() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAssistantRequestFromAIKey();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isAssistantRequestFromAIKey = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAssistantRequestFromAIKey", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isAudioMessage(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAudioMessage(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAudioMessage(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAudioMessage", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAudioMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isAudioMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isAudioMessage(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isAudioMessage = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isAudioMessage(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isAudioMessage", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void shouldDowngradeAuthForDora(int r25, IDowngradeAuthForDoraCallbackIDL r26) {
        IDowngradeAuthForDoraCallbackIDL r6 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("shouldDowngradeAuthForDora(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IDowngradeAuthForDoraCallbackIDL r11 = r6;
    L21:
        r14.a("IFlowUiIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class) == false) goto L19;
        r11 = p.a((IDowngradeAuthForDoraCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = p.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowUiIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IDowngradeAuthForDoraCallbackIDL r9 = r6;
    L35:
        r12.shouldDowngradeAuthForDora(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "shouldDowngradeAuthForDora = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "shouldDowngradeAuthForDora", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, DowngradeAuthForDoraCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class) == false) goto L33;
        r9 = p.a((IDowngradeAuthForDoraCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IDowngradeAuthForDoraCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = p.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void processRequiresAuthentication() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "processRequiresAuthentication()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "processRequiresAuthentication() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "processRequiresAuthentication", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "processRequiresAuthentication()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "processRequiresAuthentication()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.processRequiresAuthentication();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "processRequiresAuthentication = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "processRequiresAuthentication() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "processRequiresAuthentication", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void showWindow() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showWindow()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "showWindow() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "showWindow", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "showWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showWindow();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "showWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "showWindow() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "showWindow", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowMode() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowMode()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isWindowMode() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isWindowMode", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowMode()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowMode()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isWindowMode();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isWindowMode = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isWindowMode() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isWindowMode", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public void popWindow() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "popWindow()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "popWindow() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "popWindow", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "popWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "popWindow()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.popWindow();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "popWindow = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "popWindow() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "popWindow", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public boolean isWindowShowing() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowShowing()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isWindowShowing() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isWindowShowing", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowShowing()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "isWindowShowing()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isWindowShowing();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "isWindowShowing = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "isWindowShowing() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "isWindowShowing", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getTaskSkillModelJson() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getTaskSkillModelJson()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getTaskSkillModelJson() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getTaskSkillModelJson", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getTaskSkillModelJson()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getTaskSkillModelJson()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getTaskSkillModelJson();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "getTaskSkillModelJson = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getTaskSkillModelJson() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getTaskSkillModelJson", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
    public String getCurrentDisplayModel() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getCurrentDisplayModel()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getCurrentDisplayModel() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getCurrentDisplayModel", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getCurrentDisplayModel()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowUiIDLIPC", "getCurrentDisplayModel()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getCurrentDisplayModel();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowUiIDLIPC", "getCurrentDisplayModel = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowUiIDLIPC", "getCurrentDisplayModel() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowUiIDLIPC", "getCurrentDisplayModel", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
