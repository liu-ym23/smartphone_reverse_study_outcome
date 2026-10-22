package com.stepos.core.ability.executor;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import p6.d;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ability.executor.InferenceExecutor$executeInternal$1$plan$1", f = "InferenceExecutor.kt", l = {235}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class InferenceExecutor$executeInternal$1$plan$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super h7.c>, Object> {
    final /* synthetic */ v6.c $abilityInput;
    final /* synthetic */ long $localWatchdogMs;
    final /* synthetic */ Object $record;
    final /* synthetic */ d<v6.c, v6.d> $typedAbility;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InferenceExecutor$executeInternal$1$plan$1(d<v6.c, v6.d> dVar, v6.c cVar, Object obj, long j10, qb.b<? super InferenceExecutor$executeInternal$1$plan$1> bVar) {
        super(2, bVar);
        this.$typedAbility = dVar;
        this.$abilityInput = cVar;
        this.$record = obj;
        this.$localWatchdogMs = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new InferenceExecutor$executeInternal$1$plan$1(this.$typedAbility, this.$abilityInput, this.$record, this.$localWatchdogMs, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        d<v6.c, v6.d> dVar = this.$typedAbility;
        v6.c cVar = this.$abilityInput;
        Object obj2 = this.$record;
        long j10 = this.$localWatchdogMs;
        this.label = 1;
        Object objPlanExecution = dVar.planExecution(cVar, obj2, j10, this);
        return objPlanExecution == coroutineSingletons ? coroutineSingletons : objPlanExecution;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super h7.c> bVar) {
        return ((InferenceExecutor$executeInternal$1$plan$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
