package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.serverevent.ServerEventManager;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.ui.component.CJLoading;
import com.android.ttcjpaysdk.base.ui.component.CJToast;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJWalletCashierBtmUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.CJUnifyPreVerifyManager;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.UnifyPreVerifyVMContext;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyListener;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.UnifyCommonBizParams;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyAction;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyResultAction;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyLogParams;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 g2\u00020\u0001:\u0001gB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J\b\u0010\u001a\u001a\u00020\u0017H\u0004J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0004J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020 H\u0004J\b\u0010!\u001a\u00020\u0017H\u0004J\u0006\u0010\"\u001a\u00020#J\n\u0010$\u001a\u0004\u0018\u00010%H\u0004J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u001dH\u0004J\b\u0010)\u001a\u00020*H\u0004J\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u0011J\n\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u00010\u00112\u0006\u00101\u001a\u00020\u0011J*\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u00010\u00112\u0006\u00101\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011J\u0006\u00105\u001a\u00020\u0003J\u001a\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u001dH\u0004J\b\u0010:\u001a\u00020\u0017H\u0016J\u001a\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010?\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010@\u001a\u00020\u0006H\u0002J\u000f\u0010A\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020\u0017H\u0004J\b\u0010D\u001a\u00020\u0017H\u0004J\b\u0010E\u001a\u00020\u0017H\u0004J\b\u0010F\u001a\u00020\u0017H\u0004J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u0006H\u0004J\u0014\u0010I\u001a\u00020\u00172\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0011H\u0004J\b\u0010K\u001a\u00020\u0017H\u0004J\b\u0010L\u001a\u00020\u0017H\u0004J\u0012\u0010M\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0004J\b\u0010N\u001a\u00020\u0006H\u0016J\u0012\u0010O\u001a\u00020\u00172\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020\u0017H\u0016Jn\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00112:\b\u0002\u0010X\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0017\u0018\u00010Y2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010_\u001a\u00020\u00172\b\u0010`\u001a\u0004\u0018\u00010\u0011H\u0004J\b\u0010a\u001a\u00020\u0017H\u0016J\b\u0010b\u001a\u00020\u0017H\u0016J&\u0010c\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\u00062\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010U\u001a\u00020VH\u0004J$\u0010d\u001a\u00020\u00172\b\u0010>\u001a\u0004\u0018\u00010\u00002\u0006\u0010e\u001a\u0002082\b\b\u0002\u0010f\u001a\u00020\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/base/UnifyPreVerifyBaseVM;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/IUnifyPreVerifyComponent;", "verifyVMContext", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyVMContext;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyVMContext;)V", "encryptEnable", "", "getEncryptEnable", "()Z", "encryptEnable$delegate", "Lkotlin/Lazy;", "initBtm", "<set-?>", "isQueryConnecting", "setQueryConnecting", "(Z)V", UnifyPreVerifyBaseVM.KEY_POP_SOURCE, "", "getPopSource", "()Ljava/lang/String;", "setPopSource", "(Ljava/lang/String;)V", "backToCashierHome", "", "buildSelectedAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "canCancelPay", "changePayMethod", "data", "Lorg/json/JSONObject;", "checkByServer", "createHostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "degradeCashierUi", "getContext", "Landroid/content/Context;", "getCurrentVerifyItem", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyItem;", "getEmbeddedView", "Landroid/view/View;", "getLynxDialogExtraData", "getOnCommonDialogListener", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/CJUnifyPreVerifyManager$OnCommonDialogListener;", "getPaymentInstructionIcon", "getPaymentInstructionText", "getTitle", "getUnifyEncryptData", "pwd", "salt", "source", "getUnifyEncryptDataWithoutMd5", "rawData", "field", "getVMContext", "gotoAnotherVerify", "newType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "extParams", "handleTradeConfirmFailed", "handleTradeConfirmIntercept", "cashierResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "preVM", "handleTradeConfirmResp", "isBioVerifyDegrade", "leftCanBack", "()Ljava/lang/Boolean;", "markQueryEnd", "markQueryStart", "notifyLoginInvalid", "notifyToHideLoading", "notifyToSetConfirmStatus", "visible", "notifyToShowLoading", "loadingText", "notifyToUpdateLeftButton", "notifyToUpdateTitle", "notifyToUpdateTitleBar", "onBackPressed", "onEmbeddedViewHide", "homePageStatus", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "onEmbeddedViewResume", "performShowSecurityLoading", "isShow", "scene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;", "loadingInfo", "extraTask", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "show", BaseHttpRequestInfo.KEY_HIT, "specialCopyWrite", "refreshCashierHome", "code", "release", "resetStatus", "showSecurityLoading", "startVerify", "preVerifyType", "extData", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UnifyPreVerifyBaseVM implements IUnifyPreVerifyComponent {
    public static final String BTM_TOKEN_LEVER_TWO_ENCRYPT_FAIL = "a24331.b14590.c47152.d0";
    public static final String BTM_TOKEN_LEVER_TWO_ENCRYPT_START = "a24331.b14590.c33692.d0";
    public static final Companion Companion = null;
    public static final String KEY_DEGRADE_TIPS = "degrade_tips";
    private static final String KEY_PAYMENT_INSTRUCTION_ICON = "payment_instruction_icon";
    private static final String KEY_PAYMENT_INSTRUCTION_TEXT = "payment_instruction_text";
    public static final String KEY_POP_SOURCE = "popSource";
    public static final String TAG = "UnifyPreVerifyBaseVM";
    private final Lazy encryptEnable$delegate;
    private boolean initBtm;
    private volatile boolean isQueryConnecting;
    private String popSource;
    private final UnifyPreVerifyVMContext verifyVMContext;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/base/UnifyPreVerifyBaseVM$Companion;", "", "()V", "BTM_TOKEN_LEVER_TWO_ENCRYPT_FAIL", "", "BTM_TOKEN_LEVER_TWO_ENCRYPT_START", "KEY_DEGRADE_TIPS", "KEY_PAYMENT_INSTRUCTION_ICON", "KEY_PAYMENT_INSTRUCTION_TEXT", "KEY_POP_SOURCE", "TAG", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public View getEmbeddedView() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public boolean handleTradeConfirmIntercept(ICJUnifyPayTradeConfirmResp r100, UnifyPreVerifyBaseVM r101) {
        Intrinsics.checkNotNullParameter(r100, "cashierResult");
        return false;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public boolean handleTradeConfirmResp(ICJUnifyPayTradeConfirmResp r100) {
        return false;
    }

    public Boolean leftCanBack() {
        return null;
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public void onEmbeddedViewHide(UnifyPayHomepageState r100) {
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public void onEmbeddedViewResume() {
    }

    public void resetStatus() {
    }

    private final boolean getEncryptEnable() {
        return ((Boolean) this.encryptEnable$delegate.getValue()).booleanValue();
    }

    private final boolean isBioVerifyDegrade() {
        if (this.verifyVMContext.getPreVerifyManager().getRealFingerprintType() != UnifyPreVerifyType.VERIFY_TYPE_PWD) goto L5;
        return true;
    L5:
        return false;
    }

    public final void backToCashierHome() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyResult$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyResultAction.BACK_TO_CASHIER_HOME, null, 2, null);
    }

    public final AssetInfoBean buildSelectedAssetInfo() {
        return this.verifyVMContext.getPreVerifyGetParams().getPaymentParams().getSelectedAssetInfo();
    }

    public final void canCancelPay() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyResult$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyResultAction.CANCELABLE_PAY, null, 2, null);
    }

    public final CJPayHostInfo createHostInfo() {
        CJPayHostInfo r100 = new CJPayHostInfo();
        UnifyCommonBizParams r101 = getVMContext().getVerifyParams().getCommonBizParams();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getMerchantId();
    L6:
        r100.merchantId = r103;
        UnifyCommonBizParams r104 = getVMContext().getVerifyParams().getCommonBizParams();
        if (r104 == null) goto L9;
        r102 = r104.getAppId();
    L9:
        r100.appId = r102;
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public final void degradeCashierUi() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyResult$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyResultAction.DEGRADE_CASHIER_UI, null, 2, null);
    }

    public final Context getContext() {
        return this.verifyVMContext.getContext();
    }

    public final UnifyCashierRenderInfo.StandardVerifyItem getCurrentVerifyItem() {
        UnifyCashierRenderInfo.StandardVerifyInfo r100 = this.verifyVMContext.getPreVerifyGetParams().getTradeParams().getStandardVerifyInfo();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVerifyItem(getPreVerifyType().getValue());
    }

    public final JSONObject getLynxDialogExtraData() {
        UnifyCommonBizParams r100 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r100 == null) goto L9;
        CJPayMerchantInfo r101 = r100.getMerchantInfo();     // Catch: Exception -> L65
        if (r101 == null) goto L9;
        String r102 = r101.jh_merchant_id;     // Catch: Exception -> L65
    L11:
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        UnifyCommonBizParams r103 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r103 == null) goto L18;
        CJPayMerchantInfo r104 = r103.getMerchantInfo();     // Catch: Exception -> L65
        if (r104 == null) goto L18;
        String r105 = r104.jh_app_id;     // Catch: Exception -> L65
    L19:
        if (r105 != null) goto L21;
        r105 = "";
    L21:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L65
        r106.put("jh_merchant_id", r102);     // Catch: Exception -> L65
        r106.put("host_domain", ServerEventManager.Companion.getInstance().fetchHostDomain());     // Catch: Exception -> L65
        UnifyCommonBizParams r107 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r107 == null) goto L28;
        JSONObject r108 = r107.getProcessInfo();     // Catch: Exception -> L65
        if (r108 == null) goto L28;
        if (r106.put("process_info", r108) == null) goto L28;
    L29:
        UnifyCommonBizParams r110 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r110 == null) goto L32;
        String r111 = r110.getMerchantId();     // Catch: Exception -> L65
    L33:
        r106.put("merchant_id", r111);     // Catch: Exception -> L65
        r106.put("app_id", r105);     // Catch: Exception -> L65
        UnifyCommonBizParams r109 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r109 == null) goto L36;
        String r112 = r109.getAppId();     // Catch: Exception -> L65
    L37:
        r106.put("zg_app_id", r112);     // Catch: Exception -> L65
        UnifyCommonBizParams r113 = getVMContext().getVerifyParams().getCommonBizParams();     // Catch: Exception -> L65
        if (r113 == null) goto L40;
        String r114 = r113.getMerchantId();     // Catch: Exception -> L65
    L41:
        r106.put("dev_info", CJPayBasicUtils.getJsonDeviceInfo(r114));     // Catch: Exception -> L65
        if (CJPayCallBackCenter.getInstance() != null) goto L45;
    L47:
        String r115 = CJPayCallBackCenter.getInstance().getTraceId();     // Catch: Exception -> L65
    L49:
        if (TextUtils.isEmpty(r115) == true) goto L51;
        r106.put(BindCardPayConfirmConstants.Key.TRACE_ID, r115);     // Catch: Exception -> L65
    L51:
        VerifyLogParams r116 = getVMContext().getVerifyParams().getLogParams();     // Catch: Exception -> L65
        if (r116 == null) goto L57;
        JSONObject r117 = r116.getCommonParams();     // Catch: Exception -> L65
        if (r117 == null) goto L57;
        r106.put("prepay_id", r117.optString("prepay_id"));     // Catch: Exception -> L65
        r106.put("cashier_style", r117.optInt("cashier_style"));     // Catch: Exception -> L65
        r106.put(b.B0, r117.optString(b.B0));     // Catch: Exception -> L65
        r106.put("show_style", r117.optInt("show_style"));     // Catch: Exception -> L65
        r106.put("is_cold_launch", r117.optBoolean("is_cold_launch"));     // Catch: Exception -> L65
    L57:
        if (getVMContext().getVerifyParams().getCjPayUserInfo() == null) goto L63;
        CJPayUserInfo r118 = getVMContext().getVerifyParams().getCjPayUserInfo();     // Catch: Exception -> L65
        if (r118 == null) goto L61;
        List<String> r119 = r118.opened_check_ways;     // Catch: Exception -> L65
    L62:
        r106.put("opened_check_ways", r119);     // Catch: Exception -> L65
        goto L63
    L61:
        r119 = null;
    L63:
        r106.put("is_bio_degrade", isBioVerifyDegrade());     // Catch: Exception -> L65
        return r106;
    L45:
        if (CJPayCallBackCenter.getInstance().getTrackInfo() == null) goto L47;
        r115 = CJPayCallBackCenter.getInstance().getTrackInfo().optString(BindCardPayConfirmConstants.Key.TRACE_ID, "");     // Catch: Exception -> L65
        goto L49
    L40:
        r114 = null;
        goto L41
    L36:
        r112 = null;
        goto L37
    L32:
        r111 = null;
    L28:
        r106.put("process_info", "");     // Catch: Exception -> L65
    L18:
        r105 = null;
    L9:
        r102 = null;
    L65:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnifyPreVerifyBaseVM#getLynxDialogExtraData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnifyPreVerifyBaseVM#getLynxDialogExtraData", e);
        e.printStackTrace();
        return null;
    }

    public final CJUnifyPreVerifyManager.OnCommonDialogListener getOnCommonDialogListener() {
        return this.verifyVMContext.getPreVerifyManager().getOnCommonDialogListener();
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public void handleTradeConfirmFailed() {
        CJToast.Companion r100 = CJToast.Companion;
        Context r101 = getContext();
        int r102 = ue4.b.f549806a;
        CJToast.Companion.showToast$default(r100, r101, ue4.b.f(getContext(), R.string.cj_pay_network_error), null, null, null, 0, 60, null);
    }

    public final void markQueryEnd() {
        if (this.isQueryConnecting == true) goto L5;
        return;
    L5:
        this.isQueryConnecting = false;
        CJLogger.d(TAG, "markQueryEnd, type=" + getPreVerifyType());
    }

    public final void notifyLoginInvalid() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyResult$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyResultAction.LOGIN_INVALID, null, 2, null);
    }

    public final void notifyToHideLoading() {
        IUnifyPreVerifyListener r100 = this.verifyVMContext.getPreVerifyListener();
        PreVerifyAction r101 = PreVerifyAction.SET_LOADING_STATUS;
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "show", Boolean.FALSE);
        Unit r103 = Unit.INSTANCE;
        r100.onPreVerifyAction(r101, r102);
    }

    public final void notifyToUpdateLeftButton() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyAction$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyAction.UPDATE_LEFT_BUTTON, null, 2, null);
    }

    public final void notifyToUpdateTitle() {
        IUnifyPreVerifyListener.DefaultImpls.onPreVerifyAction$default(this.verifyVMContext.getPreVerifyListener(), PreVerifyAction.UPDATE_TITLE, null, 2, null);
    }

    public final String getPaymentInstructionIcon() {
        UnifyCashierRenderInfo.StandardVerifyItem r100 = getCurrentVerifyItem();
        if (r100 == null) goto L7;
        HashMap<String, String> r101 = r100.exts;
        if (r101 == null) goto L7;
        String r102 = r101.get(KEY_PAYMENT_INSTRUCTION_ICON);
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final String getPaymentInstructionText() {
        UnifyCashierRenderInfo.StandardVerifyItem r100 = getCurrentVerifyItem();
        if (r100 == null) goto L7;
        HashMap<String, String> r101 = r100.exts;
        if (r101 == null) goto L7;
        String r102 = r101.get(KEY_PAYMENT_INSTRUCTION_TEXT);
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final void markQueryStart() {
        if (CJPaySettingsManager.getInstance().isDegradeNoPwdBackIntercept() == false) goto L5;
        return;
    L5:
        this.isQueryConnecting = true;
        CJLogger.d(TAG, "markQueryStart, type=" + getPreVerifyType());
    }

    public final String getPopSource() {
        return this.popSource;
    }

    public final UnifyPreVerifyVMContext getVMContext() {
        return this.verifyVMContext;
    }

    public final boolean isQueryConnecting() {
        return this.isQueryConnecting;
    }

    public void release() {
        markQueryEnd();
    }

    public UnifyPreVerifyBaseVM(UnifyPreVerifyVMContext r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyVMContext");
        this.verifyVMContext = r100;
        this.popSource = "base_verify";
        this.encryptEnable$delegate = LazyKt.lazy(UnifyPreVerifyBaseVM$encryptEnable$2.INSTANCE);
    }

    public final void changePayMethod(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.verifyVMContext.getPreVerifyListener().onPreVerifyResult(PreVerifyResultAction.CHANGE_PAY_METHOD, r100);
    }

    public void checkByServer(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.verifyVMContext.getPreVerifyManager().preVerifyByServer(getPreVerifyType(), r100);
    }

    public final void notifyToSetConfirmStatus(boolean r100) {
        IUnifyPreVerifyListener r101 = this.verifyVMContext.getPreVerifyListener();
        PreVerifyAction r102 = PreVerifyAction.SET_CONFIRM_STATUS;
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "visible", Boolean.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        r101.onPreVerifyAction(r102, r103);
    }

    public final void notifyToShowLoading(String r100) {
        IUnifyPreVerifyListener r101 = this.verifyVMContext.getPreVerifyListener();
        PreVerifyAction r102 = PreVerifyAction.SET_LOADING_STATUS;
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "show", Boolean.TRUE);
        if (r100 != null) goto L5;
    L10:
        Unit r104 = Unit.INSTANCE;
        r101.onPreVerifyAction(r102, r103);
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        KtSafeMethodExtensionKt.safePut(r103, "loading_text", r100);
        goto L10
    }

    public final void notifyToUpdateTitleBar(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.verifyVMContext.getPreVerifyListener().onPreVerifyAction(PreVerifyAction.UPDATE_TITLE_BAR, r100);
    }

    public final void refreshCashierHome(String r100) {
        IUnifyPreVerifyListener r101 = this.verifyVMContext.getPreVerifyListener();
        PreVerifyResultAction r102 = PreVerifyResultAction.REFRESH;
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "code", r100);
        Unit r104 = Unit.INSTANCE;
        r101.onPreVerifyResult(r102, r103);
    }

    public final void setPopSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.popSource = r100;
    }

    public final void setQueryConnecting(boolean r100) {
        this.isQueryConnecting = r100;
    }

    public final void gotoAnotherVerify(UnifyPreVerifyType r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "newType");
        Intrinsics.checkNotNullParameter(r101, "extParams");
        this.verifyVMContext.getPreVerifyManager().changePreVerifyType(getPreVerifyType(), r100, r101);
    }

    public final String getUnifyEncryptData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        if (getEncryptEnable() == false) goto L5;
        CJEncryptScene r103 = CJEncryptScene.TRADE_VERIFY;
    L7:
        if (getEncryptEnable() == false) goto L9;
        String r104 = "创原";
    L10:
        CJUnifyPreVerifyManager r105 = getVMContext().getPreVerifyManager();
        JSONObject r106 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r106, "service_name", r104);
        Unit r107 = Unit.INSTANCE;
        r105.uploadPreVerifyEvent(CJUnifyPayEventUtils.EVENT_NAME_LEVER_TWO_ENCRYPT_START, r106);
        String r108 = CJPayEncryptHelper.Companion.getEncryptData(r103, r100, r101, r102);
        if (r108.length() != 0) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L16;
        String r110 = r108;
    L17:
        if (r110 == null) goto L19;
        CJUnifyPreVerifyManager r111 = getVMContext().getPreVerifyManager();
        JSONObject r112 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r112, "service_name", r104);
        r111.uploadPreVerifyEvent(CJUnifyPayEventUtils.EVENT_NAME_LEVER_TWO_ENCRYPT_FAIL, r112);
    L19:
        return r108;
    L16:
        r110 = null;
        goto L17
    L13:
        r109 = false;
        goto L14
    L9:
        r104 = "信安";
        goto L10
    L5:
        r103 = CJEncryptScene.UNKNOWN;
        goto L7
    }

    public final void showSecurityLoading(boolean r110, String r111, ICJPaySecurityLoadingService.SecurityLoadingScene r112) {
        Intrinsics.checkNotNullParameter(r112, "scene");
        performShowSecurityLoading$default(this, r110, r112, null, null, r111, 12, null);
    }

    public void startVerify(UnifyPreVerifyBaseVM r100, UnifyPreVerifyType r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "preVerifyType");
        Intrinsics.checkNotNullParameter(r102, "extData");
        CJLogger.d(TAG, "did startVerify, preVM: " + r100 + ", preVerifyType: " + r101);
        String r103 = r102.optString(KEY_POP_SOURCE);
        if (r103.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L12;
        this.popSource = r103;
    L12:
        if (this.initBtm == true) goto L14;
        CJWalletCashierBtmUtils.registerBtmView(this.verifyVMContext.getContext(), "a24331.b14590.c33692.d0");
    L14:
        this.initBtm = true;
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static /* synthetic */ void notifyToShowLoading$default(UnifyPreVerifyBaseVM r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.notifyToShowLoading(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyToShowLoading");
    }

    public static /* synthetic */ void notifyToUpdateTitleBar$default(UnifyPreVerifyBaseVM r100, JSONObject r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = new JSONObject();
    L6:
        r100.notifyToUpdateTitleBar(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyToUpdateTitleBar");
    }

    public final String getUnifyEncryptDataWithoutMd5(String r100, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r112, "field");
        if (getEncryptEnable() == false) goto L5;
        CJEncryptScene r101 = CJEncryptScene.TRADE_VERIFY;
    L6:
        CJEncryptScene r102 = r101;
        if (getEncryptEnable() == false) goto L9;
        String r103 = "创原";
    L10:
        CJUnifyPreVerifyManager r104 = getVMContext().getPreVerifyManager();
        JSONObject r105 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r105, "service_name", r103);
        Unit r106 = Unit.INSTANCE;
        r104.uploadPreVerifyEvent(CJUnifyPayEventUtils.EVENT_NAME_LEVER_TWO_ENCRYPT_START, r105);
        String r107 = CJPayEncryptHelper.Companion.getEncryptDataWithoutMd5(r102, r100, r110, r111, r112);
        if (r107.length() != 0) goto L13;
        boolean r113 = true;
    L14:
        if (r113 == false) goto L16;
        String r114 = r107;
    L17:
        if (r114 == null) goto L19;
        CJUnifyPreVerifyManager r115 = getVMContext().getPreVerifyManager();
        JSONObject r116 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r116, "service_name", r103);
        r115.uploadPreVerifyEvent(CJUnifyPayEventUtils.EVENT_NAME_LEVER_TWO_ENCRYPT_FAIL, r116);
    L19:
        return r107;
    L16:
        r114 = null;
        goto L17
    L13:
        r113 = false;
        goto L14
    L9:
        r103 = "信安";
        goto L10
    L5:
        r101 = CJEncryptScene.UNKNOWN;
        goto L6
    }

    public static /* synthetic */ void gotoAnotherVerify$default(UnifyPreVerifyBaseVM r100, UnifyPreVerifyType r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        r100.gotoAnotherVerify(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gotoAnotherVerify");
    }

    private final void performShowSecurityLoading(boolean r110, ICJPaySecurityLoadingService.SecurityLoadingScene r111, String r112, final Function2<? super Boolean, ? super Boolean, Unit> r113, String r210) {
        if (r110 == false) goto L5;
        CJLoading.showDialogViewLoading$default(CJLoading.Companion.getInstance(), getContext(), r111, r112, r210, false, false, null, null, null, new AnonymousClass1(r113), 480, null);
        return;
    L5:
        CJLoading.Companion.getInstance().dismissDialogViewLoading(new AnonymousClass2(r113));
    }

    public static /* synthetic */ void showSecurityLoading$default(UnifyPreVerifyBaseVM r100, boolean r101, String r102, ICJPaySecurityLoadingService.SecurityLoadingScene r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = ICJPaySecurityLoadingService.SecurityLoadingScene.SECURITY_LOADING_SCENE_NORMAL;
    L9:
        r100.showSecurityLoading(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSecurityLoading");
    }

    public static /* synthetic */ void startVerify$default(UnifyPreVerifyBaseVM r100, UnifyPreVerifyBaseVM r101, UnifyPreVerifyType r102, JSONObject r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = new JSONObject();
    L6:
        r100.startVerify(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startVerify");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void performShowSecurityLoading$default(UnifyPreVerifyBaseVM r100, boolean r101, ICJPaySecurityLoadingService.SecurityLoadingScene r102, String r103, Function2 r110, String r111, int r112, Object r113) {
        if (r113 != null) goto L21;
        if ((r112 & 2) == 0) goto L6;
        r102 = ICJPaySecurityLoadingService.SecurityLoadingScene.SECURITY_LOADING_SCENE_PAY;
    L6:
        ICJPaySecurityLoadingService.SecurityLoadingScene r104 = r102;
        if ((r112 & 4) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        Function2 r106 = null;
    L15:
        if ((r112 & 16) == 0) goto L17;
        String r107 = null;
    L18:
        r100.performShowSecurityLoading(r101, r104, r105, r106, r107);
        return;
    L17:
        r107 = r111;
        goto L18
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performShowSecurityLoading");
    }
}
