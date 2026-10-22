package com.stepos.ability.manager.cache;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.InterfaceC2108a;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository", f = "AtomicAbilityRepository.kt", l = {225, 59}, m = "saveFullScan", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$saveFullScan$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public List f3122a;
    public InterfaceC2108a b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$saveFullScan$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.g(null, this);
    }
}
