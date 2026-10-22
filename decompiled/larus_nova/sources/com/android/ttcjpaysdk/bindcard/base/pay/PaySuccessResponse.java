package com.android.ttcjpaysdk.bindcard.base.pay;

import android.app.Activity;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNewCardBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/pay/PaySuccessResponse;", "Lcom/android/ttcjpaysdk/bindcard/base/pay/IPayNewCardBaseResponse;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dealWithResponse", "", "bean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNewCardBean;", "tradeQuery", "Lorg/json/JSONObject;", "memberBizOrderNo", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaySuccessResponse extends IPayNewCardBaseResponse {
    public PaySuccessResponse(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, null, 2, null);
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.pay.IPayNewCardBaseResponse
    public void dealWithResponse(CJPayNewCardBean r110, JSONObject r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        if (CJPayOptimizeSwitch.Companion.get().fixPayNewCardResultPageMethodTeaParam == false) goto L5;
        JSONObject r100 = r110.getPayParams();
    L6:
        IPayNewCardBaseResponse.notifyAll$default(this, true, false, r100, r111, r112, r110.process_info, 2, null);
        return;
    L5:
        r100 = null;
        goto L6
    }
}
