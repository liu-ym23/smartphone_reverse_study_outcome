package com.stepos.ability.task.scheduler;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.bean.InternalTask;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.task.scheduler.TaskScheduler$schedule$2$1", f = "TaskScheduler.kt", l = {43}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/bean/TaskResult;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/bean/TaskResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TaskScheduler$schedule$2$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3318a;
    public final /* synthetic */ a b;
    public final /* synthetic */ InternalTask c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskScheduler$schedule$2$1(a aVar, InternalTask internalTask, int i, int i6, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = internalTask;
        this.d = i;
        this.e = i6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TaskScheduler$schedule$2$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TaskScheduler$schedule$2$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3318a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        ITaskExecutor iTaskExecutor = this.b.f3319a;
        this.f3318a = 1;
        Object objExecute = iTaskExecutor.execute(this.c, this.d, this.e, this);
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
