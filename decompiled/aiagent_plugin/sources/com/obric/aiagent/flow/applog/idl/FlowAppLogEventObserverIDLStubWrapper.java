package com.obric.aiagent.flow.applog.idl;

import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppLogEventObserverIDLStubWrapper extends IFlowAppLogEventObserverIDL.Stub {
    boolean log;
    final IFlowAppLogEventObserverIDL.Stub origin;

    FlowAppLogEventObserverIDLStubWrapper(IFlowAppLogEventObserverIDL.Stub r2) {
        this(r2, true);
    }

    FlowAppLogEventObserverIDLStubWrapper(IFlowAppLogEventObserverIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ")", e);
        g r3 = new g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        k.f18677a.b("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogEventObserverIDLStub", "onEventV3", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FlowAppLogEventObserverIDLStub", "onEventV3 = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowAppLogEventObserverIDLStub", "onEventV3", r13, r110);     // Catch: Exception -> L11
    }
}
