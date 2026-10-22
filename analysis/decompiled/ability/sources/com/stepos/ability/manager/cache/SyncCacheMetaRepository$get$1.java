package com.stepos.ability.manager.cache;

import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.manager.cache.SyncCacheMetaRepository", f = "SyncCacheMetaRepository.kt", l = {28, 28}, m = "get", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SyncCacheMetaRepository$get$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SyncCacheMetaEntity f3130a;
    public /* synthetic */ Object b;
    public final /* synthetic */ c c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncCacheMetaRepository$get$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(this);
    }
}
