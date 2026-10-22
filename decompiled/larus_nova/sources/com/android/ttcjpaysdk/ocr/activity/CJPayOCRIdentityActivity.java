package com.android.ttcjpaysdk.ocr.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogBuilder;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ocr.CameraPreview;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.ocr.data.OCRScanData;
import com.android.ttcjpaysdk.ocr.data.OnceOCRResult;
import com.android.ttcjpaysdk.ocr.log.CJPayIdentityOCRLogger;
import com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger;
import com.android.ttcjpaysdk.ocr.presenter.OCRIDCardPresenter;
import com.android.ttcjpaysdk.ocr.utils.CJPayOCRRotateUtils;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.android.ttcjpaysdk.ocr.view.OCRCodeView;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
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
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00101\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00102\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020-H\u0002J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020-H\u0016J\b\u0010<\u001a\u00020-H\u0016J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0016J\b\u0010A\u001a\u00020 H\u0002J\b\u0010B\u001a\u00020-H\u0002J\b\u0010C\u001a\u00020-H\u0002J\"\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020-H\u0014J\u001c\u0010K\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J,\u0010L\u001a\u00020-2\b\u0010M\u001a\u0004\u0018\u00010\u00052\b\u0010N\u001a\u0004\u0018\u00010\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u0017H\u0002J\b\u0010Q\u001a\u00020-H\u0002J0\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020T2\u0006\u00109\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\u0017H\u0002J*\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\b\b\u0002\u0010Y\u001a\u00020 H\u0002J\b\u0010Z\u001a\u00020-H\u0002J\u001c\u0010[\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\\\u001a\u00020-J\u0010\u0010]\u001a\u00020-2\u0006\u0010^\u001a\u00020\fH\u0002J\b\u0010_\u001a\u00020-H\u0002J\b\u0010`\u001a\u00020-H\u0002J\b\u0010a\u001a\u00020-H\u0016J\u0010\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRIdentityActivity;", "Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRBaseActivity;", "Lcom/android/ttcjpaysdk/ocr/log/CJPayIdentityOCRLogger;", "()V", "ID_FRONT", "", "TAG", "albumView", "Landroid/widget/TextView;", "callbackCount", "", "choosePictureStartTime", "", "countDownStartTime", "executorService", "Ljava/util/concurrent/ExecutorService;", "iconRoot", "Landroid/widget/LinearLayout;", "insuranceTipsView", "Landroid/view/View;", "labelRoot", "Landroid/widget/RelativeLayout;", "lastOCRResult", "Lcom/android/ttcjpaysdk/ocr/data/OnceOCRResult;", "mCardInputType", "mConfirmDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mHandler", "Landroid/os/Handler;", "mIsFromAlbum", "", "mOCRPresenter", "Lcom/android/ttcjpaysdk/ocr/presenter/OCRIDCardPresenter;", "mOCRStartTime", "mPhotoType", "ocrType", "requestCount", "subTitle", "subTitleLayout", "subTitleView", "title", "titleView", "cameraError", "", "doCancel", "errorCode", "errorMsg", "doManual", "doPermissionGranted", "executeOCR", "scanData", "Lcom/android/ttcjpaysdk/ocr/data/OCRScanData;", "getLayout", "gotoAlbum", "handleAlbumPic", "data", "Landroid/content/Intent;", "initAction", "initData", "initScanView", "initView", "isActivityPortrait", "isFromAlbum", "isRotateRelayoutDegraded", "newInitScanView", "oldInitScanView", "onActivityResult", "requestCode", "resultCode", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "onOCRScanError", "onOCRScanSuccess", "idNameDecrypted", "idCodeDecrypted", "isOnce", "onceOCRResult", "onSizeChanged", "parsingOCRResponse", "json", "Lorg/json/JSONObject;", "", "photoType", "requestOCR", "result", "hasRetry", "resetParams", "showOCRErrorDialog", "showTimeoutDialog", "startCountDownTime", "time", "stopSpot", "updateView", "uploadOcrScanningPageImp", "uploadOrcScanningPageClick", "buttonName", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOCRIdentityActivity extends CJPayOCRBaseActivity<CJPayIdentityOCRLogger> {
    private final String ID_FRONT;
    private final String TAG;
    private TextView albumView;
    private int callbackCount;
    private long choosePictureStartTime;
    private long countDownStartTime;
    private ExecutorService executorService;
    private LinearLayout iconRoot;
    private View insuranceTipsView;
    private RelativeLayout labelRoot;
    private OnceOCRResult lastOCRResult;
    private int mCardInputType;
    private CJPayCommonDialog mConfirmDialog;
    private CountDownTimer mCountDownTimer;
    private final Handler mHandler;
    private boolean mIsFromAlbum;
    private OCRIDCardPresenter mOCRPresenter;
    private long mOCRStartTime;
    private String mPhotoType;
    public String ocrType;
    private int requestCount;
    public String subTitle;
    private LinearLayout subTitleLayout;
    private TextView subTitleView;
    public String title;
    private TextView titleView;

    public static /* synthetic */ void access$000(CJPayOCRBaseActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private final void cameraError() {
        showLoading(false);
        ICJPayServiceRetCallBack r100 = OCRDevice.getInstance().getCallBack();
        if (r100 == null) goto L5;
        r100.onResult(OCRCodeUtil.createIdentityResult("1", "", "", 0, "无法打开相机"), null);
    L5:
        CJPayBasicUtils.displayToastInternal(getActivity(), getString(R.string.cj_pay_camera_error_toast), 0, 17, 0, 0);
        CJPayIdentityOCRLogger r101 = getLogger();
        if (r101 == null) goto L8;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r101, this.TAG, "cameraError", "", getString(R.string.cj_pay_camera_error_toast), null, 16, null);
    L8:
        CJPayIdentityOCRLogger r102 = getLogger();
        if (r102 == null) goto L11;
        r102.logOCRResult("0", System.currentTimeMillis() - this.mOCRStartTime, 1, "", "无法打开相机", this.requestCount, this.callbackCount);
    L11:
        finish();
    }

    private final void resetParams() {
        this.requestCount = 0;
        this.callbackCount = 0;
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public int getLayout() {
        return R.layout.cj_pay_activity_identity_bindcard_ocr_scan;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final void gotoAlbum() {
        Intent r100 = new Intent("android.intent.action.GET_CONTENT");
        r100.setType("image/*");
        startActivityForResult(r100, CJPayOCRBankCardActivity.Companion.getALBUM_REQUEST_CODE());
        this.choosePictureStartTime = System.currentTimeMillis();
        this.mIsFromAlbum = true;
    }

    private final boolean isRotateRelayoutDegraded() {
        return CJPayOCRRotateUtils.isRotateRelayoutDegraded(this.ocrType);
    }

    private final void updateView() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        initScanView();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void showTimeoutDialog() {
        View.OnClickListener r100 = new CJPayOCRIdentityActivity$showTimeoutDialog$leftClickListener$1(this);
        CJPayDialogBuilder r101 = CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(getString(R.string.cj_pay_ocr_id_card_error_title)).setSubTitle(getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getString(R.string.cj_pay_ocr_error_leftbtn)).setRightBtnStr(getString(R.string.cj_pay_ocr_error_rightbtn)).setLeftBtnListener(r100).setRightBtnListener(new CJPayOCRIdentityActivity$showTimeoutDialog$rightClickListener$1(this)).setLeftBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue)).setRightBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue)).setSingleBtnColor(getResources().getColor(R.color.cj_pay_color_new_blue));
        boolean r102 = false;
        CJPayCommonDialog r103 = CJPayDialogUtils.initDialog(r101.setLeftBtnBold(false).setRightBtnBold(false).setSingleBtnBold(false).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
        this.mConfirmDialog = r103;
        if (r103 == null) goto L5;
        CJPayKotlinExtensionsKt.showSafely(r103, getActivity());
    L5:
        CJPayIdentityOCRLogger r104 = getLogger();
        if (r104 == null) goto L15;
        long r105 = System.currentTimeMillis() - this.mOCRStartTime;
        int r106 = this.mCardInputType;
        if (this.lastOCRResult.getMsg().length() != 0) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L12;
        String r107 = "超时识别失败";
    L13:
        r104.logOCRResult("0", r105, r106, "", r107, this.requestCount, this.callbackCount);
        return;
    L12:
        r107 = "超时识别失败--" + this.lastOCRResult.getMsg();
        goto L13
    }

    public CJPayOCRIdentityActivity() {
        this.mCardInputType = 1;
        this.mPhotoType = "";
        this.ID_FRONT = "id_photo_front";
        this.mHandler = new Handler();
        this.lastOCRResult = new OnceOCRResult(0, null, null, 0, 0, 0, 0, 127, null);
        this.TAG = "CJPayOCRIdentityActivity";
    }

    private final void initScanView() {
        if (isRotateRelayoutDegraded() == false) goto L5;
        oldInitScanView();
        return;
    L5:
        newInitScanView();
    }

    private final void newInitScanView() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L52;
        r100.setScanBoxText(getString(R.string.cj_pay_ocr_scanbox_identity_front_text));
        r100.setScanBoxTextSize(OCRCodeUtil.dp2px(getActivity(), 14.0f));
        int r101 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getActivity());
        int r102 = CJPayBasicUtils.getScreenHeight(getActivity());
        int r103 = CJPayOCRRotateUtils.getRealScreenSize(getActivity()).getFirst().intValue();
        int r104 = 0;
        if (r103 <= 0) goto L8;
        if (r102 > r103) goto L8;
        boolean r105 = true;
    L9:
        int r106 = Math.min(r101, r102) - (OCRCodeUtil.dp2px(getActivity(), 24.0f) * 2);
        if (r105 == false) goto L12;
        r106 = (int) (r106 * 0.5f);
    L12:
        int r107 = (int) ((((double) r106) * 212.0d) / 327.0d);
        if (r105 == false) goto L22;
        CameraPreview r108 = r100.getCameraPreview();
        if (r108 == null) goto L17;
        int r109 = r108.getHeight();
    L18:
        if (r109 > 0) goto L21;
        r109 = r102;
    L21:
        int r110 = (r109 - r107) / 2;
    L23:
        if (r105 == true) goto L26;
        r110 = ((r102 - OCRCodeUtil.dp2px(getActivity(), 44.0f)) - r107) / 2;
    L26:
        if (r106 <= 0) goto L29;
        if (r107 <= 0) goto L29;
        r100.setScanBoxSize(r106, r107);
    L29:
        if (r110 <= 0) goto L31;
        r100.setScanBoxTopOffset(r110);
    L31:
        int r111 = getStatusBarHeight();
        if (r105 == false) goto L34;
        r104 = OCRCodeUtil.dp2px(getActivity(), 8.0f);
    L34:
        int r112 = r111 + r104;
        setMarginTop(findViewById(R.id.back_view), OCRCodeUtil.dp2px(getActivity(), 9.0f), r112, 0, 0);
        setMarginTop(getMLightView(), 0, r112, OCRCodeUtil.dp2px(getActivity(), 12.0f), 0);
        TextView r113 = this.albumView;
        AppCompatActivity r114 = getActivity();
        if (r105 == false) goto L37;
        float r115 = 60.0f;
    L38:
        setMarginTop(r113, 0, 0, 0, OCRCodeUtil.dp2px(r114, r115));
        if (r105 == false) goto L41;
        int r116 = getStatusBarHeight() + OCRCodeUtil.dp2px(getActivity(), 48.0f);
    L42:
        int r117 = r116;
        AppCompatActivity r118 = getActivity();
        if (r105 == false) goto L45;
        int r119 = OCRCodeUtil.dp2px(r118, 35.0f) + r117;
    L46:
        int r120 = r119;
        AppCompatActivity r121 = getActivity();
        if (r105 == false) goto L49;
        int r122 = OCRCodeUtil.dp2px(r121, 12.0f);
    L50:
        setMarginTop(this.titleView, 0, r117, 0, 0);
        setMarginTop(this.subTitleLayout, OCRCodeUtil.dp2px(getActivity(), 24.0f), r120, OCRCodeUtil.dp2px(getActivity(), 24.0f), 0);
        setMarginTop(this.insuranceTipsView, 0, 0, 0, r122);
        r100.setImageCollectionListener(new CJPayOCRIdentityActivity$newInitScanView$1$1(this));
        r100.setOCRScanViewListener(new CJPayOCRIdentityActivity$newInitScanView$1$2(this));
        return;
    L49:
        r122 = OCRCodeUtil.dp2px(r121, 16.0f);
        goto L50
    L45:
        r119 = OCRCodeUtil.dp2px(r118, 139.0f);
        goto L46
    L41:
        r116 = OCRCodeUtil.dp2px(getActivity(), 104.0f);
        goto L42
    L37:
        r115 = 134.0f;
        goto L38
    L17:
        r109 = r100.getHeight();
        goto L18
    L22:
        r110 = 0;
    L8:
        r105 = false;
        goto L9
    }

    private final void oldInitScanView() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L6;
        r100.setScanBoxText(getString(R.string.cj_pay_ocr_scanbox_identity_front_text));
        r100.setScanBoxTextSize(OCRCodeUtil.dp2px(getActivity(), 14.0f));
        r100.setImageCollectionListener(new CJPayOCRIdentityActivity$oldInitScanView$1$1(this));
        r100.setOCRScanViewListener(new CJPayOCRIdentityActivity$oldInitScanView$1$2(this));
        return;
    }

    private final void onSizeChanged() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L5;
        Rect r101 = r100.getScanBoxRect();
    L6:
        if (r101 == null) goto L9;
        RelativeLayout r102 = this.labelRoot;
        int r103 = r101.left;
        int r104 = OCRCodeUtil.dp2px(getActivity(), 28.0f) + r103;
        int r105 = r101.top;
        setMarginTop(r102, r104, OCRCodeUtil.dp2px(getActivity(), 40.0f) + r105, (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getActivity()) - r101.right) + OCRCodeUtil.dp2px(getActivity(), 28.0f), 0);
        setMarginTop(this.iconRoot, 0, r101.bottom + OCRCodeUtil.dp2px(getActivity(), 88.0f), 0, 0);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void stopSpot() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L5;
        r100.stopSpot();
    L5:
        OCRIDCardPresenter r101 = this.mOCRPresenter;
        if (r101 == null) goto L9;
        r101.cancelRequest();
        return;
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__onDestroy$___twin___() {
        super.onDestroy();
        ExecutorService r100 = this.executorService;
        if (r100 == null) goto L5;
        r100.shutdown();
    L5:
        CountDownTimer r101 = this.mCountDownTimer;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doPermissionGranted() {
        super.doPermissionGranted();
        startCountDownTime(30);
        this.countDownStartTime = System.currentTimeMillis();
        CJPayIdentityOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.walletAddbcardOrcScanningIdcardStart();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initAction() {
        super.initAction();
        TextView r100 = this.albumView;
        if (r100 == null) goto L6;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new C93041(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initData() {
        this.mOCRStartTime = System.currentTimeMillis();
        this.executorService = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CJPayOCRIdentityActivity"));
        this.mOCRPresenter = new OCRIDCardPresenter();
        this.mPhotoType = this.ID_FRONT;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initView() {
        super.initView();
        this.albumView = (TextView) findViewById(R.id.album_view);
        AppCompatActivity r100 = getActivity();
        boolean r101 = false;
        String r102 = null;
        if (r100 == null) goto L11;
        Resources r103 = r100.getResources();
        if (r103 == null) goto L11;
        Drawable r104 = r103.getDrawable(R.drawable.cj_pay_ocr_album_icon);
        if (r104 == null) goto L11;
        r104.setBounds(0, 0, CJPayBasicExtensionKt.dp(24), CJPayBasicExtensionKt.dp(24));
        TextView r105 = this.albumView;
        if (r105 == null) goto L11;
        r105.setCompoundDrawables(r104, null, null, null);
    L11:
        this.titleView = (TextView) findViewById(R.id.cj_pay_ocr_title);
        this.subTitleLayout = (LinearLayout) findViewById(R.id.cj_pay_ocr_subtitle);
        this.subTitleView = (TextView) findViewById(R.id.cj_pay_ocr_subtitle_black_text);
        this.insuranceTipsView = findViewById(R.id.bottom_insurance_view);
        TextView r106 = this.titleView;
        if (r106 == null) goto L27;
        String r107 = this.title;
        if (r107 != null) goto L17;
    L25:
        r107 = getString(R.string.cj_pay_ocr_scan_id_card_title);
    L26:
        r106.setText(r107);
        goto L27
    L17:
        if (r107.length() <= 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L23;
        r107 = null;
    L23:
        if (r107 == null) goto L25;
    L19:
        r108 = false;
    L27:
        TextView r109 = this.subTitleView;
        if (r109 == null) goto L41;
        String r110 = this.subTitle;
        if (r110 != null) goto L33;
    L39:
        r102 = getString(R.string.cj_pay_ocr_safety_subtitle);
    L40:
        r109.setText(r102);
        goto L41
    L33:
        if (r110.length() <= 0) goto L35;
        r101 = true;
    L35:
        if (r101 == false) goto L37;
        r102 = r110;
    L37:
        if (r102 == null) goto L39;
    L41:
        initScanView();
        setLoadingMsg(getString(R.string.cj_pay_ocr_upload_loading));
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        return isRotateRelayoutDegraded();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOcrScanningPageImp() {
        CJPayIdentityOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.logPageShow();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public boolean isFromAlbum() {
        return this.mIsFromAlbum;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ void access$cameraError(CJPayOCRIdentityActivity r100) {
        r100.cameraError();
    }

    public static final /* synthetic */ int access$getCallbackCount$p(CJPayOCRIdentityActivity r100) {
        return r100.callbackCount;
    }

    public static final /* synthetic */ long access$getCountDownStartTime$p(CJPayOCRIdentityActivity r100) {
        return r100.countDownStartTime;
    }

    public static final /* synthetic */ String access$getID_FRONT$p(CJPayOCRIdentityActivity r100) {
        return r100.ID_FRONT;
    }

    public static final /* synthetic */ int access$getMCardInputType$p(CJPayOCRIdentityActivity r100) {
        return r100.mCardInputType;
    }

    public static final /* synthetic */ CJPayCommonDialog access$getMConfirmDialog$p(CJPayOCRIdentityActivity r100) {
        return r100.mConfirmDialog;
    }

    public static final /* synthetic */ CountDownTimer access$getMCountDownTimer$p(CJPayOCRIdentityActivity r100) {
        return r100.mCountDownTimer;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(CJPayOCRIdentityActivity r100) {
        return r100.mHandler;
    }

    public static final /* synthetic */ String access$getMPhotoType$p(CJPayOCRIdentityActivity r100) {
        return r100.mPhotoType;
    }

    public static final /* synthetic */ String access$getTAG$p(CJPayOCRIdentityActivity r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ void access$gotoAlbum(CJPayOCRIdentityActivity r100) {
        r100.gotoAlbum();
    }

    public static final /* synthetic */ void access$onSizeChanged(CJPayOCRIdentityActivity r100) {
        r100.onSizeChanged();
    }

    public static final /* synthetic */ void access$resetParams(CJPayOCRIdentityActivity r100) {
        r100.resetParams();
    }

    public static final /* synthetic */ void access$stopSpot(CJPayOCRIdentityActivity r100) {
        r100.stopSpot();
    }

    public static final /* synthetic */ void access$updateView(CJPayOCRIdentityActivity r100) {
        r100.updateView();
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayOCRIdentityActivity r100) {
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayOCRIdentityActivity r110) {
        r110.com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CJPayOCRIdentityActivity.class.getName()));
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

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayOCRIdentityActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private final void executeOCR(final OCRScanData r100) {
        CJPayKotlinExtensionsKt.executeSafely(this.executorService, new AnonymousClass1(this, r100));
    }

    private final void handleAlbumPic(final Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        showLoading(true);
        CJPayKotlinExtensionsKt.executeSafely(this.executorService, new C93031(r100, this));
    }

    private final void startCountDownTime(long r100) {
        final long r101 = r100 * ((long) 1000);
        CountDownTimer r102 = new CountDownTimerC93071(this, r101);
        this.mCountDownTimer = r102;
        r102.start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        OCRCodeView r101 = getOCRCodeView();
        if (r101 == null) goto L6;
        r101.post(new RunnableC93051(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOrcScanningPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        CJPayIdentityOCRLogger r101 = getLogger();
        if (r101 == null) goto L6;
        r101.logPageClick(r100);
        return;
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRIdentityActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(CJPayOCRBaseActivity r100, Configuration r101) {
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

    public static final /* synthetic */ void access$executeOCR(CJPayOCRIdentityActivity r100, OCRScanData r101) {
        r100.executeOCR(r101);
    }

    public static final /* synthetic */ void access$setCallbackCount$p(CJPayOCRIdentityActivity r100, int r101) {
        r100.callbackCount = r101;
    }

    public static final /* synthetic */ void access$setCountDownStartTime$p(CJPayOCRIdentityActivity r100, long r101) {
        r100.countDownStartTime = r101;
    }

    private final void doManual(String r100, String r101) {
        ICJPayServiceRetCallBack r102 = OCRDevice.getInstance().getCallBack();
        if (r102 != null) goto L5;
    L8:
        resetParams();
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.onResult(OCRCodeUtil.createIdentityResult("2", "", "", 0, r101), null);
        goto L8
    }

    private final void onOCRScanError(String r100, String r101) {
        showLoading(false);
        stopSpot();
        showOCRErrorDialog(r100, r101);
        this.mCardInputType = 2;
        CJPayIdentityOCRLogger r102 = getLogger();
        if (r102 == null) goto L6;
        r102.walletIDOrcScanningFailPopImp(this.mCardInputType, r100, r101);
        return;
    }

    private final void showOCRErrorDialog(final String r110, final String r111) {
        View.OnClickListener r100 = new CJPayOCRIdentityActivity$showOCRErrorDialog$leftClickListener$1(this, r110, r111);
        View.OnClickListener r101 = new CJPayOCRIdentityActivity$showOCRErrorDialog$rightClickListener$1(this, r110, r111);
        CJPayCommonDialog r102 = CJPayDialogUtils.initDialog(CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(getString(R.string.cj_pay_ocr_id_card_error_title_for_album)).setSubTitle(getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getString(R.string.cj_pay_ocr_error_leftbtn_for_album)).setRightBtnStr(getString(R.string.cj_pay_ocr_error_rightbtn)).setLeftBtnListener(r100).setRightBtnListener(r101).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
        this.mConfirmDialog = r102;
        if (r102 == null) goto L5;
        CJPayKotlinExtensionsKt.showSafely(r102, getActivity());
    L5:
        CJPayIdentityOCRLogger r103 = getLogger();
        if (r103 == null) goto L9;
        r103.logOCRResult("0", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, r110, r111, this.requestCount, this.callbackCount);
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doCancel(String r110, String r111) {
        if (this.lastOCRResult.getMsg().length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        r111 = r111 + HttpClient.ENDFLAG + this.lastOCRResult.getMsg();
    L9:
        String r101 = r111;
        ICJPayServiceRetCallBack r112 = OCRDevice.getInstance().getCallBack();
        if (r112 == null) goto L12;
        r112.onResult(OCRCodeUtil.createIdentityResult("1", "", "", 0, r101), null);
    L12:
        CJPayIdentityOCRLogger r102 = getLogger();
        if (r102 == null) goto L15;
        r102.logOCRResult("0", System.currentTimeMillis() - this.mOCRStartTime, this.mCardInputType, r110, r101, this.requestCount, this.callbackCount);
    L15:
        resetParams();
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static final /* synthetic */ void access$doManual(CJPayOCRIdentityActivity r100, String r101, String r102) {
        r100.doManual(r101, r102);
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
        CJPayIdentityOCRLogger r107 = getLogger();
        if (r107 == null) goto L26;
        long r108 = System.currentTimeMillis() - this.choosePictureStartTime;
        if (r101 == (-1)) goto L24;
        r103 = 0;
    L24:
        r107.walletAddbcardOrcScanningIdcardPhotoBack(r108, r103);
        return;
    L26:
        return;
    L16:
        if (r100 != CJPayOCRBankCardActivity.Companion.getALBUM_REQUEST_CODE()) goto L18;
        handleAlbumPic(r102);
        goto L18
    }

    private final void onOCRScanSuccess(String r110, String r111, boolean r112, OnceOCRResult r113) {
        showLoading(false);
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L23:
        r113.setResult(0);
        String r114 = "OCR姓名格式错误";
        if (TextUtils.isEmpty(r110) == false) goto L26;
        String r115 = "OCR姓名格式错误";
    L27:
        r113.setMsg(r115);
        if (TextUtils.isEmpty(r110) == true) goto L31;
        r114 = "OCR身份证号码格式";
    L31:
        onOCRScanError("", r114);
        return;
    L26:
        r115 = "OCR身份证号码格式错误";
        goto L27
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L23;
        if (this.requestCount >= this.callbackCount) goto L10;
        return;
    L10:
        if (r112 == true) goto L12;
        int r100 = 1;
    L13:
        ICJPayServiceRetCallBack r116 = OCRDevice.getInstance().getCallBack();
        if (r116 == null) goto L16;
        r116.onResult(OCRCodeUtil.createIdentityResult("0", r110, r111, r100, r113.getMsg()), null);
    L16:
        OCRIDCardPresenter r117 = this.mOCRPresenter;
        if (r117 == null) goto L19;
        r117.cancelRequest();
    L19:
        r113.setResult(1);
        CJPayIdentityOCRLogger r101 = getLogger();
        if (r101 == null) goto L22;
        r101.logOCRResult("1", System.currentTimeMillis() - this.mOCRStartTime, r100, r113.getCode(), r113.getMsg(), this.requestCount, this.callbackCount);
    L22:
        resetParams();
        finish();
        return;
    L12:
        r100 = 2;
        goto L13
    }

    private final void requestOCR(final byte[] r210, final String r211, final boolean r212, final boolean r213) {
        this.requestCount++;
        final long r100 = System.currentTimeMillis();
        final OnceOCRResult r101 = new OnceOCRResult(0, null, null, 0, 0, 0, 0, 127, null);
        final Function0<Unit> r102 = new CJPayOCRIdentityActivity$requestOCR$updateOCRResult$1(r101, r210, r212, this, r100);
        OCRIDCardPresenter r110 = this.mOCRPresenter;
        if (r110 == null) goto L7;
        if (r110 == null) goto L8;
        OCRIDCardPresenter.fetchOCRResult$default(r110, "ID_CARD", r210, new C93061(r102, this, r210, r211, r212, r101, r213), false, 8, null);
        return;
    L8:
        return;
    }

    public static final /* synthetic */ void access$requestOCR(CJPayOCRIdentityActivity r100, byte[] r101, String r102, boolean r103, boolean r104) {
        r100.requestOCR(r101, r102, r103, r104);
    }

    private final void parsingOCRResponse(JSONObject r110, byte[] r111, String r112, boolean r113, final OnceOCRResult r114) {
        JSONObject r115 = r110.optJSONObject("response");     // Catch: Throwable -> L63
        String r116 = null;
        if (r115 == null) goto L5;
        final String r100 = r115.optString("code");     // Catch: Throwable -> L63
    L6:
        if (r115 == null) goto L9;
        String r101 = r115.optString("msg");     // Catch: Throwable -> L63
    L11:
        if (r115 == null) goto L14;
        String r102 = r115.optString("id_name");     // Catch: Throwable -> L63
    L16:
        if (r115 == null) goto L18;
        String r117 = r115.optString("id_code");     // Catch: Throwable -> L63
    L20:
        final String r103 = "";
        if (TextUtils.isEmpty(r102) == true) goto L23;
        final String r104 = CJPayEncryptHelper.Companion.getDecryptDataSM(CJEncryptScene.OCR, r102, "ocr-idCard", "id_name");     // Catch: Throwable -> L63
    L25:
        if (TextUtils.isEmpty(r117) == true) goto L27;
        r103 = CJPayEncryptHelper.Companion.getDecryptDataSM(CJEncryptScene.OCR, r117, "ocr-idCard", "id_code");     // Catch: Throwable -> L63
    L27:
        boolean r118 = true;
        if (r100 != null) goto L30;
    L38:
        if (r101 != null) goto L40;
    L47:
        Function0<Unit> r119 = new CJPayOCRIdentityActivity$parsingOCRResponse$successBadCase$1(r100, r104, r114, r103);     // Catch: Throwable -> L63
        if (Intrinsics.areEqual("MP000000", r100) == true) goto L50;
    L56:
        if (r113 == false) goto L58;
        r119.invoke();     // Catch: Throwable -> L63
        onOCRScanError(r100, r114.getMsg());     // Catch: Throwable -> L63
    L59:
        this.lastOCRResult = r114;     // Catch: Throwable -> L63
        CJPayIdentityOCRLogger r120 = getLogger();     // Catch: Throwable -> L63
        if (r120 == null) goto L70;
        r120.walletAddbcardOrcScanningSingleIdcardresult(r114);     // Catch: Throwable -> L63
        return;
    L70:
        return;
    L58:
        r119.invoke();     // Catch: Throwable -> L63
        goto L59
    L50:
        if (Intrinsics.areEqual(r112, this.mPhotoType) == false) goto L56;
        if (TextUtils.isEmpty(r104) == true) goto L56;
        if (TextUtils.isEmpty(r103) == true) goto L56;
        onOCRScanSuccess(r104, r103, r113, r114);     // Catch: Throwable -> L63
        goto L59
    L40:
        if (r101.length() > 0) goto L43;
        r118 = false;
    L43:
        if (r118 == false) goto L45;
        r116 = r101;
    L45:
        if (r116 == null) goto L47;
        r114.setMsg(r116);     // Catch: Throwable -> L63
        goto L47
    L30:
        if (r100.length() <= 0) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L35;
        String r106 = r100;
    L36:
        if (r106 == null) goto L38;
        r114.setCode(r106);     // Catch: Throwable -> L63
        goto L38
    L35:
        r106 = null;
        goto L36
    L32:
        r105 = false;
        goto L33
    L23:
        r104 = "";
        goto L25
    L18:
        r117 = null;
        goto L20
    L14:
        r102 = null;
        goto L16
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
    L63:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayOCRIdentityActivity#parsingOCRResponse", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRIdentityActivity#parsingOCRResponse", th);
        CJPayIdentityOCRLogger r107 = getLogger();
        if (r107 == null) goto L71;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r107, this.TAG, "parsingOCRResponse", "", "Parser error: " + th, null, 16, null);
        return;
    }

    public static final /* synthetic */ void access$parsingOCRResponse(CJPayOCRIdentityActivity r100, JSONObject r101, byte[] r102, String r103, boolean r104, OnceOCRResult r105) {
        r100.parsingOCRResponse(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void requestOCR$default(CJPayOCRIdentityActivity r100, byte[] r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = false;
    L5:
        r100.requestOCR(r101, r102, r103, r104);
    }
}
