package com.stepos.ability.task.executor;

import C7.r;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.WhitelistCheckResult;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;

/* loaded from: classes3.dex */
public final class f extends a {
    public final Map d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ITaskListener taskListener, Map executorMap) {
        super(taskListener);
        k.f(taskListener, "taskListener");
        k.f(executorMap, "executorMap");
        this.d = executorMap;
    }

    public final ITaskExecutor b(int i) {
        ITaskExecutor iTaskExecutor = (ITaskExecutor) this.d.get(Integer.valueOf(i));
        if (iTaskExecutor == null) {
            String msg = "unknow Type:" + i;
            k.f(msg, "msg");
            P3.c.f1086a.invoke(6, "Ability_".concat("TaskExecutor"), msg, null);
        }
        return iTaskExecutor;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancel(Task task, H7.c cVar) {
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskExecutor"), androidx.constraintlayout.core.dsl.a.h("cancel: ", task != null ? task.getTaskId() : null, NotificationCompat.CATEGORY_MESSAGE), null);
        AbstractC1683A.n(this.b, null, new TaskExecutor$cancel$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancelFullScreenGUI(Task task, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$cancelFullScreenGUI$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final void cancelPackageConflict(String newTaskId, int i) {
        k.f(newTaskId, "newTaskId");
        ITaskExecutor iTaskExecutorB = b(1);
        if (iTaskExecutorB != null) {
            iTaskExecutorB.cancelPackageConflict(newTaskId, i);
        }
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancelUserInput(String str, String str2, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$cancelUserInput$2(this, str, str2, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final WhitelistCheckResult checkAppWhitelist(String appName) {
        WhitelistCheckResult whitelistCheckResultCheckAppWhitelist;
        k.f(appName, "appName");
        ITaskExecutor iTaskExecutorB = b(1);
        return (iTaskExecutorB == null || (whitelistCheckResultCheckAppWhitelist = iTaskExecutorB.checkAppWhitelist(appName)) == null) ? new WhitelistCheckResult(2, "", -1) : whitelistCheckResultCheckAppWhitelist;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final void confirmPackageConflict(String newTaskId, int i) {
        k.f(newTaskId, "newTaskId");
        ITaskExecutor iTaskExecutorB = b(1);
        if (iTaskExecutorB != null) {
            iTaskExecutorB.confirmPackageConflict(newTaskId, i);
        }
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object dismissFullScreenOverlay(String str, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$dismissFullScreenOverlay$2(this, str, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object dismissVoiceInput(String str, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$dismissVoiceInput$2(this, str, null), 3);
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(com.stepos.ability.bean.InternalTask r9, int r10, int r11, H7.c r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stepos.ability.task.executor.TaskExecutor$execute$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ability.task.executor.TaskExecutor$execute$1 r0 = (com.stepos.ability.task.executor.TaskExecutor$execute$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.stepos.ability.task.executor.TaskExecutor$execute$1 r0 = new com.stepos.ability.task.executor.TaskExecutor$execute$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            com.stepos.ability.bean.InternalTask r9 = r0.f3285a
            kotlin.b.b(r12)
            goto L4d
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.b.b(r12)
            com.stepos.ability.bean.Task r12 = r9.getTask()
            int r12 = r12.getTaskType()
            com.stepos.ability.api.task.executor.ITaskExecutor r8 = r8.b(r12)
            if (r8 == 0) goto L53
            r0.f3285a = r9
            r0.d = r3
            java.lang.Object r12 = r8.execute(r9, r10, r11, r0)
            if (r12 != r1) goto L4d
            return r1
        L4d:
            com.stepos.ability.bean.TaskResult r12 = (com.stepos.ability.bean.TaskResult) r12
            if (r12 != 0) goto L52
            goto L53
        L52:
            return r12
        L53:
            com.stepos.ability.bean.TaskResult r0 = new com.stepos.ability.bean.TaskResult
            com.stepos.ability.bean.Task r8 = r9.getTask()
            java.lang.String r1 = r8.getTaskId()
            com.stepos.ability.bean.Task r8 = r9.getTask()
            int r8 = r8.getTaskType()
            java.lang.String r9 = "unknow type:"
            java.lang.String r4 = B7.a.h(r8, r9)
            r6 = 20
            r7 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.f.execute(com.stepos.ability.bean.InternalTask, int, int, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object fullScreenGUI(Task task, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$fullScreenGUI$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final String getForegroundTaskId() {
        ITaskExecutor iTaskExecutorB = b(1);
        String foregroundTaskId = iTaskExecutorB != null ? iTaskExecutorB.getForegroundTaskId() : null;
        return foregroundTaskId == null ? "" : foregroundTaskId;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        MainDisplayTopAppHistory mainDisplayTopAppHistory;
        ITaskExecutor iTaskExecutorB = b(1);
        return (iTaskExecutorB == null || (mainDisplayTopAppHistory = iTaskExecutorB.getMainDisplayTopAppHistory()) == null) ? new MainDisplayTopAppHistory(false, false, "", "", 0L, 0L, "") : mainDisplayTopAppHistory;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final AppOccupationResult isAppOccupied(String appName) {
        AppOccupationResult appOccupationResultIsAppOccupied;
        k.f(appName, "appName");
        ITaskExecutor iTaskExecutorB = b(1);
        return (iTaskExecutorB == null || (appOccupationResultIsAppOccupied = iTaskExecutorB.isAppOccupied(appName)) == null) ? new AppOccupationResult(false, "", "") : appOccupationResultIsAppOccupied;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final List listActiveTasks() {
        ITaskExecutor iTaskExecutorB = b(1);
        List<TaskSnapshot> listListActiveTasks = iTaskExecutorB != null ? iTaskExecutorB.listActiveTasks() : null;
        return listListActiveTasks == null ? EmptyList.f4893a : listListActiveTasks;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object pause(Task task, H7.c cVar) {
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskExecutor"), androidx.constraintlayout.core.dsl.a.h("pause: ", task != null ? task.getTaskId() : null, NotificationCompat.CATEGORY_MESSAGE), null);
        AbstractC1683A.n(this.b, null, new TaskExecutor$pause$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object resume(Task task, H7.c cVar) {
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskExecutor"), androidx.constraintlayout.core.dsl.a.h("resume: ", task != null ? task.getTaskId() : null, NotificationCompat.CATEGORY_MESSAGE), null);
        AbstractC1683A.n(this.b, null, new TaskExecutor$resume$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object resumeFullScreenOverlay(String str, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$resumeFullScreenOverlay$2(this, str, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object showFullScreenGuiV2(String str, Bundle bundle, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$showFullScreenGuiV2$2(this, str, bundle, null), 3);
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object submitPermissionAuthResult(boolean r5, java.lang.String r6, android.os.Bundle r7, H7.c r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ability.task.executor.TaskExecutor$submitPermissionAuthResult$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.task.executor.TaskExecutor$submitPermissionAuthResult$1 r0 = (com.stepos.ability.task.executor.TaskExecutor$submitPermissionAuthResult$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.task.executor.TaskExecutor$submitPermissionAuthResult$1 r0 = new com.stepos.ability.task.executor.TaskExecutor$submitPermissionAuthResult$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f3291a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r8)
            goto L57
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r8)
            r8 = 0
            com.stepos.ability.api.task.executor.ITaskExecutor r4 = r4.b(r8)
            if (r4 == 0) goto L42
            r0.c = r3
            java.lang.Object r4 = r4.submitPermissionAuthResult(r5, r6, r7, r0)
            if (r4 != r1) goto L57
            return r1
        L42:
            r4 = 5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Ability_"
            java.lang.String r6 = "TaskExecutor"
            java.lang.String r5 = r5.concat(r6)
            P3.b r6 = P3.c.f1086a
            java.lang.String r7 = "submitPermissionAuthResult: TOOL executor missing"
            r8 = 0
            r6.invoke(r4, r5, r7, r8)
        L57:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.f.submitPermissionAuthResult(boolean, java.lang.String, android.os.Bundle, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object submitUserInput(String str, String str2, String str3, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$submitUserInput$2(this, str, str2, str3, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object takeOver(Task task, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$takeOver$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object unTakeOver(Task task, H7.c cVar) {
        AbstractC1683A.n(this.b, null, new TaskExecutor$unTakeOver$2(task, this, null), 3);
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object updateTask(String str, int i, Bundle bundle, H7.c cVar) {
        String msg = "updateTask: taskId=" + str + ", taskType=" + i;
        k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskExecutor"), msg, null);
        AbstractC1683A.n(this.b, null, new TaskExecutor$updateTask$2(this, i, str, bundle, null), 3);
        return r.f317a;
    }
}
