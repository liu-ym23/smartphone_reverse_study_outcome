package com.android.ttcjpaysdk.thirdparty.verify.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayPerformance;
import com.android.ttcjpaysdk.base.CJPayTrackReport;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.eventbus.Observer;
import com.android.ttcjpaysdk.base.framework.CJPayActivityManager;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.service.ICJPayVerifyStackStateCallback;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.ui.Utils.keepdialog.CJPayKeepDialogUtil;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogBuilder;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.CJPayResultRespExts;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentBasicParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.TradeConfirmResultInfo;
import com.android.ttcjpaysdk.thirdparty.verify.BuildConfig;
import com.android.ttcjpaysdk.thirdparty.verify.mode.VerifyMode;
import com.android.ttcjpaysdk.thirdparty.verify.mode.VerifyQueryMode;
import com.android.ttcjpaysdk.thirdparty.verify.params.CJPayVerifyParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyCommonParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNewPwdParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyRequestParams;
import com.android.ttcjpaysdk.thirdparty.verify.utils.UploadEventUtils;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.android.ttcjpaysdk.thirdparty.verify.vm.Verify3DSVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyAddPwdVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyCardSignVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyCvvVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyDoubleCheckVm;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyFaceVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyFingerprintVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyIdentityVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyInputPhoneVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyMemberVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyNothingVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyOneStepPaymentVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyPasswordVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyRealNameConflictVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifySmsFullVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifySmsVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyTokenVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyUploadIDCardVM;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes39.dex */
public class VerifyBaseManager {
    private static final long COUNTDOWN_INTERVAL_MS = 10;
    private static final String TAG = "VerifyBaseManager";
    public static int VERIFY_TYPE_ADD_PWD = 6;
    public static int VERIFY_TYPE_CARD_SIGN = 1;
    public static int VERIFY_TYPE_CVV = 14;
    public static int VERIFY_TYPE_FACE_CHECK = 11;
    public static int VERIFY_TYPE_FINGERPRINT = 2;
    public static int VERIFY_TYPE_MEMBER = 15;
    public static int VERIFY_TYPE_NOTHING = 4;
    public static int VERIFY_TYPE_ONE_STEP_PAYMENT = 3;
    public static int VERIFY_TYPE_OPEN_FINGERPRINT = 16;
    public static int VERIFY_TYPE_PWD = 0;
    public static int VERIFY_TYPE_SMS_CODE = 8;
    public static int VERIFY_TYPE_TOKEN = 5;
    public static long latestTradeConfirmSuccessTime;
    private VerifyCardSignVM.OnCardSignListener cardSignListener;
    private HashSet<String> checkList;
    private CJPayTradeConfirmResponseBean confirmResponseBean;
    private final OnCommonDialogListener defaultDialog;
    private final OnFaceCheckUnexpectedErrorListener faceCheckDefaultListener;
    private VerifyFingerprintVM.OnFingerprintListener fingerprintListener;
    private boolean hasShownKeepDialog;
    private boolean isRegisterGlobalCountdown;
    private boolean isTriggerRiskControl;
    private CallBack mCallBack;
    private VerifyCommonParams mCommonParams;
    private Context mContext;
    private final Handler mCountdownHandler;
    private long mCountdownRemainingTimeMs;
    private final Runnable mCountdownRunnable;
    private OnCountdownTickListener mCountdownTickListener;
    private VerifyBaseVM mCurrentVM;
    private OnFaceCheckUnexpectedErrorListener mFaceCheckDefaultListener;
    private FastPayCallBack mFastPayCallBack;
    private boolean mIsHookFragmentVM;
    private volatile boolean mIsTradeQueryConnecting;
    private VerifyBaseVM mLastLoadingVM;
    private VerifyMode mModel;
    private Observer mObserver;
    private OnAddPwdListener mOnAddPwdListener;
    private OnCardSignListener mOnCardSignListener;
    private OnCommonDialogListener mOnCommonDialogListener;
    private VerifyMode.OnConfirmResponse mOnConfirmResponse;
    private OnFingerprintListener mOnFingerprintListener;
    private OnOneStepPaymentListener mOnOneStepPaymentListener;
    private OnVerifyMemberListener mOnVerifyMemberListener;
    private OnVerifyNothingListener mOnVerifyNothingListener;
    private OnVerifyQueryListener mOnVerifyQueryListener;
    private OnVerifyTokenListener mOnVerifyTokenListener;
    private String mPayMethod;
    private QueryCallBack mQueryCallBack;
    private VerifyStackManager mStackManager;
    private VerifyBaseVM mSuccessVM;
    private VerifyBaseVM mSupportConfirmAgainVM;
    private VerifyVMContext mVMContext;
    private VerifyTypeChangeListener mVerifyTypeChangeListener;
    private VerifyMonitorManager monitorManager;
    private VerifyOneStepPaymentVM.OnOneStepPaymentListener oneStepPaymentListener;
    private SuccessPwdVmParams pwdVmParams;
    protected String showStyle;
    private VerifyAddPwdVM.OnVerifyAddPwdListener verifyAddPwdListener;
    private VerifyMemberVM.OnVerifyMemberListener verifyMemberListener;
    private VerifyNothingVM.OnVerifyNothingListener verifyNothingListener;
    private VerifyQueryMode verifyQueryMode;
    private VerifyTokenVM.OnVerifyTokenListener verifyTokenListener;
    private List<VerifyBaseVM> vms;

    public interface CallBack {
        void onButtunInfoCloseClick(boolean r100);

        void onFailed(CJPayTradeConfirmResponseBean r100, CJPayVerifyParams r101);

        void onLimitError(CJPayTradeConfirmResponseBean r100, VerifyBaseVM r101);

        void onLoginFailed();

        void onSuccess(Map<String, String> r100, JSONObject r101, Function0<Unit> r102, JSONObject r103);

        void toConfirm();

        void toInsufficientPage(CJPayTradeConfirmResponseBean r100, CJPayVerifyParams r101);
    }

    public interface FastPayCallBack {
        void onCancel();

        void onFailed(CJPayTradeConfirmResponseBean r100, boolean r101);

        void onHideLoading(String r100);

        void onShowLoading();

        void onSuccess(JSONObject r100, boolean r101);
    }

    public interface OnAddPwdListener {
        void hideLoading();

        void onAddPwdCancel(boolean r100);

        void onTradeConfirmFailed(String r100, boolean r101);

        void onTradeConfirmStart();
    }

    public interface OnCardSignListener {
        void hideLoading();

