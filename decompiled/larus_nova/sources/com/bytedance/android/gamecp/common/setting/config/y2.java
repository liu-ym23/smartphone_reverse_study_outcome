package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/y2;", "", "", "isUseInstallCache", "Z", "b", "()Z", "", "installCacheValidMills", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y2 {

    @SerializedName("install_cache_valid_mills")
    private final long installCacheValidMills;

    @SerializedName("is_use_install_cache")
    private final boolean isUseInstallCache;

    public y2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y2) == false) goto L10;
        y2 r101 = (y2) r100;
        if (this.isUseInstallCache == r101.isUseInstallCache) goto L8;
        return false;
    L8:
        if (this.installCacheValidMills == r101.installCacheValidMills) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.isUseInstallCache;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.installCacheValidMills;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "OmniCooperationConfig(isUseInstallCache=" + this.isUseInstallCache + ", installCacheValidMills=" + this.installCacheValidMills + ")";
    }

    public final long a() {
        return this.installCacheValidMills;
    }

    public final boolean b() {
        return this.isUseInstallCache;
    }

    public y2(int r100) {
        this.isUseInstallCache = true;
        this.installCacheValidMills = 10000;
    }
}
