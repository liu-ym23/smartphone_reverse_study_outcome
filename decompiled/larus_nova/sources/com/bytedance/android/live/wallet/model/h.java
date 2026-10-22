package com.bytedance.android.live.wallet.model;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public static final g a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toOrderData");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L23
        String r102 = r100.mParams;     // Catch: Throwable -> L23
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L23
    L17:
        String r105 = r104.optString("merchant_id", "");     // Catch: Throwable -> L23
        String r106 = r104.optString("app_id", "");     // Catch: Throwable -> L23
        String r107 = r104.optString("product_id", "");     // Catch: Throwable -> L23
        String r108 = r104.optString(OrderParamsKey.KEY_SDK_PARAM, "");     // Catch: Throwable -> L23
        String r109 = r100.mOrderId;     // Catch: Throwable -> L23
        if (r109 != null) goto L20;
        String r110 = "";
    L21:
        return new g(r110, r105, r106, r107, r108);
    L20:
        r110 = r109;
        goto L21
    L13:
        String r111 = r100.mParams;     // Catch: Throwable -> L23
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r104 = new JSONObject(r111);     // Catch: Throwable -> L23
        goto L17
    L6:
        if (r102.length() == 0) goto L9;
        r103 = false;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L27;
        ALogger.e("WalletPay", "order data error: " + r114.getMessage());
    L27:
        g r115 = new g("", "", "", "", "");
        if (Result.m9455isFailureimpl(r113) == false) goto L31;
        r113 = r115;
    L31:
        return (g) r113;
    }
}
