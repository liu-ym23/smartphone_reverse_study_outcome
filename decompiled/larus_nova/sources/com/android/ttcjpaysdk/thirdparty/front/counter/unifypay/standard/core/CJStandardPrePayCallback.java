package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.core;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPrePayProcessState;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPreProcessCode;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPreTradeConfirmParams;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J4\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/core/CJStandardPrePayCallback;", "", "onPayResult", "", "code", "", "onPrePayResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPreProcessCode;", "confirmParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPreTradeConfirmParams;", "msg", "", "preProcessState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPrePayProcessState;", "onShowLoading", "isShow", "", "isPayScene", "onStartVerify", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJStandardPrePayCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onPrePayResult$default(CJStandardPrePayCallback r100, CJUnifyPreProcessCode r101, CJUnifyPreTradeConfirmParams r102, String r103, CJUnifyPrePayProcessState r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = null;
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = null;
        L12:
            r100.onPrePayResult(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPrePayResult");
        }
    }

    void onPayResult(int r100);

    void onPrePayResult(CJUnifyPreProcessCode r100, CJUnifyPreTradeConfirmParams r101, String r102, CJUnifyPrePayProcessState r103);

    void onShowLoading(boolean r100, boolean r101);

    void onStartVerify();
}
