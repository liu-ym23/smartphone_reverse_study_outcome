package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowFrontierIDLStubWrapper extends IFlowFrontierIDL.Stub {
    boolean log;
    final IFlowFrontierIDL.Stub origin;

    FlowFrontierIDLStubWrapper(IFlowFrontierIDL.Stub r2) {
        this(r2, true);
    }

    FlowFrontierIDLStubWrapper(IFlowFrontierIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public int getState() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "getState()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "getState() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "getState", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "getState()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.getState();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "getState = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "getState() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "getState", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerDataListener(int r25, IFlowFrontierDataListenerIDL r26) {
        IFlowFrontierDataListenerIDL r6 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "registerDataListener(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "registerDataListener(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "registerDataListener", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "registerDataListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFrontierDataListenerIDL r9 = r6;
    L19:
        r14.registerDataListener(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "registerDataListener = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "registerDataListener(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "registerDataListener", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L17;
        r9 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ac.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterDataListener(int r25, IFlowFrontierDataListenerIDL r26) {
        IFlowFrontierDataListenerIDL r6 = (IFlowFrontierDataListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "unregisterDataListener(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "unregisterDataListener(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "unregisterDataListener", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "unregisterDataListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFrontierDataListenerIDL r9 = r6;
    L19:
        r14.unregisterDataListener(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "unregisterDataListener = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "unregisterDataListener(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "unregisterDataListener", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierDataListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierDataListenerIDL.Stub.class) == false) goto L17;
        r9 = ac.a((IFlowFrontierDataListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierDataListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ac.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void registerStateListener(int r25, IFlowFrontierStateListenerIDL r26) {
        IFlowFrontierStateListenerIDL r6 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "registerStateListener(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "registerStateListener(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "registerStateListener", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "registerStateListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFrontierStateListenerIDL r9 = r6;
    L19:
        r14.registerStateListener(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "registerStateListener = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "registerStateListener(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "registerStateListener", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L17;
        r9 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ae.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void unregisterStateListener(int r25, IFlowFrontierStateListenerIDL r26) {
        IFlowFrontierStateListenerIDL r6 = (IFlowFrontierStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r26, IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "unregisterStateListener(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "unregisterStateListener(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "unregisterStateListener", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "unregisterStateListener(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IFlowFrontierIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IFlowFrontierStateListenerIDL r9 = r6;
    L19:
        r14.unregisterStateListener(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "unregisterStateListener = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "unregisterStateListener(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "unregisterStateListener", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, FlowFrontierStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IFlowFrontierStateListenerIDL.Stub.class) == false) goto L17;
        r9 = ae.a((IFlowFrontierStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IFlowFrontierStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = ae.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void sendData(int r23, byte[] r24, Map r25) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "sendData(" + r23 + ", " + r24 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "sendData(" + r23 + ", " + r24 + ", " + r7 + ") = fail", r3, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "sendData", r3, r9, r20);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "sendData(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.sendData(r23, r24, r7);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "sendData = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "sendData(" + r23 + ", " + r24 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "sendData", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshot(int r23, Bitmap r24, Map r25) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r20 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ") = fail", r3, r9);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "cacheScreenshot", r3, r9, r20);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.cacheScreenshot(r23, r24, r7);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "cacheScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "cacheScreenshot(" + r23 + ", " + r24 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "cacheScreenshot", r14, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
    public void cacheScreenshotFd(int r33, String r34, ParcelFileDescriptor r35, Map r36) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowFrontierIDLStub", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = fail", r4, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "cacheScreenshotFd", r4, r28, r30);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowFrontierIDLStub", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.cacheScreenshotFd(r33, r34, r35, r8);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowFrontierIDLStub", "cacheScreenshotFd = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowFrontierIDLStub", "cacheScreenshotFd(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowFrontierIDLStub", "cacheScreenshotFd", r11, r22);     // Catch: Exception -> L11
    }
}
