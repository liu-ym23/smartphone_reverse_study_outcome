package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home;

import android.view.View;
import com.android.ttcjpaysdk.asset.utils.AssetInfoUtil;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.CJStringExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.ui.Utils.AssetProcessUtils;
import com.android.ttcjpaysdk.base.ui.component.tag.CJVoucherTagBean;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayDoubleConfirmPageInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayTopRightBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPreBioGuideInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CheckoutCounterCashDeskShowConf;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyTypeStrategy;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyPasswordVM;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base.UnifyPreVerifyBaseVM;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.core.CJStandardStateProvider;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.marketing.CJStandardDefaultBankCardPointHandler;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.marketing.CJStandardVoucherExpansionManager;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 :2\u00020\u0001:\u00069:;<=>B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0002J\n\u0010+\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010.\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\u0012\u00107\u001a\u0004\u0018\u00010\n2\u0006\u00108\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper;", "", "cjStandardStateProvider", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/core/CJStandardStateProvider;", "homePageAction", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageAction;", "view", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageView;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/core/CJStandardStateProvider;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageAction;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageView;)V", "lastReportedTopRightButtonName", "", "topRightText", "buildTopBarState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$TopBarState;", "pageStyle", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "data", "Lorg/json/JSONObject;", "getAmountText", "getCurrentPaymentMethod", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getCurrentViewState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomeViewState;", "getPageStyleConfig", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyleConfig;", "getRecommend", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$SubPayTypeRecommend;", "currentMethod", "getTopRightText", "hasOtherHomePageInStack", "", "isPageStyleMatchCurrentViewState", "viewState", "isPayTypeSwitchable", "isShowMarketing", "isShowPayType", ChameleonOpenTracker.Stage.RENDER, "", "embeddedComponent", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/base/UnifyPreVerifyBaseVM;", "reportTopRightButtonShowIfNeeded", "state", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$HomePageRenderState;", "resolveAmountText", "resolveBackIconType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$BackIconType;", "resolveBankCardPointAsset", "resolveNoPwdGuideInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "resolvePreBioGuideInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPreBioGuideInfo;", "resolveShowAmount", "resolveShowDiscount", "resolveShowPayTypeByServer", "resolveShowTradeNameByServer", "resolveTradeName", "afterExpand", "BackIconType", "Companion", "HomePageRenderState", "PageStyle", "PageStyleConfig", "TopBarState", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardHomePageWrapper {
    public static final Companion Companion = null;
    private static final String TAG = "CJStandardHomePageWrapper";
    private final CJStandardStateProvider cjStandardStateProvider;
    private final CJStandardHomePageAction homePageAction;
    private String lastReportedTopRightButtonName;
    private String topRightText;
    private final CJStandardHomePageView view;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$BackIconType;", "", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BackIconType extends Enum<BackIconType> {
        private static final /* synthetic */ BackIconType[] $VALUES = null;
        public static final BackIconType BACK = null;
        public static final BackIconType CLOSE = null;

        private static final /* synthetic */ BackIconType[] $values() {
            return new BackIconType[]{CLOSE, BACK};
        }

        public static BackIconType valueOf(String r100) {
            return (BackIconType) a.a(BackIconType.class, r100);
        }

        public static BackIconType[] values() {
            return (BackIconType[]) $VALUES.clone();
        }

        static {
            CLOSE = new BackIconType("CLOSE", 0);
            BACK = new BackIconType("BACK", 1);
            $VALUES = $values();
        }

        private BackIconType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$Companion;", "", "()V", "TAG", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b8\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"¢\u0006\u0002\u0010#J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dHÆ\u0003J\u001d\u0010L\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003Jó\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\t2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"HÆ\u0001J\u0013\u0010V\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u000bHÖ\u0001J\t\u0010Y\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R%\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%¨\u0006Z"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$HomePageRenderState;", "", "topBarState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$TopBarState;", "pageStyle", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "topRightText", "", "showTopRight", "", "preVerifyTopMarginDp", "", "amountText", "tradeName", "currentMethod", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "showPayType", "payTypeSwitchable", "preBioGuideInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPreBioGuideInfo;", "noPwdGuideInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "showPreBioGuide", "showNoPwdGuide", "bankCardPointAsset", "payTypeRecommend", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$SubPayTypeRecommend;", "showMarketing", "premiumFeelTag", "", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherTagBean;", "countdownArea", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "Lkotlin/collections/ArrayList;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$TopBarState;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;ZZLcom/android/ttcjpaysdk/thirdparty/data/CJPayPreBioGuideInfo;Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;ZZLcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$SubPayTypeRecommend;ZLjava/util/List;Ljava/util/ArrayList;)V", "getAmountText", "()Ljava/lang/String;", "getBankCardPointAsset", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getCountdownArea", "()Ljava/util/ArrayList;", "getCurrentMethod", "getNoPwdGuideInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "getPageStyle", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "getPayTypeRecommend", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$SubPayTypeRecommend;", "getPayTypeSwitchable", "()Z", "getPreBioGuideInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPreBioGuideInfo;", "getPreVerifyTopMarginDp", "()I", "getPremiumFeelTag", "()Ljava/util/List;", "getShowMarketing", "getShowNoPwdGuide", "getShowPayType", "getShowPreBioGuide", "getShowTopRight", "getTopBarState", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$TopBarState;", "getTopRightText", "getTradeName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomePageRenderState {
        private final String amountText;
        private final AssetInfoBean bankCardPointAsset;
        private final ArrayList<UIComponent> countdownArea;
        private final AssetInfoBean currentMethod;
        private final CJPayProtocolGroupContentsBean noPwdGuideInfo;
        private final PageStyle pageStyle;
        private final CJPayPayInfo.SubPayTypeRecommend payTypeRecommend;
        private final boolean payTypeSwitchable;
        private final CJPayPreBioGuideInfo preBioGuideInfo;
        private final int preVerifyTopMarginDp;
        private final List<CJVoucherTagBean> premiumFeelTag;
        private final boolean showMarketing;
        private final boolean showNoPwdGuide;
        private final boolean showPayType;
        private final boolean showPreBioGuide;
        private final boolean showTopRight;
        private final TopBarState topBarState;
        private final String topRightText;
        private final String tradeName;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomePageRenderState copy$default(HomePageRenderState r110, TopBarState r111, PageStyle r112, String r210, boolean r211, int r212, String r213, String r214, AssetInfoBean r215, boolean r216, boolean r217, CJPayPreBioGuideInfo r218, CJPayProtocolGroupContentsBean r219, boolean r310, boolean r311, AssetInfoBean r312, CJPayPayInfo.SubPayTypeRecommend r313, boolean r314, List r315, ArrayList r316, int r317, Object r318) {
            if ((r317 & 1) == 0) goto L5;
            TopBarState r100 = r110.topBarState;
        L7:
            if ((r317 & 2) == 0) goto L9;
            PageStyle r101 = r110.pageStyle;
        L11:
            if ((r317 & 4) == 0) goto L13;
            String r102 = r110.topRightText;
        L15:
            if ((r317 & 8) == 0) goto L17;
            boolean r103 = r110.showTopRight;
        L19:
            if ((r317 & 16) == 0) goto L21;
            int r104 = r110.preVerifyTopMarginDp;
        L23:
            if ((r317 & 32) == 0) goto L25;
            String r105 = r110.amountText;
        L27:
            if ((r317 & 64) == 0) goto L29;
            String r106 = r110.tradeName;
        L31:
            if ((r317 & 128) == 0) goto L33;
            AssetInfoBean r107 = r110.currentMethod;
        L35:
            if ((r317 & 256) == 0) goto L37;
            boolean r113 = r110.showPayType;
        L39:
            if ((r317 & 512) == 0) goto L41;
            boolean r114 = r110.payTypeSwitchable;
        L43:
            if ((r317 & 1024) == 0) goto L45;
            CJPayPreBioGuideInfo r115 = r110.preBioGuideInfo;
        L47:
            if ((r317 & 2048) == 0) goto L49;
            CJPayProtocolGroupContentsBean r116 = r110.noPwdGuideInfo;
        L51:
            if ((r317 & 4096) == 0) goto L53;
            boolean r117 = r110.showPreBioGuide;
        L55:
            if ((r317 & 8192) == 0) goto L57;
            boolean r118 = r110.showNoPwdGuide;
        L58:
            boolean r319 = r118;
            if ((r317 & 16384) == 0) goto L61;
            AssetInfoBean r119 = r110.bankCardPointAsset;
        L62:
            AssetInfoBean r320 = r119;
            if ((r317 & 32768) == 0) goto L65;
            CJPayPayInfo.SubPayTypeRecommend r120 = r110.payTypeRecommend;
        L66:
            CJPayPayInfo.SubPayTypeRecommend r321 = r120;
            if ((r317 & 65536) == 0) goto L69;
            boolean r121 = r110.showMarketing;
        L70:
            boolean r322 = r121;
            if ((r317 & 131072) == 0) goto L73;
            List r122 = r110.premiumFeelTag;
        L75:
            if ((r317 & 262144) == 0) goto L77;
            ArrayList r108 = r110.countdownArea;
        L79:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
        L77:
            r108 = r316;
            goto L79
        L73:
            r122 = r315;
            goto L75
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final TopBarState component1() {
            return this.topBarState;
        }

        public final boolean component10() {
            return this.payTypeSwitchable;
        }

        public final CJPayPreBioGuideInfo component11() {
            return this.preBioGuideInfo;
        }

        public final CJPayProtocolGroupContentsBean component12() {
            return this.noPwdGuideInfo;
        }

        public final boolean component13() {
            return this.showPreBioGuide;
        }

        public final boolean component14() {
            return this.showNoPwdGuide;
        }

        public final AssetInfoBean component15() {
            return this.bankCardPointAsset;
        }

        public final CJPayPayInfo.SubPayTypeRecommend component16() {
            return this.payTypeRecommend;
        }

        public final boolean component17() {
            return this.showMarketing;
        }

        public final List<CJVoucherTagBean> component18() {
            return this.premiumFeelTag;
        }

        public final ArrayList<UIComponent> component19() {
            return this.countdownArea;
        }

        public final PageStyle component2() {
            return this.pageStyle;
        }

        public final String component3() {
            return this.topRightText;
        }

        public final boolean component4() {
            return this.showTopRight;
        }

        public final int component5() {
            return this.preVerifyTopMarginDp;
        }

        public final String component6() {
            return this.amountText;
        }

        public final String component7() {
            return this.tradeName;
        }

        public final AssetInfoBean component8() {
            return this.currentMethod;
        }

        public final boolean component9() {
            return this.showPayType;
        }

        public final HomePageRenderState copy(TopBarState r210, PageStyle r211, String r212, boolean r213, int r214, String r215, String r216, AssetInfoBean r310, boolean r311, boolean r312, CJPayPreBioGuideInfo r313, CJPayProtocolGroupContentsBean r314, boolean r315, boolean r316, AssetInfoBean r317, CJPayPayInfo.SubPayTypeRecommend r318, boolean r319, List<CJVoucherTagBean> r410, ArrayList<UIComponent> r411) {
            Intrinsics.checkNotNullParameter(r210, "topBarState");
            Intrinsics.checkNotNullParameter(r211, "pageStyle");
            return new HomePageRenderState(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof HomePageRenderState) == true) goto L8;
            return false;
        L8:
            HomePageRenderState r101 = (HomePageRenderState) r100;
            if (Intrinsics.areEqual(this.topBarState, r101.topBarState) == true) goto L12;
            return false;
        L12:
            if (this.pageStyle == r101.pageStyle) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.topRightText, r101.topRightText) == true) goto L18;
            return false;
        L18:
            if (this.showTopRight == r101.showTopRight) goto L21;
            return false;
        L21:
            if (this.preVerifyTopMarginDp == r101.preVerifyTopMarginDp) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.amountText, r101.amountText) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.tradeName, r101.tradeName) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.currentMethod, r101.currentMethod) == true) goto L33;
            return false;
        L33:
            if (this.showPayType == r101.showPayType) goto L36;
            return false;
        L36:
            if (this.payTypeSwitchable == r101.payTypeSwitchable) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.preBioGuideInfo, r101.preBioGuideInfo) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.noPwdGuideInfo, r101.noPwdGuideInfo) == true) goto L45;
            return false;
        L45:
            if (this.showPreBioGuide == r101.showPreBioGuide) goto L48;
            return false;
        L48:
            if (this.showNoPwdGuide == r101.showNoPwdGuide) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.bankCardPointAsset, r101.bankCardPointAsset) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.payTypeRecommend, r101.payTypeRecommend) == true) goto L57;
            return false;
        L57:
            if (this.showMarketing == r101.showMarketing) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.premiumFeelTag, r101.premiumFeelTag) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.countdownArea, r101.countdownArea) == true) goto L65;
            return false;
        L65:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.topBarState.hashCode() * 31) + this.pageStyle.hashCode()) * 31;
            String r101 = this.topRightText;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            int r105 = 1231;
            if (this.showTopRight == false) goto L9;
            int r106 = 1231;
        L10:
            int r107 = (((r104 + r106) * 31) + this.preVerifyTopMarginDp) * 31;
            String r108 = this.amountText;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.tradeName;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            AssetInfoBean r114 = this.currentMethod;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            if (this.showPayType == false) goto L25;
            int r117 = 1231;
        L26:
            int r118 = (r116 + r117) * 31;
            if (this.payTypeSwitchable == false) goto L29;
            int r119 = 1231;
        L30:
            int r120 = (r118 + r119) * 31;
            CJPayPreBioGuideInfo r121 = this.preBioGuideInfo;
            if (r121 != null) goto L33;
            int r122 = 0;
        L34:
            int r123 = (r120 + r122) * 31;
            CJPayProtocolGroupContentsBean r124 = this.noPwdGuideInfo;
            if (r124 != null) goto L37;
            int r125 = 0;
        L38:
            int r126 = (r123 + r125) * 31;
            if (this.showPreBioGuide == false) goto L41;
            int r127 = 1231;
        L42:
            int r128 = (r126 + r127) * 31;
            if (this.showNoPwdGuide == false) goto L45;
            int r129 = 1231;
        L46:
            int r130 = (r128 + r129) * 31;
            AssetInfoBean r131 = this.bankCardPointAsset;
            if (r131 != null) goto L49;
            int r132 = 0;
        L50:
            int r133 = (r130 + r132) * 31;
            CJPayPayInfo.SubPayTypeRecommend r134 = this.payTypeRecommend;
            if (r134 != null) goto L53;
            int r135 = 0;
        L54:
            int r136 = (r133 + r135) * 31;
            if (this.showMarketing == true) goto L58;
            r105 = 1237;
        L58:
            int r137 = (r136 + r105) * 31;
            List<CJVoucherTagBean> r138 = this.premiumFeelTag;
            if (r138 != null) goto L61;
            int r139 = 0;
        L62:
            int r140 = (r137 + r139) * 31;
            ArrayList<UIComponent> r141 = this.countdownArea;
            if (r141 == null) goto L67;
            r102 = r141.hashCode();
        L67:
            return r140 + r102;
        L61:
            r139 = r138.hashCode();
            goto L62
        L53:
            r135 = r134.hashCode();
            goto L54
        L49:
            r132 = r131.hashCode();
            goto L50
        L45:
            r129 = 1237;
            goto L46
        L41:
            r127 = 1237;
            goto L42
        L37:
            r125 = r124.hashCode();
            goto L38
        L33:
            r122 = r121.hashCode();
            goto L34
        L29:
            r119 = 1237;
            goto L30
        L25:
            r117 = 1237;
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = 1237;
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "HomePageRenderState(topBarState=" + this.topBarState + ", pageStyle=" + this.pageStyle + ", topRightText=" + this.topRightText + ", showTopRight=" + this.showTopRight + ", preVerifyTopMarginDp=" + this.preVerifyTopMarginDp + ", amountText=" + this.amountText + ", tradeName=" + this.tradeName + ", currentMethod=" + this.currentMethod + ", showPayType=" + this.showPayType + ", payTypeSwitchable=" + this.payTypeSwitchable + ", preBioGuideInfo=" + this.preBioGuideInfo + ", noPwdGuideInfo=" + this.noPwdGuideInfo + ", showPreBioGuide=" + this.showPreBioGuide + ", showNoPwdGuide=" + this.showNoPwdGuide + ", bankCardPointAsset=" + this.bankCardPointAsset + ", payTypeRecommend=" + this.payTypeRecommend + ", showMarketing=" + this.showMarketing + ", premiumFeelTag=" + this.premiumFeelTag + ", countdownArea=" + this.countdownArea + ')';
        }

        public final String getAmountText() {
            return this.amountText;
        }

        public final AssetInfoBean getBankCardPointAsset() {
            return this.bankCardPointAsset;
        }

        public final ArrayList<UIComponent> getCountdownArea() {
            return this.countdownArea;
        }

        public final AssetInfoBean getCurrentMethod() {
            return this.currentMethod;
        }

        public final CJPayProtocolGroupContentsBean getNoPwdGuideInfo() {
            return this.noPwdGuideInfo;
        }

        public final PageStyle getPageStyle() {
            return this.pageStyle;
        }

        public final CJPayPayInfo.SubPayTypeRecommend getPayTypeRecommend() {
            return this.payTypeRecommend;
        }

        public final boolean getPayTypeSwitchable() {
            return this.payTypeSwitchable;
        }

        public final CJPayPreBioGuideInfo getPreBioGuideInfo() {
            return this.preBioGuideInfo;
        }

        public final int getPreVerifyTopMarginDp() {
            return this.preVerifyTopMarginDp;
        }

        public final List<CJVoucherTagBean> getPremiumFeelTag() {
            return this.premiumFeelTag;
        }

        public final boolean getShowMarketing() {
            return this.showMarketing;
        }

        public final boolean getShowNoPwdGuide() {
            return this.showNoPwdGuide;
        }

        public final boolean getShowPayType() {
            return this.showPayType;
        }

        public final boolean getShowPreBioGuide() {
            return this.showPreBioGuide;
        }

        public final boolean getShowTopRight() {
            return this.showTopRight;
        }

        public final TopBarState getTopBarState() {
            return this.topBarState;
        }

        public final String getTopRightText() {
            return this.topRightText;
        }

        public final String getTradeName() {
            return this.tradeName;
        }

        public HomePageRenderState(TopBarState r100, PageStyle r101, String r102, boolean r103, int r104, String r110, String r111, AssetInfoBean r112, boolean r113, boolean r114, CJPayPreBioGuideInfo r115, CJPayProtocolGroupContentsBean r116, boolean r117, boolean r118, AssetInfoBean r119, CJPayPayInfo.SubPayTypeRecommend r210, boolean r211, List<CJVoucherTagBean> r212, ArrayList<UIComponent> r213) {
            Intrinsics.checkNotNullParameter(r100, "topBarState");
            Intrinsics.checkNotNullParameter(r101, "pageStyle");
            this.topBarState = r100;
            this.pageStyle = r101;
            this.topRightText = r102;
            this.showTopRight = r103;
            this.preVerifyTopMarginDp = r104;
            this.amountText = r110;
            this.tradeName = r111;
            this.currentMethod = r112;
            this.showPayType = r113;
            this.payTypeSwitchable = r114;
            this.preBioGuideInfo = r115;
            this.noPwdGuideInfo = r116;
            this.showPreBioGuide = r117;
            this.showNoPwdGuide = r118;
            this.bankCardPointAsset = r119;
            this.payTypeRecommend = r210;
            this.showMarketing = r211;
            this.premiumFeelTag = r212;
            this.countdownArea = r213;
        }

        public /* synthetic */ HomePageRenderState(TopBarState r210, PageStyle r211, String r212, boolean r213, int r214, String r215, String r216, AssetInfoBean r310, boolean r311, boolean r312, CJPayPreBioGuideInfo r313, CJPayProtocolGroupContentsBean r314, boolean r315, boolean r316, AssetInfoBean r317, CJPayPayInfo.SubPayTypeRecommend r318, boolean r319, List r410, ArrayList r411, int r412, DefaultConstructorMarker r413) {
            if ((r412 & 131072) == 0) goto L5;
            List r217 = null;
        L7:
            if ((r412 & 262144) == 0) goto L9;
            ArrayList r218 = null;
        L10:
            this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r217, r218);
            return;
        L9:
            r218 = r411;
            goto L10
        L5:
            r217 = r410;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "", "(Ljava/lang/String;I)V", "PASSWORD", CancelRetainContactInfoFunctions.SMS, CancelRetainContactInfoFunctions.CVV, "DOUBLE_CONFIRM", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PageStyle extends Enum<PageStyle> {
        private static final /* synthetic */ PageStyle[] $VALUES = null;
        public static final PageStyle CVV = null;
        public static final PageStyle DOUBLE_CONFIRM = null;
        public static final PageStyle PASSWORD = null;
        public static final PageStyle SMS = null;

        private static final /* synthetic */ PageStyle[] $values() {
            return new PageStyle[]{PASSWORD, SMS, CVV, DOUBLE_CONFIRM};
        }

        public static PageStyle valueOf(String r100) {
            return (PageStyle) a.a(PageStyle.class, r100);
        }

        public static PageStyle[] values() {
            return (PageStyle[]) $VALUES.clone();
        }

        static {
            PASSWORD = new PageStyle("PASSWORD", 0);
            SMS = new PageStyle(CancelRetainContactInfoFunctions.SMS, 1);
            CVV = new PageStyle(CancelRetainContactInfoFunctions.CVV, 2);
            DOUBLE_CONFIRM = new PageStyle("DOUBLE_CONFIRM", 3);
            $VALUES = $values();
        }

        private PageStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0003¢\u0006\u0002\u0010\u0011J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J£\u0001\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\r\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00060"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyleConfig;", "", "showAmount", "Lkotlin/Function0;", "", "showPayType", "showTradeName", "showPreBioGuide", "showNoPwdGuide", "preVerifyTopMarginDp", "", "topRightVisible", "payTypeSwitchable", "showBankCardPointGuide", "showMarketing", "resolveTitleText", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getPayTypeSwitchable", "()Lkotlin/jvm/functions/Function0;", "getPreVerifyTopMarginDp", "()I", "getResolveTitleText", "getShowAmount", "getShowBankCardPointGuide", "()Z", "getShowMarketing", "getShowNoPwdGuide", "getShowPayType", "getShowPreBioGuide", "getShowTradeName", "getTopRightVisible", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PageStyleConfig {
        private final Function0<Boolean> payTypeSwitchable;
        private final int preVerifyTopMarginDp;
        private final Function0<String> resolveTitleText;
        private final Function0<Boolean> showAmount;
        private final boolean showBankCardPointGuide;
        private final Function0<Boolean> showMarketing;
        private final boolean showNoPwdGuide;
        private final Function0<Boolean> showPayType;
        private final boolean showPreBioGuide;
        private final Function0<Boolean> showTradeName;
        private final Function0<Boolean> topRightVisible;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageStyleConfig copy$default(PageStyleConfig r110, Function0 r111, Function0 r112, Function0 r113, boolean r114, boolean r115, int r116, Function0 r117, Function0 r210, boolean r211, Function0 r212, Function0 r213, int r214, Object r215) {
            if ((r214 & 1) == 0) goto L5;
            Function0 r100 = r110.showAmount;
        L7:
            if ((r214 & 2) == 0) goto L9;
            Function0 r101 = r110.showPayType;
        L11:
            if ((r214 & 4) == 0) goto L13;
            Function0 r102 = r110.showTradeName;
        L15:
            if ((r214 & 8) == 0) goto L17;
            boolean r103 = r110.showPreBioGuide;
        L19:
            if ((r214 & 16) == 0) goto L21;
            boolean r104 = r110.showNoPwdGuide;
        L23:
            if ((r214 & 32) == 0) goto L25;
            int r105 = r110.preVerifyTopMarginDp;
        L27:
            if ((r214 & 64) == 0) goto L29;
            Function0 r106 = r110.topRightVisible;
        L31:
            if ((r214 & 128) == 0) goto L33;
            Function0 r107 = r110.payTypeSwitchable;
        L35:
            if ((r214 & 256) == 0) goto L37;
            boolean r118 = r110.showBankCardPointGuide;
        L39:
            if ((r214 & 512) == 0) goto L41;
            Function0 r119 = r110.showMarketing;
        L43:
            if ((r214 & 1024) == 0) goto L45;
            Function0 r108 = r110.resolveTitleText;
        L47:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
        L45:
            r108 = r213;
            goto L47
        L41:
            r119 = r212;
            goto L43
        L37:
            r118 = r211;
            goto L39
        L33:
            r107 = r210;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final Function0<Boolean> component1() {
            return this.showAmount;
        }

        public final Function0<Boolean> component10() {
            return this.showMarketing;
        }

        public final Function0<String> component11() {
            return this.resolveTitleText;
        }

        public final Function0<Boolean> component2() {
            return this.showPayType;
        }

        public final Function0<Boolean> component3() {
            return this.showTradeName;
        }

        public final boolean component4() {
            return this.showPreBioGuide;
        }

        public final boolean component5() {
            return this.showNoPwdGuide;
        }

        public final int component6() {
            return this.preVerifyTopMarginDp;
        }

        public final Function0<Boolean> component7() {
            return this.topRightVisible;
        }

        public final Function0<Boolean> component8() {
            return this.payTypeSwitchable;
        }

        public final boolean component9() {
            return this.showBankCardPointGuide;
        }

        public final PageStyleConfig copy(Function0<Boolean> r110, Function0<Boolean> r111, Function0<Boolean> r112, boolean r113, boolean r114, int r115, Function0<Boolean> r210, Function0<Boolean> r211, boolean r212, Function0<Boolean> r213, Function0<String> r214) {
            Intrinsics.checkNotNullParameter(r110, "showAmount");
            Intrinsics.checkNotNullParameter(r111, "showPayType");
            Intrinsics.checkNotNullParameter(r112, "showTradeName");
            Intrinsics.checkNotNullParameter(r210, "topRightVisible");
            Intrinsics.checkNotNullParameter(r211, "payTypeSwitchable");
            Intrinsics.checkNotNullParameter(r213, "showMarketing");
            Intrinsics.checkNotNullParameter(r214, "resolveTitleText");
            return new PageStyleConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PageStyleConfig) == true) goto L8;
            return false;
        L8:
            PageStyleConfig r101 = (PageStyleConfig) r100;
            if (Intrinsics.areEqual(this.showAmount, r101.showAmount) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.showPayType, r101.showPayType) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.showTradeName, r101.showTradeName) == true) goto L18;
            return false;
        L18:
            if (this.showPreBioGuide == r101.showPreBioGuide) goto L21;
            return false;
        L21:
            if (this.showNoPwdGuide == r101.showNoPwdGuide) goto L24;
            return false;
        L24:
            if (this.preVerifyTopMarginDp == r101.preVerifyTopMarginDp) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.topRightVisible, r101.topRightVisible) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.payTypeSwitchable, r101.payTypeSwitchable) == true) goto L33;
            return false;
        L33:
            if (this.showBankCardPointGuide == r101.showBankCardPointGuide) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.showMarketing, r101.showMarketing) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.resolveTitleText, r101.resolveTitleText) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.showAmount.hashCode() * 31) + this.showPayType.hashCode()) * 31) + this.showTradeName.hashCode()) * 31;
            int r101 = 1231;
            if (this.showPreBioGuide == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.showNoPwdGuide == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (((((((r103 + r104) * 31) + this.preVerifyTopMarginDp) * 31) + this.topRightVisible.hashCode()) * 31) + this.payTypeSwitchable.hashCode()) * 31;
            if (this.showBankCardPointGuide == true) goto L15;
            r101 = 1237;
        L15:
            return ((((r105 + r101) * 31) + this.showMarketing.hashCode()) * 31) + this.resolveTitleText.hashCode();
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public String toString() {
            return "PageStyleConfig(showAmount=" + this.showAmount + ", showPayType=" + this.showPayType + ", showTradeName=" + this.showTradeName + ", showPreBioGuide=" + this.showPreBioGuide + ", showNoPwdGuide=" + this.showNoPwdGuide + ", preVerifyTopMarginDp=" + this.preVerifyTopMarginDp + ", topRightVisible=" + this.topRightVisible + ", payTypeSwitchable=" + this.payTypeSwitchable + ", showBankCardPointGuide=" + this.showBankCardPointGuide + ", showMarketing=" + this.showMarketing + ", resolveTitleText=" + this.resolveTitleText + ')';
        }

        public final Function0<Boolean> getPayTypeSwitchable() {
            return this.payTypeSwitchable;
        }

        public final int getPreVerifyTopMarginDp() {
            return this.preVerifyTopMarginDp;
        }

        public final Function0<String> getResolveTitleText() {
            return this.resolveTitleText;
        }

        public final Function0<Boolean> getShowAmount() {
            return this.showAmount;
        }

        public final boolean getShowBankCardPointGuide() {
            return this.showBankCardPointGuide;
        }

        public final Function0<Boolean> getShowMarketing() {
            return this.showMarketing;
        }

        public final boolean getShowNoPwdGuide() {
            return this.showNoPwdGuide;
        }

        public final Function0<Boolean> getShowPayType() {
            return this.showPayType;
        }

        public final boolean getShowPreBioGuide() {
            return this.showPreBioGuide;
        }

        public final Function0<Boolean> getShowTradeName() {
            return this.showTradeName;
        }

        public final Function0<Boolean> getTopRightVisible() {
            return this.topRightVisible;
        }

        public PageStyleConfig(Function0<Boolean> r100, Function0<Boolean> r101, Function0<Boolean> r102, boolean r103, boolean r104, int r105, Function0<Boolean> r106, Function0<Boolean> r107, boolean r110, Function0<Boolean> r111, Function0<String> r112) {
            Intrinsics.checkNotNullParameter(r100, "showAmount");
            Intrinsics.checkNotNullParameter(r101, "showPayType");
            Intrinsics.checkNotNullParameter(r102, "showTradeName");
            Intrinsics.checkNotNullParameter(r106, "topRightVisible");
            Intrinsics.checkNotNullParameter(r107, "payTypeSwitchable");
            Intrinsics.checkNotNullParameter(r111, "showMarketing");
            Intrinsics.checkNotNullParameter(r112, "resolveTitleText");
            this.showAmount = r100;
            this.showPayType = r101;
            this.showTradeName = r102;
            this.showPreBioGuide = r103;
            this.showNoPwdGuide = r104;
            this.preVerifyTopMarginDp = r105;
            this.topRightVisible = r106;
            this.payTypeSwitchable = r107;
            this.showBankCardPointGuide = r110;
            this.showMarketing = r111;
            this.resolveTitleText = r112;
        }

        public /* synthetic */ PageStyleConfig(Function0 r110, Function0 r111, Function0 r112, boolean r113, boolean r114, int r115, Function0 r210, Function0 r211, boolean r212, Function0 r213, Function0 r214, int r215, DefaultConstructorMarker r216) {
            if ((r215 & 256) == 0) goto L5;
            boolean r116 = true;
        L6:
            this(r110, r111, r112, r113, r114, r115, r210, r211, r116, r213, r214);
            return;
        L5:
            r116 = r212;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$TopBarState;", "", "pageStyle", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "backIconType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$BackIconType;", "titleText", "", "topRightText", "showTopRight", "", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$BackIconType;Ljava/lang/String;Ljava/lang/String;Z)V", "getBackIconType", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$BackIconType;", "getPageStyle", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomePageWrapper$PageStyle;", "getShowTopRight", "()Z", "getTitleText", "()Ljava/lang/String;", "getTopRightText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TopBarState {
        private final BackIconType backIconType;
        private final PageStyle pageStyle;
        private final boolean showTopRight;
        private final String titleText;
        private final String topRightText;

        public static /* synthetic */ TopBarState copy$default(TopBarState r100, PageStyle r101, BackIconType r102, String r103, String r104, boolean r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.pageStyle;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.backIconType;
        L8:
            BackIconType r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.titleText;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.topRightText;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.showTopRight;
        L17:
            PageStyle r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final PageStyle component1() {
            return this.pageStyle;
        }

        public final BackIconType component2() {
            return this.backIconType;
        }

        public final String component3() {
            return this.titleText;
        }

        public final String component4() {
            return this.topRightText;
        }

        public final boolean component5() {
            return this.showTopRight;
        }

        public final TopBarState copy(PageStyle r100, BackIconType r101, String r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "pageStyle");
            Intrinsics.checkNotNullParameter(r101, "backIconType");
            return new TopBarState(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TopBarState) == true) goto L8;
            return false;
        L8:
            TopBarState r101 = (TopBarState) r100;
            if (this.pageStyle == r101.pageStyle) goto L12;
            return false;
        L12:
            if (this.backIconType == r101.backIconType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.titleText, r101.titleText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.topRightText, r101.topRightText) == true) goto L21;
            return false;
        L21:
            if (this.showTopRight == r101.showTopRight) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.pageStyle.hashCode() * 31) + this.backIconType.hashCode()) * 31;
            String r101 = this.titleText;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.topRightText;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (r104 + r102) * 31;
            if (this.showTopRight == false) goto L13;
            int r107 = 1231;
        L15:
            return r106 + r107;
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "TopBarState(pageStyle=" + this.pageStyle + ", backIconType=" + this.backIconType + ", titleText=" + this.titleText + ", topRightText=" + this.topRightText + ", showTopRight=" + this.showTopRight + ')';
        }

        public final BackIconType getBackIconType() {
            return this.backIconType;
        }

        public final PageStyle getPageStyle() {
            return this.pageStyle;
        }

        public final boolean getShowTopRight() {
            return this.showTopRight;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final String getTopRightText() {
            return this.topRightText;
        }

        public TopBarState(PageStyle r100, BackIconType r101, String r102, String r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "pageStyle");
            Intrinsics.checkNotNullParameter(r101, "backIconType");
            this.pageStyle = r100;
            this.backIconType = r101;
            this.titleText = r102;
            this.topRightText = r103;
            this.showTopRight = r104;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PageStyle.values().length];
            r100[PageStyle.PASSWORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PageStyle.SMS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PageStyle.CVV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PageStyle.DOUBLE_CONFIRM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final CJStandardHomeViewState getCurrentViewState() {
        return this.cjStandardStateProvider.getCurrentViewState();
    }

    private final boolean hasOtherHomePageInStack() {
        return this.cjStandardStateProvider.hasOtherHomePageInStack(this.view.getHomeFragmentName());
    }

    private final String resolveAmountText() {
        AssetInfoBean r100 = this.cjStandardStateProvider.getCurrentPaymentMethod();     // Catch: Throwable -> L60
        if (r100 != null) goto L7;
        CJLogger.b(TAG, "resolveAmountText: current payment method is null");     // Catch: Throwable -> L60
        return null;
    L7:
        boolean r101 = CJStandardVoucherExpansionManager.Companion.isCurrentAssetExpanded(this.cjStandardStateProvider.getVoucherExpandResult(), r100);     // Catch: Throwable -> L60
        AssetInfoBean.AssetToCombineAssetInfoBean r102 = (AssetInfoBean.AssetToCombineAssetInfoBean) CollectionsKt.firstOrNull(r100.asset_combine_pay_info.asset_to_combine_asset_info_list);     // Catch: Throwable -> L60
        boolean r103 = false;
        if (r102 != null) goto L10;
        AssetInfoBean.AssetExtensionShowInfo r104 = r100.asset_extension_show_info;     // Catch: Throwable -> L60
        if (r100.isShowPaymentSelectionMaterial() == true) goto L27;
    L29:
        boolean r105 = false;
    L31:
        if (r100.isShowFunctionGuide() == true) goto L33;
    L35:
        boolean r106 = false;
    L36:
        if (r105 == false) goto L44;
        String r107 = r100.getPaymentSelectionMaterialKey();     // Catch: Throwable -> L60
        if (r107.length() <= 0) goto L40;
        boolean r108 = true;
    L41:
        if (r108 == false) goto L43;
        String r109 = AssetInfoUtil.INSTANCE.parseBindCardPointStandardShowAmount(r104, r107);     // Catch: Throwable -> L60
    L54:
        if (r109.length() != 0) goto L56;
        r103 = true;
    L56:
        if (r103 == false) goto L58;
        r109 = null;
    L58:
        CJLogger.a(TAG, "resolveAmountText: amount=" + r109);     // Catch: Throwable -> L60
        return r109;
    L43:
        r109 = AssetInfoUtil.INSTANCE.parseStandardShowAmount(r104, r101);     // Catch: Throwable -> L60
        goto L54
    L40:
        r108 = false;
        goto L41
    L44:
        if (r106 == false) goto L52;
        String r110 = r100.getFunctionGuideMaterialKey();     // Catch: Throwable -> L60
        if (r110.length() <= 0) goto L48;
        boolean r111 = true;
    L49:
        if (r111 == false) goto L51;
        r109 = AssetInfoUtil.INSTANCE.parseBindCardPointStandardShowAmount(r104, r110);     // Catch: Throwable -> L60
        goto L54
    L51:
        r109 = AssetInfoUtil.INSTANCE.parseStandardShowAmount(r104, r101);     // Catch: Throwable -> L60
        goto L54
    L48:
        r111 = false;
        goto L49
    L52:
        r109 = AssetInfoUtil.INSTANCE.parseStandardShowAmount(r104, r101);     // Catch: Throwable -> L60
        goto L54
    L33:
        if (r100.isFunctionGuideChecked() == false) goto L35;
        r106 = true;
        goto L36
    L27:
        if (r100.isPaymentSelectionChecked() == false) goto L29;
        r105 = true;
        goto L31
    L10:
        if (r102.isShowPaymentSelectionMaterial() == true) goto L12;
    L14:
        boolean r112 = false;
    L15:
        if (r112 == false) goto L23;
        String r113 = r102.getPaymentSelectionMaterialKey();     // Catch: Throwable -> L60
        if (r113.length() <= 0) goto L19;
        boolean r114 = true;
    L20:
        if (r114 == false) goto L22;
        r109 = AssetProcessUtils.INSTANCE.getCombinePayShowAmount(r102, r113);     // Catch: Throwable -> L60
        goto L54
    L22:
        r109 = AssetInfoUtil.INSTANCE.parseCombineStandardShowAmount(r102, r101);     // Catch: Throwable -> L60
        goto L54
    L19:
        r114 = false;
        goto L20
    L23:
        r109 = AssetInfoUtil.INSTANCE.parseCombineStandardShowAmount(r102, r101);     // Catch: Throwable -> L60
        goto L54
    L12:
        if (r102.isPaymentSelectionChecked() == false) goto L14;
        r112 = true;
    L60:
        th = move-exception;
        CJLogger.c(TAG, "resolveAmountText exception", th);
        CJReporter r115 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "CJStandardHomePageWrapper#resolveAmountText", 2, th);
        return null;
    }

    private final CJPayProtocolGroupContentsBean resolveNoPwdGuideInfo() {
        CJPayCheckoutCounterResponseBean r100 = this.cjStandardStateProvider.getUnifyStandardData().getCheckoutResponse();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.nopwd_guide_info;
    }

    private final CJPayPreBioGuideInfo resolvePreBioGuideInfo() {
        CJPayCheckoutCounterResponseBean r100 = this.cjStandardStateProvider.getUnifyStandardData().getCheckoutResponse();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.pre_bio_guide_info;
    }

    private final boolean resolveShowAmount() {
        CJPayPayInfo r100 = this.cjStandardStateProvider.getUnifyStandardData().getPayInfo();
        if (r100 == null) goto L5;
        String r101 = r100.show_amount_view;
    L7:
        return !Intrinsics.areEqual(r101, "0");
    L5:
        r101 = null;
        goto L7
    }

    private final boolean resolveShowPayTypeByServer() {
        CJPayPayInfo r100 = this.cjStandardStateProvider.getUnifyStandardData().getPayInfo();
        if (r100 == null) goto L5;
        String r101 = r100.show_change_paytype;
    L7:
        return !Intrinsics.areEqual(r101, "0");
    L5:
        r101 = null;
        goto L7
    }

    private final boolean resolveShowTradeNameByServer() {
        CheckoutCounterCashDeskShowConf r100 = this.cjStandardStateProvider.getUnifyStandardData().getCashDeskShowConf();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.show_trade_name;
    }

    public final AssetInfoBean getCurrentPaymentMethod() {
        return this.cjStandardStateProvider.getCurrentPaymentMethod();
    }

    private final boolean resolveShowDiscount() {
        if (resolveShowAmount() == true) goto L5;
    L7:
        return false;
    L5:
        if (CJStringExtensionKt.isNotNullOrEmpty(resolveAmountText()) == false) goto L7;
        return true;
    }

    public final String getAmountText() {
        return resolveAmountText();
    }

    public static final /* synthetic */ CJStandardStateProvider access$getCjStandardStateProvider$p(CJStandardHomePageWrapper r100) {
        return r100.cjStandardStateProvider;
    }

    public static final /* synthetic */ boolean access$hasOtherHomePageInStack(CJStandardHomePageWrapper r100) {
        return r100.hasOtherHomePageInStack();
    }

    public static final /* synthetic */ boolean access$resolveShowAmount(CJStandardHomePageWrapper r100) {
        return r100.resolveShowAmount();
    }

    public static final /* synthetic */ boolean access$resolveShowDiscount(CJStandardHomePageWrapper r100) {
        return r100.resolveShowDiscount();
    }

    public static final /* synthetic */ boolean access$resolveShowPayTypeByServer(CJStandardHomePageWrapper r100) {
        return r100.resolveShowPayTypeByServer();
    }

    public static final /* synthetic */ boolean access$resolveShowTradeNameByServer(CJStandardHomePageWrapper r100) {
        return r100.resolveShowTradeNameByServer();
    }

    private final PageStyleConfig getPageStyleConfig(PageStyle r310) {
        int r100 = WhenMappings.$EnumSwitchMapping$0[r310.ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return new PageStyleConfig(new AnonymousClass22(this), new AnonymousClass23(this), new AnonymousClass24(this), false, false, 0, new AnonymousClass25(this), new AnonymousClass26(this), true, new AnonymousClass27(this), AnonymousClass28.INSTANCE);
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new PageStyleConfig(AnonymousClass15.INSTANCE, AnonymousClass16.INSTANCE, AnonymousClass17.INSTANCE, false, false, 0, AnonymousClass18.INSTANCE, AnonymousClass19.INSTANCE, false, AnonymousClass20.INSTANCE, new AnonymousClass21(this));
    L19:
        return new PageStyleConfig(new AnonymousClass8(this), new AnonymousClass9(this), new AnonymousClass10(this), false, false, 4, new AnonymousClass11(this), AnonymousClass12.INSTANCE, true, new AnonymousClass13(this), AnonymousClass14.INSTANCE);
    L16:
        return new PageStyleConfig(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), true, true, 0, new AnonymousClass4(this), new AnonymousClass5(this), true, new AnonymousClass6(this), new AnonymousClass7(this));
    }

    private final String getTopRightText(PageStyle r100) {
        if (r100 != PageStyle.DOUBLE_CONFIRM) goto L16;
        CJPayCheckoutCounterResponseBean r101 = this.cjStandardStateProvider.getUnifyStandardData().getCheckoutResponse();
        if (r101 == null) goto L13;
        CJPayDoubleConfirmPageInfo r102 = r101.double_confirm_page_info;
        if (r102 == null) goto L13;
        CJPayTopRightBtnInfo r103 = r102.sub_button_info;
        if (r103 == null) goto L13;
        String r104 = r103.desc;
        if (r104 == null) goto L13;
        return r104;
    L13:
        return "";
    L16:
        return this.cjStandardStateProvider.getTopRightTextForCurrentView();
    }

    private final void reportTopRightButtonShowIfNeeded(HomePageRenderState r100) {
        String r101 = r100.getTopRightText();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r100.getShowTopRight() == true) goto L8;
        return;
    L8:
        if (r101.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(this.lastReportedTopRightButtonName, r101) == false) goto L16;
        return;
    L16:
        CJUnifyPayEventUtils r103 = CJUnifyPayEventUtils.INSTANCE;
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "payment_process", "first_pay");
        PreVerifyTypeStrategy r105 = this.cjStandardStateProvider.getCurPreVerifyTypeStrategy();
        if (r105 == null) goto L21;
        UnifyPreVerifyType r106 = r105.getCurPreVerifyType();
        if (r106 == null) goto L21;
        Integer r107 = Integer.valueOf(r106.toCheckType());
    L22:
        KtSafeMethodExtensionKt.safePut(r104, "current_verify_type", String.valueOf(r107));
        KtSafeMethodExtensionKt.safePut(r104, "button_name", r101);
        Unit r108 = Unit.INSTANCE;
        CJUnifyPayEventUtils.uploadEvent$default(r103, "wallet_cashier_right_button_show", r104, false, 4, null);
        this.lastReportedTopRightButtonName = r101;
        return;
    L21:
        r107 = null;
        goto L22
    L10:
        r102 = false;
        goto L11
    }

    private final BackIconType resolveBackIconType(PageStyle r100) {
        if (r100 != PageStyle.DOUBLE_CONFIRM) goto L7;
        return BackIconType.CLOSE;
    L7:
        if (this.view.getHomeEnterAnimType() == 1) goto L9;
        boolean r101 = this.homePageAction.backView().isCloseIcon();
        if (getCurrentViewState() != CJStandardHomeViewState.PASSWORD) goto L18;
        Boolean r102 = this.cjStandardStateProvider.leftCanBackForCurrentView();
        if (r102 == null) goto L18;
        if (r101 == false) goto L18;
        if (r102.booleanValue() == false) goto L18;
        r101 = false;
    L18:
        if (r101 == false) goto L21;
        return BackIconType.CLOSE;
    L21:
        return BackIconType.BACK;
    L9:
        return BackIconType.BACK;
    }

    private final AssetInfoBean resolveBankCardPointAsset(AssetInfoBean r100) {
        UnifyPreVerifyBaseVM r101 = this.cjStandardStateProvider.getVerifyComponentByType(UnifyPreVerifyType.VERIFY_TYPE_PWD);
        if ((r101 instanceof UnifyPreVerifyPasswordVM) == false) goto L8;
        if (((UnifyPreVerifyPasswordVM) r101).getCurrentPageStatus() == UnifyPreVerifyPasswordVM.PageStatus.VERIFY_PWD) goto L8;
        return null;
    L8:
        if (CJStandardDefaultBankCardPointHandler.INSTANCE.shouldShowFunctionGuide(r100) == true) goto L17;
        StringBuilder r102 = new StringBuilder("resolveBankCardPointAsset skip: symbol=");
        if (r100 == null) goto L14;
        AssetInfoBean.AssetMetaInfoBean r103 = r100.asset_meta_info;
        if (r103 == null) goto L14;
        String r104 = r103.getUniqueSymbol();
    L15:
        r102.append(r104);
        CJLogger.d(TAG, r102.toString());
        return null;
    L14:
        r104 = null;
        goto L15
    L17:
        return r100;
    }

    private final String resolveTradeName(boolean r100) {
        CJPayCheckoutCounterResponseBean r101 = this.cjStandardStateProvider.getUnifyStandardData().getCheckoutResponse();
        if (r101 == null) goto L5;
        CJPayTradeInfo r102 = r101.trade_info;
    L6:
        if (r100 == false) goto L9;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.secondary_trade_name;
    L9:
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.trade_name;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean isPayTypeSwitchable(PageStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "pageStyle");
        return getPageStyleConfig(r100).getPayTypeSwitchable().invoke().booleanValue();
    }

    public final boolean isShowMarketing(PageStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "pageStyle");
        return getPageStyleConfig(r100).getShowMarketing().invoke().booleanValue();
    }

    public final boolean isShowPayType(PageStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "pageStyle");
        return getPageStyleConfig(r100).getShowPayType().invoke().booleanValue();
    }

    private final CJPayPayInfo.SubPayTypeRecommend getRecommend(PageStyle r100, AssetInfoBean r101) {
        CJPayPayInfo r102 = this.cjStandardStateProvider.getUnifyStandardData().getPayInfo();
        if (r102 == null) goto L5;
        CJPayPayInfo.SubPayTypeRecommend r103 = r102.sub_pay_type_recommend;
    L6:
        if (r101 == null) goto L10;
        AssetInfoBean.AssetMetaInfoBean r104 = r101.asset_meta_info;
        if (r104 == null) goto L10;
        String r105 = r104.getUniqueSymbol();
    L11:
        if (r103 == null) goto L15;
        AssetInfoBean.AssetMetaInfoBean r106 = r103.asset_meta_info;
        if (r106 == null) goto L15;
        String r107 = r106.getUniqueSymbol();
    L17:
        if (r100 != PageStyle.PASSWORD) goto L39;
        boolean r108 = false;
        if (r107 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == true) goto L39;
        if (this.cjStandardStateProvider.hasClickedPayTypeRecommend() == true) goto L39;
        if (r105 != null) goto L31;
    L38:
        return r103;
    L31:
        if (r105.length() != 0) goto L33;
        r108 = true;
    L33:
        if (r108 == true) goto L38;
        if (Intrinsics.areEqual(r105, r107) == false) goto L38;
        return null;
    L21:
        if (r107.length() == 0) goto L24;
        r109 = false;
    L39:
        return null;
    L15:
        r107 = null;
    L10:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    private final boolean isPageStyleMatchCurrentViewState(PageStyle r100, CJStandardHomeViewState r101) {
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L16;
        if (r102 != 4) goto L14;
        if (r101 != CJStandardHomeViewState.DOUBLE_CONFIRM) goto L25;
    L23:
        return true;
    L25:
        return false;
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r101 == CJStandardHomeViewState.CVV) goto L23;
        return false;
    L19:
        if (r101 == CJStandardHomeViewState.SMS) goto L23;
        return false;
    L22:
        if (r101 == CJStandardHomeViewState.PASSWORD) goto L23;
        return false;
    }

    public final TopBarState buildTopBarState(PageStyle r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "pageStyle");
        PageStyleConfig r100 = getPageStyleConfig(r110);
        BackIconType r101 = resolveBackIconType(r110);
        String r102 = r100.getResolveTitleText().invoke();
        String r103 = getTopRightText(r110);
        CJStandardHomeViewState r104 = getCurrentViewState();
        boolean r105 = isPageStyleMatchCurrentViewState(r110, r104);
        if (r105 == true) goto L7;
        String r106 = this.topRightText;
        if (r106 == null) goto L7;
    L8:
        this.topRightText = r106;
        if (r110 != PageStyle.PASSWORD) goto L12;
        if (r111 == null) goto L12;
        boolean r112 = r111.optBoolean("top_right_allow_show", true);
    L13:
        if (r112 == true) goto L15;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L22;
        String r108 = this.topRightText;
    L23:
        CJLogger.d(TAG, "buildTopBarState pageStyle=" + r110 + " viewState=" + r104 + " match=" + r105 + " backIcon=" + r101 + " title=" + r102 + " allowShow=" + r112 + " topRightVisible=" + r100.getTopRightVisible().invoke().booleanValue() + " latestTopRightText=" + r103 + " cachedTopRightText=" + this.topRightText + " renderTopRightText=" + r108 + " showTopRight=" + r107);
        return new TopBarState(r110, r101, r102, r108, r107);
    L22:
        r108 = null;
        goto L23
    L15:
        if (r100.getTopRightVisible().invoke().booleanValue() == false) goto L19;
        if (CJStringExtensionKt.isNotNullOrEmpty(this.topRightText) == false) goto L19;
        r107 = true;
    L12:
        r112 = true;
    L7:
        r106 = r103;
        goto L8
    }

    public final void render(PageStyle r210, UnifyPreVerifyBaseVM r211) {
        Intrinsics.checkNotNullParameter(r210, "pageStyle");
        PageStyleConfig r100 = getPageStyleConfig(r210);
        TopBarState r101 = buildTopBarState(r210, null);
        AssetInfoBean r102 = getCurrentPaymentMethod();
        if (r100.getShowAmount().invoke().booleanValue() == false) goto L5;
        String r103 = getAmountText();
    L7:
        if (r210 != PageStyle.PASSWORD) goto L9;
    L12:
        VoucherDialogExpandResult r104 = this.cjStandardStateProvider.getVoucherExpandResult();
        if (r104 == null) goto L15;
        String r105 = r104.isOneCentPurchaseExpand;
    L17:
        if (Intrinsics.areEqual(r105, "1") == false) goto L19;
        boolean r106 = true;
    L21:
        if (r100.getShowTradeName().invoke().booleanValue() == false) goto L23;
        String r107 = resolveTradeName(r106);
    L25:
        if (r100.getShowBankCardPointGuide() == false) goto L27;
        AssetInfoBean r110 = resolveBankCardPointAsset(r102);
    L28:
        String r108 = r101.getTopRightText();
        boolean r111 = r101.getShowTopRight();
        int r112 = r100.getPreVerifyTopMarginDp();
        boolean r113 = r100.getShowPayType().invoke().booleanValue();
        boolean r114 = r100.getPayTypeSwitchable().invoke().booleanValue();
        CJPayPreBioGuideInfo r115 = resolvePreBioGuideInfo();
        CJPayProtocolGroupContentsBean r116 = resolveNoPwdGuideInfo();
        boolean r117 = r100.getShowPreBioGuide();
        boolean r212 = r100.getShowNoPwdGuide();
        CJPayPayInfo.SubPayTypeRecommend r213 = getRecommend(r210, r102);
        boolean r214 = r100.getShowMarketing().invoke().booleanValue();
        if (r102 == null) goto L35;
        AssetInfoBean.AssetExtensionShowInfo r109 = r102.asset_extension_show_info;
        if (r109 == null) goto L35;
        AssetInfoBean.VoucherMsgBean r118 = r109.voucher_msg_map;
        if (r118 == null) goto L35;
        List r215 = AssetInfoBean.VoucherMsgBean.getStdUIVoucherMsgV2OfPremiumFeelTag$default(r118, false, 1, null);
    L36:
        CJPayCheckoutCounterResponseBean r119 = this.cjStandardStateProvider.getUnifyStandardData().getCheckoutResponse();
        if (r119 == null) goto L39;
        ArrayList<UIComponent> r216 = r119.countdown_area;
    L40:
        HomePageRenderState r120 = new HomePageRenderState(r101, r210, r108, r111, r112, r103, r107, r102, r113, r114, r115, r116, r117, r212, r110, r213, r214, r215, r216);
        reportTopRightButtonShowIfNeeded(r120);
        CJStandardHomePageView r121 = this.view;
        if (r211 == null) goto L43;
        View r122 = r211.getEmbeddedView();
    L44:
        r121.render(r120, r122);
        return;
    L43:
        r122 = null;
        goto L44
    L39:
        r216 = null;
    L35:
        r215 = null;
        goto L36
    L27:
        r110 = null;
        goto L28
    L23:
        r107 = null;
    L19:
        r106 = false;
        goto L21
    L15:
        r105 = null;
        goto L17
    L9:
        if (r210 == PageStyle.SMS) goto L12;
        if (r210 != PageStyle.DOUBLE_CONFIRM) goto L19;
    L5:
        r103 = null;
        goto L7
    }

    public CJStandardHomePageWrapper(CJStandardStateProvider r100, CJStandardHomePageAction r101, CJStandardHomePageView r102) {
        Intrinsics.checkNotNullParameter(r100, "cjStandardStateProvider");
        Intrinsics.checkNotNullParameter(r101, "homePageAction");
        Intrinsics.checkNotNullParameter(r102, "view");
        this.cjStandardStateProvider = r100;
        this.homePageAction = r101;
        this.view = r102;
    }
}
