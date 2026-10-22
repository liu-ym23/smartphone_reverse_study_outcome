package com.stepos.ability.manager.discovery;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor", f = "AbilityDiscoveryProcessor.kt", l = {87}, m = "performUpload", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityDiscoveryProcessor$performUpload$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3140a;
    public final /* synthetic */ a b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityDiscoveryProcessor$performUpload$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3140a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.e(null, this);
    }
}
