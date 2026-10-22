package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/j2;", "", "", "installGuideEnable", "Z", "c", "()Z", "", "jumpInstallPageLabelMilliSeconds", "J", "e", "()J", "showInstallGuideDelay", "f", "bannerIntervalMilliSeconds", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "isBannerLoop", ce.f26391f, "hasPermissionDialogFrequency", "b", "installInterceptEnable", "d", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j2 {

    @SerializedName("install_guide_banner_interval")
    private final long bannerIntervalMilliSeconds;

    @SerializedName("has_permission_dialog_frequency")
    private final boolean hasPermissionDialogFrequency;

    @SerializedName("install_guide_enable")
    private final boolean installGuideEnable;

    @SerializedName("install_intercept_enable")
    private final boolean installInterceptEnable;

    @SerializedName("install_guide_banner_loop")
    private final boolean isBannerLoop;

    @SerializedName("jump_install_page_label_milliseconds")
    private final long jumpInstallPageLabelMilliSeconds;

    @SerializedName("show_install_guide_delay_milliseconds")
    private final long showInstallGuideDelay;

    public j2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j2) == false) goto L20;
        j2 r101 = (j2) r100;
        if (this.installGuideEnable == r101.installGuideEnable) goto L8;
        return false;
    L8:
        if (this.jumpInstallPageLabelMilliSeconds == r101.jumpInstallPageLabelMilliSeconds) goto L10;
        return false;
    L10:
        if (this.showInstallGuideDelay == r101.showInstallGuideDelay) goto L12;
        return false;
    L12:
        if (this.bannerIntervalMilliSeconds == r101.bannerIntervalMilliSeconds) goto L14;
        return false;
    L14:
        if (this.isBannerLoop == r101.isBannerLoop) goto L16;
        return false;
    L16:
        if (this.hasPermissionDialogFrequency == r101.hasPermissionDialogFrequency) goto L18;
        return false;
    L18:
        if (this.installInterceptEnable == r101.installInterceptEnable) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r100 = this.installGuideEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.jumpInstallPageLabelMilliSeconds;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.showInstallGuideDelay;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.bannerIntervalMilliSeconds;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.isBannerLoop;
        ?? r110 = r109;
        if (r109 == false) goto L8;
        r110 = 1;
    L8:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.hasPermissionDialogFrequency;
        ?? r113 = r112;
        if (r112 == false) goto L11;
        r113 = 1;
    L11:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.installInterceptEnable;
        if (r115 == true) goto L16;
        r101 = r115;
    L16:
        return r114 + r101;
    }

    public final String toString() {
        return "InstallGuideConfig(installGuideEnable=" + this.installGuideEnable + ", jumpInstallPageLabelMilliSeconds=" + this.jumpInstallPageLabelMilliSeconds + ", showInstallGuideDelay=" + this.showInstallGuideDelay + ", bannerIntervalMilliSeconds=" + this.bannerIntervalMilliSeconds + ", isBannerLoop=" + this.isBannerLoop + ", hasPermissionDialogFrequency=" + this.hasPermissionDialogFrequency + ", installInterceptEnable=" + this.installInterceptEnable + ")";
    }

    public final long a() {
        return this.bannerIntervalMilliSeconds;
    }

    public final boolean b() {
        return this.hasPermissionDialogFrequency;
    }

    public final boolean c() {
        return this.installGuideEnable;
    }

    public final boolean d() {
        return this.installInterceptEnable;
    }

    public final long e() {
        return this.jumpInstallPageLabelMilliSeconds;
    }

    public final long f() {
        return this.showInstallGuideDelay;
    }

    public final boolean g() {
        return this.isBannerLoop;
    }

    public j2(int r100) {
        this.installGuideEnable = true;
        this.jumpInstallPageLabelMilliSeconds = 2000;
        this.showInstallGuideDelay = 1000;
        this.bannerIntervalMilliSeconds = 5000;
        this.isBannerLoop = true;
        this.hasPermissionDialogFrequency = true;
        this.installInterceptEnable = true;
    }
}
