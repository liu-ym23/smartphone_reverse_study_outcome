package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.ResultPageInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeErrorBean;
import com.android.ttcjpaysdk.integrated.counter.data.TradeQueryBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.FeGuideInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeQueryResponseBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0013J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeQueryDataBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeQueryResp;", "()V", "byte_pay_result_info", "Lcom/android/ttcjpaysdk/integrated/counter/data/TradeQueryBean$BytePayResultInfo;", "code", "", "common_result_info", "fe_guide_info", "Lcom/android/ttcjpaysdk/thirdparty/counter/data/FeGuideInfo;", "msg", "no_show_result_page", "payment_desc_infos", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeQueryResponseBean$PayInfo;", "Lkotlin/collections/ArrayList;", "recommend_open_msg", "recommend_open_status", "", "result_page_info", "Lcom/android/ttcjpaysdk/base/ui/data/ResultPageInfo;", "trade_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeInfo;", "unify_cashier_query_result", "getCode", "getData", "getError", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;", "getLogId", "getRecommendOpenMsg", "getRecommendOpenStatus", "getTradeStatus", "isSuccess", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeQueryDataBean implements CJPayObject, ICJUnifyPayTradeQueryResp {
    public TradeQueryBean.BytePayResultInfo byte_pay_result_info;
    public String code;
    public String common_result_info;
    public FeGuideInfo fe_guide_info;
    public String msg;
    public String no_show_result_page;
    public ArrayList<CJPayTradeQueryResponseBean.PayInfo> payment_desc_infos;
    public String recommend_open_msg;
    public boolean recommend_open_status;
    public ResultPageInfo result_page_info;
    public CJPayTradeInfo trade_info;
    public String unify_cashier_query_result;

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public CJUnifyPayTradeQueryDataBean getData() {
        return this;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getLogId() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public CounterTradeErrorBean getError() {
        CounterTradeErrorBean r100 = new CounterTradeErrorBean();
        r100.msg = this.msg;
        return r100;
    }

    public final String getRecommendOpenMsg() {
        String r100 = this.unify_cashier_query_result;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L23;
        String r102 = this.recommend_open_msg;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L23:
        String r103 = new JSONObject(new JSONObject(r100).optString("response")).optString("recommend_open_msg");     // Catch: Exception -> L20
        if (r103 != null) goto L26;
        return "";
    L26:
        return r103;
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyPayTradeQueryDataBean#getRecommendOpenMsg", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJUnifyPayTradeQueryDataBean#getRecommendOpenMsg", e);
        return "";
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean getRecommendOpenStatus() {
        String r100 = this.unify_cashier_query_result;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        if (new JSONObject(new JSONObject(r100).optString("response")).optBoolean("recommend_open_status") != true) goto L20;
        return true;
    L20:
        return false;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyPayTradeQueryDataBean#getRecommendOpenStatus", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJUnifyPayTradeQueryDataBean#getRecommendOpenStatus", e);
        return false;
    L11:
        return this.recommend_open_status;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getTradeStatus() {
        CJPayTradeInfo r100 = this.trade_info;
        if (r100 == null) goto L5;
        String r101 = r100.trade_status;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public boolean isSuccess() {
        return Intrinsics.areEqual("CD000000", this.code);
    }

    public CJUnifyPayTradeQueryDataBean() {
        this.payment_desc_infos = new ArrayList();
        this.byte_pay_result_info = new TradeQueryBean.BytePayResultInfo();
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getCode() {
        return this.code;
    }
}
