package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/k0;", "", "", "checkStartTimeout", "Z", "getCheckStartTimeout", "()Z", "setCheckStartTimeout", "(Z)V", "", "startAllowTime", "J", "getStartAllowTime", "()J", "setStartAllowTime", "(J)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName("check_start_timeout")
    private boolean checkStartTimeout;

    @SerializedName("start_allow_time")
    private long startAllowTime;

    public k0() {
        this.checkStartTimeout = true;
        this.startAllowTime = 4000;
    }
}
