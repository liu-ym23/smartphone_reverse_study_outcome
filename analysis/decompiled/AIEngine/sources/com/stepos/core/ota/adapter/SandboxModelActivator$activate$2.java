package com.stepos.core.ota.adapter;

import b7.s;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.model.manager.ModelCacheImpl;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.SandboxModelActivator$activate$2", f = "InstallAdapters.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SandboxModelActivator$activate$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ String $installer;
    final /* synthetic */ String $otaId;
    final /* synthetic */ String $path;
    final /* synthetic */ int $version;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SandboxModelActivator$activate$2(String str, int i10, String str2, String str3, b<? super SandboxModelActivator$activate$2> bVar) {
        super(2, bVar);
        this.$otaId = str;
        this.$version = i10;
        this.$path = str2;
        this.$installer = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        SandboxModelActivator$activate$2 sandboxModelActivator$activate$2 = new SandboxModelActivator$activate$2(this.$otaId, this.$version, this.$path, this.$installer, bVar);
        sandboxModelActivator$activate$2.L$0 = obj;
        return sandboxModelActivator$activate$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        String str = this.$otaId;
        int i10 = this.$version;
        String str2 = this.$path;
        String str3 = this.$installer;
        try {
            ModelCacheImpl modelCacheImpl = s.f3120b;
            if (modelCacheImpl != null) {
                modelCacheImpl.switchVersion(str, i10, str2, str3);
            } else {
                ModelPathStore.INSTANCE.onDownloadComplete(str, str2, "");
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((SandboxModelActivator$activate$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
