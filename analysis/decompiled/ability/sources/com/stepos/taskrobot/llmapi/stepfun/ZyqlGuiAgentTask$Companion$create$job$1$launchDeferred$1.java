package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import com.mdisdk.Task;
import com.mdisdk.action.ActionResult;
import com.mdisdk.action.OpenAppAction;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.model.SessionState;
import stepai.android.llm.base.twoway.FlowType;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1", f = "ZyqlGuiAgentTask.kt", l = {412, 415}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ Context $context;
    final /* synthetic */ ZyqlGuiAgentTask $guiTask;
    final /* synthetic */ Task $mdiTask;
    final /* synthetic */ String $openAppName;
    final /* synthetic */ String $taskId;
    final /* synthetic */ int $taskType;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1(Context context, String str, int i, Task task, String str2, ZyqlGuiAgentTask zyqlGuiAgentTask, H7.c<? super ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$openAppName = str;
        this.$taskType = i;
        this.$mdiTask = task;
        this.$taskId = str2;
        this.$guiTask = zyqlGuiAgentTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1(this.$context, this.$openAppName, this.$taskType, this.$mdiTask, this.$taskId, this.$guiTask, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objExecute;
        String str;
        String str2;
        Object objExecute2;
        ActionResult actionResult;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        r rVar = r.f317a;
        boolean z10 = false;
        if (i == 0) {
            kotlin.b.b(obj);
            PackageUtil packageUtil = PackageUtil.INSTANCE;
            Context context = this.$context;
            String str3 = this.$openAppName;
            if (str3 == null) {
                str3 = "";
            }
            String packageNameByAppName = packageUtil.getPackageNameByAppName(context, str3);
            if (packageNameByAppName == null) {
                return rVar;
            }
            String currentTimeString = ZyqlGuiAgentTask.INSTANCE.getCurrentTimeString();
            if (this.$taskType != 0) {
                Task task = this.$mdiTask;
                OpenAppAction openAppAction = new OpenAppAction(packageNameByAppName, null, null, new Integer(task.getDisplayId()), null, 22, null);
                this.L$0 = packageNameByAppName;
                this.L$1 = currentTimeString;
                this.label = 1;
                objExecute2 = task.execute(openAppAction, this);
                if (objExecute2 != coroutineSingletons) {
                    str = currentTimeString;
                    str2 = packageNameByAppName;
                    actionResult = (ActionResult) objExecute2;
                }
            } else {
                Task task2 = this.$mdiTask;
                OpenAppAction openAppAction2 = new OpenAppAction(packageNameByAppName, null, null, new Integer(0), null, 22, null);
                this.L$0 = packageNameByAppName;
                this.L$1 = currentTimeString;
                this.label = 2;
                objExecute = task2.execute(openAppAction2, this);
                if (objExecute != coroutineSingletons) {
                    str = currentTimeString;
                    str2 = packageNameByAppName;
                    actionResult = (ActionResult) objExecute;
                }
            }
            return coroutineSingletons;
        }
        if (i == 1) {
            str = (String) this.L$1;
            str2 = (String) this.L$0;
            kotlin.b.b(obj);
            objExecute2 = obj;
            actionResult = (ActionResult) objExecute2;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$1;
            str2 = (String) this.L$0;
            kotlin.b.b(obj);
            objExecute = obj;
            actionResult = (ActionResult) objExecute;
        }
        String str4 = str;
        com.stepos.statsrpk.service.c.p("***************[", this.$taskId, "] MDI Task openApp***************", "ZyqlGuiAgentTask", true);
        ZyqlGuiAgentTask.Companion companion = ZyqlGuiAgentTask.INSTANCE;
        String currentTimeString2 = companion.getCurrentTimeString();
        if (!(actionResult instanceof ActionResult.Failure)) {
            if (!(actionResult instanceof ActionResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            z10 = true;
        }
        this.$guiTask.getGuiTaskRecord().addAction(new GuiActionRecord("openApp", z10 ? "success" : FlowType.FAILED, str4, currentTimeString2, null, B7.a.k("openApp: packageName=", str2), null, null, null, null, null, 2000, null));
        if (z10) {
            this.$guiTask.registerForegroundAppObserver$stepfun_release();
            this.$guiTask.registerAppDiedObserver$stepfun_release();
            return rVar;
        }
        GuiTaskRecord guiTaskRecord = this.$guiTask.getGuiTaskRecord();
        SessionState sessionState = SessionState.h;
        guiTaskRecord.setTaskState(sessionState);
        this.$guiTask.getGuiTaskRecord().setEndTime(companion.getCurrentTimeString());
        this.$guiTask.state = sessionState;
        GuitaskreportManager guitaskreportManager = GuitaskreportManager.INSTANCE;
        guitaskreportManager.updateReportState(this.$taskId, sessionState);
        guitaskreportManager.finishReport(this.$taskId);
        ZyqlGuiAgentTask.notifyProgressChanged$default(this.$guiTask, Actions.INSTANCE.getERROR(), null, null, B7.a.m("打开", this.$openAppName, "失败"), 6, null);
        com.stepos.statsrpk.service.c.p("[", this.$taskId, "] Open app failed, stopping task", "ZyqlGuiAgentTask", true);
        this.$guiTask.revokeOmniDisplayImeIfNeeded();
        SystemSdkBridgeKt.finishWithRedirectCleanup(this.$mdiTask, true);
        this.$guiTask.releaseDebugCompositor$stepfun_release();
        return rVar;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ZyqlGuiAgentTask$Companion$create$job$1$launchDeferred$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
