package com.android.ttcjpaysdk.base.bpea.permission;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.bytedance.caijing.sdk.infra.base.api.bpea.BpeaService;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Deprecated(message = "use CJBpea instead")
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u001a\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J3\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001c\u0010-\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010.\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010/\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u001a\u00100\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J6\u00101\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00042\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u0001032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0006H\u0016¨\u00066"}, d2 = {"Lcom/android/ttcjpaysdk/base/bpea/permission/CJPayBPEAService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService;", "()V", "alipay", "", "pay", "Lkotlin/Function0;", "getBpeaService", "Lcom/bytedance/caijing/sdk/infra/base/api/bpea/BpeaService;", BpeaManager.getNetworkType, "", "telephonyManager", "Landroid/telephony/TelephonyManager;", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "pm", "Landroid/content/pm/PackageManager;", "packageName", "flags", "getPackageName", "getPrimaryClip", "Landroid/content/ClipData;", "clip", "Landroid/content/ClipboardManager;", "openCamera", "Landroid/hardware/Camera;", ShortVideoSegments.KEY_CAMERA_ID, "token", "releaseCamera", "", "camera", "releaseRecord", "audioRecord", "Landroid/media/AudioRecord;", "requestEzPermission", "activity", "Landroid/app/Activity;", ComplianceResult.JsonKey.PERMISSIONS, "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$PermissionCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/service/ICJPayBPEAService$PermissionCallback;)V", "setClipboardText", "text", "", "setPrimaryClip", "clipData", "startRecording", "stopRecording", "wrapStartActivityByBpea", "ext", "", "", "action", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBPEAService implements ICJPayBPEAService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    private final BpeaService getBpeaService() {
        a.f554342a.getClass();
        return (BpeaService) a.a(BpeaService.class);
    }

    public CJPayBPEAService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public String alipay(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "pay");
        BpeaService r101 = getBpeaService();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.alipay(r100, "bpea-bpea-cjpay_android_alipay");
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public int getNetworkType(TelephonyManager r100) {
        BpeaService r101 = getBpeaService();
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getNetworkType(r100, "bpea-cjpay_android_network_type");
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public ClipData getPrimaryClip(ClipboardManager r100) {
        BpeaService r101 = getBpeaService();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPrimaryClip(r100, "bpea-cjpay_android_edit_text_clipboard");
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public Camera openCamera(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        BpeaService r101 = getBpeaService();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.openCamera(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public Camera openCamera(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        BpeaService r102 = getBpeaService();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.openCamera(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void releaseCamera(Camera r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.releaseCamera(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void releaseRecord(AudioRecord r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.releaseRecord(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void setClipboardText(ClipboardManager r100, CharSequence r101) {
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.setClipboardText(r100, r101, "bpea-cjpay_android_confirm_clipboard");
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void setPrimaryClip(ClipboardManager r100, ClipData r101) {
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.setPrimaryClip(r100, r101, "bpea-cjpay_android_recharge_clipboard");
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void startRecording(AudioRecord r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.startRecording(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void stopRecording(AudioRecord r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        BpeaService r102 = getBpeaService();
        if (r102 == null) goto L6;
        r102.stopRecording(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public PackageInfo getPackageInfo(PackageManager r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "pm");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        BpeaService r103 = getBpeaService();
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getPackageInfo(r100, r101, r102, "bpea-cjpay_android_get_package_info_pay");
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void wrapStartActivityByBpea(String r100, Map<String, ? extends Object> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "action");
        BpeaService r103 = getBpeaService();
        if (r103 == null) goto L6;
        r103.wrapStartActivityByBpea(r100, r101, r102);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService
    public void requestEzPermission(Activity r100, String[] r101, String r102, final ICJPayBPEAService.PermissionCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "callback");
        BpeaService r104 = getBpeaService();
        if (r104 == null) goto L6;
        r104.requestEzPermission(r100, r101, r102, new AnonymousClass1(r103));
        return;
    }
}
