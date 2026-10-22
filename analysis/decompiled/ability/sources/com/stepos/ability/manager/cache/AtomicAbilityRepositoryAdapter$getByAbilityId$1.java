package com.stepos.ability.manager.cache;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter", f = "AtomicAbilityRepositoryAdapter.kt", l = {20}, m = "getByAbilityId", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepositoryAdapter$getByAbilityId$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3128a;
    public final /* synthetic */ b b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepositoryAdapter$getByAbilityId$1(b bVar, H7.c cVar) {
        super(cVar);
        this.b = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3128a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.getByAbilityId(0, this);
    }
}
