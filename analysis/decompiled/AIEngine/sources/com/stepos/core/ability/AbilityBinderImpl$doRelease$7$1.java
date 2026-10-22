package com.stepos.core.ability;

import com.stepos.base.model.ModelReleaseReason;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$doRelease$7$1", f = "AbilityBinderImpl.kt", l = {1327}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbilityBinderImpl$doRelease$7$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ ModelReleaseReason $reason;
    final /* synthetic */ AbilityBinderImpl $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityBinderImpl$doRelease$7$1(AbilityBinderImpl abilityBinderImpl, ModelReleaseReason modelReleaseReason, qb.b<? super AbilityBinderImpl$doRelease$7$1> bVar) {
        super(2, bVar);
        this.$this_runCatching = abilityBinderImpl;
        this.$reason = modelReleaseReason;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new AbilityBinderImpl$doRelease$7$1(this.$this_runCatching, this.$reason, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            p6.d<?, ?> ability = this.$this_runCatching.getAbility();
            ModelReleaseReason modelReleaseReason = this.$reason;
            this.label = 1;
            if (ability.release(modelReleaseReason, this) == coroutineSingletons) {
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
        return ((AbilityBinderImpl$doRelease$7$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
