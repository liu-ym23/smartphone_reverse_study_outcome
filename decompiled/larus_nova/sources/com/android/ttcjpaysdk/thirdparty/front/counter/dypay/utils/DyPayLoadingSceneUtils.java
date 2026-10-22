package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.utils;

import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.utils.FrontSelectPaymentMethodUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/utils/DyPayLoadingSceneUtils;", "", "()V", "needPayVerifyPreLoading", "", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayLoadingSceneUtils {
    public static final DyPayLoadingSceneUtils INSTANCE = null;

    static {
        INSTANCE = new DyPayLoadingSceneUtils();
    }

    private DyPayLoadingSceneUtils() {
    }

    public final boolean needPayVerifyPreLoading(CJPayCheckoutCounterResponseBean r100) {
        Boolean r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.isAssetStandard());
    L7:
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        if (r103 == false) goto L16;
        if (r100 == null) goto L13;
        r101 = Boolean.valueOf(r100.isShowPreLoading());
    L13:
        if (r101 != null) goto L18;
        return false;
    L18:
        return r101.booleanValue();
    L16:
        return FrontSelectPaymentMethodUtils.INSTANCE.isCreditScore(r100);
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
