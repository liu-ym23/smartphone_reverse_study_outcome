package com.stepos.core.model.manager;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelLoaderImpl$loadModelInternal$1$migrated$1", f = "ModelLoaderImpl.kt", l = {367}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelLoaderImpl$loadModelInternal$1$migrated$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Boolean>, Object> {
    final /* synthetic */ b7.k $config;
    final /* synthetic */ c7.c $d;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelLoaderImpl$loadModelInternal$1$migrated$1(c7.c cVar, b7.k kVar, qb.b<? super ModelLoaderImpl$loadModelInternal$1$migrated$1> bVar) {
        super(2, bVar);
        this.$d = cVar;
        this.$config = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        ModelLoaderImpl$loadModelInternal$1$migrated$1 modelLoaderImpl$loadModelInternal$1$migrated$1 = new ModelLoaderImpl$loadModelInternal$1$migrated$1(this.$d, this.$config, bVar);
        modelLoaderImpl$loadModelInternal$1$migrated$1.L$0 = obj;
        return modelLoaderImpl$loadModelInternal$1$migrated$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                c7.c cVar = this.$d;
                File file = new File(this.$config.f3091b);
                this.label = 1;
                obj = cVar.migrateIfNeeded(file, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            objA = (Boolean) obj;
            objA.getClass();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        b7.k kVar = this.$config;
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.MODEL, "ModelLoaderImpl", ai.onnxruntime.a.l("at-rest migrate error [", kVar.f3090a, "]: ", thB.getMessage()));
        }
        return objA instanceof Result.Failure ? Boolean.FALSE : objA;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((ModelLoaderImpl$loadModelInternal$1$migrated$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
