package com.stepos.ailauncher.taskstore.livenotification;

import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1", f = "TaskLiveNotificationDispatcher.kt", l = {1121}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ TaskInfoStatus $next;
    final /* synthetic */ TaskInfoCard $target;
    long J$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1(TaskInfoCard taskInfoCard, TaskInfoStatus taskInfoStatus, InterfaceC4014c<? super TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$target = taskInfoCard;
        this.$next = taskInfoStatus;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1(this.$target, this.$next, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$syncAskUserWaitingOnCards$2$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objP;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                long jCurrentTimeMillis = System.currentTimeMillis();
                TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
                TaskInfoCard taskInfoCardCopy$default = TaskInfoCard.copy$default(this.$target, TaskInfoEventType.UPDATED, null, null, null, null, null, null, null, null, null, 0, 0, false, this.$next, null, null, null, null, null, null, null, null, 0L, null, null, Math.max(this.$target.getUpdatedAt(), jCurrentTimeMillis), null, null, null, null, null, null, null, null, -33562626, 3, null);
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                objP = taskStoreModule.p(taskInfoCardCopy$default, this);
                if (objP == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objP = obj;
            }
            TaskLiveNotificationDispatcher.askUserCardSyncInFlight.remove(this.$target.getTaskId());
            return Y8.t.f7040a;
        } catch (Throwable th) {
            TaskLiveNotificationDispatcher.askUserCardSyncInFlight.remove(this.$target.getTaskId());
            throw th;
        }
    }
}
