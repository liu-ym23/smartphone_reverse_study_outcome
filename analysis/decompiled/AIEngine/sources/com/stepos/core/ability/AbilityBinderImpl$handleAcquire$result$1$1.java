package com.stepos.core.ability;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$handleAcquire$result$1$1", f = "AbilityBinderImpl.kt", l = {226}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbilityBinderImpl$handleAcquire$result$1$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Boolean>, Object> {
    final /* synthetic */ long $acquireStartMonoNs;
    final /* synthetic */ long $acquireStartWallMs;
    final /* synthetic */ Ref$BooleanRef $failurePublished;
    final /* synthetic */ long $timeoutMillis;
    int label;
    final /* synthetic */ AbilityBinderImpl this$0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.AbilityBinderImpl$handleAcquire$result$1$1$1", f = "AbilityBinderImpl.kt", l = {227}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.AbilityBinderImpl$handleAcquire$result$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Boolean>, Object> {
        int label;
        final /* synthetic */ AbilityBinderImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AbilityBinderImpl abilityBinderImpl, qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.this$0 = abilityBinderImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass1(this.this$0, bVar);
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
            p6.d<?, ?> ability = this.this$0.getAbility();
            this.label = 1;
            Object objAcquire = ability.acquire(this);
            return objAcquire == coroutineSingletons ? coroutineSingletons : objAcquire;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityBinderImpl$handleAcquire$result$1$1(long j10, AbilityBinderImpl abilityBinderImpl, long j11, long j12, Ref$BooleanRef ref$BooleanRef, qb.b<? super AbilityBinderImpl$handleAcquire$result$1$1> bVar) {
        super(2, bVar);
        this.$timeoutMillis = j10;
        this.this$0 = abilityBinderImpl;
        this.$acquireStartMonoNs = j11;
        this.$acquireStartWallMs = j12;
        this.$failurePublished = ref$BooleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new AbilityBinderImpl$handleAcquire$result$1$1(this.$timeoutMillis, this.this$0, this.$acquireStartMonoNs, this.$acquireStartWallMs, this.$failurePublished, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        boolean zBooleanValue = false;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = this.$timeoutMillis;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                obj = TimeoutKt.withTimeout(j10, anonymousClass1, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            zBooleanValue = ((Boolean) obj).booleanValue();
        } catch (TimeoutCancellationException e10) {
            LogModule logModule = LogModule.ABILITY;
            String str = this.this$0.TAG;
            StringBuilder sbL = com.stepos.core.ota.d.l("handleAcquire timeout: ", this.$timeoutMillis, this.this$0.getToken(), ", timeout: ");
            sbL.append("ms");
            AIEngineLogger.e(logModule, str, sbL.toString(), e10);
            this.this$0.publishAcquireFailure(e10, this.$acquireStartMonoNs, this.$acquireStartWallMs);
            this.$failurePublished.f10073a = true;
        } catch (Exception e11) {
            AIEngineLogger.e(LogModule.ABILITY, this.this$0.TAG, "handleAcquire error: " + this.this$0.getToken(), e11);
            this.this$0.publishAcquireFailure(e11, this.$acquireStartMonoNs, this.$acquireStartWallMs);
            this.$failurePublished.f10073a = true;
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((AbilityBinderImpl$handleAcquire$result$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
