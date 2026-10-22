package com.android.ttcjpaysdk.thirdparty.counter.model;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/model/ResetPwdModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "data", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "host", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "request", "", ExifInterface.GPS_DIRECTION_TRUE, "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResetPwdModel extends MvpModel {
    private final CJPayCheckoutCounterResponseBean data;
    private final CJPayHostInfo host;

    public final <T> void request(ICJPayNetWorkCallback<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        CJPayCheckoutCounterResponseBean r101 = this.data;
        HashMap<String, String> r102 = null;
        if (r101 == null) goto L7;
        CJPayTradeInfo r103 = r101.trade_info;
        if (r103 == null) goto L7;
        String r104 = r103.trade_no;
    L8:
        if (r101 == null) goto L12;
        CJPayProcessInfo r105 = r101.process_info;
        if (r105 == null) goto L12;
        JSONObject r106 = r105.toJson();
    L13:
        JSONObject r107 = new JSONObject();
        CJPayHostInfo r108 = this.host;
        if (r108 == null) goto L16;
        Map<String, String> r109 = r108.getRiskInfoParams();
    L17:
        JSONObject r110 = new JSONObject();
        if (r109 == null) goto L20;
        JSONObject r111 = KtSafeMethodExtensionKt.safeToJson(r109);
    L21:
        KtSafeMethodExtensionKt.safePut(r110, "risk_str", String.valueOf(r111));
        JSONObject r112 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r112, b.B0, r104);
        KtSafeMethodExtensionKt.safePut(r112, DyVerifyReqConstants.Key.RISK_INFO, r110);
        KtSafeMethodExtensionKt.safePut(r112, "process_info", r106);
        KtSafeMethodExtensionKt.safePut(r112, "exts", r107.toString());
        String r113 = CJPayParamsUtils.getHttpUrl("bytepay.cashdesk.reset_pwd", CJPayParamsUtils.HostAPI.BDPAY);
        String r114 = r112.toString();
        CJPayHostInfo r115 = this.host;
        if (r115 == null) goto L24;
        String r116 = r115.appId;
    L25:
        if (r115 == null) goto L27;
        String r117 = r115.merchantId;
    L28:
        Map<String, String> r118 = CJPayParamsUtils.getHttpData("bytepay.cashdesk.reset_pwd", r114, r116, r117);
        CJPayHostInfo r119 = this.host;
        if (r119 == null) goto L31;
        r102 = r119.extraHeaderMap;
    L31:
        addRequest(CJPayNetworkManager.postForm(r113, r118, CJPayParamsUtils.getNetHeaderData(r113, "bytepay.cashdesk.reset_pwd", r102), r100));
        return;
    L27:
        r117 = null;
        goto L28
    L24:
        r116 = null;
        goto L25
    L20:
        r111 = null;
        goto L21
    L16:
        r109 = null;
    L12:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public ResetPwdModel(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101) {
        this.data = r100;
        this.host = r101;
    }
}
