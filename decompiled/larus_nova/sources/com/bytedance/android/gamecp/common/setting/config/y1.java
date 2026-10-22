package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/y1;", "", "", "enableGetInstallInfo", "Z", "b", "()Z", "Lcom/bytedance/android/gamecp/common/setting/config/z1;", "promoteIconLimitConfig", "Lcom/bytedance/android/gamecp/common/setting/config/z1;", "d", "()Lcom/bytedance/android/gamecp/common/setting/config/z1;", "promoteDetailLimitConfig", "c", "cloudGameLimitConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y1 {

    @SerializedName("cloud_game_limit_config")
    private final z1 cloudGameLimitConfig;

    @SerializedName("enable_get_install_info")
    private final boolean enableGetInstallInfo;

    @SerializedName("promote_detail_limit_config")
    private final z1 promoteDetailLimitConfig;

    @SerializedName("promote_icon_limit_config")
    private final z1 promoteIconLimitConfig;

    public y1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y1) == false) goto L14;
        y1 r101 = (y1) r100;
        if (this.enableGetInstallInfo == r101.enableGetInstallInfo) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promoteIconLimitConfig, r101.promoteIconLimitConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promoteDetailLimitConfig, r101.promoteDetailLimitConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cloudGameLimitConfig, r101.cloudGameLimitConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.enableGetInstallInfo;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        z1 r103 = this.promoteIconLimitConfig;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        z1 r107 = this.promoteDetailLimitConfig;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        z1 r110 = this.cloudGameLimitConfig;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GameRelatePkgInfoConfig(enableGetInstallInfo=" + this.enableGetInstallInfo + ", promoteIconLimitConfig=" + this.promoteIconLimitConfig + ", promoteDetailLimitConfig=" + this.promoteDetailLimitConfig + ", cloudGameLimitConfig=" + this.cloudGameLimitConfig + ")";
    }

    public final z1 a() {
        return this.cloudGameLimitConfig;
    }

    public final boolean b() {
        return this.enableGetInstallInfo;
    }

    public final z1 c() {
        return this.promoteDetailLimitConfig;
    }

    public final z1 d() {
        return this.promoteIconLimitConfig;
    }

    public y1(int r100) {
        this.enableGetInstallInfo = false;
        this.promoteIconLimitConfig = null;
        this.promoteDetailLimitConfig = null;
        this.cloudGameLimitConfig = null;
    }
}
