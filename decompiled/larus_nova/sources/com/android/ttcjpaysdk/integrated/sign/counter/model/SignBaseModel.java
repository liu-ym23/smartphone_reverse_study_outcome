package com.android.ttcjpaysdk.integrated.sign.counter.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.network.ICJPayParserCallback;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.android.ttcjpaysdk.integrated.sign.counter.data.BizContentRequestParams;
import com.android.ttcjpaysdk.integrated.sign.counter.data.RiskInfo;
import com.android.ttcjpaysdk.integrated.sign.counter.provider.IntegratedSignCounterProvider;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JH\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J8\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/model/SignBaseModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "getHostHttpUrl", "", "path", "getHttpRiskInfo", "signConfirm", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "parserCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayParserCallback;", "signCreate", "signQuery", "", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignBaseModel extends MvpModel {
    private final String getHttpRiskInfo() {
        RiskInfo r100 = new RiskInfo();
        RiskInfo.RiskStrInfo r101 = new RiskInfo.RiskStrInfo();
        r100.identity_token = "";
        CJPayHostInfo r102 = IntegratedSignCounterProvider.hostInfo;
        if (r102 == null) goto L5;
        Map<String, String> r103 = r102.getRiskInfoParams();
    L6:
        r101.riskInfoParamsMap = r103;
        r100.risk_str = r101;
        return r101.toJson().toString();
    L5:
        r103 = null;
        goto L6
    }

    public SignBaseModel() {
    }

    private final String getHostHttpUrl(String r100) {
        String r101 = CJPayParamsUtils.getIntegratedServerDomain() + r100;
        if (TextUtils.isEmpty(CJPaySettingsManager.getInstance().getHostDomain()) == false) goto L5;
        return r101;
    L5:
        return "https://" + CJPaySettingsManager.getInstance().getHostDomain() + r100;
    }

    public final <T> void signCreate(ICJPayNetWorkCallback<T> r100, ICJPayParserCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        BizContentRequestParams r102 = new BizContentRequestParams();
        CJPayHostInfo r103 = IntegratedSignCounterProvider.hostInfo;
        HashMap<String, String> r104 = null;
        if (r103 == null) goto L5;
        Map<String, String> r105 = r103.getRequestParams();
    L6:
        r102.setParams(r105);
        String r106 = getHostHttpUrl("/gateway-cashier2/tp/cashier/sign_create");
        String r107 = r102.toJsonString();
        CJPayHostInfo r108 = IntegratedSignCounterProvider.hostInfo;
        if (r108 == null) goto L9;
        String r109 = r108.appId;
    L10:
        if (r108 == null) goto L12;
        String r110 = r108.merchantId;
    L13:
        Map<String, String> r111 = CJPayParamsUtils.getHttpData("tp.cashier.sign_create", r107, r109, r110);
        r111.put(DyVerifyReqConstants.Key.RISK_INFO, getHttpRiskInfo());
        r111.put("channel_support_scene", "ALI_APP,ALI_H5,WX_APP,WX_H5");
        CJPayHostInfo r112 = IntegratedSignCounterProvider.hostInfo;
        if (r112 == null) goto L16;
        r104 = r112.extraHeaderMap;
    L16:
        addRequest(CJPayNetworkManager.postForm(r106, r111, CJPayParamsUtils.getNetHeaderData(r106, "tp.cashier.sign_create", r104), r100, r101));
        return;
    L12:
        r110 = null;
        goto L13
    L9:
        r109 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public final <T> void signConfirm(HashMap<String, String> r100, ICJPayNetWorkCallback<T> r101, ICJPayParserCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r103 = new JSONObject();
        r103.put("ptcode", r100.get("ptcode"));
        JSONObject r104 = new JSONObject();
        r104.put(CJDyPayResult.EXT_K_RETURN_URL, r100.get(CJDyPayResult.EXT_K_RETURN_URL));
        Unit r105 = Unit.INSTANCE;
        r103.put("ptcode_info", r104);
        String r106 = getHostHttpUrl("/gateway-cashier2/tp/cashier/sign_confirm");
        String r107 = r103.toString();
        CJPayHostInfo r108 = IntegratedSignCounterProvider.hostInfo;
        HashMap<String, String> r109 = null;
        if (r108 == null) goto L5;
        String r110 = r108.appId;
    L6:
        if (r108 == null) goto L8;
        String r111 = r108.merchantId;
    L9:
        Map<String, String> r112 = CJPayParamsUtils.getHttpData("tp.cashier.sign_confirm", r107, r110, r111);
        r112.put("process", r100.get("process"));
        r112.put("channel_support_scene", "ALI_APP,ALI_H5,WX_APP,WX_H5");
        r112.put(DyVerifyReqConstants.Key.RISK_INFO, getHttpRiskInfo());
        CJPayHostInfo r113 = IntegratedSignCounterProvider.hostInfo;
        if (r113 == null) goto L12;
        r109 = r113.extraHeaderMap;
    L12:
        addRequest(CJPayNetworkManager.postForm(r106, r112, CJPayParamsUtils.getNetHeaderData(r106, "tp.cashier.sign_confirm", r109), r101, r102));
        return;
    L8:
        r111 = null;
        goto L9
    L5:
        r110 = null;
        goto L6
    }

    public final <T> void signQuery(Map<String, String> r100, ICJPayNetWorkCallback<T> r101, ICJPayParserCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r103 = getHostHttpUrl("/gateway-cashier2/tp/cashier/sign_query");
        String r104 = new JSONObject().toString();
        CJPayHostInfo r105 = IntegratedSignCounterProvider.hostInfo;
        HashMap<String, String> r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.appId;
    L6:
        if (r105 == null) goto L8;
        String r108 = r105.merchantId;
    L9:
        Map<String, String> r109 = CJPayParamsUtils.getHttpData("tp.cashier.sign_query", r104, r107, r108);
        r109.put("process", r100.get("process"));
        r109.put(DyVerifyReqConstants.Key.RISK_INFO, getHttpRiskInfo());
        CJPayHostInfo r110 = IntegratedSignCounterProvider.hostInfo;
        if (r110 == null) goto L12;
        r106 = r110.extraHeaderMap;
    L12:
        addRequest(CJPayNetworkManager.postForm(r103, r109, CJPayParamsUtils.getNetHeaderData(r103, "tp.cashier.sign_query", r106), r101, r102));
        return;
    L8:
        r108 = null;
        goto L9
    L5:
        r107 = null;
        goto L6
    }
}
