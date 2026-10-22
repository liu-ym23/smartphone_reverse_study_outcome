package com.stepos.core.model.manager;

import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$rollback$1", f = "ModelCacheImpl.kt", l = {1916}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$rollback$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Boolean>, Object> {
    final /* synthetic */ String $modelId;
    final /* synthetic */ String $reason;
    final /* synthetic */ int $toVersion;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ModelCacheImpl.VersionRouter this$0;
    final /* synthetic */ ModelCacheImpl this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCacheImpl$VersionRouter$rollback$1(ModelCacheImpl.VersionRouter versionRouter, String str, int i10, ModelCacheImpl modelCacheImpl, String str2, qb.b<? super ModelCacheImpl$VersionRouter$rollback$1> bVar) {
        super(2, bVar);
        this.this$0 = versionRouter;
        this.$modelId = str;
        this.$toVersion = i10;
        this.this$1 = modelCacheImpl;
        this.$reason = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        ModelCacheImpl$VersionRouter$rollback$1 modelCacheImpl$VersionRouter$rollback$1 = new ModelCacheImpl$VersionRouter$rollback$1(this.this$0, this.$modelId, this.$toVersion, this.this$1, this.$reason, bVar);
        modelCacheImpl$VersionRouter$rollback$1.L$0 = obj;
        return modelCacheImpl$VersionRouter$rollback$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0128  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$rollback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((ModelCacheImpl$VersionRouter$rollback$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
