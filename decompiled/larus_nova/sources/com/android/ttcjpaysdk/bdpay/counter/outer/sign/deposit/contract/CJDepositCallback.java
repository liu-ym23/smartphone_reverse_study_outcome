package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.contract;

import com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state.CJDepositResultCode;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositCallback;", "", "onDepositClose", "", "code", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositResultCode;", "data", "", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJDepositCallback {
    void onDepositClose(CJDepositResultCode r100, Map<String, String> r101);
}
