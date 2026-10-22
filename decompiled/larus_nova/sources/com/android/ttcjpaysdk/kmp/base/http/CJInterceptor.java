package com.android.ttcjpaysdk.kmp.base.http;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor;", "", "intercept", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "chain", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Chain", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CJInterceptor {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "", "request", "Lcom/android/ttcjpaysdk/kmp/base/http/CJRequest;", "proceed", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Chain {
        Object proceed(CJRequest r100, Continuation<? super CJResponse> r101);

        CJRequest request();
    }

    Object intercept(Chain r100, Continuation<? super CJResponse> r101);
}
