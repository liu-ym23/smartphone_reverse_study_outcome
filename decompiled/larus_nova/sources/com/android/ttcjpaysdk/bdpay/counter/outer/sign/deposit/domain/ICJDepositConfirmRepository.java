package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.domain;

import com.android.ttcjpaysdk.bdpay.counter.outer.sign.common.CJSignResult;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.data.model.CJCreditPayParamsQueryRequest;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.data.model.CJCreditPayParamsQueryResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/domain/ICJDepositConfirmRepository;", "", "cancelCurrentRequest", "", "clearAllCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPayParams", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/model/CJCreditPayParamsQueryResponse;", "request", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/model/CJCreditPayParamsQueryRequest;", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/model/CJCreditPayParamsQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJDepositConfirmRepository {
    void cancelCurrentRequest();

    Object clearAllCache(Continuation<? super Unit> r100);

    Object queryPayParams(CJCreditPayParamsQueryRequest r100, Continuation<? super CJSignResult<CJCreditPayParamsQueryResponse>> r101);
}
