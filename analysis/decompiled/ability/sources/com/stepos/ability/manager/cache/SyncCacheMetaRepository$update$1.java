package com.stepos.ability.manager.cache;

import S7.k;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.manager.cache.SyncCacheMetaRepository", f = "SyncCacheMetaRepository.kt", l = {37, 39}, m = "update", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SyncCacheMetaRepository$update$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public k f3131a;
    public SyncCacheMetaEntity b;
    public /* synthetic */ Object c;
    public final /* synthetic */ c d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncCacheMetaRepository$update$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.b(null, this);
    }
}
