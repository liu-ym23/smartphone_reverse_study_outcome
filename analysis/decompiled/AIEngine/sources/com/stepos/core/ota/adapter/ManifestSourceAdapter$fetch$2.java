package com.stepos.core.ota.adapter;

import com.stepos.core.ota.domain.model.ModelManifest;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ManifestSourceAdapter$fetch$2", f = "ManifestSourceAdapter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ManifestSourceAdapter$fetch$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends List<? extends ModelManifest>>>, Object> {
    final /* synthetic */ List<String> $otaIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ManifestSourceAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManifestSourceAdapter$fetch$2(ManifestSourceAdapter manifestSourceAdapter, List<String> list, b<? super ManifestSourceAdapter$fetch$2> bVar) {
        super(2, bVar);
        this.this$0 = manifestSourceAdapter;
        this.$otaIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ManifestSourceAdapter$fetch$2 manifestSourceAdapter$fetch$2 = new ManifestSourceAdapter$fetch$2(this.this$0, this.$otaIds, bVar);
        manifestSourceAdapter$fetch$2.L$0 = obj;
        return manifestSourceAdapter$fetch$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends List<? extends ModelManifest>>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<? extends List<ModelManifest>>>) bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        ManifestSourceAdapter manifestSourceAdapter = this.this$0;
        List<String> list = this.$otaIds;
        try {
            RemoteModelsRepository.fetch$default(manifestSourceAdapter.context, kotlin.collections.a.z0(list, "|", null, null, null, 62), false, 4, null);
            objA = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ModelManifest modelManifestCached = manifestSourceAdapter.cached((String) it.next());
                if (modelManifestCached != null) {
                    objA.add(modelManifestCached);
                }
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<? extends List<ModelManifest>>> bVar) {
        return ((ManifestSourceAdapter$fetch$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
