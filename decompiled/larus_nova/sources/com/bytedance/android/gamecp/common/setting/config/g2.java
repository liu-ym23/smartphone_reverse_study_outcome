package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/g2;", "", "", "checkInstallLaunchEnable", "Z", "b", "()Z", "", "checkInstallLaunchMills", "J", "c", "()J", "checkInstallLaunchDelayMills", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timeTrackerEnabled", "d", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g2 {

    @SerializedName("check_install_launch_delay_mills")
    private final long checkInstallLaunchDelayMills;

    @SerializedName("check_install_launch_enable")
    private final boolean checkInstallLaunchEnable;

    @SerializedName("check_install_launch_mills")
    private final long checkInstallLaunchMills;

    @SerializedName("time_tracker_enabled")
    private final boolean timeTrackerEnabled;

    public g2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g2) == false) goto L14;
        g2 r101 = (g2) r100;
        if (this.checkInstallLaunchEnable == r101.checkInstallLaunchEnable) goto L8;
        return false;
    L8:
        if (this.checkInstallLaunchMills == r101.checkInstallLaunchMills) goto L10;
        return false;
    L10:
        if (this.checkInstallLaunchDelayMills == r101.checkInstallLaunchDelayMills) goto L12;
        return false;
    L12:
        if (this.timeTrackerEnabled == r101.timeTrackerEnabled) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.checkInstallLaunchEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.checkInstallLaunchMills;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.checkInstallLaunchDelayMills;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.timeTrackerEnabled;
        if (r107 == true) goto L10;
        r101 = r107;
    L10:
        return r106 + r101;
    }

    public final String toString() {
        return "InstallChainConfig(checkInstallLaunchEnable=" + this.checkInstallLaunchEnable + ", checkInstallLaunchMills=" + this.checkInstallLaunchMills + ", checkInstallLaunchDelayMills=" + this.checkInstallLaunchDelayMills + ", timeTrackerEnabled=" + this.timeTrackerEnabled + ")";
    }

    public final long a() {
        return this.checkInstallLaunchDelayMills;
    }

    public final boolean b() {
        return this.checkInstallLaunchEnable;
    }

    public final long c() {
        return this.checkInstallLaunchMills;
    }

    public final boolean d() {
        return this.timeTrackerEnabled;
    }

    public g2(int r100) {
        this.checkInstallLaunchEnable = false;
        this.checkInstallLaunchMills = 1000;
        this.checkInstallLaunchDelayMills = 1000;
        this.timeTrackerEnabled = false;
    }
}
