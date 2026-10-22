package com.android.ttcjpaysdk.integrated.counter.outerpay;

import android.util.Pair;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR-\u0010\u000b\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR-\u0010\r\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR-\u0010\u000f\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR-\u0010\u0011\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR-\u0010\u0013\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/outerpay/CJOuterPayResult;", "", "()V", "CJ_PAY_CREATE_FAILED", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "getCJ_PAY_CREATE_FAILED", "()Landroid/util/Pair;", "CJ_PAY_PARAMS_QUERY_TOKEN_ERROR", "getCJ_PAY_PARAMS_QUERY_TOKEN_ERROR", "CJ_PAY_PROCESS_CANCEL", "getCJ_PAY_PROCESS_CANCEL", "CJ_PAY_PROCESS_FAILED", "getCJ_PAY_PROCESS_FAILED", "CJ_PAY_PROCESS_SUCCESS", "getCJ_PAY_PROCESS_SUCCESS", "CJ_PAY_SDK_PARAMS_ERROR", "getCJ_PAY_SDK_PARAMS_ERROR", "CJ_PAY_SDK_VERSION_ERROR", "getCJ_PAY_SDK_VERSION_ERROR", "getResult", "result", "extra", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterPayResult {
    private static final Pair<String, String> CJ_PAY_CREATE_FAILED = null;
    private static final Pair<String, String> CJ_PAY_PARAMS_QUERY_TOKEN_ERROR = null;
    private static final Pair<String, String> CJ_PAY_PROCESS_CANCEL = null;
    private static final Pair<String, String> CJ_PAY_PROCESS_FAILED = null;
    private static final Pair<String, String> CJ_PAY_PROCESS_SUCCESS = null;
    private static final Pair<String, String> CJ_PAY_SDK_PARAMS_ERROR = null;
    private static final Pair<String, String> CJ_PAY_SDK_VERSION_ERROR = null;
    public static final CJOuterPayResult INSTANCE = null;

    private CJOuterPayResult() {
    }

    static {
        INSTANCE = new CJOuterPayResult();
        CJ_PAY_PROCESS_SUCCESS = new Pair("0", "支付成功");
        CJ_PAY_PROCESS_CANCEL = new Pair("1", "支付取消");
        CJ_PAY_PROCESS_FAILED = new Pair("2", "支付失败，可能有多种原因");
        CJ_PAY_PARAMS_QUERY_TOKEN_ERROR = new Pair("3", "获取下单参数失败");
        CJ_PAY_CREATE_FAILED = new Pair("4", "下单失败");
        CJ_PAY_SDK_VERSION_ERROR = new Pair("5", "抖音版本过低，需要用户升级");
        CJ_PAY_SDK_PARAMS_ERROR = new Pair("6", "传参错误");
    }

    public final Pair<String, String> getCJ_PAY_CREATE_FAILED() {
        return CJ_PAY_CREATE_FAILED;
    }

    public final Pair<String, String> getCJ_PAY_PARAMS_QUERY_TOKEN_ERROR() {
        return CJ_PAY_PARAMS_QUERY_TOKEN_ERROR;
    }

    public final Pair<String, String> getCJ_PAY_PROCESS_CANCEL() {
        return CJ_PAY_PROCESS_CANCEL;
    }

    public final Pair<String, String> getCJ_PAY_PROCESS_FAILED() {
        return CJ_PAY_PROCESS_FAILED;
    }

    public final Pair<String, String> getCJ_PAY_PROCESS_SUCCESS() {
        return CJ_PAY_PROCESS_SUCCESS;
    }

    public final Pair<String, String> getCJ_PAY_SDK_PARAMS_ERROR() {
        return CJ_PAY_SDK_PARAMS_ERROR;
    }

    public final Pair<String, String> getCJ_PAY_SDK_VERSION_ERROR() {
        return CJ_PAY_SDK_VERSION_ERROR;
    }

    public final String getResult(Pair<String, String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "extra");
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "code", r100.first);
        KtSafeMethodExtensionKt.safePut(r102, "msg", r100.second);
        KtSafeMethodExtensionKt.safePut(r102, "extra", r101);
        return r102.toString();
    }

    public static /* synthetic */ String getResult$default(CJOuterPayResult r100, Pair r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.getResult(r101, r102);
    }
}
