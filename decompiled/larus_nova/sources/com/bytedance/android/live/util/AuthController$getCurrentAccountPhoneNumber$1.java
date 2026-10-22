package com.bytedance.android.live.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "getCurrentAccountPhoneNumber"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.util.AuthController", f = "AuthController.kt", i = {}, l = {92}, m = "getCurrentAccountPhoneNumber", n = {}, s = {})
public final class AuthController$getCurrentAccountPhoneNumber$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthController this$0;

    public AuthController$getCurrentAccountPhoneNumber$1(AuthController r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
