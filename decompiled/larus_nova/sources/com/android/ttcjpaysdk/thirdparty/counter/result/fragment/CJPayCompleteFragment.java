package com.android.ttcjpaysdk.thirdparty.counter.result.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.CJPayTrackReport;
import com.android.ttcjpaysdk.base.framework.CJPayActivityManager;
import com.android.ttcjpaysdk.base.framework.manager.SuspendCountDownManager;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogUtil;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayResultGuideInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJHybridSharedStorageUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayCountDownTimeUtil;
import com.android.ttcjpaysdk.base.utils.CJPayH5LynxUtil;
import com.android.ttcjpaysdk.base.utils.CJWalletCashierBtmUtils;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragmentListener;
import com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract;
import com.android.ttcjpaysdk.thirdparty.counter.action.IFingerprintAction;
import com.android.ttcjpaysdk.thirdparty.counter.action.IFingerprintDegradeGuideAction;
import com.android.ttcjpaysdk.thirdparty.counter.action.IPasswordFreeAction;
import com.android.ttcjpaysdk.thirdparty.counter.action.IPreBioFingerprintAction;
import com.android.ttcjpaysdk.thirdparty.counter.action.IResetPwdGuideAction;
import com.android.ttcjpaysdk.thirdparty.counter.action.IRiskTypeAction;
import com.android.ttcjpaysdk.thirdparty.counter.activity.CJPayCheckoutCounterActivity;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.android.ttcjpaysdk.thirdparty.counter.data.FastPayGuideInfo;
import com.android.ttcjpaysdk.thirdparty.counter.data.QueryPromotionAfterPayInfo;
import com.android.ttcjpaysdk.thirdparty.counter.model.BdPayCounterModel;
import com.android.ttcjpaysdk.thirdparty.counter.presenter.BdPayResutlPagePresenter;
import com.android.ttcjpaysdk.thirdparty.counter.presenter.BdPayWithoutPwdPresenter;
import com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.BaseCompleteWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.CompleteDialogWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.CompleteFailHalfWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.CompleteFulWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.result.wrapper.CompleteHalfWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.utils.CJPayResultPageLogUtils;
import com.android.ttcjpaysdk.thirdparty.counter.utils.CheckoutReportLogUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBioOpenGuide;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.CJPayGuideInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPreBioGuideInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeQueryResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.wallet.AuthResultEvent;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJBtmUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCompleteFragment extends CJPayBaseFragment implements BdPayCounterContract.ResultPageBuyAgainInfoView {
    private static final String BuyAgainTimerKey = "buy_again_timer";
    public static CJPayCounterTradeQueryResponseBean responseBean;
    private SuspendCountDownManager countDownManager;
    private boolean isCancelLastQueryPromotionAfterPayInfo;
    private boolean isEnableNextQueryPromotionAfterPayInfo;
    private boolean isNeedReportPageTime;
    private boolean isStopQueryPromotionAfterPayInfo;
    private IPasswordFreeAction mAmountUpgradeAction;
    private int mCashDeskShowStyle;
    private JSONObject mCommonParams;
    private IFingerprintAction mFingerprintAction;
    private IFingerprintDegradeGuideAction mFingerprintDegradeGuideAction;
    private boolean mFromOuter;
    private boolean mIsFromInsufficientBalance;
    private volatile boolean mIsQueryConnecting;
    private String mJhAppId;
    private String mJhMerchantId;
    private boolean mOuterBDPay;
    private IPasswordFreeAction mPasswordFreeAction;
    private IPreBioFingerprintAction mPreBioFingerprintAction;
    private BdPayResutlPagePresenter mPresenter;
    private QueryPromotionAfterPayInfo mQueryPromotionAfterPayInfo;
    private IResetPwdGuideAction mResetPwdGuideAction;
    private IRiskTypeAction mRiskTypeAction;
    private HashMap<String, String> mSharedParams;
    private int mShowStyle;
    private String mTradeNo;
    private BdPayWithoutPwdPresenter mWithoutPwdPresenter;
    private BaseCompleteWrapper mWrapper;
    private Long queryPromotionTimestamp;
    private String successResultType;

    public static class DelayFinishSelfRunnable implements Runnable {
        private WeakReference<Activity> activityRef;

        @Override // java.lang.Runnable
        public void run() {
            com_android_ttcjpaysdk_thirdparty_counter_result_fragment_CJPayCompleteFragment$DelayFinishSelfRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_android_ttcjpaysdk_thirdparty_counter_result_fragment_CJPayCompleteFragment$DelayFinishSelfRunnable__run$___twin___() {
            WeakReference<Activity> r100 = this.activityRef;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.get() != null) goto L7;
            return;
        L7:
            if (this.activityRef.get().isFinishing() == true) goto L13;
            this.activityRef.get().onBackPressed();
            return;
        }

        public DelayFinishSelfRunnable(Activity r100) {
            this.activityRef = new WeakReference(r100);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_android_ttcjpaysdk_thirdparty_counter_result_fragment_CJPayCompleteFragment$DelayFinishSelfRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DelayFinishSelfRunnable r100) {
            r100.com_android_ttcjpaysdk_thirdparty_counter_result_fragment_CJPayCompleteFragment$DelayFinishSelfRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface OnFragmentListener extends CJPayBaseFragmentListener {
        void backToConfirmFragment(int r100);

        CJPayPaymentMethodInfo getSelectedPaymentMethodInfo();

        void showErrorDialog(CJPayButtonInfo r100);
    }

    private void disableQueryPromotionAfterPayInfo() {
        this.isEnableNextQueryPromotionAfterPayInfo = false;
    }

    private void enableQueryPromotionAfterPayInfo() {
        this.isEnableNextQueryPromotionAfterPayInfo = true;
    }

    private void stopQueryPromotionAfterPayInfo() {
        this.isStopQueryPromotionAfterPayInfo = true;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getContentViewLayoutId() {
        return R.layout.cj_pay_fragment_bdpay_complete_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getFragmentName() {
        return "追光支付完成页";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getSource() {
        return "支付收银台";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initData() {
        inOrOutWithAnimation(false, true);
    }

    private JSONObject getCommonParams() {
        JSONObject r100 = this.mCommonParams;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new JSONObject();
    }

    private MvpModel getModel() {
        return new BdPayCounterModel();
    }

    private String getPayInfo() {
        CJPayCounterTradeQueryResponseBean r100 = responseBean;
        if (r100 == null) goto L17;
        ArrayList<CJPayTradeQueryResponseBean.PayInfo> r101 = r100.pay_info;
        if (r101 == null) goto L17;
        if (r101.size() == 0) goto L17;
        int r102 = 0;
    L11:
        if (r102 >= responseBean.pay_info.size()) goto L17;
        if ("paytype".equals(((CJPayTradeQueryResponseBean.PayInfo) ListProtector.get(responseBean.pay_info, r102)).type_mark) == true) goto L15;
        r102 = r102 + 1;
        goto L11
    L15:
        return ((CJPayTradeQueryResponseBean.PayInfo) ListProtector.get(responseBean.pay_info, r102)).toJsonString();
    L17:
        return null;
    }

    private BdPayResutlPagePresenter getPresenter() {
        if (this.mPresenter != null) goto L6;
        BdPayResutlPagePresenter r100 = new BdPayResutlPagePresenter();
        this.mPresenter = r100;
        r100.attachView(getModel(), this);
    L6:
        return this.mPresenter;
    }

    private boolean isNeedJhTradeQuery() {
        return TextUtils.equals(getShareParams("jh_result_page_style"), "1");
    }

    private boolean isNeedPreBioGuide() {
        HashMap<String, String> r100 = this.mSharedParams;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        ICJPayFingerprintService r102 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        if (Build.VERSION.SDK_INT < 23) goto L22;
        CJPayCheckoutCounterResponseBean r103 = CJPayCheckoutCounterActivity.checkoutResponseBean;
        if (r103 == null) goto L23;
        CJPayPreBioGuideInfo r104 = r103.pre_bio_guide_info;
        if (r104 != null) goto L15;
        return false;
    L15:
        if (TextUtils.isEmpty(r104.title) == true) goto L25;
        if (r102 != null) goto L18;
        return false;
    L18:
        if (r102.isSupportFingerprint(CJPayHostInfo.applicationContext) == false) goto L27;
        if (r101 == false) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L25:
        return false;
    L23:
        return false;
    L22:
        return false;
    L5:
        if (r100.containsKey("open_pre_bio_guide") == false) goto L7;
        r101 = "true".equals(this.mSharedParams.get("open_pre_bio_guide"));
        goto L8
    }

    private boolean isShowPasswordFreeGuide() {
        CJPayCounterTradeQueryResponseBean r100 = responseBean;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ("nopwd_guide".equals(r100.result_guide_info.guide_type) == false) goto L7;
        return true;
    }

    private boolean isSuccess() {
        CJPayCounterTradeQueryResponseBean r100 = responseBean;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ("SUCCESS".equals(r100.trade_info.trade_status) == false) goto L7;
        return true;
    }

    private void processFailStatus() {
        this.mWrapper.updateView(4, false, responseBean);
        if (isQueryOnlyWithoutUI() == false) goto L8;
        CJPayCallBackCenter.getInstance().setResultCode(102);
        if (getActivity() == null) goto L9;
        getActivity().onBackPressed();
        return;
    L9:
        return;
    }

    private void processNetworkTimeoutStatus() {
        this.mWrapper.updateView(5, false, responseBean);
        if (isQueryOnlyWithoutUI() == false) goto L8;
        CJPayCallBackCenter.getInstance().setResultCode(101);
        if (getActivity() == null) goto L9;
        getActivity().onBackPressed();
        return;
    L9:
        return;
    }

    private void processProcessingStatus() {
        uploadApplyResultImp(responseBean, "支付处理中", "0");
        this.mWrapper.updateView(2, false, responseBean);
        if (isQueryOnlyWithoutUI() == false) goto L8;
        CJPayCallBackCenter.getInstance().setResultCode(101);
        if (getActivity() == null) goto L9;
        getActivity().onBackPressed();
        return;
    L9:
        return;
    }

    private void processRemainTimeAndExecute() {
        if (responseBean != null) goto L6;
        return;
    L6:
        if (hasPayAfterGuide() == false) goto L8;
        int r100 = -1;
    L9:
        if (r100 > 0) goto L11;
        if (r100 == 0) goto L15;
        return;
    L15:
        if (getActivity() == null) goto L21;
        getActivity().onBackPressed();
        return;
    L21:
        return;
    L11:
        if (getActivity() == null) goto L18;
        final DelayFinishSelfRunnable r101 = new DelayFinishSelfRunnable(getActivity());
        SuspendCountDownManager r102 = new SuspendCountDownManager(1000, ((long) r100) * 1000);
        this.countDownManager = r102;
        r102.start(new AnonymousClass4(this, r101));
        return;
    L18:
        return;
    L8:
        r100 = responseBean.result_page_show_conf.remain_time;
        goto L9
    }

    private void processTimeoutStatus() {
        this.mWrapper.updateView(3, true, responseBean);
        if (isQueryOnlyWithoutUI() == false) goto L8;
        CJPayCallBackCenter.getInstance().setResultCode(103);
        if (getActivity() == null) goto L9;
        getActivity().onBackPressed();
        return;
    L9:
        return;
    }

    private void queryPromotionAfterPayInfo() {
        if (this.isStopQueryPromotionAfterPayInfo == false) goto L5;
        return;
    L5:
        if (this.isEnableNextQueryPromotionAfterPayInfo == true) goto L7;
        return;
    L7:
        if (responseBean == null) goto L21;
        ICJPayIntegratedCounterService r100 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        if (r100 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.mJhMerchantId) == false) goto L14;
        this.mJhMerchantId = r100.getIntegratedCounterMerchantId();
    L14:
        HashMap<String, String> r101 = new HashMap();
        r101.put("uid", responseBean.user_info.uid);
        r101.put("aid", CJEnv.e());
        r101.put("app_version", CJPayBasicUtils.getAppVersionName(CJPayHostInfo.applicationContext));
        r101.put(a.KEY_DID, CJEnv.c());
        r101.put("order_amount", String.valueOf(responseBean.trade_info.trade_amount));
        r101.put("placement_no", "PP202211180001116311332062");
        r101.put("origin_trade_no", this.mTradeNo);
        r101.put("pay_way", responseBean.trade_info.pay_type);
        r101.put("merchant_id", this.mJhMerchantId);
        r101.put("app_id", this.mJhAppId);
        r101.put("device_platform", "android");
        if (this.queryPromotionTimestamp.longValue() <= 0) goto L17;
        r101.put("pay_timestamp", Long.toString(this.queryPromotionTimestamp.longValue()));
    L17:
        disableQueryPromotionAfterPayInfo();
        getPresenter().queryPromotionAfterPayInfo(r101);
        return;
    }

    private void showAmountUpgradeGuide() {
        IPasswordFreeAction r100 = this.mAmountUpgradeAction;
        if (r100 == null) goto L5;
        r100.showGuide(responseBean, null, null);
    L5:
        postUpdateView();
    }

    private void showFingerprintGuide() {
        JSONObject r100 = new JSONObject();
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#showFingerprintGuide", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#showFingerprintGuide", e);
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_guide_exception", r100);
    L15:
        postUpdateView();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        IFingerprintAction r101 = this.mFingerprintAction;     // Catch: Exception -> L13
        if (r101 == null) goto L9;
        r101.showGuide(responseBean, null, 470);     // Catch: Exception -> L13
        r100.put(a.KEY_IS_SHOW, 1);     // Catch: Exception -> L13
        r100.put("type", "可显示引导");     // Catch: Exception -> L13
    L11:
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_guide_status", r100);     // Catch: Exception -> L13
        goto L15
    L9:
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L13
        r100.put("type", "mFingerprintAction回调为空");     // Catch: Exception -> L13
        goto L11
    L10:
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L13
        r100.put("type", "系统版本低");     // Catch: Exception -> L13
        goto L11
    }

    private void showPasswordFreeGuide() {
        IPasswordFreeAction r100 = this.mPasswordFreeAction;
        if (r100 == null) goto L5;
        r100.showGuide(responseBean, null, null);
    L5:
        postUpdateView();
    }

    private void showResetPwdGuideGuide() {
        IResetPwdGuideAction r100 = this.mResetPwdGuideAction;
        if (r100 == null) goto L5;
        r100.showGuide(responseBean);
    L5:
        postUpdateView();
    }

    private void updateView() {
        if (responseBean != null) goto L6;
        return;
    L6:
        if (isNeedJhTradeQuery() == false) goto L8;
        return;
    L8:
        this.mWrapper.updateView(1, false, responseBean);
        if (TextUtils.isEmpty(this.successResultType) == true) goto L12;
        CheckoutReportLogUtils.logResultPageImp(this.successResultType, getCommonParams(), responseBean);
    L12:
        if (this.mWrapper.isNeedShowPromotionAfterPay() == false) goto L15;
        startQueryPromotionAfterPayData();
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public View getPanelView() {
        BaseCompleteWrapper r100 = this.mWrapper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPanelView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public boolean isAddPanelLayer() {
        BaseCompleteWrapper r100 = this.mWrapper;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAddPanelLayer();
    }

    public boolean isNewFullPage() {
        CJPayCounterTradeQueryResponseBean r100 = responseBean;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.result_page_info == null) goto L9;
        if (r100.result_page_show_conf.show_style != 1) goto L9;
        return true;
    }

    public boolean isQueryOnlyWithoutUI() {
        CJPayCounterTradeQueryResponseBean r100 = responseBean;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.result_page_show_conf.remain_time != 0) goto L7;
        return true;
    }

    public boolean tryShowPromotionDialog() {
        BaseCompleteWrapper r100 = this.mWrapper;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.tryShowPromotionDialog();
    }

    public CJPayCompleteFragment() {
        this.mIsQueryConnecting = false;
        this.isStopQueryPromotionAfterPayInfo = false;
        this.isEnableNextQueryPromotionAfterPayInfo = true;
        this.isCancelLastQueryPromotionAfterPayInfo = false;
        this.isNeedReportPageTime = true;
        this.successResultType = "";
    }

    private void postUpdateView() {
        if (isNewFullPage() == false) goto L5;
        updateView();
        return;
    L5:
        this.mWrapper.getRootView().postDelayed(new AnonymousClass3(this), 800);
    }

    private void processInsufficientErrorCode() {
        if (getActivity() == null) goto L6;
        this.mWrapper.updateView(4, false, responseBean);
        return;
    }

    private void showFingerprintDegradeGuide() {
        JSONObject r100 = new JSONObject();
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#showFingerprintDegradeGuide", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#showFingerprintDegradeGuide", e);
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_downgrade_guide_exception", r100);
    L22:
        postUpdateView();
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L20
        r100.put("type", "系统版本低");     // Catch: Exception -> L20
    L18:
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_downgrade_guide_status", r100);     // Catch: Exception -> L20
        goto L22
    L7:
        if (this.mFingerprintDegradeGuideAction == null) goto L16;
        HashMap<String, String> r101 = this.mSharedParams;     // Catch: Exception -> L20
        if (r101 != null) goto L11;
    L14:
        String r102 = "";
    L15:
        this.mFingerprintDegradeGuideAction.showGuide(responseBean, CastIntegerProtector.parseInt(r102));     // Catch: Exception -> L20
        r100.put(a.KEY_IS_SHOW, 1);     // Catch: Exception -> L20
        r100.put("type", "可显示引导");     // Catch: Exception -> L20
        goto L18
    L11:
        if (r101.containsKey("result_height") == false) goto L14;
        r102 = this.mSharedParams.get("result_height");     // Catch: Exception -> L20
        goto L15
    L16:
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L20
        r100.put("type", "FingerprintDegradeGuideAction回调为空");     // Catch: Exception -> L20
        goto L18
    }

    private void showPreBioFingerprintGuide() {
        JSONObject r100 = new JSONObject();
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#showPreBioFingerprintGuide", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#showPreBioFingerprintGuide", e);
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_prebio_guide_exception", r100);
    L22:
        postUpdateView();
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L20
        r100.put("type", "系统版本低");     // Catch: Exception -> L20
    L18:
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_prebio_guide_status", r100);     // Catch: Exception -> L20
        goto L22
    L7:
        if (this.mPreBioFingerprintAction == null) goto L16;
        HashMap<String, String> r101 = this.mSharedParams;     // Catch: Exception -> L20
        if (r101 != null) goto L11;
    L14:
        String r102 = "";
    L15:
        this.mPreBioFingerprintAction.showGuide(CastIntegerProtector.parseInt(r102));     // Catch: Exception -> L20
        r100.put(a.KEY_IS_SHOW, 1);     // Catch: Exception -> L20
        r100.put("type", "可显示引导");     // Catch: Exception -> L20
        goto L18
    L11:
        if (r101.containsKey("result_height") == false) goto L14;
        r102 = this.mSharedParams.get("result_height");     // Catch: Exception -> L20
        goto L15
    L16:
        r100.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L20
        r100.put("type", "mPreBioFingerprintAction回调为空");     // Catch: Exception -> L20
        goto L18
    }

    private void startQueryPromotionAfterPayData() {
        this.queryPromotionTimestamp = Long.valueOf(System.currentTimeMillis());
        CJPayCountDownTimeUtil.getInstance().putCountDownTimer(BuyAgainTimerKey, 10000, 500, new AnonymousClass5(this));
        enableQueryPromotionAfterPayInfo();
        queryPromotionAfterPayInfo();
    }

    public boolean hasPayAfterGuide() {
        if (isNeedPreBioGuide() == false) goto L5;
        return true;
    L5:
        if (isNeedShowFingerprintGuide(responseBean) == false) goto L7;
        return true;
    L7:
        if (isShowPasswordFreeGuide() == false) goto L9;
        return true;
    L9:
        if (isNeedFingerprintDegradeGuide(responseBean) == false) goto L11;
        return true;
    L11:
        if (isNeedResetPwdGuide(responseBean) == false) goto L13;
        return true;
    L13:
        if (isGotoLynxGuide(responseBean) == false) goto L15;
        return true;
    L15:
        if (isNeedShowAmountUpgradeGuide(responseBean) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getView() == null) goto L5;
        Lazy r100 = CJBtmUtils.f202293a;
        CJBtmUtils.b(getView());
    L5:
        BdPayResutlPagePresenter r101 = this.mPresenter;
        if (r101 == null) goto L8;
        r101.detachView();
        this.mPresenter = null;
    L8:
        BdPayWithoutPwdPresenter r102 = this.mWithoutPwdPresenter;
        if (r102 == null) goto L11;
        r102.detachView();
        this.mWithoutPwdPresenter = null;
    L11:
        CJPayCountDownTimeUtil.getInstance().cancel(BuyAgainTimerKey);
        BaseCompleteWrapper r103 = this.mWrapper;
        if (r103 == null) goto L14;
        r103.release();
    L14:
        super.onDestroyView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public boolean getIsQueryConnecting() {
        return this.mIsQueryConnecting;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public static /* synthetic */ BaseCompleteWrapper access$100(CJPayCompleteFragment r100) {
        return r100.mWrapper;
    }

    public static /* synthetic */ String access$1000(CJPayCompleteFragment r100) {
        return r100.mJhMerchantId;
    }

    public static /* synthetic */ String access$1100(CJPayCompleteFragment r100) {
        return r100.mTradeNo;
    }

    public static /* synthetic */ JSONObject access$200(CJPayCompleteFragment r100) {
        return r100.getCommonParams();
    }

    public static /* synthetic */ SuspendCountDownManager access$300(CJPayCompleteFragment r100) {
        return r100.countDownManager;
    }

    public static /* synthetic */ void access$400(CJPayCompleteFragment r100) {
        r100.updateView();
    }

    public static /* synthetic */ void access$500(CJPayCompleteFragment r100) {
        r100.queryPromotionAfterPayInfo();
    }

    public static /* synthetic */ void access$600(CJPayCompleteFragment r100) {
        r100.stopQueryPromotionAfterPayInfo();
    }

    public static /* synthetic */ QueryPromotionAfterPayInfo access$700(CJPayCompleteFragment r100) {
        return r100.mQueryPromotionAfterPayInfo;
    }

    public static /* synthetic */ String access$900(CJPayCompleteFragment r100) {
        return r100.mJhAppId;
    }

    private void bindData(CJPayCounterTradeQueryResponseBean r110) {
        setResultData(false);     // Catch: Exception -> L64
        if (r110 != null) goto L9;
        processNetworkTimeoutStatus();     // Catch: Exception -> L64
        uploadApplyResultImp(r110, "网络异常", "0");     // Catch: Exception -> L64
        return;
    L9:
        if ("CD000000".equals(r110.code) == true) goto L12;
        processErrorStatus(r110.code);     // Catch: Exception -> L64
        return;
    L12:
        CJPayTradeInfo r100 = r110.trade_info;     // Catch: Exception -> L64
        if (r100 != null) goto L15;
    L43:
        processProcessingStatus();     // Catch: Exception -> L64
    L45:
        if (getActivity() == null) goto L52;
        FragmentActivity r101 = getActivity();     // Catch: Exception -> L64
        if (TextUtils.isEmpty(r110.nopwd_open_msg) == true) goto L49;
        String r102 = r110.nopwd_open_msg;     // Catch: Exception -> L64
    L50:
        CJPayBasicUtils.displayToast(r101, r102);     // Catch: Exception -> L64
        goto L52
    L49:
        r102 = "";
    L52:
        if (TextUtils.isEmpty(r110.nopwd_open_msg) == true) goto L70;
        JSONObject r103 = getCommonParams();     // Catch: Exception -> L64
        r103.put("pswd_guide_type", CJPayCheckoutCounterActivity.checkoutResponseBean.nopwd_guide_info.getPswdGuideType());     // Catch: JSONException -> L56 Exception -> L64
        r103.put("pswd_quota", CJPayCheckoutCounterActivity.checkoutResponseBean.nopwd_guide_info.getPswdQuota());     // Catch: JSONException -> L56 Exception -> L64
    L59:
        if (r110.nopwd_open_status == false) goto L61;
        int r104 = 1;
    L62:
        CJPayResultPageLogUtils.logPayWithoutPwdOpenStatus(r103, "支付验证页", r104, r110.code, r110.msg, CJPayResultPageLogUtils.getCurrentMethod(r110), r110.result_guide_info.pic_url, CJPayCheckoutCounterActivity.checkoutResponseBean);     // Catch: Exception -> L64
        return;
    L61:
        r104 = 0;
    L56:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#processProcessingStatus", e);     // Catch: Exception -> L64
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#processProcessingStatus", e);     // Catch: Exception -> L64
        e.printStackTrace();     // Catch: Exception -> L64
        goto L59
    L70:
        return;
    L15:
        if (TextUtils.isEmpty(r100.trade_status) == true) goto L43;
        String r105 = r110.trade_info.trade_status;     // Catch: Exception -> L64
        switch(r105.hashCode()) {
            case -1149187101: goto L29;
            case -595928767: goto L26;
            case 2150174: goto L23;
            case 907287315: goto L20;
            default: goto L31;
        };     // Catch: Exception -> L64
    L31:
        byte r106 = -1;
    L32:
        if (r106 == 0) goto L42;
        if (r106 == 1) goto L39;
        if (r106 == 2) goto L38;
        if (r106 == 3) goto L37;
        processProcessingStatus();     // Catch: Exception -> L64
        goto L45
    L37:
        processTimeoutStatus();     // Catch: Exception -> L64
        uploadApplyResultImp(r110, "支付超时", "0");     // Catch: Exception -> L64
        goto L45
    L38:
        processFailStatus();     // Catch: Exception -> L64
        uploadApplyResultImp(r110, "支付失败", "0");     // Catch: Exception -> L64
        goto L45
    L39:
        processSuccessStatus(r110);     // Catch: Exception -> L64
        if (isNeedJhTradeQuery() == true) goto L45;
        uploadApplyResultImp(r110, "支付成功", "1");     // Catch: Exception -> L64
        goto L45
    L42:
        processProcessingStatus();     // Catch: Exception -> L64
        goto L45
    L20:
        if (r105.equals("PROCESSING") == false) goto L31;
        r106 = 0;
        goto L32
    L23:
        if (r105.equals("FAIL") == false) goto L31;
        r106 = 2;
        goto L32
    L26:
        if (r105.equals("TIMEOUT") == false) goto L31;
        r106 = 3;
        goto L32
    L29:
        if (r105.equals("SUCCESS") == false) goto L31;
        r106 = 1;
    L64:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#processProcessingStatus", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#processProcessingStatus", e);
        e.printStackTrace();
    }

    private String getShareParams(String r100) {
        HashMap<String, String> r101 = this.mSharedParams;     // Catch: Exception -> L8
        if (r101 != null) goto L5;
        return "";
    L5:
        if (r101.containsKey(r100) == false) goto L15;
        return this.mSharedParams.get(r100);
    L15:
        return "";
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#getShareParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#getShareParams", e);
        return "";
    }

    private BaseCompleteWrapper getWrapper(View r100) {
        if (isQueryOnlyWithoutUI() == false) goto L7;
        return new CompleteDialogWrapper(r100, R.layout.cj_pay_view_complete_dialog_layout);
    L7:
        if (isSuccess() == false) goto L15;
        if (isNewFullPage() == false) goto L12;
        this.successResultType = "full";
        return new CompleteFulWrapper(r100, R.layout.cj_pay_view_complete_full_layout, getCommonParams(), CJPayCheckoutCounterActivity.hostInfo);
    L12:
        this.successResultType = "half";
        return new CompleteHalfWrapper(r100, R.layout.cj_pay_view_complete_half_layout, getCommonParams(), CJPayCheckoutCounterActivity.hostInfo, false);
    L15:
        return new CompleteFailHalfWrapper(r100, R.layout.cj_pay_view_complete_fail_half_layout, this.mCashDeskShowStyle, false);
    }

    private boolean isGotoLynxGuide(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.fe_guide_info.url) == true) goto L6;
        return true;
    }

    private boolean isNeedFingerprintDegradeGuide(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 == null) goto L9;
        CJPayResultGuideInfo r101 = r100.result_guide_info;
        if (r101 == null) goto L9;
        if ("bio_fail_retain_guide".equals(r101.guide_type) == false) goto L9;
        boolean r102 = true;
    L10:
        ICJPayFingerprintService r103 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r100 == null) goto L18;
        if (r103 == null) goto L18;
        if (r103.isSupportFingerprint(CJPayHostInfo.applicationContext) == false) goto L18;
        if (r102 == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        r102 = false;
        goto L10
    }

    private boolean isNeedResetPwdGuide(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ("reset_pwd".equals(r100.result_guide_info.guide_type) == false) goto L6;
        return true;
    }

    private boolean isNeedShowAmountUpgradeGuide(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.isNewPwdFreeAmountUpgradeGuide() == true) goto L9;
        CJPayProtocolGroupContentsBean r101 = r100.nopwd_guide_info;
        if (r101.need_guide == false) goto L10;
        if (InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE.equals(r101.guide_type) == false) goto L10;
    L9:
        return true;
    }

    private boolean isNeedShowFingerprintGuide(CJPayCounterTradeQueryResponseBean r100) {
        HashMap<String, String> r101 = this.mSharedParams;
        if (r101 != null) goto L5;
    L7:
        String r102 = "";
    L8:
        ICJPayFingerprintService r103 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        JSONObject r104 = new JSONObject();
        if (r100 != null) goto L56;
    L21:
        r104.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L19
        r104.put("type", "没有引导数据/引导为关");     // Catch: Exception -> L19
    L22:
        if (r103 != null) goto L24;
    L25:
        r104.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L19
        r104.put("type", "手机不支持指纹");     // Catch: Exception -> L19
    L27:
        if (TextUtils.isEmpty(r102) == false) goto L29;
        r104.put(a.KEY_IS_SHOW, 0);     // Catch: Exception -> L19
        r104.put("type", "密码为空");     // Catch: Exception -> L19
    L29:
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_guide_status", r104);     // Catch: Exception -> L19
    L33:
        if (r100 == null) goto L39;
        CJPayBioOpenGuide r105 = r100.bio_open_guide;
        if (r105 == null) goto L39;
        if (r105.show_guide == false) goto L39;
        boolean r106 = true;
    L40:
        if (r100 == null) goto L46;
        CJPayResultGuideInfo r107 = r100.result_guide_info;
        if (r107 == null) goto L46;
        if ("bio_guide".equals(r107.guide_type) == false) goto L46;
        boolean r108 = true;
    L48:
        if (Build.VERSION.SDK_INT < 23) goto L58;
        if (r103 != null) goto L51;
        return false;
    L51:
        if (r103.isSupportFingerprint(CJPayHostInfo.applicationContext) == false) goto L60;
        if (r108 == true) goto L54;
        if (r106 == true) goto L54;
        return false;
    L54:
        return true;
    L60:
        return false;
    L58:
        return false;
    L46:
        r108 = false;
    L39:
        r106 = false;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#isNeedShowFingerprintGuide", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#isNeedShowFingerprintGuide", e);
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_fingerprint_guide_exception", new JSONObject());
        goto L33
    L24:
        if (r103.isSupportFingerprint(CJPayHostInfo.applicationContext) == true) goto L27;
    L56:
        CJPayBioOpenGuide r109 = r100.bio_open_guide;     // Catch: Exception -> L19
        if (r109 == null) goto L21;
        if (r109.show_guide == false) goto L21;
        CJPayResultGuideInfo r110 = r100.result_guide_info;     // Catch: Exception -> L19
        if (r110 == null) goto L21;
        if (TextUtils.isEmpty(r110.bio_type) == false) goto L22;
    L5:
        if (r101.containsKey("pwd") == false) goto L7;
        r102 = this.mSharedParams.get("pwd");
        goto L8
    }

    private void processErrorStatus(String r100) {
        if ("GW400008".equals(r100) == false) goto L8;
        CJPayCallBackCenter.getInstance().setResultCode(108).notifyPayResult();
        if (getActivity() == null) goto L16;
        CJPayActivityManager.INSTANCE.finishAll(getActivity());
        return;
    L16:
        return;
    L8:
        if (CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_INSUFFICIENT.equals(r100) == false) goto L10;
        processInsufficientErrorCode();
        return;
    L10:
        uploadApplyResultImp(responseBean, "支付处理中", "0");
        this.mWrapper.updateView(2, false, responseBean);
        if (isQueryOnlyWithoutUI() == false) goto L19;
        CJPayCallBackCenter.getInstance().setResultCode(101);
        if (getActivity() == null) goto L20;
        getActivity().onBackPressed();
        return;
    L20:
        return;
    }

    private void processSuccessStatus(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CJPayCallBackCenter.getInstance().setResultCode(0);
        if (isNeedPreBioGuide() == false) goto L8;
        showPreBioFingerprintGuide();
    L27:
        if (isNeedJhTradeQuery() == false) goto L29;
        return;
    L29:
        processRemainTimeAndExecute();
        return;
    L8:
        if (isNeedShowFingerprintGuide(r100) == false) goto L11;
        showFingerprintGuide();
        goto L27
    L11:
        if (isShowPasswordFreeGuide() == false) goto L14;
        showPasswordFreeGuide();
        goto L27
    L14:
        if (isNeedFingerprintDegradeGuide(r100) == false) goto L17;
        showFingerprintDegradeGuide();
        goto L27
    L17:
        if (isNeedResetPwdGuide(r100) == false) goto L20;
        showResetPwdGuideGuide();
        goto L27
    L20:
        if (isGotoLynxGuide(r100) == false) goto L23;
        startLynxGuide(r100.fe_guide_info.url);
        goto L27
    L23:
        if (isNeedShowAmountUpgradeGuide(r100) == false) goto L25;
        showAmountUpgradeGuide();
        goto L27
    L25:
        updateView();
        goto L27
    }

    private void startLynxGuide(String r100) {
        if (getActivity() == null) goto L11;
        CJPayGuideInfo r101 = new CJPayGuideInfo();
        CJPayCheckoutCounterResponseBean r102 = CJPayCheckoutCounterActivity.checkoutResponseBean;
        if (r102 == null) goto L9;
        CJPayUserInfo r103 = r102.user_info;
        if (r103 == null) goto L9;
        r101.uid = r103.uid;
    L9:
        String r104 = CJPayJsonParser.toJsonObject(r101).toString();
        HashMap r105 = new HashMap();
        r105.put("CJPayGuideInfo", r104);
        CJHybridSharedStorageUtils.INSTANCE.setCacheDataMap(r105);
        CJPayH5LynxUtil.INSTANCE.openLynxPageWithCallback(getActivity(), r100, CJPayHostInfo.copy(CJPayCheckoutCounterActivity.hostInfo), new AnonymousClass2(this));
        return;
    }

    private void uploadApplyFinishPageIconClickLog(String r100) {
        JSONObject r101 = getCommonParams();
        r101.put("icon_name", r100);     // Catch: Exception -> L7
        String r102 = CJPayResultPageLogUtils.getCurrentMethod(responseBean);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r101.put(e.f25671s, r102);     // Catch: Exception -> L7
    L9:
        CJPayCallBackCenter.getInstance().onEvent("wallet_cashier_pay_finish_page_icon_click", new JSONObject[]{r101});
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#uploadApplyFinishPageIconClickLog", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#uploadApplyFinishPageIconClickLog", e);
        goto L9
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void bindViews(View r100) {
        CJPayCounterTradeQueryResponseBean r101 = responseBean;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        this.mShowStyle = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L9;
        this.mCashDeskShowStyle = r103.getInt("cash_desk_show_style");
        this.mTradeNo = r103.getString(b.B0);
        this.mJhAppId = r103.getString("jh_app_id");
        this.mJhMerchantId = r103.getString("jh_merchant_id");
        this.mFromOuter = r103.getBoolean("is_from_outer_pay", false);
        this.mOuterBDPay = r103.getBoolean("is_outer_bdpay_pay", false);
    L9:
        BaseCompleteWrapper r104 = getWrapper(r100);
        this.mWrapper = r104;
        r104.isFromOuter = this.mFromOuter;
        return;
    L5:
        r102 = r101.result_page_show_conf.show_style;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initActions(View r100) {
        this.mWrapper.initActions();
        this.mWrapper.setOnCompleteWrapperListener(new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (r100 == false) goto L5;
        return;
    L5:
        inOrOutWithAnimation(false, true);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract.ResultPageBuyAgainInfoView
    public void onQueryPromotionAfterPayInfoSuccess(QueryPromotionAfterPayInfo r100) {
        if (this.isCancelLastQueryPromotionAfterPayInfo == false) goto L5;
        return;
    L5:
        enableQueryPromotionAfterPayInfo();
        if (r100 != null) goto L9;
        return;
    L9:
        if ("SUCCESS".equals(r100.ret_status) == true) goto L11;
        stopQueryPromotionAfterPayInfo();
        return;
    L11:
        if (QueryPromotionAfterPayInfo.SUCCESS_CODE.equals(r100.code) == false) goto L29;
        stopQueryPromotionAfterPayInfo();
        CJPayCounterTradeQueryResponseBean r101 = responseBean;
        if (r101 == null) goto L19;
        CJPayMerchantInfo r102 = r101.merchant_info;
        if (r102 == null) goto L19;
        if (TextUtils.isEmpty(r102.jh_app_id) == false) goto L19;
        CJPayMerchantInfo r103 = responseBean.merchant_info;
        r103.jh_app_id = this.mJhAppId;
    L19:
        CJPayCounterTradeQueryResponseBean r104 = responseBean;
        if (r104 == null) goto L26;
        CJPayMerchantInfo r105 = r104.merchant_info;
        if (r105 == null) goto L26;
        if (TextUtils.isEmpty(r105.jh_merchant_id) == false) goto L26;
        CJPayMerchantInfo r106 = responseBean.merchant_info;
        r106.jh_merchant_id = this.mJhMerchantId;
    L26:
        this.mWrapper.updatePromotionAfterPay(r100, this.mTradeNo, hasPayAfterGuide(), responseBean);
        return;
    L29:
        if (QueryPromotionAfterPayInfo.QUERY_CODE.equals(r100.code) == false) goto L33;
        this.mQueryPromotionAfterPayInfo = r100;
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void onVisibilityChange(boolean r100) {
        super.onVisibilityChange(r100);
        if (this.isNeedReportPageTime == false) goto L8;
        this.isNeedReportPageTime = false;
        String r101 = getShareParams("scenes_name");
        if (TextUtils.isEmpty(r101) == true) goto L9;
        CJPayTrackReport r102 = CJPayTrackReport.getInstance();
        CJPayTrackReport.Scenes r103 = CJPayTrackReport.Scenes.START_PAY_PROCESS;
        r102.doTrackReport(r103.getValue(), "结果页展示", r101);
        HashMap<String, String> r104 = new HashMap();
        r104.put("merge_api_status", getShareParams("merge_api_status"));
        CJPayTrackReport.getInstance().end(r103.getValue(), r101, r104);
        return;
    L9:
        return;
    }

    public void setAmountUpgradeGuide(IPasswordFreeAction r100) {
        this.mAmountUpgradeAction = r100;
    }

    public void setFingerprintDegradeGuideAction(IFingerprintDegradeGuideAction r100) {
        this.mFingerprintDegradeGuideAction = r100;
    }

    public void setFingerprintGuide(IFingerprintAction r100) {
        this.mFingerprintAction = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void setIsQueryConnecting(boolean r100) {
        this.mIsQueryConnecting = r100;
    }

    public void setLogCommonParams(JSONObject r100) {
        this.mCommonParams = r100;
    }

    public void setPasswordFreeGuide(IPasswordFreeAction r100) {
        this.mPasswordFreeAction = r100;
    }

    public void setPreBioFingerprintGuide(IPreBioFingerprintAction r100) {
        this.mPreBioFingerprintAction = r100;
    }

    public void setResultData(boolean r100) {
        if (getActivity() != null) goto L6;
        return;
    L6:
        if (responseBean == null) goto L12;
        HashMap r101 = new HashMap();
        r101.put("trade_info", responseBean.trade_info.toJsonString());
        if (TextUtils.isEmpty(getPayInfo()) == true) goto L10;
        String r102 = getPayInfo();
    L11:
        r101.put("pay_info", r102);
        r101.put("sign", CJPayCounterConstant.CJ_PAY_PAY_SIGN);
        r101.put("sign_type", "MD5");
        CJPayCallBackCenter.getInstance().setCallBackInfo(r101);
        goto L12
    L10:
        r102 = "";
    L12:
        CJPayCounterTradeQueryResponseBean r103 = responseBean;
        if (r103 == null) goto L43;
        CJPayTradeInfo r104 = r103.trade_info;
        if (r104 == null) goto L43;
        if (TextUtils.isEmpty(r104.trade_status) == true) goto L43;
        String r105 = responseBean.trade_info.trade_status;
        r105.getClass();
        byte r106 = -1;
        switch(r105.hashCode()) {
            case -1149187101: goto L34;
            case -595928767: goto L30;
            case 2150174: goto L26;
            case 907287315: goto L22;
            default: goto L37;
        };
    L37:
        switch(r106) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            default: goto L38;
        };
    L38:
        CJPayCallBackCenter.getInstance().setResultCode(101);
    L44:
        if (r100 == false) goto L47;
        CJPayCallBackCenter.getInstance().notifyPayResult();
        return;
    L47:
        return;
    L39:
        CJPayCallBackCenter.getInstance().setResultCode(101);
        goto L44
    L40:
        CJPayCallBackCenter.getInstance().setResultCode(102);
        goto L44
    L41:
        CJPayCallBackCenter.getInstance().setResultCode(103);
        goto L44
    L42:
        CJPayCallBackCenter.getInstance().setResultCode(0);
        goto L44
    L22:
        if (r105.equals("PROCESSING") == false) goto L37;
        r106 = 3;
        goto L37
    L26:
        if (r105.equals("FAIL") == false) goto L37;
        r106 = 2;
        goto L37
    L30:
        if (r105.equals("TIMEOUT") == false) goto L37;
        r106 = 1;
        goto L37
    L34:
        if (r105.equals("SUCCESS") == false) goto L37;
        r106 = 0;
    L43:
        CJPayCallBackCenter.getInstance().setResultCode(101);
        goto L44
    }

    public void setRiskTypeAction(IRiskTypeAction r100) {
        this.mRiskTypeAction = r100;
    }

    public void setSharedParams(Map<String, String> r100) {
        this.mSharedParams = new HashMap(r100);
    }

    public static /* synthetic */ void access$000(CJPayCompleteFragment r100, String r101) {
        r100.uploadApplyFinishPageIconClickLog(r101);
    }

    public static /* synthetic */ SuspendCountDownManager access$302(CJPayCompleteFragment r100, SuspendCountDownManager r101) {
        r100.countDownManager = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(CJPayCompleteFragment r100, boolean r101) {
        r100.isCancelLastQueryPromotionAfterPayInfo = r101;
        return r101;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initViews(View r100, Bundle r101) {
        bindData(responseBean);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.counter.BdPayCounterContract.ResultPageBuyAgainInfoView
    public void onQueryPromotionAfterPayInfoFail(String r100, String r101) {
        enableQueryPromotionAfterPayInfo();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (r100 == null) goto L6;
        Lazy r102 = CJBtmUtils.f202293a;
        CJBtmUtils.i(r100, CJWalletCashierBtmUtils.BTM_TOKEN_NATIVE_RESULT_IMP);
        CJBtmUtils.c(r100);
        CJWalletCashierBtmUtils.INSTANCE.setNtvResultBtmPageEventParams(new CJPageFinder().via(r100));
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void uploadApplyResultImp(CJPayCounterTradeQueryResponseBean r110, String r111, String r112) {
        JSONObject r100 = getCommonParams();
        String r101 = "";
        r100.put("result", r112);     // Catch: Exception -> L55
        r100.put("status", r111);     // Catch: Exception -> L55
        r100.put("error_code", r110.code);     // Catch: Exception -> L55
        r100.put("error_message", r110.msg);     // Catch: Exception -> L55
        if ("1".equals(r112) == false) goto L37;
        JSONArray r113 = new JSONArray();     // Catch: Exception -> L55
        Iterator<CJPayTradeQueryResponseBean.Voucher> r102 = r110.voucher_details.iterator();     // Catch: Exception -> L55
    L7:
        if (r102.hasNext() == false) goto L17;
        CJPayTradeQueryResponseBean.Voucher r103 = r102.next();     // Catch: Exception -> L55
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L55
        r104.put("id", r103.voucher_no);     // Catch: Exception -> L55
        if ("discount_voucher".equals(r103.voucher_type) == false) goto L11;
        int r105 = 0;
    L12:
        r104.put("type", r105);     // Catch: Exception -> L55
        r104.put("reduce", r103.used_amount);     // Catch: Exception -> L55
        r104.put("label", r103.label);     // Catch: Exception -> L55
        if (TextUtils.isEmpty(r103.credit_pay_installment) == false) goto L15;
        String r106 = r103.front_bank_code;     // Catch: Exception -> L55
    L16:
        r104.put("front_bank_code", r106);     // Catch: Exception -> L55
        r113.put(r104);     // Catch: Exception -> L55
        goto L7
    L15:
        r106 = r103.credit_pay_installment;     // Catch: Exception -> L55
        goto L16
    L11:
        r105 = 1;
        goto L12
    L17:
        r100.put("activity_info", r113);     // Catch: Exception -> L55
        if (r110.trade_info.is_pay_new_card == false) goto L20;
        int r107 = 1;
    L21:
        r100.put("is_newcard", r107);     // Catch: Exception -> L55
        r100.put("bank_name", r110.trade_info.bank_name);     // Catch: Exception -> L55
        if ("DEBIT".equals(r110.trade_info.card_type) == false) goto L24;
        Object r108 = "储蓄卡";
    L25:
        r100.put("bank_type", r108);     // Catch: Exception -> L55
        Iterator<CJPayTradeInfo.CJPayCombinePayInfo> r114 = r110.trade_info.combine_pay_fund_list.iterator();     // Catch: Exception -> L55
    L27:
        if (r114.hasNext() == false) goto L37;
        CJPayTradeInfo.CJPayCombinePayInfo r109 = r114.next();     // Catch: Exception -> L55
        if ("balance".equals(r109.fund_type) == true) goto L30;
        if (AuthResultEvent.BANKCARD.equals(r109.fund_type) == true) goto L33;
        if ("income".equals(r109.fund_type) == false) goto L27;
        r100.put("income_amount", r109.fund_amount);     // Catch: Exception -> L55
        goto L27
    L33:
        r100.put("card_amount", r109.fund_amount);     // Catch: Exception -> L55
        goto L27
    L30:
        r100.put("balance_amount", r109.fund_amount);     // Catch: Exception -> L55
        goto L27
    L24:
        r108 = "信用卡";
        goto L25
    L20:
        r107 = 0;
    L37:
        IRiskTypeAction r115 = this.mRiskTypeAction;     // Catch: Exception -> L55
        if (r115 == null) goto L40;
        Object r116 = r115.getCheckList();     // Catch: Exception -> L55
    L41:
        r100.put("risk_type", r116);     // Catch: Exception -> L55
        String r117 = CJPayResultPageLogUtils.getCurrentMethod(r110);     // Catch: Exception -> L55
    L53:
        e = move-exception;
        String r118 = r117;
        e = e;
    L57:
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#uploadApplyResultImp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#uploadApplyResultImp", e);
        r117 = r118;
    L58:
        CJPayCallBackCenter.getInstance().onEvent("wallet_cashier_result", new JSONObject[]{r100});
        CJWalletCashierBtmUtils.INSTANCE.reportNtvResultBTM("btm_module_custom", CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_CASHIER_PAY_RESULT, r100, new CJPageFinder().via(getView()), null);
        if (isQueryOnlyWithoutUI() == false) goto L61;
        return;
    L61:
        if (TextUtils.isEmpty(r110.onekeypay_guide_info.more.promotion_info.description) == false) goto L63;
    L65:
        uploadApplyFinishPageImpLog(r111, r117, r110.onekeypay_guide_info.need_guide, r101);
        return;
    L63:
        if (r110.onekeypay_guide_info.guide_bar.size() != 2) goto L65;
        r101 = ((FastPayGuideInfo.GuideBarItem) ListProtector.get(r110.onekeypay_guide_info.guide_bar, 1)).msg;
        goto L65
    L43:
        if (TextUtils.isEmpty(r117) == true) goto L46;
        r100.put(e.f25671s, r117);     // Catch: Exception -> L53
    L46:
        if (TextUtils.isEmpty(r110.user_check_way) == true) goto L49;
        r100.put("check_type", r110.user_check_way);     // Catch: Exception -> L53
    L49:
        if (this.mIsFromInsufficientBalance == false) goto L51;
        r100.put("tea_source", "second_pay");     // Catch: Exception -> L53
    L51:
        CJPayKeepDialogUtil.INSTANCE.putInTeaParamsUsingTradeNo(this.mTradeNo, r100);     // Catch: Exception -> L53
        goto L58
    L40:
        r116 = "";
    L55:
        e = e;
        r118 = "";
        goto L57
    }

    private void uploadApplyFinishPageImpLog(String r100, String r101, boolean r102, String r103) {
        JSONObject r104 = getCommonParams();
        r104.put("result", r100);     // Catch: Exception -> L17
        if (responseBean != null) goto L6;
    L8:
        int r105 = 0;
    L9:
        r104.put("is_pswd_guide", r105);     // Catch: Exception -> L17
        if (r102 == false) goto L12;
        int r106 = 1;
    L13:
        r104.put("is_fast_guide", r106);     // Catch: Exception -> L17
        r104.put(a.KEY_ACTIVITY_LABEL, r103);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r101) == true) goto L19;
        r104.put(e.f25671s, r101);     // Catch: Exception -> L17
    L19:
        CJPayCallBackCenter.getInstance().onEvent("wallet_cashier_pay_finish_page_imp", new JSONObject[]{r104});
        return;
    L12:
        r106 = 0;
        goto L13
    L6:
        if (isShowPasswordFreeGuide() == false) goto L8;
        r105 = 1;
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCompleteFragment#uploadApplyFinishPageImpLog", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCompleteFragment#uploadApplyFinishPageImpLog", e);
        goto L19
    }
}