        void onCardSignFailed(String r100);

        void onCardSignStart(boolean r100);

        void onCardSignSuccess();

        void onTradeConfirmFailed(String r100, boolean r101);

        void onTradeConfirmStart();
    }

    public interface OnCommonDialogListener {
        void dismissCommonDialog();

        CJPayCommonDialog getCommonDialog();

        void showCommonDialog(CJPayCommonDialog.Builder r100);

        void showCommonDialog(CJPayDialogBuilder r100);

        void showDialogIfNotNull(CJPayDialogBuilder r100);
    }

    public interface OnCountdownTickListener {
        void onTick(long r100);
    }

    public interface OnFaceCheckUnexpectedErrorListener {
        void onTradeConfirmFailed();
    }

    public interface OnFingerprintListener {
        void hideLoading();

        void onFingerprintCancel(String r100);

        void onFingerprintStart();

        void onTradeConfirmFailed(String r100, String r101, TradeConfirmResultInfo.PayResultShowInfo r102, boolean r103);

        void onTradeConfirmStart();
    }

    public interface OnOneStepPaymentListener {
        void hideLoading();

        void onTradeCancel();

        void onTradeConfirmFailed(String r100, TradeConfirmResultInfo.PayResultShowInfo r101, boolean r102);

        void onTradeConfirmStart(int r100);
    }

    public interface OnVerifyMemberListener {
        void hideLoading();

        void onTradeCancel();

        void onTradeConfirmFailed(String r100, boolean r101);

        void onTradeConfirmStart();
    }

    public interface OnVerifyNothingListener {
        void hideLoading();

        void onTradeConfirmFailed(String r100, TradeConfirmResultInfo.PayResultShowInfo r101, boolean r102);

        void onTradeConfirmStart();
    }

    public interface OnVerifyQueryListener {
        void onFinishQuery();

        void onStartQuery();
    }

    public interface OnVerifyTokenListener {
        void hideLoading();

        void onTradeConfirmFailed(String r100, TradeConfirmResultInfo.PayResultShowInfo r101, boolean r102);

        void onTradeConfirmStart();
    }

    public interface QueryCallBack {
        void onResult(JSONObject r100);
    }

    public class SuccessPwdVmParams implements CJPayObject {
        int amountFontSize;
        String amountStr;
        int height;
        int loadingContainerHeight;
        int sizeTypedValue;
        final /* synthetic */ VerifyBaseManager this$0;
        int unitFontSize;
        String voucherStr;

        public SuccessPwdVmParams(VerifyBaseManager r100) {
            this.this$0 = r100;
            this.height = 470;
            this.loadingContainerHeight = 0;
            this.amountStr = "";
            this.voucherStr = "";
            this.amountFontSize = 0;
            this.unitFontSize = 0;
            this.sizeTypedValue = 0;
        }
    }

    public interface VerifyTypeChangeListener {
        void onVerifyTypeChange(int r100, int r101);
    }

    public void setHasShowedKeepDialog() {
        this.hasShownKeepDialog = true;
    }

    public void setTriggerRiskControl() {
        this.isTriggerRiskControl = true;
    }

    private void startCountdown() {
        if (this.mCountdownRemainingTimeMs <= 0) goto L6;
        this.mCountdownHandler.postDelayed(this.mCountdownRunnable, 10);
        return;
    }

    private void stopCountdown() {
        this.mCountdownHandler.removeCallbacks(this.mCountdownRunnable);
    }

    private boolean willShouldReport() {
        return !this.mCommonParams.mIsFastPay;
    }

