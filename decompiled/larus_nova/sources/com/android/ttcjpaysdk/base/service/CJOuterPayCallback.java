package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;", "", "onPayResult", "", "result", "", "Companion", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJOuterPayCallback {
    public static final String CJ_PAY_SDK_VERSION_ERROR = "100";
    public static final Companion Companion = null;
    public static final String OUTER_PARAMS_EXTRA_PARAMS = "extraParams";
    public static final String OUTER_PARAMS_RESULT_CODE = "resultCode";
    public static final String OUTER_PARAMS_RESULT_MSG = "errorMsg";
    public static final String PARAMS_RESULT_CODE = "code";
    public static final String PARAMS_RESULT_EXTRA = "extra";
    public static final String PARAMS_RESULT_MSG = "msg";
    public static final String RESULT_CODE_CANCEL = "1";
    public static final String RESULT_CODE_FAIL = "2";
    public static final String RESULT_CODE_NOTIFY_TO_DYLITE = "201";
    public static final String RESULT_CODE_PROCESSING = "3";
    public static final String RESULT_CODE_SUCCESS = "0";

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback$Companion;", "", "()V", "CJ_PAY_SDK_VERSION_ERROR", "", "OUTER_PARAMS_EXTRA_PARAMS", "OUTER_PARAMS_RESULT_CODE", "OUTER_PARAMS_RESULT_MSG", "PARAMS_RESULT_CODE", "PARAMS_RESULT_EXTRA", "PARAMS_RESULT_MSG", "RESULT_CODE_CANCEL", "RESULT_CODE_FAIL", "RESULT_CODE_NOTIFY_TO_DYLITE", "RESULT_CODE_PROCESSING", "RESULT_CODE_SUCCESS", "buildResultStr", "resultCode", "resultMsg", "extras", "getResultCode", "result", "getResultExtra", "getResultMsg", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String CJ_PAY_SDK_VERSION_ERROR = "100";
        public static final String OUTER_PARAMS_EXTRA_PARAMS = "extraParams";
        public static final String OUTER_PARAMS_RESULT_CODE = "resultCode";
        public static final String OUTER_PARAMS_RESULT_MSG = "errorMsg";
        public static final String PARAMS_RESULT_CODE = "code";
        public static final String PARAMS_RESULT_EXTRA = "extra";
        public static final String PARAMS_RESULT_MSG = "msg";
        public static final String RESULT_CODE_CANCEL = "1";
        public static final String RESULT_CODE_FAIL = "2";
        public static final String RESULT_CODE_NOTIFY_TO_DYLITE = "201";
        public static final String RESULT_CODE_PROCESSING = "3";
        public static final String RESULT_CODE_SUCCESS = "0";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final String getResultCode(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            return KtSafeMethodExtensionKt.safeCreate(r100).optString("code");
        }

        public final String getResultExtra(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            return KtSafeMethodExtensionKt.safeCreate(r100).optString("extra");
        }

        public final String getResultMsg(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            return KtSafeMethodExtensionKt.safeCreate(r100).optString("msg");
        }

        public final String buildResultStr(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "resultCode");
            Intrinsics.checkNotNullParameter(r101, "resultMsg");
            Intrinsics.checkNotNullParameter(r102, "extras");
            JSONObject r103 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r103, "code", r100);
            KtSafeMethodExtensionKt.safePut(r103, "msg", r101);
            KtSafeMethodExtensionKt.safePut(r103, "extra", r102);
            return r103.toString();
        }

        public static /* synthetic */ String buildResultStr$default(Companion r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = "";
        L6:
            return r100.buildResultStr(r101, r102, r103);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onPayResult(String r100);
}
