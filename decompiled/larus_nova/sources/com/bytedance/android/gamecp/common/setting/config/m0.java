package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/m0;", "", "", "enableNotReadyProcess", "Z", "getEnableNotReadyProcess", "()Z", "setEnableNotReadyProcess", "(Z)V", "", "pollingInterval", "J", "getPollingInterval", "()J", "setPollingInterval", "(J)V", "", "pollingLimit", "I", "getPollingLimit", "()I", "setPollingLimit", "(I)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("enable_not_ready_process")
    private boolean enableNotReadyProcess;

    @SerializedName("polling_interval")
    private long pollingInterval;

    @SerializedName("polling_limit")
    private int pollingLimit;

    public m0() {
        this.enableNotReadyProcess = true;
        this.pollingInterval = 15000;
        this.pollingLimit = 60;
    }
}
