package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/s0;", "", "", "downloadPauseABTest", "I", "b", "()I", "gameDetailABTest", "getGameDetailABTest", "introduceCardABTest", "d", "", "dialogSwitch", "Z", "getDialogSwitch", "()Z", "", "strongTipsSpeed", FaceService.girlLabel, ce.f26391f, "()F", "", "strongTipsTime", "J", "h", "()J", "pauseDialogNoLimit", "f", "afterClickCheckDelay", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getTextByPkgSize", "c", "lastClickInterval", "e", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("after_click_check_pause_delay_time")
    private final long afterClickCheckDelay;

    @SerializedName("dialog_switch")
    private final boolean dialogSwitch;

    @SerializedName("download_pause_abtest")
    private final int downloadPauseABTest;

    @SerializedName("download_pause_game_detail_abtest")
    private final int gameDetailABTest;

    @SerializedName("get_pause_text_by_pkg_size")
    private final boolean getTextByPkgSize;

    @SerializedName("download_pause_introduce_card_abtest")
    private final int introduceCardABTest;

    @SerializedName("last_click_interval_time")
    private final long lastClickInterval;

    @SerializedName("debug_pause_dialog_no_limit")
    private final boolean pauseDialogNoLimit;

    @SerializedName("strong_tips_speed")
    private final float strongTipsSpeed;

    @SerializedName("strong_tips_time")
    private final long strongTipsTime;

    public s0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L26;
        s0 r101 = (s0) r100;
        if (this.downloadPauseABTest == r101.downloadPauseABTest) goto L8;
        return false;
    L8:
        if (this.gameDetailABTest == r101.gameDetailABTest) goto L10;
        return false;
    L10:
        if (this.introduceCardABTest == r101.introduceCardABTest) goto L12;
        return false;
    L12:
        if (this.dialogSwitch == r101.dialogSwitch) goto L14;
        return false;
    L14:
        if (Float.compare(this.strongTipsSpeed, r101.strongTipsSpeed) == 0) goto L16;
        return false;
    L16:
        if (this.strongTipsTime == r101.strongTipsTime) goto L18;
        return false;
    L18:
        if (this.pauseDialogNoLimit == r101.pauseDialogNoLimit) goto L20;
        return false;
    L20:
        if (this.afterClickCheckDelay == r101.afterClickCheckDelay) goto L22;
        return false;
    L22:
        if (this.getTextByPkgSize == r101.getTextByPkgSize) goto L24;
        return false;
    L24:
        if (this.lastClickInterval == r101.lastClickInterval) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final int hashCode() {
        int r100 = ((((this.downloadPauseABTest * 31) + this.gameDetailABTest) * 31) + this.introduceCardABTest) * 31;
        boolean r101 = this.dialogSwitch;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (((r100 + r103) * 31) + Float.floatToIntBits(this.strongTipsSpeed)) * 31;
        long r105 = this.strongTipsTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.pauseDialogNoLimit;
        ?? r108 = r107;
        if (r107 == false) goto L8;
        r108 = 1;
    L8:
        int r109 = (r106 + r108) * 31;
        long r110 = this.afterClickCheckDelay;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        boolean r112 = this.getTextByPkgSize;
        if (r112 == true) goto L12;
        r102 = r112;
    L12:
        int r113 = (r111 + r102) * 31;
        long r114 = this.lastClickInterval;
        return r113 + ((int) (r114 ^ (r114 >>> 32)));
    }

    public final String toString() {
        return "DownloadPauseConfig(downloadPauseABTest=" + this.downloadPauseABTest + ", gameDetailABTest=" + this.gameDetailABTest + ", introduceCardABTest=" + this.introduceCardABTest + ", dialogSwitch=" + this.dialogSwitch + ", strongTipsSpeed=" + this.strongTipsSpeed + ", strongTipsTime=" + this.strongTipsTime + ", pauseDialogNoLimit=" + this.pauseDialogNoLimit + ", afterClickCheckDelay=" + this.afterClickCheckDelay + ", getTextByPkgSize=" + this.getTextByPkgSize + ", lastClickInterval=" + this.lastClickInterval + ")";
    }

    public final long a() {
        return this.afterClickCheckDelay;
    }

    public final int b() {
        return this.downloadPauseABTest;
    }

    public final boolean c() {
        return this.getTextByPkgSize;
    }

    public final int d() {
        return this.introduceCardABTest;
    }

    public final long e() {
        return this.lastClickInterval;
    }

    public final boolean f() {
        return this.pauseDialogNoLimit;
    }

    public final float g() {
        return this.strongTipsSpeed;
    }

    public final long h() {
        return this.strongTipsTime;
    }

    public s0(int r100) {
        this.downloadPauseABTest = 0;
        this.gameDetailABTest = 0;
        this.introduceCardABTest = 0;
        this.dialogSwitch = true;
        this.strongTipsSpeed = 8.5f;
        this.strongTipsTime = 10000;
        this.pauseDialogNoLimit = false;
        this.afterClickCheckDelay = 500;
        this.getTextByPkgSize = false;
        this.lastClickInterval = 1500;
    }
}
