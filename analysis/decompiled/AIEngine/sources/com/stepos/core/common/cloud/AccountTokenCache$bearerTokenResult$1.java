package com.stepos.core.common.cloud;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.common.cloud.AccountTokenCache", f = "AccountTokenCache.kt", l = {242, 111}, m = "bearerTokenResult$common_release")
/* loaded from: classes.dex */
public final class AccountTokenCache$bearerTokenResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountTokenCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountTokenCache$bearerTokenResult$1(AccountTokenCache accountTokenCache, qb.b<? super AccountTokenCache$bearerTokenResult$1> bVar) {
        super(bVar);
        this.this$0 = accountTokenCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bearerTokenResult$common_release(null, this);
    }
}
