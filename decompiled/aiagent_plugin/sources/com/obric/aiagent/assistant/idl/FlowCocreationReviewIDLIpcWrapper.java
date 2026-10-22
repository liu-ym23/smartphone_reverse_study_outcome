package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowCocreationReviewIDLIpcWrapper implements IFlowCocreationReviewIDL {
    boolean log;
    final IFlowCocreationReviewIDL origin;

    FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r3) {
        this((IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowCocreationReviewIDLIpcWrapper(IFlowCocreationReviewIDL r3, boolean r4) {
        this.origin = (IFlowCocreationReviewIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowCocreationReviewIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r26, long r27, String r29, int r30, String r31, String r32, boolean r33, boolean r34, long r35, String r37) {
        String r14 = r26;
        String r15 = r29;
        int r13 = r30;
        String r16 = "IFlowCocreationReviewIDLIPC";
        long r17 = SystemClock.elapsedRealtimeNanos();
    L63:
        e = e;
        r37 = r37;
        String r23 = ")";
    L65:
        String r18 = ", ";
        String r19 = "logOmniStep(";
    L66:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r16, r19 + r14 + r18 + r27 + r18 + r15 + r18 + r13 + r18 + r31 + r18 + r32 + r18 + r33 + r18 + r34 + r18 + r35 + r18 + r37 + r23, e);     // Catch: Throwable -> L68
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L68
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L68
        long r0 = Math.max(0, r21 - r17) / 1000;     // Catch: Throwable -> L68
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowCocreationReviewIDLIPC", r19 + r14 + r18 + r27 + r18 + r15 + r18 + r13 + r18 + r31 + r18 + r32 + r18 + r33 + r18 + r34 + r18 + r35 + r18 + r37 + ") = fail", r1, r0);     // Catch: Throwable -> L68
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowCocreationReviewIDLIPC", "logOmniStep", r1, r0, r21);     // Catch: Throwable -> L68
        return;
    L4:
        if (this.log == false) goto L12;
        String r6 = ")";
        String r5 = r16;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r5, "logOmniStep(" + r14 + ", " + r27 + ", " + r15 + ", " + r13 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ", " + r35 + ", " + r37 + r6);     // Catch: Exception -> L59 Throwable -> L68
    L13:
        if (this.log == true) goto L75;
        r37 = r37;
    L21:
        String r4 = r5;
        r19 = "logOmniStep(";
        r23 = r6;
        this.origin.logOmniStep(r26, r27, r29, r30, r31, r32, r33, r34, r35, r37);     // Catch: Exception -> L55 Throwable -> L68
        if (this.log == false) goto L26;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r4, "logOmniStep = void");     // Catch: Exception -> L55 Throwable -> L68
    L26:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L55 Throwable -> L68
        long r8 = Math.max(0, r7 - r17) / 1000;     // Catch: Exception -> L55 Throwable -> L68
        r14 = r26;
        r16 = r4;
        r18 = ", ";
        r15 = r29;
        r37 = r37;
        com.obric.aiagent.ipc.utils.k.f18677a.a(r16, r19 + r14 + r18 + r27 + r18 + r15 + r18 + r30 + r18 + r31 + r18 + r32 + r18 + r33 + r18 + r34 + r18 + r35 + r18 + r37 + ") = void", r8);     // Catch: Exception -> L42 Throwable -> L68
        r16 = r16;
        r13 = r30;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowCocreationReviewIDLIPC", "logOmniStep", r8, r7);     // Catch: Exception -> L40 Throwable -> L68
        return;
    L40:
        e = e;
    L42:
        e = e;
    L46:
        r16 = r16;
        r13 = r30;
    L44:
        e = e;
        r37 = r37;
    L47:
        e = e;
    L54:
        r13 = r30;
    L49:
        e = e;
        r15 = r29;
    L52:
        e = e;
        r15 = r29;
        r18 = ", ";
    L55:
        e = e;
        r14 = r26;
        r13 = r30;
        r37 = r37;
        r16 = r4;
        r18 = ", ";
        r15 = r29;
    L57:
        e = e;
    L61:
        r16 = r5;
    L62:
        r23 = r6;
        goto L65
    L75:
        r37 = r37;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r5, "logOmniStep(" + r14 + ", " + r27 + ", " + r15 + ", " + r13 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ", " + r35 + ", " + r37 + r6);     // Catch: Exception -> L57 Throwable -> L68
    L18:
        e = e;
    L60:
        r37 = r37;
    L59:
        e = e;
    L10:
        e = e;
        r37 = r37;
        goto L62
    L12:
        r5 = r16;
        r6 = ")";
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r24, long r25, String r27, long r28, String r30, String r31) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L31:
        e = e;
        String r9 = ", ";
        String r20 = "IFlowCocreationReviewIDLIPC";
        String r22 = ")";
        long r13 = r28;
        String r15 = "logOmniUserStop(";
    L33:
        long r5 = r13;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r20, r15 + r24 + r9 + r25 + r9 + r27 + r9 + r13 + r9 + r30 + r9 + r31 + r22, e);     // Catch: Throwable -> L35
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L35
        long r14 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L35
        long r0 = Math.max(0, r14 - r16) / 1000;     // Catch: Throwable -> L35
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowCocreationReviewIDLIPC", r15 + r24 + r9 + r25 + r9 + r27 + r9 + r5 + r9 + r30 + r9 + r31 + ") = fail", r1, r0);     // Catch: Throwable -> L35
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r1, r0, r14);     // Catch: Throwable -> L35
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r24 + ", " + r25 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L31 Throwable -> L35
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop(" + r24 + ", " + r25 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L31 Throwable -> L35
    L9:
        r20 = "IFlowCocreationReviewIDLIPC";
        r22 = ")";
        r15 = "logOmniUserStop(";
        this.origin.logOmniUserStop(r24, r25, r27, r28, r30, r31);     // Catch: Exception -> L28 Throwable -> L35
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r20, "logOmniUserStop = void");     // Catch: Exception -> L28 Throwable -> L35
    L14:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L28 Throwable -> L35
        long r6 = Math.max(0, r7 - r16) / 1000;     // Catch: Exception -> L28 Throwable -> L35
        r9 = ", ";
        com.obric.aiagent.ipc.utils.k.f18677a.a(r20, r15 + r24 + r9 + r25 + r9 + r27 + r9 + r28 + r9 + r30 + r9 + r31 + ") = void", r6);     // Catch: Exception -> L24 Throwable -> L35
        r20 = r20;
        r13 = r28;
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowCocreationReviewIDLIPC", "logOmniUserStop", r6, r7);     // Catch: Exception -> L22 Throwable -> L35
        return;
    L22:
        e = e;
    L24:
        e = e;
        r20 = r20;
        r13 = r28;
    L26:
        e = e;
    L30:
        r13 = r28;
    L28:
        e = e;
        r9 = ", ";
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
