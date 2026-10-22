package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AgentTaskAppIDLStubWrapper extends IAgentTaskAppIDL.Stub {
    boolean log;
    final IAgentTaskAppIDL.Stub origin;

    AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r2) {
        this(r2, true);
    }

    AgentTaskAppIDLStubWrapper(IAgentTaskAppIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void openEventTaskDetailPage(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "openEventTaskDetailPage", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.openEventTaskDetailPage(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "openEventTaskDetailPage = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "openEventTaskDetailPage", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void testRunConditionTask(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "testRunConditionTask", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.testRunConditionTask(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "testRunConditionTask = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "testRunConditionTask(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "testRunConditionTask", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void addTaskManagerShortcut(PendingIntent r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "addTaskManagerShortcut", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.addTaskManagerShortcut(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "addTaskManagerShortcut = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "addTaskManagerShortcut(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "addTaskManagerShortcut", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean shouldShowAddTaskManagerIconGuide() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.shouldShowAddTaskManagerIconGuide();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "shouldShowAddTaskManagerIconGuide", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean hasShortcutForMessage(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "hasShortcutForMessage", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.hasShortcutForMessage(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "hasShortcutForMessage = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "hasShortcutForMessage(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "hasShortcutForMessage", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "getShortcutRecommendItems", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        List<ShortcutRecommendItem> r11 = this.origin.getShortcutRecommendItems(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "getShortcutRecommendItems = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "getShortcutRecommendItems(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "getShortcutRecommendItems", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void runShortcutTaskFromRecommendPanel(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.runShortcutTaskFromRecommendPanel(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentTaskAppIDLStub", "runShortcutTaskFromRecommendPanel", r13, r110);     // Catch: Exception -> L11
    }
}
