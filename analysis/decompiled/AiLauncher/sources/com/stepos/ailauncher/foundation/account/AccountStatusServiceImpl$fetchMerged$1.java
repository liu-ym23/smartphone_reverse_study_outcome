package com.stepos.ailauncher.foundation.account;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.account.AccountStatusServiceImpl", f = "AccountStatusServiceImpl.kt", l = {216, 129, 226, 226}, m = "fetchMerged", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccountStatusServiceImpl$fetchMerged$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountStatusServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountStatusServiceImpl$fetchMerged$1(AccountStatusServiceImpl accountStatusServiceImpl, InterfaceC4014c<? super AccountStatusServiceImpl$fetchMerged$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = accountStatusServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
