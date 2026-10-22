package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001c\u00100\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010\u001e¨\u00068"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/a3;", "", "", "patchUpdateEnable", "Ljava/lang/Boolean;", "o", "()Ljava/lang/Boolean;", "", "", "patchBlackGamePkgList", "Ljava/util/List;", ce.f26396k, "()Ljava/util/List;", "patchCheckSumEnable", "l", "detailPageShowPatchSize", "Z", ce.f26391f, "()Z", "", "patchProgressWhenDownloadFinsh", "Ljava/lang/Float;", "m", "()Ljava/lang/Float;", "calculateGameApkMd5Enable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "calculateGameApkMd5Interval", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "calculateMd5FromAppLaunchEnable", "getCalculateMd5FromAppLaunchEnable", "calculateMd5FromSubscribeEnable", "e", "calculateMd5FromToolbarEnable", "f", "calculateMd5FromAnchorEnable", "c", "calculateMd5FromInstalledEnable", "d", "", "gameApkMd5MaxStoreSize", "Ljava/lang/Integer;", "h", "()Ljava/lang/Integer;", "patchUpdateDecompressThreadCount", OfficeSDKRequestTag.KEY_NEW_USER, "restoreTimeOut", "p", "getPackageInfoEnable", RXScreenCaptureService.KEY_INDEX, "useNewCalculator", "q", "needClearHostVersionCode", ce.f26395j, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a3 {

    @SerializedName("calculate_game_apk_md5_enable")
    private final Boolean calculateGameApkMd5Enable;

    @SerializedName("calculate_game_apk_md5_interval")
    private final Long calculateGameApkMd5Interval;

    @SerializedName("calculate_md5_from_game_anchor")
    private final Boolean calculateMd5FromAnchorEnable;

    @SerializedName("calculate_md5_from_app_launch_enable")
    private final Boolean calculateMd5FromAppLaunchEnable;

    @SerializedName("calculate_md5_from_installed_callback")
    private final Boolean calculateMd5FromInstalledEnable;

    @SerializedName("calculate_md5_from_subscribe")
    private final Boolean calculateMd5FromSubscribeEnable;

    @SerializedName("calculate_md5_from_game_toolbar")
    private final Boolean calculateMd5FromToolbarEnable;

    @SerializedName("patch_detail_show_patch_size")
    private final boolean detailPageShowPatchSize;

    @SerializedName("game_apk_md5_max_store_size")
    private final Integer gameApkMd5MaxStoreSize;

    @SerializedName("get_package_info_enable")
    private final Boolean getPackageInfoEnable;

    @SerializedName("need_clear_host_version_code")
    private final Long needClearHostVersionCode;

    @SerializedName("patch_black_game_pkg_list")
    private final List<String> patchBlackGamePkgList;

    @SerializedName("patch_check_sum_enable")
    private final Boolean patchCheckSumEnable;

    @SerializedName("patch_progress_when_download_finish")
    private final Float patchProgressWhenDownloadFinsh;

    @SerializedName("patch_update_decompress_thread_count")
    private final Integer patchUpdateDecompressThreadCount;

    @SerializedName("patch_update_enable")
    private final Boolean patchUpdateEnable;

    @SerializedName("restore_timeout")
    private final Long restoreTimeOut;

    @SerializedName("use_new_md5_calculator")
    private final Boolean useNewCalculator;

    public a3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a3) == false) goto L42;
        a3 r101 = (a3) r100;
        if (Intrinsics.areEqual(this.patchUpdateEnable, r101.patchUpdateEnable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.patchBlackGamePkgList, r101.patchBlackGamePkgList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.patchCheckSumEnable, r101.patchCheckSumEnable) == true) goto L12;
        return false;
    L12:
        if (this.detailPageShowPatchSize == r101.detailPageShowPatchSize) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.patchProgressWhenDownloadFinsh, r101.patchProgressWhenDownloadFinsh) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.calculateGameApkMd5Enable, r101.calculateGameApkMd5Enable) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.calculateGameApkMd5Interval, r101.calculateGameApkMd5Interval) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.calculateMd5FromAppLaunchEnable, r101.calculateMd5FromAppLaunchEnable) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.calculateMd5FromSubscribeEnable, r101.calculateMd5FromSubscribeEnable) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.calculateMd5FromToolbarEnable, r101.calculateMd5FromToolbarEnable) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.calculateMd5FromAnchorEnable, r101.calculateMd5FromAnchorEnable) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.calculateMd5FromInstalledEnable, r101.calculateMd5FromInstalledEnable) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.gameApkMd5MaxStoreSize, r101.gameApkMd5MaxStoreSize) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.patchUpdateDecompressThreadCount, r101.patchUpdateDecompressThreadCount) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.restoreTimeOut, r101.restoreTimeOut) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.getPackageInfoEnable, r101.getPackageInfoEnable) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.useNewCalculator, r101.useNewCalculator) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.needClearHostVersionCode, r101.needClearHostVersionCode) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        Boolean r100 = this.patchUpdateEnable;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.patchBlackGamePkgList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.patchCheckSumEnable;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.detailPageShowPatchSize;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.patchProgressWhenDownloadFinsh;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.calculateGameApkMd5Enable;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.calculateGameApkMd5Interval;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.calculateMd5FromAppLaunchEnable;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.calculateMd5FromSubscribeEnable;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.calculateMd5FromToolbarEnable;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.calculateMd5FromAnchorEnable;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.calculateMd5FromInstalledEnable;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.gameApkMd5MaxStoreSize;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.patchUpdateDecompressThreadCount;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.restoreTimeOut;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.getPackageInfoEnable;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.useNewCalculator;
        if (r149 == null) goto L68;
        int r150 = r149.hashCode();
    L69:
        int r151 = (r148 + r150) * 31;
        Long r152 = this.needClearHostVersionCode;
        if (r152 == null) goto L73;
        r101 = r152.hashCode();
    L73:
        return r151 + r101;
    L68:
        r150 = 0;
        goto L69
    L64:
        r147 = 0;
        goto L65
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PatchUpdateConfig(patchUpdateEnable=" + this.patchUpdateEnable + ", patchBlackGamePkgList=" + this.patchBlackGamePkgList + ", patchCheckSumEnable=" + this.patchCheckSumEnable + ", detailPageShowPatchSize=" + this.detailPageShowPatchSize + ", patchProgressWhenDownloadFinsh=" + this.patchProgressWhenDownloadFinsh + ", calculateGameApkMd5Enable=" + this.calculateGameApkMd5Enable + ", calculateGameApkMd5Interval=" + this.calculateGameApkMd5Interval + ", calculateMd5FromAppLaunchEnable=" + this.calculateMd5FromAppLaunchEnable + ", calculateMd5FromSubscribeEnable=" + this.calculateMd5FromSubscribeEnable + ", calculateMd5FromToolbarEnable=" + this.calculateMd5FromToolbarEnable + ", calculateMd5FromAnchorEnable=" + this.calculateMd5FromAnchorEnable + ", calculateMd5FromInstalledEnable=" + this.calculateMd5FromInstalledEnable + ", gameApkMd5MaxStoreSize=" + this.gameApkMd5MaxStoreSize + ", patchUpdateDecompressThreadCount=" + this.patchUpdateDecompressThreadCount + ", restoreTimeOut=" + this.restoreTimeOut + ", getPackageInfoEnable=" + this.getPackageInfoEnable + ", useNewCalculator=" + this.useNewCalculator + ", needClearHostVersionCode=" + this.needClearHostVersionCode + ")";
    }

    public final Boolean a() {
        return this.calculateGameApkMd5Enable;
    }

    public final Long b() {
        return this.calculateGameApkMd5Interval;
    }

    public final Boolean c() {
        return this.calculateMd5FromAnchorEnable;
    }

    public final Boolean d() {
        return this.calculateMd5FromInstalledEnable;
    }

    public final Boolean e() {
        return this.calculateMd5FromSubscribeEnable;
    }

    public final Boolean f() {
        return this.calculateMd5FromToolbarEnable;
    }

    public final boolean g() {
        return this.detailPageShowPatchSize;
    }

    public final Integer h() {
        return this.gameApkMd5MaxStoreSize;
    }

    public final Boolean i() {
        return this.getPackageInfoEnable;
    }

    public final Long j() {
        return this.needClearHostVersionCode;
    }

    public final List<String> k() {
        return this.patchBlackGamePkgList;
    }

    public final Boolean l() {
        return this.patchCheckSumEnable;
    }

    public final Float m() {
        return this.patchProgressWhenDownloadFinsh;
    }

    public final Integer n() {
        return this.patchUpdateDecompressThreadCount;
    }

    public final Boolean o() {
        return this.patchUpdateEnable;
    }

    public final Long p() {
        return this.restoreTimeOut;
    }

    public final Boolean q() {
        return this.useNewCalculator;
    }

    public a3(Object r100) {
        Boolean r101 = Boolean.TRUE;
        ArrayList r102 = new ArrayList();
        Float r103 = Float.valueOf(0.9f);
        this.patchUpdateEnable = r101;
        this.patchBlackGamePkgList = r102;
        this.patchCheckSumEnable = r101;
        this.detailPageShowPatchSize = true;
        this.patchProgressWhenDownloadFinsh = r103;
        this.calculateGameApkMd5Enable = r101;
        this.calculateGameApkMd5Interval = 60000L;
        this.calculateMd5FromAppLaunchEnable = r101;
        this.calculateMd5FromSubscribeEnable = r101;
        this.calculateMd5FromToolbarEnable = r101;
        this.calculateMd5FromAnchorEnable = r101;
        this.calculateMd5FromInstalledEnable = r101;
        this.gameApkMd5MaxStoreSize = 30;
        this.patchUpdateDecompressThreadCount = 3;
        this.restoreTimeOut = 300000L;
        this.getPackageInfoEnable = r101;
        this.useNewCalculator = r101;
        this.needClearHostVersionCode = 0L;
    }
}
