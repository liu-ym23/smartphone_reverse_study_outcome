package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.contract;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/contract/CJUnifyPayMethodParams;", "", "isAnimEnd", "", "isExpandState", "isFrontHomeState", "isIndependentCashierShow", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyPayMethodParams {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isExpandState(CJUnifyPayMethodParams r100) {
            return true;
        }

        public static boolean isIndependentCashierShow(CJUnifyPayMethodParams r100) {
            return true;
        }
    }

    boolean isAnimEnd();

    boolean isExpandState();

    boolean isFrontHomeState();

    boolean isIndependentCashierShow();
}
