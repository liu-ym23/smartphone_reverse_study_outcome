package com.stepos.ability.api.task.executor;

import C7.r;
import H7.c;
import android.os.Bundle;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskResult;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.WhitelistCheckResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H¦@¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u0010\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u0011\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u0012\u0010\u000eJ\u001a\u0010\u0013\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u0013\u0010\u000eJ\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0004\b\u0014\u0010\u000eJ(\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H¦@¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\"\u0010#J(\u0010&\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b&\u0010'J \u0010(\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b(\u0010)J\"\u0010+\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0015H\u0016¢\u0006\u0004\b1\u0010\u001dJ\u000f\u00102\u001a\u00020\u0015H\u0016¢\u0006\u0004\b2\u0010\u001dJ\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u0002062\u0006\u0010-\u001a\u00020\u0015H\u0016¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010<J\u001a\u0010>\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0004\b>\u0010#J\u001a\u0010?\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0004\b?\u0010#J(\u0010D\u001a\u00020\f2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0018H\u0096@¢\u0006\u0004\bD\u0010E¨\u0006FÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/task/executor/ITaskExecutor;", "", "Lcom/stepos/ability/bean/InternalTask;", "internalTask", "", "callingUid", "callingPid", "Lcom/stepos/ability/bean/TaskResult;", "execute", "(Lcom/stepos/ability/bean/InternalTask;IILH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/bean/Task;", "task", "LC7/r;", "pause", "(Lcom/stepos/ability/bean/Task;LH7/c;)Ljava/lang/Object;", "resume", "cancel", "takeOver", "unTakeOver", "fullScreenGUI", "cancelFullScreenGUI", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "taskType", "Landroid/os/Bundle;", "bundle", "updateTask", "(Ljava/lang/String;ILandroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "getForegroundTaskId", "()Ljava/lang/String;", "", "Lcom/stepos/ability/bean/TaskSnapshot;", "listActiveTasks", "()Ljava/util/List;", "dismissVoiceInput", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "requestId", "content", "submitUserInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "cancelUserInput", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "options", "showFullScreenGuiV2", "(Ljava/lang/String;Landroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "appName", "Lcom/stepos/ability/bean/WhitelistCheckResult;", "checkAppWhitelist", "(Ljava/lang/String;)Lcom/stepos/ability/bean/WhitelistCheckResult;", "getForegroundTaskSessionId", "getLastActiveTaskSessionId", "Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "getMainDisplayTopAppHistory", "()Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "Lcom/stepos/ability/bean/AppOccupationResult;", "isAppOccupied", "(Ljava/lang/String;)Lcom/stepos/ability/bean/AppOccupationResult;", "newTaskId", "conflictKind", "confirmPackageConflict", "(Ljava/lang/String;I)V", "cancelPackageConflict", "dismissFullScreenOverlay", "resumeFullScreenOverlay", "", "agreed", Key.KEY_TOOL_CALL_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "submitPermissionAuthResult", "(ZLjava/lang/String;Landroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITaskExecutor {
    static /* synthetic */ Object cancelUserInput$suspendImpl(ITaskExecutor iTaskExecutor, String str, String str2, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object dismissFullScreenOverlay$suspendImpl(ITaskExecutor iTaskExecutor, String str, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object dismissVoiceInput$suspendImpl(ITaskExecutor iTaskExecutor, String str, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object execute$default(ITaskExecutor iTaskExecutor, InternalTask internalTask, int i, int i6, c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i10 & 4) != 0) {
            i6 = 0;
        }
        return iTaskExecutor.execute(internalTask, i, i6, cVar);
    }

    static /* synthetic */ Object resumeFullScreenOverlay$suspendImpl(ITaskExecutor iTaskExecutor, String str, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object showFullScreenGuiV2$suspendImpl(ITaskExecutor iTaskExecutor, String str, Bundle bundle, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object submitPermissionAuthResult$suspendImpl(ITaskExecutor iTaskExecutor, boolean z10, String str, Bundle bundle, c<? super r> cVar) {
        return r.f317a;
    }

    static /* synthetic */ Object submitUserInput$suspendImpl(ITaskExecutor iTaskExecutor, String str, String str2, String str3, c<? super r> cVar) {
        return r.f317a;
    }

    Object cancel(Task task, c<? super r> cVar);

    Object cancelFullScreenGUI(Task task, c<? super r> cVar);

    default void cancelPackageConflict(String newTaskId, int conflictKind) {
        k.f(newTaskId, "newTaskId");
    }

    default Object cancelUserInput(String str, String str2, c<? super r> cVar) {
        return cancelUserInput$suspendImpl(this, str, str2, cVar);
    }

    default WhitelistCheckResult checkAppWhitelist(String appName) {
        k.f(appName, "appName");
        return new WhitelistCheckResult(2, "", -1);
    }

    default void confirmPackageConflict(String newTaskId, int conflictKind) {
        k.f(newTaskId, "newTaskId");
    }

    default Object dismissFullScreenOverlay(String str, c<? super r> cVar) {
        return dismissFullScreenOverlay$suspendImpl(this, str, cVar);
    }

    default Object dismissVoiceInput(String str, c<? super r> cVar) {
        return dismissVoiceInput$suspendImpl(this, str, cVar);
    }

    Object execute(InternalTask internalTask, int i, int i6, c<? super TaskResult> cVar);

    Object fullScreenGUI(Task task, c<? super r> cVar);

    default String getForegroundTaskId() {
        return "";
    }

    default String getForegroundTaskSessionId() {
        return "";
    }

    default String getLastActiveTaskSessionId() {
        return "";
    }

    default MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        return new MainDisplayTopAppHistory(false, false, "", "", 0L, 0L, "");
    }

    default AppOccupationResult isAppOccupied(String appName) {
        k.f(appName, "appName");
        return new AppOccupationResult(false, "", "");
    }

    default List<TaskSnapshot> listActiveTasks() {
        return EmptyList.f4893a;
    }

    Object pause(Task task, c<? super r> cVar);

    Object resume(Task task, c<? super r> cVar);

    default Object resumeFullScreenOverlay(String str, c<? super r> cVar) {
        return resumeFullScreenOverlay$suspendImpl(this, str, cVar);
    }

    default Object showFullScreenGuiV2(String str, Bundle bundle, c<? super r> cVar) {
        return showFullScreenGuiV2$suspendImpl(this, str, bundle, cVar);
    }

    default Object submitPermissionAuthResult(boolean z10, String str, Bundle bundle, c<? super r> cVar) {
        return submitPermissionAuthResult$suspendImpl(this, z10, str, bundle, cVar);
    }

    default Object submitUserInput(String str, String str2, String str3, c<? super r> cVar) {
        return submitUserInput$suspendImpl(this, str, str2, str3, cVar);
    }

    Object takeOver(Task task, c<? super r> cVar);

    Object unTakeOver(Task task, c<? super r> cVar);

    Object updateTask(String str, int i, Bundle bundle, c<? super r> cVar);
}
