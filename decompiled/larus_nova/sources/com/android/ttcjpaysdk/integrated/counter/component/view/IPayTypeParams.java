package com.android.ttcjpaysdk.integrated.counter.component.view;

import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/view/IPayTypeParams;", "", "fetchPayComponentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "getBtnDesc", "", "getDynamicBizParams", "Lorg/json/JSONObject;", "getPayAmount", "getPayParams", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayTypeParams {
    PayComponentBean fetchPayComponentBean();

    String getBtnDesc();

    JSONObject getDynamicBizParams();

    String getPayAmount();

    JSONObject getPayParams();
}
