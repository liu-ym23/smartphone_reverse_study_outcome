package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/c0;", "", "", "timeoutLimit", "J", "getTimeoutLimit", "()J", "setTimeoutLimit", "(J)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("timeout_limit")
    private long timeoutLimit;

    public c0() {
        this.timeoutLimit = 27000;
    }
}
