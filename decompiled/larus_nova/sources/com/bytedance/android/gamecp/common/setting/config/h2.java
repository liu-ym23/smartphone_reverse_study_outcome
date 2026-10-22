package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h2;", "", "", "enterRoomCheckInstallEnable", "Z", "b", "()Z", "installFailPushEnable", "getInstallFailPushEnable", "", "installFailTipsStrategyTime", "I", "d", "()I", "", "enterRoomDelayMilliSeconds", "J", "c", "()J", "checkInstallCancelEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pushDelayMilliSeconds", "e", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h2 {

    @SerializedName("check_install_cancel_enable")
    private final boolean checkInstallCancelEnable;

    @SerializedName("enter_room_check_install_enable")
    private final boolean enterRoomCheckInstallEnable;

    @SerializedName("enter_room_delay_milliseconds")
    private final long enterRoomDelayMilliSeconds;

    @SerializedName("check_install_fail_push_enable")
    private final boolean installFailPushEnable;

    @SerializedName("install_fail_tips_strategy_time")
    private final int installFailTipsStrategyTime;

    @SerializedName("push_delay_milliseconds")
    private final long pushDelayMilliSeconds;

    public h2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h2) == false) goto L18;
        h2 r101 = (h2) r100;
        if (this.enterRoomCheckInstallEnable == r101.enterRoomCheckInstallEnable) goto L8;
        return false;
    L8:
        if (this.installFailPushEnable == r101.installFailPushEnable) goto L10;
        return false;
    L10:
        if (this.installFailTipsStrategyTime == r101.installFailTipsStrategyTime) goto L12;
        return false;
    L12:
        if (this.enterRoomDelayMilliSeconds == r101.enterRoomDelayMilliSeconds) goto L14;
        return false;
    L14:
        if (this.checkInstallCancelEnable == r101.checkInstallCancelEnable) goto L16;
        return false;
    L16:
        if (this.pushDelayMilliSeconds == r101.pushDelayMilliSeconds) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean r100 = this.enterRoomCheckInstallEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.installFailPushEnable;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((r103 + r105) * 31) + this.installFailTipsStrategyTime) * 31;
        long r107 = this.enterRoomDelayMilliSeconds;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.checkInstallCancelEnable;
        if (r109 == true) goto L12;
        r101 = r109;
    L12:
        int r110 = (r108 + r101) * 31;
        long r111 = this.pushDelayMilliSeconds;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    }

    public final String toString() {
        return "InstallFailTipsConfig(enterRoomCheckInstallEnable=" + this.enterRoomCheckInstallEnable + ", installFailPushEnable=" + this.installFailPushEnable + ", installFailTipsStrategyTime=" + this.installFailTipsStrategyTime + ", enterRoomDelayMilliSeconds=" + this.enterRoomDelayMilliSeconds + ", checkInstallCancelEnable=" + this.checkInstallCancelEnable + ", pushDelayMilliSeconds=" + this.pushDelayMilliSeconds + ")";
    }

    public final boolean a() {
        return this.checkInstallCancelEnable;
    }

    public final boolean b() {
        return this.enterRoomCheckInstallEnable;
    }

    public final long c() {
        return this.enterRoomDelayMilliSeconds;
    }

    public final int d() {
        return this.installFailTipsStrategyTime;
    }

    public final long e() {
        return this.pushDelayMilliSeconds;
    }

    public h2(int r100) {
        this.enterRoomCheckInstallEnable = false;
        this.installFailPushEnable = true;
        this.installFailTipsStrategyTime = 15;
        this.enterRoomDelayMilliSeconds = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.checkInstallCancelEnable = false;
        this.pushDelayMilliSeconds = 5000;
    }
}
