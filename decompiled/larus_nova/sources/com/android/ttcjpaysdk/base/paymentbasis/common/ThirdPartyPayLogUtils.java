package com.android.ttcjpaysdk.base.paymentbasis.common;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/common/ThirdPartyPayLogUtils;", "", "()V", "Companion", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThirdPartyPayLogUtils {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/common/ThirdPartyPayLogUtils$Companion;", "", "()V", "monitorPayFailure", "", "payType", "", "errorInfo", "uploadPayResult", e.f25671s, "resMsg", "mOnPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void monitorPayFailure(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "payType");
            Intrinsics.checkNotNullParameter(r101, "errorInfo");
            JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
            r102.put("pay_type", r100);     // Catch: Exception -> L5
            r102.put("failure_reason", r101);     // Catch: Exception -> L5
            CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_thirdpartypay_failure_reason", r102);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("ThirdPartyPayLogUtils#monitorPayFailure", e);
            CJBasicCommonUtils.logCatch("CJCatch", "ThirdPartyPayLogUtils#monitorPayFailure", e);
        }

        public final void uploadPayResult(String r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
            Intrinsics.checkNotNullParameter(r100, e.f25671s);
            Intrinsics.checkNotNullParameter(r101, "resMsg");
            JSONObject r103 = new JSONObject();
            r103.put(e.f25671s, r100);     // Catch: Exception -> L13
            r103.put("error_code", 1);     // Catch: Exception -> L13
            r103.put("error_message", r101);     // Catch: Exception -> L13
            r103.put("is_install", 1);     // Catch: Exception -> L13
            r103.put("other_sdk_version", "");     // Catch: Exception -> L13
            JSONObject r104 = CJPayCallBackCenter.getInstance().getTrackInfo();     // Catch: Exception -> L13
            if (r104 == null) goto L15;
            Iterator<String> r105 = r104.keys();     // Catch: Exception -> L13
        L7:
            if (r105.hasNext() == false) goto L15;
            String r106 = r105.next();     // Catch: Exception -> L13
            String r107 = r104.optString(r106);     // Catch: Exception -> L13
            if (r107 != null) goto L11;
            r107 = "";
        L11:
            r103.put(r106, r107);     // Catch: Exception -> L13
        L15:
            if (r102 == null) goto L24;
            r102.onEvent("wallet_pay_callback", r103.toString());
            return;
        L24:
            return;
        L13:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("ThirdPartyPayLogUtils#uploadPayResult", e);
            CJBasicCommonUtils.logCatch("CJCatch", "ThirdPartyPayLogUtils#uploadPayResult", e);
            goto L15
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ThirdPartyPayLogUtils() {
    }
}
