package com.stepos.core.ability;

import b7.s;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.AbilityManager$initialize$3$1", f = "AbilityManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbilityManager$initialize$3$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ String $algorithmId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityManager$initialize$3$1(String str, qb.b<? super AbilityManager$initialize$3$1> bVar) {
        super(2, bVar);
        this.$algorithmId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        AbilityManager$initialize$3$1 abilityManager$initialize$3$1 = new AbilityManager$initialize$3$1(this.$algorithmId, bVar);
        abilityManager$initialize$3$1.L$0 = obj;
        return abilityManager$initialize$3$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        ModelCacheImpl modelCacheImpl = s.f3120b;
        if (modelCacheImpl == null) {
            return n.f10413a;
        }
        try {
            modelCacheImpl.preload(this.$algorithmId);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        String str = this.$algorithmId;
        if (!(objA instanceof Result.Failure)) {
            h0.e.k("resident model reloaded after preinstall/OTA: ", str, LogModule.ABILITY, "AbilityManager");
        }
        String str2 = this.$algorithmId;
        Throwable thB = Result.b(objA);
        if (thB != null) {
            LogModule logModule = LogModule.ABILITY;
            String simpleName = thB.getClass().getSimpleName();
            a0.a.x(ai.onnxruntime.a.s("reload after extract failed (fallback to acquire-triggered): ", str2, ": ", simpleName, ": "), thB.getMessage(), logModule, "AbilityManager");
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((AbilityManager$initialize$3$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
