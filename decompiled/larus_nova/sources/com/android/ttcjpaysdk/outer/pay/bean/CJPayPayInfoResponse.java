package com.android.ttcjpaysdk.outer.pay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.VoucherRetainInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRecommendPopup;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/bean/CJPayPayInfoResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "code", "", "exts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "merchant_info", "Lcom/android/ttcjpaysdk/outer/pay/bean/CJPayMerchantInfo;", "msg", "payee_explanation", "process_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayProcessInfo;", "promotion_put_info", "retain_info_v2", "Lorg/json/JSONObject;", "sign_information", "Lcom/android/ttcjpaysdk/outer/pay/bean/CJPaySignInformation;", "superimposed_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "trace_params", "trade_info", "Lcom/android/ttcjpaysdk/outer/pay/bean/CJPayTradeInfo;", "getLoginStyle", "getThemeId", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPayInfoResponse implements CJPayObject, Serializable {
    public String code;
    public HashMap<String, String> exts;
    public CJPayMerchantInfo merchant_info;
    public String msg;
    public String payee_explanation;
    public CJPayProcessInfo process_info;
    public String promotion_put_info;
    public JSONObject retain_info_v2;
    public CJPaySignInformation sign_information;
    public VoucherRetainInfo superimposed_retain_info;
    public JSONObject trace_params;
    public CJPayTradeInfo trade_info;

    public final String getLoginStyle() {
        String r100 = this.exts.get(CJPayRecommendPopup.POPUP_TYPE_LOGIN_STYLE);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getThemeId() {
        String r100 = this.exts.get("theme_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public CJPayPayInfoResponse() {
        this.code = "";
        this.msg = "";
        this.promotion_put_info = "";
        this.payee_explanation = "";
        this.exts = new HashMap();
    }
}
