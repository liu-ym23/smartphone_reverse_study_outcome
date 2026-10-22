package com.android.ttcjpaysdk.bdpay.paymentmethod.model;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJ2\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/model/PaymentMethodModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "()V", "request", "", ExifInterface.GPS_DIRECTION_TRUE, "methodName", "", "param", "Lorg/json/JSONObject;", "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "riskInfo", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentMethodModel extends MvpModel {
    public PaymentMethodModel() {
    }

    public final <T> void request(String r100, JSONObject r101, ICJPayNetWorkCallback<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = CJPayParamsUtils.getHttpUrl(r100, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo.Companion r104 = CJPayHostInfo.Companion;
        ICJPayPaymentMethodService.OutParams r105 = ShareData.INSTANCE.getOutParams();
        if (r105 == null) goto L5;
        JSONObject r106 = r105.getHostInfo();
    L6:
        CJPayHostInfo r107 = r104.toBean(r106);
        addRequest(CJPayNetworkManager.postForm(r103, CJPayParamsUtils.getHttpData(r100, r101.toString(), r107.appId, r107.merchantId), CJPayParamsUtils.getNetHeaderData(r103, r100, r107.extraHeaderMap), r102));
        return;
    L5:
        r106 = null;
        goto L6
    }

    public final <T> void request(String r100, JSONObject r101, String r102, ICJPayNetWorkCallback<T> r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r102, "riskInfo");
        Intrinsics.checkNotNullParameter(r103, "callback");
        String r104 = CJPayParamsUtils.getHttpUrl(r100, CJPayParamsUtils.HostAPI.BDPAY);
        CJPayHostInfo.Companion r105 = CJPayHostInfo.Companion;
        ICJPayPaymentMethodService.OutParams r106 = ShareData.INSTANCE.getOutParams();
        if (r106 == null) goto L5;
        JSONObject r107 = r106.getHostInfo();
    L6:
        CJPayHostInfo r108 = r105.toBean(r107);
        Map<String, String> r109 = CJPayParamsUtils.getHttpData(r100, r101.toString(), r108.appId, r108.merchantId);
        r109.put(DyVerifyReqConstants.Key.RISK_INFO, r102);
        addRequest(CJPayNetworkManager.postForm(r104, r109, CJPayParamsUtils.getNetHeaderData(r104, r100, r108.extraHeaderMap), r103));
        return;
    L5:
        r107 = null;
        goto L6
    }
}
