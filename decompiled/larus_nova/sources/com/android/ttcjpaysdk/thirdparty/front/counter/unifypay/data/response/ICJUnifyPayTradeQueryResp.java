package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeErrorBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeQueryResp;", "", "getCode", "", "getData", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeQueryDataBean;", "getError", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;", "getLogId", "getTradeStatus", "isSuccess", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJUnifyPayTradeQueryResp {
    String getCode();

    CJUnifyPayTradeQueryDataBean getData();

    CounterTradeErrorBean getError();

    String getLogId();

    String getTradeStatus();

    boolean isSuccess();
}
