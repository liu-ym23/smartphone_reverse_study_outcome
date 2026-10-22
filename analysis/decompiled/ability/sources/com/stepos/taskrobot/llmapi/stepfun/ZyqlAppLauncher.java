package com.stepos.taskrobot.llmapi.stepfun;

import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.action.ActionResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import stepai.aios.guiagent.app.AppLauncher;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlAppLauncher;", "Lstepai/aios/guiagent/app/AppLauncher;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "getActionDisplayId", "Lcom/mdisdk/Task;", "taskProvider", AppAgent.CONSTRUCT, "(Ljava/lang/String;Landroid/content/Context;LS7/a;LS7/a;)V", "Lcom/mdisdk/action/ActionResult;", "", "isSuccess", "(Lcom/mdisdk/action/ActionResult;)Z", "Lstepai/aios/guiagent/app/AppLaunchRequest;", "req", "Lkotlin/Result;", "launch-gIAlu-s", "(Lstepai/aios/guiagent/app/AppLaunchRequest;LH7/c;)Ljava/lang/Object;", "launch", "Ljava/lang/String;", "Landroid/content/Context;", "LS7/a;", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "taskEntity", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getTaskEntity", "()Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "setTaskEntity", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)V", "getTask", "()Lcom/mdisdk/Task;", "task", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlAppLauncher implements AppLauncher {
    private static final String TAG = "ZyqlAppLauncher";
    private final Context context;
    private final S7.a getActionDisplayId;
    private TaskEntity taskEntity;
    private final String taskId;
    private final S7.a taskProvider;

    public ZyqlAppLauncher(String taskId, Context context, S7.a getActionDisplayId, S7.a taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(getActionDisplayId, "getActionDisplayId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        this.taskId = taskId;
        this.context = context;
        this.getActionDisplayId = getActionDisplayId;
        this.taskProvider = taskProvider;
    }

    private final Task getTask() {
        return (Task) this.taskProvider.invoke();
    }

    private final boolean isSuccess(ActionResult<?> actionResult) {
        if (actionResult instanceof ActionResult.Success) {
            return true;
        }
        if (actionResult instanceof ActionResult.Failure) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final TaskEntity getTaskEntity() {
        return this.taskEntity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // stepai.aios.guiagent.app.AppLauncher
    /* renamed from: launch-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo7350launchgIAlus(stepai.aios.guiagent.app.AppLaunchRequest r24, H7.c<? super kotlin.Result<java.lang.String>> r25) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlAppLauncher.mo7350launchgIAlus(stepai.aios.guiagent.app.AppLaunchRequest, H7.c):java.lang.Object");
    }

    public final void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
