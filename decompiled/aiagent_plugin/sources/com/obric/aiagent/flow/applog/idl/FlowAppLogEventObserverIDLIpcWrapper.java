package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogEventObserverIDLIpcWrapper implements IFlowAppLogEventObserverIDL {
    boolean log;
    final IFlowAppLogEventObserverIDL origin;

    FlowAppLogEventObserverIDLIpcWrapper(IFlowAppLogEventObserverIDL r3) {
        this((IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppLogEventObserverIDLIpcWrapper(IFlowAppLogEventObserverIDL r3, boolean r4) {
        this.origin = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        g r3 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFlowAppLogEventObserverIDLIPC", "onEventV3 = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppLogEventObserverIDLIPC", "onEventV3", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
