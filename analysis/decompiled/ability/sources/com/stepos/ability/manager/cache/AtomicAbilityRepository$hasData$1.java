package com.stepos.ability.manager.cache;

import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository", f = "AtomicAbilityRepository.kt", l = {ComposerKt.compositionLocalMapKey}, m = "hasData", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$hasData$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3117a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$hasData$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3117a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.d(this);
    }
}
