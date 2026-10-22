package com.android.ttcjpaysdk.integrated.counter.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.integrated.counter.adapter.CJPayConfirmAdapter;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.Card;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.IntegratedCounterResponseData;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.fragment.BindCardParamsData;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayCommonParamsBuildUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayPaymentMethodUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u00002\u00020\u0001:\u0003rstB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010$\u001a\u00020%2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H&JR\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001f0*j\b\u0012\u0004\u0012\u00020\u001f`+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010/2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`+H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\"\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001f0*j\b\u0012\u0004\u0012\u00020\u001f`+2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00105\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u00107\u001a\u000208H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H&J\b\u0010<\u001a\u000208H&J\b\u0010=\u001a\u00020\u000eH\u0016J\b\u0010>\u001a\u00020%H\u0016J\b\u0010?\u001a\u00020%H&J\b\u0010@\u001a\u00020%H&J.\u0010A\u001a\u00020%2\u001a\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`+2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016J\u0016\u0010E\u001a\u00020\u000e2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001f0FH\u0016J\u0018\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006H\u0016J\u0012\u0010J\u001a\u00020%2\b\b\u0002\u0010K\u001a\u00020\u0006H\u0016J\b\u0010L\u001a\u00020%H\u0016J\u0010\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020\u0006H&J9\u0010O\u001a\u00020\u000e2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2#\u0010R\u001a\u001f\u0012\u0013\u0012\u001108¢\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020%\u0018\u00010SH\u0016J\b\u0010W\u001a\u00020%H\u0016J\u0012\u0010X\u001a\u00020%2\b\u0010B\u001a\u0004\u0018\u00010\u0006H\u0016J2\u0010Y\u001a\u00020%2\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u001f0*j\b\u0012\u0004\u0012\u00020\u001f`+2\u0006\u0010Z\u001a\u00020\u001f2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u001a\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010_\u001a\u00020%2\b\u0010Z\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000eH&J\"\u0010b\u001a\u00020%2\b\u0010c\u001a\u0004\u0018\u00010\u00062\u0006\u0010d\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020\u000eH\u0016J\u0010\u0010f\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000eH&J\u0010\u0010g\u001a\u00020%2\u0006\u0010h\u001a\u00020\u0006H\u0016J\b\u0010i\u001a\u00020%H&J\u0010\u0010j\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000eH&J\b\u0010k\u001a\u00020%H\u0016J\u0010\u0010l\u001a\u00020%2\u0006\u0010m\u001a\u00020\u000eH&J\b\u0010n\u001a\u00020%H\u0016J\u0010\u0010o\u001a\u00020%2\u0006\u0010a\u001a\u00020\u000eH&J\b\u0010p\u001a\u00020%H\u0004J\b\u0010q\u001a\u00020%H\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006u"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "getCheckoutResponseBean", "()Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "setCheckoutResponseBean", "(Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;)V", "isLeftCloseClicked", "", "()Z", "setLeftCloseClicked", "(Z)V", "onConfirmWrapperListener", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnConfirmWrapperListener;", "getOnConfirmWrapperListener", "()Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnConfirmWrapperListener;", "setOnConfirmWrapperListener", "(Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnConfirmWrapperListener;)V", "onDyPayConfirmWrapperListener", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnDyPayConfirmWrapperListener;", "getOnDyPayConfirmWrapperListener", "()Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnDyPayConfirmWrapperListener;", "setOnDyPayConfirmWrapperListener", "(Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnDyPayConfirmWrapperListener;)V", "paymentMethodInfo", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "getPaymentMethodInfo", "()Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "setPaymentMethodInfo", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;)V", "bindData", "", "executeAdjustOnScreenChanged", "newConfig", "Landroid/content/res/Configuration;", "getBindSelectMethodInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shareData", "Lcom/android/ttcjpaysdk/integrated/counter/beans/ShareData;", "subPayList", "getBytePayCardInfo", "bankCardId", "getConfirmBtnText", "getConfirmPayList", "getFrontBankCode", "methodInfo", "getMethodShowType", "", "getPanelView", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getResId", "handleBackPressed", "hideLayer", "hideLoading", "initActions", "initDefaultSelectMethodInfo", "paymentMethods", "isAddPanelLayer", "isDyPaySelected", "isPayConfirmEnable", "", "notifyUnavailablePayMethod", "bankCardNo", "errorMsg", "onOverseaPayCurrencyUpdate", "currency", "onRelease", "onTimeChange", "time", "onVerifyChange", "data", "Lorg/json/JSONObject;", "changePayMethod", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "refreshDiscountDesc", "refreshFloatingBanner", "refreshSelect", "info", "adapter", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter;", "resetCounterPayment", "payBankCardId", "scrollToPos", "setBackVisible", "enable", "setBusinessFooter", SocialConstants.PARAM_APP_DESC, "isIndependentShow", "isExpand", "setPayConfirmViewEnabled", d.f25925o, "text", "setTitleData", "showConfirmLoading", "showLayer", DyPayConstant.KEY_SHOW_LOADING, "show", "updateData", "updatePayConfirmContent", "walletCashierCloseClick", "walletCashierCustomerServiceClick", "OnConfirmWrapperListener", "OnDyPayConfirmWrapperListener", "SelectPayTypeEnum", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseConfirmWrapper extends BaseWrapper {
    private final String TAG;
    private CounterResponseBean checkoutResponseBean;
    private boolean isLeftCloseClicked;
    private OnConfirmWrapperListener onConfirmWrapperListener;
    private OnDyPayConfirmWrapperListener onDyPayConfirmWrapperListener;
    private PaymentMethodInfo paymentMethodInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnConfirmWrapperListener;", "", "isLocalEnableFingerprint", "", "onPayConfirmClick", "", "onPayConfirmClickFromGameCashier", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "setUseIncomePayMethod", "startVerifyForPwd", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfirmWrapperListener {
        boolean isLocalEnableFingerprint();

        void onPayConfirmClick();

        void onPayConfirmClickFromGameCashier(PaymentMethodInfo r100);

        void setUseIncomePayMethod();

        void startVerifyForPwd();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u001e\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0005H&¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$OnDyPayConfirmWrapperListener;", "", "isLocalEnableFingerprint", "", "onChangeMethod", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "onClickIconTips", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "onPayConfirmClick", "onSelectDetail", "doEvent", "setSecurityLoadingInfo", "setUseIncomePayMethod", "startVerifyForPwd", "toBindCardPay", "newCardParams", "Lorg/json/JSONObject;", "paymentMethodInfo", "toIndependentBindCard", "bindCardInfoData", "Lcom/android/ttcjpaysdk/integrated/counter/fragment/BindCardParamsData;", "toSetOverseaPaymentCurrency", "jumpUrl", "", "tradeCreateWithFallBack", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDyPayConfirmWrapperListener {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onSelectDetail$default(OnDyPayConfirmWrapperListener r100, boolean r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = true;
            L6:
                r100.onSelectDetail(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSelectDetail");
            }

            public static /* synthetic */ void toBindCardPay$default(OnDyPayConfirmWrapperListener r100, JSONObject r101, PaymentMethodInfo r102, int r103, Object r104) {
                if (r104 != null) goto L9;
                if ((r103 & 2) == 0) goto L6;
                r102 = null;
            L6:
                r100.toBindCardPay(r101, r102);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toBindCardPay");
            }
        }

        boolean isLocalEnableFingerprint();

        void onChangeMethod(PaymentMethodInfo r100);

        void onClickIconTips(IconTips r100);

        void onPayConfirmClick();

        void onSelectDetail(boolean r100);

        void setSecurityLoadingInfo();

        void setUseIncomePayMethod();

        void startVerifyForPwd();

        void toBindCardPay(JSONObject r100, PaymentMethodInfo r101);

        void toIndependentBindCard(PaymentMethodInfo r100, BindCardParamsData r101);

        void toSetOverseaPaymentCurrency(String r100);

        void tradeCreateWithFallBack();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseConfirmWrapper$SelectPayTypeEnum;", "", "value", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getValue", "()I", "setValue", "(I)V", "BankcardPay", "NeedSign", "AddNewBankcardAndPay", "BalanceOrBankcardNotAvailable", "Weixin", "Alipay", "BalancePay", "SelectNone", "QrCodePay", "BankcardOnestepPay", "BalanceOnestepPay", "INCOMEPay", "CREDITPay", "DyPay", "TransferPay", "ECNY", "BankcardShare", "GlobalPay", "FundPay", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SelectPayTypeEnum extends Enum<SelectPayTypeEnum> {
        private static final /* synthetic */ SelectPayTypeEnum[] $VALUES = null;
        public static final SelectPayTypeEnum AddNewBankcardAndPay = null;
        public static final SelectPayTypeEnum Alipay = null;
        public static final SelectPayTypeEnum BalanceOnestepPay = null;
        public static final SelectPayTypeEnum BalanceOrBankcardNotAvailable = null;
        public static final SelectPayTypeEnum BalancePay = null;
        public static final SelectPayTypeEnum BankcardOnestepPay = null;
        public static final SelectPayTypeEnum BankcardPay = null;
        public static final SelectPayTypeEnum BankcardShare = null;
        public static final SelectPayTypeEnum CREDITPay = null;
        public static final SelectPayTypeEnum DyPay = null;
        public static final SelectPayTypeEnum ECNY = null;
        public static final SelectPayTypeEnum FundPay = null;
        public static final SelectPayTypeEnum GlobalPay = null;
        public static final SelectPayTypeEnum INCOMEPay = null;
        public static final SelectPayTypeEnum NeedSign = null;
        public static final SelectPayTypeEnum QrCodePay = null;
        public static final SelectPayTypeEnum SelectNone = null;
        public static final SelectPayTypeEnum TransferPay = null;
        public static final SelectPayTypeEnum Weixin = null;
        private String desc;
        private int value;

        private static final /* synthetic */ SelectPayTypeEnum[] $values() {
            return new SelectPayTypeEnum[]{BankcardPay, NeedSign, AddNewBankcardAndPay, BalanceOrBankcardNotAvailable, Weixin, Alipay, BalancePay, SelectNone, QrCodePay, BankcardOnestepPay, BalanceOnestepPay, INCOMEPay, CREDITPay, DyPay, TransferPay, ECNY, BankcardShare, GlobalPay, FundPay};
        }

        public static SelectPayTypeEnum valueOf(String r100) {
            return (SelectPayTypeEnum) a.a(SelectPayTypeEnum.class, r100);
        }

        public static SelectPayTypeEnum[] values() {
            return (SelectPayTypeEnum[]) $VALUES.clone();
        }

        static {
            BankcardPay = new SelectPayTypeEnum("BankcardPay", 0, 1, "普通银行正常支付");
            NeedSign = new SelectPayTypeEnum("NeedSign", 1, 2, "补签约");
            AddNewBankcardAndPay = new SelectPayTypeEnum("AddNewBankcardAndPay", 2, 3, "添加新卡支付");
            BalanceOrBankcardNotAvailable = new SelectPayTypeEnum("BalanceOrBankcardNotAvailable", 3, 4, "余额或者普通银行卡不可用");
            Weixin = new SelectPayTypeEnum("Weixin", 4, 5, "微信");
            Alipay = new SelectPayTypeEnum("Alipay", 5, 6, "支付宝");
            BalancePay = new SelectPayTypeEnum("BalancePay", 6, 7, "余额支付");
            SelectNone = new SelectPayTypeEnum("SelectNone", 7, 9, "什么都没选");
            QrCodePay = new SelectPayTypeEnum("QrCodePay", 8, 10, "扫码支付");
            BankcardOnestepPay = new SelectPayTypeEnum("BankcardOnestepPay", 9, 11, "银行卡免密支付");
            BalanceOnestepPay = new SelectPayTypeEnum("BalanceOnestepPay", 10, 12, "余额免密支付");
            INCOMEPay = new SelectPayTypeEnum("INCOMEPay", 11, 13, "钱包收入支付");
            CREDITPay = new SelectPayTypeEnum("CREDITPay", 12, 14, "信用支付");
            DyPay = new SelectPayTypeEnum("DyPay", 13, 15, "端外支付");
            TransferPay = new SelectPayTypeEnum("TransferPay", 14, 16, "大额支付");
            ECNY = new SelectPayTypeEnum("ECNY", 15, 17, "数字人民币");
            BankcardShare = new SelectPayTypeEnum("BankcardShare", 16, 18, "共享支付老卡");
            GlobalPay = new SelectPayTypeEnum("GlobalPay", 17, 19, "海外支付");
            FundPay = new SelectPayTypeEnum("FundPay", 18, 20, "赚钱宝");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getValue() {
            return this.value;
        }

        public final void setDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.desc = r100;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        private SelectPayTypeEnum(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.desc = r103;
        }
    }

    public abstract void bindData(CounterResponseBean r100);

    public abstract void executeAdjustOnScreenChanged(Configuration r100);

    public PaymentMethodInfo getBytePayCardInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bankCardId");
        return null;
    }

    public String getConfirmBtnText() {
        return "";
    }

    public View getPanelView() {
        return null;
    }

    public abstract RecyclerView getRecyclerView();

    public abstract int getResId();

    public boolean handleBackPressed() {
        return false;
    }

    public void hideLayer() {
    }

    public abstract void hideLoading();

    public abstract void initActions();

    public boolean isAddPanelLayer() {
        return false;
    }

    public void notifyUnavailablePayMethod(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bankCardNo");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
    }

    public void onOverseaPayCurrencyUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currency");
    }

    public void onRelease() {
    }

    public abstract void onTimeChange(String r100);

    public void refreshDiscountDesc() {
    }

    public void refreshFloatingBanner(String r100) {
    }

    public void resetCounterPayment(String r100, CounterResponseBean r101) {
        Intrinsics.checkNotNullParameter(r100, "payBankCardId");
    }

    public void scrollToPos(PaymentMethodInfo r100) {
    }

    public abstract void setBackVisible(boolean r100);

    public void setBusinessFooter(String r100, boolean r101, boolean r102) {
    }

    public abstract void setPayConfirmViewEnabled(boolean r100);

    public void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    public abstract void setTitleData();

    public abstract void showConfirmLoading(boolean r100);

    public void showLayer() {
    }

    public abstract void showLoading(boolean r100);

    public void updateData() {
    }

    public abstract void updatePayConfirmContent(boolean r100);

    public boolean isDyPaySelected() {
        List r100 = CollectionsKt.listOf(new String[]{"alipay", "wx", "ecnypay", CJPayConstant.TT_CJ_PAY_KEY_FOR_OVERSEA_PAY});
        PaymentMethodInfo r101 = this.paymentMethodInfo;
        if (r101 == null) goto L5;
        String r102 = r101.paymentType;
    L7:
        return !CollectionsKt.contains(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    public final void walletCashierCloseClick() {
        CJPayCommonParamsBuildUtils.Companion.onEvent(getContext(), "wallet_cashier_close_click", new JSONObject());
    }

    public final void walletCashierCustomerServiceClick() {
        CJPayCommonParamsBuildUtils.Companion.onEvent(getContext(), "wallet_cashier_service_click", new JSONObject());
    }

    public int getMethodShowType() {
        if (getContext() == null) goto L121;
        if (ShareData.checkoutResponseBean == null) goto L121;
        PaymentMethodInfo r100 = this.paymentMethodInfo;
        if (r100 == null) goto L113;
        if (TextUtils.isEmpty(r100.paymentType) == true) goto L113;
        String r101 = r100.paymentType;
        if (r101 == null) goto L143;
        switch(r101.hashCode()) {
            case -2143180204: goto L108;
            case -1911820001: goto L104;
            case -1581701048: goto L100;
            case -1414960566: goto L96;
            case -1184259671: goto L92;
            case -1148142799: goto L88;
            case -1066391653: goto L63;
            case -951532658: goto L59;
            case -858433012: goto L55;
            case -339185956: goto L41;
            case 3809: goto L37;
            case 96067571: goto L33;
            case 144002333: goto L29;
            case 674559759: goto L25;
            case 707136099: goto L21;
            case 1066291160: goto L18;
            default: goto L143;
        };
    L18:
        if (r101.equals("addnormalcard") == false) goto L143;
    L122:
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    L21:
        if (r101.equals("addspecificcard") == true) goto L122;
    L25:
        if (r101.equals("creditpay") == false) goto L143;
        return SelectPayTypeEnum.CREDITPay.getValue();
    L29:
        if (r101.equals(CJPayConstant.TT_CJ_PAY_KEY_FOR_MFUND_BCB_PAY) == false) goto L143;
        return SelectPayTypeEnum.FundPay.getValue();
    L33:
        if (r101.equals("dypay") == false) goto L143;
        return SelectPayTypeEnum.DyPay.getValue();
    L37:
        if (r101.equals("wx") == false) goto L143;
        return SelectPayTypeEnum.Weixin.getValue();
    L41:
        if (r101.equals("balance") == false) goto L143;
        if (r100.isCardAvailable() == false) goto L49;
        if (Intrinsics.areEqual("3", r100.identity_verify_way) == true) goto L49;
        return SelectPayTypeEnum.BalancePay.getValue();
    L49:
        if (r100.isCardAvailable() == false) goto L129;
        if (Intrinsics.areEqual("3", r100.identity_verify_way) == false) goto L129;
        return SelectPayTypeEnum.BalanceOnestepPay.getValue();
    L129:
        return SelectPayTypeEnum.BalanceOrBankcardNotAvailable.getValue();
    L55:
        if (r101.equals(CJPayConstant.TT_CJ_PAY_KEY_FOR_OVERSEA_PAY) == false) goto L143;
        return SelectPayTypeEnum.GlobalPay.getValue();
    L59:
        if (r101.equals("qrcode") == false) goto L143;
        return SelectPayTypeEnum.QrCodePay.getValue();
    L63:
        if (r101.equals("quickpay") == false) goto L143;
        if (r100.isCardInactive() == false) goto L69;
        return SelectPayTypeEnum.NeedSign.getValue();
    L69:
        if (r100.isCardAvailable() == false) goto L74;
        if (Intrinsics.areEqual("3", r100.identity_verify_way) == true) goto L74;
        return SelectPayTypeEnum.BankcardPay.getValue();
    L74:
        if (r100.isCardAvailable() == false) goto L79;
        if (Intrinsics.areEqual("3", r100.identity_verify_way) == false) goto L79;
        return SelectPayTypeEnum.BankcardOnestepPay.getValue();
    L79:
        if (CJPayPaymentMethodUtils.Companion.getCardListSize(this.checkoutResponseBean) == 0) goto L136;
        if (r100.isCardAvailable() == true) goto L135;
        if (r100.isCardInactive() == false) goto L136;
    L135:
        return SelectPayTypeEnum.BalanceOrBankcardNotAvailable.getValue();
    L136:
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    L88:
        if (r101.equals("addcard") == false) goto L143;
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    L92:
        if (r101.equals("income") == false) goto L143;
        return SelectPayTypeEnum.INCOMEPay.getValue();
    L96:
        if (r101.equals("alipay") == false) goto L143;
        return SelectPayTypeEnum.Alipay.getValue();
    L100:
        if (r101.equals("share_pay") == false) goto L143;
        return SelectPayTypeEnum.BankcardShare.getValue();
    L104:
        if (r101.equals("ecnypay") == false) goto L143;
        return SelectPayTypeEnum.ECNY.getValue();
    L108:
        if (r101.equals("transfer_pay") == false) goto L143;
        return SelectPayTypeEnum.TransferPay.getValue();
    L143:
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    L113:
        if (CJPayOptimizeSwitch.Companion.get().fixPayNoneSelectPayMethodDefaultPtcodeParam == false) goto L116;
        return SelectPayTypeEnum.SelectNone.getValue();
    L116:
        if (ShareData.isAssetStandard() == false) goto L119;
        return -1;
    L119:
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    L121:
        return SelectPayTypeEnum.AddNewBankcardAndPay.getValue();
    }

    public final CounterResponseBean getCheckoutResponseBean() {
        return this.checkoutResponseBean;
    }

    public final OnConfirmWrapperListener getOnConfirmWrapperListener() {
        return this.onConfirmWrapperListener;
    }

    public final OnDyPayConfirmWrapperListener getOnDyPayConfirmWrapperListener() {
        return this.onDyPayConfirmWrapperListener;
    }

    public final PaymentMethodInfo getPaymentMethodInfo() {
        return this.paymentMethodInfo;
    }

    public final boolean isLeftCloseClicked() {
        return this.isLeftCloseClicked;
    }

    public BaseConfirmWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.TAG = "BaseConfirmWrapper";
        LayoutInflater.from(getContext()).inflate(getResId(), (ViewGroup) r100);
    }

    public ArrayList<PaymentMethodInfo> getConfirmPayList(CounterResponseBean r100) {
        ArrayList<PaymentMethodInfo> r101 = new ArrayList();
        if (r100 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.data.paytype_items.size() == 0) goto L13;
        CJPayPaymentMethodUtils.Companion r102 = CJPayPaymentMethodUtils.Companion;
        String r103 = r102.getDefaultPayType();
        Context r104 = getContext();
        IntegratedCounterResponseData r105 = r100.data;
        ArrayList<PaymentMethodInfo> r106 = r102.getConfirmInfoList(r104, r105.paytype_items, r105.sorted_ptcodes, r103);
        if (r102.isNeedCollapseCashDesk() == true) goto L10;
    L12:
        return r106;
    L10:
        if (ShareData.checkoutResponseBean.getPayItemsShowNum() >= r106.size()) goto L12;
        PaymentMethodInfo r107 = r102.createPaymentMethodForMoreMethod(getContext());
        ListProtector.add(r106, ShareData.checkoutResponseBean.getPayItemsShowNum(), r107);
        goto L12
    }

    public String getFrontBankCode(PaymentMethodInfo r100) {
        if (r100 == null) goto L6;
        Card r101 = r100.card;
        if (r101 == null) goto L6;
        String r102 = r101.front_bank_code;
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public boolean isPayConfirmEnable(List<? extends PaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "paymentMethods");
        if (getContext() != null) goto L5;
        return false;
    L5:
        Iterator<T> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((PaymentMethodInfo) r102).isChecked == false) goto L7;
    L13:
        if (((PaymentMethodInfo) r102) != null) goto L15;
        return false;
    L15:
        PaymentMethodInfo r103 = this.paymentMethodInfo;
        if (r103 != null) goto L18;
        return false;
    L18:
        if (r103 == null) goto L20;
        String r104 = r103.paymentType;
    L22:
        if (r104 == null) goto L57;
        int r105 = r104.hashCode();
        if (r105 == (-1148142799)) goto L54;
        if (r105 == (-1066391653)) goto L34;
        if (r105 != (-339185956)) goto L57;
        if (r104.equals("balance") == false) goto L57;
    L35:
        PaymentMethodInfo r106 = this.paymentMethodInfo;
        if (r106 != null) goto L38;
    L40:
        boolean r107 = false;
    L41:
        if (r107 == false) goto L44;
        return true;
    L44:
        if (ShareData.checkoutResponseBean == null) goto L66;
        CJPayPaymentMethodUtils.Companion r108 = CJPayPaymentMethodUtils.Companion;
        if (r108.getCardListSize(ShareData.checkoutResponseBean) > 0) goto L48;
        return false;
    L48:
        if (StringsKt.contains$default(r108.getMethods(ShareData.checkoutResponseBean), "quickpay", false, 2, null) == true) goto L50;
        return false;
    L50:
        if (r108.isAvailableBindCard(ShareData.checkoutResponseBean) == false) goto L69;
        return true;
    L69:
        return false;
    L66:
        return false;
    L38:
        if (r106.isCardAvailable() != true) goto L40;
        r107 = true;
        goto L41
    L34:
        if (r104.equals("quickpay") == false) goto L57;
    L54:
        if (r104.equals("addcard") == false) goto L57;
        return true;
    L57:
        PaymentMethodInfo r109 = this.paymentMethodInfo;
        if (r109 != null) goto L60;
        return false;
    L60:
        if (r109.isCardAvailable() != true) goto L71;
        return true;
    L71:
        return false;
    L20:
        r104 = null;
        goto L22
    L11:
        r102 = null;
        goto L13
    }

    public final void setCheckoutResponseBean(CounterResponseBean r100) {
        this.checkoutResponseBean = r100;
    }

    public final void setLeftCloseClicked(boolean r100) {
        this.isLeftCloseClicked = r100;
    }

    public final void setOnConfirmWrapperListener(OnConfirmWrapperListener r100) {
        this.onConfirmWrapperListener = r100;
    }

    public final void setOnDyPayConfirmWrapperListener(OnDyPayConfirmWrapperListener r100) {
        this.onDyPayConfirmWrapperListener = r100;
    }

    public final void setPaymentMethodInfo(PaymentMethodInfo r100) {
        this.paymentMethodInfo = r100;
    }

    public void initDefaultSelectMethodInfo(ArrayList<PaymentMethodInfo> r100, ShareData r101) {
        if (r100 == null) goto L15;
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L21;
        PaymentMethodInfo r103 = (PaymentMethodInfo) r102.next();
        if (r103.isChecked != true) goto L5;
        if (r101 == null) goto L11;
        r101.selectPaymentMethodInfo = r103;
    L11:
        if (r101 == null) goto L14;
        r101.selectDetailMethodInfo = r103;
    L14:
        ShareData.setCJPayPaymentMethodInfo(r103);
        CJLogger.d(this.TAG, "initDefaultSelectMethodInfo select " + r103.assetInfoBean.asset_meta_info.asset_id);
        goto L5
    L21:
        return;
    }

    public boolean onVerifyChange(JSONObject r100, Function1<? super Integer, Unit> r101) {
        if (r100 == null) goto L6;
        String r102 = r100.optString("index", "");
        if (r102 == null) goto L6;
        Integer r103 = StringsKt.toIntOrNull(r102);
    L7:
        if (r103 == null) goto L12;
        if (r101 == null) goto L13;
        r101.invoke(r103);
        return true;
    L13:
        return true;
    L12:
        return true;
    L6:
        r103 = null;
        goto L7
    }

    public void refreshSelect(ArrayList<PaymentMethodInfo> r100, PaymentMethodInfo r101, CJPayConfirmAdapter r102) {
        Intrinsics.checkNotNullParameter(r100, "paymentMethods");
        Intrinsics.checkNotNullParameter(r101, "info");
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        PaymentMethodInfo r104 = (PaymentMethodInfo) r103.next();
        r104.isChecked = false;
        if (Intrinsics.areEqual(r104, r101) == false) goto L4;
        r104.isChecked = true;
        goto L4
    L8:
        if (r102 == null) goto L16;
        r102.dataChangedNotify(r100);
        return;
    }

    public static /* synthetic */ void onOverseaPayCurrencyUpdate$default(BaseConfirmWrapper r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = "";
    L6:
        r100.onOverseaPayCurrencyUpdate(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOverseaPayCurrencyUpdate");
    }

    public ArrayList<PaymentMethodInfo> getBindSelectMethodInfoList(Context r100, CounterResponseBean r101, ShareData r102, ArrayList<PaymentMethodInfo> r110) {
        ArrayList<PaymentMethodInfo> r111 = new ArrayList();
        if (r102 == null) goto L10;
        if (r101 == null) goto L10;
        if (r101.data.paytype_items.size() == 0) goto L10;
        String r103 = r102.selectDetailMethodInfo.paymentType;
        CJPayPaymentMethodUtils.Companion r104 = CJPayPaymentMethodUtils.Companion;
        IntegratedCounterResponseData r105 = r101.data;
        return r104.getMethodInfoList(r100, r105.paytype_items, r102, r105.sorted_ptcodes, r103);
    L10:
        return r111;
    }

    public static /* synthetic */ boolean onVerifyChange$default(BaseConfirmWrapper r100, JSONObject r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.onVerifyChange(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVerifyChange");
    }
}
