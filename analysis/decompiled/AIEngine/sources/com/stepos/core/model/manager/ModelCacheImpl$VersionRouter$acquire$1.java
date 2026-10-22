package com.stepos.core.model.manager;

import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$acquire$1", f = "ModelCacheImpl.kt", l = {1916, 1612}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$acquire$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super b7.n>, Object> {
    final /* synthetic */ String $modelId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ModelCacheImpl.VersionRouter this$0;
    final /* synthetic */ ModelCacheImpl this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelCacheImpl$VersionRouter$acquire$1(ModelCacheImpl.VersionRouter versionRouter, String str, ModelCacheImpl modelCacheImpl, qb.b<? super ModelCacheImpl$VersionRouter$acquire$1> bVar) {
        super(2, bVar);
        this.this$0 = versionRouter;
        this.$modelId = str;
        this.this$1 = modelCacheImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelCacheImpl$VersionRouter$acquire$1(this.this$0, this.$modelId, this.this$1, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0099 A[Catch: all -> 0x0124, TRY_ENTER, TryCatch #1 {all -> 0x0124, blocks: (B:18:0x007f, B:30:0x00ac, B:34:0x00dc, B:73:0x01f0, B:74:0x020c, B:36:0x00e4, B:38:0x00ee, B:40:0x00fb, B:41:0x010e, B:43:0x0114, B:50:0x012a, B:53:0x012f, B:54:0x015a, B:55:0x015b, B:57:0x0167, B:59:0x016d, B:71:0x01d9, B:72:0x01ef, B:26:0x0099, B:29:0x00a0), top: B:79:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a4 A[Catch: all -> 0x01a8, TryCatch #2 {all -> 0x01a8, blocks: (B:63:0x018a, B:65:0x01a4, B:68:0x01ac), top: B:80:0x018a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$acquire$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super b7.n> bVar) {
        return ((ModelCacheImpl$VersionRouter$acquire$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