    public boolean currentVMHasUI() {
        VerifyBaseVM r100 = this.mCurrentVM;
        if ((r100 instanceof VerifyPasswordVM) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r100 instanceof VerifySmsVM) == true) goto L8;
        return false;
    }

    public void dismissBindCardPayAgainDialogLoading() {
        VerifyBaseFragment r100 = this.mStackManager.peek();
        if ((r100 instanceof VerifyPasswordFragment) == false) goto L6;
        ((VerifyPasswordFragment) r100).dismissBindCardPayAgainLoading();
        return;
    }

    public int getCheckCount() {
        HashSet<String> r100 = this.checkList;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.size();
    }

    public String getCheckList() {
        StringBuilder r100 = new StringBuilder();
        HashSet<String> r101 = this.checkList;
        if (r101 != null) goto L5;
        return "无";
    L5:
        if (r101.size() <= 0) goto L21;
        Iterator<String> r102 = this.checkList.iterator();
        int r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L15;
        String r104 = r102.next();
        if (r103 != 0) goto L12;
        r100.append(r104);
    L13:
        r103 = r103 + 1;
        goto L8
    L12:
        r100.append(",");
        r100.append(r104);
        goto L13
    L15:
        return r100.toString();
    L21:
        return "无";
    }

    public String getCheckName() {
        HashSet<String> r100 = this.checkList;
        if (r100 != null) goto L5;
        return "无";
    L5:
        if (r100.size() > 0) goto L7;
        return "无";
    L7:
        return this.checkList.iterator().next();
    }

    public FastPayCallBack getFastPayCallBack() {
        if (this.mCommonParams.mIsFastPay == true) goto L7;
        return null;
    L7:
        return this.mFastPayCallBack;
    }

    public OnCommonDialogListener getOnCommonDialogListener() {
        OnCommonDialogListener r100 = this.mOnCommonDialogListener;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.defaultDialog;
    }

    public String getPwdVmParams() {
        SuccessPwdVmParams r100 = this.pwdVmParams;     // Catch: Exception -> L8
        if (r100 == null) goto L13;
        return CJPayJsonParser.toJsonObject(r100).toString();
    L13:
        return "";
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#getPwdVmParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#getPwdVmParams", e);
        return "";
    }

    public boolean globalCountdownIsFinish() {
        if (this.isRegisterGlobalCountdown == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mCountdownRemainingTimeMs > 0) goto L7;
        return true;
    }

    public void initCountdownFromCheckoutResponse() {
        VerifyCommonParams r100 = this.mCommonParams;
        if (r100 == null) goto L16;
        ArrayList<UIComponent> r101 = r100.countdownArea;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.isRegisterGlobalCountdown == false) goto L12;
        return;
    L12:
        int r102 = resolveCountdownDurationMsFromCountdownArea(this.mCommonParams.countdownArea);
        if (r102 <= 0) goto L18;
        this.mCountdownRemainingTimeMs = r102;
        return;
    L18:
        return;
    }

    public boolean isEmpty() {
        if (this.mStackManager.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isQueryConnecting() {
        Iterator<VerifyBaseVM> r100 = this.vms.iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L7;
        r101 = r100.next().isQueryConnecting();
        if (r101 == false) goto L4;
    L7:
        return r101;
    }

    public boolean isVerifyFingerprint() {
        return this.mSuccessVM instanceof VerifyFingerprintVM;
    }

    public boolean isVerifyOneStepPaymentDialogStyle() {
        VerifyBaseVM r100 = this.mSuccessVM;
        if ((r100 instanceof VerifyOneStepPaymentVM) == true) goto L5;
    L7:
        return false;
    L5:
        if (((VerifyOneStepPaymentVM) r100).isDialog() == false) goto L7;
        return true;
    }

    public boolean isVerifyToken() {
        return this.mSuccessVM instanceof VerifyTokenVM;
    }

    public void stop() {
        this.mStackManager.finishFragmentAll(false);
    }

    public boolean whenBackPressedExit() {
        VerifyBaseFragment r100 = this.mStackManager.peek();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.whenBackPressedExit();
    }

    private void removeTrackReport() {
        if (willShouldReport() == false) goto L6;
        CJPayTrackReport.getInstance().remove(CJPayTrackReport.Scenes.START_PAY_PROCESS.getValue());
        return;
    }

    private void unregisterGlobalCountdown() {
        stopCountdown();
        this.mCountdownTickListener = null;
        this.isRegisterGlobalCountdown = false;
        this.mCountdownRemainingTimeMs = 0;
    }

    public void finishFragmentAll() {
        if (isVerifyOneStepPaymentDialogStyle() == false) goto L11;
        CJPayTradeConfirmResponseBean r100 = this.confirmResponseBean;
        if (r100 == null) goto L11;
        if (r100.code.equals(CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_PAY_BEYOND_AMOUNT_LIMIT) == false) goto L9;
    L10:
        boolean r101 = true;
    L12:
        CJPayTradeConfirmResponseBean r102 = this.confirmResponseBean;
        if (r102 != null) goto L15;
    L23:
        CJPayActivityManager.INSTANCE.finishPaymentMethod(this.mContext);
        return;
    L15:
        if (TextUtils.equals(r102.code, CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_PAY_BEYOND_AMOUNT_LIMIT) == true) goto L19;
        if (TextUtils.equals(this.confirmResponseBean.code, CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_VOUCHER_UNABLE) == false) goto L23;
    L19:
        if (CJPayABExperimentKeys.isNewAnim(true) == true) goto L23;
        VerifyStackManager r103 = this.mStackManager;
        if (r103 == null) goto L23;
        r103.finishFragmentAll(r101);
        goto L23
    L9:
        if (this.confirmResponseBean.code.equals(CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_VOUCHER_UNABLE) == true) goto L10;
    L11:
        r101 = false;
        goto L12
    }

    public boolean isGlobalCountdownFinish() {
        return globalCountdownIsFinish();
    }

    public boolean onBackPressed() {
        if (isQueryConnecting() == false) goto L7;
        CJLogger.d(TAG, "onBackPressed: query connecting, return true");
        return true;
    L7:
        if (isTradeQueryConnecting() == false) goto L10;
        CJLogger.d(TAG, "onBackPressed: trade query connecting, return true");
        CJReporter r100 = CJReporter.f202294a;
        CJReporter.n(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_backpressed_tradequery", new HashMap(), null, -1, true);
        return true;
    L10:
        int r101 = this.mStackManager.size();
        if (r101 > 0) goto L13;
    L15:
        if (r101 != 0) goto L18;
        return false;
    L18:
        VerifyBaseFragment r102 = this.mStackManager.peek();
        if (r102 != null) goto L21;
    L23:
        return true;
    L21:
        if (r102.onBackPressed() == false) goto L23;
        this.mStackManager.doPop(true);
        goto L23
    L13:
        if (this.mIsHookFragmentVM == false) goto L15;
        return true;
    }

    public CallBack getCallBack() {
        return this.mCallBack;
    }

    public VerifyBaseVM getLastLoadingVM() {
        return this.mLastLoadingVM;
    }

    public String getPayMethod() {
        return this.mPayMethod;
    }

    public String getShowStyle() {
        return this.showStyle;
    }

    public List<VerifyBaseVM> getVMS() {
        return this.vms;
    }

    public VerifyCommonParams getVerifyParams() {
        return this.mCommonParams;
    }

    public boolean hasShowedKeepDialog() {
        return this.hasShownKeepDialog;
    }

    public boolean isTradeQueryConnecting() {
        return this.mIsTradeQueryConnecting;
    }

    public boolean isTriggerRiskControl() {
        return this.isTriggerRiskControl;
    }

    public static /* synthetic */ long access$000(VerifyBaseManager r100) {
        return r100.mCountdownRemainingTimeMs;
    }

    public static /* synthetic */ void access$100(VerifyBaseManager r100) {
        r100.stopCountdown();
    }

    public static /* synthetic */ CJPayTradeConfirmResponseBean access$1000(VerifyBaseManager r100) {
        return r100.confirmResponseBean;
    }

    public static /* synthetic */ VerifyCommonParams access$1100(VerifyBaseManager r100) {
        return r100.mCommonParams;
    }

    public static /* synthetic */ VerifyBaseVM access$1500(VerifyBaseManager r100) {
        return r100.mSuccessVM;
    }

    public static /* synthetic */ VerifyVMContext access$1600(VerifyBaseManager r100) {
        return r100.mVMContext;
    }

    public static /* synthetic */ VerifyQueryMode access$1900(VerifyBaseManager r100) {
        return r100.verifyQueryMode;
    }

    public static /* synthetic */ OnCountdownTickListener access$200(VerifyBaseManager r100) {
        return r100.mCountdownTickListener;
    }

    public static /* synthetic */ OnVerifyQueryListener access$2000(VerifyBaseManager r100) {
        return r100.mOnVerifyQueryListener;
    }

    public static /* synthetic */ CallBack access$2100(VerifyBaseManager r100) {
        return r100.mCallBack;
    }

    public static /* synthetic */ QueryCallBack access$2200(VerifyBaseManager r100) {
        return r100.mQueryCallBack;
    }

    public static /* synthetic */ VerifyStackManager access$2300(VerifyBaseManager r100) {
        return r100.mStackManager;
    }

    public static /* synthetic */ OnCardSignListener access$2600(VerifyBaseManager r100) {
        return r100.mOnCardSignListener;
    }

    public static /* synthetic */ OnOneStepPaymentListener access$2700(VerifyBaseManager r100) {
        return r100.mOnOneStepPaymentListener;
    }

    public static /* synthetic */ OnFingerprintListener access$2800(VerifyBaseManager r100) {
        return r100.mOnFingerprintListener;
    }

    public static /* synthetic */ OnVerifyNothingListener access$2900(VerifyBaseManager r100) {
        return r100.mOnVerifyNothingListener;
    }

    public static /* synthetic */ Handler access$300(VerifyBaseManager r100) {
        return r100.mCountdownHandler;
    }

    public static /* synthetic */ OnVerifyTokenListener access$3000(VerifyBaseManager r100) {
        return r100.mOnVerifyTokenListener;
    }

    public static /* synthetic */ OnVerifyMemberListener access$3100(VerifyBaseManager r100) {
        return r100.mOnVerifyMemberListener;
    }

    public static /* synthetic */ OnFaceCheckUnexpectedErrorListener access$3200(VerifyBaseManager r100) {
        return r100.mFaceCheckDefaultListener;
    }

    public static /* synthetic */ OnAddPwdListener access$3300(VerifyBaseManager r100) {
        return r100.mOnAddPwdListener;
    }

    public static /* synthetic */ Context access$400(VerifyBaseManager r100) {
        return r100.mContext;
    }

    public static /* synthetic */ VerifyBaseVM access$600(VerifyBaseManager r100) {
        return r100.mLastLoadingVM;
    }

    public static /* synthetic */ VerifyBaseVM access$700(VerifyBaseManager r100) {
        return r100.mSupportConfirmAgainVM;
    }

    public static /* synthetic */ void access$800(VerifyBaseManager r100) {
        r100.removeTrackReport();
    }

    public static /* synthetic */ boolean access$900(VerifyBaseManager r100) {
        return r100.willShouldReport();
    }

    private void doFrontTimeConsumeInStageTrackReport(boolean r100) {
        VerifyVMContext r101 = this.mVMContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVerifyParams() != null) goto L7;
        return;
    L7:
        if (this.mVMContext.getVerifyParams().mIsFront == true) goto L9;
        return;
    L9:
        if (this.mVMContext.getVerifyParams().mIsFrontStandard == true) goto L22;
        VerifyBaseVM r102 = this.mSuccessVM;
        if (r102 == null) goto L13;
        String r103 = r102.getVMName();
    L14:
        Long r104 = Long.valueOf(System.currentTimeMillis());
        if (r100 == false) goto L17;
        CJPayTrackReport.FrontCounterSubSectionEnum.doSubSectionTrackReport(CJPayTrackReport.FrontCounterSubSectionEnum.TradeQueryPre, r103, r104.longValue());
        return;
    L17:
        CJPayTrackReport.FrontCounterSubSectionEnum.doSubSectionTrackReport(CJPayTrackReport.FrontCounterSubSectionEnum.ArrivalResult, r103, r104.longValue());
        CJPayTrackReport.FrontCounterSubSectionEnum.doSubSectionTrackReport(CJPayTrackReport.FrontCounterSubSectionEnum.Overall, r103, r104.longValue());
        CJPayTrackReport.FrontCounterSubSectionEnum.releaseSubSection();
        return;
    L13:
        r103 = null;
        goto L14
    }

    private String getPayTypeForLog(CJPayTradeConfirmBizContentBasicParams r100) {
        if (this.mCommonParams.mIsAssetStandard == false) goto L15;
        StringBuilder r101 = new StringBuilder();
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r102 = r100.asset_meta_info_list;
        if (r102 == null) goto L19;
        int r103 = 0;
    L8:
        if (r103 >= r102.size()) goto L19;
        if (r103 != 0) goto L11;
        r101.append(((AssetInfoBean.AssetMetaInfoBean) ListProtector.get(r102, r103)).asset_type);
    L12:
        r103 = r103 + 1;
        goto L8
    L11:
        r101.append(Marker.ANY_NON_NULL_MARKER);
        r101.append(((AssetInfoBean.AssetMetaInfoBean) ListProtector.get(r102, r103)).asset_type);
    L19:
        return r101.toString();
    L15:
        return r100.pay_type;
    }

    private void initViewMode(VerifyVMContext r100) {
        VerifyPasswordVM r101 = new VerifyPasswordVM(r100);
        this.vms.add(r101);
        VerifySmsVM r102 = new VerifySmsVM(r100);
        this.vms.add(r102);
        VerifyIdentityVM r103 = new VerifyIdentityVM(r100);
        this.vms.add(r103);
        VerifySmsFullVM r104 = new VerifySmsFullVM(r100);
        this.vms.add(r104);
        VerifyCardSignVM r105 = new VerifyCardSignVM(r100);
        r105.setOnCardSignListener(this.cardSignListener);
        this.vms.add(r105);
        VerifyFingerprintVM r106 = new VerifyFingerprintVM(r100);
        r106.setFingerprintListener(this.fingerprintListener);
        this.vms.add(r106);
        VerifyFaceVM r107 = new VerifyFaceVM(r100);
        r107.setFaceCheckDefaultListener(this.faceCheckDefaultListener);
        this.vms.add(r107);
        VerifyInputPhoneVM r108 = new VerifyInputPhoneVM(r100);
        this.vms.add(r108);
        VerifyRealNameConflictVM r109 = new VerifyRealNameConflictVM(r100);
        this.vms.add(r109);
        VerifyOneStepPaymentVM r110 = new VerifyOneStepPaymentVM(r100);
        r110.setOnOneStepPaymentListener(this.oneStepPaymentListener);
        this.vms.add(r110);
        VerifyUploadIDCardVM r111 = new VerifyUploadIDCardVM(r100);
        this.vms.add(r111);
        VerifyNothingVM r112 = new VerifyNothingVM(r100);
        r112.setOnVerifyNothingListener(this.verifyNothingListener);
        this.vms.add(r112);
        VerifyTokenVM r113 = new VerifyTokenVM(r100);
        r113.setOnVerifyTokenListener(this.verifyTokenListener);
        this.vms.add(r113);
        VerifyAddPwdVM r114 = new VerifyAddPwdVM(r100);
        r114.setOnVerifyAddPwdListener(this.verifyAddPwdListener);
        this.vms.add(r114);
        VerifyCvvVM r115 = new VerifyCvvVM(r100);
        this.vms.add(r115);
        Verify3DSVM r116 = new Verify3DSVM(r100);
        this.vms.add(r116);
        VerifyDoubleCheckVm r117 = new VerifyDoubleCheckVm(r100);
        this.vms.add(r117);
        VerifyMemberVM r118 = new VerifyMemberVM(r100);
        r118.setListener(this.verifyMemberListener);
        this.vms.add(r118);
    }

    private void initViewModule(Context r100) {
        VerifyVMContext r101 = new VerifyVMContext.Builder().setContext(r100).setStackManage(this.mStackManager).setVerifyManage(this).setMode(this.mModel).setMonitorManager(this.monitorManager).create();
        this.mVMContext = r101;
        this.monitorManager.setVmContext(r101);
        initViewMode(r101);
        Iterator<VerifyBaseVM> r102 = this.vms.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().setOnCommonDialogListener(getOnCommonDialogListener());
        goto L4
    }

    private boolean isLynxGuide(JSONObject r100) {
        if (r100 != null) goto L13;
        return false;
    L13:
        JSONObject r101 = r100.optJSONObject("fe_guide_info");     // Catch: Exception -> L10
        if (r101 == null) goto L12;
        return !TextUtils.isEmpty(r101.optString("url"));
    L12:
        return false;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#isLynxGuide", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#isLynxGuide", e);
        goto L12
    }

    private boolean isNormalHeight(VerifyBaseVM r100) {
        if ((r100 instanceof VerifyPasswordVM) == false) goto L5;
        return true;
    L5:
        if ((r100 instanceof VerifySmsVM) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private void reportVerifyStart(int r110) {
        VerifyRequestParams r100 = this.mCommonParams.requestParams;
        String r101 = "";
        if (r100 == null) goto L8;
        String r102 = r100.getMerchantId();
        String r103 = this.mCommonParams.requestParams.getAppId();
        if (this.mCommonParams.requestParams.getTradeConfirmBasicParams() == null) goto L7;
        r101 = getPayTypeForLog(this.mCommonParams.requestParams.getTradeConfirmBasicParams());
    L7:
        String r104 = r101;
        r101 = r102;
        String r105 = r104;
    L9:
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r101, r103);
        r106.put("check_type_code", r110);     // Catch: Exception -> L12
        r106.put("pay_type", r105);     // Catch: Exception -> L12
    L14:
        CJReporter r111 = CJReporter.f202294a;
        CJReporter.g(CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_bdpay_verify_start", CJPayBasicUtils.Json2Map(r106), null, -1, true);
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#reportVerifyStart", e);
        CJLogger.c(TAG, "reportVerifyStart: ", e);
        goto L14
    L8:
        r105 = "";
        r103 = r105;
        goto L9
    }

    private int resolveCountdownDurationMsFromCountdownArea(ArrayList<UIComponent> r100) {
        if (r100 != null) goto L5;
    L20:
        return 0;
    L5:
        if (r100.isEmpty() == true) goto L20;
        Iterator<UIComponent> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L20;
        UIComponent r102 = r101.next();
        if ("countdown".equals(r102.type) == false) goto L9;
        String r103 = r102.text;
        if (r103 == null) goto L9;
        if (r103.isEmpty() == true) goto L9;
        return CastIntegerProtector.parseInt(r102.text);
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCheckoutCounterResponseBean#resolveCountdownDurationMsFromCountdownArea", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCheckoutCounterResponseBean#resolveCountdownDurationMsFromCountdownArea", e);
        goto L9
    }

    private boolean willDoQuery(JSONObject r100) {
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#willDoQuery", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#willDoQuery", e);
        return false;
    L3:
        if ("CD000000".equals(r100.optString("code")) == true) goto L5;
        return true;
    L5:
        if ("PROCESSING".equals(r100.optJSONObject("trade_info").optString("trade_status")) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public void closeVerifyFragments(boolean r100) {
        this.mStackManager.finishFragmentAll(r100);
    }

    public void finishFragmentAll(Boolean r100) {
        CJLogger.d(TAG, "finishFragmentAll forceFinish:" + r100);
        CJPayTradeConfirmResponseBean r101 = this.confirmResponseBean;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
    L15:
        boolean r104 = true;
    L17:
        if (isVerifyOneStepPaymentDialogStyle() == false) goto L20;
        if (r104 == false) goto L20;
        r102 = true;
    L20:
        if (r104 == true) goto L22;
    L26:
        CJPayActivityManager.INSTANCE.finishPaymentMethod(this.mContext);
        return;
    L22:
        if (CJPayABExperimentKeys.isNewAnim(true) == true) goto L26;
        VerifyStackManager r105 = this.mStackManager;
        if (r105 == null) goto L26;
        r105.finishFragmentAll(r102);
        goto L26
    L12:
        if (r100.booleanValue() == true) goto L15;
        r104 = false;
        goto L17
    L5:
        if (r101.code.equals(CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_PAY_BEYOND_AMOUNT_LIMIT) == false) goto L7;
    L8:
        r103 = true;
        goto L10
    L7:
        if (this.confirmResponseBean.code.equals(CJPayCounterConstant.CJPayCheckoutCounterResponseCode.RESPONSE_VOUCHER_UNABLE) == false) goto L9;
        goto L8
    }

    public void release(boolean r100) {
        release(r100, -1, Boolean.TRUE);
    }

    public void setCallBack(CallBack r100) {
        this.mCallBack = r100;
    }

    public void setCheckName(String r110) {
        HashSet<String> r100 = this.checkList;
        if (r100 == null) goto L6;
        r100.add(r110);
    L6:
        if (this.mVerifyTypeChangeListener == null) goto L90;
        r110.getClass();
        int r101 = 8;
        int r102 = 4;
        switch(r110.hashCode()) {
            case -695386983: goto L67;
            case 26080: goto L63;
            case 657854: goto L59;
            case 668697: goto L55;
            case 759035: goto L51;
            case 818322: goto L47;
            case 991295: goto L43;
            case 34567693: goto L39;
            case 34687725: goto L35;
            case 65782840: goto L31;
            case 110541305: goto L27;
            case 626088129: goto L23;
            case 720075646: goto L19;
            case 1065234691: goto L15;
            case 1909441081: goto L11;
            default: goto L9;
        };
    L9:
        byte r111 = -1;
    L70:
        switch(r111) {
            case 0: goto L87;
            case 1: goto L86;
            case 2: goto L85;
            case 3: goto L84;
            case 4: goto L83;
            case 5: goto L82;
            case 6: goto L81;
            case 7: goto L80;
            case 8: goto L79;
            case 9: goto L78;
            case 10: goto L77;
            case 11: goto L76;
            case 12: goto L75;
            case 13: goto L74;
            case 14: goto L73;
            default: goto L71;
        };
    L71:
        r101 = -1;
    L72:
        r102 = -1;
    L88:
        this.mVerifyTypeChangeListener.onVerifyTypeChange(r101, r102);
        return;
    L73:
        r101 = -1;
        r102 = 3;
        goto L88
    L74:
        r101 = -1;
        r102 = 6;
    L75:
        r101 = -1;
        goto L88
    L76:
        r102 = 16;
        goto L75
    L77:
        r101 = 6;
        goto L72
    L78:
        r101 = 7;
        goto L72
    L79:
        r101 = -1;
        r102 = 5;
        goto L88
    L80:
        r101 = 100;
        goto L72
    L81:
        r102 = 1;
        goto L88
    L82:
        r101 = 1;
        goto L72
    L83:
        r101 = 0;
        goto L72
    L84:
        r101 = 3;
        goto L72
    L85:
        r101 = -1;
        r102 = 0;
        goto L88
    L86:
        r101 = 5;
        goto L72
    L87:
        r101 = -1;
        r102 = 2;
        goto L88
    L11:
        if (r110.equals("上传身份证") == false) goto L9;
        r111 = 14;
        goto L70
    L15:
        if (r110.equals("补手机号") == false) goto L9;
        r111 = HTTP.CR;
        goto L70
    L19:
        if (r110.equals("实名冲突") == false) goto L9;
        r111 = 12;
        goto L70
    L23:
        if (r110.equals("二次加验") == false) goto L9;
        r111 = 11;
        goto L70
    L27:
        if (r110.equals("token") == false) goto L9;
        r111 = 10;
        goto L70
    L31:
        if (r110.equals("CVV验证") == false) goto L9;
        r111 = 9;
        goto L70
    L35:
        if (r110.equals("补设密") == false) goto L9;
        r111 = 8;
        goto L70
    L39:
        if (r110.equals("补签约") == false) goto L9;
        r111 = 7;
        goto L70
    L43:
        if (r110.equals("短验") == false) goto L9;
        r111 = 6;
        goto L70
    L47:
        if (r110.equals("指纹") == false) goto L9;
        r111 = 5;
        goto L70
    L51:
        if (r110.equals("密码") == false) goto L9;
        r111 = 4;
        goto L70
    L55:
        if (r110.equals("免密") == false) goto L9;
        r111 = 3;
        goto L70
    L59:
        if (r110.equals("人脸") == false) goto L9;
        r111 = 2;
        goto L70
    L63:
        if (r110.equals("无") == false) goto L9;
        r111 = 1;
        goto L70
    L67:
        if (r110.equals("证件后六位") == false) goto L9;
        r111 = 0;
        goto L70
    }

    public void setCountdownTickListener(OnCountdownTickListener r100) {
        this.mCountdownTickListener = r100;
        if (this.isRegisterGlobalCountdown == false) goto L5;
        return;
    L5:
        startCountdown();
        this.isRegisterGlobalCountdown = true;
    }

    public void setFaceCheckDefaultListener(OnFaceCheckUnexpectedErrorListener r100) {
        this.mFaceCheckDefaultListener = r100;
    }

    public void setFastPayCallBack(FastPayCallBack r100) {
        this.mFastPayCallBack = r100;
    }

    public void setLastLoadingVM(VerifyBaseVM r100) {
        this.mLastLoadingVM = r100;
    }

    public void setOnAddPwdListener(OnAddPwdListener r100) {
        this.mOnAddPwdListener = r100;
    }

    public void setOnCardSignListener(OnCardSignListener r100) {
        this.mOnCardSignListener = r100;
    }

    public void setOnCommonDialogListener(OnCommonDialogListener r100) {
        this.mOnCommonDialogListener = r100;
        Iterator<VerifyBaseVM> r101 = this.vms.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setOnCommonDialogListener(getOnCommonDialogListener());
        goto L4
    }

    public void setOnFingerprintListener(OnFingerprintListener r100) {
        this.mOnFingerprintListener = r100;
    }

    public void setOnFirstPageShowListener(VerifyMonitorManager.OnFirstPageShowListener r100) {
        this.monitorManager.setOnFirstPageShowListener(r100);
    }

    public void setOnOneStepPaymentListener(OnOneStepPaymentListener r100) {
        this.mOnOneStepPaymentListener = r100;
    }

    public void setOnVerifyMemberListener(OnVerifyMemberListener r100) {
        this.mOnVerifyMemberListener = r100;
    }

    public void setOnVerifyNothingListener(OnVerifyNothingListener r100) {
        this.mOnVerifyNothingListener = r100;
    }

    public void setOnVerifyQueryListener(OnVerifyQueryListener r100) {
        this.mOnVerifyQueryListener = r100;
    }

    public void setOnVerifyTokenListener(OnVerifyTokenListener r100) {
        this.mOnVerifyTokenListener = r100;
    }

    public void setPayMethod(String r100) {
        this.mPayMethod = r100;
    }

    public void setShowStyle(String r100) {
        this.showStyle = r100;
    }

    public void setTradeQueryConnecting(boolean r100) {
        this.mIsTradeQueryConnecting = r100;
    }

    public void setVerifyTypeChangeListener(VerifyTypeChangeListener r100) {
        this.mVerifyTypeChangeListener = r100;
    }

    public void setmIsHookFragmentVM(boolean r100) {
        this.mIsHookFragmentVM = r100;
    }

    public static /* synthetic */ long access$002(VerifyBaseManager r100, long r101) {
        r100.mCountdownRemainingTimeMs = r101;
        return r101;
    }

    public static /* synthetic */ long access$022(VerifyBaseManager r100, long r101) {
        long r102 = r100.mCountdownRemainingTimeMs - r101;
        r100.mCountdownRemainingTimeMs = r102;
        return r102;
    }

    public static /* synthetic */ CJPayTradeConfirmResponseBean access$1002(VerifyBaseManager r100, CJPayTradeConfirmResponseBean r101) {
        r100.confirmResponseBean = r101;
        return r101;
    }

    public static /* synthetic */ VerifyBaseVM access$1502(VerifyBaseManager r100, VerifyBaseVM r101) {
        r100.mSuccessVM = r101;
        return r101;
    }

    public static /* synthetic */ void access$1700(VerifyBaseManager r100, boolean r101) {
        r100.doFrontTimeConsumeInStageTrackReport(r101);
    }

    public static /* synthetic */ boolean access$1800(VerifyBaseManager r100, JSONObject r101) {
        return r100.willDoQuery(r101);
    }

    public static /* synthetic */ boolean access$2400(VerifyBaseManager r100, VerifyBaseVM r101) {
        return r100.isNormalHeight(r101);
    }

    public static /* synthetic */ boolean access$2500(VerifyBaseManager r100, JSONObject r101) {
        return r100.isLynxGuide(r101);
    }

    public static /* synthetic */ VerifyBaseVM access$502(VerifyBaseManager r100, VerifyBaseVM r101) {
        r100.mCurrentVM = r101;
        return r101;
    }

    public static /* synthetic */ VerifyBaseVM access$602(VerifyBaseManager r100, VerifyBaseVM r101) {
        r100.mLastLoadingVM = r101;
        return r101;
    }

    public static /* synthetic */ VerifyBaseVM access$702(VerifyBaseManager r100, VerifyBaseVM r101) {
        r100.mSupportConfirmAgainVM = r101;
        return r101;
    }

    private void doConfirmAgain(JSONObject r100, String r101) {
    L22:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#doConfirmAgain", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#doConfirmAgain", e);
    L25:
        if (this.mCommonParams.mIsFastPay == true) goto L29;
        VerifyBaseVM r102 = this.mSupportConfirmAgainVM;
        if (r102 == null) goto L45;
        r102.doConfirmAgain(r100);
        return;
    L45:
        return;
    L29:
        VerifyBaseVM r103 = this.mSupportConfirmAgainVM;
        if (r103 == null) goto L33;
        r103.doConfirmAgain(r100);
        return;
    L33:
        if (BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO.equals(r101) == false) goto L38;
        VerifyVMContext r104 = this.mVMContext;
        if (r104 == null) goto L38;
        r104.getUploadIDCardVM().doTradeConfirm(r100);
    L38:
        if ("121".equals(r101) == false) goto L48;
        VerifyVMContext r105 = this.mVMContext;
        if (r105 == null) goto L49;
        r105.getInputPhoneVM().doTradeConfirm(r100);
        return;
    L49:
        return;
    L48:
        return;
    L5:
        if (BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO.equals(r101) == false) goto L10;
        if (r100 != null) goto L8;
        r100 = new JSONObject();     // Catch: Exception -> L22
    L8:
        r100.put("req_type_real", "12");     // Catch: Exception -> L22
    L10:
        if ("121".equals(r101) == false) goto L14;
        if (r100 != null) goto L13;
        r100 = new JSONObject();     // Catch: Exception -> L22
    L13:
        r100.put("req_type_real", "13");     // Catch: Exception -> L22
    L14:
        if (r100 == null) goto L25;
        if (r100.has("nonblock_anti_laundering_canceled") == false) goto L25;
        CJPayTradeConfirmResponseBean r106 = this.confirmResponseBean;     // Catch: Exception -> L22
        if (r106 == null) goto L20;
        r100.put("button_info_ext", r106.button_info.exts);     // Catch: Exception -> L22
    L20:
        r100.put("button_info_action_11", "button_info_action_11");     // Catch: Exception -> L22
        goto L25
    }

    private boolean onConfirmIntercept(CJPayTradeConfirmResponseBean r100, VerifyBaseVM r101) {
        Iterator<VerifyBaseVM> r102 = this.vms.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L7;
        r103 = r102.next().onConfirmIntercept(r100, r101);
        if (r103 == false) goto L4;
    L7:
        return r103;
    }

    private void reportPayAfterUseStatus(VerifyVMContext r100, CJPayTradeConfirmResponseBean r101) {
        if (r101 == null) goto L10;
        CJPayResultRespExts r102 = r101.exts;
        if (r102 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102.pay_after_use_open_status) == true) goto L12;
        String r103 = r101.code;
        String r104 = r101.msg;
        boolean r105 = "success".equals(r101.exts.pay_after_use_open_status);
        CJPayResultRespExts r106 = r101.exts;
        String r107 = r106.activity_id;
        String r108 = r106.bill_page_display_text;
        UploadEventUtils.walletCashierPayAfterUseOpenResult(r100, r103, r104, r105 ? 1 : 0, r107, r108);
        return;
    L12:
        return;
    }

    private void setPwdVmParams(String r100, VerifyBaseVM r101) {
    L10:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#setPwdVmParams", th);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#setPwdVmParams", th);
        this.pwdVmParams = null;
        return;
    L4:
        if ("CD000000".equals(r100) == true) goto L6;
    L8:
        this.pwdVmParams = null;     // Catch: Throwable -> L10
    L13:
        return;
    L6:
        if ((r101 instanceof VerifyPasswordVM) == false) goto L8;
        SuccessPwdVmParams r102 = new SuccessPwdVmParams(this);     // Catch: Throwable -> L10
        this.pwdVmParams = r102;     // Catch: Throwable -> L10
        r102.height = ((VerifyPasswordVM) r101).getPageHeight();     // Catch: Throwable -> L10
        SuccessPwdVmParams r103 = this.pwdVmParams;     // Catch: Throwable -> L10
        r103.loadingContainerHeight = ((VerifyPasswordVM) r101).getLoadingContainerHeight();     // Catch: Throwable -> L10
        SuccessPwdVmParams r104 = this.pwdVmParams;     // Catch: Throwable -> L10
        r104.amountStr = ((VerifyPasswordVM) r101).getAmountStr();     // Catch: Throwable -> L10
        SuccessPwdVmParams r105 = this.pwdVmParams;     // Catch: Throwable -> L10
        r105.voucherStr = ((VerifyPasswordVM) r101).getVoucherStr();     // Catch: Throwable -> L10
        SuccessPwdVmParams r106 = this.pwdVmParams;     // Catch: Throwable -> L10
        r106.amountFontSize = ((VerifyPasswordVM) r101).getAmountFontSize()[0];     // Catch: Throwable -> L10
        SuccessPwdVmParams r107 = this.pwdVmParams;     // Catch: Throwable -> L10
        r107.unitFontSize = ((VerifyPasswordVM) r101).getAmountFontSize()[1];     // Catch: Throwable -> L10
        SuccessPwdVmParams r108 = this.pwdVmParams;     // Catch: Throwable -> L10
        r108.sizeTypedValue = ((VerifyPasswordVM) r101).getAmountFontSize()[2];     // Catch: Throwable -> L10
        goto L13
    }

    public static /* synthetic */ void access$1200(VerifyBaseManager r100, VerifyVMContext r101, CJPayTradeConfirmResponseBean r102) {
        r100.reportPayAfterUseStatus(r101, r102);
    }

    public static /* synthetic */ boolean access$1300(VerifyBaseManager r100, CJPayTradeConfirmResponseBean r101, VerifyBaseVM r102) {
        return r100.onConfirmIntercept(r101, r102);
    }

    public static /* synthetic */ void access$1400(VerifyBaseManager r100, String r101, VerifyBaseVM r102) {
        r100.setPwdVmParams(r101, r102);
    }

    public static /* synthetic */ void access$3400(VerifyBaseManager r100, JSONObject r101, String r102) {
        r100.doConfirmAgain(r101, r102);
    }

    public void release(boolean r100, int r101, Boolean r102) {
        this.mSupportConfirmAgainVM = null;
        this.mLastLoadingVM = null;
        this.mSuccessVM = null;
        this.mCurrentVM = null;
        this.mModel.cancel();
        this.verifyQueryMode.stop();
        this.mStackManager.finishFragmentAll(r100, r101, r102);
        this.mStackManager.release();
        Iterator<VerifyBaseVM> r103 = this.vms.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().release();
        goto L4
    L6:
        this.vms.clear();
        this.mVMContext = null;
        this.pwdVmParams = null;
        EventManager.INSTANCE.unregister(this.mObserver);
        unregisterGlobalCountdown();
    }

    public void start(int r100, int r101, int r102, boolean r110) {
        this.mCommonParams.newPwdParams = new VerifyNewPwdParams();
        VerifyVMContext r103 = this.mVMContext;
        if (r103 == null) goto L23;
        r103.releasePaymentService();
        VerifyCommonParams r104 = this.mCommonParams;
        if (r104.mHasShowBankCardPoint == false) goto L18;
        VerifyNoPwdPayParams r105 = r104.noPwdPayParams;
        if (r105 == null) goto L18;
        if (r105.getPayInfo() == null) goto L18;
        if (this.mCommonParams.noPwdPayParams.getPayInfo().asset_info == null) goto L18;
        if (this.mCommonParams.noPwdPayParams.getPayInfo().isCombinePay() == true) goto L15;
    L17:
        VerifyVMContext r106 = this.mVMContext;
        String r107 = this.mCommonParams.noPwdPayParams.getPayInfo().asset_info.asset_meta_info.getUniqueSymbol();
        VerifyCommonParams r108 = this.mCommonParams;
        r106.setBankCardPointSwitch(r107, r108.bankCardPointChecked, r108.bankCardPointKey);
        goto L18
    L15:
        if (this.mCommonParams.noPwdPayParams.getPayInfo().getCombineAssetInfo() == null) goto L17;
        String r109 = this.mCommonParams.noPwdPayParams.getPayInfo().getCombineAssetInfo().asset_meta_info.getUniqueSymbol();
        VerifyVMContext r111 = this.mVMContext;
        VerifyCommonParams r112 = this.mCommonParams;
        r111.setBankCardPointSwitch(r109, r112.bankCardPointChecked, r112.bankCardPointKey);
    L18:
        VoucherDialogExpandResult r113 = this.mCommonParams.expandResult;
        if (r113 == null) goto L23;
        Map<String, Object> r114 = this.mVMContext.verifyProcessParams;
        if (r114 == null) goto L23;
        r114.put(CJPayKeepDialogUtil.VOUCHER_BLOAT_PARAM_KEY, r113);
    L23:
        initCountdownFromCheckoutResponse();
        CJLogger.d(TAG, "VerifyBase start:" + r100 + "," + r101 + "," + r102 + "," + r110);     // Catch: Exception -> L30
        Iterator<VerifyBaseVM> r115 = this.vms.iterator();     // Catch: Exception -> L30
    L26:
        if (r115.hasNext() == false) goto L28;
        r115.next().firstStart(r100, r101, r102, r110);     // Catch: Exception -> L30
        goto L26
    L28:
        reportVerifyStart(r100);     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyBaseManager#start", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyBaseManager#start", e);
        CJReporter r116 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "start_verify_fail", 0, e);
    }

    public void startFastPay(String r100, int r101, int r102, boolean r103) {
        Iterator<VerifyBaseVM> r104 = this.vms.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().startByFastPay(r100, r101, r102, r103);
        goto L4
    }

    public VerifyBaseManager(Context r100, int r110, VerifyCommonParams r111, ICJPayVerifyStackStateCallback r112, CJContext r113) {
        this.vms = new CopyOnWriteArrayList();
        this.mIsHookFragmentVM = false;
        this.checkList = new HashSet();
        this.isTriggerRiskControl = false;
        this.hasShownKeepDialog = false;
        this.isRegisterGlobalCountdown = false;
        this.showStyle = "";
        this.mCountdownRemainingTimeMs = 0;
        this.mCountdownHandler = new Handler(Looper.getMainLooper());
        this.mCountdownRunnable = new AnonymousClass1(this);
        this.defaultDialog = new AnonymousClass2(this);
        this.mOnConfirmResponse = new AnonymousClass3(this);
        this.mQueryCallBack = new AnonymousClass4(this);
        this.cardSignListener = new AnonymousClass5(this);
        this.oneStepPaymentListener = new AnonymousClass6(this);
        this.fingerprintListener = new AnonymousClass7(this);
        this.verifyNothingListener = new AnonymousClass8(this);
        this.verifyTokenListener = new AnonymousClass9(this);
        this.verifyMemberListener = new AnonymousClass10(this);
        this.faceCheckDefaultListener = new AnonymousClass11(this);
        this.verifyAddPwdListener = new AnonymousClass12(this);
        this.mObserver = new AnonymousClass13(this);
        CJPayPerformance.getInstance().initByModule(BuildConfig.LIBRARY_PACKAGE_NAME);
        this.mCommonParams = r111;
        this.mContext = r100;
        this.mModel = new VerifyMode(r111, this.mOnConfirmResponse, r113);
        VerifyCommonParams r114 = this.mCommonParams;
        this.verifyQueryMode = new VerifyQueryMode(r114.tradeQueryParams, this.mQueryCallBack, r114.keepDialogParams, r114.logParams, this);
        this.mStackManager = new VerifyStackManager(r100, r110, r112);
        this.monitorManager = new VerifyMonitorManager();
        initViewModule(r100);
        EventManager.INSTANCE.register(this.mObserver);
    }
}
