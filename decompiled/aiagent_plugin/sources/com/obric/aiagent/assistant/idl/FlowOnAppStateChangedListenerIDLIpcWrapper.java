package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowOnAppStateChangedListenerIDLIpcWrapper implements IFlowOnAppStateChangedListenerIDL {
    boolean log;
    final IFlowOnAppStateChangedListenerIDL origin;

    FlowOnAppStateChangedListenerIDLIpcWrapper(IFlowOnAppStateChangedListenerIDL r3) {
        this((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowOnAppStateChangedListenerIDLIpcWrapper(IFlowOnAppStateChangedListenerIDL r3, boolean r4) {
        this.origin = (IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppBackground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAppBackground();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppBackground", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAppForeground() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAppForeground();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAppForeground", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onAllActivityDestroyed() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onAllActivityDestroyed();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onAllActivityDestroyed", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
    public void onMainBotChatPageResume(boolean r22, boolean r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onMainBotChatPageResume(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowOnAppStateChangedListenerIDLIPC", "onMainBotChatPageResume", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
