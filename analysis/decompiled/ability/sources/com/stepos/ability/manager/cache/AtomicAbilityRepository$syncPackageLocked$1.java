package com.stepos.ability.manager.cache;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository", f = "AtomicAbilityRepository.kt", l = {211, 215, 216}, m = "syncPackageLocked", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$syncPackageLocked$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3126a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$syncPackageLocked$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return a.a(this.c, null, this);
    }
}
