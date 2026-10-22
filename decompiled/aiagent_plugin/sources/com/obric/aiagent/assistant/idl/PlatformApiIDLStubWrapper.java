package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PlatformApiIDLStubWrapper extends IPlatformApiIDL.Stub {
    boolean log;
    final IPlatformApiIDL.Stub origin;

    PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r2) {
        this(r2, true);
    }

    PlatformApiIDLStubWrapper(IPlatformApiIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r33, int r34, boolean r35) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("PlatformApiIDLStub", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("PlatformApiIDLStub", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ") = fail", r4, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("PlatformApiIDLStub", "moveTaskToDisplay", r4, r28, r30);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("PlatformApiIDLStub", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Exception -> L11
    L6:
        boolean r14 = this.origin.moveTaskToDisplay(r33, r34, r35);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("PlatformApiIDLStub", "moveTaskToDisplay = " + r14);     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r10 = Math.max(0, r22 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("PlatformApiIDLStub", "moveTaskToDisplay(" + r33 + ", " + r34 + ", " + r35 + ") = " + r14, r10);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("PlatformApiIDLStub", "moveTaskToDisplay", r10, r22);     // Catch: Exception -> L11
        return r14;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r33, boolean r34, boolean r35, int r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("PlatformApiIDLStub", "getTasksPackages(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("PlatformApiIDLStub", "getTasksPackages(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("PlatformApiIDLStub", "getTasksPackages", r5, r28, r30);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("PlatformApiIDLStub", "getTasksPackages(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r11 = this.origin.getTasksPackages(r33, r34, r35, r36);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("PlatformApiIDLStub", "getTasksPackages = " + r11);     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("PlatformApiIDLStub", "getTasksPackages(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = " + r11, r12);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("PlatformApiIDLStub", "getTasksPackages", r12, r22);     // Catch: Exception -> L11
        return r11;
    }
}
