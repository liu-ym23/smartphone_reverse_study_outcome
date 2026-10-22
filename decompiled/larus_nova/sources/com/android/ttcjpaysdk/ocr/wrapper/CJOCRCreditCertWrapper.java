package com.android.ttcjpaysdk.ocr.wrapper;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ocr.CameraPreview;
import com.android.ttcjpaysdk.ocr.controller.CJOCRManager;
import com.android.ttcjpaysdk.ocr.data.CJOCRBean;
import com.android.ttcjpaysdk.ocr.data.CJOCRCreditCertBean;
import com.android.ttcjpaysdk.ocr.data.OCRScanData;
import com.android.ttcjpaysdk.ocr.log.CJOCRCreditCertLogger;
import com.android.ttcjpaysdk.ocr.view.CJOCRTakePhotoPreview;
import com.android.ttcjpaysdk.ocr.view.IScanBoxView;
import com.android.ttcjpaysdk.ocr.view.OCRCodeView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.caijing.sdk.infra.utils.g;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.tabs.TabLayout;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0012\n\u0002\b\u000f\u0018\u0000 m2\u00020\u0001:\u0002mnB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J$\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020-H\u0002J\b\u00105\u001a\u00020-H\u0002J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J$\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010+2\b\u0010=\u001a\u0004\u0018\u00010+2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020-H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020+H\u0002J\u0010\u0010B\u001a\u00020@2\u0006\u0010A\u001a\u00020+H\u0002J\u0017\u0010C\u001a\u00020+2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020GH\u0002J\u0012\u0010H\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u00010IH\u0002J0\u0010J\u001a\u00020-2\u0006\u00103\u001a\u00020+2\u0006\u0010K\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\nH\u0002J\b\u0010N\u001a\u00020-H\u0002J\u0010\u0010O\u001a\u00020-2\u0006\u0010P\u001a\u00020\u0011H\u0002J\b\u0010Q\u001a\u00020-H\u0002J\b\u0010R\u001a\u00020-H\u0002J\b\u0010S\u001a\u00020-H\u0002J\b\u0010T\u001a\u00020\nH\u0002J\u0012\u0010U\u001a\u00020-2\b\u0010V\u001a\u0004\u0018\u00010)H\u0002J\b\u0010W\u001a\u00020\nH\u0016J\b\u0010X\u001a\u00020-H\u0016J\b\u0010Y\u001a\u00020-H\u0016J$\u0010Z\u001a\u00020-2\u0006\u00109\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010+2\b\u0010=\u001a\u0004\u0018\u00010+H\u0002J\b\u0010[\u001a\u00020-H\u0016J\b\u0010\\\u001a\u00020-H\u0016J\b\u0010]\u001a\u00020-H\u0002J\u0018\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u00020`2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010a\u001a\u00020-H\u0002J\u0010\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\nH\u0002J$\u0010d\u001a\u00020-2\u0006\u00109\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010+2\b\u0010=\u001a\u0004\u0018\u00010+H\u0002J\b\u0010e\u001a\u00020-H\u0002J\u0010\u0010f\u001a\u00020-2\u0006\u0010g\u001a\u00020\nH\u0002J\b\u0010h\u001a\u00020-H\u0002J\u0017\u0010i\u001a\u00020-2\b\u0010j\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020-2\u0006\u00101\u001a\u00020`H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRCreditCertWrapper;", "Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRBaseWrapper;", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "ocrBean", "Lcom/android/ttcjpaysdk/ocr/data/CJOCRBean;", "(Landroid/app/Activity;Landroid/view/View;Lcom/android/ttcjpaysdk/ocr/data/CJOCRBean;)V", "isOpenFlashLight", "", "isRequestPermission", "isUploading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastSelectedTab", "", "lastWarningShow", "", "logger", "Lcom/android/ttcjpaysdk/ocr/log/CJOCRCreditCertLogger;", "mBackView", "Landroid/widget/ImageView;", "mConfirmDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mLightView", "mOCRCodeView", "Lcom/android/ttcjpaysdk/ocr/view/OCRCodeView;", "mOCRLoadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "mOCRScanTipsView", "Landroid/widget/TextView;", "mScanView", "Lcom/android/ttcjpaysdk/ocr/view/IScanBoxView;", "mTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "mTakePhotoCheckView", "Lcom/android/ttcjpaysdk/ocr/view/CJOCRTakePhotoPreview;", "mTakePhotoView", "ocrBizParams", "Lcom/android/ttcjpaysdk/ocr/data/CJOCRCreditCertBean;", "ocrResult", "", "cameraError", "", "closeFlashlight", "createResult", "code", "data", "Lorg/json/JSONObject;", "sourceMedia", "doAlbumAction", "endAlbumProcess", "executeOCR", "scanData", "Lcom/android/ttcjpaysdk/ocr/data/OCRScanData;", "photoSource", "Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRCreditCertWrapper$PhotoSource;", "executeWarningAnimation", "errorCode", "errorMsg", VideoEventOneOutSync.END_TYPE_FINISH, "getBiggerText", "Landroid/text/SpannableString;", "text", "getNormalText", "getPhotoSourceType", "tabPosition", "(Ljava/lang/Integer;)Ljava/lang/String;", "getTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "handleAlbumPic", "Landroid/content/Intent;", "handleOCRResult", "responseJson", "requestStartTime", "antiBacklog", "initAction", "initCountDownTime", "time", "initData", "initOCRViewListener", "initView", "isUsingCamera", "ocrBizParamsCheck", "bean", "onBackPressed", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onOCRScanError", "onPause", "onResume", "recallCameraAfterPermission", "requestCustomOCR", "result", "", "setFlashlight", DyPayConstant.KEY_SHOW_LOADING, "isShow", "showOCRErrorDialog", "showTimeoutDialog", "startScan", "start", "stopSpot", "tabReselected", "position", "(Ljava/lang/Integer;)V", "takePhotoPreview", "Companion", "PhotoSource", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRCreditCertWrapper extends CJOCRBaseWrapper {
    public static final Companion Companion = null;
    private static final String TAG = null;
    public static final int WARNING_ANIMATION_TIME_INTERVAL = 2000;
    private boolean isOpenFlashLight;
    private boolean isRequestPermission;
    private final AtomicBoolean isUploading;
    private int lastSelectedTab;
    private long lastWarningShow;
    private CJOCRCreditCertLogger logger;
    private ImageView mBackView;
    private CJPayCommonDialog mConfirmDialog;
    private CountDownTimer mCountDownTimer;
    private ImageView mLightView;
    private OCRCodeView mOCRCodeView;
    private CJPayTextLoadingView mOCRLoadingView;
    private TextView mOCRScanTipsView;
    private IScanBoxView mScanView;
    private TabLayout mTabLayout;
    private CJOCRTakePhotoPreview mTakePhotoCheckView;
    private ImageView mTakePhotoView;
    private final CJOCRBean ocrBean;
    private CJOCRCreditCertBean ocrBizParams;
    private String ocrResult;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRCreditCertWrapper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "WARNING_ANIMATION_TIME_INTERVAL", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getTAG() {
            return CJOCRCreditCertWrapper.access$getTAG$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRCreditCertWrapper$PhotoSource;", "", "value", "", "type", "", "tabPosition", "(Ljava/lang/String;IILjava/lang/String;I)V", "getTabPosition", "()I", "getType", "()Ljava/lang/String;", "getValue", "SCAN", "TAKE_PHOTO", FlowDoraWifiScene.ALBUM, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PhotoSource extends Enum<PhotoSource> {
        private static final /* synthetic */ PhotoSource[] $VALUES = null;
        public static final PhotoSource ALBUM = null;
        public static final PhotoSource SCAN = null;
        public static final PhotoSource TAKE_PHOTO = null;
        private final int tabPosition;
        private final String type;
        private final int value;

        private static final /* synthetic */ PhotoSource[] $values() {
            return new PhotoSource[]{SCAN, TAKE_PHOTO, ALBUM};
        }

        public static PhotoSource valueOf(String r100) {
            return (PhotoSource) a.a(PhotoSource.class, r100);
        }

        public static PhotoSource[] values() {
            return (PhotoSource[]) $VALUES.clone();
        }

        static {
            SCAN = new PhotoSource("SCAN", 0, 0, "scan", 1);
            TAKE_PHOTO = new PhotoSource("TAKE_PHOTO", 1, 1, "camera", 2);
            ALBUM = new PhotoSource(FlowDoraWifiScene.ALBUM, 2, 2, "album", 0);
            $VALUES = $values();
        }

        public final int getTabPosition() {
            return this.tabPosition;
        }

        public final String getType() {
            return this.type;
        }

        public final int getValue() {
            return this.value;
        }

        private PhotoSource(String r100, int r101, int r102, String r103, int r104) {
            super(r100, r101);
            this.value = r102;
            this.type = r103;
            this.tabPosition = r104;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PhotoSource.values().length];
            r100[PhotoSource.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PhotoSource.TAKE_PHOTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PhotoSource.SCAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private final void cameraError() {
        showLoading(false);
        CJPayBasicUtils.displayToastInternal(getContext(), getContext().getString(R.string.cj_pay_camera_error_toast), 0, 17, 0, 0);
        getActivity().finish();
    }

    private final void endAlbumProcess() {
        showLoading(false);
        TabLayout r100 = this.mTabLayout;
        if (r100 == null) goto L8;
        TabLayout.Tab r101 = r100.getTabAt(this.lastSelectedTab);
        if (r101 == null) goto L9;
        r101.select();
        return;
    L9:
        return;
    }

    static {
        Companion = new Companion(null);
        TAG = "CJOCRCreditCertWrapper";
    }

    private final void closeFlashlight() {
        OCRCodeView r100 = this.mOCRCodeView;
        if (r100 == null) goto L5;
        r100.closeFlashlight();
    L5:
        this.isOpenFlashLight = false;
        ImageView r101 = this.mLightView;
        if (r101 == null) goto L9;
        r101.setImageResource(R.drawable.cj_pay_ocr_light_icon);
        return;
    }

    private final TabLayout.OnTabSelectedListener getTabSelectedListener() {
        return new C93261(this);
    }

    private final void initAction() {
        ImageView r100 = this.mBackView;
        if (r100 == null) goto L5;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r100, new C93281(this));
    L5:
        ImageView r101 = this.mLightView;
        if (r101 == null) goto L8;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r101, new AnonymousClass2(this));
    L8:
        TabLayout r102 = this.mTabLayout;
        if (r102 == null) goto L11;
        r102.addOnTabSelectedListener(getTabSelectedListener());
    L11:
        ImageView r103 = this.mTakePhotoView;
        if (r103 == null) goto L15;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r103, new AnonymousClass3(this));
        return;
    }

    private final void initData() {
        CJOCRCreditCertBean.Companion r100 = CJOCRCreditCertBean.Companion;
        CJOCRBean r101 = this.ocrBean;
        if (r101 == null) goto L6;
        String r102 = r101.ocrParams;
        if (r102 == null) goto L6;
    L7:
        CJOCRCreditCertBean r103 = r100.toBean(r102);
        this.ocrBizParams = r103;
        this.logger = new CJOCRCreditCertLogger(this.ocrBean, r103);
        ocrBizParamsCheck(this.ocrBizParams);
        TextView r104 = this.mOCRScanTipsView;
        Integer r105 = null;
        if (r104 == null) goto L15;
        String r106 = getContext().getString(R.string.cj_pay_ocr_scan_tips);
        Object[] r107 = new Object[1];
        CJOCRCreditCertBean r108 = this.ocrBizParams;
        if (r108 == null) goto L13;
        String r109 = r108.getModuleName();
    L14:
        r107[0] = r109;
        r104.setText(g.b(r106, r107));
        goto L15
    L13:
        r109 = null;
    L15:
        initCountDownTime(30);
        Function1<Function2<? super Boolean, ? super Boolean, Unit>, Unit> r110 = getCheckCameraPermission();
        if (r110 == null) goto L18;
        r110.invoke(new C93301(this));
    L18:
        CJOCRCreditCertBean r111 = this.ocrBizParams;
        if (r111 == null) goto L21;
        r105 = Integer.valueOf(r111.getPageType());
    L21:
        PhotoSource r112 = PhotoSource.SCAN;
        int r113 = r112.getValue();
        if (r105 != null) goto L25;
    L27:
        PhotoSource r114 = PhotoSource.TAKE_PHOTO;
        int r115 = r114.getValue();
        if (r105 != null) goto L31;
    L33:
        int r116 = r112.getTabPosition();
    L34:
        TabLayout r117 = this.mTabLayout;
        if (r117 == null) goto L39;
        TabLayout.Tab r118 = r117.getTabAt(r116);
        if (r118 == null) goto L39;
        r118.select();
    L39:
        CJOCRCreditCertLogger r119 = this.logger;
        if (r119 == null) goto L43;
        r119.logPageImp(getPhotoSourceType(Integer.valueOf(r116)));
        return;
    L43:
        return;
    L31:
        if (r105.intValue() != r115) goto L33;
        r116 = r114.getTabPosition();
        goto L34
    L25:
        if (r105.intValue() != r113) goto L27;
        r116 = r112.getTabPosition();
    L6:
        r102 = "";
        goto L7
    }

    private final void initOCRViewListener() {
        OCRCodeView r100 = this.mOCRCodeView;
        if (r100 == null) goto L6;
        r100.setImageCollectionListener(new C93311(this));
        return;
    }

    private final boolean isUsingCamera() {
        TabLayout r100 = this.mTabLayout;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L19;
        TabLayout r102 = this.mTabLayout;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r102.getSelectedTabPosition() != 2) goto L14;
        r103 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r100.getSelectedTabPosition() != 1) goto L7;
        r101 = true;
        goto L8
    }

    private final void recallCameraAfterPermission() {
        if (this.isRequestPermission == false) goto L29;
        OCRCodeView r100 = this.mOCRCodeView;     // Catch: Throwable -> L24
        if (r100 == null) goto L7;
        CameraPreview r101 = r100.getCameraPreview();     // Catch: Throwable -> L24
    L9:
        if (r101 == null) goto L12;
        r101.setVisibility(0);     // Catch: Throwable -> L24
    L12:
        OCRCodeView r102 = this.mOCRCodeView;     // Catch: Throwable -> L24
        if (r102 == null) goto L16;
        r102.showPermissionTip(false);     // Catch: Throwable -> L24
    L16:
        if (isUsingCamera() == false) goto L30;
        OCRCodeView r103 = this.mOCRCodeView;     // Catch: Throwable -> L24
        if (r103 == null) goto L31;
        r103.startSpotAndShowRect();     // Catch: Throwable -> L24
        Camera r104 = r103.getCamera();     // Catch: Throwable -> L24
        if (r104 == null) goto L22;
        r104.startPreview();     // Catch: Throwable -> L24
    L22:
        r103.startSpot();     // Catch: Throwable -> L24
        return;
    L31:
        return;
    L30:
        return;
    L7:
        r101 = null;
    L24:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOCRCreditCertWrapper#recallCameraAfterPermission", th);
        CJLogger.c(TAG, "recallCameraAfterPermission", th);
        return;
    }

    private final void setFlashlight() {
        if (this.isOpenFlashLight == false) goto L10;
        OCRCodeView r100 = this.mOCRCodeView;
        if (r100 == null) goto L7;
        r100.closeFlashlight();
    L7:
        this.isOpenFlashLight = false;
        ImageView r101 = this.mLightView;
        if (r101 == null) goto L17;
        r101.setImageResource(R.drawable.cj_pay_ocr_light_icon);
        return;
    L17:
        return;
    L10:
        OCRCodeView r102 = this.mOCRCodeView;
        if (r102 == null) goto L13;
        r102.openFlashlight();
    L13:
        this.isOpenFlashLight = true;
        ImageView r103 = this.mLightView;
        if (r103 == null) goto L19;
        r103.setImageResource(R.drawable.cj_pay_ocr_light_open_icon);
        return;
    }

    private final void stopSpot() {
        OCRCodeView r100 = this.mOCRCodeView;
        if (r100 == null) goto L6;
        r100.stopSpot();
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper
    public void finish() {
        OCRCodeView r100 = this.mOCRCodeView;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.closeFlashlight();     // Catch: Throwable -> L9
    L5:
        ICJPayServiceRetCallBack r101 = CJOCRManager.INSTANCE.getMCallBack();     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        r101.onResult(this.ocrResult, null);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOCRCreditCertWrapper#finish", th);
        CJLogger.c(TAG, VideoEventOneOutSync.END_TYPE_FINISH, th);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseWrapper
    public boolean onBackPressed() {
        CJOCRTakePhotoPreview r100 = this.mTakePhotoCheckView;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L14;
        CJOCRTakePhotoPreview r102 = this.mTakePhotoCheckView;
        if (r102 == null) goto L13;
        r102.setVisibility(8);
    L13:
        return true;
    L14:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper
    public void onDestroy() {
        OCRCodeView r100 = this.mOCRCodeView;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.onDestroy();     // Catch: Throwable -> L9
    L5:
        CJPayCommonDialog r101 = this.mConfirmDialog;     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        CJPayKotlinExtensionsKt.dismissSafely(r101);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOCRCreditCertWrapper#onDestroy", th);
        CJLogger.c(TAG, LiveCommonConstants.REASON_ON_DEDTROY, th);
    }

    @Override // com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper
    public void onPause() {
        OCRCodeView r100 = this.mOCRCodeView;     // Catch: Throwable -> L9
        if (r100 == null) goto L14;
        r100.stopSpot();     // Catch: Throwable -> L9
        Camera r101 = r100.getCamera();     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.stopPreview();     // Catch: Throwable -> L9
    L7:
        r100.stopCamera();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOCRCreditCertWrapper#onPause", th);
        CJLogger.c(TAG, "onPause", th);
    }

    private final void doAlbumAction() {
        Function1<Function2<? super Integer, ? super Intent, Unit>, Unit> r100 = getOpenAlbum();
        if (r100 == null) goto L6;
        r100.invoke(new AnonymousClass1(this));
        return;
    }

    private final void initView() {
        LayoutInflater r100 = LayoutInflater.from(getContext());
        View r101 = getRootView();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        r100.inflate(R.layout.cj_pay_credit_cert_ocr_layout, (ViewGroup) r101, true);
        this.mBackView = (ImageView) getRootView().findViewById(R.id.back_view);
        this.mLightView = (ImageView) getRootView().findViewById(R.id.light_view);
        this.mScanView = (IScanBoxView) getRootView().findViewById(R.id.cj_pay_ocr_scan_view);
        this.mTabLayout = (TabLayout) getRootView().findViewById(R.id.bottom_tab_layout);
        this.mTakePhotoView = (ImageView) getRootView().findViewById(R.id.btn_take_photo);
        this.mTakePhotoCheckView = (CJOCRTakePhotoPreview) getRootView().findViewById(R.id.cj_pay_take_photo_preview);
        this.mOCRScanTipsView = (TextView) getRootView().findViewById(R.id.tv_ocr_scan_tips);
        this.mOCRLoadingView = (CJPayTextLoadingView) getRootView().findViewById(R.id.ocr_loading_view);
        OCRCodeView r102 = (OCRCodeView) getRootView().findViewById(R.id.tt_cj_pay_ocr_view);
        this.mOCRCodeView = r102;
        if (r102 == null) goto L6;
        r102.setScanView(this.mScanView);
        r102.showScanBox(false);
        return;
    }

    private final void showTimeoutDialog() {
        final String r100 = getContext().getString(R.string.cj_pay_ocr_error_title_for_ocr_failed);
        CJOCRCreditCertLogger r101 = this.logger;
        if (r101 == null) goto L5;
        r101.logOCRErrorTipImp("", r100, PhotoSource.SCAN.getType());
    L5:
        View.OnClickListener r102 = new CJOCRCreditCertWrapper$showTimeoutDialog$leftClickListener$1(this, r100);
        View.OnClickListener r103 = new CJOCRCreditCertWrapper$showTimeoutDialog$rightClickListener$1(this, r100);
        CJPayCommonDialog r104 = CJPayDialogUtils.initDialog(CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(getContext().getString(R.string.cj_pay_ocr_error_title_for_ocr_failed)).setSubTitle(getContext().getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getContext().getString(R.string.cj_pay_ocr_error_rightbtn_exit)).setRightBtnStr(getContext().getString(R.string.cj_pay_ocr_error_leftbtn)).setLeftBtnListener(r102).setRightBtnListener(r103).setLeftBtnColor(getContext().getResources().getColor(R.color.cj_pay_color_black)).setRightBtnColor(getContext().getResources().getColor(R.color.cj_pay_color_black)).setTitleBold(true).setLeftBtnBold(false).setRightBtnBold(true).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
        this.mConfirmDialog = r104;
        if (r104 == null) goto L9;
        CJPayKotlinExtensionsKt.showSafely(r104, getActivity());
        return;
    }

    @Override // com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper
    public void onCreate() {
        initView();
        initAction();
        initData();
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    @Override // com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper
    public void onResume() {
        recallCameraAfterPermission();
    }

    public static final /* synthetic */ void access$cameraError(CJOCRCreditCertWrapper r100) {
        r100.cameraError();
    }

    public static final /* synthetic */ void access$closeFlashlight(CJOCRCreditCertWrapper r100) {
        r100.closeFlashlight();
    }

    public static final /* synthetic */ void access$doAlbumAction(CJOCRCreditCertWrapper r100) {
        r100.doAlbumAction();
    }

    public static final /* synthetic */ void access$endAlbumProcess(CJOCRCreditCertWrapper r100) {
        r100.endAlbumProcess();
    }

    public static final /* synthetic */ CJOCRCreditCertLogger access$getLogger$p(CJOCRCreditCertWrapper r100) {
        return r100.logger;
    }

    public static final /* synthetic */ CJPayCommonDialog access$getMConfirmDialog$p(CJOCRCreditCertWrapper r100) {
        return r100.mConfirmDialog;
    }

    public static final /* synthetic */ CountDownTimer access$getMCountDownTimer$p(CJOCRCreditCertWrapper r100) {
        return r100.mCountDownTimer;
    }

    public static final /* synthetic */ OCRCodeView access$getMOCRCodeView$p(CJOCRCreditCertWrapper r100) {
        return r100.mOCRCodeView;
    }

    public static final /* synthetic */ CJOCRTakePhotoPreview access$getMTakePhotoCheckView$p(CJOCRCreditCertWrapper r100) {
        return r100.mTakePhotoCheckView;
    }

    public static final /* synthetic */ CJOCRCreditCertBean access$getOcrBizParams$p(CJOCRCreditCertWrapper r100) {
        return r100.ocrBizParams;
    }

    public static final /* synthetic */ void access$initOCRViewListener(CJOCRCreditCertWrapper r100) {
        r100.initOCRViewListener();
    }

    public static final /* synthetic */ void access$recallCameraAfterPermission(CJOCRCreditCertWrapper r100) {
        r100.recallCameraAfterPermission();
    }

    public static final /* synthetic */ void access$setFlashlight(CJOCRCreditCertWrapper r100) {
        r100.setFlashlight();
    }

    public static final /* synthetic */ void access$showTimeoutDialog(CJOCRCreditCertWrapper r100) {
        r100.showTimeoutDialog();
    }

    public static final /* synthetic */ void access$stopSpot(CJOCRCreditCertWrapper r100) {
        r100.stopSpot();
    }

    private final SpannableString getBiggerText(String r100) {
        SpannableString r101 = new SpannableString(r100);
        r101.setSpan(new AbsoluteSizeSpan(18, true), 0, r100.length(), 33);
        return r101;
    }

    private final SpannableString getNormalText(String r100) {
        SpannableString r101 = new SpannableString(r100);
        r101.setSpan(new AbsoluteSizeSpan(16, true), 0, r100.length(), 33);
        return r101;
    }

    private final String getPhotoSourceType(Integer r100) {
        PhotoSource r101 = PhotoSource.SCAN;
        int r102 = r101.getTabPosition();
        if (r100 != null) goto L6;
    L8:
        PhotoSource r103 = PhotoSource.TAKE_PHOTO;
        int r104 = r103.getTabPosition();
        if (r100 != null) goto L12;
    L14:
        PhotoSource r105 = PhotoSource.ALBUM;
        int r106 = r105.getTabPosition();
        if (r100 != null) goto L18;
    L20:
        return "";
    L18:
        if (r100.intValue() != r106) goto L20;
        return r105.getType();
    L12:
        if (r100.intValue() != r104) goto L14;
        return r103.getType();
    L6:
        if (r100.intValue() != r102) goto L8;
        return r101.getType();
    }

    private final void handleAlbumPic(final Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        showLoading(true);
        b.c(new RunnableC93271(r100, this), 0);
    }

    private final void initCountDownTime(long r100) {
        final long r101 = r100 * ((long) 1000);
        this.mCountDownTimer = new CountDownTimerC93291(this, r101);
    }

    private final void ocrBizParamsCheck(CJOCRCreditCertBean r100) {
        boolean r101 = false;
        if (r100 == null) goto L12;
        String r102 = r100.getOcrUrl();
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L12;
        r101 = true;
        goto L12
    L9:
        r103 = false;
    L12:
        if (r101 == true) goto L17;
        CJOCRCreditCertLogger r104 = this.logger;
        if (r104 == null) goto L18;
        r104.logOCRDataException(TAG + ":ocr_url is empty");
        return;
    L18:
        return;
    }

    private final void showLoading(boolean r100) {
        if (r100 == false) goto L6;
        CJPayTextLoadingView r101 = this.mOCRLoadingView;
        if (r101 == null) goto L10;
        r101.show();
        return;
    L10:
        return;
    L6:
        CJPayTextLoadingView r102 = this.mOCRLoadingView;
        if (r102 == null) goto L12;
        r102.hide();
        return;
    }

    private final void startScan(boolean r100) {
        if (this.isRequestPermission == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L15;
        CountDownTimer r101 = this.mCountDownTimer;
        if (r101 == null) goto L9;
        r101.start();
    L9:
        OCRCodeView r102 = this.mOCRCodeView;
        if (r102 == null) goto L12;
        r102.startSpot();
    L12:
        OCRCodeView r103 = this.mOCRCodeView;
        if (r103 == null) goto L22;
        r103.showScanLine(true);
        return;
    L22:
        return;
    L15:
        CountDownTimer r104 = this.mCountDownTimer;
        if (r104 == null) goto L18;
        r104.cancel();
    L18:
        stopSpot();
        OCRCodeView r105 = this.mOCRCodeView;
        if (r105 == null) goto L24;
        r105.showScanLine(false);
        return;
    }

    private final void tabReselected(Integer r100) {
        PhotoSource r101 = PhotoSource.ALBUM;
        int r102 = r101.getTabPosition();
        if (r100 != null) goto L6;
    L16:
        int r103 = PhotoSource.SCAN.getTabPosition();
        if (r100 != null) goto L20;
    L30:
        int r104 = PhotoSource.TAKE_PHOTO.getTabPosition();
        if (r100 != null) goto L34;
    L44:
        int r105 = r101.getTabPosition();
        if (r100 != null) goto L48;
    L49:
        if (r100 == null) goto L51;
        int r106 = r100.intValue();
    L52:
        this.lastSelectedTab = r106;
        return;
    L51:
        r106 = this.lastSelectedTab;
        goto L52
    L48:
        if (r100.intValue() != r105) goto L49;
        return;
    L34:
        if (r100.intValue() != r104) goto L44;
        TextView r107 = this.mOCRScanTipsView;
        if (r107 == null) goto L39;
        r107.setVisibility(8);
    L39:
        ImageView r108 = this.mTakePhotoView;
        if (r108 == null) goto L43;
        r108.setVisibility(0);
    L43:
        startScan(false);
        goto L44
    L20:
        if (r100.intValue() != r103) goto L30;
        TextView r109 = this.mOCRScanTipsView;
        if (r109 == null) goto L25;
        r109.setVisibility(0);
    L25:
        ImageView r110 = this.mTakePhotoView;
        if (r110 == null) goto L29;
        r110.setVisibility(8);
    L29:
        startScan(true);
        goto L44
    L6:
        if (r100.intValue() != r102) goto L16;
        doAlbumAction();
        closeFlashlight();
        TextView r111 = this.mOCRScanTipsView;
        if (r111 == null) goto L11;
        r111.setVisibility(8);
    L11:
        ImageView r112 = this.mTakePhotoView;
        if (r112 == null) goto L15;
        r112.setVisibility(8);
    L15:
        startScan(false);
        goto L44
    }

    private final void takePhotoPreview(final byte[] r100) {
        CJOCRTakePhotoPreview r101 = this.mTakePhotoCheckView;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        b.a(new RunnableC93321(r100, this), 0);
    }

    public static final /* synthetic */ SpannableString access$getBiggerText(CJOCRCreditCertWrapper r100, String r101) {
        return r100.getBiggerText(r101);
    }

    public static final /* synthetic */ SpannableString access$getNormalText(CJOCRCreditCertWrapper r100, String r101) {
        return r100.getNormalText(r101);
    }

    public static final /* synthetic */ String access$getPhotoSourceType(CJOCRCreditCertWrapper r100, Integer r101) {
        return r100.getPhotoSourceType(r101);
    }

    public static final /* synthetic */ void access$handleAlbumPic(CJOCRCreditCertWrapper r100, Intent r101) {
        r100.handleAlbumPic(r101);
    }

    public static final /* synthetic */ void access$setRequestPermission$p(CJOCRCreditCertWrapper r100, boolean r101) {
        r100.isRequestPermission = r101;
    }

    public static final /* synthetic */ void access$showLoading(CJOCRCreditCertWrapper r100, boolean r101) {
        r100.showLoading(r101);
    }

    public static final /* synthetic */ void access$tabReselected(CJOCRCreditCertWrapper r100, Integer r101) {
        r100.tabReselected(r101);
    }

    public static final /* synthetic */ void access$takePhotoPreview(CJOCRCreditCertWrapper r100, byte[] r101) {
        r100.takePhotoPreview(r101);
    }

    private final void executeOCR(final OCRScanData r100, final PhotoSource r101) {
        b.c(new RunnableC93251(this, r100, r101), 0);
    }

    private final void requestCustomOCR(byte[] r110, final PhotoSource r111) {
        boolean r100 = true;
        final boolean r101 = Intrinsics.areEqual(CJPayABExperimentKeys.getOcrRequestAntiBacklogConfig().value(true).custom_interface, "1");
        if (r101 == true) goto L5;
    L7:
        final long r102 = System.currentTimeMillis();
        final String r103 = Base64.encodeToString(r110, 2);     // Catch: Exception -> L36
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L36
        r104.put("media", r103);     // Catch: Exception -> L36
        CJOCRCreditCertBean r105 = this.ocrBizParams;     // Catch: Exception -> L36
        if (r105 == null) goto L12;
        JSONObject r106 = r105.getExtParams();     // Catch: Exception -> L36
        if (r106 == null) goto L12;
    L13:
        r104.put("params", r106);     // Catch: Exception -> L36
        r104.put("ocr_mode", r111.getValue());     // Catch: Exception -> L36
        String r107 = r104.toString();     // Catch: Exception -> L36
        CJOCRCreditCertBean r108 = this.ocrBizParams;     // Catch: Exception -> L36
        if (r108 == null) goto L17;
        String r109 = r108.getOcrUrl();     // Catch: Exception -> L36
        if (r109 == null) goto L17;
    L18:
        String r112 = r109;
        if (r103.length() != 0) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L31;
        CJOCRCreditCertLogger r114 = this.logger;     // Catch: Exception -> L36
        if (r114 == null) goto L31;
        StringBuilder r115 = new StringBuilder();     // Catch: Exception -> L36
        r115.append(TAG);     // Catch: Exception -> L36
        r115.append(": media is empty, photo source is empty?-");     // Catch: Exception -> L36
        if (r110.length == 0) goto L29;
        r100 = false;
    L29:
        r115.append(r100);     // Catch: Exception -> L36
        r114.logOCRDataException(r115.toString());     // Catch: Exception -> L36
    L31:
        if (CJPayNetworkManager.postJson(r112, new HashMap(), new HashMap(), r107, new CJOCRCreditCertWrapper$requestCustomOCR$request$1(this, r103, r111, r102, r101)) != null) goto L43;
        showLoading(false);     // Catch: Exception -> L36
        if (r101 == false) goto L44;
        this.isUploading.set(false);     // Catch: Exception -> L36
        return;
    L44:
        return;
    L43:
        return;
    L21:
        r113 = false;
    L17:
        r109 = "";
    L12:
        r106 = new JSONObject();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        if (r101 == false) goto L39;
        this.isUploading.set(false);
    L39:
        CJBasicCommonUtils.reportCatchException("CJOCRCreditCertWrapper#onFailure", e);
        CJLogger.c(TAG, "requestCustomOCR", e);
        return;
    L5:
        if (this.isUploading.getAndSet(true) == false) goto L7;
    }

    public CJOCRCreditCertWrapper(Activity r100, View r101, CJOCRBean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100, r101);
        this.ocrBean = r102;
        this.lastSelectedTab = 1;
        this.isUploading = new AtomicBoolean(false);
        this.ocrResult = createResult$default(this, 1, null, null, 6, null);
    }

    public static final /* synthetic */ void access$executeOCR(CJOCRCreditCertWrapper r100, OCRScanData r101, PhotoSource r102) {
        r100.executeOCR(r101, r102);
    }

    public static final /* synthetic */ void access$requestCustomOCR(CJOCRCreditCertWrapper r100, byte[] r101, PhotoSource r102) {
        r100.requestCustomOCR(r101, r102);
    }

    private final String createResult(int r100, JSONObject r101, String r102) {
        if (r100 != 0) goto L4;
        String r103 = "识别成功";
    L5:
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "code", Integer.valueOf(r100));
        KtSafeMethodExtensionKt.safePut(r104, "msg", r103);
        KtSafeMethodExtensionKt.safePut(r104, "data", r101);
        KtSafeMethodExtensionKt.safePut(r104, "meta_file", r102);
        return r104.toString();
    L4:
        r103 = "用户取消识别";
        goto L5
    }

    private final void executeWarningAnimation(String r100, String r101, PhotoSource r102) {
        long r103 = System.currentTimeMillis() - this.lastWarningShow;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (r103 < 2000) goto L16;
        CJOCRCreditCertLogger r104 = this.logger;
        if (r104 == null) goto L10;
        r104.logOCRErrorTipImp(r100, r101, r102.getType());
    L10:
        this.lastWarningShow = System.currentTimeMillis();
        TextView r105 = this.mOCRScanTipsView;
        if (r105 == null) goto L17;
        r105.setText(r101);
        return;
    L17:
        return;
    }

    private final void onOCRScanError(PhotoSource r100, String r101, String r102) {
        showLoading(false);
        stopSpot();
        showOCRErrorDialog(r100, r101, r102);
    }

    private final void showOCRErrorDialog(final PhotoSource r100, final String r101, final String r102) {
        CJOCRCreditCertLogger r103 = this.logger;
        if (r103 == null) goto L5;
        r103.logOCRErrorTipImp(r101, r102, r100.getType());
    L5:
        View.OnClickListener r104 = new CJOCRCreditCertWrapper$showOCRErrorDialog$leftClickListener$1(this, r101, r102, r100);
        View.OnClickListener r105 = new CJOCRCreditCertWrapper$showOCRErrorDialog$rightClickListener$1(this, r100, r101, r102);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = getContext().getString(R.string.cj_pay_ocr_error_title_for_ocr_failed);
    L8:
        int r106 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r106 != 1) goto L11;
        String r107 = getContext().getString(R.string.cj_pay_ocr_error_leftbtn_for_album);
    L16:
        if (this.mConfirmDialog != null) goto L18;
        this.mConfirmDialog = CJPayDialogUtils.initDialog(CJPayDialogUtils.getDefaultBuilder(getActivity()).setActivity(getActivity()).setTitle(r102).setSubTitle(getContext().getString(R.string.cj_pay_errormsg)).setLeftBtnStr(getContext().getString(R.string.cj_pay_ocr_error_rightbtn_exit)).setRightBtnStr(r107).setLeftBtnListener(r104).setRightBtnListener(r105).setLeftBtnColor(getContext().getResources().getColor(R.color.cj_pay_color_black)).setRightBtnColor(getContext().getResources().getColor(R.color.cj_pay_color_black)).setTitleBold(true).setLeftBtnBold(false).setRightBtnBold(true).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer));
    L18:
        CJPayCommonDialog r108 = this.mConfirmDialog;
        if (r108 == null) goto L21;
        r108.setTitle(r102);
    L21:
        CJPayCommonDialog r109 = this.mConfirmDialog;
        if (r109 == null) goto L25;
        CJPayKotlinExtensionsKt.showSafely(r109, getActivity());
        return;
    L25:
        return;
    L11:
        if (r106 == 2) goto L13;
        r107 = getContext().getString(R.string.cj_pay_ocr_error_leftbtn);
        goto L16
    L13:
        r107 = getContext().getString(R.string.cj_pay_ocr_reshoot);
        goto L16
    }

    private final void handleOCRResult(String r100, JSONObject r101, PhotoSource r102, long r103, boolean r110) {
        boolean r104 = false;
        if (r110 == false) goto L5;
        this.isUploading.set(false);
    L5:
        showLoading(false);
        String r105 = r101.optString("msg");
        int r111 = r101.optInt("code");
        JSONObject r106 = r101.optJSONObject("data");
        String r107 = null;
        if (r106 == null) goto L8;
        String r108 = r106.optString("data_validation");
    L9:
        if (r106 == null) goto L11;
        String r109 = r106.optString("ocr_check_code");
    L12:
        if (r106 == null) goto L15;
        r107 = r106.optString("ocr_check_msg");
    L15:
        if (Intrinsics.areEqual("y", r108) == false) goto L24;
        if (getActivity().isFinishing() == true) goto L22;
        this.ocrResult = createResult(0, r106, r100);
        CJOCRCreditCertLogger r112 = this.logger;
        if (r112 == null) goto L21;
        r112.logOCRSuccess(r102.getType());
    L21:
        getActivity().finish();
        return;
    L22:
        CJLogger.d(TAG, "requestCustomOCR: success, activity is finishing");
        return;
    L24:
        if (r109 != null) goto L26;
    L27:
        r104 = true;
    L28:
        if (r104 == false) goto L30;
        String r113 = String.valueOf(r111);
    L31:
        int r114 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r114 != 1) goto L34;
    L39:
        onOCRScanError(r102, r113, r107);
    L40:
        CJLogger.d(TAG, "requestCustomOCR: code-" + r111 + ", msg-" + r105 + ", ocr_check_code-" + r109 + ", ocr_check_msg-" + r107);
        return;
    L34:
        if (r114 == 2) goto L39;
        if (r114 != 3) goto L40;
        executeWarningAnimation(r113, r107, r102);
        goto L40
    L30:
        r113 = r109;
        goto L31
    L26:
        if (r109.length() != 0) goto L28;
    L11:
        r109 = null;
        goto L12
    L8:
        r108 = null;
        goto L9
    }

    public static final /* synthetic */ void access$handleOCRResult(CJOCRCreditCertWrapper r100, String r101, JSONObject r102, PhotoSource r103, long r104, boolean r105) {
        r100.handleOCRResult(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ String createResult$default(CJOCRCreditCertWrapper r100, int r101, JSONObject r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = "";
    L9:
        return r100.createResult(r101, r102, r103);
    }
}
