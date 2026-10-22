package com.android.ttcjpaysdk.thirdparty.verify.utils;

import android.content.Context;
import com.android.ttcjpaysdk.asset.utils.AssetInfoUtil;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmResponseBean;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/utils/CJPayECNYUtils;", "", "()V", "checkNeedInterceptForDigitalRMB", "", "confirmResponseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmResponseBean;", "parseCardInvalidState", "Lcom/android/ttcjpaysdk/thirdparty/verify/utils/CJPayECNYInvalidData;", "responseBeen", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayECNYUtils {
    public static final CJPayECNYUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayECNYUtils();
    }

    private CJPayECNYUtils() {
    }

    public final boolean checkNeedInterceptForDigitalRMB(CJPayTradeConfirmResponseBean r100) {
        AssetInfoUtil r101 = AssetInfoUtil.INSTANCE;
        String r102 = null;
        if (r100 == null) goto L7;
        AssetInfoBean r103 = r100.used_asset_info;
        if (r103 == null) goto L7;
        AssetInfoBean.AssetMetaInfoBean r104 = r103.asset_meta_info;
    L8:
        boolean r105 = r101.isEcny(r104);
        if (r100 == null) goto L11;
        String r106 = r100.pay_type;
    L12:
        boolean r107 = Intrinsics.areEqual(r106, "ecnypay");
        if (r105 == true) goto L15;
        if (r107 == true) goto L15;
    L20:
        return false;
    L15:
        if (r100 == null) goto L18;
        r102 = r100.code;
    L18:
        if (Intrinsics.areEqual(r102, "CD000000") == true) goto L20;
        return true;
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final CJPayECNYInvalidData parseCardInvalidState(CJPayTradeConfirmResponseBean r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "responseBeen");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r100.code, CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_INSUFFICIENT) == false) goto L7;
        return new CJPayECNYInvalidData(r101.getString(R.string.cj_pay_ecny_insufficient_toast_text), r101.getString(R.string.cj_pay_ecny_insufficient_status_text));
    L7:
        return new CJPayECNYInvalidData(r101.getString(R.string.cj_pay_ecny_service_unavailable_toast_text), r101.getString(R.string.cj_pay_ecny_service_unavailable_status_text));
    }
}
