package com.stepos.ailauncher.taskstore.sync;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TaskCancelRequest;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sync.TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1", f = "TaskSyncManager.kt", l = {207}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super TaskInfoCard>, Object> {
    final /* synthetic */ TaskInfoCard $task;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1(TaskInfoCard taskInfoCard, InterfaceC4014c<? super TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$task = taskInfoCard;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1(this.$task, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TaskInfoCard> interfaceC4014c) {
        return ((TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                TaskSyncManager taskSyncManager = TaskSyncManager.INSTANCE;
                TaskInfoCard taskInfoCard = this.$task;
                Result.Companion companion = Result.INSTANCE;
                SessionHandler sessionHandlerZ = taskSyncManager.z();
                TaskCancelRequest taskCancelRequest = new TaskCancelRequest(taskInfoCard.getTaskId(), null, null, null, null, 30, null);
                this.L$0 = h.a(taskSyncManager);
                this.L$1 = h.a(taskSyncManager);
                this.L$2 = h.a(this);
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.label = 1;
                obj = sessionHandlerZ.b4(taskCancelRequest, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(C4109a.a(((Boolean) obj).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("TaskSyncManager", "remote sync error", thE, false, 8, null);
        }
        Boolean boolA = C4109a.a(false);
        if (Result.g(objB)) {
            objB = boolA;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        TaskInfoCard taskInfoCard2 = this.$task;
        if (zBooleanValue) {
            return null;
        }
        return taskInfoCard2;
    }
}
