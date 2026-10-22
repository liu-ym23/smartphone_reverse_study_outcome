package com.android.ttcjpaysdk.bindcard.base.utils;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayNewCardCallback;
import com.android.ttcjpaysdk.base.service.bean.NormalBindCardBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRiskInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.LynxBindCardCallbackBean;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/CJPayBindCardHttpUtils;", "", "()V", "getPreChargeBizContent", "Lorg/json/JSONObject;", "lynxBindCardCallbackBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/LynxBindCardCallbackBean;", "bean", "Lcom/android/ttcjpaysdk/base/service/bean/NormalBindCardBean;", "Method", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardHttpUtils {
    public static final CJPayBindCardHttpUtils INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/CJPayBindCardHttpUtils$Method;", "", "()V", "NEW_CARD_PRE_CHARGE", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Method {
        public static final Method INSTANCE = null;
        public static final String NEW_CARD_PRE_CHARGE = "bytepay.cashdesk.new_card_pre_charge";

        static {
            INSTANCE = new Method();
        }

        private Method() {
        }
    }

    static {
        INSTANCE = new CJPayBindCardHttpUtils();
    }

    private CJPayBindCardHttpUtils() {
    }

    public final JSONObject getPreChargeBizContent(LynxBindCardCallbackBean r100, NormalBindCardBean r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxBindCardCallbackBean");
        Intrinsics.checkNotNullParameter(r101, "bean");
        JSONObject r102 = new JSONObject();
        BindCardCommonInfoUtil r103 = BindCardCommonInfoUtil.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r102, "merchant_id", r103.getMerchantId());
        KtSafeMethodExtensionKt.safePut(r102, "app_id", r103.getAppId());
        CJPayRiskInfo r104 = new CJPayRiskInfo();
        r104.riskInfoParamsMap = r103.getHostInfo().getRiskInfoParams();
        KtSafeMethodExtensionKt.safePut(r102, DyVerifyReqConstants.Key.RISK_INFO, r104.toJsonNew());
        KtSafeMethodExtensionKt.safePut(r102, "process_info", r101.getProcessInfo());
        JSONObject r105 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r105, "bind_card_ext", r100.bind_card_ext);
        Unit r106 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r102, "exts", r105);
        ICJPayNewCardCallback r107 = r103.getPayNewCardCallback();
        if (r107 == null) goto L7;
        JSONObject r108 = r107.getPayNewCardConfigs();
        if (r108 == null) goto L7;
        String r109 = r108.optString("fundBillIndex");
    L8:
        KtSafeMethodExtensionKt.safePut(r102, "fund_bill_index", r109);
        return r102;
    L7:
        r109 = null;
        goto L8
    }
}
