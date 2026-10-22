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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015R\u001a\u0010)\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015R\u001a\u0010,\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 R\u001a\u00102\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u001e\u001a\u0004\b3\u0010 R\u001a\u00104\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010 R\u001a\u00106\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010 R\u001a\u00108\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 ¨\u0006:"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/n0;", "", "", "Lcom/bytedance/android/gamecp/common/setting/config/o0;", "supCustomInstallBlackList", "Ljava/util/List;", "l", "()Ljava/util/List;", "supCallbackBlackList", ce.f26395j, "", "supAllDeviceBlackList", RXScreenCaptureService.KEY_INDEX, "supInstallPrepareInBgBlackList", "m", "supCallbackWhiteList", ce.f26396k, "", "delayCheckInstallMills", "J", "e", "()J", "delayCheckInstallInternalMills", "d", "userConfirmDelayMills", "o", "userConfirmCheckFastCancelDelayMills", OfficeSDKRequestTag.KEY_NEW_USER, "", "forbidInstallInSameTime", "Z", "f", "()Z", "defaultInstallingStateDelayMills", "c", "oppoInstallingStateDelayMills", "h", "customInstallGuideIsLooper", "getCustomInstallGuideIsLooper", "customInstallGuideLooperInterval", "b", "customInstallTextGuideLooperInterval", "getCustomInstallTextGuideLooperInterval", "", "maxSessionNum", "I", ce.f26391f, "()I", "clearSessionInSubThread", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "isResumeInstallWithPermission", "r", "isBgSessionCommitEnable", "p", "isUserCancelCheckOpt", "s", "isClearCurSession", "q", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("clear_session_in_sub_thread")
    private final boolean clearSessionInSubThread;

    @SerializedName("custom_install_guide_is_looper")
    private final boolean customInstallGuideIsLooper;

    @SerializedName("custom_install_guide_looper_interval")
    private final long customInstallGuideLooperInterval;

    @SerializedName("custom_install_text_guide_looper_interval")
    private final long customInstallTextGuideLooperInterval;

    @SerializedName("default_installing_state_delay_mills")
    private final long defaultInstallingStateDelayMills;

    @SerializedName("delay_check_install_internal_mills")
    private final long delayCheckInstallInternalMills;

    @SerializedName("delay_check_install_mills")
    private final long delayCheckInstallMills;

    @SerializedName("forbid_install_in_same_time")
    private final boolean forbidInstallInSameTime;

    @SerializedName("is_bg_session_commit_enable")
    private final boolean isBgSessionCommitEnable;

    @SerializedName("is_clear_cur_session")
    private final boolean isClearCurSession;

    @SerializedName("is_resume_install_with_permission")
    private final boolean isResumeInstallWithPermission;

    @SerializedName("is_user_cancel_check_opt")
    private final boolean isUserCancelCheckOpt;

    @SerializedName("max_session_num")
    private final int maxSessionNum;

    @SerializedName("oppo_installing_state_delay_mills")
    private final long oppoInstallingStateDelayMills;

    @SerializedName("sup_all_device_black_list")
    private final List<o0> supAllDeviceBlackList;

    @SerializedName("sup_callback_black_list")
    private final List<o0> supCallbackBlackList;

    @SerializedName("sup_callback_white_list")
    private final List<o0> supCallbackWhiteList;

    @SerializedName("sup_custom_install_black_list")
    private final List<o0> supCustomInstallBlackList;

    @SerializedName("sup_install_prepare_in_bg_black_list")
    private final List<o0> supInstallPrepareInBgBlackList;

    @SerializedName("user_confirm_check_fast_cancel_delay_mills")
    private final long userConfirmCheckFastCancelDelayMills;

    @SerializedName("user_confirm_delay_mills")
    private final long userConfirmDelayMills;

    public n0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L48;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.supCustomInstallBlackList, r101.supCustomInstallBlackList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supCallbackBlackList, r101.supCallbackBlackList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supAllDeviceBlackList, r101.supAllDeviceBlackList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.supInstallPrepareInBgBlackList, r101.supInstallPrepareInBgBlackList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.supCallbackWhiteList, r101.supCallbackWhiteList) == true) goto L16;
        return false;
    L16:
        if (this.delayCheckInstallMills == r101.delayCheckInstallMills) goto L18;
        return false;
    L18:
        if (this.delayCheckInstallInternalMills == r101.delayCheckInstallInternalMills) goto L20;
        return false;
    L20:
        if (this.userConfirmDelayMills == r101.userConfirmDelayMills) goto L22;
        return false;
    L22:
        if (this.userConfirmCheckFastCancelDelayMills == r101.userConfirmCheckFastCancelDelayMills) goto L24;
        return false;
    L24:
        if (this.forbidInstallInSameTime == r101.forbidInstallInSameTime) goto L26;
        return false;
    L26:
        if (this.defaultInstallingStateDelayMills == r101.defaultInstallingStateDelayMills) goto L28;
        return false;
    L28:
        if (this.oppoInstallingStateDelayMills == r101.oppoInstallingStateDelayMills) goto L30;
        return false;
    L30:
        if (this.customInstallGuideIsLooper == r101.customInstallGuideIsLooper) goto L32;
        return false;
    L32:
        if (this.customInstallGuideLooperInterval == r101.customInstallGuideLooperInterval) goto L34;
        return false;
    L34:
        if (this.customInstallTextGuideLooperInterval == r101.customInstallTextGuideLooperInterval) goto L36;
        return false;
    L36:
        if (this.maxSessionNum == r101.maxSessionNum) goto L38;
        return false;
    L38:
        if (this.clearSessionInSubThread == r101.clearSessionInSubThread) goto L40;
        return false;
    L40:
        if (this.isResumeInstallWithPermission == r101.isResumeInstallWithPermission) goto L42;
        return false;
    L42:
        if (this.isBgSessionCommitEnable == r101.isBgSessionCommitEnable) goto L44;
        return false;
    L44:
        if (this.isUserCancelCheckOpt == r101.isUserCancelCheckOpt) goto L46;
        return false;
    L46:
        if (this.isClearCurSession == r101.isClearCurSession) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        List<o0> r100 = this.supCustomInstallBlackList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<o0> r104 = this.supCallbackBlackList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<o0> r107 = this.supAllDeviceBlackList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<o0> r110 = this.supInstallPrepareInBgBlackList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<o0> r113 = this.supCallbackWhiteList;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        long r115 = this.delayCheckInstallMills;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.delayCheckInstallInternalMills;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.userConfirmDelayMills;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.userConfirmCheckFastCancelDelayMills;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        boolean r123 = this.forbidInstallInSameTime;
        ?? r124 = 1;
        ?? r125 = r123;
        if (r123 == false) goto L24;
        r125 = 1;
    L24:
        long r126 = this.defaultInstallingStateDelayMills;
        int r127 = (((r122 + r125) * 31) + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = this.oppoInstallingStateDelayMills;
        int r129 = (r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31;
        boolean r130 = this.customInstallGuideIsLooper;
        ?? r131 = r130;
        if (r130 == false) goto L27;
        r131 = 1;
    L27:
        long r132 = this.customInstallGuideLooperInterval;
        int r133 = (((r129 + r131) * 31) + ((int) (r132 ^ (r132 >>> 32)))) * 31;
        long r134 = this.customInstallTextGuideLooperInterval;
        int r135 = (((r133 + ((int) (r134 ^ (r134 >>> 32)))) * 31) + this.maxSessionNum) * 31;
        boolean r136 = this.clearSessionInSubThread;
        ?? r137 = r136;
        if (r136 == false) goto L30;
        r137 = 1;
    L30:
        int r138 = (r135 + r137) * 31;
        boolean r139 = this.isResumeInstallWithPermission;
        ?? r140 = r139;
        if (r139 == false) goto L33;
        r140 = 1;
    L33:
        int r141 = (r138 + r140) * 31;
        boolean r142 = this.isBgSessionCommitEnable;
        ?? r143 = r142;
        if (r142 == false) goto L36;
        r143 = 1;
    L36:
        int r144 = (r141 + r143) * 31;
        boolean r145 = this.isUserCancelCheckOpt;
        ?? r146 = r145;
        if (r145 == false) goto L39;
        r146 = 1;
    L39:
        int r147 = (r144 + r146) * 31;
        boolean r148 = this.isClearCurSession;
        if (r148 == true) goto L44;
        r124 = r148;
    L44:
        return r147 + r124;
    L17:
        r111 = 0;
        goto L18
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
        return "CustomInstallConfig(supCustomInstallBlackList=" + this.supCustomInstallBlackList + ", supCallbackBlackList=" + this.supCallbackBlackList + ", supAllDeviceBlackList=" + this.supAllDeviceBlackList + ", supInstallPrepareInBgBlackList=" + this.supInstallPrepareInBgBlackList + ", supCallbackWhiteList=" + this.supCallbackWhiteList + ", delayCheckInstallMills=" + this.delayCheckInstallMills + ", delayCheckInstallInternalMills=" + this.delayCheckInstallInternalMills + ", userConfirmDelayMills=" + this.userConfirmDelayMills + ", userConfirmCheckFastCancelDelayMills=" + this.userConfirmCheckFastCancelDelayMills + ", forbidInstallInSameTime=" + this.forbidInstallInSameTime + ", defaultInstallingStateDelayMills=" + this.defaultInstallingStateDelayMills + ", oppoInstallingStateDelayMills=" + this.oppoInstallingStateDelayMills + ", customInstallGuideIsLooper=" + this.customInstallGuideIsLooper + ", customInstallGuideLooperInterval=" + this.customInstallGuideLooperInterval + ", customInstallTextGuideLooperInterval=" + this.customInstallTextGuideLooperInterval + ", maxSessionNum=" + this.maxSessionNum + ", clearSessionInSubThread=" + this.clearSessionInSubThread + ", isResumeInstallWithPermission=" + this.isResumeInstallWithPermission + ", isBgSessionCommitEnable=" + this.isBgSessionCommitEnable + ", isUserCancelCheckOpt=" + this.isUserCancelCheckOpt + ", isClearCurSession=" + this.isClearCurSession + ")";
    }

    public final boolean a() {
        return this.clearSessionInSubThread;
    }

    public final long b() {
        return this.customInstallGuideLooperInterval;
    }

    public final long c() {
        return this.defaultInstallingStateDelayMills;
    }

    public final long d() {
        return this.delayCheckInstallInternalMills;
    }

    public final long e() {
        return this.delayCheckInstallMills;
    }

    public final boolean f() {
        return this.forbidInstallInSameTime;
    }

    public final int g() {
        return this.maxSessionNum;
    }

    public final long h() {
        return this.oppoInstallingStateDelayMills;
    }

    public final List<o0> i() {
        return this.supAllDeviceBlackList;
    }

    public final List<o0> j() {
        return this.supCallbackBlackList;
    }

    public final List<o0> k() {
        return this.supCallbackWhiteList;
    }

    public final List<o0> l() {
        return this.supCustomInstallBlackList;
    }

    public final List<o0> m() {
        return this.supInstallPrepareInBgBlackList;
    }

    public final long n() {
        return this.userConfirmCheckFastCancelDelayMills;
    }

    public final long o() {
        return this.userConfirmDelayMills;
    }

    public final boolean p() {
        return this.isBgSessionCommitEnable;
    }

    public final boolean q() {
        return this.isClearCurSession;
    }

    public final boolean r() {
        return this.isResumeInstallWithPermission;
    }

    public final boolean s() {
        return this.isUserCancelCheckOpt;
    }

    public n0(Object r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        this.supCustomInstallBlackList = r101;
        this.supCallbackBlackList = r102;
        this.supAllDeviceBlackList = r103;
        this.supInstallPrepareInBgBlackList = r104;
        this.supCallbackWhiteList = r105;
        this.delayCheckInstallMills = 10000;
        this.delayCheckInstallInternalMills = 1000;
        this.userConfirmDelayMills = 1000;
        this.userConfirmCheckFastCancelDelayMills = 500;
        this.forbidInstallInSameTime = true;
        this.defaultInstallingStateDelayMills = 1000;
        this.oppoInstallingStateDelayMills = 3000;
        this.customInstallGuideIsLooper = true;
        this.customInstallGuideLooperInterval = 5000;
        this.customInstallTextGuideLooperInterval = 3000;
        this.maxSessionNum = 30;
        this.clearSessionInSubThread = true;
        this.isResumeInstallWithPermission = true;
        this.isBgSessionCommitEnable = true;
        this.isUserCancelCheckOpt = true;
        this.isClearCurSession = true;
    }
}
