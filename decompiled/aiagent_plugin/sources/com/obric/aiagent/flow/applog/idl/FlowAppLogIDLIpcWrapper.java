package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogIDLIpcWrapper implements IFlowAppLogIDL {
    boolean log;
    final IFlowAppLogIDL origin;

    FlowAppLogIDLIpcWrapper(IFlowAppLogIDL r3) {
        this((IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppLogIDLIpcWrapper(IFlowAppLogIDL r3, boolean r4) {
        this.origin = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setHeaderInfo(Map r21) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r4 + ")", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "setHeaderInfo", r1, r6, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setHeaderInfo(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "setHeaderInfo = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "setHeaderInfo(" + r4 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "setHeaderInfo", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3(" + r21 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onEventV3 = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Json(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        g r3 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3Json", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3Json(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onEventV3Json = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3Json(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3Json", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onEventV3Bundle(String r22, Bundle r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        g r3 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3Bundle", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3Bundle(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onEventV3Bundle = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onEventV3Bundle(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onEventV3Bundle", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addSessionHook(IFlowAppLogSessionObserverIDL r21) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "addSessionHook(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addSessionHook(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addSessionHook", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "addSessionHook(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("addSessionHook(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogSessionObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L19;
        r15 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = d.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogSessionObserverIDL r7 = r4;
    L35:
        r13.addSessionHook(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "addSessionHook = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addSessionHook(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addSessionHook", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L33;
        r7 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = d.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeSessionHook(IFlowAppLogSessionObserverIDL r21) {
        IFlowAppLogSessionObserverIDL r4 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeSessionHook", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("removeSessionHook(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogSessionObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L19;
        r15 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = d.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogSessionObserverIDL r7 = r4;
    L35:
        r13.removeSessionHook(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "removeSessionHook = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeSessionHook(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeSessionHook", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogSessionObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogSessionObserverIDL.Stub.class) == false) goto L33;
        r7 = d.a((IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = d.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addEventObserver(IFlowAppLogEventObserverIDL r21) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "addEventObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addEventObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addEventObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "addEventObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("addEventObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogEventObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L19;
        r15 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = b.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogEventObserverIDL r7 = r4;
    L35:
        r13.addEventObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "addEventObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addEventObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addEventObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L33;
        r7 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = b.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeEventObserver(IFlowAppLogEventObserverIDL r21) {
        IFlowAppLogEventObserverIDL r4 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeEventObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("removeEventObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogEventObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L19;
        r15 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = b.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogEventObserverIDL r7 = r4;
    L35:
        r13.removeEventObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "removeEventObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeEventObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeEventObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogEventObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogEventObserverIDL.Stub.class) == false) goto L33;
        r7 = b.a((IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = b.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void addDataObserver(IFlowAppLogDataObserverIDL r21) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "addDataObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addDataObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addDataObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "addDataObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("addDataObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogDataObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L19;
        r15 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = a.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogDataObserverIDL r7 = r4;
    L35:
        r13.addDataObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "addDataObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "addDataObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "addDataObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L33;
        r7 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = a.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void removeDataObserver(IFlowAppLogDataObserverIDL r21) {
        IFlowAppLogDataObserverIDL r4 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r4 + ")", e);     // Catch: Throwable -> L43
        g r1 = new g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeDataObserver", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        j r12 = j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("removeDataObserver(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowAppLogDataObserverIDL r15 = r4;
    L21:
        r12.a("IFlowAppLogIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L19;
        r15 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = a.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppLogIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowAppLogDataObserverIDL r7 = r4;
    L35:
        r13.removeDataObserver(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        j.f18676a.c("IFlowAppLogIDLIPC", "removeDataObserver = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        k.f18677a.a("IFlowAppLogIDLIPC", "removeDataObserver(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "removeDataObserver", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowAppLogDataObserverIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowAppLogDataObserverIDL.Stub.class) == false) goto L33;
        r7 = a.a((IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = a.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onResume(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        g r3 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onResume", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResume(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onResume = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onResume(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onResume", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onPause() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onPause()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onPause() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onPause", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onPause()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onPause()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onPause();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onPause = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onPause() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onPause", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void onStop() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "onStop()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onStop() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onStop", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "onStop()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "onStop()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onStop();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "onStop = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "onStop() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "onStop", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void setLaunchService(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "setLaunchService(" + r21 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "setLaunchService(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "setLaunchService", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "setLaunchService(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "setLaunchService(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setLaunchService(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "setLaunchService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "setLaunchService(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "setLaunchService", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public void clearLaunchService() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "clearLaunchService()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "clearLaunchService() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "clearLaunchService", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "clearLaunchService()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "clearLaunchService()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.clearLaunchService();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "clearLaunchService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "clearLaunchService() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "clearLaunchService", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getDid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "getDid()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getDid() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getDid", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "getDid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "getDid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getDid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "getDid = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getDid() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getDid", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getIid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "getIid()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getIid() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getIid", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "getIid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "getIid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getIid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "getIid = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getIid() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getIid", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getSsid() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "getSsid()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getSsid() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getSsid", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "getSsid()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "getSsid()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getSsid();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "getSsid = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getSsid() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getSsid", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserUniqueID() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserUniqueID()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getUserUniqueID() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getUserUniqueID", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserUniqueID()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserUniqueID()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getUserUniqueID();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "getUserUniqueID = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getUserUniqueID() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getUserUniqueID", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
    public String getUserID() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserID()", e);     // Catch: Throwable -> L17
        g r1 = new g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getUserID() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getUserID", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserID()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogIDLIPC", "getUserID()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getUserID();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogIDLIPC", "getUserID = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogIDLIPC", "getUserID() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogIDLIPC", "getUserID", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
