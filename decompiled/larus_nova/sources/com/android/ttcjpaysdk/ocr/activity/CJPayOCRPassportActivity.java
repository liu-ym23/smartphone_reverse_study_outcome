package com.android.ttcjpaysdk.ocr.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ocr.CameraPreview;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.ocr.data.CJPayOCRPassportBean;
import com.android.ttcjpaysdk.ocr.data.PassportOcrInfo;
import com.android.ttcjpaysdk.ocr.log.CJPayOCRMvpLogger;
import com.android.ttcjpaysdk.ocr.log.CJPayPassportOCRLogger;
import com.android.ttcjpaysdk.ocr.presenter.OCRPassportPresenter;
import com.android.ttcjpaysdk.ocr.utils.CJPayOCRRotateUtils;
import com.android.ttcjpaysdk.ocr.utils.OCRCodeUtil;
import com.android.ttcjpaysdk.ocr.view.OCRCodeView;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\u001a\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0005H\u0002J\u001c\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\"H\u0016J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\b\u0010.\u001a\u00020\u001eH\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\b\u00107\u001a\u00020\u001eH\u0002J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020\u001eH\u0002J\b\u0010D\u001a\u00020\u001eH\u0016J\u0010\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRPassportActivity;", "Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRBaseActivity;", "Lcom/android/ttcjpaysdk/ocr/log/CJPayPassportOCRLogger;", "()V", "cameraErrorText", "", "idIndicatorView", "Landroid/widget/ImageView;", "idLabelView", "idMaskView", "isZhLanguage", "", "needShowPermissionTips", "getNeedShowPermissionTips", "()Z", "setNeedShowPermissionTips", "(Z)V", "netErrorText", "ocrPresenter", "Lcom/android/ttcjpaysdk/ocr/presenter/OCRPassportPresenter;", "ocrScanTipsView", "Landroid/widget/TextView;", "ocrType", "scanTipsText", "takePhotoBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "takePhotoText", "uploadSuccessText", "uploadingText", "applyLandscapeOverlayByScanRect", "", "scanRectInRoot", "Landroid/graphics/Rect;", "rootWidth", "", "applyPortraitOverlayByScanRect", "cameraError", "createResult", "code", "data", "doCancel", "errorCode", "errorMsg", "doPermissionGranted", "getLayout", "getScanBoxRectInRootOrNull", "initAction", "initChOrEnText", "initData", "initScanView", "initView", "isActivityPortrait", "isRotateRelayoutDegraded", "isZHLang", "newInitScanView", "oldInitScanView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "parsingOCRResponse", "json", "Lorg/json/JSONObject;", "requestOCR", "result", "", "photoType", "requestPhotoOCR", "updateView", "uploadOcrScanningPageImp", "uploadOrcScanningPageClick", "buttonName", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOCRPassportActivity extends CJPayOCRBaseActivity<CJPayPassportOCRLogger> {
    private static final int COMPRESS_DEFAULT_SIZE = 150;
    public static final Companion Companion = null;
    private static final String PHOTO_TYPE = "id_photo_front";
    private static final String TAG = "CJPayOCRPassportActivity";
    private String cameraErrorText;
    private ImageView idIndicatorView;
    private ImageView idLabelView;
    private ImageView idMaskView;
    private boolean isZhLanguage;
    private boolean needShowPermissionTips;
    private String netErrorText;
    private OCRPassportPresenter ocrPresenter;
    private TextView ocrScanTipsView;
    public String ocrType;
    private String scanTipsText;
    private CJPayCustomButton takePhotoBtn;
    private String takePhotoText;
    private String uploadSuccessText;
    private String uploadingText;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/activity/CJPayOCRPassportActivity$Companion;", "", "()V", "COMPRESS_DEFAULT_SIZE", "", "PHOTO_TYPE", "", "TAG", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public static /* synthetic */ void access$000(CJPayOCRBaseActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private final void cameraError() {
        showLoading(false);
        String r100 = this.cameraErrorText;
        CJPayBasicUtils.displayToastInternal(this, r100, 0, 17, 0, 0);
        CJPayPassportOCRLogger r101 = getLogger();
        if (r101 == null) goto L5;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r101, TAG, "cameraError", "", r100, null, 16, null);
    L5:
        getActivity().finish();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public int getLayout() {
        return R.layout.cj_pay_activity_passport_ocr_scan;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final boolean isRotateRelayoutDegraded() {
        return CJPayOCRRotateUtils.isRotateRelayoutDegraded(this.ocrType);
    }

    private final boolean isZHLang() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r100 = Resources.getSystem().getConfiguration().getLocales().get(0);
    L6:
        if (r100 != null) goto L9;
        r100 = Locale.ENGLISH;
    L9:
        return StringsKt.contains(r100.getLanguage(), "zh", true);
    L5:
        r100 = Resources.getSystem().getConfiguration().locale;
        goto L6
    }

    private final void newInitScanView() {
        final OCRCodeView r100 = getOCRCodeView();
        if (r100 != null) goto L5;
        return;
    L5:
        final View r110 = findViewById(R.id.tt_cj_pay_ocr_id_rootview);
        r100.setVisibility(4);
        r100.setScanBoxText("");
        r100.setScanBoxTextSize(OCRCodeUtil.dp2px(getActivity(), 14.0f));
        final int r101 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getActivity());
        final int r102 = CJPayBasicUtils.getScreenHeight(getActivity());
        int r103 = CJPayOCRRotateUtils.getRealScreenSize(getActivity()).getFirst().intValue();
        if (r103 <= 0) goto L9;
        if (r102 > r103) goto L9;
        boolean r104 = true;
    L10:
        RelativeLayout.LayoutParams r111 = null;
        if (r104 == false) goto L42;
        final int r112 = (int) ((Math.min(r101, r102) - (OCRCodeUtil.dp2px(getActivity(), 24.0f) * 2)) * 0.5f);
        final int r113 = (int) ((((double) r112) * 240.0d) / 327.0d);
        CameraPreview r105 = r100.getCameraPreview();
        if (r105 == null) goto L15;
        int r106 = r105.getHeight();
    L16:
        if (r106 > 0) goto L19;
        r106 = r102;
    L19:
        int r107 = RangesKt.coerceAtLeast((r106 - r113) / 2, 0);
        if (r112 <= 0) goto L23;
        if (r113 <= 0) goto L23;
        r100.setScanBoxSize(r112, r113);
    L23:
        r100.setScanBoxTopOffset(r107);
        int r114 = getStatusBarHeight() + OCRCodeUtil.dp2px(getActivity(), 8.0f);
        setMarginTop(findViewById(R.id.back_view), OCRCodeUtil.dp2px(getActivity(), 9.0f), r114, 0, 0);
        setMarginTop(getMLightView(), 0, r114, OCRCodeUtil.dp2px(getActivity(), 12.0f), 0);
        CJPayCustomButton r108 = this.takePhotoBtn;
        if (r108 == null) goto L26;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L28:
        if ((r109 instanceof RelativeLayout.LayoutParams) == false) goto L30;
        r111 = (RelativeLayout.LayoutParams) r109;
    L30:
        RelativeLayout.LayoutParams r115 = r111;
        if (r115 == null) goto L40;
        int r116 = Math.min(r101 - OCRCodeUtil.dp2px(getActivity(), 200.0f), OCRCodeUtil.dp2px(getActivity(), 360.0f));
        if (r116 > 0) goto L36;
        r116 = -1;
    L36:
        r115.width = r116;
        r115.leftMargin = 0;
        r115.rightMargin = 0;
        r115.bottomMargin = OCRCodeUtil.dp2px(getActivity(), 76.0f);
        r115.addRule(14);
        CJPayCustomButton r117 = this.takePhotoBtn;
        if (r117 == null) goto L40;
        r117.setLayoutParams(r115);
    L40:
        r110.post(new AnonymousClass3(this, r110, r101, r102, r112, r113, r100));
        return;
    L26:
        r109 = null;
        goto L28
    L15:
        r106 = r100.getHeight();
        goto L16
    L42:
        int r118 = r101 - (OCRCodeUtil.dp2px(getActivity(), 24.0f) * 2);
        final int r119 = (int) ((((double) r118) * 240.0d) / 327.0d);
        final int r120 = RangesKt.coerceAtLeast((r101 - r118) / 2, 0);
        final int r121 = r120 + r118;
        final int r122 = OCRCodeUtil.dp2px(getActivity(), 132.0f);
        r100.setScanBoxSize(r118, r119);
        r100.setScanBoxTopOffset(r122);
        setMarginTop(findViewById(R.id.back_view), OCRCodeUtil.dp2px(getActivity(), 9.0f), getStatusBarHeight(), 0, 0);
        setMarginTop(getMLightView(), 0, getStatusBarHeight(), OCRCodeUtil.dp2px(getActivity(), 12.0f), 0);
        setMarginTop(this.idLabelView, OCRCodeUtil.dp2px(getActivity(), 40.0f), OCRCodeUtil.dp2px(getActivity(), 191.0f), 0, 0);
        CJPayCustomButton r123 = this.takePhotoBtn;
        if (r123 == null) goto L45;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
    L47:
        if ((r124 instanceof RelativeLayout.LayoutParams) == false) goto L49;
        r111 = (RelativeLayout.LayoutParams) r124;
    L49:
        RelativeLayout.LayoutParams r125 = r111;
        if (r125 == null) goto L55;
        r125.width = -1;
        r125.leftMargin = OCRCodeUtil.dp2px(getActivity(), 24.0f);
        r125.rightMargin = OCRCodeUtil.dp2px(getActivity(), 24.0f);
        r125.bottomMargin = OCRCodeUtil.dp2px(getActivity(), 76.0f);
        r125.addRule(14);
        CJPayCustomButton r126 = this.takePhotoBtn;
        if (r126 == null) goto L55;
        r126.setLayoutParams(r125);
    L55:
        r110.post(new AnonymousClass5(this, r110, r101, r120, r122, r121, r119, r100));
        return;
    L45:
        r124 = null;
    L9:
        r104 = false;
        goto L10
    }

    private final void updateView() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        if (isRotateRelayoutDegraded() == false) goto L5;
        initScanView();     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L5:
        initScanView();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public CJPayOCRPassportActivity() {
        this.isZhLanguage = true;
        this.uploadingText = "";
        this.scanTipsText = "";
        this.takePhotoText = "";
        this.cameraErrorText = "";
        this.netErrorText = "";
        this.uploadSuccessText = "";
    }

    private final Rect getScanBoxRectInRootOrNull() {
        View r100 = findViewById(R.id.tt_cj_pay_ocr_id_rootview);
        OCRCodeView r101 = getOCRCodeView();
        if (r101 == null) goto L5;
        Rect r102 = r101.getScanBoxRectRelativeTo(r100);
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.width() > 0) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == true) goto L15;
        return null;
    L15:
        return r102;
    L10:
        if (r102.height() <= 0) goto L12;
        r103 = true;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    private final void initScanView() {
        if (isRotateRelayoutDegraded() == false) goto L5;
        oldInitScanView();
        return;
    L5:
        newInitScanView();
    }

    private final void oldInitScanView() {
        OCRCodeView r100 = getOCRCodeView();
        if (r100 == null) goto L6;
        r100.setScanBoxText("");
        r100.setScanBoxTextSize(OCRCodeUtil.dp2px(getActivity(), 14.0f));
        r100.setScanBoxSize(CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getActivity()) - (OCRCodeUtil.dp2px(getActivity(), 24.0f) * 2), OCRCodeUtil.dp2px(getActivity(), 240.0f));
        r100.setScanBoxTopOffset(OCRCodeUtil.dp2px(getActivity(), 132.0f));
        r100.setVisibility(0);
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doPermissionGranted() {
        super.doPermissionGranted();
        ImageView r100 = this.idIndicatorView;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initAction() {
        super.initAction();
        CJPayCustomButton r100 = this.takePhotoBtn;
        if (r100 == null) goto L6;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new AnonymousClass1(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initChOrEnText() {
        boolean r100 = isZHLang();
        this.isZhLanguage = r100;
        if (r100 == false) goto L5;
        super.initChOrEnText();
        this.uploadingText = getString(R.string.cj_pay_ocr_passport_uploading);
        this.scanTipsText = getString(R.string.cj_pay_ocr_passport_tips);
        this.takePhotoText = getString(R.string.cj_pay_ocr_passport_btn);
        this.cameraErrorText = getString(R.string.cj_pay_ocr_passport_camera_error);
        this.netErrorText = getString(R.string.cj_pay_ocr_passport_network_error);
        this.uploadSuccessText = getString(R.string.cj_pay_ocr_passport_upload_success);
        return;
    L5:
        this.uploadingText = getString(R.string.cj_pay_ocr_passport_uploading_en);
        this.scanTipsText = getString(R.string.cj_pay_ocr_passport_tips_en);
        this.takePhotoText = getString(R.string.cj_pay_ocr_passport_btn_en);
        this.cameraErrorText = getString(R.string.cj_pay_ocr_passport_camera_error_en);
        this.netErrorText = getString(R.string.cj_pay_ocr_passport_network_error_en);
        this.uploadSuccessText = getString(R.string.cj_pay_ocr_passport_upload_success_en);
        setCameraErrorToastText(getString(R.string.cj_pay_camera_error_toast_en));
        setPermissionTitleText(getString(R.string.cj_pay_permission_title_en));
        setPermissionLeftBtnText(getString(R.string.cj_pay_permission_leftbtn_en));
        setPermissionRightBtnText(getString(R.string.cj_pay_permission_rightbtn_en));
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initData() {
        super.initData();
        setLoadingMsg(this.uploadingText);
        TextView r100 = this.ocrScanTipsView;
        if (r100 == null) goto L6;
        r100.setText(this.scanTipsText);
    L6:
        CJPayCustomButton r101 = this.takePhotoBtn;
        if (r101 == null) goto L10;
        r101.setText(this.takePhotoText);
    L10:
        this.ocrPresenter = new OCRPassportPresenter();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void initView() {
        super.initView();
        this.idIndicatorView = (ImageView) findViewById(R.id.passport_id_indicator);
        this.idMaskView = (ImageView) findViewById(R.id.passport_id_mask);
        this.idLabelView = (ImageView) findViewById(R.id.passport_identity_label_view);
        this.ocrScanTipsView = (TextView) findViewById(R.id.passport_tips);
        this.takePhotoBtn = (CJPayCustomButton) findViewById(R.id.take_photo_button);
        initScanView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        return isRotateRelayoutDegraded();
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOcrScanningPageImp() {
        CJPayPassportOCRLogger r100 = getLogger();
        if (r100 == null) goto L6;
        r100.logPassportOCRImp();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public boolean getNeedShowPermissionTips() {
        return this.needShowPermissionTips;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ void access$cameraError(CJPayOCRPassportActivity r100) {
        r100.cameraError();
    }

    public static final /* synthetic */ String access$getNetErrorText$p(CJPayOCRPassportActivity r100) {
        return r100.netErrorText;
    }

    public static final /* synthetic */ Rect access$getScanBoxRectInRootOrNull(CJPayOCRPassportActivity r100) {
        return r100.getScanBoxRectInRootOrNull();
    }

    public static final /* synthetic */ CJPayCustomButton access$getTakePhotoBtn$p(CJPayOCRPassportActivity r100) {
        return r100.takePhotoBtn;
    }

    public static final /* synthetic */ void access$updateView(CJPayOCRPassportActivity r100) {
        r100.updateView();
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayOCRPassportActivity r100) {
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayOCRPassportActivity r110) {
        r110.com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CJPayOCRPassportActivity.class.getName()));
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

    public static void com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayOCRPassportActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private final void parsingOCRResponse(JSONObject r110) {
        boolean r100 = false;
        showLoading(false);     // Catch: Throwable -> L48
        CJPayCustomButton r101 = this.takePhotoBtn;     // Catch: Throwable -> L48
        if (r101 == null) goto L7;
        r101.setEnabled(true);     // Catch: Throwable -> L48
    L7:
        JSONObject r111 = r110.optJSONObject("response");     // Catch: Throwable -> L48
        if (r111 != null) goto L14;
        String r112 = this.netErrorText;     // Catch: Throwable -> L48
        CJPayBasicUtils.displayToastInternal(getActivity(), r112, 0, 17, 0, 0);     // Catch: Throwable -> L48
        CJPayPassportOCRLogger r102 = getLogger();     // Catch: Throwable -> L48
        if (r102 == null) goto L54;
        r102.logPassportOCRUploadClick(NewBroadcastMonitor.CAPTURE.FRONT, "0", r112);     // Catch: Throwable -> L48
        return;
    L54:
        return;
    L14:
        CJPayOCRPassportBean r113 = (CJPayOCRPassportBean) CJPayJsonParser.fromJson(r111, CJPayOCRPassportBean.class);     // Catch: Throwable -> L48
        if (r113 != null) goto L17;
    L19:
        boolean r103 = false;
    L20:
        String r104 = null;
        if (r103 == true) goto L23;
        if (r113 == null) goto L44;
        String r114 = r113.msg;     // Catch: Throwable -> L48
        if (r114 == null) goto L44;
        r104 = KtSafeMethodExtensionKt.ifNullOrBlank(r114, new CJPayOCRPassportActivity$parsingOCRResponse$errorMsg$2(this));     // Catch: Throwable -> L48
    L44:
        String r115 = r104;
        CJPayBasicUtils.displayToastInternal(getActivity(), r115, 0, 17, 0, 0);     // Catch: Throwable -> L48
        CJPayPassportOCRLogger r105 = getLogger();     // Catch: Throwable -> L48
        if (r105 == null) goto L57;
        r105.logPassportOCRUploadClick(NewBroadcastMonitor.CAPTURE.FRONT, "0", r115);     // Catch: Throwable -> L48
        return;
    L57:
        return;
    L23:
        if (getActivity().isFinishing() == true) goto L37;
        String r106 = r113.msg;     // Catch: Throwable -> L48
        if (r106.length() != 0) goto L27;
        r100 = true;
    L27:
        if (r100 == false) goto L29;
        r106 = this.uploadSuccessText;     // Catch: Throwable -> L48
    L29:
        CJPayBasicUtils.displayToastInternal(getActivity(), r106, 0, 17, 0, 0);     // Catch: Throwable -> L48
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L48
        KtSafeMethodExtensionKt.safePut(r107, "flow_no", r113.flow_no);     // Catch: Throwable -> L48
        KtSafeMethodExtensionKt.safePut(r107, "member_biz_order_no", r113.member_biz_order_no);     // Catch: Throwable -> L48
        KtSafeMethodExtensionKt.safePut(r107, "hit_ps_process", r113.hit_ps_process);     // Catch: Throwable -> L48
        KtSafeMethodExtensionKt.safePut(r107, "need_double_verify", Boolean.valueOf(r113.need_double_verify));     // Catch: Throwable -> L48
        PassportOcrInfo r116 = r113.passport_ocr_info;     // Catch: Throwable -> L48
        if (r116 == null) goto L32;
        JSONObject r117 = r116.toJson();     // Catch: Throwable -> L48
    L33:
        KtSafeMethodExtensionKt.safePut(r107, "passport_ocr_info", r117);     // Catch: Throwable -> L48
        ICJPayServiceRetCallBack r118 = OCRDevice.getInstance().getCallBack();     // Catch: Throwable -> L48
        if (r118 == null) goto L36;
        r118.onResult(createResult("0", r107.toString()), null);     // Catch: Throwable -> L48
    L36:
        finish();     // Catch: Throwable -> L48
        goto L37
    L32:
        r117 = null;
    L37:
        CJPayPassportOCRLogger r119 = getLogger();     // Catch: Throwable -> L48
        if (r119 == null) goto L55;
        r119.logPassportOCRUploadClick(NewBroadcastMonitor.CAPTURE.FRONT, "1", "");     // Catch: Throwable -> L48
        return;
    L55:
        return;
    L17:
        if (r113.isSuccess() != true) goto L19;
        r103 = true;
    L48:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayOCRPassportActivity#parsingOCRResponse", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayOCRPassportActivity#parsingOCRResponse", th);
        CJPayBasicUtils.displayToastInternal(getActivity(), this.netErrorText, 0, 17, 0, 0);
        CJPayPassportOCRLogger r108 = getLogger();
        if (r108 == null) goto L58;
        CJPayOCRMvpLogger.DefaultImpls.monitorLog$default(r108, TAG, "parsingOCRResponse", "", "Parser error: " + th, null, 16, null);
        return;
    }

    private final void requestPhotoOCR(final byte[] r100) {
        b.a(new RunnableC93211(r100, this), 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        View r101 = findViewById(R.id.tt_cj_pay_ocr_id_rootview);
        if (r101 == null) goto L6;
        r101.post(new RunnableC93191(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void setNeedShowPermissionTips(boolean r100) {
        this.needShowPermissionTips = r100;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void uploadOrcScanningPageClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        CJPayPassportOCRLogger r101 = getLogger();
        if (r101 == null) goto L6;
        r101.logPassportOCRClick(r100);
        return;
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_ocr_activity_CJPayOCRPassportActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(CJPayOCRBaseActivity r100, Configuration r101) {
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

    public static final /* synthetic */ void access$parsingOCRResponse(CJPayOCRPassportActivity r100, JSONObject r101) {
        r100.parsingOCRResponse(r101);
    }

    public static final /* synthetic */ void access$requestPhotoOCR(CJPayOCRPassportActivity r100, byte[] r101) {
        r100.requestPhotoOCR(r101);
    }

    private final void applyLandscapeOverlayByScanRect(Rect r110, int r111) {
        int r100 = OCRCodeUtil.dp2px(getActivity(), 16.0f);
        int r101 = OCRCodeUtil.dp2px(getActivity(), 59.0f);
        int r102 = OCRCodeUtil.dp2px(getActivity(), 181.0f);
        int r103 = OCRCodeUtil.dp2px(getActivity(), 12.0f);
        int r112 = OCRCodeUtil.dp2px(getActivity(), 163.0f);
        int r113 = OCRCodeUtil.dp2px(getActivity(), 192.0f);
        int r114 = OCRCodeUtil.dp2px(getActivity(), 29.0f);
        int r115 = OCRCodeUtil.dp2px(getActivity(), 28.0f);
        setMarginTop(this.idLabelView, r110.left + r100, r110.top + r101, 0, 0);
        ImageView r104 = this.idMaskView;
        RelativeLayout.LayoutParams r116 = null;
        if (r104 == null) goto L5;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L7:
        if ((r105 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r105;
    L10:
        if (r106 == null) goto L15;
        r106.height = OCRCodeUtil.dp2px(getActivity(), 47.0f);
        ImageView r107 = this.idMaskView;
        if (r107 == null) goto L15;
        r107.setLayoutParams(r106);
    L15:
        setMarginTop(this.idMaskView, r110.left + r103, r110.top + r102, RangesKt.coerceAtLeast(r111 - r110.right, 0) + r103, 0);
        ImageView r108 = this.idIndicatorView;
        if (r108 == null) goto L18;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L20:
        if ((r109 instanceof RelativeLayout.LayoutParams) == false) goto L22;
        RelativeLayout.LayoutParams r117 = (RelativeLayout.LayoutParams) r109;
    L23:
        if (r117 == null) goto L28;
        r117.height = OCRCodeUtil.dp2px(getActivity(), 9.0f);
        ImageView r118 = this.idIndicatorView;
        if (r118 == null) goto L28;
        r118.setLayoutParams(r117);
    L28:
        setMarginTop(this.idIndicatorView, r110.left + r112, r110.top + r113, RangesKt.coerceAtLeast(r111 - r110.right, 0) + r114, 0);
        setMarginTop(this.ocrScanTipsView, OCRCodeUtil.dp2px(getActivity(), 24.0f), r110.bottom + r115, OCRCodeUtil.dp2px(getActivity(), 24.0f), 0);
        TextView r119 = this.ocrScanTipsView;
        if (r119 == null) goto L31;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
    L33:
        if ((r120 instanceof RelativeLayout.LayoutParams) == false) goto L35;
        r116 = (RelativeLayout.LayoutParams) r120;
    L35:
        if (r116 == null) goto L41;
        r116.addRule(14);
        TextView r121 = this.ocrScanTipsView;
        if (r121 == null) goto L42;
        r121.setLayoutParams(r116);
        return;
    L42:
        return;
    L41:
        return;
    L31:
        r120 = null;
        goto L33
    L22:
        r117 = null;
        goto L23
    L18:
        r109 = null;
        goto L20
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L7
    }

    private final void applyPortraitOverlayByScanRect(Rect r110, int r111) {
        int r100 = OCRCodeUtil.dp2px(getActivity(), 47.0f);
        int r101 = OCRCodeUtil.dp2px(getActivity(), 12.0f);
        int r102 = OCRCodeUtil.dp2px(getActivity(), 12.0f);
        int r103 = OCRCodeUtil.dp2px(getActivity(), 28.0f);
        int r104 = RangesKt.coerceAtLeast((r110.bottom - r101) - r100, 0);
        int r105 = r110.left + r102;
        int r106 = RangesKt.coerceAtLeast(r111 - r110.right, 0) + r102;
        ImageView r107 = this.idMaskView;
        RelativeLayout.LayoutParams r112 = null;
        if (r107 == null) goto L5;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L7:
        if ((r108 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        RelativeLayout.LayoutParams r109 = (RelativeLayout.LayoutParams) r108;
    L10:
        if (r109 == null) goto L15;
        r109.height = r100;
        ImageView r113 = this.idMaskView;
        if (r113 == null) goto L15;
        r113.setLayoutParams(r109);
    L15:
        setMarginTop(this.idMaskView, r105, r104, r106, 0);
        ImageView r114 = this.idIndicatorView;
        if (r114 == null) goto L18;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
    L20:
        if ((r115 instanceof RelativeLayout.LayoutParams) == false) goto L22;
        RelativeLayout.LayoutParams r116 = (RelativeLayout.LayoutParams) r115;
    L23:
        if (r116 == null) goto L28;
        r116.height = OCRCodeUtil.dp2px(getActivity(), 9.0f);
        ImageView r117 = this.idIndicatorView;
        if (r117 == null) goto L28;
        r117.setLayoutParams(r116);
    L28:
        setMarginTop(this.idIndicatorView, RangesKt.coerceAtLeast(MathKt.roundToInt(r110.left + (r110.width() * 0.49847096f)), 0), r104 + OCRCodeUtil.dp2px(getActivity(), 11.0f), RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(r111 - r110.right, 0) + (r110.width() * 0.08868501f)), 0), 0);
        setMarginTop(this.ocrScanTipsView, OCRCodeUtil.dp2px(getActivity(), 24.0f), r110.bottom + r103, OCRCodeUtil.dp2px(getActivity(), 24.0f), 0);
        TextView r118 = this.ocrScanTipsView;
        if (r118 == null) goto L31;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L33:
        if ((r119 instanceof RelativeLayout.LayoutParams) == false) goto L35;
        r112 = (RelativeLayout.LayoutParams) r119;
    L35:
        if (r112 == null) goto L41;
        r112.addRule(14);
        TextView r120 = this.ocrScanTipsView;
        if (r120 == null) goto L42;
        r120.setLayoutParams(r112);
        return;
    L42:
        return;
    L41:
        return;
    L31:
        r119 = null;
        goto L33
    L22:
        r116 = null;
        goto L23
    L18:
        r115 = null;
        goto L20
    L9:
        r109 = null;
        goto L10
    L5:
        r108 = null;
        goto L7
    }

    private final String createResult(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "code", r100);
        KtSafeMethodExtensionKt.safePut(r102, "data", r101);
        return r102.toString();
    }

    private final void requestOCR(byte[] r100, String r101) {
        OCRPassportPresenter r102 = this.ocrPresenter;
        if (r102 == null) goto L6;
        r102.fetchOCRResult(r101, this.isZhLanguage, r100, new C93201(this));
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.activity.CJPayOCRBaseActivity
    public void doCancel(String r100, String r101) {
        ICJPayServiceRetCallBack r102 = OCRDevice.getInstance().getCallBack();
        if (r102 == null) goto L6;
        r102.onResult(createResult$default(this, "1", null, 2, null), null);
        return;
    }

    public static final /* synthetic */ void access$applyLandscapeOverlayByScanRect(CJPayOCRPassportActivity r100, Rect r101, int r102) {
        r100.applyLandscapeOverlayByScanRect(r101, r102);
    }

    public static final /* synthetic */ void access$applyPortraitOverlayByScanRect(CJPayOCRPassportActivity r100, Rect r101, int r102) {
        r100.applyPortraitOverlayByScanRect(r101, r102);
    }

    public static final /* synthetic */ void access$requestOCR(CJPayOCRPassportActivity r100, byte[] r101, String r102) {
        r100.requestOCR(r101, r102);
    }

    public static /* synthetic */ String createResult$default(CJPayOCRPassportActivity r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.createResult(r101, r102);
    }
}
