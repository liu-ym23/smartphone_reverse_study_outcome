package com.android.ttcjpaysdk.fastpay.model;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.network.ICJPayParserCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayBizContent;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayData;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayResponseBean;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayTradeInfo;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayTradeQueryBizContentParams;
import com.android.ttcjpaysdk.fastpay.utils.FastPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ<\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/model/FastPayModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "fetchFastPayData", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "", "", "ptcode", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "parserCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayParserCallback;", "fetchTradeQueryData", "responseBean", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastPayModel extends MvpModel {
    public FastPayModel() {
    }

    public final <T> void fetchTradeQueryData(Map<String, String> r100, FastPayResponseBean r101, ICJPayNetWorkCallback<T> r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r101 != null) goto L5;
        return;
    L5:
        FastPayData r103 = r101.data;
        String r104 = null;
        if (r103 == null) goto L10;
        FastPayTradeInfo r105 = r103.trade_info;
        if (r105 == null) goto L10;
        String r106 = r105.douyin_trade_info;
    L11:
        if (r106 != null) goto L13;
        return;
    L13:
        FastPayTradeQueryBizContentParams r107 = new FastPayTradeQueryBizContentParams();
        FastPayData r108 = r101.data;     // Catch: Exception -> L26
        if (r108 == null) goto L19;
        FastPayTradeInfo r109 = r108.trade_info;     // Catch: Exception -> L26
        if (r109 == null) goto L19;
        String r110 = r109.trade_no;     // Catch: Exception -> L26
    L20:
        r107.trade_no = r110;     // Catch: Exception -> L26
        JSONObject r111 = new JSONObject(r101.data.trade_info.douyin_trade_info);     // Catch: Exception -> L26
        JSONObject r112 = r111.optJSONObject("trade_info");     // Catch: Exception -> L26
        JSONObject r113 = r111.optJSONObject("process_info");     // Catch: Exception -> L26
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L26
        r107.byte_pay_param = r114;     // Catch: Exception -> L26
        r114.put("process_info", r113);     // Catch: Exception -> L26
        JSONObject r115 = r107.byte_pay_param;     // Catch: Exception -> L26
        if (r112 == null) goto L24;
        r104 = r112.optString(b.B0);     // Catch: Exception -> L26
    L24:
        r115.put(b.B0, r104);     // Catch: Exception -> L26
    L28:
        String r116 = FastPayParamsUtils.getHostHttpUrl("/gateway-cashier2/tp/cashier/trade_query");
        if (r100 == null) goto L32;
        String r117 = r100.get("app_id");
        if (r117 == null) goto L32;
    L33:
        addRequest(CJPayNetworkManager.postForm(r116, FastPayParamsUtils.getHttpData(CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED, r107.toJsonString(), r117), FastPayParamsUtils.getNetHeaderData(r116, CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED), r102));
        return;
    L32:
        r117 = "";
    L19:
        r110 = null;
    L26:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FastPayModel#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayModel#unknown", e);
    L10:
        r106 = null;
        goto L11
    }

    public final <T> void fetchFastPayData(Map<String, String> r100, String r101, ICJPayNetWorkCallback<T> r102, ICJPayParserCallback r103) {
        Intrinsics.checkNotNullParameter(r101, "ptcode");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FastPayBizContent r104 = new FastPayBizContent();
        r104.params = r100;
        r104.ptcode = r101;
        String r105 = FastPayParamsUtils.getHostHttpUrl("/gateway-cashier2/tp/cashier/direct_confirm");
        if (r100 == null) goto L6;
        String r106 = r100.get("app_id");
        if (r106 == null) goto L6;
    L7:
        addRequest(CJPayNetworkManager.postForm(r105, FastPayParamsUtils.getHttpData("", r104.toJsonString(), r106), FastPayParamsUtils.getNetHeaderData(r105, "tp.cashier.confirm_onekeypay"), r102, r103));
        return;
    L6:
        r106 = "";
        goto L7
    }
}
