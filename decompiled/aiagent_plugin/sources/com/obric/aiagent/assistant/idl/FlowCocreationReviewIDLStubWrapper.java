package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class FlowCocreationReviewIDLStubWrapper extends IFlowCocreationReviewIDL.Stub {
    boolean log;
    final IFlowCocreationReviewIDL.Stub origin;

    FlowCocreationReviewIDLStubWrapper(IFlowCocreationReviewIDL.Stub r2) {
        this(r2, true);
    }

    FlowCocreationReviewIDLStubWrapper(IFlowCocreationReviewIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniStep(String r26, long r27, String r29, int r30, String r31, String r32, boolean r33, boolean r34, long r35, String r37) {
        int r13 = r30;
        String r2 = "logOmniStep(";
        String r16 = "FlowCocreationReviewIDLStub";
        String r1 = ", ";
        long r17 = SystemClock.elapsedRealtimeNanos();
        if (this.log == true) goto L70;
        String r5 = r37;
        String r14 = r16;
        String r6 = ")";
    L21:
        String r15 = r14;
        String r22 = r6;
        r2 = "logOmniStep(";
        this.origin.logOmniStep(r26, r27, r29, r30, r31, r32, r33, r34, r35, r37);     // Catch: Exception -> L54
        if (this.log == false) goto L26;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r15, "logOmniStep = void");     // Catch: Exception -> L54
    L26:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L54
        long r8 = Math.max(0, r7 - r17) / 1000;     // Catch: Exception -> L54
        r26 = r26;
        r1 = ", ";
        String r18 = r29;
        r37 = r37;
        com.obric.aiagent.ipc.utils.k.f18677a.b(r15, r2 + r26 + r1 + r27 + r1 + r18 + r1 + r30 + r1 + r31 + r1 + r32 + r1 + r33 + r1 + r34 + r1 + r35 + r1 + r37 + ") = void", r8);     // Catch: Exception -> L42
        r16 = r15;
        r13 = r30;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowCocreationReviewIDLStub", "logOmniStep", r8, r7);     // Catch: Exception -> L40
        return;
    L40:
        e = e;
    L62:
        com.obric.aiagent.ipc.utils.j.f18676a.a(r16, r2 + r26 + r1 + r27 + r1 + r18 + r1 + r13 + r1 + r31 + r1 + r32 + r1 + r33 + r1 + r34 + r1 + r35 + r1 + r37 + r22, e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r0 = Math.max(0, r23 - r17) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowCocreationReviewIDLStub", r2 + r26 + r1 + r27 + r1 + r18 + r1 + r13 + r1 + r31 + r1 + r32 + r1 + r33 + r1 + r34 + r1 + r35 + r1 + r37 + ") = fail", r3, r0);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowCocreationReviewIDLStub", "logOmniStep", r3, r0, r23);
        throw r3;
    L42:
        e = e;
    L46:
        r16 = r15;
        r13 = r30;
    L44:
        e = e;
        r37 = r37;
    L47:
        e = e;
    L57:
        r16 = r15;
        r13 = r30;
    L49:
        e = e;
        r18 = r29;
    L52:
        e = e;
    L56:
        r18 = r29;
        r1 = ", ";
    L54:
        e = e;
        r26 = r26;
    L58:
        e = e;
        r26 = r26;
        r1 = ", ";
        r37 = r5;
        r22 = r6;
        r13 = r13;
        r16 = r14;
        r18 = r29;
        r2 = "logOmniStep(";
        goto L62
    L70:
        r5 = r37;
        r6 = ")";
        r14 = r16;
        com.obric.aiagent.ipc.utils.j.f18676a.b(r14, "logOmniStep(" + r26 + ", " + r27 + ", " + r29 + ", " + r13 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ", " + r35 + ", " + r5 + r6);     // Catch: Exception -> L58
    L12:
        e = e;
        r26 = r26;
        r1 = ", ";
        r2 = "logOmniStep(";
        r37 = r5;
        r22 = r6;
    L19:
        r18 = r29;
    L14:
        e = e;
        r37 = r5;
    L18:
        r22 = ")";
    L16:
        e = e;
        r37 = r37;
    L60:
        e = e;
        r37 = r37;
        r1 = ", ";
        r26 = r26;
        r22 = ")";
        r2 = "logOmniStep(";
        r13 = r13;
        r18 = r29;
        goto L62
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL
    public void logOmniUserStop(String r24, long r25, String r27, long r28, String r30, String r31) {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L28:
        e = e;
        String r9 = ", ";
        String r20 = "FlowCocreationReviewIDLStub";
        String r22 = ")";
        long r13 = r28;
        String r15 = "logOmniUserStop(";
    L30:
        long r5 = r13;
        com.obric.aiagent.ipc.utils.j.f18676a.a(r20, r15 + r24 + r9 + r25 + r9 + r27 + r9 + r13 + r9 + r30 + r9 + r31 + r22, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r14 = SystemClock.elapsedRealtimeNanos();
        long r0 = Math.max(0, r14 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowCocreationReviewIDLStub", r15 + r24 + r9 + r25 + r9 + r27 + r9 + r5 + r9 + r30 + r9 + r31 + ") = fail", r1, r0);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowCocreationReviewIDLStub", "logOmniUserStop", r1, r0, r14);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowCocreationReviewIDLStub", "logOmniUserStop(" + r24 + ", " + r25 + ", " + r27 + ", " + r28 + ", " + r30 + ", " + r31 + ")");     // Catch: Exception -> L28
    L6:
        r20 = "FlowCocreationReviewIDLStub";
        r22 = ")";
        r15 = "logOmniUserStop(";
        this.origin.logOmniUserStop(r24, r25, r27, r28, r30, r31);     // Catch: Exception -> L25
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.j.f18676a.c(r20, "logOmniUserStop = void");     // Catch: Exception -> L25
    L11:
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L25
        long r6 = Math.max(0, r7 - r16) / 1000;     // Catch: Exception -> L25
        r9 = ", ";
        com.obric.aiagent.ipc.utils.k.f18677a.b(r20, r15 + r24 + r9 + r25 + r9 + r27 + r9 + r28 + r9 + r30 + r9 + r31 + ") = void", r6);     // Catch: Exception -> L21
        r20 = r20;
        r13 = r28;
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowCocreationReviewIDLStub", "logOmniUserStop", r6, r7);     // Catch: Exception -> L19
        return;
    L19:
        e = e;
    L21:
        e = e;
        r20 = r20;
        r13 = r28;
    L23:
        e = e;
    L27:
        r13 = r28;
    L25:
        e = e;
        r9 = ", ";
        goto L27
    }
}
