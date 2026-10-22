package com.android.ttcjpaysdk.thirdparty.front.counter.directbank.model;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002JF\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0013¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/directbank/model/DirectBankModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "getHttpData", "", "", e.f25671s, "bizContent", "merchantId", "appId", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "tradeQueryByVerifyFace", "", ExifInterface.GPS_DIRECTION_TRUE, "params", "Ljava/util/HashMap;", "", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DirectBankModel extends MvpModel {
    public DirectBankModel() {
    }

    private final Map<String, String> getHttpData(String r100, String r101, String r102, String r103, CJPayHostInfo r104) {
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(e.f25671s, r100);
        r105.put(SubInfo.KEY_FORMAT, "JSON");
        r105.put("charset", XML.CHARSET_UTF8);
        r105.put("version", "2.0.0");
        boolean r106 = true;
        Map<String, String> r107 = null;
        if (r103 != null) goto L5;
    L13:
        if (r102 != null) goto L15;
    L23:
        r105.put(b.C0, r101);
        r105.put("scene", "");
        CJPayRiskInfo r108 = new CJPayRiskInfo();
        CJPayRiskInfo.RiskStrInfo r109 = new CJPayRiskInfo.RiskStrInfo();
        r108.identity_token = "";
        if (r104 == null) goto L26;
        r107 = r104.getRiskInfoParams();
    L26:
        r109.riskInfoParamsMap = r107;
        r108.risk_str = r109;
        r105.put(DyVerifyReqConstants.Key.RISK_INFO, String.valueOf(r109.toJson()));
        return r105;
    L15:
        if (r102.length() > 0) goto L18;
        r106 = false;
    L18:
        if (r106 == true) goto L21;
        r102 = null;
    L21:
        if (r102 == null) goto L23;
        String r110 = (String) r105.put("merchant_id", r102);
        goto L23
    L5:
        if (r103.length() <= 0) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L13;
        String r112 = (String) r105.put("app_id", r103);
        goto L13
    L7:
        r111 = false;
        goto L8
    }

    public final <T> void tradeQueryByVerifyFace(HashMap<String, Object> r110, String r111, String r112, CJPayHostInfo r113, ICJPayNetWorkCallback<T> r114) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "merchantId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "hostInfo");
        Intrinsics.checkNotNullParameter(r114, "callback");
        ICJPayIntegratedCounterService r100 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r100.getIntegratedCounterUrl("gateway-cashier2", "tp/cashier/transfer_pay_method");
        addRequest(CJPayNetworkManager.postForm(r101, getHttpData("tp.cashier.transfer_pay_method", new JSONObject(MapsKt.toMap(r110)).toString(), r111, r112, r113), r100.getIntegratedCounterHttpHeader(r101, "tp.cashier.transfer_pay_method"), r114));
    }

    public static /* synthetic */ Map getHttpData$default(DirectBankModel r100, String r101, String r102, String r103, String r110, CJPayHostInfo r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.getHttpData(r101, r102, r103, r110, r111);
    }
}
