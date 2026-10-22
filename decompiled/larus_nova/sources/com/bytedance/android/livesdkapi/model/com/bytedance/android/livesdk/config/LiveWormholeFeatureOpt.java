package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveWormholeFeatureOpt;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "pullTimeEnable", "getPullTimeEnable", "setPullTimeEnable", "pullTimeLimit", "", "getPullTimeLimit", "()I", "setPullTimeLimit", "(I)V", "revSend", "getRevSend", "setRevSend", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWormholeFeatureOpt {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("pull_time_enable")
    private boolean pullTimeEnable;

    @SerializedName("pull_time_Limit")
    private int pullTimeLimit;

    @SerializedName("rev_send")
    private boolean revSend;

    public LiveWormholeFeatureOpt() {
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getPullTimeEnable() {
        return this.pullTimeEnable;
    }

    public final int getPullTimeLimit() {
        return this.pullTimeLimit;
    }

    public final boolean getRevSend() {
        return this.revSend;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setPullTimeEnable(boolean r100) {
        this.pullTimeEnable = r100;
    }

    public final void setPullTimeLimit(int r100) {
        this.pullTimeLimit = r100;
    }

    public final void setRevSend(boolean r100) {
        this.revSend = r100;
    }
}
