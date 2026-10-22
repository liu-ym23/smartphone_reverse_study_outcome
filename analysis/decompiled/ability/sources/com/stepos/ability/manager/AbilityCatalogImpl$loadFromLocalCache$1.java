package com.stepos.ability.manager;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.AbilityCatalogImpl", f = "AbilityCatalogImpl.kt", l = {34, 36}, m = "loadFromLocalCache", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityCatalogImpl$loadFromLocalCache$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3103a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityCatalogImpl$loadFromLocalCache$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3103a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.b(null, this);
    }
}
