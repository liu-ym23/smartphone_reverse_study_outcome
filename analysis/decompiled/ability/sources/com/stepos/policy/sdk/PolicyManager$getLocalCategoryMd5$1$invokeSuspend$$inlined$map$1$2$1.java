package com.stepos.policy.sdk;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.policy.sdk.PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2", f = "PolicyManager.kt", l = {223}, m = "emit")
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3885a;
    public int b;
    public final /* synthetic */ d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getLocalCategoryMd5$1$invokeSuspend$$inlined$map$1$2$1(d dVar, H7.c cVar) {
        super(cVar);
        this.c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3885a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
