package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogIDLStubWrapper extends IFlowAppLogIDL.Stub {
    boolean log;
    final IFlowAppLogIDL.Stub origin;

    FlowAppLogIDLStubWrapper(IFlowAppLogIDL.Stub r2) {
        this(r2, true);
    }

    FlowAppLogIDLStubWrapper(IFlowAppLogIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setHeaderInfo(Map r21) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "setHeaderInfo(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "setHeaderInfo(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "setHeaderInfo", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "setHeaderInfo(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setHeaderInfo(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "setHeaderInfo = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "setHeaderInfo(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "setHeaderInfo", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onEventV3(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onEventV3(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onEventV3 = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Json(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onEventV3Json(" + r22 + ", " + r23 + ")", e);
        g r3 = new g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3Json(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3Json", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onEventV3Json(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3Json(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onEventV3Json = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3Json(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3Json", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Bundle(String r22, Bundle r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onEventV3Bundle(" + r22 + ", " + r23 + ")", e);
        g r3 = new g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3Bundle(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3Bundle", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onEventV3Bundle(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3Bundle(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onEventV3Bundle = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onEventV3Bundle(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onEventV3Bundle", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addSessionHook(IFlowAppLogSessionObserverIDL r21) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "addSessionHook(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "addSessionHook(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addSessionHook", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "addSessionHook(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogSessionObserverIDL r7 = r4;
    L19:
        r12.addSessionHook(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "addSessionHook = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "addSessionHook(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addSessionHook", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L17;
        r7 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = d.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeSessionHook(IFlowAppLogSessionObserverIDL r21) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "removeSessionHook(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "removeSessionHook(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeSessionHook", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "removeSessionHook(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogSessionObserverIDL r7 = r4;
    L19:
        r12.removeSessionHook(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "removeSessionHook = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "removeSessionHook(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeSessionHook", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L17;
        r7 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = d.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addEventObserver(IFlowAppLogEventObserverIDL r21) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "addEventObserver(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "addEventObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addEventObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "addEventObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogEventObserverIDL r7 = r4;
    L19:
        r12.addEventObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "addEventObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "addEventObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addEventObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L17;
        r7 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = b.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeEventObserver(IFlowAppLogEventObserverIDL r21) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "removeEventObserver(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "removeEventObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeEventObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "removeEventObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogEventObserverIDL r7 = r4;
    L19:
        r12.removeEventObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "removeEventObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "removeEventObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeEventObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L17;
        r7 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = b.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addDataObserver(IFlowAppLogDataObserverIDL r21) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "addDataObserver(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "addDataObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addDataObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "addDataObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogDataObserverIDL r7 = r4;
    L19:
        r12.addDataObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "addDataObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "addDataObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "addDataObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L17;
        r7 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = a.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeDataObserver(IFlowAppLogDataObserverIDL r21) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "removeDataObserver(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "removeDataObserver(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeDataObserver", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "removeDataObserver(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IFlowAppLogIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IFlowAppLogDataObserverIDL r7 = r4;
    L19:
        r12.removeDataObserver(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("FlowAppLogIDLStub", "removeDataObserver = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("FlowAppLogIDLStub", "removeDataObserver(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "removeDataObserver", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L17;
        r7 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = a.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onResume(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onResume(" + r22 + ", " + r23 + ")", e);
        g r3 = new g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onResume(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onResume", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResume(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onResume = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onResume(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onResume", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onPause() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onPause()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onPause() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onPause", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onPause()");     // Catch: Exception -> L11
    L6:
        this.origin.onPause();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onPause = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onPause() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onPause", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onStop() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "onStop()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "onStop() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onStop", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "onStop()");     // Catch: Exception -> L11
    L6:
        this.origin.onStop();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "onStop = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "onStop() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "onStop", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setLaunchService(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "setLaunchService(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "setLaunchService(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "setLaunchService", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "setLaunchService(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setLaunchService(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "setLaunchService = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "setLaunchService(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "setLaunchService", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void clearLaunchService() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "clearLaunchService()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "clearLaunchService() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "clearLaunchService", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "clearLaunchService()");     // Catch: Exception -> L11
    L6:
        this.origin.clearLaunchService();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "clearLaunchService = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "clearLaunchService() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "clearLaunchService", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getDid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "getDid()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "getDid() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getDid", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "getDid()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getDid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "getDid = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "getDid() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getDid", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getIid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "getIid()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "getIid() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getIid", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "getIid()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getIid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "getIid = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "getIid() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getIid", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getSsid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "getSsid()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "getSsid() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getSsid", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "getSsid()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getSsid();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "getSsid = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "getSsid() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getSsid", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserUniqueID() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "getUserUniqueID()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "getUserUniqueID() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getUserUniqueID", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "getUserUniqueID()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getUserUniqueID();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "getUserUniqueID = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "getUserUniqueID() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getUserUniqueID", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserID() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogIDLStub", "getUserID()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("FlowAppLogIDLStub", "getUserID() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getUserID", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogIDLStub", "getUserID()");     // Catch: Exception -> L11
    L6:
        String r9 = this.origin.getUserID();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogIDLStub", "getUserID = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogIDLStub", "getUserID() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogIDLStub", "getUserID", r14, r17);     // Catch: Exception -> L11
        return r9;
    }
}
