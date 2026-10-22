package com.stepos.ability.task.executor;

import C7.r;
import D7.w;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.GuiAgentConfig;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.WhitelistCheckResult;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.report.IReportManager;
import com.stepos.ability.report.event.AgentCacheTaskEvent;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1;
import com.stepos.ability.task.executor.e;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.ITaskRobotManger;
import com.stepos.taskrobot.common.bean.ActionInfo;
import com.stepos.taskrobot.common.bean.ExplainSnapshot;
import com.stepos.taskrobot.common.bean.TaskInfo;
import com.stepos.taskrobot.common.bean.TaskSnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.q0;

/* loaded from: classes3.dex */
public final class d extends a {
    public final IReportManager d;
    public final int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ITaskListener taskListener, IReportManager reportManager) {
        super(taskListener);
        k.f(taskListener, "taskListener");
        k.f(reportManager, "reportManager");
        this.d = reportManager;
        this.e = 1;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancel(Task task, H7.c cVar) throws RemoteException {
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.stopTask(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancelFullScreenGUI(Task task, H7.c cVar) throws RemoteException {
        P3.c.b("GuiTaskExecutor", "cancelFullScreenGUI:" + task);
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.hideFullScreenActivity(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final void cancelPackageConflict(String newTaskId, int i) throws RemoteException {
        k.f(newTaskId, "newTaskId");
        ITaskRobotManger iTaskRobotManger = e.f3313j;
        if (iTaskRobotManger != null) {
            iTaskRobotManger.cancelPackageConflict(newTaskId, i);
        }
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancelUserInput(String taskId, String requestId, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            k.f(taskId, "taskId");
            k.f(requestId, "requestId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.cancelUserInput(taskId, requestId);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("cancelUserInput failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final WhitelistCheckResult checkAppWhitelist(String appName) {
        Object objA;
        ITaskRobotManger iTaskRobotManger;
        k.f(appName, "appName");
        try {
            iTaskRobotManger = e.f3313j;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (iTaskRobotManger == null) {
            throw new IllegalStateException("TaskRobotService not connected");
        }
        com.stepos.taskrobot.common.bean.WhitelistCheckResult whitelistCheckResultCheckAppWhitelistV1 = iTaskRobotManger.checkAppWhitelistV1(appName);
        k.e(whitelistCheckResultCheckAppWhitelistV1, "checkAppWhitelistV1(...)");
        objA = new WhitelistCheckResult(whitelistCheckResultCheckAppWhitelistV1.getVerdict(), whitelistCheckResultCheckAppWhitelistV1.getResolvedAppName(), whitelistCheckResultCheckAppWhitelistV1.getManifestVersion());
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("checkAppWhitelist failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
            objA = new WhitelistCheckResult(2, "", -1);
        }
        return (WhitelistCheckResult) objA;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final void confirmPackageConflict(String newTaskId, int i) throws RemoteException {
        k.f(newTaskId, "newTaskId");
        ITaskRobotManger iTaskRobotManger = e.f3313j;
        if (iTaskRobotManger != null) {
            iTaskRobotManger.confirmPackageConflict(newTaskId, i);
        }
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object dismissFullScreenOverlay(String str, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.dismissFullScreenOverlay(str);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("dismissFullScreenOverlay failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object dismissVoiceInput(String taskId, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.dismissVoiceInput(taskId);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("dismissVoiceInput failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1] */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object execute(final InternalTask internalTask, int i, int i6, H7.c cVar) {
        String str;
        String string;
        C1718k c1718k;
        String modelName;
        String str2;
        String modelName2;
        final Task task = internalTask.getTask();
        final String taskId = task.getTaskId();
        final C1718k c1718k2 = new C1718k(1, U7.a.I(cVar));
        c1718k2.y();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        GuiAgentConfig guiAgentConfig = internalTask.getGuiAgentConfig();
        final String str3 = null;
        P3.c.b("GuiTaskExecutor", "GUI execute suface:" + (guiAgentConfig != null ? guiAgentConfig.getSurface() : null));
        Bundle bundle = task.getBundle();
        String string2 = bundle != null ? bundle.getString(Key.KEY_TRACE_ID) : null;
        P3.c.a("GuiTaskExecutor", "traceId = " + string2 + ", toolCallId = " + internalTask.getToolCallId());
        final q0 q0VarN = AbstractC1683A.n(this.b, null, new GuiTaskExecutor$execute$2$timeoutJob$1(taskId, null), 3);
        c1718k2.j(new J4.b(q0VarN, 10));
        this.d.reportTaskEvent(new AgentCacheTaskEvent(string2, task.getTaskId(), AgentCache.AGENT_CACHE_TASK_TYPE_GUI, false, null, AgentCache.AGENT_CACHE_MSG_TYPE_UP_LINK));
        Bundle bundle2 = task.getBundle();
        String string3 = bundle2 != null ? bundle2.getString(AgentServiceClient.KEY_CHAT_SESSION_ID) : null;
        if (string3 == null || string3.length() <= 0) {
            str = null;
        } else {
            str = null;
            str3 = string3;
        }
        Bundle bundle3 = task.getBundle();
        if (bundle3 == null || (string = bundle3.getString("session_id")) == null || string.length() <= 0) {
            string = str;
        }
        if (string3 == null) {
            string3 = "null";
        }
        String str4 = str3 == null ? "null" : str3;
        String str5 = string != null ? string : "null";
        boolean z10 = task.getBundle() == null;
        StringBuilder sbW = B7.a.w("[RELAUNCH] GuiTaskExecutor.execute: extract sessions, taskId=", taskId, ", rawChatSessionId='", string3, "', chatSessionId='");
        androidx.constraintlayout.core.dsl.a.A(sbW, str4, "', subSessionId='", str5, "', bundleNull=");
        sbW.append(z10);
        P3.c.b("GuiTaskExecutor", sbW.toString());
        final Bundle bundle4 = new Bundle();
        if (string2 != null && string2.length() != 0) {
            bundle4.putString(Key.KEY_TRACE_ID, string2);
            bundle4.putString(Key.KEY_TOOL_CALL_ID, internalTask.getToolCallId());
        }
        if (i6 > 0) {
            bundle4.putInt("calling_pid", i6);
        }
        if (string != null && string.length() != 0) {
            bundle4.putString(Key.KEY_SUB_SESSION_ID, string);
        }
        final String str6 = string2;
        final ?? r02 = new ITaskProgressCallback.Stub() { // from class: com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1
            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onAction(TaskInfo taskInfo, ActionInfo actionInfo) {
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onExplainUpdated(String taskId2, ExplainSnapshot snapshot) {
                if (taskId2 == null || snapshot == null) {
                    return;
                }
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1(dVar, taskId2, snapshot, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onInfoDismissed(String taskId2, String requestId, String reason, String chatSessionId) {
                if (taskId2 == null || requestId == null) {
                    return;
                }
                StringBuilder sbW2 = B7.a.w("onInfoDismissed: taskId=", taskId2, ", requestId=", requestId, ", reason=");
                sbW2.append(reason);
                sbW2.append(", chatSessionId=");
                sbW2.append(chatSessionId);
                P3.c.b("GuiTaskExecutor", sbW2.toString());
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onInfoDismissed$1(dVar, taskId2, requestId, reason, chatSessionId, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onInfoRequested(String taskId2, String taskName, String requestId, String inputType, String message, String payloadJson, long timeoutMs, String chatSessionId) {
                if (taskId2 == null || requestId == null) {
                    return;
                }
                StringBuilder sbW2 = B7.a.w("onInfoRequested: taskId=", taskId2, ", requestId=", requestId, ", type=");
                sbW2.append(inputType);
                sbW2.append(", chatSessionId=");
                sbW2.append(chatSessionId);
                P3.c.b("GuiTaskExecutor", sbW2.toString());
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onInfoRequested$1(dVar, taskId2, requestId, inputType, message, payloadJson, timeoutMs, chatSessionId, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
                StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(conflictKind, "onPackageConflict: kind=", " new=", newTaskId, ", running=");
                sbK.append(runningTaskId);
                sbK.append(", pkg=");
                sbK.append(packageName);
                String msg = sbK.toString();
                k.f(msg, "msg");
                P3.c.f1086a.invoke(5, "Ability_".concat("GuiTaskExecutor"), msg, null);
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onPackageConflict$1(dVar, conflictKind, newTaskId, newTaskName, runningTaskId, packageName, hint, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onRequestRelaunch(String taskId2, String chatSessionId, String reason) {
                if (taskId2 == null) {
                    return;
                }
                StringBuilder sbW2 = B7.a.w("[RELAUNCH] GuiTaskExecutor.onRequestRelaunch: taskId=", taskId2, ", sessionId=", chatSessionId, ", reason=");
                sbW2.append(reason);
                P3.c.b("GuiTaskExecutor", sbW2.toString());
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onRequestRelaunch$1(dVar, taskId2, chatSessionId, reason, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskAction(String taskId2, String taskName, String action, String bitmapId, Bitmap bitmap, String message) {
                k.f(taskId2, "taskId");
                k.f(taskName, "taskName");
                k.f(action, "action");
                StringBuilder sb = new StringBuilder("onTaskAction action:");
                androidx.constraintlayout.core.dsl.a.A(sb, action, " bitmapId:", bitmapId, ", bitmap:");
                sb.append(bitmap);
                sb.append(" message:");
                sb.append(message);
                P3.c.b("GuiTaskExecutor", sb.toString());
                d dVar = this.this$0;
                AbstractC1683A.n(dVar.b, null, new GuiTaskExecutor$execute$2$progressCallback$1$onTaskAction$1(action, taskId2, taskName, bitmapId, bitmap, message, dVar, task, str6, q0VarN, internalTask, atomicBoolean, c1718k2, null), 3);
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskActionPair(String taskId2, String taskName, String action, String bitmapId, Bitmap bitmap, String url) {
                k.f(taskId2, "taskId");
                k.f(taskName, "taskName");
                k.f(action, "action");
            }

            @Override // com.stepos.taskrobot.common.ITaskProgressCallback
            public void onTaskStatusChange(TaskInfo taskInfo) {
            }
        };
        int taskType = this.e;
        if (str3 == null || str3.length() == 0) {
            c1718k = c1718k2;
            P3.c.b("GuiTaskExecutor", "[RELAUNCH] GuiTaskExecutor.execute: NO chat_session_id in bundle → startTaskV1 (old path, preCheckGuiTask gets null session unless service-side fallback from SystemSdkBridge pending), taskId=" + taskId);
            GuiAgentConfig guiAgentConfig2 = internalTask.getGuiAgentConfig();
            if (guiAgentConfig2 == null || (modelName = guiAgentConfig2.getModelName()) == null) {
                modelName = "";
            }
            GuiAgentConfig guiAgentConfig3 = internalTask.getGuiAgentConfig();
            if (guiAgentConfig3 != null) {
                taskType = guiAgentConfig3.getTaskType();
            }
            String params = task.getParams();
            str2 = params != null ? params : "";
            GuiAgentConfig guiAgentConfig4 = internalTask.getGuiAgentConfig();
            final Surface surface = guiAgentConfig4 != null ? guiAgentConfig4.getSurface() : null;
            GuiAgentConfig guiAgentConfig5 = internalTask.getGuiAgentConfig();
            int startMode = guiAgentConfig5 != null ? guiAgentConfig5.getStartMode() : 0;
            k.f(taskId, "taskId");
            Log.i("TaskRobotManager", "[RELAUNCH] startTaskV1 (SDK wrapper, V1 old path): taskId=" + taskId + " (no sessionId param)");
            StringBuilder sb = new StringBuilder("modelId: ");
            sb.append(modelName);
            sb.append("; taskId: ");
            androidx.compose.foundation.b.B(sb, taskId, "; taskType: ", taskType, "; paramsJson: ");
            sb.append(str2);
            sb.append("; startMode: ");
            sb.append(startMode);
            Log.d("TaskRobotManager", sb.toString());
            Application application = e.l;
            k.c(application);
            final int i10 = taskType;
            final String str7 = modelName;
            final int i11 = startMode;
            final String str8 = str2;
            e.v(application, new S7.k() { // from class: n6.b
                @Override // S7.k
                public final Object invoke(Object obj) throws RemoteException {
                    String str9 = str7;
                    String str10 = taskId;
                    int i12 = i10;
                    String str11 = str8;
                    Surface surface2 = surface;
                    int i13 = i11;
                    Bundle bundle5 = bundle4;
                    GuiTaskExecutor$execute$2$progressCallback$1 guiTaskExecutor$execute$2$progressCallback$1 = r02;
                    ((Boolean) obj).getClass();
                    ITaskRobotManger iTaskRobotManger = e.f3313j;
                    if (iTaskRobotManger != null) {
                        iTaskRobotManger.startTaskV1(str9, str10, i12, str11, surface2, i13, bundle5, guiTaskExecutor$execute$2$progressCallback$1);
                    }
                    return r.f317a;
                }
            });
        } else {
            c1718k = c1718k2;
            P3.c.a("GuiTaskExecutor", "execute: chatSessionId=" + str3 + " → startTaskV1WithSession");
            StringBuilder sb2 = new StringBuilder("[RELAUNCH] GuiTaskExecutor.execute: has sessionId → startTaskV1WithSession, taskId=");
            sb2.append(taskId);
            P3.c.b("GuiTaskExecutor", sb2.toString());
            GuiAgentConfig guiAgentConfig6 = internalTask.getGuiAgentConfig();
            if (guiAgentConfig6 == null || (modelName2 = guiAgentConfig6.getModelName()) == null) {
                modelName2 = "";
            }
            GuiAgentConfig guiAgentConfig7 = internalTask.getGuiAgentConfig();
            if (guiAgentConfig7 != null) {
                taskType = guiAgentConfig7.getTaskType();
            }
            String params2 = task.getParams();
            str2 = params2 != null ? params2 : "";
            GuiAgentConfig guiAgentConfig8 = internalTask.getGuiAgentConfig();
            Surface surface2 = guiAgentConfig8 != null ? guiAgentConfig8.getSurface() : null;
            GuiAgentConfig guiAgentConfig9 = internalTask.getGuiAgentConfig();
            int startMode2 = guiAgentConfig9 != null ? guiAgentConfig9.getStartMode() : 0;
            k.f(taskId, "taskId");
            boolean z11 = str3.length() == 0;
            final Surface surface3 = surface2;
            StringBuilder sbW2 = B7.a.w("[RELAUNCH] startTaskV1WithSession (SDK wrapper): taskId=", taskId, ", sessionId='", str3, "', hasSession=");
            sbW2.append(!z11);
            Log.i("TaskRobotManager", sbW2.toString());
            Log.d("TaskRobotManager", "modelId: " + modelName2 + "; taskId: " + taskId + "; taskType: " + taskType + "; paramsJson: " + str2 + "; startMode: " + startMode2 + "; sessionId: " + str3);
            Application application2 = e.l;
            k.c(application2);
            final String str9 = modelName2;
            final int i12 = taskType;
            final String str10 = str2;
            final int i13 = startMode2;
            e.v(application2, new S7.k() { // from class: n6.a
                @Override // S7.k
                public final Object invoke(Object obj) throws RemoteException {
                    String str11 = str9;
                    String str12 = taskId;
                    int i14 = i12;
                    String str13 = str10;
                    Surface surface4 = surface3;
                    int i15 = i13;
                    Bundle bundle5 = bundle4;
                    String str14 = str3;
                    GuiTaskExecutor$execute$2$progressCallback$1 guiTaskExecutor$execute$2$progressCallback$1 = r02;
                    ((Boolean) obj).getClass();
                    ITaskRobotManger iTaskRobotManger = e.f3313j;
                    if (iTaskRobotManger != null) {
                        iTaskRobotManger.startTaskV1WithSession(str11, str12, i14, str13, surface4, i15, bundle5, str14, guiTaskExecutor$execute$2$progressCallback$1);
                    }
                    return r.f317a;
                }
            });
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object fullScreenGUI(Task task, H7.c cVar) throws RemoteException {
        P3.c.b("GuiTaskExecutor", "fullScreenGUI:" + task);
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.showFullScreenActivity(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final String getForegroundTaskId() {
        Object objA;
        Object obj = "";
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            objA = iTaskRobotManger != null ? iTaskRobotManger.getForegroundTaskId() : null;
            if (objA == null) {
                objA = "";
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            obj = objA;
        } else {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("getForegroundTaskId failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return (String) obj;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final String getForegroundTaskSessionId() {
        Object objA;
        Object obj = "";
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            objA = iTaskRobotManger != null ? iTaskRobotManger.getForegroundTaskSessionId() : null;
            if (objA == null) {
                objA = "";
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            obj = objA;
        } else {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("getForegroundTaskSessionId failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return (String) obj;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final String getLastActiveTaskSessionId() {
        Object objA;
        Object obj = "";
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            objA = iTaskRobotManger != null ? iTaskRobotManger.getLastActiveTaskSessionId() : null;
            if (objA == null) {
                objA = "";
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            obj = objA;
        } else {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("getLastActiveTaskSessionId failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return (String) obj;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        Object objA;
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            com.stepos.taskrobot.common.bean.MainDisplayTopAppHistory mainDisplayTopAppHistory = iTaskRobotManger != null ? iTaskRobotManger.getMainDisplayTopAppHistory() : null;
            objA = mainDisplayTopAppHistory != null ? new MainDisplayTopAppHistory(mainDisplayTopAppHistory.getWatching(), mainDisplayTopAppHistory.getChanged(), mainDisplayTopAppHistory.getBaselinePackage(), mainDisplayTopAppHistory.getCurrentPackage(), mainDisplayTopAppHistory.getBaselineAt(), mainDisplayTopAppHistory.getLastChangeAt(), mainDisplayTopAppHistory.getChatSessionId()) : new MainDisplayTopAppHistory(false, false, "", "", 0L, 0L, "");
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("getMainDisplayTopAppHistory failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
            objA = new MainDisplayTopAppHistory(false, false, "", "", 0L, 0L, "");
        }
        return (MainDisplayTopAppHistory) objA;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final AppOccupationResult isAppOccupied(String appName) {
        Object objA;
        Object objA2;
        com.stepos.taskrobot.common.bean.AppOccupationResult appOccupationResult;
        k.f(appName, "appName");
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger == null) {
                appOccupationResult = new com.stepos.taskrobot.common.bean.AppOccupationResult(false, "", "");
            } else {
                try {
                    objA2 = iTaskRobotManger.isAppOccupiedV1(appName);
                } catch (Throwable th) {
                    objA2 = kotlin.b.a(th);
                }
                if (Result.a(objA2) != null) {
                    objA2 = new com.stepos.taskrobot.common.bean.AppOccupationResult(false, "", "");
                }
                appOccupationResult = (com.stepos.taskrobot.common.bean.AppOccupationResult) objA2;
            }
            objA = new AppOccupationResult(appOccupationResult.getOccupied(), appOccupationResult.getOccupierTaskId(), appOccupationResult.getPackageName());
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("isAppOccupied failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
            objA = new AppOccupationResult(false, "", "");
        }
        return (AppOccupationResult) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final List listActiveTasks() {
        Object objA;
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            List<TaskSnapshot> listListActiveTasks = iTaskRobotManger != null ? iTaskRobotManger.listActiveTasks() : null;
            if (listListActiveTasks == null) {
                listListActiveTasks = EmptyList.f4893a;
            }
            List<TaskSnapshot> list = listListActiveTasks;
            objA = new ArrayList(w.c0(list, 10));
            for (TaskSnapshot taskSnapshot : list) {
                objA.add(new com.stepos.ability.bean.TaskSnapshot(taskSnapshot.getTaskId(), taskSnapshot.getPackageName(), taskSnapshot.getAppName(), taskSnapshot.getState(), taskSnapshot.getForeground()));
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        EmptyList emptyList = objA;
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("listActiveTasks failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
            emptyList = EmptyList.f4893a;
        }
        return emptyList;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object pause(Task task, H7.c cVar) throws RemoteException {
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.pauseTask(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object resume(Task task, H7.c cVar) throws RemoteException {
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.resumeTask(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object resumeFullScreenOverlay(String str, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.resumeFullScreenOverlay(str);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("resumeFullScreenOverlay failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object showFullScreenGuiV2(String taskId, Bundle bundle, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.showFullScreenActivityV2(taskId, bundle);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("showFullScreenGuiV2 failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object submitUserInput(String taskId, String requestId, String content, H7.c cVar) {
        Object objA;
        r rVar = r.f317a;
        try {
            k.f(taskId, "taskId");
            k.f(requestId, "requestId");
            k.f(content, "content");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.submitUserInput(taskId, requestId, content);
            }
            objA = rVar;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("submitUserInput failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
        return rVar;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object takeOver(Task task, H7.c cVar) throws RemoteException {
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.takeoverTask(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.task.executor.a, com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object unTakeOver(Task task, H7.c cVar) throws RemoteException {
        if (task != null) {
            String taskId = task.getTaskId();
            k.f(taskId, "taskId");
            ITaskRobotManger iTaskRobotManger = e.f3313j;
            if (iTaskRobotManger != null) {
                iTaskRobotManger.recoverFromTakeover(taskId);
            }
        }
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object updateTask(String taskId, int i, Bundle bundle, H7.c cVar) {
        Object objA;
        Object obj = "";
        P3.b bVar = P3.c.f1086a;
        P3.c.b("GuiTaskExecutor", "updateTask:" + taskId);
        bundle.setClassLoader(GuiAgentConfig.class.getClassLoader());
        GuiAgentConfig guiAgentConfig = (GuiAgentConfig) bundle.getParcelable(Key.KEY_GUI_AGENT_CONFIG);
        if (guiAgentConfig != null) {
            P3.c.a("GuiTaskExecutor", "updateTask: taskId=" + taskId + ", surface=" + guiAgentConfig.getSurface());
            try {
                ITaskRobotManger iTaskRobotManger = e.f3313j;
                objA = iTaskRobotManger != null ? iTaskRobotManger.getForegroundTaskId() : null;
                if (objA == null) {
                    objA = "";
                }
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA == null) {
                obj = objA;
            } else {
                bVar.invoke(5, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("updateTask: getForegroundTaskId failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
            }
            if (((String) obj).equals(taskId)) {
                String msg = "updateTask: skip setOutputSurface (fullscreen owns) taskId=" + taskId + ", incomingSurface=" + guiAgentConfig.getSurface() + ", callerThread=" + Thread.currentThread().getName();
                k.f(msg, "msg");
                bVar.invoke(5, "Ability_".concat("GuiTaskExecutor"), msg, null);
            } else {
                try {
                    Surface surface = guiAgentConfig.getSurface();
                    k.f(taskId, "taskId");
                    ITaskRobotManger iTaskRobotManger2 = e.f3313j;
                    if (iTaskRobotManger2 != null) {
                        iTaskRobotManger2.setOutputSurface(taskId, surface);
                    }
                } catch (Exception e) {
                    bVar.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("updateTask failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
                }
            }
        }
        String string = bundle.getString(AgentServiceClient.KEY_CHAT_SESSION_ID);
        if (string != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    String msg2 = "updateTask: taskId=" + taskId + ", chatSessionId=" + string;
                    k.f(msg2, "msg");
                    bVar.invoke(3, "Ability_".concat("GuiTaskExecutor"), msg2, null);
                    k.f(taskId, "taskId");
                    ITaskRobotManger iTaskRobotManger3 = e.f3313j;
                    if (iTaskRobotManger3 != null) {
                        iTaskRobotManger3.setChatSessionId(taskId, string);
                    }
                } catch (Exception e6) {
                    bVar.invoke(6, "Ability_".concat("GuiTaskExecutor"), androidx.constraintlayout.core.dsl.a.h("updateTask setChatSessionId failed: ", e6.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e6);
                }
            }
        }
        return r.f317a;
    }
}
