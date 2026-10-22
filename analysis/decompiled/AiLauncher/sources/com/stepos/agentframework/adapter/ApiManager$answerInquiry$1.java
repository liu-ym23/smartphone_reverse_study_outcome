package com.stepos.agentframework.adapter;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {708}, m = "answerInquiry", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiManager$answerInquiry$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiManager$answerInquiry$1(ApiManager apiManager, InterfaceC4014c<? super ApiManager$answerInquiry$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = apiManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, null, null, null, this);
    }
}
