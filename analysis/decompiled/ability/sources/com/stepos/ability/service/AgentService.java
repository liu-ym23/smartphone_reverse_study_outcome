package com.stepos.ability.service;

import C7.r;
import P3.c;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.ability.runtime.IRuntimeManager;
import com.stepos.ability.api.ability.security.ISecurityManager;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.api.task.schduler.ITaskScheduler;
import com.stepos.ability.bean.AbilityQueryParamsParcelable;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.GuiAgentConfig;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.SlaPermissionResult;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskConfigKt;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.bean.WhitelistCheckResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.tracelogger.ITraceLogger;
import dagger.hilt.android.AndroidEntryPoint;
import j9.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1703V;
import m9.C1730w;
import m9.InterfaceC1733z;
import m9.r0;
import w0.C2085f;
import z2.l;

@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001j\b\u0007\u0018\u0000 m2\u00020\u0001:\u0001nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010e\u001a\n d*\u0004\u0018\u00010c0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006o"}, d2 = {"Lcom/stepos/ability/service/AgentService;", "Landroid/app/Service;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "LC7/r;", AppAgent.ON_CREATE, "onDestroy", "initTool", "enforceAccessPermission", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "enforceTaskOwnerIfRegistered", "(Ljava/lang/String;)V", "", "status", "controlTask", "(Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/api/task/schduler/ITaskScheduler;", "taskScheduler", "Lcom/stepos/ability/api/task/schduler/ITaskScheduler;", "getTaskScheduler", "()Lcom/stepos/ability/api/task/schduler/ITaskScheduler;", "setTaskScheduler", "(Lcom/stepos/ability/api/task/schduler/ITaskScheduler;)V", "Lcom/stepos/ability/api/task/executor/ITaskExecutor;", "taskExecutor", "Lcom/stepos/ability/api/task/executor/ITaskExecutor;", "getTaskExecutor", "()Lcom/stepos/ability/api/task/executor/ITaskExecutor;", "setTaskExecutor", "(Lcom/stepos/ability/api/task/executor/ITaskExecutor;)V", "Lcom/stepos/ability/api/task/registry/ITaskRegistry;", "taskRegistry", "Lcom/stepos/ability/api/task/registry/ITaskRegistry;", "getTaskRegistry", "()Lcom/stepos/ability/api/task/registry/ITaskRegistry;", "setTaskRegistry", "(Lcom/stepos/ability/api/task/registry/ITaskRegistry;)V", "Lcom/stepos/ability/api/task/listener/ITaskListener;", "taskListener", "Lcom/stepos/ability/api/task/listener/ITaskListener;", "getTaskListener", "()Lcom/stepos/ability/api/task/listener/ITaskListener;", "setTaskListener", "(Lcom/stepos/ability/api/task/listener/ITaskListener;)V", "Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "abilityMng", "Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "getAbilityMng", "()Lcom/stepos/ability/commoninternal/ability/IAbilityManager;", "setAbilityMng", "(Lcom/stepos/ability/commoninternal/ability/IAbilityManager;)V", "Lcom/stepos/ability/api/ability/runtime/IRuntimeManager;", "runtimeMng", "Lcom/stepos/ability/api/ability/runtime/IRuntimeManager;", "getRuntimeMng", "()Lcom/stepos/ability/api/ability/runtime/IRuntimeManager;", "setRuntimeMng", "(Lcom/stepos/ability/api/ability/runtime/IRuntimeManager;)V", "Lcom/stepos/ability/api/ability/security/ISecurityManager;", "securityMng", "Lcom/stepos/ability/api/ability/security/ISecurityManager;", "getSecurityMng", "()Lcom/stepos/ability/api/ability/security/ISecurityManager;", "setSecurityMng", "(Lcom/stepos/ability/api/ability/security/ISecurityManager;)V", "Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "slaPermissionMng", "Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "getSlaPermissionMng", "()Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;", "setSlaPermissionMng", "(Lcom/stepos/ability/api/ability/permission/ISlaPermissionManager;)V", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "callTool", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "getCallTool", "()Lcom/stepos/ability/api/ability/calltool/ICallTool;", "setCallTool", "(Lcom/stepos/ability/api/ability/calltool/ICallTool;)V", "Lcom/stepos/ability/api/ability/monitor/IMonitor;", "monitor", "Lcom/stepos/ability/api/ability/monitor/IMonitor;", "getMonitor", "()Lcom/stepos/ability/api/ability/monitor/IMonitor;", "setMonitor", "(Lcom/stepos/ability/api/ability/monitor/IMonitor;)V", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "traceLogger", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "getTraceLogger", "()Lcom/stepos/ability/tracelogger/ITraceLogger;", "setTraceLogger", "(Lcom/stepos/ability/tracelogger/ITraceLogger;)V", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "singleThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "Lm9/z;", "serviceScope", "Lm9/z;", "com/stepos/ability/service/AgentService$binder$1", "binder", "Lcom/stepos/ability/service/AgentService$binder$1;", "Companion", "com/stepos/ability/service/a", "service_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class AgentService extends Hilt_AgentService {
    public static final a Companion = new a();
    private static final String TAG = "AgentService";

    @Inject
    public IAbilityManager abilityMng;
    private final AgentService$binder$1 binder;

    @Inject
    public ICallTool callTool;

    @Inject
    public IMonitor monitor;

    @Inject
    public IRuntimeManager runtimeMng;

    @Inject
    public ISecurityManager securityMng;
    private final InterfaceC1733z serviceScope;
    private final ExecutorService singleThreadExecutor;

    @Inject
    public ISlaPermissionManager slaPermissionMng;

    @Inject
    public ITaskExecutor taskExecutor;

    @Inject
    public ITaskListener taskListener;

    @Inject
    public ITaskRegistry taskRegistry;

    @Inject
    public ITaskScheduler taskScheduler;

    @Inject
    public ITraceLogger traceLogger;

    /* JADX WARN: Type inference failed for: r0v4, types: [com.stepos.ability.service.AgentService$binder$1] */
    public AgentService() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        this.singleThreadExecutor = singleThreadExecutor;
        r0 r0VarC = AbstractC1683A.c();
        k.e(singleThreadExecutor, "singleThreadExecutor");
        this.serviceScope = AbstractC1683A.b(l.H(r0VarC, new C1703V(singleThreadExecutor)).plus(new b(C1730w.f5337a, 0)));
        this.binder = new IAgentServiceManager.Stub() { // from class: com.stepos.ability.service.AgentService$binder$1
            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelFullScreenGui(String taskId) {
                Task task;
                this.this$0.enforceAccessPermission();
                String msg = "cancelFullScreenGui: " + taskId;
                k.f(msg, "msg");
                String strConcat = "Ability_".concat("AgentService");
                P3.b bVar = c.f1086a;
                bVar.invoke(3, strConcat, msg, null);
                if (taskId == null || m.s0(taskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                InternalTask internalTask = this.this$0.getTaskRegistry().get(taskId);
                if (internalTask != null && (task = internalTask.getTask()) != null) {
                    AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$cancelFullScreenGui$1(this.this$0, task, null), 3);
                    return;
                }
                String msg2 = "cancelFullScreenGui: task not found ".concat(taskId);
                k.f(msg2, "msg");
                bVar.invoke(5, "Ability_".concat("AgentService"), msg2, null);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelPackageConflict(String newTaskId, int conflictKind) {
                this.this$0.enforceAccessPermission();
                String msg = "cancelPackageConflict: " + newTaskId + " kind=" + conflictKind;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                if (newTaskId == null || m.s0(newTaskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(newTaskId);
                this.this$0.getTaskExecutor().cancelPackageConflict(newTaskId, conflictKind);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void cancelUserInput(String taskId, String requestId) {
                this.this$0.enforceAccessPermission();
                if (taskId == null || m.s0(taskId) || requestId == null || m.s0(requestId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$cancelUserInput$1(this.this$0, taskId, requestId, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public WhitelistCheckResult checkAppWhitelistV1(String appName) {
                k.f(appName, "appName");
                this.this$0.enforceAccessPermission();
                String msg = "checkAppWhitelistV1: ".concat(appName);
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                return this.this$0.getTaskExecutor().checkAppWhitelist(appName);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.EmptyList] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
            /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.StringBuilder] */
            /* JADX WARN: Type inference failed for: r6v2, types: [com.stepos.ability.api.ability.permission.ISlaPermissionManager] */
            @Override // com.stepos.ability.IAgentServiceManager
            public SlaPermissionResult checkSlaPermissionV1(List<String> functions) {
                ?? arrayList;
                this.this$0.enforceAccessPermission();
                if (functions != null) {
                    arrayList = new ArrayList();
                    for (Object obj : functions) {
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = EmptyList.f4893a;
                }
                SlaPermissionResult slaPermissionResultCheckSlaPermission = this.this$0.getSlaPermissionMng().checkSlaPermission(arrayList);
                String msg = "checkSlaPermissionV1: funcs=" + arrayList + " -> verdict=" + slaPermissionResultCheckSlaPermission.getVerdict() + " canExecute=" + slaPermissionResultCheckSlaPermission.getCanExecute() + " denyReason=" + slaPermissionResultCheckSlaPermission.getDenyReason() + " denied=" + slaPermissionResultCheckSlaPermission.getDeniedFunction();
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                return slaPermissionResultCheckSlaPermission;
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void confirmPackageConflict(String newTaskId, int conflictKind) {
                this.this$0.enforceAccessPermission();
                String msg = "confirmPackageConflict: " + newTaskId + " kind=" + conflictKind;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                if (newTaskId == null || m.s0(newTaskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(newTaskId);
                this.this$0.getTaskExecutor().confirmPackageConflict(newTaskId, conflictKind);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void dismissFullScreenOverlay(String taskId) {
                this.this$0.enforceAccessPermission();
                if (taskId != null) {
                    String str = !m.s0(taskId) ? taskId : null;
                    if (str != null) {
                        this.this$0.enforceTaskOwnerIfRegistered(str);
                    }
                }
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$dismissFullScreenOverlay$3(this.this$0, taskId, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void dismissVoiceInput(String taskId) {
                this.this$0.enforceAccessPermission();
                if (taskId == null || m.s0(taskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$dismissVoiceInput$1(this.this$0, taskId, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void fullScreenGui(String taskId) {
                Task task;
                this.this$0.enforceAccessPermission();
                String msg = "fullScreenGui: " + taskId;
                k.f(msg, "msg");
                String strConcat = "Ability_".concat("AgentService");
                P3.b bVar = c.f1086a;
                bVar.invoke(3, strConcat, msg, null);
                if (taskId == null || m.s0(taskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                InternalTask internalTask = this.this$0.getTaskRegistry().get(taskId);
                if (internalTask != null && (task = internalTask.getTask()) != null) {
                    AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$fullScreenGui$1(this.this$0, task, null), 3);
                    return;
                }
                String msg2 = "fullScreenGui: task not found ".concat(taskId);
                k.f(msg2, "msg");
                bVar.invoke(5, "Ability_".concat("AgentService"), msg2, null);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getForegroundTaskId() {
                this.this$0.enforceAccessPermission();
                return this.this$0.getTaskExecutor().getForegroundTaskId();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getForegroundTaskSessionId() {
                this.this$0.enforceAccessPermission();
                return this.this$0.getTaskExecutor().getForegroundTaskSessionId();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String getLastActiveTaskSessionId() {
                this.this$0.enforceAccessPermission();
                return this.this$0.getTaskExecutor().getLastActiveTaskSessionId();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
                this.this$0.enforceAccessPermission();
                return this.this$0.getTaskExecutor().getMainDisplayTopAppHistory();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public AppOccupationResult isAppOccupiedV1(String appName) {
                k.f(appName, "appName");
                this.this$0.enforceAccessPermission();
                String msg = "isAppOccupiedV1: ".concat(appName);
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                return this.this$0.getTaskExecutor().isAppOccupied(appName);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public List<TaskSnapshot> listActiveTasks() {
                this.this$0.enforceAccessPermission();
                return this.this$0.getTaskExecutor().listActiveTasks();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void queryAbilities(String query, List<AbilityQueryParamsParcelable> params, IAbilityQueryCallback callback) {
                this.this$0.enforceAccessPermission();
                Log.i("AgentService", "queryAbilities called. params: " + params);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$queryAbilities$1(this.this$0, query, params, callback, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void registerTaskListener(com.stepos.ability.ITaskListener listener, String key) {
                this.this$0.enforceAccessPermission();
                String msg = "registerTaskListener: key:" + key + ", " + listener;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                if (listener == null || key == null || m.s0(key)) {
                    return;
                }
                this.this$0.getTaskListener().registerTaskListener(listener, key);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void resumeFullScreenOverlay(String taskId) {
                this.this$0.enforceAccessPermission();
                if (taskId != null) {
                    String str = !m.s0(taskId) ? taskId : null;
                    if (str != null) {
                        this.this$0.enforceTaskOwnerIfRegistered(str);
                    }
                }
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$resumeFullScreenOverlay$3(this.this$0, taskId, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void showFullScreenGuiV2(String taskId, Bundle options) {
                this.this$0.enforceAccessPermission();
                if (taskId == null || m.s0(taskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$showFullScreenGuiV2$1(this.this$0, taskId, options, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitPermissionAuthResult(boolean agreed, String toolCallId, Bundle extras) {
                this.this$0.enforceAccessPermission();
                if (toolCallId == null) {
                    toolCallId = "";
                }
                String str = toolCallId;
                if (extras == null) {
                    extras = new Bundle();
                }
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$submitPermissionAuthResult$1(this.this$0, agreed, str, extras, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public String submitTask(TaskConfig taskConfig) {
                InternalTask internalTask;
                this.this$0.enforceAccessPermission();
                String msg = "submitTask: " + taskConfig;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                if (taskConfig == null || (internalTask = TaskConfigKt.toInternalTask(taskConfig)) == null) {
                    return null;
                }
                Task task = internalTask.getTask();
                int callingUid = Binder.getCallingUid();
                int callingPid = Binder.getCallingPid();
                this.this$0.getTaskRegistry().register(internalTask, callingUid);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$submitTask$1(this.this$0, internalTask, callingUid, callingPid, null), 3);
                return task.getTaskId();
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitToolCallEvent(ToolCallEvent event) {
                k.f(event, "event");
                this.this$0.enforceAccessPermission();
                this.this$0.getTaskListener().onToolCallEvent(event);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void submitUserInput(String taskId, String requestId, String content) {
                this.this$0.enforceAccessPermission();
                if (taskId == null || m.s0(taskId) || requestId == null || m.s0(requestId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$submitUserInput$1(this.this$0, taskId, requestId, content, null), 3);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void toolUpdateTask(Task task) {
                k.f(task, "task");
                this.this$0.enforceAccessPermission();
                this.this$0.enforceTaskOwnerIfRegistered(task.getTaskId());
                String msg = "toolUpdateTask: " + task;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                this.this$0.getTaskListener().onTaskEvent(task, true);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void unRegisterTaskListener(String key) {
                this.this$0.enforceAccessPermission();
                String msg = "unRegisterTaskListener: " + key;
                k.f(msg, "msg");
                c.f1086a.invoke(3, "Ability_".concat("AgentService"), msg, null);
                if (key == null || m.s0(key)) {
                    return;
                }
                this.this$0.getTaskListener().unRegisterTaskListener(key);
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void updateTask(String taskId, Bundle bundle) {
                this.this$0.enforceAccessPermission();
                c.a("AgentService", "updateTask: " + taskId);
                if (taskId == null || m.s0(taskId) || bundle == null) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                InternalTask internalTask = this.this$0.getTaskRegistry().get(taskId);
                if (internalTask != null) {
                    AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$updateTask$2(internalTask, this.this$0, taskId, bundle, null), 3);
                    return;
                }
                bundle.setClassLoader(GuiAgentConfig.class.getClassLoader());
                if (!bundle.containsKey(Key.KEY_GUI_AGENT_CONFIG)) {
                    c.c("updateTask: task not found ".concat(taskId));
                } else {
                    c.c("updateTask: task not yet registered, route GUI surface to pre-cache: ".concat(taskId));
                    AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$updateTask$1(this.this$0, taskId, bundle, null), 3);
                }
            }

            @Override // com.stepos.ability.IAgentServiceManager
            public void updateTaskStatusAndControl(String taskId, int status) {
                this.this$0.enforceAccessPermission();
                String msg = "updateTaskStatusAndControl: " + taskId + ", " + status;
                k.f(msg, "msg");
                String strConcat = "Ability_".concat("AgentService");
                P3.b bVar = c.f1086a;
                bVar.invoke(3, strConcat, msg, null);
                if (taskId == null || m.s0(taskId)) {
                    return;
                }
                this.this$0.enforceTaskOwnerIfRegistered(taskId);
                C2085f c2085f = TaskStatus.b;
                if (status == 3 || status == 6 || status == 2 || status == 8) {
                    AbstractC1683A.n(this.this$0.serviceScope, null, new AgentService$binder$1$updateTaskStatusAndControl$1(this.this$0, taskId, status, null), 3);
                    return;
                }
                String msg2 = "updateTaskStatusAndControl no change " + taskId + ", status=" + status;
                k.f(msg2, "msg");
                bVar.invoke(3, "Ability_".concat("AgentService"), msg2, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object controlTask(String str, int i, H7.c<? super r> cVar) {
        Object objTakeOver;
        InternalTask internalTask = getTaskRegistry().get(str);
        P3.b bVar = c.f1086a;
        r rVar = r.f317a;
        if (internalTask == null) {
            bVar.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("controlTask: task not found ", str, NotificationCompat.CATEGORY_MESSAGE), null);
            return rVar;
        }
        Task task = internalTask.getTask();
        Integer status = getTaskRegistry().getStatus(str);
        int iIntValue = status != null ? status.intValue() : task.getStatus();
        C2085f c2085f = TaskStatus.b;
        if (i == 3) {
            Object objPause = getTaskExecutor().pause(task, cVar);
            if (objPause == CoroutineSingletons.f4909a) {
                return objPause;
            }
        } else if (i == 6) {
            Object objCancel = getTaskExecutor().cancel(task, cVar);
            if (objCancel == CoroutineSingletons.f4909a) {
                return objCancel;
            }
        } else if (i != 2) {
            TaskStatus.b.getClass();
            if (TaskStatus.c.contains(new Integer(i))) {
                if (iIntValue == 3) {
                    Object objResume = getTaskExecutor().resume(task, cVar);
                    if (objResume == CoroutineSingletons.f4909a) {
                        return objResume;
                    }
                } else {
                    if (!TaskStatus.d.contains(new Integer(iIntValue))) {
                        String msg = "controlTask: ignore RUNNING from preStatus=" + iIntValue;
                        k.f(msg, "msg");
                        bVar.invoke(3, "Ability_".concat(TAG), msg, null);
                        return rVar;
                    }
                    Object objUnTakeOver = getTaskExecutor().unTakeOver(task, cVar);
                    if (objUnTakeOver == CoroutineSingletons.f4909a) {
                        return objUnTakeOver;
                    }
                }
            } else if (i == 8 && (objTakeOver = getTaskExecutor().takeOver(task, cVar)) == CoroutineSingletons.f4909a) {
                return objTakeOver;
            }
        } else if (iIntValue == 3) {
            Object objResume2 = getTaskExecutor().resume(task, cVar);
            if (objResume2 == CoroutineSingletons.f4909a) {
                return objResume2;
            }
        } else {
            TaskStatus.b.getClass();
            if (!TaskStatus.d.contains(new Integer(iIntValue)) && iIntValue != 12 && iIntValue != 11 && iIntValue != 10) {
                String msg2 = "controlTask: ignore RUNNING from preStatus=" + iIntValue;
                k.f(msg2, "msg");
                bVar.invoke(3, "Ability_".concat(TAG), msg2, null);
                return rVar;
            }
            Object objUnTakeOver2 = getTaskExecutor().unTakeOver(task, cVar);
            if (objUnTakeOver2 == CoroutineSingletons.f4909a) {
                return objUnTakeOver2;
            }
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enforceAccessPermission() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return;
        }
        enforceCallingPermission("com.stepos.ability.permission.ACCESS_AGENT_SERVICE", "ACCESS_AGENT_SERVICE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enforceTaskOwnerIfRegistered(String taskId) {
        Integer callingUid;
        if (m.s0(taskId) || (callingUid = getTaskRegistry().getCallingUid(taskId)) == null) {
            return;
        }
        int iIntValue = callingUid.intValue();
        int callingUid2 = Binder.getCallingUid();
        if (callingUid2 == Process.myUid() || iIntValue == callingUid2) {
            return;
        }
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(iIntValue, "task owner mismatch: taskId=", taskId, " ownerUid=", " callingUid=");
        sbT.append(callingUid2);
        String msg = sbT.toString();
        k.f(msg, "msg");
        c.f1086a.invoke(5, "Ability_".concat(TAG), msg, null);
        throw new SecurityException(androidx.constraintlayout.core.dsl.a.c(callingUid2, "Caller uid ", " is not the owner of task ", taskId));
    }

    private final void initTool() {
        getCallTool().setup(this);
        getAbilityMng().setup(this);
        getRuntimeMng().setup(this);
        getMonitor().setup(this);
    }

    public final IAbilityManager getAbilityMng() {
        IAbilityManager iAbilityManager = this.abilityMng;
        if (iAbilityManager != null) {
            return iAbilityManager;
        }
        k.n("abilityMng");
        throw null;
    }

    public final ICallTool getCallTool() {
        ICallTool iCallTool = this.callTool;
        if (iCallTool != null) {
            return iCallTool;
        }
        k.n("callTool");
        throw null;
    }

    public final IMonitor getMonitor() {
        IMonitor iMonitor = this.monitor;
        if (iMonitor != null) {
            return iMonitor;
        }
        k.n("monitor");
        throw null;
    }

    public final IRuntimeManager getRuntimeMng() {
        IRuntimeManager iRuntimeManager = this.runtimeMng;
        if (iRuntimeManager != null) {
            return iRuntimeManager;
        }
        k.n("runtimeMng");
        throw null;
    }

    public final ISecurityManager getSecurityMng() {
        ISecurityManager iSecurityManager = this.securityMng;
        if (iSecurityManager != null) {
            return iSecurityManager;
        }
        k.n("securityMng");
        throw null;
    }

    public final ISlaPermissionManager getSlaPermissionMng() {
        ISlaPermissionManager iSlaPermissionManager = this.slaPermissionMng;
        if (iSlaPermissionManager != null) {
            return iSlaPermissionManager;
        }
        k.n("slaPermissionMng");
        throw null;
    }

    public final ITaskExecutor getTaskExecutor() {
        ITaskExecutor iTaskExecutor = this.taskExecutor;
        if (iTaskExecutor != null) {
            return iTaskExecutor;
        }
        k.n("taskExecutor");
        throw null;
    }

    public final ITaskListener getTaskListener() {
        ITaskListener iTaskListener = this.taskListener;
        if (iTaskListener != null) {
            return iTaskListener;
        }
        k.n("taskListener");
        throw null;
    }

    public final ITaskRegistry getTaskRegistry() {
        ITaskRegistry iTaskRegistry = this.taskRegistry;
        if (iTaskRegistry != null) {
            return iTaskRegistry;
        }
        k.n("taskRegistry");
        throw null;
    }

    public final ITaskScheduler getTaskScheduler() {
        ITaskScheduler iTaskScheduler = this.taskScheduler;
        if (iTaskScheduler != null) {
            return iTaskScheduler;
        }
        k.n("taskScheduler");
        throw null;
    }

    public final ITraceLogger getTraceLogger() {
        ITraceLogger iTraceLogger = this.traceLogger;
        if (iTraceLogger != null) {
            return iTraceLogger;
        }
        k.n("traceLogger");
        throw null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        c.f1086a.invoke(3, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("onBind: ", intent != null ? intent.getAction() : null, NotificationCompat.CATEGORY_MESSAGE), null);
        return this.binder;
    }

    @Override // com.stepos.ability.service.Hilt_AgentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        initTool();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        getAbilityMng().destroy();
        this.singleThreadExecutor.shutdown();
    }

    public final void setAbilityMng(IAbilityManager iAbilityManager) {
        k.f(iAbilityManager, "<set-?>");
        this.abilityMng = iAbilityManager;
    }

    public final void setCallTool(ICallTool iCallTool) {
        k.f(iCallTool, "<set-?>");
        this.callTool = iCallTool;
    }

    public final void setMonitor(IMonitor iMonitor) {
        k.f(iMonitor, "<set-?>");
        this.monitor = iMonitor;
    }

    public final void setRuntimeMng(IRuntimeManager iRuntimeManager) {
        k.f(iRuntimeManager, "<set-?>");
        this.runtimeMng = iRuntimeManager;
    }

    public final void setSecurityMng(ISecurityManager iSecurityManager) {
        k.f(iSecurityManager, "<set-?>");
        this.securityMng = iSecurityManager;
    }

    public final void setSlaPermissionMng(ISlaPermissionManager iSlaPermissionManager) {
        k.f(iSlaPermissionManager, "<set-?>");
        this.slaPermissionMng = iSlaPermissionManager;
    }

    public final void setTaskExecutor(ITaskExecutor iTaskExecutor) {
        k.f(iTaskExecutor, "<set-?>");
        this.taskExecutor = iTaskExecutor;
    }

    public final void setTaskListener(ITaskListener iTaskListener) {
        k.f(iTaskListener, "<set-?>");
        this.taskListener = iTaskListener;
    }

    public final void setTaskRegistry(ITaskRegistry iTaskRegistry) {
        k.f(iTaskRegistry, "<set-?>");
        this.taskRegistry = iTaskRegistry;
    }

    public final void setTaskScheduler(ITaskScheduler iTaskScheduler) {
        k.f(iTaskScheduler, "<set-?>");
        this.taskScheduler = iTaskScheduler;
    }

    public final void setTraceLogger(ITraceLogger iTraceLogger) {
        k.f(iTraceLogger, "<set-?>");
        this.traceLogger = iTraceLogger;
    }
}
