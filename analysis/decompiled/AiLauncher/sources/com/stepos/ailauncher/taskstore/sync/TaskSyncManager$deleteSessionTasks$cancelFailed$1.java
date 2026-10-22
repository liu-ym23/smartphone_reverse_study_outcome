package com.stepos.ailauncher.taskstore.sync;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AwaitKt;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sync.TaskSyncManager$deleteSessionTasks$cancelFailed$1", f = "TaskSyncManager.kt", l = {211}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskSyncManager$deleteSessionTasks$cancelFailed$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends TaskInfoCard>>, Object> {
    final /* synthetic */ List<TaskInfoCard> $activeRemoteTasks;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSyncManager$deleteSessionTasks$cancelFailed$1(List<TaskInfoCard> list, InterfaceC4014c<? super TaskSyncManager$deleteSessionTasks$cancelFailed$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$activeRemoteTasks = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskSyncManager$deleteSessionTasks$cancelFailed$1 taskSyncManager$deleteSessionTasks$cancelFailed$1 = new TaskSyncManager$deleteSessionTasks$cancelFailed$1(this.$activeRemoteTasks, interfaceC4014c);
        taskSyncManager$deleteSessionTasks$cancelFailed$1.L$0 = obj;
        return taskSyncManager$deleteSessionTasks$cancelFailed$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return ((TaskSyncManager$deleteSessionTasks$cancelFailed$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            List<TaskInfoCard> list = this.$activeRemoteTasks;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(C1060i.b(m10, null, null, new TaskSyncManager$deleteSessionTasks$cancelFailed$1$1$1((TaskInfoCard) it.next(), null), 3, null));
            }
            this.L$0 = h.a(m10);
            this.label = 1;
            obj = AwaitKt.a(arrayList, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return F.n0((Iterable) obj);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends TaskInfoCard>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<TaskInfoCard>>) interfaceC4014c);
    }
}
