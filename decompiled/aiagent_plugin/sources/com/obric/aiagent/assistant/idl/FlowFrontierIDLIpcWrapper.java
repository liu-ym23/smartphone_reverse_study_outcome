package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowFrontierIDLIpcWrapper implements IFlowFrontierIDL {
    boolean log;
    final IFlowFrontierIDL origin;

    FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r3) {
        this((IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowFrontierIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowFrontierIDLIpcWrapper(IFlowFrontierIDL r3, boolean r4) {
        this.origin = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "getState()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "getState() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "getState", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "getState()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getState();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "getState = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "getState() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "getState", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r25, IFlowFrontierDataListenerIDL r26) {
        IFlowFrontierDataListenerIDL r6 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "registerDataListener(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "registerDataListener(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "registerDataListener", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "registerDataListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("registerDataListener(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r11 = r6;
    L21:
        r14.a("IFlowFrontierIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L19;
        r11 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ac.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r9 = r6;
    L35:
        r12.registerDataListener(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "registerDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "registerDataListener(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "registerDataListener", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L33;
        r9 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ac.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r25, IFlowFrontierDataListenerIDL r26) {
        IFlowFrontierDataListenerIDL r6 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "unregisterDataListener", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("unregisterDataListener(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFrontierDataListenerIDL r11 = r6;
    L21:
        r14.a("IFlowFrontierIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L19;
        r11 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ac.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFrontierDataListenerIDL r9 = r6;
    L35:
        r12.unregisterDataListener(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "unregisterDataListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "unregisterDataListener(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "unregisterDataListener", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L33;
        r9 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ac.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r25, IFlowFrontierStateListenerIDL r26) {
        IFlowFrontierStateListenerIDL r6 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "registerStateListener(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "registerStateListener(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "registerStateListener", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "registerStateListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("registerStateListener(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r11 = r6;
    L21:
        r14.a("IFlowFrontierIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L19;
        r11 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ae.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r9 = r6;
    L35:
        r12.registerStateListener(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "registerStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "registerStateListener(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "registerStateListener", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L33;
        r9 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ae.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r25, IFlowFrontierStateListenerIDL r26) {
        IFlowFrontierStateListenerIDL r6 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "unregisterStateListener", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("unregisterStateListener(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IFlowFrontierStateListenerIDL r11 = r6;
    L21:
        r14.a("IFlowFrontierIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L19;
        r11 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = ae.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowFrontierIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IFlowFrontierStateListenerIDL r9 = r6;
    L35:
        r12.unregisterStateListener(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "unregisterStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "unregisterStateListener(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "unregisterStateListener", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L33;
        r9 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = ae.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r23, byte[] r24, Map r25) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r7 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r7 + ") = fail", r3, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "sendData", r3, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendData(r23, r24, r7);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "sendData = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "sendData(" + r23 + ", " + r24 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "sendData", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r23, Bitmap r24, Map r25) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r20 - r8) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ") = fail", r3, r9);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "cacheScreenshot", r3, r9, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshot(r23, r24, r7);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "cacheScreenshot = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "cacheScreenshot", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r33, String r34, ParcelFileDescriptor r35, Map r36) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = fail", r4, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd", r4, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.cacheScreenshotFd(r33, r34, r35, r8);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowFrontierIDLIPC", "cacheScreenshotFd = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowFrontierIDLIPC", "cacheScreenshotFd", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
