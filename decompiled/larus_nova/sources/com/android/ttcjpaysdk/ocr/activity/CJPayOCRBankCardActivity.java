package com.android.ttcjpaysdk.ocr.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJResult;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogBuilder;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ocr.CameraPreview;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.ocr.OCRScanResult;
import com.android.ttcjpaysdk.ocr.data.BankCardOCRResult;
import com.android.ttcjpaysdk.ocr.data.OCRResponse;
import com.android.ttcjpaysdk.ocr.data.OCRScanData;
import com.android.ttcjpaysdk.ocr.data.OnceOCRResult;
import com.android.ttcjpaysdk.ocr.log.CJPayBankOCRLogger;
import com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger;
import com.android.ttcjpaysdk.ocr.presenter.OCRBankCardPresenter;
import com.android.ttcjpaysdk.ocr.utils.CJPayOCRRotateUtils;
import com.android.ttcjpaysdk.ocr.utils.OCRAnimationUtil;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.android.ttcjpaysdk.ocr.view.OCRCodeView;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import dc9.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0010\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001iB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0005H\u0002J\u001c\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00102\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00103\u001a\u00020,H\u0016J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u000206H\u0002J$\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00109\u001a\u00020\u0007H\u0016J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070;H\u0002J\b\u0010<\u001a\u00020,H\u0002J\u0012\u0010=\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010>H\u0002J\u0012\u0010?\u001a\u00020,2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u00020,H\u0016J\b\u0010C\u001a\u00020,H\u0002J\b\u0010D\u001a\u00020,H\u0016J\b\u0010E\u001a\u00020\u000fH\u0016J\b\u0010F\u001a\u00020\u000fH\u0016J\b\u0010G\u001a\u00020\u000fH\u0002J\"\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010>H\u0014J\u0010\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020MH\u0016J\u0012\u0010N\u001a\u00020,2\b\u0010O\u001a\u0004\u0018\u00010PH\u0014J\b\u0010Q\u001a\u00020,H\u0014J\u001c\u0010R\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010S\u001a\u00020,2\u0006\u0010@\u001a\u00020T2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\u0015H\u0002J(\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020Y2\u0006\u0010.\u001a\u00020Z2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\u0015H\u0002J \u0010[\u001a\u00020,2\u0006\u0010@\u001a\u00020Z2\u0006\u0010U\u001a\u00020\u000f2\b\b\u0002\u0010\\\u001a\u00020\u000fJ\b\u0010]\u001a\u00020,H\u0002J\u001c\u0010^\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010_\u001a\u00020,J\u0010\u0010`\u001a\u00020,2\u0006\u0010a\u001a\u00020\nH\u0002J\b\u0010b\u001a\u00020,H\u0002J\b\u0010c\u001a\u00020,H\u0002J\u0010\u0010d\u001a\u00020,2\u0006\u0010e\u001a\u00020\u0005H\u0016J\b\u0010f\u001a\u00020,H\u0016J\b\u0010g\u001a\u00020,H\u0016J\u0010\u0010h\u001a\u00020,2\u0006\u0010e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRBankCardActivity;", "Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRBaseActivity;", "Lcom/android/ttcjpaysdk/ocr/log/CJPayBankOCRLogger;", "()V", "TAG", "", "WARNING_ANIMATION_TIME_INTERVAL", "", "callbackCount", "choosePictureStartTime", "", "countDownStartTime", "executorService", "Ljava/util/concurrent/ExecutorService;", "isUseFromAlbum", "", "()Z", "setUseFromAlbum", "(Z)V", "isWarningProcess", "lastOCRResult", "Lcom/android/ttcjpaysdk/ocr/data/OnceOCRResult;", "lastWarningShow", "mAlbumView", "Landroid/widget/TextView;", "mCardInputType", "mConfirmDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mHandler", "Landroid/os/Handler;", "mOCRPresenter", "Lcom/android/ttcjpaysdk/ocr/presenter/OCRBankCardPresenter;", "mOCRStartTime", "mWaringTv", "mWarningLayout", "Landroid/view/View;", "ocrType", "requestCount", "subTitle", "title", "titleView", "cameraError", "", "checkOCRule", "data", "doCancel", "errorCode", "errorMsg", "doManual", "doPermissionGranted", "executeOCR", "scanData", "Lcom/android/ttcjpaysdk/ocr/data/OCRScanData;", "executeWarningAnimation", "tips", "getLayout", "getRealScreenSize", "Lkotlin/Pair;", "gotoAlbum", "handleAlbumPic", "Landroid/content/Intent;", "handleNativeOCR", "result", "Lcom/android/ttcjpaysdk/ocr/data/BankCardOCRResult;", "initAction", "initScanView", "initView", "isActivityPortrait", "isFromAlbum", "isRotateRelayoutDegraded", "onActivityResult", "requestCode", "resultCode", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onOCRScanError", "onScanOCRCode", "Lcom/android/ttcjpaysdk/ocr/OCRScanResult;", "isOnce", "onceOCRResult", "parsingOCRResponse", "json", "Lorg/json/JSONObject;", "", "requestOCR", "hasRetry", "resetParams", "showOCRErrorDialog", "showTimeoutDialog", "startCountDownTime", "time", "stopSpot", "updateView", "uploadOcrAuthPageClick", "buttonName", "uploadOcrAuthPageImp", "uploadOcrScanningPageImp", "uploadOrcScanningPageClick", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOCRBankCardActivity extends CJPayOCRBaseActivity<CJPayBankOCRLogger> {
    private static final int ALBUM_REQUEST_CODE = 0;
    public static final Companion Companion = null;
    private final String TAG;
    private final int WARNING_ANIMATION_TIME_INTERVAL;
    private int callbackCount;
    private long choosePictureStartTime;
    private long countDownStartTime;
    private ExecutorService executorService;
    private boolean isUseFromAlbum;
    private boolean isWarningProcess;
    private OnceOCRResult lastOCRResult;
    private long lastWarningShow;
    private TextView mAlbumView;
    private int mCardInputType;
    private CJPayCommonDialog mConfirmDialog;
    private CountDownTimer mCountDownTimer;
    private final Handler mHandler;
    private OCRBankCardPresenter mOCRPresenter;
    private long mOCRStartTime;
    private TextView mWaringTv;
    private View mWarningLayout;
    public String ocrType;
    private int requestCount;
    public String subTitle;
    public String title;
    private TextView titleView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRBankCardActivity$Companion;", "", "()V", "ALBUM_REQUEST_CODE", "", "getALBUM_REQUEST_CODE", "()I", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int getALBUM_REQUEST_CODE() {
            return CJPayOCRBankCardActivity.access$getALBUM_REQUEST_CODE$cp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void access$000(CJPayOCRBaseActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private final void cameraError() {
        showLoading(false);
        CJPayBasicUtils.displayToastInternal(getActivity(), getString(R.string.cj_pay_camera_error_toast), 0, 17, 0, 0);
        CJPayBankOCRLogger r100 = getLogger();
        if (r100 == null) goto L5;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r100, this.TAG, "cameraError", "", getString(R.string.cj_pay_camera_error_toast), null, 16, null);
    L5:
        CJPayBankOCRLogger r101 = getLogger();
        if (r101 == null) goto L8;
        CJPayBankOCRLogger.uploadOcrScanningResult$default(r101, "0", System.currentTimeMillis() - this.mOCRStartTime, 1, "", "无法打开相机", this.requestCount, this.callbackCount, 0, 128, null);
    L8:
        finish();
    }

    private final void resetParams() {
        this.requestCount = 0;
        this.callbackCount = 0;
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public int getLayout() {
        return R.layout.cj_pay_activity_ocr_scan;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final void gotoAlbum() {
        Intent r100 = new Intent("android.intent.action.GET_CONTENT");
        r100.setType("image/*");
        startActivityForResult(r100, ALBUM_REQUEST_CODE);
        this.choosePictureStartTime = System.currentTimeMillis();
        this.isUseFromAlbum = true;
    }

    private final boolean isRotateRelayoutDegraded() {
        return CJPayOCRRotateUtils.isRotateRelayoutDegraded(this.ocrType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateView() {
        boolean r100 = this instanceof ICJTag;
        String r101 = "runCatching";
        if (r100 == false) goto L10;
        String r102 = ((ICJTag) this).CJTag();
        if (r102 == null) goto L10;
        if (StringsKt.isBlank(r102) == false) goto L9;
        r102 = "runCatching";
    L9:
        String r103 = r102;
    L12:
        if (StringsKt.isBlank(r103) == false) goto L21;
        if (r100 == false) goto L20;
        String r104 = ((ICJTag) this).CJTag();
        if (r104 == null) goto L20;
        if (StringsKt.isBlank(r104) == true) goto L20;
        r101 = r104;
    L20:
        String r105 = r101;
    L22:
        String r110 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r105, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r111 = System.currentTimeMillis();
        String r112 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L73
        OCRCodeView r107 = getOCRCodeView();     // Catch: Throwable -> L73
        if (r107 != null) goto L26;
        int r113 = 0;
    L68:
        Unit r108 = null;
    L69:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L71
    L77:
        if (Result.m9456isSuccessimpl(r109) == false) goto L79;
        CJLogger.d(r105, "onSuccess\n " + r110);
        Object r114 = r109;
        boolean r115 = true;
    L80:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r109);
        if (r116 == null) goto L83;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r116);
        CJLogger.c(r105, "onFailure", r116);
        r115 = false;
    L84:
        long r117 = System.currentTimeMillis() - r111;
        CJLogger.d(r105, "is_success: " + r115 + ", duration: " + r117);
        CJReporter r118 = CJReporter.f202294a;
        Set<String> r119 = CJContext.f202254w;
        String r120 = "";
        CJContext r121 = CJContext.c.a(r103, "", "", new HashMap());
        Pair[] r122 = new Pair[5];
        r122[r113] = TuplesKt.to("tag", r103);
        r122[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r115, "1", "0"));
        if (r116 == null) goto L87;
        r112 = r116.getMessage();
    L87:
        if (r112 == null) goto L90;
        r120 = r112;
    L90:
        r122[2] = TuplesKt.to("error_msg", r120);
        r122[3] = TuplesKt.to("trace", r110);
        r122[4] = TuplesKt.to("duration", Long.valueOf(r117));
        CJReporter.o(r121, "cjpay_run_catch_result", MapsKt.mapOf(r122));
        new CJResult(r114, r115, r116);
        return;
    L83:
        r116 = null;
        goto L84
    L79:
        r114 = null;
        r115 = false;
    L71:
        th = th;
    L75:
        Result.Companion r123 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L77
    L26:
        if (isRotateRelayoutDegraded() == true) goto L63;
        int r124 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this);     // Catch: Throwable -> L73
        int r125 = CJPayBasicUtils.getScreenHeight(this);     // Catch: Throwable -> L73
        Pair<Integer, Integer> r126 = getRealScreenSize();     // Catch: Throwable -> L73
        int r127 = r126.getFirst().intValue();     // Catch: Throwable -> L73
        r126.getSecond().intValue();     // Catch: Throwable -> L73
        if (r125 > r127) goto L30;
        boolean r128 = true;
    L31:
        int r129 = Math.min(r124, r125) - (OCRCodeUtil.dp2px(this, 24.0f) * 2);     // Catch: Throwable -> L73
        if (r128 == false) goto L34;
        r129 = (int) (r129 * 0.5f);     // Catch: Throwable -> L73
    L34:
        int r130 = (int) ((((double) r129) * 212.0d) / 327.0d);     // Catch: Throwable -> L73
        if (r129 <= 0) goto L38;
        if (r130 <= 0) goto L38;
        boolean r131 = true;
    L39:
        if (r131 == true) goto L42;
        r129 = OCRCodeUtil.dp2px(this, 327.0f);     // Catch: Throwable -> L73
    L42:
        if (r131 == true) goto L45;
        r130 = OCRCodeUtil.dp2px(this, 212.0f);     // Catch: Throwable -> L73
    L45:
        if (r128 == false) goto L51;
        CameraPreview r132 = r107.getCameraPreview();     // Catch: Throwable -> L73
        if (r132 == null) goto L49;
        int r133 = r132.getHeight();     // Catch: Throwable -> L73
    L50:
        int r134 = (r133 - r130) / 2;     // Catch: Throwable -> L73
    L52:
        r107.setScanBoxSize(r129, r130);     // Catch: Throwable -> L73
        if (r134 > 0) goto L56;
        r134 = OCRCodeUtil.dp2px(this, 150.0f);     // Catch: Throwable -> L73
    L56:
        r107.setScanBoxTopOffset(r134);     // Catch: Throwable -> L73
        if (r128 == false) goto L59;
        int r135 = OCRCodeUtil.dp2px(this, 60.0f);     // Catch: Throwable -> L73
    L60:
        r113 = 0;
        setMarginTop(this.mAlbumView, 0, 0, 0, r135);     // Catch: Throwable -> L71
    L64:
        r107.setVisibility(r113);     // Catch: Throwable -> L71
        Rect r136 = r107.getScanBoxRect();     // Catch: Throwable -> L71
        if (r136 == null) goto L68;
        setMarginTop(this.mWarningLayout, 0, r136.top - CJPayBasicExtensionKt.dp(50.0f), 0, 0);     // Catch: Throwable -> L71
        r108 = Unit.INSTANCE;     // Catch: Throwable -> L71
        goto L69
    L59:
        r135 = OCRCodeUtil.dp2px(this, 134.0f);     // Catch: Throwable -> L73
        goto L60
    L49:
        r133 = r107.getHeight();     // Catch: Throwable -> L73
        goto L50
    L51:
        r134 = ((r125 - OCRCodeUtil.dp2px(this, 44.0f)) - r130) / 2;     // Catch: Throwable -> L73
    L38:
        r131 = false;
        goto L39
    L30:
        r128 = false;
        goto L31
    L63:
        r113 = 0;
    L73:
        th = th;
        r113 = 0;
        goto L75
    L21:
        r105 = r103;
    L10:
        r103 = "runCatching";
        goto L12
    }

    public final void showTimeoutDialog() {
        View.OnClickListener r100 = new CJPayOCRBankCardActivity$showTimeoutDialog$leftClickListener$1(this);
        CJPayDialogBuilder r101 = CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(getString(R.string.cj_pay_ocr_error_title)).setSubTitle(getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getString(R.string.cj_pay_ocr_error_leftbtn)).setRightBtnStr(getString(R.string.cj_pay_ocr_error_rightbtn)).setLeftBtnListener(r100).setRightBtnListener(new CJPayOCRBankCardActivity$showTimeoutDialog$rightClickListener$1(this)).setLeftBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue)).setRightBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue)).setSingleBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue));
        boolean r102 = false;
        CJPayCommonDialog r103 = CJPayDialogUtils.initDialog(r101.setLeftBtnBold(false).setRightBtnBold(false).setSingleBtnBold(false).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
        this.mConfirmDialog = r103;
        if (r103 == null) goto L5;
        CJPayKotlinExtensionsKt.showSafely(r103, getActivity());
    L5:
        CJPayBankOCRLogger r104 = getLogger();
        if (r104 == null) goto L15;
        long r105 = System.currentTimeMillis() - this.mOCRStartTime;
        int r106 = this.mCardInputType;
        String r107 = this.lastOCRResult.getCode();
        if (this.lastOCRResult.getMsg().length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L12;
        String r108 = "超时识别失败";
    L13:
        CJPayBankOCRLogger.uploadOcrScanningResult$default(r104, "0", r105, r106, r107, r108, this.requestCount, this.callbackCount, 0, 128, null);
        return;
    L12:
        r108 = "超时识别失败--" + this.lastOCRResult.getMsg();
        goto L13
    }

    public CJPayOCRBankCardActivity() {
        this.mCardInputType = 1;
        this.mHandler = new Handler();
        this.lastOCRResult = new OnceOCRResult(0, null, null, 0, 0, 0, 0, 127, null);
        this.WARNING_ANIMATION_TIME_INTERVAL = 2000;
        this.TAG = "CJPayOCRBankCardActivity";
    }

    private final Pair<Integer, Integer> getRealScreenSize() {
        return CJPayOCRRotateUtils.getRealScreenSize(this);
    }

    private final void initScanView() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L6;
        r100.setImageCollectionListener(new C92851(this));
        return;
    }

    private final void stopSpot() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L5;
        r100.stopSpot();
    L5:
        OCRBankCardPresenter r101 = this.mOCRPresenter;
        if (r101 == null) goto L9;
        r101.cancelRequest();
        return;
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onDestroy$___twin___() {
        super.onDestroy();
        ExecutorService r100 = this.executorService;
        if (r100 == null) goto L5;
        r100.shutdown();
    L5:
        CountDownTimer r101 = this.mCountDownTimer;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        OCRDevice.getInstance().release();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doPermissionGranted() {
        super.doPermissionGranted();
        startCountDownTime(30);
        this.countDownStartTime = System.currentTimeMillis();
        CJPayBankOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.walletAddbcardOrcScanningStart();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initAction() {
        super.initAction();
        TextView r100 = this.mAlbumView;
        if (r100 == null) goto L6;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new C92841(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initView() {
        super.initView();
        this.mAlbumView = (TextView) findViewById(R.id.album_view);
        AppCompatActivity r100 = getActivity();
        boolean r101 = false;
        String r102 = null;
        if (r100 == null) goto L11;
        Resources r103 = r100.getResources();
        if (r103 == null) goto L11;
        Drawable r104 = r103.getDrawable(R.drawable.cj_pay_ocr_album_icon);
        if (r104 == null) goto L11;
        r104.setBounds(0, 0, CJPayBasicExtensionKt.dp(24), CJPayBasicExtensionKt.dp(24));
        TextView r105 = this.mAlbumView;
        if (r105 == null) goto L11;
        r105.setCompoundDrawables(r104, null, null, null);
    L11:
        this.mWarningLayout = findViewById(R.id.warning_tips_layout);
        this.mWaringTv = (TextView) findViewById(R.id.tv_warning_tips);
        View r106 = this.mWarningLayout;
        if (r106 == null) goto L14;
        r106.post(new AnonymousClass2(this));
    L14:
        TextView r107 = (TextView) findViewById(R.id.cj_pay_ocr_title);
        this.titleView = r107;
        if (r107 == null) goto L28;
        String r108 = this.title;
        if (r108 != null) goto L20;
    L26:
        r102 = getString(R.string.cj_pay_ocr_scan_bank_card_title);
    L27:
        r107.setText(r102);
        goto L28
    L20:
        if (r108.length() <= 0) goto L22;
        r101 = true;
    L22:
        if (r101 == false) goto L24;
        r102 = r108;
    L24:
        if (r102 == null) goto L26;
    L28:
        setLoadingMsg(getString(R.string.cj_pay_ocr_bank_card_loading));
        initScanView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        return isRotateRelayoutDegraded();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOcrAuthPageImp() {
        CJPayBankOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.uploadOcrAuthPageImp();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOcrScanningPageImp() {
        CJPayBankOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.uploadOcrScanningPageImp();
        return;
    }

    public static final /* synthetic */ int access$getALBUM_REQUEST_CODE$cp() {
        return ALBUM_REQUEST_CODE;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public boolean isFromAlbum() {
        return this.isUseFromAlbum;
    }

    public final boolean isUseFromAlbum() {
        return this.isUseFromAlbum;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ void access$cameraError(CJPayOCRBankCardActivity r100) {
        r100.cameraError();
    }

    public static final /* synthetic */ int access$getCallbackCount$p(CJPayOCRBankCardActivity r100) {
        return r100.callbackCount;
    }

    public static final /* synthetic */ long access$getCountDownStartTime$p(CJPayOCRBankCardActivity r100) {
        return r100.countDownStartTime;
    }

    public static final /* synthetic */ int access$getMCardInputType$p(CJPayOCRBankCardActivity r100) {
        return r100.mCardInputType;
    }

    public static final /* synthetic */ CJPayCommonDialog access$getMConfirmDialog$p(CJPayOCRBankCardActivity r100) {
        return r100.mConfirmDialog;
    }

    public static final /* synthetic */ CountDownTimer access$getMCountDownTimer$p(CJPayOCRBankCardActivity r100) {
        return r100.mCountDownTimer;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(CJPayOCRBankCardActivity r100) {
        return r100.mHandler;
    }

    public static final /* synthetic */ String access$getTAG$p(CJPayOCRBankCardActivity r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ int access$getWARNING_ANIMATION_TIME_INTERVAL$p(CJPayOCRBankCardActivity r100) {
        return r100.WARNING_ANIMATION_TIME_INTERVAL;
    }

    public static final /* synthetic */ void access$gotoAlbum(CJPayOCRBankCardActivity r100) {
        r100.gotoAlbum();
    }

    public static final /* synthetic */ void access$resetParams(CJPayOCRBankCardActivity r100) {
        r100.resetParams();
    }

    public static final /* synthetic */ void access$stopSpot(CJPayOCRBankCardActivity r100) {
        r100.stopSpot();
    }

    public static final /* synthetic */ void access$updateView(CJPayOCRBankCardActivity r100) {
        r100.updateView();
    }

    private final boolean checkOCRule(String r100) {
        JSONObject r101 = new JSONObject(OCRDevice.getInstance().getRule());     // Catch: Exception -> L11
        int r102 = r101.optInt("min_length");     // Catch: Exception -> L11
        int r103 = r101.optInt("max_length");     // Catch: Exception -> L11
        int r104 = r100.length();     // Catch: Exception -> L11
        if (r102 > r104) goto L8;
        if (r104 > r103) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L13;
        return true;
    L13:
        return false;
    L8:
        r105 = false;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayOCRBankCardActivity#checkOCRule", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRBankCardActivity#checkOCRule", e);
        goto L13
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayOCRBankCardActivity r100) {
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayOCRBankCardActivity r110) {
        r110.com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CJPayOCRBankCardActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayOCRBankCardActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private final void executeOCR(final OCRScanData r100) {
        final long r101 = System.currentTimeMillis();
        CJPayKotlinExtensionsKt.executeSafely(this.executorService, new AnonymousClass1(this, r100, r101));
    }

    private final void handleAlbumPic(final Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        showLoading(true);
        CJPayKotlinExtensionsKt.executeSafely(this.executorService, new C92831(r100, this));
    }

    private final void handleNativeOCR(BankCardOCRResult r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        String r100 = "";
        if (TextUtils.isEmpty(r110.getCardNumber()) == true) goto L14;
        String r101 = r110.getCardNumber();
        if (r101 == null) goto L14;
        String r102 = new Regex(" ").replace(r101, "");
        if (r102 == null) goto L14;
        r100 = r102;
    L14:
        if (checkOCRule(r100) == false) goto L23;
        ICJPayServiceRetCallBack r103 = OCRDevice.getInstance().getCallBack();
        if (r103 == null) goto L18;
        r103.onResult(OCRCodeUtil.createResult("0", r110.getCardNumber(), r110.getCardNumberImage(), this.mCardInputType, "识别成功"), r110.getOriginalImage());
    L18:
        CJPayBankOCRLogger r104 = getLogger();
        if (r104 == null) goto L21;
        r104.uploadOcrScanningResult("1", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, "", "native OCR success", this.requestCount, this.callbackCount, r100.length());
    L21:
        resetParams();
        finish();
        return;
    }

    private final void startCountDownTime(long r100) {
        final long r101 = r100 * ((long) 1000);
        CountDownTimer r102 = new CountDownTimerC92871(this, r101);
        this.mCountDownTimer = r102;
        r102.start();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        this.mOCRStartTime = System.currentTimeMillis();
        this.executorService = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CJPayOCRBankCardActivity"));
        this.mOCRPresenter = new OCRBankCardPresenter();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        View r101 = this.mWarningLayout;
        if (r101 == null) goto L6;
        r101.post(new RunnableC92861(this));
        return;
    }

    public final void setUseFromAlbum(boolean r100) {
        this.isUseFromAlbum = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOcrAuthPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        CJPayBankOCRLogger r101 = getLogger();
        if (r101 == null) goto L6;
        r101.uploadOcrAuthPageClick(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOrcScanningPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        CJPayBankOCRLogger r101 = getLogger();
        if (r101 == null) goto L6;
        r101.walletAddbcardOrcScanningPageClick(r100);
        return;
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(CJPayOCRBaseActivity r100, Configuration r101) {
        access$000(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static final /* synthetic */ void access$executeOCR(CJPayOCRBankCardActivity r100, OCRScanData r101) {
        r100.executeOCR(r101);
    }

    public static final /* synthetic */ void access$handleNativeOCR(CJPayOCRBankCardActivity r100, BankCardOCRResult r101) {
        r100.handleNativeOCR(r101);
    }

    public static final /* synthetic */ void access$setCallbackCount$p(CJPayOCRBankCardActivity r100, int r101) {
        r100.callbackCount = r101;
    }

    public static final /* synthetic */ void access$setCountDownStartTime$p(CJPayOCRBankCardActivity r100, long r101) {
        r100.countDownStartTime = r101;
    }

    public static final /* synthetic */ void access$setLastWarningShow$p(CJPayOCRBankCardActivity r100, long r101) {
        r100.lastWarningShow = r101;
    }

    public static final /* synthetic */ void access$setWarningProcess$p(CJPayOCRBankCardActivity r100, boolean r101) {
        r100.isWarningProcess = r101;
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(CJPayOCRBankCardActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRBankCardActivity__onCreate$___twin___(r101);
    }

    private final void doManual(String r100, String r101) {
        ICJPayServiceRetCallBack r102 = OCRDevice.getInstance().getCallBack();
        if (r102 == null) goto L5;
        r102.onResult(OCRCodeUtil.createResult("2", "", "", 0, r101), null);
    L5:
        resetParams();
    }

    private final void onOCRScanError(String r100, String r101) {
        showLoading(false);
        stopSpot();
        showOCRErrorDialog(r100, r101);
        this.mCardInputType = 2;
        CJPayBankOCRLogger r102 = getLogger();
        if (r102 == null) goto L6;
        r102.walletAddbcardOrcScanningFailPopImp(this.mCardInputType, r100, r101);
        return;
    }

    private final void showOCRErrorDialog(final String r110, final String r111) {
        View.OnClickListener r100 = new CJPayOCRBankCardActivity$showOCRErrorDialog$leftClickListener$1(this, r110, r111);
        View.OnClickListener r101 = new CJPayOCRBankCardActivity$showOCRErrorDialog$rightClickListener$1(this, r110, r111);
        CJPayCommonDialog r102 = CJPayDialogUtils.initDialog(CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(getString(R.string.cj_pay_ocr_error_title_for_album)).setSubTitle(getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getString(R.string.cj_pay_ocr_error_leftbtn_for_album)).setRightBtnStr(getString(R.string.cj_pay_ocr_error_rightbtn)).setLeftBtnListener(r100).setRightBtnListener(r101).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
        this.mConfirmDialog = r102;
        if (r102 == null) goto L5;
        CJPayKotlinExtensionsKt.showSafely(r102, getActivity());
    L5:
        CJPayBankOCRLogger r103 = getLogger();
        if (r103 == null) goto L9;
        CJPayBankOCRLogger.uploadOcrScanningResult$default(r103, "0", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, r110, r111, this.requestCount, this.callbackCount, 0, 128, null);
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doCancel(String r110, String r111) {
        if (this.lastOCRResult.getMsg().length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        String r101 = r111;
    L9:
        ICJPayServiceRetCallBack r102 = OCRDevice.getInstance().getCallBack();
        if (r102 == null) goto L12;
        r102.onResult(OCRCodeUtil.createResult("1", "", "", 0, r101), null);
    L12:
        CJPayBankOCRLogger r103 = getLogger();
        if (r103 == null) goto L15;
        CJPayBankOCRLogger.uploadOcrScanningResult$default(r103, "0", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, r110, r101, this.requestCount, this.callbackCount, 0, 128, null);
    L15:
        resetParams();
        return;
    L8:
        r101 = r111 + HttpClient.ENDFLAG + this.lastOCRResult.getMsg();
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    public static final /* synthetic */ void access$doManual(CJPayOCRBankCardActivity r100, String r101, String r102) {
        r100.doManual(r101, r102);
    }

    private final void executeWarningAnimation(String r100, String r101, String r110) {
        long r102 = System.currentTimeMillis() - this.lastWarningShow;
        if (this.isWarningProcess == false) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        if (r102 < this.WARNING_ANIMATION_TIME_INTERVAL) goto L40;
        TextView r104 = this.mWaringTv;
        if (r104 == null) goto L15;
        CharSequence r105 = r104.getText();
    L17:
        if (Intrinsics.areEqual(r105, r100) == false) goto L25;
        View r106 = this.mWarningLayout;
        if (r106 != null) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == false) goto L25;
    L28:
        TextView r108 = this.mWaringTv;
        if (r108 == null) goto L32;
        r108.setText(r100);
    L32:
        View r109 = this.mWarningLayout;
        if (r109 == null) goto L36;
        r109.setVisibility(0);
    L36:
        OCRAnimationUtil.INSTANCE.executeWarningAnimation(this.mWarningLayout, new C92821(this));
        this.isWarningProcess = true;
        return;
    L21:
        if (r106.getVisibility() != 0) goto L23;
        r107 = true;
    L25:
        CJPayBankOCRLogger r111 = getLogger();
        if (r111 == null) goto L28;
        r111.walletAddbcardOrcScanningPageTitleImp(r100, r101, r110);
        goto L28
    L15:
        r105 = null;
        goto L17
    L40:
        return;
    L7:
        r103 = false;
        goto L8
    }

    private final void onScanOCRCode(OCRScanResult r110, boolean r111, OnceOCRResult r112) {
        showLoading(false);
        this.mCardInputType = r110.cardInputType;
        if (TextUtils.isEmpty(r110.text) == false) goto L5;
        String r100 = "";
    L7:
        if (checkOCRule(r100) == false) goto L22;
        if (this.requestCount >= this.callbackCount) goto L11;
        return;
    L11:
        ICJPayServiceRetCallBack r113 = OCRDevice.getInstance().getCallBack();
        if (r113 == null) goto L14;
        r113.onResult(OCRCodeUtil.createResult("0", r110.text, r110.croppedImage, this.mCardInputType, r112.getMsg()), r110.data);
    L14:
        OCRBankCardPresenter r114 = this.mOCRPresenter;
        if (r114 == null) goto L17;
        r114.cancelRequest();
    L17:
        r112.setResult(1);
        CJPayBankOCRLogger r101 = getLogger();
        if (r101 == null) goto L20;
        r101.uploadOcrScanningResult("1", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, r112.getCode(), r112.getMsg(), this.requestCount, this.callbackCount, r100.length());
    L20:
        resetParams();
        finish();
        return;
    L22:
        if (r111 == false) goto L24;
        r112.setResult(0);
        r112.setMsg("OCR银行卡号格式错误");
        onOCRScanError("", "OCR银行卡号格式错误");
        return;
    L24:
        r112.setResult(0);
        r112.setMsg("OCR银行卡号格式错误");
        return;
    L5:
        String r102 = r110.text;
        r100 = new Regex(" ").replace(r102, "");
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        int r103 = 1;
        if (r101 == (-1)) goto L16;
        if (r101 != 0) goto L18;
        CountDownTimer r104 = this.mCountDownTimer;
        if (r104 == null) goto L9;
        r104.start();
    L9:
        OCRCodeView r105 = getOCRCodeView();
        if (r105 == null) goto L12;
        r105.startSpot();
    L12:
        OCRCodeView r106 = getOCRCodeView();
        if (r106 == null) goto L18;
        r106.showScanLine(true);
    L18:
        CJPayBankOCRLogger r107 = getLogger();
        if (r107 == null) goto L26;
        long r108 = System.currentTimeMillis() - this.choosePictureStartTime;
        if (r101 == (-1)) goto L24;
        r103 = 0;
    L24:
        r107.walletAddbcardOrcScanningPhotoBack(r108, r103);
        return;
    L26:
        return;
    L16:
        if (r100 != ALBUM_REQUEST_CODE) goto L18;
        handleAlbumPic(r102);
        goto L18
    }

    public final void requestOCR(final byte[] r210, final boolean r211, final boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "result");
        this.requestCount++;
        final long r100 = System.currentTimeMillis();
        final OnceOCRResult r213 = new OnceOCRResult(0, null, null, 0, 0, 0, 0, 127, null);
        final Function0<Unit> r101 = new CJPayOCRBankCardActivity$requestOCR$updateOCRResult$1(this, r213, r210, r211, r100);
        OCRBankCardPresenter r110 = this.mOCRPresenter;
        if (r110 == null) goto L6;
        r110.fetchOCRResult(r210, new CJPayOCRBankCardActivity$requestOCR$1$1(r101, this, r210, r211, r213, r212));
        return;
    }

    public static final /* synthetic */ void access$executeWarningAnimation(CJPayOCRBankCardActivity r100, String r101, String r102, String r103) {
        r100.executeWarningAnimation(r101, r102, r103);
    }

    private final void parsingOCRResponse(JSONObject r100, byte[] r110, boolean r111, final OnceOCRResult r112) {
        JSONObject r101 = r100.optJSONObject("response");     // Catch: Throwable -> L65
        String r102 = null;
        if (r101 == null) goto L5;
        final String r103 = r101.optString("code");     // Catch: Throwable -> L65
    L6:
        if (r101 == null) goto L9;
        String r104 = r101.optString("msg");     // Catch: Throwable -> L65
    L11:
        if (r101 == null) goto L13;
        String r105 = r101.optString("card_no");     // Catch: Throwable -> L65
    L14:
        if (r101 == null) goto L16;
        final String r106 = r101.optString("cropped_img");     // Catch: Throwable -> L65
    L18:
        if (TextUtils.isEmpty(r105) == true) goto L20;
        final String r107 = CJPayEncryptHelper.Companion.getDecryptDataSM(CJEncryptScene.OCR, r105, "ocr-银行卡", "card_no");     // Catch: Throwable -> L65
    L21:
        boolean r108 = false;
        int r109 = 1;
        if (r103 != null) goto L24;
    L32:
        if (r104 != null) goto L34;
    L40:
        Function0<Unit> r113 = new CJPayOCRBankCardActivity$parsingOCRResponse$successBadCase$1(r112, r103, r107, r106);     // Catch: Throwable -> L65
        if (Intrinsics.areEqual("MP000000", r103) == true) goto L43;
    L51:
        if (r111 == false) goto L54;
        r113.invoke();     // Catch: Throwable -> L65
        onOCRScanError(r103, r112.getMsg());     // Catch: Throwable -> L65
    L60:
        CJPayBankOCRLogger r114 = getLogger();     // Catch: Throwable -> L65
        if (r114 == null) goto L63;
        r114.walletAddbcardOrcScanningSingleResult(r112, r107.length());     // Catch: Throwable -> L65
    L63:
        this.lastOCRResult = r112;     // Catch: Throwable -> L65
        return;
    L54:
        if (Intrinsics.areEqual(OCRResponse.RESPONSE_ERROR_MP020349, r103) == true) goto L56;
        r113.invoke();     // Catch: Throwable -> L65
        goto L60
    L56:
        if (r112.getSingleTime() >= 2000) goto L58;
        executeWarningAnimation(getString(R.string.cj_pay_ocr_warning_bank_card_not_in_the_scan_area), r103, r104);     // Catch: Throwable -> L65
    L58:
        r113.invoke();     // Catch: Throwable -> L65
        goto L60
    L43:
        if (TextUtils.isEmpty(r107) == true) goto L51;
        if (TextUtils.isEmpty(r106) == true) goto L51;
        if (r111 == false) goto L50;
        r109 = 2;
    L50:
        onScanOCRCode(new OCRScanResult(r107, r106, r110, r109), r111, r112);     // Catch: Throwable -> L65
        goto L60
    L34:
        if (r104.length() <= 0) goto L36;
        r108 = true;
    L36:
        if (r108 == false) goto L38;
        r102 = r104;
    L38:
        if (r102 == null) goto L40;
        r112.setMsg(r102);     // Catch: Throwable -> L65
        goto L40
    L24:
        if (r103.length() <= 0) goto L26;
        boolean r115 = true;
    L27:
        if (r115 == false) goto L29;
        String r116 = r103;
    L30:
        if (r116 == null) goto L32;
        r112.setCode(r116);     // Catch: Throwable -> L65
        goto L32
    L29:
        r116 = null;
        goto L30
    L26:
        r115 = false;
        goto L27
    L20:
        r107 = "";
        goto L21
    L16:
        r106 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
    L65:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayOCRBankCardActivity#parsingOCRResponse", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRBankCardActivity#parsingOCRResponse", th);
        CJPayBankOCRLogger r117 = getLogger();
        if (r117 == null) goto L72;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r117, this.TAG, "parsingOCRResponse", "", "Parser error: " + th, null, 16, null);
        return;
    }

    public static final /* synthetic */ void access$parsingOCRResponse(CJPayOCRBankCardActivity r100, JSONObject r101, byte[] r102, boolean r103, OnceOCRResult r104) {
        r100.parsingOCRResponse(r101, r102, r103, r104);
    }

    public static /* synthetic */ void requestOCR$default(CJPayOCRBankCardActivity r100, byte[] r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.requestOCR(r101, r102, r103);
    }
}
