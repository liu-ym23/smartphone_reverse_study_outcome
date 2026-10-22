package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyEventReporter;", "", "getBusinessParams", "Lorg/json/JSONObject;", "uploadEvent", "", "eventName", "", "params", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UnifyPreVerifyEventReporter {
    JSONObject getBusinessParams();

    void uploadEvent(String r100, JSONObject r101);
}
