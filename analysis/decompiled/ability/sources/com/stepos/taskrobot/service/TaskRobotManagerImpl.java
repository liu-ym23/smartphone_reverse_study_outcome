package com.stepos.taskrobot.service;

import A4.e;
import C7.r;
import android.app.Application;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.taskrobot.appwhitelist.api.AppWhitelistService;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.ITaskRobotManger;
import com.stepos.taskrobot.common.bean.AppOccupationResult;
import com.stepos.taskrobot.common.bean.MainDisplayTopAppHistory;
import com.stepos.taskrobot.common.bean.TaskSnapshot;
import com.stepos.taskrobot.common.bean.WhitelistCheckResult;
import com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge;
import com.stepos.taskrobot.llmapi.stepfun.j;
import com.stepos.taskrobot.service.TaskRobotManagerImpl;
import f6.AbstractC1436a;
import j9.m;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.a;
import kotlinx.coroutines.c;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1725r;
import m9.c0;
import o6.i;
import p6.p;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 v2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006JM\u0010\u0013\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J]\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJW\u0010\u001e\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b#\u0010!J\u001f\u0010$\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b&\u0010%J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010!J\u000f\u0010-\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020/2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b2\u00101J\u001f\u00104\u001a\u00020/2\u0006\u0010\t\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b6\u0010!J\u0017\u00107\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010!J\u0017\u00108\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010!J\u0017\u00109\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b9\u0010!J\u0017\u0010:\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b:\u0010!J\u0017\u0010;\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b;\u0010!J!\u0010<\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b<\u0010=J#\u0010?\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010+J\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020B0'H\u0016¢\u0006\u0004\bC\u0010)J\u0019\u0010D\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bD\u0010!J-\u0010G\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010E\u001a\u0004\u0018\u00010\u00072\b\u0010F\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bG\u0010HJ#\u0010I\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bI\u0010@J#\u0010K\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010J\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020N2\u0006\u0010M\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010PJa\u0010R\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010Q\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010+J\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010+J\u000f\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020Y2\b\u0010M\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bZ\u0010[J!\u0010^\u001a\u00020\u00122\b\u0010\\\u001a\u0004\u0018\u00010\u00072\u0006\u0010]\u001a\u00020\rH\u0016¢\u0006\u0004\b^\u0010_J!\u0010`\u001a\u00020\u00122\b\u0010\\\u001a\u0004\u0018\u00010\u00072\u0006\u0010]\u001a\u00020\rH\u0016¢\u0006\u0004\b`\u0010_J\u0019\u0010a\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\ba\u0010!J\u0019\u0010b\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bb\u0010!J!\u0010c\u001a\u00020/2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\bc\u0010dJ#\u0010f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\bf\u0010gR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0005\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010\u0006R\u0017\u0010m\u001a\u00020l8\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u0017\u0010r\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010u¨\u0006x"}, d2 = {"Lcom/stepos/taskrobot/service/TaskRobotManagerImpl;", "Lcom/stepos/taskrobot/common/ITaskRobotManger$Stub;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "", "modelId", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "paramsJson", "Landroid/view/Surface;", "surface", "", "taskType", "startMode", "Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "progressCallback", "LC7/r;", "startTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;IILcom/stepos/taskrobot/common/ITaskProgressCallback;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "width", "height", "openAppname", "callback", "startCozeTask", "(ILjava/lang/String;Ljava/lang/String;Landroid/view/Surface;IIILjava/lang/String;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)I", "Landroid/os/Bundle;", "bundle", "startTaskV1", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/view/Surface;ILandroid/os/Bundle;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)V", "stopTask", "(Ljava/lang/String;)V", "pauseTask", "resumeTask", "registerProgressCallback", "(Ljava/lang/String;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)V", "unregisterProgressCallback", "", "getModelOptions", "()Ljava/util/List;", "getCurrentModelId", "()Ljava/lang/String;", "addModel", "removeAllCustomModels", "()I", "", "deleteCustomModelById", "(Ljava/lang/String;)Z", "isCustomModel", "reason", "cancelTaskById", "(Ljava/lang/String;Ljava/lang/String;)Z", "takeoverTask", "recoverFromTakeover", "switchToMainDisplay", "switchToVirtualDisplay", "showFullScreenActivity", "hideFullScreenActivity", "setOutputSurface", "(Ljava/lang/String;Landroid/view/Surface;)V", "chatSessionId", "setChatSessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "getForegroundTaskId", "Lcom/stepos/taskrobot/common/bean/TaskSnapshot;", "listActiveTasks", "dismissVoiceInput", "requestId", "content", "submitUserInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cancelUserInput", "options", "showFullScreenActivityV2", "(Ljava/lang/String;Landroid/os/Bundle;)V", "appName", "Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "checkAppWhitelistV1", "(Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/WhitelistCheckResult;", "sessionId", "startTaskV1WithSession", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/view/Surface;ILandroid/os/Bundle;Ljava/lang/String;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)V", "getForegroundTaskSessionId", "getLastActiveTaskSessionId", "Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", "getMainDisplayTopAppHistory", "()Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", "Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "isAppOccupiedV1", "(Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "newTaskId", "conflictKind", "confirmPackageConflict", "(Ljava/lang/String;I)V", "cancelPackageConflict", "dismissFullScreenOverlay", "resumeFullScreenOverlay", "rejectIfDisabled", "(Ljava/lang/String;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)Z", "explicit", "resolveChatSessionId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "Landroid/os/Handler;", "backgroundHandler", "Landroid/os/Handler;", "getBackgroundHandler", "()Landroid/os/Handler;", "Lm9/r;", "taskJob", "Lm9/r;", "getTaskJob", "()Lm9/r;", "Companion", "o6/i", "service_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskRobotManagerImpl extends ITaskRobotManger.Stub {
    public static final i Companion = new i();
    public static final String TAG = "TaskRobotManagerImpl";
    private final Handler backgroundHandler;
    public Context context;
    private final InterfaceC1725r taskJob;

    public TaskRobotManagerImpl() {
        this.backgroundHandler = new Handler(Looper.getMainLooper());
        this.taskJob = a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelPackageConflict$lambda$0(String str, int i) throws RemoteException {
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        if (str == null) {
            str = "";
        }
        systemSdkBridge.cancelPackageConflict(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelUserInput$lambda$0(String str, String str2) {
        SystemSdkBridge.cancelUserInput$default(SystemSdkBridge.INSTANCE, str, str2, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmPackageConflict$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str, int i) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$confirmPackageConflict$1$1(str, i, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissFullScreenOverlay$lambda$0(String str) {
        SystemSdkBridge.INSTANCE.dismissFullScreenOverlay(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissVoiceInput$lambda$0(String str) {
        SystemSdkBridge.INSTANCE.dismissVoiceInput(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideFullScreenActivity$lambda$0(String str) {
        SystemSdkBridge.INSTANCE.hideFullScreenActivity(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pauseTask$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$pauseTask$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverFromTakeover$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$recoverFromTakeover$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerProgressCallback$lambda$0(String str, int i, ITaskProgressCallback iTaskProgressCallback) {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "registerProgressCallback taskId: ", str, " callerPid: ", " callback: ");
        sbT.append(iTaskProgressCallback);
        AbstractC1436a.a(TAG, sbT.toString(), true);
        SystemSdkBridge.INSTANCE.registerProgressCallback(str, i, iTaskProgressCallback);
    }

    private final boolean rejectIfDisabled(String taskId, ITaskProgressCallback progressCallback) {
        AbstractC1436a.e(TAG, "[TaskRobot] feature switch OFF, reject startTask taskId=" + taskId, true);
        if (progressCallback != null) {
            try {
                progressCallback.onTaskAction(taskId, "", "error", null, null, "GUI 自动化功能暂未开放");
            } catch (Throwable th) {
                b.a(th);
            }
        }
        return true;
    }

    private final String resolveChatSessionId(String taskId, String explicit) {
        if (explicit != null && explicit.length() != 0) {
            return explicit;
        }
        String strPeekPendingChatSessionId = SystemSdkBridge.INSTANCE.peekPendingChatSessionId(taskId);
        if (strPeekPendingChatSessionId != null) {
            AbstractC1436a.d(TAG, B7.a.n("[RELAUNCH] resolveChatSessionId: explicit empty, fallback to pending='", strPeekPendingChatSessionId, "', taskId=", taskId), true);
        }
        return strPeekPendingChatSessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resumeFullScreenOverlay$lambda$0(String str) {
        SystemSdkBridge.INSTANCE.resumeFullScreenOverlay(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resumeTask$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$resumeTask$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChatSessionId$lambda$0(String str, String str2) {
        SystemSdkBridge.INSTANCE.setChatSessionId(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOutputSurface$lambda$0(String str, Surface surface) throws RemoteException {
        SystemSdkBridge.INSTANCE.setOutputSurface(str, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFullScreenActivity$lambda$0(String str) {
        SystemSdkBridge.showFullScreenActivity$default(SystemSdkBridge.INSTANCE, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFullScreenActivityV2$lambda$0(String str, Bundle bundle) {
        SystemSdkBridge.INSTANCE.showFullScreenActivityV2(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTask$lambda$0(String str, String str2, String str3, Surface surface, int i, int i6, ITaskProgressCallback iTaskProgressCallback, int i10) throws RemoteException {
        SystemSdkBridge.startTask$default(SystemSdkBridge.INSTANCE, str, str2, str3, surface, i, i6, null, iTaskProgressCallback, null, null, i10, 768, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r startTaskV1$lambda$1(final String str, TaskRobotManagerImpl taskRobotManagerImpl, final String str2, final Surface surface, final int i, final int i6, final Bundle bundle, final ITaskProgressCallback iTaskProgressCallback, final String str3, final int i10, final String effectiveJson) {
        k.f(effectiveJson, "effectiveJson");
        AbstractC1436a.d(TAG, "[LOOP-DEBUG] startTaskV1.submit: posting SystemSdkBridge.startTask, taskId=" + str, true);
        taskRobotManagerImpl.backgroundHandler.post(new Runnable() { // from class: o6.h
            @Override // java.lang.Runnable
            public final void run() throws RemoteException {
                TaskRobotManagerImpl.startTaskV1$lambda$1$0(str2, str, effectiveJson, surface, i, i6, bundle, iTaskProgressCallback, str3, i10);
            }
        });
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTaskV1$lambda$1$0(String str, String str2, String str3, Surface surface, int i, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback, String str4, int i10) throws RemoteException {
        SystemSdkBridge.startTask$default(SystemSdkBridge.INSTANCE, str, str2, str3, surface, i, i6, bundle, iTaskProgressCallback, null, str4, i10, 256, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r startTaskV1WithSession$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, final String str, final String str2, final Surface surface, final int i, final int i6, final Bundle bundle, final ITaskProgressCallback iTaskProgressCallback, final String str3, final String str4, final String effectiveJson) {
        k.f(effectiveJson, "effectiveJson");
        taskRobotManagerImpl.backgroundHandler.post(new Runnable() { // from class: o6.f
            @Override // java.lang.Runnable
            public final void run() throws RemoteException {
                TaskRobotManagerImpl.startTaskV1WithSession$lambda$0$0(str, str2, effectiveJson, surface, i, i6, bundle, iTaskProgressCallback, str3, str4);
            }
        });
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTaskV1WithSession$lambda$0$0(String str, String str2, String str3, Surface surface, int i, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback, String str4, String str5) throws RemoteException {
        SystemSdkBridge.startTask$default(SystemSdkBridge.INSTANCE, str, str2, str3, surface, i, i6, bundle, iTaskProgressCallback, (str4 == null || str4.length() <= 0) ? null : str4, str5, 0, 1024, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitUserInput$lambda$0(String str, String str2, String str3) {
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        if (str3 == null) {
            str3 = "";
        }
        systemSdkBridge.submitUserInput(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchToMainDisplay$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$switchToMainDisplay$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchToVirtualDisplay$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$switchToVirtualDisplay$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takeoverTask$lambda$0(TaskRobotManagerImpl taskRobotManagerImpl, String str) {
        c0 c0Var = taskRobotManagerImpl.taskJob;
        d dVar = AbstractC1691I.f5315a;
        c cVar = (c) c0Var;
        cVar.getClass();
        AbstractC1683A.n(AbstractC1683A.b(l.H(cVar, dVar)), null, new TaskRobotManagerImpl$takeoverTask$1$1(str, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterProgressCallback$lambda$0(String str, int i, ITaskProgressCallback iTaskProgressCallback) {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "unregisterProgressCallback taskId: ", str, " callerPid: ", " callback: ");
        sbT.append(iTaskProgressCallback);
        AbstractC1436a.a(TAG, sbT.toString(), true);
        SystemSdkBridge.INSTANCE.unregisterProgressCallback(str, i);
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void addModel(String modelId) {
        k.f(modelId, "modelId");
        SystemSdkBridge.addModel$default(SystemSdkBridge.INSTANCE, modelId, null, 2, null);
        AbstractC1436a.a(TAG, "addModel: " + r.f317a, true);
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void cancelPackageConflict(String newTaskId, int conflictKind) {
        AbstractC1436a.a(TAG, "cancelPackageConflict: " + newTaskId + " kind=" + conflictKind, true);
        this.backgroundHandler.post(new androidx.core.content.res.a(newTaskId, conflictKind, 2));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public boolean cancelTaskById(String taskId, String reason) {
        k.f(taskId, "taskId");
        k.f(reason, "reason");
        boolean zCancelTask = SystemSdkBridge.INSTANCE.cancelTask(taskId, reason);
        AbstractC1436a.a(TAG, taskId + " " + reason + " cancelTaskById: " + zCancelTask, true);
        return zCancelTask;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void cancelUserInput(String taskId, String requestId) {
        if (taskId == null || m.s0(taskId) || requestId == null || m.s0(requestId)) {
            return;
        }
        this.backgroundHandler.post(new o6.a(0, taskId, requestId));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public WhitelistCheckResult checkAppWhitelistV1(String appName) {
        k.f(appName, "appName");
        AbstractC1436a.a(TAG, "checkAppWhitelistV1: ".concat(appName), true);
        return AppWhitelistService.INSTANCE.check(appName);
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void confirmPackageConflict(String newTaskId, int conflictKind) {
        AbstractC1436a.a(TAG, "confirmPackageConflict: " + newTaskId + " kind=" + conflictKind, true);
        this.backgroundHandler.post(new android.view.i(this, newTaskId, conflictKind));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public boolean deleteCustomModelById(String modelId) {
        k.f(modelId, "modelId");
        boolean zDeleteCustomModelById = SystemSdkBridge.INSTANCE.deleteCustomModelById(modelId);
        AbstractC1436a.a(TAG, "deleteCustomModelById: " + zDeleteCustomModelById, true);
        return zDeleteCustomModelById;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void dismissFullScreenOverlay(String taskId) {
        AbstractC1436a.a(TAG, "dismissFullScreenOverlay: " + taskId, true);
        this.backgroundHandler.post(new j(taskId, 3));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void dismissVoiceInput(String taskId) {
        if (taskId == null || m.s0(taskId)) {
            return;
        }
        this.backgroundHandler.post(new j(taskId, 2));
    }

    public final Handler getBackgroundHandler() {
        return this.backgroundHandler;
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        k.n("context");
        throw null;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public String getCurrentModelId() {
        String currentModelId = SystemSdkBridge.INSTANCE.getCurrentModelId();
        AbstractC1436a.a(TAG, "getCurrentModelId: " + currentModelId, true);
        return currentModelId;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public String getForegroundTaskId() {
        return SystemSdkBridge.INSTANCE.getForegroundTaskId();
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public String getForegroundTaskSessionId() {
        return SystemSdkBridge.INSTANCE.getForegroundTaskSessionId();
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public String getLastActiveTaskSessionId() {
        return SystemSdkBridge.INSTANCE.getLastActiveTaskSessionId();
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        return SystemSdkBridge.INSTANCE.getMainDisplayTopAppHistory();
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public List<String> getModelOptions() {
        List<String> modelOptions = SystemSdkBridge.INSTANCE.getModelOptions();
        AbstractC1436a.a(TAG, "options: " + modelOptions, true);
        return modelOptions;
    }

    public final InterfaceC1725r getTaskJob() {
        return this.taskJob;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void hideFullScreenActivity(String taskId) {
        k.f(taskId, "taskId");
        AbstractC1436a.a(TAG, "hideFullScreenActivity: ".concat(taskId), true);
        this.backgroundHandler.post(new j(taskId, 5));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public AppOccupationResult isAppOccupiedV1(String appName) {
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        if (appName == null) {
            appName = "";
        }
        return systemSdkBridge.queryAppOccupation(appName);
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public boolean isCustomModel(String modelId) {
        k.f(modelId, "modelId");
        boolean zIsCustomModel = SystemSdkBridge.INSTANCE.isCustomModel(modelId);
        AbstractC1436a.a(TAG, modelId + "isCustomModel: " + zIsCustomModel, true);
        return zIsCustomModel;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public List<TaskSnapshot> listActiveTasks() {
        return SystemSdkBridge.INSTANCE.listActiveTasks();
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void pauseTask(String taskId) {
        AbstractC1436a.a(TAG, "pauseTask: " + taskId, true);
        this.backgroundHandler.post(new o6.c(this, taskId, 0));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void recoverFromTakeover(String taskId) {
        k.f(taskId, "taskId");
        this.backgroundHandler.post(new o6.c(this, taskId, 4));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void registerProgressCallback(String taskId, ITaskProgressCallback callback) {
        k.f(taskId, "taskId");
        k.f(callback, "callback");
        this.backgroundHandler.post(new o6.d(taskId, Binder.getCallingPid(), callback, 1));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public int removeAllCustomModels() {
        int iRemoveAllCustomModels = SystemSdkBridge.INSTANCE.removeAllCustomModels();
        AbstractC1436a.a(TAG, "removeAllCustomModels: " + iRemoveAllCustomModels, true);
        return iRemoveAllCustomModels;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void resumeFullScreenOverlay(String taskId) {
        AbstractC1436a.a(TAG, "resumeFullScreenOverlay: " + taskId, true);
        this.backgroundHandler.post(new j(taskId, 1));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void resumeTask(String taskId) {
        AbstractC1436a.a(TAG, "resumeTask: " + taskId, true);
        this.backgroundHandler.post(new o6.c(this, taskId, 5));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void setChatSessionId(String taskId, String chatSessionId) {
        AbstractC1436a.a(TAG, B7.a.n("setChatSessionId: taskId=", taskId, ", chatSessionId=", chatSessionId), true);
        if (taskId == null || taskId.length() == 0) {
            return;
        }
        this.backgroundHandler.post(new o6.a(1, taskId, chatSessionId));
    }

    public final void setContext(Context context) {
        k.f(context, "<set-?>");
        this.context = context;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void setOutputSurface(String taskId, Surface surface) {
        k.f(taskId, "taskId");
        AbstractC1436a.a(TAG, "setOutputSurface: taskId=" + taskId + ", surface=" + surface, true);
        this.backgroundHandler.post(new I4.l(25, taskId, surface));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void showFullScreenActivity(String taskId) {
        k.f(taskId, "taskId");
        AbstractC1436a.a(TAG, "showFullScreenActivity: ".concat(taskId), true);
        this.backgroundHandler.post(new j(taskId, 4));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void showFullScreenActivityV2(String taskId, Bundle options) {
        if (taskId == null || m.s0(taskId)) {
            return;
        }
        this.backgroundHandler.post(new I4.l(26, taskId, options));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public int startCozeTask(int taskType, String taskId, String taskName, Surface surface, int width, int height, int startMode, String openAppname, ITaskProgressCallback callback) {
        k.f(taskId, "taskId");
        k.f(taskName, "taskName");
        AbstractC1436a.b(TAG, "Coze Task no longer supported", true);
        return -1;
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void startTask(final String modelId, final String taskId, final String paramsJson, final Surface surface, final int taskType, final int startMode, final ITaskProgressCallback progressCallback) {
        k.f(taskId, "taskId");
        k.f(paramsJson, "paramsJson");
        if (rejectIfDisabled(taskId, progressCallback)) {
            return;
        }
        final int callingPid = Binder.getCallingPid();
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(callingPid, "startTask: taskId=", taskId, " callerPid=", " taskType=");
        androidx.constraintlayout.core.dsl.a.y(sbT, taskType, " startMode=", startMode, " progressCallback=");
        sbT.append(progressCallback);
        AbstractC1436a.a(TAG, sbT.toString(), true);
        this.backgroundHandler.post(new Runnable() { // from class: o6.g
            @Override // java.lang.Runnable
            public final void run() throws RemoteException {
                TaskRobotManagerImpl.startTask$lambda$0(modelId, taskId, paramsJson, surface, taskType, startMode, progressCallback, callingPid);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startTaskV1(final java.lang.String r18, final java.lang.String r19, final int r20, java.lang.String r21, final android.view.Surface r22, final int r23, final android.os.Bundle r24, final com.stepos.taskrobot.common.ITaskProgressCallback r25) {
        /*
            r17 = this;
            r2 = r17
            r1 = r19
            r11 = r21
            r7 = r24
            r8 = r25
            java.lang.String r0 = "taskId"
            kotlin.jvm.internal.k.f(r1, r0)
            java.lang.String r0 = "paramsJson"
            kotlin.jvm.internal.k.f(r11, r0)
            boolean r0 = r2.rejectIfDisabled(r1, r8)
            if (r0 == 0) goto L1c
            goto Ld1
        L1c:
            r0 = 0
            if (r7 == 0) goto L36
            java.lang.String r3 = "calling_pid"
            r4 = -1
            int r3 = r7.getInt(r3, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            if (r3 <= 0) goto L2d
            goto L2e
        L2d:
            r4 = r0
        L2e:
            if (r4 == 0) goto L36
            int r3 = r4.intValue()
        L34:
            r10 = r3
            goto L3b
        L36:
            int r3 = android.os.Binder.getCallingPid()
            goto L34
        L3b:
            java.lang.String r3 = " taskType "
            java.lang.String r4 = " surface "
            java.lang.String r5 = "startTaskV1: "
            r6 = r20
            java.lang.StringBuilder r3 = androidx.appfunctions.metadata.a.t(r6, r5, r11, r3, r4)
            r4 = r22
            r3.append(r4)
            java.lang.String r5 = " startMode "
            r3.append(r5)
            r5 = r23
            r3.append(r5)
            java.lang.String r9 = " bundle "
            r3.append(r9)
            r3.append(r7)
            java.lang.String r9 = " progressCallback "
            r3.append(r9)
            r3.append(r8)
            java.lang.String r9 = " callerPid "
            r3.append(r9)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            java.lang.String r9 = "TaskRobotManagerImpl"
            r12 = 1
            f6.AbstractC1436a.a(r9, r3, r12)
            java.lang.String r13 = r2.resolveChatSessionId(r1, r0)
            if (r7 == 0) goto L84
            java.lang.String r0 = "sub_session_id"
            java.lang.String r0 = r7.getString(r0)
        L84:
            if (r13 != 0) goto L89
            java.lang.String r3 = "null"
            goto L8a
        L89:
            r3 = r13
        L8a:
            if (r13 == 0) goto L95
            int r14 = r13.length()
            if (r14 != 0) goto L93
            goto L95
        L93:
            r14 = 0
            goto L96
        L95:
            r14 = r12
        L96:
            r14 = r14 ^ r12
            java.lang.String r15 = ", explicitSession=null, resolvedSessionId='"
            java.lang.String r12 = "', hasSessionId="
            r16 = r0
            java.lang.String r0 = "[RELAUNCH] startTaskV1 (V1 old path) entry: taskId="
            java.lang.StringBuilder r0 = B7.a.w(r0, r1, r15, r3, r12)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r3 = 1
            f6.AbstractC1436a.d(r9, r0, r3)
            o6.b r0 = new o6.b
            r3 = r6
            r6 = r5
            r5 = r3
            r3 = r18
            r9 = r16
            r0.<init>()
            android.os.Handler r1 = p6.p.f5554a
            android.content.Context r1 = r17.getContext()
            r3 = r25
            r5 = r0
            r0 = r1
            r2 = r11
            r4 = r13
            r1 = r19
            boolean r0 = p6.p.h(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto Ld1
            r5.invoke(r11)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.service.TaskRobotManagerImpl.startTaskV1(java.lang.String, java.lang.String, int, java.lang.String, android.view.Surface, int, android.os.Bundle, com.stepos.taskrobot.common.ITaskProgressCallback):void");
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void startTaskV1WithSession(final String modelId, final String taskId, final int taskType, String paramsJson, final Surface surface, final int startMode, final Bundle bundle, final String sessionId, final ITaskProgressCallback progressCallback) {
        k.f(taskId, "taskId");
        k.f(paramsJson, "paramsJson");
        if (rejectIfDisabled(taskId, progressCallback)) {
            return;
        }
        boolean z10 = sessionId == null || sessionId.length() == 0;
        StringBuilder sbW = B7.a.w("[RELAUNCH] startTaskV1WithSession entry: taskId=", taskId, ", sessionId='", sessionId, "', hasSession=");
        sbW.append(!z10);
        AbstractC1436a.d(TAG, sbW.toString(), true);
        StringBuilder sb = new StringBuilder("startTaskV1WithSession: sessionId=");
        androidx.constraintlayout.core.dsl.a.A(sb, sessionId, ", ", paramsJson, " taskType ");
        sb.append(taskType);
        sb.append(" surface ");
        sb.append(surface);
        sb.append(" startMode ");
        sb.append(startMode);
        sb.append(" bundle ");
        sb.append(bundle);
        sb.append(" progressCallback ");
        sb.append(progressCallback);
        AbstractC1436a.a(TAG, sb.toString(), true);
        final String string = bundle != null ? bundle.getString(Key.KEY_SUB_SESSION_ID) : null;
        S7.k kVar = new S7.k() { // from class: o6.e
            @Override // S7.k
            public final Object invoke(Object obj) {
                return TaskRobotManagerImpl.startTaskV1WithSession$lambda$0(this.f5437a, modelId, taskId, surface, taskType, startMode, bundle, progressCallback, sessionId, string, (String) obj);
            }
        };
        Handler handler = p.f5554a;
        if (p.h(getContext(), taskId, paramsJson, progressCallback, resolveChatSessionId(taskId, sessionId), kVar)) {
            kVar.invoke(paramsJson);
        }
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void stopTask(String taskId) throws RemoteException {
        AbstractC1436a.a(TAG, "stopTask: " + taskId, true);
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        if (taskId == null) {
            taskId = "";
        }
        SystemSdkBridge.clearTask$default(systemSdkBridge, taskId, false, null, 6, null);
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void submitUserInput(String taskId, String requestId, String content) {
        if (taskId == null || m.s0(taskId) || requestId == null || m.s0(requestId)) {
            return;
        }
        this.backgroundHandler.post(new e(taskId, (Serializable) requestId, (Object) content, 10));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void switchToMainDisplay(String taskId) {
        k.f(taskId, "taskId");
        this.backgroundHandler.post(new o6.c(this, taskId, 1));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void switchToVirtualDisplay(String taskId) {
        k.f(taskId, "taskId");
        this.backgroundHandler.post(new o6.c(this, taskId, 2));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void takeoverTask(String taskId) {
        AbstractC1436a.a(TAG, "takeoverTask: " + taskId, true);
        this.backgroundHandler.post(new o6.c(this, taskId, 3));
    }

    @Override // com.stepos.taskrobot.common.ITaskRobotManger
    public void unregisterProgressCallback(String taskId, ITaskProgressCallback callback) {
        k.f(taskId, "taskId");
        k.f(callback, "callback");
        this.backgroundHandler.post(new o6.d(taskId, Binder.getCallingPid(), callback, 0));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskRobotManagerImpl(Context context) {
        this();
        k.f(context, "context");
        setContext(context);
        Context applicationContext = context.getApplicationContext();
        k.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        S0.b.k1((Application) applicationContext);
    }
}
