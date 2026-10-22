package com.stepos.ability.manager.cache;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$IntRef;
import w9.InterfaceC2108a;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository", f = "AtomicAbilityRepository.kt", l = {225, 159, 162}, m = "mergeCloudAbilities", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$mergeCloudAbilities$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public List f3118a;
    public Ref$IntRef b;
    public Ref$IntRef c;
    public Ref$IntRef d;
    public InterfaceC2108a e;
    public int f;
    public int g;
    public /* synthetic */ Object h;
    public final /* synthetic */ a i;

    /* renamed from: j, reason: collision with root package name */
    public int f3119j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$mergeCloudAbilities$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.i = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.f3119j |= Integer.MIN_VALUE;
        return this.i.e(null, this);
    }
}
