package com.stepos.core.model.manager;

import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$switchVersion$1", f = "ModelCacheImpl.kt", l = {1916}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ModelCacheImpl$VersionRouter$switchVersion$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
    final /* synthetic */ String $installer;
    final /* synthetic */ String $modelId;
    final /* synthetic */ String $newPath;
    final /* synthetic */ int $newVersion;
    int I$0;
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
    public ModelCacheImpl$VersionRouter$switchVersion$1(ModelCacheImpl.VersionRouter versionRouter, String str, int i10, String str2, ModelCacheImpl modelCacheImpl, String str3, qb.b<? super ModelCacheImpl$VersionRouter$switchVersion$1> bVar) {
        super(2, bVar);
        this.this$0 = versionRouter;
        this.$modelId = str;
        this.$newVersion = i10;
        this.$newPath = str2;
        this.this$1 = modelCacheImpl;
        this.$installer = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new ModelCacheImpl$VersionRouter$switchVersion$1(this.this$0, this.$modelId, this.$newVersion, this.$newPath, this.this$1, this.$installer, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082 A[Catch: all -> 0x00ec, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ec, blocks: (B:12:0x006b, B:24:0x00a1, B:26:0x00a7, B:37:0x00f0, B:59:0x01d3, B:29:0x00b4, B:31:0x00bf, B:34:0x00c6, B:39:0x012d, B:41:0x0133, B:43:0x013b, B:45:0x0145, B:47:0x014f, B:48:0x0153, B:49:0x0156, B:51:0x017b, B:53:0x0181, B:54:0x0184, B:55:0x01b9, B:58:0x01cc, B:19:0x0082), top: B:66:0x006b, inners: #0 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.manager.ModelCacheImpl$VersionRouter$switchVersion$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((ModelCacheImpl$VersionRouter$switchVersion$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
