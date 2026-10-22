package com.stepos.core.model.concurrency;

import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.model.concurrency.ThreadPoolManagerImpl$launchConsumer$1$job$1", f = "ThreadPoolManagerImpl.kt", l = {475}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ThreadPoolManagerImpl$launchConsumer$1$job$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ ThreadPoolManagerImpl.Work $work;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPoolManagerImpl$launchConsumer$1$job$1(ThreadPoolManagerImpl.Work work, qb.b<? super ThreadPoolManagerImpl$launchConsumer$1$job$1> bVar) {
        super(2, bVar);
        this.$work = work;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new ThreadPoolManagerImpl$launchConsumer$1$job$1(this.$work, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            l<qb.b<? super n>, Object> runner = this.$work.getRunner();
            this.label = 1;
            if (runner.invoke(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((ThreadPoolManagerImpl$launchConsumer$1$job$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
