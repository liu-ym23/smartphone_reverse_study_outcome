package com.android.ttcjpaysdk.base.service.bean;

import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.service.ICJPayNormalBindCardService;
import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.base.service.IDyPayService;
import com.android.ttcjpaysdk.base.service.IPayAgainService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020\u0000J\u0014\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/DyPayProcessConfig;", "", "()V", "bindCardInfo", "", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "closeWebView", "", "commonLogParams", "Lorg/json/JSONObject;", "configId", "", "dyPayParentView", "Landroid/view/ViewGroup;", "errorCode", "errorMsg", "extParam", "forbidRetainDefault", "Ljava/lang/Boolean;", "frontInfo", "hostInfoJSON", "integratedCounterParams", "Lcom/android/ttcjpaysdk/base/service/bean/IntegratedCounterParams;", "isAssetStandard", "isFromPaymentMethod", "isInvokeOForInner", "isNewStyle", "listenerBuilder", "Lcom/android/ttcjpaysdk/base/service/IDyPayService$DyPayListenerBuilder;", "needFinishTogether", "outerCounterParams", "Lcom/android/ttcjpaysdk/base/service/bean/OuterCounterParams;", "outerTrackParamsForResultPage", "", "payType", "processInfo", "rawString", InvRouter.SCENES, "Lcom/android/ttcjpaysdk/base/service/bean/DyPayProcessConfig$Scenes;", "source", "tradeInfo", "copy", "copyJSONObject", "jsonObject", "isIndependentOuterPay", "isOuterPay", "isOuterPayForOut", "isPayAgainForFastPay", "Scenes", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayProcessConfig {
    public String bindCardInfo;
    public CJContext cjContext;
    public boolean closeWebView;
    public JSONObject commonLogParams;
    public long configId;
    public ViewGroup dyPayParentView;
    public String errorCode;
    public String errorMsg;
    public String extParam;
    public Boolean forbidRetainDefault;
    public JSONObject frontInfo;
    public JSONObject hostInfoJSON;
    public IntegratedCounterParams integratedCounterParams;
    public Boolean isAssetStandard;
    public boolean isFromPaymentMethod;
    public boolean isInvokeOForInner;
    public boolean isNewStyle;
    public IDyPayService.DyPayListenerBuilder listenerBuilder;
    public boolean needFinishTogether;
    public OuterCounterParams outerCounterParams;
    public Map<String, String> outerTrackParamsForResultPage;
    public String payType;
    public JSONObject processInfo;
    public String rawString;
    public Scenes scenes;
    public String source;
    public String tradeInfo;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BG\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/DyPayProcessConfig$Scenes;", "", "scenesType", "", "scenesName", "", "methodFromScene", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;", "payAgainScene", "Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;", "payNewCardBizType", "Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;", "payNewCardType", "Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;", "isNotifyAfterPayFailed", "", "activityRoot", "(Ljava/lang/String;IILjava/lang/String;Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;ZLjava/lang/String;)V", "ET", "Standard", "INTEGRATED", "INTEGRATED_OUTER", "O_OUTER_INDEPENDENT", "PAY_AGAIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Scenes extends Enum<Scenes> {
        private static final /* synthetic */ Scenes[] $VALUES = null;
        public static final Scenes ET = null;
        public static final Scenes INTEGRATED = null;
        public static final Scenes INTEGRATED_OUTER = null;
        public static final Scenes O_OUTER_INDEPENDENT = null;
        public static final Scenes PAY_AGAIN = null;
        public static final Scenes Standard = null;
        public final String activityRoot;
        public final boolean isNotifyAfterPayFailed;
        public final ICJPayPaymentMethodService.FromScene methodFromScene;
        public final IPayAgainService.FromScene payAgainScene;
        public final ICJPayNormalBindCardService.BizType payNewCardBizType;
        public final ICJPayNormalBindCardService.SourceType payNewCardType;
        public final String scenesName;
        public final int scenesType;

        private static final /* synthetic */ Scenes[] $values() {
            return new Scenes[]{ET, Standard, INTEGRATED, INTEGRATED_OUTER, O_OUTER_INDEPENDENT, PAY_AGAIN};
        }

        public static Scenes valueOf(String r100) {
            return (Scenes) a.a(Scenes.class, r100);
        }

        public static Scenes[] values() {
            return (Scenes[]) $VALUES.clone();
        }

        static {
            ICJPayPaymentMethodService.FromScene r100 = ICJPayPaymentMethodService.FromScene.FROM_FRONT_ET;
            IPayAgainService.FromScene r101 = IPayAgainService.FromScene.FROM_NEW_ET;
            ICJPayNormalBindCardService.BizType r102 = ICJPayNormalBindCardService.BizType.ECommerce;
            ICJPayNormalBindCardService.SourceType r210 = ICJPayNormalBindCardService.SourceType.FrontPay;
            ET = new Scenes("ET", 0, 0, "电商", r100, r101, r102, r210, false, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayETActivity");
            Standard = new Scenes("Standard", 1, 1, "标准前置", ICJPayPaymentMethodService.FromScene.FROM_FRONT_STANDARD, IPayAgainService.FromScene.FROM_NEW_STANDARD, ICJPayNormalBindCardService.BizType.LocalLife, r210, false, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayStandardActivity");
            ICJPayPaymentMethodService.FromScene r110 = ICJPayPaymentMethodService.FromScene.FROM_INTEGRATE;
            IPayAgainService.FromScene r111 = IPayAgainService.FromScene.FROM_NEW_INTEGRATE;
            ICJPayNormalBindCardService.BizType r103 = ICJPayNormalBindCardService.BizType.Integrated;
            ICJPayNormalBindCardService.SourceType r211 = ICJPayNormalBindCardService.SourceType.Pay;
            INTEGRATED = new Scenes("INTEGRATED", 2, 2, "聚合收银台", r110, r111, r103, r211, true, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayStandardActivity");
            INTEGRATED_OUTER = new Scenes("INTEGRATED_OUTER", 3, 3, "聚合唤端", r110, r111, ICJPayNormalBindCardService.BizType.Integrated_Outer, r211, true, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayStandardActivity");
            ICJPayPaymentMethodService.FromScene r104 = ICJPayPaymentMethodService.FromScene.FROM_STANDARD;
            O_OUTER_INDEPENDENT = new Scenes("O_OUTER_INDEPENDENT", 4, 5, "追光独立收银台", r104, IPayAgainService.FromScene.FROM_O_OUTER_INDEPENDENT, ICJPayNormalBindCardService.BizType.BDPay_Outer, r211, true, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayStandardActivity");
            PAY_AGAIN = new Scenes("PAY_AGAIN", 5, 6, "二次支付", r104, IPayAgainService.FromScene.FROM_SUPER_PAY_FAIL, ICJPayNormalBindCardService.BizType.SUPER_PAY_FAIL_PAY_AGAIN, ICJPayNormalBindCardService.SourceType.SuperPay, true, "com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayStandardActivity");
            $VALUES = $values();
        }

        private Scenes(String r100, int r101, int r102, String r103, ICJPayPaymentMethodService.FromScene r104, IPayAgainService.FromScene r105, ICJPayNormalBindCardService.BizType r106, ICJPayNormalBindCardService.SourceType r107, boolean r108, String r110) {
            super(r100, r101);
            this.scenesType = r102;
            this.scenesName = r103;
            this.methodFromScene = r104;
            this.payAgainScene = r105;
            this.payNewCardBizType = r106;
            this.payNewCardType = r107;
            this.isNotifyAfterPayFailed = r108;
            this.activityRoot = r110;
        }
    }

    public final DyPayProcessConfig copy() {
        DyPayProcessConfig r100 = new DyPayProcessConfig();
        r100.tradeInfo = this.tradeInfo;
        r100.rawString = this.rawString;
        r100.hostInfoJSON = copyJSONObject(this.hostInfoJSON);
        r100.bindCardInfo = this.bindCardInfo;
        r100.closeWebView = this.closeWebView;
        r100.source = this.source;
        r100.frontInfo = copyJSONObject(this.frontInfo);
        r100.scenes = this.scenes;
        r100.listenerBuilder = this.listenerBuilder;
        IntegratedCounterParams r101 = this.integratedCounterParams;
        OuterCounterParams r102 = null;
        if (r101 == null) goto L5;
        IntegratedCounterParams r103 = r101.copy();
    L6:
        r100.integratedCounterParams = r103;
        OuterCounterParams r104 = this.outerCounterParams;
        if (r104 == null) goto L9;
        r102 = r104.copy();
    L9:
        r100.outerCounterParams = r102;
        r100.isNewStyle = this.isNewStyle;
        r100.errorCode = this.errorCode;
        r100.processInfo = copyJSONObject(this.processInfo);
        r100.isAssetStandard = this.isAssetStandard;
        r100.forbidRetainDefault = this.forbidRetainDefault;
        r100.errorMsg = this.errorMsg;
        r100.extParam = this.extParam;
        r100.commonLogParams = copyJSONObject(this.commonLogParams);
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public final boolean isIndependentOuterPay() {
        if (this.scenes != Scenes.O_OUTER_INDEPENDENT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOuterPay() {
        if (this.scenes != Scenes.O_OUTER_INDEPENDENT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPayAgainForFastPay() {
        if (this.scenes != Scenes.PAY_AGAIN) goto L5;
        return true;
    L5:
        return false;
    }

    public DyPayProcessConfig() {
        this.closeWebView = true;
        this.payType = "";
        this.rawString = "";
        Boolean r100 = Boolean.FALSE;
        this.isAssetStandard = r100;
        this.forbidRetainDefault = r100;
        this.extParam = "";
    }

    public final boolean isOuterPayForOut() {
        if (isOuterPay() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isInvokeOForInner == true) goto L7;
        return true;
    }

    private final JSONObject copyJSONObject(JSONObject r100) {
        if (r100 == null) goto L11;
        return new JSONObject(r100.toString());
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyPayProcessConfig#copyJSONObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyPayProcessConfig#copyJSONObject", e);
        return null;
    L11:
        return null;
    }
}
