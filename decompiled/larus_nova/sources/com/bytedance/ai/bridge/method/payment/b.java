package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignResponse;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f35781a = null;

    static {
        f35781a = LazyKt.lazy(new a());
    }

    public static AppletPaymentApi c() {
        return (AppletPaymentApi) f35781a.getValue();
    }

    public static GetOrderPaymentResponse a(GetOrderPaymentRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return c().getOrderPayment(r100).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.i("AppletPaymentRemoteDataSource", "getOrderPayment error: " + e.getMessage());
        return new GetOrderPaymentResponse(null, e.traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        return new GetOrderPaymentResponse(null, "", 13000, r101);
    }

    public static GetOrderPaymentWithSignResponse b(GetOrderPaymentWithSignRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return c().getOrderPaymentWithSign(r100).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.i("AppletPaymentRemoteDataSource", "getOrderPaymentWithSign error: " + e.getMessage());
        return new GetOrderPaymentWithSignResponse(null, e.traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        return new GetOrderPaymentWithSignResponse(null, "", 13000, r101);
    }

    public static GetSignPageDataResponse d(GetSignPageDataRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return c().getSignPageData(r100).execute().body();
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.i("AppletPaymentRemoteDataSource", "getSignPageData error: " + e.getMessage());
        return new GetSignPageDataResponse(null, e.traceCode, 10401, "internal error");
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        return new GetSignPageDataResponse(null, "", 13000, r101);
    }
}
