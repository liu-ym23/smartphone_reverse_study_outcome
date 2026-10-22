package com.android.ttcjpaysdk.bdpay.sign.model;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bdpay.sign.SignProvider;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J:\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/model/SignModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "getHttpRiskInfo", "", "request", "", ExifInterface.GPS_DIRECTION_TRUE, "methodName", "param", "Lorg/json/JSONObject;", "appId", "merchantId", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignModel extends MvpModel {
    private final String getHttpRiskInfo() {
        CJPayHostInfo r100 = SignProvider.hostInfo;
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getRiskInfoParams();
        if (r101 == null) goto L7;
        JSONObject r102 = KtSafeMethodExtensionKt.safeToJson(r101);
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    public SignModel() {
    }

    public final <T> void request(String r100, JSONObject r101, String r102, String r103, ICJPayNetWorkCallback<T> r104) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "merchantId");
        Intrinsics.checkNotNullParameter(r104, "callback");
        String r105 = CJPayParamsUtils.getHttpUrl(r100, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r106 = CJPayParamsUtils.getHttpData(r100, r101.toString(), r102, r103);
        r106.put(DyVerifyReqConstants.Key.RISK_INFO, getHttpRiskInfo());
        addRequest(CJPayNetworkManager.postForm(r105, r106, CJPayParamsUtils.getNetHeaderData(r105, r100, MapsKt.emptyMap()), r104));
    }
}
