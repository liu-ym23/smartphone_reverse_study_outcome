package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.bean;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.bean.DyPayProcessConfig;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.activity.CJPayFrontData;
import com.android.ttcjpaysdk.thirdparty.front.counter.activity.CJPayReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0010\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+J\u0006\u0010,\u001a\u00020&J\u0006\u0010-\u001a\u00020&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/bean/DyPayData;", "", "()V", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "config", "Lcom/android/ttcjpaysdk/base/service/bean/DyPayProcessConfig;", "et_from_type", "", "hasShowRetain", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "jhTradeNoForResultPromotion", "lynx_call_ttpay_time", "", "lynx_create_order_end_time", "lynx_create_order_start_time", "needEndPageAnim", "", "needFinishWithSource", "needResultPage", "newBindCard", "", "noLayer", "noMask", "noPasswordPay", "pageMode", "payChainTraceParams", "rawString", "sdk_call_start_time", "ttPayConfirmStart", "ttPayEnd", "ttPayQueryStart", "ttPayStart", "getData", "getPwdCheckWay", "isHalfMode", "setBindCard", "", "setConfirmTime", "setEndTime", "setLynxCreateOrderTime", "data", "Lorg/json/JSONObject;", "setNoPasswordPay", "setStartTime", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayData {
    public static final Companion Companion = null;
    private static final String FRONT_HAS_NOT_SHOW_RETAIN = null;
    private static final String FRONT_HAS_SHOW_RETAIN = null;
    private static final String FRONT_NEED_RESULT = null;
    private static final String FRONT_NOT_NEED_RESULT = null;
    private static final String FRONT_PAGE_MODE_FULL = null;
    private static final String FRONT_PAGE_MODE_HALF = null;
    private static final String FRONT_TYPE_ET = null;
    private static final String FRONT_TYPE_STANDARD = null;
    public CJPayCheckoutCounterResponseBean checkoutResponseBean;
    public DyPayProcessConfig config;
    public String et_from_type;
    public String hasShowRetain;
    public CJPayHostInfo hostInfo;
    public String jhTradeNoForResultPromotion;
    public long lynx_call_ttpay_time;
    public long lynx_create_order_end_time;
    public long lynx_create_order_start_time;
    public boolean needEndPageAnim;
    public boolean needFinishWithSource;
    public String needResultPage;
    private int newBindCard;
    public boolean noLayer;
    public boolean noMask;
    private int noPasswordPay;
    public String pageMode;
    public String payChainTraceParams;
    public String rawString;
    public long sdk_call_start_time;
    private long ttPayConfirmStart;
    private long ttPayEnd;
    private long ttPayQueryStart;
    private long ttPayStart;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/dypay/bean/DyPayData$Companion;", "", "()V", "FRONT_HAS_NOT_SHOW_RETAIN", "", "getFRONT_HAS_NOT_SHOW_RETAIN", "()Ljava/lang/String;", "FRONT_HAS_SHOW_RETAIN", "getFRONT_HAS_SHOW_RETAIN", "FRONT_NEED_RESULT", "getFRONT_NEED_RESULT", "FRONT_NOT_NEED_RESULT", "getFRONT_NOT_NEED_RESULT", "FRONT_PAGE_MODE_FULL", "getFRONT_PAGE_MODE_FULL", "FRONT_PAGE_MODE_HALF", "getFRONT_PAGE_MODE_HALF", "FRONT_TYPE_ET", "getFRONT_TYPE_ET", "FRONT_TYPE_STANDARD", "getFRONT_TYPE_STANDARD", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getFRONT_HAS_NOT_SHOW_RETAIN() {
            return DyPayData.access$getFRONT_HAS_NOT_SHOW_RETAIN$cp();
        }

        public final String getFRONT_HAS_SHOW_RETAIN() {
            return DyPayData.access$getFRONT_HAS_SHOW_RETAIN$cp();
        }

        public final String getFRONT_NEED_RESULT() {
            return DyPayData.access$getFRONT_NEED_RESULT$cp();
        }

        public final String getFRONT_NOT_NEED_RESULT() {
            return DyPayData.access$getFRONT_NOT_NEED_RESULT$cp();
        }

        public final String getFRONT_PAGE_MODE_FULL() {
            return DyPayData.access$getFRONT_PAGE_MODE_FULL$cp();
        }

        public final String getFRONT_PAGE_MODE_HALF() {
            return DyPayData.access$getFRONT_PAGE_MODE_HALF$cp();
        }

        public final String getFRONT_TYPE_ET() {
            return DyPayData.access$getFRONT_TYPE_ET$cp();
        }

        public final String getFRONT_TYPE_STANDARD() {
            return DyPayData.access$getFRONT_TYPE_STANDARD$cp();
        }
    }

    public final void setBindCard() {
        this.newBindCard = 1;
    }

    public final void setNoPasswordPay() {
        this.noPasswordPay = 1;
    }

    static {
        Companion = new Companion(null);
        FRONT_TYPE_ET = "front_type_et";
        FRONT_TYPE_STANDARD = CJPayFrontData.FRONT_TYPE_STANDARD;
        FRONT_PAGE_MODE_FULL = "fullpage";
        FRONT_PAGE_MODE_HALF = "halfpage";
        FRONT_NOT_NEED_RESULT = "0";
        FRONT_NEED_RESULT = "1";
        FRONT_HAS_NOT_SHOW_RETAIN = "0";
        FRONT_HAS_SHOW_RETAIN = "1";
    }

    public final String getData() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L7
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L7
        r101.put("no_password_pay", this.noPasswordPay);     // Catch: Exception -> L7
        r101.put("new_bind_card", this.newBindCard);     // Catch: Exception -> L7
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
        r102.put("C_ORDER_TTPAY_START", this.ttPayStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_TTPAY_CONFIRM_PAY_START", this.ttPayConfirmStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_TTPAY_CHECK_PAY_START", this.ttPayQueryStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_TTPAY_END", this.ttPayEnd);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_START", CJPayReportData.orderCreateStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_JSB_START", CJPayReportData.orderCreateJSBStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_JSB_END", CJPayReportData.orderCreateJSBEnd);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_NET_START", CJPayReportData.orderCreateNetStart);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_NET_END", CJPayReportData.orderCreateNetEnd);     // Catch: Exception -> L7
        r102.put("C_ORDER_CREATE_END", CJPayReportData.orderCreateEnd);     // Catch: Exception -> L7
        r102.put("C_ORDER_TTPAY_CALL_START", CJPayReportData.orderTTPayCallStart);     // Catch: Exception -> L7
        r100.put("performance_common_params", r101);     // Catch: Exception -> L7
        r100.put("performace_stages", r102);     // Catch: Exception -> L7
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("sdk_performance", r100);     // Catch: Exception -> L7
        JSONObject r104 = CJPayReportData.createOrderResponseJSON;     // Catch: Exception -> L7
        if (r104 == null) goto L5;
        r103.put("create_order_response", r104);     // Catch: Exception -> L7
    L5:
        return r103.toString();
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyPayData#getData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyPayData#getData", e);
        return "";
    }

    public final String getPwdCheckWay() {
        CJPayCheckoutCounterResponseBean r100 = this.checkoutResponseBean;
        String r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.isAssetStandard());
    L6:
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();
    L10:
        if (r103 == false) goto L25;
        CJPayCheckoutCounterResponseBean r104 = this.checkoutResponseBean;
        if (r104 == null) goto L18;
        AssetInfoBean r105 = r104.used_asset_info;
        if (r105 == null) goto L18;
        AssetInfoBean.ExtInfo r106 = r105.ext_info;
        if (r106 == null) goto L18;
        String r107 = r106.pwd_check_way;
    L19:
        if (r104 == null) goto L24;
        CJPayUserInfo r108 = r104.user_info;
        if (r108 == null) goto L24;
        r101 = r108.pwd_check_way;
    L24:
        return KtSafeMethodExtensionKt.or(r107, KtSafeMethodExtensionKt.or(r101, "0"));
    L18:
        r107 = null;
        goto L19
    L25:
        CJPayCheckoutCounterResponseBean r109 = this.checkoutResponseBean;
        if (r109 == null) goto L31;
        CJPayUserInfo r110 = r109.user_info;
        if (r110 == null) goto L31;
        r101 = r110.pwd_check_way;
    L31:
        return KtSafeMethodExtensionKt.or(r101, "0");
    L8:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final boolean hasShowRetain() {
        return Intrinsics.areEqual(FRONT_HAS_SHOW_RETAIN, this.hasShowRetain);
    }

    public final boolean isHalfMode() {
        return Intrinsics.areEqual(FRONT_PAGE_MODE_HALF, this.pageMode);
    }

    public final boolean needResultPage() {
        return Intrinsics.areEqual(FRONT_NEED_RESULT, this.needResultPage);
    }

    public DyPayData() {
        this.needEndPageAnim = true;
        this.config = new DyPayProcessConfig();
    }

    public final void setConfirmTime() {
        this.ttPayConfirmStart = System.currentTimeMillis();
        this.ttPayQueryStart = System.currentTimeMillis();
    }

    public final void setEndTime() {
        this.ttPayEnd = System.currentTimeMillis();
    }

    public final void setStartTime() {
        this.ttPayStart = System.currentTimeMillis();
    }

    public static final /* synthetic */ String access$getFRONT_HAS_NOT_SHOW_RETAIN$cp() {
        return FRONT_HAS_NOT_SHOW_RETAIN;
    }

    public static final /* synthetic */ String access$getFRONT_HAS_SHOW_RETAIN$cp() {
        return FRONT_HAS_SHOW_RETAIN;
    }

    public static final /* synthetic */ String access$getFRONT_NEED_RESULT$cp() {
        return FRONT_NEED_RESULT;
    }

    public static final /* synthetic */ String access$getFRONT_NOT_NEED_RESULT$cp() {
        return FRONT_NOT_NEED_RESULT;
    }

    public static final /* synthetic */ String access$getFRONT_PAGE_MODE_FULL$cp() {
        return FRONT_PAGE_MODE_FULL;
    }

    public static final /* synthetic */ String access$getFRONT_PAGE_MODE_HALF$cp() {
        return FRONT_PAGE_MODE_HALF;
    }

    public static final /* synthetic */ String access$getFRONT_TYPE_ET$cp() {
        return FRONT_TYPE_ET;
    }

    public static final /* synthetic */ String access$getFRONT_TYPE_STANDARD$cp() {
        return FRONT_TYPE_STANDARD;
    }

    public final void setLynxCreateOrderTime(JSONObject r100) {
        if (r100 == null) goto L7;
        JSONObject r101 = r100.optJSONObject("timestamp_info");
        if (r101 == null) goto L8;
        this.lynx_create_order_start_time = r101.optLong("create_order", 0);
        this.lynx_create_order_end_time = r101.optLong("create_order_response", 0);
        this.lynx_call_ttpay_time = r101.optLong("launch_ttpay", 0);
        this.sdk_call_start_time = System.currentTimeMillis();
        return;
    L8:
        return;
    }
}
