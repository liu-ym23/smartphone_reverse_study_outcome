package com.stepos.ability.api.task.listener;

import androidx.core.app.NotificationCompat;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H&¢\u0006\u0004\b\u0015\u0010\u0016JI\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J1\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J?\u0010/\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100J'\u00101\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u00102¨\u00063À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/task/listener/ITaskListener;", "", "Lcom/stepos/ability/ITaskListener;", "aidlTaskListener", "", "key", "LC7/r;", "registerTaskListener", "(Lcom/stepos/ability/ITaskListener;Ljava/lang/String;)V", "unRegisterTaskListener", "(Ljava/lang/String;)V", "Lcom/stepos/ability/bean/Task;", "task", "", "publishToTaskListener", "onTaskEvent", "(Lcom/stepos/ability/bean/Task;Z)V", "Lcom/stepos/ability/bean/ToolCallEvent;", NotificationCompat.CATEGORY_EVENT, "onToolCallEvent", "(Lcom/stepos/ability/bean/ToolCallEvent;)V", "clear", "()V", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "requestId", "inputType", "message", "payloadJson", "", "timeoutMs", "chatSessionId", "onInfoRequested", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "reason", "onInfoDismissed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ability/bean/ExplainSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "onExplainUpdated", "(Ljava/lang/String;Lcom/stepos/ability/bean/ExplainSnapshot;)V", "", "conflictKind", "newTaskId", "newTaskName", "runningTaskId", "packageName", "hint", "onPackageConflict", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onRequestRelaunch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITaskListener {
    static /* synthetic */ void onInfoDismissed$default(ITaskListener iTaskListener, String str, String str2, String str3, String str4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInfoDismissed");
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        iTaskListener.onInfoDismissed(str, str2, str3, str4);
    }

    static /* synthetic */ void onInfoRequested$default(ITaskListener iTaskListener, String str, String str2, String str3, String str4, String str5, long j5, String str6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInfoRequested");
        }
        iTaskListener.onInfoRequested(str, str2, str3, str4, str5, j5, (i & 64) != 0 ? "" : str6);
    }

    static /* synthetic */ void onTaskEvent$default(ITaskListener iTaskListener, Task task, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTaskEvent");
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        iTaskListener.onTaskEvent(task, z10);
    }

    void clear();

    default void onExplainUpdated(String taskId, ExplainSnapshot snapshot) {
        k.f(taskId, "taskId");
        k.f(snapshot, "snapshot");
    }

    default void onInfoDismissed(String taskId, String requestId, String reason, String chatSessionId) {
        k.f(taskId, "taskId");
        k.f(requestId, "requestId");
        k.f(reason, "reason");
        k.f(chatSessionId, "chatSessionId");
    }

    default void onInfoRequested(String taskId, String requestId, String inputType, String message, String payloadJson, long timeoutMs, String chatSessionId) {
        k.f(taskId, "taskId");
        k.f(requestId, "requestId");
        k.f(inputType, "inputType");
        k.f(message, "message");
        k.f(payloadJson, "payloadJson");
        k.f(chatSessionId, "chatSessionId");
    }

    default void onPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
        k.f(newTaskId, "newTaskId");
        k.f(newTaskName, "newTaskName");
        k.f(runningTaskId, "runningTaskId");
        k.f(packageName, "packageName");
        k.f(hint, "hint");
    }

    default void onRequestRelaunch(String taskId, String chatSessionId, String reason) {
        k.f(taskId, "taskId");
        k.f(chatSessionId, "chatSessionId");
        k.f(reason, "reason");
    }

    void onTaskEvent(Task task, boolean publishToTaskListener);

    void onToolCallEvent(ToolCallEvent event);

    void registerTaskListener(com.stepos.ability.ITaskListener aidlTaskListener, String key);

    void unRegisterTaskListener(String key);
}
