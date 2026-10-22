package com.android.ttcjpaysdk.thirdparty.counter.model;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.counter.activity.CJPayCheckoutCounterActivity;
import com.android.ttcjpaysdk.thirdparty.counter.data.FastPaySignBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.QueryPromotionAfterPayInfo;
import com.android.ttcjpaysdk.thirdparty.counter.utils.CJPayCheckoutCounterParamsBuildUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class BdPayCounterModel extends MvpModel {
    public static final String QUERY_BUY_AGAIN_AREA_INFO_METHOD = "tp.promotion_put.QueryPaySuccessPagePutResource";
    public static final String QUERY_PUT_PROMOTION_AREA_INFO_METHOD = "bytepay.promotion_put.query_put_promotion_for_cashier_pay_success";

    public BdPayCounterModel() {
    }

    public <T> void fastPaySign(ICJPayNetWorkCallback<FastPaySignBean> r100) {
        if (CJPayHostInfo.applicationContext != null) goto L5;
        return;
    L5:
        if (CJPayCheckoutCounterActivity.checkoutResponseBean == null) goto L26;
        HashMap r101 = new HashMap();
        r101.put(e.f25671s, "cashdesk.sdk.user.open_one_key_pay");     // Catch: Exception -> L10
        r101.put("process_info", CJPayCheckoutCounterActivity.checkoutResponseBean.process_info.toJson());     // Catch: Exception -> L10
        r101.put(b.B0, CJPayCheckoutCounterActivity.checkoutResponseBean.trade_info.trade_no);     // Catch: Exception -> L10
        r101.put(DyVerifyReqConstants.Key.RISK_INFO, CJPayCheckoutCounterParamsBuildUtils.getHttpRiskInfo(CJPayHostInfo.applicationContext, false, CJPayCheckoutCounterActivity.hostInfo).toJson());     // Catch: Exception -> L10
    L12:
        CJPayHostInfo r102 = CJPayCheckoutCounterActivity.hostInfo;
        String r103 = "";
        if (r102 == null) goto L15;
        String r104 = r102.merchantId;
    L16:
        if (r102 == null) goto L18;
        r103 = r102.appId;
    L18:
        if (r102 == null) goto L20;
        HashMap<String, String> r105 = r102.extraHeaderMap;
    L21:
        String r106 = CJPayParamsUtils.getHttpUrl("bytepay.cashdesk.open_one_key_pay", CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r106, CJPayParamsUtils.getHttpData("bytepay.cashdesk.open_one_key_pay", new JSONObject(r101).toString(), r103, r104), CJPayParamsUtils.getNetHeaderData(r106, "bytepay.cashdesk.open_one_key_pay", r105), r100));
        return;
    L20:
        r105 = null;
        goto L21
    L15:
        r104 = "";
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BdPayCounterModel#fastPaySign", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BdPayCounterModel#fastPaySign", e);
        goto L12
    }

    public void queryPromotionAfterPayInfo(HashMap<String, String> r100, ICJPayNetWorkCallback<QueryPromotionAfterPayInfo> r101) {
        ICJPayIntegratedCounterService r102 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r102.getIntegratedCounterUrl("gateway-u", QUERY_PUT_PROMOTION_AREA_INFO_METHOD);
        addRequest(CJPayNetworkManager.postForm(r103, r102.getIntegratedCounterHttpData(r100, QUERY_PUT_PROMOTION_AREA_INFO_METHOD, null, null), r102.getIntegratedCounterHttpHeader(r103, QUERY_PUT_PROMOTION_AREA_INFO_METHOD), r101));
    }

    public <T> void amountUpgrade(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101, ICJPayNetWorkCallback<T> r102) {
        if (CJPayHostInfo.applicationContext == null) goto L24;
        if (r100 == null) goto L25;
        HashMap r103 = new HashMap();
        r103.put(e.f25671s, "cashdesk.sdk.upgrade_no_password");     // Catch: Exception -> L9
        r103.put("process_info", r100.process_info.toJson());     // Catch: Exception -> L9
        r103.put(b.B0, r100.trade_info.trade_no);     // Catch: Exception -> L9
        r103.put(DyVerifyReqConstants.Key.RISK_INFO, CJPayCheckoutCounterParamsBuildUtils.getHttpRiskInfo(CJPayHostInfo.applicationContext, false, r101).toJson());     // Catch: Exception -> L9
    L11:
        String r104 = "";
        if (r101 == null) goto L14;
        String r105 = r101.merchantId;
    L15:
        if (r101 == null) goto L17;
        r104 = r101.appId;
    L17:
        if (r101 == null) goto L19;
        HashMap<String, String> r106 = r101.extraHeaderMap;
    L20:
        String r107 = CJPayParamsUtils.getHttpUrl("bytepay.cashdesk.modify_no_password", CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r107, CJPayParamsUtils.getHttpData("bytepay.cashdesk.modify_no_password", new JSONObject(r103).toString(), r104, r105), CJPayParamsUtils.getNetHeaderData(r107, "bytepay.cashdesk.modify_no_password", r106), r102));
        return;
    L19:
        r106 = null;
        goto L20
    L14:
        r105 = "";
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BdPayCounterModel#amountUpgrade", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BdPayCounterModel#amountUpgrade", e);
        goto L11
    L25:
        return;
    }

    public <T> void openPayWithoutPwd(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101, ICJPayNetWorkCallback<T> r102) {
        if (CJPayHostInfo.applicationContext == null) goto L24;
        if (r100 == null) goto L25;
        HashMap r103 = new HashMap();
        r103.put(e.f25671s, "cashdesk.sdk.open_no_password");     // Catch: Exception -> L9
        r103.put("process_info", r100.process_info.toJson());     // Catch: Exception -> L9
        r103.put(b.B0, r100.trade_info.trade_no);     // Catch: Exception -> L9
        r103.put(DyVerifyReqConstants.Key.RISK_INFO, CJPayCheckoutCounterParamsBuildUtils.getHttpRiskInfo(CJPayHostInfo.applicationContext, false, r101).toJson());     // Catch: Exception -> L9
    L11:
        String r104 = "";
        if (r101 == null) goto L14;
        String r105 = r101.merchantId;
    L15:
        if (r101 == null) goto L17;
        r104 = r101.appId;
    L17:
        if (r101 == null) goto L19;
        HashMap<String, String> r106 = r101.extraHeaderMap;
    L20:
        String r107 = CJPayParamsUtils.getHttpUrl("bytepay.cashdesk.open_no_password", CJPayParamsUtils.HostAPI.BDPAY);
        addRequest(CJPayNetworkManager.postForm(r107, CJPayParamsUtils.getHttpData("bytepay.cashdesk.open_no_password", new JSONObject(r103).toString(), r104, r105), CJPayParamsUtils.getNetHeaderData(r107, "bytepay.cashdesk.open_no_password", r106), r102));
        return;
    L19:
        r106 = null;
        goto L20
    L14:
        r105 = "";
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BdPayCounterModel#openPayWithoutPwd", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BdPayCounterModel#openPayWithoutPwd", e);
        goto L11
    L25:
        return;
    }
}
