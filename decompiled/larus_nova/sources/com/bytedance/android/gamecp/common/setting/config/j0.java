package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/j0;", "", "", "minValidLaunchDuration", "Ljava/lang/Integer;", "getMinValidLaunchDuration", "()Ljava/lang/Integer;", "setMinValidLaunchDuration", "(Ljava/lang/Integer;)V", "recentUseCheckType", "getRecentUseCheckType", "setRecentUseCheckType", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("min_valid_launch_duration")
    private Integer minValidLaunchDuration;

    @SerializedName("recent_use_check_type")
    private Integer recentUseCheckType;

    public j0() {
        this.minValidLaunchDuration = -1;
        this.recentUseCheckType = 0;
    }
}
