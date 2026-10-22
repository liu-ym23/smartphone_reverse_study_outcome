package com.bytedance.ai.bridge.method.phoneNum;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow", f = "GetPhoneNumFlow.kt", i = {}, l = {257}, m = "postPhoneNumUsed", n = {}, s = {})
final class GetPhoneNumFlow$postPhoneNumUsed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetPhoneNumFlow this$0;

    public GetPhoneNumFlow$postPhoneNumUsed$1(GetPhoneNumFlow r100, Continuation<? super GetPhoneNumFlow$postPhoneNumUsed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GetPhoneNumFlow.c(this.this$0, null, this);
    }
}
