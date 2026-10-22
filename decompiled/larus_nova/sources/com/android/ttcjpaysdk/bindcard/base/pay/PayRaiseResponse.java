package com.android.ttcjpaysdk.bindcard.base.pay;

import android.app.Activity;
import com.android.ttcjpaysdk.bindcard.base.applog.PayNewCardLogger;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNewCardBean;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/pay/PayRaiseResponse;", "Lcom/android/ttcjpaysdk/bindcard/base/pay/IPayNewCardBaseResponse;", "activity", "Landroid/app/Activity;", "logger", "Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;)V", "dealWithResponse", "", "bean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNewCardBean;", "tradeQuery", "Lorg/json/JSONObject;", "memberBizOrderNo", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayRaiseResponse extends IPayNewCardBaseResponse {
    public PayRaiseResponse(Activity r100, PayNewCardLogger r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.pay.IPayNewCardBaseResponse
    public void dealWithResponse(CJPayNewCardBean r100, JSONObject r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        if (Intrinsics.areEqual(r100.button_info.button_status, "1") == false) goto L5;
        IPayNewCardBaseResponse.processButtonInfo$default(this, getActivity(), r100.button_info, r110, false, 8, null);
    L5:
        CJLogger.d(getTAG(), "pay new card response, handle PayRaiseResponse");
    }
}
