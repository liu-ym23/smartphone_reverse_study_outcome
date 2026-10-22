package com.stepos.core.model.manager;

import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1", f = "ModelCacheImpl.kt", l = {1566}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Result<? extends lb.n>>, Object> {
    final /* synthetic */ ModelCacheImpl.VersionRouter.DrainEntry $entry;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1(ModelCacheImpl.VersionRouter.DrainEntry drainEntry, qb.b<? super ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1> bVar) {
        super(2, bVar);
        this.$entry = drainEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1(this.$entry, bVar);
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, qb.b<? super Result<? extends lb.n>> bVar) {
        return invoke2(coroutineScope, (qb.b<? super Result<lb.n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objMo9closeIoAF18A;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            b7.a iModel = this.$entry.getIModel();
            this.label = 1;
            objMo9closeIoAF18A = iModel.mo9closeIoAF18A(this);
            if (objMo9closeIoAF18A == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            objMo9closeIoAF18A = ((Result) obj).f9987a;
        }
        return new Result(objMo9closeIoAF18A);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, qb.b<? super Result<lb.n>> bVar) {
        return ((ModelCacheImpl$VersionRouter$deactivate$1$1$3$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
