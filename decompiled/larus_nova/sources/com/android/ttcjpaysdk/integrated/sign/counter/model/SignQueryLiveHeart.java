package com.android.ttcjpaysdk.integrated.sign.counter.model;

import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SignQueryLiveHeart implements Runnable {
    private static final int MAX_REQUEST_COUNT = 2;
    public static final int RESULT_STATUS_ERROR = 3;
    public static final int RESULT_STATUS_FAIl = 1;
    public static final int RESULT_STATUS_PROCESSING = 2;
    public static final int RESULT_STATUS_SUCCESS = 0;
    private static final int TIME_SPAN = 500;
    private int mCurrentRequestCount;
    private final Handler mHandler;
    private volatile boolean mIsQueryConnecting;
    private final AtomicBoolean mIsRunning;
    private Map<String, String> mParams;
    private QueryCallBack mQueryCallBack;
    private final SignBaseModel signBaseModel;

    public interface QueryCallBack {
        void onResult(int r100, String r101, String r102);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_android_ttcjpaysdk_integrated_sign_counter_model_SignQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public synchronized void start() {
        monitor-enter(this);
        this.mIsRunning.set(true);     // Catch: Throwable -> L6
        this.mHandler.post(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        this.mIsRunning.set(false);     // Catch: Throwable -> L6
        this.mHandler.removeCallbacks(this);     // Catch: Throwable -> L6
        this.mCurrentRequestCount = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void askPayResult() {
        this.signBaseModel.signQuery(this.mParams, new AnonymousClass1(this), null);
        this.mIsQueryConnecting = true;
    }

    public void com_android_ttcjpaysdk_integrated_sign_counter_model_SignQueryLiveHeart__run$___twin___() {
        if (this.mIsRunning.get() == true) goto L5;
        return;
    L5:
        if (this.mCurrentRequestCount < 2) goto L7;
        return;
    L7:
        if (this.mIsQueryConnecting == true) goto L18;
        this.mCurrentRequestCount++;
        askPayResult();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("SignQueryLiveHeart#run", th);
        CJBasicCommonUtils.logCatch("CJCatch", "SignQueryLiveHeart#run", th);
        th.printStackTrace();
        return;
    }

    public SignQueryLiveHeart() {
        AtomicBoolean r100 = new AtomicBoolean(true);
        this.mIsRunning = r100;
        this.mCurrentRequestCount = 0;
        this.mIsQueryConnecting = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.signBaseModel = new SignBaseModel();
        r100.set(true);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_android_ttcjpaysdk_integrated_sign_counter_model_SignQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(SignQueryLiveHeart r100) {
        r100.com_android_ttcjpaysdk_integrated_sign_counter_model_SignQueryLiveHeart__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setParams(Map<String, String> r100) {
        this.mParams = r100;
    }

    public void setQueryCallBack(QueryCallBack r100) {
        this.mQueryCallBack = r100;
    }

    public static /* synthetic */ boolean access$002(SignQueryLiveHeart r100, boolean r101) {
        r100.mIsQueryConnecting = r101;
        return r101;
    }

    private void callBackError(String r100, String r101) {
        stop();
        QueryCallBack r102 = this.mQueryCallBack;
        if (r102 == null) goto L6;
        r102.onResult(3, r100, r101);
        return;
    }

    private void callBackFail(String r100, String r101) {
        stop();
        QueryCallBack r102 = this.mQueryCallBack;
        if (r102 == null) goto L6;
        r102.onResult(1, r100, r101);
        return;
    }

    private void callBackProcessing(String r100, String r101) {
        if (this.mCurrentRequestCount < 2) goto L7;
        stop();
        QueryCallBack r102 = this.mQueryCallBack;
        if (r102 == null) goto L9;
        r102.onResult(2, r100, r101);
        return;
    L9:
        return;
    L7:
        this.mIsQueryConnecting = false;
        this.mHandler.postDelayed(this, 500);
    }

    private void callBackSuccess(String r100, String r101) {
        stop();
        QueryCallBack r102 = this.mQueryCallBack;
        if (r102 == null) goto L6;
        r102.onResult(0, r100, r101);
        return;
    }

    public static /* synthetic */ void access$100(SignQueryLiveHeart r100, String r101, String r102) {
        r100.callBackSuccess(r101, r102);
    }

    public static /* synthetic */ void access$200(SignQueryLiveHeart r100, String r101, String r102) {
        r100.callBackFail(r101, r102);
    }

    public static /* synthetic */ void access$300(SignQueryLiveHeart r100, String r101, String r102) {
        r100.callBackProcessing(r101, r102);
    }

    public static /* synthetic */ void access$400(SignQueryLiveHeart r100, String r101, String r102) {
        r100.callBackError(r101, r102);
    }
}
