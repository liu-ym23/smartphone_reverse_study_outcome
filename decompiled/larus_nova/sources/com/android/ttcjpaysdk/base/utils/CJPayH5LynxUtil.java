package com.android.ttcjpaysdk.base.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import com.android.ttcjpaysdk.base.service.bean.H5SchemeParamBuilder;
import com.android.ttcjpaysdk.ttcjpayapi.IGeneralPay;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J(\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayH5LynxUtil;", "", "()V", "TAG", "", "getCode", "data", "getPayToken", "getQueryParam", "uri", "Landroid/net/Uri;", "key", "goToH5ActivateCreditPay", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "activateUrl", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "gotoCreditActivate", "url", "gotoLynxPage", "schema", "openH5PageWithCallback", "activity", "Landroid/app/Activity;", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/IGeneralPay$IGeneralPayCallback;", "openLynxPageWithCallback", "lynxSchema", "BankResignResult", "OpenLynxIntResult", "OpenLynxResult", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayH5LynxUtil {
    public static final CJPayH5LynxUtil INSTANCE = null;
    private static final String TAG = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayH5LynxUtil$BankResignResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAILED", "CANCEL", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BankResignResult extends Enum<BankResignResult> {
        private static final /* synthetic */ BankResignResult[] $VALUES = null;
        public static final BankResignResult CANCEL = null;
        public static final BankResignResult FAILED = null;
        public static final BankResignResult SUCCESS = null;
        private final int value;

        private static final /* synthetic */ BankResignResult[] $values() {
            return new BankResignResult[]{SUCCESS, FAILED, CANCEL};
        }

        public static BankResignResult valueOf(String r100) {
            return (BankResignResult) a.a(BankResignResult.class, r100);
        }

        public static BankResignResult[] values() {
            return (BankResignResult[]) $VALUES.clone();
        }

        static {
            SUCCESS = new BankResignResult("SUCCESS", 0, 1);
            FAILED = new BankResignResult("FAILED", 1, -1);
            CANCEL = new BankResignResult("CANCEL", 2, 0);
            $VALUES = $values();
        }

        public final int getValue() {
            return this.value;
        }

        private BankResignResult(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayH5LynxUtil$OpenLynxIntResult;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "FAILED", "CANCEL", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OpenLynxIntResult extends Enum<OpenLynxIntResult> {
        private static final /* synthetic */ OpenLynxIntResult[] $VALUES = null;
        public static final OpenLynxIntResult CANCEL = null;
        public static final OpenLynxIntResult FAILED = null;
        public static final OpenLynxIntResult SUCCESS = null;
        private final int code;

        private static final /* synthetic */ OpenLynxIntResult[] $values() {
            return new OpenLynxIntResult[]{SUCCESS, FAILED, CANCEL};
        }

        public static OpenLynxIntResult valueOf(String r100) {
            return (OpenLynxIntResult) a.a(OpenLynxIntResult.class, r100);
        }

        public static OpenLynxIntResult[] values() {
            return (OpenLynxIntResult[]) $VALUES.clone();
        }

        static {
            SUCCESS = new OpenLynxIntResult("SUCCESS", 0, 1);
            FAILED = new OpenLynxIntResult("FAILED", 1, 2);
            CANCEL = new OpenLynxIntResult("CANCEL", 2, 0);
            $VALUES = $values();
        }

        public final int getCode() {
            return this.code;
        }

        private OpenLynxIntResult(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayH5LynxUtil$OpenLynxResult;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "SUCCESS", "FAILED", "CANCEL", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OpenLynxResult extends Enum<OpenLynxResult> {
        private static final /* synthetic */ OpenLynxResult[] $VALUES = null;
        public static final OpenLynxResult CANCEL = null;
        public static final OpenLynxResult FAILED = null;
        public static final OpenLynxResult SUCCESS = null;
        private final String code;

        private static final /* synthetic */ OpenLynxResult[] $values() {
            return new OpenLynxResult[]{SUCCESS, FAILED, CANCEL};
        }

        public static OpenLynxResult valueOf(String r100) {
            return (OpenLynxResult) a.a(OpenLynxResult.class, r100);
        }

        public static OpenLynxResult[] values() {
            return (OpenLynxResult[]) $VALUES.clone();
        }

        static {
            SUCCESS = new OpenLynxResult("SUCCESS", 0, "1");
            FAILED = new OpenLynxResult("FAILED", 1, "0");
            CANCEL = new OpenLynxResult("CANCEL", 2, "2");
            $VALUES = $values();
        }

        public final String getCode() {
            return this.code;
        }

        private OpenLynxResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    private CJPayH5LynxUtil() {
    }

    static {
        INSTANCE = new CJPayH5LynxUtil();
        TAG = "CJPayH5LynxUtil";
    }

    public final String getCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new JSONObject(r100).optString("code");
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayH5LynxUtil#getCode", e);
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.m(null, "lynx_callback_parse_code", 2, e);
        CJLogger.b(TAG, "parse code error");
        return "";
    }

    public final String getPayToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new JSONObject(r100).optString("pay_token");
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayH5LynxUtil#getPayToken", e);
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.m(null, "lynx_callback_parse_pay_token", 2, e);
        CJLogger.b(TAG, "parse payToken error");
        return "";
    }

    private final String getQueryParam(Uri r100, String r101) {
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, r101)) == false) goto L6;
        return "";
    L6:
        return URLDecoder.decode(UriProtector.getQueryParameter(r100, r101));
    }

    public final void gotoLynxPage(Context r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (CJPayCallBackCenter.getInstance().getOpenSchemeWithContextInterface() == null) goto L8;
        CJPayCallBackCenter.getInstance().getOpenSchemeWithContextInterface().openScheme(r100, r101);
        return;
    L8:
        if (CJPayCallBackCenter.getInstance().getOpenSchemeInterface() == null) goto L12;
        CJPayCallBackCenter.getInstance().getOpenSchemeInterface().openScheme(r101);
        return;
    }

    private final void goToH5ActivateCreditPay(Context r100, String r101, CJPayHostInfo r102) {
        ICJPayH5Service r103 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        if (r103 == null) goto L6;
        r103.startH5ByScheme(new H5SchemeParamBuilder().setContext(r100).setUrl(r101).setHostInfo(CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r102, null, 2, null)));
        return;
    }

    public final void gotoCreditActivate(Context r100, String r101, CJPayHostInfo r102) {
        String r103 = getQueryParam(UriProtector.parse(r101), "cj_page_type");     // Catch: Exception -> L10
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        if (Intrinsics.areEqual("lynx", r103) == false) goto L8;
        gotoLynxPage(r100, r101);     // Catch: Exception -> L10
    L13:
        return;
    L8:
        goToH5ActivateCreditPay(r100, r101, r102);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayH5LynxUtil#gotoCreditActivate", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayH5LynxUtil#gotoCreditActivate", e);
    }

    public final void openH5PageWithCallback(Activity r110, String r111, CJPayHostInfo r112, IGeneralPay.IGeneralPayCallback r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r113, "callback");
        IGeneralPay r100 = CJPayCallBackCenter.getInstance().getGeneralPay();
        if (r100 == null) goto L6;
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "schema", r111);
        r100.pay(r110, r101.toString(), 99, "", "", "", IGeneralPay.FromNative, CJPayHostInfo.Companion.copy(r112), r113);
        return;
    }

    public final void openLynxPageWithCallback(Activity r110, String r111, CJPayHostInfo r112, IGeneralPay.IGeneralPayCallback r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "lynxSchema");
        Intrinsics.checkNotNullParameter(r113, "callback");
        IGeneralPay r100 = CJPayCallBackCenter.getInstance().getGeneralPay();
        if (r100 == null) goto L6;
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "schema", r111);
        r100.pay(r110, r101.toString(), 98, "", "", "", IGeneralPay.FromNative, CJPayHostInfo.Companion.copy(r112), r113);
        return;
    }
}
