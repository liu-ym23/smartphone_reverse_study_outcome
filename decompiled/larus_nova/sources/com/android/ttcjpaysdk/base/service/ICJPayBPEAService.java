package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000 22\u00020\u0001:\u000223J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0003H&J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0003H&J\u001a\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u0003H&J3\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010'\u001a\u0004\u0018\u00010(H&J\u001c\u0010)\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010+\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u0003H&J\u001a\u0010,\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u0003H&J6\u0010-\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00032\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H&¨\u00064"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "alipay", "", "pay", "Lkotlin/Function0;", BpeaManager.getNetworkType, "", "telephonyManager", "Landroid/telephony/TelephonyManager;", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "pm", "Landroid/content/pm/PackageManager;", "packageName", "flags", "getPrimaryClip", "Landroid/content/ClipData;", "clip", "Landroid/content/ClipboardManager;", "openCamera", "Landroid/hardware/Camera;", ShortVideoSegments.KEY_CAMERA_ID, "token", "releaseCamera", "", "camera", "releaseRecord", "audioRecord", "Landroid/media/AudioRecord;", "requestEzPermission", "activity", "Landroid/app/Activity;", ComplianceResult.JsonKey.PERMISSIONS, "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$PermissionCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$PermissionCallback;)V", "setClipboardText", "text", "", "setPrimaryClip", "clipData", "startRecording", "stopRecording", "wrapStartActivityByBpea", "ext", "", "", AbsMethodDelegate.TAG_INVOKE, "Companion", "PermissionCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayBPEAService extends ICJPayService {
    public static final Companion Companion = null;
    public static final String TOKEN_ALIPAY = "bpea-bpea-cjpay_android_alipay";
    public static final String TOKEN_CAMERA = "bpea-bpea-cjpay_android_camera";
    public static final String TOKEN_CASHIER_JUMP_BACK = "bpea-caijing_homepage_cashier_jump_back";
    public static final String TOKEN_CMB = "bpea-bpea-cjpay_android_cmb";
    public static final String TOKEN_CONFIRM_CLIP_BOARD = "bpea-cjpay_android_confirm_clipboard";
    public static final String TOKEN_DEVICE_NETWORK_TYPE = "bpea-cjpay_android_network_type";
    public static final String TOKEN_GET_CLIP_BOARD = "bpea-cjpay_android_edit_text_clipboard";
    public static final String TOKEN_GET_PACKAGE_INFO_PAY = "bpea-cjpay_android_get_package_info_pay";
    public static final String TOKEN_JSB_FILE_CHOOSE_PERMISSION = "bpea-cjpay_android_jsbridge_camera_and_storage";
    public static final String TOKEN_NATIVE_PERMISSION = "bpea-cjpay_android_native_request_permission";
    public static final String TOKEN_OCR_CAMERA = "bpea-cjpay_android_ocr_camera";
    public static final String TOKEN_OCR_CAMERA_UTIL = "bpea-cjpay_android_ocr_util";
    public static final String TOKEN_OCR_RELEASE_CAMERA = "bpea-cjpay_android_ocr_release_camera";
    public static final String TOKEN_OCR_RELEASE_CAMERA_UTIL = "bpea-cjpay_android_release_ocr_util";
    public static final String TOKEN_OPEN_CAMERA_UTIL = "bpea-cjpay_android_open_camera_util";
    public static final String TOKEN_OPEN_FACE_CAMERA = "bpea-caijing_face_request_camera_permission";
    public static final String TOKEN_OPEN_SCHEMA = "bpea-bpea-cjpay_android_xbridge_openschema";
    public static final String TOKEN_RELEASE_CAMERA_UTIL = "bpea-cjpay_android_release_camera_util";
    public static final String TOKEN_SET_CLIP_BOARD = "bpea-cjpay_android_recharge_clipboard";
    public static final String TOKEN_WEIXIN = "bpea-bpea-cjpay_android_weixin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$Companion;", "", "()V", "TOKEN_ALIPAY", "", "TOKEN_CAMERA", "TOKEN_CASHIER_JUMP_BACK", "TOKEN_CMB", "TOKEN_CONFIRM_CLIP_BOARD", "TOKEN_DEVICE_NETWORK_TYPE", "TOKEN_GET_CLIP_BOARD", "TOKEN_GET_PACKAGE_INFO_PAY", "TOKEN_JSB_FILE_CHOOSE_PERMISSION", "TOKEN_NATIVE_PERMISSION", "TOKEN_OCR_CAMERA", "TOKEN_OCR_CAMERA_UTIL", "TOKEN_OCR_RELEASE_CAMERA", "TOKEN_OCR_RELEASE_CAMERA_UTIL", "TOKEN_OPEN_CAMERA_UTIL", "TOKEN_OPEN_FACE_CAMERA", "TOKEN_OPEN_SCHEMA", "TOKEN_RELEASE_CAMERA_UTIL", "TOKEN_SET_CLIP_BOARD", "TOKEN_WEIXIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String TOKEN_ALIPAY = "bpea-bpea-cjpay_android_alipay";
        public static final String TOKEN_CAMERA = "bpea-bpea-cjpay_android_camera";
        public static final String TOKEN_CASHIER_JUMP_BACK = "bpea-caijing_homepage_cashier_jump_back";
        public static final String TOKEN_CMB = "bpea-bpea-cjpay_android_cmb";
        public static final String TOKEN_CONFIRM_CLIP_BOARD = "bpea-cjpay_android_confirm_clipboard";
        public static final String TOKEN_DEVICE_NETWORK_TYPE = "bpea-cjpay_android_network_type";
        public static final String TOKEN_GET_CLIP_BOARD = "bpea-cjpay_android_edit_text_clipboard";
        public static final String TOKEN_GET_PACKAGE_INFO_PAY = "bpea-cjpay_android_get_package_info_pay";
        public static final String TOKEN_JSB_FILE_CHOOSE_PERMISSION = "bpea-cjpay_android_jsbridge_camera_and_storage";
        public static final String TOKEN_NATIVE_PERMISSION = "bpea-cjpay_android_native_request_permission";
        public static final String TOKEN_OCR_CAMERA = "bpea-cjpay_android_ocr_camera";
        public static final String TOKEN_OCR_CAMERA_UTIL = "bpea-cjpay_android_ocr_util";
        public static final String TOKEN_OCR_RELEASE_CAMERA = "bpea-cjpay_android_ocr_release_camera";
        public static final String TOKEN_OCR_RELEASE_CAMERA_UTIL = "bpea-cjpay_android_release_ocr_util";
        public static final String TOKEN_OPEN_CAMERA_UTIL = "bpea-cjpay_android_open_camera_util";
        public static final String TOKEN_OPEN_FACE_CAMERA = "bpea-caijing_face_request_camera_permission";
        public static final String TOKEN_OPEN_SCHEMA = "bpea-bpea-cjpay_android_xbridge_openschema";
        public static final String TOKEN_RELEASE_CAMERA_UTIL = "bpea-cjpay_android_release_camera_util";
        public static final String TOKEN_SET_CLIP_BOARD = "bpea-cjpay_android_recharge_clipboard";
        public static final String TOKEN_WEIXIN = "bpea-bpea-cjpay_android_weixin";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$PermissionCallback;", "", "onEzPermissionResult", "", "allGranted", "", "grantedList", "", "", "deniedList", "onRequestPermissions", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PermissionCallback {
        void onEzPermissionResult(boolean r100, List<String> r101, List<String> r102);

        void onRequestPermissions();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String alipay(Function0<String> r100);

    int getNetworkType(TelephonyManager r100);

    PackageInfo getPackageInfo(PackageManager r100, String r101, int r102);

    ClipData getPrimaryClip(ClipboardManager r100);

    Camera openCamera(int r100, String r101) throws Exception;

    Camera openCamera(String r100) throws Exception;

    void releaseCamera(Camera r100, String r101);

    void releaseRecord(AudioRecord r100, String r101);

    void requestEzPermission(Activity r100, String[] r101, String r102, PermissionCallback r103);

    void setClipboardText(ClipboardManager r100, CharSequence r101);

    void setPrimaryClip(ClipboardManager r100, ClipData r101);

    void startRecording(AudioRecord r100, String r101);

    void stopRecording(AudioRecord r100, String r101);

    void wrapStartActivityByBpea(String r100, Map<String, ? extends Object> r101, Function0<Unit> r102);
}
