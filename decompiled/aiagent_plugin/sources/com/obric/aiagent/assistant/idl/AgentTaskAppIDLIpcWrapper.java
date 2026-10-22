package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class AgentTaskAppIDLIpcWrapper implements IAgentTaskAppIDL {
    boolean log;
    final IAgentTaskAppIDL origin;

    AgentTaskAppIDLIpcWrapper(IAgentTaskAppIDL r3) {
        this((IAgentTaskAppIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentTaskAppIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentTaskAppIDLIpcWrapper(IAgentTaskAppIDL r3, boolean r4) {
        this.origin = (IAgentTaskAppIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentTaskAppIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void openEventTaskDetailPage(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.openEventTaskDetailPage(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "openEventTaskDetailPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "openEventTaskDetailPage", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void testRunConditionTask(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "testRunConditionTask(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "testRunConditionTask(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "testRunConditionTask", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "testRunConditionTask(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "testRunConditionTask(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.testRunConditionTask(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "testRunConditionTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "testRunConditionTask(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "testRunConditionTask", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void addTaskManagerShortcut(PendingIntent r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.addTaskManagerShortcut(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "addTaskManagerShortcut = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "addTaskManagerShortcut", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean shouldShowAddTaskManagerIconGuide() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.shouldShowAddTaskManagerIconGuide();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "shouldShowAddTaskManagerIconGuide", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public boolean hasShortcutForMessage(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.hasShortcutForMessage(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "hasShortcutForMessage = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "hasShortcutForMessage", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        List<ShortcutRecommendItem> r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getShortcutRecommendItems(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "getShortcutRecommendItems = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "getShortcutRecommendItems", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
    public void runShortcutTaskFromRecommendPanel(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.runShortcutTaskFromRecommendPanel(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentTaskAppIDLIPC", "runShortcutTaskFromRecommendPanel", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
