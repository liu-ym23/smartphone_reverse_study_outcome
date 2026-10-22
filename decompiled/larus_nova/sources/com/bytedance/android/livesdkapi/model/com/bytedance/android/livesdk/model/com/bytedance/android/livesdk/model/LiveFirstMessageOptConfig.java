package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.com.bytedance.android.livesdk.model;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/com/bytedance/android/livesdk/model/LiveFirstMessageOptConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableVSSimplifyFirstMessage", "getEnableVSSimplifyFirstMessage", "setEnableVSSimplifyFirstMessage", "forceUseV3", "getForceUseV3", "setForceUseV3", "logEnable", "getLogEnable", "setLogEnable", "threshold", "", "getThreshold", "()J", "setThreshold", "(J)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFirstMessageOptConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("vs_simplify_first_msg")
    private boolean enableVSSimplifyFirstMessage;

    @SerializedName("force_use_v3")
    private boolean forceUseV3;

    @SerializedName("log_enable")
    private boolean logEnable;

    @SerializedName("overtime_threshold")
    private long threshold;

    public LiveFirstMessageOptConfig() {
        this.threshold = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.forceUseV3 = true;
        this.enableVSSimplifyFirstMessage = true;
        this.logEnable = v.a();
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableVSSimplifyFirstMessage() {
        return this.enableVSSimplifyFirstMessage;
    }

    public final boolean getForceUseV3() {
        return this.forceUseV3;
    }

    public final boolean getLogEnable() {
        return this.logEnable;
    }

    public final long getThreshold() {
        return this.threshold;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableVSSimplifyFirstMessage(boolean r100) {
        this.enableVSSimplifyFirstMessage = r100;
    }

    public final void setForceUseV3(boolean r100) {
        this.forceUseV3 = r100;
    }

    public final void setLogEnable(boolean r100) {
        this.logEnable = r100;
    }

    public final void setThreshold(long r100) {
        this.threshold = r100;
    }
}
