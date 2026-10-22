package com.android.ttcjpaysdk.base.saas;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.env.ICJPayToutiaoHostService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0018J\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/saas/CJPaySaasUtils;", "", "()V", "BYTEPAY_GATEWAYPATH", "", "BYTEPAY_GATEWAY_SAAS_PATH", "CAIJING_NO_SAAS_REQUEST_HEADER_MARK", "CAIJING_SAAS_JSB_REQUEST_HEADER_MARK", "CAIJING_SAAS_REQUEST_HEADER_MARK", "CASHIER_GATEWAY_PATH", "CASHIER_GATEWAY_SAAS_PATH", "CASHIER_U_GATEWAY_PATH", "CASHIER_U_GATEWAY_SAAS_PATH", "PAYSCORE_PATH", "PAYSCORE_SAAS_PATH", "isAddSchemaSaasMarkGlobal", "", "isSaasEnv", "saasScene", "checkIsCaijingSaasEnv", "checkSaasSchema", "originSchema", "getSaasAccessToken", "getSaasHeaders", "", "getSaasScene", "getSaasUrl", "originUrl", "isNeedSchemaAddSaasMarkGlobal", "isSaasJsbRequest", "headerValue", "isSaasRequest", "saveSaasEnv", "", "activity", "Landroid/content/Context;", "scene", "addSchemaSaasMarkGlobal", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySaasUtils {
    private static final String BYTEPAY_GATEWAYPATH = "gateway-bytepay";
    private static final String BYTEPAY_GATEWAY_SAAS_PATH = "gateway-bytepay-saas";
    public static final String CAIJING_NO_SAAS_REQUEST_HEADER_MARK = "not_saas";
    public static final String CAIJING_SAAS_JSB_REQUEST_HEADER_MARK = "jsb_saas";
    public static final String CAIJING_SAAS_REQUEST_HEADER_MARK = "saas";
    private static final String CASHIER_GATEWAY_PATH = "gateway-cashier2";
    private static final String CASHIER_GATEWAY_SAAS_PATH = "gateway-cashier2-saas";
    private static final String CASHIER_U_GATEWAY_PATH = "gateway-u";
    private static final String CASHIER_U_GATEWAY_SAAS_PATH = "gateway-u-saas";
    public static final CJPaySaasUtils INSTANCE = null;
    private static final String PAYSCORE_PATH = "v1/payscore/credit_product";
    private static final String PAYSCORE_SAAS_PATH = "gateway-u-saas/v1/payscore/credit_product";
    private static boolean isAddSchemaSaasMarkGlobal;
    private static boolean isSaasEnv;
    private static String saasScene;

    private CJPaySaasUtils() {
    }

    static {
        INSTANCE = new CJPaySaasUtils();
        saasScene = "";
    }

    public final String getSaasAccessToken() {
        a.f554342a.getClass();
        Intrinsics.checkNotNullParameter(ICJPayToutiaoHostService.class, "clazz");
        ICJPayToutiaoHostService r100 = (ICJPayToutiaoHostService) a.c(ICJPayToutiaoHostService.class);
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getSaasAccessToken();
    }

    public final Map<String, String> getSaasHeaders() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = INSTANCE.getSaasAccessToken();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        r100.put("Authorization", "Bearer " + r101);
        r100.put("saasscene", saasScene);
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public final boolean isNeedSchemaAddSaasMarkGlobal() {
        if (isSaasEnv == true) goto L5;
    L7:
        return false;
    L5:
        if (isAddSchemaSaasMarkGlobal == false) goto L7;
        return true;
    }

    public final boolean checkIsCaijingSaasEnv() {
        if (getSaasAccessToken().length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return false;
    L9:
        return isSaasEnv;
    L5:
        r100 = false;
        goto L6
    }

    public final String getSaasScene() {
        return saasScene;
    }

    public static final /* synthetic */ void access$setAddSchemaSaasMarkGlobal$p(boolean r100) {
        isAddSchemaSaasMarkGlobal = r100;
    }

    public static final /* synthetic */ void access$setSaasEnv$p(boolean r100) {
        isSaasEnv = r100;
    }

    public final String checkSaasSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L7
        if (UriProtector.getQueryParameterNames(r101).contains("is_caijing_saas") == true) goto L12;
        Uri.Builder r102 = r101.buildUpon();     // Catch: Exception -> L7
        r102.appendQueryParameter("is_caijing_saas", "1");     // Catch: Exception -> L7
        r102.appendQueryParameter(CJOuterPayBean.KEY_SAAS_SCENE, saasScene);     // Catch: Exception -> L7
        return r102.build().toString();
    L12:
        return r100;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySaasUtils#checkSaasSchema", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySaasUtils#checkSaasSchema", e);
        return r100;
    }

    public final String getSaasUrl(String r110) {
        Intrinsics.checkNotNullParameter(r110, "originUrl");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, CASHIER_GATEWAY_PATH, CASHIER_GATEWAY_SAAS_PATH, false, 4, null), BYTEPAY_GATEWAYPATH, BYTEPAY_GATEWAY_SAAS_PATH, false, 4, null), CASHIER_U_GATEWAY_PATH, CASHIER_U_GATEWAY_SAAS_PATH, false, 4, null), PAYSCORE_PATH, PAYSCORE_SAAS_PATH, false, 4, null);
    }

    public final boolean isSaasJsbRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "headerValue");
        return Intrinsics.areEqual(CAIJING_SAAS_JSB_REQUEST_HEADER_MARK, r100);
    }

    public final boolean isSaasRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "headerValue");
        return Intrinsics.areEqual("saas", r100);
    }

    public final void saveSaasEnv(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "scene");
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r100;
    L6:
        if (r103 == null) goto L8;
        isSaasEnv = true;
        isAddSchemaSaasMarkGlobal = r102;
        saasScene = r101;
        new SaasLifeCycle(r103, new CJPaySaasUtils$saveSaasEnv$1$1());
    L9:
        CJLogger.d("Saas", "saveSaasEnv saasEnv is: " + isSaasEnv + ", isAddSchemaSaasMarkGlobal is " + isAddSchemaSaasMarkGlobal);
        return;
    L8:
        isSaasEnv = false;
        isAddSchemaSaasMarkGlobal = false;
        Unit r104 = Unit.INSTANCE;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
