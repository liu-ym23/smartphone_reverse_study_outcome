package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyPayTypeParams;", "", "getBindCardCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodBindCardCallback;", "getBindCardInfo", "Lorg/json/JSONObject;", "getFromScene", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;", "getHostInfo", "getNextPage", "", "getPayNewCardReconfirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/PayNewCardReconfirmInfo;", "getSecondaryConfirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "getSource", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyPayTypeParams {
    ICJPayPaymentMethodService.IPaymentMethodBindCardCallback getBindCardCallback();

    JSONObject getBindCardInfo();

    ICJPayPaymentMethodService.FromScene getFromScene();

    JSONObject getHostInfo();

    String getNextPage();

    PayNewCardReconfirmInfo getPayNewCardReconfirmInfo();

    CJPayNoPwdPayInfo getSecondaryConfirmInfo();

    String getSource();
}
