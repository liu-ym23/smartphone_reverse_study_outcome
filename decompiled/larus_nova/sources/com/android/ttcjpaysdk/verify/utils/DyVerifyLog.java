package com.android.ttcjpaysdk.verify.utils;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CustomizedConfig;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.verify.base.DyVerifyCenter;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.android.ttcjpaysdk.verify.constants.DyVerifyResultCode;
import com.android.ttcjpaysdk.verify.data.product.DyVerifyBase;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u009e\u0001\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010&\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J,\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 J$\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007J.\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u000100J&\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005J&\u00104\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¨\u00065"}, d2 = {"Lcom/android/ttcjpaysdk/verify/utils/DyVerifyLog;", "", "()V", "getCommonLogParams", "", "", "eventParams", "", "getStageEn", "stage", "reportBioOptVerify", "", "reportCallbackEvent", "code", "", "msg", "curVerifyProduct", "ext", "reportCertExceptionTrackEvent", "errorCode", "errorMsg", "pin", "partCsrData", "completedCsrData", "certData", "signFactor", "signFactorId", "serverDn", "serverSn", "localDn", "localSn", "busParams", "Lorg/json/JSONObject;", "reportCertInstallClick", "buttonName", "reportCertInstallDialogClick", "reportCertInstallDialogImp", "reportCertInstallImp", "reportCertSignRequest", "reportCertSignResult", "result", "reportEvent", "eventName", "reportInvokeEvent", "verifyId", "verifyToken", "verifyProduct", "config", "Lcom/android/ttcjpaysdk/base/service/CustomizedConfig;", "reportSendSmsEvent", "success", "", "reportVerifySmsEvent", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyLog {
    public static final DyVerifyLog INSTANCE = null;

    static {
        INSTANCE = new DyVerifyLog();
    }

    private DyVerifyLog() {
    }

    public final void reportCertInstallDialogImp() {
        Pair[] r100 = new Pair[1];
        String r101 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[0] = TuplesKt.to("verify_product", r101);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_INSTALL_DIALOG_IMP, MapsKt.mutableMapOf(r100));
    }

    public final void reportCertInstallImp() {
        Pair[] r100 = new Pair[1];
        String r101 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[0] = TuplesKt.to("verify_product", r101);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_INSTALL_IMP, MapsKt.mutableMapOf(r100));
    }

    private final String getStageEn(String r100) {
        switch(r100.hashCode()) {
            case -1969834323: goto L66;
            case -1548280320: goto L62;
            case -987865039: goto L58;
            case -944089784: goto L54;
            case -163329111: goto L50;
            case -10452777: goto L46;
            case 161419151: goto L42;
            case 380069051: goto L38;
            case 548826844: goto L34;
            case 984082454: goto L30;
            case 1076988668: goto L26;
            case 1247231803: goto L22;
            case 1587351406: goto L18;
            case 1708448446: goto L14;
            case 1787953626: goto L10;
            case 2080839881: goto L6;
            default: goto L85;
        };
    L85:
        return r100;
    L6:
        if (r100.equals("手机盾加密失败") == false) goto L86;
        return "Encrypt_EncryptFail";
    L86:
        return r100;
    L10:
        if (r100.equals("证书状态查询-本地证书查询失败") == false) goto L87;
        return "Check_LocalFail";
    L87:
        return r100;
    L14:
        if (r100.equals("证书状态查询-证书数据不一致") == false) goto L88;
        return "Check_Unequal";
    L88:
        return r100;
    L18:
        if (r100.equals("证书安装-导入证书失败") == false) goto L89;
        return "Install_LocalInstallCertFail";
    L89:
        return r100;
    L22:
        if (r100.equals("证书安装-生成部分CSR失败") == false) goto L90;
        return "Install_ServerGenPartCsrFail";
    L90:
        return r100;
    L26:
        if (r100.equals("证书签名-签名失败") == false) goto L91;
        return "Sign_LocalSignFail";
    L91:
        return r100;
    L30:
        if (r100.equals("证书签名-更新签名因子后依然签名失败") == false) goto L92;
        return "Sign_LocalSignFailAfterUpdateQ1";
    L92:
        return r100;
    L34:
        if (r100.equals("证书安装-下载证书失败certData解密失败") == false) goto L93;
        return "Install_ServerGetCertFailForDecryptFail";
    L93:
        return r100;
    L38:
        if (r100.equals("证书签名-远端更新签名因子失败") == false) goto L94;
        return "Sign_ServerUpdateQ1Fail";
    L94:
        return r100;
    L42:
        if (r100.equals("证书卸载-远端卸载失败") == false) goto L95;
        return "Uninstall_ServerFail";
    L95:
        return r100;
    L46:
        if (r100.equals("证书安装-下载证书失败") == false) goto L96;
        return "Install_ServerGetCertFail";
    L96:
        return r100;
    L50:
        if (r100.equals("证书状态查询-远端证书查询失败") == false) goto L97;
        return "Check_ServerFail";
    L97:
        return r100;
    L54:
        if (r100.equals("证书安装-生成客户端部分公钥失败") == false) goto L98;
        return "Install_LocalGenClientPartPubKeyFail";
    L98:
        return r100;
    L58:
        if (r100.equals("证书安装-生成完整CSR失败") == false) goto L99;
        return "Install_LocalGenCompleteCsrFail";
    L99:
        return r100;
    L62:
        if (r100.equals("证书卸载-本地卸载失败") == false) goto L100;
        return "Uninstall_LocalFail";
    L100:
        return r100;
    L66:
        if (r100.equals("证书安装-服务端初始化失败") == false) goto L101;
        return "Install_ServerInitFail";
    L101:
        return r100;
    }

    public final Map<String, ? extends String> getCommonLogParams(Map<String, String> r100) {
        JSONObject r101 = CJPayParamsUtils.getCommonLogParams("", "");
        DyVerifyCenter r102 = DyVerifyCenter.INSTANCE;     // Catch: Exception -> L19
        DyVerifyBase r103 = r102.getVerifyToken().product.getProductByType(r102.getCurVerifyProduct());     // Catch: Exception -> L19
        if (r103 == null) goto L13;
        r101.put("app_id", r103.app_id);     // Catch: Exception -> L19
        r101.put("merchant_id", r103.merchant_id);     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.VERIFY_TRACE_ID, r103.verify_trace_id);     // Catch: Exception -> L19
        r101.put("member_biz_order_no", r103.member_biz_order_no);     // Catch: Exception -> L19
        String r104 = r103.verify_params;     // Catch: Exception -> L19
        if (r104 == null) goto L13;
        if ((!StringsKt.isBlank(r104)) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        KtSafeMethodExtensionKt.safePutAll(r101, new JSONObject(r104));     // Catch: Exception -> L19
    L13:
        r101.put(DyVerifyEventConstants.EventParam.VERIFY_ID, r102.getVerifyId());     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.VERIFY_CODE, r102.getVerifyToken().verify_flow);     // Catch: Exception -> L19
        r101.put("event_type", r102.getVerifyToken().event_type);     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.PULLUP_SDK, "1");     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.PULLUP_MODULE, "1");     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r102.getVerifyToken().event_type);     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.SDK_PLATFORM, "native");     // Catch: Exception -> L19
        r101.put(DyVerifyEventConstants.EventParam.IS_DY_VERIFY, "1");     // Catch: Exception -> L19
        r101.put("params_for_special", a.VALUE_PARAMS_FOR_SPECIAL);     // Catch: Exception -> L19
        CustomizedConfig r105 = r102.getConfig();     // Catch: Exception -> L19
        if (r105 == null) goto L21;
        JSONObject r106 = r105.logParams;     // Catch: Exception -> L19
        if (r106 == null) goto L21;
        KtSafeMethodExtensionKt.safePutAll(r101, r106);     // Catch: Exception -> L19
    L21:
        Map<String, String> r107 = KtSafeMethodExtensionKt.toMap(r101);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map<String, ? extends String> r108 = TypeIntrinsics.asMutableMap(r107);
        if (r100 == null) goto L24;
        r108.putAll(r100);
    L24:
        return r108;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyLog#getCommonLogParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyLog#getCommonLogParams", e);
        goto L21
    }

    public final void reportBioOptVerify(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Pair[] r101 = new Pair[2];
        String r102 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[0] = TuplesKt.to("verify_product", r102);
        r101[1] = TuplesKt.to("stage", r100);
        reportEvent(DyVerifyEventConstants.EventName.VERIFICATION_SDK_BIO_OPT_VERIFY, MapsKt.mutableMapOf(r101));
    }

    public final void reportCertInstallClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Pair[] r101 = new Pair[2];
        String r102 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[0] = TuplesKt.to("verify_product", r102);
        r101[1] = TuplesKt.to("button_name", r100);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_INSTALL_CLICK, MapsKt.mutableMapOf(r101));
    }

    public final void reportCertInstallDialogClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Pair[] r101 = new Pair[2];
        String r102 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[0] = TuplesKt.to("verify_product", r102);
        r101[1] = TuplesKt.to("button_name", r100);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_INSTALL_DIALOG_CLICK, MapsKt.mutableMapOf(r101));
    }

    public final void reportCertSignRequest(JSONObject r100) {
        Pair[] r101 = new Pair[1];
        String r102 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[0] = TuplesKt.to("verify_product", r102);
        Map<String, String> r103 = MapsKt.mutableMapOf(r101);
        if (r100 == null) goto L8;
        r103.putAll(KtSafeMethodExtensionKt.toMap(r100));
    L8:
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_SIGN_REQUEST, r103);
    }

    public final void reportEvent(String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "eventParams");
        Set<String> r100 = CJContext.f202254w;
        CJContext r101 = CJContext.c.a("base_verify_sdk", "", "", new HashMap());
        Map<String, ? extends String> r102 = getCommonLogParams(r111);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        CJReporter r112 = CJReporter.f202294a;
        CJReporter.g(r101, r110, r102, null, -1, false);
    }

    public final void reportSendSmsEvent(boolean r100, String r101, String r102) {
        if (r100 == false) goto L4;
        String r103 = "1";
    L5:
        Pair[] r104 = new Pair[3];
        r104[0] = TuplesKt.to("result", r103);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104[1] = TuplesKt.to("error_code", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104[2] = TuplesKt.to("error_message", r102);
        reportEvent(DyVerifyEventConstants.EventName.VERIFICATION_SDK_SMS_SENDMSG, MapsKt.mapOf(r104));
        return;
    L4:
        r103 = "0";
        goto L5
    }

    public final void reportVerifySmsEvent(boolean r100, String r101, String r102) {
        if (r100 == false) goto L4;
        String r103 = "1";
    L5:
        Pair[] r104 = new Pair[3];
        r104[0] = TuplesKt.to("result", r103);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104[1] = TuplesKt.to("error_code", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104[2] = TuplesKt.to("error_message", r102);
        reportEvent(DyVerifyEventConstants.EventName.VERIFICATION_SDK_SMS_RESULT, MapsKt.mapOf(r104));
        return;
    L4:
        r103 = "0";
        goto L5
    }

    public static /* synthetic */ void reportCertInstallDialogClick$default(DyVerifyLog r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = "";
    L5:
        r100.reportCertInstallDialogClick(r101);
    }

    public final void reportCallbackEvent(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "curVerifyProduct");
        Pair[] r104 = new Pair[7];
        DyVerifyCenter r105 = DyVerifyCenter.INSTANCE;
        r104[0] = TuplesKt.to("verify_id", r105.getVerifyId());
        r104[1] = TuplesKt.to("verify_token", CJPayJsonParser.toJsonObject(r105.getVerifyToken()).toString());
        r104[2] = TuplesKt.to("code", String.valueOf(r100));
        r104[3] = TuplesKt.to("message", r101);
        r104[4] = TuplesKt.to("verify_product", r102);
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r104[5] = TuplesKt.to("ext", r103);
        Integer r106 = (Integer) DyVerifyResultCode.CJ_PAY_DY_VERIFY_SUCCESS.first;
        if (r106 != null) goto L9;
    L11:
        String r107 = "0";
    L12:
        r104[6] = TuplesKt.to("result", r107);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CALLBACK, MapsKt.mutableMapOf(r104));
        return;
    L9:
        if (r100 != r106.intValue()) goto L11;
        r107 = "1";
        goto L12
    }

    public final void reportCertSignResult(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Pair[] r104 = new Pair[4];
        String r105 = (String) CollectionsKt.firstOrNull(DyVerifyCenter.INSTANCE.getVerifyList());
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104[0] = TuplesKt.to("verify_product", r105);
        r104[1] = TuplesKt.to("result", r100);
        r104[2] = TuplesKt.to("error_code", r101);
        r104[3] = TuplesKt.to("error_message", r102);
        Map<String, String> r106 = MapsKt.mutableMapOf(r104);
        if (r103 == null) goto L8;
        r106.putAll(KtSafeMethodExtensionKt.toMap(r103));
    L8:
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_CERT_SIGN_RESULT, r106);
    }

    public final void reportInvokeEvent(String r100, String r101, String r102, CustomizedConfig r103) {
        Pair[] r104 = new Pair[4];
        String r105 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r104[0] = TuplesKt.to("verify_id", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104[1] = TuplesKt.to("verify_token", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104[2] = TuplesKt.to("verify_product", r102);
        if (r103 == null) goto L17;
        String r106 = r103.toJsonStr();
        if (r106 == null) goto L17;
        r105 = r106;
    L17:
        r104[3] = TuplesKt.to("ext", r105);
        reportEvent(DyVerifyEventConstants.EventName.DY_VERIFY_SDK_INVOKE, MapsKt.mutableMapOf(r104));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportEvent$default(DyVerifyLog r100, String r101, Map r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r100.reportEvent(r101, r102);
    }

    public static /* synthetic */ void reportSendSmsEvent$default(DyVerifyLog r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.reportSendSmsEvent(r101, r102, r103);
    }

    public static /* synthetic */ void reportVerifySmsEvent$default(DyVerifyLog r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.reportVerifySmsEvent(r101, r102, r103);
    }

    public static /* synthetic */ void reportCallbackEvent$default(DyVerifyLog r100, int r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.reportCallbackEvent(r101, r102, r103, r104);
    }

    public static /* synthetic */ void reportCertSignResult$default(DyVerifyLog r100, String r101, String r102, String r103, JSONObject r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.reportCertSignResult(r101, r102, r103, r104);
    }

    public final void reportCertExceptionTrackEvent(String r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, JSONObject r212) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r110, "errorCode");
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        Intrinsics.checkNotNullParameter(r112, "pin");
        Pair[] r101 = new Pair[14];     // Catch: Throwable -> L49
        r101[0] = TuplesKt.to("stage", r100);     // Catch: Throwable -> L49
        r101[1] = TuplesKt.to("stage_en", getStageEn(r100));     // Catch: Throwable -> L49
        r101[2] = TuplesKt.to("error_code", r110);     // Catch: Throwable -> L49
        r101[3] = TuplesKt.to("error_msg", r111);     // Catch: Throwable -> L49
        r101[4] = TuplesKt.to("pin", r112);     // Catch: Throwable -> L49
        String r102 = "";
        if (r113 != null) goto L7;
        String r103 = "";
    L8:
        r101[5] = TuplesKt.to("part_csr_data", r103);     // Catch: Throwable -> L49
        if (r114 != null) goto L11;
        String r104 = "";
    L12:
        r101[6] = TuplesKt.to("completed_csr_data", r104);     // Catch: Throwable -> L49
        if (r115 != null) goto L15;
        String r105 = "";
    L16:
        r101[7] = TuplesKt.to("cert_data", r105);     // Catch: Throwable -> L49
        if (r116 != null) goto L19;
        String r106 = "";
    L20:
        r101[8] = TuplesKt.to("sign_factor", r106);     // Catch: Throwable -> L49
        if (r117 != null) goto L23;
        String r107 = "";
    L24:
        r101[9] = TuplesKt.to("sign_factor_id", r107);     // Catch: Throwable -> L49
        if (r118 != null) goto L27;
        String r108 = "";
    L28:
        r101[10] = TuplesKt.to("server_dn", r108);     // Catch: Throwable -> L49
        if (r119 != null) goto L31;
        String r109 = "";
    L32:
        r101[11] = TuplesKt.to("server_sn", r109);     // Catch: Throwable -> L49
        if (r210 != null) goto L35;
        String r120 = "";
    L36:
        r101[12] = TuplesKt.to("local_dn", r120);     // Catch: Throwable -> L49
        if (r211 == null) goto L40;
        r102 = r211;
    L40:
        r101[13] = TuplesKt.to("local_sn", r102);     // Catch: Throwable -> L49
        Map<String, String> r121 = MapsKt.mutableMapOf(r101);     // Catch: Throwable -> L49
        if (r212 == null) goto L55;
        r121.putAll(KtSafeMethodExtensionKt.toMap(r212));     // Catch: Throwable -> L49
    L55:
        reportEvent("wallet_rd_digital_cert_track", r121);     // Catch: Throwable -> L47
        return;
    L47:
        th = th;
    L51:
        CJBasicCommonUtils.reportCatchException("DyVerifyLog#reportCertExceptionTrackEvent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyLog#reportCertExceptionTrackEvent", th);
        return;
    L35:
        r120 = r210;
        goto L36
    L31:
        r109 = r119;
        goto L32
    L27:
        r108 = r118;
        goto L28
    L23:
        r107 = r117;
        goto L24
    L19:
        r106 = r116;
        goto L20
    L15:
        r105 = r115;
        goto L16
    L11:
        r104 = r114;
        goto L12
    L7:
        r103 = r113;
    L49:
        th = th;
        goto L51
    }

    public static /* synthetic */ void reportCertExceptionTrackEvent$default(DyVerifyLog r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, JSONObject r312, int r313, Object r314) {
        if ((r313 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r313 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 64) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r313 & 128) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r313 & 256) == 0) goto L21;
        String r114 = null;
    L23:
        if ((r313 & 512) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r313 & 1024) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r313 & 2048) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r313 & 4096) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r313 & 8192) == 0) goto L41;
        JSONObject r119 = null;
    L42:
        r110.reportCertExceptionTrackEvent(r111, r210, r211, r212, r100, r101, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L41:
        r119 = r312;
        goto L42
    L37:
        r118 = r311;
        goto L39
    L33:
        r117 = r310;
        goto L35
    L29:
        r116 = r219;
        goto L31
    L25:
        r115 = r218;
        goto L27
    L21:
        r114 = r217;
        goto L23
    L17:
        r113 = r216;
        goto L19
    L13:
        r112 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
