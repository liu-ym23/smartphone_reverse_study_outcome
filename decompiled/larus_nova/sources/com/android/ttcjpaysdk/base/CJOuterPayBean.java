package com.android.ttcjpaysdk.base;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KBû\u0001\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0002\u0010\u001eJ\u0006\u00102\u001a\u00020/J\u0006\u00103\u001a\u00020\u0004J\u0010\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u0004\u0018\u00010\u0004J\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0006\u0010:\u001a\u00020\u0004J\b\u0010;\u001a\u0004\u0018\u00010\u0004J\b\u0010<\u001a\u0004\u0018\u00010\u0004J\u0006\u0010=\u001a\u00020\u0011J\u0006\u0010>\u001a\u00020\u0011J\u0006\u0010?\u001a\u00020\u0011J\u0006\u0010@\u001a\u00020\u0011J\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0011J\u0006\u0010C\u001a\u00020\u0011J\u0006\u0010D\u001a\u00020\u0011J\u0006\u0010E\u001a\u00020\u0011J\u0010\u0010F\u001a\u00020G2\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0014\u0010H\u001a\u0004\u0018\u00010)2\b\u0010\u001c\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\u00002\b\u0010J\u001a\u0004\u0018\u00010/R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0012\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "Ljava/io/Serializable;", "dataMap", "", "", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "callbackId", "", "process_info", CJOuterPayManager.KEY_ROOTER_TIME, "cold_start", "nickName", "avatar", CJOuterPayManager.KEY_BINDPHONE, "caller_app", "isInvokeForInnerByPkg", "", "container_way", "Lcom/android/ttcjpaysdk/base/ContainerWay;", "extTrackParams", "", "industry_ext", "", CJOuterPayManager.KEY_DY_PAY_VERSION, "token", "pay_source", "pay_scene_source", "payInfo", "isFromAccountSwitch", "(Ljava/util/Map;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/android/ttcjpaysdk/base/ContainerWay;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "callerRiskInfo", "clientSessionId", "coldStartTime", "", "()Z", "setFromAccountSwitch", "(Z)V", "isHidePageLoading", "setHidePageLoading", "payInfoBean", "Lcom/android/ttcjpaysdk/base/DyPayInfoBean;", "getPayInfoBean", "()Lcom/android/ttcjpaysdk/base/DyPayInfoBean;", "setPayInfoBean", "(Lcom/android/ttcjpaysdk/base/DyPayInfoBean;)V", "payInfoJson", "Lorg/json/JSONObject;", "getPayInfoJson", "()Lorg/json/JSONObject;", "getCallerInfo", "getDyPayVersion", "getExtraParam", "key", "getFrom", "Lcom/android/ttcjpaysdk/base/OuterType;", "getMerchantId", "getOuterAidInLetter", "getOuterAppId", "getPaySource", "getPrePayId", "isBdPayAPSign", "isBdPaySign", "isBdpaySupported", "isCreditSignOnly", "isInvokeForInner", "isInvokeOForInner", "isJSOrIMSceneSource", "isSignOnly", "isUseOuterLoading", "setClientSessionId", "", "toInfoBean", "toOuterPayBean", "json", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterPayBean implements Serializable {
    public static final Companion Companion = null;
    public static final String KEY_PREFETCH_DATA = "prefetch_data";
    public static final String KEY_SAAS_SCENE = "saas_scene";
    public String avatar;
    public String bindPhone;
    public int callbackId;
    public String callerRiskInfo;
    public String caller_app;
    public String clientSessionId;
    public long coldStartTime;
    public String cold_start;
    public ContainerWay container_way;
    public Map<String, String> dataMap;
    public String dypay_version;
    public Map<String, String> extTrackParams;
    public CJPayHostInfo hostInfo;
    public Map<String, ? extends Object> industry_ext;
    private boolean isFromAccountSwitch;
    private boolean isHidePageLoading;
    public boolean isInvokeForInnerByPkg;
    public String nickName;
    public String payInfo;
    private DyPayInfoBean payInfoBean;
    private JSONObject payInfoJson;
    public String pay_scene_source;
    public String pay_source;
    public String process_info;
    public String rooter_create_time;
    public String token;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJOuterPayBean$Companion;", "", "()V", "KEY_PREFETCH_DATA", "", "KEY_SAAS_SCENE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJOuterPayBean() {
        this(null, null, 0, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, 1048575, null);
    }

    private final JSONObject getPayInfoJson() {
        JSONObject r100 = this.payInfoJson;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return KtSafeMethodExtensionKt.safeCreate(this.payInfo);
    }

    public final JSONObject getCallerInfo() {
        String r100 = getExtraParam("sdk_ext");
        if (r100 == null) goto L9;
        JSONObject r101 = KtSafeMethodExtensionKt.safeCreate(r100).optJSONObject("caller_info");
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new JSONObject();
    L9:
        return new JSONObject();
    }

    public final OuterType getFrom() {
        boolean r100 = true;
        if (this.payInfo.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return OuterType.TYPE_THIRD_APP;
    L9:
        if (this.token.length() > 0) goto L12;
        r100 = false;
    L12:
        if (r100 == false) goto L15;
        return OuterType.TYPE_BROWSER;
    L15:
        return OuterType.TYPE_UNKNOWN;
    L5:
        r101 = false;
        goto L6
    }

    public final String getMerchantId() {
        String r100 = getExtraParam(DyPayConstant.K_PAY_INFO_PARAM_PARTNERID);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        return r100;
    L11:
        return getExtraParam("merchant_id");
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String getOuterAidInLetter() {
        String r100 = "appid";
        if (TextUtils.isEmpty(getExtraParam("appid")) == false) goto L7;
        r100 = "merchant_app_id";
    L7:
        return getExtraParam(r100);
    }

    public final DyPayInfoBean getPayInfoBean() {
        DyPayInfoBean r100 = this.payInfoBean;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return toInfoBean(getPayInfoJson());
    }

    public final boolean isJSOrIMSceneSource() {
        if (TextUtils.equals(this.pay_scene_source, "JSAPI") == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals(this.pay_scene_source, "IMPAY") == true) goto L8;
        return false;
    }

    public final String getDyPayVersion() {
        if (getFrom() != OuterType.TYPE_THIRD_APP) goto L10;
        DyPayInfoBean r100 = getPayInfoBean();
        if (r100 == null) goto L8;
        String r101 = r100.getOuterVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return "";
    L10:
        return this.dypay_version;
    }

    public final String getOuterAppId() {
        if (getFrom() != OuterType.TYPE_THIRD_APP) goto L9;
        DyPayInfoBean r100 = getPayInfoBean();
        if (r100 == null) goto L8;
        String r101 = r100.appId;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return "";
    L9:
        return "browser";
    }

    public final String getPaySource() {
        if (getFrom() != OuterType.TYPE_THIRD_APP) goto L9;
        DyPayInfoBean r100 = getPayInfoBean();
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.pay_source;
    L9:
        return this.pay_source;
    }

    public final String getPrePayId() {
        if (isInvokeForInner() == false) goto L22;
        String r100 = getExtraParam(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID);
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L23;
        JSONObject r102 = getPayInfoJson();
        if (r102 == null) goto L15;
        String r103 = r102.optString("token");
    L16:
        if (r103 != null) goto L18;
        r103 = "";
    L18:
        String r104 = KtSafeMethodExtensionKt.safeCreate(r103).optString("package");
        if (StringsKt.contains$default(r104, "prepay_id=", false, 2, null) == true) goto L25;
        return r100;
    L25:
        return StringsKt.replaceFirst$default(r104, "prepay_id=", "", false, 4, null);
    L15:
        r103 = null;
        goto L16
    L23:
        return r100;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L22:
        return getExtraParam(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID);
    }

    public final boolean isBdPayAPSign() {
        JSONObject r100 = getPayInfoJson();
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = KtSafeMethodExtensionKt.safeCreate(r101).optString("package");
        return OuterOrderType.Companion.isBdPayAPSign(r102);
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isBdPaySign() {
        JSONObject r100 = getPayInfoJson();
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = KtSafeMethodExtensionKt.safeCreate(r101).optString("package");
        return OuterOrderType.Companion.isBdPaySign(r102);
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isBdpaySupported() {
        if (Intrinsics.areEqual(getPaySource(), DyPayConstant.V_PAY_SOURCE_OUTER_BDPAY) == true) goto L5;
        return true;
    L5:
        JSONObject r100 = getPayInfoJson();
        OuterOrderType r101 = null;
        if (r100 == null) goto L8;
        String r102 = r100.optString("token");
    L9:
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        String r103 = KtSafeMethodExtensionKt.safeCreate(r102).optString("package");
        OuterOrderType[] r104 = OuterOrderType.values();
        int r105 = r104.length;
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L17;
        OuterOrderType r107 = r104[r106];
        if (StringsKt.equals(r107.getValue(), r103, true) == true) goto L15;
        r106 = r106 + 1;
        goto L12
    L15:
        r101 = r107;
    L17:
        if (r101 != null) goto L23;
        return false;
    L23:
        return true;
    L8:
        r102 = null;
        goto L9
    }

    public final boolean isCreditSignOnly() {
        JSONObject r100 = getPayInfoJson();
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = KtSafeMethodExtensionKt.safeCreate(r101).optString("package");
        return OuterOrderType.Companion.isBdPayCreditOnlySign(r102);
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isInvokeForInner() {
        JSONObject r100 = getPayInfoJson();
        boolean r101 = false;
        if (r100 == null) goto L12;
        String r102 = r100.optString("invoke_source");
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L12;
        r101 = true;
        goto L12
    L9:
        r103 = false;
    L12:
        if (r101 == false) goto L20;
        JSONObject r104 = getPayInfoJson();
        if (r104 == null) goto L16;
        String r105 = r104.optString("invoke_source");
    L18:
        return Intrinsics.areEqual(r105, "0");
    L16:
        r105 = null;
        goto L18
    L20:
        return this.isInvokeForInnerByPkg;
    }

    public final boolean isInvokeOForInner() {
        if (isUseOuterLoading() == false) goto L5;
    L8:
        return true;
    L5:
        if (isInvokeForInner() == true) goto L8;
        return false;
    }

    public final boolean isSignOnly() {
        JSONObject r100 = getPayInfoJson();
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = KtSafeMethodExtensionKt.safeCreate(r101).optString("package");
        return OuterOrderType.Companion.isBdPayOnlySign(r102);
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isUseOuterLoading() {
        JSONObject r100 = getPayInfoJson();
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return KtSafeMethodExtensionKt.safeCreate(r101).optBoolean("use_outer_loading");
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isFromAccountSwitch() {
        return this.isFromAccountSwitch;
    }

    public final boolean isHidePageLoading() {
        return this.isHidePageLoading;
    }

    private final DyPayInfoBean toInfoBean(JSONObject r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        DyPayInfoBean r111 = new DyPayInfoBean(null, null, null, null, null, null, null, 127, null);
        r111.pay_source = r110.optString("pay_source");
        r111.token = r110.optString("token");
        r111.dypay_version = r110.optString(CJOuterPayManager.KEY_DY_PAY_VERSION);
        r111.version = r110.optString("version");
        r111.appName = r110.optString("appName");
        r111.pkgName = r110.optString("pkgName");
        r111.appId = r110.optString("appId");
        return r111;
    }

    public final String getExtraParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (getFrom() != OuterType.TYPE_THIRD_APP) goto L13;
        JSONObject r101 = getPayInfoJson();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.has(r100) == false) goto L12;
        JSONObject r102 = getPayInfoJson();
        if (r102 != null) goto L19;
        return null;
    L19:
        return r102.optString(r100);
    L12:
        return KtSafeMethodExtensionKt.safeCreate(r101.optString("token")).optString(r100);
    L13:
        Map<String, String> r103 = this.dataMap;
        if (r103 != null) goto L16;
        return null;
    L16:
        return r103.get(r100);
    }

    public final void setClientSessionId(String r100) {
        this.clientSessionId = r100;
    }

    public final void setFromAccountSwitch(boolean r100) {
        this.isFromAccountSwitch = r100;
    }

    public final void setHidePageLoading(boolean r100) {
        this.isHidePageLoading = r100;
    }

    public final void setPayInfoBean(DyPayInfoBean r100) {
        this.payInfoBean = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CJOuterPayBean toOuterPayBean(JSONObject r210) {
        if (r210 != null) goto L6;
        return null;
    L6:
        Object[] r110 = 0 == true ? 1 : 0;
        CJOuterPayBean r111 = new CJOuterPayBean(null, null, 0, null, null, null, null, null, null, null, false, null, null, null, r110, null, null, null, null, false, 1048575, null);
        r111.rooter_create_time = r210.optString(CJOuterPayManager.KEY_ROOTER_TIME);
        r111.cold_start = r210.optString("cold_start");
        r111.nickName = r210.optString("nickName");
        r111.avatar = r210.optString("avatar");
        r111.bindPhone = r210.optString(CJOuterPayManager.KEY_BINDPHONE);
        r111.dypay_version = r210.optString(CJOuterPayManager.KEY_DY_PAY_VERSION);
        r111.token = r210.optString("token");
        r111.pay_source = r210.optString("pay_source");
        r111.payInfo = r210.optString("payInfo");
        r111.caller_app = r210.optString("caller_app");
        r111.pay_scene_source = r210.optString("pay_scene_source");
        return r111;
    }

    public CJOuterPayBean(Map<String, String> r110, CJPayHostInfo r111, int r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, ContainerWay r217, Map<String, String> r218, Map<String, ? extends Object> r219, String r310, String r311, String r312, String r313, String r314, boolean r315) {
        Intrinsics.checkNotNullParameter(r111, "hostInfo");
        Intrinsics.checkNotNullParameter(r210, CJOuterPayManager.KEY_ROOTER_TIME);
        Intrinsics.checkNotNullParameter(r211, "cold_start");
        Intrinsics.checkNotNullParameter(r212, "nickName");
        Intrinsics.checkNotNullParameter(r213, "avatar");
        Intrinsics.checkNotNullParameter(r214, CJOuterPayManager.KEY_BINDPHONE);
        Intrinsics.checkNotNullParameter(r215, "caller_app");
        Intrinsics.checkNotNullParameter(r217, "container_way");
        Intrinsics.checkNotNullParameter(r310, CJOuterPayManager.KEY_DY_PAY_VERSION);
        Intrinsics.checkNotNullParameter(r311, "token");
        Intrinsics.checkNotNullParameter(r312, "pay_source");
        Intrinsics.checkNotNullParameter(r313, "pay_scene_source");
        Intrinsics.checkNotNullParameter(r314, "payInfo");
        this.dataMap = r110;
        this.hostInfo = r111;
        this.callbackId = r112;
        this.process_info = r113;
        this.rooter_create_time = r210;
        this.cold_start = r211;
        this.nickName = r212;
        this.avatar = r213;
        this.bindPhone = r214;
        this.caller_app = r215;
        this.isInvokeForInnerByPkg = r216;
        this.container_way = r217;
        this.extTrackParams = r218;
        this.industry_ext = r219;
        this.dypay_version = r310;
        this.token = r311;
        this.pay_source = r312;
        this.pay_scene_source = r313;
        this.payInfo = r314;
        this.isFromAccountSwitch = r315;
    }

    public /* synthetic */ CJOuterPayBean(Map r210, CJPayHostInfo r211, int r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, boolean r312, ContainerWay r313, Map r314, Map r315, String r316, String r317, String r318, String r319, String r410, boolean r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        Map r100 = new HashMap();
    L7:
        if ((r412 & 2) == 0) goto L9;
        CJPayHostInfo r101 = new CJPayHostInfo();
    L11:
        if ((r412 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r412 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r111 = "";
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r412 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        ContainerWay r115 = ContainerWay.OTHER;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Map r106 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        Map r107 = null;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r412 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r412 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r412 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r412 & 262144) == 0) goto L77;
        String r119 = "";
    L79:
        if ((r412 & 524288) == 0) goto L81;
        boolean r109 = false;
    L82:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r107 = r315;
        goto L59
    L53:
        r106 = r314;
        goto L55
    L49:
        r115 = r313;
        goto L51
    L45:
        r114 = r312;
        goto L47
    L41:
        r113 = r311;
        goto L43
    L37:
        r112 = r310;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
