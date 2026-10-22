package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.manager.CJPayFragmentManager;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.CJUnifyPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.CJUnifyPayProcessParams;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req.CJUnifyPayTradeConfirmBizContentParams;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req.CJUnifyRefreshPreTradeCreateReq;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPayProcessCallback;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPayTradeConfirmCallback;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract.CJUnifyPayTradeQueryCallback;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.mode.CJUnifyTradeQueryReqParams;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 Y2\u00020\u0001:\u0004XYZ[B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH&J,\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\"H&J\n\u0010#\u001a\u0004\u0018\u00010$H&J\n\u0010%\u001a\u0004\u0018\u00010&H&J\n\u0010'\u001a\u0004\u0018\u00010\"H&J\b\u0010(\u001a\u00020\"H&J\b\u0010)\u001a\u00020*H&J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020\nJ-\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010*2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u000104H&¢\u0006\u0002\u00105J\"\u00106\u001a\u0002012\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010\u0018\u001a\u00020;H&J\b\u0010<\u001a\u00020\nH&J\u000e\u0010=\u001a\u0002012\u0006\u00109\u001a\u00020:J\b\u0010>\u001a\u000201H&J\b\u0010?\u001a\u000201H&J\b\u0010@\u001a\u000201H&J\u000e\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u000201H\u0016J\u000e\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020\nJ\u0014\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010\u0015H&J\u0018\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010\u0018\u001a\u00020MH&J\u000e\u0010N\u001a\u0002012\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020QH&JF\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u0001082\b\u0010\u0018\u001a\u0004\u0018\u00010T2\u0006\u00109\u001a\u00020:2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010U\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020VH&J\u001a\u0010W\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u000108H&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000b¨\u0006\\"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;", "", "()V", "adapterModel", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterModel;", "getAdapterModel", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterModel;", "coreCallback", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$CJUnifyPayCoreCallback;", "isExpOpt", "", "()Z", "isExpOpt$delegate", "Lkotlin/Lazy;", "adapterUnifyPayTradeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/CJUnifyPayTradeInfo;", "executeTradeConfirmWithCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "currentModel", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayProcessParams;", "unifyCashierJson", "Lorg/json/JSONObject;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "callback", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayTradeConfirmCallback;", "executeTradeQueryWithCallback", "tradeQueryReqParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryReqParams;", "queryCallback", "Lcom/android/ttcjpaysdk/base/network/ICJPayCallback;", "getActivityFragmentManger", "Lcom/android/ttcjpaysdk/base/framework/manager/CJPayFragmentManager;", "getAdapterType", "", "getCJContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "getCounterRootBgView", "Landroid/view/ViewGroup;", "getJhPassThrough", "getJhProcessInfoString", "getQueryResultTimes", "", "getTradeConfirmBizContentParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeConfirmBizContentParams;", "assetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "handleBackPressed", "handlePaymentResult", "", "code", "callbackInfo", "", "(Ljava/lang/Integer;Ljava/util/Map;)V", "handleTradeConfirmError", "res", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "activity", "Landroid/app/Activity;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$ICJUnifyPayHandlePayResultCallback;", "isFromOuter", "notifyActivityDestroy", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onResume", "onUpdateUnifyPayRenderData", OnekeyLoginConstants.CT_KEY_RSP_DATA, "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "onWalletCashierFirstImp", "onWindowFocusChanged", "hasFocus", "parseQueryJsonToQueryBean", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeQueryResp;", "jsonObject", "refreshPreTradeCreateData", "reqParam", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$ICJUnifyPayTradeCreateCallback;", "registerCoreCallback", "shouldBusinessShowRec", "selectMethod", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "shouldHandleThirdPay", "payParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayProcessCallback;", "verifyQueryParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayTradeQueryCallback;", "shouldHandleTradeConfirmRespFail", "CJUnifyPayCoreCallback", "Companion", "ICJUnifyPayHandlePayResultCallback", "ICJUnifyPayTradeCreateCallback", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJUnifyPayAdapterProxy {
    public static final String ADAPTER_TYPE_JH = "jh";
    public static final String ADAPTER_TYPE_ZG = "zg";
    public static final Companion Companion = null;
    private final CJUnifyPayAdapterModel adapterModel;
    private CJUnifyPayCoreCallback coreCallback;
    private final Lazy isExpOpt$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$CJUnifyPayCoreCallback;", "", "handleBackPressed", "", "onActivityDestroy", "", "activity", "Landroid/app/Activity;", "onWindowFocusChanged", "hasFocus", "updateUnifyPayRenderData", OnekeyLoginConstants.CT_KEY_RSP_DATA, "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJUnifyPayCoreCallback {
        boolean handleBackPressed();

        void onActivityDestroy(Activity r100);

        void onWindowFocusChanged(boolean r100);

        void updateUnifyPayRenderData(UnifyCashierRenderInfo r100);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$Companion;", "", "()V", "ADAPTER_TYPE_JH", "", "ADAPTER_TYPE_ZG", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$ICJUnifyPayHandlePayResultCallback;", "", "onFinishPayment", "", "code", "", "callbackInfo", "", "", "(Ljava/lang/Integer;Ljava/util/Map;)V", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICJUnifyPayHandlePayResultCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void onFinishPayment$default(ICJUnifyPayHandlePayResultCallback r100, Integer r101, Map r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = null;
            L9:
                r100.onFinishPayment(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFinishPayment");
            }
        }

        void onFinishPayment(Integer r100, Map<String, String> r101);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy$ICJUnifyPayTradeCreateCallback;", "", "onRespError", "", "errorCode", "", "errorMessage", "onRespSuccess", "result", "Lcom/android/ttcjpaysdk/integrated/counter/data/unifypay/ICJUnifyPayTradeCreateResp;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICJUnifyPayTradeCreateCallback {
        void onRespError(String r100, String r101);

        void onRespSuccess(ICJUnifyPayTradeCreateResp r100);
    }

    static {
        Companion = new Companion(null);
    }

    public abstract CJUnifyPayTradeInfo adapterUnifyPayTradeInfo();

    public abstract ICJPayRequest executeTradeConfirmWithCallback(CJUnifyPayProcessParams r100, JSONObject r101, CJPayHostInfo r102, CJUnifyPayTradeConfirmCallback r103);

    public abstract ICJPayRequest executeTradeQueryWithCallback(CJUnifyTradeQueryReqParams r100, ICJPayCallback r101);

    public abstract CJPayFragmentManager getActivityFragmentManger();

    public abstract String getAdapterType();

    public abstract CJContext getCJContext();

    public abstract ViewGroup getCounterRootBgView();

    public abstract String getJhPassThrough();

    public abstract String getJhProcessInfoString();

    public abstract int getQueryResultTimes();

    public CJUnifyPayTradeConfirmBizContentParams getTradeConfirmBizContentParams(AssetInfoBean r100) {
        return null;
    }

    public abstract void handlePaymentResult(Integer r100, Map<String, String> r101);

    public abstract void handleTradeConfirmError(ICJUnifyPayTradeConfirmResp r100, Activity r101, ICJUnifyPayHandlePayResultCallback r102);

    public abstract boolean isFromOuter();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onResume();

    public void onWalletCashierFirstImp() {
    }

    public abstract ICJUnifyPayTradeQueryResp parseQueryJsonToQueryBean(JSONObject r100);

    public abstract void refreshPreTradeCreateData(CJUnifyRefreshPreTradeCreateReq r100, ICJUnifyPayTradeCreateCallback r101);

    public abstract boolean shouldBusinessShowRec(CJUnifyPayMethodTuple r100);

    public abstract boolean shouldHandleThirdPay(CJUnifyPayProcessParams r100, ICJUnifyPayTradeConfirmResp r101, CJUnifyPayProcessCallback r102, Activity r103, CJPayHostInfo r104, CJUnifyTradeQueryReqParams r105, CJUnifyPayTradeQueryCallback r106);

    public abstract boolean shouldHandleTradeConfirmRespFail(CJUnifyPayProcessParams r100, ICJUnifyPayTradeConfirmResp r101);

    public final boolean handleBackPressed() {
        CJUnifyPayCoreCallback r100 = this.coreCallback;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.handleBackPressed());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isExpOpt() {
        return ((Boolean) this.isExpOpt$delegate.getValue()).booleanValue();
    }

    public CJUnifyPayAdapterProxy() {
        this.adapterModel = new CJUnifyPayAdapterModel();
        this.isExpOpt$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    public final CJUnifyPayAdapterModel getAdapterModel() {
        return this.adapterModel;
    }

    public final void notifyActivityDestroy(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        CJUnifyPayCoreCallback r101 = this.coreCallback;
        if (r101 == null) goto L6;
        r101.onActivityDestroy(r100);
        return;
    }

    public final void onUpdateUnifyPayRenderData(UnifyCashierRenderInfo r100) {
        Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CT_KEY_RSP_DATA);
        CJUnifyPayCoreCallback r101 = this.coreCallback;
        if (r101 == null) goto L6;
        r101.updateUnifyPayRenderData(r100);
        return;
    }

    public final void onWindowFocusChanged(boolean r100) {
        CJUnifyPayCoreCallback r101 = this.coreCallback;
        if (r101 == null) goto L6;
        r101.onWindowFocusChanged(r100);
        return;
    }

    public final void registerCoreCallback(CJUnifyPayCoreCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.coreCallback = r100;
    }
}
