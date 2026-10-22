package com.stepos.ability.permission.cache;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.permission.cache.RefreshScheduler", f = "RefreshScheduler.kt", l = {251}, m = "runAuthCardShots", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RefreshScheduler$runAuthCardShots$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f3211a;
    public /* synthetic */ Object b;
    public final /* synthetic */ c c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshScheduler$runAuthCardShots$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return c.a(this.c, this);
    }
}
