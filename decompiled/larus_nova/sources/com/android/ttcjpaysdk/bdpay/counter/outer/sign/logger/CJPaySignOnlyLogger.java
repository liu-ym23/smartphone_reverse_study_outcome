package com.android.ttcjpaysdk.bdpay.counter.outer.sign.logger;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.android.ttcjpaysdk.base.CJOuterHostInfo;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayRetainInfoV2NativeBean;
import com.android.ttcjpaysdk.base.ui.data.RetainInfoGroups;
import com.android.ttcjpaysdk.base.ui.data.RetainMsg;
import com.android.ttcjpaysdk.base.ui.data.VoucherRetainInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.AssetInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.AssetMetaInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPayPromotionActivity;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPayPromotionVoucherInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPayRecommendUserInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInfoQueryResponse;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInformation;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.PayTypeItem;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.helper.CJSignHelper;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.helper.CJSignPerfTracker;
import com.android.ttcjpaysdk.bdpay.counter.outer.utils.CJOuterBtmConstants;
import com.android.ttcjpaysdk.bdpay.sign.applog.SetPayOrderLogger;
import com.android.ttcjpaysdk.thirdparty.data.CJPayAppUserInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPaySwitchAccountPanelLogger;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import com.bytedance.caijing.sdk.infra.base.event.CJBtmUtils;
import com.bytedance.ee.bear.document.analytic.AnalyticPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b1\b\u0016\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u00103\u001a\u00020.2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u00104\u001a\u00020.2\u0006\u0010-\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020.J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020(H\u0016J\b\u0010?\u001a\u00020.H\u0016J\u0010\u0010@\u001a\u00020.2\u0006\u0010>\u001a\u00020(H\u0016J\b\u0010A\u001a\u00020.H\u0016J0\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(2\b\u0010G\u001a\u0004\u0018\u00010HJ.\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020(2\b\b\u0002\u0010K\u001a\u00020(2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010M\u001a\u00020\u001cJ\u001a\u0010N\u001a\u00020.2\b\u0010O\u001a\u0004\u0018\u00010H2\b\b\u0002\u0010L\u001a\u00020(J\u0018\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020(2\b\u0010L\u001a\u0004\u0018\u00010(J\u0018\u0010R\u001a\u00020.2\u0006\u0010Q\u001a\u00020(2\b\u0010L\u001a\u0004\u0018\u00010(J \u0010S\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(H\u0016J\u001e\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020WJ \u0010Y\u001a\u00020.2\u0006\u0010C\u001a\u00020(2\u0006\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020(H\u0016J&\u0010\\\u001a\u00020.2\u0006\u0010L\u001a\u00020(2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010M\u001a\u00020\u001cH\u0004J\u001c\u0010^\u001a\u00020.2\u0006\u0010L\u001a\u00020(2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\fH\u0004J.\u0010_\u001a\u00020.2\u0006\u0010+\u001a\u00020(2\u0006\u0010L\u001a\u00020(2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010M\u001a\u00020\u001cH\u0004J\u001c\u0010`\u001a\u00020.2\u0006\u0010L\u001a\u00020(2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\fH\u0004J\u001c\u0010a\u001a\u00020.2\u0006\u0010L\u001a\u00020(2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\fH\u0002J \u0010c\u001a\u00020.2\u0006\u0010L\u001a\u00020(2\u0006\u0010J\u001a\u00020(2\b\u0010d\u001a\u0004\u0018\u00010(J\u0010\u0010e\u001a\u00020.2\b\u0010d\u001a\u0004\u0018\u00010(J\u0006\u0010f\u001a\u00020.J\u001a\u0010g\u001a\u00020.2\u0006\u0010J\u001a\u00020(2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010(J\u0012\u0010h\u001a\u00020.2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010(J\u0010\u0010i\u001a\u00020.2\u0006\u0010j\u001a\u00020(H\u0016J\u000e\u0010k\u001a\u00020.2\u0006\u0010l\u001a\u00020(J\u001a\u0010m\u001a\u00020.2\b\u0010E\u001a\u0004\u0018\u00010(2\b\u0010F\u001a\u0004\u0018\u00010(J\u0010\u0010n\u001a\u00020.2\u0006\u0010o\u001a\u00020(H\u0016J\b\u0010p\u001a\u00020.H\u0016J\b\u0010q\u001a\u00020.H\u0016J\u0016\u0010r\u001a\u00020.2\u0006\u0010J\u001a\u00020(2\u0006\u0010s\u001a\u00020\u001cJ\u000e\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020(J\b\u0010v\u001a\u00020.H\u0016J\u0006\u0010w\u001a\u00020.J\u0006\u0010x\u001a\u00020.J\u0006\u0010y\u001a\u00020.J \u0010z\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(H\u0016J\u001a\u0010{\u001a\u00020.2\b\u0010E\u001a\u0004\u0018\u00010(2\b\u0010|\u001a\u0004\u0018\u00010(J4\u0010}\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010~\u001a\u00020.H\u0016J\b\u0010\u007f\u001a\u00020.H\u0016J\t\u0010\u0080\u0001\u001a\u00020.H\u0016J\u0007\u0010\u0081\u0001\u001a\u00020.J#\u0010\u0082\u0001\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\b\u0010E\u001a\u0004\u0018\u00010(2\b\u0010F\u001a\u0004\u0018\u00010(J\u0018\u0010\u0083\u0001\u001a\u00020.2\u0007\u0010\u0084\u0001\u001a\u00020(2\u0006\u0010J\u001a\u00020(J\u0010\u0010\u0085\u0001\u001a\u00020.2\u0007\u0010\u0084\u0001\u001a\u00020(J!\u0010\u0086\u0001\u001a\u00020.2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R`\u0010&\u001aQ\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012.\u0012,\u0012\u0013\u0012\u00110\f¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020.0,¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020.0'j\u0002`0¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006\u0088\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger;", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPaySwitchAccountPanelLogger;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "signInfoBean", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "outerPayBean", "Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "activity", "Landroid/app/Activity;", "(Lcom/android/ttcjpaysdk/base/CJPayHostInfo;Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;Lcom/android/ttcjpaysdk/base/CJOuterPayBean;Landroid/app/Activity;)V", AnalyticPlugin.BIZ_COMMON_PARAMS, "Lorg/json/JSONObject;", "getBizCommonParams", "()Lorg/json/JSONObject;", "setBizCommonParams", "(Lorg/json/JSONObject;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "setHostInfo", "(Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "isFromRefresh", "", "()Z", "setFromRefresh", "(Z)V", "getOuterPayBean", "()Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "getSignInfoBean", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "setSignInfoBean", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;)V", "uploadEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lkotlin/Function1;", "params", "", "doExtra", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/EventUploadFunc;", "getUploadEvent", "()Lkotlin/jvm/functions/Function2;", "appendAPStdParams", "appendPerfParams", "getCommonBizParams", "getDiscountLabel", "Lorg/json/JSONArray;", "getRetainDiscountLabel", "monitorLoginException", "time", "", "onPageDestroy", "recommendAccountHalfPopClick", "clickType", "recommendAccountHalfPopImp", "recommendLoginHalfPopClick", "recommendLoginHalfPopImp", "stdUploadSignResult", "result", "status", "code", "msg", "chooseMethod", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "stdUploadWithholdOpenPageClick", "buttonName", "click", "btm", "createSourceBtmToken", "stdUploadWithholdOpenPageImp", "assetInfo", "uploadAgreementPopClick", "event", "uploadAgreementPopImp", "uploadAuthResult", "uploadBindCardMonitor", "scene", "isLiveReady", "", "isResourceReady", "uploadBindCardResult", "pageForm", "isSetPassword", "uploadBtmModuleClickEvent", "bizParams", "uploadBtmModuleCustomEvent", "uploadBtmModuleEvent", "uploadBtmModuleShowEvent", "uploadBtmPageShowEvent", "extParams", "uploadCheckAgainPopClick", "style", "uploadCheckAgainPopImp", "uploadConfirmCallbackAction", "uploadDiscountPageClick", "uploadDiscountPageImp", "uploadGoBindCard", "enterFrom", "uploadHomePageDialogShow", "content", "uploadPayErrorPop", "uploadRetainAgreementBtmEvent", "protocolName", "uploadRetainCancelBtmEvent", "uploadRetainConfirmBtmEvent", "uploadRetainPageClick", "cCountDownFinished", "uploadRetainPageImp", "popType", "uploadRetainShowBtmEvent", "uploadServiceInfoIconClick", "uploadServiceInfoPopClick", "uploadServiceInfoPopImp", "uploadSetPwdResult", "uploadSignQueryResult", "message", "uploadSignResult", "uploadStartAuth", "uploadStartSetPwd", "uploadStartVerify", "uploadSwitchAccountAppAlive", "uploadSwitchAccountResult", "uploadTipDialogClick", "title", "uploadTipDialogShow", "uploadVerifyResult", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPaySignOnlyLogger implements CJPaySwitchAccountPanelLogger {
    public static final Companion Companion = null;
    private static final String TAG = "CJPaySignOnlyLogger";
    private final Activity activity;
    private JSONObject bizCommonParams;
    private View contentView;
    private CJPayHostInfo hostInfo;
    private boolean isFromRefresh;
    private final CJOuterPayBean outerPayBean;
    private CJPaySignInfoQueryResponse signInfoBean;
    private final Function2<String, Function1<? super JSONObject, Unit>, Unit> uploadEvent;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/logger/CJPaySignOnlyLogger$Companion;", "", "()V", "TAG", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public void uploadRetainAgreementBtmEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "protocolName");
    }

    public void uploadRetainCancelBtmEvent() {
    }

    public void uploadRetainConfirmBtmEvent() {
    }

    public void uploadRetainShowBtmEvent() {
    }

    public final void uploadServiceInfoPopImp() {
        uploadBtmModuleShowEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_SERVICE_INFO_POP_IMP, null, 2, null);
    }

    private final JSONObject getCommonBizParams() {
        CJPayHostInfo r100 = this.hostInfo;
        JSONObject r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.merchantId;
    L6:
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        String r106 = CJOuterHostInfo.INSTANCE.getCJContext().f202256b;
    L19:
        CJPayHostInfo r107 = this.hostInfo;
        if (r107 == null) goto L22;
        String r108 = r107.appId;
    L23:
        JSONObject r109 = CJPayParamsUtils.getCommonLogParams(r106, r108);
        CJPaySignInfoQueryResponse r110 = this.signInfoBean;
        if (r110 == null) goto L30;
        CJPayUserInfo r111 = r110.user_info;
        if (r111 == null) goto L30;
        if (r111.is_new_user != true) goto L30;
        boolean r112 = true;
    L31:
        if (r112 == false) goto L33;
        String r113 = "new_user";
    L43:
        Pair<String, String> r114 = CJSignHelper.INSTANCE.getSignId(this.outerPayBean);
        JSONArray r115 = new JSONArray();
        CJPaySignInfoQueryResponse r116 = this.signInfoBean;
        if (r116 == null) goto L53;
        CJPaySignInformation r117 = r116.sign_information;
        if (r117 == null) goto L53;
        ArrayList<PayTypeItem> r118 = r117.pay_type_list;
        if (r118 == null) goto L53;
        Iterator<T> r119 = r118.iterator();
    L51:
        if (r119.hasNext() == false) goto L53;
        r115.put(CJPayJsonParser.toJsonObject((PayTypeItem) r119.next()));
    L53:
        CJPaySignInfoQueryResponse r120 = this.signInfoBean;
        if (r120 == null) goto L58;
        CJPaySignInformation r121 = r120.sign_information;
        if (r121 == null) goto L58;
        PayTypeItem r122 = r121.first_pay_type_info;
    L59:
        CJOuterPayBean r123 = this.outerPayBean;
        if (r123 == null) goto L71;
        String r124 = r123.getOuterAppId();
        if (r124 == null) goto L71;
        if (r124.length() > 0) goto L67;
        r103 = false;
    L67:
        if (r103 == true) goto L70;
        r124 = null;
    L70:
        if (r124 == null) goto L71;
    L75:
        KtSafeMethodExtensionKt.safePut(r109, "outer_aid", r124);
        CJPaySignInfoQueryResponse r125 = this.signInfoBean;
        String r126 = "";
        if (r125 == null) goto L81;
        CJPaySignInformation r127 = r125.sign_information;
        if (r127 == null) goto L81;
        String r128 = r127.service_name;
        if (r128 == null) goto L81;
    L82:
        KtSafeMethodExtensionKt.safePut(r109, "withhold_project", r128);
        KtSafeMethodExtensionKt.safePut(r109, "byte_sub_pay_list", r115);
        KtSafeMethodExtensionKt.safePut(r109, "default_method", CJPayJsonParser.toJsonObject(r122));
        KtSafeMethodExtensionKt.safePut(r109, a.KEY_ACTIVITY_LABEL, getDiscountLabel());
        KtSafeMethodExtensionKt.safePut(r109, "page_imptype", r113);
        CJPaySignInfoQueryResponse r129 = this.signInfoBean;
        if (r129 == null) goto L88;
        CJPaySignInformation r130 = r129.sign_information;
        if (r130 == null) goto L88;
        String r131 = r130.template_id;
        if (r131 == null) goto L88;
    L89:
        KtSafeMethodExtensionKt.safePut(r109, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r131);
        CJOuterPayBean r132 = this.outerPayBean;
        if (r132 == null) goto L92;
        Boolean r133 = Boolean.valueOf(r132.isCreditSignOnly());
    L93:
        if (r133 == null) goto L95;
        boolean r134 = r133.booleanValue();
    L96:
        if (r134 == false) goto L98;
        String r135 = "3";
    L99:
        KtSafeMethodExtensionKt.safePut(r109, "cashier_style", r135);
        CJPaySignInfoQueryResponse r136 = this.signInfoBean;
        if (r136 == null) goto L104;
        CJPayUserInfo r137 = r136.user_info;
        if (r137 == null) goto L104;
        String r138 = r137.mobile;
    L105:
        if (r138 != null) goto L107;
        r138 = "";
    L107:
        KtSafeMethodExtensionKt.safePut(r109, "is_bind_mobile", r138);
        CJPaySignInfoQueryResponse r139 = this.signInfoBean;
        if (r139 == null) goto L112;
        CJPayUserInfo r140 = r139.user_info;
        if (r140 == null) goto L112;
        String r141 = r140.pwd_status;
    L113:
        if (r141 != null) goto L115;
        r141 = "";
    L115:
        KtSafeMethodExtensionKt.safePut(r109, "haspass", r141);
        CJPaySignInfoQueryResponse r142 = this.signInfoBean;
        if (r142 == null) goto L121;
        CJPaySignInformation r143 = r142.sign_information;
        if (r143 == null) goto L121;
        String r144 = r143.button_action;
        if (r144 == null) goto L121;
    L122:
        KtSafeMethodExtensionKt.safePut(r109, "is_bankcard", r144);
        KtSafeMethodExtensionKt.safePut(r109, r114.getFirst(), r114.getSecond());
        CJPaySignInfoQueryResponse r145 = this.signInfoBean;
        if (r145 == null) goto L127;
        CJPayUserInfo r146 = r145.user_info;
        if (r146 == null) goto L127;
        CJPayAppUserInfo r147 = r146.app_user_info;
    L128:
        String r148 = "1";
        if (r147 == null) goto L131;
        Object r149 = "1";
    L132:
        KtSafeMethodExtensionKt.safePut(r109, "current_account_exposure", r149);
        CJPaySignInfoQueryResponse r150 = this.signInfoBean;
        if (r150 == null) goto L137;
        CJPayRecommendUserInfo r151 = r150.recommend_user_info;
        if (r151 == null) goto L137;
        CJPayAppUserInfo r152 = r151.app_user_info;
    L138:
        if (r152 == null) goto L140;
        Object r153 = "1";
    L141:
        KtSafeMethodExtensionKt.safePut(r109, "rec_account_exposure", r153);
        CJPaySignInfoQueryResponse r154 = this.signInfoBean;
        if (r154 == null) goto L149;
        CJPayRecommendUserInfo r155 = r154.recommend_user_info;
        if (r155 == null) goto L149;
        CJPayPromotionVoucherInfo r156 = r155.promotion_voucher_info;
        if (r156 == null) goto L149;
        String r157 = r156.promotion_desc;
        if (r157 == null) goto L149;
    L150:
        KtSafeMethodExtensionKt.safePut(r109, "rec_account_activity_label", r157);
        Activity r158 = this.activity;
        if (r158 == null) goto L156;
        Intent r159 = r158.getIntent();
        if (r159 == null) goto L156;
        r104 = r159.getFlags();
    L156:
        if ((67108864 & r104) == 0) goto L158;
        Object r160 = "1";
    L159:
        KtSafeMethodExtensionKt.safePut(r109, "is_switch", r160);
        if (this.isFromRefresh == false) goto L162;
        Object r161 = "1";
    L163:
        KtSafeMethodExtensionKt.safePut(r109, "is_refresh", r161);
        KtSafeMethodExtensionKt.safePut(r109, "source", "sign");
        CJOuterPayBean r162 = this.outerPayBean;
        if (r162 == null) goto L167;
        String r163 = r162.getPaySource();
        if (r163 == null) goto L167;
    L168:
        KtSafeMethodExtensionKt.safePut(r109, "pay_source", r163);
        CJPaySignInfoQueryResponse r164 = this.signInfoBean;
        if (r164 == null) goto L176;
        CJPayPromotionVoucherInfo r165 = r164.promotion_voucher_info;
        if (r165 == null) goto L176;
        String r166 = r165.promotion_prefix + r165.promotion_desc;
        if (r166 == null) goto L176;
        r126 = r166;
    L176:
        KtSafeMethodExtensionKt.safePut(r109, "yx_top_title", r126);
        CJPaySignInfoQueryResponse r167 = this.signInfoBean;
        if (r167 == null) goto L181;
        CJPaySignInformation r168 = r167.sign_information;
        if (r168 == null) goto L181;
        AssetInfo r169 = r168.first_asset_info;
    L182:
        if (r169 != null) goto L185;
        r148 = "0";
    L185:
        KtSafeMethodExtensionKt.safePut(r109, "is_paymethod", r148);
        CJPaySignInfoQueryResponse r170 = this.signInfoBean;
        if (r170 == null) goto L188;
        r101 = r170.trace_params;
    L188:
        KtSafeMethodExtensionKt.safePutAll(r109, r101);
        appendAPStdParams(r109);
        return r109;
    L181:
        r169 = null;
    L167:
        r163 = "";
        goto L168
    L162:
        r161 = "0";
        goto L163
    L158:
        r160 = "0";
    L149:
        r157 = "";
        goto L150
    L140:
        r153 = "0";
    L137:
        r152 = null;
        goto L138
    L131:
        r149 = "0";
    L127:
        r147 = null;
    L121:
        r144 = "";
    L112:
        r141 = null;
    L104:
        r138 = null;
        goto L105
    L98:
        r135 = "2";
        goto L99
    L95:
        r134 = false;
        goto L96
    L92:
        r133 = null;
    L88:
        r131 = "";
    L81:
        r128 = "";
    L71:
        CJOuterPayBean r171 = this.outerPayBean;
        if (r171 == null) goto L74;
        r124 = r171.getOuterAidInLetter();
        goto L75
    L74:
        r124 = null;
    L58:
        r122 = null;
        goto L59
    L33:
        if (r110 == null) goto L39;
        CJPaySignInformation r172 = r110.sign_information;
        if (r172 == null) goto L39;
        ArrayList<PayTypeItem> r173 = r172.pay_type_list;
        if (r173 == null) goto L39;
        int r174 = r173.size();
    L40:
        if (r174 <= 0) goto L42;
        r113 = "old_paytype";
        goto L43
    L42:
        r113 = "old_nopaytype";
    L39:
        r174 = 0;
    L30:
        r112 = false;
        goto L31
    L22:
        r108 = null;
        goto L23
    L15:
        CJPayHostInfo r175 = this.hostInfo;
        if (r175 == null) goto L18;
        r106 = r175.merchantId;
        goto L19
    L18:
        r106 = null;
        goto L19
    L9:
        if (r102.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    private final JSONArray getDiscountLabel() {
        JSONArray r100 = new JSONArray();
        CJPaySignInfoQueryResponse r101 = this.signInfoBean;
        if (r101 == null) goto L12;
        CJPayPromotionVoucherInfo r102 = r101.promotion_voucher_info;
        if (r102 == null) goto L12;
        ArrayList<CJPayPromotionActivity> r103 = r102.promotion_activitys;
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r100.put(CJPayJsonParser.toJsonObject((CJPayPromotionActivity) r104.next()));
    L12:
        return r100;
    }

    private final JSONArray getRetainDiscountLabel() {
        JSONArray r100 = new JSONArray();
        CJPaySignInfoQueryResponse r101 = this.signInfoBean;
        if (r101 == null) goto L16;
        CJPayRetainInfoV2NativeBean r102 = r101.retain_info_v2;
        if (r102 == null) goto L16;
        RetainInfoGroups r103 = r102.unput_pwd_retain_info;
        if (r103 == null) goto L16;
        VoucherRetainInfo r104 = r103.voucher_retain_info;
        if (r104 == null) goto L16;
        List<RetainMsg> r105 = r104.retain_msg_list;
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        r100.put(CJPayJsonParser.toJsonObject((RetainMsg) r106.next()));
    L16:
        return r100;
    }

    public final void onPageDestroy() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        View r101 = this.contentView;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        Lazy r102 = CJBtmUtils.f202293a;     // Catch: Throwable -> L8
        CJBtmUtils.b(r101);     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
        return;
    L5:
        r103 = null;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.android.ttcjpaysdk.thirdparty.data.CJPaySwitchAccountPanelLogger
    public void recommendAccountHalfPopImp() {
        this.uploadEvent.invoke("wallet_cashier_switch_account_half_pop", new C90091(this));
    }

    @Override // com.android.ttcjpaysdk.thirdparty.data.CJPaySwitchAccountPanelLogger
    public void recommendLoginHalfPopImp() {
        CJPaySignInfoQueryResponse r100 = this.signInfoBean;
        if (r100 == null) goto L7;
        CJPayUserInfo r101 = r100.user_info;
        if (r101 == null) goto L7;
        CJPayAppUserInfo r102 = r101.app_user_info;
    L7:
        this.uploadEvent.invoke("wallet_cashier_switch_account_half_pop", new C90111(this));
    }

    public final void uploadConfirmCallbackAction() {
        this.uploadEvent.invoke("wallet_sign_confirm_callback_action", C90211.INSTANCE);
    }

    public final void uploadServiceInfoIconClick() {
        uploadBtmModuleClickEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_SERVICE_INFO_ICON_CLICK, null, false, 6, null);
    }

    public final void uploadServiceInfoPopClick() {
        uploadBtmModuleClickEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_SERVICE_INFO_POP_CLICK, null, false, 6, null);
    }

    public void uploadStartAuth() {
        this.uploadEvent.invoke("wallet_sign_auth_start", C90321.INSTANCE);
        uploadBtmModuleCustomEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_AUTH_START, null, 2, null);
    }

    public void uploadStartSetPwd() {
        this.uploadEvent.invoke("wallet_sign_set_password_start", C90331.INSTANCE);
        uploadBtmModuleCustomEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_SET_PWD_START, null, 2, null);
    }

    public void uploadStartVerify() {
        this.uploadEvent.invoke("wallet_sign_risk_start", C90341.INSTANCE);
        uploadBtmModuleCustomEvent$default(this, CJOuterBtmConstants.BTM_ID_SIGN_RISK_START, null, 2, null);
    }

    public final void uploadSwitchAccountAppAlive() {
        this.uploadEvent.invoke("wallet_sign_switch_account_app_alive", C90351.INSTANCE);
    }

    public final JSONObject getBizCommonParams() {
        return this.bizCommonParams;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final CJPayHostInfo getHostInfo() {
        return this.hostInfo;
    }

    public final CJOuterPayBean getOuterPayBean() {
        return this.outerPayBean;
    }

    public final CJPaySignInfoQueryResponse getSignInfoBean() {
        return this.signInfoBean;
    }

    public final Function2<String, Function1<? super JSONObject, Unit>, Unit> getUploadEvent() {
        return this.uploadEvent;
    }

    public final boolean isFromRefresh() {
        return this.isFromRefresh;
    }

    public static final /* synthetic */ JSONObject access$getCommonBizParams(CJPaySignOnlyLogger r100) {
        return r100.getCommonBizParams();
    }

    public static final /* synthetic */ JSONArray access$getRetainDiscountLabel(CJPaySignOnlyLogger r100) {
        return r100.getRetainDiscountLabel();
    }

    private final void appendAPStdParams(JSONObject r100) {
        CJOuterPayBean r101 = this.outerPayBean;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        return;
    L9:
        CJOuterPayBean r103 = this.outerPayBean;
        if (r103 == null) goto L12;
        String r104 = r103.getExtraParam("page_source");
    L13:
        KtSafeMethodExtensionKt.safePut(r100, "sign_page_source", r104);
        CJPaySignInfoQueryResponse r105 = this.signInfoBean;
        if (r105 == null) goto L23;
        CJPaySignInformation r106 = r105.sign_information;
        if (r106 == null) goto L23;
        AssetInfo r107 = r106.first_asset_info;
        if (r107 == null) goto L23;
        AssetMetaInfo r108 = r107.asset_meta_info;
        if (r108 == null) goto L23;
        String r109 = r108.asset_type;
        if (r109 == null) goto L23;
    L24:
        KtSafeMethodExtensionKt.safePut(r100, "default_method", r109);
        return;
    L23:
        r109 = "";
        goto L24
    L12:
        r104 = null;
        goto L13
    L5:
        if (r101.isBdPayAPSign() == true) goto L7;
        r102 = true;
        goto L7
    }

    private final void appendPerfParams(JSONObject r100) {
        Iterator<Map.Entry<String, Object>> r101 = CJSignPerfTracker.INSTANCE.getFinalPerfParams().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Object> r102 = r101.next();
        KtSafeMethodExtensionKt.safePut(r100, r102.getKey(), r102.getValue());
        goto L4
    L6:
        CJOuterPayBean r103 = this.outerPayBean;
        Long r104 = null;
        if (r103 == null) goto L14;
        Long r105 = Long.valueOf(r103.coldStartTime);
        if (r105.longValue() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r104 = r105;
        goto L14
    L11:
        r106 = false;
    L14:
        if (r104 == null) goto L18;
        KtSafeMethodExtensionKt.safePut(r100, "cold_client_duration", String.valueOf(System.currentTimeMillis() - r104.longValue()));
        return;
    }

    public final void monitorLoginException(final long r100) {
        this.uploadEvent.invoke("wallet_sign_login_exception", new AnonymousClass1(r100));
    }

    @Override // com.android.ttcjpaysdk.thirdparty.data.CJPaySwitchAccountPanelLogger
    public void recommendAccountHalfPopClick(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        this.uploadEvent.invoke("wallet_cashier_switch_account_half_click", new C90081(r100, this));
    }

    @Override // com.android.ttcjpaysdk.thirdparty.data.CJPaySwitchAccountPanelLogger
    public void recommendLoginHalfPopClick(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        this.uploadEvent.invoke("wallet_cashier_switch_account_half_click", new C90101(r100, this));
    }

    public final void setBizCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizCommonParams = r100;
    }

    public final void setContentView(View r100) {
        this.contentView = r100;
    }

    public final void setFromRefresh(boolean r100) {
        this.isFromRefresh = r100;
    }

    public final void setHostInfo(CJPayHostInfo r100) {
        this.hostInfo = r100;
    }

    public final void setSignInfoBean(CJPaySignInfoQueryResponse r100) {
        this.signInfoBean = r100;
    }

    public final void uploadCheckAgainPopImp(final String r100) {
        this.uploadEvent.invoke("wallet_withhold_sign_double_check_pop_imp", new C90201(r100));
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "style", r100);
        Unit r102 = Unit.INSTANCE;
        uploadBtmModuleShowEvent(CJOuterBtmConstants.BTM_ID_SIGN_DOUBLE_CHECK_POP_IMP, r101);
    }

    public final void uploadDiscountPageImp(String r100) {
        this.uploadEvent.invoke("wallet_withhold_open_discount_page_imp", new C90231(this));
        if (r100 == null) goto L10;
        JSONObject r101 = new JSONObject();
        CJPaySignInfoQueryResponse r102 = this.signInfoBean;
        if (r102 == null) goto L7;
        String r103 = r102.confirm_sign_button;
    L8:
        KtSafeMethodExtensionKt.safePut(r101, "button_name", r103);
        Unit r104 = Unit.INSTANCE;
        uploadBtmModuleShowEvent(r100, r101);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void uploadGoBindCard(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.uploadEvent.invoke("wallet_sign_addcard_start", new C90241(r100));
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "enter_from", r100);
        Unit r102 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_BIND_CARD_START, r101);
    }

    public final void uploadHomePageDialogShow(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.uploadEvent.invoke("deposit_free_coupon_pop_show", new C90251(r100));
    }

    public final void uploadRetainPageImp(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "popType");
        this.uploadEvent.invoke("wallet_o_cashier_keep_pop_show", new C90281(r100, this));
    }

    public final void uploadTipDialogShow(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.uploadEvent.invoke("deposit_free_open_fail_pop_imp", new C90381(r100));
    }

    public static final /* synthetic */ void access$appendPerfParams(CJPaySignOnlyLogger r100, JSONObject r101) {
        r100.appendPerfParams(r101);
    }

    private final void uploadBtmPageShowEvent(String r100, JSONObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        View r103 = this.contentView;     // Catch: Throwable -> L8
        if (r103 == null) goto L5;
        Lazy r104 = CJBtmUtils.f202293a;     // Catch: Throwable -> L8
        CJBtmUtils.i(r103, r100);     // Catch: Throwable -> L8
        JSONObject r105 = getCommonBizParams();     // Catch: Throwable -> L8
        KtSafeMethodExtensionKt.safePutAll(r105, this.bizCommonParams);     // Catch: Throwable -> L8
        KtSafeMethodExtensionKt.safePutAll(r105, r101);     // Catch: Throwable -> L8
        CJBtmUtils.j(new CJPageFinder().via(r103), r105);     // Catch: Throwable -> L8
        CJBtmUtils.c(r103);     // Catch: Throwable -> L8
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L16;
        CJBasicCommonUtils.reportCatchException("CJPaySignOnlyLogger#uploadBtmPageShowEvent", r108);
        int r109 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;
        com.bytedance.caijing.sdk.infra.base.logger.a.e(TAG, "reportBtmEvent", String.valueOf(r108.getStackTrace()));
        return;
    L16:
        return;
    L5:
        r106 = null;
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void stdUploadWithholdOpenPageImp(final AssetInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "btm");
        final JSONArray r102 = new JSONArray();
        CJPaySignInfoQueryResponse r103 = this.signInfoBean;
        if (r103 == null) goto L12;
        CJPaySignInformation r104 = r103.sign_information;
        if (r104 == null) goto L12;
        ArrayList<AssetInfo> r105 = r104.specified_sort_asset_infos;
        if (r105 == null) goto L12;
        Iterator<T> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r102.put(CJPayJsonParser.toJsonObject((AssetInfo) r106.next()));
    L12:
        this.uploadEvent.invoke("wallet_withhold_open_page_imp", new AnonymousClass2(this, r102, r100));
        JSONObject r107 = new JSONObject();
        CJPaySignInfoQueryResponse r108 = this.signInfoBean;
        String r109 = null;
        if (r108 == null) goto L17;
        CJPaySignInformation r110 = r108.sign_information;
        if (r110 == null) goto L17;
        String r111 = r110.merchant_name;
    L18:
        KtSafeMethodExtensionKt.safePut(r107, "merchant_name", r111);
        KtSafeMethodExtensionKt.safePut(r107, "byte_sub_pay_list", r102);
        if (r100 == null) goto L24;
        AssetMetaInfo r112 = r100.asset_meta_info;
        if (r112 == null) goto L24;
        String r113 = r112.asset_type;
        if (r113 == null) goto L24;
    L25:
        KtSafeMethodExtensionKt.safePut(r107, "choose_method", r113);
        CJPaySignInfoQueryResponse r114 = this.signInfoBean;
        if (r114 == null) goto L28;
        String r115 = r114.confirm_sign_button;
    L29:
        KtSafeMethodExtensionKt.safePut(r107, "button_name", r115);
        CJPaySignInfoQueryResponse r116 = this.signInfoBean;
        if (r116 == null) goto L34;
        CJPayPromotionVoucherInfo r117 = r116.promotion_voucher_info;
        if (r117 == null) goto L34;
        String r118 = r117.promotion_desc;
    L35:
        KtSafeMethodExtensionKt.safePut(r107, "promotion_desc", r118);
        CJPaySignInfoQueryResponse r119 = this.signInfoBean;
        if (r119 == null) goto L40;
        CJPaySignInformation r120 = r119.sign_information;
        if (r120 == null) goto L40;
        AssetInfo r121 = r120.first_asset_info;
    L41:
        if (r121 == null) goto L43;
        String r122 = "1";
    L44:
        KtSafeMethodExtensionKt.safePut(r107, "is_has_payment_method", r122);
        CJPaySignInfoQueryResponse r123 = this.signInfoBean;
        if (r123 == null) goto L47;
        r109 = r123.protocol_show_position;
    L47:
        KtSafeMethodExtensionKt.safePut(r107, "agreement_position", r109);
        Unit r124 = Unit.INSTANCE;
        uploadBtmPageShowEvent(r101, r107);
        return;
    L43:
        r122 = "0";
    L40:
        r121 = null;
    L34:
        r118 = null;
        goto L35
    L28:
        r115 = null;
    L24:
        r113 = "";
    L17:
        r111 = null;
        goto L18
    }

    public final void uploadAgreementPopClick(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.uploadEvent.invoke(r100, C90141.INSTANCE);
        if (r110 == null) goto L6;
        uploadBtmModuleClickEvent$default(this, r110, null, false, 6, null);
        return;
    }

    public final void uploadAgreementPopImp(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.uploadEvent.invoke(r100, C90151.INSTANCE);
        if (r101 == null) goto L6;
        uploadBtmModuleShowEvent$default(this, r101, null, 2, null);
        return;
    }

    public final void uploadBtmModuleCustomEvent(String r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        uploadBtmModuleEvent$default(this, "btm_module_custom", r100, r110, false, 8, null);
    }

    public final void uploadBtmModuleShowEvent(String r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        uploadBtmModuleEvent$default(this, "btm_module_show", r100, r110, false, 8, null);
    }

    public final void uploadDiscountPageClick(final String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "buttonName");
        this.uploadEvent.invoke("wallet_withhold_open_discount_page_click", new C90221(r110));
        if (r111 == null) goto L6;
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "button_name", r110);
        Unit r112 = Unit.INSTANCE;
        uploadBtmModuleClickEvent$default(this, r111, r100, false, 4, null);
        return;
    }

    public final void uploadPayErrorPop(final String r100, final String r101) {
        this.uploadEvent.invoke("wallet_cashier_douyin_to_pay_error_pop", new C90261(r100, r101));
    }

    public final void uploadRetainPageClick(final String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        if (r101 == false) goto L5;
        final String r102 = "0";
    L6:
        this.uploadEvent.invoke("wallet_o_cashier_keep_pop_click", new C90271(r100, r102, this));
        return;
    L5:
        r102 = "1";
        goto L6
    }

    public final void uploadSignQueryResult(final String r100, final String r101) {
        this.uploadEvent.invoke("wallet_cashier_SDK_pull_result", new C90301(r100, r101));
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "code", r100);
        KtSafeMethodExtensionKt.safePut(r102, "message", r101);
        Unit r103 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SDK_PULL_RESULT, r102);
    }

    public final void uploadTipDialogClick(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "buttonName");
        this.uploadEvent.invoke("deposit_free_open_fail_pop_click", new C90371(r100, r101));
    }

    public void uploadAuthResult(final boolean r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.uploadEvent.invoke("wallet_sign_auth_result", new C90161(r100, r101, r102));
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        KtSafeMethodExtensionKt.safePut(r103, "result", r104);
        KtSafeMethodExtensionKt.safePut(r103, "error_code", r101);
        KtSafeMethodExtensionKt.safePut(r103, "error_message", r102);
        Unit r105 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_AUTH_RESULT, r103);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public final void uploadBindCardMonitor(final String r100, final int r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.uploadEvent.invoke("wallet_sdk_webcast_lynx_ready_status", new C90171(r100, r101, r102));
    }

    public void uploadBindCardResult(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "pageForm");
        Intrinsics.checkNotNullParameter(r102, "isSetPassword");
        this.uploadEvent.invoke(SetPayOrderLogger.EVENT_SETUP_BIND_CARD_RESULT, new C90181(r100, r101, r102));
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "result", r100);
        KtSafeMethodExtensionKt.safePut(r103, "page_form", r101);
        KtSafeMethodExtensionKt.safePut(r103, "is_set_password", r102);
        Unit r104 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_BIND_CARD_RESULT, r103);
    }

    public final void uploadBtmModuleClickEvent(String r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        uploadBtmModuleEvent("btm_module_click", r100, r101, r102);
    }

    public final void uploadCheckAgainPopClick(String r110, final String r111, final String r112) {
        Intrinsics.checkNotNullParameter(r110, "btm");
        Intrinsics.checkNotNullParameter(r111, "buttonName");
        this.uploadEvent.invoke("wallet_withhold_sign_double_check_pop_click", new C90191(r111, r112));
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "button_name", r111);
        KtSafeMethodExtensionKt.safePut(r100, "style", r112);
        Unit r113 = Unit.INSTANCE;
        uploadBtmModuleClickEvent$default(this, r110, r100, false, 4, null);
    }

    public void uploadSetPwdResult(final boolean r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.uploadEvent.invoke("wallet_sign_set_password_result", new C90291(r100, r101, r102));
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        KtSafeMethodExtensionKt.safePut(r103, "result", r104);
        KtSafeMethodExtensionKt.safePut(r103, "error_code", r101);
        KtSafeMethodExtensionKt.safePut(r103, "error_message", r102);
        Unit r105 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_SET_PWD_RESULT, r103);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public final void uploadSwitchAccountResult(final boolean r100, final String r101, final String r102) {
        this.uploadEvent.invoke("wallet_sign_switch_account_result", new C90361(r100, r101, r102));
    }

    public void uploadVerifyResult(final boolean r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.uploadEvent.invoke("wallet_sign_risk_result", new C90391(r100, r101, r102));
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        KtSafeMethodExtensionKt.safePut(r103, "result", r104);
        KtSafeMethodExtensionKt.safePut(r103, "error_code", r101);
        KtSafeMethodExtensionKt.safePut(r103, "error_message", r102);
        Unit r105 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_RISK_RESULT, r103);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public CJPaySignOnlyLogger(CJPayHostInfo r100, CJPaySignInfoQueryResponse r101, CJOuterPayBean r102, Activity r103) {
        this.hostInfo = r100;
        this.signInfoBean = r101;
        this.outerPayBean = r102;
        this.activity = r103;
        this.bizCommonParams = new JSONObject();
        this.uploadEvent = new CJPaySignOnlyLogger$uploadEvent$1(this);
    }

    public static /* synthetic */ void uploadDiscountPageImp$default(CJPaySignOnlyLogger r100, String r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.uploadDiscountPageImp(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadDiscountPageImp");
    }

    public final void stdUploadWithholdOpenPageClick(final String r100, final String r101, String r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter(r101, "click");
        CJPaySignInfoQueryResponse r103 = this.signInfoBean;
        String r104 = null;
        if (r103 == null) goto L5;
        final AssetInfo r105 = CJSignHelper.INSTANCE.getSelectedAsset(r103);
    L6:
        this.uploadEvent.invoke("wallet_withhold_open_page_click", new C90131(this, r100, r105, r101));
        if (r102 == null) goto L28;
        JSONObject r106 = new JSONObject();
        CJPaySignInfoQueryResponse r107 = this.signInfoBean;
        if (r107 == null) goto L13;
        CJPayPromotionVoucherInfo r108 = r107.promotion_voucher_info;
        if (r108 == null) goto L13;
        String r109 = r108.promotion_desc;
    L14:
        KtSafeMethodExtensionKt.safePut(r106, "promotion_desc", r109);
        KtSafeMethodExtensionKt.safePut(r106, "button_name", r100);
        CJPaySignInfoQueryResponse r111 = this.signInfoBean;
        if (r111 == null) goto L19;
        CJPaySignInformation r112 = r111.sign_information;
        if (r112 == null) goto L19;
        r104 = r112.button_action;
    L19:
        KtSafeMethodExtensionKt.safePut(r106, "button_action", r104);
        if (r105 == null) goto L25;
        AssetMetaInfo r113 = r105.asset_meta_info;
        if (r113 == null) goto L25;
        String r114 = r113.asset_type;
        if (r114 == null) goto L25;
    L26:
        KtSafeMethodExtensionKt.safePut(r106, "choose_method", r114);
        KtSafeMethodExtensionKt.safePut(r106, "click", r101);
        Unit r115 = Unit.INSTANCE;
        uploadBtmModuleClickEvent(r102, r106, r110);
        return;
    L25:
        r114 = "";
    L13:
        r109 = null;
        goto L14
    L28:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void uploadBtmModuleEvent(String r100, final String r101, final JSONObject r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        Lazy r105 = CJBtmUtils.f202293a;     // Catch: Throwable -> L8
        final Map r106 = CJBtmUtils.d(r101, new CJPageFinder().via(this.contentView));     // Catch: Throwable -> L8
        this.uploadEvent.invoke(r100, new CJPaySignOnlyLogger$uploadBtmModuleEvent$1$1(r102, this, r106, r101));     // Catch: Throwable -> L8
        if (r103 == false) goto L6;
        CJBtmUtils.e(r101, new CJPageFinder().via(this.contentView));     // Catch: Throwable -> L8
    L6:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L16;
        CJBasicCommonUtils.reportCatchException("CJPaySignOnlyLogger#uploadBtmModuleEvent", r108);
        int r109 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;
        com.bytedance.caijing.sdk.infra.base.logger.a.e(TAG, "reportBtmEvent", String.valueOf(r108.getStackTrace()));
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static /* synthetic */ void stdUploadWithholdOpenPageImp$default(CJPaySignOnlyLogger r100, AssetInfo r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = CJOuterBtmConstants.BTM_ID_SIGN_PAGE_IMP;
    L6:
        r100.stdUploadWithholdOpenPageImp(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stdUploadWithholdOpenPageImp");
    }

    public static /* synthetic */ void uploadBtmModuleCustomEvent$default(CJPaySignOnlyLogger r100, String r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.uploadBtmModuleCustomEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadBtmModuleCustomEvent");
    }

    public static /* synthetic */ void uploadBtmModuleShowEvent$default(CJPaySignOnlyLogger r100, String r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.uploadBtmModuleShowEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadBtmModuleShowEvent");
    }

    public static /* synthetic */ void uploadBtmPageShowEvent$default(CJPaySignOnlyLogger r100, String r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.uploadBtmPageShowEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadBtmPageShowEvent");
    }

    public static /* synthetic */ void uploadDiscountPageClick$default(CJPaySignOnlyLogger r100, String r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.uploadDiscountPageClick(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadDiscountPageClick");
    }

    public final void stdUploadSignResult(final boolean r100, final String r110, final String r111, final String r112, final AssetInfo r113) {
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r111, "code");
        Intrinsics.checkNotNullParameter(r112, "msg");
        this.uploadEvent.invoke("wallet_withhold_open_result", new C90121(r100, r110, r111, r112, r113));
    }

    public void uploadSignResult(final boolean r100, final String r101, final String r102, final String r103, AssetInfo r104) {
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "code");
        Intrinsics.checkNotNullParameter(r103, "msg");
        this.uploadEvent.invoke("wallet_withhold_open_result", new C90311(r100, r101, r102, r103));
        JSONObject r105 = new JSONObject();
        if (r100 == false) goto L5;
        String r106 = "1";
    L6:
        KtSafeMethodExtensionKt.safePut(r105, "result", r106);
        KtSafeMethodExtensionKt.safePut(r105, "status", r101);
        KtSafeMethodExtensionKt.safePut(r105, "error_code", r102);
        KtSafeMethodExtensionKt.safePut(r105, "error_message", r103);
        Unit r107 = Unit.INSTANCE;
        uploadBtmModuleCustomEvent(CJOuterBtmConstants.BTM_ID_SIGN_RESULT, r105);
        return;
    L5:
        r106 = "0";
        goto L6
    }

    public /* synthetic */ CJPaySignOnlyLogger(CJPayHostInfo r100, CJPaySignInfoQueryResponse r101, CJOuterPayBean r102, Activity r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ void uploadBtmModuleClickEvent$default(CJPaySignOnlyLogger r100, String r101, JSONObject r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        r100.uploadBtmModuleClickEvent(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadBtmModuleClickEvent");
    }

    public static /* synthetic */ void stdUploadWithholdOpenPageClick$default(CJPaySignOnlyLogger r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if (r106 != null) goto L15;
        if ((r105 & 2) == 0) goto L7;
        r102 = "";
    L7:
        if ((r105 & 4) == 0) goto L10;
        r103 = null;
    L10:
        if ((r105 & 8) == 0) goto L12;
        r104 = true;
    L12:
        r100.stdUploadWithholdOpenPageClick(r101, r102, r103, r104);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stdUploadWithholdOpenPageClick");
    }

    public static /* synthetic */ void uploadBtmModuleEvent$default(CJPaySignOnlyLogger r100, String r101, String r102, JSONObject r103, boolean r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = null;
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = true;
    L9:
        r100.uploadBtmModuleEvent(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadBtmModuleEvent");
    }

    public static /* synthetic */ void uploadSignResult$default(CJPaySignOnlyLogger r100, boolean r101, String r102, String r103, String r110, AssetInfo r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 16) == 0) goto L6;
        r111 = null;
    L6:
        r100.uploadSignResult(r101, r102, r103, r110, r111);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadSignResult");
    }
}
