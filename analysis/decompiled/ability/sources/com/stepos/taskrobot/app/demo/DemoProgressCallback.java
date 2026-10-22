package com.stepos.taskrobot.app.demo;

import S7.o;
import S7.r;
import android.graphics.Bitmap;
import androidx.constraintlayout.core.dsl.a;
import b6.C0826a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.bean.ActionInfo;
import com.stepos.taskrobot.common.bean.ExplainSnapshot;
import com.stepos.taskrobot.common.bean.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 82\u00020\u0001:\u00019Bg\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012:\u0010\t\u001a6\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\n\u0010\u000bJK\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0015\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u0006\u0010\u001cJ]\u0010#\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b#\u0010$J7\u0010&\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+JI\u00102\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u00032\b\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00032\b\u00100\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b2\u00103J-\u00104\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b4\u00105R0\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106RH\u0010\t\u001a6\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107¨\u0006:"}, d2 = {"Lcom/stepos/taskrobot/app/demo/DemoProgressCallback;", "Lcom/stepos/taskrobot/common/ITaskProgressCallback$Stub;", "Lkotlin/Function3;", "", "Landroid/graphics/Bitmap;", "LC7/r;", "onAction", "Lkotlin/Function6;", "", "onPackageConflictFn", AppAgent.CONSTRUCT, "(LS7/o;LS7/r;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, GuiTaskProgressKt.GuiTaskProgress_KEY_BITMAP_ID, "bitmap", "message", "onTaskAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_BITMAP_URL, "onTaskActionPair", "Lcom/stepos/taskrobot/common/bean/TaskInfo;", "taskInfo", "onTaskStatusChange", "(Lcom/stepos/taskrobot/common/bean/TaskInfo;)V", "Lcom/stepos/taskrobot/common/bean/ActionInfo;", "actionInfo", "(Lcom/stepos/taskrobot/common/bean/TaskInfo;Lcom/stepos/taskrobot/common/bean/ActionInfo;)V", "requestId", "inputType", "payloadJson", "", "timeoutMs", "chatSessionId", "onInfoRequested", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "reason", "onInfoDismissed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "onExplainUpdated", "(Ljava/lang/String;Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;)V", "conflictKind", "newTaskId", "newTaskName", "runningTaskId", "packageName", "hint", "onPackageConflict", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onRequestRelaunch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "LS7/o;", "LS7/r;", "Companion", "b6/a", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DemoProgressCallback extends ITaskProgressCallback.Stub {
    public static final C0826a Companion = new C0826a();
    private static final String TAG = "DemoProgressCallback";
    private final o onAction;
    private final r onPackageConflictFn;

    public DemoProgressCallback(o onAction, r onPackageConflictFn) {
        k.f(onAction, "onAction");
        k.f(onPackageConflictFn, "onPackageConflictFn");
        this.onAction = onAction;
        this.onPackageConflictFn = onPackageConflictFn;
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onAction(TaskInfo taskInfo, ActionInfo actionInfo) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onExplainUpdated(String taskId, ExplainSnapshot snapshot) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onInfoDismissed(String taskId, String requestId, String reason, String chatSessionId) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onInfoRequested(String taskId, String taskName, String requestId, String inputType, String message, String payloadJson, long timeoutMs, String chatSessionId) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
        try {
            this.onPackageConflictFn.invoke(Integer.valueOf(conflictKind), newTaskId, newTaskName, runningTaskId, packageName, hint);
        } catch (Throwable th) {
            a.w("onPackageConflict dispatch failed: ", th.getMessage(), TAG);
        }
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onRequestRelaunch(String taskId, String chatSessionId, String reason) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onTaskAction(String taskId, String taskName, String action, String bitmapId, Bitmap bitmap, String message) {
        if (action == null) {
            return;
        }
        try {
            this.onAction.invoke(action, message, bitmap);
        } catch (Throwable th) {
            a.w("onTaskAction dispatch failed: ", th.getMessage(), TAG);
        }
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onTaskActionPair(String taskId, String taskName, String action, String bitmapId, Bitmap bitmap, String bitmapUrl) {
    }

    @Override // com.stepos.taskrobot.common.ITaskProgressCallback
    public void onTaskStatusChange(TaskInfo taskInfo) {
    }
}
