package com.android.ttcjpaysdk.bindcard.base.applog;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u0006\u0010\u001a\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK", "", "WALLET_ADDBCARD_PAY_AGREEMENT_POP_SHOW", "appId", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "merchantId", "payAgreementSource", "buildCommonParams", "", "json", "Lorg/json/JSONObject;", "clickAgreeBtn", "clickAgreement", "agreementName", "clickDisagreeBtn", "initParams", "Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger$AgreementSource;", "logEvent", "event", "paramMap", "Ljava/util/HashMap;", "", "show", "AgreementSource", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAgreementDialogLogger implements MvpLogger {
    private final String WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK;
    private final String WALLET_ADDBCARD_PAY_AGREEMENT_POP_SHOW;
    private String appId;
    private CJPayHostInfo hostInfo;
    private String merchantId;
    private String payAgreementSource;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/CJPayAgreementDialogLogger$AgreementSource;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "CARD_BIN", "SELECT_CARD_TYPE", "SILENT_SELECT_CARD_TYPE", "TWO_ELEMENTS", "FOUR_ELEMENTS", "AUTH", "AUTH_DENOISE", "UNION_PAY", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AgreementSource extends Enum<AgreementSource> {
        private static final /* synthetic */ AgreementSource[] $VALUES = null;
        public static final AgreementSource AUTH = null;
        public static final AgreementSource AUTH_DENOISE = null;
        public static final AgreementSource CARD_BIN = null;
        public static final AgreementSource FOUR_ELEMENTS = null;
        public static final AgreementSource SELECT_CARD_TYPE = null;
        public static final AgreementSource SILENT_SELECT_CARD_TYPE = null;
        public static final AgreementSource TWO_ELEMENTS = null;
        public static final AgreementSource UNION_PAY = null;
        private final String desc;

        private static final /* synthetic */ AgreementSource[] $values() {
            return new AgreementSource[]{CARD_BIN, SELECT_CARD_TYPE, SILENT_SELECT_CARD_TYPE, TWO_ELEMENTS, FOUR_ELEMENTS, AUTH, AUTH_DENOISE, UNION_PAY};
        }

        public static AgreementSource valueOf(String r100) {
            return (AgreementSource) a.a(AgreementSource.class, r100);
        }

        public static AgreementSource[] values() {
            return (AgreementSource[]) $VALUES.clone();
        }

        static {
            CARD_BIN = new AgreementSource("CARD_BIN", 0, "绑卡首页");
            SELECT_CARD_TYPE = new AgreementSource("SELECT_CARD_TYPE", 1, "选择卡类型");
            SILENT_SELECT_CARD_TYPE = new AgreementSource("SILENT_SELECT_CARD_TYPE", 2, "实名静默授权卡类型选择");
            TWO_ELEMENTS = new AgreementSource("TWO_ELEMENTS", 3, "二要素");
            FOUR_ELEMENTS = new AgreementSource("FOUR_ELEMENTS", 4, "四要素");
            AUTH = new AgreementSource("AUTH", 5, "实名授权");
            AUTH_DENOISE = new AgreementSource("AUTH_DENOISE", 6, "实名授权降噪");
            UNION_PAY = new AgreementSource("UNION_PAY", 7, "云闪付");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        private AgreementSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.desc = r102;
        }
    }

    public final void clickAgreeBtn() {
        logEvent(this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", "同意并继续"), TuplesKt.to("pay_agreement_source", this.payAgreementSource)}));
    }

    public final void clickDisagreeBtn() {
        logEvent(this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", "不同意"), TuplesKt.to("pay_agreement_source", this.payAgreementSource)}));
    }

    public final void show() {
        logEvent(this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_SHOW, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("pay_agreement_source", this.payAgreementSource)}));
    }

    public CJPayAgreementDialogLogger() {
        this.merchantId = "";
        this.appId = "";
        this.payAgreementSource = "";
        this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_SHOW = "wallet_addbcard_pay_agreement_pop_show";
        this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK = "wallet_addbcard_pay_agreement_pop_click";
    }

    private final void buildCommonParams(JSONObject r100) {
        Object r101 = "";
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L15
        int r103 = 0;
        if (r102.isRealName() == false) goto L6;
        int r104 = 0;
    L7:
        r100.put("needidentify", r104);     // Catch: Exception -> L15
        if (r102.isHasPassword() == false) goto L10;
        r103 = 1;
    L10:
        r100.put("haspass", r103);     // Catch: Exception -> L15
        r100.put("is_onestep", 1);     // Catch: Exception -> L15
        r100.put("show_onestep", 1);     // Catch: Exception -> L15
        r100.put("is_auth", CJPayBindCardLogUtils.getIsAuth());     // Catch: Exception -> L15
        r100.put("is_showphone", CJPayBindCardLogUtils.getIsShowPhone());     // Catch: Exception -> L15
        r100.put("addbcard_type", "");     // Catch: Exception -> L15
        if (CJPayBindCardLogUtils.getIsEntryNameInit() == false) goto L13;
        r101 = Integer.valueOf(CJPayBindCardLogUtils.getEntryName());     // Catch: Exception -> L15
    L13:
        r100.put("entry_name", r101);     // Catch: Exception -> L15
        return;
    L6:
        r104 = 1;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAgreementDialogLogger#buildCommonParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAgreementDialogLogger#buildCommonParams", e);
    }

    public final void clickAgreement(String r100) {
        Intrinsics.checkNotNullParameter(r100, "agreementName");
        logEvent(this.WALLET_ADDBCARD_PAY_AGREEMENT_POP_CLICK, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", r100), TuplesKt.to("pay_agreement_source", this.payAgreementSource)}));
    }

    public final void initParams(AgreementSource r100) {
        Intrinsics.checkNotNullParameter(r100, "payAgreementSource");
        CJPayHostInfo r101 = BindCardCommonInfoUtil.INSTANCE.getHostInfo();
        this.hostInfo = r101;
        CJPayHostInfo r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
        r101 = null;
    L5:
        String r103 = r101.merchantId;
        String r104 = "";
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.merchantId = r103;
        CJPayHostInfo r105 = this.hostInfo;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("hostInfo");
    L12:
        String r106 = r102.appId;
        if (r106 == null) goto L16;
        r104 = r106;
    L16:
        this.appId = r104;
        this.payAgreementSource = r100.getDesc();
        return;
    L11:
        r102 = r105;
        goto L12
    }

    public final void logEvent(String r100, HashMap<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (StringsKt.isBlank(this.payAgreementSource) == false) goto L5;
        return;
    L5:
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams(this.merchantId, this.appId);
        buildCommonParams(r102);
        if (r101 == null) goto L12;
        Iterator<Map.Entry<String, Object>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, Object> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
    L12:
        if (TextUtils.isEmpty(CJPayBindCardLogUtils.getSource()) == true) goto L14;
        r102.put("source", CJPayBindCardLogUtils.getSource());
    L14:
        CJPayBindCardLogUtils.doReport(r100, new JSONObject[]{r102});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logEvent$default(CJPayAgreementDialogLogger r100, String r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.logEvent(r101, r102);
    }
}
