package com.bytedance.android.live.effect.api;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.ILiveWrappedVESdkService;
import com.bytedance.common.utility.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010#\u001a\u00020!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/api/VESDKUtils;", "", "()V", "ALGORITHM_RES_CACHE_DIR", "", "getALGORITHM_RES_CACHE_DIR", "()Ljava/lang/String;", "EFFECT_CACHE_DIR", "getEFFECT_CACHE_DIR", "FRAME_ZIP_FILE_NAME", "ORI_PIC_DIR_SUFFIX", "getORI_PIC_DIR_SUFFIX", "RES_CACHE_DIR", "getRES_CACHE_DIR", "RES_DOWNLOAD_MODEL_DIR", "getRES_DOWNLOAD_MODEL_DIR", "SDCARD_CACHE_DIR", "getSDCARD_CACHE_DIR", "SDCARD_CACHE_NAME", "getSDCARD_CACHE_NAME", "SDCARD_EXTERNAL_PATH", "getSDCARD_EXTERNAL_PATH", "TAG", "VIDEO_CACHE_DIR", "getVIDEO_CACHE_DIR", "VIDEO_CACHE_TMP_DIR", "getVIDEO_CACHE_TMP_DIR", "is64Bit", "", "loadVESDK", "activity", "Landroid/content/Context;", "reloadSo", "", PerfLog.PARAM_KEY_CONTEXT_ID, "vesdkSetEffectResourceFinder", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class VESDKUtils {
    private static final String ALGORITHM_RES_CACHE_DIR = null;
    private static final String EFFECT_CACHE_DIR = null;
    public static final String FRAME_ZIP_FILE_NAME = "video_frame.zip";
    public static final VESDKUtils INSTANCE = null;
    private static final String ORI_PIC_DIR_SUFFIX = null;
    private static final String RES_CACHE_DIR = null;
    private static final String RES_DOWNLOAD_MODEL_DIR = null;
    private static final String SDCARD_CACHE_DIR = null;
    private static final String SDCARD_CACHE_NAME = null;
    private static final String TAG = "VideoUtils";
    private static final String VIDEO_CACHE_DIR = null;
    private static final String VIDEO_CACHE_TMP_DIR = null;

    private VESDKUtils() {
    }

    static {
        VESDKUtils r100 = new VESDKUtils();
        INSTANCE = r100;
        SDCARD_CACHE_NAME = "/ttlivesdk/";
        String r101 = r100.getSDCARD_EXTERNAL_PATH() + "/ttlivesdk/";
        SDCARD_CACHE_DIR = r101;
        String r102 = r101 + ".res/";
        RES_CACHE_DIR = r102;
        RES_DOWNLOAD_MODEL_DIR = r101 + ".download_model/";
        VIDEO_CACHE_DIR = r101 + ".ssvideo/";
        VIDEO_CACHE_TMP_DIR = r101 + ".ssvideo_cache/";
        ALGORITHM_RES_CACHE_DIR = r101 + ".algo_res/";
        EFFECT_CACHE_DIR = r102 + "effect";
        ORI_PIC_DIR_SUFFIX = "/ttlivesdk/.pic";
    }

    private final boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return Process.is64Bit();
    }

    public final void vesdkSetEffectResourceFinder() {
        int r100 = xn0.b.f564608a;
        monitor-enter(xn0.b.class);
        HashMap r101 = new HashMap();     // Catch: Throwable -> L12
        int r102 = xn0.a.f564607a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "env");     // Catch: Throwable -> L12
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L12
        ILiveWrappedEffectSDKService r103 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L12
        if (r103 == null) goto L7;
        r103.multiMediaEnv_initialize((String) r101.get("bundle_type"), (String) r101.get("host_build_type"));     // Catch: Throwable -> L12
    L7:
        monitor-exit(xn0.b.class);
        xn0.b.a();
        ILiveWrappedVESdkService.Companion.getClass();
        ILiveWrappedVESdkService r104 = ILiveWrappedVESdkService.a.a();
        if (r104 == null) goto L17;
        r104.getVESDK();
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final String getSDCARD_EXTERNAL_PATH() {
        String r100 = jc1.a.b().getFilesDir().getPath();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getALGORITHM_RES_CACHE_DIR() {
        return ALGORITHM_RES_CACHE_DIR;
    }

    public final String getEFFECT_CACHE_DIR() {
        return EFFECT_CACHE_DIR;
    }

    public final String getORI_PIC_DIR_SUFFIX() {
        return ORI_PIC_DIR_SUFFIX;
    }

    public final String getRES_CACHE_DIR() {
        return RES_CACHE_DIR;
    }

    public final String getRES_DOWNLOAD_MODEL_DIR() {
        return RES_DOWNLOAD_MODEL_DIR;
    }

    public final String getSDCARD_CACHE_DIR() {
        return SDCARD_CACHE_DIR;
    }

    public final String getSDCARD_CACHE_NAME() {
        return SDCARD_CACHE_NAME;
    }

    public final String getVIDEO_CACHE_DIR() {
        return VIDEO_CACHE_DIR;
    }

    public final String getVIDEO_CACHE_TMP_DIR() {
        return VIDEO_CACHE_TMP_DIR;
    }

    @JvmStatic
    public static final synchronized boolean loadVESDK(Context r100) {
        monitor-enter(VESDKUtils.class);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L41
        VESDKUtils r101 = INSTANCE;     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
        r101.reloadSo(r100);     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
        r101.vesdkSetEffectResourceFinder();     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
    L10:
        ILiveWrappedVESdkService.Companion.getClass();     // Catch: Throwable -> L41
        ILiveWrappedVESdkService r102 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r102 == null) goto L13;
        r102.getVESDK();     // Catch: Throwable -> L41
    L13:
        ILiveWrappedVESdkService r103 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r103 == null) goto L16;
        r103.getVEConfigCenter();     // Catch: Throwable -> L41
    L16:
        ILiveWrappedVESdkService r104 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r104 == null) goto L19;
        r104.getVESDK();     // Catch: Throwable -> L41
    L19:
        ILiveWrappedVESdkService r105 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r105 == null) goto L22;
        r105.getVESDK();     // Catch: Throwable -> L41
    L22:
        ILiveWrappedVESdkService r106 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r106 == null) goto L26;
        r106.getVESDK();     // Catch: Throwable -> L41
    L26:
        if (INSTANCE.is64Bit() == false) goto L33;
        ILiveWrappedVESdkService r107 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r107 == null) goto L30;
        r107.getVESDK();     // Catch: Throwable -> L41
    L30:
        ILiveWrappedVESdkService r108 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r108 == null) goto L33;
        r108.getVESDK();     // Catch: Throwable -> L41
    L33:
        monitor-exit(VESDKUtils.class);
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L41
        Logger.w(TAG, "initDownloadableModel UnsatisfiedLinkError", e);     // Catch: Throwable -> L41
        VESDKUtils r109 = INSTANCE;     // Catch: Throwable -> L41
        r109.reloadSo(r100);     // Catch: Throwable -> L41
        r109.vesdkSetEffectResourceFinder();     // Catch: UnsatisfiedLinkError -> L36 Throwable -> L41
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L41
        Logger.w(TAG, "reloadSo UnsatisfiedLinkError", e);     // Catch: Throwable -> L41
        return false;
    L41:
        th = move-exception;
        throw th;
    }

    private final void reloadSo(Context r100) {
        String[] r101 = (String[]) ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(SaaSLiveResourceStrategy.getLoadHostLibraryList(), "npth_unw"), "vehook"), "bmf_hydra_lite"), "ttvesdk");
        SaaSLiveResourceStrategy.loadHostLibraryByList(r100, VESDKUtils.class.getClassLoader(), r101);
    }
}
