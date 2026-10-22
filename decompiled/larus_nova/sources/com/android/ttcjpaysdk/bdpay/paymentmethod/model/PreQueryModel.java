package com.android.ttcjpaysdk.bdpay.paymentmethod.model;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J*\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/model/PreQueryModel;", "", "()V", "getProcessInfo", "Lorg/json/JSONObject;", "queryPayType", "", "creditPayActivateStatus", "", "topAssetList", "Lorg/json/JSONArray;", "onResult", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IQueryPayTypeResultCallback;", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreQueryModel {
    public PreQueryModel() {
    }

    private final JSONObject getProcessInfo() {
        JSONObject r100 = new JSONObject();
        ICJPayPaymentMethodService.OutParams r101 = ShareData.INSTANCE.getOutParams();
        if (r101 == null) goto L5;
        JSONObject r102 = r101.getProcessInfo();
    L6:
        CJPayProcessInfo r103 = (CJPayProcessInfo) CJPayJsonParser.fromJson(r102, CJPayProcessInfo.class);
        if (r103 == null) goto L9;
        KtSafeMethodExtensionKt.safePut(r100, CrashHianalyticsData.PROCESS_ID, r103.process_id);
        KtSafeMethodExtensionKt.safePut(r100, "create_time", Long.valueOf(r103.create_time));
        KtSafeMethodExtensionKt.safePut(r100, "process_info", r103.process_info);
    L9:
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final void queryPayType(String r100, JSONArray r101, final ICJPayPaymentMethodService.IQueryPayTypeResultCallback r102) {
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "trade_scene", "trade_create");
        KtSafeMethodExtensionKt.safePut(r103, "support_asset_standard", "1");
        if (r100 != null) goto L5;
    L13:
        if (r101 == null) goto L19;
        KtSafeMethodExtensionKt.safePut(r103, "top_asset_meta_info_list", r101);
        KtSafeMethodExtensionKt.safePut(r103, "use_new_asset_scene", "new_card_pay");
        if (r101.length() != 1) goto L17;
        String r104 = "close";
    L18:
        KtSafeMethodExtensionKt.safePut(r103, "user_combine_pay_status", r104);
        goto L19
    L17:
        r104 = "open";
    L19:
        JSONObject r105 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r105, "process_info", getProcessInfo());
        KtSafeMethodExtensionKt.safePut(r105, "pre_trade_params", r103.toString());
        new PaymentMethodModel().request("bytepay.cashdesk.query_pay_type", r105, new AnonymousClass1(r102));
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        String r107 = r100;
    L11:
        if (r107 == null) goto L13;
        KtSafeMethodExtensionKt.safePut(r103, "yuefu_pay_status", r100);
        goto L13
    L10:
        r107 = null;
        goto L11
    L7:
        r106 = false;
        goto L8
    }

    public static /* synthetic */ void queryPayType$default(PreQueryModel r100, String r101, JSONArray r102, ICJPayPaymentMethodService.IQueryPayTypeResultCallback r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = null;
    L11:
        r100.queryPayType(r101, r102, r103);
    }
}
