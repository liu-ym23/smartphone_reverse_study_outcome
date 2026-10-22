package com.stepos.core.model.concurrency;

import android.util.Log;
import com.stepos.base.task.data.TaskState;
import java.util.concurrent.CancellationException;
import k7.a;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import rb.c;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$submit$work$1", f = "ThreadPoolManagerImpl.kt", l = {164}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ThreadPoolManagerImpl$submit$work$1 extends SuspendLambda implements l<qb.b<? super n>, Object> {
    final /* synthetic */ r6.a $decision;
    final /* synthetic */ j7.b $task;
    int label;
    final /* synthetic */ ThreadPoolManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPoolManagerImpl$submit$work$1(j7.b bVar, ThreadPoolManagerImpl threadPoolManagerImpl, r6.a aVar, qb.b<? super ThreadPoolManagerImpl$submit$work$1> bVar2) {
        super(1, bVar2);
        this.$task = bVar;
        this.this$0 = threadPoolManagerImpl;
        this.$decision = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(qb.b<?> bVar) {
        return new ThreadPoolManagerImpl$submit$work$1(this.$task, this.this$0, this.$decision, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        k7.a aVar;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                this.$task.setState(TaskState.f6405c);
                ThreadPoolManagerImpl.access$getTaskExecutor$p(this.this$0);
                ThreadPoolManagerImpl.access$getTaskExecutor$p(this.this$0);
                aVar = null;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
                aVar = (k7.a) obj;
            }
            if (aVar != null) {
                ThreadPoolManagerImpl.access$getTaskExecutor$p(this.this$0);
            }
            this.$task.setState((aVar == null || !(aVar instanceof a.C0101a)) ? TaskState.h : TaskState.f6406d);
        } catch (CancellationException e10) {
            this.$task.setState(TaskState.f6407e);
            throw e10;
        } catch (Exception e11) {
            this.$task.setState(TaskState.h);
            Log.e("ThreadPoolManager", "task failed: " + this.$task.getId(), e11);
        }
        return n.f10413a;
    }

    @Override // zb.l
    public final Object invoke(qb.b<? super n> bVar) {
        return ((ThreadPoolManagerImpl$submit$work$1) create(bVar)).invokeSuspend(n.f10413a);
    }
}
